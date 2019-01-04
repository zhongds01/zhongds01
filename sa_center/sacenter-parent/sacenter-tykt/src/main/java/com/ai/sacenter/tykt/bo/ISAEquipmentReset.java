package com.ai.sacenter.tykt.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ISAEquipmentReset extends DataContainer implements DataContainerInterface,IISAEquipmentReset{
  private static final long serialVersionUID = 3253277221035768180L;
  private static String  m_boName = "com.ai.sacenter.tykt.bo.ISAEquipmentReset";
  public final static  String S_PrioLevel = "PRIO_LEVEL";
  public final static  String S_PsType = "PS_TYPE";
  public final static  String S_RollbackFlag = "ROLLBACK_FLAG";
  public final static  String S_AccId = "ACC_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_SuspendPsId = "SUSPEND_PS_ID";
  public final static  String S_TargetParam = "TARGET_PARAM";
  public final static  String S_CurrProcess = "CURR_PROCESS";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_HandNotes = "HAND_NOTES";
  public final static  String S_SpId = "SP_ID";
  public final static  String S_HandDate = "HAND_DATE";
  public final static  String S_HandOpId = "HAND_OP_ID";
  public final static  String S_PsServiceType = "PS_SERVICE_TYPE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_PsParam = "PS_PARAM";
  public final static  String S_ServiceId = "SERVICE_ID";
  public final static  String S_PsStatus = "PS_STATUS";
  public final static  String S_AsyncFlag = "ASYNC_FLAG";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_RetryTimes = "RETRY_TIMES";
  public final static  String S_PlanId = "PLAN_ID";
  public final static  String S_PsNetCode = "PS_NET_CODE";
  public final static  String S_OldPsParam = "OLD_PS_PARAM";
  public final static  String S_ActionId = "ACTION_ID";
  public final static  String S_FailNum = "FAIL_NUM";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_PsDeviceCode = "PS_DEVICE_CODE";
  public final static  String S_SubValidDate = "SUB_VALID_DATE";
  public final static  String S_RetOpId = "RET_OP_ID";
  public final static  String S_ActFlag = "ACT_FLAG";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_RetDate = "RET_DATE";
  public final static  String S_UppCreateDate = "UPP_CREATE_DATE";
  public final static  String S_ExternId = "EXTERN_ID";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_Notes = "NOTES";
  public final static  String S_StopType = "STOP_TYPE";
  public final static  String S_DeadLine = "DEAD_LINE";
  public final static  String S_OldPsId = "OLD_PS_ID";
  public final static  String S_RetNotes = "RET_NOTES";
  public final static  String S_PsId = "PS_ID";
  public final static  String S_SubPasswd = "SUB_PASSWD";
  public final static  String S_OrgPsId = "ORG_PS_ID";
  public final static  String S_SubPlanNo = "SUB_PLAN_NO";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_MonFlag = "MON_FLAG";
  public final static  String S_NextProcess = "NEXT_PROCESS";
  public final static  String S_SourceId = "SOURCE_ID";
  public final static  String S_RegionCode = "REGION_CODE";
  public final static  String S_StatusUpdDate = "STATUS_UPD_DATE";
  public final static  String S_StartDate = "START_DATE";
  public final static  String S_SubId = "SUB_ID";
  public final static  String S_ProdSpecId = "PROD_SPEC_ID";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_BusiCode = "BUSI_CODE";
  public final static  String S_FailCode = "FAIL_CODE";
  public final static  String S_PsServiceCode = "PS_SERVICE_CODE";
  public final static  String S_HandId = "HAND_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ISAEquipmentReset() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initPrioLevel(long value){
     this.initProperty(S_PrioLevel,new Long(value));
  }
  public  void setPrioLevel(long value){
     this.set(S_PrioLevel,new Long(value));
  }
  public  void setPrioLevelNull(){
     this.set(S_PrioLevel,null);
  }

  public long getPrioLevel(){
        return DataType.getAsLong(this.get(S_PrioLevel));
  
  }
  public long getPrioLevelInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PrioLevel));
      }

  public void initPsType(int value){
     this.initProperty(S_PsType,new Integer(value));
  }
  public  void setPsType(int value){
     this.set(S_PsType,new Integer(value));
  }
  public  void setPsTypeNull(){
     this.set(S_PsType,null);
  }

  public int getPsType(){
        return DataType.getAsInt(this.get(S_PsType));
  
  }
  public int getPsTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PsType));
      }

  public void initRollbackFlag(int value){
     this.initProperty(S_RollbackFlag,new Integer(value));
  }
  public  void setRollbackFlag(int value){
     this.set(S_RollbackFlag,new Integer(value));
  }
  public  void setRollbackFlagNull(){
     this.set(S_RollbackFlag,null);
  }

  public int getRollbackFlag(){
        return DataType.getAsInt(this.get(S_RollbackFlag));
  
  }
  public int getRollbackFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_RollbackFlag));
      }

  public void initAccId(long value){
     this.initProperty(S_AccId,new Long(value));
  }
  public  void setAccId(long value){
     this.set(S_AccId,new Long(value));
  }
  public  void setAccIdNull(){
     this.set(S_AccId,null);
  }

  public long getAccId(){
        return DataType.getAsLong(this.get(S_AccId));
  
  }
  public long getAccIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AccId));
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

  public void initSuspendPsId(long value){
     this.initProperty(S_SuspendPsId,new Long(value));
  }
  public  void setSuspendPsId(long value){
     this.set(S_SuspendPsId,new Long(value));
  }
  public  void setSuspendPsIdNull(){
     this.set(S_SuspendPsId,null);
  }

  public long getSuspendPsId(){
        return DataType.getAsLong(this.get(S_SuspendPsId));
  
  }
  public long getSuspendPsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SuspendPsId));
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

  public void initCurrProcess(String value){
     this.initProperty(S_CurrProcess,value);
  }
  public  void setCurrProcess(String value){
     this.set(S_CurrProcess,value);
  }
  public  void setCurrProcessNull(){
     this.set(S_CurrProcess,null);
  }

  public String getCurrProcess(){
       return DataType.getAsString(this.get(S_CurrProcess));
  
  }
  public String getCurrProcessInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CurrProcess));
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

  public void initHandNotes(String value){
     this.initProperty(S_HandNotes,value);
  }
  public  void setHandNotes(String value){
     this.set(S_HandNotes,value);
  }
  public  void setHandNotesNull(){
     this.set(S_HandNotes,null);
  }

  public String getHandNotes(){
       return DataType.getAsString(this.get(S_HandNotes));
  
  }
  public String getHandNotesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_HandNotes));
      }

  public void initSpId(int value){
     this.initProperty(S_SpId,new Integer(value));
  }
  public  void setSpId(int value){
     this.set(S_SpId,new Integer(value));
  }
  public  void setSpIdNull(){
     this.set(S_SpId,null);
  }

  public int getSpId(){
        return DataType.getAsInt(this.get(S_SpId));
  
  }
  public int getSpIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SpId));
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

  public void initPsServiceType(String value){
     this.initProperty(S_PsServiceType,value);
  }
  public  void setPsServiceType(String value){
     this.set(S_PsServiceType,value);
  }
  public  void setPsServiceTypeNull(){
     this.set(S_PsServiceType,null);
  }

  public String getPsServiceType(){
       return DataType.getAsString(this.get(S_PsServiceType));
  
  }
  public String getPsServiceTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PsServiceType));
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

  public void initAsyncFlag(int value){
     this.initProperty(S_AsyncFlag,new Integer(value));
  }
  public  void setAsyncFlag(int value){
     this.set(S_AsyncFlag,new Integer(value));
  }
  public  void setAsyncFlagNull(){
     this.set(S_AsyncFlag,null);
  }

  public int getAsyncFlag(){
        return DataType.getAsInt(this.get(S_AsyncFlag));
  
  }
  public int getAsyncFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_AsyncFlag));
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

  public void initPlanId(long value){
     this.initProperty(S_PlanId,new Long(value));
  }
  public  void setPlanId(long value){
     this.set(S_PlanId,new Long(value));
  }
  public  void setPlanIdNull(){
     this.set(S_PlanId,null);
  }

  public long getPlanId(){
        return DataType.getAsLong(this.get(S_PlanId));
  
  }
  public long getPlanIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PlanId));
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

  public void initActionId(long value){
     this.initProperty(S_ActionId,new Long(value));
  }
  public  void setActionId(long value){
     this.set(S_ActionId,new Long(value));
  }
  public  void setActionIdNull(){
     this.set(S_ActionId,null);
  }

  public long getActionId(){
        return DataType.getAsLong(this.get(S_ActionId));
  
  }
  public long getActionIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ActionId));
      }

  public void initFailNum(int value){
     this.initProperty(S_FailNum,new Integer(value));
  }
  public  void setFailNum(int value){
     this.set(S_FailNum,new Integer(value));
  }
  public  void setFailNumNull(){
     this.set(S_FailNum,null);
  }

  public int getFailNum(){
        return DataType.getAsInt(this.get(S_FailNum));
  
  }
  public int getFailNumInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_FailNum));
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

  public void initPsDeviceCode(String value){
     this.initProperty(S_PsDeviceCode,value);
  }
  public  void setPsDeviceCode(String value){
     this.set(S_PsDeviceCode,value);
  }
  public  void setPsDeviceCodeNull(){
     this.set(S_PsDeviceCode,null);
  }

  public String getPsDeviceCode(){
       return DataType.getAsString(this.get(S_PsDeviceCode));
  
  }
  public String getPsDeviceCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PsDeviceCode));
      }

  public void initSubValidDate(Timestamp value){
     this.initProperty(S_SubValidDate,value);
  }
  public  void setSubValidDate(Timestamp value){
     this.set(S_SubValidDate,value);
  }
  public  void setSubValidDateNull(){
     this.set(S_SubValidDate,null);
  }

  public Timestamp getSubValidDate(){
        return DataType.getAsDateTime(this.get(S_SubValidDate));
  
  }
  public Timestamp getSubValidDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SubValidDate));
      }

  public void initRetOpId(long value){
     this.initProperty(S_RetOpId,new Long(value));
  }
  public  void setRetOpId(long value){
     this.set(S_RetOpId,new Long(value));
  }
  public  void setRetOpIdNull(){
     this.set(S_RetOpId,null);
  }

  public long getRetOpId(){
        return DataType.getAsLong(this.get(S_RetOpId));
  
  }
  public long getRetOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RetOpId));
      }

  public void initActFlag(int value){
     this.initProperty(S_ActFlag,new Integer(value));
  }
  public  void setActFlag(int value){
     this.set(S_ActFlag,new Integer(value));
  }
  public  void setActFlagNull(){
     this.set(S_ActFlag,null);
  }

  public int getActFlag(){
        return DataType.getAsInt(this.get(S_ActFlag));
  
  }
  public int getActFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ActFlag));
      }

  public void initSortId(long value){
     this.initProperty(S_SortId,new Long(value));
  }
  public  void setSortId(long value){
     this.set(S_SortId,new Long(value));
  }
  public  void setSortIdNull(){
     this.set(S_SortId,null);
  }

  public long getSortId(){
        return DataType.getAsLong(this.get(S_SortId));
  
  }
  public long getSortIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SortId));
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

  public void initUppCreateDate(Timestamp value){
     this.initProperty(S_UppCreateDate,value);
  }
  public  void setUppCreateDate(Timestamp value){
     this.set(S_UppCreateDate,value);
  }
  public  void setUppCreateDateNull(){
     this.set(S_UppCreateDate,null);
  }

  public Timestamp getUppCreateDate(){
        return DataType.getAsDateTime(this.get(S_UppCreateDate));
  
  }
  public Timestamp getUppCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_UppCreateDate));
      }

  public void initExternId(String value){
     this.initProperty(S_ExternId,value);
  }
  public  void setExternId(String value){
     this.set(S_ExternId,value);
  }
  public  void setExternIdNull(){
     this.set(S_ExternId,null);
  }

  public String getExternId(){
       return DataType.getAsString(this.get(S_ExternId));
  
  }
  public String getExternIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExternId));
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

  public void initDeadLine(long value){
     this.initProperty(S_DeadLine,new Long(value));
  }
  public  void setDeadLine(long value){
     this.set(S_DeadLine,new Long(value));
  }
  public  void setDeadLineNull(){
     this.set(S_DeadLine,null);
  }

  public long getDeadLine(){
        return DataType.getAsLong(this.get(S_DeadLine));
  
  }
  public long getDeadLineInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DeadLine));
      }

  public void initOldPsId(long value){
     this.initProperty(S_OldPsId,new Long(value));
  }
  public  void setOldPsId(long value){
     this.set(S_OldPsId,new Long(value));
  }
  public  void setOldPsIdNull(){
     this.set(S_OldPsId,null);
  }

  public long getOldPsId(){
        return DataType.getAsLong(this.get(S_OldPsId));
  
  }
  public long getOldPsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OldPsId));
      }

  public void initRetNotes(String value){
     this.initProperty(S_RetNotes,value);
  }
  public  void setRetNotes(String value){
     this.set(S_RetNotes,value);
  }
  public  void setRetNotesNull(){
     this.set(S_RetNotes,null);
  }

  public String getRetNotes(){
       return DataType.getAsString(this.get(S_RetNotes));
  
  }
  public String getRetNotesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RetNotes));
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

  public void initSubPasswd(String value){
     this.initProperty(S_SubPasswd,value);
  }
  public  void setSubPasswd(String value){
     this.set(S_SubPasswd,value);
  }
  public  void setSubPasswdNull(){
     this.set(S_SubPasswd,null);
  }

  public String getSubPasswd(){
       return DataType.getAsString(this.get(S_SubPasswd));
  
  }
  public String getSubPasswdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SubPasswd));
      }

  public void initOrgPsId(long value){
     this.initProperty(S_OrgPsId,new Long(value));
  }
  public  void setOrgPsId(long value){
     this.set(S_OrgPsId,new Long(value));
  }
  public  void setOrgPsIdNull(){
     this.set(S_OrgPsId,null);
  }

  public long getOrgPsId(){
        return DataType.getAsLong(this.get(S_OrgPsId));
  
  }
  public long getOrgPsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrgPsId));
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

  public void initMonFlag(int value){
     this.initProperty(S_MonFlag,new Integer(value));
  }
  public  void setMonFlag(int value){
     this.set(S_MonFlag,new Integer(value));
  }
  public  void setMonFlagNull(){
     this.set(S_MonFlag,null);
  }

  public int getMonFlag(){
        return DataType.getAsInt(this.get(S_MonFlag));
  
  }
  public int getMonFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MonFlag));
      }

  public void initNextProcess(String value){
     this.initProperty(S_NextProcess,value);
  }
  public  void setNextProcess(String value){
     this.set(S_NextProcess,value);
  }
  public  void setNextProcessNull(){
     this.set(S_NextProcess,null);
  }

  public String getNextProcess(){
       return DataType.getAsString(this.get(S_NextProcess));
  
  }
  public String getNextProcessInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NextProcess));
      }

  public void initSourceId(int value){
     this.initProperty(S_SourceId,new Integer(value));
  }
  public  void setSourceId(int value){
     this.set(S_SourceId,new Integer(value));
  }
  public  void setSourceIdNull(){
     this.set(S_SourceId,null);
  }

  public int getSourceId(){
        return DataType.getAsInt(this.get(S_SourceId));
  
  }
  public int getSourceIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SourceId));
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

  public void initStatusUpdDate(Timestamp value){
     this.initProperty(S_StatusUpdDate,value);
  }
  public  void setStatusUpdDate(Timestamp value){
     this.set(S_StatusUpdDate,value);
  }
  public  void setStatusUpdDateNull(){
     this.set(S_StatusUpdDate,null);
  }

  public Timestamp getStatusUpdDate(){
        return DataType.getAsDateTime(this.get(S_StatusUpdDate));
  
  }
  public Timestamp getStatusUpdDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StatusUpdDate));
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

  public void initSubId(long value){
     this.initProperty(S_SubId,new Long(value));
  }
  public  void setSubId(long value){
     this.set(S_SubId,new Long(value));
  }
  public  void setSubIdNull(){
     this.set(S_SubId,null);
  }

  public long getSubId(){
        return DataType.getAsLong(this.get(S_SubId));
  
  }
  public long getSubIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SubId));
      }

  public void initProdSpecId(int value){
     this.initProperty(S_ProdSpecId,new Integer(value));
  }
  public  void setProdSpecId(int value){
     this.set(S_ProdSpecId,new Integer(value));
  }
  public  void setProdSpecIdNull(){
     this.set(S_ProdSpecId,null);
  }

  public int getProdSpecId(){
        return DataType.getAsInt(this.get(S_ProdSpecId));
  
  }
  public int getProdSpecIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ProdSpecId));
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

  public void initBusiCode(long value){
     this.initProperty(S_BusiCode,new Long(value));
  }
  public  void setBusiCode(long value){
     this.set(S_BusiCode,new Long(value));
  }
  public  void setBusiCodeNull(){
     this.set(S_BusiCode,null);
  }

  public long getBusiCode(){
        return DataType.getAsLong(this.get(S_BusiCode));
  
  }
  public long getBusiCodeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiCode));
      }

  public void initFailCode(long value){
     this.initProperty(S_FailCode,new Long(value));
  }
  public  void setFailCode(long value){
     this.set(S_FailCode,new Long(value));
  }
  public  void setFailCodeNull(){
     this.set(S_FailCode,null);
  }

  public long getFailCode(){
        return DataType.getAsLong(this.get(S_FailCode));
  
  }
  public long getFailCodeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FailCode));
      }

  public void initPsServiceCode(String value){
     this.initProperty(S_PsServiceCode,value);
  }
  public  void setPsServiceCode(String value){
     this.set(S_PsServiceCode,value);
  }
  public  void setPsServiceCodeNull(){
     this.set(S_PsServiceCode,null);
  }

  public String getPsServiceCode(){
       return DataType.getAsString(this.get(S_PsServiceCode));
  
  }
  public String getPsServiceCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PsServiceCode));
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

