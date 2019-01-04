package com.ai.sacenter.receive.order.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ISARocket extends DataContainer implements DataContainerInterface,IISARocket{
  private static final long serialVersionUID = -3866205199581225284L;
  private static String  m_boName = "com.ai.sacenter.receive.order.bo.ISARocket";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_ChannelId = "CHANNEL_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_PlwkCreate = "PLWK_CREATE";
  public final static  String S_OrderRegionId = "ORDER_REGION_ID";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_PlwkComplete = "PLWK_COMPLETE";
  public final static  String S_QueueId = "QUEUE_ID";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_CustOrder = "CUST_ORDER";
  public final static  String S_CatalogId = "CATALOG_ID";
  public final static  String S_Originate = "ORIGINATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ISARocket() throws AIException{
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

  public void initBusinessId(String value){
     this.initProperty(S_BusinessId,value);
  }
  public  void setBusinessId(String value){
     this.set(S_BusinessId,value);
  }
  public  void setBusinessIdNull(){
     this.set(S_BusinessId,null);
  }

  public String getBusinessId(){
       return DataType.getAsString(this.get(S_BusinessId));
  
  }
  public String getBusinessIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusinessId));
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

  public void initChannelId(String value){
     this.initProperty(S_ChannelId,value);
  }
  public  void setChannelId(String value){
     this.set(S_ChannelId,value);
  }
  public  void setChannelIdNull(){
     this.set(S_ChannelId,null);
  }

  public String getChannelId(){
       return DataType.getAsString(this.get(S_ChannelId));
  
  }
  public String getChannelIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChannelId));
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

  public void initOrderRegionId(String value){
     this.initProperty(S_OrderRegionId,value);
  }
  public  void setOrderRegionId(String value){
     this.set(S_OrderRegionId,value);
  }
  public  void setOrderRegionIdNull(){
     this.set(S_OrderRegionId,null);
  }

  public String getOrderRegionId(){
       return DataType.getAsString(this.get(S_OrderRegionId));
  
  }
  public String getOrderRegionIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderRegionId));
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

  public void initQueueId(String value){
     this.initProperty(S_QueueId,value);
  }
  public  void setQueueId(String value){
     this.set(S_QueueId,value);
  }
  public  void setQueueIdNull(){
     this.set(S_QueueId,null);
  }

  public String getQueueId(){
       return DataType.getAsString(this.get(S_QueueId));
  
  }
  public String getQueueIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_QueueId));
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

  public void initCatalogId(String value){
     this.initProperty(S_CatalogId,value);
  }
  public  void setCatalogId(String value){
     this.set(S_CatalogId,value);
  }
  public  void setCatalogIdNull(){
     this.set(S_CatalogId,null);
  }

  public String getCatalogId(){
       return DataType.getAsString(this.get(S_CatalogId));
  
  }
  public String getCatalogIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CatalogId));
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


 
 }

