package com.ai.sacenter.suggest.dao.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.suggest.bo.SASuggest;
import com.ai.sacenter.suggest.dao.interfaces.IUpfgxmDAO;

public class UpfgxmDAOImpl extends ISystemDAOImpl implements IUpfgxmDAO{

	public UpfgxmDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.dao.interfaces.IUpfgxmDAO#getPLMQ_ID()
	 */
	public long getPLMQ_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( SASuggest.S_TYPE.getMapingEnty() ).longValue();
	}

}
