package com.ai.sacenter.base.basic.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISAI18nResource extends DataStructInterface{

  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Expire = "EXPIRE";
  public final static  String S_Alias = "ALIAS";
  public final static  String S_Extend = "EXTEND";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_Effective = "EFFECTIVE";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Name = "NAME";
  public final static  String S_Code = "CODE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Domain = "DOMAIN";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";


public long getModifier();

public Timestamp getExpire();

public String getAlias();

public String getExtend();

public long getSortBy();

public Timestamp getEffective();

public String getState();

public long getCreater();

public String getName();

public String getCode();

public Timestamp getCreateDate();

public String getDomain();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public long getId();


public  void setModifier(long value);

public  void setExpire(Timestamp value);

public  void setAlias(String value);

public  void setExtend(String value);

public  void setSortBy(long value);

public  void setEffective(Timestamp value);

public  void setState(String value);

public  void setCreater(long value);

public  void setName(String value);

public  void setCode(String value);

public  void setCreateDate(Timestamp value);

public  void setDomain(String value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setId(long value);
}
