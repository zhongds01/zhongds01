package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAOperateX extends DataStructInterface{

  public final static  String S_InfoValue = "INFO_VALUE";
  public final static  String S_InfoCode = "INFO_CODE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Operate = "OPERATE";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Name = "NAME";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";


public String getInfoValue();

public String getInfoCode();

public long getModifier();

public String getOperate();

public int getSortBy();

public String getState();

public long getCreater();

public String getName();

public String getPlatform();

public Timestamp getCreateDate();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public long getId();


public  void setInfoValue(String value);

public  void setInfoCode(String value);

public  void setModifier(long value);

public  void setOperate(String value);

public  void setSortBy(int value);

public  void setState(String value);

public  void setCreater(long value);

public  void setName(String value);

public  void setPlatform(String value);

public  void setCreateDate(Timestamp value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setId(long value);
}
