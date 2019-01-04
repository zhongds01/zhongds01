package com.ai.sacenter.module;

import java.lang.reflect.Method;

/**
 * ģ���ʼ���ӿ�
 * <p>Title: openframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009-12-13</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcLifeCycle {
	/**
	 * ģ���ʼ��ת��
	 * @param aIInitJobSKEL
	 * @throws Exception
	 */
	public void initalize(IConfigDefine.IModuleDefine.IModuleIDefine.IInitalizeDefine aInitalize ) throws Exception;
	/**
	 * @author Administrator
	 * �������ӿڶ���
	 */
	public interface IInterceptor {
		/***
		 * 
		 * @param INSTANCE
		 * @param METHOD
		 * @param objectArray
		 * @throws Exception
		 */
		public void beforeInterceptor( Object INSTANCE , 
				Method METHOD , 
				Object objectArray[] ) throws Exception;
		/***
		 * 
		 * @param INSTANCE
		 * @param METHOD
		 * @param objectArray
		 * @throws Exception
		 */
		public void afterInterceptor(Object INSTANCE , 
				Method METHOD , 
				Object objectArray[]) throws Exception;
		/***
		 * 
		 * @param INSTANCE
		 * @param METHOD
		 * @param objectArray
		 * @param aException
		 * 
		 * @throws Exception
		 */
		public void exceptionInterceptor(Object INSTANCE , 
				Method METHOD , 
				Object objectArray[] , 
				Exception aException ) throws Exception;
		/***
		 * 
		 * @param INSTANCE
		 * @param METHOD
		 * @param objectArray
		 * @throws Exception
		 */
	    public void finallInterceptor( Object INSTANCE , 
	    		Method METHOD , 
	    		Object objectArray[] ) throws Exception;
	}
}
