package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAOffice extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_StartNum = "START_NUM";
  public final static  String S_EndNum = "END_NUM";
  public final static  String S_PsNetCode = "PS_NET_CODE";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Headnum = "HEADNUM";
  public final static  String S_Id = "ID";
  public final static  String S_Platfrom = "PLATFROM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_RegionCode = "REGION_CODE";
  public final static  String S_Modifier = "MODIFIER";


public String getState();

public String getStartNum();

public String getEndNum();

public String getPsNetCode();

public Timestamp getModifyDate();

public String getRegionId();

public String getCategory();

public long getCreater();

public String getHeadnum();

public long getId();

public String getPlatfrom();

public Timestamp getCreateDate();

public String getRegionCode();

public long getModifier();


public  void setState(String value);

public  void setStartNum(String value);

public  void setEndNum(String value);

public  void setPsNetCode(String value);

public  void setModifyDate(Timestamp value);

public  void setRegionId(String value);

public  void setCategory(String value);

public  void setCreater(long value);

public  void setHeadnum(String value);

public  void setId(long value);

public  void setPlatfrom(String value);

public  void setCreateDate(Timestamp value);

public  void setRegionCode(String value);

public  void setModifier(long value);
}
