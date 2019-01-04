package com.ai.sacenter.base.basic.service.impl;

import java.rmi.RemoteException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.basic.service.interfaces.IBaseSV;

/**
 * 
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012-3-30</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class BaseSVImpl implements IBaseSV {

	public BaseSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.IBaseSV#getDONE_CODE()
	 */
	public long getDONE_CODE() throws RemoteException, Exception {
		return BasicFactory.getIBaseDAO().getDONE_CODE();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.IBaseSV#getSysdate()
	 */
	public java.sql.Timestamp getSysdate() throws RemoteException, Exception {
		return BasicFactory.getIBaseDAO().getSysdate();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.IBaseSV#retrieveCount(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.HashMap)
	 */
	public int retrieveCount(ObjectType fromTYPE, 
			String fromCond,
			java.util.HashMap fromPARAM) throws RemoteException, Exception {
		return BasicFactory.getIBaseDAO().retrieveCount(fromTYPE, fromCond, fromPARAM);
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.IBaseSV#retrieve(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.HashMap, java.lang.String[], int, int)
	 */
	public DataStructInterface[] retrieve(ObjectType fromTYPE, 
			String fromCond,
			java.util.HashMap fromPARAM, 
			String[] fromCol, 
			int startRowIndex,
			int endRowIndex) throws RemoteException, Exception {
		return BasicFactory.getIBaseDAO().retrieve(fromTYPE, 
				fromCond, 
				fromPARAM, 
				fromCol, 
				startRowIndex, 
				endRowIndex);
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.IBaseSV#finish(com.ai.appframe2.common.DataContainerInterface[])
	 */
	public void finish(DataContainerInterface[] fromContain) throws RemoteException, Exception {
		BasicFactory.getIBaseDAO().finish( fromContain );
	}
}
