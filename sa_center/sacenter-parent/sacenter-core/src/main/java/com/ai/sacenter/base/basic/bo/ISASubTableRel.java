package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISASubTableRel extends DataStructInterface{

  public final static  String S_Target = "TARGET";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Persistent = "PERSISTENT";
  public final static  String S_TableName = "TABLE_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_TargetId = "TARGET_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Control = "CONTROL";


public String getTarget();

public long getModifier();

public String getPersistent();

public String getTableName();

public String getState();

public long getCreater();

public String getPlatform();

public Timestamp getCreateDate();

public long getTargetId();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public String getControl();


public  void setTarget(String value);

public  void setModifier(long value);

public  void setPersistent(String value);

public  void setTableName(String value);

public  void setState(String value);

public  void setCreater(long value);

public  void setPlatform(String value);

public  void setCreateDate(Timestamp value);

public  void setTargetId(long value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setControl(String value);
}
