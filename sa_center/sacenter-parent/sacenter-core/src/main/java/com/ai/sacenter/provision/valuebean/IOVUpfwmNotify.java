package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.bo.IISANotifyIndex;
import com.ai.sacenter.provision.bo.ISANotifyIndex;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;

public class IOVUpfwmNotify extends IUpdfmxLittle implements java.io.Serializable{
	private static final long serialVersionUID = 1583694545517135684L;
	private long   ORDER_ID     ;                       
	private String CATEGORY     ;                       
	private long   USER_ID      ;                       
	private String PLATFORM     ;                       
	private java.sql.Timestamp CREATE_DATE  ;                       
	private String REGION_ID    ;                       
	private long   STATUS       ;                       
	private java.sql.Timestamp ORDER_DATE   ;                       
	private java.sql.Timestamp BACKUP_DATE  ;                       
	private String UP_FIELD     ;                       
	private String FAIL_CODE    ;                       
	private String FAIL_REASON  ;                       
	private String FAIL_LOG     ;                       
	private java.sql.Timestamp START_DATE   ;                       
	private java.sql.Timestamp COMPLETE_DATE;                       
	private java.sql.Timestamp END_DATE     ;                       
	private long   HAND_ID      ;                       
	private long   HAND_OP_ID   ;                       
	private java.sql.Timestamp HAND_DATE    ;
	private IUpfwmNotifyHome _order = null;
	public IOVUpfwmNotify() throws Exception{
		super();
		_instance = new ISANotifyIndex  ();
		_order    = new IUpfwmNotifyHome();
	}
	
	public IOVUpfwmNotify(IISANotifyIndex aNotify) throws Exception{
		super( aNotify );
		ORDER_ID      = aNotify.getOrderId      ();                       
		CATEGORY      = aNotify.getCategory     ();                       
		USER_ID       = aNotify.getUserId       ();                       
		PLATFORM      = aNotify.getPlatform     ();                       
		CREATE_DATE   = aNotify.getCreateDate   ();                       
		REGION_ID     = aNotify.getRegionId     ();                       
		STATUS        = aNotify.getStatus       ();                       
		ORDER_DATE    = aNotify.getOrderDate    ();                       
		BACKUP_DATE   = aNotify.getBackupDate   ();                       
		UP_FIELD      = aNotify.getUpField      ();                       
		FAIL_CODE     = aNotify.getFailCode     ();                       
		FAIL_REASON   = aNotify.getFailReason   ();                       
		FAIL_LOG      = aNotify.getFailLog      ();                       
		START_DATE    = aNotify.getStartDate    ();                       
		COMPLETE_DATE = aNotify.getCompleteDate ();                       
		END_DATE      = aNotify.getEndDate      ();                       
		HAND_ID       = aNotify.getHandId       ();                       
		HAND_OP_ID    = aNotify.getHandOpId     ();                       
		HAND_DATE     = aNotify.getHandDate     ();   
		_order        = new IUpfwmNotifyHome    ();
	}
	
	public IOVUpfwmNotify(java.util.Map<String, Object> fromUpfwm) throws Exception{
		super();
		_instance     = new ISANotifyIndex();
		OracleUtils.ICustom.transfer( fromUpfwm, _instance            );
		ORDER_ID      = ((IISANotifyIndex)_instance).getOrderId      ();                       
		CATEGORY      = ((IISANotifyIndex)_instance).getCategory     ();                       
		USER_ID       = ((IISANotifyIndex)_instance).getUserId       ();                       
		PLATFORM      = ((IISANotifyIndex)_instance).getPlatform     ();                       
		CREATE_DATE   = ((IISANotifyIndex)_instance).getCreateDate   ();                       
		REGION_ID     = ((IISANotifyIndex)_instance).getRegionId     ();                       
		STATUS        = ((IISANotifyIndex)_instance).getStatus       ();                       
		ORDER_DATE    = ((IISANotifyIndex)_instance).getOrderDate    ();                       
		BACKUP_DATE   = ((IISANotifyIndex)_instance).getBackupDate   ();                       
		UP_FIELD      = ((IISANotifyIndex)_instance).getUpField      ();                       
		FAIL_CODE     = ((IISANotifyIndex)_instance).getFailCode     ();                       
		FAIL_REASON   = ((IISANotifyIndex)_instance).getFailReason   ();                       
		FAIL_LOG      = ((IISANotifyIndex)_instance).getFailLog      ();                       
		START_DATE    = ((IISANotifyIndex)_instance).getStartDate    ();                       
		COMPLETE_DATE = ((IISANotifyIndex)_instance).getCompleteDate ();                       
		END_DATE      = ((IISANotifyIndex)_instance).getEndDate      ();                       
		HAND_ID       = ((IISANotifyIndex)_instance).getHandId       ();                       
		HAND_OP_ID    = ((IISANotifyIndex)_instance).getHandOpId     ();                       
		HAND_DATE     = ((IISANotifyIndex)_instance).getHandDate     ();                       
		((IISANotifyIndex)_instance).setStsToOld                     (); 
		_order        = new IUpfwmNotifyHome                         ();
	}
	
