package com.ai.sacenter.core.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAOffer extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_ProductId = "PRODUCT_ID";
  public final static  String S_Param01 = "PARAM_01";
  public final static  String S_Comptel = "COMPTEL";
  public final static  String S_Param02 = "PARAM_02";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_Param03 = "PARAM_03";
  public final static  String S_Param04 = "PARAM_04";
  public final static  String S_Subflow = "SUBFLOW";
  public final static  String S_Param05 = "PARAM_05";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_CompeteId = "COMPETE_ID";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_SortBy = "SORT_BY";


public String getState();

public long getUserId();

public long getProductId();

public String getParam01();

public String getComptel();

public String getParam02();

public Timestamp getCompleteDate();

public String getParam03();

public String getParam04();

public String getSubflow();

public String getParam05();

public String getRegionId();

public long getOrderId();

public long getCompeteId();

public long getOfferId();

public Timestamp getCreateDate();

public int getSortBy();


public  void setState(String value);

public  void setUserId(long value);

public  void setProductId(long value);

public  void setParam01(String value);

public  void setComptel(String value);

public  void setParam02(String value);

public  void setCompleteDate(Timestamp value);

public  void setParam03(String value);

public  void setParam04(String value);

public  void setSubflow(String value);

public  void setParam05(String value);

public  void setRegionId(String value);

public  void setOrderId(long value);

public  void setCompeteId(long value);

public  void setOfferId(long value);

public  void setCreateDate(Timestamp value);

public  void setSortBy(int value);
}
