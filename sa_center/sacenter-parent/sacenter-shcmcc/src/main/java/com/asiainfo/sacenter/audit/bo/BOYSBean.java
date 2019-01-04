package com.asiainfo.sacenter.audit.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sacenter.audit.ivalues.IBOYSValue;

public class BOYSBean extends DataContainer implements DataContainerInterface,IBOYSValue {

  private static String  m_boName = "com.asiainfo.sacenter.audit.bo.BOYS";



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
  public BOYSBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

