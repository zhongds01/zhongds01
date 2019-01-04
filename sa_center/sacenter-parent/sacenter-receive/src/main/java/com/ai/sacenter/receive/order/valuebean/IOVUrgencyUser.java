package com.ai.sacenter.receive.order.valuebean;

import com.ai.sacenter.receive.order.bo.IISAUrgency;
import com.ai.sacenter.receive.order.bo.ISAUrgency;
import com.ai.sacenter.receive.order.bo.ISAUrgencyFail;
import com.ai.sacenter.receive.order.bo.ISAUrgencyHis;
import com.ai.sacenter.receive.order.bo.ISAUrgencyX;
import com.ai.sacenter.receive.order.bo.ISAUrgencyXHis;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.OracleUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 服务定单用户</p>
 * <p>Copyright: Copyright (c) 2016年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUrgencyUser implements java.io.Serializable{
	private static final long serialVersionUID = -4992479733674412596L;
	private long   ORDER_ID     ;
	private String CUST_ORDER   ;
	private String DONE_CODE    ;
	private String BUSINESS     ;
	private long   USER_ID      ;
	private String BILL_ID      ;
	private String SUB_BILL_ID  ;
	private java.sql.Timestamp CREATE_DATE  ;
	private String REGION_ID    ;
	private String USER_REGION_ID;
	private String STATE        ;
	private String PARAM        ;
	private java.sql.Timestamp ORDER_DATE   ;
	private java.sql.Timestamp COMPLETE_DATE;
	private String FAIL_LOG     ;
	private long   ORG_ID       ;
	private long   STAFF_ID     ;
	private IISAUrgency INSTANCE = null;
	private CarbonList<IOVUrgencyOffer> ORDER = new CarbonList<IOVUrgencyOffer>();
	public IOVUrgencyUser() throws Exception{
		super();
		INSTANCE = new ISAUrgency();
	}
	
	public IOVUrgencyUser( IISAUrgency urgency ) throws Exception{
		super();
		ORDER_ID      = urgency.getOrderId     ();
		CUST_ORDER    = urgency.getCustOrder   ();
		DONE_CODE     = urgency.getDoneCode    ();
		BUSINESS      = urgency.getBusiness    ();
		USER_ID       = urgency.getUserId      ();
		BILL_ID       = urgency.getBillId      ();
		SUB_BILL_ID   = urgency.getSubBillId   ();
		CREATE_DATE   = urgency.getCreateDate  ();
		REGION_ID     = urgency.getRegionId    ();
		STATE         = urgency.getState       ();
		USER_REGION_ID= urgency.getUserRegionId();
		PARAM         = urgency.getParam       ();
		ORDER_DATE    = urgency.getOrderDate   ();
		COMPLETE_DATE = urgency.getCompleteDate();
		FAIL_LOG      = urgency.getFailLog     ();
		ORG_ID        = urgency.getOrgId       ();
		STAFF_ID      = urgency.getStaffId     ();
		INSTANCE      = urgency                  ;
	}
	
	public IOVUrgencyUser( java.util.HashMap<String,Object> _urgency_ ) throws Exception{
		super();
		IISAUrgency urgency = new ISAUrgency();
		OracleUtils.ICustom.transfer( _urgency_, urgency );
		ORDER_ID      = urgency.getOrderId     ();
		CUST_ORDER    = urgency.getCustOrder   ();
		DONE_CODE     = urgency.getDoneCode    ();
		BUSINESS      = urgency.getBusiness    ();
		USER_ID       = urgency.getUserId      ();
		BILL_ID       = urgency.getBillId      ();
		SUB_BILL_ID   = urgency.getSubBillId   ();
		CREATE_DATE   = urgency.getCreateDate  ();
		REGION_ID     = urgency.getRegionId    ();
		STATE         = urgency.getState       ();
		USER_REGION_ID= urgency.getUserRegionId();
		PARAM         = urgency.getParam       ();
		ORDER_DATE    = urgency.getOrderDate   ();
		COMPLETE_DATE = urgency.getCompleteDate();
		FAIL_LOG      = urgency.getFailLog     ();
		ORG_ID        = urgency.getOrgId       ();
		STAFF_ID      = urgency.getStaffId     ();
		urgency.setStsToOld();
		INSTANCE      = urgency;
	}
	
	public IOVUrgencyUser( IOVUrgencyUser urgency ) throws Exception{
		super();
		ORDER_ID       = urgency.ORDER_ID       ;
		CUST_ORDER     = urgency.CUST_ORDER     ;
		DONE_CODE      = urgency.DONE_CODE      ;
		BUSINESS       = urgency.BUSINESS       ;
		USER_ID        = urgency.USER_ID        ;
		BILL_ID        = urgency.BILL_ID        ;
		SUB_BILL_ID    = urgency.SUB_BILL_ID    ;
		CREATE_DATE    = urgency.CREATE_DATE    ;
		REGION_ID      = urgency.REGION_ID      ;
		STATE          = urgency.STATE          ;
		USER_REGION_ID = urgency.USER_REGION_ID ;
		PARAM          = urgency.PARAM          ;
		ORDER_DATE     = urgency.ORDER_DATE     ;
		COMPLETE_DATE  = urgency.COMPLETE_DATE  ;
		FAIL_LOG       = urgency.FAIL_LOG       ;
		ORG_ID         = urgency.ORG_ID         ;
		STAFF_ID       = urgency.STAFF_ID       ;
		INSTANCE       = (IISAUrgency)OracleUtils.ISystem.transfer( urgency.INSTANCE );
		for( java.util.Iterator<IOVUrgencyOffer> itera = urgency.ORDER.iterator(); itera.hasNext(); ){
			IOVUrgencyOffer urgencyoffer = (IOVUrgencyOffer)itera.next();
			ORDER.add( new IOVUrgencyOffer( urgencyoffer ) );
		}
	}
	
	public IOVUrgencyUser( IOVUrgencyUser urgency, IISAUrgency _urgency_ ) throws Exception{
		super();
		ORDER_ID       = urgency.ORDER_ID       ;
		CUST_ORDER     = urgency.CUST_ORDER     ;
		DONE_CODE      = urgency.DONE_CODE      ;
		BUSINESS       = urgency.BUSINESS       ;
		USER_ID        = urgency.USER_ID        ;
		BILL_ID        = urgency.BILL_ID        ;
		SUB_BILL_ID    = urgency.SUB_BILL_ID    ;
		CREATE_DATE    = urgency.CREATE_DATE    ;
		REGION_ID      = urgency.REGION_ID      ;
		STATE          = urgency.STATE          ;
		USER_REGION_ID = urgency.USER_REGION_ID ;
		PARAM          = urgency.PARAM          ;
		ORDER_DATE     = urgency.ORDER_DATE     ;
		COMPLETE_DATE  = urgency.COMPLETE_DATE  ;
		FAIL_LOG       = urgency.FAIL_LOG       ;
		ORG_ID         = urgency.ORG_ID         ;
		STAFF_ID       = urgency.STAFF_ID       ;
		OracleUtils.ICustom.transfer( urgency.INSTANCE, _urgency_ );
		INSTANCE       = _urgency_              ;
		for( java.util.Iterator<IOVUrgencyOffer> itera = urgency.ORDER.iterator(); itera.hasNext(); ){
			IOVUrgencyOffer urgencyoffer = (IOVUrgencyOffer)itera.next();
			if( _urgency_ != null && _urgency_ instanceof ISAUrgency ){
				ORDER.add( new IOVUrgencyOffer( urgencyoffer, new ISAUrgencyX() ) );
			}
			else if( _urgency_ != null && _urgency_ instanceof ISAUrgencyFail ){
				ORDER.add( new IOVUrgencyOffer( urgencyoffer, new ISAUrgencyX() ) );
			}
			else if( _urgency_ != null && _urgency_ instanceof ISAUrgencyHis ){
				ORDER.add( new IOVUrgencyOffer( urgencyoffer, new ISAUrgencyXHis() ) );
			}
			else{
				ORDER.add( new IOVUrgencyOffer( urgencyoffer ) );
			}
		}
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
		if( INSTANCE != null ) INSTANCE.setCustOrder( cUST_ORDER );
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
		if( INSTANCE != null ) INSTANCE.setDoneCode( dONE_CODE );
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
		if( INSTANCE != null ) INSTANCE.setBusiness( bUSINESS );
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
		if( INSTANCE != null ) INSTANCE.setBillId( bILL_ID );
	}

	/**
	 * @return the sUB_BILL_ID
	 */
	public String getSUB_BILL_ID() {
		return SUB_BILL_ID;
	}

	/**
	 * @param sUB_BILL_ID the sUB_BILL_ID to set
	 */
	public void setSUB_BILL_ID(String sUB_BILL_ID) {
		SUB_BILL_ID = sUB_BILL_ID;
		if( INSTANCE != null ) INSTANCE.setSubBillId( sUB_BILL_ID );
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
	 * @return the uSER_REGION_ID
	 */
	public String getUSER_REGION_ID() {
		return USER_REGION_ID;
	}

	/**
	 * @param uSER_REGION_ID the uSER_REGION_ID to set
	 */
	public void setUSER_REGION_ID(String uSER_REGION_ID) {
		USER_REGION_ID = uSER_REGION_ID;
		if( INSTANCE != null ) INSTANCE.setUserRegionId( uSER_REGION_ID );
	}

	/**
	 * @return the pARAM
	 */
	public String getPARAM() {
		return PARAM;
	}
	
	/**
	 * @param pARAM the pARAM to set
	 */
	public void setPARAM(String pARAM) {
		PARAM = pARAM;
		if( INSTANCE != null ) INSTANCE.setParam( pARAM );
	}
	
	/**
	 * @return the oRDER_DATE
	 */
	public java.sql.Timestamp getORDER_DATE() {
		return ORDER_DATE;
	}
	
	/**
	 * @param oRDER_DATE the oRDER_DATE to set
	 */
	public void setORDER_DATE(java.sql.Timestamp oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
		if( INSTANCE != null ) INSTANCE.setOrderDate( oRDER_DATE );
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
	 * @return the fAIL_LOG
	 */
	public String getFAIL_LOG() {
		return FAIL_LOG;
	}
	
	/**
	 * @param fAIL_LOG the fAIL_LOG to set
	 */
	public void setFAIL_LOG(String fAIL_LOG) {
		FAIL_LOG = fAIL_LOG;
		if( INSTANCE != null ) INSTANCE.setFailLog( fAIL_LOG );
	}
	
	/**
	 * @return the oRG_ID
	 */
	public long getORG_ID() {
		return ORG_ID;
	}

	/**
	 * @param oRG_ID the oRG_ID to set
	 */
	public void setORG_ID(long oRG_ID) {
		ORG_ID = oRG_ID;
		if( INSTANCE != null ) INSTANCE.setOrgId( oRG_ID );
	}

	/**
	 * @return the sTAFF_ID
	 */
	public long getSTAFF_ID() {
		return STAFF_ID;
	}

	/**
	 * @param sTAFF_ID the sTAFF_ID to set
	 */
	public void setSTAFF_ID(long sTAFF_ID) {
		STAFF_ID = sTAFF_ID;
		if( INSTANCE != null ) INSTANCE.setStaffId( sTAFF_ID );
	}

	/**
	 * @return the iNSTANCE
	 */
	public IISAUrgency getINSTANCE() {
		return INSTANCE;
	}
	
	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(IISAUrgency iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
	
	/**
	 * @return the oRDER
	 */
	public CarbonList<IOVUrgencyOffer> getORDER() {
		return ORDER;
	}
}
