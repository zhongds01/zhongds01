package com.ai.sacenter.cache.redis;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.platform.bo.ISAClient;
import com.ai.sacenter.base.platform.bo.ISADebuging;
import com.ai.sacenter.base.platform.bo.ISADirective;
import com.ai.sacenter.base.platform.bo.ISADirectiveS;
import com.ai.sacenter.base.platform.bo.ISAFeature;
import com.ai.sacenter.base.platform.bo.ISAOperate;
import com.ai.sacenter.base.platform.bo.ISAOperateX;
import com.ai.sacenter.base.platform.bo.ISAPlatform;
import com.ai.sacenter.base.platform.bo.ISAPlatformX;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 逻辑指令层[基础配置]</p>
 * <p>Copyright: Copyright (c) 2011-10-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IIPlatformCacheImpl extends ISystemCacheImpl {

	public IIPlatformCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromUpfm = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithPlatform( fromUpfm );
			_wrapWithFeature( fromUpfm );
			_wrapWithOperate( fromUpfm );
			_wrapWithDirective( fromUpfm );
			_wrapWithDebuging( fromUpfm );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromUpfm;
	}
	/**
	 * 
	 * @param fromUpfm
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithPlatform( java.util.Map fromUpfm ) throws SFException,Exception{
		java.util.Map fromUpfmx = new java.util.HashMap();
		java.util.Map fromUpfmc = new java.util.HashMap();
		try
		{
			class IUpfmxSubFlowImpl{
				IUpfmxModel _PLATFORM = new IUpfmxModel();
				public IUpfmxSubFlowImpl(){
					super();
				}
				/**
				 * 查询父级网元平台
				 * @param aIPlatform
				 * @param aIPlatformLL
				 * @param aIPlatformL
				 * @throws SFException
				 * @throws Exception
				 */
				private void finishSFUpfspmOffer( IPlatformTemplate.IUpffmOffer aIPlatform , 
						IPlatformTemplate.IUpffmOffer aIPlatformLL[], 
						java.util.List aIPlatformL ) throws SFException,Exception{
					aIPlatformL.add( aIPlatform );
					for(int index = 0 ; index < aIPlatformLL.length ; index++){
						if( StringUtils.equals( aIPlatformLL[index].getID() , aIPlatform.getPARENT_() ) == false ) continue;
						finishSFUpfspmOffer( aIPlatformLL[index] , aIPlatformLL, aIPlatformL);
					}
				}
				/**
				 * 查询下级网元平台
				 * @param aIPlatform
				 * @param aIPlatformLL
				 * @param aIPlatformL
				 * @throws SFException
				 * @throws Exception
				 */
				private void finishSFUpfcpmOffer( IPlatformTemplate.IUpffmOffer aIPlatform , 
						IPlatformTemplate.IUpffmOffer aIPlatformLL[], 
						java.util.List aIPlatformL ) throws SFException,Exception{
					aIPlatformL.add( aIPlatform );
					for(int index = 0 ; index < aIPlatformLL.length ; index++){
						if( StringUtils.equals( aIPlatform.getID() , aIPlatformLL[index].getPARENT_() ) == false ) continue;
						finishSFUpfcpmOffer( aIPlatformLL[index] , aIPlatformLL, aIPlatformL);
					}
				}
				/**
				 * 
				 * @param fromUpfm
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfmFeature( java.util.Map fromUpfm ) throws SFException,Exception{
					java.util.List fromList = null;
					try
					{
						fromList = BasicFactory.getIUpffmSV().getIUpfmxCatalog();
						for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
							ISAPlatformX aPlatformX = (ISAPlatformX)itera.next();
							if( _PLATFORM.getMAPPING( aPlatformX.getPlatform() ) == null ){
								_PLATFORM.getMAPPING().put( aPlatformX.getPlatform(),
										new java.util.HashMap() );
							}
							_PLATFORM.getMAPPING( aPlatformX.getPlatform() ).put( aPlatformX.getInfoCode(), 
									aPlatformX.getInfoValue() );
						}
					}
					finally{
						if( fromList != null ){ fromList.clear(); fromList = null; }
					}
				}
				/**
				 * 
				 * @param fromUpfm
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfmNetWork( java.util.Map fromUpfm ) throws SFException,Exception{
					java.util.List fromUpdbm = null;
					try
					{
						IPlatformTemplate.IUpffmNetWork fromClient = null;
						fromUpdbm = BasicFactory.getIUpffmSV().getIUpffmNetWork();
						for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
							ISAClient aClient = (ISAClient)itera.next();
							fromClient = new IPlatformTemplate.IUpffmNetWork( aClient );
							String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_NETWORK, 
									new String[]{ fromClient.getID() } );
							_PLATFORM.getNETWORK().put( fromClient.getID() , fromClient );
							fromUpfm.put( aINDEX, fromClient );
						}
					}
					finally{
						if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
					}
				}
				/**
				 * 
				 * @param fromUpfm
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfmOffer( java.util.Map fromUpfm ) throws SFException,Exception{
					java.util.List fromUpdbm = null;
					try
					{
						fromUpdbm = BasicFactory.getIUpffmSV().getIUpffmOffer();
						IPlatformTemplate.IUpffmOffer aIPlatformL[] = new IPlatformTemplate.IUpffmOffer[ fromUpdbm.size() ];
						for(int index = 0 ; fromUpdbm != null && index < fromUpdbm.size() ; index++){
							ISAPlatform aPlatform = (ISAPlatform)fromUpdbm.get( index );
							String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_BASIC, 
									new String[]{ISAPlatform.S_Id}, aPlatform );
							java.util.Map fromGraph = _PLATFORM.getMAPPING( aPlatform.getId() );
							IPlatformTemplate.IUpffmNetWork fromClient = null;
							if( StringUtils.isBlank( aPlatform.getNetwork() ) == false && 
									_PLATFORM.getNETWORK().get( aPlatform.getNetwork() ) != null ){
								fromClient = (IPlatformTemplate.IUpffmNetWork)_PLATFORM.getNETWORK().get( 
										aPlatform.getNetwork() );
							}
							aIPlatformL[index] = new IPlatformTemplate.IUpffmOffer( aPlatform, 
									fromClient, 
									fromGraph );
							fromUpfm.put( aINDEX , aIPlatformL[index] );
						}
						for(int index = 0 ; index < aIPlatformL.length ; index++){
							String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_PARENT , 
									new String[]{aIPlatformL[index].getID()} );
							fromUpfm.put( aINDEX , new java.util.ArrayList() );
							finishSFUpfspmOffer( aIPlatformL[index], aIPlatformL, (java.util.List)fromUpfm.get( aINDEX ) );
							
							aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_CHILD , 
									new String[]{aIPlatformL[index].getID()} );
							fromUpfm.put( aINDEX , new java.util.ArrayList() );
							finishSFUpfcpmOffer( aIPlatformL[index], aIPlatformL, (java.util.List)fromUpfm.get( aINDEX ) );
						}
					}
					finally{
						if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
					}
				}
				class IUpfmxModel{
					/*针对SA_PLATFORM_X缓存*/
					private java.util.Map _mapping = new java.util.HashMap();
					/*针对SA_CLIENT转存*/
					private java.util.Map _network = new java.util.HashMap();
					public IUpfmxModel(){
						super();
					}
					/**
					 * @return the _mapping
					 */
					public java.util.Map getMAPPING() {
						return _mapping;
					}
					/**
					 * @return the pLATFORM_X
					 */
					public java.util.Map getMAPPING( String aPLATFORM ) {
						return (java.util.Map)_mapping.get( aPLATFORM );
					}
					/**
					 * @return the _network
					 */
					public java.util.Map getNETWORK() {
						return _network;
					}
				}
			}
			IUpfmxSubFlowImpl fromUpfmImpl = new IUpfmxSubFlowImpl();
			try
			{
				fromUpfmImpl.finishSFUpfmFeature( fromUpfm );
				fromUpfmImpl.finishSFUpfmNetWork( fromUpfm );
				fromUpfmImpl.finishSFUpfmOffer( fromUpfm );
			}
			finally{
				if( fromUpfmImpl != null ){ fromUpfmImpl = null; }
			}
		}
		finally{
			if( fromUpfmc != null ){ fromUpfmc.clear(); fromUpfmc = null; }
			if( fromUpfmx != null ){ fromUpfmx.clear(); fromUpfmx = null ;}
		}
	}
	/**
	 * 
	 * @param fromUpfm
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithDebuging( java.util.Map fromUpfm ) throws SFException,Exception{
		java.util.List fromUpdbm = null;
		try
		{
			IPlatformTemplate.IUpffmDebuging fromUpffgm = null;
			fromUpdbm = BasicFactory.getIUpffmSV().getIUpffmDebug();
			for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
				ISADebuging aDebugging = (ISADebuging)itera.next();
				fromUpffgm = new IPlatformTemplate.IUpffmDebuging( aDebugging );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_DEBUG, 
						new String[]{fromUpffgm.getPLATFORM(), fromUpffgm.getDIRECTIVE() } );
				fromUpfm.put( fromINDEX, fromUpffgm );
			}
		}
		finally{
			
		}
	}
	/**
	 * 
	 * @param fromUpfm
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithFeature( java.util.Map fromUpfm ) throws SFException,Exception{
		try
		{
			IPlatformTemplate.IUpffxOffer fromUpffxm = null;
			java.util.List fromList = BasicFactory.getIUpffmSV().getIUpffxmOffer();
			for( java.util.Iterator itera = fromList.iterator() ; itera.hasNext(); ){
				ISAFeature aFEATURE = (ISAFeature)itera.next();
				fromUpffxm = new IPlatformTemplate.IUpffxOffer( aFEATURE );
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_FEATURE , 
						new String[]{fromUpffxm.getPLATFORM()} );
				if( fromUpfm.containsKey( aINDEX ) == false ) fromUpfm.put( aINDEX, new java.util.HashMap() );
				((java.util.Map)fromUpfm.get( aINDEX ) ).put( fromUpffxm.getID(), fromUpffxm );
			}
		}
		finally{
			
		}
	}
	/**
	 * 
	 * @param fromUpfm
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithOperate( java.util.Map fromUpfm ) throws SFException,Exception{
		java.util.Map fromUpfmx = new java.util.HashMap();
		try
		{
			IPlatformTemplate.IUpffmOperate fromUpfom = null;
			java.util.List fromList = BasicFactory.getIUpffmSV().getIUpffmOperateX();
			for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
				ISAOperateX aOperateX = (ISAOperateX)itera.next();
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_OPERATE , 
						new String[]{ISAOperateX.S_Platform,ISAOperateX.S_Operate,}, aOperateX );
				if( fromUpfmx.containsKey( aINDEX ) == false ) fromUpfmx.put( aINDEX , new java.util.HashMap() );
				((java.util.Map)fromUpfmx.get( aINDEX ) ).put( aOperateX.getInfoCode() , aOperateX.getInfoValue() );
			}
			fromList = BasicFactory.getIUpffmSV().getIUpffmOperate();
			for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
				ISAOperate aOperate = (ISAOperate)itera.next();
				fromUpfom = new IPlatformTemplate.IUpffmOperate( aOperate );
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_OPERATE , 
						new String[]{fromUpfom.getPLATFORM_(),fromUpfom.getID()} );
				if( fromUpfmx.containsKey( aINDEX ) ){
					ClassUtils.IMerge.merge( (java.util.Map)fromUpfmx.get( aINDEX ), 
							fromUpfom.getGRAPHICS(), 
							false );
				}
				fromUpfm.put( aINDEX , fromUpfom );
			}
		}
		finally{
			if( fromUpfmx != null ){ fromUpfmx.clear(); fromUpfmx = null; }
		}
	}
	/**
	 * 
	 * @param fromUpfm
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithDirective( java.util.Map fromUpfm ) throws SFException,Exception{
		try
		{
			IPlatformTemplate.IUpffbpmOffer fromUpffbpm = null;
			java.util.List fromList = BasicFactory.getIUpffmSV().getIUpffmLogical();
			for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
				ISADirective aDirective = (ISADirective)itera.next();
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_DIRECTIVE , 
						new String[]{ISADirective.S_Platform,ISADirective.S_Id}, aDirective );
				fromUpfm.put( aINDEX , new IPlatformTemplate.IUpffmDirective( aDirective ) );
			}
			fromList = BasicFactory.getIUpffmSV().getIUpffmSubFlow();
			for( java.util.Iterator itera = fromList.iterator(); itera.hasNext(); ){
				ISADirectiveS aDirective = (ISADirectiveS)itera.next();
				IPlatformTemplate.IUpffmSubFlow fromUpdfsm = new IPlatformTemplate.IUpffmSubFlow( aDirective );
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_SUBFLOW , 
						new String[]{fromUpdfsm.getSUBFLOW()} );
				fromUpffbpm = (IPlatformTemplate.IUpffbpmOffer)fromUpfm.get( aINDEX );
				if( fromUpffbpm == null ){
					fromUpfm.put( aINDEX , fromUpffbpm = new IPlatformTemplate.IUpffbpmOffer(
							fromUpdfsm.getSUBFLOW(), fromUpdfsm.getNAME() ) );
				}
				fromUpffbpm.getSUBFLOW().add( fromUpdfsm );
			}
		}
		finally{
			
		}
	}
}
