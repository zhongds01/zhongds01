package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFBsException;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月8日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFResponse implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String CUST_ORDER;
    private String CATALOG   ;
    private String BUSINESS  ;
    private String ORIGINATE ;
    private String CHANNEL   ;
    private long   USER_ID   ;
    private String BILL_ID   ;
    private String REGION_ID ;
    private String DONE_CODE ;
    private java.sql.Timestamp DONE_DATE;
    private String ORG_ID    ;
    private String STAFF_ID  ; 
    private IOVMsgFRsRspHome RESULT = new IOVMsgFRsRspHome();
	public IOVMsgFResponse() {
		super();
	}
	
	/**
	 * @return the cUST_ORDER
	 */
	public String getCUST_ORDER() {
		return CUST_ORDER;
	}
	
	/**
	 * @param cUST_ORDER the cUST_ORDER to set
	 */
	public void setCUST_ORDER(String cUST_ORDER) {
		CUST_ORDER = cUST_ORDER;
	}
	
	/**
	 * @return the cATALOG
	 */
	public String getCATALOG() {
		return CATALOG;
	}
	
	/**
	 * @param cATALOG the cATALOG to set
	 */
	public void setCATALOG(String cATALOG) {
		CATALOG = cATALOG;
	}
	
	/**
	 * @return the bUSINESS
	 */
	public String getBUSINESS() {
		return BUSINESS;
	}
	
	/**
	 * @param bUSINESS the bUSINESS to set
	 */
	public void setBUSINESS(String bUSINESS) {
		BUSINESS = bUSINESS;
	}
	
	/**
	 * @return the oRIGINATE
	 */
	public String getORIGINATE() {
		return ORIGINATE;
	}
	
	/**
	 * @param oRIGINATE the oRIGINATE to set
	 */
	public void setORIGINATE(String oRIGINATE) {
		ORIGINATE = oRIGINATE;
	}
	
	/**
	 * @return the cHANNEL
	 */
	public String getCHANNEL() {
		return CHANNEL;
	}
	
	/**
	 * @param cHANNEL the cHANNEL to set
	 */
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}
	
	/**
	 * @return the uSER_ID
	 */
	public long getUSER_ID() {
		return USER_ID;
	}
	
	/**
	 * @param uSER_ID the uSER_ID to set
	 */
	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	/**
	 * @return the bILL_ID
	 */
	public String getBILL_ID() {
		return BILL_ID;
	}

	/**
	 * @param bILL_ID the bILL_ID to set
	 */
	public void setBILL_ID(String bILL_ID) {
		BILL_ID = bILL_ID;
	}

	/**
	 * @return the rEGION_ID
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}
	
	/**
	 * @param rEGION_ID the rEGION_ID to set
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	
	/**
	 * @return the dONE_CODE
	 */
	public String getDONE_CODE() {
		return DONE_CODE;
	}
	
	/**
	 * @param dONE_CODE the dONE_CODE to set
	 */
	public void setDONE_CODE(String dONE_CODE) {
		DONE_CODE = dONE_CODE;
	}
	
	/**
	 * @return the dONE_DATE
	 */
	public java.sql.Timestamp getDONE_DATE() {
		return DONE_DATE;
	}
	
	/**
	 * @param dONE_DATE the dONE_DATE to set
	 */
	public void setDONE_DATE(java.sql.Timestamp dONE_DATE) {
		DONE_DATE = dONE_DATE;
	}
	
	/**
	 * @return the oRG_ID
	 */
	public String getORG_ID() {
		return ORG_ID;
	}
	
	/**
	 * @param oRG_ID the oRG_ID to set
	 */
	public void setORG_ID(String oRG_ID) {
		ORG_ID = oRG_ID;
	}
	
	/**
	 * @return the sTAFF_ID
	 */
	public String getSTAFF_ID() {
		return STAFF_ID;
	}
	
	/**
	 * @param sTAFF_ID the sTAFF_ID to set
	 */
	public void setSTAFF_ID(String sTAFF_ID) {
		STAFF_ID = sTAFF_ID;
	}
	
	/**
	 * @return rESULT
	 */
	public IOVMsgFRsRspHome getRESULT() {
		return RESULT;
	}

	/**
	 * 
	 * @param _pubinfo
	 * @throws Exception
	 */
	private void pubInfoToXml( org.dom4j.Element _pubinfo ) throws Exception{
		try
		{
			_pubinfo.addElement( "CustomerOrderId" ).setText( CUST_ORDER                            );
			_pubinfo.addElement( "ProdSpec"        ).setText( CATALOG                               );
			_pubinfo.addElement( "BusinessId"      ).setText( BUSINESS                              );
			_pubinfo.addElement( "OriginId"        ).setText( ORIGINATE                             );
			_pubinfo.addElement( "ChannelId"       ).setText( CHANNEL                               );
			_pubinfo.addElement( "UserId"          ).setText( String.valueOf( USER_ID )             );
			_pubinfo.addElement( "BillId"          ).setText( BILL_ID                               );
			_pubinfo.addElement( "RegionId"        ).setText( REGION_ID                             );
			_pubinfo.addElement( "OrgId"           ).setText( ORG_ID                                );
			_pubinfo.addElement( "StaffId"         ).setText( STAFF_ID                              );
			_pubinfo.addElement( "DoneCode"        ).setText( DONE_CODE                             );
			_pubinfo.addElement( "DoneDate"        ).setText( TimeUtils.yyyymmddhhmmss( DONE_DATE ) );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param _busiinfo
	 * @param fromExtend
	 * @throws Exception
	 */
	private void busiInfoToXml( org.dom4j.Element _busiinfo, SFBsException fromExtend ) throws Exception{
		try
		{
			org.dom4j.Document _busidoc = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _bizrsp = _busidoc.addElement( "BizRsp" );
			if( fromExtend != null ){
				_bizrsp.addElement( "RspCode" ).setText( fromExtend.getFaultCode() );
				_bizrsp.addElement( "RspDesc" ).setText( fromExtend.getMessage  () );
			}
			else{
				_bizrsp.addElement( "RspCode" ).setText( RESULT.getRspCode() );
				_bizrsp.addElement( "RspDesc" ).setText( RESULT.getRspDesc() );
			}
			if( RESULT.getRspResult() != null ){
				OrderUtils.IRocket.IIRsRsp._gvp_wrap_complex("RspResult", 
						RESULT.getRspResult(), 
						_bizrsp );
			}
			if( RESULT.getRspBody() != null && RESULT.getRspBody().size() > 0 ){
				OrderUtils.IRocket.IIRsRsp._gvp_wrap_complex("RspBody", 
						RESULT.getRspBody(), 
						_bizrsp);
			}
			_busiinfo.addCDATA( _busidoc.asXML() );
		}
		finally{
			
		}
	}
	
	/**
	 * 开通反馈转换开通外部应答
	 * @return
	 * @throws Exception
	 */
	public String getAsXml() throws Exception{
		String _xml = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "IPSCRocket" );
			pubInfoToXml ( _root.addElement( "PubInfo"  ) );
			SFBsException fromExtend = ExceptionFactory.getExtend( IUpdcConst.IUpdfx.IQuality.SUCCEED, "" );
			if( RESULT != null ){
				fromExtend = ExceptionFactory.getExtend( RESULT.getRspCode(), RESULT.getRspDesc() );
			}
			busiInfoToXml( _root.addElement( "BusiInfo" ), fromExtend );
			_xml = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_xml = super.toString();
		}
		finally{
			
		}
		return _xml;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String _xml = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "IPSCRocket" );
			pubInfoToXml ( _root.addElement( "PubInfo"  ) );
			busiInfoToXml( _root.addElement( "BusiInfo" ), null );
			_xml = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_xml = super.toString();
		}
		finally{
			
		}
		return _xml;
	}
	
}
