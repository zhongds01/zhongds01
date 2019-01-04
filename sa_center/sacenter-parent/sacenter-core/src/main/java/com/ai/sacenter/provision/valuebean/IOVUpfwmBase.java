package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.bo.ISAWorkOrder;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元基础工单</p>
 * <p>Copyright: Copyright (c) 2014-12-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfwmBase extends IUpdfmxLittle implements java.io.Serializable{
	private static final long serialVersionUID = -7031060200709212931L;
	protected long   PS_ID          ;
	protected String CUST_ORDER     ;
	protected String DONE_CODE      ;
	protected long   CATALOG        ;
	protected long   BUSINESS       ;
	protected long   ORDER_ID       ;
	protected long   TASK_ID        ;
	protected String CATEGORY       ;
	protected long   USER_ID        ;
	protected String BILL_ID        ;
	protected String SUB_BILL_ID    ;
	protected String REGION_ID      ;
	protected java.sql.Timestamp CREATE_DATE    ;
	protected long   PRIORITY       ;
	protected String PLATFORM       ;
	protected String DIRECTIVE      ;
	protected String PROGRAM        ;
	protected String OLD_PS_PARAM   ;
	protected String PS_PARAM       ;
	protected String TARGET_PARAM   ;
	protected long   PS_STATUS      ;
	protected String FAIL_CODE      ;
	protected String FAIL_DEVICE    ;
	protected String FAIL_REASON    ;
	protected String FAIL_LOG       ;
	protected java.sql.Timestamp START_DATE     ;
	protected java.sql.Timestamp END_DATE       ;
	protected java.sql.Timestamp RET_DATE       ;
	protected long   STOP_TYPE      ;
	protected String PS_NET_CODE    ;
	protected long   SERVICE_ID     ;
	protected long   RETRY_TIMES    ;
	protected long   SUB_PLAN_NO    ;
	protected java.sql.Timestamp ORDER_DATE     ;
	protected String STAFF_ID       ;
	protected String ORG_ID         ;
	protected String NOTES          ;
	public IOVUpfwmBase() throws Exception{
		super();
	}
	
	public IOVUpfwmBase( IISAProvision provision ) throws Exception{
		super( provision );
		transfer( provision );
	}
	
	public IOVUpfwmBase( ISAWorkOrder provision ) throws Exception{
		super( provision );
		transfer( provision );
	}
	
	public IOVUpfwmBase( IOVUpfwmBase provision ) throws Exception{
		super( provision );
		PS_ID        = provision.PS_ID       ;
		CUST_ORDER   = provision.CUST_ORDER  ;
		DONE_CODE    = provision.DONE_CODE   ;
		CATALOG      = provision.CATALOG     ;
		BUSINESS     = provision.BUSINESS    ;
		ORDER_ID     = provision.ORDER_ID    ;
		TASK_ID      = provision.TASK_ID     ;
		CATEGORY     = provision.CATEGORY    ;
		USER_ID      = provision.USER_ID     ;
		BILL_ID      = provision.BILL_ID     ;
		SUB_BILL_ID  = provision.SUB_BILL_ID ;
		REGION_ID    = provision.REGION_ID   ;
		CREATE_DATE  = provision.CREATE_DATE ;
		PRIORITY     = provision.PRIORITY    ;
		PLATFORM     = provision.PLATFORM    ;
		DIRECTIVE    = provision.DIRECTIVE   ;
		PROGRAM      = provision.PROGRAM     ;
		OLD_PS_PARAM = provision.OLD_PS_PARAM;
		PS_PARAM     = provision.PS_PARAM    ;
		TARGET_PARAM = provision.TARGET_PARAM;
		PS_STATUS    = provision.PS_STATUS   ;
		FAIL_CODE    = provision.FAIL_CODE   ;
		FAIL_DEVICE  = provision.FAIL_DEVICE ;
		FAIL_REASON  = provision.FAIL_REASON ;
		FAIL_LOG     = provision.FAIL_LOG    ;
		START_DATE   = provision.START_DATE  ;
		END_DATE     = provision.END_DATE    ;
		RET_DATE     = provision.RET_DATE    ;
		STOP_TYPE    = provision.STOP_TYPE   ;
		PS_NET_CODE  = provision.PS_NET_CODE ;
		SERVICE_ID   = provision.SERVICE_ID  ;
		RETRY_TIMES  = provision.RETRY_TIMES ;
		SUB_PLAN_NO  = provision.SUB_PLAN_NO ;
		ORDER_DATE   = provision.ORDER_DATE  ;
		STAFF_ID     = provision.STAFF_ID    ;
		ORG_ID       = provision.ORG_ID      ;
		NOTES        = provision.NOTES       ;
	}
	
	/**
	 * @return the pS_ID
	 */
	public long getPS_ID() {
		return PS_ID;
	}
	
	/**
	 * @param pS_ID the pS_ID to set
	 */
	public void setPS_ID(long pS_ID) {
		PS_ID = pS_ID;
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
	 * @return the dONE_CODE
	 */
	public String getDONE_CODE() {
		return DONE_CODE;
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
	}
	
	/**
	 * @return the bUSINESS
	 */
	public long getBUSINESS() {
		return BUSINESS;
	}
	
	/**
	 * @param bUSINESS the bUSINESS to set
	 */
	public void setBUSINESS(long bUSINESS) {
		BUSINESS = bUSINESS;
	}
	
	/**
	 * @param dONE_CODE the dONE_CODE to set
	 */
	public void setDONE_CODE(String dONE_CODE) {
		DONE_CODE = dONE_CODE;
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
	}
	
	/**
	 * @return the tASK_ID
	 */
	public long getTASK_ID() {
		return TASK_ID;
	}
	
	/**
	 * @param tASK_ID the tASK_ID to set
	 */
	public void setTASK_ID(long tASK_ID) {
		TASK_ID = tASK_ID;
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
	}
	
	/**
	 * @return the pRIORITY
	 */
	public long getPRIORITY() {
		return PRIORITY;
	}
	
	/**
	 * @param pRIORITY the pRIORITY to set
	 */
	public void setPRIORITY(long pRIORITY) {
		PRIORITY = pRIORITY;
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
	public void setPLATFORM(String pLATFORM) throws Exception{
		PLATFORM = pLATFORM;
	}
	
	/**
	 * @return the dIRECTIVE
	 */
	public String getDIRECTIVE() {
		return DIRECTIVE;
	}
	
	/**
	 * @param dIRECTIVE the dIRECTIVE to set
	 */
	public void setDIRECTIVE(String dIRECTIVE) {
		DIRECTIVE = dIRECTIVE;
	}
	
	/**
	 * @return the pROGRAM
	 */
	public String getPROGRAM() {
		return PROGRAM;
	}
	
	/**
	 * @param pROGRAM the pROGRAM to set
	 */
	public void setPROGRAM(String pROGRAM) throws Exception{
		PROGRAM = pROGRAM;
	}
	
	/**
	 * @return the oLD_PS_PARAM
	 */
	public String getOLD_PS_PARAM() {
		return OLD_PS_PARAM;
	}
	
	/**
	 * @param oLD_PS_PARAM the oLD_PS_PARAM to set
	 */
	public void setOLD_PS_PARAM(String oLD_PS_PARAM) {
		OLD_PS_PARAM = oLD_PS_PARAM;
	}
	
	/**
	 * @return the pS_PARAM
	 */
	public String getPS_PARAM() {
		return PS_PARAM;
	}
	
	/**
	 * @param pS_PARAM the pS_PARAM to set
	 */
	public void setPS_PARAM(String pS_PARAM) {
		PS_PARAM = pS_PARAM;
	}
	
	/**
	 * @return the tARGET_PARAM
	 */
	public String getTARGET_PARAM() {
		return TARGET_PARAM;
	}
	
	/**
	 * @param tARGET_PARAM the tARGET_PARAM to set
	 */
	public void setTARGET_PARAM(String tARGET_PARAM) {
		TARGET_PARAM = tARGET_PARAM;
	}
	
	/**
	 * @return the pS_STATUS
	 */
	public long getPS_STATUS() {
		return PS_STATUS;
	}
	
	/**
	 * @param pS_STATUS the pS_STATUS to set
	 */
	public void setPS_STATUS(long pS_STATUS) {
		PS_STATUS = pS_STATUS;
	}
	
	/**
	 * @return the fAIL_CODE
	 */
	public String getFAIL_CODE() {
		if( FAIL_CODE == null && PS_STATUS != IUpfwmConst.IUpdos.CREATE ) 
			return String.valueOf( PS_STATUS );
		return FAIL_CODE;
	}
	
	/**
	 * @param fAIL_CODE the fAIL_CODE to set
	 */
	public void setFAIL_CODE(String fAIL_CODE) {
		FAIL_CODE = fAIL_CODE;
	}
	
	/**
	 * @return the fAIL_DEVICE
	 */
	public String getFAIL_DEVICE() {
		return FAIL_DEVICE;
	}
	
	/**
	 * @param fAIL_DEVICE the fAIL_DEVICE to set
	 */
	public void setFAIL_DEVICE(String fAIL_DEVICE) {
		FAIL_DEVICE = fAIL_DEVICE;
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
	}
	
	/**
	 * @return the rET_DATE
	 */
	public java.sql.Timestamp getRET_DATE() {
		return RET_DATE;
	}
	
	/**
	 * @param rET_DATE the rET_DATE to set
	 */
	public void setRET_DATE(java.sql.Timestamp rET_DATE) {
		RET_DATE = rET_DATE;
	}
	
	/**
	 * @return the sTOP_TYPE
	 */
	public long getSTOP_TYPE() {
		return STOP_TYPE;
	}
	
	/**
	 * @param sTOP_TYPE the sTOP_TYPE to set
	 */
	public void setSTOP_TYPE(long sTOP_TYPE) {
		STOP_TYPE = sTOP_TYPE;
	}
	
	/**
	 * @return the pS_NET_CODE
	 */
	public String getPS_NET_CODE() {
		return PS_NET_CODE;
	}
	
	/**
	 * @param pS_NET_CODE the pS_NET_CODE to set
	 */
	public void setPS_NET_CODE(String pS_NET_CODE) {
		PS_NET_CODE = pS_NET_CODE;
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
	}
	
	/**
	 * @return the rETRY_TIMES
	 */
	public long getRETRY_TIMES() {
		return RETRY_TIMES;
	}
	
	/**
	 * @param rETRY_TIMES the rETRY_TIMES to set
	 */
	public void setRETRY_TIMES(long rETRY_TIMES) {
		RETRY_TIMES = rETRY_TIMES;
	}
	
	/**
	 * @return the sUB_PLAN_NO
	 */
	public long getSUB_PLAN_NO() {
		return SUB_PLAN_NO;
	}
	
	/**
	 * @param sUB_PLAN_NO the sUB_PLAN_NO to set
	 */
	public void setSUB_PLAN_NO(long sUB_PLAN_NO) {
		SUB_PLAN_NO = sUB_PLAN_NO;
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
	 * @return the nOTES
	 */
	public String getNOTES() {
		return NOTES;
	}
	
	/**
	 * @param nOTES the nOTES to set
	 */
	public void setNOTES(String nOTES) {
		NOTES = nOTES;
	}
	
	/**
	 * 
	 * @param provision
	 */
	protected void transfer( IISAProvision provision ){
		try
		{
			PS_ID        = provision.getPsId       ();
			CUST_ORDER   = provision.getCustOrder  ();
			DONE_CODE    = provision.getDoneCode   ();
			ORDER_ID     = provision.getOrderId    ();
			TASK_ID      = provision.getTaskId     ();
			CATEGORY     = provision.getCategory   ();
			USER_ID      = provision.getUserId     ();
			BILL_ID      = provision.getBillId     ();
			SUB_BILL_ID  = provision.getSubBillId  ();
			REGION_ID    = provision.getRegionId   ();
			CREATE_DATE  = provision.getCreateDate ();
			PRIORITY     = provision.getPriority   ();
			PLATFORM     = provision.getPlatform   ();
			PROGRAM      = provision.getProgram    ();
			DIRECTIVE    = provision.getDirective  ();
			OLD_PS_PARAM = provision.getOldPsParam ();
			PS_PARAM     = provision.getPsParam    ();
			TARGET_PARAM = provision.getTargetParam();
			PS_STATUS    = provision.getPsStatus   ();
			FAIL_CODE    = provision.getFailCode   ();
			FAIL_DEVICE  = provision.getFailDevice ();
			FAIL_REASON  = provision.getFailReason ();
			FAIL_LOG     = provision.getFailLog    ();
			START_DATE   = provision.getStartDate  ();
			END_DATE     = provision.getEndDate    ();
			RET_DATE     = provision.getRetDate    ();
			STOP_TYPE    = provision.getStopType   ();
			PS_NET_CODE  = provision.getPsNetCode  ();
			SERVICE_ID   = provision.getServiceId  ();
			RETRY_TIMES  = provision.getRetryTimes ();
			SUB_PLAN_NO  = provision.getSubPlanNo  ();
			ORDER_DATE   = provision.getOrderDate  ();
			STAFF_ID     = provision.getStaffId    ();
			ORG_ID       = provision.getOrgId      ();
			NOTES        = provision.getNotes      ();
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param provision
	 */
	protected void transfer( ISAWorkOrder provision ){
		try
		{
			PS_ID        = provision.getPsId       ();
			CUST_ORDER   = provision.getCustOrder  ();
			DONE_CODE    = provision.getDoneCode   ();
			ORDER_ID     = provision.getOrderId    ();
			TASK_ID      = provision.getTaskId     ();
			CATEGORY     = provision.getCategory   ();
			USER_ID      = provision.getUserId     ();
			BILL_ID      = provision.getBillId     ();
			SUB_BILL_ID  = provision.getSubBillId  ();
			REGION_ID    = provision.getRegionId   ();
			CREATE_DATE  = provision.getCreateDate ();
			PRIORITY     = provision.getPriority   ();
			PLATFORM     = provision.getPlatform   ();
			PROGRAM      = provision.getProgram    ();
			DIRECTIVE    = provision.getDirective  ();
			OLD_PS_PARAM = provision.getOldPsParam ();
			PS_PARAM     = provision.getPsParam    ();
			TARGET_PARAM = provision.getTargetParam();
			PS_STATUS    = provision.getPsStatus   ();
			FAIL_CODE    = provision.getFailCode   ();
			FAIL_DEVICE  = provision.getFailDevice ();
			FAIL_REASON  = provision.getFailReason ();
			FAIL_LOG     = provision.getFailLog    ();
			START_DATE   = provision.getStartDate  ();
			END_DATE     = provision.getEndDate    ();
			RET_DATE     = provision.getRetDate    ();
			STOP_TYPE    = provision.getStopType   ();
			PS_NET_CODE  = provision.getPsNetCode  ();
			SERVICE_ID   = provision.getServiceId  ();
			RETRY_TIMES  = provision.getRetryTimes ();
			SUB_PLAN_NO  = provision.getSubPlanNo  ();
			ORDER_DATE   = provision.getOrderDate  ();
			STAFF_ID     = provision.getStaffId    ();
			ORG_ID       = provision.getOrgId      ();
			NOTES        = provision.getNotes      ();
		}
		finally{
			
		}
	}
}
