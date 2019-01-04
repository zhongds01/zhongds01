package com.ai.sacenter.base.platform.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SAProtocol extends DataContainer implements DataContainerInterface,ISAProtocol{
  private static final long serialVersionUID = -7673654594965003474L;
  private static String  m_boName = "com.ai.sacenter.base.platform.bo.SAProtocol";
  public final static  String S_Plmmx11 = "PLMMX_11";
  public final static  String S_Plmmx10 = "PLMMX_10";
  public final static  String S_Plmmx15 = "PLMMX_15";
  public final static  String S_Plmmx14 = "PLMMX_14";
  public final static  String S_Plmmx13 = "PLMMX_13";
  public final static  String S_Plmmx12 = "PLMMX_12";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_PlmxType = "PLMX_TYPE";
  public final static  String S_Id = "ID";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Plmmx04 = "PLMMX_04";
  public final static  String S_Plmmx03 = "PLMMX_03";
  public final static  String S_Plmmx02 = "PLMMX_02";
  public final static  String S_Plmmx01 = "PLMMX_01";
  public final static  String S_Plmmx08 = "PLMMX_08";
  public final static  String S_Plmmx07 = "PLMMX_07";
  public final static  String S_Plmmx06 = "PLMMX_06";
  public final static  String S_Files = "FILES";
  public final static  String S_Plmmx05 = "PLMMX_05";
  public final static  String S_Name = "NAME";
  public final static  String S_Plmmx09 = "PLMMX_09";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_FileType = "FILE_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAProtocol() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initPlmmx11(String value){
     this.initProperty(S_Plmmx11,value);
  }
  public  void setPlmmx11(String value){
     this.set(S_Plmmx11,value);
  }
  public  void setPlmmx11Null(){
     this.set(S_Plmmx11,null);
  }

  public String getPlmmx11(){
       return DataType.getAsString(this.get(S_Plmmx11));
  
  }
  public String getPlmmx11InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx11));
      }

  public void initPlmmx10(String value){
     this.initProperty(S_Plmmx10,value);
  }
  public  void setPlmmx10(String value){
     this.set(S_Plmmx10,value);
  }
  public  void setPlmmx10Null(){
     this.set(S_Plmmx10,null);
  }

  public String getPlmmx10(){
       return DataType.getAsString(this.get(S_Plmmx10));
  
  }
  public String getPlmmx10InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx10));
      }

  public void initPlmmx15(String value){
     this.initProperty(S_Plmmx15,value);
  }
  public  void setPlmmx15(String value){
     this.set(S_Plmmx15,value);
  }
  public  void setPlmmx15Null(){
     this.set(S_Plmmx15,null);
  }

  public String getPlmmx15(){
       return DataType.getAsString(this.get(S_Plmmx15));
  
  }
  public String getPlmmx15InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx15));
      }

  public void initPlmmx14(String value){
     this.initProperty(S_Plmmx14,value);
  }
  public  void setPlmmx14(String value){
     this.set(S_Plmmx14,value);
  }
  public  void setPlmmx14Null(){
     this.set(S_Plmmx14,null);
  }

  public String getPlmmx14(){
       return DataType.getAsString(this.get(S_Plmmx14));
  
  }
  public String getPlmmx14InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx14));
      }

  public void initPlmmx13(String value){
     this.initProperty(S_Plmmx13,value);
  }
  public  void setPlmmx13(String value){
     this.set(S_Plmmx13,value);
  }
  public  void setPlmmx13Null(){
     this.set(S_Plmmx13,null);
  }

  public String getPlmmx13(){
       return DataType.getAsString(this.get(S_Plmmx13));
  
  }
  public String getPlmmx13InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx13));
      }

  public void initPlmmx12(String value){
     this.initProperty(S_Plmmx12,value);
  }
  public  void setPlmmx12(String value){
     this.set(S_Plmmx12,value);
  }
  public  void setPlmmx12Null(){
     this.set(S_Plmmx12,null);
  }

  public String getPlmmx12(){
       return DataType.getAsString(this.get(S_Plmmx12));
  
  }
  public String getPlmmx12InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx12));
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

  public void initPlmxType(String value){
     this.initProperty(S_PlmxType,value);
  }
  public  void setPlmxType(String value){
     this.set(S_PlmxType,value);
  }
  public  void setPlmxTypeNull(){
     this.set(S_PlmxType,null);
  }

  public String getPlmxType(){
       return DataType.getAsString(this.get(S_PlmxType));
  
  }
  public String getPlmxTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PlmxType));
      }

  public void initId(String value){
     this.initProperty(S_Id,value);
  }
  public  void setId(String value){
     this.set(S_Id,value);
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public String getId(){
       return DataType.getAsString(this.get(S_Id));
  
  }
  public String getIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Id));
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

  public void initPlmmx04(String value){
     this.initProperty(S_Plmmx04,value);
  }
  public  void setPlmmx04(String value){
     this.set(S_Plmmx04,value);
  }
  public  void setPlmmx04Null(){
     this.set(S_Plmmx04,null);
  }

  public String getPlmmx04(){
       return DataType.getAsString(this.get(S_Plmmx04));
  
  }
  public String getPlmmx04InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx04));
      }

  public void initPlmmx03(String value){
     this.initProperty(S_Plmmx03,value);
  }
  public  void setPlmmx03(String value){
     this.set(S_Plmmx03,value);
  }
  public  void setPlmmx03Null(){
     this.set(S_Plmmx03,null);
  }

  public String getPlmmx03(){
       return DataType.getAsString(this.get(S_Plmmx03));
  
  }
  public String getPlmmx03InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx03));
      }

  public void initPlmmx02(String value){
     this.initProperty(S_Plmmx02,value);
  }
  public  void setPlmmx02(String value){
     this.set(S_Plmmx02,value);
  }
  public  void setPlmmx02Null(){
     this.set(S_Plmmx02,null);
  }

  public String getPlmmx02(){
       return DataType.getAsString(this.get(S_Plmmx02));
  
  }
  public String getPlmmx02InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx02));
      }

  public void initPlmmx01(String value){
     this.initProperty(S_Plmmx01,value);
  }
  public  void setPlmmx01(String value){
     this.set(S_Plmmx01,value);
  }
  public  void setPlmmx01Null(){
     this.set(S_Plmmx01,null);
  }

  public String getPlmmx01(){
       return DataType.getAsString(this.get(S_Plmmx01));
  
  }
  public String getPlmmx01InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx01));
      }

  public void initPlmmx08(String value){
     this.initProperty(S_Plmmx08,value);
  }
  public  void setPlmmx08(String value){
     this.set(S_Plmmx08,value);
  }
  public  void setPlmmx08Null(){
     this.set(S_Plmmx08,null);
  }

  public String getPlmmx08(){
       return DataType.getAsString(this.get(S_Plmmx08));
  
  }
  public String getPlmmx08InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx08));
      }

  public void initPlmmx07(String value){
     this.initProperty(S_Plmmx07,value);
  }
  public  void setPlmmx07(String value){
     this.set(S_Plmmx07,value);
  }
  public  void setPlmmx07Null(){
     this.set(S_Plmmx07,null);
  }

  public String getPlmmx07(){
       return DataType.getAsString(this.get(S_Plmmx07));
  
  }
  public String getPlmmx07InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx07));
      }

  public void initPlmmx06(String value){
     this.initProperty(S_Plmmx06,value);
  }
  public  void setPlmmx06(String value){
     this.set(S_Plmmx06,value);
  }
  public  void setPlmmx06Null(){
     this.set(S_Plmmx06,null);
  }

  public String getPlmmx06(){
       return DataType.getAsString(this.get(S_Plmmx06));
  
  }
  public String getPlmmx06InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx06));
      }

  public void initFiles(String value){
     this.initProperty(S_Files,value);
  }
  public  void setFiles(String value){
     this.set(S_Files,value);
  }
  public  void setFilesNull(){
     this.set(S_Files,null);
  }

  public String getFiles(){
       return DataType.getAsString(this.get(S_Files));
  
  }
  public String getFilesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Files));
      }

  public void initPlmmx05(String value){
     this.initProperty(S_Plmmx05,value);
  }
  public  void setPlmmx05(String value){
     this.set(S_Plmmx05,value);
  }
  public  void setPlmmx05Null(){
     this.set(S_Plmmx05,null);
  }

  public String getPlmmx05(){
       return DataType.getAsString(this.get(S_Plmmx05));
  
  }
  public String getPlmmx05InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx05));
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

  public void initPlmmx09(String value){
     this.initProperty(S_Plmmx09,value);
  }
  public  void setPlmmx09(String value){
     this.set(S_Plmmx09,value);
  }
  public  void setPlmmx09Null(){
     this.set(S_Plmmx09,null);
  }

  public String getPlmmx09(){
       return DataType.getAsString(this.get(S_Plmmx09));
  
  }
  public String getPlmmx09InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plmmx09));
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

  public void initFileType(String value){
     this.initProperty(S_FileType,value);
  }
  public  void setFileType(String value){
     this.set(S_FileType,value);
  }
  public  void setFileTypeNull(){
     this.set(S_FileType,null);
  }

  public String getFileType(){
       return DataType.getAsString(this.get(S_FileType));
  
  }
  public String getFileTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FileType));
      }


 
 }

