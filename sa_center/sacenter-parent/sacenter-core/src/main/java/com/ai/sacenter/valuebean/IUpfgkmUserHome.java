package com.ai.sacenter.valuebean;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务用户号码订购</p>
 * <p>Copyright: Copyright (c) 2015-5-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgkmUserHome implements java.io.Serializable{
	private static final long serialVersionUID = 7685392500434782589L;
	/*发起方工单*/
	private Object  OBJECTIVE = null;
	/*服务订购集*/
	private java.util.Map _offer = new java.util.HashMap();
	/*发起方原始属性*/
	private IUpfgkmPhoneHome _user = new IUpfgkmPhoneHome();
	public IUpfgkmUserHome( Object objective) {
		super();
		OBJECTIVE = objective;
	}
	/**
	 * @return 发起方工单
	 */
	public Object getOBJECTIVE() {
		return OBJECTIVE;
	}
	/**
	 * @param objective 发起方工单
	 */
	public void setOBJECTIVE(Object objective) {
		OBJECTIVE = objective;
	}
	/**
	 * @return 服务订购集
	 */
	public java.util.Map getOFFER() {
		return _offer;
	}
	/**
	 * @return 发起方原始属性
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
		/*用户编号*/
		private long    USER_ID;
		/*用户号码*/
		private String  BILL_ID;
		/*次计费号*/
		private String  SUB_BILL_ID;
		/*用户地市*/
		private String  REGION_CODE;
		/*定单地市*/
		private String  REGION_ID;
		/*其它属性*/
		private java.util.Map PARAM = new java.util.HashMap();
		public IUpfgkmPhoneHome(){
			super();
		}
		/**
		 * @return 用户号码
		 */
		public String getBILL_ID() {
			return BILL_ID;
		}
		/**
		 * @param bill_id 用户号码
		 */
		public void setBILL_ID(String bill_id) {
			BILL_ID = bill_id;
		}
		/**
		 * @return 次计费号
		 */
		public String getSUB_BILL_ID() {
			return SUB_BILL_ID;
		}
		/**
		 * @param sub_bill_id 次计费号
		 */
		public void setSUB_BILL_ID(String sub_bill_id) {
			SUB_BILL_ID = sub_bill_id;
		}
		/**
		 * @return 用户编号
		 */
		public long getUSER_ID() {
			return USER_ID;
		}
		/**
		 * @param user_id 用户编号
		 */
		public void setUSER_ID(long user_id) {
			USER_ID = user_id;
		}
		/**
		 * @return 定单地市
		 */
		public String getREGION_ID() {
			return REGION_ID;
		}
		/**
		 * @param region_id 定单地市
		 */
		public void setREGION_ID(String region_id) {
			REGION_ID = region_id;
		}
		/**
		 * @return 用户地市
		 */
		public String getREGION_CODE() {
			return REGION_CODE;
		}
		/**
		 * @param region_code 用户地市
		 */
		public void setREGION_CODE(String region_code) {
			REGION_CODE = region_code;
		}
		/**
		 * @return 其它属性
		 */
		public java.util.Map getPARAM() {
			return PARAM;
		}
		
	}
}
