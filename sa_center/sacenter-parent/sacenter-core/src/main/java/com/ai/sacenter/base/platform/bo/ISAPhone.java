package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAPhone extends DataStructInterface{

  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Msisdn = "MSISDN";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_State = "STATE";
  public final static  String S_Id = "ID";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Control = "CONTROL";


public String getPlatform();

public String getComplex();

public Timestamp getCreateDate();

public long getModifier();

public String getMsisdn();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public String getState();

public long getId();

public long getCreater();

public String getControl();


public  void setPlatform(String value);

public  void setComplex(String value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setMsisdn(String value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setState(String value);

public  void setId(long value);

public  void setCreater(long value);

public  void setControl(String value);
}
