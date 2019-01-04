package com.ai.sacenter.receive.custom.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class CmFamilyCust extends DataContainer implements DataContainerInterface {
	private static final long serialVersionUID = 7888948391643884110L;
	private static String m_boName = "com.ai.sacenter.receive.custom.bo.CmFamilyCust";
	public final static String S_State = "STATE";
	public final static String S_IndivCustId = "INDIV_CUST_ID";
	public final static String S_CustLevel = "CUST_LEVEL";
	public final static String S_CustAddress = "CUST_ADDRESS";
	public final static String S_BaseCustId = "BASE_CUST_ID";
	public final static String S_CustCertType = "CUST_CERT_TYPE";
	public final static String S_CreateOpId = "CREATE_OP_ID";
	public final static String S_FamilyCustId = "FAMILY_CUST_ID";
	public final static String S_CustCertCode = "CUST_CERT_CODE";
	public final static String S_EntryChnl = "ENTRY_CHNL";
	public final static String S_CustCertExpire = "CUST_CERT_EXPIRE";
	public final static String S_DoneCode = "DONE_CODE";
	public final static String S_FamilyPhone = "FAMILY_PHONE";
	public final static String S_CustZipcode = "CUST_ZIPCODE";
	public final static String S_Notes = "NOTES";
	public final static String S_ExpireDate = "EXPIRE_DATE";
	public final static String S_OpId = "OP_ID";
	public final static String S_CustStatus = "CUST_STATUS";
	public final static String S_EffectiveDate = "EFFECTIVE_DATE";
	public final static String S_SignalCover = "SIGNAL_COVER";
	public final static String S_OrgId = "ORG_ID";
	public final static String S_RegionId = "REGION_ID";
	public final static String S_CreateOrgId = "CREATE_ORG_ID";
	public final static String S_CustName = "CUST_NAME";
	public final static String S_EquipmentUsage = "EQUIPMENT_USAGE";
	public final static String S_CountyId = "COUNTY_ID";
	public final static String S_DoneDate = "DONE_DATE";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_MemberNum = "MEMBER_NUM";
	public final static String S_CustCertAddress = "CUST_CERT_ADDRESS";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public CmFamilyCust() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("Cannot reset ObjectType");
	}

	public void initState(String value) {
		this.initProperty(S_State, value);
	}

	public void setState(String value) {
		this.set(S_State, value);
	}

	public void setStateNull() {
		this.set(S_State, null);
	}

	public String getState() {
		return DataType.getAsString(this.get(S_State));

	}

	public String getStateInitialValue() {
		return DataType.getAsString(this.getOldObj(S_State));
	}

	public void initIndivCustId(long value) {
		this.initProperty(S_IndivCustId, new Long(value));
	}

	public void setIndivCustId(long value) {
		this.set(S_IndivCustId, new Long(value));
	}

	public void setIndivCustIdNull() {
		this.set(S_IndivCustId, null);
	}

	public long getIndivCustId() {
		return DataType.getAsLong(this.get(S_IndivCustId));

	}

	public long getIndivCustIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_IndivCustId));
	}

	public void initCustLevel(int value) {
		this.initProperty(S_CustLevel, new Integer(value));
	}

	public void setCustLevel(int value) {
		this.set(S_CustLevel, new Integer(value));
	}

	public void setCustLevelNull() {
		this.set(S_CustLevel, null);
	}

	public int getCustLevel() {
		return DataType.getAsInt(this.get(S_CustLevel));

	}

	public int getCustLevelInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_CustLevel));
	}

	public void initCustAddress(String value) {
		this.initProperty(S_CustAddress, value);
	}

	public void setCustAddress(String value) {
		this.set(S_CustAddress, value);
	}

	public void setCustAddressNull() {
		this.set(S_CustAddress, null);
	}

	public String getCustAddress() {
		return DataType.getAsString(this.get(S_CustAddress));

	}

	public String getCustAddressInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CustAddress));
	}

	public void initBaseCustId(long value) {
		this.initProperty(S_BaseCustId, new Long(value));
	}

	public void setBaseCustId(long value) {
		this.set(S_BaseCustId, new Long(value));
	}

	public void setBaseCustIdNull() {
		this.set(S_BaseCustId, null);
	}

	public long getBaseCustId() {
		return DataType.getAsLong(this.get(S_BaseCustId));

	}

	public long getBaseCustIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BaseCustId));
	}

	public void initCustCertType(int value) {
		this.initProperty(S_CustCertType, new Integer(value));
	}

	public void setCustCertType(int value) {
		this.set(S_CustCertType, new Integer(value));
	}

	public void setCustCertTypeNull() {
		this.set(S_CustCertType, null);
	}

	public int getCustCertType() {
		return DataType.getAsInt(this.get(S_CustCertType));

	}

	public int getCustCertTypeInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_CustCertType));
	}

	public void initCreateOpId(long value) {
		this.initProperty(S_CreateOpId, new Long(value));
	}

	public void setCreateOpId(long value) {
		this.set(S_CreateOpId, new Long(value));
	}

	public void setCreateOpIdNull() {
		this.set(S_CreateOpId, null);
	}

	public long getCreateOpId() {
		return DataType.getAsLong(this.get(S_CreateOpId));

	}

	public long getCreateOpIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CreateOpId));
	}

	public void initFamilyCustId(long value) {
		this.initProperty(S_FamilyCustId, new Long(value));
	}

	public void setFamilyCustId(long value) {
		this.set(S_FamilyCustId, new Long(value));
	}

	public void setFamilyCustIdNull() {
		this.set(S_FamilyCustId, null);
	}

	public long getFamilyCustId() {
		return DataType.getAsLong(this.get(S_FamilyCustId));

	}

	public long getFamilyCustIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_FamilyCustId));
	}

	public void initCustCertCode(String value) {
		this.initProperty(S_CustCertCode, value);
	}

	public void setCustCertCode(String value) {
		this.set(S_CustCertCode, value);
	}

	public void setCustCertCodeNull() {
		this.set(S_CustCertCode, null);
	}

	public String getCustCertCode() {
		return DataType.getAsString(this.get(S_CustCertCode));

	}

	public String getCustCertCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CustCertCode));
	}

	public void initEntryChnl(int value) {
		this.initProperty(S_EntryChnl, new Integer(value));
	}

	public void setEntryChnl(int value) {
		this.set(S_EntryChnl, new Integer(value));
	}

	public void setEntryChnlNull() {
		this.set(S_EntryChnl, null);
	}

	public int getEntryChnl() {
		return DataType.getAsInt(this.get(S_EntryChnl));

	}

	public int getEntryChnlInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_EntryChnl));
	}

	public void initCustCertExpire(Timestamp value) {
		this.initProperty(S_CustCertExpire, value);
	}

	public void setCustCertExpire(Timestamp value) {
		this.set(S_CustCertExpire, value);
	}

	public void setCustCertExpireNull() {
		this.set(S_CustCertExpire, null);
	}

	public Timestamp getCustCertExpire() {
		return DataType.getAsDateTime(this.get(S_CustCertExpire));

	}

	public Timestamp getCustCertExpireInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CustCertExpire));
	}

	public void initDoneCode(long value) {
		this.initProperty(S_DoneCode, new Long(value));
	}

	public void setDoneCode(long value) {
		this.set(S_DoneCode, new Long(value));
	}

	public void setDoneCodeNull() {
		this.set(S_DoneCode, null);
	}

	public long getDoneCode() {
		return DataType.getAsLong(this.get(S_DoneCode));

	}

	public long getDoneCodeInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_DoneCode));
	}

	public void initFamilyPhone(String value) {
		this.initProperty(S_FamilyPhone, value);
	}

	public void setFamilyPhone(String value) {
		this.set(S_FamilyPhone, value);
	}

	public void setFamilyPhoneNull() {
		this.set(S_FamilyPhone, null);
	}

	public String getFamilyPhone() {
		return DataType.getAsString(this.get(S_FamilyPhone));

	}

	public String getFamilyPhoneInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FamilyPhone));
	}

	public void initCustZipcode(String value) {
		this.initProperty(S_CustZipcode, value);
	}

	public void setCustZipcode(String value) {
		this.set(S_CustZipcode, value);
	}

	public void setCustZipcodeNull() {
		this.set(S_CustZipcode, null);
	}

	public String getCustZipcode() {
		return DataType.getAsString(this.get(S_CustZipcode));

	}

	public String getCustZipcodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CustZipcode));
	}

	public void initNotes(String value) {
		this.initProperty(S_Notes, value);
	}

	public void setNotes(String value) {
		this.set(S_Notes, value);
	}

	public void setNotesNull() {
		this.set(S_Notes, null);
	}

	public String getNotes() {
		return DataType.getAsString(this.get(S_Notes));

	}

	public String getNotesInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Notes));
	}

	public void initExpireDate(Timestamp value) {
		this.initProperty(S_ExpireDate, value);
	}

	public void setExpireDate(Timestamp value) {
		this.set(S_ExpireDate, value);
	}

	public void setExpireDateNull() {
		this.set(S_ExpireDate, null);
	}

	public Timestamp getExpireDate() {
		return DataType.getAsDateTime(this.get(S_ExpireDate));

	}

	public Timestamp getExpireDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_ExpireDate));
	}

	public void initOpId(long value) {
		this.initProperty(S_OpId, new Long(value));
	}

	public void setOpId(long value) {
		this.set(S_OpId, new Long(value));
	}

	public void setOpIdNull() {
		this.set(S_OpId, null);
	}

	public long getOpId() {
		return DataType.getAsLong(this.get(S_OpId));

	}

	public long getOpIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OpId));
	}

	public void initCustStatus(int value) {
		this.initProperty(S_CustStatus, new Integer(value));
	}

	public void setCustStatus(int value) {
		this.set(S_CustStatus, new Integer(value));
	}

	public void setCustStatusNull() {
		this.set(S_CustStatus, null);
	}

	public int getCustStatus() {
		return DataType.getAsInt(this.get(S_CustStatus));

	}

	public int getCustStatusInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_CustStatus));
	}

	public void initEffectiveDate(Timestamp value) {
		this.initProperty(S_EffectiveDate, value);
	}

	public void setEffectiveDate(Timestamp value) {
		this.set(S_EffectiveDate, value);
	}

	public void setEffectiveDateNull() {
		this.set(S_EffectiveDate, null);
	}

	public Timestamp getEffectiveDate() {
		return DataType.getAsDateTime(this.get(S_EffectiveDate));

	}

	public Timestamp getEffectiveDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_EffectiveDate));
	}

	public void initSignalCover(String value) {
		this.initProperty(S_SignalCover, value);
	}

	public void setSignalCover(String value) {
		this.set(S_SignalCover, value);
	}

	public void setSignalCoverNull() {
		this.set(S_SignalCover, null);
	}

	public String getSignalCover() {
		return DataType.getAsString(this.get(S_SignalCover));

	}

	public String getSignalCoverInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SignalCover));
	}

	public void initOrgId(long value) {
		this.initProperty(S_OrgId, new Long(value));
	}

	public void setOrgId(long value) {
		this.set(S_OrgId, new Long(value));
	}

	public void setOrgIdNull() {
		this.set(S_OrgId, null);
	}

	public long getOrgId() {
		return DataType.getAsLong(this.get(S_OrgId));

	}

	public long getOrgIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OrgId));
	}

	public void initRegionId(String value) {
		this.initProperty(S_RegionId, value);
	}

	public void setRegionId(String value) {
		this.set(S_RegionId, value);
	}

	public void setRegionIdNull() {
		this.set(S_RegionId, null);
	}

	public String getRegionId() {
		return DataType.getAsString(this.get(S_RegionId));

	}

	public String getRegionIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RegionId));
	}

	public void initCreateOrgId(long value) {
		this.initProperty(S_CreateOrgId, new Long(value));
	}

	public void setCreateOrgId(long value) {
		this.set(S_CreateOrgId, new Long(value));
	}

	public void setCreateOrgIdNull() {
		this.set(S_CreateOrgId, null);
	}

	public long getCreateOrgId() {
		return DataType.getAsLong(this.get(S_CreateOrgId));

	}

	public long getCreateOrgIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CreateOrgId));
	}

	public void initCustName(String value) {
		this.initProperty(S_CustName, value);
	}

	public void setCustName(String value) {
		this.set(S_CustName, value);
	}

	public void setCustNameNull() {
		this.set(S_CustName, null);
	}

	public String getCustName() {
		return DataType.getAsString(this.get(S_CustName));

	}

	public String getCustNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CustName));
	}

	public void initEquipmentUsage(String value) {
		this.initProperty(S_EquipmentUsage, value);
	}

	public void setEquipmentUsage(String value) {
		this.set(S_EquipmentUsage, value);
	}

	public void setEquipmentUsageNull() {
		this.set(S_EquipmentUsage, null);
	}

	public String getEquipmentUsage() {
		return DataType.getAsString(this.get(S_EquipmentUsage));

	}

	public String getEquipmentUsageInitialValue() {
		return DataType.getAsString(this.getOldObj(S_EquipmentUsage));
	}

	public void initCountyId(String value) {
		this.initProperty(S_CountyId, value);
	}

	public void setCountyId(String value) {
		this.set(S_CountyId, value);
	}

	public void setCountyIdNull() {
		this.set(S_CountyId, null);
	}

	public String getCountyId() {
		return DataType.getAsString(this.get(S_CountyId));

	}

	public String getCountyIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CountyId));
	}

	public void initDoneDate(Timestamp value) {
		this.initProperty(S_DoneDate, value);
	}

	public void setDoneDate(Timestamp value) {
		this.set(S_DoneDate, value);
	}

	public void setDoneDateNull() {
		this.set(S_DoneDate, null);
	}

	public Timestamp getDoneDate() {
		return DataType.getAsDateTime(this.get(S_DoneDate));

	}

	public Timestamp getDoneDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_DoneDate));
	}

	public void initCreateDate(Timestamp value) {
		this.initProperty(S_CreateDate, value);
	}

	public void setCreateDate(Timestamp value) {
		this.set(S_CreateDate, value);
	}

	public void setCreateDateNull() {
		this.set(S_CreateDate, null);
	}

	public Timestamp getCreateDate() {
		return DataType.getAsDateTime(this.get(S_CreateDate));

	}

	public Timestamp getCreateDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
	}

	public void initMemberNum(int value) {
		this.initProperty(S_MemberNum, new Integer(value));
	}

	public void setMemberNum(int value) {
		this.set(S_MemberNum, new Integer(value));
	}

	public void setMemberNumNull() {
		this.set(S_MemberNum, null);
	}

	public int getMemberNum() {
		return DataType.getAsInt(this.get(S_MemberNum));

	}

	public int getMemberNumInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_MemberNum));
	}

	public void initCustCertAddress(String value) {
		this.initProperty(S_CustCertAddress, value);
	}

	public void setCustCertAddress(String value) {
		this.set(S_CustCertAddress, value);
	}

	public void setCustCertAddressNull() {
		this.set(S_CustCertAddress, null);
	}

	public String getCustCertAddress() {
		return DataType.getAsString(this.get(S_CustCertAddress));

	}

	public String getCustCertAddressInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CustCertAddress));
	}

}