	public IOVUpfwmNotify( IOVUpfwmNotify fromNotify) throws Exception{
		super( fromNotify );
		ORDER_ID      = fromNotify.getORDER_ID                 ();                       
		CATEGORY      = fromNotify.getCATEGORY                 ();                       
		USER_ID       = fromNotify.getUSER_ID                  ();                       
		PLATFORM      = fromNotify.getPLATFORM                 ();                       
		CREATE_DATE   = fromNotify.getCREATE_DATE              ();                       
		REGION_ID     = fromNotify.getREGION_ID                ();                       
		STATUS        = fromNotify.getSTATUS                   ();                       
		ORDER_DATE    = fromNotify.getORDER_DATE               ();                       
		BACKUP_DATE   = fromNotify.getBACKUP_DATE              ();                       
		UP_FIELD      = fromNotify.getUP_FIELD                 ();                       
		FAIL_CODE     = fromNotify.getFAIL_CODE                ();                       
		FAIL_REASON   = fromNotify.getFAIL_REASON              ();                       
		FAIL_LOG      = fromNotify.getFAIL_LOG                 ();                       
		START_DATE    = fromNotify.getSTART_DATE               ();                       
		COMPLETE_DATE = fromNotify.getCOMPLETE_DATE            ();                       
		END_DATE      = fromNotify.getEND_DATE                 ();                       
		HAND_ID       = fromNotify.getHAND_ID                  ();                       
		HAND_OP_ID    = fromNotify.getHAND_OP_ID               ();                       
		HAND_DATE     = fromNotify.getHAND_DATE                ();
		_order        = new IUpfwmNotifyHome( fromNotify._order );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setOrderId( oRDER_ID );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setCategory( cATEGORY );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setUserId( uSER_ID );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setPlatform( pLATFORM );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setCreateDate( cREATE_DATE );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setRegionId( rEGION_ID );
	}

	/**
	 * @return the sTATUS
	 */
	public long getSTATUS() {
		return STATUS;
	}

	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(long sTATUS) {
		STATUS = sTATUS;
		if( _instance != null ) ((IISANotifyIndex)_instance).setStatus( (int)sTATUS );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setOrderDate( oRDER_DATE );
	}

	/**
	 * @return the bACKUP_DATE
	 */
	public java.sql.Timestamp getBACKUP_DATE() {
		return BACKUP_DATE;
	}

	/**
	 * @param bACKUP_DATE the bACKUP_DATE to set
	 */
	public void setBACKUP_DATE(java.sql.Timestamp bACKUP_DATE) {
		BACKUP_DATE = bACKUP_DATE;
		if( _instance != null ) ((IISANotifyIndex)_instance).setBackupDate( bACKUP_DATE );
	}

	/**
	 * @return the uP_FIELD
	 */
	public String getUP_FIELD() {
		return UP_FIELD;
	}

	/**
	 * @param uP_FIELD the uP_FIELD to set
	 */
	public void setUP_FIELD(String uP_FIELD) {
		UP_FIELD = uP_FIELD;
		if( _instance != null ) ((IISANotifyIndex)_instance).setUpField( uP_FIELD );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setFailCode( fAIL_CODE );
	}

	/**
	 * @return the fAIL_REASON
	 */
	public String getFAIL_REASON() {
		return FAIL_REASON;
	}

