package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAMappingRel extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Control = "CONTROL";
  public final static  String S_Template = "TEMPLATE";
  public final static  String S_Ignoreable = "IGNOREABLE";
  public final static  String S_Mapping = "MAPPING";
  public final static  String S_Nullable = "NULLABLE";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Module = "MODULE";
  public final static  String S_Id = "ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_ParentId = "PARENT_ID";
  public final static  String S_Length = "LENGTH";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_Compete = "COMPETE";


public String getState();

public String getName();

public String getDescription();

public String getControl();

public String getTemplate();

public String getIgnoreable();

public String getMapping();

public String getNullable();

public Timestamp getModifyDate();

public String getImplclass();

public String getCategory();

public String getComplex();

public long getCreater();

public String getModule();

public long getId();

public Timestamp getCreateDate();

public long getModifier();

public long getParentId();

public int getLength();

public int getSortBy();

public String getCompete();


public  void setState(String value);

public  void setName(String value);

public  void setDescription(String value);

public  void setControl(String value);

public  void setTemplate(String value);

public  void setIgnoreable(String value);

public  void setMapping(String value);

public  void setNullable(String value);

public  void setModifyDate(Timestamp value);

public  void setImplclass(String value);

public  void setCategory(String value);

public  void setComplex(String value);

public  void setCreater(long value);

public  void setModule(String value);

public  void setId(long value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setParentId(long value);

public  void setLength(int value);

public  void setSortBy(int value);

public  void setCompete(String value);
}
