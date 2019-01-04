package com.ai.sacenter.cache.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.SFCacheCluster;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.cache.SFRedisCluster;
import com.ai.sacenter.cache.SFRedisFactory;
import com.ai.sacenter.cache.interfaces.IDialect;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.util.JSONUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê7ÔÂ19ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class RedisClusterImpl extends DialectSystemImpl implements IDialect {
	private final static Log log = LogFactory.getLog( RedisClusterImpl.class );
	public RedisClusterImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IDialectRDO#hgetAll(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.Map)
	 */
	public java.util.ArrayList hgetAll(ObjectType fromTYPE, 
			String fromCond, 
			java.util.Map fromPARAM) throws SFException, Exception {
		java.util.ArrayList fromLaten = new java.util.ArrayList();
		SFCacheCluster _cachecluster = null;
		try
		{
			class CacheClusterImpl{
				public CacheClusterImpl(){
					super();
				}
				
				/**
				 * 
				 * @param _jsonarray
				 * @param _laten
				 * @throws SFException
				 * @throws Exception
				 */
				public void transferAsJSON( java.util.ArrayList _jsonarray, 
						ObjectType _objecttype,
						java.util.ArrayList _laten ) throws SFException,Exception{
					try
					{
						for( java.util.Iterator itera = _jsonarray.iterator(); itera.hasNext(); ){
							String _jsonString = (String)itera.next();
							_laten.add( JSONUtils.fromBean(_jsonString, _objecttype ) );
						}
					}
					finally{
						
					}
				}
			}
			CacheClusterImpl fromClusterImpl = new CacheClusterImpl();
			SFRedisCluster fromRedisCluster = null;
			try
			{
				SFCacheFactory.ICacheDeque fromDeque = SFCacheFactory.getDeque().getLaten();
				_cachecluster = SFCacheFactory.getCache().hgetCluster( fromDeque.getGroup(), fromTYPE );
				SFCacheCluster.IClusterSlot _clusterslot = _cachecluster.getClustSlot( fromDeque.getGroup() );
				fromRedisCluster = SFRedisFactory.createCluster( _clusterslot.getCluster() );
				SFCacheCluster.ICacheSlot fromCacheSlot  = _clusterslot.getSlot( fromDeque.getGroup() );
				for( java.util.Iterator itera = fromCacheSlot.getEntity().iterator(); itera.hasNext(); ){
					SFCacheCluster.ICacheEntity fromEntity = (SFCacheCluster.ICacheEntity)itera.next();
					java.util.ArrayList _laten = null;
					try
					{
						_laten = fromRedisCluster.getAll( fromEntity.getCache() );
						fromClusterImpl.transferAsJSON(_laten, fromTYPE, fromLaten);
					}
					finally{
						if( _laten != null ){ _laten.clear(); _laten = null; }
					}
				}
			}
			finally{
				if( fromRedisCluster != null ) { SFRedisFactory.returnCluster( fromRedisCluster ); }
				if( fromClusterImpl != null ){ fromClusterImpl = null; }
			}
			
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
			fromLaten = HQSQLFactory.getOracle().retrieve(fromTYPE, 
					fromCond, 
					fromPARAM);
		}
		finally{
			if( _cachecluster != null ){ _cachecluster = null; }
		}
		return fromLaten;
	}
}
