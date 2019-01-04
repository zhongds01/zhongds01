package com.ai.sacenter.base.basic.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class SAParallel extends DataContainer implements DataContainerInterface,ISAParallel{
  private static final long serialVersionUID = -3232923039093666676L;
  private static String  m_boName = "com.ai.sacenter.base.basic.bo.SAParallel";
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

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAParallel() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initRegionId(String value){
     this.initProperty(S_RegionId,value);
  }
  public  void setRegionId(String value){
     this.set(S_RegionId,value);
  }
  public  void setRegionIdNull(){
     this.set(S_RegionId,null);
  }

  public String getRegionId(){
       return DataType.getAsString(this.get(S_RegionId));
  
  }
  public String getRegionIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RegionId));
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

  public void initOriginate(String value){
     this.initProperty(S_Originate,value);
  }
  public  void setOriginate(String value){
     this.set(S_Originate,value);
  }
  public  void setOriginateNull(){
     this.set(S_Originate,null);
  }

  public String getOriginate(){
       return DataType.getAsString(this.get(S_Originate));
  
  }
  public String getOriginateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Originate));
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

  public void initParallel(String value){
     this.initProperty(S_Parallel,value);
  }
  public  void setParallel(String value){
     this.set(S_Parallel,value);
  }
  public  void setParallelNull(){
     this.set(S_Parallel,null);
  }

  public String getParallel(){
       return DataType.getAsString(this.get(S_Parallel));
  
  }
  public String getParallelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Parallel));
      }


 
 }

