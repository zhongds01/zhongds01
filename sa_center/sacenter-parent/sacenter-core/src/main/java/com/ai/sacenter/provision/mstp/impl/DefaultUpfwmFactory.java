package com.ai.sacenter.provision.mstp.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool.BasePoolableObjectFactory;

import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.IUpfwmDefine;
import com.ai.sacenter.provision.mstp.IUpfwsxDefine;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

public class DefaultUpfwmFactory extends BasePoolableObjectFactory implements java.io.Serializable {
	private static final long serialVersionUID = 6537019801600442614L;
	protected final static Log log = LogFactory.getLog( DefaultUpfwmFactory.class );
	protected IUpffmNetWork PLATFORM_;
	protected IUpfwmDefine NETWORK_ = null;
	protected Class CLIENT_ = null;
	protected java.util.Map STUB_ = new java.util.HashMap();
	public DefaultUpfwmFactory(IUpfwsxDefine fromUpfwsx,
			org.dom4j.Element aContext ) throws Exception {
		super();
		PLATFORM_ = fromUpfwsx.getPLATFORM_();
		CLIENT_ = Class.forName(fromUpfwsx.getPOOL_().getCLIENT_());
		NETWORK_ = new IUpfwmDefine(fromUpfwsx, fromUpfwsx.getPLATFORM_(),
				aContext);
		configure(fromUpfwsx, aContext);
	}
	
	/**
	 * 初始化与服务端网路路由配置
	 * @param fromUpfwsx 网路配置
	 * @param fromUpfgsm 网路路由
	 * @throws SFException
	 * @throws Exception
	 */
	public void configure( IUpfwsxDefine fromUpfwsx,
			org.dom4j.Element fromUpfgsm ) throws SFException,Exception{
		
	}
	/**
	 * 创建与服务端通道
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfwmClient makeChannel() throws SFException,Exception{
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.pool.BasePoolableObjectFactory#makeObject()
	 */
	public Object makeObject() throws Exception {
		return makeChannel();
	}
	/**
	 * 与服务端通道心跳通信
	 * @param fromChannel 服务端通道
	 * @throws SFException
	 * @throws Exception
	 */
	public void hbhbtChannel(IUpfwmClient fromChannel) throws SFException,Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.pool.BasePoolableObjectFactory#validateObject(java.lang.Object)
	 */
	public boolean validateObject(Object fromChannel) {
		boolean fromHbhbt = true;
		try 
		{
		   IUpfwmClient fromClient = (IUpfwmClient) fromChannel;
			if (fromClient != null && fromClient.isClientReady()) {
				UpfsvcManager.getMBean().beginTransaction();
				try
				{
					hbhbtChannel(fromClient);
					UpfsvcManager.getMBean().commitTransaction();
				}
				catch( java.lang.Exception aEXCEPTION ){
					UpfsvcManager.getMBean().rollbackTransaction();
					throw aEXCEPTION;
				}
				finally{
					UpfsvcManager.finishMBean();
				}
				if (log.isDebugEnabled()) log.debug("ucmframe client through authentication[" + fromClient.getPLATFORM_().getID() + "]");
			}
		} 
		catch (java.lang.Exception aEXCEPTION) {
			if( log.isErrorEnabled() ) log.error( aEXCEPTION.getMessage() , aEXCEPTION );
			fromHbhbt = false;
		}
		finally{

		}
		return fromHbhbt;
	}
	
	/**
	 * 摧毁与服务端通道
	 * @param fromChannel 服务端通道
	 * @throws SFException
	 * @throws Exception
	 */
	public void destroyChannel(IUpfwmClient fromChannel) throws SFException,Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.pool.BasePoolableObjectFactory#destroyObject(java.lang.Object)
	 */
	public void destroyObject(Object fromChannel) throws Exception {
		try 
		{
			IUpfwmClient fromUpfwm = (IUpfwmClient)fromChannel;
			if( fromUpfwm != null && fromUpfwm.isClientReady() ){
				UpfsvcManager.getMBean().beginTransaction();
				try
				{
					destroyChannel(fromUpfwm);
					UpfsvcManager.getMBean().commitTransaction();
				}
				catch( java.lang.Exception aEXCEPTION ){
					UpfsvcManager.getMBean().rollbackTransaction();
					if( log.isErrorEnabled() ) log.error( aEXCEPTION.getMessage(), aEXCEPTION );
				}
				finally{
					UpfsvcManager.finishMBean();
				}
			}
			if (log.isDebugEnabled()) log.debug("ucmframe client through destroy[" + fromUpfwm.getPLATFORM_().getID() + "] successfully");
			super.destroyObject(fromUpfwm);
		} 
		finally {

		}
	}
	
	/**
	 * @return 网路路由
	 */
	public IUpfwmDefine getNETWORK_() {
		return NETWORK_;
	}

	/**
	 * @return 网路路由规范
	 */
	public IUpffmNetWork getPLATFORM_() {
		return PLATFORM_;
	}

	/**
	 * @return 扩展信息
	 */
	public java.util.Map getSTUB_() {
		return STUB_;
	}
}
