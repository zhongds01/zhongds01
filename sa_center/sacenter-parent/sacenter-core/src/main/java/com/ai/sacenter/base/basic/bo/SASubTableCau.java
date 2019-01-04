package com.ai.sacenter.base.basic.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SASubTableCau extends DataContainer implements DataContainerInterface,ISASubTableCau{
  private static final long serialVersionUID = -200184148795382034L;
  private static String  m_boName = "com.ai.sacenter.base.basic.bo.SASubTableCau";
  public final static  String S_SuffixO = "SUFFIX_O";
  public final static  String S_TableName = "TABLE_NAME";
  public final static  String S_SuffixN = "SUFFIX_N";
  public final static  String S_ColumnName = "COLUMN_NAME";
  public final static  String S_ColumnValue = "COLUMN_VALUE";
  public final static  String S_ColumnId = "COLUMN_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SuffixA = "SUFFIX_A";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_SuffixE = "SUFFIX_E";
  public final static  String S_SuffixD = "SUFFIX_D";
  public final static  String S_SuffixC = "SUFFIX_C";
  public final static  String S_SuffixB = "SUFFIX_B";
  public final static  String S_SuffixI = "SUFFIX_I";
  public final static  String S_SuffixH = "SUFFIX_H";
  public final static  String S_SuffixG = "SUFFIX_G";
  public final static  String S_SuffixF = "SUFFIX_F";
  public final static  String S_SuffixM = "SUFFIX_M";
  public final static  String S_SuffixL = "SUFFIX_L";
  public final static  String S_SuffixK = "SUFFIX_K";
  public final static  String S_SuffixJ = "SUFFIX_J";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SASubTableCau() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initSuffixO(String value){
     this.initProperty(S_SuffixO,value);
  }
  public  void setSuffixO(String value){
     this.set(S_SuffixO,value);
  }
  public  void setSuffixONull(){
     this.set(S_SuffixO,null);
  }

  public String getSuffixO(){
       return DataType.getAsString(this.get(S_SuffixO));
  
  }
  public String getSuffixOInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixO));
      }

  public void initTableName(String value){
     this.initProperty(S_TableName,value);
  }
  public  void setTableName(String value){
     this.set(S_TableName,value);
  }
  public  void setTableNameNull(){
     this.set(S_TableName,null);
  }

  public String getTableName(){
       return DataType.getAsString(this.get(S_TableName));
  
  }
  public String getTableNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TableName));
      }

  public void initSuffixN(String value){
     this.initProperty(S_SuffixN,value);
  }
  public  void setSuffixN(String value){
     this.set(S_SuffixN,value);
  }
  public  void setSuffixNNull(){
     this.set(S_SuffixN,null);
  }

  public String getSuffixN(){
       return DataType.getAsString(this.get(S_SuffixN));
  
  }
  public String getSuffixNInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixN));
      }

  public void initColumnName(String value){
     this.initProperty(S_ColumnName,value);
  }
  public  void setColumnName(String value){
     this.set(S_ColumnName,value);
  }
  public  void setColumnNameNull(){
     this.set(S_ColumnName,null);
  }

  public String getColumnName(){
       return DataType.getAsString(this.get(S_ColumnName));
  
  }
  public String getColumnNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ColumnName));
      }

  public void initColumnValue(String value){
     this.initProperty(S_ColumnValue,value);
  }
  public  void setColumnValue(String value){
     this.set(S_ColumnValue,value);
  }
  public  void setColumnValueNull(){
     this.set(S_ColumnValue,null);
  }

  public String getColumnValue(){
       return DataType.getAsString(this.get(S_ColumnValue));
  
  }
  public String getColumnValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ColumnValue));
      }

  public void initColumnId(long value){
     this.initProperty(S_ColumnId,new Long(value));
  }
  public  void setColumnId(long value){
     this.set(S_ColumnId,new Long(value));
  }
  public  void setColumnIdNull(){
     this.set(S_ColumnId,null);
  }

  public long getColumnId(){
        return DataType.getAsLong(this.get(S_ColumnId));
  
  }
  public long getColumnIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ColumnId));
      }

  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initCreater(long value){
     this.initProperty(S_Creater,new Long(value));
  }
  public  void setCreater(long value){
     this.set(S_Creater,new Long(value));
  }
  public  void setCreaterNull(){
     this.set(S_Creater,null);
  }

  public long getCreater(){
        return DataType.getAsLong(this.get(S_Creater));
  
  }
  public long getCreaterInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Creater));
      }

  public void initPlatform(String value){
     this.initProperty(S_Platform,value);
  }
  public  void setPlatform(String value){
     this.set(S_Platform,value);
  }
  public  void setPlatformNull(){
     this.set(S_Platform,null);
  }

  public String getPlatform(){
       return DataType.getAsString(this.get(S_Platform));
  
  }
  public String getPlatformInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Platform));
      }

  public void initDescription(String value){
     this.initProperty(S_Description,value);
  }
  public  void setDescription(String value){
     this.set(S_Description,value);
  }
  public  void setDescriptionNull(){
     this.set(S_Description,null);
  }

  public String getDescription(){
       return DataType.getAsString(this.get(S_Description));
  
  }
  public String getDescriptionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Description));
      }

  public void initModifyDate(Timestamp value){
     this.initProperty(S_ModifyDate,value);
  }
  public  void setModifyDate(Timestamp value){
     this.set(S_ModifyDate,value);
  }
  public  void setModifyDateNull(){
     this.set(S_ModifyDate,null);
  }

  public Timestamp getModifyDate(){
        return DataType.getAsDateTime(this.get(S_ModifyDate));
  
  }
  public Timestamp getModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
      }

  public void initModifier(long value){
     this.initProperty(S_Modifier,new Long(value));
  }
  public  void setModifier(long value){
     this.set(S_Modifier,new Long(value));
  }
  public  void setModifierNull(){
     this.set(S_Modifier,null);
  }

  public long getModifier(){
        return DataType.getAsLong(this.get(S_Modifier));
  
  }
  public long getModifierInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Modifier));
      }

  public void initSuffixA(String value){
     this.initProperty(S_SuffixA,value);
  }
  public  void setSuffixA(String value){
     this.set(S_SuffixA,value);
  }
  public  void setSuffixANull(){
     this.set(S_SuffixA,null);
  }

  public String getSuffixA(){
       return DataType.getAsString(this.get(S_SuffixA));
  
  }
  public String getSuffixAInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixA));
      }

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
      }

  public void initSuffixE(String value){
     this.initProperty(S_SuffixE,value);
  }
  public  void setSuffixE(String value){
     this.set(S_SuffixE,value);
  }
  public  void setSuffixENull(){
     this.set(S_SuffixE,null);
  }

  public String getSuffixE(){
       return DataType.getAsString(this.get(S_SuffixE));
  
  }
  public String getSuffixEInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixE));
      }

  public void initSuffixD(String value){
     this.initProperty(S_SuffixD,value);
  }
  public  void setSuffixD(String value){
     this.set(S_SuffixD,value);
  }
  public  void setSuffixDNull(){
     this.set(S_SuffixD,null);
  }

  public String getSuffixD(){
       return DataType.getAsString(this.get(S_SuffixD));
  
  }
  public String getSuffixDInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixD));
      }

  public void initSuffixC(String value){
     this.initProperty(S_SuffixC,value);
  }
  public  void setSuffixC(String value){
     this.set(S_SuffixC,value);
  }
  public  void setSuffixCNull(){
     this.set(S_SuffixC,null);
  }

  public String getSuffixC(){
       return DataType.getAsString(this.get(S_SuffixC));
  
  }
  public String getSuffixCInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixC));
      }

  public void initSuffixB(String value){
     this.initProperty(S_SuffixB,value);
  }
  public  void setSuffixB(String value){
     this.set(S_SuffixB,value);
  }
  public  void setSuffixBNull(){
     this.set(S_SuffixB,null);
  }

  public String getSuffixB(){
       return DataType.getAsString(this.get(S_SuffixB));
  
  }
  public String getSuffixBInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixB));
      }

  public void initSuffixI(String value){
     this.initProperty(S_SuffixI,value);
  }
  public  void setSuffixI(String value){
     this.set(S_SuffixI,value);
  }
  public  void setSuffixINull(){
     this.set(S_SuffixI,null);
  }

  public String getSuffixI(){
       return DataType.getAsString(this.get(S_SuffixI));
  
  }
  public String getSuffixIInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixI));
      }

  public void initSuffixH(String value){
     this.initProperty(S_SuffixH,value);
  }
  public  void setSuffixH(String value){
     this.set(S_SuffixH,value);
  }
  public  void setSuffixHNull(){
     this.set(S_SuffixH,null);
  }

  public String getSuffixH(){
       return DataType.getAsString(this.get(S_SuffixH));
  
  }
  public String getSuffixHInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixH));
      }

  public void initSuffixG(String value){
     this.initProperty(S_SuffixG,value);
  }
  public  void setSuffixG(String value){
     this.set(S_SuffixG,value);
  }
  public  void setSuffixGNull(){
     this.set(S_SuffixG,null);
  }

  public String getSuffixG(){
       return DataType.getAsString(this.get(S_SuffixG));
  
  }
  public String getSuffixGInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixG));
      }

  public void initSuffixF(String value){
     this.initProperty(S_SuffixF,value);
  }
  public  void setSuffixF(String value){
     this.set(S_SuffixF,value);
  }
  public  void setSuffixFNull(){
     this.set(S_SuffixF,null);
  }

  public String getSuffixF(){
       return DataType.getAsString(this.get(S_SuffixF));
  
  }
  public String getSuffixFInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixF));
      }

  public void initSuffixM(String value){
     this.initProperty(S_SuffixM,value);
  }
  public  void setSuffixM(String value){
     this.set(S_SuffixM,value);
  }
  public  void setSuffixMNull(){
     this.set(S_SuffixM,null);
  }

  public String getSuffixM(){
       return DataType.getAsString(this.get(S_SuffixM));
  
  }
  public String getSuffixMInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixM));
      }

  public void initSuffixL(String value){
     this.initProperty(S_SuffixL,value);
  }
  public  void setSuffixL(String value){
     this.set(S_SuffixL,value);
  }
  public  void setSuffixLNull(){
     this.set(S_SuffixL,null);
  }

  public String getSuffixL(){
       return DataType.getAsString(this.get(S_SuffixL));
  
  }
  public String getSuffixLInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixL));
      }

  public void initSuffixK(String value){
     this.initProperty(S_SuffixK,value);
  }
  public  void setSuffixK(String value){
     this.set(S_SuffixK,value);
  }
  public  void setSuffixKNull(){
     this.set(S_SuffixK,null);
  }

  public String getSuffixK(){
       return DataType.getAsString(this.get(S_SuffixK));
  
  }
  public String getSuffixKInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixK));
      }

  public void initSuffixJ(String value){
     this.initProperty(S_SuffixJ,value);
  }
  public  void setSuffixJ(String value){
     this.set(S_SuffixJ,value);
  }
  public  void setSuffixJNull(){
     this.set(S_SuffixJ,null);
  }

  public String getSuffixJ(){
       return DataType.getAsString(this.get(S_SuffixJ));
  
  }
  public String getSuffixJInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuffixJ));
      }


 
 }

