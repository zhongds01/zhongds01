package com.asiainfo.sacenter.shcmcc.provision.sandpay.valuebean;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ISandPayResponse implements java.io.Serializable{
	private static final long serialVersionUID = -6781472080956405309L;
	/*发起方*/
	private Object _objective = null;
	/*反馈结果*/
	private ISandPaySyncRsRsp _result = null;
	public ISandPayResponse( Object objective ) {
		super();
		_objective = objective;
	}
	
	/**
	 * @return 发起方
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return 反馈结果
	 */
	public ISandPaySyncRsRsp getResult() {
		return _result;
	}

	/**
	 * @param result 反馈结果
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
		 * @return 反馈代码
		 */
		public String getRspCode() {
			return rspCode;
		}

		/**
		 * @param rspCode 反馈代码
		 */
		public void setRspCode(String rspCode) {
			this.rspCode = rspCode;
		}

		/**
		 * @return 代码描述
		 */
		public String getRspDesc() {
			return rspDesc;
		}

		/**
		 * @param rspDesc 代码描述
		 */
		public void setRspDesc(String rspDesc) {
			this.rspDesc = rspDesc;
		}

		/**
		 * @return 反馈结果
		 */
		public String getRspResult() {
			return rspResult;
		}

		/**
		 * @param rspResult 反馈结果
		 */
		public void setRspResult(String rspResult) {
			this.rspResult = rspResult;
		}
		/**
		 * @return 报文解析分项
		 */
		public java.util.HashMap getRspBody() {
			return rspBody;
		}
	}
}
