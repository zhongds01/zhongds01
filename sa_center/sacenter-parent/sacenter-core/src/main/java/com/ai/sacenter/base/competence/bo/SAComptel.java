package com.ai.sacenter.base.competence.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SAComptel extends DataContainer implements DataContainerInterface,ISAComptel{
  private static final long serialVersionUID = -5907727905096201927L;
  private static String  m_boName = "com.ai.sacenter.base.competence.bo.SAComptel";
  public final static  String S_Expire = "EXPIRE";
  public final static  String S_State = "STATE";
  public final static  String S_ExtendId = "EXTEND_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Checking = "CHECKING";
  public final static  String S_Subflow = "SUBFLOW";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Creater = "CREATER";
  public final static  String S_CompeteId = "COMPETE_ID";
  public final static  String S_Id = "ID";
  public final static  String S_Business = "BUSINESS";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_Effective = "EFFECTIVE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAComptel() throws AIException{
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

  public void initExtendId(String value){
     this.initProperty(S_ExtendId,value);
  }
  public  void setExtendId(String value){
     this.set(S_ExtendId,value);
  }
  public  void setExtendIdNull(){
     this.set(S_ExtendId,null);
  }

  public String getExtendId(){
       return DataType.getAsString(this.get(S_ExtendId));
  
  }
  public String getExtendIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendId));
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

  public void initChecking(String value){
     this.initProperty(S_Checking,value);
  }
  public  void setChecking(String value){
     this.set(S_Checking,value);
  }
  public  void setCheckingNull(){
     this.set(S_Checking,null);
  }

  public String getChecking(){
       return DataType.getAsString(this.get(S_Checking));
  
  }
  public String getCheckingInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Checking));
      }

  public void initSubflow(String value){
     this.initProperty(S_Subflow,value);
  }
  public  void setSubflow(String value){
     this.set(S_Subflow,value);
  }
  public  void setSubflowNull(){
     this.set(S_Subflow,null);
  }

  public String getSubflow(){
       return DataType.getAsString(this.get(S_Subflow));
  
  }
  public String getSubflowInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Subflow));
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

  public void initImplclass(String value){
     this.initProperty(S_Implclass,value);
  }
  public  void setImplclass(String value){
     this.set(S_Implclass,value);
  }
  public  void setImplclassNull(){
     this.set(S_Implclass,null);
  }

  public String getImplclass(){
       return DataType.getAsString(this.get(S_Implclass));
  
  }
  public String getImplclassInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Implclass));
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

  public void initCompeteId(long value){
     this.initProperty(S_CompeteId,new Long(value));
  }
  public  void setCompeteId(long value){
     this.set(S_CompeteId,new Long(value));
  }
  public  void setCompeteIdNull(){
     this.set(S_CompeteId,null);
  }

  public long getCompeteId(){
        return DataType.getAsLong(this.get(S_CompeteId));
  
  }
  public long getCompeteIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CompeteId));
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

  public void initBusiness(long value){
     this.initProperty(S_Business,new Long(value));
  }
  public  void setBusiness(long value){
     this.set(S_Business,new Long(value));
  }
  public  void setBusinessNull(){
     this.set(S_Business,null);
  }

  public long getBusiness(){
        return DataType.getAsLong(this.get(S_Business));
  
  }
  public long getBusinessInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Business));
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

