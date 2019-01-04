package com.ai.sacenter.base.platform.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SAOffice extends DataContainer implements DataContainerInterface,ISAOffice{
  private static final long serialVersionUID = -3140302774974277637L;
  private static String  m_boName = "com.ai.sacenter.base.platform.bo.SAOffice";
  public final static  String S_State = "STATE";
  public final static  String S_StartNum = "START_NUM";
  public final static  String S_EndNum = "END_NUM";
  public final static  String S_PsNetCode = "PS_NET_CODE";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Headnum = "HEADNUM";
  public final static  String S_Id = "ID";
  public final static  String S_Platfrom = "PLATFROM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_RegionCode = "REGION_CODE";
  public final static  String S_Modifier = "MODIFIER";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAOffice() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initStartNum(String value){
     this.initProperty(S_StartNum,value);
  }
  public  void setStartNum(String value){
     this.set(S_StartNum,value);
  }
  public  void setStartNumNull(){
     this.set(S_StartNum,null);
  }

  public String getStartNum(){
       return DataType.getAsString(this.get(S_StartNum));
  
  }
  public String getStartNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StartNum));
      }

  public void initEndNum(String value){
     this.initProperty(S_EndNum,value);
  }
  public  void setEndNum(String value){
     this.set(S_EndNum,value);
  }
  public  void setEndNumNull(){
     this.set(S_EndNum,null);
  }

  public String getEndNum(){
       return DataType.getAsString(this.get(S_EndNum));
  
  }
  public String getEndNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EndNum));
      }

  public void initPsNetCode(String value){
     this.initProperty(S_PsNetCode,value);
  }
  public  void setPsNetCode(String value){
     this.set(S_PsNetCode,value);
  }
  public  void setPsNetCodeNull(){
     this.set(S_PsNetCode,null);
  }

  public String getPsNetCode(){
       return DataType.getAsString(this.get(S_PsNetCode));
  
  }
  public String getPsNetCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PsNetCode));
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

  public void initHeadnum(String value){
     this.initProperty(S_Headnum,value);
  }
  public  void setHeadnum(String value){
     this.set(S_Headnum,value);
  }
  public  void setHeadnumNull(){
     this.set(S_Headnum,null);
  }

  public String getHeadnum(){
       return DataType.getAsString(this.get(S_Headnum));
  
  }
  public String getHeadnumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Headnum));
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

  public void initPlatfrom(String value){
     this.initProperty(S_Platfrom,value);
  }
  public  void setPlatfrom(String value){
     this.set(S_Platfrom,value);
  }
  public  void setPlatfromNull(){
     this.set(S_Platfrom,null);
  }

  public String getPlatfrom(){
       return DataType.getAsString(this.get(S_Platfrom));
  
  }
  public String getPlatfromInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Platfrom));
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


 
 }

