package com.ai.sacenter.core.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class SAOrder extends DataContainer implements DataContainerInterface,ISAOrder{
  private static final long serialVersionUID = 4528478825528438818L;
  private static String  m_boName = "com.ai.sacenter.core.bo.SAOrder";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Business = "BUSINESS";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Competence = "COMPETENCE";
  public final static  String S_OrderRegionId = "ORDER_REGION_ID";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Catalog = "CATALOG";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_CustOrder = "CUST_ORDER";
  public final static  String S_UserRegionId = "USER_REGION_ID";
  public final static  String S_GroupOrderId = "GROUP_ORDER_ID";
  public final static  String S_ChannelId = "CHANNEL_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_RegionCode = "REGION_CODE";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_CreateTaskId = "CREATE_TASK_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_FailLog = "FAIL_LOG";
  public final static  String S_CreateOrderId = "CREATE_ORDER_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAOrder() throws AIException{
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

  public void initUserRegionId(String value){
     this.initProperty(S_UserRegionId,value);
  }
  public  void setUserRegionId(String value){
     this.set(S_UserRegionId,value);
  }
  public  void setUserRegionIdNull(){
     this.set(S_UserRegionId,null);
  }

  public String getUserRegionId(){
       return DataType.getAsString(this.get(S_UserRegionId));
  
  }
  public String getUserRegionIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserRegionId));
      }

  public void initGroupOrderId(long value){
     this.initProperty(S_GroupOrderId,new Long(value));
  }
  public  void setGroupOrderId(long value){
     this.set(S_GroupOrderId,new Long(value));
  }
  public  void setGroupOrderIdNull(){
     this.set(S_GroupOrderId,null);
  }

  public long getGroupOrderId(){
        return DataType.getAsLong(this.get(S_GroupOrderId));
  
  }
  public long getGroupOrderIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_GroupOrderId));
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

  public void initCreateOrderId(long value){
     this.initProperty(S_CreateOrderId,new Long(value));
  }
  public  void setCreateOrderId(long value){
     this.set(S_CreateOrderId,new Long(value));
  }
  public  void setCreateOrderIdNull(){
     this.set(S_CreateOrderId,null);
  }

  public long getCreateOrderId(){
        return DataType.getAsLong(this.get(S_CreateOrderId));
  
  }
  public long getCreateOrderIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CreateOrderId));
      }


 
 }

