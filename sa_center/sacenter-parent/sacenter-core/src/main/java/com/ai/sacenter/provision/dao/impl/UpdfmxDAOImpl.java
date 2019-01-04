package com.ai.sacenter.provision.dao.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.provision.bo.ISAUatmix;
import com.ai.sacenter.provision.dao.interfaces.IUpdfmxDAO;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê10ÔÂ28ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdfmxDAOImpl extends ISystemDAOImpl implements IUpdfmxDAO {
	public UpdfmxDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpdfmxDAO#getPLMM_ID()
	 */
	public long getPLMM_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( ISAUatmix.S_TYPE.getMapingEnty() ).longValue();
	}

}
