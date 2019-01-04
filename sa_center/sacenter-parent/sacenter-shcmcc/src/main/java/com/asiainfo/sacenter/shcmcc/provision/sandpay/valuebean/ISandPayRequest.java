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
public class ISandPayRequest implements java.io.Serializable{
	private static final long serialVersionUID = 6228196355955286493L;
	/*发起方工单*/
	private Object _objective = null;
	/*网元测请求*/
	private ISandPaySyncReq _order = null;
	public ISandPayRequest( Object objective ){
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
	 * @return 网元测请求
	 */
	public ISandPaySyncReq getORDER() {
		return _order;
	}

	/**
	 * @param order 网元测请求
	 */
	public void setORDER(ISandPaySyncReq order) {
		_order = order;
	}

	public static class ISandPaySyncReq implements java.io.Serializable{
		private static final long serialVersionUID = 5112604721673659118L;
		private java.util.Map xmlhead;
		private String        xmlbody;
		public ISandPaySyncReq() {
			super();
			xmlhead = null;
			xmlbody = null;
		}
		
		/**
		 * @return the xmlhead
		 */
		public java.util.Map getXmlhead() {
			return xmlhead;
		}
		
		/**
		 * @param xmlhead the xmlhead to set
		 */
		public void setXmlhead(java.util.Map xmlhead) {
			this.xmlhead = xmlhead;
		}
		
		/**
		 * @return the xmlbody
		 */
		public String getXmlbody() {
			return xmlbody;
		}
		
		/**
		 * @param xmlbody the xmlbody to set
		 */
		public void setXmlbody(String xmlbody) {
			this.xmlbody = xmlbody;
		}
	}
}
