package com.ai.sacenter.base.competence.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAComptelRel extends DataStructInterface{

  public final static  String S_Expire = "EXPIRE";
  public final static  String S_State = "STATE";
  public final static  String S_ExtendId = "EXTEND_ID";
  public final static  String S_ProductId = "PRODUCT_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Checking = "CHECKING";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Creater = "CREATER";
  public final static  String S_CompeteId = "COMPETE_ID";
  public final static  String S_Id = "ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_Effective = "EFFECTIVE";


public Timestamp getExpire();

public String getState();

public String getExtendId();

public long getProductId();

public String getDescription();

public String getChecking();

public String getImplclass();

public Timestamp getModifyDate();

public String getComplex();

public long getCreater();

public long getCompeteId();

public long getId();

public Timestamp getCreateDate();

public long getModifier();

public int getSortBy();

public Timestamp getEffective();


public  void setExpire(Timestamp value);

public  void setState(String value);

public  void setExtendId(String value);

public  void setProductId(long value);

public  void setDescription(String value);

public  void setChecking(String value);

public  void setImplclass(String value);

public  void setModifyDate(Timestamp value);

public  void setComplex(String value);

public  void setCreater(long value);

public  void setCompeteId(long value);

public  void setId(long value);

public  void setCreateDate(Timestamp value);

public  void setModifier(long value);

public  void setSortBy(int value);

public  void setEffective(Timestamp value);
}
