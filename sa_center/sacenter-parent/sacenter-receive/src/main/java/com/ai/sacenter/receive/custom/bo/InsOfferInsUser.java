package com.ai.sacenter.receive.custom.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class InsOfferInsUser extends DataContainer implements DataContainerInterface{
  private static final long serialVersionUID = 7620820612410054654L;
  private static String  m_boName = "com.ai.sacenter.receive.custom.bo.InsOfferInsUser";
  public final static  String S_State = "STATE";
  public final static  String S_EffectiveDate = "EFFECTIVE_DATE";
  public final static  String S_GroupRegionId = "GROUP_REGION_ID";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_IsGrpMainUser = "IS_GRP_MAIN_USER";
  public final static  String S_UserRegionId = "USER_REGION_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_OfferInstId = "OFFER_INST_ID";
  public final static  String S_SrcSystemType = "SRC_SYSTEM_TYPE";
  public final static  String S_CountyCode = "COUNTY_CODE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_ExpireDate = "EXPIRE_DATE";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_OfferUserRelatId = "OFFER_USER_RELAT_ID";
  public final static  String S_ExpireDateType = "EXPIRE_DATE_TYPE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_IsMainOffer = "IS_MAIN_OFFER";
  public final static  String S_EffectiveDateType = "EFFECTIVE_DATE_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public InsOfferInsUser() throws AIException{
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

  public void initGroupRegionId(String value){
     this.initProperty(S_GroupRegionId,value);
  }
  public  void setGroupRegionId(String value){
     this.set(S_GroupRegionId,value);
  }
  public  void setGroupRegionIdNull(){
     this.set(S_GroupRegionId,null);
  }

  public String getGroupRegionId(){
       return DataType.getAsString(this.get(S_GroupRegionId));
  
  }
  public String getGroupRegionIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GroupRegionId));
      }

  public void initRoleId(long value){
     this.initProperty(S_RoleId,new Long(value));
  }
  public  void setRoleId(long value){
     this.set(S_RoleId,new Long(value));
  }
  public  void setRoleIdNull(){
     this.set(S_RoleId,null);
  }

  public long getRoleId(){
        return DataType.getAsLong(this.get(S_RoleId));
  
  }
  public long getRoleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RoleId));
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

  public void initIsGrpMainUser(int value){
     this.initProperty(S_IsGrpMainUser,new Integer(value));
  }
  public  void setIsGrpMainUser(int value){
     this.set(S_IsGrpMainUser,new Integer(value));
  }
  public  void setIsGrpMainUserNull(){
     this.set(S_IsGrpMainUser,null);
  }

  public int getIsGrpMainUser(){
        return DataType.getAsInt(this.get(S_IsGrpMainUser));
  
  }
  public int getIsGrpMainUserInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsGrpMainUser));
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

  public void initOfferUserRelatId(long value){
     this.initProperty(S_OfferUserRelatId,new Long(value));
  }
  public  void setOfferUserRelatId(long value){
     this.set(S_OfferUserRelatId,new Long(value));
  }
  public  void setOfferUserRelatIdNull(){
     this.set(S_OfferUserRelatId,null);
  }

  public long getOfferUserRelatId(){
        return DataType.getAsLong(this.get(S_OfferUserRelatId));
  
  }
  public long getOfferUserRelatIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OfferUserRelatId));
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

  public void initIsMainOffer(int value){
     this.initProperty(S_IsMainOffer,new Integer(value));
  }
  public  void setIsMainOffer(int value){
     this.set(S_IsMainOffer,new Integer(value));
  }
  public  void setIsMainOfferNull(){
     this.set(S_IsMainOffer,null);
  }

  public int getIsMainOffer(){
        return DataType.getAsInt(this.get(S_IsMainOffer));
  
  }
  public int getIsMainOfferInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsMainOffer));
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


 
 }

