package com.ai.sacenter.servicefulfil.dao.impl;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.provision.bo.ISANotifyIndex;
import com.ai.sacenter.servicefulfil.dao.interfaces.ISFUpdcDAO;

/**
 * <p>Title: sacenter-zjcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê3ÔÂ29ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpdcDAOImpl extends ISystemDAOImpl implements ISFUpdcDAO {
	public SFUpdcDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.dao.interfaces.ISFUpdcDAO#testID(java.lang.String, java.lang.String)
	 */
	public long testID(String fromTABLE, String fromREGION) throws SFException, Exception {
		return super.getSEQUENCE( fromTABLE, fromREGION ).longValue();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.dao.interfaces.ISFUpdcDAO#retrieve(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.HashMap)
	 */
	public java.util.ArrayList<HQSQLEntityBean> retrieve(ObjectType fromTYPE, String fromCond, java.util.HashMap<String, Object> fromPARAM) throws SFException, Exception {
		return HQSQLFactory.getMySQL5().retrieve( fromTYPE, fromCond, fromPARAM );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.dao.interfaces.ISFUpdcDAO#retrieve(String, java.lang.String, java.util.HashMap)
	 */
	public java.util.ArrayList<HQSQLEntityBean> retrieve(String fromTYPE, String fromCond, java.util.HashMap<String, Object> fromPARAM) throws SFException, Exception {
		return HQSQLFactory.getMySQL5().retrieve( fromTYPE, fromCond, fromPARAM );
	}
}
