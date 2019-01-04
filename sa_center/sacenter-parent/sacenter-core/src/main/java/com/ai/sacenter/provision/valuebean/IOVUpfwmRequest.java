package com.ai.sacenter.provision.valuebean;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元测请求集</p>
 * <p>Copyright: Copyright (c) 2015年10月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfwmRequest implements java.io.Serializable{
	private static final long serialVersionUID = -6175942013617234882L;
	/*发起方工单*/
	private Object _objective = null;
	/*服务任务测*/
	private IUpdbpmOfferHome _subflow  = new IUpdbpmOfferHome();
	/*服务网元测*/
	private IUpffmxOfferHome _platform = new IUpffmxOfferHome();
	public IOVUpfwmRequest( Object objective ) {
		super();
		_objective = objective;
	}
	
	/**
	 * @return 发起方工单
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return 服务任务测
	 */
	public IUpdbpmOfferHome getSUBFLOW() {
		return _subflow;
	}
	
	/**
	 * @return 服务网元测
	 */
	public IUpffmxOfferHome getPLATFORM() {
		return _platform;
	}

	public static class IUpdbpmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -2821392238586878744L;
		/*服务任务订购*/
		private java.util.Map _subflow = new java.util.HashMap();
		/*网元测订购属性*/
		private java.util.Map _platform = new java.util.HashMap();
		public IUpdbpmOfferHome(){
			super();
		}
		/**
		 * @return 服务任务订购
		 */
		public java.util.Map getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * @return 网元测订购属性
		 */
		public java.util.Map getPLATFORM() {
			return _platform;
		}
	}
	
	public static class IUpffmxOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 1153534069268288597L;
		/*网元测发起原始报文*/
		private Object _original = null;
		/*网元测人机语言报文*/
		private String _bottom = null;
		public IUpffmxOfferHome(){
			super();
		}
		/**
		 * @return 原始报文
		 */
		public Object getORIGINAL() {
			return _original;
		}
		/**
		 * @param original 原始报文
		 */
		public void setORIGINAL(Object original) {
			_original = original;
		}
		/**
		 * @return 人机报文
		 */
		public String getBOTTOM() {
			return _bottom;
		}
		/**
		 * @param pLWK_DISPING 人机报文
		 */
		public void setBOTTOM(String pLWK_DISPING) {
			_bottom = pLWK_DISPING;
		}
	}
}
