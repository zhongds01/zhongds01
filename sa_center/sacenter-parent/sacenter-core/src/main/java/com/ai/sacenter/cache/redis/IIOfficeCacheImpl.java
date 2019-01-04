package com.ai.sacenter.cache.redis;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.platform.bo.ISAOffice;
import com.ai.sacenter.base.platform.bo.ISAPhone;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 即开即通号段清单缓存   局向</p>
 * <tables><id>I_LOGICAL</id><table>I_OPEN_LOGICAL</table></tables>
 * <tables><id>I_MSISDN</id><table>I_OPEN_ACCOUNT</table></tables>
 * <p>Copyright: Copyright (c) 2012-2-4</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IIOfficeCacheImpl extends ISystemCacheImpl {

	public IIOfficeCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromOffice = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithOffice( fromOffice );
			_wrapWithPhone( fromOffice );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromOffice;
	}
	/**
	 * 
	 * @param fromOffice
	 * @throws SFException
	 * @throws Exception
	 */
	private void _wrapWithOffice( java.util.HashMap fromOffice ) throws SFException,Exception{
		java.util.List fromNUMBER = null;
		try
		{
			ISystemTemplate.IUpfgkmOffice fromSection = null;
			fromNUMBER = BasicFactory.getIUpffmSV().getIUpffmOffice();
			for( java.util.Iterator itera = fromNUMBER.iterator() ; itera.hasNext(); ){
				ISAOffice aOffice = (ISAOffice)itera.next();
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_OFFICE_SECTION, 
						new String[]{aOffice.getHeadnum(), aOffice.getCategory() } ); 
				fromSection = (ISystemTemplate.IUpfgkmOffice)fromOffice.get( fromINDEX );
				if( fromSection == null ){
					fromOffice.put( fromINDEX, fromSection = new ISystemTemplate.IUpfgkmOffice( aOffice ) );
				}
				fromSection.mergeAsOffice( aOffice );
			}
		}
		finally{
			if( fromNUMBER != null ){ fromNUMBER.clear(); fromNUMBER = null;}
		}
	}
	/**
	 * 
	 * @param fromLogical
	 * @throws SFException
	 * @throws Exception
	 */
	private void _wrapWithPhone( java.util.HashMap fromLogical ) throws SFException,Exception{
		java.util.List fromNUMBER = null;
		try
		{
			IPlatformTemplate.IUpffmPhone fromUpffms = null;
			fromNUMBER = BasicFactory.getIUpffmSV().getIUpffmPhone();
			for( java.util.Iterator itera = fromNUMBER.iterator() ; itera.hasNext(); ){
				ISAPhone aPhone = (ISAPhone)itera.next();
				fromUpffms = new IPlatformTemplate.IUpffmPhone( aPhone );
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_OFFICE_PHONE, new String[]{
						fromUpffms.getID(),fromUpffms.getPLATFORM()} );
				fromLogical.put( aINDEX , fromUpffms );
			}
		}
		finally{
			if( fromNUMBER != null ){ fromNUMBER.clear(); fromNUMBER = null;}
		}
	}
}
