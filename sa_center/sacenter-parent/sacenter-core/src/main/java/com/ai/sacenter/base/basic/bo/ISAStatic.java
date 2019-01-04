package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;

public interface ISAStatic extends DataStructInterface{

  public final static  String S_Code = "CODE";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Alias = "ALIAS";
  public final static  String S_Kind = "KIND";
  public final static  String S_State = "STATE";
  public final static  String S_Id = "ID";
  public final static  String S_Value = "VALUE";
  public final static  String S_Extern = "EXTERN";
  public final static  String S_Name = "NAME";


public String getCode();

public int getSortId();

public String getDescription();

public String getAlias();

public String getKind();

public String getState();

public long getId();

public String getValue();

public String getExtern();

public String getName();


public  void setCode(String value);

public  void setSortId(int value);

public  void setDescription(String value);

public  void setAlias(String value);

public  void setKind(String value);

public  void setState(String value);

public  void setId(long value);

public  void setValue(String value);

public  void setExtern(String value);

public  void setName(String value);
}
