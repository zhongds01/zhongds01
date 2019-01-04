package com.ai.sacenter.cache.redis;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.competence.bo.ISABusines;
import com.ai.sacenter.base.competence.bo.ISABusinesRel;
import com.ai.sacenter.base.competence.bo.ISABusinesX;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 开通接入层[基础配置]</p>
 * <p>Copyright: Copyright (c) 2013-4-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IIBusinesCacheImpl extends ISystemCacheImpl {

	public IIBusinesCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromUpdbm = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithBusines( fromUpdbm );
			_wrapWithBusinesX( fromUpdbm );
			_wrapWithBusinesRel( fromUpdbm );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromUpdbm;
	}
	/**
	 * 
	 * @param fromUpdbm
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithBusines( java.util.HashMap fromUpdbm ) throws SFException,Exception{
		try
		{
			IProfessionalTemplate.IBusinesOffer fromUpdcpm = null;
		    java.util.List fromBUSINES = BasicFactory.getIUpdcpmSV().getIUpdbfxBusines();
			for( java.util.Iterator itera = fromBUSINES.iterator(); itera.hasNext(); ){
				ISABusines aBusiness = (ISABusines)itera.next();
				fromUpdcpm = new IProfessionalTemplate.IBusinesOffer( aBusiness );
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_BUSINES , 
						new String[]{fromUpdcpm.getCATALOG(),  fromUpdcpm.getBUSINES(), 
								fromUpdcpm.getORIGINATE(), fromUpdcpm.getCATEGORY()});
				fromUpdbm.put( aINDEX, fromUpdcpm );
			}
		}
		finally{
			
		}
	}
	/**
	 * 
	 * @param fromUpdbm
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithBusinesX( java.util.HashMap fromUpdbm ) throws SFException,Exception{
		try
		{
			IProfessionalTemplate.IBusinesCombine fromGroup = null;
			IProfessionalTemplate.IBusinesKernel fromBusinesX = null;
		    java.util.List fromBUSINES = BasicFactory.getIUpdcpmSV().getIUpdbfxKernel();
			for( java.util.Iterator itera = fromBUSINES.iterator(); itera.hasNext(); ){
				ISABusinesX aBusiness = (ISABusinesX)itera.next();
				fromBusinesX = new IProfessionalTemplate.IBusinesKernel( aBusiness );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_BUSINES_KERNEL, 
						new String[]{ fromBusinesX.getPROGRAM() } );
				fromGroup = (IProfessionalTemplate.IBusinesCombine)fromUpdbm.get( fromINDEX );
				if( fromGroup == null ){
					fromUpdbm.put( fromINDEX, fromGroup = new IProfessionalTemplate.IBusinesCombine(
							fromBusinesX.getPROGRAM() ) );
				}
				fromGroup.getPROGRAM().put( fromBusinesX.getID(), fromBusinesX );
			}
		}
		finally{
			
		}
	}
	/**
	 * 
	 * @param fromUpdbm
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithBusinesRel( java.util.HashMap fromUpdbm ) throws SFException,Exception{
		try
		{
			IProfessionalTemplate.IBusinesCatalog fromBusines = null;
		    java.util.List fromBUSINES = BasicFactory.getIUpdcpmSV().getIUpdbfxCatalog();
			for( java.util.Iterator itera = fromBUSINES.iterator(); itera.hasNext(); ){
				ISABusinesRel aBusiness = (ISABusinesRel)itera.next();
				fromBusines = new IProfessionalTemplate.IBusinesCatalog( aBusiness );
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_BUSINES_COMPETE , 
						new String[]{fromBusines.getCATALOG(), 
						fromBusines.getBUSINES(), 
						fromBusines.getPRODUCT(),
						fromBusines.getCATEGORY()});
				fromUpdbm.put( aINDEX , fromBusines );
			}
		}
		finally{
			
		}
	}
	
}
