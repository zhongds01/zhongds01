package com.ai.sacenter.base.competence.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class SAComponent extends DataContainer implements DataContainerInterface, ISAComponent {
	private static final long serialVersionUID = -7296129176296212056L;
	private static String m_boName = "com.ai.sacenter.base.competence.bo.SAComponent";
	public final static String S_State = "STATE";
	public final static String S_Name = "NAME";
	public final static String S_Description = "DESCRIPTION";
	public final static String S_Control = "CONTROL";
	public final static String S_Implclass = "IMPLCLASS";
	public final static String S_ModifyDate = "MODIFY_DATE";
	public final static String S_Category = "CATEGORY";
	public final static String S_Complex = "COMPLEX";
	public final static String S_Creater = "CREATER";
	public final static String S_Id = "ID";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_Modifier = "MODIFIER";
	public final static String S_SortBy = "SORT_BY";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory()
					.getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public SAComponent() throws AIException {
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

	public void initName(String value) {
		this.initProperty(S_Name, value);
	}

	public void setName(String value) {
		this.set(S_Name, value);
	}

	public void setNameNull() {
		this.set(S_Name, null);
	}

	public String getName() {
		return DataType.getAsString(this.get(S_Name));

	}

	public String getNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Name));
	}

	public void initDescription(String value) {
		this.initProperty(S_Description, value);
	}

	public void setDescription(String value) {
		this.set(S_Description, value);
	}

	public void setDescriptionNull() {
		this.set(S_Description, null);
	}

	public String getDescription() {
		return DataType.getAsString(this.get(S_Description));

	}

	public String getDescriptionInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Description));
	}

	public void initControl(String value) {
		this.initProperty(S_Control, value);
	}

	public void setControl(String value) {
		this.set(S_Control, value);
	}

	public void setControlNull() {
		this.set(S_Control, null);
	}

	public String getControl() {
		return DataType.getAsString(this.get(S_Control));

	}

	public String getControlInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Control));
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

	public void initModifyDate(Timestamp value) {
		this.initProperty(S_ModifyDate, value);
	}

	public void setModifyDate(Timestamp value) {
		this.set(S_ModifyDate, value);
	}

	public void setModifyDateNull() {
		this.set(S_ModifyDate, null);
	}

	public Timestamp getModifyDate() {
		return DataType.getAsDateTime(this.get(S_ModifyDate));

	}

	public Timestamp getModifyDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
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

	public void initComplex(String value) {
		this.initProperty(S_Complex, value);
	}

	public void setComplex(String value) {
		this.set(S_Complex, value);
	}

	public void setComplexNull() {
		this.set(S_Complex, null);
	}

	public String getComplex() {
		return DataType.getAsString(this.get(S_Complex));

	}

	public String getComplexInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Complex));
	}

	public void initCreater(long value) {
		this.initProperty(S_Creater, new Long(value));
	}

	public void setCreater(long value) {
		this.set(S_Creater, new Long(value));
	}

	public void setCreaterNull() {
		this.set(S_Creater, null);
	}

	public long getCreater() {
		return DataType.getAsLong(this.get(S_Creater));

	}

	public long getCreaterInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Creater));
	}

	public void initId(String value) {
		this.initProperty(S_Id, value);
	}

	public void setId(String value) {
		this.set(S_Id, value);
	}

	public void setIdNull() {
		this.set(S_Id, null);
	}

	public String getId() {
		return DataType.getAsString(this.get(S_Id));

	}

	public String getIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Id));
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

	public void initModifier(long value) {
		this.initProperty(S_Modifier, new Long(value));
	}

	public void setModifier(long value) {
		this.set(S_Modifier, new Long(value));
	}

	public void setModifierNull() {
		this.set(S_Modifier, null);
	}

	public long getModifier() {
		return DataType.getAsLong(this.get(S_Modifier));

	}

	public long getModifierInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Modifier));
	}

	public void initSortBy(int value) {
		this.initProperty(S_SortBy, new Integer(value));
	}

	public void setSortBy(int value) {
		this.set(S_SortBy, new Integer(value));
	}

	public void setSortByNull() {
		this.set(S_SortBy, null);
	}

	public int getSortBy() {
		return DataType.getAsInt(this.get(S_SortBy));

	}

	public int getSortByInitialValue() {
		return DataType.getAsInt(this.getOldObj(S_SortBy));
	}

}
