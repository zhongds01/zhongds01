package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISACenterMapping extends DataStructInterface{

  public final static  String S_Code = "CODE";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_State = "STATE";
  public final static  String S_Id = "ID";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Describe = "DESCRIBE";
  public final static  String S_Name = "NAME";


public String getCode();

public String getComplex();

public Timestamp getCreateDate();

public long getModifier();

public String getCategory();

public Timestamp getModifyDate();

public String getState();

public long getId();

public long getCreater();

public String getImplclass();

public String getDescribe();

public String getName();


public  void setCode(String value);

public  void setComplex(String value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setState(String value);

public  void setId(long value);

public  void setCreater(long value);

public  void setImplclass(String value);

public  void setDescribe(String value);

public  void setName(String value);
}
