package com.ai.sacenter.module.proxy;

import com.ai.sacenter.SFException;
import com.ai.sacenter.module.IConfigDefine;


/**
 * @author Administrator
 * 单例模式代理
 */
public class SingletonProxyCreate extends PojoProxyCreate {

	public SingletonProxyCreate() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.module.proxy.BaseProxyCreateUI#createService(com.ai.sacenter.module.IConfigDefine.IServiceDefine)
	 */
	public Object createService(IConfigDefine.IServiceDefine aServiceDefine) throws SFException, Exception {
		if( _runtime_singleton.containsKey( aServiceDefine.getID() ) == false ){
			_runtime_singleton.put( aServiceDefine.getID() , super.createService(aServiceDefine) );
		}
		return _runtime_singleton.get( aServiceDefine.getID() );
	}

	/**
	 * @author Administrator
	 * 线程单例
	 */
	public static class SingletonTProxyCreate extends PojoProxyCreate {

		public SingletonTProxyCreate() {
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.proxy.POJOProxyCreate#createService(com.ai.sacenter.module.IConfigDefine.IServiceDefine)
		 */
		public Object createService(IConfigDefine.IServiceDefine aServiceDefine) throws SFException, Exception {
			Object aSingleton = super.getService( aServiceDefine.getIMPL_DEFINE().getINVOKE() , aServiceDefine.getID() );
			if( aSingleton == null ){
				aSingleton = super.createService(aServiceDefine);
				super.submitService( aServiceDefine.getIMPL_DEFINE().getINVOKE() , aServiceDefine.getID() , aSingleton);
			}
			return aSingleton;
		}
	}
}
