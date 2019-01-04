package com.ai.sacenter.cache.impl;

import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.complex.cache.CacheFactory;
import com.ai.appframe2.complex.cache.ICache;
import com.ai.appframe2.complex.xml.XMLHelper;
import com.ai.appframe2.complex.xml.cfg.caches.Cache;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.SFCacheCluster;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.cache.interfaces.IDialect;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.module.model.ICacheConfigure;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 基于APP环境机制</p>
 * <p>Copyright: Copyright (c) 2015年9月29日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class DialectSystemImpl extends UpdcEclipseImpl implements IDialect {
	public DialectSystemImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IDialect#hgetAll(java.lang.Class)
	 */
	public java.util.HashMap hgetAll(Class fromCLASS) throws SFException, Exception {
		return CacheFactory.getAll( fromCLASS );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IDialect#hget(java.lang.Class, java.lang.String)
	 */
	public Object hget(Class fromCLASS, String fromKEY) throws SFException, Exception {
		return CacheFactory.get( fromCLASS, fromKEY );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IDialect#hexist(java.lang.Class, java.lang.String)
	 */
	public boolean hexist(Class fromCLASS, String fromKEY) throws SFException,Exception {
		return CacheFactory.containsKey( fromCLASS, fromKEY );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IDialect#hgetAll(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.Map)
	 */
	public java.util.ArrayList hgetAll(ObjectType fromTYPE, String fromCond, java.util.Map fromPARAM) throws SFException, Exception {
		java.util.ArrayList fromUpdfmx = null;
		try
		{
			SFCacheCluster.ICacheSlot __cacheslot__ = SFCacheFactory.getCache().hgetCluster( fromTYPE );
			if( __cacheslot__ == null || __cacheslot__.getEntity().size() <= 0 ){
				fromUpdfmx = HQSQLFactory.getOracle().retrieve(fromTYPE, fromCond, fromPARAM);
			}
			else{
				fromUpdfmx = new java.util.ArrayList();
				for( java.util.Iterator itera = __cacheslot__.getEntity().iterator(); itera.hasNext(); ){
					SFCacheCluster.ICacheEntity _cacheentity_ = (SFCacheCluster.ICacheEntity)itera.next();
					java.util.ArrayList _tables_ = HQSQLFactory.getOracle().retrieve( _cacheentity_.getTable(), fromTYPE, fromCond, fromPARAM );
					if( _tables_ != null && _tables_.size() > 0 ){ fromUpdfmx.addAll( _tables_ ); }
				}
			}
		}
		finally{
			
		}
		return fromUpdfmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IDialect#refreshGroup(java.lang.String)
	 */
	public void refreshGroup(String _group) throws SFException, Exception {
		java.util.Map fromGroup = null;
		try
		{
			ICacheConfigure.ICacheRoute fromRoute = null;
			fromGroup = SFCacheFactory.getConfgiure().getRoute( _group );
			Cache fromcache[] = XMLHelper.getInstance().getCaches().getCaches();
			for( int index = 0; fromcache != null && index < fromcache.length; index++ ){
				fromRoute = (ICacheConfigure.ICacheRoute)fromGroup.get( fromcache[index].getDataType() );
				ICache _cache = (ICache)CacheFactory._getCacheInstances().get( Class.forName( fromcache[index].getId() ) );
				if( fromRoute == null || _cache == null /*指定集群内无此缓存*/) continue;
				_cache.refresh();
				if( log.isErrorEnabled() ){ log.error( ExceptionFactory.getDefault().getLocal("com.ai.appframe2.complex.cache.job.refresh.succeed", 
						new String[] { _cache.getClass().getName() }));
				}
			}
		}
		finally{
			if( fromGroup != null ){ fromGroup.clear(); fromGroup = null; }
		}
	}

}
