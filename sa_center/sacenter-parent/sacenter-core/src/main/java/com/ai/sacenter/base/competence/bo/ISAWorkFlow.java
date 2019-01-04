package com.ai.sacenter.base.competence.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAWorkFlow extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Name = "NAME";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Id = "ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_ModifyDate = "MODIFY_DATE";


public String getState();

public String getCategory();

public String getName();

public long getCreater();

public String getComplex();

public String getDescription();

public String getId();

public Timestamp getCreateDate();

public long getModifier();

public Timestamp getModifyDate();


public  void setState(String value);

public  void setCategory(String value);

public  void setName(String value);

public  void setCreater(long value);

public  void setComplex(String value);

public  void setDescription(String value);

public  void setId(String value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setModifyDate(Timestamp value);
}
