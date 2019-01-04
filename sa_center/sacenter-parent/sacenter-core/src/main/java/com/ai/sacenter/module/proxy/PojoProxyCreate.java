package com.ai.sacenter.module.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.module.IUpdcLifeCycle;
import com.ai.sacenter.module.model.UpdcLifeCycle;

/**
 * @author Administrator
 * POJO代理
 */
public class PojoProxyCreate extends BaseProxyCreate.BlankProxyCreate {

	public PojoProxyCreate() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.module.proxy.BaseProxyCreateUI#createService(com.ai.sacenter.module.IConfigDefine.IServiceDefine)
	 */
	public Object createService(IConfigDefine.IServiceDefine aServiceDefine) throws SFException, Exception {
		return Class.forName( aServiceDefine.getIMPL_DEFINE().getIMPL_CLASS() ).newInstance();
	}
	/**
	 * @author Administrator
	 *  拦截器代理类
	 */
	public static class InterceptorProxyCreate extends BaseProxyCreate.BlankProxyCreate {
		
		public InterceptorProxyCreate() {
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.proxy.BaseProxyCreateUI#createService(com.ai.sacenter.module.IConfigDefine.IServiceDefine)
		 */
		public Object createService(IConfigDefine.IServiceDefine aServiceDefine) throws SFException, Exception {
			IConfigDefine.IServiceDefine.IImplInvokeDefine aImplDefine = (IConfigDefine.IServiceDefine.IImplInvokeDefine) aServiceDefine
					.getIMPL_DEFINE();
			Class fromCLASS = Class.forName(aServiceDefine.getINTERFACE());
			UpdcLifeCycle.InvokeHandler fromHandler = new UpdcLifeCycle.InvokeHandler(
					Class.forName(aImplDefine.getIMPL_CLASS()).newInstance(),
					(IUpdcLifeCycle.IInterceptor) Class.forName(
							aImplDefine.getINTERCEPTOR_CLASS()).newInstance());
			return Proxy.newProxyInstance(fromCLASS.getClassLoader(),
					new Class[] { fromCLASS }, fromHandler);
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 管理线程服务交易索引</p>
	 * <p>Copyright: Copyright (c) 2014-9-23</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class OptimizeProxyCreate extends BaseProxyCreate.BlankProxyCreate{
		public OptimizeProxyCreate(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.proxy.BaseProxyCreateUI#createService(com.ai.sacenter.module.IConfigDefine.IServiceDefine)
		 */
		public Object createService(IConfigDefine.IServiceDefine aServiceDefine) throws SFException, Exception {
			IConfigDefine.IServiceDefine.IImplDefine aImplDefine = (IConfigDefine.IServiceDefine.IImplDefine) aServiceDefine
					.getIMPL_DEFINE();
			Class fromCLASS = Class.forName(aServiceDefine.getINTERFACE());
			UpdcLifeCycle.InvokeHandler fromHandler = new UpdcLifeCycle.InvokeHandler(
					Class.forName(aImplDefine.getIMPL_CLASS()).newInstance(),
					(IUpdcLifeCycle.IInterceptor) OptimizeInterceptor.class
							.newInstance());
			return Proxy.newProxyInstance(fromCLASS.getClassLoader(),
					new Class[] { fromCLASS }, fromHandler);
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2013-3-13</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
	    public static class OptimizeInterceptor extends UpdcLifeCycle.Interceptor{
	    	public OptimizeInterceptor(){
	    		super();
	    	}
	    	/* (non-Javadoc)
			 * @see com.ai.sacenter.module.model.UpdcLifeCycle.Interceptor#beforeInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
			 */
			public void beforeInterceptor(Object INSTANCE, 
					Method METHOD, 
					Object[] objectArray) throws Exception {
				try {
					super.beforeInterceptor(INSTANCE, METHOD, objectArray);
				} finally {

				}
			}
			/* (non-Javadoc)
			 * @see com.ai.sacenter.module.model.UpdcLifeCycle.Interceptor#afterInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
			 */
			public void afterInterceptor(Object INSTANCE, Method METHOD, Object[] objectArray) throws Exception {
				try {
					super.afterInterceptor(INSTANCE, METHOD, objectArray);
					MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
					if (fromMBean != null)
						fromMBean.setCOMPLETE(new java.sql.Timestamp(System
								.currentTimeMillis()));
				} finally {

				}
			}
			/* (non-Javadoc)
			 * @see com.ai.sacenter.module.model.UpdcLifeCycle.Interceptor#exceptionInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Exception)
			 */
			public void exceptionInterceptor(Object INSTANCE, Method METHOD, Object[] objectArray, Exception aException) throws Exception {
				try {
					super.exceptionInterceptor(INSTANCE, METHOD, objectArray,
							aException);
					MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
					if (fromMBean != null) {
						fromMBean.setEXCEPTION( ExceptionFactory.getException(aException) );
						fromMBean.setCOMPLETE(new java.sql.Timestamp(System
								.currentTimeMillis()));
					}
				} finally {

				}
			}
	    }
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 管理线程变量以及服务交易索引</p>
	 * <p>Copyright: Copyright (c) 2013-3-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class PrimitiveProxyCreate extends BaseProxyCreate.BlankProxyCreate{
		public PrimitiveProxyCreate(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.proxy.BaseProxyCreateUI#createService(com.ai.sacenter.module.IConfigDefine.IServiceDefine)
		 */
		public Object createService(IConfigDefine.IServiceDefine aServiceDefine) throws SFException, Exception {
			IConfigDefine.IServiceDefine.IImplDefine aImplDefine = (IConfigDefine.IServiceDefine.IImplDefine) aServiceDefine
					.getIMPL_DEFINE();
			Class fromCLASS = Class.forName(aServiceDefine.getINTERFACE());
			UpdcLifeCycle.InvokeHandler fromHandler = new UpdcLifeCycle.InvokeHandler(
					Class.forName(aImplDefine.getIMPL_CLASS()).newInstance(),
					(IUpdcLifeCycle.IInterceptor) PrimitiveInterceptor.class
							.newInstance());
			return Proxy.newProxyInstance(fromCLASS.getClassLoader(),
					new Class[] { fromCLASS }, fromHandler);
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2013-3-13</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
	    public static class PrimitiveInterceptor extends UpdcLifeCycle.Interceptor{
	    	public PrimitiveInterceptor(){
	    		super();
	    	}

			/* (non-Javadoc)
			 * @see com.ai.sacenter.module.model.UpdcLifeCycle.Interceptor#beforeInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
			 */
			public void beforeInterceptor(Object INSTANCE, 
					Method METHOD, 
					Object[] objectArray) throws Exception {
				try {
					SFCenterFactory.pushCenterInfo();
					super.beforeInterceptor(INSTANCE, METHOD, objectArray);
					UpfsvcManager.getMBean().beginTransaction();
				} finally {

				}
			}

			/* (non-Javadoc)
			 * @see com.ai.sacenter.module.model.UpdcLifeCycle.Interceptor#afterInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
			 */
			public void afterInterceptor(Object INSTANCE, 
					Method METHOD, 
					Object[] objectArray) throws Exception {
				try {
					super.afterInterceptor(INSTANCE, METHOD, objectArray);
					MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
					if (fromMBean != null)
						fromMBean.setCOMPLETE(new java.sql.Timestamp(System
								.currentTimeMillis()));
					UpfsvcManager.getMBean().commitTransaction();
				} finally {

				}
			}

			/* (non-Javadoc)
			 * @see com.ai.sacenter.module.model.UpdcLifeCycle.Interceptor#exceptionInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], Exception)
			 */
			public void exceptionInterceptor(Object INSTANCE, 
					Method METHOD, 
					Object[] objectArray, 
					Exception aEXCEPTION) throws Exception {
				try {
					super.exceptionInterceptor(INSTANCE, METHOD, objectArray,
							aEXCEPTION);
					MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
					if (fromMBean != null) {
						fromMBean.setEXCEPTION( ExceptionFactory.getException(aEXCEPTION));
						fromMBean.setCOMPLETE(new java.sql.Timestamp(System
								.currentTimeMillis()));
					}
					UpfsvcManager.getMBean().rollbackTransaction();
				} finally {

				}
			}

			/* (non-Javadoc)
			 * @see com.ai.sacenter.module.model.UpdcLifeCycle.Interceptor#finallInterceptor(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
			 */
			public void finallInterceptor(Object INSTANCE, 
					Method METHOD, 
					Object[] objectArray) throws Exception {
				try {
					super.finallInterceptor(INSTANCE, METHOD, objectArray);
					if (UpfsvcManager.getMBean() != null)
						UpfsvcManager.finishMBean();
					SFCenterFactory.popCenterInfo();
				} finally {

				}
			}
	    }
	}
}
