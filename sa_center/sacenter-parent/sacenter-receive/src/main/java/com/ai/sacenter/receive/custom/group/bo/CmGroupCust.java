package com.ai.sacenter.receive.custom.group.bo;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class CmGroupCust extends DataContainer implements DataContainerInterface {
	private static final long serialVersionUID = -4142728791467740238L;
	private static String m_boName = "com.ai.sacenter.receive.custom.group.bo.CmGroupCust";
	public final static String S_PostAddress = "POST_ADDRESS";
	public final static String S_PostProvince = "POST_PROVINCE";
	public final static String S_CustLevel = "CUST_LEVEL";
	public final static String S_GroupCountyId = "GROUP_COUNTY_ID";
	public final static String S_GroupProvinceId = "GROUP_PROVINCE_ID";
	public final static String S_ChnlRegionType = "CHNL_REGION_TYPE";
	public final static String S_IsFibrenetCover = "IS_FIBRENET_COVER";
	public final static String S_BaseCustId = "BASE_CUST_ID";
	public final static String S_SaOperId = "SA_OPER_ID";
	public final static String S_CustCertType = "CUST_CERT_TYPE";
	public final static String S_PostCity = "POST_CITY";
	public final static String S_CustCertCode = "CUST_CERT_CODE";
	public final static String S_GroupTownId = "GROUP_TOWN_ID";
	public final static String S_CustPassword = "CUST_PASSWORD";
	public final static String S_CustCertExpire = "CUST_CERT_EXPIRE";
	public final static String S_ChnlRegionDetail = "CHNL_REGION_DETAIL";
	public final static String S_GroupCityId = "GROUP_CITY_ID";
	public final static String S_CustZipcode = "CUST_ZIPCODE";
	public final static String S_TaxId = "TAX_ID";
	public final static String S_IndustryType = "INDUSTRY_TYPE";
	public final static String S_ExpireDate = "EXPIRE_DATE";
	public final static String S_OpId = "OP_ID";
	public final static String S_CoverDate = "COVER_DATE";
	public final static String S_EffectiveDate = "EFFECTIVE_DATE";
	public final static String S_ChnlCityId = "CHNL_CITY_ID";
	public final static String S_GroupId = "GROUP_ID";
	public final static String S_ContEmail = "CONT_EMAIL";
	public final static String S_ChnlProvinceId = "CHNL_PROVINCE_ID";
	public final static String S_CustType = "CUST_TYPE";
	public final static String S_CustName = "CUST_NAME";
	public final static String S_DoneDate = "DONE_DATE";
	public final static String S_DevelopType = "DEVELOP_TYPE";
	public final static String S_GroupStatus = "GROUP_STATUS";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_State = "STATE";
	public final static String S_LegalCustId = "LEGAL_CUST_ID";
	public final static String S_ContName = "CONT_NAME";
	public final static String S_ShortName = "SHORT_NAME";
	public final static String S_Nationality = "NATIONALITY";
	public final static String S_GroupType = "GROUP_TYPE";
	public final static String S_CustAddress = "CUST_ADDRESS";
	public final static String S_PostPostcode = "POST_POSTCODE";
	public final static String S_IsPonnetCover = "IS_PONNET_COVER";
	public final static String S_CreateOpId = "CREATE_OP_ID";
	public final static String S_DoneCode = "DONE_CODE";
	public final static String S_ContPhone2 = "CONT_PHONE2";
	public final static String S_ContPhone1 = "CONT_PHONE1";
	public final static String S_Notes = "NOTES";
	public final static String S_SyncDate = "SYNC_DATE";
	public final static String S_CustStatus = "CUST_STATUS";
	public final static String S_LegalCustName = "LEGAL_CUST_NAME";
	public final static String S_PartnerId = "PARTNER_ID";
	public final static String S_CustLevelNew = "CUST_LEVEL_NEW";
	public final static String S_ParentCustId = "PARENT_CUST_ID";
	public final static String S_GroupCustId = "GROUP_CUST_ID";
	public final static String S_OrgId = "ORG_ID";
	public final static String S_RegionId = "REGION_ID";
	public final static String S_CreateOrgId = "CREATE_ORG_ID";
	public final static String S_CoreMemNum = "CORE_MEM_NUM";
	public final static String S_GroupVillegeId = "GROUP_VILLEGE_ID";
	public final static String S_IsTransnetCover = "IS_TRANSNET_COVER";
	public final static String S_CustCertAddress = "CUST_CERT_ADDRESS";
	public final static String S_CompetitorInfo = "COMPETITOR_INFO";
	public final static String S_ContFax = "CONT_FAX";
	public final static String S_GroupWeb = "GROUP_WEB";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public CmGroupCust() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("Cannot reset ObjectType");
	}

	public void initPostAddress(String value) {
		this.initProperty(S_PostAddress, value);
	}

	public void setPostAddress(String value) {
		this.set(S_PostAddress, value);
	}

	public void setPostAddressNull() {
		this.set(S_PostAddress, null);
	}

	public String getPostAddress() {
		return DataType.getAsString(this.get(S_PostAddress));

	}

	public String getPostAddressInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PostAddress));
	}

	public void initPostProvince(long value) {
		this.initProperty(S_PostProvince, new Long(value));
	}

	public void setPostProvince(long value) {
		this.set(S_PostProvince, new Long(value));
	}

	public void setPostProvinceNull() {
		this.set(S_PostProvince, null);
	}

	public long getPostProvince() {
		return DataType.getAsLong(this.get(S_PostProvince));

	}

	public long getPostProvinceInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PostProvince));
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

	public void initGroupCountyId(long value) {
		this.initProperty(S_GroupCountyId, new Long(value));
	}

	public void setGroupCountyId(long value) {
		this.set(S_GroupCountyId, new Long(value));
	}

	public void setGroupCountyIdNull() {
		this.set(S_GroupCountyId, null);
	}

	public long getGroupCountyId() {
		return DataType.getAsLong(this.get(S_GroupCountyId));

	}

	public long getGroupCountyIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GroupCountyId));
	}

	public void initGroupProvinceId(long value) {
		this.initProperty(S_GroupProvinceId, new Long(value));
	}

	public void setGroupProvinceId(long value) {
		this.set(S_GroupProvinceId, new Long(value));
	}

	public void setGroupProvinceIdNull() {
		this.set(S_GroupProvinceId, null);
	}

	public long getGroupProvinceId() {
		return DataType.getAsLong(this.get(S_GroupProvinceId));

	}

	public long getGroupProvinceIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GroupProvinceId));
	}

	public void initChnlRegionType(String value) {
		this.initProperty(S_ChnlRegionType, value);
	}

	public void setChnlRegionType(String value) {
		this.set(S_ChnlRegionType, value);
	}

	public void setChnlRegionTypeNull() {
		this.set(S_ChnlRegionType, null);
	}

	public String getChnlRegionType() {
		return DataType.getAsString(this.get(S_ChnlRegionType));

	}

	public String getChnlRegionTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ChnlRegionType));
	}

	public void initIsFibrenetCover(int value) {
		this.initProperty(S_IsFibrenetCover, new Integer(value));
	}

	public void setIsFibrenetCover(int value) {
		this.set(S_IsFibrenetCover, new Integer(value));
	}

	public void setIsFibrenetCoverNull() {
		this.set(S_IsFibrenetCover, null);
	}

	public int getIsFibrenetCover() {
		return DataType.getAsInt(this.get(S_IsFibrenetCover));

	}

	public int getIsFibrenetCoverInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_IsFibrenetCover));
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

	public void initSaOperId(long value) {
		this.initProperty(S_SaOperId, new Long(value));
	}

	public void setSaOperId(long value) {
		this.set(S_SaOperId, new Long(value));
	}

	public void setSaOperIdNull() {
		this.set(S_SaOperId, null);
	}

	public long getSaOperId() {
		return DataType.getAsLong(this.get(S_SaOperId));

	}

	public long getSaOperIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SaOperId));
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

	public void initPostCity(long value) {
		this.initProperty(S_PostCity, new Long(value));
	}

	public void setPostCity(long value) {
		this.set(S_PostCity, new Long(value));
	}

	public void setPostCityNull() {
		this.set(S_PostCity, null);
	}

	public long getPostCity() {
		return DataType.getAsLong(this.get(S_PostCity));

	}

	public long getPostCityInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PostCity));
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

	public void initGroupTownId(long value) {
		this.initProperty(S_GroupTownId, new Long(value));
	}

	public void setGroupTownId(long value) {
		this.set(S_GroupTownId, new Long(value));
	}

	public void setGroupTownIdNull() {
		this.set(S_GroupTownId, null);
	}

	public long getGroupTownId() {
		return DataType.getAsLong(this.get(S_GroupTownId));

	}

	public long getGroupTownIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GroupTownId));
	}

	public void initCustPassword(String value) {
		this.initProperty(S_CustPassword, value);
	}

	public void setCustPassword(String value) {
		this.set(S_CustPassword, value);
	}

	public void setCustPasswordNull() {
		this.set(S_CustPassword, null);
	}

	public String getCustPassword() {
		return DataType.getAsString(this.get(S_CustPassword));

	}

	public String getCustPasswordInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CustPassword));
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

	public void initChnlRegionDetail(long value) {
		this.initProperty(S_ChnlRegionDetail, new Long(value));
	}

	public void setChnlRegionDetail(long value) {
		this.set(S_ChnlRegionDetail, new Long(value));
	}

	public void setChnlRegionDetailNull() {
		this.set(S_ChnlRegionDetail, null);
	}

	public long getChnlRegionDetail() {
		return DataType.getAsLong(this.get(S_ChnlRegionDetail));

	}

	public long getChnlRegionDetailInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ChnlRegionDetail));
	}

	public void initGroupCityId(long value) {
		this.initProperty(S_GroupCityId, new Long(value));
	}

	public void setGroupCityId(long value) {
		this.set(S_GroupCityId, new Long(value));
	}

	public void setGroupCityIdNull() {
		this.set(S_GroupCityId, null);
	}

	public long getGroupCityId() {
		return DataType.getAsLong(this.get(S_GroupCityId));

	}

	public long getGroupCityIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GroupCityId));
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

	public void initTaxId(String value) {
		this.initProperty(S_TaxId, value);
	}

	public void setTaxId(String value) {
		this.set(S_TaxId, value);
	}

	public void setTaxIdNull() {
		this.set(S_TaxId, null);
	}

	public String getTaxId() {
		return DataType.getAsString(this.get(S_TaxId));

	}

	public String getTaxIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TaxId));
	}

	public void initIndustryType(int value) {
		this.initProperty(S_IndustryType, new Integer(value));
	}

	public void setIndustryType(int value) {
		this.set(S_IndustryType, new Integer(value));
	}

	public void setIndustryTypeNull() {
		this.set(S_IndustryType, null);
	}

	public int getIndustryType() {
		return DataType.getAsInt(this.get(S_IndustryType));

	}

	public int getIndustryTypeInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_IndustryType));
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

	public void initCoverDate(Timestamp value) {
		this.initProperty(S_CoverDate, value);
	}

	public void setCoverDate(Timestamp value) {
		this.set(S_CoverDate, value);
	}

	public void setCoverDateNull() {
		this.set(S_CoverDate, null);
	}

	public Timestamp getCoverDate() {
		return DataType.getAsDateTime(this.get(S_CoverDate));

	}

	public Timestamp getCoverDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CoverDate));
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

	public void initChnlCityId(String value) {
		this.initProperty(S_ChnlCityId, value);
	}

	public void setChnlCityId(String value) {
		this.set(S_ChnlCityId, value);
	}

	public void setChnlCityIdNull() {
		this.set(S_ChnlCityId, null);
	}

	public String getChnlCityId() {
		return DataType.getAsString(this.get(S_ChnlCityId));

	}

	public String getChnlCityIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ChnlCityId));
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

	public void initContEmail(String value) {
		this.initProperty(S_ContEmail, value);
	}

	public void setContEmail(String value) {
		this.set(S_ContEmail, value);
	}

	public void setContEmailNull() {
		this.set(S_ContEmail, null);
	}

	public String getContEmail() {
		return DataType.getAsString(this.get(S_ContEmail));

	}

	public String getContEmailInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ContEmail));
	}

	public void initChnlProvinceId(long value) {
		this.initProperty(S_ChnlProvinceId, new Long(value));
	}

	public void setChnlProvinceId(long value) {
		this.set(S_ChnlProvinceId, new Long(value));
	}

	public void setChnlProvinceIdNull() {
		this.set(S_ChnlProvinceId, null);
	}

	public long getChnlProvinceId() {
		return DataType.getAsLong(this.get(S_ChnlProvinceId));

	}

	public long getChnlProvinceIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ChnlProvinceId));
	}

	public void initCustType(int value) {
		this.initProperty(S_CustType, new Integer(value));
	}

	public void setCustType(int value) {
		this.set(S_CustType, new Integer(value));
	}

	public void setCustTypeNull() {
		this.set(S_CustType, null);
	}

	public int getCustType() {
		return DataType.getAsInt(this.get(S_CustType));

	}

	public int getCustTypeInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_CustType));
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

	public void initDevelopType(int value) {
		this.initProperty(S_DevelopType, new Integer(value));
	}

	public void setDevelopType(int value) {
		this.set(S_DevelopType, new Integer(value));
	}

	public void setDevelopTypeNull() {
		this.set(S_DevelopType, null);
	}

	public int getDevelopType() {
		return DataType.getAsInt(this.get(S_DevelopType));

	}

	public int getDevelopTypeInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_DevelopType));
	}

	public void initGroupStatus(int value) {
		this.initProperty(S_GroupStatus, new Integer(value));
	}

	public void setGroupStatus(int value) {
		this.set(S_GroupStatus, new Integer(value));
	}

	public void setGroupStatusNull() {
		this.set(S_GroupStatus, null);
	}

	public int getGroupStatus() {
		return DataType.getAsInt(this.get(S_GroupStatus));

	}

	public int getGroupStatusInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_GroupStatus));
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

	public void initLegalCustId(long value) {
		this.initProperty(S_LegalCustId, new Long(value));
	}

	public void setLegalCustId(long value) {
		this.set(S_LegalCustId, new Long(value));
	}

	public void setLegalCustIdNull() {
		this.set(S_LegalCustId, null);
	}

	public long getLegalCustId() {
		return DataType.getAsLong(this.get(S_LegalCustId));

	}

	public long getLegalCustIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_LegalCustId));
	}

	public void initContName(String value) {
		this.initProperty(S_ContName, value);
	}

	public void setContName(String value) {
		this.set(S_ContName, value);
	}

	public void setContNameNull() {
		this.set(S_ContName, null);
	}

	public String getContName() {
		return DataType.getAsString(this.get(S_ContName));

	}

	public String getContNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ContName));
	}

	public void initShortName(String value) {
		this.initProperty(S_ShortName, value);
	}

	public void setShortName(String value) {
		this.set(S_ShortName, value);
	}

	public void setShortNameNull() {
		this.set(S_ShortName, null);
	}

	public String getShortName() {
		return DataType.getAsString(this.get(S_ShortName));

	}

	public String getShortNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ShortName));
	}

	public void initNationality(long value) {
		this.initProperty(S_Nationality, new Long(value));
	}

	public void setNationality(long value) {
		this.set(S_Nationality, new Long(value));
	}

	public void setNationalityNull() {
		this.set(S_Nationality, null);
	}

	public long getNationality() {
		return DataType.getAsLong(this.get(S_Nationality));

	}

	public long getNationalityInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Nationality));
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

	public void initPostPostcode(int value) {
		this.initProperty(S_PostPostcode, new Integer(value));
	}

	public void setPostPostcode(int value) {
		this.set(S_PostPostcode, new Integer(value));
	}

	public void setPostPostcodeNull() {
		this.set(S_PostPostcode, null);
	}

	public int getPostPostcode() {
		return DataType.getAsInt(this.get(S_PostPostcode));

	}

	public int getPostPostcodeInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_PostPostcode));
	}

	public void initIsPonnetCover(int value) {
		this.initProperty(S_IsPonnetCover, new Integer(value));
	}

	public void setIsPonnetCover(int value) {
		this.set(S_IsPonnetCover, new Integer(value));
	}

	public void setIsPonnetCoverNull() {
		this.set(S_IsPonnetCover, null);
	}

	public int getIsPonnetCover() {
		return DataType.getAsInt(this.get(S_IsPonnetCover));

	}

	public int getIsPonnetCoverInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_IsPonnetCover));
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

	public void initContPhone2(String value) {
		this.initProperty(S_ContPhone2, value);
	}

	public void setContPhone2(String value) {
		this.set(S_ContPhone2, value);
	}

	public void setContPhone2Null() {
		this.set(S_ContPhone2, null);
	}

	public String getContPhone2() {
		return DataType.getAsString(this.get(S_ContPhone2));

	}

	public String getContPhone2InitialValue() {
		return DataType.getAsString(this.getOldObj(S_ContPhone2));
	}

	public void initContPhone1(String value) {
		this.initProperty(S_ContPhone1, value);
	}

	public void setContPhone1(String value) {
		this.set(S_ContPhone1, value);
	}

	public void setContPhone1Null() {
		this.set(S_ContPhone1, null);
	}

	public String getContPhone1() {
		return DataType.getAsString(this.get(S_ContPhone1));

	}

	public String getContPhone1InitialValue() {
		return DataType.getAsString(this.getOldObj(S_ContPhone1));
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

	public void initSyncDate(Timestamp value) {
		this.initProperty(S_SyncDate, value);
	}

	public void setSyncDate(Timestamp value) {
		this.set(S_SyncDate, value);
	}

	public void setSyncDateNull() {
		this.set(S_SyncDate, null);
	}

	public Timestamp getSyncDate() {
		return DataType.getAsDateTime(this.get(S_SyncDate));

	}

	public Timestamp getSyncDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_SyncDate));
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

	public void initLegalCustName(String value) {
		this.initProperty(S_LegalCustName, value);
	}

	public void setLegalCustName(String value) {
		this.set(S_LegalCustName, value);
	}

	public void setLegalCustNameNull() {
		this.set(S_LegalCustName, null);
	}

	public String getLegalCustName() {
		return DataType.getAsString(this.get(S_LegalCustName));

	}

	public String getLegalCustNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_LegalCustName));
	}

	public void initPartnerId(long value) {
		this.initProperty(S_PartnerId, new Long(value));
	}

	public void setPartnerId(long value) {
		this.set(S_PartnerId, new Long(value));
	}

	public void setPartnerIdNull() {
		this.set(S_PartnerId, null);
	}

	public long getPartnerId() {
		return DataType.getAsLong(this.get(S_PartnerId));

	}

	public long getPartnerIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PartnerId));
	}

	public void initCustLevelNew(int value) {
		this.initProperty(S_CustLevelNew, new Integer(value));
	}

	public void setCustLevelNew(int value) {
		this.set(S_CustLevelNew, new Integer(value));
	}

	public void setCustLevelNewNull() {
		this.set(S_CustLevelNew, null);
	}

	public int getCustLevelNew() {
		return DataType.getAsInt(this.get(S_CustLevelNew));

	}

	public int getCustLevelNewInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_CustLevelNew));
	}

	public void initParentCustId(long value) {
		this.initProperty(S_ParentCustId, new Long(value));
	}

	public void setParentCustId(long value) {
		this.set(S_ParentCustId, new Long(value));
	}

	public void setParentCustIdNull() {
		this.set(S_ParentCustId, null);
	}

	public long getParentCustId() {
		return DataType.getAsLong(this.get(S_ParentCustId));

	}

	public long getParentCustIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ParentCustId));
	}

	public void initGroupCustId(long value) {
		this.initProperty(S_GroupCustId, new Long(value));
	}

	public void setGroupCustId(long value) {
		this.set(S_GroupCustId, new Long(value));
	}

	public void setGroupCustIdNull() {
		this.set(S_GroupCustId, null);
	}

	public long getGroupCustId() {
		return DataType.getAsLong(this.get(S_GroupCustId));

	}

	public long getGroupCustIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GroupCustId));
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

	public void initCoreMemNum(long value) {
		this.initProperty(S_CoreMemNum, new Long(value));
	}

	public void setCoreMemNum(long value) {
		this.set(S_CoreMemNum, new Long(value));
	}

	public void setCoreMemNumNull() {
		this.set(S_CoreMemNum, null);
	}

	public long getCoreMemNum() {
		return DataType.getAsLong(this.get(S_CoreMemNum));

	}

	public long getCoreMemNumInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CoreMemNum));
	}

	public void initGroupVillegeId(String value) {
		this.initProperty(S_GroupVillegeId, value);
	}

	public void setGroupVillegeId(String value) {
		this.set(S_GroupVillegeId, value);
	}

	public void setGroupVillegeIdNull() {
		this.set(S_GroupVillegeId, null);
	}

	public String getGroupVillegeId() {
		return DataType.getAsString(this.get(S_GroupVillegeId));

	}

	public String getGroupVillegeIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_GroupVillegeId));
	}

	public void initIsTransnetCover(int value) {
		this.initProperty(S_IsTransnetCover, new Integer(value));
	}

	public void setIsTransnetCover(int value) {
		this.set(S_IsTransnetCover, new Integer(value));
	}

	public void setIsTransnetCoverNull() {
		this.set(S_IsTransnetCover, null);
	}

	public int getIsTransnetCover() {
		return DataType.getAsInt(this.get(S_IsTransnetCover));

	}

	public int getIsTransnetCoverInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_IsTransnetCover));
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

	public void initCompetitorInfo(String value) {
		this.initProperty(S_CompetitorInfo, value);
	}

	public void setCompetitorInfo(String value) {
		this.set(S_CompetitorInfo, value);
	}

	public void setCompetitorInfoNull() {
		this.set(S_CompetitorInfo, null);
	}

	public String getCompetitorInfo() {
		return DataType.getAsString(this.get(S_CompetitorInfo));

	}

	public String getCompetitorInfoInitialValue() {
		return DataType.getAsString(this.getOldObj(S_CompetitorInfo));
	}

	public void initContFax(String value) {
		this.initProperty(S_ContFax, value);
	}

	public void setContFax(String value) {
		this.set(S_ContFax, value);
	}

	public void setContFaxNull() {
		this.set(S_ContFax, null);
	}

	public String getContFax() {
		return DataType.getAsString(this.get(S_ContFax));

	}

	public String getContFaxInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ContFax));
	}

	public void initGroupWeb(String value) {
		this.initProperty(S_GroupWeb, value);
	}

	public void setGroupWeb(String value) {
		this.set(S_GroupWeb, value);
	}

	public void setGroupWebNull() {
		this.set(S_GroupWeb, null);
	}

	public String getGroupWeb() {
		return DataType.getAsString(this.get(S_GroupWeb));

	}

	public String getGroupWebInitialValue() {
		return DataType.getAsString(this.getOldObj(S_GroupWeb));
	}

}
