package com.ai.sacenter.provision.valuebean;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.provision.bo.ISAProvisionReset;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 异步应答工单</p>
 * <p>Copyright: Copyright (c) 2014-9-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfwmCouple implements java.io.Serializable{
	private static final long serialVersionUID = -3789222938257285252L;
	private long   PS_ID          ;
	private long   USER_ID        ;
	private String BILL_ID        ;
	private java.sql.Timestamp CREATE_DATE    ;
	private String REGION_ID      ;
	private String REGION_CODE    ;
	private String PS_PARAM       ;
	private String TARGET_PARAM   ;
	private int    PS_STATUS      ;
	private String FAIL_CODE      ;
	private String FAIL_DEVICE    ;
	private String FAIL_REASON    ;
	private String FAIL_LOG       ;
	private java.sql.Timestamp START_DATE     ;
	private java.sql.Timestamp END_DATE       ;
	private java.sql.Timestamp RET_DATE       ;
	private DataStructInterface INSTANCE = null;
	public IOVUpfwmCouple() {
		super();
	}

	public IOVUpfwmCouple( ISAProvisionReset provision ) throws Exception{
		super();
		PS_ID        = provision.getPsId       ();
		BILL_ID      = provision.getBillId     ();
		CREATE_DATE  = provision.getCreateDate ();
		REGION_ID    = provision.getRegionId   ();
		REGION_CODE  = provision.getRegionId   ();
		PS_PARAM     = provision.getPsParam    ();
		TARGET_PARAM = provision.getTargetParam();
		START_DATE   = provision.getStartDate  ();
		END_DATE     = provision.getEndDate    ();
		RET_DATE     = provision.getRetDate    ();
		PS_STATUS    = provision.getPsStatus   ();
		FAIL_CODE    = provision.getFailCode   ();
		FAIL_DEVICE  = provision.getFailDevice ();
		FAIL_REASON  = provision.getFailReason ();
		FAIL_LOG     = provision.getFailLog    ();
		INSTANCE     = provision                 ;
		INSTANCE.setStsToOld();
	}
	
	/**
	 * @return the bILL_ID
	 */
	public String getBILL_ID() {
		return BILL_ID;
	}

	/**
	 * @param bill_id the bILL_ID to set
	 */
	public void setBILL_ID(String bill_id) {
		BILL_ID = bill_id;
	}

	/**
	 * @return the cREATE_DATE
	 */
	public java.sql.Timestamp getCREATE_DATE() {
		return CREATE_DATE;
	}

	/**
	 * @param create_date the cREATE_DATE to set
	 */
	public void setCREATE_DATE(java.sql.Timestamp create_date) {
		CREATE_DATE = create_date;
	}

	/**
	 * @return the eND_DATE
	 */
	public java.sql.Timestamp getEND_DATE() {
		return END_DATE;
	}

	/**
	 * @param end_date the eND_DATE to set
	 */
	public void setEND_DATE(java.sql.Timestamp end_date) {
		END_DATE = end_date;
	}

	/**
	 * @return the fAIL_CODE
	 */
	public String getFAIL_CODE() {
		return FAIL_CODE;
	}

	/**
	 * @param fail_code the fAIL_CODE to set
	 */
	public void setFAIL_CODE(String fail_code) {
		FAIL_CODE = fail_code;
	}

	/**
	 * @return the fAIL_DEVICE
	 */
	public String getFAIL_DEVICE() {
		return FAIL_DEVICE;
	}

	/**
	 * @param fail_device the fAIL_DEVICE to set
	 */
	public void setFAIL_DEVICE(String fail_device) {
		FAIL_DEVICE = fail_device;
	}

	/**
	 * @return the fAIL_LOG
	 */
	public String getFAIL_LOG() {
		return FAIL_LOG;
	}

	/**
	 * @param fail_log the fAIL_LOG to set
	 */
	public void setFAIL_LOG(String fail_log) {
		FAIL_LOG = fail_log;
	}

	/**
	 * @return the fAIL_REASON
	 */
	public String getFAIL_REASON() {
		return FAIL_REASON;
	}

	/**
	 * @param fail_reason the fAIL_REASON to set
	 */
	public void setFAIL_REASON(String fail_reason) {
		FAIL_REASON = fail_reason;
	}

	/**
	 * @return the pS_ID
	 */
	public long getPS_ID() {
		return PS_ID;
	}

	/**
	 * @param ps_id the pS_ID to set
	 */
	public void setPS_ID(long ps_id) {
		PS_ID = ps_id;
	}

	/**
	 * @return the pS_PARAM
	 */
	public String getPS_PARAM() {
		return PS_PARAM;
	}

	/**
	 * @param ps_param the pS_PARAM to set
	 */
	public void setPS_PARAM(String ps_param) {
		PS_PARAM = ps_param;
	}

	/**
	 * @return the pS_STATUS
	 */
	public int getPS_STATUS() {
		return PS_STATUS;
	}

	/**
	 * @param ps_status the pS_STATUS to set
	 */
	public void setPS_STATUS(int ps_status) {
		PS_STATUS = ps_status;
	}

	/**
	 * @return the rEGION_ID
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}

	/**
	 * @param region_id the rEGION_ID to set
	 */
	public void setREGION_ID(String region_id) {
		REGION_ID = region_id;
	}

	/**
	 * @return the rEGION_CODE
	 */
	public String getREGION_CODE() {
		return REGION_CODE;
	}

	/**
	 * @param rEGION_CODE the rEGION_CODE to set
	 */
	public void setREGION_CODE(String rEGION_CODE) {
		REGION_CODE = rEGION_CODE;
	}

	/**
	 * @return the rET_DATE
	 */
	public java.sql.Timestamp getRET_DATE() {
		return RET_DATE;
	}

	/**
	 * @param ret_date the rET_DATE to set
	 */
	public void setRET_DATE(java.sql.Timestamp ret_date) {
		RET_DATE = ret_date;
	}

	/**
	 * @return the sTART_DATE
	 */
	public java.sql.Timestamp getSTART_DATE() {
		return START_DATE;
	}

	/**
	 * @param start_date the sTART_DATE to set
	 */
	public void setSTART_DATE(java.sql.Timestamp start_date) {
		START_DATE = start_date;
	}

	/**
	 * @return the tARGET_PARAM
	 */
	public String getTARGET_PARAM() {
		return TARGET_PARAM;
	}

	/**
	 * @param target_param the tARGET_PARAM to set
	 */
	public void setTARGET_PARAM(String target_param) {
		TARGET_PARAM = target_param;
	}

	/**
	 * @return the uSER_ID
	 */
	public long getUSER_ID() {
		return USER_ID;
	}

	/**
	 * @param user_id the uSER_ID to set
	 */
	public void setUSER_ID(long user_id) {
		USER_ID = user_id;
	}

	/**
	 * @return the iNSTANCE
	 */
	public DataStructInterface getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(DataStructInterface iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
}
