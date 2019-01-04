package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISACenterCatalog extends DataStructInterface{

  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Name = "NAME";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_Describe = "DESCRIBE";


public String getComplex();

public long getModifier();

public int getSortBy();

public String getState();

public long getCreater();

public String getImplclass();

public String getComposite();

public String getName();

public String getPlatform();

public Timestamp getCreateDate();

public String getCategory();

public Timestamp getModifyDate();

public long getId();

public String getDescribe();


public  void setComplex(String value);

public  void setModifier(long value);

public  void setSortBy(int value);

public  void setState(String value);

public  void setCreater(long value);

public  void setImplclass(String value);

public  void setComposite(String value);

public  void setName(String value);

public  void setPlatform(String value);

public  void setCreateDate(Timestamp value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setId(long value);

public  void setDescribe(String value);
}
