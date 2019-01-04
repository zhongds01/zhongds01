package com.ai.sacenter.cache.redis;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.basic.bo.ISAI18nResource;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 开通其它层</p>
 * <p>Copyright: Copyright (c) 2017年5月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IIMultlesCacheImpl extends ISystemCacheImpl {
	public IIMultlesCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromMultle = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithResource( fromMultle );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromMultle;
	}
	
	/**
	 * 
	 * @param fromMultle
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithResource( java.util.HashMap fromMultle ) throws SFException,Exception{
		java.util.List fromList = null;
		try
		{
			ISystemTemplate.IUpfgkmResource fromResource = null;
			fromList = BasicFactory.getIBasicSV().getIUpfgkmResource();
			for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
				ISAI18nResource aResource = (ISAI18nResource)itera.next();
				fromResource = new ISystemTemplate.IUpfgkmResource( aResource );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_MULTLE_RESOURCE , 
						new String[]{fromResource.getCATEGORY(), fromResource.getCODE()} ); 
				fromMultle.put( fromINDEX, fromResource );
			}
		}
		finally{
			if( fromList != null ){ fromList.clear(); fromList = null; }
		}
	}
}
