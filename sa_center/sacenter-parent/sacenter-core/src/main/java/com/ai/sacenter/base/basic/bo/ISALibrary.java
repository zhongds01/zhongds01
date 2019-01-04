package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISALibrary extends DataStructInterface{

  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Name = "NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Method = "METHOD";
  public final static  String S_Id = "ID";
  public final static  String S_Describe = "DESCRIBE";
  public final static  String S_Control = "CONTROL";


public String getComplex();

public long getModifier();

public String getState();

public long getCreater();

public String getImplclass();

public String getName();

public Timestamp getCreateDate();

public String getCategory();

public Timestamp getModifyDate();

public String getMethod();

public String getId();

public String getDescribe();

public String getControl();


public  void setComplex(String value);

public  void setModifier(long value);

public  void setState(String value);

public  void setCreater(long value);

public  void setImplclass(String value);

public  void setName(String value);

public  void setCreateDate(Timestamp value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setMethod(String value);

public  void setId(String value);

public  void setDescribe(String value);

public  void setControl(String value);
}
