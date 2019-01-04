package com.ai.sacenter.receive.expire.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISAExpire extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_BrandId = "BRAND_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_CustOrder = "CUST_ORDER";
  public final static  String S_CatalogId = "CATALOG_ID";
  public final static  String S_UserRegionId = "USER_REGION_ID";


public String getRegionId();

public String getOrgId();

public String getDoneCode();

public long getOrderDate();

public String getStaffId();

public String getState();

public long getUserId();

public String getBrandId();

public Timestamp getCreateDate();

public String getBillId();

public Timestamp getCompleteDate();

public long getOrderId();

public String getCategory();

public String getFailLog();

public String getCustOrder();

public long getCatalogId();

public String getUserRegionId();


public  void setRegionId(String value);

public  void setOrgId(String value);

public  void setDoneCode(String value);

public  void setOrderDate(long value);

public  void setStaffId(String value);

public  void setState(String value);

public  void setUserId(long value);

public  void setBrandId(String value);

public  void setCreateDate(Timestamp value);

public  void setBillId(String value);

public  void setCompleteDate(Timestamp value);

public  void setOrderId(long value);

public  void setCategory(String value);

public  void setFailLog(String value);

public  void setCustOrder(String value);

public  void setCatalogId(long value);

public  void setUserRegionId(String value);
}
