package com.ai.sacenter.common;

import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOrderRsRspHome;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年2月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class MBeanRsRspHome implements java.io.Serializable{
	private static final long serialVersionUID = -6832002714967466190L;
	/*发起方*/
	private Object _objective;
	/*开通反馈*/
	private IUpfgsmRsRspHome _subflow = new IUpfgsmRsRspHome();
	public MBeanRsRspHome() {
		super();
	}
	
	public MBeanRsRspHome( Object objective ) {
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
	 * @param objective 发起方
	 */
	public void setOBJECTIVE(Object objective) {
		_objective = objective;
	}
	/**
	 * @return 开通反馈
	 */
	public IUpfgsmRsRspHome getSUBFLOW() {
		return _subflow;
	}
	
	/**
	 * 重置反馈报文
	 */
	public void purgeAsResult(){
		if( _subflow._result != null ){ _subflow._result = null; }
	}
	
	/**
	 * 添加开通反馈报文
	 * @param result 开通反馈明细
	 */
	public void mergeAsGroup( IOVUpfwmResponse result ){
		if( _subflow._result == null ){ _subflow._result = new IOrderRsRspHome(); }
		_subflow._result.mergeAsGroup( result );
	}
	
	/**
	 * 重置并添加开通反馈报文
	 * @param result 开通反馈明细
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
	 * <p>Copyright: Copyright (c) 2017年2月17日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmRsRspHome implements java.io.Serializable{
		private static final long serialVersionUID = -2786928434463679171L;
		/*开通反馈明细*/
		private IOrderRsRspHome     _result = null;
		/*其它属性*/
		private java.util.HashMap   _complex = new java.util.HashMap();
		public IUpfgsmRsRspHome(){
			super();
		}
		
		/**
		 * @return 开通反馈明细
		 */
		public IOrderRsRspHome getRESULT() {
			return _result;
		}
		
		/**
		 * @return 其它属性
		 */
		public java.util.HashMap getCOMPLEX() {
			return _complex;
		}
	}
}
