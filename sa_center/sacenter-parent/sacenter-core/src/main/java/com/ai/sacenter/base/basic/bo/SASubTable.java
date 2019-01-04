package com.ai.sacenter.base.basic.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SASubTable extends DataContainer implements DataContainerInterface,ISASubTable{
  private static final long serialVersionUID = 8995991389055007645L;
  private static String  m_boName = "com.ai.sacenter.base.basic.bo.SASubTable";
  public final static  String S_Location = "LOCATION";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Persistent = "PERSISTENT";
  public final static  String S_TableName = "TABLE_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_TableId = "TABLE_ID";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Buffer = "BUFFER";
  public final static  String S_Multiple = "MULTIPLE";
  public final static  String S_Base = "BASE";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Sequence = "SEQUENCE";
  public final static  String S_Fail = "FAIL";
  public final static  String S_Suggest = "SUGGEST";
  public final static  String S_Control = "CONTROL";
  public final static  String S_History = "HISTORY";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SASubTable() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initLocation(int value){
     this.initProperty(S_Location,new Integer(value));
  }
  public  void setLocation(int value){
     this.set(S_Location,new Integer(value));
  }
  public  void setLocationNull(){
     this.set(S_Location,null);
  }

  public int getLocation(){
        return DataType.getAsInt(this.get(S_Location));
  
  }
  public int getLocationInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Location));
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

  public void initPersistent(String value){
     this.initProperty(S_Persistent,value);
  }
  public  void setPersistent(String value){
     this.set(S_Persistent,value);
  }
  public  void setPersistentNull(){
     this.set(S_Persistent,null);
  }

  public String getPersistent(){
       return DataType.getAsString(this.get(S_Persistent));
  
  }
  public String getPersistentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Persistent));
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

  public void initTableId(long value){
     this.initProperty(S_TableId,new Long(value));
  }
  public  void setTableId(long value){
     this.set(S_TableId,new Long(value));
  }
  public  void setTableIdNull(){
     this.set(S_TableId,null);
  }

  public long getTableId(){
        return DataType.getAsLong(this.get(S_TableId));
  
  }
  public long getTableIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TableId));
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

  public void initBuffer(String value){
     this.initProperty(S_Buffer,value);
  }
  public  void setBuffer(String value){
     this.set(S_Buffer,value);
  }
  public  void setBufferNull(){
     this.set(S_Buffer,null);
  }

  public String getBuffer(){
       return DataType.getAsString(this.get(S_Buffer));
  
  }
  public String getBufferInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Buffer));
      }

  public void initMultiple(String value){
     this.initProperty(S_Multiple,value);
  }
  public  void setMultiple(String value){
     this.set(S_Multiple,value);
  }
  public  void setMultipleNull(){
     this.set(S_Multiple,null);
  }

  public String getMultiple(){
       return DataType.getAsString(this.get(S_Multiple));
  
  }
  public String getMultipleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Multiple));
      }

  public void initBase(String value){
     this.initProperty(S_Base,value);
  }
  public  void setBase(String value){
     this.set(S_Base,value);
  }
  public  void setBaseNull(){
     this.set(S_Base,null);
  }

  public String getBase(){
       return DataType.getAsString(this.get(S_Base));
  
  }
  public String getBaseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Base));
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

  public void initSequence(String value){
     this.initProperty(S_Sequence,value);
  }
  public  void setSequence(String value){
     this.set(S_Sequence,value);
  }
  public  void setSequenceNull(){
     this.set(S_Sequence,null);
  }

  public String getSequence(){
       return DataType.getAsString(this.get(S_Sequence));
  
  }
  public String getSequenceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Sequence));
      }

  public void initFail(String value){
     this.initProperty(S_Fail,value);
  }
  public  void setFail(String value){
     this.set(S_Fail,value);
  }
  public  void setFailNull(){
     this.set(S_Fail,null);
  }

  public String getFail(){
       return DataType.getAsString(this.get(S_Fail));
  
  }
  public String getFailInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Fail));
      }

  public void initSuggest(String value){
     this.initProperty(S_Suggest,value);
  }
  public  void setSuggest(String value){
     this.set(S_Suggest,value);
  }
  public  void setSuggestNull(){
     this.set(S_Suggest,null);
  }

  public String getSuggest(){
       return DataType.getAsString(this.get(S_Suggest));
  
  }
  public String getSuggestInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Suggest));
      }

  public void initControl(String value){
     this.initProperty(S_Control,value);
  }
  public  void setControl(String value){
     this.set(S_Control,value);
  }
  public  void setControlNull(){
     this.set(S_Control,null);
  }

  public String getControl(){
       return DataType.getAsString(this.get(S_Control));
  
  }
  public String getControlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Control));
      }

  public void initHistory(String value){
     this.initProperty(S_History,value);
  }
  public  void setHistory(String value){
     this.set(S_History,value);
  }
  public  void setHistoryNull(){
     this.set(S_History,null);
  }

  public String getHistory(){
       return DataType.getAsString(this.get(S_History));
  
  }
  public String getHistoryInitialValue(){
        return DataType.getAsString(this.getOldObj(S_History));
      }


 
 }

