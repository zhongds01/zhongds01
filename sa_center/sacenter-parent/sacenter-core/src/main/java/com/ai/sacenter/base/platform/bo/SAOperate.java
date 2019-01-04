package com.ai.sacenter.base.platform.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SAOperate extends DataContainer implements DataContainerInterface,ISAOperate{
  private static final long serialVersionUID = -3167331225750452900L;
  private static String  m_boName = "com.ai.sacenter.base.platform.bo.SAOperate";
  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_Control = "CONTROL";
  public final static  String S_Rsltflg = "RSLTFLG";
  public final static  String S_PsType = "PS_TYPE";
  public final static  String S_Syncflg = "SYNCFLG";
  public final static  String S_RedoTimes = "REDO_TIMES";
  public final static  String S_Request = "REQUEST";
  public final static  String S_PsService = "PS_SERVICE";
  public final static  String S_Plosflg = "PLOSFLG";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_Monitor = "MONITOR";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_Complex = "COMPLEX";
  public final static  String S_Composite = "COMPOSITE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_Platform = "PLATFORM";
  public final static  String S_Response = "RESPONSE";
  public final static  String S_Id = "ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Code = "CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAOperate() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initDescription(String value){
     this.initProperty(S_Description,value);
  }
  public  void setDescription(String value){
     this.set(S_Description,value);
  }
  public  void setDescriptionNull(){
     this.set(S_Description,null);
  }

  public String getDescription(){
       return DataType.getAsString(this.get(S_Description));
  
  }
  public String getDescriptionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Description));
      }

  public void initPriority(String value){
     this.initProperty(S_Priority,value);
  }
  public  void setPriority(String value){
     this.set(S_Priority,value);
  }
  public  void setPriorityNull(){
     this.set(S_Priority,null);
  }

  public String getPriority(){
       return DataType.getAsString(this.get(S_Priority));
  
  }
  public String getPriorityInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Priority));
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

  public void initRsltflg(String value){
     this.initProperty(S_Rsltflg,value);
  }
  public  void setRsltflg(String value){
     this.set(S_Rsltflg,value);
  }
  public  void setRsltflgNull(){
     this.set(S_Rsltflg,null);
  }

  public String getRsltflg(){
       return DataType.getAsString(this.get(S_Rsltflg));
  
  }
  public String getRsltflgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Rsltflg));
      }

  public void initPsType(String value){
     this.initProperty(S_PsType,value);
  }
  public  void setPsType(String value){
     this.set(S_PsType,value);
  }
  public  void setPsTypeNull(){
     this.set(S_PsType,null);
  }

  public String getPsType(){
       return DataType.getAsString(this.get(S_PsType));
  
  }
  public String getPsTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PsType));
      }

  public void initSyncflg(String value){
     this.initProperty(S_Syncflg,value);
  }
  public  void setSyncflg(String value){
     this.set(S_Syncflg,value);
  }
  public  void setSyncflgNull(){
     this.set(S_Syncflg,null);
  }

  public String getSyncflg(){
       return DataType.getAsString(this.get(S_Syncflg));
  
  }
  public String getSyncflgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Syncflg));
      }

  public void initRedoTimes(long value){
     this.initProperty(S_RedoTimes,new Long(value));
  }
  public  void setRedoTimes(long value){
     this.set(S_RedoTimes,new Long(value));
  }
  public  void setRedoTimesNull(){
     this.set(S_RedoTimes,null);
  }

  public long getRedoTimes(){
        return DataType.getAsLong(this.get(S_RedoTimes));
  
  }
  public long getRedoTimesInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RedoTimes));
      }

  public void initRequest(String value){
     this.initProperty(S_Request,value);
  }
  public  void setRequest(String value){
     this.set(S_Request,value);
  }
  public  void setRequestNull(){
     this.set(S_Request,null);
  }

  public String getRequest(){
       return DataType.getAsString(this.get(S_Request));
  
  }
  public String getRequestInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Request));
      }

  public void initPsService(String value){
     this.initProperty(S_PsService,value);
  }
  public  void setPsService(String value){
     this.set(S_PsService,value);
  }
  public  void setPsServiceNull(){
     this.set(S_PsService,null);
  }

  public String getPsService(){
       return DataType.getAsString(this.get(S_PsService));
  
  }
  public String getPsServiceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PsService));
      }

  public void initPlosflg(String value){
     this.initProperty(S_Plosflg,value);
  }
  public  void setPlosflg(String value){
     this.set(S_Plosflg,value);
  }
  public  void setPlosflgNull(){
     this.set(S_Plosflg,null);
  }

  public String getPlosflg(){
       return DataType.getAsString(this.get(S_Plosflg));
  
  }
  public String getPlosflgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Plosflg));
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

  public void initMonitor(String value){
     this.initProperty(S_Monitor,value);
  }
  public  void setMonitor(String value){
     this.set(S_Monitor,value);
  }
  public  void setMonitorNull(){
     this.set(S_Monitor,null);
  }

  public String getMonitor(){
       return DataType.getAsString(this.get(S_Monitor));
  
  }
  public String getMonitorInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Monitor));
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

  public void initComplex(String value){
     this.initProperty(S_Complex,value);
  }
  public  void setComplex(String value){
     this.set(S_Complex,value);
  }
  public  void setComplexNull(){
     this.set(S_Complex,null);
  }

  public String getComplex(){
       return DataType.getAsString(this.get(S_Complex));
  
  }
  public String getComplexInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Complex));
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

  public void initPlatform(String value){
     this.initProperty(S_Platform,value);
  }
  public  void setPlatform(String value){
     this.set(S_Platform,value);
  }
  public  void setPlatformNull(){
     this.set(S_Platform,null);
  }

  public String getPlatform(){
       return DataType.getAsString(this.get(S_Platform));
  
  }
  public String getPlatformInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Platform));
      }

  public void initResponse(String value){
     this.initProperty(S_Response,value);
  }
  public  void setResponse(String value){
     this.set(S_Response,value);
  }
  public  void setResponseNull(){
     this.set(S_Response,null);
  }

  public String getResponse(){
       return DataType.getAsString(this.get(S_Response));
  
  }
  public String getResponseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Response));
      }

  public void initId(String value){
     this.initProperty(S_Id,value);
  }
  public  void setId(String value){
     this.set(S_Id,value);
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public String getId(){
       return DataType.getAsString(this.get(S_Id));
  
  }
  public String getIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Id));
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


 
 }

