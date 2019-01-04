package com.ai.sacenter.base.competence.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAComponentRel extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Name = "NAME";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Id = "ID";
  public final static  String S_Component = "COMPONENT";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Subfigure = "SUBFIGURE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_ModifyDate = "MODIFY_DATE";


public String getState();

public String getCategory();

public String getName();

public long getCreater();

public String getComplex();

public long getId();

public String getComponent();

public Timestamp getCreateDate();

public String getSubfigure();

public long getModifier();

public int getSortBy();

public Timestamp getModifyDate();


public  void setState(String value);

public  void setCategory(String value);

public  void setName(String value);

public  void setCreater(long value);

public  void setComplex(String value);

public  void setId(long value);

public  void setComponent(String value);

public  void setCreateDate(Timestamp value);

public  void setSubfigure(String value);

public  void setModifier(long value);

public  void setSortBy(int value);

public  void setModifyDate(Timestamp value);
}
