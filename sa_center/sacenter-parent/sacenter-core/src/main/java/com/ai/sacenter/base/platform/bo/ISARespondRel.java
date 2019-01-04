package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISARespondRel extends DataStructInterface{

  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Network = "NETWORK";
  public final static  String S_Expire = "EXPIRE";
  public final static  String S_Effective = "EFFECTIVE";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Name = "NAME";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Code = "CODE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_Control = "CONTROL";


public String getComplex();

public long getModifier();

public String getNetwork();

public Timestamp getExpire();

public Timestamp getEffective();

public String getState();

public long getCreater();

public String getComposite();

public String getName();

public String getPlatform();

public String getCode();

public Timestamp getCreateDate();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public long getId();

public String getControl();


public  void setComplex(String value);

public  void setModifier(long value);

public  void setNetwork(String value);

public  void setExpire(Timestamp value);

public  void setEffective(Timestamp value);

public  void setState(String value);

public  void setCreater(long value);

public  void setComposite(String value);

public  void setName(String value);

public  void setPlatform(String value);

public  void setCode(String value);

public  void setCreateDate(Timestamp value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setId(long value);

public  void setControl(String value);
}
