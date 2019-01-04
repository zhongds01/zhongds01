package com.ai.sacenter.cache.redis;

import com.ai.appframe2.complex.xml.XMLHelper;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.basic.bo.ISACenterCatalog;
import com.ai.sacenter.base.basic.bo.ISACenterMapping;
import com.ai.sacenter.base.basic.bo.ISACenterWrapper;
import com.ai.sacenter.base.basic.bo.ISADistrict;
import com.ai.sacenter.base.basic.bo.ISAIdGenerator;
import com.ai.sacenter.base.basic.bo.ISALibrary;
import com.ai.sacenter.base.basic.bo.ISAParallel;
import com.ai.sacenter.base.basic.bo.ISAPersistent;
import com.ai.sacenter.base.basic.bo.ISAPriorityBusines;
import com.ai.sacenter.base.basic.bo.ISAPriorityLimite;
import com.ai.sacenter.base.basic.bo.ISAPriorityCompete;
import com.ai.sacenter.base.basic.bo.ISAStatic;
import com.ai.sacenter.base.basic.bo.ISASubTable;
import com.ai.sacenter.base.basic.bo.ISASubTableCau;
import com.ai.sacenter.base.basic.bo.ISASubTableCol;
import com.ai.sacenter.base.basic.bo.ISASubTableRel;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.base.basic.bo.ISACenter;
import com.ai.sacenter.base.basic.bo.ISADiction;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.ISubTableTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;


