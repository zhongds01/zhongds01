package com.ai.sacenter.base.basic.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SADistrict extends DataContainer implements DataContainerInterface,ISADistrict{
  private static final long serialVersionUID = 9010262740498809490L;
  private static String  m_boName = "com.ai.sacenter.base.basic.bo.SADistrict";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_ParentDistrict = "PARENT_DISTRICT";
  public final static  String S_RegionCode = "REGION_CODE";
  public final static  String S_DistrictId = "DISTRICT_ID";
  public final static  String S_State = "STATE";
  public final static  String S_DistrictTypeId = "DISTRICT_TYPE_ID";
  public final static  String S_AreaCode = "AREA_CODE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_EnglishName = "ENGLISH_NAME";
  public final static  String S_CourseFlag = "COURSE_FLAG";
  public final static  String S_CenterCode = "CENTER_CODE";
  public final static  String S_TwoNumber = "TWO_NUMBER";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_DistrictName = "DISTRICT_NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_DistrictCode = "DISTRICT_CODE";
  public final static  String S_Control = "CONTROL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SADistrict() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initParentDistrict(long value){
     this.initProperty(S_ParentDistrict,new Long(value));
  }
  public  void setParentDistrict(long value){
     this.set(S_ParentDistrict,new Long(value));
  }
  public  void setParentDistrictNull(){
     this.set(S_ParentDistrict,null);
  }

  public long getParentDistrict(){
        return DataType.getAsLong(this.get(S_ParentDistrict));
  
  }
  public long getParentDistrictInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ParentDistrict));
      }

  public void initRegionCode(String value){
     this.initProperty(S_RegionCode,value);
  }
  public  void setRegionCode(String value){
     this.set(S_RegionCode,value);
  }
  public  void setRegionCodeNull(){
     this.set(S_RegionCode,null);
  }

  public String getRegionCode(){
       return DataType.getAsString(this.get(S_RegionCode));
  
  }
  public String getRegionCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RegionCode));
      }

  public void initDistrictId(long value){
     this.initProperty(S_DistrictId,new Long(value));
  }
  public  void setDistrictId(long value){
     this.set(S_DistrictId,new Long(value));
  }
  public  void setDistrictIdNull(){
     this.set(S_DistrictId,null);
  }

  public long getDistrictId(){
        return DataType.getAsLong(this.get(S_DistrictId));
  
  }
  public long getDistrictIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DistrictId));
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

  public void initDistrictTypeId(int value){
     this.initProperty(S_DistrictTypeId,new Integer(value));
  }
  public  void setDistrictTypeId(int value){
     this.set(S_DistrictTypeId,new Integer(value));
  }
  public  void setDistrictTypeIdNull(){
     this.set(S_DistrictTypeId,null);
  }

  public int getDistrictTypeId(){
        return DataType.getAsInt(this.get(S_DistrictTypeId));
  
  }
  public int getDistrictTypeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_DistrictTypeId));
      }

  public void initAreaCode(String value){
     this.initProperty(S_AreaCode,value);
  }
  public  void setAreaCode(String value){
     this.set(S_AreaCode,value);
  }
  public  void setAreaCodeNull(){
     this.set(S_AreaCode,null);
  }

  public String getAreaCode(){
       return DataType.getAsString(this.get(S_AreaCode));
  
  }
  public String getAreaCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AreaCode));
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

  public void initEnglishName(String value){
     this.initProperty(S_EnglishName,value);
  }
  public  void setEnglishName(String value){
     this.set(S_EnglishName,value);
  }
  public  void setEnglishNameNull(){
     this.set(S_EnglishName,null);
  }

  public String getEnglishName(){
       return DataType.getAsString(this.get(S_EnglishName));
  
  }
  public String getEnglishNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EnglishName));
      }

  public void initCourseFlag(int value){
     this.initProperty(S_CourseFlag,new Integer(value));
  }
  public  void setCourseFlag(int value){
     this.set(S_CourseFlag,new Integer(value));
  }
  public  void setCourseFlagNull(){
     this.set(S_CourseFlag,null);
  }

  public int getCourseFlag(){
        return DataType.getAsInt(this.get(S_CourseFlag));
  
  }
  public int getCourseFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CourseFlag));
      }

  public void initCenterCode(String value){
     this.initProperty(S_CenterCode,value);
  }
  public  void setCenterCode(String value){
     this.set(S_CenterCode,value);
  }
  public  void setCenterCodeNull(){
     this.set(S_CenterCode,null);
  }

  public String getCenterCode(){
       return DataType.getAsString(this.get(S_CenterCode));
  
  }
  public String getCenterCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CenterCode));
      }

  public void initTwoNumber(int value){
     this.initProperty(S_TwoNumber,new Integer(value));
  }
  public  void setTwoNumber(int value){
     this.set(S_TwoNumber,new Integer(value));
  }
  public  void setTwoNumberNull(){
     this.set(S_TwoNumber,null);
  }

  public int getTwoNumber(){
        return DataType.getAsInt(this.get(S_TwoNumber));
  
  }
  public int getTwoNumberInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_TwoNumber));
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

  public void initDistrictName(String value){
     this.initProperty(S_DistrictName,value);
  }
  public  void setDistrictName(String value){
     this.set(S_DistrictName,value);
  }
  public  void setDistrictNameNull(){
     this.set(S_DistrictName,null);
  }

  public String getDistrictName(){
       return DataType.getAsString(this.get(S_DistrictName));
  
  }
  public String getDistrictNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DistrictName));
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

  public void initDistrictCode(String value){
     this.initProperty(S_DistrictCode,value);
  }
  public  void setDistrictCode(String value){
     this.set(S_DistrictCode,value);
  }
  public  void setDistrictCodeNull(){
     this.set(S_DistrictCode,null);
  }

  public String getDistrictCode(){
       return DataType.getAsString(this.get(S_DistrictCode));
  
  }
  public String getDistrictCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DistrictCode));
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

