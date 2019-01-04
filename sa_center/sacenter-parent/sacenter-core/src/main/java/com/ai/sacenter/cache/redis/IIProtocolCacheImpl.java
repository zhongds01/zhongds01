package com.ai.sacenter.cache.redis;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.platform.bo.SAProtocol;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;


/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元协议层[基础配置]</p>
 * <p>Copyright: Copyright (c) 2013-5-3</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IIProtocolCacheImpl extends ISystemCacheImpl {
	public IIProtocolCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromProtocol = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithProtocol( fromProtocol );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromProtocol;
	}
	/**
	 * 
	 * @param fromProtocol
	 * @throws SFException
	 * @throws Exception
	 */
	private void _wrapWithProtocol( java.util.Map fromProtocol ) throws SFException,Exception{
		java.util.List fromList = null;
		try
		{
			IPlatformTemplate.IUpffmProtocol fromPROTOCOL = null;
			fromList = BasicFactory.getIUpffmSV().getIUpffmProtocol();
			for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
				SAProtocol aProtocol = (SAProtocol)itera.next();
				fromPROTOCOL = new IPlatformTemplate.IUpffmProtocol( aProtocol );
				String aINDEX = ClassUtils.getINDEX(IUpdcConst.ICache.ICachePref.I_PLATFORM_PROTOCOL,
						new String[]{fromPROTOCOL.getID()});
				fromProtocol.put( aINDEX, fromPROTOCOL );
			}
		}
		finally{
			if( fromList != null ){ fromList.clear(); fromList = null;}
		}
	}
}
