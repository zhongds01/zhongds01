package com.asiainfo.sacenter.shcmcc.util;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;

import java.util.Date;
import java.util.Map;

/**
 * Created by Think on 2018/3/9.
 */
public class TfFrameWork extends com.asiainfo.appframe.ext.exeframe.tf.TfFrameWork {
    private static CuratorFramework curatorFramework;
    private static byte[] Lock = new byte[0];
    private static String FULLPATH ;
    private static String TFCODE ;
    private static String DefaultMod = System.getenv("TFMOD");
    private static String hostname = null == System.getenv("OUTSIDEIP") ? "127.0.0.1" : System.getenv("OUTSIDEIP");

    public TfFrameWork(){
        super();
    }

    public static void main(String[] args) throws Exception {
        /**
         *
         * /TF
         *  /open
         *      /{tfCode}
         *          /Lock   （ip）
         *          /MOD    （mod值）
         *              /0  （IP）
         *              /1
         *              /2
         *              。。。
         *
         */


        try {
            if (args.length >= 1 && null != args[0] && !"".equals(args[0].trim())) {
                Map ZKConfig = OthersConfigure.getItem("TFController", "zk");
                Map TFModConfig = OthersConfigure.getItem("TFController", "TFMod");
                TFCODE = args[0];
                FULLPATH = ZKConfig.get("FullPath")+TFCODE;
                DefaultMod = (String) (null == DefaultMod || "".equals(DefaultMod.trim()) ? (null == TFModConfig.get(TFCODE)?TFModConfig.get("default"):TFModConfig.get(TFCODE)) : DefaultMod);


                RetryPolicy retryPolicy = new RetryForever(Integer.valueOf((String) ZKConfig.get("timeout")));
                curatorFramework = CuratorFrameworkFactory.newClient((String) ZKConfig.get("server"), retryPolicy);
                curatorFramework.start();

                try{
                    //父节点是否存在
                    Stat pathStat = curatorFramework.checkExists().forPath(FULLPATH + "/MOD");
                    if(null == pathStat){
                        //不存在尝试新增父节点
                        curatorFramework.create().creatingParentsIfNeeded().forPath(FULLPATH + "/MOD", DefaultMod.getBytes());
                    }
                }catch (KeeperException.NodeExistsException e){
                    //写不了就写了
                }

                addLock();

                //重写MOD值，以使得环境变量修改时即可自动修改
                int MOD = Integer.valueOf(DefaultMod);
                curatorFramework.setData().forPath(FULLPATH + "/MOD", DefaultMod.getBytes());

                int COUNT = curatorFramework.getChildren().forPath(FULLPATH + "/MOD").size();

                if(COUNT >= MOD){
                    //超出MOD值，不启动
                    System.out.println("已有足够分片启动，此次将不再启动");
                    releaseLock();
                }else{
                    Stat valStat ;
                    for(int tVal = 0; tVal < MOD;tVal++){
                        //扫描哪个分片没启动
                        valStat = curatorFramework.checkExists().forPath(FULLPATH + "/MOD/"+tVal);
                        if(valStat == null){
                            //启动分片，此次分片值为VAL
                            String[] tfArgs = new String[]{TFCODE,String.valueOf(MOD),String.valueOf(tVal)};
                            curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(FULLPATH + "/MOD/" + tVal, (hostname + "|" + new Date()).getBytes());
                            releaseLock();
                            com.asiainfo.appframe.ext.exeframe.tf.TfFrameWork.main(tfArgs);
                            break;
                        }
                    }
                }
            } else {
                System.out.println("必须有启动参数[ 转移编码 ]");
            }
        }catch (Exception e){
            System.out.println("请检查Others.xml配置或ZK预置数据！");
            e.printStackTrace();
        }
    }

    private static void addLock()throws Exception{

        synchronized (Lock){
            //检查并加锁此TFCODE数据修改
            Stat lockStat = new Stat();
            while(lockStat != null) {
                lockStat = curatorFramework.checkExists().forPath(FULLPATH + "/Lock");
                if(null == lockStat) {
                    //没有抢占，尝试加锁
                    try {
                        //加临时锁
                        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(FULLPATH + "/Lock", hostname.getBytes());
                        lockStat = null;
                    } catch (KeeperException.NodeExistsException nodeExistsException) {
                        //加锁失败，被抢占，继续等待
                        System.out.println("加锁失败，等待释放");
                        lockStat = new Stat();
                    } catch (Exception e){
                        throw e;
                    }
                }
                Thread.sleep(1000);
            }
        }
    }

    private  static void releaseLock()throws Exception{
        synchronized (Lock) {
            curatorFramework.delete().forPath(FULLPATH + "/Lock");
        }
    }
}
