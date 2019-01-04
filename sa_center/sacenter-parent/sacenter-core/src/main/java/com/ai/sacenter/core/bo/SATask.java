package com.ai.sacenter.core.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class SATask extends DataContainer implements DataContainerInterface,ISATask{
  private static final long serialVersionUID = -3190239314176134504L;
  private static String  m_boName = "com.ai.sacenter.core.bo.SATask";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_DoneTimes = "DONE_TIMES";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_PlwkCoding = "PLWK_CODING";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Directive = "DIRECTIVE";
  public final static  String S_RedoTimes = "REDO_TIMES";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_DependTaskId = "DEPEND_TASK_ID";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_Param = "PARAM";
  public final static  String S_PlwkCreate = "PLWK_CREATE";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_CreateTaskId = "CREATE_TASK_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_PlwkComplete = "PLWK_COMPLETE";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_Subflow = "SUBFLOW";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_DoneResult = "DONE_RESULT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SATask() throws AIException{
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

  public void initDoneTimes(int value){
     this.initProperty(S_DoneTimes,new Integer(value));
  }
  public  void setDoneTimes(int value){
     this.set(S_DoneTimes,new Integer(value));
  }
  public  void setDoneTimesNull(){
     this.set(S_DoneTimes,null);
  }

  public int getDoneTimes(){
        return DataType.getAsInt(this.get(S_DoneTimes));
  
  }
  public int getDoneTimesInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_DoneTimes));
      }

  public void initOrgId(String value){
     this.initProperty(S_OrgId,value);
  }
  public  void setOrgId(String value){
     this.set(S_OrgId,value);
  }
  public  void setOrgIdNull(){
     this.set(S_OrgId,null);
  }

  public String getOrgId(){
       return DataType.getAsString(this.get(S_OrgId));
  
  }
  public String getOrgIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgId));
      }

  public void initPlwkCoding(String value){
     this.initProperty(S_PlwkCoding,value);
  }
  public  void setPlwkCoding(String value){
     this.set(S_PlwkCoding,value);
  }
  public  void setPlwkCodingNull(){
     this.set(S_PlwkCoding,null);
  }

  public String getPlwkCoding(){
       return DataType.getAsString(this.get(S_PlwkCoding));
  
  }
  public String getPlwkCodingInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PlwkCoding));
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

  public void initStaffId(String value){
     this.initProperty(S_StaffId,value);
  }
  public  void setStaffId(String value){
     this.set(S_StaffId,value);
  }
  public  void setStaffIdNull(){
     this.set(S_StaffId,null);
  }

  public String getStaffId(){
       return DataType.getAsString(this.get(S_StaffId));
  
  }
  public String getStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffId));
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

  public void initPriority(long value){
     this.initProperty(S_Priority,new Long(value));
  }
  public  void setPriority(long value){
     this.set(S_Priority,new Long(value));
  }
  public  void setPriorityNull(){
     this.set(S_Priority,null);
  }

  public long getPriority(){
        return DataType.getAsLong(this.get(S_Priority));
  
  }
  public long getPriorityInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Priority));
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

  public void initDirective(String value){
     this.initProperty(S_Directive,value);
  }
  public  void setDirective(String value){
     this.set(S_Directive,value);
  }
  public  void setDirectiveNull(){
     this.set(S_Directive,null);
  }

  public String getDirective(){
       return DataType.getAsString(this.get(S_Directive));
  
  }
  public String getDirectiveInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Directive));
      }

  public void initRedoTimes(int value){
     this.initProperty(S_RedoTimes,new Integer(value));
  }
  public  void setRedoTimes(int value){
     this.set(S_RedoTimes,new Integer(value));
  }
  public  void setRedoTimesNull(){
     this.set(S_RedoTimes,null);
  }

  public int getRedoTimes(){
        return DataType.getAsInt(this.get(S_RedoTimes));
  
  }
  public int getRedoTimesInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_RedoTimes));
      }

  public void initStateDate(Timestamp value){
     this.initProperty(S_StateDate,value);
  }
  public  void setStateDate(Timestamp value){
     this.set(S_StateDate,value);
  }
  public  void setStateDateNull(){
     this.set(S_StateDate,null);
  }

  public Timestamp getStateDate(){
        return DataType.getAsDateTime(this.get(S_StateDate));
  
  }
  public Timestamp getStateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StateDate));
      }

  public void initDependTaskId(long value){
     this.initProperty(S_DependTaskId,new Long(value));
  }
  public  void setDependTaskId(long value){
     this.set(S_DependTaskId,new Long(value));
  }
  public  void setDependTaskIdNull(){
     this.set(S_DependTaskId,null);
  }

  public long getDependTaskId(){
        return DataType.getAsLong(this.get(S_DependTaskId));
  
  }
  public long getDependTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DependTaskId));
      }

  public void initOfferId(long value){
     this.initProperty(S_OfferId,new Long(value));
  }
  public  void setOfferId(long value){
     this.set(S_OfferId,new Long(value));
  }
  public  void setOfferIdNull(){
     this.set(S_OfferId,null);
  }

  public long getOfferId(){
        return DataType.getAsLong(this.get(S_OfferId));
  
  }
  public long getOfferIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OfferId));
      }

  public void initParam(String value){
     this.initProperty(S_Param,value);
  }
  public  void setParam(String value){
     this.set(S_Param,value);
  }
  public  void setParamNull(){
     this.set(S_Param,null);
  }

  public String getParam(){
       return DataType.getAsString(this.get(S_Param));
  
  }
  public String getParamInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param));
      }

  public void initPlwkCreate(Timestamp value){
     this.initProperty(S_PlwkCreate,value);
  }
  public  void setPlwkCreate(Timestamp value){
     this.set(S_PlwkCreate,value);
  }
  public  void setPlwkCreateNull(){
     this.set(S_PlwkCreate,null);
  }

  public Timestamp getPlwkCreate(){
        return DataType.getAsDateTime(this.get(S_PlwkCreate));
  
  }
  public Timestamp getPlwkCreateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PlwkCreate));
      }

  public void initStationId(String value){
     this.initProperty(S_StationId,value);
  }
  public  void setStationId(String value){
     this.set(S_StationId,value);
  }
  public  void setStationIdNull(){
     this.set(S_StationId,null);
  }

  public String getStationId(){
       return DataType.getAsString(this.get(S_StationId));
  
  }
  public String getStationIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StationId));
      }

  public void initCreateTaskId(long value){
     this.initProperty(S_CreateTaskId,new Long(value));
  }
  public  void setCreateTaskId(long value){
     this.set(S_CreateTaskId,new Long(value));
  }
  public  void setCreateTaskIdNull(){
     this.set(S_CreateTaskId,null);
  }

  public long getCreateTaskId(){
        return DataType.getAsLong(this.get(S_CreateTaskId));
  
  }
  public long getCreateTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CreateTaskId));
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

  public void initPlwkComplete(Timestamp value){
     this.initProperty(S_PlwkComplete,value);
  }
  public  void setPlwkComplete(Timestamp value){
     this.set(S_PlwkComplete,value);
  }
  public  void setPlwkCompleteNull(){
     this.set(S_PlwkComplete,null);
  }

  public Timestamp getPlwkComplete(){
        return DataType.getAsDateTime(this.get(S_PlwkComplete));
  
  }
  public Timestamp getPlwkCompleteInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PlwkComplete));
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

  public void initSubflow(long value){
     this.initProperty(S_Subflow,new Long(value));
  }
  public  void setSubflow(long value){
     this.set(S_Subflow,new Long(value));
  }
  public  void setSubflowNull(){
     this.set(S_Subflow,null);
  }

  public long getSubflow(){
        return DataType.getAsLong(this.get(S_Subflow));
  
  }
  public long getSubflowInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Subflow));
      }

  public void initTaskId(long value){
     this.initProperty(S_TaskId,new Long(value));
  }
  public  void setTaskId(long value){
     this.set(S_TaskId,new Long(value));
  }
  public  void setTaskIdNull(){
     this.set(S_TaskId,null);
  }

  public long getTaskId(){
        return DataType.getAsLong(this.get(S_TaskId));
  
  }
  public long getTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TaskId));
      }

  public void initDoneResult(String value){
     this.initProperty(S_DoneResult,value);
  }
  public  void setDoneResult(String value){
     this.set(S_DoneResult,value);
  }
  public  void setDoneResultNull(){
     this.set(S_DoneResult,null);
  }

  public String getDoneResult(){
       return DataType.getAsString(this.get(S_DoneResult));
  
  }
  public String getDoneResultInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DoneResult));
      }


 
 }

