package com.ai.sacenter.tykt.valuebean;

import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.tykt.bo.IISAEquipment;
import com.ai.sacenter.tykt.bo.ISAEquipment;
import com.ai.sacenter.util.OracleUtils;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: 统一开通工单</p>
 * <p>Copyright: Copyright (c) 2017年12月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class IOVUpfgkmOffer extends IUpdfmxLittle implements java.io.Serializable{
	private static final long serialVersionUID = -5089538229040532477L;
	private long    PS_ID	       ;
	private long    BUSI_CODE	   ;
	private String  DONE_CODE	   ;
	private String  EXTERN_ID	   ;
	private int     PS_TYPE	       ;
	private long    PRIO_LEVEL	   ;
	private long    DEAD_LINE	   ;
	private long    SORT_ID	       ;
	private String  PS_SERVICE_TYPE;
	private long    USER_ID	       ;
	private String  BILL_ID	       ;
	private String  SUB_BILL_ID	   ;
	private long    PLAN_ID	       ;
	private java.sql.Timestamp    CREATE_DATE	   ;
	private String  REGION_ID	   ;
	private long    ACTION_ID	   ;
	private String  OLD_PS_PARAM   ;
	private String  PS_PARAM	   ;
	private String  TARGET_PARAM   ;
	private int     PS_STATUS	   ;
	private int     STOP_TYPE	   ;
	private String  PS_NET_CODE	   ;
	private long    SUB_PLAN_NO	   ;
	private String  COMPOSITE	   ;
	private long    FAIL_CODE	   ;
	private int     FAIL_NUM	   ;
	private String  FAIL_REASON	   ;
	private String  FAIL_LOG	   ;
	private java.sql.Timestamp    SUB_VALID_DATE ;
	private java.sql.Timestamp    UPP_CREATE_DATE;
	private java.sql.Timestamp    START_DATE     ;
	private java.sql.Timestamp    END_DATE	   ;
	private java.sql.Timestamp    RET_DATE	   ;
	private java.sql.Timestamp    STATUS_UPD_DATE;
	private int     MON_FLAG	   ;
	private long    HAND_ID	       ;
	private long    HAND_OP_ID	   ;
	private String  HAND_NOTES	   ;
	private long    RET_OP_ID	   ;
	private String  RET_NOTES	   ;
	private long    OP_ID	       ;
	private int     SP_ID	       ;
	private long    ORG_ID	       ;
	private long    OLD_PS_ID	   ;
	private int     ROLLBACK_FLAG  ;
	private int     ASYNC_FLAG	   ;
	private int     ACT_FLAG	   ;
	private String  PS_DEVICE_CODE ;
	private long    ACC_ID	       ;
	private String  SUB_PASSWD	   ;
	private java.sql.Timestamp    HAND_DATE	   ;
	private int     SERVICE_ID	   ;
	private String  NOTES	       ;
	private int     RETRY_TIMES	   ;
	private long    ORG_PS_ID	   ;
	private java.sql.Timestamp    ORDER_DATE	   ;
	private long    SUSPEND_PS_ID  ;
	private String  PS_SERVICE_CODE;
	private String  CURR_PROCESS   ;
	private String  NEXT_PROCESS   ;
	private int     SOURCE_ID      ;
	private int     PROD_SPEC_ID   ; 
	public IOVUpfgkmOffer() throws Exception{
		super();
		_instance = new ISAEquipment();
	}
	
	public IOVUpfgkmOffer(java.util.Map fromUpfwm) throws Exception{
		super();
		IISAEquipment provision = new ISAEquipment();
		OracleUtils.ICustom.transfer( fromUpfwm, provision );
		_readFromBottle( provision );
		provision.setStsToOld();
		_instance = provision;
	}
	
	public IOVUpfgkmOffer( IISAEquipment provision ) throws Exception{
		super( provision );
		_readFromBottle( provision );
	}
	
	public IOVUpfgkmOffer( IOVUpfgkmOffer provision ) throws Exception{
		super( provision );
		PS_ID           = provision.getPS_ID           ();
		BUSI_CODE       = provision.getBUSI_CODE       ();
		DONE_CODE       = provision.getDONE_CODE       ();
		EXTERN_ID       = provision.getEXTERN_ID       ();
		PS_TYPE	        = provision.getPS_TYPE	       ();
		PRIO_LEVEL      = provision.getPRIO_LEVEL      ();
		DEAD_LINE       = provision.getDEAD_LINE       ();
		SORT_ID	        = provision.getSORT_ID	       ();
		PS_SERVICE_TYPE = provision.getPS_SERVICE_TYPE ();
		USER_ID	        = provision.getUSER_ID	       ();
		BILL_ID	        = provision.getBILL_ID	       ();
		SUB_BILL_ID     = provision.getSUB_BILL_ID     ();
		PLAN_ID	        = provision.getPLAN_ID	       ();
		CREATE_DATE     = provision.getCREATE_DATE     ();
		REGION_ID       = provision.getREGION_ID       ();
		ACTION_ID       = provision.getACTION_ID       ();
		OLD_PS_PARAM    = provision.getOLD_PS_PARAM    ();
		PS_PARAM        = provision.getPS_PARAM        ();
		TARGET_PARAM    = provision.getTARGET_PARAM    ();
		PS_STATUS       = provision.getPS_STATUS       ();
		STOP_TYPE       = provision.getSTOP_TYPE       ();
		PS_NET_CODE     = provision.getPS_NET_CODE     ();
		SUB_PLAN_NO     = provision.getSUB_PLAN_NO     ();
		COMPOSITE       = provision.getCOMPOSITE       ();
		FAIL_CODE       = provision.getFAIL_CODE       ();
		FAIL_NUM        = provision.getFAIL_NUM        ();
		FAIL_REASON     = provision.getFAIL_REASON     ();
		FAIL_LOG        = provision.getFAIL_LOG        ();
		SUB_VALID_DATE  = provision.getSUB_VALID_DATE  ();
		UPP_CREATE_DATE = provision.getUPP_CREATE_DATE ();
		START_DATE      = provision.getSTART_DATE      ();
		END_DATE        = provision.getEND_DATE        ();
		RET_DATE        = provision.getRET_DATE        ();
		STATUS_UPD_DATE = provision.getSTATUS_UPD_DATE ();
		MON_FLAG        = provision.getMON_FLAG        ();
		HAND_ID	        = provision.getHAND_ID	       ();
		HAND_OP_ID      = provision.getHAND_OP_ID      ();
		HAND_NOTES      = provision.getHAND_NOTES      ();
		RET_OP_ID       = provision.getRET_OP_ID       ();
		RET_NOTES       = provision.getRET_NOTES       ();
		OP_ID	        = provision.getOP_ID	       ();
		SP_ID	        = provision.getSP_ID	       ();
		ORG_ID	        = provision.getORG_ID	       ();
		OLD_PS_ID       = provision.getOLD_PS_ID       ();
		ROLLBACK_FLAG   = provision.getROLLBACK_FLAG   ();
		ASYNC_FLAG      = provision.getASYNC_FLAG      ();
		ACT_FLAG        = provision.getACT_FLAG        ();
		PS_DEVICE_CODE  = provision.getPS_DEVICE_CODE  ();
		ACC_ID	        = provision.getACC_ID	       ();
		SUB_PASSWD      = provision.getSUB_PASSWD      ();
		HAND_DATE       = provision.getHAND_DATE       ();
		SERVICE_ID      = provision.getSERVICE_ID      ();
		NOTES	        = provision.getNOTES	       ();
		RETRY_TIMES     = provision.getRETRY_TIMES     ();
		ORG_PS_ID       = provision.getORG_PS_ID       ();
		ORDER_DATE      = provision.getORDER_DATE      ();
		SUSPEND_PS_ID   = provision.getSUSPEND_PS_ID   ();
		PS_SERVICE_CODE = provision.getPS_SERVICE_CODE ();
		CURR_PROCESS    = provision.getCURR_PROCESS    ();
		NEXT_PROCESS    = provision.getNEXT_PROCESS    ();
		SOURCE_ID       = provision.getSOURCE_ID       ();
		PROD_SPEC_ID    = provision.getPROD_SPEC_ID    ();
	}
	
	/**
	 * 
	 * @param provision
	 * @throws Exception
	 */
	private void _readFromBottle( IISAEquipment provision ) throws Exception{
		PS_ID           = provision.getPsId           ();
		BUSI_CODE       = provision.getBusiCode       ();
		DONE_CODE       = provision.getDoneCode       ();
		EXTERN_ID       = provision.getExternId       ();
		PS_TYPE	        = provision.getPsType 	      ();
		PRIO_LEVEL      = provision.getPrioLevel      ();
		DEAD_LINE       = provision.getDeadLine       ();
		SORT_ID	        = provision.getSortId	      ();
		PS_SERVICE_TYPE = provision.getPsServiceType  ();
		USER_ID	        = provision.getSubId	      ();
		BILL_ID	        = provision.getBillId	      ();
		SUB_BILL_ID     = provision.getSubBillId      ();
		PLAN_ID	        = provision.getPlanId	      ();
		CREATE_DATE     = provision.getCreateDate     ();
		REGION_ID       = provision.getRegionCode     ();
		ACTION_ID       = provision.getActionId       ();
		OLD_PS_PARAM    = provision.getOldPsParam     ();
		PS_PARAM        = provision.getPsParam        ();
		TARGET_PARAM    = provision.getTargetParam    ();
		PS_STATUS       = provision.getPsStatus       ();
		STOP_TYPE       = 0                             ;
		if( provision.get( IISAEquipment.S_StopType ) != null ){
			STOP_TYPE   = provision.getStopType() + 1  ;
		}
		PS_NET_CODE     = provision.getPsNetCode      ();
		SUB_PLAN_NO     = provision.getSubPlanNo      ();
		COMPOSITE       = provision.getComposite      ();
		FAIL_CODE       = provision.getFailCode       ();
		FAIL_NUM        = provision.getFailNum        ();
		FAIL_REASON     = provision.getFailReason     ();
		FAIL_LOG        = provision.getFailLog        ();
		SUB_VALID_DATE  = provision.getSubValidDate   ();
		UPP_CREATE_DATE = provision.getUppCreateDate  ();
		START_DATE      = provision.getStartDate      ();
		END_DATE        = provision.getEndDate        ();
		RET_DATE        = provision.getRetDate        ();
		STATUS_UPD_DATE = provision.getStatusUpdDate  ();
		MON_FLAG        = provision.getMonFlag        ();
		HAND_ID	        = provision.getHandId 	      ();
		HAND_OP_ID      = provision.getHandOpId       ();
		HAND_NOTES      = provision.getHandNotes      ();
		RET_OP_ID       = provision.getRetOpId        ();
		RET_NOTES       = provision.getRetNotes       ();
		OP_ID	        = provision.getOpId	          ();
		SP_ID	        = provision.getSpId	          ();
		ORG_ID	        = provision.getOrgId	      ();
		OLD_PS_ID       = provision.getOldPsId        ();
		ROLLBACK_FLAG   = provision.getRollbackFlag   ();
		ASYNC_FLAG      = provision.getAsyncFlag      ();
		ACT_FLAG        = provision.getActFlag        ();
		PS_DEVICE_CODE  = provision.getPsDeviceCode   ();
		ACC_ID	        = provision.getAccId	      ();
		SUB_PASSWD      = provision.getSubPasswd      ();
		HAND_DATE       = provision.getHandDate       ();
		SERVICE_ID      = provision.getServiceId      ();
		NOTES	        = provision.getNotes	      ();
		RETRY_TIMES     = provision.getRetryTimes     ();
		ORG_PS_ID       = provision.getOrgPsId        ();
		ORDER_DATE      = provision.getOrderDate      ();
		SUSPEND_PS_ID   = provision.getSuspendPsId    ();
		PS_SERVICE_CODE = provision.getPsServiceCode  ();
		CURR_PROCESS    = provision.getCurrProcess    ();
		NEXT_PROCESS    = provision.getNextProcess    ();
		SOURCE_ID       = provision.getSourceId       ();
		PROD_SPEC_ID    = provision.getProdSpecId     ();
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
		if( _instance != null ){ ((IISAEquipment)_instance).setPsId( pS_ID );}
	}

	/**
	 * @return the bUSI_CODE
	 */
	public long getBUSI_CODE() {
		return BUSI_CODE;
	}

	/**
	 * @param bUSI_CODE the bUSI_CODE to set
	 */
	public void setBUSI_CODE(long bUSI_CODE) {
		BUSI_CODE = bUSI_CODE;
		if( _instance != null ){ ((IISAEquipment)_instance).setBusiCode( bUSI_CODE );}
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
		if( _instance != null ){ ((IISAEquipment)_instance).setDoneCode( dONE_CODE );}
	}

	/**
	 * @return the eXTERN_ID
	 */
	public String getEXTERN_ID() {
		return EXTERN_ID;
	}

	/**
	 * @param eXTERN_ID the eXTERN_ID to set
	 */
	public void setEXTERN_ID(String eXTERN_ID) {
		EXTERN_ID = eXTERN_ID;
		if( _instance != null ){ ((IISAEquipment)_instance).setExternId( eXTERN_ID );}
	}

	/**
	 * @return the pS_TYPE
	 */
	public int getPS_TYPE() {
		return PS_TYPE;
	}

	/**
	 * @param pS_TYPE the pS_TYPE to set
	 */
	public void setPS_TYPE(int pS_TYPE) {
		PS_TYPE = pS_TYPE;
		if (_instance != null) {((IISAEquipment)_instance).setPsType(pS_TYPE); }
	}

	/**
	 * @return the pRIO_LEVEL
	 */
	public long getPRIO_LEVEL() {
		return PRIO_LEVEL;
	}

	/**
	 * @param pRIO_LEVEL the pRIO_LEVEL to set
	 */
	public void setPRIO_LEVEL(long pRIO_LEVEL) {
		PRIO_LEVEL = pRIO_LEVEL;
		if (_instance != null) {((IISAEquipment)_instance).setPrioLevel(pRIO_LEVEL);}
	}

	/**
	 * @return the dEAD_LINE
	 */
	public long getDEAD_LINE() {
		return DEAD_LINE;
	}

	/**
	 * @param dEAD_LINE the dEAD_LINE to set
	 */
	public void setDEAD_LINE(long dEAD_LINE) {
		DEAD_LINE = dEAD_LINE;
		if (_instance != null) {((IISAEquipment)_instance).setDeadLine(dEAD_LINE);}
	}

	/**
	 * @return the sORT_ID
	 */
	public long getSORT_ID() {
		return SORT_ID;
	}

	/**
	 * @param sORT_ID the sORT_ID to set
	 */
	public void setSORT_ID(long sORT_ID) {
		SORT_ID = sORT_ID;
		if (_instance != null) {((IISAEquipment)_instance).setSortId(sORT_ID);}
	}

	/**
	 * @return the pS_SERVICE_TYPE
	 */
	public String getPS_SERVICE_TYPE() {
		return PS_SERVICE_TYPE;
	}

	/**
	 * @param pS_SERVICE_TYPE the pS_SERVICE_TYPE to set
	 */
	public void setPS_SERVICE_TYPE(String pS_SERVICE_TYPE) {
		PS_SERVICE_TYPE = pS_SERVICE_TYPE;
		if (_instance != null) {((IISAEquipment)_instance).setPsServiceType(pS_SERVICE_TYPE);}
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
		if (_instance != null) {((IISAEquipment)_instance).setSubId(uSER_ID);}
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
		if (_instance != null) {((IISAEquipment)_instance).setBillId(bILL_ID);}
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
		if (_instance != null) {((IISAEquipment)_instance).setSubBillId(sUB_BILL_ID);}
	}

	/**
	 * @return the pLAN_ID
	 */
	public long getPLAN_ID() {
		return PLAN_ID;
	}

	/**
	 * @param pLAN_ID the pLAN_ID to set
	 */
	public void setPLAN_ID(long pLAN_ID) {
		PLAN_ID = pLAN_ID;
		if (_instance != null) {((IISAEquipment)_instance).setPlanId(pLAN_ID);}
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
		if (_instance != null) {((IISAEquipment)_instance).setCreateDate(cREATE_DATE);}
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
		if (_instance != null) {((IISAEquipment)_instance).setRegionCode(rEGION_ID);}
	}

	/**
	 * @return the aCTION_ID
	 */
	public long getACTION_ID() {
		return ACTION_ID;
	}

	/**
	 * @param aCTION_ID the aCTION_ID to set
	 */
	public void setACTION_ID(long aCTION_ID) {
		ACTION_ID = aCTION_ID;
		if (_instance != null) {((IISAEquipment)_instance).setActionId(aCTION_ID);}
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
		if (_instance != null) { ((IISAEquipment)_instance).setOldPsParam(oLD_PS_PARAM); }
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
		if (_instance != null) {((IISAEquipment)_instance).setPsParam(pS_PARAM);}
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
		if (_instance != null) { ((IISAEquipment)_instance).setTargetParam(tARGET_PARAM); }
	}

	/**
	 * @return the pS_STATUS
	 */
	public int getPS_STATUS() {
		return PS_STATUS;
	}

	/**
	 * @param pS_STATUS the pS_STATUS to set
	 */
	public void setPS_STATUS(int pS_STATUS) {
		PS_STATUS = pS_STATUS;
		if (_instance != null) { ((IISAEquipment)_instance).setPsStatus(pS_STATUS); }
	}

	/**
	 * @return the sTOP_TYPE
	 */
	public int getSTOP_TYPE() {
		return STOP_TYPE;
	}

	/**
	 * @param sTOP_TYPE the sTOP_TYPE to set
	 */
	public void setSTOP_TYPE(int sTOP_TYPE) {
		STOP_TYPE = sTOP_TYPE;
		if (_instance != null && sTOP_TYPE > 0 ) { ((IISAEquipment)_instance).setStopType( sTOP_TYPE -  1 ); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setPsNetCode(pS_NET_CODE); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setSubPlanNo(sUB_PLAN_NO); }
	}

	/**
	 * @return the cOMPOSITE
	 */
	public String getCOMPOSITE() {
		return COMPOSITE;
	}

	/**
	 * @param cOMPOSITE the cOMPOSITE to set
	 */
	public void setCOMPOSITE(String cOMPOSITE) {
		COMPOSITE = cOMPOSITE;
		if (_instance != null) { ((IISAEquipment)_instance).setComposite(cOMPOSITE); }
	}

	/**
	 * @return the fAIL_CODE
	 */
	public long getFAIL_CODE() {
		return FAIL_CODE;
	}

	/**
	 * @param fAIL_CODE the fAIL_CODE to set
	 */
	public void setFAIL_CODE(long fAIL_CODE) {
		FAIL_CODE = fAIL_CODE;
		if (_instance != null) { ((IISAEquipment)_instance).setFailCode(fAIL_CODE); }
	}

	/**
	 * @return the fAIL_NUM
	 */
	public int getFAIL_NUM() {
		return FAIL_NUM;
	}

	/**
	 * @param fAIL_NUM the fAIL_NUM to set
	 */
	public void setFAIL_NUM(int fAIL_NUM) {
		FAIL_NUM = fAIL_NUM;
		if (_instance != null) { ((IISAEquipment)_instance).setFailNum(fAIL_NUM); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setFailReason(fAIL_REASON); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setFailLog(fAIL_LOG); }
	}

	/**
	 * @return the sUB_VALID_DATE
	 */
	public java.sql.Timestamp getSUB_VALID_DATE() {
		return SUB_VALID_DATE;
	}

	/**
	 * @param sUB_VALID_DATE the sUB_VALID_DATE to set
	 */
	public void setSUB_VALID_DATE(java.sql.Timestamp sUB_VALID_DATE) {
		SUB_VALID_DATE = sUB_VALID_DATE;
		if (_instance != null) { ((IISAEquipment)_instance).setSubValidDate(sUB_VALID_DATE); }
	}

	/**
	 * @return the uPP_CREATE_DATE
	 */
	public java.sql.Timestamp getUPP_CREATE_DATE() {
		return UPP_CREATE_DATE;
	}

	/**
	 * @param uPP_CREATE_DATE the uPP_CREATE_DATE to set
	 */
	public void setUPP_CREATE_DATE(java.sql.Timestamp uPP_CREATE_DATE) {
		UPP_CREATE_DATE = uPP_CREATE_DATE;
		if (_instance != null) { ((IISAEquipment)_instance).setUppCreateDate(uPP_CREATE_DATE); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setStartDate(sTART_DATE); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setEndDate(eND_DATE); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setRetDate(rET_DATE); }
	}

	/**
	 * @return the sTATUS_UPD_DATE
	 */
	public java.sql.Timestamp getSTATUS_UPD_DATE() {
		return STATUS_UPD_DATE;
	}

	/**
	 * @param sTATUS_UPD_DATE the sTATUS_UPD_DATE to set
	 */
	public void setSTATUS_UPD_DATE(java.sql.Timestamp sTATUS_UPD_DATE) {
		STATUS_UPD_DATE = sTATUS_UPD_DATE;
		if (_instance != null) { ((IISAEquipment)_instance).setStatusUpdDate(sTATUS_UPD_DATE); }
	}

	/**
	 * @return the mON_FLAG
	 */
	public int getMON_FLAG() {
		return MON_FLAG;
	}

	/**
	 * @param mON_FLAG the mON_FLAG to set
	 */
	public void setMON_FLAG(int mON_FLAG) {
		MON_FLAG = mON_FLAG;
		if (_instance != null) { ((IISAEquipment)_instance).setMonFlag(mON_FLAG); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setHandId(hAND_ID); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setHandOpId(hAND_OP_ID); }
	}

	/**
	 * @return the hAND_NOTES
	 */
	public String getHAND_NOTES() {
		return HAND_NOTES;
	}

	/**
	 * @param hAND_NOTES the hAND_NOTES to set
	 */
	public void setHAND_NOTES(String hAND_NOTES) {
		HAND_NOTES = hAND_NOTES;
		if (_instance != null) { ((IISAEquipment)_instance).setHandNotes(hAND_NOTES); }
	}

	/**
	 * @return the rET_OP_ID
	 */
	public long getRET_OP_ID() {
		return RET_OP_ID;
	}

	/**
	 * @param rET_OP_ID the rET_OP_ID to set
	 */
	public void setRET_OP_ID(long rET_OP_ID) {
		RET_OP_ID = rET_OP_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setRetOpId(rET_OP_ID); }
	}

	/**
	 * @return the rET_NOTES
	 */
	public String getRET_NOTES() {
		return RET_NOTES;
	}

	/**
	 * @param rET_NOTES the rET_NOTES to set
	 */
	public void setRET_NOTES(String rET_NOTES) {
		RET_NOTES = rET_NOTES;
		if (_instance != null) { ((IISAEquipment)_instance).setRetNotes(rET_NOTES); }
	}

	/**
	 * @return the oP_ID
	 */
	public long getOP_ID() {
		return OP_ID;
	}

	/**
	 * @param oP_ID the oP_ID to set
	 */
	public void setOP_ID(long oP_ID) {
		OP_ID = oP_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setOpId(oP_ID); }
	}

	/**
	 * @return the sP_ID
	 */
	public int getSP_ID() {
		return SP_ID;
	}

	/**
	 * @param sP_ID the sP_ID to set
	 */
	public void setSP_ID(int sP_ID) {
		SP_ID = sP_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setSpId(sP_ID); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setOrgId(oRG_ID); }
	}

	/**
	 * @return the oLD_PS_ID
	 */
	public long getOLD_PS_ID() {
		return OLD_PS_ID;
	}

	/**
	 * @param oLD_PS_ID the oLD_PS_ID to set
	 */
	public void setOLD_PS_ID(long oLD_PS_ID) {
		OLD_PS_ID = oLD_PS_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setOldPsId(oLD_PS_ID); }
	}

	/**
	 * @return the rOLLBACK_FLAG
	 */
	public int getROLLBACK_FLAG() {
		return ROLLBACK_FLAG;
	}

	/**
	 * @param rOLLBACK_FLAG the rOLLBACK_FLAG to set
	 */
	public void setROLLBACK_FLAG(int rOLLBACK_FLAG) {
		ROLLBACK_FLAG = rOLLBACK_FLAG;
		if (_instance != null) { ((IISAEquipment)_instance).setRollbackFlag(rOLLBACK_FLAG); }
	}

	/**
	 * @return the aSYNC_FLAG
	 */
	public int getASYNC_FLAG() {
		return ASYNC_FLAG;
	}

	/**
	 * @param aSYNC_FLAG the aSYNC_FLAG to set
	 */
	public void setASYNC_FLAG(int aSYNC_FLAG) {
		ASYNC_FLAG = aSYNC_FLAG;
		if (_instance != null) { ((IISAEquipment)_instance).setAsyncFlag(aSYNC_FLAG); }
	}

	/**
	 * @return the aCT_FLAG
	 */
	public int getACT_FLAG() {
		return ACT_FLAG;
	}

	/**
	 * @param aCT_FLAG the aCT_FLAG to set
	 */
	public void setACT_FLAG(int aCT_FLAG) {
		ACT_FLAG = aCT_FLAG;
		if (_instance != null) { ((IISAEquipment)_instance).setActFlag(aCT_FLAG); }
	}

	/**
	 * @return the pS_DEVICE_CODE
	 */
	public String getPS_DEVICE_CODE() {
		return PS_DEVICE_CODE;
	}

	/**
	 * @param pS_DEVICE_CODE the pS_DEVICE_CODE to set
	 */
	public void setPS_DEVICE_CODE(String pS_DEVICE_CODE) {
		PS_DEVICE_CODE = pS_DEVICE_CODE;
		if (_instance != null) { ((IISAEquipment)_instance).setPsDeviceCode(pS_DEVICE_CODE); }
	}

	/**
	 * @return the aCC_ID
	 */
	public long getACC_ID() {
		return ACC_ID;
	}

	/**
	 * @param aCC_ID the aCC_ID to set
	 */
	public void setACC_ID(long aCC_ID) {
		ACC_ID = aCC_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setAccId(aCC_ID); }
	}

	/**
	 * @return the sUB_PASSWD
	 */
	public String getSUB_PASSWD() {
		return SUB_PASSWD;
	}

	/**
	 * @param sUB_PASSWD the sUB_PASSWD to set
	 */
	public void setSUB_PASSWD(String sUB_PASSWD) {
		SUB_PASSWD = sUB_PASSWD;
		if (_instance != null) { ((IISAEquipment)_instance).setSubPasswd(sUB_PASSWD); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setHandDate(hAND_DATE); }
	}

	/**
	 * @return the sERVICE_ID
	 */
	public int getSERVICE_ID() {
		return SERVICE_ID;
	}

	/**
	 * @param sERVICE_ID the sERVICE_ID to set
	 */
	public void setSERVICE_ID(int sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setServiceId(sERVICE_ID); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setNotes(nOTES); }
	}

	/**
	 * @return the rETRY_TIMES
	 */
	public int getRETRY_TIMES() {
		return RETRY_TIMES;
	}

	/**
	 * @param rETRY_TIMES the rETRY_TIMES to set
	 */
	public void setRETRY_TIMES(int rETRY_TIMES) {
		RETRY_TIMES = rETRY_TIMES;
		if (_instance != null) { ((IISAEquipment)_instance).setRetryTimes(rETRY_TIMES); }
	}

	/**
	 * @return the oRG_PS_ID
	 */
	public long getORG_PS_ID() {
		return ORG_PS_ID;
	}

	/**
	 * @param oRG_PS_ID the oRG_PS_ID to set
	 */
	public void setORG_PS_ID(long oRG_PS_ID) {
		ORG_PS_ID = oRG_PS_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setOrgPsId(oRG_PS_ID); }
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
		if (_instance != null) { ((IISAEquipment)_instance).setOrderDate(oRDER_DATE); }
	}

	/**
	 * @return the sUSPEND_PS_ID
	 */
	public long getSUSPEND_PS_ID() {
		return SUSPEND_PS_ID;
	}

	/**
	 * @param sUSPEND_PS_ID the sUSPEND_PS_ID to set
	 */
	public void setSUSPEND_PS_ID(long sUSPEND_PS_ID) {
		SUSPEND_PS_ID = sUSPEND_PS_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setSuspendPsId(sUSPEND_PS_ID); }
	}

	/**
	 * @return the pS_SERVICE_CODE
	 */
	public String getPS_SERVICE_CODE() {
		return PS_SERVICE_CODE;
	}

	/**
	 * @param pS_SERVICE_CODE the pS_SERVICE_CODE to set
	 */
	public void setPS_SERVICE_CODE(String pS_SERVICE_CODE) {
		PS_SERVICE_CODE = pS_SERVICE_CODE;
		if (_instance != null) { ((IISAEquipment)_instance).setPsServiceCode(pS_SERVICE_CODE); }
	}

	/**
	 * @return the cURR_PROCESS
	 */
	public String getCURR_PROCESS() {
		return CURR_PROCESS;
	}

	/**
	 * @param cURR_PROCESS the cURR_PROCESS to set
	 */
	public void setCURR_PROCESS(String cURR_PROCESS) {
		CURR_PROCESS = cURR_PROCESS;
		if (_instance != null) { ((IISAEquipment)_instance).setCurrProcess(cURR_PROCESS); }
	}

	/**
	 * @return the nEXT_PROCESS
	 */
	public String getNEXT_PROCESS() {
		return NEXT_PROCESS;
	}

	/**
	 * @param nEXT_PROCESS the nEXT_PROCESS to set
	 */
	public void setNEXT_PROCESS(String nEXT_PROCESS) {
		NEXT_PROCESS = nEXT_PROCESS;
		if (_instance != null) { ((IISAEquipment)_instance).setNextProcess(nEXT_PROCESS); }
	}

	/**
	 * @return the sOURCE_ID
	 */
	public int getSOURCE_ID() {
		return SOURCE_ID;
	}

	/**
	 * @param sOURCE_ID the sOURCE_ID to set
	 */
	public void setSOURCE_ID(int sOURCE_ID) {
		SOURCE_ID = sOURCE_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setSourceId(sOURCE_ID); }
	}

	/**
	 * @return the pROD_SPEC_ID
	 */
	public int getPROD_SPEC_ID() {
		return PROD_SPEC_ID;
	}

	/**
	 * @param pROD_SPEC_ID the pROD_SPEC_ID to set
	 */
	public void setPROD_SPEC_ID(int pROD_SPEC_ID) {
		PROD_SPEC_ID = pROD_SPEC_ID;
		if (_instance != null) { ((IISAEquipment)_instance).setProdSpecId(pROD_SPEC_ID); }
	}
}
