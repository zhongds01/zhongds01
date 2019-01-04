package com.ai.sacenter.base.competence.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SAProduct extends DataContainer implements DataContainerInterface,ISAProduct{
  private static final long serialVersionUID = -4743512728785627291L;
  private static String  m_boName = "com.ai.sacenter.base.competence.bo.SAProduct";
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

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAProduct() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initExpire(Timestamp value){
     this.initProperty(S_Expire,value);
  }
  public  void setExpire(Timestamp value){
     this.set(S_Expire,value);
  }
  public  void setExpireNull(){
     this.set(S_Expire,null);
  }

  public Timestamp getExpire(){
        return DataType.getAsDateTime(this.get(S_Expire));
  
  }
  public Timestamp getExpireInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_Expire));
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

  public void initProductId(long value){
     this.initProperty(S_ProductId,new Long(value));
  }
  public  void setProductId(long value){
     this.set(S_ProductId,new Long(value));
  }
  public  void setProductIdNull(){
     this.set(S_ProductId,null);
  }

  public long getProductId(){
        return DataType.getAsLong(this.get(S_ProductId));
  
  }
  public long getProductIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProductId));
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

  public void initCategory(String value){
     this.initProperty(S_Category,value);
  }
  public  void setCategory(String value){
     this.set(S_Category,value);
  }
  public  void setCategoryNull(){
     this.set(S_Category,null);
  }

  public String getCategory(){
       return DataType.getAsString(this.get(S_Category));
  
  }
  public String getCategoryInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Category));
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

  public void initProvider(String value){
     this.initProperty(S_Provider,value);
  }
  public  void setProvider(String value){
     this.set(S_Provider,value);
  }
  public  void setProviderNull(){
     this.set(S_Provider,null);
  }

  public String getProvider(){
       return DataType.getAsString(this.get(S_Provider));
  
  }
  public String getProviderInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Provider));
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

  public void initSortBy(long value){
     this.initProperty(S_SortBy,new Long(value));
  }
  public  void setSortBy(long value){
     this.set(S_SortBy,new Long(value));
  }
  public  void setSortByNull(){
     this.set(S_SortBy,null);
  }

  public long getSortBy(){
        return DataType.getAsLong(this.get(S_SortBy));
  
  }
  public long getSortByInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SortBy));
      }

  public void initCode(String value){
     this.initProperty(S_Code,value);
  }
  public  void setCode(String value){
     this.set(S_Code,value);
  }
  public  void setCodeNull(){
     this.set(S_Code,null);
  }

  public String getCode(){
       return DataType.getAsString(this.get(S_Code));
  
  }
  public String getCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Code));
      }

  public void initEffective(Timestamp value){
     this.initProperty(S_Effective,value);
  }
  public  void setEffective(Timestamp value){
     this.set(S_Effective,value);
  }
  public  void setEffectiveNull(){
     this.set(S_Effective,null);
  }

  public Timestamp getEffective(){
        return DataType.getAsDateTime(this.get(S_Effective));
  
  }
  public Timestamp getEffectiveInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_Effective));
      }


 
 }

