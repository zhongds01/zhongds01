package com.ai.sacenter.cache.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.appframe2.complex.cache.impl.AbstractCache;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public abstract class ISystemCacheImpl extends AbstractCache {
	protected final static Log log = LogFactory.getLog( ISystemCacheImpl.class ); 
	public ISystemCacheImpl() {
		super();
	}
	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract java.util.HashMap getCache() throws Exception;
	
	/* (non-Javadoc)
	 * @see com.ai.appframe2.complex.cache.impl.AbstractCache#getData()
	 */
	public java.util.HashMap getData() throws Exception {
		return getCache();
	}
}
