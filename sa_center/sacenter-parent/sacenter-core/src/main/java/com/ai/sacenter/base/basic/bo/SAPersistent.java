package com.ai.sacenter.base.basic.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class SAPersistent extends DataContainer implements DataContainerInterface,ISAPersistent{
  private static final long serialVersionUID = 2671734968438062286L;
  private static String  m_boName = "com.ai.sacenter.base.basic.bo.SAPersistent";
  public final static  String S_ExtendAttrL = "EXTEND_ATTR_L";
  public final static  String S_ExtendAttrK = "EXTEND_ATTR_K";
  public final static  String S_ExtendAttrJ = "EXTEND_ATTR_J";
  public final static  String S_ExtendAttrI = "EXTEND_ATTR_I";
  public final static  String S_ExtendAttrO = "EXTEND_ATTR_O";
  public final static  String S_ExtendAttrN = "EXTEND_ATTR_N";
  public final static  String S_ExtendAttrM = "EXTEND_ATTR_M";
  public final static  String S_State = "STATE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_Describe = "DESCRIBE";
  public final static  String S_Cycle = "CYCLE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Persistent = "PERSISTENT";
  public final static  String S_Failure = "FAILURE";
  public final static  String S_Name = "NAME";
  public final static  String S_Code = "CODE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_ExtendAttrD = "EXTEND_ATTR_D";
  public final static  String S_ExtendAttrC = "EXTEND_ATTR_C";
  public final static  String S_ExtendAttrB = "EXTEND_ATTR_B";
  public final static  String S_ExtendAttrA = "EXTEND_ATTR_A";
  public final static  String S_ExtendAttrH = "EXTEND_ATTR_H";
  public final static  String S_ExtendAttrG = "EXTEND_ATTR_G";
  public final static  String S_ExtendAttrF = "EXTEND_ATTR_F";
  public final static  String S_Control = "CONTROL";
  public final static  String S_ExtendAttrE = "EXTEND_ATTR_E";
  public final static  String S_History = "HISTORY";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAPersistent() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initExtendAttrL(String value){
     this.initProperty(S_ExtendAttrL,value);
  }
  public  void setExtendAttrL(String value){
     this.set(S_ExtendAttrL,value);
  }
  public  void setExtendAttrLNull(){
     this.set(S_ExtendAttrL,null);
  }

  public String getExtendAttrL(){
       return DataType.getAsString(this.get(S_ExtendAttrL));
  
  }
  public String getExtendAttrLInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrL));
      }

  public void initExtendAttrK(String value){
     this.initProperty(S_ExtendAttrK,value);
  }
  public  void setExtendAttrK(String value){
     this.set(S_ExtendAttrK,value);
  }
  public  void setExtendAttrKNull(){
     this.set(S_ExtendAttrK,null);
  }

  public String getExtendAttrK(){
       return DataType.getAsString(this.get(S_ExtendAttrK));
  
  }
  public String getExtendAttrKInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrK));
      }

  public void initExtendAttrJ(String value){
     this.initProperty(S_ExtendAttrJ,value);
  }
  public  void setExtendAttrJ(String value){
     this.set(S_ExtendAttrJ,value);
  }
  public  void setExtendAttrJNull(){
     this.set(S_ExtendAttrJ,null);
  }

  public String getExtendAttrJ(){
       return DataType.getAsString(this.get(S_ExtendAttrJ));
  
  }
  public String getExtendAttrJInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrJ));
      }

  public void initExtendAttrI(String value){
     this.initProperty(S_ExtendAttrI,value);
  }
  public  void setExtendAttrI(String value){
     this.set(S_ExtendAttrI,value);
  }
  public  void setExtendAttrINull(){
     this.set(S_ExtendAttrI,null);
  }

  public String getExtendAttrI(){
       return DataType.getAsString(this.get(S_ExtendAttrI));
  
  }
  public String getExtendAttrIInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrI));
      }

  public void initExtendAttrO(String value){
     this.initProperty(S_ExtendAttrO,value);
  }
  public  void setExtendAttrO(String value){
     this.set(S_ExtendAttrO,value);
  }
  public  void setExtendAttrONull(){
     this.set(S_ExtendAttrO,null);
  }

  public String getExtendAttrO(){
       return DataType.getAsString(this.get(S_ExtendAttrO));
  
  }
  public String getExtendAttrOInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrO));
      }

  public void initExtendAttrN(String value){
     this.initProperty(S_ExtendAttrN,value);
  }
  public  void setExtendAttrN(String value){
     this.set(S_ExtendAttrN,value);
  }
  public  void setExtendAttrNNull(){
     this.set(S_ExtendAttrN,null);
  }

  public String getExtendAttrN(){
       return DataType.getAsString(this.get(S_ExtendAttrN));
  
  }
  public String getExtendAttrNInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrN));
      }

  public void initExtendAttrM(String value){
     this.initProperty(S_ExtendAttrM,value);
  }
  public  void setExtendAttrM(String value){
     this.set(S_ExtendAttrM,value);
  }
  public  void setExtendAttrMNull(){
     this.set(S_ExtendAttrM,null);
  }

  public String getExtendAttrM(){
       return DataType.getAsString(this.get(S_ExtendAttrM));
  
  }
  public String getExtendAttrMInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrM));
      }

  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initCreater(long value){
     this.initProperty(S_Creater,new Long(value));
  }
  public  void setCreater(long value){
     this.set(S_Creater,new Long(value));
  }
  public  void setCreaterNull(){
     this.set(S_Creater,null);
  }

  public long getCreater(){
        return DataType.getAsLong(this.get(S_Creater));
  
  }
  public long getCreaterInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Creater));
      }

  public void initModifyDate(Timestamp value){
     this.initProperty(S_ModifyDate,value);
  }
  public  void setModifyDate(Timestamp value){
     this.set(S_ModifyDate,value);
  }
  public  void setModifyDateNull(){
     this.set(S_ModifyDate,null);
  }

  public Timestamp getModifyDate(){
        return DataType.getAsDateTime(this.get(S_ModifyDate));
  
  }
  public Timestamp getModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
      }

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
        return DataType.getAsLong(this.get(S_Id));
  
  }
  public long getIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Id));
      }

  public void initDescribe(String value){
     this.initProperty(S_Describe,value);
  }
  public  void setDescribe(String value){
     this.set(S_Describe,value);
  }
  public  void setDescribeNull(){
     this.set(S_Describe,null);
  }

  public String getDescribe(){
       return DataType.getAsString(this.get(S_Describe));
  
  }
  public String getDescribeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Describe));
      }

  public void initCycle(long value){
     this.initProperty(S_Cycle,new Long(value));
  }
  public  void setCycle(long value){
     this.set(S_Cycle,new Long(value));
  }
  public  void setCycleNull(){
     this.set(S_Cycle,null);
  }

  public long getCycle(){
        return DataType.getAsLong(this.get(S_Cycle));
  
  }
  public long getCycleInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Cycle));
      }

  public void initModifier(long value){
     this.initProperty(S_Modifier,new Long(value));
  }
  public  void setModifier(long value){
     this.set(S_Modifier,new Long(value));
  }
  public  void setModifierNull(){
     this.set(S_Modifier,null);
  }

  public long getModifier(){
        return DataType.getAsLong(this.get(S_Modifier));
  
  }
  public long getModifierInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Modifier));
      }

  public void initPersistent(String value){
     this.initProperty(S_Persistent,value);
  }
  public  void setPersistent(String value){
     this.set(S_Persistent,value);
  }
  public  void setPersistentNull(){
     this.set(S_Persistent,null);
  }

  public String getPersistent(){
       return DataType.getAsString(this.get(S_Persistent));
  
  }
  public String getPersistentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Persistent));
      }

  public void initFailure(String value){
     this.initProperty(S_Failure,value);
  }
  public  void setFailure(String value){
     this.set(S_Failure,value);
  }
  public  void setFailureNull(){
     this.set(S_Failure,null);
  }

  public String getFailure(){
       return DataType.getAsString(this.get(S_Failure));
  
  }
  public String getFailureInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Failure));
      }

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initCode(String value){
     this.initProperty(S_Code,value);
  }
  public  void setCode(String value){
     this.set(S_Code,value);
  }
  public  void setCodeNull(){
     this.set(S_Code,null);
  }

  public String getCode(){
       return DataType.getAsString(this.get(S_Code));
  
  }
  public String getCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Code));
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

  public void initExtendAttrD(String value){
     this.initProperty(S_ExtendAttrD,value);
  }
  public  void setExtendAttrD(String value){
     this.set(S_ExtendAttrD,value);
  }
  public  void setExtendAttrDNull(){
     this.set(S_ExtendAttrD,null);
  }

  public String getExtendAttrD(){
       return DataType.getAsString(this.get(S_ExtendAttrD));
  
  }
  public String getExtendAttrDInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrD));
      }

  public void initExtendAttrC(String value){
     this.initProperty(S_ExtendAttrC,value);
  }
  public  void setExtendAttrC(String value){
     this.set(S_ExtendAttrC,value);
  }
  public  void setExtendAttrCNull(){
     this.set(S_ExtendAttrC,null);
  }

  public String getExtendAttrC(){
       return DataType.getAsString(this.get(S_ExtendAttrC));
  
  }
  public String getExtendAttrCInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrC));
      }

  public void initExtendAttrB(String value){
     this.initProperty(S_ExtendAttrB,value);
  }
  public  void setExtendAttrB(String value){
     this.set(S_ExtendAttrB,value);
  }
  public  void setExtendAttrBNull(){
     this.set(S_ExtendAttrB,null);
  }

  public String getExtendAttrB(){
       return DataType.getAsString(this.get(S_ExtendAttrB));
  
  }
  public String getExtendAttrBInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrB));
      }

  public void initExtendAttrA(String value){
     this.initProperty(S_ExtendAttrA,value);
  }
  public  void setExtendAttrA(String value){
     this.set(S_ExtendAttrA,value);
  }
  public  void setExtendAttrANull(){
     this.set(S_ExtendAttrA,null);
  }

  public String getExtendAttrA(){
       return DataType.getAsString(this.get(S_ExtendAttrA));
  
  }
  public String getExtendAttrAInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrA));
      }

  public void initExtendAttrH(String value){
     this.initProperty(S_ExtendAttrH,value);
  }
  public  void setExtendAttrH(String value){
     this.set(S_ExtendAttrH,value);
  }
  public  void setExtendAttrHNull(){
     this.set(S_ExtendAttrH,null);
  }

  public String getExtendAttrH(){
       return DataType.getAsString(this.get(S_ExtendAttrH));
  
  }
  public String getExtendAttrHInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrH));
      }

  public void initExtendAttrG(String value){
     this.initProperty(S_ExtendAttrG,value);
  }
  public  void setExtendAttrG(String value){
     this.set(S_ExtendAttrG,value);
  }
  public  void setExtendAttrGNull(){
     this.set(S_ExtendAttrG,null);
  }

  public String getExtendAttrG(){
       return DataType.getAsString(this.get(S_ExtendAttrG));
  
  }
  public String getExtendAttrGInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrG));
      }

  public void initExtendAttrF(String value){
     this.initProperty(S_ExtendAttrF,value);
  }
  public  void setExtendAttrF(String value){
     this.set(S_ExtendAttrF,value);
  }
  public  void setExtendAttrFNull(){
     this.set(S_ExtendAttrF,null);
  }

  public String getExtendAttrF(){
       return DataType.getAsString(this.get(S_ExtendAttrF));
  
  }
  public String getExtendAttrFInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrF));
      }

  public void initControl(String value){
     this.initProperty(S_Control,value);
  }
  public  void setControl(String value){
     this.set(S_Control,value);
  }
  public  void setControlNull(){
     this.set(S_Control,null);
  }

  public String getControl(){
       return DataType.getAsString(this.get(S_Control));
  
  }
  public String getControlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Control));
      }

  public void initExtendAttrE(String value){
     this.initProperty(S_ExtendAttrE,value);
  }
  public  void setExtendAttrE(String value){
     this.set(S_ExtendAttrE,value);
  }
  public  void setExtendAttrENull(){
     this.set(S_ExtendAttrE,null);
  }

  public String getExtendAttrE(){
       return DataType.getAsString(this.get(S_ExtendAttrE));
  
  }
  public String getExtendAttrEInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendAttrE));
      }

  public void initHistory(String value){
     this.initProperty(S_History,value);
  }
  public  void setHistory(String value){
     this.set(S_History,value);
  }
  public  void setHistoryNull(){
     this.set(S_History,null);
  }

  public String getHistory(){
       return DataType.getAsString(this.get(S_History));
  
  }
  public String getHistoryInitialValue(){
        return DataType.getAsString(this.getOldObj(S_History));
      }


 
 }

