package com.ai.sacenter.base.competence.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAProduct extends DataStructInterface{

  public final static  String S_Expire = "EXPIRE";
  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_ProductId = "PRODUCT_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Control = "CONTROL";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Creater = "CREATER";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Provider = "PROVIDER";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_Code = "CODE";
  public final static  String S_Effective = "EFFECTIVE";


public Timestamp getExpire();

public String getState();

public String getName();

public long getProductId();

public String getDescription();

public String getControl();

public Timestamp getModifyDate();

public String getCategory();

public long getCreater();

public Timestamp getCreateDate();

public String getProvider();

public long getModifier();

public long getSortBy();

public String getCode();

public Timestamp getEffective();


public  void setExpire(Timestamp value);

public  void setState(String value);

public  void setName(String value);

public  void setProductId(long value);

public  void setDescription(String value);

public  void setControl(String value);

public  void setModifyDate(Timestamp value);

public  void setCategory(String value);

public  void setCreater(long value);

public  void setCreateDate(Timestamp value);

public  void setProvider(String value);

public  void setModifier(long value);

public  void setSortBy(long value);

public  void setCode(String value);

public  void setEffective(Timestamp value);
}
