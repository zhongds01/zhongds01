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
         *          /Lock   ��ip��
         *          /MOD    ��modֵ��
         *              /0  ��IP��
         *              /1
         *              /2
         *              ������
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
                    //���ڵ��Ƿ����
                    Stat pathStat = curatorFramework.checkExists().forPath(FULLPATH + "/MOD");
                    if(null == pathStat){
                        //�����ڳ����������ڵ�
                        curatorFramework.create().creatingParentsIfNeeded().forPath(FULLPATH + "/MOD", DefaultMod.getBytes());
                    }
                }catch (KeeperException.NodeExistsException e){
                    //д���˾�д��
                }

                addLock();

                //��дMODֵ����ʹ�û��������޸�ʱ�����Զ��޸�
                int MOD = Integer.valueOf(DefaultMod);
                curatorFramework.setData().forPath(FULLPATH + "/MOD", DefaultMod.getBytes());

                int COUNT = curatorFramework.getChildren().forPath(FULLPATH + "/MOD").size();

                if(COUNT >= MOD){
                    //����MODֵ��������
                    System.out.println("�����㹻��Ƭ�������˴ν���������");
                    releaseLock();
                }else{
                    Stat valStat ;
                    for(int tVal = 0; tVal < MOD;tVal++){
                        //ɨ���ĸ���Ƭû����
                        valStat = curatorFramework.checkExists().forPath(FULLPATH + "/MOD/"+tVal);
                        if(valStat == null){
                            //������Ƭ���˴η�ƬֵΪVAL
                            String[] tfArgs = new String[]{TFCODE,String.valueOf(MOD),String.valueOf(tVal)};
                            curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(FULLPATH + "/MOD/" + tVal, (hostname + "|" + new Date()).getBytes());
                            releaseLock();
                            com.asiainfo.appframe.ext.exeframe.tf.TfFrameWork.main(tfArgs);
                            break;
                        }
                    }
                }
            } else {
                System.out.println("��������������[ ת�Ʊ��� ]");
            }
        }catch (Exception e){
            System.out.println("����Others.xml���û�ZKԤ�����ݣ�");
            e.printStackTrace();
        }
    }

    private static void addLock()throws Exception{

        synchronized (Lock){
            //��鲢������TFCODE�����޸�
            Stat lockStat = new Stat();
            while(lockStat != null) {
                lockStat = curatorFramework.checkExists().forPath(FULLPATH + "/Lock");
                if(null == lockStat) {
                    //û����ռ�����Լ���
                    try {
                        //����ʱ��
                        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath(FULLPATH + "/Lock", hostname.getBytes());
                        lockStat = null;
                    } catch (KeeperException.NodeExistsException nodeExistsException) {
                        //����ʧ�ܣ�����ռ�������ȴ�
                        System.out.println("����ʧ�ܣ��ȴ��ͷ�");
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
