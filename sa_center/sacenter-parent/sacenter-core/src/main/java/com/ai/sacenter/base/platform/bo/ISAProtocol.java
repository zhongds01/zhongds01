package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAProtocol extends DataStructInterface{

  public final static  String S_Plmmx11 = "PLMMX_11";
  public final static  String S_Plmmx10 = "PLMMX_10";
  public final static  String S_Plmmx15 = "PLMMX_15";
  public final static  String S_Plmmx14 = "PLMMX_14";
  public final static  String S_Plmmx13 = "PLMMX_13";
  public final static  String S_Plmmx12 = "PLMMX_12";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_PlmxType = "PLMX_TYPE";
  public final static  String S_Id = "ID";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Plmmx04 = "PLMMX_04";
  public final static  String S_Plmmx03 = "PLMMX_03";
  public final static  String S_Plmmx02 = "PLMMX_02";
  public final static  String S_Plmmx01 = "PLMMX_01";
  public final static  String S_Plmmx08 = "PLMMX_08";
  public final static  String S_Plmmx07 = "PLMMX_07";
  public final static  String S_Plmmx06 = "PLMMX_06";
  public final static  String S_Files = "FILES";
  public final static  String S_Plmmx05 = "PLMMX_05";
  public final static  String S_Name = "NAME";
  public final static  String S_Plmmx09 = "PLMMX_09";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_FileType = "FILE_TYPE";


public String getPlmmx11();

public String getPlmmx10();

public String getPlmmx15();

public String getPlmmx14();

public String getPlmmx13();

public String getPlmmx12();

public String getState();

public long getCreater();

public String getPlatform();

public String getDescription();

public Timestamp getModifyDate();

public String getPlmxType();

public String getId();

public long getModifier();

public String getPlmmx04();

public String getPlmmx03();

public String getPlmmx02();

public String getPlmmx01();

public String getPlmmx08();

public String getPlmmx07();

public String getPlmmx06();

public String getFiles();

public String getPlmmx05();

public String getName();

public String getPlmmx09();

public Timestamp getCreateDate();

public String getFileType();


public  void setPlmmx11(String value);

public  void setPlmmx10(String value);

public  void setPlmmx15(String value);

public  void setPlmmx14(String value);

public  void setPlmmx13(String value);

public  void setPlmmx12(String value);

public  void setState(String value);

public  void setCreater(long value);

public  void setPlatform(String value);

public  void setDescription(String value);

public  void setModifyDate(Timestamp value);

public  void setPlmxType(String value);

public  void setId(String value);

public  void setModifier(long value);

public  void setPlmmx04(String value);

public  void setPlmmx03(String value);

public  void setPlmmx02(String value);

public  void setPlmmx01(String value);

public  void setPlmmx08(String value);

public  void setPlmmx07(String value);

public  void setPlmmx06(String value);

public  void setFiles(String value);

public  void setPlmmx05(String value);

public  void setName(String value);

public  void setPlmmx09(String value);

public  void setCreateDate(Timestamp value);

public  void setFileType(String value);
}
