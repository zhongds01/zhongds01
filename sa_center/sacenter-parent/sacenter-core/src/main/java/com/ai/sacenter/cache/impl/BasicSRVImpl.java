package com.ai.sacenter.cache.impl;

import com.ai.appframe2.complex.cache.CacheFactory;
import com.ai.appframe2.complex.cache.impl.TableSplitCacheImpl;
import com.ai.appframe2.complex.cache.impl.TableSplitFunctionCacheImpl;
import com.ai.appframe2.complex.cache.impl.TableSplitMappingCacheImpl;
import com.ai.appframe2.complex.self.po.TableSplit;
import com.ai.appframe2.complex.self.po.TableSplitMapping;
import com.ai.appframe2.complex.tab.split.function.IFunction;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.cache.interfaces.IBasicSRV;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISubTableTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.asiainfo.appframe.ext.exeframe.http.client.cache.HttpClientCacheImpl;
import com.asiainfo.appframe.ext.exeframe.http.query.po.CfgHttpClient;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê9ÔÂ29ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class BasicSRVImpl extends DialectSystemImpl implements IBasicSRV {

	public BasicSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getHttpClient(java.lang.String)
	 */
	public CfgHttpClient getHttpClient(String aHttpClientCode) throws SFException, Exception {
		CfgHttpClient fromClient = null;
		try
		{
			fromClient = (CfgHttpClient)hget(HttpClientCacheImpl.class, aHttpClientCode);
			if( fromClient == null ) ExceptionFactory.throwIllegal("IOS0011066", new String[]{aHttpClientCode});
		}
		finally{
			
		}
		return fromClient;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFEnumChain(java.lang.String)
	 */
	public ISystemTemplate.IEnumWrapper getSFEnumChain(String fromCatalog) throws SFException, Exception {
		ISystemTemplate.IEnumWrapper fromEnum = null; 
		try
		{
			String fromUpffmx[] = StringUtils.wildcardArray( fromCatalog, "," );
			ISystemTemplate.IEnumGroup fromGroup = this.getSFEnumGroup( fromUpffmx[0] );
			if( fromGroup != null && fromGroup.getGROUP().size() > 0 ){
				for( int index = 1; fromUpffmx != null && index < fromUpffmx.length; index++ ){
					fromEnum = fromGroup.getENUM( fromUpffmx[index] );
					if( fromEnum != null ){ break; }
				}
			}
		}
		finally{
			
		}
		return fromEnum;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFEnumGroup(java.lang.String)
	 */
	public ISystemTemplate.IEnumGroup getSFEnumGroup(String fromCATEGORY) throws SFException, Exception {
		ISystemTemplate.IEnumGroup fromGroup = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_DICTION, new String[]{ fromCATEGORY } );
			fromGroup = (ISystemTemplate.IEnumGroup)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
		}
		finally{
			
		}
		return fromGroup;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFStaticCategory(java.lang.String)
	 */
	public ISystemTemplate.IStaticCategory getSFStaticCategory(String aCATEGORY) throws SFException, Exception {
		ISystemTemplate.IStaticCategory __category__ = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_CATEGORY, new String[]{ aCATEGORY } );
			__category__ = (ISystemTemplate.IStaticCategory)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
		}
		finally{
			
		}
		return __category__;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFStaticGroup(java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.IStaticGroup getSFStaticGroup(String aGROUP, String aCATEGORY) throws SFException, Exception {
		ISystemTemplate.IStaticGroup fromStatic = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_STATIC, 
					new String[]{ aCATEGORY, aGROUP } ); 
			fromStatic = (ISystemTemplate.IStaticGroup)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
		}
		finally{
			
		}
		return fromStatic;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFStaticBytes()
	 */
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFStaticGroup(java.lang.String)
	 */
	public ISystemTemplate.IStaticGroup getSFStaticGroup(String aGROUP) throws SFException, Exception {
		ISystemTemplate.IStaticGroup fromStatic = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_STATIC, new String[]{ aGROUP } ); 
			fromStatic = (ISystemTemplate.IStaticGroup)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
		}
		finally{
			
		}
		return fromStatic;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFStaticBytes()
	 */
	public ISystemTemplate.IStaticOffer getSFStaticBytes() throws SFException, Exception {
		ISystemTemplate.IStaticOffer fromMaxByte = null;
		try
		{
			ISystemTemplate.IStaticGroup fromGROUP = getSFStaticGroup( IUpdcConst.IEnum.BYTE );
			if( fromGROUP != null ){ fromMaxByte = fromGROUP.getLITTLE(); };
		}
		finally{
			
		}
		return fromMaxByte;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFStaticOffer(java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.IStaticOffer getSFStaticOffer(String aCATEGORY, String aSTATIC) throws SFException, Exception {
		ISystemTemplate.IStaticOffer fromStatic = null;
		try
		{
			ISystemTemplate.IStaticGroup fromGROUP = getSFStaticGroup( aCATEGORY ); 
			if( fromGROUP != null ){ fromStatic = fromGROUP.getSTATIC( aSTATIC ); }
		}
		finally{
			
		}
		return fromStatic;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFStaticOffer(java.lang.String)
	 */
	public ISystemTemplate.IStaticOffer[] getSFStaticOffer(String aCATEGORY) throws SFException, Exception {
		ISystemTemplate.IStaticOffer fromStatic[] = null;
		try
		{
			ISystemTemplate.IStaticGroup fromGROUP = getSFStaticGroup( aCATEGORY );
			if( fromGROUP != null ){ fromStatic = fromGROUP.getAsGroup(); }
		}
		finally{
			
		}
		return fromStatic;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFIdGenerator(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ISubTableTemplate.IdGenerator getSFIdGenerator(String aTABLE, String aCHANNEL, String aREGION) throws SFException, Exception {
		ISubTableTemplate.IdGenerator fromIdGenerator = null;
		try
		{
			aTABLE = OracleUtils.ICustom.getTableName( aTABLE );
			String fromColumn[][] = new String[][]{{aTABLE, aCHANNEL, aREGION},
			                                       {aTABLE, "*"     , aREGION},
			                                       {aTABLE, aCHANNEL, "*"    },
			                                       {aTABLE, "*"     , "*"    }};
			for( int index = 0 ; index < fromColumn.length; index++ ){
				String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_IDGENERATOR , 
						new String[]{ fromColumn[index][0] , fromColumn[index][1] , fromColumn[index][2]} );
				fromIdGenerator = (ISubTableTemplate.IdGenerator)hget( IUpdcConst.ICache.IIUpdpbfgI, aINDEX );
				if( fromIdGenerator != null ) break;
			}
		}
		finally{
			
		}
		return fromIdGenerator;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFIdGenerator(java.lang.String)
	 */
	public ISubTableTemplate.IdGenerator getSFIdGenerator(String aREGION_NUMBER) throws SFException, Exception {
		ISubTableTemplate.IdGenerator fromIdGenerator = null;
		try
		{
			if( StringUtils.isBlank( aREGION_NUMBER ) ) ExceptionFactory.throwException("IOS0011040", new String[]{"NULL"});
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_REGIONNUMBER , new String[]{ aREGION_NUMBER} );
			fromIdGenerator = (ISubTableTemplate.IdGenerator)hget( IUpdcConst.ICache.IIUpdpbfgI, aINDEX );
			if( fromIdGenerator == null ) ExceptionFactory.throwException("IOS0011040", new String[]{aREGION_NUMBER});
		}
		finally{
			
		}
		return fromIdGenerator;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpfgkmLibrary(java.lang.String)
	 */
	public ISystemTemplate.IImplCapital getSFUpfgkmLibrary(String aIMPLCLASS) throws SFException, Exception {
		ISystemTemplate.IImplCapital fromJAVA = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_LIBRARY , 
					new String[]{ aIMPLCLASS } ); 
			fromJAVA = (ISystemTemplate.IImplCapital)hget( IUpdcConst.ICache.IIUpdpbfgI, aINDEX );
			if ( fromJAVA == null ) ExceptionFactory.throwIllegal("IOS0011041", new String[]{aIMPLCLASS});
		}
		finally{
			
		}
		return fromJAVA;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpfgkmComposite()
	 */
	public ISystemTemplate.IUpfgkmGroup getSFUpfgkmComposite() throws SFException, Exception {
		ISystemTemplate.IUpfgkmGroup _composite = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_PERSISTENT );
			_composite = (ISystemTemplate.IUpfgkmGroup)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
		}
		finally{
			
		}
		return _composite;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpfgkmComposite(java.lang.String)
	 */
	public ISystemTemplate.IUpfgkmComposite getSFUpfgkmComposite(String _table_name) throws SFException, Exception {
		ISystemTemplate.IUpfgkmComposite  fromPersist = null;
		try
		{
			ISystemTemplate.IUpfgkmGroup _composite = null;
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_PERSISTENT );
			_composite = (ISystemTemplate.IUpfgkmGroup)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
			if( _composite != null ){
				_table_name = OracleUtils.ICustom.getTableName( _table_name );
				fromPersist = (ISystemTemplate.IUpfgkmComposite)_composite.getSUBFLOW( _table_name );
			}
		}
		finally{
			
		}
		return fromPersist;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFSubTableSplit(java.lang.String)
	 */
	public TableSplit getSFSubTableSplit(String fromTableName) throws SFException, Exception {
		TableSplit fromTableSplit = null;
		try
		{
			fromTableSplit = (TableSplit)CacheFactory.get( TableSplitCacheImpl.class, fromTableName );
			if( fromTableSplit == null ) ExceptionFactory.throwIllegal( "IOS0014004", new String[]{ fromTableName } );
		}
		finally{
			
		}
		return fromTableSplit;
	}	
	
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFSubTableMapping(java.lang.String)
	 */
	public TableSplitMapping[] getSFSubTableMapping(String fromTableName) throws SFException, Exception {
		TableSplitMapping fromMapping[] = null;
		try
		{
			fromMapping = (TableSplitMapping[])CacheFactory.get( TableSplitMappingCacheImpl.class, 
					fromTableName );
		}
		finally{
			
		}
		return fromMapping;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFSubTableChain(java.lang.String)
	 */
	public IFunction getSFSubTableChain(String fromCLASS) throws SFException, Exception {
		IFunction fromChain = null;
		try
		{
			fromChain =(IFunction)CacheFactory.get( TableSplitFunctionCacheImpl.class, fromCLASS );
		}
		finally{
			
		}
		return fromChain;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFSubTableGroup()
	 */
	public ISubTableTemplate.ISubSQLCombine getSFSubTableGroup() throws SFException, Exception {
		ISubTableTemplate.ISubSQLCombine fromSubSQL = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_NETWORK, new String[]{ } );
			fromSubSQL = (ISubTableTemplate.ISubSQLCombine)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
		}
		finally{
			
		}
		return fromSubSQL;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFSubTablGroup(java.lang.String)
	 */
	public ISubTableTemplate.ISubSQLGroup getSFSubTableGroup(String aPLATFORM) throws SFException, Exception {
		ISubTableTemplate.ISubSQLGroup fromSubSQL = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_NETWORK, new String[]{ aPLATFORM } );
			fromSubSQL = (ISubTableTemplate.ISubSQLGroup)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
		}
		finally{
			
		}
		return fromSubSQL;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFSubTableCau(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public ISubTableTemplate.ISubSQLTableCau getSFSubTableCau(String aPLATFORM, 
			String aTABLE, 
			String aCOLUMN, 
			String aVALUE) throws SFException, Exception {
		ISubTableTemplate.ISubSQLTableCau fromCAU = null;
		try
		{
			aTABLE = OracleUtils.ICustom.getTableName( aTABLE );
			String fromUpffmx[] = new String[]{ aTABLE , "*" };
			for( int index = 0 ; index < fromUpffmx.length; index++ ){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_ROUTING , 
						new String[]{ aPLATFORM , fromUpffmx[index] , aCOLUMN , aVALUE} );
				fromCAU = (ISubTableTemplate.ISubSQLTableCau)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
				if( fromCAU != null ) break;
			}
		}
		finally{
			
		}
		return fromCAU;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterGroup(java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.ICenterGroup getSFCenterGroup(String aPLATFORM, String aCATEGORY) throws SFException, Exception {
		ISystemTemplate.ICenterGroup fromGroup = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffm[] = null;
			fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( aPLATFORM );
			for( int index = 0; fromUpffm != null && index < fromUpffm.length; index++ ){
				String fromINDEX =  ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_CENTER_ROUTING, 
						new String[]{ fromUpffm[index].getID() , aCATEGORY } );
				fromGroup = (ISystemTemplate.ICenterGroup)hget( IUpdcConst.ICache.IIUpdpbfgI , fromINDEX );
				if( fromGroup != null ){ break; }
			}
		}
		finally{
			
		}
		return fromGroup;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterOffer(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.ICenterRoute getSFCenterOffer(String aROUTE, 
			String aCATEGORY,
			String aPLATFORM) throws SFException, Exception {
		ISystemTemplate.ICenterRoute fromCAU = null;
		try
		{
			ISystemTemplate.ICenterGroup fromGroup = getSFCenterGroup( aPLATFORM, aCATEGORY );
			if( fromGroup != null ) fromCAU = fromGroup.getSUBFLOW( aROUTE );
			if( fromCAU == null ) ExceptionFactory.throwIllegal("IOS0011027", new String[]{aCATEGORY, aROUTE});
		}
		finally{
			
		}
		return fromCAU;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterOffer(java.lang.String, java.lang.String, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer)
	 */
	public ISystemTemplate.ICenterRoute getSFCenterOffer(String aROUTE_ID, 
			String aROUTE_TYPE,
			IPlatformTemplate.IUpffmOffer fromUpfm) throws SFException, Exception {
		ISystemTemplate.ICenterRoute fromCenter = null;
		try
		{
			ISystemTemplate.ICenterGroup fromGroup = null;
			IPlatformTemplate.IUpffmOffer fromUpffm[] = null;
			String fromUpffx[] = new String[]{ aROUTE_ID, "*" };
			fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( fromUpfm.getID() );
			for( int index = 0 ; fromUpffm != null && index < fromUpffm.length ; index++ ){
				fromGroup = getSFCenterGroup( fromUpffm[index].getID(), aROUTE_TYPE );
				if( fromGroup != null ){
					for( int aINDEX = 0 ; fromUpffx != null && aINDEX < fromUpffx.length; aINDEX++ ){
						fromCenter = fromGroup.getSUBFLOW( fromUpffx[aINDEX] );
						if( fromCenter != null ){ break;}
					}
				}
				if( fromCenter != null ){ break;}
			}
		}
		finally{
			
		}
		return fromCenter;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterSubFlow()
	 */
	public ISystemTemplate.ICenterRoute[] getSFCenterSubFlow() throws SFException, Exception {
		ISystemTemplate.ICenterRoute fromRoute[] = null;
		try
		{
			ISystemTemplate.ICenterGroup fromGroup = null;
			fromGroup = getSFCenterGroup( IUpdcConst.IUpfwm.IUpfm.ucmframe, IUpdcConst.IUpdbm.IUpdbf.SUBFLOW );
			if( fromGroup != null ){
				fromRoute = (ISystemTemplate.ICenterRoute[])fromGroup.getSUBFLOW().values().toArray( 
						new ISystemTemplate.ICenterRoute[]{} );
			}
		}
		finally{
			
		}
		return fromRoute;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterSubFlow(java.lang.String)
	 */
	public ISystemTemplate.ICenterRoute getSFCenterSubFlow(String aREGION_ID) throws SFException, Exception {
		ISystemTemplate.ICenterRoute fromRoute = null;
		try
		{
			ISystemTemplate.ICenterGroup fromGroup = null;
			fromGroup = getSFCenterGroup( IUpdcConst.IUpfwm.IUpfm.ucmframe, IUpdcConst.IUpdbm.IUpdbf.SUBFLOW );
			if( fromGroup != null ) fromRoute = fromGroup.getSUBFLOW( aREGION_ID );
			if( fromRoute == null ){ ExceptionFactory.throwIllegal("IOS0011076", new String[]{ aREGION_ID }); }
		}
		finally{
			
		}
		return fromRoute;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterSubFlow(long)
	 */
	public ISystemTemplate.ICenterRoute getSFCenterSubFlow(long aREGION_NUMBER) throws SFException, Exception {
		ISystemTemplate.ICenterRoute fromRoute = null;
		try
		{
			ISystemTemplate.ICenterGroup fromGroup = null;
			fromGroup = getSFCenterGroup( IUpdcConst.IUpfwm.IUpfm.ucmframe, IUpdcConst.IUpdbm.IUpdbf.SUBFLOW );
			if( fromGroup != null ) fromRoute = fromGroup.getCENTER( String.valueOf( aREGION_NUMBER ) );
			if( fromRoute == null ) { ExceptionFactory.throwIllegal("IOS0011080", new String[]{ 
					String.valueOf( aREGION_NUMBER ) }); }
		}
		finally{
			
		}
 		return fromRoute;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterWrapper(java.lang.String, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer)
	 */
	public ISystemTemplate.ICenterWrapper getSFCenterWrapper(String aIMPLCLASS, 
			IPlatformTemplate.IUpffmOffer fromUpfm) throws SFException, Exception {
		ISystemTemplate.ICenterWrapper fromCenter = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromNetWork[] = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( fromUpfm.getID() );
			for( int index = 0 ; fromNetWork != null && index < fromNetWork.length ; index++ ){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_CENTER_WRAPPER, new String[]{ 
						fromNetWork[index].getID(), aIMPLCLASS } );
				fromCenter = (ISystemTemplate.ICenterWrapper)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
				if( fromCenter != null ) { break; }
			}
		}
		finally{
			
		}
		return fromCenter;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterMapping(java.lang.String)
	 */
	public ISystemTemplate.ICenterMapping getSFCenterMapping(String aCATEGORY)
			throws SFException, Exception {
		ISystemTemplate.ICenterMapping fromUpfgsm = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_CENTER_MAPPING, 
					new String[]{aCATEGORY} );
			fromUpfgsm = (ISystemTemplate.ICenterMapping)hget( IUpdcConst.ICache.IIUpdpbfgI, 
					fromINDEX );
			if( fromUpfgsm == null ){
				ExceptionFactory.throwIllegal( "IOS0011075", new String[]{aCATEGORY});
			}
		}
		finally{
			
		}
		return fromUpfgsm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterCatalog(java.lang.String)
	 */
	public ISystemTemplate.ICenterCombine getSFCenterCatalog(String fromGROUP) throws SFException, Exception {
		ISystemTemplate.ICenterCombine fromCombine = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_CENTER_CATALOG, 
					new String[]{ fromGROUP } );
			fromCombine = (ISystemTemplate.ICenterCombine)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
		}
		finally{
			
		}
		return fromCombine;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFCenterCatalog(java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.ICenterCatalog getSFCenterCatalog(String aIMPLCLASS, String fromGROUP) throws SFException, Exception {
		ISystemTemplate.ICenterCatalog fromCatalog = null;
		try 
		{
			ISystemTemplate.ICenterCombine fromCombine = getSFCenterCatalog( fromGROUP );
			if( fromCombine != null ){
				fromCatalog = fromCombine.getCatalog( aIMPLCLASS );
			}
		}
		finally {
			
		}
		return fromCatalog;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpfgkmParallel(java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.IUpfgkmParallel getSFUpfgkmParallel(String orignate,String regionId) throws SFException, Exception {
		ISystemTemplate.IUpfgkmParallel fromParallel = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SYSTEM_PARALLEL,
					new String[]{ orignate,regionId});
			fromParallel = (ISystemTemplate.IUpfgkmParallel)hget(IUpdcConst.ICache.IIUpdpbfgI, fromINDEX);
		}
		finally{
			
		}
		return fromParallel;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpfgkmResource(java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.IUpfgkmResource getSFUpfgkmResource(String resource, java.lang.String category) throws SFException, Exception {
		ISystemTemplate.IUpfgkmResource fromResource = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_MULTLE_RESOURCE,
					new String[]{ category.toUpperCase(), resource });
			fromResource = (ISystemTemplate.IUpfgkmResource)hget(IUpdcConst.ICache.IIMultlesI, fromINDEX);
		}
		finally{
			
		}
		return fromResource;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpfgkmOffice(java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.IUpfgkmOfficeX getSFUpfgkmOffice(String fromBILL,
			String fromCATEGORY) throws SFException, Exception {
		ISystemTemplate.IUpfgkmOfficeX fromOffice = null;
		try
		{
			ISystemTemplate.IUpfgkmOffice fromSection = null;
			String fromSEGMENT = StringUtils.substring( fromBILL, 0, 7 );
			String fromOfficeX[] = new String[]{ fromSEGMENT, "*" };
			for( int index = 0; fromOfficeX != null && index < fromOfficeX.length; index++ ){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_OFFICE_SECTION , 
						new String[]{ fromOfficeX[index], fromCATEGORY } ); 
				fromSection = (ISystemTemplate.IUpfgkmOffice)hget( IUpdcConst.ICache.IIUpfmsgtI, fromINDEX );
				if( fromSection != null && fromSection.getSUBFLOW().size() > 0 ){
					fromOffice = fromSection.getOFFICE( fromBILL );
					break;
				}
			}
			if( fromOffice == null ) {ExceptionFactory.throwException("IOS0011039", new String[]{fromBILL});}
		}
		finally{
			
		}
		return fromOffice;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpfgkmOffice(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.IUpfgkmOfficeX getSFUpfgkmOffice(String fromBILL_ID,
			String fromHEADNUM,
			String fromCATEGORY) throws SFException, Exception {
		ISystemTemplate.IUpfgkmOfficeX fromOffice = null;
		try
		{
			ISystemTemplate.IUpfgkmOffice fromSection = null;
			String fromSEGMENT = fromHEADNUM.length() <= 7?fromHEADNUM:StringUtils.substring( fromHEADNUM, 0, 7 );
			String fromOfficeX[] = new String[]{ fromSEGMENT, "*" };
			for( int index = 0; index < fromOfficeX.length; index++ ){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_OFFICE_SECTION, 
						new String[]{fromOfficeX[index], fromCATEGORY } ); 
				fromSection = (ISystemTemplate.IUpfgkmOffice)hget( IUpdcConst.ICache.IIUpfmsgtI, fromINDEX );
				if( fromSection != null && fromSection.getSUBFLOW().size() > 0 ){
					fromOffice = fromSection.getOFFICE( fromBILL_ID );
					break;
				}
			}
		}
		finally{
			
		}
		return fromOffice;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpdbfsOffer(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public ISystemTemplate.IUpdbfsCombine getSFUpdbfsOffer(String fromCatalog,
			String fromBusines,
			String fromBatches, 
			String fromChannel) throws SFException, Exception {
		ISystemTemplate.IUpdbfsCombine fromCombine = null;
		try
		{
			if( StringUtils.isBlank( fromBatches ) ) fromBatches = "0";
			String fromLimite[][] = new String[][]{
				    {fromCatalog, fromBusines, fromChannel,fromBatches}, {fromCatalog, fromBusines, "*"        ,fromBatches},
				    {fromCatalog, fromBusines, fromChannel,"*"        }, {fromCatalog, fromBusines, "*"        ,"*"        },
				    {"*"        , fromBusines, "*"        ,"*"        }, {fromCatalog, "*"        , "*"        ,"*"        }, 
				    {"*"        , "*"        , "*"        ,"*"        }};
			for( int index = 0; fromLimite != null && index < fromLimite.length; index++ ){
				String fromINDEX = ClassUtils.getINDEX(IUpdcConst.ICache.ICachePref.I_PRIORITY_BUSINESS, 
						new String[]{IUpdcConst.IUpfwm.IUpfm.ucmframe, fromLimite[index][0], fromLimite[index][1], 
								fromLimite[index][3], fromLimite[index][2] } );
				fromCombine = (ISystemTemplate.IUpdbfsCombine)hget(IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
				if( fromCombine != null ){ break; }
			}
		}
		finally{
			
		}
		return fromCombine;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpffmxOffer()
	 */
	public ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer() throws SFException, Exception {
		ISystemTemplate.IUpdbfsGroup fromGroup = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PRIORITY_LIMITE, 
					new String[]{ IUpdcConst.IUpfwm.IUpfm.ucmframe, IUpdcConst.IEnum.PRIORITY } );
			fromGroup = (ISystemTemplate.IUpdbfsGroup)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
		}
		finally{
			
		}
		return fromGroup;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpffmxOffer(long)
	 */
	public ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer(long aPRIORITY) throws SFException, Exception {
		ISystemTemplate.IUpdbfsGroup fromGroup = null;
		try
		{
			String fromLimite[] = new String[]{ SystemUtils.IMagic._priority( aPRIORITY ), "*" };
			for( int index = 0; fromLimite != null && index < fromLimite.length; index++ ){
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PRIORITY_LIMITE, 
						new String[]{ IUpdcConst.IUpfwm.IUpfm.ucmframe, fromLimite[index] } );
				fromGroup = (ISystemTemplate.IUpdbfsGroup)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
				if( fromGroup != null ){ break; }
			}
		}
		finally{
			
		}
		return fromGroup;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.interfaces.IBasicSRV#getSFUpffmxOffer(long, java.lang.String)
	 */
	public ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer(long aPRIORITY, String aPLATFORM) throws SFException, Exception {
		ISystemTemplate.IUpdbfsGroup fromGroup = null;
		try
		{
			String fromLimite[] = new String[]{ SystemUtils.IMagic._priority( aPRIORITY ), "*" };
			IPlatformTemplate.IUpffmOffer fromUpffm[] = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( aPLATFORM );
			for( int index = 0; fromUpffm != null && index < fromUpffm.length; index++ ){
				for( int iterap = 0; fromLimite != null && iterap < fromLimite.length; iterap++ ){
					String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PRIORITY_LIMITE, 
							new String[]{ fromUpffm[index].getID(), fromLimite[iterap] } );
					fromGroup = (ISystemTemplate.IUpdbfsGroup)hget( IUpdcConst.ICache.IIUpdpbfgI, fromINDEX );
					if( fromGroup != null ){ break; }
				}
				if( fromGroup != null ){ break; }
			}
		}
		finally{
			
		}
		return fromGroup;
	}
	
}
