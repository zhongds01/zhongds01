package com.ai.sacenter.receive.teaminvoke.in.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.order.OrderFactory;
import com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpffmxSV;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê3ÔÂ9ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpffmxSVImpl extends UpdcEclipseImpl implements IUpffmxSV {
	public UpffmxSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpffmxSV#getROCKET_ID()
	 */
	public long getROCKET_ID() throws RemoteException, Exception {
		return OrderFactory.getIOrderDAO().getORDER_ID();
	}

}
