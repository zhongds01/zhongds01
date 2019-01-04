package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.provision.bo.IISAUatmix;
import com.ai.sacenter.provision.bo.ISAUatmixHis;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.SystemUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 网元交互轨迹</p>
 * <p>Copyright: Copyright (c) 2017年6月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpfwmUatmix implements java.io.Serializable{
	private static final long serialVersionUID = 7795027757381030837L;
	private long   LGMSG_ID     ;
	private String ORDER_ID     ;
	private String DONE_CODE    ;
	private long   USER_ID      ;
	private String BILL_ID      ;
	private java.sql.Timestamp CREATE_DATE  ;
	private String REGION_ID    ;
	private String STATE        ;
	private String PLATFORM     ;
	private String PLWK_IDO     ;
	private String IMPLCLASS    ;
	private String ORG_ID       ;
	private String FAIL_CODE    ;
	private String FAIL_LOG     ;
	private String STAFF_ID     ;
	private java.sql.Timestamp COMPLETE_DATE;
	private IISAUatmix INSTANCE = null;
	private IUatmixOfferHome _order = new IUatmixOfferHome();
	public IOVUpfwmUatmix() throws Exception{
		super();
		INSTANCE = new ISAUatmixHis();
	}
	
	public IOVUpfwmUatmix( IISAUatmix aUatmix ) throws Exception{
		super();
		LGMSG_ID      = aUatmix.getLgmsgId     ();
		ORDER_ID      = aUatmix.getOrderId     ();
		DONE_CODE     = aUatmix.getDoneCode    ();
		USER_ID       = aUatmix.getUserId      ();
		BILL_ID       = aUatmix.getBillId      ();
		CREATE_DATE   = aUatmix.getCreateDate  ();
		REGION_ID     = aUatmix.getRegionId    ();
		STATE         = aUatmix.getState       ();
		PLATFORM      = aUatmix.getPlatform    ();
		PLWK_IDO      = aUatmix.getPlwkIdo     ();
		IMPLCLASS     = aUatmix.getImplclass   ();
		FAIL_LOG      = aUatmix.getResult      ();
		ORG_ID        = aUatmix.getOrgId       ();
		STAFF_ID      = aUatmix.getStaffId     ();
		COMPLETE_DATE = aUatmix.getCompleteDate();
		INSTANCE      = aUatmix                  ;
	}
	
	/**
	 * @return the lGMSG_ID
	 */
	public long getLGMSG_ID() {
		return LGMSG_ID;
	}
	
	/**
	 * @param lGMSG_ID the lGMSG_ID to set
	 */
	public void setLGMSG_ID(long lGMSG_ID) {
		LGMSG_ID = lGMSG_ID;
		if (INSTANCE != null) INSTANCE.setLgmsgId(lGMSG_ID);
	}
	
	/**
	 * @return the oRDER_ID
	 */
	public String getORDER_ID() {
		return ORDER_ID;
	}
	
	/**
	 * @param oRDER_ID the oRDER_ID to set
	 */
	public void setORDER_ID(String oRDER_ID) {
		ORDER_ID = oRDER_ID;
		if (INSTANCE != null) INSTANCE.setOrderId(oRDER_ID);
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
		if (INSTANCE != null) INSTANCE.setDoneCode(dONE_CODE);
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
		if (INSTANCE != null) INSTANCE.setUserId(uSER_ID);
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
		if (INSTANCE != null) INSTANCE.setBillId(bILL_ID);
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
		if (INSTANCE != null) INSTANCE.setCreateDate(cREATE_DATE);
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
		if (INSTANCE != null) INSTANCE.setRegionId(rEGION_ID);
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
		if (INSTANCE != null) INSTANCE.setState(sTATE);
	}
	
	/**
	 * @return the pLATFORM
	 */
	public String getPLATFORM() {
		return PLATFORM;
	}
	
	/**
	 * @param pLATFORM the pLATFORM to set
	 */
	public void setPLATFORM(String pLATFORM) {
		PLATFORM = pLATFORM;
		if (INSTANCE != null) INSTANCE.setPlatform(pLATFORM);
	}
	
	/**
	 * @return the pLWK_IDO
	 */
	public String getPLWK_IDO() {
		return PLWK_IDO;
	}
	
	/**
	 * @param pLWK_IDO the pLWK_IDO to set
	 */
	public void setPLWK_IDO(String pLWK_IDO) {
		PLWK_IDO = pLWK_IDO;
		if (INSTANCE != null) INSTANCE.setPlwkIdo(pLWK_IDO);
	}
	
	/**
	 * @return the iMPLCLASS
	 */
	public String getIMPLCLASS() {
		return IMPLCLASS;
	}
	
	/**
	 * @param iMPLCLASS the iMPLCLASS to set
	 */
	public void setIMPLCLASS(String iMPLCLASS) {
		IMPLCLASS = iMPLCLASS;
		if (INSTANCE != null) INSTANCE.setImplclass(iMPLCLASS);
	}
	
	/**
	 * @return 报文明细
	 */
	public String getMSG(){
		if( _order._msg == null ){
			StringBuilder __uatmix__ = new StringBuilder();
			for( int index = 0 ; index < 20; index++ ){
				String _field_ = ClassUtils.getINDEX( new String[]{"MSG_",index < 9 ?"0":"",String.valueOf( index + 1 ) } );
				if( INSTANCE.get( _field_ ) == null ){ continue; }
				__uatmix__.append( INSTANCE.get( _field_ ).toString() );
			}
			_order._msg = __uatmix__.toString();
			__uatmix__ = null;
		}
		return _order._msg;
	}
	
	/**
	 * 
	 * @param _uatmix_
	 * @throws Exception
	 */
	public void setMSG( String _uatmix_ ) throws Exception{
		_order._msg = _uatmix_;
		String __uatmix__[] = SystemUtils.ICustom.substringAsL( _uatmix_  );
		for( int index = 0 ; __uatmix__ != null && __uatmix__.length > 0 && index < 20; index++ ){
			String _field_ = ClassUtils.getINDEX( new String[]{"MSG_",index < 9 ?"0":"",String.valueOf( index + 1 ) } );
			if( index < __uatmix__.length ){
				INSTANCE.set( _field_, __uatmix__[index] );
			}
			else{
				INSTANCE.set( _field_, null );
			}
		}
	}
	
	/**
	 * @return the fAIL_CODE
	 */
	public String getFAIL_CODE() {
		return FAIL_CODE;
	}

	/**
	 * @param fAIL_CODE the fAIL_CODE to set
	 */
	public void setFAIL_CODE(String fAIL_CODE) {
		FAIL_CODE = fAIL_CODE;
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
		if (INSTANCE != null) INSTANCE.setResult(fAIL_LOG);
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
		if (INSTANCE != null) INSTANCE.setCompleteDate(cOMPLETE_DATE);
	}
	
	/**
	 * @return the iNSTANCE
	 */
	public IISAUatmix getINSTANCE() {
		return INSTANCE;
	}
	
	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(IISAUatmix iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
	
	/**
	 * @return the _order
	 */
	public IUatmixOfferHome getORDER() {
		return _order;
	}

	public static class IUatmixOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -7461933915052223366L;
		/*报文明细*/
		private String  _msg ;
		public IUatmixOfferHome(){
			super();
		}
		
		/**
		 * @return 报文明细
		 */
		public String getMSG() {
			return _msg;
		}
	}
}
