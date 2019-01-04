package com.ai.sacenter.receive.teaminvoke.out.impl;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcCSV;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFRsRspMessage;


public class UpdcCSVImpl implements IUpdcCSV {
	protected final static Log log = LogFactory.getLog( UpdcCSVImpl.class );
	public UpdcCSVImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcCSV#orderReceive(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public RocketFRsRspMessage orderReceive(RocketFMessage fromRocket) throws RemoteException, Exception {
		RocketFRsRspMessage fromASK = null;
		try
		{
			fromASK = UpdbfsFactory.getIUpdcFSV().orderReceive( fromRocket );
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwExtend( exception );
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcCSV#orderReceiveAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public void orderReceiveAsyn(RocketFMessage fromMetaMX) throws RemoteException, Exception {
		try
		{
			UpdbfsFactory.getIUpdcFSV().orderReceiveAsyn( fromMetaMX );
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwExtend( exception );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcCSV#rocketReceive(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public RocketFRsRspMessage rocketReceive(RocketFMessage fromRocket) throws RemoteException, Exception {
		RocketFRsRspMessage fromASK = null;
		try
		{
			fromASK = UpdbfsFactory.getIUpdcFSV().rocketReceive( fromRocket );
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwExtend( exception );
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcCSV#rocketReceiveAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public void rocketReceiveAsyn(RocketFMessage fromRocket) throws RemoteException, Exception {
		try
		{
			UpdbfsFactory.getIUpdcFSV().rocketReceiveAsyn(fromRocket);
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwExtend( exception );
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcCSV#rocketCompleteAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public RocketFRsRspMessage rocketCompleteAsyn(RocketFMessage fromRocket) throws RemoteException, Exception {
		RocketFRsRspMessage fromRsRsp = null;
		try
		{
			fromRsRsp = UpdbfsFactory.getIUpdcFSV().rocketCompleteAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwExtend( exception );
		}
		finally{
			
		}
		return fromRsRsp;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcCSV#rabbitReceiveAsyn(com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage)
	 */
	public void rabbitReceiveAsyn(RocketFMessage fromRocket) throws RemoteException, Exception {
		try
		{
			UpdbfsFactory.getIUpdcFSV().rabbitReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwExtend( exception );
		}
		finally{
			
		}
	}
}
