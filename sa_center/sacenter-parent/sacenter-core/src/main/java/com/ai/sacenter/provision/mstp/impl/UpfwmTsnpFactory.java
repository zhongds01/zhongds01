package com.ai.sacenter.provision.mstp.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.mstp.IUpfwsxDefine;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-3-6</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmTsnpFactory extends UpfwmHttpFactory {
	private static final long serialVersionUID = -7005744050216647674L;
	public UpfwmTsnpFactory(IUpfwsxDefine fromUpfwsx, org.dom4j.Element fromUpfgsm)
			throws Exception {
		super(fromUpfwsx, fromUpfgsm);
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.impl.UpfwmHttpFactory#configure(com.ai.sacenter.provision.mstp.IUpfwsxDefine, org.dom4j.Element)
	 */
	public void configure(IUpfwsxDefine fromUpfwsx, org.dom4j.Element fromUpfgsm) throws SFException, Exception {
		try {
			UpfwmTsnpClient.IUpfwmTsnpDefine fromNetWork;
			for (java.util.Iterator itera = fromUpfgsm.elements("impl-define")
					.iterator(); itera.hasNext();) {
				org.dom4j.Element aElement = (org.dom4j.Element) itera.next();
				fromNetWork = new UpfwmTsnpClient.IUpfwmTsnpDefine( aElement );
				if( fromNetWork.getUSE() == false ) continue;
				NETWORK_.getNETWORK_().add( fromNetWork );
			}
		} finally {

		}
	}

}
