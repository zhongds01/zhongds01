package com.ai.sacenter.core.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAQueue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_RedoTimes = "REDO_TIMES";
  public final static  String S_PlwkComplete = "PLWK_COMPLETE";
  public final static  String S_QueueId = "QUEUE_ID";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_SrcSystem = "SRC_SYSTEM";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_Result = "RESULT";
  public final static  String S_Program = "PROGRAM";
  public final static  String S_PlwkDescribe = "PLWK_DESCRIBE";
  public final static  String S_Param = "PARAM";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_PlqkId = "PLQK_ID";
  public final static  String S_PlwkCoding = "PLWK_CODING";
  public final static  String S_DoneTimes = "DONE_TIMES";
  public final static  String S_PlwkCreate = "PLWK_CREATE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_CreateDate = "CREATE_DATE";


public String getState();

public long getUserId();

public long getPriority();

public int getRedoTimes();

public Timestamp getPlwkComplete();

public long getQueueId();

public Timestamp getCompleteDate();

public String getSrcSystem();

public String getOrgId();

public String getRegionId();

public String getCategory();

public long getOrderId();

public String getStaffId();

public String getResult();

public String getProgram();

public String getPlwkDescribe();

public String getParam();

public String getPlatform();

public long getPlqkId();

public String getPlwkCoding();

public int getDoneTimes();

public Timestamp getPlwkCreate();

public String getBillId();

public Timestamp getCreateDate();


public  void setState(String value);

public  void setUserId(long value);

public  void setPriority(long value);

public  void setRedoTimes(int value);

public  void setPlwkComplete(Timestamp value);

public  void setQueueId(long value);

public  void setCompleteDate(Timestamp value);

public  void setSrcSystem(String value);

public  void setOrgId(String value);

public  void setRegionId(String value);

public  void setCategory(String value);

public  void setOrderId(long value);

public  void setStaffId(String value);

public  void setResult(String value);

public  void setProgram(String value);

public  void setPlwkDescribe(String value);

public  void setParam(String value);

public  void setPlatform(String value);

public  void setPlqkId(long value);

public  void setPlwkCoding(String value);

public  void setDoneTimes(int value);

public  void setPlwkCreate(Timestamp value);

public  void setBillId(String value);

public  void setCreateDate(Timestamp value);
}
