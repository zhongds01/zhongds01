package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISASubTableCau extends DataStructInterface{

  public final static  String S_SuffixO = "SUFFIX_O";
  public final static  String S_TableName = "TABLE_NAME";
  public final static  String S_SuffixN = "SUFFIX_N";
  public final static  String S_ColumnName = "COLUMN_NAME";
  public final static  String S_ColumnValue = "COLUMN_VALUE";
  public final static  String S_ColumnId = "COLUMN_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SuffixA = "SUFFIX_A";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_SuffixE = "SUFFIX_E";
  public final static  String S_SuffixD = "SUFFIX_D";
  public final static  String S_SuffixC = "SUFFIX_C";
  public final static  String S_SuffixB = "SUFFIX_B";
  public final static  String S_SuffixI = "SUFFIX_I";
  public final static  String S_SuffixH = "SUFFIX_H";
  public final static  String S_SuffixG = "SUFFIX_G";
  public final static  String S_SuffixF = "SUFFIX_F";
  public final static  String S_SuffixM = "SUFFIX_M";
  public final static  String S_SuffixL = "SUFFIX_L";
  public final static  String S_SuffixK = "SUFFIX_K";
  public final static  String S_SuffixJ = "SUFFIX_J";


public String getSuffixO();

public String getTableName();

public String getSuffixN();

public String getColumnName();

public String getColumnValue();

public long getColumnId();

public String getState();

public long getCreater();

public String getPlatform();

public String getDescription();

public Timestamp getModifyDate();

public long getModifier();

public String getSuffixA();

public Timestamp getCreateDate();

public String getSuffixE();

public String getSuffixD();

public String getSuffixC();

public String getSuffixB();

public String getSuffixI();

public String getSuffixH();

public String getSuffixG();

public String getSuffixF();

public String getSuffixM();

public String getSuffixL();

public String getSuffixK();

public String getSuffixJ();


public  void setSuffixO(String value);

public  void setTableName(String value);

public  void setSuffixN(String value);

public  void setColumnName(String value);

public  void setColumnValue(String value);

public  void setColumnId(long value);

public  void setState(String value);

public  void setCreater(long value);

public  void setPlatform(String value);

public  void setDescription(String value);

public  void setModifyDate(Timestamp value);

public  void setModifier(long value);

public  void setSuffixA(String value);

public  void setCreateDate(Timestamp value);

public  void setSuffixE(String value);

public  void setSuffixD(String value);

public  void setSuffixC(String value);

public  void setSuffixB(String value);

public  void setSuffixI(String value);

public  void setSuffixH(String value);

public  void setSuffixG(String value);

public  void setSuffixF(String value);

public  void setSuffixM(String value);

public  void setSuffixL(String value);

public  void setSuffixK(String value);

public  void setSuffixJ(String value);
}
