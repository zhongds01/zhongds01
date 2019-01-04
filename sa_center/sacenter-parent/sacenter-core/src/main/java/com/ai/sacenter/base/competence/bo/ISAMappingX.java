package com.ai.sacenter.base.competence.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAMappingX extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Control = "CONTROL";
  public final static  String S_Mapping = "MAPPING";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Id = "ID";
  public final static  String S_Component = "COMPONENT";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_Compete = "COMPETE";
  public final static  String S_Code = "CODE";


public String getState();

public String getName();

public String getDescription();

public String getControl();

public String getMapping();

public String getImplclass();

public Timestamp getModifyDate();

public String getComplex();

public long getCreater();

public String getPlatform();

public long getId();

public String getComponent();

public Timestamp getCreateDate();

public long getModifier();

public int getSortBy();

public String getCompete();

public String getCode();


public  void setState(String value);

public  void setName(String value);

public  void setDescription(String value);

public  void setControl(String value);

public  void setMapping(String value);

public  void setImplclass(String value);

public  void setModifyDate(Timestamp value);

public  void setComplex(String value);

public  void setCreater(long value);

public  void setPlatform(String value);

public  void setId(long value);

public  void setComponent(String value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setSortBy(int value);

public  void setCompete(String value);

public  void setCode(String value);
}
