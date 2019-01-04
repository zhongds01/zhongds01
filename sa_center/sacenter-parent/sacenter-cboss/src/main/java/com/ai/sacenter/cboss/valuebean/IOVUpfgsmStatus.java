package com.ai.sacenter.cboss.valuebean;

import com.ai.sacenter.cboss.bo.ISAMiscStatus;

/**
 * <p>Title: sacenter-cboss</p>
 * <p>Description: 用户状态</p>
 * <p>Copyright: Copyright (c) 2018年4月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfgsmStatus extends IOVUpfgsmOrder {
	private static final long serialVersionUID = -3071103768622041898L;
	private String OLD_BILL_ID ;
	private java.sql.Timestamp COMMIT_DATE ;
	private java.sql.Timestamp STS_CHG_TIME;
	private java.sql.Timestamp STS_OPR_TIME;
	private long   DONE_CODE   ;
	private java.sql.Timestamp DONE_DATE   ;
	private String REV1	       ;
	private long   REV2	       ;
	private String REV3	       ;
	private String REMARK	   ;
	public IOVUpfgsmStatus() throws Exception{
		super();
		_instance = new ISAMiscStatus();
	}

	public IOVUpfgsmStatus(ISAMiscStatus instance) throws Exception{
		super(instance);
		OLD_BILL_ID  = instance.getOldBillId ();
		COMMIT_DATE  = instance.getCommitDate();
		STS_CHG_TIME = instance.getStsChgTime();
		STS_OPR_TIME = instance.getStsOprTime();
		DONE_CODE    = instance.getDoneCode  ();
		DONE_DATE    = instance.getDoneDate  ();
		REV1	     = instance.getRev1	     ();
		REV2	     = instance.getRev2	     ();
		REV3	     = instance.getRev3	     ();
		REMARK	     = instance.getRemark    ();
	}

	public IOVUpfgsmStatus( IOVUpfgsmStatus provision ) throws Exception{
		super( provision );
		OLD_BILL_ID  = provision.getOLD_BILL_ID ();
		COMMIT_DATE  = provision.getCOMMIT_DATE ();
		STS_CHG_TIME = provision.getSTS_CHG_TIME();
		STS_OPR_TIME = provision.getSTS_OPR_TIME();
		DONE_CODE    = provision.getDONE_CODE   ();
		DONE_DATE    = provision.getDONE_DATE   ();
		REV1	     = provision.getREV1	    ();
		REV2	     = provision.getREV2	    ();
		REV3	     = provision.getREV3	    ();
		REMARK	     = provision.getREMARK	    ();
	}
	
	/**
	 * @return the oLD_BILL_ID
	 */
	public String getOLD_BILL_ID() {
		return OLD_BILL_ID;
	}

	/**
	 * @param oLD_BILL_ID the oLD_BILL_ID to set
	 */
	public void setOLD_BILL_ID(String oLD_BILL_ID) {
		OLD_BILL_ID = oLD_BILL_ID;
		if( _instance != null ){ ((ISAMiscStatus)_instance).setOldBillId( oLD_BILL_ID ); }
	}

	/**
	 * @return the cOMMIT_DATE
	 */
	public java.sql.Timestamp getCOMMIT_DATE() {
		return COMMIT_DATE;
	}

	/**
	 * @param cOMMIT_DATE the cOMMIT_DATE to set
	 */
	public void setCOMMIT_DATE(java.sql.Timestamp cOMMIT_DATE) {
		COMMIT_DATE = cOMMIT_DATE;
		if( _instance != null ){ ((ISAMiscStatus)_instance).setCommitDate( cOMMIT_DATE ); }
	}

	/**
	 * @return the sTS_CHG_TIME
	 */
	public java.sql.Timestamp getSTS_CHG_TIME() {
		return STS_CHG_TIME;
	}

	/**
	 * @param sTS_CHG_TIME the sTS_CHG_TIME to set
	 */
	public void setSTS_CHG_TIME(java.sql.Timestamp sTS_CHG_TIME) {
		STS_CHG_TIME = sTS_CHG_TIME;
		if( _instance != null ){ ((ISAMiscStatus)_instance).setStsChgTime( sTS_CHG_TIME ); }
	}

	/**
	 * @return the sTS_OPR_TIME
	 */
	public java.sql.Timestamp getSTS_OPR_TIME() {
		return STS_OPR_TIME;
	}

	/**
	 * @param sTS_OPR_TIME the sTS_OPR_TIME to set
	 */
	public void setSTS_OPR_TIME(java.sql.Timestamp sTS_OPR_TIME) {
		STS_OPR_TIME = sTS_OPR_TIME;
		if( _instance != null ){ ((ISAMiscStatus)_instance).setStsOprTime( sTS_OPR_TIME ); }
	}

	/**
	 * @return the dONE_CODE
	 */
	public long getDONE_CODE() {
		return DONE_CODE;
	}

	/**
	 * @param dONE_CODE the dONE_CODE to set
	 */
	public void setDONE_CODE(long dONE_CODE) {
		DONE_CODE = dONE_CODE;
		if( _instance != null ){ ((ISAMiscStatus)_instance).setDoneCode( dONE_CODE ); }
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
		if( _instance != null ){ ((ISAMiscStatus)_instance).setDoneDate( dONE_DATE ); }
	}

	/**
	 * @return the rEV1
	 */
	public String getREV1() {
		return REV1;
	}

	/**
	 * @param rEV1 the rEV1 to set
	 */
	public void setREV1(String rEV1) {
		REV1 = rEV1;
		if( _instance != null ){ ((ISAMiscStatus)_instance).setRev1( rEV1 ); }
	}

	/**
	 * @return the rEV2
	 */
	public long getREV2() {
		return REV2;
	}

	/**
	 * @param rEV2 the rEV2 to set
	 */
	public void setREV2(long rEV2) {
		REV2 = rEV2;
		if( _instance != null ){ ((ISAMiscStatus)_instance).setRev2( rEV2 ); }
	}

	/**
	 * @return the rEV3
	 */
	public String getREV3() {
		return REV3;
	}

	/**
	 * @param rEV3 the rEV3 to set
	 */
	public void setREV3(String rEV3) {
		REV3 = rEV3;
		if( _instance != null ){ ((ISAMiscStatus)_instance).setRev3( rEV3 ); }
	}

	/**
	 * @return the rEMARK
	 */
	public String getREMARK() {
		return REMARK;
	}

	/**
	 * @param rEMARK the rEMARK to set
	 */
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
		if( _instance != null ){ ((ISAMiscStatus)_instance).setRemark( rEMARK ); }
	}

	/**
	 * 
	 * @return
	 */
	public ISAMiscStatus getOsStatus(){
		return (ISAMiscStatus)_instance;
	}

}
