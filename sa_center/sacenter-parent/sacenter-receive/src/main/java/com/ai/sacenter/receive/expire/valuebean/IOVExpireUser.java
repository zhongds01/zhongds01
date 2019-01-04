package com.ai.sacenter.receive.expire.valuebean;

import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.receive.expire.bo.ISAExpire;
import com.ai.sacenter.receive.expire.bo.SAExpire;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.OracleUtils;

public class IOVExpireUser extends IUpdfmxEntry implements java.io.Serializable{
	private static final long serialVersionUID = -1470670229524497030L;
	private long   ORDER_ID      			;
	private String CUST_ORDER               ;
	private String DONE_CODE                ;
	private String CATEGORY      			;
	private long   USER_ID      		    ;
	private long   CATALOG                  ;
	private String BILL_ID       			;
	private String BRAND_ID                 ;
	private String USER_REGION_ID           ;
	private java.sql.Timestamp CREATE_DATE  ;
	private String REGION_ID     			;
	private long   ORDER_DATE   			;
	private String FAIL_LOG       			;
	private String ORG_ID       			;
	private String STAFF_ID     			;
	private java.sql.Timestamp COMPLETE_DATE;
	private String STATE        			;
	private ISAExpire INSTANCE				;
	private CarbonList<IOVExpireOffer> ORDER = new CarbonList<IOVExpireOffer>();
	public IOVExpireUser() throws Exception{
		super();
		INSTANCE = new SAExpire();
	}
	
	public IOVExpireUser(ISAExpire aExpire) {
		super();
		_readfrombottle( aExpire );
		INSTANCE = aExpire;
	}
	
	public IOVExpireUser(IOVExpireUser expire) throws Exception{
		super( expire );
		INSTANCE = (ISAExpire)OracleUtils.ISystem.transfer( expire.INSTANCE );
		_readfrombottle( INSTANCE );
		for( java.util.Iterator<IOVExpireOffer> itera = expire.ORDER.iterator(); itera.hasNext(); ){
			IOVExpireOffer _expireoffer = (IOVExpireOffer)itera.next();
			ORDER.add( new IOVExpireOffer( _expireoffer ) );
		}
	}
	
	public IOVExpireUser( java.util.Map<String,Object> fromExpire ) throws Exception{
		super();
		ISAExpire aExpire = new SAExpire();
		OracleUtils.ICustom.transfer( fromExpire, aExpire );
		_readfrombottle( aExpire );
		INSTANCE = aExpire;
		INSTANCE.setStsToOld();
	}
	
	/**
	 * 
	 * @param aEXPIRE
	 */
	private void _readfrombottle( ISAExpire aEXPIRE ){
		ORDER_ID       = aEXPIRE.getOrderId     ();    				                        
		USER_ID        = aEXPIRE.getUserId      ();    				                 
		CATEGORY       = aEXPIRE.getCategory    ();
		CATALOG        = aEXPIRE.getCatalogId   ();
		BILL_ID        = aEXPIRE.getBillId      ();
		BRAND_ID       = aEXPIRE.getBrandId     ();
		USER_REGION_ID = aEXPIRE.getUserRegionId();
		CREATE_DATE    = aEXPIRE.getCreateDate  ();    				                 
		REGION_ID      = aEXPIRE.getRegionId    ();    				             
		ORDER_DATE     = aEXPIRE.getOrderDate   ();    				             
		FAIL_LOG       = aEXPIRE.getFailLog     ();   				             
		ORG_ID         = aEXPIRE.getOrgId       ();    				             
		STAFF_ID       = aEXPIRE.getStaffId     ();    				             
		COMPLETE_DATE  = aEXPIRE.getCompleteDate();    				             
		STATE          = aEXPIRE.getState       ();
		DONE_CODE      = aEXPIRE.getDoneCode	();
		CUST_ORDER     = aEXPIRE.getCustOrder   ();
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
		if( INSTANCE != null ) INSTANCE.setOrderId(oRDER_ID);
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
		if( INSTANCE != null ) INSTANCE.setUserId(uSER_ID);
	}
	
	/**
	 * @return the cATEGORY
	 */
	public String getCATEGORY() {
		return CATEGORY;
	}
	
	/**
	 * @param cATEGORY the cATEGORY to set
	 */
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
		if( INSTANCE != null ) INSTANCE.setCategory(cATEGORY);
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
		if( INSTANCE != null ) INSTANCE.setBillId(bILL_ID);
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
		if( INSTANCE != null ) INSTANCE.setCreateDate(CREATE_DATE);
	}
	
	/**
	 * @return the cATALOG
	 */
	public long getCATALOG() {
		return CATALOG;
	}

	/**
	 * @param cATALOG the cATALOG to set
	 */
	public void setCATALOG(long cATALOG) {
		CATALOG = cATALOG;
		if( INSTANCE != null ) INSTANCE.setCatalogId( cATALOG );
	}

	/**
	 * @return the bRAND_ID
	 */
	public String getBRAND_ID() {
		return BRAND_ID;
	}

	/**
	 * @param bRAND_ID the bRAND_ID to set
	 */
	public void setBRAND_ID(String bRAND_ID) {
		BRAND_ID = bRAND_ID;
		if( INSTANCE != null ) INSTANCE.setBrandId( bRAND_ID );
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
		if( INSTANCE != null ) INSTANCE.setRegionId(rEGION_ID);
	}
	
	/**
	 * @return the oRDER_DATE
	 */
	public long getORDER_DATE() {
		return ORDER_DATE;
	}
	
	/**
	 * @param oRDER_DATE the oRDER_DATE to set
	 */
	public void setORDER_DATE(long oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
		if( INSTANCE != null ) INSTANCE.setOrderDate(oRDER_DATE);
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
		if( INSTANCE != null ) INSTANCE.setFailLog(fAIL_LOG);
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
		if( INSTANCE != null ) INSTANCE.setOrgId(oRG_ID);
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
		if( INSTANCE != null ) INSTANCE.setStaffId(sTAFF_ID);
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
		if( INSTANCE != null ) INSTANCE.setCompleteDate(cOMPLETE_DATE);
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
		if( INSTANCE != null ) INSTANCE.setState(sTATE);
	}

	/**
	 * @return the iNSTANCE
	 */
	public ISAExpire getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(ISAExpire iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	/**
	 * @return the ORDER
	 */
	public CarbonList<IOVExpireOffer> getORDER() {
		return ORDER;
	}
}
