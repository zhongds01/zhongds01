package com.ai.sacenter.provision.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISAUatmix extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Msg20 = "MSG_20";
  public final static  String S_Msg01 = "MSG_01";
  public final static  String S_LgmsgId = "LGMSG_ID";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_PlwkIdo = "PLWK_IDO";
  public final static  String S_Msg19 = "MSG_19";
  public final static  String S_Msg18 = "MSG_18";
  public final static  String S_Result = "RESULT";
  public final static  String S_Msg17 = "MSG_17";
  public final static  String S_Msg16 = "MSG_16";
  public final static  String S_Msg15 = "MSG_15";
  public final static  String S_Msg14 = "MSG_14";
  public final static  String S_Msg13 = "MSG_13";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Msg10 = "MSG_10";
  public final static  String S_Msg11 = "MSG_11";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Msg12 = "MSG_12";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Msg03 = "MSG_03";
  public final static  String S_Msg02 = "MSG_02";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Msg05 = "MSG_05";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_Msg04 = "MSG_04";
  public final static  String S_Msg07 = "MSG_07";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Msg06 = "MSG_06";
  public final static  String S_Msg09 = "MSG_09";
  public final static  String S_Msg08 = "MSG_08";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_CreateDate = "CREATE_DATE";


public String getState();

public String getMsg20();

public String getMsg01();

public long getLgmsgId();

public Timestamp getCompleteDate();

public String getPlwkIdo();

public String getMsg19();

public String getMsg18();

public String getResult();

public String getMsg17();

public String getMsg16();

public String getMsg15();

public String getMsg14();

public String getMsg13();

public String getDoneCode();

public long getUserId();

public String getMsg10();

public String getMsg11();

public String getOrgId();

public String getImplclass();

public String getMsg12();

public String getRegionId();

public String getMsg03();

public String getMsg02();

public String getOrderId();

public String getMsg05();

public String getStaffId();

public String getMsg04();

public String getMsg07();

public String getPlatform();

public String getMsg06();

public String getMsg09();

public String getMsg08();

public String getBillId();

public Timestamp getCreateDate();


public  void setState(String value);

public  void setMsg20(String value);

public  void setMsg01(String value);

public  void setLgmsgId(long value);

public  void setCompleteDate(Timestamp value);

public  void setPlwkIdo(String value);

public  void setMsg19(String value);

public  void setMsg18(String value);

public  void setResult(String value);

public  void setMsg17(String value);

public  void setMsg16(String value);

public  void setMsg15(String value);

public  void setMsg14(String value);

public  void setMsg13(String value);

public  void setDoneCode(String value);

public  void setUserId(long value);

public  void setMsg10(String value);

public  void setMsg11(String value);

public  void setOrgId(String value);

public  void setImplclass(String value);

public  void setMsg12(String value);

public  void setRegionId(String value);

public  void setMsg03(String value);

public  void setMsg02(String value);

public  void setOrderId(String value);

public  void setMsg05(String value);

public  void setStaffId(String value);

public  void setMsg04(String value);

public  void setMsg07(String value);

public  void setPlatform(String value);

public  void setMsg06(String value);

public  void setMsg09(String value);

public  void setMsg08(String value);

public  void setBillId(String value);

public  void setCreateDate(Timestamp value);
}
