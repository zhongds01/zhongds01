package com.ai.sacenter.receive.exigence.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISPCRocket extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_ChannelId = "CHANNEL_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_CustOrder = "CUST_ORDER";
  public final static  String S_CatalogId = "CATALOG_ID";
  public final static  String S_Originate = "ORIGINATE";
  public final static  String S_PlwkCreate = "PLWK_CREATE";
  public final static  String S_PlwkComplete = "PLWK_COMPLETE";
  public final static  String S_FailCode = "FAIL_CODE";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_RetryTimes = "RETRY_TIMES";
  
public String getRegionId();

public String getBusinessId();

public Timestamp getDoneDate();

public String getOrgId();

public String getChannelId();

public String getDoneCode();

public String getStaffId();

public String getState();

public long getUserId();

public long getPriority();

public Timestamp getCreateDate();

public String getBillId();

public Timestamp getCompleteDate();

public long getOrderId();

public String getFailLog();

public String getCustOrder();

public String getCatalogId();

public Timestamp getPlwkCreate();

public Timestamp getPlwkComplete();

public String getOriginate();

public Timestamp getOrderDate();

public int getRetryTimes();

public String getFailCode();

public  void setRegionId(String value);

public  void setBusinessId(String value);

public  void setDoneDate(Timestamp value);

public  void setOrgId(String value);

public  void setChannelId(String value);

public  void setDoneCode(String value);

public  void setStaffId(String value);

public  void setState(String value);

public  void setUserId(long value);

public  void setPriority(long value);

public  void setCreateDate(Timestamp value);

public  void setBillId(String value);

public  void setCompleteDate(Timestamp value);

public  void setOrderId(long value);

public  void setFailLog(String value);

public  void setCustOrder(String value);

public  void setCatalogId(String value);

public  void setOriginate(String value);

public  void setPlwkCreate(Timestamp value);

public  void setPlwkComplete(Timestamp value);

public  void setOrderDate(Timestamp value);

public  void setRetryTimes(int value);

public  void setFailCode(String value);

}
