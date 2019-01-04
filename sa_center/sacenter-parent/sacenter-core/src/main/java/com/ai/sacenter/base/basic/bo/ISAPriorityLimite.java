package com.ai.sacenter.base.basic.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISAPriorityLimite extends DataStructInterface{

  public final static  String S_ExtendAttrL = "EXTEND_ATTR_L";
  public final static  String S_ExtendAttrK = "EXTEND_ATTR_K";
  public final static  String S_ExtendAttrJ = "EXTEND_ATTR_J";
  public final static  String S_ExtendAttrI = "EXTEND_ATTR_I";
  public final static  String S_ExtendAttrO = "EXTEND_ATTR_O";
  public final static  String S_ExtendAttrN = "EXTEND_ATTR_N";
  public final static  String S_ExtendAttrM = "EXTEND_ATTR_M";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_State = "STATE";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
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


public String getExtendAttrL();

public String getExtendAttrK();

public String getExtendAttrJ();

public String getExtendAttrI();

public String getExtendAttrO();

public String getExtendAttrN();

public String getExtendAttrM();

public int getSortBy();

public String getState();

public long getPriority();

public long getCreater();

public String getComposite();

public String getPlatform();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public long getId();

public String getComplex();

public long getModifier();

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


public  void setExtendAttrL(String value);

public  void setExtendAttrK(String value);

public  void setExtendAttrJ(String value);

public  void setExtendAttrI(String value);

public  void setExtendAttrO(String value);

public  void setExtendAttrN(String value);

public  void setExtendAttrM(String value);

public  void setSortBy(int value);

public  void setState(String value);

public  void setPriority(long value);

public  void setCreater(long value);

public  void setComposite(String value);

public  void setPlatform(String value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setId(long value);

public  void setComplex(String value);

public  void setModifier(long value);

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
}
