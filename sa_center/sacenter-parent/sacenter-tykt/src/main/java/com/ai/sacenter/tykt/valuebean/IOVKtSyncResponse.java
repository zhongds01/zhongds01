package com.ai.sacenter.tykt.valuebean;

import com.ai.sacenter.tykt.IUpfgkmConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年8月19日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVKtSyncResponse implements java.io.Serializable{
	private static final long serialVersionUID = 1831990207038643849L;
	private int    psStatus     ;
	private String failReason   ;
	private String complete     ;
	private String original     ;
	private IOVKySyncRsRsp rspResult = new IOVKySyncRsRsp();
	public IOVKtSyncResponse() {
		super();
		psStatus = -1;
		failReason = "未知错误";
	}
	
	/**
	 * @return 工单状态 
	 */
	public int getPsStatus() {
		return psStatus;
	}

	/**
	 * @param psStatus 工单状态
	 */
	public void setPsStatus(int psStatus) {
		this.psStatus = psStatus;
	}

	/**
	 * @return 工单结果
	 */
	public String getFailReason() {
		return failReason;
	}

	/**
	 * @param failReason 工单结果
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	/**
	 * @return 反馈时间
	 */
	public String getComplete() {
		return complete;
	}

	/**
	 * @param complete 反馈时间
	 */
	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	/**
	 * @return 原始报文
	 */
	public String getOriginal() {
		return original;
	}

	/**
	 * @param original 原始报文
	 */
	public void setOriginal(String original) {
		this.original = original;
	}
	
	/**
	 * @return 网元反馈明细
	 */
	public IOVKySyncRsRsp getRspResult() {
		return rspResult;
	}

	/**
	 * @param rspResult the rspResult to set
	 */
	public void setRspResult(IOVKySyncRsRsp rspResult) {
		this.rspResult = rspResult;
	}

	/**
	 * 是否网元反馈成功
	 * @return
	 */
	public boolean isSUCCEED(){
		return psStatus >= 1 && psStatus <= 99;
	}

	/**
	 * <item id = "head" length = "182" desc = "报文头描述">
	 *    <item id = "PS_NET_CODE"     length = "20"  desc = "网元编码"/>
     *    <item id = "PS_ID"           length = "16"  desc = "工单流水号"/>
     *    <item id = "ACTION_ID"       length = "10"  desc = "操作类型"/>
     *    <item id = "PS_SERVICE_TYPE" length = "32"  desc = "服务类型"/>
     *    <item id = "BILL_ID"         length = "32"  desc = "手机号码"/>
     *    <item id = "REGION_CODE"     length = "8"   desc = "用户所在区号"/>
     *    <item id = "DONE_CODE"       length = "64"  desc = "统一流水号"/> 
	 * </item>
	 * <item id = "body" desc = "报文体">
	 *    
	 * </item>
	 * @param fromBytes
	 * @throws Exception
	 */
	public void _wrap( byte[] fromBytes ) throws Exception{
		try
		{
			String fromBody = null;
			fromBody = new String( fromBytes, 0, fromBytes.length );
			_wrapByBody( fromBody );
		}
		finally{
		
		}
	}
	/**
	 * 
	 * @param fromBytes
	 * @throws Exception
	 */
	private void _wrapByBody( String fromBody ) throws Exception{
		StringBuilder fromMML = new StringBuilder( fromBody );
		try
		{
			if( StringUtils.endsWith( fromMML.toString(), "$@$" ) == false ){
				fromMML.append( "$@$" );
			}
			original = fromMML.toString();
			String fromPARAM[] = StringUtils.wildcardArray(fromMML.toString(), 
					"$@$");
			complete = TimeUtils.yyyymmddhhmmss( new java.sql.Timestamp( 
					System.currentTimeMillis() ) );
			if( fromPARAM != null && fromPARAM.length >= 5 ){
				psStatus = Integer.parseInt( fromPARAM[0] );
				failReason = fromPARAM[1];
				rspResult.rspCode = fromPARAM[0];
				rspResult.rspDesc = fromPARAM[1];
				rspResult.rspResult = fromPARAM.length > 3 && fromPARAM[3] != null?
						fromPARAM[3].trim():null;
				if( psStatus == IUpfgkmConst.IUpfwm.SUCCEED &&  StringUtils.isBlank( 
						fromPARAM[2] ) == false ){
					failReason = fromPARAM[2];
					_wrapByStatus( fromPARAM[2] );
				}
			}
		}
		finally{
			if( fromMML != null ){ fromMML = null; }
		}
	}
	/**
	 * 
	 * @param fromRsRspBody
	 */
	private void _wrapByStatus( String fromRsRspBody ){
		try
		{
			if( XmlUtils.IXml.isXML( fromRsRspBody ) ){
				org.dom4j.Element fromBody = null;
				fromBody = XmlUtils.parseXml( fromRsRspBody );
				String fromPARAM = fromBody.elementTextTrim( "STATE" );
				if( StringUtils.isBlank( fromPARAM ) == false ){
					psStatus = Integer.parseInt( fromPARAM );
					rspResult.rspCode = fromPARAM;
				}
				fromPARAM = fromBody.elementTextTrim( "FAIL_REASON" );
				if( StringUtils.isBlank( fromPARAM ) == false ){
					failReason = fromPARAM;
					rspResult.rspDesc = fromPARAM;
				}
			}
		}
		catch( java.lang.Exception aEXCEPTION ){
			
		}
		finally{
			
		}
	}
	/**
	 * 5位格式串[第5位开通串]
	 * @param fromBytes
	 * @throws Exception
	 */
	public void _wrapWithPARAM( byte[] fromBytes ) throws Exception{
		StringBuilder fromMML = new StringBuilder( );
		try
		{
			fromMML.append( new String( fromBytes, 0, fromBytes.length ) );
			if( StringUtils.endsWith( fromMML.toString(), "$@$" ) == false ){
				fromMML.append( "$@$" );
			}
			original = fromMML.toString();
			String fromPARAM[] = StringUtils.wildcardArray(fromMML.toString(), "$@$");
			complete = TimeUtils.yyyymmddhhmmss( new java.sql.Timestamp( System.currentTimeMillis() ) );
			if( fromPARAM != null && fromPARAM.length >= 5 ){
				psStatus = Integer.parseInt( fromPARAM[0] );
				failReason = fromPARAM[1];
				rspResult.rspCode = fromPARAM[0];
				rspResult.rspDesc = fromPARAM[1];
				if( psStatus == IUpfgkmConst.IUpfwm.SUCCEED &&  StringUtils.isBlank( 
						fromPARAM[2] ) == false ){
					rspResult.rspResult = fromPARAM.length >= 4 && fromPARAM[3] != null?fromPARAM[3].trim():null;
					_wrapByStatus( fromPARAM[2] );
				}
			}
		}
		finally{
			
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String fromXML = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		try
		{
			fromPARAM.put("PS_STATUS"      , String.valueOf( psStatus ) );
			fromPARAM.put("FAIL_REASON"    , failReason                 );
			fromPARAM.put("ORIGINAL"       , original                   );
			fromPARAM.put("COMPLETE"       , complete                   );
			fromPARAM.put("RESULT"           , new java.util.HashMap()    );
			((java.util.Map)fromPARAM.get("RESULT")).put("RETN"    , rspResult.rspCode  );
			((java.util.Map)fromPARAM.get("RESULT")).put("DESCRIBE", rspResult.rspDesc  );
			((java.util.Map)fromPARAM.get("RESULT")).put("RESULT"  , rspResult.rspResult);
			fromXML = XmlUtils.createGeneralXml( "InterBOSS", 
					fromPARAM );
		}
		catch( java.lang.Exception aEXCEPTION ){
			
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromXML;
	}
	public static class IOVKySyncRsRsp implements java.io.Serializable{
		private static final long serialVersionUID = 223598554048316284L;
		private String rspCode      ;
		private String rspDesc      ;
		private String rspResult    ;
		private java.util.HashMap rspBody = new java.util.HashMap();
		public IOVKySyncRsRsp(){
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
