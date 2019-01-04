package com.ai.sacenter.cboss.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISARadiusX extends DataStructInterface{

  public final static  String S_Param17 = "PARAM_17";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Param18 = "PARAM_18";
  public final static  String S_Param19 = "PARAM_19";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_Param10 = "PARAM_10";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Param11 = "PARAM_11";
  public final static  String S_Param12 = "PARAM_12";
  public final static  String S_Param13 = "PARAM_13";
  public final static  String S_Param14 = "PARAM_14";
  public final static  String S_Param15 = "PARAM_15";
  public final static  String S_Param16 = "PARAM_16";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_SoNbr = "SO_NBR";
  public final static  String S_Param06 = "PARAM_06";
  public final static  String S_SubPlanNo = "SUB_PLAN_NO";
  public final static  String S_Param07 = "PARAM_07";
  public final static  String S_Param08 = "PARAM_08";
  public final static  String S_Param09 = "PARAM_09";
  public final static  String S_Param20 = "PARAM_20";
  public final static  String S_Param01 = "PARAM_01";
  public final static  String S_Param02 = "PARAM_02";
  public final static  String S_Param03 = "PARAM_03";
  public final static  String S_Param04 = "PARAM_04";
  public final static  String S_MsoNbr = "MSO_NBR";
  public final static  String S_Param05 = "PARAM_05";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OrderDate = "ORDER_DATE";


public String getParam17();

public String getRegionId();

public String getParam18();

public String getParam19();

public int getSortBy();

public String getParam10();

public long getUserId();

public String getParam11();

public String getParam12();

public String getParam13();

public String getParam14();

public String getParam15();

public String getParam16();

public String getCategory();

public long getSoNbr();

public String getParam06();

public long getSubPlanNo();

public String getParam07();

public String getParam08();

public String getParam09();

public String getParam20();

public String getParam01();

public String getParam02();

public String getParam03();

public String getParam04();

public long getMsoNbr();

public String getParam05();

public Timestamp getCreateDate();

public Timestamp getOrderDate();


public  void setParam17(String value);

public  void setRegionId(String value);

public  void setParam18(String value);

public  void setParam19(String value);

public  void setSortBy(int value);

public  void setParam10(String value);

public  void setUserId(long value);

public  void setParam11(String value);

public  void setParam12(String value);

public  void setParam13(String value);

public  void setParam14(String value);

public  void setParam15(String value);

public  void setParam16(String value);

public  void setCategory(String value);

public  void setSoNbr(long value);

public  void setParam06(String value);

public  void setSubPlanNo(long value);

public  void setParam07(String value);

public  void setParam08(String value);

public  void setParam09(String value);

public  void setParam20(String value);

public  void setParam01(String value);

public  void setParam02(String value);

public  void setParam03(String value);

public  void setParam04(String value);

public  void setMsoNbr(long value);

public  void setParam05(String value);

public  void setCreateDate(Timestamp value);

public  void setOrderDate(Timestamp value);
}
