package com.ai.sacenter.provision.valuebean;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ������</p>
 * <p>Copyright: Copyright (c) 2015��10��26��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfwmRequest implements java.io.Serializable{
	private static final long serialVersionUID = -6175942013617234882L;
	/*���𷽹���*/
	private Object _objective = null;
	/*���������*/
	private IUpdbpmOfferHome _subflow  = new IUpdbpmOfferHome();
	/*������Ԫ��*/
	private IUpffmxOfferHome _platform = new IUpffmxOfferHome();
	public IOVUpfwmRequest( Object objective ) {
		super();
		_objective = objective;
	}
	
	/**
	 * @return ���𷽹���
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return ���������
	 */
	public IUpdbpmOfferHome getSUBFLOW() {
		return _subflow;
	}
	
	/**
	 * @return ������Ԫ��
	 */
	public IUpffmxOfferHome getPLATFORM() {
		return _platform;
	}

	public static class IUpdbpmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -2821392238586878744L;
		/*�������񶩹�*/
		private java.util.Map _subflow = new java.util.HashMap();
		/*��Ԫ�ⶩ������*/
		private java.util.Map _platform = new java.util.HashMap();
		public IUpdbpmOfferHome(){
			super();
		}
		/**
		 * @return �������񶩹�
		 */
		public java.util.Map getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * @return ��Ԫ�ⶩ������
		 */
		public java.util.Map getPLATFORM() {
			return _platform;
		}
	}
	
	public static class IUpffmxOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 1153534069268288597L;
		/*��Ԫ�ⷢ��ԭʼ����*/
		private Object _original = null;
		/*��Ԫ���˻����Ա���*/
		private String _bottom = null;
		public IUpffmxOfferHome(){
			super();
		}
		/**
		 * @return ԭʼ����
		 */
		public Object getORIGINAL() {
			return _original;
		}
		/**
		 * @param original ԭʼ����
		 */
		public void setORIGINAL(Object original) {
			_original = original;
		}
		/**
		 * @return �˻�����
		 */
		public String getBOTTOM() {
			return _bottom;
		}
		/**
		 * @param pLWK_DISPING �˻�����
		 */
		public void setBOTTOM(String pLWK_DISPING) {
			_bottom = pLWK_DISPING;
		}
	}
}
