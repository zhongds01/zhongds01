package com.ai.sacenter.base.competence.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISABusines extends DataStructInterface{

  public final static  String S_Effective = "EFFECTIVE";
  public final static  String S_State = "STATE";
  public final static  String S_Business = "BUSINESS";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Competence = "COMPETENCE";
  public final static  String S_GroupRole = "GROUP_ROLE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Complete = "COMPLETE";
  public final static  String S_Catalog = "CATALOG";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Expire = "EXPIRE";
  public final static  String S_Protocol = "PROTOCOL";
  public final static  String S_MemberRole = "MEMBER_ROLE";
  public final static  String S_Name = "NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Originate = "ORIGINATE";
  public final static  String S_Program = "PROGRAM";
  public final static  String S_Control = "CONTROL";


public Timestamp getEffective();

public String getState();

public String getBusiness();

public int getPriority();

public String getCompetence();

public String getGroupRole();

public long getCreater();

public String getImplclass();

public String getComposite();

public String getComplete();

public String getCatalog();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public long getId();

public String getComplex();

public long getModifier();

public Timestamp getExpire();

public String getProtocol();

public String getMemberRole();

public String getName();

public Timestamp getCreateDate();

public String getOriginate();

public String getProgram();

public String getControl();


public  void setEffective(Timestamp value);

public  void setState(String value);

public  void setBusiness(String value);

public  void setPriority(int value);

public  void setCompetence(String value);

public  void setGroupRole(String value);

public  void setCreater(long value);

public  void setImplclass(String value);

public  void setComposite(String value);

public  void setComplete(String value);

public  void setCatalog(String value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setId(long value);

public  void setComplex(String value);

public  void setModifier(long value);

public  void setExpire(Timestamp value);

public  void setProtocol(String value);

public  void setMemberRole(String value);

public  void setName(String value);

public  void setCreateDate(Timestamp value);

public  void setOriginate(String value);

public  void setProgram(String value);

public  void setControl(String value);
}
