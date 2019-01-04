package com.ai.sacenter.cboss.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISABrandChg extends DataStructInterface{

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


public String getRegionId();

public long getSubPlanNo();

public Timestamp getDoneDate();

public long getDoneCode();

public Timestamp getOrderDate();

public String getSubBillId();

public long getOfferId();

public long getUserId();

public String getUserSts();

public int getOldBrand();

public int getBrand();

public String getExt1();

public String getExt2();

public Timestamp getCreateDate();

public String getExt3();

public String getBillId();

public int getSts();

public long getOrderId();

public String getCategory();

public Timestamp getCommitDate();

public long getSoNbr();

public String getRemark();

public long getTaskId();


public  void setRegionId(String value);

public  void setSubPlanNo(long value);

public  void setDoneDate(Timestamp value);

public  void setDoneCode(long value);

public  void setOrderDate(Timestamp value);

public  void setSubBillId(String value);

public  void setOfferId(long value);

public  void setUserId(long value);

public  void setUserSts(String value);

public  void setOldBrand(int value);

public  void setBrand(int value);

public  void setExt1(String value);

public  void setExt2(String value);

public  void setCreateDate(Timestamp value);

public  void setExt3(String value);

public  void setBillId(String value);

public  void setSts(int value);

public  void setOrderId(long value);

public  void setCategory(String value);

public  void setCommitDate(Timestamp value);

public  void setSoNbr(long value);

public  void setRemark(String value);

public  void setTaskId(long value);
}
