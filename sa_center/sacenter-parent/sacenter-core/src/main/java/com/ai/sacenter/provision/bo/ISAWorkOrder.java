package com.ai.sacenter.provision.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISAWorkOrder extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_TargetParam = "TARGET_PARAM";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_RetDate = "RET_DATE";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_Notes = "NOTES";
  public final static  String S_Complete = "COMPLETE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_StopType = "STOP_TYPE";
  public final static  String S_PsParam = "PS_PARAM";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Directive = "DIRECTIVE";
  public final static  String S_CustOrder = "CUST_ORDER";
  public final static  String S_PsId = "PS_ID";
  public final static  String S_ServiceId = "SERVICE_ID";
  public final static  String S_PsStatus = "PS_STATUS";
  public final static  String S_SubPlanNo = "SUB_PLAN_NO";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_RetryTimes = "RETRY_TIMES";
  public final static  String S_StartDate = "START_DATE";
  public final static  String S_PsNetCode = "PS_NET_CODE";
  public final static  String S_OldPsParam = "OLD_PS_PARAM";
  public final static  String S_FailDevice = "FAIL_DEVICE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_FailCode = "FAIL_CODE";
  public final static  String S_Originate = "ORIGINATE";
  public final static  String S_Result = "RESULT";
  public final static  String S_Program = "PROGRAM";
  public final static  String S_TaskId = "TASK_ID";


public String getRegionId();

public String getOrgId();

public String getTargetParam();

public String getSubBillId();

public Timestamp getEndDate();

public String getStaffId();

public String getState();

public long getUserId();

public long getPriority();

public Timestamp getRetDate();

public String getPlatform();

public String getFailReason();

public String getNotes();

public String getComplete();

public String getBillId();

public int getStopType();

public String getPsParam();

public String getCategory();

public String getDirective();

public String getCustOrder();

public long getPsId();

public int getServiceId();

public int getPsStatus();

public long getSubPlanNo();

public String getDoneCode();

public Timestamp getOrderDate();

public int getRetryTimes();

public Timestamp getStartDate();

public String getPsNetCode();

public String getOldPsParam();

public String getFailDevice();

public Timestamp getCreateDate();

public Timestamp getCompleteDate();

public long getOrderId();

public String getFailLog();

public String getFailCode();

public String getOriginate();

public String getResult();

public String getProgram();

public long getTaskId();


public  void setRegionId(String value);

public  void setOrgId(String value);

public  void setTargetParam(String value);

public  void setSubBillId(String value);

public  void setEndDate(Timestamp value);

public  void setStaffId(String value);

public  void setState(String value);

public  void setUserId(long value);

public  void setPriority(long value);

public  void setRetDate(Timestamp value);

public  void setPlatform(String value);

public  void setFailReason(String value);

public  void setNotes(String value);

public  void setComplete(String value);

public  void setBillId(String value);

public  void setStopType(int value);

public  void setPsParam(String value);

public  void setCategory(String value);

public  void setDirective(String value);

public  void setCustOrder(String value);

public  void setPsId(long value);

public  void setServiceId(int value);

public  void setPsStatus(int value);

public  void setSubPlanNo(long value);

public  void setDoneCode(String value);

public  void setOrderDate(Timestamp value);

public  void setRetryTimes(int value);

public  void setStartDate(Timestamp value);

public  void setPsNetCode(String value);

public  void setOldPsParam(String value);

public  void setFailDevice(String value);

public  void setCreateDate(Timestamp value);

public  void setCompleteDate(Timestamp value);

public  void setOrderId(long value);

public  void setFailLog(String value);

public  void setFailCode(String value);

public  void setOriginate(String value);

public  void setResult(String value);

public  void setProgram(String value);

public  void setTaskId(long value);
}
