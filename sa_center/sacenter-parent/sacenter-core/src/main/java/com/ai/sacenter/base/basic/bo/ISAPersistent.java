package com.ai.sacenter.base.basic.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISAPersistent extends DataStructInterface{

  public final static  String S_ExtendAttrL = "EXTEND_ATTR_L";
  public final static  String S_ExtendAttrK = "EXTEND_ATTR_K";
  public final static  String S_ExtendAttrJ = "EXTEND_ATTR_J";
  public final static  String S_ExtendAttrI = "EXTEND_ATTR_I";
  public final static  String S_ExtendAttrO = "EXTEND_ATTR_O";
  public final static  String S_ExtendAttrN = "EXTEND_ATTR_N";
  public final static  String S_ExtendAttrM = "EXTEND_ATTR_M";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_Describe = "DESCRIBE";
  public final static  String S_Cycle = "CYCLE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Persistent = "PERSISTENT";
  public final static  String S_Failure = "FAILURE";
  public final static  String S_Name = "NAME";
  public final static  String S_Code = "CODE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_ExtendAttrD = "EXTEND_ATTR_D";
  public final static  String S_ExtendAttrC = "EXTEND_ATTR_C";
  public final static  String S_ExtendAttrB = "EXTEND_ATTR_B";
  public final static  String S_ExtendAttrA = "EXTEND_ATTR_A";
  public final static  String S_ExtendAttrH = "EXTEND_ATTR_H";
  public final static  String S_ExtendAttrG = "EXTEND_ATTR_G";
  public final static  String S_ExtendAttrF = "EXTEND_ATTR_F";
  public final static  String S_Control = "CONTROL";
  public final static  String S_ExtendAttrE = "EXTEND_ATTR_E";
  public final static  String S_History = "HISTORY";


public String getExtendAttrL();

public String getExtendAttrK();

public String getExtendAttrJ();

public String getExtendAttrI();

public String getExtendAttrO();

public String getExtendAttrN();

public String getExtendAttrM();

public String getState();

public long getCreater();

public Timestamp getModifyDate();

public long getId();

public String getDescribe();

public long getCycle();

public long getModifier();

public String getPersistent();

public String getFailure();

public String getName();

public String getCode();

public Timestamp getCreateDate();

public String getExtendAttrD();

public String getExtendAttrC();

public String getExtendAttrB();

public String getExtendAttrA();

public String getExtendAttrH();

public String getExtendAttrG();

public String getExtendAttrF();

public String getControl();

public String getExtendAttrE();

public String getHistory();


public  void setExtendAttrL(String value);

public  void setExtendAttrK(String value);

public  void setExtendAttrJ(String value);

public  void setExtendAttrI(String value);

public  void setExtendAttrO(String value);

public  void setExtendAttrN(String value);

public  void setExtendAttrM(String value);

public  void setState(String value);

public  void setCreater(long value);

public  void setModifyDate(Timestamp value);

public  void setId(long value);

public  void setDescribe(String value);

public  void setCycle(long value);

public  void setModifier(long value);

public  void setPersistent(String value);

public  void setFailure(String value);

public  void setName(String value);

public  void setCode(String value);

public  void setCreateDate(Timestamp value);

public  void setExtendAttrD(String value);

public  void setExtendAttrC(String value);

public  void setExtendAttrB(String value);

public  void setExtendAttrA(String value);

public  void setExtendAttrH(String value);

public  void setExtendAttrG(String value);

public  void setExtendAttrF(String value);

public  void setControl(String value);

public  void setExtendAttrE(String value);

public  void setHistory(String value);
}
