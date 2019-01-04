package com.ai.sacenter.cboss.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ISAMcasIndex extends DataContainer implements DataContainerInterface,IISAMcasIndex{
  private static final long serialVersionUID = 5544823784504680315L;
  private static String  m_boName = "com.ai.sacenter.cboss.bo.ISAMcasIndex";
  public final static  String S_ActType = "ACT_TYPE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Src = "SRC";
  public final static  String S_OldBillId = "OLD_BILL_ID";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_UserSts = "USER_STS";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Sts = "STS";
  public final static  String S_PsParam = "PS_PARAM";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_CommitDate = "COMMIT_DATE";
  public final static  String S_SoNbr = "SO_NBR";
  public final static  String S_Remark = "REMARK";
  public final static  String S_SubPlanNo = "SUB_PLAN_NO";
  public final static  String S_OrderFlag = "ORDER_FLAG";
  public final static  String S_CallbackFlag = "CALLBACK_FLAG";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_ReconfirmFlag = "RECONFIRM_FLAG";
  public final static  String S_ReconfirmCode = "RECONFIRM_CODE";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_PkgSeq = "PKG_SEQ";
  public final static  String S_Brand = "BRAND";
  public final static  String S_MsoNbr = "MSO_NBR";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_ProcessDate = "PROCESS_DATE";
  public final static  String S_ResultDesc = "RESULT_DESC";
  public final static  String S_SingleSeq = "SINGLE_SEQ";
  public final static  String S_Result = "RESULT";
  public final static  String S_TaskId = "TASK_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ISAMcasIndex() throws AIException{
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

  public void initSrc(int value){
     this.initProperty(S_Src,new Integer(value));
  }
  public  void setSrc(int value){
     this.set(S_Src,new Integer(value));
  }
  public  void setSrcNull(){
     this.set(S_Src,null);
  }

  public int getSrc(){
        return DataType.getAsInt(this.get(S_Src));
  
  }
  public int getSrcInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Src));
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

  public void initSts(int value){
     this.initProperty(S_Sts,new Integer(value));
  }
  public  void setSts(int value){
     this.set(S_Sts,new Integer(value));
  }
  public  void setStsNull(){
     this.set(S_Sts,null);
  }

  public int getSts(){
        return DataType.getAsInt(this.get(S_Sts));
  
  }
  public int getStsInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Sts));
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

  public void initRemark(String value){
     this.initProperty(S_Remark,value);
  }
  public  void setRemark(String value){
     this.set(S_Remark,value);
  }
  public  void setRemarkNull(){
     this.set(S_Remark,null);
  }

  public String getRemark(){
       return DataType.getAsString(this.get(S_Remark));
  
  }
  public String getRemarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark));
      }

  public void initSubPlanNo(long value){
     this.initProperty(S_SubPlanNo,new Long(value));
  }
  public  void setSubPlanNo(long value){
     this.set(S_SubPlanNo,new Long(value));
  }
  public  void setSubPlanNoNull(){
     this.set(S_SubPlanNo,null);
  }

  public long getSubPlanNo(){
        return DataType.getAsLong(this.get(S_SubPlanNo));
  
  }
  public long getSubPlanNoInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SubPlanNo));
      }

  public void initOrderFlag(int value){
     this.initProperty(S_OrderFlag,new Integer(value));
  }
  public  void setOrderFlag(int value){
     this.set(S_OrderFlag,new Integer(value));
  }
  public  void setOrderFlagNull(){
     this.set(S_OrderFlag,null);
  }

  public int getOrderFlag(){
        return DataType.getAsInt(this.get(S_OrderFlag));
  
  }
  public int getOrderFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_OrderFlag));
      }

  public void initCallbackFlag(int value){
     this.initProperty(S_CallbackFlag,new Integer(value));
  }
  public  void setCallbackFlag(int value){
     this.set(S_CallbackFlag,new Integer(value));
  }
  public  void setCallbackFlagNull(){
     this.set(S_CallbackFlag,null);
  }

  public int getCallbackFlag(){
        return DataType.getAsInt(this.get(S_CallbackFlag));
  
  }
  public int getCallbackFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CallbackFlag));
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

  public void initReconfirmFlag(int value){
     this.initProperty(S_ReconfirmFlag,new Integer(value));
  }
  public  void setReconfirmFlag(int value){
     this.set(S_ReconfirmFlag,new Integer(value));
  }
  public  void setReconfirmFlagNull(){
     this.set(S_ReconfirmFlag,null);
  }

  public int getReconfirmFlag(){
        return DataType.getAsInt(this.get(S_ReconfirmFlag));
  
  }
  public int getReconfirmFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ReconfirmFlag));
      }

  public void initReconfirmCode(String value){
     this.initProperty(S_ReconfirmCode,value);
  }
  public  void setReconfirmCode(String value){
     this.set(S_ReconfirmCode,value);
  }
  public  void setReconfirmCodeNull(){
     this.set(S_ReconfirmCode,null);
  }

  public String getReconfirmCode(){
       return DataType.getAsString(this.get(S_ReconfirmCode));
  
  }
  public String getReconfirmCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReconfirmCode));
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

  public void initPkgSeq(String value){
     this.initProperty(S_PkgSeq,value);
  }
  public  void setPkgSeq(String value){
     this.set(S_PkgSeq,value);
  }
  public  void setPkgSeqNull(){
     this.set(S_PkgSeq,null);
  }

  public String getPkgSeq(){
       return DataType.getAsString(this.get(S_PkgSeq));
  
  }
  public String getPkgSeqInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PkgSeq));
      }

  public void initBrand(int value){
     this.initProperty(S_Brand,new Integer(value));
  }
  public  void setBrand(int value){
     this.set(S_Brand,new Integer(value));
  }
  public  void setBrandNull(){
     this.set(S_Brand,null);
  }

  public int getBrand(){
        return DataType.getAsInt(this.get(S_Brand));
  
  }
  public int getBrandInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Brand));
      }

  public void initMsoNbr(long value){
     this.initProperty(S_MsoNbr,new Long(value));
  }
  public  void setMsoNbr(long value){
     this.set(S_MsoNbr,new Long(value));
  }
  public  void setMsoNbrNull(){
     this.set(S_MsoNbr,null);
  }

  public long getMsoNbr(){
        return DataType.getAsLong(this.get(S_MsoNbr));
  
  }
  public long getMsoNbrInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MsoNbr));
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

  public void initSingleSeq(String value){
     this.initProperty(S_SingleSeq,value);
  }
  public  void setSingleSeq(String value){
     this.set(S_SingleSeq,value);
  }
  public  void setSingleSeqNull(){
     this.set(S_SingleSeq,null);
  }

  public String getSingleSeq(){
       return DataType.getAsString(this.get(S_SingleSeq));
  
  }
  public String getSingleSeqInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SingleSeq));
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

  public void initTaskId(long value){
     this.initProperty(S_TaskId,new Long(value));
  }
  public  void setTaskId(long value){
     this.set(S_TaskId,new Long(value));
  }
  public  void setTaskIdNull(){
     this.set(S_TaskId,null);
  }

  public long getTaskId(){
        return DataType.getAsLong(this.get(S_TaskId));
  
  }
  public long getTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TaskId));
      }


 
 }

