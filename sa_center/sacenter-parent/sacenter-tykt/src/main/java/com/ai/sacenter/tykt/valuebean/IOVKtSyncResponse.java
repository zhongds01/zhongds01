package com.ai.sacenter.tykt.valuebean;

import com.ai.sacenter.tykt.IUpfgkmConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016��8��19��</p>
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
		failReason = "δ֪����";
	}
	
	/**
	 * @return ����״̬ 
	 */
	public int getPsStatus() {
		return psStatus;
	}

	/**
	 * @param psStatus ����״̬
	 */
	public void setPsStatus(int psStatus) {
		this.psStatus = psStatus;
	}

	/**
	 * @return �������
	 */
	public String getFailReason() {
		return failReason;
	}

	/**
	 * @param failReason �������
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	/**
	 * @return ����ʱ��
	 */
	public String getComplete() {
		return complete;
	}

	/**
	 * @param complete ����ʱ��
	 */
	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	/**
	 * @return ԭʼ����
	 */
	public String getOriginal() {
		return original;
	}

	/**
	 * @param original ԭʼ����
	 */
	public void setOriginal(String original) {
		this.original = original;
	}
	
	/**
	 * @return ��Ԫ������ϸ
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
	 * �Ƿ���Ԫ�����ɹ�
	 * @return
	 */
	public boolean isSUCCEED(){
		return psStatus >= 1 && psStatus <= 99;
	}

	/**
	 * <item id = "head" length = "182" desc = "����ͷ����">
	 *    <item id = "PS_NET_CODE"     length = "20"  desc = "��Ԫ����"/>
     *    <item id = "PS_ID"           length = "16"  desc = "������ˮ��"/>
     *    <item id = "ACTION_ID"       length = "10"  desc = "��������"/>
     *    <item id = "PS_SERVICE_TYPE" length = "32"  desc = "��������"/>
     *    <item id = "BILL_ID"         length = "32"  desc = "�ֻ�����"/>
     *    <item id = "REGION_CODE"     length = "8"   desc = "�û���������"/>
     *    <item id = "DONE_CODE"       length = "64"  desc = "ͳһ��ˮ��"/> 
	 * </item>
	 * <item id = "body" desc = "������">
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
	 * 5λ��ʽ��[��5λ��ͨ��]
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
