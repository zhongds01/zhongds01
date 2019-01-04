package com.ai.sacenter.provision.mstp.impl;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.IUpfwmClientFactory;
import com.ai.sacenter.provision.mstp.IUpfwsxDefine;
import com.ai.sacenter.util.ReflectUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元客户端池化工厂</p>
 * <p>Copyright: Copyright (c) 2015-1-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmDefaultFactory extends DefaultUpfwmFactory implements IUpfwmClientFactory{
	private static final long serialVersionUID = 421540298235965198L;
	public UpfwmDefaultFactory(IUpfwsxDefine fromUpfwsx,
			org.dom4j.Element fromUpfgsm ) throws Exception {
		super( fromUpfwsx, fromUpfgsm );
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.impl.DefaultUpfwmFactory#configure(com.ai.sacenter.provision.mstp.IUpfwsxDefine, org.dom4j.Element)
	 */
	public void configure(IUpfwsxDefine fromUpfwsx, org.dom4j.Element fromUpfgsm) throws SFException, Exception {
		try 
		{
			UpfwmDefault.IUpfwmCauDefine fromNetWork;
			java.util.List fromCAU = fromUpfgsm.elements("impl-define");
			for (java.util.Iterator itera = fromCAU.iterator(); itera.hasNext();) {
				org.dom4j.Element aElement = (org.dom4j.Element) itera.next();
				fromNetWork = new UpfwmDefault.IUpfwmCauDefine( aElement );
				if( fromNetWork.getUSE() == false ) continue;
				NETWORK_.getNETWORK_().add( fromNetWork );
			}
		}
		finally {

		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.impl.DefaultUpfwmFactory#makeChannel()
	 */
	public IUpfwmClient makeChannel() throws SFException, Exception {
		IUpfwmClient fromClient = null;
		try 
		{
			fromClient = (IUpfwmClient) ReflectUtils.IReflect.invokeConstructor(
					CLIENT_, new Object[] { PLATFORM_, NETWORK_ });
		} 
		finally{

		}
		return fromClient;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.impl.DefaultUpfwmFactory#hbhbtChannel(com.ai.sacenter.provision.mstp.IUpfwmClient)
	 */
	public void hbhbtChannel(IUpfwmClient fromChannel) throws SFException, Exception {
		try
		{
			if( fromChannel != null ){ fromChannel.hbhbt(); }
		}
		finally {

		}
	}
		
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.impl.DefaultUpfwmFactory#destroyChannel(com.ai.sacenter.provision.mstp.IUpfwmClient)
	 */
	public void destroyChannel(IUpfwmClient fromChannel) throws SFException, Exception {
		try 
		{
			fromChannel.logout();
		}
		finally {

		}
	}
}
