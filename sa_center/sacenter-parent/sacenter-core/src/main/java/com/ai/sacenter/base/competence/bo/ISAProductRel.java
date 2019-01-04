package com.ai.sacenter.base.competence.bo;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ISAProductRel extends DataStructInterface{

  public final static  String S_ExtendAttrO = "EXTEND_ATTR_O";
  public final static  String S_State = "STATE";
  public final static  String S_ExtendAttrM = "EXTEND_ATTR_M";
  public final static  String S_ExtendAttrN = "EXTEND_ATTR_N";
  public final static  String S_ExtendAttrK = "EXTEND_ATTR_K";
  public final static  String S_ProductId = "PRODUCT_ID";
  public final static  String S_ExtendAttrL = "EXTEND_ATTR_L";
  public final static  String S_ExtendAttrI = "EXTEND_ATTR_I";
  public final static  String S_ExtendAttrJ = "EXTEND_ATTR_J";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_ProdRelatKindId = "PROD_RELAT_KIND_ID";
  public final static  String S_Id = "ID";
  public final static  String S_Modifier = "MODIFIER";
  public final static  String S_Expire = "EXPIRE";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_RelatProductId = "RELAT_PRODUCT_ID";
  public final static  String S_Creater = "CREATER";
  public final static  String S_ExtendAttrB = "EXTEND_ATTR_B";
  public final static  String S_ExtendAttrA = "EXTEND_ATTR_A";
  public final static  String S_ExtendAttrD = "EXTEND_ATTR_D";
  public final static  String S_ExtendAttrC = "EXTEND_ATTR_C";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_ExtendAttrF = "EXTEND_ATTR_F";
  public final static  String S_ExtendAttrE = "EXTEND_ATTR_E";
  public final static  String S_ExtendAttrH = "EXTEND_ATTR_H";
  public final static  String S_ExtendAttrG = "EXTEND_ATTR_G";
  public final static  String S_Effective = "EFFECTIVE";


public String getExtendAttrO();

public String getState();

public String getExtendAttrM();

public String getExtendAttrN();

public String getExtendAttrK();

public String getProductId();

public String getExtendAttrL();

public String getExtendAttrI();

public String getExtendAttrJ();

public Timestamp getModifyDate();

public String getProdRelatKindId();

public long getId();

public long getModifier();

public Timestamp getExpire();

public String getDescription();

public String getRelatProductId();

public long getCreater();

public String getExtendAttrB();

public String getExtendAttrA();

public String getExtendAttrD();

public String getExtendAttrC();

public Timestamp getCreateDate();

public String getExtendAttrF();

public String getExtendAttrE();

public String getExtendAttrH();

public String getExtendAttrG();

public Timestamp getEffective();


public  void setExtendAttrO(String value);

public  void setState(String value);

public  void setExtendAttrM(String value);

public  void setExtendAttrN(String value);

public  void setExtendAttrK(String value);

public  void setProductId(String value);

public  void setExtendAttrL(String value);

public  void setExtendAttrI(String value);

public  void setExtendAttrJ(String value);

public  void setModifyDate(Timestamp value);

public  void setProdRelatKindId(String value);

public  void setId(long value);

public  void setModifier(long value);

public  void setExpire(Timestamp value);

public  void setDescription(String value);

public  void setRelatProductId(String value);

public  void setCreater(long value);

public  void setExtendAttrB(String value);

public  void setExtendAttrA(String value);

public  void setExtendAttrD(String value);

public  void setExtendAttrC(String value);

public  void setCreateDate(Timestamp value);

public  void setExtendAttrF(String value);

public  void setExtendAttrE(String value);

public  void setExtendAttrH(String value);

public  void setExtendAttrG(String value);

public  void setEffective(Timestamp value);
}
