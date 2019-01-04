package com.ai.sacenter.tykt.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISAEquipmentReset extends DataStructInterface{

  public final static  String S_PrioLevel = "PRIO_LEVEL";
  public final static  String S_PsType = "PS_TYPE";
  public final static  String S_RollbackFlag = "ROLLBACK_FLAG";
  public final static  String S_AccId = "ACC_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_SuspendPsId = "SUSPEND_PS_ID";
  public final static  String S_TargetParam = "TARGET_PARAM";
  public final static  String S_CurrProcess = "CURR_PROCESS";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_HandNotes = "HAND_NOTES";
  public final static  String S_SpId = "SP_ID";
  public final static  String S_HandDate = "HAND_DATE";
  public final static  String S_HandOpId = "HAND_OP_ID";
  public final static  String S_PsServiceType = "PS_SERVICE_TYPE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_PsParam = "PS_PARAM";
  public final static  String S_ServiceId = "SERVICE_ID";
  public final static  String S_PsStatus = "PS_STATUS";
  public final static  String S_AsyncFlag = "ASYNC_FLAG";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_RetryTimes = "RETRY_TIMES";
  public final static  String S_PlanId = "PLAN_ID";
  public final static  String S_PsNetCode = "PS_NET_CODE";
  public final static  String S_OldPsParam = "OLD_PS_PARAM";
  public final static  String S_ActionId = "ACTION_ID";
  public final static  String S_FailNum = "FAIL_NUM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_PsDeviceCode = "PS_DEVICE_CODE";
  public final static  String S_SubValidDate = "SUB_VALID_DATE";
  public final static  String S_RetOpId = "RET_OP_ID";
  public final static  String S_ActFlag = "ACT_FLAG";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_RetDate = "RET_DATE";
  public final static  String S_UppCreateDate = "UPP_CREATE_DATE";
  public final static  String S_ExternId = "EXTERN_ID";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_Notes = "NOTES";
  public final static  String S_StopType = "STOP_TYPE";
  public final static  String S_DeadLine = "DEAD_LINE";
  public final static  String S_OldPsId = "OLD_PS_ID";
  public final static  String S_RetNotes = "RET_NOTES";
  public final static  String S_PsId = "PS_ID";
  public final static  String S_SubPasswd = "SUB_PASSWD";
  public final static  String S_OrgPsId = "ORG_PS_ID";
  public final static  String S_SubPlanNo = "SUB_PLAN_NO";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_MonFlag = "MON_FLAG";
  public final static  String S_NextProcess = "NEXT_PROCESS";
  public final static  String S_SourceId = "SOURCE_ID";
  public final static  String S_RegionCode = "REGION_CODE";
  public final static  String S_StatusUpdDate = "STATUS_UPD_DATE";
  public final static  String S_StartDate = "START_DATE";
  public final static  String S_SubId = "SUB_ID";
  public final static  String S_ProdSpecId = "PROD_SPEC_ID";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_BusiCode = "BUSI_CODE";
  public final static  String S_FailCode = "FAIL_CODE";
  public final static  String S_PsServiceCode = "PS_SERVICE_CODE";
  public final static  String S_HandId = "HAND_ID";


public long getPrioLevel();

public int getPsType();

public int getRollbackFlag();

public long getAccId();

public long getOrgId();

public long getSuspendPsId();

public String getTargetParam();

public String getCurrProcess();

public Timestamp getEndDate();

public String getHandNotes();

public int getSpId();

public Timestamp getHandDate();

public long getHandOpId();

public String getPsServiceType();

public String getBillId();

public String getPsParam();

public int getServiceId();

public int getPsStatus();

public int getAsyncFlag();

public Timestamp getOrderDate();

public int getRetryTimes();

public long getPlanId();

public String getPsNetCode();

public String getOldPsParam();

public long getActionId();

public int getFailNum();

public Timestamp getCreateDate();

public String getPsDeviceCode();

public Timestamp getSubValidDate();

public long getRetOpId();

public int getActFlag();

public long getSortId();

public long getOpId();

public String getSubBillId();

public Timestamp getRetDate();

public Timestamp getUppCreateDate();

public String getExternId();

public String getFailReason();

public String getNotes();

public int getStopType();

public long getDeadLine();

public long getOldPsId();

public String getRetNotes();

public long getPsId();

public String getSubPasswd();

public long getOrgPsId();

public long getSubPlanNo();

public String getDoneCode();

public int getMonFlag();

public String getNextProcess();

public int getSourceId();

public String getRegionCode();

public Timestamp getStatusUpdDate();

public Timestamp getStartDate();

public long getSubId();

public int getProdSpecId();

public String getFailLog();

public long getBusiCode();

public long getFailCode();

public String getPsServiceCode();

public long getHandId();


public  void setPrioLevel(long value);

public  void setPsType(int value);

public  void setRollbackFlag(int value);

public  void setAccId(long value);

public  void setOrgId(long value);

public  void setSuspendPsId(long value);

public  void setTargetParam(String value);

public  void setCurrProcess(String value);

public  void setEndDate(Timestamp value);

public  void setHandNotes(String value);

public  void setSpId(int value);

public  void setHandDate(Timestamp value);

public  void setHandOpId(long value);

public  void setPsServiceType(String value);

public  void setBillId(String value);

public  void setPsParam(String value);

public  void setServiceId(int value);

public  void setPsStatus(int value);

public  void setAsyncFlag(int value);

public  void setOrderDate(Timestamp value);

public  void setRetryTimes(int value);

public  void setPlanId(long value);

public  void setPsNetCode(String value);

public  void setOldPsParam(String value);

public  void setActionId(long value);

public  void setFailNum(int value);

public  void setCreateDate(Timestamp value);

public  void setPsDeviceCode(String value);

public  void setSubValidDate(Timestamp value);

public  void setRetOpId(long value);

public  void setActFlag(int value);

public  void setSortId(long value);

public  void setOpId(long value);

public  void setSubBillId(String value);

public  void setRetDate(Timestamp value);

public  void setUppCreateDate(Timestamp value);

public  void setExternId(String value);

public  void setFailReason(String value);

public  void setNotes(String value);

public  void setStopType(int value);

public  void setDeadLine(long value);

public  void setOldPsId(long value);

public  void setRetNotes(String value);

public  void setPsId(long value);

public  void setSubPasswd(String value);

public  void setOrgPsId(long value);

public  void setSubPlanNo(long value);

public  void setDoneCode(String value);

public  void setMonFlag(int value);

public  void setNextProcess(String value);

public  void setSourceId(int value);

public  void setRegionCode(String value);

public  void setStatusUpdDate(Timestamp value);

public  void setStartDate(Timestamp value);

public  void setSubId(long value);

public  void setProdSpecId(int value);

public  void setFailLog(String value);

public  void setBusiCode(long value);

public  void setFailCode(long value);

public  void setPsServiceCode(String value);

public  void setHandId(long value);
}
