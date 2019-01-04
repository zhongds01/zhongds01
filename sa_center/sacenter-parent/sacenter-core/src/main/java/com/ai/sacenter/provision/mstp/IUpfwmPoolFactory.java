package com.ai.sacenter.provision.mstp;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.mstp.impl.DefaultUpfwmFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-1-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmPoolFactory extends GenericObjectPool implements IUpfwmPool, java.io.Serializable {
	private static final long serialVersionUID = 8333236358336691242L;
	private final static Log log = LogFactory.getLog( IUpfwmPoolFactory.class );
	private static java.util.Map _runtime_objectpool = new java.util.concurrent.ConcurrentHashMap();
	/*网路路由规范*/
	private IUpffmNetWork PLATFORM_;
	/*路由配置信息*/
	private IUpfwmDefine NETWORK_;
	/*全量参数清单*/
	private java.util.Map STUB_ = new java.util.HashMap();
	public IUpfwmPoolFactory(DefaultUpfwmFactory aFACTORY_, 
			IUpfwsxDefine fromUpfwsx ) throws Exception {
		super(aFACTORY_);
		for( java.util.Iterator itera = fromUpfwsx.getPOOL_().getSTUB_().entrySet().iterator() ; itera.hasNext() ; ){
			java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
			final Class propertyType = PropertyUtils.getPropertyType(this, aEntry.getKey().toString() );
            Object value = ConvertUtils.convert( aEntry.getValue().toString(), propertyType);
            PropertyUtils.setProperty(this, aEntry.getKey().toString(), value );
		}
		PLATFORM_ = aFACTORY_.getPLATFORM_();
		NETWORK_ = aFACTORY_.getNETWORK_();
        ClassUtils.IMerge.merge( fromUpfwsx.getSTUB_() , STUB_ );
	}
	/**
	 * 根据网元编号得到网元协议池
	 * @param fromUpffm
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfwmPool getUpdbcpPool(final IUpffmOffer fromUpffm ) throws SFException,Exception{
		IUpfwmPool fromUpfwmPool = null;
		try
		{
			IPlatformTemplate.IUpffmNetWork fromClient = UpfwmUtils.ISystem.getUpffmNetWork( fromUpffm );
			String _center_network = ClassUtils.getINDEX( new String[]{fromClient.getID(), "_$_", IUpdcConst.IEnum.ISschk.NULL } );
			fromUpfwmPool = (IUpfwmPoolFactory)_runtime_objectpool.get( _center_network );
			if( fromUpfwmPool == null ){
				synchronized ( _runtime_objectpool ) {
					if(( fromUpfwmPool = (IUpfwmPoolFactory)_runtime_objectpool.get( _center_network ) ) == null ){
						IUpfwsxDefine fromUpfwsx = new IUpfwsxDefine( fromClient );
						for( java.util.Iterator itera = fromUpfwsx.getNETWORK_().iterator(); itera.hasNext(); ){
							org.dom4j.Element aElement = (org.dom4j.Element)itera.next();
							DefaultUpfwmFactory aFACTORY_ = (DefaultUpfwmFactory)ReflectUtils.IReflect.invokeConstructor( 
									Class.forName( fromUpfwsx.getPOOL_().getFACTORY_() ) , new Object[]{fromUpfwsx , aElement } );
							String fromINDEX = ClassUtils.getINDEX( new String[]{fromClient.getID(),"_$_",aFACTORY_.getNETWORK_().getID_() } );
							_runtime_objectpool.put( fromINDEX , new IUpfwmPoolFactory( aFACTORY_ , fromUpfwsx ) );
						}
						if( log.isDebugEnabled() ) log.debug("initalize UpdbcpFactory[" + fromClient.getID() + "] successfully" );
						fromUpfwmPool = (IUpfwmPoolFactory)_runtime_objectpool.get( _center_network );
						if( fromUpfwmPool == null ) ExceptionFactory.throwRuntime("IOS0011011", new String[]{ fromUpffm.getID() } );
					}
				}
			}
		}
		finally{
			
		}
		return fromUpfwmPool;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmPool#getHBT()
	 */
	public boolean getHBT() {
		boolean fromHBT = false;
		try {
			String aCheckHbt = (String) ReflectUtils.xPath( "PLATFORM.HBHBT", STUB_);
			fromHBT = aCheckHbt != null && StringUtils.equalsIgnoreCase(aCheckHbt, "true") ? true: false;
		} 
		catch( java.lang.Exception aException ) {

		} 
		finally{

		}
		return fromHBT;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmPool#getNETWORK_()
	 */
	public IUpfwmDefine getNETWORK_() {
		return NETWORK_;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmPool#getPLATFORM_()
	 */
	public IUpffmNetWork getPLATFORM_() {
		return PLATFORM_;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmPool#getSTUB_()
	 */
	public java.util.Map getSTUB_() {
		return STUB_;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmPool#makeClient()
	 */
	public IUpfwmClient makeClient() throws SFException, Exception {
		IUpfwmClient fromClient = null;
		try 
		{
			fromClient = (IUpfwmClient) super.borrowObject();
			if (log.isDebugEnabled()) log.debug("ucmframe client through makeClient[" + PLATFORM_.getID() + "] successfully");
		} 
		catch (java.lang.Exception aException) {
			ExceptionFactory.throwIdle("IOS0012003", new String[] {
					PLATFORM_.getID(), NETWORK_.getID_() }, aException);
		}
		return fromClient;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmPool#returnClient(com.ai.sacenter.provision.mstp.IUpfwmClient)
	 */
	public void returnClient(IUpfwmClient fromClient) throws SFException, Exception {
		try 
		{
			if (log.isDebugEnabled()) log.debug("ucmframe client through returnObject[" + PLATFORM_.getID() + "] successfully");
			super.returnObject(fromClient);
		} 
		finally {

		}
	}
}
