package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISACenterWrapper extends DataStructInterface{

  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_State = "STATE";
  public final static  String S_Psmlflg = "PSMLFLG";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Function = "FUNCTION";
  public final static  String S_Center = "CENTER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";


public String getComplex();

public long getModifier();

public String getState();

public String getPsmlflg();

public long getCreater();

public String getImplclass();

public String getFunction();

public String getCenter();

public String getPlatform();

public Timestamp getCreateDate();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public long getId();


public  void setComplex(String value);

public  void setModifier(long value);

public  void setState(String value);

public  void setPsmlflg(String value);

public  void setCreater(long value);

public  void setImplclass(String value);

public  void setFunction(String value);

public  void setCenter(String value);

public  void setPlatform(String value);

public  void setCreateDate(Timestamp value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setId(long value);
}
