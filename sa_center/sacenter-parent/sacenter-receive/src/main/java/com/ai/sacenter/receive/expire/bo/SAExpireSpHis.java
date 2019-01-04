package com.ai.sacenter.receive.expire.bo;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class SAExpireSpHis extends DataContainer implements DataContainerInterface,ISAExpireSp{
  private static final long serialVersionUID = 697132188787910348L;
  private static String  m_boName = "com.ai.sacenter.receive.expire.bo.SAExpireSpHis";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_InsProdId = "INS_PROD_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Param01 = "PARAM_01";
  public final static  String S_Param02 = "PARAM_02";
  public final static  String S_ProductId = "PRODUCT_ID";
  public final static  String S_Param03 = "PARAM_03";
  public final static  String S_Param04 = "PARAM_04";
  public final static  String S_Param05 = "PARAM_05";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Status = "STATUS";
  public final static  String S_CompleteDate = "COMPLETE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_CustOrder = "CUST_ORDER";
  public final static  String S_ProdType = "PROD_TYPE";
  public final static  String S_ServiceId = "SERVICE_ID";
  public final static  String S_OfferId = "OFFER_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAExpireSpHis() throws AIException{
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

  public void initInsProdId(long value){
     this.initProperty(S_InsProdId,new Long(value));
  }
  public  void setInsProdId(long value){
     this.set(S_InsProdId,new Long(value));
  }
  public  void setInsProdIdNull(){
     this.set(S_InsProdId,null);
  }

  public long getInsProdId(){
        return DataType.getAsLong(this.get(S_InsProdId));
  
  }
  public long getInsProdIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InsProdId));
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

  public void initParam01(String value){
     this.initProperty(S_Param01,value);
  }
  public  void setParam01(String value){
     this.set(S_Param01,value);
  }
  public  void setParam01Null(){
     this.set(S_Param01,null);
  }

  public String getParam01(){
       return DataType.getAsString(this.get(S_Param01));
  
  }
  public String getParam01InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param01));
      }

  public void initParam02(String value){
     this.initProperty(S_Param02,value);
  }
  public  void setParam02(String value){
     this.set(S_Param02,value);
  }
  public  void setParam02Null(){
     this.set(S_Param02,null);
  }

  public String getParam02(){
       return DataType.getAsString(this.get(S_Param02));
  
  }
  public String getParam02InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param02));
      }

  public void initProductId(long value){
     this.initProperty(S_ProductId,new Long(value));
  }
  public  void setProductId(long value){
     this.set(S_ProductId,new Long(value));
  }
  public  void setProductIdNull(){
     this.set(S_ProductId,null);
  }

  public long getProductId(){
        return DataType.getAsLong(this.get(S_ProductId));
  
  }
  public long getProductIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProductId));
      }

  public void initParam03(String value){
     this.initProperty(S_Param03,value);
  }
  public  void setParam03(String value){
     this.set(S_Param03,value);
  }
  public  void setParam03Null(){
     this.set(S_Param03,null);
  }

  public String getParam03(){
       return DataType.getAsString(this.get(S_Param03));
  
  }
  public String getParam03InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param03));
      }

  public void initParam04(String value){
     this.initProperty(S_Param04,value);
  }
  public  void setParam04(String value){
     this.set(S_Param04,value);
  }
  public  void setParam04Null(){
     this.set(S_Param04,null);
  }

  public String getParam04(){
       return DataType.getAsString(this.get(S_Param04));
  
  }
  public String getParam04InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param04));
      }

  public void initParam05(String value){
     this.initProperty(S_Param05,value);
  }
  public  void setParam05(String value){
     this.set(S_Param05,value);
  }
  public  void setParam05Null(){
     this.set(S_Param05,null);
  }

  public String getParam05(){
       return DataType.getAsString(this.get(S_Param05));
  
  }
  public String getParam05InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param05));
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

  public void initStatus(String value){
     this.initProperty(S_Status,value);
  }
  public  void setStatus(String value){
     this.set(S_Status,value);
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public String getStatus(){
       return DataType.getAsString(this.get(S_Status));
  
  }
  public String getStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Status));
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

  public void initProdType(String value){
     this.initProperty(S_ProdType,value);
  }
  public  void setProdType(String value){
     this.set(S_ProdType,value);
  }
  public  void setProdTypeNull(){
     this.set(S_ProdType,null);
  }

  public String getProdType(){
       return DataType.getAsString(this.get(S_ProdType));
  
  }
  public String getProdTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProdType));
      }

  public void initServiceId(long value){
     this.initProperty(S_ServiceId,new Long(value));
  }
  public  void setServiceId(long value){
     this.set(S_ServiceId,new Long(value));
  }
  public  void setServiceIdNull(){
     this.set(S_ServiceId,null);
  }

  public long getServiceId(){
        return DataType.getAsLong(this.get(S_ServiceId));
  
  }
  public long getServiceIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ServiceId));
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


 
 }

