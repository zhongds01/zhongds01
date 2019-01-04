package com.ai.sacenter.base.basic.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class SAStatic extends DataContainer implements DataContainerInterface,ISAStatic{
  private static final long serialVersionUID = 2779304845120442038L;
  private static String  m_boName = "com.ai.sacenter.base.basic.bo.SAStatic";
  public final static  String S_Code = "CODE";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Alias = "ALIAS";
  public final static  String S_Kind = "KIND";
  public final static  String S_State = "STATE";
  public final static  String S_Id = "ID";
  public final static  String S_Value = "VALUE";
  public final static  String S_Extern = "EXTERN";
  public final static  String S_Name = "NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SAStatic() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initSortId(int value){
     this.initProperty(S_SortId,new Integer(value));
  }
  public  void setSortId(int value){
     this.set(S_SortId,new Integer(value));
  }
  public  void setSortIdNull(){
     this.set(S_SortId,null);
  }

  public int getSortId(){
        return DataType.getAsInt(this.get(S_SortId));
  
  }
  public int getSortIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SortId));
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

  public void initAlias(String value){
     this.initProperty(S_Alias,value);
  }
  public  void setAlias(String value){
     this.set(S_Alias,value);
  }
  public  void setAliasNull(){
     this.set(S_Alias,null);
  }

  public String getAlias(){
       return DataType.getAsString(this.get(S_Alias));
  
  }
  public String getAliasInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Alias));
      }

  public void initKind(String value){
     this.initProperty(S_Kind,value);
  }
  public  void setKind(String value){
     this.set(S_Kind,value);
  }
  public  void setKindNull(){
     this.set(S_Kind,null);
  }

  public String getKind(){
       return DataType.getAsString(this.get(S_Kind));
  
  }
  public String getKindInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Kind));
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

  public void initValue(String value){
     this.initProperty(S_Value,value);
  }
  public  void setValue(String value){
     this.set(S_Value,value);
  }
  public  void setValueNull(){
     this.set(S_Value,null);
  }

  public String getValue(){
       return DataType.getAsString(this.get(S_Value));
  
  }
  public String getValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Value));
      }

  public void initExtern(String value){
     this.initProperty(S_Extern,value);
  }
  public  void setExtern(String value){
     this.set(S_Extern,value);
  }
  public  void setExternNull(){
     this.set(S_Extern,null);
  }

  public String getExtern(){
       return DataType.getAsString(this.get(S_Extern));
  
  }
  public String getExternInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Extern));
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


 
 }

