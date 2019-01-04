package com.ai.sacenter.base.basic.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface ISAParallel extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Expire = "EXPIRE";
  public final static  String S_Effective = "EFFECTIVE";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Originate = "ORIGINATE";
  public final static  String S_Id = "ID";
  public final static  String S_Parallel = "PARALLEL";


public String getRegionId();

public String getComplex();

public long getModifier();

public Timestamp getExpire();

public Timestamp getEffective();

public String getState();

public long getCreater();

public Timestamp getCreateDate();

public String getDescription();

public Timestamp getModifyDate();

public String getOriginate();

public long getId();

public String getParallel();


public  void setRegionId(String value);

public  void setComplex(String value);

public  void setModifier(long value);

public  void setExpire(Timestamp value);

public  void setEffective(Timestamp value);

public  void setState(String value);

public  void setCreater(long value);

public  void setCreateDate(Timestamp value);

public  void setDescription(String value);

public  void setModifyDate(Timestamp value);

public  void setOriginate(String value);

public  void setId(long value);

public  void setParallel(String value);
}
