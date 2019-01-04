package com.ai.sacenter.receive.order.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISAUrgencyX extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_InsProdId = "INS_PROD_ID";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Param01 = "PARAM_01";
  public final static  String S_Param02 = "PARAM_02";
  public final static  String S_ProductId = "PRODUCT_ID";
  public final static  String S_Param03 = "PARAM_03";
  public final static  String S_Param04 = "PARAM_04";
  public final static  String S_Param05 = "PARAM_05";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Status = "STATUS";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_ProdType = "PROD_TYPE";
  public final static  String S_ServiceId = "SERVICE_ID";


public String getRegionId();

public long getInsProdId();

public long getOfferId();

public String getState();

public long getUserId();

public String getParam01();

public String getParam02();

public long getProductId();

public String getParam03();

public String getParam04();

public String getParam05();

public Timestamp getCreateDate();

public String getStatus();

public Timestamp getCompleteDate();

public long getOrderId();

public String getProdType();

public long getServiceId();


public  void setRegionId(String value);

public  void setInsProdId(long value);

public  void setOfferId(long value);

public  void setState(String value);

public  void setUserId(long value);

public  void setParam01(String value);

public  void setParam02(String value);

public  void setProductId(long value);

public  void setParam03(String value);

public  void setParam04(String value);

public  void setParam05(String value);

public  void setCreateDate(Timestamp value);

public  void setStatus(String value);

public  void setCompleteDate(Timestamp value);

public  void setOrderId(long value);

public  void setProdType(String value);

public  void setServiceId(long value);
}
