package com.asiainfo.sacenter.audit.ivalues;
import com.ai.appframe2.common.DataStructInterface;

public interface IBOYSValue extends DataStructInterface{

  public final static  String S_ActionId = "ACTION_ID";
  public final static  String S_PsServiceType = "PS_SERVICE_TYPE";


public long getActionId();

public String getPsServiceType();


public  void setActionId(long value);

public  void setPsServiceType(String value);
}
