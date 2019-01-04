package com.ai.sacenter.receive.order.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.receive.order.bo.IISAUrgencyX;
import com.ai.sacenter.receive.order.bo.ISAUrgencyX;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 服务定单产品</p>
 * <p>Copyright: Copyright (c) 2016年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUrgencyOffer implements java.io.Serializable{
	private static final long serialVersionUID = -8767005366838181500L;
	private long   OFFER_ID     ;
	private long   ORDER_ID     ;
	private long   USER_ID      ;
	private java.sql.Timestamp CREATE_DATE  ;
	private String REGION_ID    ;
	private long   INS_PROD_ID  ;
	private long   COMPETE_ID   ;
	private long   SERVICE_ID   ;
	private long   PRODUCT_ID   ;
	private String PROD_TYPE    ;
	private String STATUS       ;
	private String PARAM_01     ;
	private String PARAM_02     ;
	private String PARAM_03     ;
	private String PARAM_04     ;
	private String PARAM_05     ;
	private String STATE        ;
	private java.sql.Timestamp COMPLETE_DATE;
	private IISAUrgencyX INSTANCE  = null;
	public IOVUrgencyOffer() throws Exception{
		super();
		INSTANCE = new ISAUrgencyX();
	}
	
	public IOVUrgencyOffer( IISAUrgencyX urgencyx ) throws Exception{
		super();
		OFFER_ID      = urgencyx.getOfferId         ();
		ORDER_ID      = urgencyx.getOrderId         ();
		USER_ID       = urgencyx.getUserId          ();
		CREATE_DATE   = urgencyx.getCreateDate      ();
		REGION_ID     = urgencyx.getRegionId        ();
		INS_PROD_ID   = urgencyx.getInsProdId       ();
		COMPETE_ID     = urgencyx.getServiceId      ();
		SERVICE_ID     = urgencyx.getServiceId      ();
		PRODUCT_ID    = urgencyx.getProductId       ();
		STATUS        = urgencyx.getStatus          ();
		PARAM_01      = urgencyx.getParam01         ();
		PARAM_02      = urgencyx.getParam02         ();
		PARAM_03      = urgencyx.getParam03         ();
		PARAM_04      = urgencyx.getParam04         ();
		PARAM_05      = urgencyx.getParam05         ();
		STATE         = urgencyx.getState           ();
		COMPLETE_DATE = urgencyx.getCompleteDate    ();
		INSTANCE      = urgencyx                      ;
	}
	
	public IOVUrgencyOffer( IOVUrgencyOffer urgencyx ) throws Exception{
		super();
		OFFER_ID      = urgencyx.OFFER_ID     ;
		ORDER_ID      = urgencyx.ORDER_ID     ;
		USER_ID       = urgencyx.USER_ID      ;
		CREATE_DATE   = urgencyx.CREATE_DATE  ;
		REGION_ID     = urgencyx.REGION_ID    ;
		INS_PROD_ID   = urgencyx.INS_PROD_ID  ;
		COMPETE_ID    = urgencyx.COMPETE_ID   ;
		SERVICE_ID    = urgencyx.SERVICE_ID   ;
		PRODUCT_ID    = urgencyx.PRODUCT_ID   ;
		STATUS        = urgencyx.STATUS       ;
		PARAM_01      = urgencyx.PARAM_01     ;
		PARAM_02      = urgencyx.PARAM_02     ;
		PARAM_03      = urgencyx.PARAM_03     ;
		PARAM_04      = urgencyx.PARAM_04     ;
		PARAM_05      = urgencyx.PARAM_05     ;
		STATE         = urgencyx.STATE        ;
		COMPLETE_DATE = urgencyx.COMPLETE_DATE;
		INSTANCE       = (IISAUrgencyX)OracleUtils.ISystem.transfer( urgencyx.INSTANCE );
	}
	
	public IOVUrgencyOffer( IOVUrgencyOffer urgencyx, IISAUrgencyX _urgencyx_ ) throws Exception{
		super();
		OFFER_ID      = urgencyx.OFFER_ID     ;
		ORDER_ID      = urgencyx.ORDER_ID     ;
		USER_ID       = urgencyx.USER_ID      ;
		CREATE_DATE   = urgencyx.CREATE_DATE  ;
		REGION_ID     = urgencyx.REGION_ID    ;
		INS_PROD_ID   = urgencyx.INS_PROD_ID  ;
		COMPETE_ID    = urgencyx.COMPETE_ID   ;
		SERVICE_ID    = urgencyx.SERVICE_ID   ;
		PRODUCT_ID    = urgencyx.PRODUCT_ID   ;
		STATUS        = urgencyx.STATUS       ;
		PARAM_01      = urgencyx.PARAM_01     ;
		PARAM_02      = urgencyx.PARAM_02     ;
		PARAM_03      = urgencyx.PARAM_03     ;
		PARAM_04      = urgencyx.PARAM_04     ;
		PARAM_05      = urgencyx.PARAM_05     ;
		STATE         = urgencyx.STATE        ;
		COMPLETE_DATE = urgencyx.COMPLETE_DATE;
		OracleUtils.ICustom.transfer( urgencyx.INSTANCE, _urgencyx_ );
		INSTANCE      = _urgencyx_            ;
	}
	
	/**
	 * @return the oFFER_ID
	 */
	public long getOFFER_ID() {
		return OFFER_ID;
	}
	
	/**
	 * @param oFFER_ID the oFFER_ID to set
	 */
	public void setOFFER_ID(long oFFER_ID) {
		OFFER_ID = oFFER_ID;
		if( INSTANCE != null ) INSTANCE.setOfferId( oFFER_ID );
	}
	
	/**
	 * @return the oRDER_ID
	 */
	public long getORDER_ID() {
		return ORDER_ID;
	}
	
	/**
	 * @param oRDER_ID the oRDER_ID to set
	 */
	public void setORDER_ID(long oRDER_ID) {
		ORDER_ID = oRDER_ID;
		if( INSTANCE != null ) INSTANCE.setOrderId( oRDER_ID );
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
		if( INSTANCE != null ) INSTANCE.setUserId( uSER_ID );
	}
	
	/**
	 * @return the cREATE_DATE
	 */
	public java.sql.Timestamp getCREATE_DATE() {
		return CREATE_DATE;
	}
	
	/**
	 * @param cREATE_DATE the cREATE_DATE to set
	 */
	public void setCREATE_DATE(java.sql.Timestamp cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
		if( INSTANCE != null ) INSTANCE.setCreateDate( cREATE_DATE );
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
		if( INSTANCE != null ) INSTANCE.setRegionId( rEGION_ID );
	}
	
	/**
	 * @return the iNS_PROD_ID
	 */
	public long getINS_PROD_ID() {
		return INS_PROD_ID;
	}
	
	/**
	 * @param iNS_PROD_ID the iNS_PROD_ID to set
	 */
	public void setINS_PROD_ID(long iNS_PROD_ID) {
		INS_PROD_ID = iNS_PROD_ID;
		if( INSTANCE != null ) INSTANCE.setInsProdId( iNS_PROD_ID );
	}
	
	/**
	 * @return the sERVICE_ID
	 */
	public long getSERVICE_ID() {
		return SERVICE_ID;
	}
	
	/**
	 * @param sERVICE_ID the sERVICE_ID to set
	 */
	public void setSERVICE_ID(long sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
		if( INSTANCE != null ) INSTANCE.setServiceId( sERVICE_ID );
	}
	
	/**
	 * @return the cOMPETE_ID
	 */
	public long getCOMPETE_ID() {
		return COMPETE_ID;
	}

	/**
	 * @param cOMPETE_ID the cOMPETE_ID to set
	 */
	public void setCOMPETE_ID(long cOMPETE_ID) {
		COMPETE_ID = cOMPETE_ID;
	}

	/**
	 * @return the pRODUCT_ID
	 */
	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	
	/**
	 * @param pRODUCT_ID the pRODUCT_ID to set
	 */
	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
		if( INSTANCE != null ) INSTANCE.setProductId( pRODUCT_ID );
	}
	
	/**
	 * @return the pROD_TYPE
	 */
	public String getPROD_TYPE() {
		return PROD_TYPE;
	}
	
	/**
	 * @param pROD_TYPE the pROD_TYPE to set
	 */
	public void setPROD_TYPE(String pROD_TYPE) {
		PROD_TYPE = pROD_TYPE;
		if( INSTANCE != null ) INSTANCE.setProdType( pROD_TYPE );
	}
	
	/**
	 * @return the sTATUS
	 */
	public String getSTATUS() {
		return STATUS;
	}
	
	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
		if( INSTANCE != null ) INSTANCE.setStatus( sTATUS );
	}
	
	/**
	 * @return the pARAM_01
	 */
	public String getPARAM_01() {
		return PARAM_01;
	}
	
	/**
	 * @param pARAM_01 the pARAM_01 to set
	 */
	public void setPARAM_01(String pARAM_01) {
		PARAM_01 = pARAM_01;
		if( INSTANCE != null ) INSTANCE.setParam01( pARAM_01 );
	}
	
	/**
	 * @return the pARAM_02
	 */
	public String getPARAM_02() {
		return PARAM_02;
	}
	
	/**
	 * @param pARAM_02 the pARAM_02 to set
	 */
	public void setPARAM_02(String pARAM_02) {
		PARAM_02 = pARAM_02;
		if( INSTANCE != null ) INSTANCE.setParam02( pARAM_02 );
	}
	
	/**
	 * @return the pARAM_03
	 */
	public String getPARAM_03() {
		return PARAM_03;
	}
	
	/**
	 * @param pARAM_03 the pARAM_03 to set
	 */
	public void setPARAM_03(String pARAM_03) {
		PARAM_03 = pARAM_03;
		if( INSTANCE != null ) INSTANCE.setParam03( pARAM_03 );
	}
	
	/**
	 * @return the pARAM_04
	 */
	public String getPARAM_04() {
		return PARAM_04;
	}
	
	/**
	 * @param pARAM_04 the pARAM_04 to set
	 */
	public void setPARAM_04(String pARAM_04) {
		PARAM_04 = pARAM_04;
		if( INSTANCE != null ) INSTANCE.setParam04( pARAM_04 );
	}
	
	/**
	 * @return the pARAM_05
	 */
	public String getPARAM_05() {
		return PARAM_05;
	}
	
	/**
	 * @param pARAM_05 the pARAM_05 to set
	 */
	public void setPARAM_05(String pARAM_05) {
		PARAM_05 = pARAM_05;
		if( INSTANCE != null ) INSTANCE.setParam05( pARAM_05 );
	}
	
	/**
	 * @return the sTATE
	 */
	public String getSTATE() {
		return STATE;
	}
	
	/**
	 * @param sTATE the sTATE to set
	 */
	public void setSTATE(String sTATE) {
		STATE = sTATE;
		if( INSTANCE != null ) INSTANCE.setState( sTATE );
	}
	
	/**
	 * @return the cOMPLETE_DATE
	 */
	public java.sql.Timestamp getCOMPLETE_DATE() {
		return COMPLETE_DATE;
	}
	
	/**
	 * @param cOMPLETE_DATE the cOMPLETE_DATE to set
	 */
	public void setCOMPLETE_DATE(java.sql.Timestamp cOMPLETE_DATE) {
		COMPLETE_DATE = cOMPLETE_DATE;
		if( INSTANCE != null ) INSTANCE.setCompleteDate( cOMPLETE_DATE );
	}
	
	/**
	 * @return the iNSTANCE
	 */
	public IISAUrgencyX getINSTANCE() {
		return INSTANCE;
	}
	
	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(IISAUrgencyX iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
	
	/**
	 * 是否产品订购有效
	 * @return
	 */
	public boolean isCREATE(){
		return StringUtils.equals( STATE, IUpdcConst.IState.C );
	}
	
}
