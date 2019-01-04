package com.ai.sacenter.cache.redis;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.competence.bo.ISACompetence;
import com.ai.sacenter.base.competence.bo.ISACompetenceRel;
import com.ai.sacenter.base.competence.bo.ISAComptel;
import com.ai.sacenter.base.competence.bo.ISAComptelRel;
import com.ai.sacenter.base.competence.bo.ISAComptelX;
import com.ai.sacenter.base.competence.bo.ISAProduct;
import com.ai.sacenter.base.competence.bo.ISAProductRel;
import com.ai.sacenter.base.competence.bo.ISAProductX;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 开通能力[基础配置]</p>
 * <p>Copyright: Copyright (c) 2014-3-31</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IICompetenceCacheImpl extends ISystemCacheImpl {

	public IICompetenceCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromCOMPETENCE = new java.util.HashMap();
		IUpdcpOfferImpl fromOfferImpl = new IUpdcpOfferImpl();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithProduct( fromCOMPETENCE, fromOfferImpl );
			_wrapWithProductCombine( fromCOMPETENCE, fromOfferImpl );
			_wrapWithCompetence( fromCOMPETENCE, fromOfferImpl );
			_wrapWithComptelBusines( fromCOMPETENCE, fromOfferImpl );
			_wrapWithComptelProperty( fromCOMPETENCE, fromOfferImpl );
			_wrapWithComptelKernel( fromCOMPETENCE, fromOfferImpl );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			if( fromOfferImpl != null ){fromOfferImpl = null;}
		}
		return fromCOMPETENCE;
	}
	/**
	 * 结构化服务能力模板
	 * @param fromCOMPETENCE
	 * @param fromOfferImpl
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithCompetence(java.util.HashMap fromCOMPETENCE, 
			IUpdcpOfferImpl fromOfferImpl ) throws SFException,Exception{
		try
		{
			java.util.List fromCatalog = BasicFactory.getIUpdcpmSV().getIUpdcpmOffer();
			if( fromCatalog != null && fromCatalog.size() > 0 ){
				IProfessionalTemplate.ICompetenceBusines fromOffer = null;
				for( java.util.Iterator itera = fromCatalog.iterator(); itera.hasNext(); ){
					ISACompetence aCompetence = (ISACompetence)itera.next();
					fromOffer = new IProfessionalTemplate.ICompetenceBusines( aCompetence );
					String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_TEMPLATE, 
							new String[]{fromOffer.getID()} );
					fromCOMPETENCE.put( fromINDEX, fromOffer );
				}
			}
			
			fromCatalog = BasicFactory.getIUpdcpmSV().getIUpdcpmCatalog();
			if( fromCatalog != null && fromCatalog.size() > 0 ){
				IProfessionalTemplate.ICompetenceBusines fromBusines = null;
				for( java.util.Iterator itera = fromCatalog.iterator(); itera.hasNext(); ){
					ISACompetenceRel aCompetence = (ISACompetenceRel)itera.next();
					String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_TEMPLATE, 
							new String[]{ aCompetence.getCompetence() } );
					fromBusines = (IProfessionalTemplate.ICompetenceBusines)fromCOMPETENCE.get( fromINDEX );
					if( fromBusines != null ){ fromBusines.mergeAsGroup( aCompetence ); }
				}
			}
			
		}
		finally{
			
		}
	}
	/**
	 * 结构化服务产品单元
	 * @param fromCOMPETENCE
	 * @param fromOfferImpl
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithProduct( java.util.HashMap fromCOMPETENCE, 
			IUpdcpOfferImpl fromOfferImpl ) throws SFException,Exception{
		try
		{
			/*转入服务产品配置*/
			fromOfferImpl.finishSFProductLoad( fromCOMPETENCE );
			if( fromOfferImpl.getMODULE() != null && fromOfferImpl.getPRODUCT().size() > 0 ){
				IProfessionalTemplate.IProductOffer fromUpdcpm = null;
				for( java.util.Iterator itera = fromOfferImpl.getPRODUCT().values().iterator(); itera.hasNext(); ){
					fromUpdcpm = (IProfessionalTemplate.IProductOffer)itera.next();
					String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_PRODUCT_BASIC, 
							new String[]{fromUpdcpm.getID() } );
					fromCOMPETENCE.put( fromINDEX , fromUpdcpm );
					
					fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_COMPETENCE_PRODUCT_COMPTEL, 
							new String[]{fromUpdcpm.getCOMPETE() } );
					fromCOMPETENCE.put( fromINDEX , fromUpdcpm );
				}
			}
		}
		finally{
			
		}
	}
	/**
	 * 结构化服务产品单元关联
	 * @param fromCOMPETENCE
	 * @param fromOfferImpl
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithProductCombine( java.util.HashMap fromCOMPETENCE, 
			IUpdcpOfferImpl fromOfferImpl ) throws SFException,Exception{
		java.util.List fromUpdbm  = null;
		try
		{
			fromUpdbm = BasicFactory.getIUpdcpmSV().getIProductCatalog();
			if( fromUpdbm != null && fromUpdbm.size() > 0 ){
				IProfessionalTemplate.IProductCombine fromCombine = null;
				IProfessionalTemplate.IProductCatalog fromCatalog = null;
				IProfessionalTemplate.IProductGroup fromGroup = null;
				for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
					ISAProductRel aProduct = (ISAProductRel)itera.next();
					fromCatalog = new IProfessionalTemplate.IProductCatalog( aProduct );
					
					String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.
							I_COMPETENCE_PRODUCT_COMBINE, new String[]{fromCatalog.getCATEGORY(), 
							fromCatalog.getPRODUCT_ID() } );
					fromCombine = (IProfessionalTemplate.IProductCombine)fromCOMPETENCE.get( fromINDEX );
					if( fromCombine == null ){
						fromCOMPETENCE.put( fromINDEX, fromCombine = 
								new IProfessionalTemplate.IProductCombine( fromCatalog ) );
					}
					fromCombine.addCOMBINE( fromCatalog );
					
					fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.
							I_COMPETENCE_PRODUCT_GROUP, new String[]{ fromCatalog.getPRODUCT_ID() } );
					fromGroup = (IProfessionalTemplate.IProductGroup)fromCOMPETENCE.get( fromINDEX );
					if( fromGroup == null ){
						fromCOMPETENCE.put( fromINDEX, fromGroup = 
								new IProfessionalTemplate.IProductGroup( aProduct ) );
					}
					fromGroup.addGROUP( fromCatalog );
				}
			}
		}
		finally{
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
		}
	}
	/**
	 * 结构化服务业务能力共享
	 * @param fromCOMPETENCE
	 * @param fromOfferImpl
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithComptelBusines( java.util.HashMap fromCOMPETENCE, 
			IUpdcpOfferImpl fromOfferImpl ) throws SFException,Exception{
		java.util.List fromUpdbm  = null;
		try
		{
			fromUpdbm = BasicFactory.getIUpdcpmSV().getIComptelOffer();
			if( fromUpdbm != null && fromUpdbm.size() > 0 ){
				IProfessionalTemplate.IProductOffer fromUpdcpm = null;
				IProfessionalTemplate.IComptelOffer fromCatalog = null;
				for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
					ISAComptel aCompetence = (ISAComptel)itera.next();
					fromCatalog = new IProfessionalTemplate.IComptelOffer( aCompetence );
					fromUpdcpm = fromOfferImpl.getPRODUCT( fromCatalog.getBUSINES() );
					if( fromUpdcpm != null ){
						fromUpdcpm.getSUBFLOW().add(  new IProfessionalTemplate.IUpdbfgsmOffer( 
							fromCatalog, 
							fromOfferImpl.getPRODUCT( fromCatalog.getCOMPETE() ) ) );
					}
				}
			}
		}
		finally{
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
		}
	}
	/**
	 * 结构化服务产品能力共享
	 * @param fromCOMPETENCE
	 * @param fromOfferImpl
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithComptelProperty( java.util.HashMap fromCOMPETENCE, 
			IUpdcpOfferImpl fromOfferImpl ) throws SFException,Exception{
		java.util.List fromUpdbm  = null;
		try
		{
			fromUpdbm = BasicFactory.getIUpdcpmSV().getIComptelCatalog();
			if( fromUpdbm != null && fromUpdbm.size() > 0 ){
				IProfessionalTemplate.IProductOffer fromUpdcpm = null;
				IProfessionalTemplate.IProductOffer fromMapping = null;
				IProfessionalTemplate.IComptelCatalog fromCatalog = null;
				for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
					ISAComptelRel aCompetence = (ISAComptelRel)itera.next();
					fromCatalog = new IProfessionalTemplate.IComptelCatalog( aCompetence );
					fromUpdcpm = fromOfferImpl.getPRODUCT( fromCatalog.getCOMPETE() );
					if( fromUpdcpm != null ){
						fromMapping = fromOfferImpl.getPRODUCT( fromCatalog.getPRODUCT() );
						fromUpdcpm.getSUBFLOW().add( new IProfessionalTemplate.IUpdbfgsmxOffer( 
							fromCatalog, 
							fromUpdcpm,
							fromMapping ) );
					}
				}
			}
		}
		finally{
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
		}
	}
	/**
	 * 结构化服务产品能力共享
	 * @param fromCOMPETENCE
	 * @param fromOfferImpl
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithComptelKernel( java.util.HashMap fromCOMPETENCE, 
			IUpdcpOfferImpl fromOfferImpl ) throws SFException,Exception{
		java.util.List fromUpdbm  = null;
		try
		{
			fromUpdbm = BasicFactory.getIUpdcpmSV().getIComptelKernel();
			if( fromUpdbm != null && fromUpdbm.size() > 0 ){
				IProfessionalTemplate.IComptelKernel fromUpdbcpm = null;
				for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
					ISAComptelX aCompetence = (ISAComptelX)itera.next();
					fromUpdbcpm = new IProfessionalTemplate.IComptelKernel( aCompetence );
					String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.
							I_COMPETENCE_PRODUCT_KERNEL, new String[]{ 
							    String.valueOf( fromUpdbcpm.getID() ) } );
					fromCOMPETENCE.put( fromINDEX, fromUpdbcpm );
				}
			}
		}
		finally{
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月9日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	class IUpdcpOfferImpl{
		private IUpdcpModelImpl MODULE = new IUpdcpModelImpl();
		public IUpdcpOfferImpl(){
			super();
		}
		/**
		 * @return the mODULE
		 */
		public IUpdcpModelImpl getMODULE() {
			return MODULE;
		}
		/**
		 * 
		 * @return
		 */
		public java.util.Map getPRODUCT(){
			return MODULE.PRODUCT;
		}
		/**
		 * 
		 * @param fromPRODUCT
		 * @return
		 */
		public IProfessionalTemplate.IProductOffer getPRODUCT( long fromPRODUCT ){
			return (IProfessionalTemplate.IProductOffer)MODULE.PRODUCT.get( 
					String.valueOf( fromPRODUCT ) );
		}
		/**
		 * 
		 * @param fromCOMPETENCE
		 * @throws RemoteException
		 * @throws Exception
		 */
		public void finishSFProductLoad( java.util.HashMap fromCOMPETENCE ) throws RemoteException,Exception{
			java.util.Map fromCATALOG = new java.util.HashMap();
			java.util.List fromUpdbm  = null;
			try
			{
				MODULE.PRODUCT.clear();
				fromUpdbm = BasicFactory.getIUpdcpmSV().getIProductComptel();
				if( fromUpdbm != null && fromUpdbm.size() > 0 ){
					IProfessionalTemplate.IProductComptel fromUpdcpfx = null;
					for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
						ISAProductX aProduct = (ISAProductX)itera.next();
						fromUpdcpfx = new IProfessionalTemplate.IProductComptel( aProduct );
						String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.
								I_COMPETENCE_PRODUCT_SUBJECT, new String[]{ fromUpdcpfx.getPRODUCT_ID() } );
						fromCATALOG.put( fromUpdcpfx.getPRODUCT_ID(), fromUpdcpfx );
						fromCOMPETENCE.put( fromINDEX, fromUpdcpfx );
					}
				}
				fromUpdbm = BasicFactory.getIUpdcpmSV().getIProductOffer();
				if( fromUpdbm != null && fromUpdbm.size() > 0 ){
					IProfessionalTemplate.IProductOffer fromUpdcpm = null;
					IProfessionalTemplate.IProductComptel fromUpdcpfx = null;
					for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
						ISAProduct aProduct = (ISAProduct)itera.next();
						fromUpdcpm = new IProfessionalTemplate.IProductOffer( aProduct );
						fromUpdcpfx = (IProfessionalTemplate.IProductComptel)fromCATALOG.get( fromUpdcpm.getID() );
						if( fromUpdcpfx != null ){ fromUpdcpm.setCOMPTEL( fromUpdcpfx );}
						MODULE.PRODUCT.put( fromUpdcpm.getID(), fromUpdcpm );
					}
				}
			}
			finally{
				if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
				if( fromCATALOG != null ){ fromCATALOG.clear(); fromCATALOG = null; }
			}
		}
		public class IUpdcpModelImpl{
			private java.util.Map PRODUCT = new java.util.HashMap();
			public IUpdcpModelImpl(){
				super();
			}
			/**
			 * @return the pRODUCT
			 */
			public java.util.Map getPRODUCT() {
				return PRODUCT;
			}
			
		}
	}
}
