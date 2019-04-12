package com.ai.sacenter.base.competence.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAProgramRel extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Control = "CONTROL";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Program = "PROGRAM";
  public final static  String S_Id = "ID";
  public final static  String S_Component = "COMPONENT";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SortBy = "SORT_BY";


public String getState();

public String getName();

public String getDescription();

public String getControl();

public Timestamp getModifyDate();

public String getCategory();

public String getComplex();

public long getCreater();

public String getProgram();

public long getId();

public String getComponent();

public Timestamp getCreateDate();

public long getModifier();

public int getSortBy();


public  void setState(String value);

public  void setName(String value);

public  void setDescription(String value);

public  void setControl(String value);

public  void setModifyDate(Timestamp value);

public  void setCategory(String value);

public  void setComplex(String value);

public  void setCreater(long value);

public  void setProgram(String value);

public  void setId(long value);

public  void setComponent(String value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setSortBy(int value);
}