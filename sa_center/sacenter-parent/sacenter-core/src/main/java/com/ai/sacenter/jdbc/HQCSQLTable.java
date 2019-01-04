package com.ai.sacenter.jdbc;

import com.ai.appframe2.common.ObjectType;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-10-8</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class HQCSQLTable implements java.io.Serializable{
	private static final long serialVersionUID = 830972579686038994L;
	private ObjectType type;
	private String table;
	private Class base = null;
	private Class fail = null;
	private Class buffer = null;
	private Class history = null;
	private Class suggest = null;
	public HQCSQLTable( ObjectType aTYPE , String aTABLE , Class aBASE ){
		super();
		type = aTYPE;
		table = aTABLE;
		base = aBASE;
	}
	
	/**
	 * @return the base
	 */
	public Class getBase() {
		return base;
	}

	/**
	 * @return the buffer
	 */
	public Class getBuffer() {
		return buffer;
	}

	/**
	 * @return the fail
	 */
	public Class getFail() {
		return fail;
	}

	/**
	 * @return the history
	 */
	public Class getHistory() {
		return history;
	}

	/**
	 * @return the suggest
	 */
	public Class getSuggest() {
		return suggest;
	}

	/**
	 * @return the table
	 */
	public String getTable() {
		return table;
	}

	/**
	 * @return the type
	 */
	public ObjectType getType() {
		return type;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(Class base) {
		this.base = base;
	}

	/**
	 * @param buffer the buffer to set
	 */
	public void setBuffer(Class buffer) {
		this.buffer = buffer;
	}

	/**
	 * @param fail the fail to set
	 */
	public void setFail(Class fail) {
		this.fail = fail;
	}

	/**
	 * @param history the history to set
	 */
	public void setHistory(Class history) {
		this.history = history;
	}

	/**
	 * @param suggest the suggest to set
	 */
	public void setSuggest(Class suggest) {
		this.suggest = suggest;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(String table) {
		this.table = table;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ObjectType type) {
		this.type = type;
	}
}
