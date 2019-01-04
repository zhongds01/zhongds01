package com.ai.sacenter.base.basic.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISADistrict extends DataStructInterface{

  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_ParentDistrict = "PARENT_DISTRICT";
  public final static  String S_RegionCode = "REGION_CODE";
  public final static  String S_DistrictId = "DISTRICT_ID";
  public final static  String S_State = "STATE";
  public final static  String S_DistrictTypeId = "DISTRICT_TYPE_ID";
  public final static  String S_AreaCode = "AREA_CODE";
  public final static  String S_Creater = "CREATER";
  public final static  String S_EnglishName = "ENGLISH_NAME";
  public final static  String S_CourseFlag = "COURSE_FLAG";
  public final static  String S_CenterCode = "CENTER_CODE";
  public final static  String S_TwoNumber = "TWO_NUMBER";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_DistrictName = "DISTRICT_NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_DistrictCode = "DISTRICT_CODE";
  public final static  String S_Control = "CONTROL";


public long getModifier();

public long getParentDistrict();

public String getRegionCode();

public long getDistrictId();

public String getState();

public int getDistrictTypeId();

public String getAreaCode();

public long getCreater();

public String getEnglishName();

public int getCourseFlag();

public String getCenterCode();

public int getTwoNumber();

public Timestamp getCreateDate();

public String getDistrictName();

public String getDescription();

public Timestamp getModifyDate();

public String getDistrictCode();

public String getControl();


public  void setModifier(long value);

public  void setParentDistrict(long value);

public  void setRegionCode(String value);

public  void setDistrictId(long value);

public  void setState(String value);

public  void setDistrictTypeId(int value);

public  void setAreaCode(String value);

public  void setCreater(long value);

public  void setEnglishName(String value);

public  void setCourseFlag(int value);

public  void setCenterCode(String value);

public  void setTwoNumber(int value);

public  void setCreateDate(Timestamp value);

public  void setDistrictName(String value);

public  void setDescription(String value);

public  void setModifyDate(Timestamp value);

public  void setDistrictCode(String value);

public  void setControl(String value);
}
