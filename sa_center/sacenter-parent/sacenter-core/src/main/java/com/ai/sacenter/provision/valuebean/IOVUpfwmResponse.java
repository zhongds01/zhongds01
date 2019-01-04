package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元测反馈集</p>
 * <p>Copyright: Copyright (c) 2015年10月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfwmResponse implements java.io.Serializable{
	private static final long serialVersionUID = -8322501744490421449L;
	/*发起方工单*/
	private Object  _objective = null;
	/*是否成功*/
	private Boolean _failure = null;
	/*反馈代码*/
	private String  _rspCode;
	/*反馈描述*/
	private String  _rspDesc;
	/*原始发起网元*/
	private String  _rspHome;
	/*原始报文*/
	private Object  _rspResult;
	/*人机报文*/
	private String  _rspBottom;
	/*反馈报文项*/
	private java.util.Map  _rspBody;
	/*网元测应答集*/
	private IUpfwmOfferHome _order = new IUpfwmOfferHome();
	public IOVUpfwmResponse( Object objective ) {
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
	 * @return 是否成功
	 */
	public Boolean getFAILURE() {
		return _failure;
	}
	
	/**
	 * @param fAILURE 是否成功
	 */
	public void setFAILURE(Boolean fAILURE) {
		_failure = fAILURE;
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
	 * @return 反馈网元
	 */
	public String getRspHome() {
		return _rspHome;
	}
	
	/**
	 * @param rspHome 反馈网元
	 */
	public void setRspHome(String rspHome) {
		_rspHome = rspHome;
	}
	
	/**
	 * @return 原始报文
	 */
	public Object getRspResult() {
		return _rspResult;
	}
	
	/**
	 * @param original 原始报文
	 */
	public void setRspResult(Object RspResult) {
		_rspResult = RspResult;
	}
	
	/**
	 * @return 外围人机报文
	 */
	public String getRspBottom() {
		return _rspBottom;
	}
	
	/**
	 * @param rspBottom 外围人机报文
	 */
	public void setRspBottom(String rspBottom) {
		_rspBottom = rspBottom;
	}
	
	/**
	 * @return 反馈报文项
	 */
	public java.util.Map getRspBody() {
		return _rspBody;
	}
	
	/**
	 * @param rspBody 反馈报文项
	 */
	public void setRspBody(java.util.Map rspBody) {
		_rspBody = rspBody;
	}
	
	/**
	 * 是否反馈成功
	 * @return
	 */
	public boolean isSUCCEED(){
		return  _failure == null || ( _failure != null && _failure.equals( Boolean.FALSE ));
	}
	
	/**
	 * 是否反馈失败
	 * @return
	 */
	public boolean isFAILURE(){
		return _failure != null && _failure.equals( Boolean.TRUE );
	}
	
	/**
	 * 是否反馈代码为NULL
	 * @return
	 */
	public boolean isRsRspNull(){
		return StringUtils.isBlank( _rspCode ) ;
	}
	
	/**
	 * 以XML内容方式返回 
	 * @return
	 */
	public String getAsXml(){
		String _xml = null;
		java.util.HashMap fromXML = new java.util.HashMap();
		try
		{
			fromXML.put( IUpdcConst.IUpfwm.PLWK_FAILURE, 
					_failure != null?_failure.toString():
						Boolean.FALSE.toString                 ()   );
			fromXML.put( IUpdcConst.IUpfwm.PLWK_CODING  , _rspCode  );
			fromXML.put( IUpdcConst.IUpfwm.PLWK_ORIGING , _rspHome  );
			fromXML.put( IUpdcConst.IUpfwm.PLWK_DESCRIBE, _rspDesc  );
			_xml = XmlUtils.createNoformatXml( "InterBOSS", fromXML );
		}
		finally{
			if( fromXML != null ){ fromXML.clear(); fromXML = null; }
		}
		return _xml;
	}
	
	/**
	 * @return 其它项
	 */
	public IUpfwmOfferHome getORDER() {
		return _order;
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -2328547117659485257L;
		/*其他信息*/
		private java.util.Map _subflow = new java.util.HashMap();
		public IUpfwmOfferHome(){
			super();
		}
		
		/**
		 * @return 其他信息
		 */
		public java.util.Map getSUBFLOW() {
			return _subflow;
		}
	}
}
