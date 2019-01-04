package com.asiainfo.sacenter.shcmcc.provision.dsmp.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ISADsmpOrderHis extends DataContainer implements DataContainerInterface,IISAProvision{
  private static final long serialVersionUID = -1098410241360318639L;
  private static String  m_boName = "com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.ISADsmpOrderHis";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_TargetParam = "TARGET_PARAM";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_RetDate = "RET_DATE";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_Notes = "NOTES";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_StopType = "STOP_TYPE";
  public final static  String S_PsParam = "PS_PARAM";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Directive = "DIRECTIVE";
  public final static  String S_CustOrder = "CUST_ORDER";
  public final static  String S_PsId = "PS_ID";
  public final static  String S_ServiceId = "SERVICE_ID";
  public final static  String S_PsStatus = "PS_STATUS";
  public final static  String S_SubPlanNo = "SUB_PLAN_NO";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_RetryTimes = "RETRY_TIMES";
  public final static  String S_StartDate = "START_DATE";
  public final static  String S_PsNetCode = "PS_NET_CODE";
  public final static  String S_OldPsParam = "OLD_PS_PARAM";
  public final static  String S_FailDevice = "FAIL_DEVICE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_FailCode = "FAIL_CODE";
  public final static  String S_Program = "PROGRAM";
  public final static  String S_TaskId = "TASK_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ISADsmpOrderHis() throws AIException{
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

  public void initTargetParam(String value){
     this.initProperty(S_TargetParam,value);
  }
  public  void setTargetParam(String value){
     this.set(S_TargetParam,value);
  }
  public  void setTargetParamNull(){
     this.set(S_TargetParam,null);
  }

  public String getTargetParam(){
       return DataType.getAsString(this.get(S_TargetParam));
  
  }
  public String getTargetParamInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TargetParam));
      }

  public void initSubBillId(String value){
     this.initProperty(S_SubBillId,value);
  }
  public  void setSubBillId(String value){
     this.set(S_SubBillId,value);
  }
  public  void setSubBillIdNull(){
     this.set(S_SubBillId,null);
  }

  public String getSubBillId(){
       return DataType.getAsString(this.get(S_SubBillId));
  
  }
  public String getSubBillIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SubBillId));
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

  public void initRetDate(Timestamp value){
     this.initProperty(S_RetDate,value);
  }
  public  void setRetDate(Timestamp value){
     this.set(S_RetDate,value);
  }
  public  void setRetDateNull(){
     this.set(S_RetDate,null);
  }

  public Timestamp getRetDate(){
        return DataType.getAsDateTime(this.get(S_RetDate));
  
  }
  public Timestamp getRetDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_RetDate));
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

  public void initNotes(String value){
     this.initProperty(S_Notes,value);
  }
  public  void setNotes(String value){
     this.set(S_Notes,value);
  }
  public  void setNotesNull(){
     this.set(S_Notes,null);
  }

  public String getNotes(){
       return DataType.getAsString(this.get(S_Notes));
  
  }
  public String getNotesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Notes));
      }

  public void initBillId(String value){
     this.initProperty(S_BillId,value);
  }
  public  void setBillId(String value){
     this.set(S_BillId,value);
  }
  public  void setBillIdNull(){
     this.set(S_BillId,null);
  }

  public String getBillId(){
       return DataType.getAsString(this.get(S_BillId));
  
  }
  public String getBillIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BillId));
      }

  public void initStopType(int value){
     this.initProperty(S_StopType,new Integer(value));
  }
  public  void setStopType(int value){
     this.set(S_StopType,new Integer(value));
  }
  public  void setStopTypeNull(){
     this.set(S_StopType,null);
  }

  public int getStopType(){
        return DataType.getAsInt(this.get(S_StopType));
  
  }
  public int getStopTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_StopType));
      }

  public void initPsParam(String value){
     this.initProperty(S_PsParam,value);
  }
  public  void setPsParam(String value){
     this.set(S_PsParam,value);
  }
  public  void setPsParamNull(){
     this.set(S_PsParam,null);
  }

  public String getPsParam(){
       return DataType.getAsString(this.get(S_PsParam));
  
  }
  public String getPsParamInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PsParam));
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

  public void initCustOrder(String value){
     this.initProperty(S_CustOrder,value);
  }
  public  void setCustOrder(String value){
     this.set(S_CustOrder,value);
  }
  public  void setCustOrderNull(){
     this.set(S_CustOrder,null);
  }

  public String getCustOrder(){
       return DataType.getAsString(this.get(S_CustOrder));
  
  }
  public String getCustOrderInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustOrder));
      }

  public void initPsId(long value){
     this.initProperty(S_PsId,new Long(value));
  }
  public  void setPsId(long value){
     this.set(S_PsId,new Long(value));
  }
  public  void setPsIdNull(){
     this.set(S_PsId,null);
  }

  public long getPsId(){
        return DataType.getAsLong(this.get(S_PsId));
  
  }
  public long getPsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PsId));
      }

  public void initServiceId(int value){
     this.initProperty(S_ServiceId,new Integer(value));
  }
  public  void setServiceId(int value){
     this.set(S_ServiceId,new Integer(value));
  }
  public  void setServiceIdNull(){
     this.set(S_ServiceId,null);
  }

  public int getServiceId(){
        return DataType.getAsInt(this.get(S_ServiceId));
  
  }
  public int getServiceIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ServiceId));
      }

  public void initPsStatus(int value){
     this.initProperty(S_PsStatus,new Integer(value));
  }
  public  void setPsStatus(int value){
     this.set(S_PsStatus,new Integer(value));
  }
  public  void setPsStatusNull(){
     this.set(S_PsStatus,null);
  }

  public int getPsStatus(){
        return DataType.getAsInt(this.get(S_PsStatus));
  
  }
  public int getPsStatusInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PsStatus));
      }

  public void initSubPlanNo(long value){
     this.initProperty(S_SubPlanNo,new Long(value));
  }
  public  void setSubPlanNo(long value){
     this.set(S_SubPlanNo,new Long(value));
  }
  public  void setSubPlanNoNull(){
     this.set(S_SubPlanNo,null);
  }

  public long getSubPlanNo(){
        return DataType.getAsLong(this.get(S_SubPlanNo));
  
  }
  public long getSubPlanNoInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SubPlanNo));
      }

  public void initDoneCode(String value){
     this.initProperty(S_DoneCode,value);
  }
  public  void setDoneCode(String value){
     this.set(S_DoneCode,value);
  }
  public  void setDoneCodeNull(){
     this.set(S_DoneCode,null);
  }

  public String getDoneCode(){
       return DataType.getAsString(this.get(S_DoneCode));
  
  }
  public String getDoneCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DoneCode));
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

  public void initRetryTimes(int value){
     this.initProperty(S_RetryTimes,new Integer(value));
  }
  public  void setRetryTimes(int value){
     this.set(S_RetryTimes,new Integer(value));
  }
  public  void setRetryTimesNull(){
     this.set(S_RetryTimes,null);
  }

  public int getRetryTimes(){
        return DataType.getAsInt(this.get(S_RetryTimes));
  
  }
  public int getRetryTimesInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_RetryTimes));
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

  public void initOldPsParam(String value){
     this.initProperty(S_OldPsParam,value);
  }
  public  void setOldPsParam(String value){
     this.set(S_OldPsParam,value);
  }
  public  void setOldPsParamNull(){
     this.set(S_OldPsParam,null);
  }

  public String getOldPsParam(){
       return DataType.getAsString(this.get(S_OldPsParam));
  
  }
  public String getOldPsParamInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OldPsParam));
      }

  public void initFailDevice(String value){
     this.initProperty(S_FailDevice,value);
  }
  public  void setFailDevice(String value){
     this.set(S_FailDevice,value);
  }
  public  void setFailDeviceNull(){
     this.set(S_FailDevice,null);
  }

  public String getFailDevice(){
       return DataType.getAsString(this.get(S_FailDevice));
  
  }
  public String getFailDeviceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FailDevice));
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


 
 }

