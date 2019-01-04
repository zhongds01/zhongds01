package com.ai.sacenter.base.competence.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISACompetence extends DataStructInterface{

  public final static  String S_Expire = "EXPIRE";
  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Control = "CONTROL";
  public final static  String S_Complete = "COMPLETE";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Catalog = "CATALOG";
  public final static  String S_Id = "ID";
  public final static  String S_Business = "BUSINESS";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Effective = "EFFECTIVE";


public Timestamp getExpire();

public String getState();

public String getName();

public String getDescription();


public String getControl();

public String getComplete();

public Timestamp getModifyDate();

public String getImplclass();

public String getCategory();

public String getComplex();

public long getCreater();

public long getCatalog();

public String getId();

public long getBusiness();

public Timestamp getCreateDate();

public long getModifier();

public Timestamp getEffective();


public  void setExpire(Timestamp value);

public  void setState(String value);

public  void setName(String value);

public  void setDescription(String value);


public  void setControl(String value);

public  void setComplete(String value);

public  void setModifyDate(Timestamp value);

public  void setImplclass(String value);

public  void setCategory(String value);

public  void setComplex(String value);

public  void setCreater(long value);

public  void setCatalog(long value);

public  void setId(String value);

public  void setBusiness(long value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setEffective(Timestamp value);
}
