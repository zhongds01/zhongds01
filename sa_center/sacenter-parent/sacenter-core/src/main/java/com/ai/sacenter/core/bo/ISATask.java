package com.ai.sacenter.core.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISATask extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_DoneTimes = "DONE_TIMES";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_PlwkCoding = "PLWK_CODING";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Directive = "DIRECTIVE";
  public final static  String S_RedoTimes = "REDO_TIMES";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_DependTaskId = "DEPEND_TASK_ID";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_Param = "PARAM";
  public final static  String S_PlwkCreate = "PLWK_CREATE";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_CreateTaskId = "CREATE_TASK_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_PlwkComplete = "PLWK_COMPLETE";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_Subflow = "SUBFLOW";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_DoneResult = "DONE_RESULT";


public String getRegionId();

public int getDoneTimes();

public String getOrgId();

public String getPlwkCoding();

public long getSortBy();

public String getStaffId();

public String getState();

public long getUserId();

public long getPriority();

public String getPlatform();

public String getDirective();

public int getRedoTimes();

public Timestamp getStateDate();

public long getDependTaskId();

public long getOfferId();

public String getParam();

public Timestamp getPlwkCreate();

public String getStationId();

public long getCreateTaskId();

public Timestamp getCreateDate();

public Timestamp getCompleteDate();

public long getOrderId();

public Timestamp getPlwkComplete();

public String getFailLog();

public long getSubflow();

public long getTaskId();

public String getDoneResult();


public  void setRegionId(String value);

public  void setDoneTimes(int value);

public  void setOrgId(String value);

public  void setPlwkCoding(String value);

public  void setSortBy(long value);

public  void setStaffId(String value);

public  void setState(String value);

public  void setUserId(long value);

public  void setPriority(long value);

public  void setPlatform(String value);

public  void setDirective(String value);

public  void setRedoTimes(int value);

public  void setStateDate(Timestamp value);

public  void setDependTaskId(long value);

public  void setOfferId(long value);

public  void setParam(String value);

public  void setPlwkCreate(Timestamp value);

public  void setStationId(String value);

public  void setCreateTaskId(long value);

public  void setCreateDate(Timestamp value);

public  void setCompleteDate(Timestamp value);

public  void setOrderId(long value);

public  void setPlwkComplete(Timestamp value);

public  void setFailLog(String value);

public  void setSubflow(long value);

public  void setTaskId(long value);

public  void setDoneResult(String value);
}
