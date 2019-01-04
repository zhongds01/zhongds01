package com.ai.sacenter.cache.redis;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.competence.bo.ISASubFlow;
import com.ai.sacenter.base.competence.bo.ISAWorkFlow;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务激活层[基础配置]</p>
 * <p>Copyright: Copyright (c) 2011-10-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IISubFlowCacheImpl extends ISystemCacheImpl {

	public IISubFlowCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromWORKFLOW = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithSubflow( fromWORKFLOW );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromWORKFLOW;
	}

	/**
	 * 
	 * @param fromWORKFLOW
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithSubflow( java.util.Map fromWORKFLOW ) throws SFException,Exception{
		java.util.List fromDelegate = null;
		try
		{
			fromDelegate = BasicFactory.getIUpdcpmSV().getIUpdbpmOffer();
			if( fromDelegate != null && fromDelegate.size() > 0 ){
				IProfessionalTemplate.IUpdbpmOffer fromOffer = null;
				for(java.util.Iterator itera = fromDelegate.iterator(); itera.hasNext(); ){
					ISAWorkFlow aWORKFLOW = (ISAWorkFlow)itera.next();
					fromOffer = new IProfessionalTemplate.IUpdbpmOffer( aWORKFLOW );
					String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_WORKFLOW, 
							new String[]{fromOffer.getID()});
					fromWORKFLOW.put( fromINDEX, fromOffer );
				}
				fromDelegate = BasicFactory.getIUpdcpmSV().getIUpdbpmCatalog();
				if( fromDelegate != null && fromDelegate.size() > 0 ){
					IProfessionalTemplate.IUpdbpelOffer fromCatalog = null;
					for( java.util.Iterator itera = fromDelegate.iterator(); itera.hasNext(); ){
						ISASubFlow fromSubFlow = (ISASubFlow)itera.next();
						String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_WORKFLOW,
								new String[] { fromSubFlow.getSubflow() });
						if ( fromWORKFLOW.containsKey( fromINDEX ) == false ) continue;
						fromCatalog = new IProfessionalTemplate.IUpdbpelOffer( fromSubFlow );
						((IProfessionalTemplate.IUpdbpmOffer) fromWORKFLOW.get(fromINDEX)).subscribe( fromCatalog );
						fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_BPELFLOW , 
								new String[]{ClassUtils.getINDEX( fromCatalog.getID() )});
						fromWORKFLOW.put( fromINDEX, fromCatalog );
					}
				}
			}
		}
		finally{
			if( fromDelegate != null ){ fromDelegate.clear(); fromDelegate = null;}
		}
	}
}
