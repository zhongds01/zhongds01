package com.ai.sacenter.core;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.core.service.interfaces.ISystemSRV;
import com.ai.sacenter.core.service.interfaces.ITaskSRV;
import com.ai.sacenter.core.service.interfaces.IUpdbpmSRV;
import com.ai.sacenter.core.service.interfaces.IUpdcmqSRV;
import com.ai.sacenter.core.service.interfaces.IUpdosSRV;
import com.ai.sacenter.core.service.interfaces.IUpdcpmSRV;
import com.ai.sacenter.core.service.interfaces.IUpdwfSRV;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务激活内部服务</p>
 * <p>Copyright: Copyright (c) 2011-10-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpdcFactory {

	public IUpdcFactory() {
		super();
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcmqSRV getIUpdcmqSV() throws SFException,Exception{
		return (IUpdcmqSRV)UpfsvcFactory.getService( IUpdcmqSRV.class );
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static ITaskSRV getITaskSV() throws SFException,Exception{
		return (ITaskSRV)UpfsvcFactory.getService( ITaskSRV.class );
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdwfSRV getIUpdwfSV() throws SFException,Exception{
		return (IUpdwfSRV)UpfsvcFactory.getService( IUpdwfSRV.class );
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static ISystemSRV getISystemSV() throws SFException,Exception{
		return (ISystemSRV)UpfsvcFactory.getService( ISystemSRV.class );
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdosSRV getIUpdosSV() throws SFException,Exception{
		return (IUpdosSRV)UpfsvcFactory.getService( IUpdosSRV.class );
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdbpmSRV getIUpdbpmSV() throws SFException,Exception{
		return (IUpdbpmSRV)UpfsvcFactory.getService( IUpdbpmSRV.class );
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpmSRV getIUpdcpmSV() throws SFException,Exception{
		return (IUpdcpmSRV)UpfsvcFactory.getService( IUpdcpmSRV.class );
	}
	/**
	 * 
	 * @param fromJAVA
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpmCapital getIUpdcpmSV( String fromJAVA ) throws SFException,Exception{
		return (IUpdcpmCapital)UpfsvcFactory.getService( fromJAVA , 
				IUpdcConst.IEnum.IInvoke.Singleton, 
				IUpdcpmCapital.class.getName(), 
				fromJAVA );
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdbpmCapital getIUpdbpmSV( String fromJAVA ) throws SFException,Exception{
		return (IUpdbpmCapital)UpfsvcFactory.getService( fromJAVA , 
				IUpdcConst.IEnum.IInvoke.Singleton, 
				IUpdbpmCapital.class.getName(), 
				fromJAVA );
	}
	/**
	 * 
	 * @param aID
	 * @param aTYPE
	 * @param aIInterface
	 * @param aIImpl
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static Object getIUpdcsSV(  String aID, 
			String aTYPE, 
			String aIInterface, 
			String aIImpl ) throws SFException,Exception{
		return UpfsvcFactory.getService(aID, aTYPE, aIInterface, aIImpl);
	}
	/**
	 * 
	 * @param aIMPL
	 * @param aTYPE
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static Object getIUpdcsSV( String aIMPL , String aTYPE ) throws SFException,Exception{
		return UpfsvcFactory.getService( aIMPL, aTYPE, aIMPL, aIMPL );
	}
}
