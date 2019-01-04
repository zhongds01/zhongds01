package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISASubTableCol extends DataStructInterface{

  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_TableName = "TABLE_NAME";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_ColumnId = "COLUMN_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_DestColumn = "DEST_COLUMN";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_SrcColumn = "SRC_COLUMN";
  public final static  String S_Control = "CONTROL";


public String getComplex();

public long getModifier();

public String getTableName();

public int getSortBy();

public long getColumnId();

public String getState();

public long getCreater();

public String getDestColumn();

public String getImplclass();

public String getPlatform();

public Timestamp getCreateDate();

public String getDescription();

public String getCategory();

public Timestamp getModifyDate();

public String getSrcColumn();

public String getControl();


public  void setComplex(String value);

public  void setModifier(long value);

public  void setTableName(String value);

public  void setSortBy(int value);

public  void setColumnId(long value);

public  void setState(String value);

public  void setCreater(long value);

public  void setDestColumn(String value);

public  void setImplclass(String value);

public  void setPlatform(String value);

public  void setCreateDate(Timestamp value);

public  void setDescription(String value);

public  void setCategory(String value);

public  void setModifyDate(Timestamp value);

public  void setSrcColumn(String value);

public  void setControl(String value);
}
