package com.ai.sacenter.provision.mstp.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.mstp.IUpfwsxDefine;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-1-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmSocketFactory extends UpfwmDefaultFactory{
	private static final long serialVersionUID = -7778315606923844459L;
	public UpfwmSocketFactory(IUpfwsxDefine fromUpfwsx, org.dom4j.Element fromUpfgsm)
			throws Exception {
		super(fromUpfwsx, fromUpfgsm);
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.impl.UpfwmDefaultFactory#configure(com.ai.sacenter.provision.mstp.IUpfwsxDefine, org.dom4j.Element)
	 */
	public void configure(IUpfwsxDefine fromUpfwsx, org.dom4j.Element fromUpfgsm) throws SFException, Exception {
		try {
			UpfwmSocket.IUpfwmSocketDefine fromNetWork;
			for (java.util.Iterator itera = fromUpfgsm.elements("impl-define")
					.iterator(); itera.hasNext();) {
				org.dom4j.Element aElement = (org.dom4j.Element) itera.next();
				fromNetWork = new UpfwmSocket.IUpfwmSocketDefine( aElement );
				if( fromNetWork.getUSE() == false ) continue;
				NETWORK_.getNETWORK_().add( fromNetWork );
			}
		} finally {

		}
	}
}
