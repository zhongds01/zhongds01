package com.ai.sacenter.servicefulfil.dao.interfaces;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.jdbc.HQSQLEntityBean;

/**
 * <p>Title: sacenter-zjcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê3ÔÂ29ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISFUpdcDAO {
	/**
	 * 
	 * @param fromTABLE
	 * @param fromREGION
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public long testID( String fromTABLE, String fromREGION ) throws SFException,Exception;
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList<HQSQLEntityBean> retrieve(ObjectType fromTYPE, String fromCond, java.util.HashMap<String, Object> fromPARAM) throws SFException, Exception;
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList<HQSQLEntityBean> retrieve(String fromTYPE, String fromCond, java.util.HashMap<String, Object> fromPARAM) throws SFException, Exception;
}
