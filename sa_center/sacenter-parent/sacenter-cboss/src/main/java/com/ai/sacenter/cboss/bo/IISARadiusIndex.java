package com.ai.sacenter.cboss.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISARadiusIndex extends DataStructInterface{

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


public String getActType();

public String getRegionId();

public int getSrc();

public String getOldBillId();

public String getSubBillId();

public long getUserId();

public String getUserSts();

public String getComposite();

public int getBusiType();

public String getBillId();

public int getSts();

public String getPsParam();

public String getCategory();

public Timestamp getCommitDate();

public long getSoNbr();

public String getRemark();

public long getSubPlanNo();

public int getOrderFlag();

public int getCallbackFlag();

public Timestamp getOrderDate();

public int getReconfirmFlag();

public String getReconfirmCode();

public long getOfferId();

public String getPkgSeq();

public int getBrand();

public long getMsoNbr();

public Timestamp getCreateDate();

public long getOrderId();

public Timestamp getProcessDate();

public String getResultDesc();

public String getSingleSeq();

public String getResult();

public long getTaskId();


public  void setActType(String value);

public  void setRegionId(String value);

public  void setSrc(int value);

public  void setOldBillId(String value);

public  void setSubBillId(String value);

public  void setUserId(long value);

public  void setUserSts(String value);

public  void setComposite(String value);

public  void setBusiType(int value);

public  void setBillId(String value);

public  void setSts(int value);

public  void setPsParam(String value);

public  void setCategory(String value);

public  void setCommitDate(Timestamp value);

public  void setSoNbr(long value);

public  void setRemark(String value);

public  void setSubPlanNo(long value);

public  void setOrderFlag(int value);

public  void setCallbackFlag(int value);

public  void setOrderDate(Timestamp value);

public  void setReconfirmFlag(int value);

public  void setReconfirmCode(String value);

public  void setOfferId(long value);

public  void setPkgSeq(String value);

public  void setBrand(int value);

public  void setMsoNbr(long value);

public  void setCreateDate(Timestamp value);

public  void setOrderId(long value);

public  void setProcessDate(Timestamp value);

public  void setResultDesc(String value);

public  void setSingleSeq(String value);

public  void setResult(String value);

public  void setTaskId(long value);
}
