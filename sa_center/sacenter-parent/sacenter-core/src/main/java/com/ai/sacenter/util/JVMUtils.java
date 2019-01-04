package com.ai.sacenter.util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import com.ai.appframe2.complex.util.RuntimeServerUtil;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年6月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class JVMUtils {
	private static String JVM_UUID = null;
	static{
		JVM_UUID = "JVM_" + UUID.getUUID();
	}
	public JVMUtils() {
		super();
	}
	/**
	 * 获取当前JVM编号
	 * @return
	 */
	public static String getJVMID(){
		return JVM_UUID;
	}
	/**
	 * 获得当权服务集群(包含所在集群主机和集群服务)
	 * 
	 * @return 数组[0集群主机1集群服务名]
	 */
	public static String[] getWEBLOGIC() {
		String fromWEBLOGIC[] = new String[] { "*", "*" };
		try {
			fromWEBLOGIC[0] = RuntimeServerUtil.getServerIP();
			fromWEBLOGIC[1] = RuntimeServerUtil.getServerName();
			if (StringUtils.isBlank(fromWEBLOGIC[0]))
				fromWEBLOGIC[0] = "*";
			if (StringUtils.isBlank(fromWEBLOGIC[1]))
				fromWEBLOGIC[1] = "*";

		} finally {

		}
		return fromWEBLOGIC;
	}
	/**
	 * 获取当前进程信息
	 * @return 格式为线程名_进程编号_机器名
	 */
	public static String getJVMPID(){
		String fromPID = null;
		StringBuilder fromWAS = new StringBuilder();
		try
		{
			RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();  
	        String fromNAME[] = StringUtils.split( runtime.getName(), "@" ); 
	        fromWAS.append( Thread.currentThread().getName() ).append( "_" )
	               .append( fromNAME[0] ).append( "_" )
	               .append( fromNAME[1] );
	        fromPID = fromWAS.toString();
		}
		catch( java.lang.Exception aEXCEPTION ){
			fromPID = "*";
		}
		finally{
			if( fromWAS != null ){ fromWAS = null; }
		}
		return fromPID;
	}
}
