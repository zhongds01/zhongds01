package com.ai.sacenter.cboss.bo;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IISARadiusCallBack extends DataStructInterface{

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


public String getActType();

public int getRegionCode();

public String getOldBillId();

public long getUserId();

public String getUserSts();

public String getExt1();

public int getBusiType();

public String getExt2();

public String getExt3();

public String getBillId();

public Timestamp getProcessDate();

public String getResultDesc();

public Timestamp getCommitDate();

public long getSoNbr();

public String getResult();


public  void setActType(String value);

public  void setRegionCode(int value);

public  void setOldBillId(String value);

public  void setUserId(long value);

public  void setUserSts(String value);

public  void setExt1(String value);

public  void setBusiType(int value);

public  void setExt2(String value);

public  void setExt3(String value);

public  void setBillId(String value);

public  void setProcessDate(Timestamp value);

public  void setResultDesc(String value);

public  void setCommitDate(Timestamp value);

public  void setSoNbr(long value);

public  void setResult(String value);
}
