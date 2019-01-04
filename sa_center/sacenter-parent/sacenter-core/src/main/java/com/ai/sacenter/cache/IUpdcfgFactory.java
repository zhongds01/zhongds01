package com.ai.sacenter.cache;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.interfaces.IDialect;
import com.ai.sacenter.cache.interfaces.IUpdcpmSRV;
import com.ai.sacenter.cache.interfaces.IBasicSRV;
import com.ai.sacenter.cache.interfaces.IUpffmSRV;
import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.module.model.ICacheConfigure;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 开通缓存服务工厂</p>
 * <p>Copyright: Copyright (c) 2015年9月27日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdcfgFactory {
	public IUpdcfgFactory() {
		super();
	}
	
	/**
	 * 缓存机制[基础配置]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IDialect getIUpdcfgSV() throws SFException,Exception{
		IDialect fromDialect = null;
		try
		{
			ICacheConfigure.ICacheRoute fromRoute = SFCacheFactory.getCache().hgetRoute();
			fromDialect = (IDialect)UpfsvcFactory.getService( fromRoute.getPERSISTENCE(), 
					IUpdcConst.IEnum.IInvoke.Singleton, 
					IDialect.class.getName(), 
					fromRoute.getPERSISTENCE() );
		}
		finally{
			
		}
		return fromDialect;
	}
	
	/**
	 * 公共基础[基础配置]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IBasicSRV getIBasicSV() throws SFException,Exception{
		return (IBasicSRV)UpfsvcFactory.getService( IBasicSRV.class );
	}
	
	/**
	 * 能力基础[基础配置]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpmSRV getIUpdcpmSV() throws SFException,Exception{
		return (IUpdcpmSRV)UpfsvcFactory.getService( IUpdcpmSRV.class );
	}
	
	/**
	 * 网元基础[基础配置]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpffmSRV getIUpffmSV() throws SFException,Exception{
		return (IUpffmSRV)UpfsvcFactory.getService( IUpffmSRV.class );
	}
}
