package com.ai.sacenter.common;

import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOrderRsRspHome;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��2��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class MBeanRsRspHome implements java.io.Serializable{
	private static final long serialVersionUID = -6832002714967466190L;
	/*����*/
	private Object _objective;
	/*��ͨ����*/
	private IUpfgsmRsRspHome _subflow = new IUpfgsmRsRspHome();
	public MBeanRsRspHome() {
		super();
	}
	
	public MBeanRsRspHome( Object objective ) {
		super();
		_objective = objective;
	}

	/**
	 * @return ����
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @param objective ����
	 */
	public void setOBJECTIVE(Object objective) {
		_objective = objective;
	}
	/**
	 * @return ��ͨ����
	 */
	public IUpfgsmRsRspHome getSUBFLOW() {
		return _subflow;
	}
	
	/**
	 * ���÷�������
	 */
	public void purgeAsResult(){
		if( _subflow._result != null ){ _subflow._result = null; }
	}
	
	/**
	 * ��ӿ�ͨ��������
	 * @param result ��ͨ������ϸ
	 */
	public void mergeAsGroup( IOVUpfwmResponse result ){
		if( _subflow._result == null ){ _subflow._result = new IOrderRsRspHome(); }
		_subflow._result.mergeAsGroup( result );
	}
	
	/**
	 * ���ò���ӿ�ͨ��������
	 * @param result ��ͨ������ϸ
	 */
	public void purgeAsGroup( IOVUpfwmResponse result ){
		if( _subflow._result == null ){ _subflow._result = new IOrderRsRspHome(); }
		else{ _subflow._result = null; _subflow._result = new IOrderRsRspHome(); }
		_subflow._result.mergeAsResult( result );
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017��2��17��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmRsRspHome implements java.io.Serializable{
		private static final long serialVersionUID = -2786928434463679171L;
		/*��ͨ������ϸ*/
		private IOrderRsRspHome     _result = null;
		/*��������*/
		private java.util.HashMap   _complex = new java.util.HashMap();
		public IUpfgsmRsRspHome(){
			super();
		}
		
		/**
		 * @return ��ͨ������ϸ
		 */
		public IOrderRsRspHome getRESULT() {
			return _result;
		}
		
		/**
		 * @return ��������
		 */
		public java.util.HashMap getCOMPLEX() {
			return _complex;
		}
	}
}
