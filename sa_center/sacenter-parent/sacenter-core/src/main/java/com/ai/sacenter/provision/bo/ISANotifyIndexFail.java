package com.ai.sacenter.provision.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ISANotifyIndexFail extends DataContainer implements DataContainerInterface,IISANotifyIndex{
  private static final long serialVersionUID = -7975837815440002220L;
  private static String  m_boName = "com.ai.sacenter.provision.bo.ISANotifyIndexFail";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_BackupDate = "BACKUP_DATE";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_StartDate = "START_DATE";
  public final static  String S_HandDate = "HAND_DATE";
  public final static  String S_HandOpId = "HAND_OP_ID";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Status = "STATUS";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_UpField = "UP_FIELD";
  public final static  String S_FailCode = "FAIL_CODE";
  public final static  String S_HandId = "HAND_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ISANotifyIndexFail() throws AIException{
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

  public void initOrderDate(Timestamp value){
     this.initProperty(S_OrderDate,value);
  }
  public  void setOrderDate(Timestamp value){
     this.set(S_OrderDate,value);
  }
  public  void setOrderDateNull(){
     this.set(S_OrderDate,null);
  }

  public Timestamp getOrderDate(){
        return DataType.getAsDateTime(this.get(S_OrderDate));
  
  }
  public Timestamp getOrderDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OrderDate));
      }

  public void initBackupDate(Timestamp value){
     this.initProperty(S_BackupDate,value);
  }
  public  void setBackupDate(Timestamp value){
     this.set(S_BackupDate,value);
  }
  public  void setBackupDateNull(){
     this.set(S_BackupDate,null);
  }

  public Timestamp getBackupDate(){
        return DataType.getAsDateTime(this.get(S_BackupDate));
  
  }
  public Timestamp getBackupDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BackupDate));
      }

  public void initEndDate(Timestamp value){
     this.initProperty(S_EndDate,value);
  }
  public  void setEndDate(Timestamp value){
     this.set(S_EndDate,value);
  }
  public  void setEndDateNull(){
     this.set(S_EndDate,null);
  }

  public Timestamp getEndDate(){
        return DataType.getAsDateTime(this.get(S_EndDate));
  
  }
  public Timestamp getEndDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EndDate));
      }

  public void initUserId(long value){
     this.initProperty(S_UserId,new Long(value));
  }
  public  void setUserId(long value){
     this.set(S_UserId,new Long(value));
  }
  public  void setUserIdNull(){
     this.set(S_UserId,null);
  }

  public long getUserId(){
        return DataType.getAsLong(this.get(S_UserId));
  
  }
  public long getUserIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UserId));
      }

  public void initStartDate(Timestamp value){
     this.initProperty(S_StartDate,value);
  }
  public  void setStartDate(Timestamp value){
     this.set(S_StartDate,value);
  }
  public  void setStartDateNull(){
     this.set(S_StartDate,null);
  }

  public Timestamp getStartDate(){
        return DataType.getAsDateTime(this.get(S_StartDate));
  
  }
  public Timestamp getStartDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StartDate));
      }

  public void initHandDate(Timestamp value){
     this.initProperty(S_HandDate,value);
  }
  public  void setHandDate(Timestamp value){
     this.set(S_HandDate,value);
  }
  public  void setHandDateNull(){
     this.set(S_HandDate,null);
  }

  public Timestamp getHandDate(){
        return DataType.getAsDateTime(this.get(S_HandDate));
  
  }
  public Timestamp getHandDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_HandDate));
      }

  public void initHandOpId(long value){
     this.initProperty(S_HandOpId,new Long(value));
  }
  public  void setHandOpId(long value){
     this.set(S_HandOpId,new Long(value));
  }
  public  void setHandOpIdNull(){
     this.set(S_HandOpId,null);
  }

  public long getHandOpId(){
        return DataType.getAsLong(this.get(S_HandOpId));
  
  }
  public long getHandOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_HandOpId));
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

  public void initFailReason(String value){
     this.initProperty(S_FailReason,value);
  }
  public  void setFailReason(String value){
     this.set(S_FailReason,value);
  }
  public  void setFailReasonNull(){
     this.set(S_FailReason,null);
  }

  public String getFailReason(){
       return DataType.getAsString(this.get(S_FailReason));
  
  }
  public String getFailReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FailReason));
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

  public void initStatus(int value){
     this.initProperty(S_Status,new Integer(value));
  }
  public  void setStatus(int value){
     this.set(S_Status,new Integer(value));
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public int getStatus(){
        return DataType.getAsInt(this.get(S_Status));
  
  }
  public int getStatusInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Status));
      }

  public void initCompleteDate(Timestamp value){
     this.initProperty(S_CompleteDate,value);
  }
  public  void setCompleteDate(Timestamp value){
     this.set(S_CompleteDate,value);
  }
  public  void setCompleteDateNull(){
     this.set(S_CompleteDate,null);
  }

  public Timestamp getCompleteDate(){
        return DataType.getAsDateTime(this.get(S_CompleteDate));
  
  }
  public Timestamp getCompleteDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CompleteDate));
      }

  public void initOrderId(long value){
     this.initProperty(S_OrderId,new Long(value));
  }
  public  void setOrderId(long value){
     this.set(S_OrderId,new Long(value));
  }
  public  void setOrderIdNull(){
     this.set(S_OrderId,null);
  }

  public long getOrderId(){
        return DataType.getAsLong(this.get(S_OrderId));
  
  }
  public long getOrderIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrderId));
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

  public void initFailLog(String value){
     this.initProperty(S_FailLog,value);
  }
  public  void setFailLog(String value){
     this.set(S_FailLog,value);
  }
  public  void setFailLogNull(){
     this.set(S_FailLog,null);
  }

  public String getFailLog(){
       return DataType.getAsString(this.get(S_FailLog));
  
  }
  public String getFailLogInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FailLog));
      }

  public void initUpField(String value){
     this.initProperty(S_UpField,value);
  }
  public  void setUpField(String value){
     this.set(S_UpField,value);
  }
  public  void setUpFieldNull(){
     this.set(S_UpField,null);
  }

  public String getUpField(){
       return DataType.getAsString(this.get(S_UpField));
  
  }
  public String getUpFieldInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UpField));
      }

  public void initFailCode(String value){
     this.initProperty(S_FailCode,value);
  }
  public  void setFailCode(String value){
     this.set(S_FailCode,value);
  }
  public  void setFailCodeNull(){
     this.set(S_FailCode,null);
  }

  public String getFailCode(){
       return DataType.getAsString(this.get(S_FailCode));
  
  }
  public String getFailCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FailCode));
      }

  public void initHandId(long value){
     this.initProperty(S_HandId,new Long(value));
  }
  public  void setHandId(long value){
     this.set(S_HandId,new Long(value));
  }
  public  void setHandIdNull(){
     this.set(S_HandId,null);
  }

  public long getHandId(){
        return DataType.getAsLong(this.get(S_HandId));
  
  }
  public long getHandIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_HandId));
      }


 
 }

