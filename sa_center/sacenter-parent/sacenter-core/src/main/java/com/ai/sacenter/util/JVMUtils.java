package com.ai.sacenter.util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import com.ai.appframe2.complex.util.RuntimeServerUtil;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015��6��22��</p>
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
	 * ��ȡ��ǰJVM���
	 * @return
	 */
	public static String getJVMID(){
		return JVM_UUID;
	}
	/**
	 * ��õ�Ȩ����Ⱥ(�������ڼ�Ⱥ�����ͼ�Ⱥ����)
	 * 
	 * @return ����[0��Ⱥ����1��Ⱥ������]
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
	 * ��ȡ��ǰ������Ϣ
	 * @return ��ʽΪ�߳���_���̱��_������
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
