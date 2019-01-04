package com.asiainfo.sacenter.audit.ivalues;
import com.ai.appframe2.common.DataStructInterface;

public interface IBOIOPENPROVISIONOLDValue extends DataStructInterface{

  public final static  String S_SubBillId = "SUB_BILL_ID";
  public final static  String S_State = "STATE";
  public final static  String S_OldPsParam = "OLD_PS_PARAM";
  public final static  String S_StopType = "STOP_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PsParam = "PS_PARAM";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_ActionId = "ACTION_ID";
  public final static  String S_PsServiceType = "PS_SERVICE_TYPE";


public String getSubBillId();

public int getState();

public String getOldPsParam();

public int getStopType();

public String getRemarks();

public String getPsParam();

public String getBillId();

public String getDoneCode();

public long getActionId();

public String getPsServiceType();


public  void setSubBillId(String value);

public  void setState(int value);

public  void setOldPsParam(String value);

public  void setStopType(int value);

public  void setRemarks(String value);

public  void setPsParam(String value);

public  void setBillId(String value);

public  void setDoneCode(String value);

public  void setActionId(long value);

public  void setPsServiceType(String value);
}
