package com.ai.sacenter.base.basic.bo;

import java.sql.*;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SAPriorityBusines extends DataContainer implements DataContainerInterface,ISAPriorityBusines{
  private static final long serialVersionUID = -5833355018623838329L;
  private static String  m_boName = "com.ai.sacenter.base.basic.bo.SAPriorityBusines";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Business = "BUSINESS";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_State = "STATE";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Channel = "CHANNEL";
  public final static  String S_Compete = "COMPETE";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_Name = "NAME";
  public final static  String S_Catalog = "CATALOG";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Batches = "BATCHES";
  public final static  String S_Control = "CONTROL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAPriorityBusines() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initComplex(String value){
     this.initProperty(S_Complex,value);
  }
  public  void setComplex(String value){
     this.set(S_Complex,value);
  }
  public  void setComplexNull(){
     this.set(S_Complex,null);
  }

  public String getComplex(){
       return DataType.getAsString(this.get(S_Complex));
  
  }
  public String getComplexInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Complex));
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

  public void initBusiness(String value){
     this.initProperty(S_Business,value);
  }
  public  void setBusiness(String value){
     this.set(S_Business,value);
  }
  public  void setBusinessNull(){
     this.set(S_Business,null);
  }

  public String getBusiness(){
       return DataType.getAsString(this.get(S_Business));
  
  }
  public String getBusinessInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Business));
      }

  public void initSortBy(int value){
     this.initProperty(S_SortBy,new Integer(value));
  }
  public  void setSortBy(int value){
     this.set(S_SortBy,new Integer(value));
  }
  public  void setSortByNull(){
     this.set(S_SortBy,null);
  }

  public int getSortBy(){
        return DataType.getAsInt(this.get(S_SortBy));
  
  }
  public int getSortByInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SortBy));
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

  public void initPriority(int value){
     this.initProperty(S_Priority,new Integer(value));
  }
  public  void setPriority(int value){
     this.set(S_Priority,new Integer(value));
  }
  public  void setPriorityNull(){
     this.set(S_Priority,null);
  }

  public int getPriority(){
        return DataType.getAsInt(this.get(S_Priority));
  
  }
  public int getPriorityInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Priority));
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

  public void initComposite(String value){
     this.initProperty(S_Composite,value);
  }
  public  void setComposite(String value){
     this.set(S_Composite,value);
  }
  public  void setCompositeNull(){
     this.set(S_Composite,null);
  }

  public String getComposite(){
       return DataType.getAsString(this.get(S_Composite));
  
  }
  public String getCompositeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Composite));
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

  public void initChannel(String value){
     this.initProperty(S_Channel,value);
  }
  public  void setChannel(String value){
     this.set(S_Channel,value);
  }
  public  void setChannelNull(){
     this.set(S_Channel,null);
  }

  public String getChannel(){
       return DataType.getAsString(this.get(S_Channel));
  
  }
  public String getChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Channel));
      }

  public void initCompete(String value){
     this.initProperty(S_Compete,value);
  }
  public  void setCompete(String value){
     this.set(S_Compete,value);
  }
  public  void setCompeteNull(){
     this.set(S_Compete,null);
  }

  public String getCompete(){
       return DataType.getAsString(this.get(S_Compete));
  
  }
  public String getCompeteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Compete));
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

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
	  return DataType.getAsLong(this.get(S_Id));
  }
  
  public long getIdInitialValue(){
	  return DataType.getAsLong(this.getOldObj(S_Id));
  }

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  
  public  void setName(String value){
     this.set(S_Name,value);
  }
  
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
	  return DataType.getAsString(this.get(S_Name));
  }
  
  public String getNameInitialValue(){
	  return DataType.getAsString(this.getOldObj(S_Name));
  }

  public void initCatalog(String value){
     this.initProperty(S_Catalog,value);
  }
  
  public  void setCatalog(String value){
     this.set(S_Catalog,value);
  }
  
  public  void setCatalogNull(){
     this.set(S_Catalog,null);
  }

  public String getCatalog(){
	  return DataType.getAsString(this.get(S_Catalog));
  }
  
  public String getCatalogInitialValue(){
	  return DataType.getAsString(this.getOldObj(S_Catalog));
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

  public void initBatches(String value){
     this.initProperty(S_Batches,value);
  }
  public  void setBatches(String value){
     this.set(S_Batches,value);
  }
  public  void setBatchesNull(){
     this.set(S_Batches,null);
  }

  public String getBatches(){
       return DataType.getAsString(this.get(S_Batches));
  
  }
  public String getBatchesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Control));
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


 
 }

