package com.ai.sacenter.cboss.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ISARadiusCallBack extends DataContainer implements DataContainerInterface,IISARadiusCallBack{
  private static final long serialVersionUID = 955596892409637376L;
  private static String  m_boName = "com.ai.sacenter.cboss.bo.ISARadiusCallBack";
  public final static  String S_ActType = "ACT_TYPE";
  public final static  String S_RegionCode = "REGION_CODE";
  public final static  String S_OldBillId = "OLD_BILL_ID";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_UserSts = "USER_STS";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_ProcessDate = "PROCESS_DATE";
  public final static  String S_ResultDesc = "RESULT_DESC";
  public final static  String S_CommitDate = "COMMIT_DATE";
  public final static  String S_SoNbr = "SO_NBR";
  public final static  String S_Result = "RESULT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ISARadiusCallBack() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initActType(String value){
     this.initProperty(S_ActType,value);
  }
  public  void setActType(String value){
     this.set(S_ActType,value);
  }
  public  void setActTypeNull(){
     this.set(S_ActType,null);
  }

  public String getActType(){
       return DataType.getAsString(this.get(S_ActType));
  
  }
  public String getActTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActType));
      }

  public void initRegionCode(int value){
     this.initProperty(S_RegionCode,new Integer(value));
  }
  public  void setRegionCode(int value){
     this.set(S_RegionCode,new Integer(value));
  }
  public  void setRegionCodeNull(){
     this.set(S_RegionCode,null);
  }

  public int getRegionCode(){
        return DataType.getAsInt(this.get(S_RegionCode));
  
  }
  public int getRegionCodeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_RegionCode));
      }

  public void initOldBillId(String value){
     this.initProperty(S_OldBillId,value);
  }
  public  void setOldBillId(String value){
     this.set(S_OldBillId,value);
  }
  public  void setOldBillIdNull(){
     this.set(S_OldBillId,null);
  }

  public String getOldBillId(){
       return DataType.getAsString(this.get(S_OldBillId));
  
  }
  public String getOldBillIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OldBillId));
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

  public void initUserSts(String value){
     this.initProperty(S_UserSts,value);
  }
  public  void setUserSts(String value){
     this.set(S_UserSts,value);
  }
  public  void setUserStsNull(){
     this.set(S_UserSts,null);
  }

  public String getUserSts(){
       return DataType.getAsString(this.get(S_UserSts));
  
  }
  public String getUserStsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserSts));
      }

  public void initExt1(String value){
     this.initProperty(S_Ext1,value);
  }
  public  void setExt1(String value){
     this.set(S_Ext1,value);
  }
  public  void setExt1Null(){
     this.set(S_Ext1,null);
  }

  public String getExt1(){
       return DataType.getAsString(this.get(S_Ext1));
  
  }
  public String getExt1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext1));
      }

  public void initBusiType(int value){
     this.initProperty(S_BusiType,new Integer(value));
  }
  public  void setBusiType(int value){
     this.set(S_BusiType,new Integer(value));
  }
  public  void setBusiTypeNull(){
     this.set(S_BusiType,null);
  }

  public int getBusiType(){
        return DataType.getAsInt(this.get(S_BusiType));
  
  }
  public int getBusiTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_BusiType));
      }

  public void initExt2(String value){
     this.initProperty(S_Ext2,value);
  }
  public  void setExt2(String value){
     this.set(S_Ext2,value);
  }
  public  void setExt2Null(){
     this.set(S_Ext2,null);
  }

  public String getExt2(){
       return DataType.getAsString(this.get(S_Ext2));
  
  }
  public String getExt2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext2));
      }

  public void initExt3(String value){
     this.initProperty(S_Ext3,value);
  }
  public  void setExt3(String value){
     this.set(S_Ext3,value);
  }
  public  void setExt3Null(){
     this.set(S_Ext3,null);
  }

  public String getExt3(){
       return DataType.getAsString(this.get(S_Ext3));
  
  }
  public String getExt3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext3));
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

  public void initProcessDate(Timestamp value){
     this.initProperty(S_ProcessDate,value);
  }
  public  void setProcessDate(Timestamp value){
     this.set(S_ProcessDate,value);
  }
  public  void setProcessDateNull(){
     this.set(S_ProcessDate,null);
  }

  public Timestamp getProcessDate(){
        return DataType.getAsDateTime(this.get(S_ProcessDate));
  
  }
  public Timestamp getProcessDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ProcessDate));
      }

  public void initResultDesc(String value){
     this.initProperty(S_ResultDesc,value);
  }
  public  void setResultDesc(String value){
     this.set(S_ResultDesc,value);
  }
  public  void setResultDescNull(){
     this.set(S_ResultDesc,null);
  }

  public String getResultDesc(){
       return DataType.getAsString(this.get(S_ResultDesc));
  
  }
  public String getResultDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResultDesc));
      }

  public void initCommitDate(Timestamp value){
     this.initProperty(S_CommitDate,value);
  }
  public  void setCommitDate(Timestamp value){
     this.set(S_CommitDate,value);
  }
  public  void setCommitDateNull(){
     this.set(S_CommitDate,null);
  }

  public Timestamp getCommitDate(){
        return DataType.getAsDateTime(this.get(S_CommitDate));
  
  }
  public Timestamp getCommitDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CommitDate));
      }

  public void initSoNbr(long value){
     this.initProperty(S_SoNbr,new Long(value));
  }
  public  void setSoNbr(long value){
     this.set(S_SoNbr,new Long(value));
  }
  public  void setSoNbrNull(){
     this.set(S_SoNbr,null);
  }

  public long getSoNbr(){
        return DataType.getAsLong(this.get(S_SoNbr));
  
  }
  public long getSoNbrInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SoNbr));
      }

  public void initResult(String value){
     this.initProperty(S_Result,value);
  }
  public  void setResult(String value){
     this.set(S_Result,value);
  }
  public  void setResultNull(){
     this.set(S_Result,null);
  }

  public String getResult(){
       return DataType.getAsString(this.get(S_Result));
  
  }
  public String getResultInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Result));
      }


 
 }

