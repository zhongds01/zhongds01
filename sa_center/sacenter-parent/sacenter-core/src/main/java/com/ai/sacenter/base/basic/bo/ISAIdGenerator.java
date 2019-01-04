package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAIdGenerator extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_TableName = "TABLE_NAME";
  public final static  String S_ChannelId = "CHANNEL_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Function = "FUNCTION";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Sequence = "SEQUENCE";
  public final static  String S_RegionNumber = "REGION_NUMBER";
  public final static  String S_Id = "ID";
  public final static  String S_Control = "CONTROL";


public String getRegionId();

public long getModifier();

public String getTableName();

public String getChannelId();

public String getState();

public long getCreater();

public String getFunction();

public Timestamp getCreateDate();

public String getDescription();

public Timestamp getModifyDate();

public String getSequence();

public String getRegionNumber();

public long getId();

public String getControl();


public  void setRegionId(String value);

public  void setModifier(long value);

public  void setTableName(String value);

public  void setChannelId(String value);

public  void setState(String value);

public  void setCreater(long value);

public  void setFunction(String value);

public  void setCreateDate(Timestamp value);

public  void setDescription(String value);

public  void setModifyDate(Timestamp value);

public  void setSequence(String value);

public  void setRegionNumber(String value);

public  void setId(long value);

public  void setControl(String value);
}
