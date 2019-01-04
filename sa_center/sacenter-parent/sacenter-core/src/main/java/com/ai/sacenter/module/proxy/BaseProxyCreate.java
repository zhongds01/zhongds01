package com.ai.sacenter.module.proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;


/**
 * @author Administrator
 * 基础代理
 */
public abstract class BaseProxyCreate extends UpdcEclipseImpl{
	private final static Log log = LogFactory.getLog( BaseProxyCreate.class );
	private static BlankProxyCreate INSTANCE = new BlankProxyCreate();
	private static java.util.Map _runtime_proxycreate = new java.util.concurrent.ConcurrentHashMap();
	public BaseProxyCreate() {
		super();
	}
	/**
	 * @return the iNSTANCE
	 */
	public static BlankProxyCreate getINSTANCE() {
		return BaseProxyCreate.INSTANCE;
	}
	/**
	 * 
	 * @param aServiceDefine
	 * @return
	 * @throws Exception
	 */
	public static BaseProxyCreate getINSTANCE( final IConfigDefine.IServiceDefine aServiceDefine ) throws Exception{
		BaseProxyCreate fromCREATE = null;
		IConfigDefine.IModuleDefine.IModuleIDefine.IDeputizeDefine fromCouple = null;
		try {
			fromCouple = IConfigDefine.getINSTANCE().getDeputize(
					IEnum.IModule.SERVICEFRAME,
					aServiceDefine.getIMPL_DEFINE().getINVOKE());
			if (fromCouple == null){
				ExceptionFactory.throwRuntime("IOS0011002", new String[]{ "SERVICEFRAME$"
						+ aServiceDefine.getIMPL_DEFINE().getINVOKE().toUpperCase() });
			}
			fromCREATE = (BaseProxyCreate)_runtime_proxycreate.get( fromCouple.getPROXY() );
			if( fromCREATE == null ){
				synchronized( _runtime_proxycreate ){
					fromCREATE = (BaseProxyCreate)_runtime_proxycreate.get( fromCouple.getPROXY() );
					if( fromCREATE == null ){
						_runtime_proxycreate.put( fromCouple.getPROXY() , fromCREATE = 
								(BaseProxyCreate)Class.forName( fromCouple.getPROXY() ).newInstance() );
					}
				}
			}
		} finally {

		}
		return fromCREATE;
	}
	/**
	 * 
	 * @param aServiceDefine
	 * @return
	 * @throws Exception
	 */
	public Object createService( final IConfigDefine.IServiceDefine aServiceDefine ) throws Exception{
		throw new java.lang.UnsupportedOperationException();
	}
	/**
	 * 
	 * @param aRemoteInterface
	 */
	public void finalizeService( Object aRemoteInterface ){
		throw new java.lang.UnsupportedOperationException();
	}
	/**
	 * @author Administrator
	 * 空代理
	 */
	public static class BlankProxyCreate extends BaseProxyCreate {
		protected static java.util.Map _runtime_singleton = new java.util.concurrent.ConcurrentHashMap();
	    public BlankProxyCreate() {
			super();
		}
		/**
		 * 
		 * @param fromTYPE 服务类型
		 * @param fromUUID 服务编码
		 * @return
		 */
		protected Object getService( String fromTYPE , String fromUUID ){
			Object fromJAVA = null;
			try {
				java.util.Map fromSingleton = UpfsvcManager.getMBean().getSingleton();
				String fromINDEX = ClassUtils.getINDEX(new String[] {
						IEnum.SVCPref, "_#_", fromTYPE.toUpperCase(), "_#_",
						fromUUID });
				fromJAVA = fromSingleton.get(fromINDEX);
			} finally {

			}
			return fromJAVA;
		}
		/**
		 * 
		 * @param fromTYPE
		 * @param fromUUID
		 * @param fromI
		 */
		protected void submitService( String fromTYPE , String fromUUID , Object fromImpl ){
			try {
				java.util.Map fromSingleton = UpfsvcManager.getMBean().getSingleton();
				String fromINDEX = ClassUtils.getINDEX(new String[] {
						IEnum.SVCPref, "_#_", fromTYPE.toUpperCase(), "_#_",
						fromUUID });
				if( log.isDebugEnabled() ) log.debug("updcframe proxy factory create interface resources " + fromINDEX);
				fromSingleton.put( fromINDEX , fromImpl );
				
			} finally {

			}
		}
		/**
		 * 
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		private Object[][] getProxyCreate( ) throws SFException,Exception{
			java.util.List fromCREATE = new java.util.ArrayList();
			try
			{
				IConfigDefine.IModuleDefine.IModuleIDefine.IDeputizeDefine fromCouple = null;
				java.util.Map fromSingleton = UpfsvcManager.getMBean().getSingleton();
				for( java.util.Iterator itera = fromSingleton.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					if( StringUtils.wildcardMatch( fromEntry.getKey().toString() ,IEnum.SVCPref+"_#_*" ) == false ) continue;
					String fromCol[] = StringUtils.wildcardArray( fromEntry.getKey().toString() , "_#_" );
					if( fromCol == null || fromCol.length <= 1 ) continue;
					if( ( fromCouple = IConfigDefine.getINSTANCE().getDeputize(IEnum.IModule.SERVICEFRAME, fromCol[1]) ) != null ){
						BaseProxyCreate fromSKEL = (BaseProxyCreate)_runtime_proxycreate.get( fromCouple.getPROXY() );
						fromCREATE.add( new Object[]{ fromEntry.getKey().toString(), fromSKEL, fromEntry.getValue() } );
					}
					else if ((fromCouple = IConfigDefine.getINSTANCE().getDeputize(IEnum.IModule.PLATFORMFRAME, fromCol[1])) != null ){
						BaseProxyCreate fromSKEL = (BaseProxyCreate)_runtime_proxycreate.get( fromCouple.getPROXY() );
						fromCREATE.add( new Object[]{ fromEntry.getKey().toString(), fromSKEL, fromEntry.getValue() } );
					}
				}
			}
			finally{
				
			}
			return (Object[][])fromCREATE.toArray( new Object[][]{} );
		}
		/**
		 * 
		 *
		 */
		public void finalizeService(){
			try {
				java.util.Map fromSingleton = UpfsvcManager.getMBean().getSingleton();
				Object fromCREATE[][] = getProxyCreate();
				for (int index = 0; index < fromCREATE.length; index++) {
					try {
						((BaseProxyCreate) fromCREATE[index][1])
								.finalizeService(fromCREATE[index][2]);
					} catch (java.lang.Exception aEXCEPTION) {
						log.error("updcframe proxy factory release interface resources ["
										+ fromCREATE[index][0] + "] exception",
								aEXCEPTION);
					}
					if (log.isDebugEnabled())
						log.debug("updcframe proxy factory release interface resources "
										+ fromCREATE[index][0]);
					fromSingleton.remove(fromCREATE[index][0]);
				}
			} catch (java.lang.Exception aEXCEPTION) {
				log.error("Which means that the release of local service through proxy resource exception module",aEXCEPTION);
			}
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.proxy.BaseProxyCreateUI#finalizeService(java.lang.Object)
		 */
		public void finalizeService(Object aRemoteInterface) {
			
		}
	}
	/**
	 * 
	 * <p>Title: zjcrm_java</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-4-4</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public interface IEnum{
    	public final static String SVCPref = "com.ai.sacenter.moduleframe";
    	public interface IModule{
    		public final static String PLATFORMFRAME = "PLATFORMFRAME";
    		public final static String SERVICEFRAME = "SERVICEFRAME";
    	}
    }
}
