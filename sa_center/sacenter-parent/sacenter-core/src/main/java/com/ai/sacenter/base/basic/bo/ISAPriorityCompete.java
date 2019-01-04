package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAPriorityCompete extends DataStructInterface{

  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_State = "STATE";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Compete = "COMPETE";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_Name = "NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Program = "PROGRAM";
  public final static  String S_Control = "CONTROL";


public String getComplex();

public long getModifier();

public int getSortBy();

public String getState();

public int getPriority();

public long getCreater();

public String getComposite();

public String getPlatform();

public Timestamp getCreateDate();

public String getCompete();

public Timestamp getModifyDate();

public long getId();

public String getName();

public String getDescription();

public String getProgram();

public String getControl();


public  void setComplex(String value);

public  void setModifier(long value);

public  void setSortBy(int value);

public  void setState(String value);

public  void setPriority(int value);

public  void setCreater(long value);

public  void setComposite(String value);

public  void setPlatform(String value);

public  void setCreateDate(Timestamp value);

public  void setCompete(String value);

public  void setModifyDate(Timestamp value);

public  void setId(long value);

public  void setName(String value);

public  void setDescription(String value);

public  void setProgram(String value);

public  void setControl(String value);
}
