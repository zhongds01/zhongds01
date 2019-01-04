package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISADirective extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Control = "CONTROL";
  public final static  String S_Subflow = "SUBFLOW";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Id = "ID";
  public final static  String S_Directive = "DIRECTIVE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Operate = "OPERATE";


public String getState();

public String getName();

public String getDescription();

public String getControl();

public String getSubflow();

public String getImplclass();

public Timestamp getModifyDate();

public String getCategory();

public String getComplex();

public long getCreater();

public String getPlatform();

public String getId();

public String getDirective();

public Timestamp getCreateDate();

public long getModifier();

public String getOperate();


public  void setState(String value);

public  void setName(String value);

public  void setDescription(String value);

public  void setControl(String value);

public  void setSubflow(String value);

public  void setImplclass(String value);

public  void setModifyDate(Timestamp value);

public  void setCategory(String value);

public  void setComplex(String value);

public  void setCreater(long value);

public  void setPlatform(String value);

public  void setId(String value);

public  void setDirective(String value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setOperate(String value);
}
