package com.ai.sacenter.cboss.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ISABrandChg extends DataContainer implements DataContainerInterface,IISABrandChg{
  private static final long serialVersionUID = -112145731632837292L;
  private static String  m_boName = "com.ai.sacenter.cboss.bo.ISABrandChg";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_SubPlanNo = "SUB_PLAN_NO";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_UserSts = "USER_STS";
  public final static  String S_OldBrand = "OLD_BRAND";
  public final static  String S_Brand = "BRAND";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Sts = "STS";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_CommitDate = "COMMIT_DATE";
  public final static  String S_SoNbr = "SO_NBR";
  public final static  String S_Remark = "REMARK";
  public final static  String S_TaskId = "TASK_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ISABrandChg() throws AIException{
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

  public void initOldBrand(int value){
     this.initProperty(S_OldBrand,new Integer(value));
  }
  public  void setOldBrand(int value){
     this.set(S_OldBrand,new Integer(value));
  }
  public  void setOldBrandNull(){
     this.set(S_OldBrand,null);
  }

  public int getOldBrand(){
        return DataType.getAsInt(this.get(S_OldBrand));
  
  }
  public int getOldBrandInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_OldBrand));
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

