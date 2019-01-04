package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.util.RocketUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月8日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFRsRspHome implements java.io.Serializable{
	private static final long serialVersionUID = -8699890460440566945L;
	/*反馈代码*/
	private String  _rspCode  ;
	/*反馈描述*/
	private String  _rspDesc  ;
	/*原始报文*/
	private Object  _rspResult;
	/*反馈明细*/
	private java.util.Map<Object,Object> _rspBody;
	public IOVMsgFRsRspHome() {
		super();
	}
	
	public IOVMsgFRsRspHome( String rspCode, String rspDesc ) {
		super();
		_rspCode = rspCode;
		_rspDesc = rspDesc;
	}
	
	public IOVMsgFRsRspHome( SFException exception ){
		super();
		_rspCode = exception.getFaultCode();
		_rspDesc = exception.getMessage();
	}
	
	public IOVMsgFRsRspHome( org.dom4j.Element element) {
		super();
		_rspCode   = RocketUtils.IMetaX._jj_string  ( element, "RspCode"     , false );
		_rspDesc   = RocketUtils.IMetaX._jj_string  ( element, "RspDesc"     , true  );
		_rspResult = RocketUtils.IMetaX._jj_string  ( element, "RspResult"   , true  );
		_rspBody   = RocketUtils.IMetaX._jj_map     ( element, "RspBody"     , true  );
	}
	
	/**
	 * @return 反馈代码
	 */
	public String getRspCode() {
		return _rspCode;
	}
	
	/**
	 * @param rspCode 反馈代码
	 */
	public void setRspCode(String rspCode) {
		_rspCode = rspCode;
	}
	
	/**
	 * @return 反馈描述
	 */
	public String getRspDesc() {
		return _rspDesc;
	}
	
	/**
	 * @param rspDesc 反馈描述
	 */
	public void setRspDesc(String rspDesc) {
		_rspDesc = rspDesc;
	}
	
	/**
	 * @return 反馈报文
	 */
	public Object getRspResult() {
		return _rspResult;
	}
	
	/**
	 * @param rspResult 反馈报文
	 */
	public void setRspResult(Object rspResult) {
		_rspResult = rspResult;
	}
	
	/**
	 * @return 反馈明细*
	 */
	public java.util.Map<Object,Object> getRspBody() {
		return _rspBody;
	}
	
	/**
	 * @param rspBody 反馈明细*
	 */
	public void setRspBody(java.util.Map<Object,Object> rspBody) {
		_rspBody = rspBody;
	}
	
}