/**
 * <p>Title: ucmframe</p>
  * <p>Description: 公共基础[基础配置]</p>
 * <p>Copyright: Copyright (c) 2011-10-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IIBasicCacheImpl extends ISystemCacheImpl {

	public IIBasicCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromBasic = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithDiction( fromBasic );
			_wrapWithStatic( fromBasic );
			_wrapWithDistrict(fromBasic);
			_wrapWithCenter( fromBasic );
			_wrapWithCenterWrapper( fromBasic );
			_wrapWithCenterMapping( fromBasic );
			_wrapWithCenterCatalog( fromBasic );
			_wrapWithLibrary( fromBasic );
			_wrapWithPersistent( fromBasic );
			_wrapWithIdGenerator( fromBasic );
			_wrapWithSubTable( fromBasic );
			_wrapWithParallel(fromBasic);
			_wrapWithPriority( fromBasic );
			_wrapWithLimite( fromBasic );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromBasic;
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithDiction( java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			java.util.List _dictiondefine = BasicFactory.getIBasicSV().getAllDiction();
			for( java.util.Iterator itera = _dictiondefine.iterator(); itera.hasNext() ; ){
				ISADiction _diction = (ISADiction)itera.next();
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_DICTION, new String[]{ _diction.getCategory() } );
				ISystemTemplate.IEnumGroup fromGroup = (ISystemTemplate.IEnumGroup)fromBasic.get( fromINDEX );
				if( fromGroup == null ){
					fromBasic.put( fromINDEX, fromGroup = new ISystemTemplate.IEnumGroup( _diction ) );
				}
				fromGroup.mergeAsEnum( _diction );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithStatic( java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			ISystemTemplate.IStaticGroup __group__ = null;
			ISystemTemplate.IStaticCategory __category__ = null;
			java.util.List _staticdefine = BasicFactory.getIBasicSV().getAllStatic();
			for(java.util.Iterator itera = _staticdefine.iterator(); itera.hasNext();){
				ISAStatic aStatic = (ISAStatic)itera.next();
				ISystemTemplate.IStaticOffer __static__ = new ISystemTemplate.IStaticOffer( aStatic );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_STATIC, 
						new String[]{__static__.getCATEGORY(), __static__.getCODE() } ); 
				if( ( __group__ = (ISystemTemplate.IStaticGroup)fromBasic.get( fromINDEX ) ) == null ){
					fromBasic.put( fromINDEX, __group__ = new ISystemTemplate.IStaticGroup( __static__ ) );
				}
				__group__.mergeAsGroup( __static__ );
				
				fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_CATEGORY, new String[]{__static__.getCATEGORY() } ); 
				if( ( __category__ = (ISystemTemplate.IStaticCategory)fromBasic.get( fromINDEX ) ) == null ){
					fromBasic.put( fromINDEX, __category__ = new ISystemTemplate.IStaticCategory( __static__ ) );
				}
				__category__.getCATEGORY().add( __static__ );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithDistrict( java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			java.util.List _districtdefine = BasicFactory.getIBasicSV().getAllDistrict();
			for( java.util.Iterator itera = _districtdefine.iterator(); itera.hasNext(); ){
				ISADistrict aDistrict = (ISADistrict)itera.next();
				ISystemTemplate.IUpfgkmDistrict aUpdgdmDefine = new ISystemTemplate.IUpfgkmDistrict( aDistrict );
				String aINDEX = ClassUtils.getINDEX( new String[]{IUpdcConst.ICache.ICachePref.I_SYSTEM_DISTRICT,
						"_$_ADL^",
						String.valueOf( aUpdgdmDefine.getID() )});
				fromBasic.put( aINDEX , aUpdgdmDefine );
				if( aUpdgdmDefine.getTYPE() == 2 ){
					aINDEX = ClassUtils.getINDEX( new String[]{IUpdcConst.ICache.ICachePref.I_SYSTEM_DISTRICT,"_$_ADR^"});
					if( fromBasic.get( aINDEX ) == null ) fromBasic.put( aINDEX , new java.util.ArrayList() );
					((java.util.List)fromBasic.get( aINDEX ) ).add( aUpdgdmDefine );
					
					aINDEX = ClassUtils.getINDEX( new String[]{IUpdcConst.ICache.ICachePref.I_SYSTEM_DISTRICT,
							"_$_MAC^",
							aUpdgdmDefine.getCODE()});
					fromBasic.put( aINDEX , aUpdgdmDefine );
					
					aINDEX = ClassUtils.getINDEX( new String[]{IUpdcConst.ICache.ICachePref.I_SYSTEM_DISTRICT,
							"_$_MAT^",
							String.valueOf( aUpdgdmDefine.getTWO_NUMBER() )});
					fromBasic.put( aINDEX , aUpdgdmDefine );
				}
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithCenter(  java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			java.util.List _centerroute = BasicFactory.getIBasicSV().getICenterRoute();
			for( java.util.Iterator itera = _centerroute.iterator(); itera.hasNext(); ){
				ISACenter aCenter = (ISACenter)itera.next();
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_CENTER_ROUTING, 
						new String[]{ aCenter.getPlatform(), aCenter.getCategory() } );
				ISystemTemplate.ICenterGroup fromGroup = (ISystemTemplate.ICenterGroup)fromBasic.get( fromINDEX );
				if( fromGroup == null ){
					fromBasic.put( fromINDEX, fromGroup = new ISystemTemplate.ICenterGroup( aCenter ) );
				}
				fromGroup.mergeAsGroup( aCenter );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithCenterWrapper(  java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			java.util.List _centerdefine = BasicFactory.getIBasicSV().getICenterWrapper();
			for( java.util.Iterator itera = _centerdefine.iterator(); itera.hasNext(); ){
				ISACenterWrapper aCenterWrapper = (ISACenterWrapper)itera.next();
				ISystemTemplate.ICenterWrapper _centerwrapper = new ISystemTemplate.ICenterWrapper( aCenterWrapper );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_CENTER_WRAPPER, new String[]{ 
						_centerwrapper.getPLATFORM_(), _centerwrapper.getID()} );
				fromBasic.put( fromINDEX, _centerwrapper );
			}
		}
		finally{
		
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithCenterMapping(  java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			java.util.List _centerdefine = BasicFactory.getIBasicSV().getICenterMapping();
			for( java.util.Iterator itera = _centerdefine.iterator(); itera.hasNext(); ){
				ISACenterMapping aCenterMapping = (ISACenterMapping)itera.next();
				ISystemTemplate.ICenterMapping _centermapping = new ISystemTemplate.ICenterMapping( aCenterMapping );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_CENTER_MAPPING, 
						new String[]{ _centermapping.getID() });
				fromBasic.put( fromINDEX, _centermapping );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithCenterCatalog(  java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			//1.按照Default.xml中//DataSource//mapping数据源映射配置初始化
			com.ai.appframe2.complex.xml.cfg.defaults.Property dataSource[] = null;
			dataSource = XMLHelper.getInstance().getDefaults().getDatasource().getMapping().getProperties();
			for(int index = 0; dataSource != null && index < dataSource.length; index++ ){
				ISystemTemplate.ICenterCatalog fromCatalog = new ISystemTemplate.ICenterCatalog( dataSource[index] );
				String fromINDEX = ClassUtils.getINDEX(IUpdcConst.ICache.ICachePref.I_CENTER_CATALOG, new String[]{ fromCatalog.getCATEGORY() } );
				ISystemTemplate.ICenterCombine fromGroup = (ISystemTemplate.ICenterCombine)fromBasic.get( fromINDEX );
				if( fromGroup == null ){
					fromBasic.put( fromINDEX, fromGroup = new ISystemTemplate.ICenterCombine( fromCatalog.getCATEGORY() ) );
				}
				fromGroup.mergeAsCatalog( fromCatalog );
			}
			//2.按照SA_CENTER_CATALOG配置表初始化
			java.util.List _centerdefine = BasicFactory.getIBasicSV().getICenterCatalog();
			for( java.util.Iterator itera = _centerdefine.iterator(); itera.hasNext(); ){
				ISACenterCatalog aCatalog = (ISACenterCatalog)itera.next();
				String fromINDEX = ClassUtils.getINDEX(IUpdcConst.ICache.ICachePref.I_CENTER_CATALOG, new String[]{ aCatalog.getCategory() } );
				ISystemTemplate.ICenterCombine fromGroup = (ISystemTemplate.ICenterCombine)fromBasic.get( fromINDEX );
				if( fromGroup == null ){
					fromBasic.put( fromINDEX, fromGroup = new ISystemTemplate.ICenterCombine( aCatalog ) );
				}
				fromGroup.mergeAsCatalog( aCatalog );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithLibrary( java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			ISystemTemplate.IImplCapital fromCapital = null;
			ISALibrary _impldefine[] = BasicFactory.getIBasicSV().getILibraryOffer();
			for( int index = 0 ; _impldefine != null && index < _impldefine.length ; index++ ){
				fromCapital = new ISystemTemplate.IImplCapital( _impldefine[index] );
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_LIBRARY , 
						new String[]{ fromCapital.getID() } ); 
				fromBasic.put(aINDEX, fromCapital );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithPersistent( java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			java.util.List _subtableoffer = BasicFactory.getIBasicSV().getISubTableOffer();
			for( java.util.Iterator itera = _subtableoffer.iterator(); itera.hasNext(); ){
				ISAPersistent aPersistence = (ISAPersistent)itera.next();
				ISystemTemplate.IUpfgkmGroup fromComposite = (ISystemTemplate.IUpfgkmGroup)fromBasic.get( 
						IUpdcConst.ICache.ICachePref.I_SUBTABLE_PERSISTENT );
				if( fromComposite == null ){ 
					fromComposite = new ISystemTemplate.IUpfgkmGroup( IUpdcConst.ICache.ICachePref.I_SUBTABLE_PERSISTENT );
					fromBasic.put( IUpdcConst.ICache.ICachePref.I_SUBTABLE_PERSISTENT, fromComposite );
				}
				fromComposite.mergeAsComposite( aPersistence );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithIdGenerator( java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			ISAIdGenerator _idgeneratordefine[] = BasicFactory.getIBasicSV().getIIdGenerator();
			for( int index = 0 ; _idgeneratordefine != null && index < _idgeneratordefine.length; index++ ){
				ISubTableTemplate.IdGenerator _idgenerator = new ISubTableTemplate.IdGenerator( _idgeneratordefine[index] );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_IDGENERATOR , 
						new String[]{_idgenerator.getTABLE(), _idgenerator.getCHANNEL(), _idgenerator.getREGION() } ); 
				fromBasic.put( fromINDEX, _idgenerator );
				if( StringUtils.isBlank( _idgenerator.getREGION_NUMBER() ) == false ){
					fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_REGIONNUMBER , 
							new String[]{_idgenerator.getREGION_NUMBER() } );
					fromBasic.put( fromINDEX, _idgenerator );
				}
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithSubTable( java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			ISubTableTemplate.ISubSQLGroup fromSubSQL = null;
			ISubTableTemplate.ISubSQLCombine fromGroup = null;
			String __association = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_NETWORK, new String[]{ } );
			fromGroup = (ISubTableTemplate.ISubSQLCombine)fromBasic.get( __association );
			if( fromGroup == null ){ fromBasic.put( __association, fromGroup = new ISubTableTemplate.ISubSQLCombine() ); }
			ISASubTable aSubTable[] = BasicFactory.getIBasicSV().getISubSQLTable();
			for(int index = 0 ; aSubTable != null && index < aSubTable.length ; index++){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_NETWORK, 
						new String[]{aSubTable[index].getPlatform()} );
				fromSubSQL = (ISubTableTemplate.ISubSQLGroup)fromBasic.get( fromINDEX );
				if( fromSubSQL == null ){
					fromSubSQL = new ISubTableTemplate.ISubSQLGroup( aSubTable[index] );
					fromBasic.put( fromINDEX, fromSubSQL );
					fromGroup.mergeAsNetWork( fromSubSQL );
				}
				fromSubSQL.mergeAsSubFlow( aSubTable[index] );
			}
			
			ISASubTableRel aSubTableRel[] = BasicFactory.getIBasicSV().getISubSQLTableRel();
			for(int index = 0 ; aSubTableRel != null && index < aSubTableRel.length ; index++){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_NETWORK, 
						new String[]{aSubTableRel[index].getPlatform()} );
				fromSubSQL = (ISubTableTemplate.ISubSQLGroup)fromBasic.get( fromINDEX );
				if( fromSubSQL != null ){ fromSubSQL.mergeAsSubJect( aSubTableRel[index] ); }
			}
			
			java.util.List _subsqltablecol = BasicFactory.getIBasicSV().getISubSQLTableCol();
			for( java.util.Iterator itera = _subsqltablecol.iterator(); itera.hasNext(); ){
				ISASubTableCol aSubTableCol = (ISASubTableCol)itera.next();
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_NETWORK, 
						new String[]{ aSubTableCol.getPlatform() } );
				fromSubSQL = (ISubTableTemplate.ISubSQLGroup)fromBasic.get( fromINDEX );
				if( fromSubSQL != null ){ fromSubSQL.mergeAsSubJSQL( aSubTableCol ); }
			}
			
			java.util.List _subsqltablecau = BasicFactory.getIBasicSV().getISubSQLTableCau();
			for( java.util.Iterator itera = _subsqltablecau.iterator(); itera.hasNext(); ){
				ISASubTableCau aSubTableCau = (ISASubTableCau)itera.next();
				ISubTableTemplate.ISubSQLTableCau fromCau = new ISubTableTemplate.ISubSQLTableCau(aSubTableCau);
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_ROUTING , 
						new String[]{fromCau.getPLATFORM_(), fromCau.getTABLE(), fromCau.getNAME(), fromCau.getCOLUMN() } );
				fromBasic.put( aINDEX , fromCau );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithParallel( java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			java.util.List _paralleldefine = BasicFactory.getIBasicSV().getIUpfgkmParallel();
			for( java.util.Iterator itera = _paralleldefine.iterator(); itera.hasNext() ; ){
				ISAParallel aParallel = (ISAParallel)itera.next();
				ISystemTemplate.IUpfgkmParallel fromParallel = new ISystemTemplate.IUpfgkmParallel( aParallel );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_PARALLEL , 
						new String[]{ fromParallel.getORIGINATE(),fromParallel.getREGION_ID() } ); 
				fromBasic.put( fromINDEX, fromParallel);
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithPriority( java.util.Map fromBasic ) throws SFException,Exception{
		try
		{
			java.util.HashMap _program = getSFUpdbfsProtection();
			java.util.ArrayList _propritybusines = BasicFactory.getIBasicSV().getIUpdbfsBusines();
			for( java.util.Iterator itera = _propritybusines.iterator(); itera.hasNext() ; ){
				ISAPriorityBusines _proprity = (ISAPriorityBusines)itera.next();
				ISystemTemplate.IUpdbfsBusines fromBusines = new ISystemTemplate.IUpdbfsBusines( _proprity, _program );
				String fromINDEX = ClassUtils.getINDEX(IUpdcConst.ICache.ICachePref.I_PRIORITY_BUSINESS, 
						new String[]{fromBusines.getPLATFORM_(), fromBusines.getCATALOG(), fromBusines.getBUSINES(), 
								fromBusines.getBATCHES(), fromBusines.getCHANNEL()});
				ISystemTemplate.IUpdbfsCombine fromCombine = (ISystemTemplate.IUpdbfsCombine)fromBasic.get( fromINDEX );
				if( fromCombine == null ){
					fromBasic.put( fromINDEX,  fromCombine = new ISystemTemplate.IUpdbfsCombine( _proprity ) );
				}
				fromCombine.getSUBFLOW().add( fromBusines );
			}
			
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromBasic
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithLimite( java.util.HashMap fromBasic ) throws SFException,Exception{
		try
		{
			java.util.List _propritylimite = BasicFactory.getIBasicSV().getIUpdbfsLimite();
			for( java.util.Iterator itera = _propritylimite.iterator(); itera.hasNext() ; ){
				ISAPriorityLimite _proprity = (ISAPriorityLimite)itera.next();
				String fromINDEX = ClassUtils.getINDEX(IUpdcConst.ICache.ICachePref.I_PRIORITY_LIMITE, 
						new String[]{ _proprity.getPlatform(), _proprity.getCode() });
				ISystemTemplate.IUpdbfsGroup fromGroup = (ISystemTemplate.IUpdbfsGroup)fromBasic.get( fromINDEX );
				if( fromGroup == null ){
					fromBasic.put( fromINDEX, fromGroup = new ISystemTemplate.IUpdbfsGroup( _proprity ) );
				}
				fromGroup.mergeAsGroup( _proprity );
			}
		}
		finally{
		
		}
	}
	
	/**
	 * 
	 * @return [KEY=SA_PRIORITY_COMPETE.PROGRAM,DATA=HashMap[KEY=SA_PRIORITY_COMPETE.COMPETE,DATA=ArrayList[SA_PRIORITY_COMPETE]]]
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getSFUpdbfsProtection() throws SFException,Exception{
		java.util.HashMap _program = new java.util.HashMap();
		try
		{
			java.util.Map _competence = null;
			ISystemTemplate.IUpdbfsCatalog fromCatalog = null;
			java.util.List _propritycatalog = BasicFactory.getIBasicSV().getIUpdbfsCatalog();
			for( java.util.Iterator itera = _propritycatalog.iterator(); itera.hasNext() ; ){
				ISAPriorityCompete aProprity = (ISAPriorityCompete)itera.next();
				fromCatalog = new ISystemTemplate.IUpdbfsCatalog(aProprity);
				if( ( _competence = (java.util.Map)_program.get( fromCatalog.getID() ) ) == null ){ 
					_program.put( fromCatalog.getID(), _competence = new java.util.HashMap() );
				}
				if( _competence.containsKey( fromCatalog.getCOMPETE_() ) == false ){
					_competence.put( fromCatalog.getCOMPETE_() , new java.util.ArrayList() );
				}
				((java.util.List)_competence.get( fromCatalog.getCOMPETE_() ) ).add( fromCatalog );
			}
		}
		finally{
			
		}
		return _program;
	}
}
