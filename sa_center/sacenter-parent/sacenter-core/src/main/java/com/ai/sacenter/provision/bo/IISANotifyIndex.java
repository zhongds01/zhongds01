package com.ai.sacenter.provision.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISANotifyIndex extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_BackupDate = "BACKUP_DATE";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_StartDate = "START_DATE";
  public final static  String S_HandDate = "HAND_DATE";
  public final static  String S_HandOpId = "HAND_OP_ID";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Status = "STATUS";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_UpField = "UP_FIELD";
  public final static  String S_FailCode = "FAIL_CODE";
  public final static  String S_HandId = "HAND_ID";


public String getRegionId();

public Timestamp getOrderDate();

public Timestamp getBackupDate();

public Timestamp getEndDate();

public long getUserId();

public Timestamp getStartDate();

public Timestamp getHandDate();

public long getHandOpId();

public String getPlatform();

public String getFailReason();

public Timestamp getCreateDate();

public int getStatus();

public Timestamp getCompleteDate();

public long getOrderId();

public String getCategory();

public String getFailLog();

public String getUpField();

public String getFailCode();

public long getHandId();


public  void setRegionId(String value);

public  void setOrderDate(Timestamp value);

public  void setBackupDate(Timestamp value);

public  void setEndDate(Timestamp value);

public  void setUserId(long value);

public  void setStartDate(Timestamp value);

public  void setHandDate(Timestamp value);

public  void setHandOpId(long value);

public  void setPlatform(String value);

public  void setFailReason(String value);

public  void setCreateDate(Timestamp value);

public  void setStatus(int value);

public  void setCompleteDate(Timestamp value);

public  void setOrderId(long value);

public  void setCategory(String value);

public  void setFailLog(String value);

public  void setUpField(String value);

public  void setFailCode(String value);

public  void setHandId(long value);
}
