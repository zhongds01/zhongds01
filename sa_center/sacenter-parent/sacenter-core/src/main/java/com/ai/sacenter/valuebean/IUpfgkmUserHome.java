package com.ai.sacenter.valuebean;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �����û����붩��</p>
 * <p>Copyright: Copyright (c) 2015-5-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgkmUserHome implements java.io.Serializable{
	private static final long serialVersionUID = 7685392500434782589L;
	/*���𷽹���*/
	private Object  OBJECTIVE = null;
	/*���񶩹���*/
	private java.util.Map _offer = new java.util.HashMap();
	/*����ԭʼ����*/
	private IUpfgkmPhoneHome _user = new IUpfgkmPhoneHome();
	public IUpfgkmUserHome( Object objective) {
		super();
		OBJECTIVE = objective;
	}
	/**
	 * @return ���𷽹���
	 */
	public Object getOBJECTIVE() {
		return OBJECTIVE;
	}
	/**
	 * @param objective ���𷽹���
	 */
	public void setOBJECTIVE(Object objective) {
		OBJECTIVE = objective;
	}
	/**
	 * @return ���񶩹���
	 */
	public java.util.Map getOFFER() {
		return _offer;
	}
	/**
	 * @return ����ԭʼ����
	 */
	public IUpfgkmPhoneHome getUSER() {
		return _user;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-5-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgkmPhoneHome implements java.io.Serializable{
		private static final long serialVersionUID = 2619033863860603199L;
		/*�û����*/
		private long    USER_ID;
		/*�û�����*/
		private String  BILL_ID;
		/*�μƷѺ�*/
		private String  SUB_BILL_ID;
		/*�û�����*/
		private String  REGION_CODE;
		/*��������*/
		private String  REGION_ID;
		/*��������*/
		private java.util.Map PARAM = new java.util.HashMap();
		public IUpfgkmPhoneHome(){
			super();
		}
		/**
		 * @return �û�����
		 */
		public String getBILL_ID() {
			return BILL_ID;
		}
		/**
		 * @param bill_id �û�����
		 */
		public void setBILL_ID(String bill_id) {
			BILL_ID = bill_id;
		}
		/**
		 * @return �μƷѺ�
		 */
		public String getSUB_BILL_ID() {
			return SUB_BILL_ID;
		}
		/**
		 * @param sub_bill_id �μƷѺ�
		 */
		public void setSUB_BILL_ID(String sub_bill_id) {
			SUB_BILL_ID = sub_bill_id;
		}
		/**
		 * @return �û����
		 */
		public long getUSER_ID() {
			return USER_ID;
		}
		/**
		 * @param user_id �û����
		 */
		public void setUSER_ID(long user_id) {
			USER_ID = user_id;
		}
		/**
		 * @return ��������
		 */
		public String getREGION_ID() {
			return REGION_ID;
		}
		/**
		 * @param region_id ��������
		 */
		public void setREGION_ID(String region_id) {
			REGION_ID = region_id;
		}
		/**
		 * @return �û�����
		 */
		public String getREGION_CODE() {
			return REGION_CODE;
		}
		/**
		 * @param region_code �û�����
		 */
		public void setREGION_CODE(String region_code) {
			REGION_CODE = region_code;
		}
		/**
		 * @return ��������
		 */
		public java.util.Map getPARAM() {
			return PARAM;
		}
		
	}
}
