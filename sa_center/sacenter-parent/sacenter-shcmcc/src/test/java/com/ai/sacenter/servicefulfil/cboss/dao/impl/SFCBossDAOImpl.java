package com.ai.sacenter.servicefulfil.cboss.dao.impl;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.receive.custom.dbcp.ICustomDAOImpl;
import com.ai.sacenter.servicefulfil.cboss.dao.interfaces.ISFCBossDAO;
import com.ai.sacenter.util.OracleUtils;

/**
 * <p>Title: sacenter-zjcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê3ÔÂ29ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFCBossDAOImpl extends ICustomDAOImpl implements ISFCBossDAO {
	private final static Log log = LogFactory.getLog( SFCBossDAOImpl.class );
	public SFCBossDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.cboss.dao.interfaces.ISFCBossDAO#getIUpfgsmINDEX(java.util.HashMap[])
	 */
	public java.util.ArrayList getIUpfgsmINDEX(java.util.HashMap[] fromUpfwm) throws RemoteException, Exception {
		java.util.ArrayList fromINDEX = null;
		java.sql.Connection aTransaction = null;
		try
		{
			aTransaction = OracleUtils.getTransaction();
			if( log.isDebugEnabled() ) log.debug( aTransaction );
		}
		finally{
			if( aTransaction != null ){ aTransaction.close(); }
		}
		return fromINDEX;
	}
}
