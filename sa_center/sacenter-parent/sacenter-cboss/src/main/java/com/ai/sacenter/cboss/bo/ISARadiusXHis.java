package com.ai.sacenter.cboss.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ISARadiusXHis extends DataContainer implements DataContainerInterface,IISARadiusX{
  private static final long serialVersionUID = -1944465675165348976L;
  private static String  m_boName = "com.ai.sacenter.cboss.bo.ISARadiusXHis";
  public final static  String S_Param17 = "PARAM_17";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Param18 = "PARAM_18";
  public final static  String S_Param19 = "PARAM_19";
  public final static  String S_SortBy = "SORT_BY";
  public final static  String S_Param10 = "PARAM_10";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Param11 = "PARAM_11";
  public final static  String S_Param12 = "PARAM_12";
  public final static  String S_Param13 = "PARAM_13";
  public final static  String S_Param14 = "PARAM_14";
  public final static  String S_Param15 = "PARAM_15";
  public final static  String S_Param16 = "PARAM_16";
  public final static  String S_Category = "CATEGORY";
  public final static  String S_SoNbr = "SO_NBR";
  public final static  String S_Param06 = "PARAM_06";
  public final static  String S_SubPlanNo = "SUB_PLAN_NO";
  public final static  String S_Param07 = "PARAM_07";
  public final static  String S_Param08 = "PARAM_08";
  public final static  String S_Param09 = "PARAM_09";
  public final static  String S_Param20 = "PARAM_20";
  public final static  String S_Param01 = "PARAM_01";
  public final static  String S_Param02 = "PARAM_02";
  public final static  String S_Param03 = "PARAM_03";
  public final static  String S_Param04 = "PARAM_04";
  public final static  String S_MsoNbr = "MSO_NBR";
  public final static  String S_Param05 = "PARAM_05";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OrderDate = "ORDER_DATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ISARadiusXHis() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initParam17(String value){
     this.initProperty(S_Param17,value);
  }
  public  void setParam17(String value){
     this.set(S_Param17,value);
  }
  public  void setParam17Null(){
     this.set(S_Param17,null);
  }

  public String getParam17(){
       return DataType.getAsString(this.get(S_Param17));
  
  }
  public String getParam17InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param17));
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

  public void initParam18(String value){
     this.initProperty(S_Param18,value);
  }
  public  void setParam18(String value){
     this.set(S_Param18,value);
  }
  public  void setParam18Null(){
     this.set(S_Param18,null);
  }

  public String getParam18(){
       return DataType.getAsString(this.get(S_Param18));
  
  }
  public String getParam18InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param18));
      }

  public void initParam19(String value){
     this.initProperty(S_Param19,value);
  }
  public  void setParam19(String value){
     this.set(S_Param19,value);
  }
  public  void setParam19Null(){
     this.set(S_Param19,null);
  }

  public String getParam19(){
       return DataType.getAsString(this.get(S_Param19));
  
  }
  public String getParam19InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param19));
      }

  public void initSortBy(int value){
     this.initProperty(S_SortBy,new Integer(value));
  }
  public  void setSortBy(int value){
     this.set(S_SortBy,new Integer(value));
  }
  public  void setSortByNull(){
     this.set(S_SortBy,null);
  }

  public int getSortBy(){
        return DataType.getAsInt(this.get(S_SortBy));
  
  }
  public int getSortByInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SortBy));
      }

  public void initParam10(String value){
     this.initProperty(S_Param10,value);
  }
  public  void setParam10(String value){
     this.set(S_Param10,value);
  }
  public  void setParam10Null(){
     this.set(S_Param10,null);
  }

  public String getParam10(){
       return DataType.getAsString(this.get(S_Param10));
  
  }
  public String getParam10InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param10));
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

  public void initParam11(String value){
     this.initProperty(S_Param11,value);
  }
  public  void setParam11(String value){
     this.set(S_Param11,value);
  }
  public  void setParam11Null(){
     this.set(S_Param11,null);
  }

  public String getParam11(){
       return DataType.getAsString(this.get(S_Param11));
  
  }
  public String getParam11InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param11));
      }

  public void initParam12(String value){
     this.initProperty(S_Param12,value);
  }
  public  void setParam12(String value){
     this.set(S_Param12,value);
  }
  public  void setParam12Null(){
     this.set(S_Param12,null);
  }

  public String getParam12(){
       return DataType.getAsString(this.get(S_Param12));
  
  }
  public String getParam12InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param12));
      }

  public void initParam13(String value){
     this.initProperty(S_Param13,value);
  }
  public  void setParam13(String value){
     this.set(S_Param13,value);
  }
  public  void setParam13Null(){
     this.set(S_Param13,null);
  }

  public String getParam13(){
       return DataType.getAsString(this.get(S_Param13));
  
  }
  public String getParam13InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param13));
      }

  public void initParam14(String value){
     this.initProperty(S_Param14,value);
  }
  public  void setParam14(String value){
     this.set(S_Param14,value);
  }
  public  void setParam14Null(){
     this.set(S_Param14,null);
  }

  public String getParam14(){
       return DataType.getAsString(this.get(S_Param14));
  
  }
  public String getParam14InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param14));
      }

  public void initParam15(String value){
     this.initProperty(S_Param15,value);
  }
  public  void setParam15(String value){
     this.set(S_Param15,value);
  }
  public  void setParam15Null(){
     this.set(S_Param15,null);
  }

  public String getParam15(){
       return DataType.getAsString(this.get(S_Param15));
  
  }
  public String getParam15InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param15));
      }

  public void initParam16(String value){
     this.initProperty(S_Param16,value);
  }
  public  void setParam16(String value){
     this.set(S_Param16,value);
  }
  public  void setParam16Null(){
     this.set(S_Param16,null);
  }

  public String getParam16(){
       return DataType.getAsString(this.get(S_Param16));
  
  }
  public String getParam16InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param16));
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

  public void initParam06(String value){
     this.initProperty(S_Param06,value);
  }
  public  void setParam06(String value){
     this.set(S_Param06,value);
  }
  public  void setParam06Null(){
     this.set(S_Param06,null);
  }

  public String getParam06(){
       return DataType.getAsString(this.get(S_Param06));
  
  }
  public String getParam06InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param06));
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

  public void initParam07(String value){
     this.initProperty(S_Param07,value);
  }
  public  void setParam07(String value){
     this.set(S_Param07,value);
  }
  public  void setParam07Null(){
     this.set(S_Param07,null);
  }

  public String getParam07(){
       return DataType.getAsString(this.get(S_Param07));
  
  }
  public String getParam07InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param07));
      }

  public void initParam08(String value){
     this.initProperty(S_Param08,value);
  }
  public  void setParam08(String value){
     this.set(S_Param08,value);
  }
  public  void setParam08Null(){
     this.set(S_Param08,null);
  }

  public String getParam08(){
       return DataType.getAsString(this.get(S_Param08));
  
  }
  public String getParam08InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param08));
      }

  public void initParam09(String value){
     this.initProperty(S_Param09,value);
  }
  public  void setParam09(String value){
     this.set(S_Param09,value);
  }
  public  void setParam09Null(){
     this.set(S_Param09,null);
  }

  public String getParam09(){
       return DataType.getAsString(this.get(S_Param09));
  
  }
  public String getParam09InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param09));
      }

  public void initParam20(String value){
     this.initProperty(S_Param20,value);
  }
  public  void setParam20(String value){
     this.set(S_Param20,value);
  }
  public  void setParam20Null(){
     this.set(S_Param20,null);
  }

  public String getParam20(){
       return DataType.getAsString(this.get(S_Param20));
  
  }
  public String getParam20InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param20));
      }

  public void initParam01(String value){
     this.initProperty(S_Param01,value);
  }
  public  void setParam01(String value){
     this.set(S_Param01,value);
  }
  public  void setParam01Null(){
     this.set(S_Param01,null);
  }

  public String getParam01(){
       return DataType.getAsString(this.get(S_Param01));
  
  }
  public String getParam01InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param01));
      }

  public void initParam02(String value){
     this.initProperty(S_Param02,value);
  }
  public  void setParam02(String value){
     this.set(S_Param02,value);
  }
  public  void setParam02Null(){
     this.set(S_Param02,null);
  }

  public String getParam02(){
       return DataType.getAsString(this.get(S_Param02));
  
  }
  public String getParam02InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param02));
      }

  public void initParam03(String value){
     this.initProperty(S_Param03,value);
  }
  public  void setParam03(String value){
     this.set(S_Param03,value);
  }
  public  void setParam03Null(){
     this.set(S_Param03,null);
  }

  public String getParam03(){
       return DataType.getAsString(this.get(S_Param03));
  
  }
  public String getParam03InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param03));
      }

  public void initParam04(String value){
     this.initProperty(S_Param04,value);
  }
  public  void setParam04(String value){
     this.set(S_Param04,value);
  }
  public  void setParam04Null(){
     this.set(S_Param04,null);
  }

  public String getParam04(){
       return DataType.getAsString(this.get(S_Param04));
  
  }
  public String getParam04InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param04));
      }

  public void initMsoNbr(long value){
     this.initProperty(S_MsoNbr,new Long(value));
  }
  public  void setMsoNbr(long value){
     this.set(S_MsoNbr,new Long(value));
  }
  public  void setMsoNbrNull(){
     this.set(S_MsoNbr,null);
  }

  public long getMsoNbr(){
        return DataType.getAsLong(this.get(S_MsoNbr));
  
  }
  public long getMsoNbrInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MsoNbr));
      }

  public void initParam05(String value){
     this.initProperty(S_Param05,value);
  }
  public  void setParam05(String value){
     this.set(S_Param05,value);
  }
  public  void setParam05Null(){
     this.set(S_Param05,null);
  }

  public String getParam05(){
       return DataType.getAsString(this.get(S_Param05));
  
  }
  public String getParam05InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Param05));
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


 
 }

