package com.ai.sacenter.receive.custom.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class InsProd extends DataContainer implements DataContainerInterface{
  private static final long serialVersionUID = -4361950567580625494L;
  private static String  m_boName = "com.ai.sacenter.receive.custom.bo.InsProd";
  public final static  String S_State = "STATE";
  public final static  String S_OldOfferId = "OLD_OFFER_ID";
  public final static  String S_EffectiveDate = "EFFECTIVE_DATE";
  public final static  String S_ProdType = "PROD_TYPE";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_ProdId = "PROD_ID";
  public final static  String S_ProdPkgFlag = "PROD_PKG_FLAG";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_OfferInstId = "OFFER_INST_ID";
  public final static  String S_OldInstOfferId = "OLD_INST_OFFER_ID";
  public final static  String S_CountyCode = "COUNTY_CODE";
  public final static  String S_SrcSystemType = "SRC_SYSTEM_TYPE";
  public final static  String S_ExpireProcessType = "EXPIRE_PROCESS_TYPE";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_ProdInstId = "PROD_INST_ID";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_EffectiveDateType = "EFFECTIVE_DATE_TYPE";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_PresentObjUser = "PRESENT_OBJ_USER";
  public final static  String S_BossEffectiveDate = "BOSS_EFFECTIVE_DATE";
  public final static  String S_ExpireDate = "EXPIRE_DATE";
  public final static  String S_ExpireDateType = "EXPIRE_DATE_TYPE";
  public final static  String S_SrcSystemExtCode = "SRC_SYSTEM_EXT_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public InsProd() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //�������������������ҵ���������
   throw new AIException("Cannot reset ObjectType");
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

  public void initOldOfferId(long value){
     this.initProperty(S_OldOfferId,new Long(value));
  }
  public  void setOldOfferId(long value){
     this.set(S_OldOfferId,new Long(value));
  }
  public  void setOldOfferIdNull(){
     this.set(S_OldOfferId,null);
  }

  public long getOldOfferId(){
        return DataType.getAsLong(this.get(S_OldOfferId));
  
  }
  public long getOldOfferIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OldOfferId));
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

  public void initProdId(long value){
     this.initProperty(S_ProdId,new Long(value));
  }
  public  void setProdId(long value){
     this.set(S_ProdId,new Long(value));
  }
  public  void setProdIdNull(){
     this.set(S_ProdId,null);
  }

  public long getProdId(){
        return DataType.getAsLong(this.get(S_ProdId));
  
  }
  public long getProdIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProdId));
      }

  public void initProdPkgFlag(int value){
     this.initProperty(S_ProdPkgFlag,new Integer(value));
  }
  public  void setProdPkgFlag(int value){
     this.set(S_ProdPkgFlag,new Integer(value));
  }
  public  void setProdPkgFlagNull(){
     this.set(S_ProdPkgFlag,null);
  }

  public int getProdPkgFlag(){
        return DataType.getAsInt(this.get(S_ProdPkgFlag));
  
  }
  public int getProdPkgFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ProdPkgFlag));
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

  public void initOfferInstId(long value){
     this.initProperty(S_OfferInstId,new Long(value));
  }
  public  void setOfferInstId(long value){
     this.set(S_OfferInstId,new Long(value));
  }
  public  void setOfferInstIdNull(){
     this.set(S_OfferInstId,null);
  }

  public long getOfferInstId(){
        return DataType.getAsLong(this.get(S_OfferInstId));
  
  }
  public long getOfferInstIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OfferInstId));
      }

  public void initOldInstOfferId(long value){
     this.initProperty(S_OldInstOfferId,new Long(value));
  }
  public  void setOldInstOfferId(long value){
     this.set(S_OldInstOfferId,new Long(value));
  }
  public  void setOldInstOfferIdNull(){
     this.set(S_OldInstOfferId,null);
  }

  public long getOldInstOfferId(){
        return DataType.getAsLong(this.get(S_OldInstOfferId));
  
  }
  public long getOldInstOfferIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OldInstOfferId));
      }

  public void initCountyCode(String value){
     this.initProperty(S_CountyCode,value);
  }
  public  void setCountyCode(String value){
     this.set(S_CountyCode,value);
  }
  public  void setCountyCodeNull(){
     this.set(S_CountyCode,null);
  }

  public String getCountyCode(){
       return DataType.getAsString(this.get(S_CountyCode));
  
  }
  public String getCountyCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CountyCode));
      }

  public void initSrcSystemType(int value){
     this.initProperty(S_SrcSystemType,new Integer(value));
  }
  public  void setSrcSystemType(int value){
     this.set(S_SrcSystemType,new Integer(value));
  }
  public  void setSrcSystemTypeNull(){
     this.set(S_SrcSystemType,null);
  }

  public int getSrcSystemType(){
        return DataType.getAsInt(this.get(S_SrcSystemType));
  
  }
  public int getSrcSystemTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SrcSystemType));
      }

  public void initExpireProcessType(int value){
     this.initProperty(S_ExpireProcessType,new Integer(value));
  }
  public  void setExpireProcessType(int value){
     this.set(S_ExpireProcessType,new Integer(value));
  }
  public  void setExpireProcessTypeNull(){
     this.set(S_ExpireProcessType,null);
  }

  public int getExpireProcessType(){
        return DataType.getAsInt(this.get(S_ExpireProcessType));
  
  }
  public int getExpireProcessTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ExpireProcessType));
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

  public void initProdInstId(long value){
     this.initProperty(S_ProdInstId,new Long(value));
  }
  public  void setProdInstId(long value){
     this.set(S_ProdInstId,new Long(value));
  }
  public  void setProdInstIdNull(){
     this.set(S_ProdInstId,null);
  }

  public long getProdInstId(){
        return DataType.getAsLong(this.get(S_ProdInstId));
  
  }
  public long getProdInstIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProdInstId));
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

  public void initPresentObjUser(long value){
     this.initProperty(S_PresentObjUser,new Long(value));
  }
  public  void setPresentObjUser(long value){
     this.set(S_PresentObjUser,new Long(value));
  }
  public  void setPresentObjUserNull(){
     this.set(S_PresentObjUser,null);
  }

  public long getPresentObjUser(){
        return DataType.getAsLong(this.get(S_PresentObjUser));
  
  }
  public long getPresentObjUserInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PresentObjUser));
      }

  public void initBossEffectiveDate(Timestamp value){
     this.initProperty(S_BossEffectiveDate,value);
  }
  public  void setBossEffectiveDate(Timestamp value){
     this.set(S_BossEffectiveDate,value);
  }
  public  void setBossEffectiveDateNull(){
     this.set(S_BossEffectiveDate,null);
  }

  public Timestamp getBossEffectiveDate(){
        return DataType.getAsDateTime(this.get(S_BossEffectiveDate));
  
  }
  public Timestamp getBossEffectiveDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BossEffectiveDate));
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

  public void initSrcSystemExtCode(String value){
     this.initProperty(S_SrcSystemExtCode,value);
  }
  public  void setSrcSystemExtCode(String value){
     this.set(S_SrcSystemExtCode,value);
  }
  public  void setSrcSystemExtCodeNull(){
     this.set(S_SrcSystemExtCode,null);
  }

  public String getSrcSystemExtCode(){
       return DataType.getAsString(this.get(S_SrcSystemExtCode));
  
  }
  public String getSrcSystemExtCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SrcSystemExtCode));
      }


 
 }

