package com.ai.sacenter.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.SFException;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.SystemUtils;
import com.asiainfo.appframe.ext.exeframe.tf.config.CfgTf;
import com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITfRegister;
import com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITransform;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: TF数据转移[目标表[服务开通],原表/历史表[调度框架]][路由中心未设置]</p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdbcSystemTfImpl extends UpdbcSystemImpl implements ITfRegister,ITransform {
	protected final static Log log = LogFactory.getLog( UpdbcSystemTfImpl.class );
	protected final static java.util.Map _graphics = new java.util.concurrent.ConcurrentHashMap();
	protected final static java.util.Map _center = new java.util.concurrent.ConcurrentHashMap();
	protected CfgTf CfgTfInfo = null;
	public UpdbcSystemTfImpl() {
		super();
	}

    /**
     * 
     * @param fromUpdbm
     * @throws SFException
     * @throws Exception
     */
	protected void _execute( java.util.HashMap fromUpdbm[] ) throws SFException,Exception{
		throw new java.lang.UnsupportedOperationException();
	}
	
	/**
	 * @return the CfgTfInfo
	 */
	public CfgTf getCfgTfInfo() {
		return CfgTfInfo;
	}

	/* (non-Javadoc)
	 * @see com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITfRegister#register(java.lang.String)
	 */
	public void register(String aCfgTfCode) {
		String aINDEX = ClassUtils.getINDEX( new String[]{"CFG_TF_$_",aCfgTfCode} );
		if( (CfgTfInfo = (CfgTf)_graphics.get( aINDEX ) ) == null ){
			synchronized ( _graphics ) {
				if( (CfgTfInfo = (CfgTf)_graphics.get( aINDEX ) ) == null ){
					java.util.Map fromCenter = null;
					try
					{
						_graphics.put( aINDEX , CfgTfInfo = SystemUtils.ICustom.getISTKCfgTf( aCfgTfCode ) );
						fromCenter = CenterUtils.ICustom.getAllRegion();
						if( fromCenter != null ) ClassUtils.IMerge.merge( fromCenter, _center );
					}
					catch( java.lang.Exception exception ){
						log.error( exception.getMessage(), exception );
						throw new java.lang.RuntimeException( exception.getMessage(), exception );
					}
					finally{
						if( fromCenter != null ){ fromCenter.clear(); fromCenter = null; }
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITransform#transform(java.util.HashMap[])
	 */
	public void transform(java.util.HashMap[] fromUpfwm) throws Exception {
		try
		{
			_execute( fromUpfwm );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		    throw exception;
		}
		finally{
			
		}
	}
}
