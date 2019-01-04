package com.ai.sacenter.base.basic.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISACenter extends DataStructInterface{

  public final static  String S_Center = "CENTER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Route = "ROUTE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_State = "STATE";
  public final static  String S_RegionNumber = "REGION_NUMBER";
  public final static  String S_Id = "ID";
  public final static  String S_Creater = "CREATER";


public String getCenter();

public String getPlatform();

public String getRoute();

public Timestamp getCreateDate();

public long getModifier();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public String getState();

public int getRegionNumber();

public long getId();

public long getCreater();


public  void setCenter(String value);

public  void setPlatform(String value);

public  void setRoute(String value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setState(String value);

public  void setRegionNumber(int value);

public  void setId(long value);

public  void setCreater(long value);
}
