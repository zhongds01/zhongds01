package com.asiainfo.sacenter.shcmcc.provision.dsmp.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISADsmpStatus extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_OldBillId = "OLD_BILL_ID";
  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_UserSts = "USER_STS";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Sts = "STS";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_CommitDate = "COMMIT_DATE";
  public final static  String S_SoNbr = "SO_NBR";
  public final static  String S_Remark = "REMARK";
  public final static  String S_StsOprTime = "STS_OPR_TIME";
  public final static  String S_SubPlanNo = "SUB_PLAN_NO";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_OrderDate = "ORDER_DATE";
  public final static  String S_StsChgTime = "STS_CHG_TIME";
  public final static  String S_Rev1 = "REV1";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_Rev2 = "REV2";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Rev3 = "REV3";
  public final static  String S_TaskId = "TASK_ID";


public String getRegionId();

public long getOrgId();

public String getOldBillId();

public String getSubBillId();

public long getUserId();

public String getUserSts();

public String getBillId();

public int getSts();

public String getCategory();

public Timestamp getCommitDate();

public long getSoNbr();

public String getRemark();

public Timestamp getStsOprTime();

public long getSubPlanNo();

public Timestamp getDoneDate();

public long getDoneCode();

public Timestamp getOrderDate();

public Timestamp getStsChgTime();

public String getRev1();

public long getOfferId();

public long getRev2();

public Timestamp getCreateDate();

public long getOrderId();

public String getRev3();

public long getTaskId();


public  void setRegionId(String value);

public  void setOrgId(long value);

public  void setOldBillId(String value);

public  void setSubBillId(String value);

public  void setUserId(long value);

public  void setUserSts(String value);

public  void setBillId(String value);

public  void setSts(int value);

public  void setCategory(String value);

public  void setCommitDate(Timestamp value);

public  void setSoNbr(long value);

public  void setRemark(String value);

public  void setStsOprTime(Timestamp value);

public  void setSubPlanNo(long value);

public  void setDoneDate(Timestamp value);

public  void setDoneCode(long value);

public  void setOrderDate(Timestamp value);

public  void setStsChgTime(Timestamp value);

public  void setRev1(String value);

public  void setOfferId(long value);

public  void setRev2(long value);

public  void setCreateDate(Timestamp value);

public  void setOrderId(long value);

public  void setRev3(String value);

public  void setTaskId(long value);
}
