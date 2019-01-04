package com.ai.sacenter.module.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.IUpdcLifeCycle;
import com.ai.sacenter.module.IConfigDefine.IModuleDefine;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012-9-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdcLifeCycle extends UpdcEclipseImpl
    implements IUpdcLifeCycle {
	public UpdcLifeCycle() {
		super();
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.module.IUpdcLifeCycle#initalize(com.ai.sacenter.module.IConfigDefine.IModuleDefine.IModuleIDefine.IInitalizeDefine)
	 */
	public void initalize(IModuleDefine.IModuleIDefine.IInitalizeDefine aInitalize) throws Exception {
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2012-9-19</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class InvokeHandler implements InvocationHandler {
		private Object _INSTANCE = null;
	    private IInterceptor _INTERCEPTOR = null;
		public InvokeHandler( Object instance, IInterceptor interceptor ) {
			super();
			_INSTANCE = instance;
			_INTERCEPTOR = interceptor;
		}
		/* (non-Javadoc)
		 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
		 */
		public Object invoke(Object proxy, Method method, Object[] args) throws java.lang.Exception{
			Object rtn = null;
			try {
				if (_INTERCEPTOR != null)
					_INTERCEPTOR.beforeInterceptor(_INSTANCE, method, args);
				rtn = method.invoke(_INSTANCE, args);
				if (_INTERCEPTOR != null)
					_INTERCEPTOR.afterInterceptor(_INSTANCE, method, args);
			} catch (java.lang.Exception tt) {
				if (_INTERCEPTOR != null)
					_INTERCEPTOR.exceptionInterceptor(_INSTANCE, method, args,
							tt);
				ExceptionFactory.throwPrimitive(tt);
			} finally {
				if (_INTERCEPTOR != null)
					_INTERCEPTOR.finallInterceptor(_INSTANCE, method, args);
			}
			return rtn;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2012-12-29</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class Interceptor extends UpdcEclipseImpl implements IInterceptor{
		public Interceptor(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.IUpdcLifeCycle.IInterceptor#exceptionInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], Exception)
		 */
		public void exceptionInterceptor(Object INSTANCE, 
				Method METHOD, 
				Object[] objectArray, 
				Exception aException) throws Exception {
			
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.IUpdcLifeCycle.IInterceptor#finallInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
		 */
		public void finallInterceptor(Object INSTANCE, 
				Method METHOD, 
				Object[] objectArray) throws Exception {
			
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.IUpdcLifeCycle.IInterceptor#afterInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
		 */
		public void afterInterceptor(Object INSTANCE, 
				Method METHOD, 
				Object[] objectArray) throws Exception {
			
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.IUpdcLifeCycle.IInterceptor#beforeInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
		 */
		public void beforeInterceptor(Object INSTANCE, 
				Method METHOD, 
				Object[] objectArray) throws Exception {
			
		}
		
	}
}
