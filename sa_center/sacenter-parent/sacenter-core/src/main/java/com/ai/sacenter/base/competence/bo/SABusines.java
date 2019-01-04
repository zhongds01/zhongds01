package com.ai.sacenter.base.competence.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class SABusines extends DataContainer implements DataContainerInterface,ISABusines{
  private static final long serialVersionUID = -2757686279442062511L;
  private static String  m_boName = "com.ai.sacenter.base.competence.bo.SABusines";
  public final static  String S_Effective = "EFFECTIVE";
  public final static  String S_State = "STATE";
  public final static  String S_Business = "BUSINESS";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Competence = "COMPETENCE";
  public final static  String S_GroupRole = "GROUP_ROLE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Implclass = "IMPLCLASS";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Complete = "COMPLETE";
  public final static  String S_Catalog = "CATALOG";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Expire = "EXPIRE";
  public final static  String S_Protocol = "PROTOCOL";
  public final static  String S_MemberRole = "MEMBER_ROLE";
  public final static  String S_Name = "NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Originate = "ORIGINATE";
  public final static  String S_Program = "PROGRAM";
  public final static  String S_Control = "CONTROL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SABusines() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initCompetence(String value){
     this.initProperty(S_Competence,value);
  }
  public  void setCompetence(String value){
     this.set(S_Competence,value);
  }
  public  void setCompetenceNull(){
     this.set(S_Competence,null);
  }

  public String getCompetence(){
       return DataType.getAsString(this.get(S_Competence));
  
  }
  public String getCompetenceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Competence));
      }

  public void initGroupRole(String value){
     this.initProperty(S_GroupRole,value);
  }
  public  void setGroupRole(String value){
     this.set(S_GroupRole,value);
  }
  public  void setGroupRoleNull(){
     this.set(S_GroupRole,null);
  }

  public String getGroupRole(){
       return DataType.getAsString(this.get(S_GroupRole));
  
  }
  public String getGroupRoleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GroupRole));
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

  public void initComplete(String value){
     this.initProperty(S_Complete,value);
  }
  public  void setComplete(String value){
     this.set(S_Complete,value);
  }
  public  void setCompleteNull(){
     this.set(S_Complete,null);
  }

  public String getComplete(){
       return DataType.getAsString(this.get(S_Complete));
  
  }
  public String getCompleteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Complete));
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

  public void initProtocol(String value){
     this.initProperty(S_Protocol,value);
  }
  public  void setProtocol(String value){
     this.set(S_Protocol,value);
  }
  public  void setProtocolNull(){
     this.set(S_Protocol,null);
  }

  public String getProtocol(){
       return DataType.getAsString(this.get(S_Protocol));
  
  }
  public String getProtocolInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Protocol));
      }

  public void initMemberRole(String value){
     this.initProperty(S_MemberRole,value);
  }
  public  void setMemberRole(String value){
     this.set(S_MemberRole,value);
  }
  public  void setMemberRoleNull(){
     this.set(S_MemberRole,null);
  }

  public String getMemberRole(){
       return DataType.getAsString(this.get(S_MemberRole));
  
  }
  public String getMemberRoleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MemberRole));
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

  public void initProgram(String value){
     this.initProperty(S_Program,value);
  }
  public  void setProgram(String value){
     this.set(S_Program,value);
  }
  public  void setProgramNull(){
     this.set(S_Program,null);
  }

  public String getProgram(){
       return DataType.getAsString(this.get(S_Program));
  
  }
  public String getProgramInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Program));
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

