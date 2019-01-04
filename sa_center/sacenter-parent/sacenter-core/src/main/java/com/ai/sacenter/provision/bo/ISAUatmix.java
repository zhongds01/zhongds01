package com.ai.sacenter.provision.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ISAUatmix extends DataContainer implements DataContainerInterface,
		IISAUatmix {

	private static final long serialVersionUID = -94163016627859449L;

	private static String m_boName = "com.ai.sacenter.provision.bo.ISAUatmix";

	public final static String S_State = "STATE";
	public final static String S_Msg20 = "MSG_20";
	public final static String S_Msg01 = "MSG_01";
	public final static String S_LgmsgId = "LGMSG_ID";
	public final static String S_CompleteDate = "COMPLETE_DATE";
	public final static String S_PlwkIdo = "PLWK_IDO";
	public final static String S_Msg19 = "MSG_19";
	public final static String S_Msg18 = "MSG_18";
	public final static String S_Result = "RESULT";
	public final static String S_Msg17 = "MSG_17";
	public final static String S_Msg16 = "MSG_16";
	public final static String S_Msg15 = "MSG_15";
	public final static String S_Msg14 = "MSG_14";
	public final static String S_Msg13 = "MSG_13";
	public final static String S_DoneCode = "DONE_CODE";
	public final static String S_UserId = "USER_ID";
	public final static String S_Msg10 = "MSG_10";
	public final static String S_Msg11 = "MSG_11";
	public final static String S_OrgId = "ORG_ID";
	public final static String S_Implclass = "IMPLCLASS";
	public final static String S_Msg12 = "MSG_12";
	public final static String S_RegionId = "REGION_ID";
	public final static String S_Msg03 = "MSG_03";
	public final static String S_Msg02 = "MSG_02";
	public final static String S_OrderId = "ORDER_ID";
	public final static String S_Msg05 = "MSG_05";
	public final static String S_StaffId = "STAFF_ID";
	public final static String S_Msg04 = "MSG_04";
	public final static String S_Msg07 = "MSG_07";
	public final static String S_Platform = "PLATFORM";
	public final static String S_Msg06 = "MSG_06";
	public final static String S_Msg09 = "MSG_09";
	public final static String S_Msg08 = "MSG_08";
	public final static String S_BillId = "BILL_ID";
	public final static String S_CreateDate = "CREATE_DATE";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory()
					.getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ISAUatmix() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		// 此种数据容器不能重置业务对象类型
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

	public void initMsg20(String value) {
		this.initProperty(S_Msg20, value);
	}

	public void setMsg20(String value) {
		this.set(S_Msg20, value);
	}

	public void setMsg20Null() {
		this.set(S_Msg20, null);
	}

	public String getMsg20() {
		return DataType.getAsString(this.get(S_Msg20));

	}

	public String getMsg20InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg20));
	}

	public void initMsg01(String value) {
		this.initProperty(S_Msg01, value);
	}

	public void setMsg01(String value) {
		this.set(S_Msg01, value);
	}

	public void setMsg01Null() {
		this.set(S_Msg01, null);
	}

	public String getMsg01() {
		return DataType.getAsString(this.get(S_Msg01));

	}

	public String getMsg01InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg01));
	}

	public void initLgmsgId(long value) {
		this.initProperty(S_LgmsgId, new Long(value));
	}

	public void setLgmsgId(long value) {
		this.set(S_LgmsgId, new Long(value));
	}

	public void setLgmsgIdNull() {
		this.set(S_LgmsgId, null);
	}

	public long getLgmsgId() {
		return DataType.getAsLong(this.get(S_LgmsgId));

	}

	public long getLgmsgIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_LgmsgId));
	}

	public void initCompleteDate(Timestamp value) {
		this.initProperty(S_CompleteDate, value);
	}

	public void setCompleteDate(Timestamp value) {
		this.set(S_CompleteDate, value);
	}

	public void setCompleteDateNull() {
		this.set(S_CompleteDate, null);
	}

	public Timestamp getCompleteDate() {
		return DataType.getAsDateTime(this.get(S_CompleteDate));

	}

	public Timestamp getCompleteDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CompleteDate));
	}

	public void initPlwkIdo(String value) {
		this.initProperty(S_PlwkIdo, value);
	}

	public void setPlwkIdo(String value) {
		this.set(S_PlwkIdo, value);
	}

	public void setPlwkIdoNull() {
		this.set(S_PlwkIdo, null);
	}

	public String getPlwkIdo() {
		return DataType.getAsString(this.get(S_PlwkIdo));

	}

	public String getPlwkIdoInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PlwkIdo));
	}

	public void initMsg19(String value) {
		this.initProperty(S_Msg19, value);
	}

	public void setMsg19(String value) {
		this.set(S_Msg19, value);
	}

	public void setMsg19Null() {
		this.set(S_Msg19, null);
	}

	public String getMsg19() {
		return DataType.getAsString(this.get(S_Msg19));

	}

	public String getMsg19InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg19));
	}

	public void initMsg18(String value) {
		this.initProperty(S_Msg18, value);
	}

	public void setMsg18(String value) {
		this.set(S_Msg18, value);
	}

	public void setMsg18Null() {
		this.set(S_Msg18, null);
	}

	public String getMsg18() {
		return DataType.getAsString(this.get(S_Msg18));

	}

	public String getMsg18InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg18));
	}

	public void initResult(String value) {
		this.initProperty(S_Result, value);
	}

	public void setResult(String value) {
		this.set(S_Result, value);
	}

	public void setResultNull() {
		this.set(S_Result, null);
	}

	public String getResult() {
		return DataType.getAsString(this.get(S_Result));

	}

	public String getResultInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Result));
	}

	public void initMsg17(String value) {
		this.initProperty(S_Msg17, value);
	}

	public void setMsg17(String value) {
		this.set(S_Msg17, value);
	}

	public void setMsg17Null() {
		this.set(S_Msg17, null);
	}

	public String getMsg17() {
		return DataType.getAsString(this.get(S_Msg17));

	}

	public String getMsg17InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg17));
	}

	public void initMsg16(String value) {
		this.initProperty(S_Msg16, value);
	}

	public void setMsg16(String value) {
		this.set(S_Msg16, value);
	}

	public void setMsg16Null() {
		this.set(S_Msg16, null);
	}

	public String getMsg16() {
		return DataType.getAsString(this.get(S_Msg16));

	}

	public String getMsg16InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg16));
	}

	public void initMsg15(String value) {
		this.initProperty(S_Msg15, value);
	}

	public void setMsg15(String value) {
		this.set(S_Msg15, value);
	}

	public void setMsg15Null() {
		this.set(S_Msg15, null);
	}

	public String getMsg15() {
		return DataType.getAsString(this.get(S_Msg15));

	}

	public String getMsg15InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg15));
	}

	public void initMsg14(String value) {
		this.initProperty(S_Msg14, value);
	}

	public void setMsg14(String value) {
		this.set(S_Msg14, value);
	}

	public void setMsg14Null() {
		this.set(S_Msg14, null);
	}

	public String getMsg14() {
		return DataType.getAsString(this.get(S_Msg14));

	}

	public String getMsg14InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg14));
	}

	public void initMsg13(String value) {
		this.initProperty(S_Msg13, value);
	}

	public void setMsg13(String value) {
		this.set(S_Msg13, value);
	}

	public void setMsg13Null() {
		this.set(S_Msg13, null);
	}

	public String getMsg13() {
		return DataType.getAsString(this.get(S_Msg13));

	}

	public String getMsg13InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg13));
	}

	public void initDoneCode(String value) {
		this.initProperty(S_DoneCode, value);
	}

	public void setDoneCode(String value) {
		this.set(S_DoneCode, value);
	}

	public void setDoneCodeNull() {
		this.set(S_DoneCode, null);
	}

	public String getDoneCode() {
		return DataType.getAsString(this.get(S_DoneCode));

	}

	public String getDoneCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_DoneCode));
	}

	public void initUserId(long value) {
		this.initProperty(S_UserId, new Long(value));
	}

	public void setUserId(long value) {
		this.set(S_UserId, new Long(value));
	}

	public void setUserIdNull() {
		this.set(S_UserId, null);
	}

	public long getUserId() {
		return DataType.getAsLong(this.get(S_UserId));

	}

	public long getUserIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_UserId));
	}

	public void initMsg10(String value) {
		this.initProperty(S_Msg10, value);
	}

	public void setMsg10(String value) {
		this.set(S_Msg10, value);
	}

	public void setMsg10Null() {
		this.set(S_Msg10, null);
	}

	public String getMsg10() {
		return DataType.getAsString(this.get(S_Msg10));

	}

	public String getMsg10InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg10));
	}

	public void initMsg11(String value) {
		this.initProperty(S_Msg11, value);
	}

	public void setMsg11(String value) {
		this.set(S_Msg11, value);
	}

	public void setMsg11Null() {
		this.set(S_Msg11, null);
	}

	public String getMsg11() {
		return DataType.getAsString(this.get(S_Msg11));

	}

	public String getMsg11InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg11));
	}

	public void initOrgId(String value) {
		this.initProperty(S_OrgId, value);
	}

	public void setOrgId(String value) {
		this.set(S_OrgId, value);
	}

	public void setOrgIdNull() {
		this.set(S_OrgId, null);
	}

	public String getOrgId() {
		return DataType.getAsString(this.get(S_OrgId));

	}

	public String getOrgIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OrgId));
	}

	public void initImplclass(String value) {
		this.initProperty(S_Implclass, value);
	}

	public void setImplclass(String value) {
		this.set(S_Implclass, value);
	}

	public void setImplclassNull() {
		this.set(S_Implclass, null);
	}

	public String getImplclass() {
		return DataType.getAsString(this.get(S_Implclass));

	}

	public String getImplclassInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Implclass));
	}

	public void initMsg12(String value) {
		this.initProperty(S_Msg12, value);
	}

	public void setMsg12(String value) {
		this.set(S_Msg12, value);
	}

	public void setMsg12Null() {
		this.set(S_Msg12, null);
	}

	public String getMsg12() {
		return DataType.getAsString(this.get(S_Msg12));

	}

	public String getMsg12InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg12));
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

	public void initMsg03(String value) {
		this.initProperty(S_Msg03, value);
	}

	public void setMsg03(String value) {
		this.set(S_Msg03, value);
	}

	public void setMsg03Null() {
		this.set(S_Msg03, null);
	}

	public String getMsg03() {
		return DataType.getAsString(this.get(S_Msg03));

	}

	public String getMsg03InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg03));
	}

	public void initMsg02(String value) {
		this.initProperty(S_Msg02, value);
	}

	public void setMsg02(String value) {
		this.set(S_Msg02, value);
	}

	public void setMsg02Null() {
		this.set(S_Msg02, null);
	}

	public String getMsg02() {
		return DataType.getAsString(this.get(S_Msg02));

	}

	public String getMsg02InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg02));
	}

	public void initOrderId(String value) {
		this.initProperty(S_OrderId, value);
	}

	public void setOrderId(String value) {
		this.set(S_OrderId, value);
	}

	public void setOrderIdNull() {
		this.set(S_OrderId, null);
	}

	public String getOrderId() {
		return DataType.getAsString(this.get(S_OrderId));

	}

	public String getOrderIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OrderId));
	}

	public void initMsg05(String value) {
		this.initProperty(S_Msg05, value);
	}

	public void setMsg05(String value) {
		this.set(S_Msg05, value);
	}

	public void setMsg05Null() {
		this.set(S_Msg05, null);
	}

	public String getMsg05() {
		return DataType.getAsString(this.get(S_Msg05));

	}

	public String getMsg05InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg05));
	}

	public void initStaffId(String value) {
		this.initProperty(S_StaffId, value);
	}

	public void setStaffId(String value) {
		this.set(S_StaffId, value);
	}

	public void setStaffIdNull() {
		this.set(S_StaffId, null);
	}

	public String getStaffId() {
		return DataType.getAsString(this.get(S_StaffId));

	}

	public String getStaffIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_StaffId));
	}

	public void initMsg04(String value) {
		this.initProperty(S_Msg04, value);
	}

	public void setMsg04(String value) {
		this.set(S_Msg04, value);
	}

	public void setMsg04Null() {
		this.set(S_Msg04, null);
	}

	public String getMsg04() {
		return DataType.getAsString(this.get(S_Msg04));

	}

	public String getMsg04InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg04));
	}

	public void initMsg07(String value) {
		this.initProperty(S_Msg07, value);
	}

	public void setMsg07(String value) {
		this.set(S_Msg07, value);
	}

	public void setMsg07Null() {
		this.set(S_Msg07, null);
	}

	public String getMsg07() {
		return DataType.getAsString(this.get(S_Msg07));

	}

	public String getMsg07InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg07));
	}

	public void initPlatform(String value) {
		this.initProperty(S_Platform, value);
	}

	public void setPlatform(String value) {
		this.set(S_Platform, value);
	}

	public void setPlatformNull() {
		this.set(S_Platform, null);
	}

	public String getPlatform() {
		return DataType.getAsString(this.get(S_Platform));

	}

	public String getPlatformInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Platform));
	}

	public void initMsg06(String value) {
		this.initProperty(S_Msg06, value);
	}

	public void setMsg06(String value) {
		this.set(S_Msg06, value);
	}

	public void setMsg06Null() {
		this.set(S_Msg06, null);
	}

	public String getMsg06() {
		return DataType.getAsString(this.get(S_Msg06));

	}

	public String getMsg06InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg06));
	}

	public void initMsg09(String value) {
		this.initProperty(S_Msg09, value);
	}

	public void setMsg09(String value) {
		this.set(S_Msg09, value);
	}

	public void setMsg09Null() {
		this.set(S_Msg09, null);
	}

	public String getMsg09() {
		return DataType.getAsString(this.get(S_Msg09));

	}

	public String getMsg09InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg09));
	}

	public void initMsg08(String value) {
		this.initProperty(S_Msg08, value);
	}

	public void setMsg08(String value) {
		this.set(S_Msg08, value);
	}

	public void setMsg08Null() {
		this.set(S_Msg08, null);
	}

	public String getMsg08() {
		return DataType.getAsString(this.get(S_Msg08));

	}

	public String getMsg08InitialValue() {
		return DataType.getAsString(this.getOldObj(S_Msg08));
	}

	public void initBillId(String value) {
		this.initProperty(S_BillId, value);
	}

	public void setBillId(String value) {
		this.set(S_BillId, value);
	}

	public void setBillIdNull() {
		this.set(S_BillId, null);
	}

	public String getBillId() {
		return DataType.getAsString(this.get(S_BillId));

	}

	public String getBillIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BillId));
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
