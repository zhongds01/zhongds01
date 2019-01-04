package com.ai.sacenter.core.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISAOrder extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Business = "BUSINESS";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Competence = "COMPETENCE";
  public final static  String S_OrderRegionId = "ORDER_REGION_ID";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Catalog = "CATALOG";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_CustOrder = "CUST_ORDER";
  public final static  String S_UserRegionId = "USER_REGION_ID";
  public final static  String S_GroupOrderId = "GROUP_ORDER_ID";
  public final static  String S_ChannelId = "CHANNEL_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_RegionCode = "REGION_CODE";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_CreateTaskId = "CREATE_TASK_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_CreateOrderId = "CREATE_ORDER_ID";


public String getRegionId();

public String getOrgId();

public String getSubBillId();

public String getStaffId();

public String getState();

public long getUserId();

public String getBusiness();

public long getPriority();

public String getCompetence();

public String getOrderRegionId();

public String getComposite();

public String getBillId();

public String getCatalog();

public String getCategory();

public String getCustOrder();

public String getUserRegionId();

public long getGroupOrderId();

public String getChannelId();

public String getDoneCode();

public Timestamp getOrderDate();

public String getRegionCode();

public Timestamp getStateDate();

public long getCreateTaskId();

public Timestamp getCreateDate();

public Timestamp getCompleteDate();

public long getOrderId();

public String getFailLog();

public long getCreateOrderId();


public  void setRegionId(String value);

public  void setOrgId(String value);

public  void setSubBillId(String value);

public  void setStaffId(String value);

public  void setState(String value);

public  void setUserId(long value);

public  void setBusiness(String value);

public  void setPriority(long value);

public  void setCompetence(String value);

public  void setOrderRegionId(String value);

public  void setComposite(String value);

public  void setBillId(String value);

public  void setCatalog(String value);

public  void setCategory(String value);

public  void setCustOrder(String value);

public  void setUserRegionId(String value);

public  void setGroupOrderId(long value);

public  void setChannelId(String value);

public  void setDoneCode(String value);

public  void setOrderDate(Timestamp value);

public  void setRegionCode(String value);

public  void setStateDate(Timestamp value);

public  void setCreateTaskId(long value);

public  void setCreateDate(Timestamp value);

public  void setCompleteDate(Timestamp value);

public  void setOrderId(long value);

public  void setFailLog(String value);

public  void setCreateOrderId(long value);
}
