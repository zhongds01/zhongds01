package com.asiainfo.sacenter.audit.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sacenter.audit.ivalues.IBOIOPENPROVISIONOLDValue;

public class BOIOPENPROVISIONOLDBean extends DataContainer implements DataContainerInterface,IBOIOPENPROVISIONOLDValue {

  private static String  m_boName = "com.asiainfo.sacenter.audit.bo.BOIOPENPROVISIONOLD";



  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_State = "STATE";
  public final static  String S_OldPsParam = "OLD_PS_PARAM";
  public final static  String S_StopType = "STOP_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PsParam = "PS_PARAM";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_ActionId = "ACTION_ID";
  public final static  String S_PsServiceType = "PS_SERVICE_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOIOPENPROVISIONOLDBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public int getState(){
        return DataType.getAsInt(this.get(S_State));
  
  }
  public int getStateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_State));
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

  public void initRemarks(String value){
     this.initProperty(S_Remarks,value);
  }
  public  void setRemarks(String value){
     this.set(S_Remarks,value);
  }
  public  void setRemarksNull(){
     this.set(S_Remarks,null);
  }

  public String getRemarks(){
       return DataType.getAsString(this.get(S_Remarks));
  
  }
  public String getRemarksInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remarks));
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


 
 }

