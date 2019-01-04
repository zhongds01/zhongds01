package com.ai.sacenter.core.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class SAQueueFail extends DataContainer implements
		DataContainerInterface, ISAQueue {

	private static final long serialVersionUID = 3084084925177418602L;

	private static String m_boName = "com.ai.sacenter.core.bo.SAQueueFail";

	public final static String S_State = "STATE";
	public final static String S_UserId = "USER_ID";
	public final static String S_Priority = "PRIORITY";
	public final static String S_RedoTimes = "REDO_TIMES";
	public final static String S_PlwkComplete = "PLWK_COMPLETE";
	public final static String S_QueueId = "QUEUE_ID";
	public final static String S_CompleteDate = "COMPLETE_DATE";
	public final static String S_SrcSystem = "SRC_SYSTEM";
	public final static String S_OrgId = "ORG_ID";
	public final static String S_RegionId = "REGION_ID";
	public final static String S_Category = "CATEGORY";
	public final static String S_OrderId = "ORDER_ID";
	public final static String S_StaffId = "STAFF_ID";
	public final static String S_Result = "RESULT";
	public final static String S_Program = "PROGRAM";
	public final static String S_PlwkDescribe = "PLWK_DESCRIBE";
	public final static String S_Param = "PARAM";
	public final static String S_Platform = "PLATFORM";
	public final static String S_PlqkId = "PLQK_ID";
	public final static String S_PlwkCoding = "PLWK_CODING";
	public final static String S_DoneTimes = "DONE_TIMES";
	public final static String S_PlwkCreate = "PLWK_CREATE";
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

	public SAQueueFail() throws AIException {
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

	public void initPriority(long value) {
		this.initProperty(S_Priority, new Long(value));
	}

	public void setPriority(long value) {
		this.set(S_Priority, new Long(value));
	}

	public void setPriorityNull() {
		this.set(S_Priority, null);
	}

	public long getPriority() {
		return DataType.getAsLong(this.get(S_Priority));

	}

	public long getPriorityInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Priority));
	}

	public void initRedoTimes(int value) {
		this.initProperty(S_RedoTimes, new Integer(value));
	}

	public void setRedoTimes(int value) {
		this.set(S_RedoTimes, new Integer(value));
	}

	public void setRedoTimesNull() {
		this.set(S_RedoTimes, null);
	}

	public int getRedoTimes() {
		return DataType.getAsInt(this.get(S_RedoTimes));

	}

	public int getRedoTimesInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_RedoTimes));
	}

	public void initPlwkComplete(Timestamp value) {
		this.initProperty(S_PlwkComplete, value);
	}

	public void setPlwkComplete(Timestamp value) {
		this.set(S_PlwkComplete, value);
	}

	public void setPlwkCompleteNull() {
		this.set(S_PlwkComplete, null);
	}

	public Timestamp getPlwkComplete() {
		return DataType.getAsDateTime(this.get(S_PlwkComplete));

	}

	public Timestamp getPlwkCompleteInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_PlwkComplete));
	}

	public void initQueueId(long value) {
		this.initProperty(S_QueueId, new Long(value));
	}

	public void setQueueId(long value) {
		this.set(S_QueueId, new Long(value));
	}

	public void setQueueIdNull() {
		this.set(S_QueueId, null);
	}

	public long getQueueId() {
		return DataType.getAsLong(this.get(S_QueueId));

	}

	public long getQueueIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_QueueId));
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

	public void initSrcSystem(String value) {
		this.initProperty(S_SrcSystem, value);
	}

	public void setSrcSystem(String value) {
		this.set(S_SrcSystem, value);
	}

	public void setSrcSystemNull() {
		this.set(S_SrcSystem, null);
	}

	public String getSrcSystem() {
		return DataType.getAsString(this.get(S_SrcSystem));

	}

	public String getSrcSystemInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SrcSystem));
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

	public void initCategory(String value) {
		this.initProperty(S_Category, value);
	}

	public void setCategory(String value) {
		this.set(S_Category, value);
	}

	public void setCategoryNull() {
		this.set(S_Category, null);
	}

	public String getCategory() {
		return DataType.getAsString(this.get(S_Category));

	}

	public String getCategoryInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Category));
	}

	public void initOrderId(long value) {
		this.initProperty(S_OrderId, new Long(value));
	}

	public void setOrderId(long value) {
		this.set(S_OrderId, new Long(value));
	}

	public void setOrderIdNull() {
		this.set(S_OrderId, null);
	}

	public long getOrderId() {
		return DataType.getAsLong(this.get(S_OrderId));

	}

	public long getOrderIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OrderId));
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

	public void initProgram(String value) {
		this.initProperty(S_Program, value);
	}

	public void setProgram(String value) {
		this.set(S_Program, value);
	}

	public void setProgramNull() {
		this.set(S_Program, null);
	}

	public String getProgram() {
		return DataType.getAsString(this.get(S_Program));

	}

	public String getProgramInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Program));
	}

	public void initPlwkDescribe(String value) {
		this.initProperty(S_PlwkDescribe, value);
	}

	public void setPlwkDescribe(String value) {
		this.set(S_PlwkDescribe, value);
	}

	public void setPlwkDescribeNull() {
		this.set(S_PlwkDescribe, null);
	}

	public String getPlwkDescribe() {
		return DataType.getAsString(this.get(S_PlwkDescribe));

	}

	public String getPlwkDescribeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PlwkDescribe));
	}

	public void initParam(String value) {
		this.initProperty(S_Param, value);
	}

	public void setParam(String value) {
		this.set(S_Param, value);
	}

	public void setParamNull() {
		this.set(S_Param, null);
	}

	public String getParam() {
		return DataType.getAsString(this.get(S_Param));

	}

	public String getParamInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Param));
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

	public void initPlqkId(long value) {
		this.initProperty(S_PlqkId, new Long(value));
	}

	public void setPlqkId(long value) {
		this.set(S_PlqkId, new Long(value));
	}

	public void setPlqkIdNull() {
		this.set(S_PlqkId, null);
	}

	public long getPlqkId() {
		return DataType.getAsLong(this.get(S_PlqkId));

	}

	public long getPlqkIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PlqkId));
	}

	public void initPlwkCoding(String value) {
		this.initProperty(S_PlwkCoding, value);
	}

	public void setPlwkCoding(String value) {
		this.set(S_PlwkCoding, value);
	}

	public void setPlwkCodingNull() {
		this.set(S_PlwkCoding, null);
	}

	public String getPlwkCoding() {
		return DataType.getAsString(this.get(S_PlwkCoding));

	}

	public String getPlwkCodingInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PlwkCoding));
	}

	public void initDoneTimes(int value) {
		this.initProperty(S_DoneTimes, new Integer(value));
	}

	public void setDoneTimes(int value) {
		this.set(S_DoneTimes, new Integer(value));
	}

	public void setDoneTimesNull() {
		this.set(S_DoneTimes, null);
	}

	public int getDoneTimes() {
		return DataType.getAsInt(this.get(S_DoneTimes));

	}

	public int getDoneTimesInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_DoneTimes));
	}

	public void initPlwkCreate(Timestamp value) {
		this.initProperty(S_PlwkCreate, value);
	}

	public void setPlwkCreate(Timestamp value) {
		this.set(S_PlwkCreate, value);
	}

	public void setPlwkCreateNull() {
		this.set(S_PlwkCreate, null);
	}

	public Timestamp getPlwkCreate() {
		return DataType.getAsDateTime(this.get(S_PlwkCreate));

	}

	public Timestamp getPlwkCreateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_PlwkCreate));
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
