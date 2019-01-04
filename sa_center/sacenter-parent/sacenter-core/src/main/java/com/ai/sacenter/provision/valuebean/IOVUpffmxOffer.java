package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.util.ClassUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年2月7日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpffmxOffer implements java.io.Serializable{
	private static final long serialVersionUID = -2637235323190062909L;
	/*发起方工单*/
	private Object _objective = null;
	/*服务能力集*/
	private java.util.HashMap _subflow = new java.util.HashMap();
	/*开通属性集*/
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
	 * @return 发起方工单
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return 服务能力集
	 */
	public java.util.HashMap getSUBFLOW() {
		return _subflow;
	}
	
	/**
	 * @return 开通属性集
	 */
	public IUpffmxOfferHome getMAPPING() {
		return _mapping;
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年2月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmxOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -4939931820099604453L;	
		/*开通主属性集*/
		private java.util.HashMap _mapping = new java.util.HashMap();
		/*开通次属性集*/
		private java.util.HashMap _composite = new java.util.HashMap(); 
		public IUpffmxOfferHome(){
			super();
		}
		/**
		 * @return 开通主属性集
		 */
		public java.util.HashMap getMAPPING() {
			return _mapping;
		}
		/**
		 * @return 开通次属性集
		 */
		public java.util.HashMap getCOMPOSITE() {
			return _composite;
		}
	}
}
