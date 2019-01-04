package com.asiainfo.sacenter.shcmcc.provision.sandpay.valuebean;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��5��15��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ISandPayResponse implements java.io.Serializable{
	private static final long serialVersionUID = -6781472080956405309L;
	/*����*/
	private Object _objective = null;
	/*�������*/
	private ISandPaySyncRsRsp _result = null;
	public ISandPayResponse( Object objective ) {
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
	 * @return �������
	 */
	public ISandPaySyncRsRsp getResult() {
		return _result;
	}

	/**
	 * @param result �������
	 */
	public void setResult(ISandPaySyncRsRsp result) {
		_result = result;
	}

	

	public static class ISandPaySyncRsRsp implements java.io.Serializable{
		private static final long serialVersionUID = 223598554048316284L;
		private String rspCode      ;
		private String rspDesc      ;
		private String rspResult    ;
		private java.util.HashMap rspBody = new java.util.HashMap();
		public ISandPaySyncRsRsp(){
			super();
		}
		
		/**
		 * @return ��������
		 */
		public String getRspCode() {
			return rspCode;
		}

		/**
		 * @param rspCode ��������
		 */
		public void setRspCode(String rspCode) {
			this.rspCode = rspCode;
		}

		/**
		 * @return ��������
		 */
		public String getRspDesc() {
			return rspDesc;
		}

		/**
		 * @param rspDesc ��������
		 */
		public void setRspDesc(String rspDesc) {
			this.rspDesc = rspDesc;
		}

		/**
		 * @return �������
		 */
		public String getRspResult() {
			return rspResult;
		}

		/**
		 * @param rspResult �������
		 */
		public void setRspResult(String rspResult) {
			this.rspResult = rspResult;
		}
		/**
		 * @return ���Ľ�������
		 */
		public java.util.HashMap getRspBody() {
			return rspBody;
		}
	}
}
