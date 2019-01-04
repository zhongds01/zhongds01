package com.ai.sacenter.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.module.proxy.BaseProxyCreate;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.SystemUtils;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012-8-28</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfsvcFactory {
	private static final Log log = LogFactory.getLog(UpfsvcFactory.class);
	private static IServiceFactory DEFAULT_FACTORY = null;
	private static boolean INITALIZE = false;
	static{
		try{
			DEFAULT_FACTORY = new ServiceFactoryImpl();	
			UpfsvcFactory.initial();
		}
		finally{
			
		}
	}
	public UpfsvcFactory() {
		super();
	}
	/***
	 * 
	 * @throws Exception
	 */
	public static void initial(){
		try
		{
			if ( INITALIZE == false ){
				synchronized (UpfsvcFactory.class) {
					if ( INITALIZE == true ) return;
					INITALIZE = true;
					IConfigDefine.getINSTANCE();
		    		SystemUtils.ISystem.initialize( IConfigDefine.getINSTANCE() );
			        if (log.isDebugEnabled()) log.debug("initialization environment - template engine successfully");
		      }
		  }
		}
		catch( java.lang.Exception tt){
			ExceptionFactory.throwRuntime("IOS0010003", new String[]{}, tt);
		}
		finally{
			
		}
	}
	/***
	 * 
	 * @param aServiceId
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static Object getService( String aServiceId ) throws SFException,Exception{
		return DEFAULT_FACTORY.getService( aServiceId );
	}
	/**
	 * 
	 * @param aIInterface
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static Object getService( Class aIInterface ) throws SFException,Exception{
		return DEFAULT_FACTORY.getService( aIInterface );
	}
	/**
	 * 
	 * @param aIInterface
	 * @param aType
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static Object getService( Class aIInterface , String aType ) throws SFException,Exception{
		return DEFAULT_FACTORY.getService(aIInterface, aType);
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
	public static Object getService( String aID,
			String aTYPE ,
			String aIInterface,
			String aIImpl ) throws SFException,Exception{
		return DEFAULT_FACTORY.getService(aID, aTYPE, aIInterface, aIImpl);
	}
	/**
	 * @author Administrator
	 *
	 */
	public interface IServiceFactory {
		/***
		 * 
		 * @param aServiceID
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public Object getService( String aServiceID ) throws SFException,Exception;
		/**
		 * 
		 * @param aIInterface
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public Object getService( Class aIInterface ) throws SFException,Exception;
		/**
		 * 
		 * @param aIInterface
		 * @param aType
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public Object getService( Class aIInterface , 
				String aType ) throws SFException,Exception;
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
		public Object getService( String aID,
				String aTYPE ,
				String aIInterface,
				String aIImpl ) throws SFException,Exception;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-3-14</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ServiceFactoryImpl implements IServiceFactory{
		public ServiceFactoryImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdsvcFactory.IServiceFactory#getService(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
		 */
		public Object getService(String aID, String aTYPE, String aIInterface, String aIImpl) throws SFException, Exception {
			Object fromImpl = null;
			try
			{
				IConfigDefine.IServiceDefine aServiceDefine = IConfigDefine.getINSTANCE().getServiceDefine(aID, 
						aTYPE, 
						aIInterface, 
						aIImpl);
				fromImpl = BaseProxyCreate.getINSTANCE( aServiceDefine ).createService( aServiceDefine );
			}
			finally{
				
			}
			return fromImpl;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdsvcFactory.IServiceFactory#getService(java.lang.Class)
		 */
		public Object getService(Class aIInterface) throws SFException, Exception {
			Object fromImpl = null;
			try
			{
				IConfigDefine.IServiceDefine aServiceDefine = IConfigDefine.getINSTANCE().getServiceDefine( aIInterface );
				fromImpl = BaseProxyCreate.getINSTANCE( aServiceDefine ).createService( aServiceDefine );
			}
			finally{
				
			}
			return fromImpl;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdsvcFactory.IServiceFactory#getService(java.lang.Class, java.lang.String)
		 */
		public Object getService(Class aIInterface, String aType) throws SFException, Exception {
			Object fromImpl = null;
			try
			{
				String aIImpl = ClassUtils.IClass.getSVImpl( aIInterface ).getName();
				IConfigDefine.IServiceDefine aServiceDefine = IConfigDefine.getINSTANCE().getServiceDefine(aIInterface.getName(), 
						aType, 
						aIInterface.getName(), 
						aIImpl);
				fromImpl = BaseProxyCreate.getINSTANCE( aServiceDefine ).createService( aServiceDefine );
			}
			finally{
				
			}
			return fromImpl;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpdsvcFactory.IServiceFactory#getService(java.lang.String)
		 */
		public Object getService(String aServiceID) throws SFException, Exception {
			Object fromImpl = null;
			try
			{
				IConfigDefine.IServiceDefine aServiceDefine = IConfigDefine.getINSTANCE().getServiceDefine( aServiceID );
				fromImpl = BaseProxyCreate.getINSTANCE(aServiceDefine).createService(aServiceDefine);
			}
			finally{
				
			}
			return fromImpl;
		}
	}
}
