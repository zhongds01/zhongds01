package com.ai.sacenter.receive.custom.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class InsOffer extends DataContainer implements DataContainerInterface{
  private static final long serialVersionUID = 8778881363205132697L;
  private static String  m_boName = "com.ai.sacenter.receive.custom.bo.InsOffer";
  public final static  String S_State = "STATE";
  public final static  String S_OldOfferId = "OLD_OFFER_ID";
  public final static  String S_EffectiveDate = "EFFECTIVE_DATE";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_SaleType = "SALE_TYPE";
  public final static  String S_OrderName = "ORDER_NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_CustType = "CUST_TYPE";
  public final static  String S_OfferType = "OFFER_TYPE";
  public final static  String S_OfferInstId = "OFFER_INST_ID";
  public final static  String S_SrcSystemType = "SRC_SYSTEM_TYPE";
  public final static  String S_CountyCode = "COUNTY_CODE";
  public final static  String S_RelatType = "RELAT_TYPE";
  public final static  String S_ExpireProcessType = "EXPIRE_PROCESS_TYPE";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_BrandId = "BRAND_ID";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_EffectiveDateType = "EFFECTIVE_DATE_TYPE";
  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_ExpireDate = "EXPIRE_DATE";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_ExpireDateType = "EXPIRE_DATE_TYPE";
  public final static  String S_SalePartyRoleId = "SALE_PARTY_ROLE_ID";
  public final static  String S_CustId = "CUST_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public InsOffer() throws AIException{
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

  public void initSaleType(int value){
     this.initProperty(S_SaleType,new Integer(value));
  }
  public  void setSaleType(int value){
     this.set(S_SaleType,new Integer(value));
  }
  public  void setSaleTypeNull(){
     this.set(S_SaleType,null);
  }

  public int getSaleType(){
        return DataType.getAsInt(this.get(S_SaleType));
  
  }
  public int getSaleTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SaleType));
      }

  public void initOrderName(String value){
     this.initProperty(S_OrderName,value);
  }
  public  void setOrderName(String value){
     this.set(S_OrderName,value);
  }
  public  void setOrderNameNull(){
     this.set(S_OrderName,null);
  }

  public String getOrderName(){
       return DataType.getAsString(this.get(S_OrderName));
  
  }
  public String getOrderNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderName));
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

  public void initCustType(String value){
     this.initProperty(S_CustType,value);
  }
  public  void setCustType(String value){
     this.set(S_CustType,value);
  }
  public  void setCustTypeNull(){
     this.set(S_CustType,null);
  }

  public String getCustType(){
       return DataType.getAsString(this.get(S_CustType));
  
  }
  public String getCustTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustType));
      }

  public void initOfferType(String value){
     this.initProperty(S_OfferType,value);
  }
  public  void setOfferType(String value){
     this.set(S_OfferType,value);
  }
  public  void setOfferTypeNull(){
     this.set(S_OfferType,null);
  }

  public String getOfferType(){
       return DataType.getAsString(this.get(S_OfferType));
  
  }
  public String getOfferTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OfferType));
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

  public void initRelatType(String value){
     this.initProperty(S_RelatType,value);
  }
  public  void setRelatType(String value){
     this.set(S_RelatType,value);
  }
  public  void setRelatTypeNull(){
     this.set(S_RelatType,null);
  }

  public String getRelatType(){
       return DataType.getAsString(this.get(S_RelatType));
  
  }
  public String getRelatTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelatType));
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

  public void initBrandId(long value){
     this.initProperty(S_BrandId,new Long(value));
  }
  public  void setBrandId(long value){
     this.set(S_BrandId,new Long(value));
  }
  public  void setBrandIdNull(){
     this.set(S_BrandId,null);
  }

  public long getBrandId(){
        return DataType.getAsLong(this.get(S_BrandId));
  
  }
  public long getBrandIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BrandId));
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

  public void initCreateOpId(long value){
     this.initProperty(S_CreateOpId,new Long(value));
  }
  public  void setCreateOpId(long value){
     this.set(S_CreateOpId,new Long(value));
  }
  public  void setCreateOpIdNull(){
     this.set(S_CreateOpId,null);
  }

  public long getCreateOpId(){
        return DataType.getAsLong(this.get(S_CreateOpId));
  
  }
  public long getCreateOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CreateOpId));
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

  public void initCreateOrgId(long value){
     this.initProperty(S_CreateOrgId,new Long(value));
  }
  public  void setCreateOrgId(long value){
     this.set(S_CreateOrgId,new Long(value));
  }
  public  void setCreateOrgIdNull(){
     this.set(S_CreateOrgId,null);
  }

  public long getCreateOrgId(){
        return DataType.getAsLong(this.get(S_CreateOrgId));
  
  }
  public long getCreateOrgIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CreateOrgId));
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

  public void initSalePartyRoleId(long value){
     this.initProperty(S_SalePartyRoleId,new Long(value));
  }
  public  void setSalePartyRoleId(long value){
     this.set(S_SalePartyRoleId,new Long(value));
  }
  public  void setSalePartyRoleIdNull(){
     this.set(S_SalePartyRoleId,null);
  }

  public long getSalePartyRoleId(){
        return DataType.getAsLong(this.get(S_SalePartyRoleId));
  
  }
  public long getSalePartyRoleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SalePartyRoleId));
      }

  public void initCustId(long value){
     this.initProperty(S_CustId,new Long(value));
  }
  public  void setCustId(long value){
     this.set(S_CustId,new Long(value));
  }
  public  void setCustIdNull(){
     this.set(S_CustId,null);
  }

  public long getCustId(){
        return DataType.getAsLong(this.get(S_CustId));
  
  }
  public long getCustIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CustId));
      }
 
 }