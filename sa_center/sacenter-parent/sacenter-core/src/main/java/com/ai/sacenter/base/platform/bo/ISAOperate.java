package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAOperate extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Control = "CONTROL";
  public final static  String S_Rsltflg = "RSLTFLG";
  public final static  String S_PsType = "PS_TYPE";
  public final static  String S_Syncflg = "SYNCFLG";
  public final static  String S_RedoTimes = "REDO_TIMES";
  public final static  String S_Request = "REQUEST";
  public final static  String S_PsService = "PS_SERVICE";
  public final static  String S_Plosflg = "PLOSFLG";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Monitor = "MONITOR";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Response = "RESPONSE";
  public final static  String S_Id = "ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Code = "CODE";


public String getState();

public String getName();

public String getDescription();

public String getPriority();

public String getControl();

public String getRsltflg();

public String getPsType();

public String getSyncflg();

public long getRedoTimes();

public String getRequest();

public String getPsService();

public String getPlosflg();

public Timestamp getModifyDate();

public String getMonitor();

public String getCategory();

public String getComplex();

public String getComposite();

public long getCreater();

public String getPlatform();

public String getResponse();

public String getId();

public Timestamp getCreateDate();

public long getModifier();

public String getCode();


public  void setState(String value);

public  void setName(String value);

public  void setDescription(String value);

public  void setPriority(String value);

public  void setControl(String value);

public  void setRsltflg(String value);

public  void setPsType(String value);

public  void setSyncflg(String value);

public  void setRedoTimes(long value);

public  void setRequest(String value);

public  void setPsService(String value);

public  void setPlosflg(String value);

public  void setModifyDate(Timestamp value);

public  void setMonitor(String value);

public  void setCategory(String value);

public  void setComplex(String value);

public  void setComposite(String value);

public  void setCreater(long value);

public  void setPlatform(String value);

public  void setResponse(String value);

public  void setId(String value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setCode(String value);
}
