package com.ai.sacenter.receive.custom.bo;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class InsUser extends DataContainer implements DataContainerInterface{
  private static final long serialVersionUID = 1L;
  private static String  m_boName = "com.ai.sacenter.receive.custom.bo.InsUser";
  public final static  String S_State = "STATE";
  public final static  String S_EffectiveDate = "EFFECTIVE_DATE";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_CreditLevel = "CREDIT_LEVEL";
  public final static  String S_AddressId = "ADDRESS_ID";
  public final static  String S_LastTransDate = "LAST_TRANS_DATE";
  public final static  String S_RiskFlag = "RISK_FLAG";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_ActiveDate = "ACTIVE_DATE";
  public final static  String S_CustType = "CUST_TYPE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_PreDestoryTime = "PRE_DESTORY_TIME";
  public final static  String S_CountryCode = "COUNTRY_CODE";
  public final static  String S_ExchangeId = "EXCHANGE_ID";
  public final static  String S_AddressDesc = "ADDRESS_DESC";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_OweAmount = "OWE_AMOUNT";
  public final static  String S_EffectiveDateType = "EFFECTIVE_DATE_TYPE";
  public final static  String S_BalOrgId = "BAL_ORG_ID";
  public final static  String S_AreaId = "AREA_ID";
  public final static  String S_ContId = "CONT_ID";
  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_Password = "PASSWORD";
  public final static  String S_UserType = "USER_TYPE";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_ProdCatalogId = "PROD_CATALOG_ID";
  public final static  String S_AreaCode = "AREA_CODE";
  public final static  String S_IsOutNet = "IS_OUT_NET";
  public final static  String S_ExpireDate = "EXPIRE_DATE";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_FirstUseDate = "FIRST_USE_DATE";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_ExpireDateType = "EXPIRE_DATE_TYPE";
  public final static  String S_PasswordType = "PASSWORD_TYPE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_NoticeFlag = "NOTICE_FLAG";
  public final static  String S_CustId = "CUST_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public InsUser() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹涓氶敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
   throw new AIException("Cannot reset ObjectType");
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

  public void initCreditLevel(int value){
     this.initProperty(S_CreditLevel,new Integer(value));
  }
  public  void setCreditLevel(int value){
     this.set(S_CreditLevel,new Integer(value));
  }
  public  void setCreditLevelNull(){
     this.set(S_CreditLevel,null);
  }

  public int getCreditLevel(){
        return DataType.getAsInt(this.get(S_CreditLevel));
  
  }
  public int getCreditLevelInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CreditLevel));
      }

  public void initAddressId(long value){
     this.initProperty(S_AddressId,new Long(value));
  }
  public  void setAddressId(long value){
     this.set(S_AddressId,new Long(value));
  }
  public  void setAddressIdNull(){
     this.set(S_AddressId,null);
  }

  public long getAddressId(){
        return DataType.getAsLong(this.get(S_AddressId));
  
  }
  public long getAddressIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AddressId));
      }

  public void initLastTransDate(Timestamp value){
     this.initProperty(S_LastTransDate,value);
  }
  public  void setLastTransDate(Timestamp value){
     this.set(S_LastTransDate,value);
  }
  public  void setLastTransDateNull(){
     this.set(S_LastTransDate,null);
  }

  public Timestamp getLastTransDate(){
        return DataType.getAsDateTime(this.get(S_LastTransDate));
  
  }
  public Timestamp getLastTransDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_LastTransDate));
      }

  public void initRiskFlag(int value){
     this.initProperty(S_RiskFlag,new Integer(value));
  }
  public  void setRiskFlag(int value){
     this.set(S_RiskFlag,new Integer(value));
  }
  public  void setRiskFlagNull(){
     this.set(S_RiskFlag,null);
  }

  public int getRiskFlag(){
        return DataType.getAsInt(this.get(S_RiskFlag));
  
  }
  public int getRiskFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_RiskFlag));
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

  public void initActiveDate(Timestamp value){
     this.initProperty(S_ActiveDate,value);
  }
  public  void setActiveDate(Timestamp value){
     this.set(S_ActiveDate,value);
  }
  public  void setActiveDateNull(){
     this.set(S_ActiveDate,null);
  }

  public Timestamp getActiveDate(){
        return DataType.getAsDateTime(this.get(S_ActiveDate));
  
  }
  public Timestamp getActiveDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ActiveDate));
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

  public void initPreDestoryTime(Timestamp value){
     this.initProperty(S_PreDestoryTime,value);
  }
  public  void setPreDestoryTime(Timestamp value){
     this.set(S_PreDestoryTime,value);
  }
  public  void setPreDestoryTimeNull(){
     this.set(S_PreDestoryTime,null);
  }

  public Timestamp getPreDestoryTime(){
        return DataType.getAsDateTime(this.get(S_PreDestoryTime));
  
  }
  public Timestamp getPreDestoryTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PreDestoryTime));
      }

  public void initCountryCode(String value){
     this.initProperty(S_CountryCode,value);
  }
  public  void setCountryCode(String value){
     this.set(S_CountryCode,value);
  }
  public  void setCountryCodeNull(){
     this.set(S_CountryCode,null);
  }

  public String getCountryCode(){
       return DataType.getAsString(this.get(S_CountryCode));
  
  }
  public String getCountryCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CountryCode));
      }

  public void initExchangeId(String value){
     this.initProperty(S_ExchangeId,value);
  }
  public  void setExchangeId(String value){
     this.set(S_ExchangeId,value);
  }
  public  void setExchangeIdNull(){
     this.set(S_ExchangeId,null);
  }

  public String getExchangeId(){
       return DataType.getAsString(this.get(S_ExchangeId));
  
  }
  public String getExchangeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExchangeId));
      }

  public void initAddressDesc(String value){
     this.initProperty(S_AddressDesc,value);
  }
  public  void setAddressDesc(String value){
     this.set(S_AddressDesc,value);
  }
  public  void setAddressDescNull(){
     this.set(S_AddressDesc,null);
  }

  public String getAddressDesc(){
       return DataType.getAsString(this.get(S_AddressDesc));
  
  }
  public String getAddressDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AddressDesc));
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

  public void initOweAmount(long value){
     this.initProperty(S_OweAmount,new Long(value));
  }
  public  void setOweAmount(long value){
     this.set(S_OweAmount,new Long(value));
  }
  public  void setOweAmountNull(){
     this.set(S_OweAmount,null);
  }

  public long getOweAmount(){
        return DataType.getAsLong(this.get(S_OweAmount));
  
  }
  public long getOweAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OweAmount));
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

  public void initBalOrgId(long value){
     this.initProperty(S_BalOrgId,new Long(value));
  }
  public  void setBalOrgId(long value){
     this.set(S_BalOrgId,new Long(value));
  }
  public  void setBalOrgIdNull(){
     this.set(S_BalOrgId,null);
  }

  public long getBalOrgId(){
        return DataType.getAsLong(this.get(S_BalOrgId));
  
  }
  public long getBalOrgIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BalOrgId));
      }

  public void initAreaId(long value){
     this.initProperty(S_AreaId,new Long(value));
  }
  public  void setAreaId(long value){
     this.set(S_AreaId,new Long(value));
  }
  public  void setAreaIdNull(){
     this.set(S_AreaId,null);
  }

  public long getAreaId(){
        return DataType.getAsLong(this.get(S_AreaId));
  
  }
  public long getAreaIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AreaId));
      }

  public void initContId(long value){
     this.initProperty(S_ContId,new Long(value));
  }
  public  void setContId(long value){
     this.set(S_ContId,new Long(value));
  }
  public  void setContIdNull(){
     this.set(S_ContId,null);
  }

  public long getContId(){
        return DataType.getAsLong(this.get(S_ContId));
  
  }
  public long getContIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ContId));
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

  public void initPassword(String value){
     this.initProperty(S_Password,value);
  }
  public  void setPassword(String value){
     this.set(S_Password,value);
  }
  public  void setPasswordNull(){
     this.set(S_Password,null);
  }

  public String getPassword(){
       return DataType.getAsString(this.get(S_Password));
  
  }
  public String getPasswordInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Password));
      }

  public void initUserType(int value){
     this.initProperty(S_UserType,new Integer(value));
  }
  public  void setUserType(int value){
     this.set(S_UserType,new Integer(value));
  }
  public  void setUserTypeNull(){
     this.set(S_UserType,null);
  }

  public int getUserType(){
        return DataType.getAsInt(this.get(S_UserType));
  
  }
  public int getUserTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_UserType));
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

  public void initProdCatalogId(long value){
     this.initProperty(S_ProdCatalogId,new Long(value));
  }
  public  void setProdCatalogId(long value){
     this.set(S_ProdCatalogId,new Long(value));
  }
  public  void setProdCatalogIdNull(){
     this.set(S_ProdCatalogId,null);
  }

  public long getProdCatalogId(){
        return DataType.getAsLong(this.get(S_ProdCatalogId));
  
  }
  public long getProdCatalogIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProdCatalogId));
      }

  public void initAreaCode(String value){
     this.initProperty(S_AreaCode,value);
  }
  public  void setAreaCode(String value){
     this.set(S_AreaCode,value);
  }
  public  void setAreaCodeNull(){
     this.set(S_AreaCode,null);
  }

  public String getAreaCode(){
       return DataType.getAsString(this.get(S_AreaCode));
  
  }
  public String getAreaCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AreaCode));
      }

  public void initIsOutNet(int value){
     this.initProperty(S_IsOutNet,new Integer(value));
  }
  public  void setIsOutNet(int value){
     this.set(S_IsOutNet,new Integer(value));
  }
  public  void setIsOutNetNull(){
     this.set(S_IsOutNet,null);
  }

  public int getIsOutNet(){
        return DataType.getAsInt(this.get(S_IsOutNet));
  
  }
  public int getIsOutNetInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsOutNet));
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

  public void initFirstUseDate(Timestamp value){
     this.initProperty(S_FirstUseDate,value);
  }
  public  void setFirstUseDate(Timestamp value){
     this.set(S_FirstUseDate,value);
  }
  public  void setFirstUseDateNull(){
     this.set(S_FirstUseDate,null);
  }

  public Timestamp getFirstUseDate(){
        return DataType.getAsDateTime(this.get(S_FirstUseDate));
  
  }
  public Timestamp getFirstUseDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_FirstUseDate));
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

  public void initPasswordType(int value){
     this.initProperty(S_PasswordType,new Integer(value));
  }
  public  void setPasswordType(int value){
     this.set(S_PasswordType,new Integer(value));
  }
  public  void setPasswordTypeNull(){
     this.set(S_PasswordType,null);
  }

  public int getPasswordType(){
        return DataType.getAsInt(this.get(S_PasswordType));
  
  }
  public int getPasswordTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PasswordType));
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

  public void initNoticeFlag(int value){
     this.initProperty(S_NoticeFlag,new Integer(value));
  }
  public  void setNoticeFlag(int value){
     this.set(S_NoticeFlag,new Integer(value));
  }
  public  void setNoticeFlagNull(){
     this.set(S_NoticeFlag,null);
  }

  public int getNoticeFlag(){
        return DataType.getAsInt(this.get(S_NoticeFlag));
  
  }
  public int getNoticeFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_NoticeFlag));
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