	/**
	 * @param fAIL_REASON the fAIL_REASON to set
	 */
	public void setFAIL_REASON(String fAIL_REASON) {
		FAIL_REASON = fAIL_REASON;
		if( _instance != null ) ((IISANotifyIndex)_instance).setFailReason( fAIL_REASON );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setFailLog( fAIL_LOG );
	}

	/**
	 * @return the sTART_DATE
	 */
	public java.sql.Timestamp getSTART_DATE() {
		return START_DATE;
	}

	/**
	 * @param sTART_DATE the sTART_DATE to set
	 */
	public void setSTART_DATE(java.sql.Timestamp sTART_DATE) {
		START_DATE = sTART_DATE;
		if( _instance != null ) ((IISANotifyIndex)_instance).setStartDate( sTART_DATE );
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
		if( _instance != null ) ((IISANotifyIndex)_instance).setCompleteDate( cOMPLETE_DATE );
	}

	/**
	 * @return the eND_DATE
	 */
	public java.sql.Timestamp getEND_DATE() {
		return END_DATE;
	}

	/**
	 * @param eND_DATE the eND_DATE to set
	 */
	public void setEND_DATE(java.sql.Timestamp eND_DATE) {
		END_DATE = eND_DATE;
		if( _instance != null ) ((IISANotifyIndex)_instance).setEndDate( eND_DATE );
	}

	/**
	 * @return the hAND_ID
	 */
	public long getHAND_ID() {
		return HAND_ID;
	}

	/**
	 * @param hAND_ID the hAND_ID to set
	 */
	public void setHAND_ID(long hAND_ID) {
		HAND_ID = hAND_ID;
		if( _instance != null ) ((IISANotifyIndex)_instance).setHandId( hAND_ID );
	}

	/**
	 * @return the hAND_OP_ID
	 */
	public long getHAND_OP_ID() {
		return HAND_OP_ID;
	}

	/**
	 * @param hAND_OP_ID the hAND_OP_ID to set
	 */
	public void setHAND_OP_ID(long hAND_OP_ID) {
		HAND_OP_ID = hAND_OP_ID;
		if( _instance != null ) ((IISANotifyIndex)_instance).setHandOpId( hAND_OP_ID );
	}

	/**
	 * @return the hAND_DATE
	 */
	public java.sql.Timestamp getHAND_DATE() {
		return HAND_DATE;
	}

	/**
	 * @param hAND_DATE the hAND_DATE to set
	 */
	public void setHAND_DATE(java.sql.Timestamp hAND_DATE) {
		HAND_DATE = hAND_DATE;
		if( _instance != null ) ((IISANotifyIndex)_instance).setHandDate( hAND_DATE );
	}

	/**
	 * 
	 * @return _little
	 */
	public IUpffxLittle getLittle() {
		if( _little != null && super.getDestiny() == null && StringUtils.isBlank( PLATFORM ) == false ){
			_little.setREPOSITORY( SystemUtils.ICustom.getIUpfomDAO( PLATFORM ) );
		}
		return _little;
	}

	/**
	 * @return the _order
	 */
	public IUpfwmNotifyHome getORDER() {
		if( _order == null ){ _order = new IUpfwmNotifyHome(); }
		if( _little != null && super.getDestiny() == null && StringUtils.isBlank( PLATFORM ) == false ){
			_little.setREPOSITORY( SystemUtils.ICustom.getIUpfomDAO( PLATFORM ) );
		}
		return _order;
	}
	
	/**
	 * 网元工单通知为创建
	 * @return
	 */
	public boolean isCREATE(){
		return STATUS == IUpfwmConst.IUpdos.CREATE;
	}
	
	/**
	 * 网元工单通知为挂起
	 * @return
	 */
	public boolean isSUSPEND(){
		return STATUS == IUpfwmConst.IUpdos.SUSPEND;
	}
	
	/**
	 * 网元工单通知为已撤销
	 * @return
	 */
	public boolean isCANCEL(){
		return STATUS == IUpfwmConst.IUpdos.CANCEL;
	}
	
	public static class IUpfwmNotifyHome implements java.io.Serializable{
		private static final long serialVersionUID = -3576517113645258227L;
		public IUpfwmNotifyHome(){
			super();
		}
		
		public IUpfwmNotifyHome( IUpfwmNotifyHome notify){
			super();
		}
	}
}
