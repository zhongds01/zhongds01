package com.ai.sacenter.cache.redis;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.platform.bo.ISARespond;
import com.ai.sacenter.base.platform.bo.ISARespondRel;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元反馈层[基础配置]</p>
 * <p>Copyright: Copyright (c) 2015年9月29日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IIRespondCacheImpl extends ISystemCacheImpl {
	public IIRespondCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromRespond = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithRespond( fromRespond );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromRespond;
	}
	/**
	 * 结构化服务激活反馈组件
	 * @param fromRespond
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithRespond( java.util.HashMap fromRespond ) throws SFException,Exception{
		try
		{
			IPlatformTemplate.IUpffmsGroup fromGroup = null;
			java.util.List fromList = BasicFactory.getIUpffmSV().getIUpffmsOffer();
			for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
				ISARespond aRespond = (ISARespond)itera.next();
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_RESPOND, 
						new String[]{ aRespond.getPlatform() } );
				fromGroup = (IPlatformTemplate.IUpffmsGroup)fromRespond.get( fromINDEX );
				if( fromGroup == null ){
					fromRespond.put( fromINDEX, fromGroup = new IPlatformTemplate.IUpffmsGroup( aRespond ) );
				}
				fromGroup.mergeAsGroup( aRespond );
			}
			
			fromList = BasicFactory.getIUpffmSV().getIUpffmsCatalog();
			for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
				ISARespondRel aRespond = (ISARespondRel)itera.next();
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_RESPOND, 
						new String[]{ aRespond.getPlatform() } );
				fromGroup = (IPlatformTemplate.IUpffmsGroup)fromRespond.get( fromINDEX );
				if( fromGroup == null ){
					fromRespond.put( fromINDEX, fromGroup = new IPlatformTemplate.IUpffmsGroup( aRespond ) );
				}
				fromGroup.mergeAsGroup( aRespond );
			}
		}
		finally{
			
		}
	}
}
