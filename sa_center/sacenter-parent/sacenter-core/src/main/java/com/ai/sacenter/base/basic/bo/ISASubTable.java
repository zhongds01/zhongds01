package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISASubTable extends DataStructInterface{

  public final static  String S_Location = "LOCATION";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Persistent = "PERSISTENT";
  public final static  String S_TableName = "TABLE_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_TableId = "TABLE_ID";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Buffer = "BUFFER";
  public final static  String S_Multiple = "MULTIPLE";
  public final static  String S_Base = "BASE";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Sequence = "SEQUENCE";
  public final static  String S_Fail = "FAIL";
  public final static  String S_Suggest = "SUGGEST";
  public final static  String S_Control = "CONTROL";
  public final static  String S_History = "HISTORY";


public int getLocation();

public long getModifier();

public String getPersistent();

public String getTableName();

public String getState();

public long getTableId();

public long getCreater();

public String getBuffer();

public String getMultiple();

public String getBase();

public String getPlatform();

public Timestamp getCreateDate();

public String getDescription();

public Timestamp getModifyDate();

public String getSequence();

public String getFail();

public String getSuggest();

public String getControl();

public String getHistory();


public  void setLocation(int value);

public  void setModifier(long value);

public  void setPersistent(String value);

public  void setTableName(String value);

public  void setState(String value);

public  void setTableId(long value);

public  void setCreater(long value);

public  void setBuffer(String value);

public  void setMultiple(String value);

public  void setBase(String value);

public  void setPlatform(String value);

public  void setCreateDate(Timestamp value);

public  void setDescription(String value);

public  void setModifyDate(Timestamp value);

public  void setSequence(String value);

public  void setFail(String value);

public  void setSuggest(String value);

public  void setControl(String value);

public  void setHistory(String value);
}
