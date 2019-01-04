package com.ai.sacenter.receive.custom.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class CmVpmnCust extends DataContainer implements DataContainerInterface {
	private static final long serialVersionUID = -3577994175596937521L;
	private static String m_boName = "com.ai.sacenter.receive.custom.bo.CmVpmnCust";
	public final static String S_State = "STATE";
	public final static String S_CountyCode = "COUNTY_CODE";
	public final static String S_GroupCategory = "GROUP_CATEGORY";
	public final static String S_MaxMtrunk = "MAX_MTRUNK";
	public final static String S_CurrentUser = "CURRENT_USER";
	public final static String S_ProvCode = "PROV_CODE";
	public final static String S_GroupType = "GROUP_TYPE";
	public final static String S_CustAddress = "CUST_ADDRESS";
	public final static String S_Phone = "PHONE";
	public final static String S_CreateOpId = "CREATE_OP_ID";
	public final static String S_DoneCode = "DONE_CODE";
	public final static String S_StartNumber = "START_NUMBER";
	public final static String S_CustZipcode = "CUST_ZIPCODE";
	public final static String S_Notes = "NOTES";
	public final static String S_ExpireDate = "EXPIRE_DATE";
	public final static String S_CustStatus = "CUST_STATUS";
	public final static String S_EffectiveDate = "EFFECTIVE_DATE";
	public final static String S_OpId = "OP_ID";
	public final static String S_RgroupId = "RGROUP_ID";
	public final static String S_GroupId = "GROUP_ID";
	public final static String S_MaxUser = "MAX_USER";
	public final static String S_Contact = "CONTACT";
	public final static String S_EndNumber = "END_NUMBER";
	public final static String S_CsManager = "CS_MANAGER";
	public final static String S_OrgId = "ORG_ID";
	public final static String S_RegionId = "REGION_ID";
	public final static String S_CreateOrgId = "CREATE_ORG_ID";
	public final static String S_CustName = "CUST_NAME";
	public final static String S_DoneDate = "DONE_DATE";
	public final static String S_VpmnCustId = "VPMN_CUST_ID";
	public final static String S_RegionCode = "REGION_CODE";
	public final static String S_CreateDate = "CREATE_DATE";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public CmVpmnCust() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		// �������������������ҵ���������
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

	public void initCountyCode(String value) {
		this.initProperty(S_CountyCode, value);
	}

	public void setCountyCode(String value) {
		this.set(S_CountyCode, value);
	}

	public void setCountyCodeNull() {
		this.set(S_CountyCode, null);
	}

	public String getCountyCode() {
		return DataType.getAsString(this.get(S_CountyCode));

	}

	public String getCountyCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CountyCode));
	}

	public void initGroupCategory(int value) {
		this.initProperty(S_GroupCategory, new Integer(value));
	}

	public void setGroupCategory(int value) {
		this.set(S_GroupCategory, new Integer(value));
	}

	public void setGroupCategoryNull() {
		this.set(S_GroupCategory, null);
	}

	public int getGroupCategory() {
		return DataType.getAsInt(this.get(S_GroupCategory));

	}

	public int getGroupCategoryInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_GroupCategory));
	}

	public void initMaxMtrunk(long value) {
		this.initProperty(S_MaxMtrunk, new Long(value));
	}

	public void setMaxMtrunk(long value) {
		this.set(S_MaxMtrunk, new Long(value));
	}

	public void setMaxMtrunkNull() {
		this.set(S_MaxMtrunk, null);
	}

	public long getMaxMtrunk() {
		return DataType.getAsLong(this.get(S_MaxMtrunk));

	}

	public long getMaxMtrunkInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_MaxMtrunk));
	}

	public void initCurrentUser(int value) {
		this.initProperty(S_CurrentUser, new Integer(value));
	}

	public void setCurrentUser(int value) {
		this.set(S_CurrentUser, new Integer(value));
	}

	public void setCurrentUserNull() {
		this.set(S_CurrentUser, null);
	}

	public int getCurrentUser() {
		return DataType.getAsInt(this.get(S_CurrentUser));

	}

	public int getCurrentUserInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_CurrentUser));
	}

	public void initProvCode(String value) {
		this.initProperty(S_ProvCode, value);
	}

	public void setProvCode(String value) {
		this.set(S_ProvCode, value);
	}

	public void setProvCodeNull() {
		this.set(S_ProvCode, null);
	}

	public String getProvCode() {
		return DataType.getAsString(this.get(S_ProvCode));

	}

	public String getProvCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ProvCode));
	}

	public void initGroupType(int value) {
		this.initProperty(S_GroupType, new Integer(value));
	}

	public void setGroupType(int value) {
		this.set(S_GroupType, new Integer(value));
	}

	public void setGroupTypeNull() {
		this.set(S_GroupType, null);
	}

	public int getGroupType() {
		return DataType.getAsInt(this.get(S_GroupType));

	}

	public int getGroupTypeInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_GroupType));
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

	public void initPhone(String value) {
		this.initProperty(S_Phone, value);
	}

	public void setPhone(String value) {
		this.set(S_Phone, value);
	}

	public void setPhoneNull() {
		this.set(S_Phone, null);
	}

	public String getPhone() {
		return DataType.getAsString(this.get(S_Phone));

	}

	public String getPhoneInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Phone));
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

	public void initStartNumber(long value) {
		this.initProperty(S_StartNumber, new Long(value));
	}

	public void setStartNumber(long value) {
		this.set(S_StartNumber, new Long(value));
	}

	public void setStartNumberNull() {
		this.set(S_StartNumber, null);
	}

	public long getStartNumber() {
		return DataType.getAsLong(this.get(S_StartNumber));

	}

	public long getStartNumberInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_StartNumber));
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

	public void initRgroupId(long value) {
		this.initProperty(S_RgroupId, new Long(value));
	}

	public void setRgroupId(long value) {
		this.set(S_RgroupId, new Long(value));
	}

	public void setRgroupIdNull() {
		this.set(S_RgroupId, null);
	}

	public long getRgroupId() {
		return DataType.getAsLong(this.get(S_RgroupId));

	}

	public long getRgroupIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RgroupId));
	}

	public void initGroupId(long value) {
		this.initProperty(S_GroupId, new Long(value));
	}

	public void setGroupId(long value) {
		this.set(S_GroupId, new Long(value));
	}

	public void setGroupIdNull() {
		this.set(S_GroupId, null);
	}

	public long getGroupId() {
		return DataType.getAsLong(this.get(S_GroupId));

	}

	public long getGroupIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GroupId));
	}

	public void initMaxUser(int value) {
		this.initProperty(S_MaxUser, new Integer(value));
	}

	public void setMaxUser(int value) {
		this.set(S_MaxUser, new Integer(value));
	}

	public void setMaxUserNull() {
		this.set(S_MaxUser, null);
	}

	public int getMaxUser() {
		return DataType.getAsInt(this.get(S_MaxUser));

	}

	public int getMaxUserInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_MaxUser));
	}

	public void initContact(String value) {
		this.initProperty(S_Contact, value);
	}

	public void setContact(String value) {
		this.set(S_Contact, value);
	}

	public void setContactNull() {
		this.set(S_Contact, null);
	}

	public String getContact() {
		return DataType.getAsString(this.get(S_Contact));

	}

	public String getContactInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Contact));
	}

	public void initEndNumber(long value) {
		this.initProperty(S_EndNumber, new Long(value));
	}

	public void setEndNumber(long value) {
		this.set(S_EndNumber, new Long(value));
	}

	public void setEndNumberNull() {
		this.set(S_EndNumber, null);
	}

	public long getEndNumber() {
		return DataType.getAsLong(this.get(S_EndNumber));

	}

	public long getEndNumberInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_EndNumber));
	}

	public void initCsManager(String value) {
		this.initProperty(S_CsManager, value);
	}

	public void setCsManager(String value) {
		this.set(S_CsManager, value);
	}

	public void setCsManagerNull() {
		this.set(S_CsManager, null);
	}

	public String getCsManager() {
		return DataType.getAsString(this.get(S_CsManager));

	}

	public String getCsManagerInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CsManager));
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

	public void initVpmnCustId(long value) {
		this.initProperty(S_VpmnCustId, new Long(value));
	}

	public void setVpmnCustId(long value) {
		this.set(S_VpmnCustId, new Long(value));
	}

	public void setVpmnCustIdNull() {
		this.set(S_VpmnCustId, null);
	}

	public long getVpmnCustId() {
		return DataType.getAsLong(this.get(S_VpmnCustId));

	}

	public long getVpmnCustIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_VpmnCustId));
	}

	public void initRegionCode(String value) {
		this.initProperty(S_RegionCode, value);
	}

	public void setRegionCode(String value) {
		this.set(S_RegionCode, value);
	}

	public void setRegionCodeNull() {
		this.set(S_RegionCode, null);
	}

	public String getRegionCode() {
		return DataType.getAsString(this.get(S_RegionCode));

	}

	public String getRegionCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RegionCode));
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

}
