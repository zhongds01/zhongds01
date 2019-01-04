package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.util.ClassUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��2��7��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpffmxOffer implements java.io.Serializable{
	private static final long serialVersionUID = -2637235323190062909L;
	/*���𷽹���*/
	private Object _objective = null;
	/*����������*/
	private java.util.HashMap _subflow = new java.util.HashMap();
	/*��ͨ���Լ�*/
	private IUpffmxOfferHome _mapping = new IUpffmxOfferHome();
	public IOVUpffmxOffer( Object objective ) {
		super();
		_objective = objective;
	}
	
	public IOVUpffmxOffer( Object objective, java.util.Map subflow ) {
		super();
		_objective = objective;
		ClassUtils.IMerge.merge( subflow, _subflow );
	}
	
	/**
	 * @return ���𷽹���
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return ����������
	 */
	public java.util.HashMap getSUBFLOW() {
		return _subflow;
	}
	
	/**
	 * @return ��ͨ���Լ�
	 */
	public IUpffmxOfferHome getMAPPING() {
		return _mapping;
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017��2��7��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmxOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -4939931820099604453L;	
		/*��ͨ�����Լ�*/
		private java.util.HashMap _mapping = new java.util.HashMap();
		/*��ͨ�����Լ�*/
		private java.util.HashMap _composite = new java.util.HashMap(); 
		public IUpffmxOfferHome(){
			super();
		}
		/**
		 * @return ��ͨ�����Լ�
		 */
		public java.util.HashMap getMAPPING() {
			return _mapping;
		}
		/**
		 * @return ��ͨ�����Լ�
		 */
		public java.util.HashMap getCOMPOSITE() {
			return _composite;
		}
	}
}
