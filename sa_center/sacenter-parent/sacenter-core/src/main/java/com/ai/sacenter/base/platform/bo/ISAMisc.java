package com.ai.sacenter.base.platform.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAMisc extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Mapping = "MAPPING";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Id = "ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Provider = "PROVIDER";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Compete = "COMPETE";
  public final static  String S_SortBy = "SORT_BY";


public String getState();

public String getName();

public String getDescription();

public String getMapping();

public Timestamp getModifyDate();

public String getComplex();

public long getCreater();

public String getPlatform();

public long getId();

public Timestamp getCreateDate();

public String getProvider();

public long getModifier();

public String getCompete();

public long getSortBy();


public  void setState(String value);

public  void setName(String value);

public  void setDescription(String value);

public  void setMapping(String value);

public  void setModifyDate(Timestamp value);

public  void setComplex(String value);

public  void setCreater(long value);

public  void setPlatform(String value);

public  void setId(long value);

public  void setCreateDate(Timestamp value);

public  void setProvider(String value);

public  void setModifier(long value);

public  void setCompete(String value);

public  void setSortBy(long value);
}
