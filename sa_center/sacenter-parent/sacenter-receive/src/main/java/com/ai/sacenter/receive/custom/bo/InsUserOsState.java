package com.ai.sacenter.receive.custom.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class InsUserOsState extends DataContainer implements DataContainerInterface{
  private static final long serialVersionUID = -1138430982830125749L;
  private static String  m_boName = "com.ai.sacenter.receive.custom.bo.InsUserOsState";
  public final static  String S_OsStatusPre = "OS_STATUS_PRE";
  public final static  String S_OStopDate = "O_STOP_DATE";
  public final static  String S_AStopDate = "A_STOP_DATE";
  public final static  String S_EffectiveDate = "EFFECTIVE_DATE";
  public final static  String S_OsStatus = "OS_STATUS";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_BStopDate = "B_STOP_DATE";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_RStopDate = "R_STOP_DATE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_ExpireDate = "EXPIRE_DATE";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_ExpireDateType = "EXPIRE_DATE_TYPE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_EffectiveDateType = "EFFECTIVE_DATE_TYPE";
  public final static  String S_MStopDate = "M_STOP_DATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public InsUserOsState() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //�������������������ҵ���������
   throw new AIException("Cannot reset ObjectType");
 }


  public void initOsStatusPre(String value){
     this.initProperty(S_OsStatusPre,value);
  }
  public  void setOsStatusPre(String value){
     this.set(S_OsStatusPre,value);
  }
  public  void setOsStatusPreNull(){
     this.set(S_OsStatusPre,null);
  }

  public String getOsStatusPre(){
       return DataType.getAsString(this.get(S_OsStatusPre));
  
  }
  public String getOsStatusPreInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OsStatusPre));
      }

  public void initOStopDate(Timestamp value){
     this.initProperty(S_OStopDate,value);
  }
  public  void setOStopDate(Timestamp value){
     this.set(S_OStopDate,value);
  }
  public  void setOStopDateNull(){
     this.set(S_OStopDate,null);
  }

  public Timestamp getOStopDate(){
        return DataType.getAsDateTime(this.get(S_OStopDate));
  
  }
  public Timestamp getOStopDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OStopDate));
      }

  public void initAStopDate(Timestamp value){
     this.initProperty(S_AStopDate,value);
  }
  public  void setAStopDate(Timestamp value){
     this.set(S_AStopDate,value);
  }
  public  void setAStopDateNull(){
     this.set(S_AStopDate,null);
  }

  public Timestamp getAStopDate(){
        return DataType.getAsDateTime(this.get(S_AStopDate));
  
  }
  public Timestamp getAStopDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AStopDate));
      }

  public void initEffectiveDate(Timestamp value){
     this.initProperty(S_EffectiveDate,value);
  }
  public  void setEffectiveDate(Timestamp value){
     this.set(S_EffectiveDate,value);
  }
  public  void setEffectiveDateNull(){
     this.set(S_EffectiveDate,null);
  }

  public Timestamp getEffectiveDate(){
        return DataType.getAsDateTime(this.get(S_EffectiveDate));
  
  }
  public Timestamp getEffectiveDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EffectiveDate));
      }

  public void initOsStatus(String value){
     this.initProperty(S_OsStatus,value);
  }
  public  void setOsStatus(String value){
     this.set(S_OsStatus,value);
  }
  public  void setOsStatusNull(){
     this.set(S_OsStatus,null);
  }

  public String getOsStatus(){
       return DataType.getAsString(this.get(S_OsStatus));
  
  }
  public String getOsStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OsStatus));
      }

  public void initDoneDate(Timestamp value){
     this.initProperty(S_DoneDate,value);
  }
  public  void setDoneDate(Timestamp value){
     this.set(S_DoneDate,value);
  }
  public  void setDoneDateNull(){
     this.set(S_DoneDate,null);
  }

  public Timestamp getDoneDate(){
        return DataType.getAsDateTime(this.get(S_DoneDate));
  
  }
  public Timestamp getDoneDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_DoneDate));
      }

  public void initBStopDate(Timestamp value){
     this.initProperty(S_BStopDate,value);
  }
  public  void setBStopDate(Timestamp value){
     this.set(S_BStopDate,value);
  }
  public  void setBStopDateNull(){
     this.set(S_BStopDate,null);
  }

  public Timestamp getBStopDate(){
        return DataType.getAsDateTime(this.get(S_BStopDate));
  
  }
  public Timestamp getBStopDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BStopDate));
      }

  public void initOrgId(long value){
     this.initProperty(S_OrgId,new Long(value));
  }
  public  void setOrgId(long value){
     this.set(S_OrgId,new Long(value));
  }
  public  void setOrgIdNull(){
     this.set(S_OrgId,null);
  }

  public long getOrgId(){
        return DataType.getAsLong(this.get(S_OrgId));
  
  }
  public long getOrgIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrgId));
      }

  public void initRStopDate(Timestamp value){
     this.initProperty(S_RStopDate,value);
  }
  public  void setRStopDate(Timestamp value){
     this.set(S_RStopDate,value);
  }
  public  void setRStopDateNull(){
     this.set(S_RStopDate,null);
  }

  public Timestamp getRStopDate(){
        return DataType.getAsDateTime(this.get(S_RStopDate));
  
  }
  public Timestamp getRStopDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_RStopDate));
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

  public void initDoneCode(long value){
     this.initProperty(S_DoneCode,new Long(value));
  }
  public  void setDoneCode(long value){
     this.set(S_DoneCode,new Long(value));
  }
  public  void setDoneCodeNull(){
     this.set(S_DoneCode,null);
  }

  public long getDoneCode(){
        return DataType.getAsLong(this.get(S_DoneCode));
  
  }
  public long getDoneCodeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DoneCode));
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

  public void initExpireDate(Timestamp value){
     this.initProperty(S_ExpireDate,value);
  }
  public  void setExpireDate(Timestamp value){
     this.set(S_ExpireDate,value);
  }
  public  void setExpireDateNull(){
     this.set(S_ExpireDate,null);
  }

  public Timestamp getExpireDate(){
        return DataType.getAsDateTime(this.get(S_ExpireDate));
  
  }
  public Timestamp getExpireDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ExpireDate));
      }

  public void initOpId(long value){
     this.initProperty(S_OpId,new Long(value));
  }
  public  void setOpId(long value){
     this.set(S_OpId,new Long(value));
  }
  public  void setOpIdNull(){
     this.set(S_OpId,null);
  }

  public long getOpId(){
        return DataType.getAsLong(this.get(S_OpId));
  
  }
  public long getOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OpId));
      }

  public void initExpireDateType(int value){
     this.initProperty(S_ExpireDateType,new Integer(value));
  }
  public  void setExpireDateType(int value){
     this.set(S_ExpireDateType,new Integer(value));
  }
  public  void setExpireDateTypeNull(){
     this.set(S_ExpireDateType,null);
  }

  public int getExpireDateType(){
        return DataType.getAsInt(this.get(S_ExpireDateType));
  
  }
  public int getExpireDateTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ExpireDateType));
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

  public void initEffectiveDateType(int value){
     this.initProperty(S_EffectiveDateType,new Integer(value));
  }
  public  void setEffectiveDateType(int value){
     this.set(S_EffectiveDateType,new Integer(value));
  }
  public  void setEffectiveDateTypeNull(){
     this.set(S_EffectiveDateType,null);
  }

  public int getEffectiveDateType(){
        return DataType.getAsInt(this.get(S_EffectiveDateType));
  
  }
  public int getEffectiveDateTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_EffectiveDateType));
      }

  public void initMStopDate(Timestamp value){
     this.initProperty(S_MStopDate,value);
  }
  public  void setMStopDate(Timestamp value){
     this.set(S_MStopDate,value);
  }
  public  void setMStopDateNull(){
     this.set(S_MStopDate,null);
  }

  public Timestamp getMStopDate(){
        return DataType.getAsDateTime(this.get(S_MStopDate));
  
  }
  public Timestamp getMStopDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_MStopDate));
      }


 
 }

