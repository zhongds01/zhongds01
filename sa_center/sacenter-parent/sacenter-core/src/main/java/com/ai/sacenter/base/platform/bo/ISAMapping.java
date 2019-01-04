package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAMapping extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Name = "NAME";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Module = "MODULE";
  public final static  String S_Id = "ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Code = "CODE";


public String getState();

public String getCategory();

public String getName();

public long getCreater();

public String getDescription();

public String getModule();

public long getId();

public Timestamp getCreateDate();

public long getModifier();

public Timestamp getModifyDate();

public String getCode();


public  void setState(String value);

public  void setCategory(String value);

public  void setName(String value);

public  void setCreater(long value);

public  void setDescription(String value);

public  void setModule(String value);

public  void setId(long value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setModifyDate(Timestamp value);

public  void setCode(String value);
}
