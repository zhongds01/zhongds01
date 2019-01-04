package com.ai.sacenter.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.complex.self.po.TableSplit;
import com.ai.appframe2.complex.self.po.TableSplitMapping;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQCSQLTable;
import com.ai.sacenter.jdbc.HQSQLConst;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLSubSQLBean;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jdbc.dialect.MySQL5HQSQLTable;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLTable;
import com.ai.sacenter.jdbc.dialect.SybaseHQSQLTable;
import com.ai.sacenter.subtable.ITableSplitWrapper;
import com.ai.sacenter.subtable.SFSubTableFactory;
import com.ai.sacenter.util.ClassUtils.IClass;
import com.ai.sacenter.valuebean.ISubTableTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年2月21日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class HQSQLUtils {
	private final static Log log = LogFactory.getLog( HQSQLUtils.class );
	private static final java.util.Map _runtime_repository = new java.util.concurrent.ConcurrentHashMap();
	public HQSQLUtils() {
		super();
	}
	
	/**
	 * 
	 * @param aCLASS
	 * @return
	 */
	public static HQCSQLTable getHQSQLTable( Class aCLASS ){
		HQCSQLTable fromHQSQL = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX(new String[]{"_$_HQSQLTable", "_$_", aCLASS.getName()} );
			if( ( fromHQSQL = (HQCSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
				synchronized ( _runtime_repository ){
					if( ( fromHQSQL = (HQCSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
						String aJdblLife = aCLASS.getName();
						if( StringUtils.endsWith( aJdblLife, "Buff" ) ) 
							aJdblLife = StringUtils.trimLeft( aJdblLife, aJdblLife.length() - "Buff".length() ); 
						else if( StringUtils.endsWith( aJdblLife, "Wait" ) ) 
							aJdblLife = StringUtils.trimLeft( aJdblLife, aJdblLife.length() - "Wait".length() );
						else if( StringUtils.endsWith( aJdblLife, "Fail" ) ) 
							aJdblLife = StringUtils.trimLeft( aJdblLife, aJdblLife.length() - "Fail".length() );
						else if( StringUtils.endsWith( aJdblLife, "His" ) ) 
							aJdblLife = StringUtils.trimLeft( aJdblLife, aJdblLife.length() - "His".length() );
						if( IClass.isAssignable( aJdblLife ) == false ) aJdblLife = aCLASS.getName();
						ObjectType aTYPE = ((DataStructInterface)Class.forName(aJdblLife).newInstance()).getObjectType();
						fromHQSQL = new HQCSQLTable( aTYPE , aTYPE.getMapingEnty() , Class.forName( aJdblLife )  );
						
						String aJdblmoLife = ClassUtils.getINDEX( new String[]{ aJdblLife , "Wait" } );
						if( IClass.isAssignable( aJdblmoLife ) ) fromHQSQL.setSuggest( Class.forName( aJdblmoLife ) );
						aJdblmoLife = ClassUtils.getINDEX( new String[]{ aJdblLife , "Fail" } );
						if( IClass.isAssignable( aJdblmoLife ) ) fromHQSQL.setFail( Class.forName( aJdblmoLife ) );
						aJdblmoLife = ClassUtils.getINDEX( new String[]{ aJdblLife , "Buff" } );
						if( IClass.isAssignable( aJdblmoLife ) ) fromHQSQL.setBuffer( Class.forName( aJdblmoLife ) );
						aJdblmoLife = ClassUtils.getINDEX( new String[]{ aJdblLife , "His" } );
						if( IClass.isAssignable( aJdblmoLife ) ) fromHQSQL.setHistory( Class.forName( aJdblmoLife ) );
						_runtime_repository.put( fromINDEX, fromHQSQL );
					}
				}
			}
		}
		catch( java.lang.Exception aEXCEPTION){
			ExceptionFactory.throwRuntime( aEXCEPTION );
		}
		finally{
			
		}
		return fromHQSQL;
	}
	
	/**
	 * 根据表名获取归档校验物理表结构
	 * @param _table_type
	 * @return
	 * @throws SFException
	 */
	public static HQSQLTable getCheckSum( ObjectType _table_type ) throws SFException{
		HQSQLTable _table = null;
		try
		{
			class SFUpfgkmTableImpl{
				public SFUpfgkmTableImpl(){
					super();
				}
				
				/**
				 * 
				 * @param _table_name
				 * @return
				 */
				public String _jj_tabledefineindex( String _table_name ){
					return ClassUtils.getINDEX( new String[]{"_MYSQL5_HOST_", "NULL", "_$_", _table_name } );
				}
				
				/**
				 * 
				 * @param fromGroup
				 * @throws SFException
				 * @throws Exception
				 */
				public void _jj_tabledefine( ISystemTemplate.IUpfgkmGroup fromGroup ) throws SFException,Exception{
					try
					{
						for( java.util.Iterator itera = fromGroup.getSUBFLOW().values().iterator();itera.hasNext(); ){
							ISystemTemplate.IUpfgkmComposite _composite = (ISystemTemplate.IUpfgkmComposite)itera.next();
							try
							{
								ObjectType _objecttype = ClassUtils.IClass.getASTBOType( _composite.getPERSISTENT() );
								String fromINDEX = _jj_tabledefineindex( _objecttype.getMapingEnty() );
								if( _composite.isCOMPLETE() == false /*非归档检验*/){
									HQSQLTable _table = new HQSQLTable( _objecttype.getMapingEnty() );
									_runtime_repository.put( fromINDEX, _table );
								}
								else{
									HQSQLTable _table = OracleUtils.getITableDefine( _composite.getCOMPOSITE(), _objecttype.getMapingEnty() );
									if( _table != null ){
										_table.setActive( HQSQLConst.Category.Status.ACTIVE );
									}
									else{
										_table = new HQSQLTable( _composite.getCOMPOSITE(), _objecttype.getMapingEnty() );
									}
									_runtime_repository.put( fromINDEX, _table );
								}
							}
							catch( java.lang.Exception exception ){
								log.error( exception.getMessage(), exception );
								String fromINDEX = _jj_tabledefineindex( _composite.getID() );
								HQSQLTable _table = new HQSQLTable( _composite.getID() );
								_runtime_repository.put( fromINDEX, _table );
							}
							
						}
					}
					finally{
						
					}
				}
			}
			SFUpfgkmTableImpl fromUpfgkmImpl = new SFUpfgkmTableImpl();
			String _table_name = null;
			try
			{
				_table_name = _table_type.getMapingEnty();
				String fromINDEX = fromUpfgkmImpl._jj_tabledefineindex( _table_name );
				if( ( _table = (HQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
					synchronized ( _runtime_repository ) {
						if( ( _table = (HQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
							ISystemTemplate.IUpfgkmComposite _composite = ISystem.getSFUpfgkmComposite( _table_name );
							if( _composite == null ){
								_runtime_repository.put( fromINDEX, _table = new HQSQLTable( _table_name ) );
							}
							else{
								fromUpfgkmImpl._jj_tabledefine( ISystem.getSFUpfgkmComposite() );
								_table = (HQSQLTable)_runtime_repository.get( fromINDEX );
							}
						}
					}
				}
			}
			catch( java.lang.Exception exception ){
				ExceptionFactory.throwOracleInside("IOS0014013", new String[]{"NULL",
						_table_name != null?_table_name:"*", 
						exception.getMessage()}, 
						exception );
			}
			finally{
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
		return _table != null && _table.isACTIVE() ?_table:null;
	}
	
	/**
	 * 初始化数据库所在用户下表[主表或具体分表]结构,如用户表不存在则抛出异常
	 * @param _owner 数据源
	 * @param _table_name 表名[可带分表标识]
	 * @return
	 */
	public static MySQL5HQSQLTable getMYSQLTable( String _owner, String _table_name ){
		MySQL5HQSQLTable fromMYSQL = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( new String[]{"_MYSQL5_", _owner != null?_owner:"NULL", "_$_", _table_name } );
			if( ( fromMYSQL = (MySQL5HQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
				synchronized ( _runtime_repository ) {
					if(( fromMYSQL = (MySQL5HQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
						HQSQLTable _table = null;
						try
						{
							boolean fromExist = OracleUtils.isExistTable( _owner, _table_name );
							if( fromExist == false ) 
								fromMYSQL = new MySQL5HQSQLTable( _owner, _table_name );
							else{
								_table = OracleUtils.getITableDefine( _owner, _table_name );
								fromMYSQL = new MySQL5HQSQLTable( _owner, _table_name, _table );
								fromMYSQL.setActive( HQSQLConst.Category.Status.ACTIVE );
							}
						}
						finally{
							if( _table != null ){ _table = null; }
						}
						_runtime_repository.put( fromINDEX , fromMYSQL );
						if( ( fromMYSQL != null && fromMYSQL.isACTIVE()) == false ){
							ExceptionFactory.throwOracle("IOS0014001", new String[]{_owner, _table_name } );
						}
					}
				}
			}
		}
		catch( java.lang.Exception aEXCEPTION){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{_owner,
					_table_name, 
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		return fromMYSQL;
	}
	
	/**
	 * 初始化数据库所在用户下计算出具体分表表结构,如用户表不存在则抛出异常
	 * @param fromEntity
	 * @return
	 */
	public static MySQL5HQSQLTable getMYSQLTable( HQSQLEntityBean fromEntity ){
		MySQL5HQSQLTable fromMYSQL = null;
		HQSQLTable _table = fromEntity.getObjectType();
		try
		{
			String _owner = OracleUtils.getTransactionName( fromEntity.getProperties() );
			String _table_name = SFSubTableFactory.createTableName( _table.getMapingEnty(), fromEntity.getProperties() );
			fromMYSQL = getMYSQLTable( _owner, _table_name );
		}
		catch( java.lang.Exception aEXCEPTION){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{_table.getDataSource(),
					_table.getMapingEnty(), 
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		finally{
			
		}
		return fromMYSQL;
	}
	
	/**
	 * 初始化数据库所在用户下表[主表或具体分表]结构
	 * 如用户下不存在此表则返回NULL
	 * @param _owner 数据源
	 * @param _table_name 表名[可带分表]
	 * @return
	 */
	public static SybaseHQSQLTable getSybaseTable( String _owner, String _table_name ){
		SybaseHQSQLTable fromSYBASE = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX( new String[]{"_SYBASE_", _owner != null?_owner:"NULL", "_$_", _table_name } );
			if( ( fromSYBASE = (SybaseHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
				synchronized ( _runtime_repository ) {
					if(( fromSYBASE = (SybaseHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
						HQSQLTable _table = null;
						try
						{
							boolean fromExist = OracleUtils.isExistTable( _owner, _table_name );
							if( fromExist == false ) 
								fromSYBASE = new SybaseHQSQLTable( _owner, _table_name );
							else{
								_table = OracleUtils.getITableDefine( _owner, _table_name );
								fromSYBASE = new SybaseHQSQLTable( _owner, _table_name, _table );
								fromSYBASE.setActive( HQSQLConst.Category.Status.ACTIVE );
							}
						}
						finally{
							if( _table != null ){ _table = null; }
						}
						_runtime_repository.put( fromINDEX , fromSYBASE );
					}
				}
			}
		}
		catch( java.lang.Exception aEXCEPTION){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{_owner,
					_table_name, 
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		return fromSYBASE != null && fromSYBASE.isACTIVE()?fromSYBASE:null;
	}
	
	/**
	 * 初始化数据库所在用户下具体分表结构[如用户下不存在此表则抛异常]
	 * @param fromOWNER 数据库所在用户
	 * @param fromTABLE 分表表名[不可带分表]
	 * @return
	 */
	public static SybaseHQSQLTable getSYBASETable( String fromOWNER, String fromTABLE ){
		SybaseHQSQLTable fromSYBASE = null;
		try
		{
			fromSYBASE = HQSQLUtils.getSybaseTable( fromOWNER, fromTABLE );
			if( fromSYBASE == null ) ExceptionFactory.throwOracle("IOS0014001", new String[]{fromOWNER , fromTABLE } );
		}
		catch( java.lang.Exception aEXCEPTION){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{fromOWNER,
					fromTABLE, 
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		finally{
			
		}
		return fromSYBASE;
	}
	
	/**
	 * 初始化数据库所在用户下主表结构[如用户下不存在此表则抛异常]
	 * @param _table_name 仓库表名[可带分表标识]
	 * @param fromEntity 数据仓库
	 * @return
	 */
	public static SybaseHQSQLTable getSYBASETable( String _table_name, java.util.Map fromEntity ){
		SybaseHQSQLTable fromSYBASE = null;
		try
		{
			String fromOWNER = OracleUtils.getTransactionName( fromEntity );
			fromSYBASE = HQSQLUtils.getSybaseTable( fromOWNER, _table_name );
			if( fromSYBASE == null ) ExceptionFactory.throwOracle("IOS0014001", new String[]{fromOWNER, _table_name } );
		}
		catch( java.lang.Exception aEXCEPTION){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{"*",
					_table_name, 
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		finally{
			
		}
		return fromSYBASE;
	}
	
	/**
	 * 初始化数据库所在用户下主表[可带分表标识]结构
	 * @param _owner 数据源
	 * @param _objecttype 
	 * @return
	 */
	public static OracleHQSQLTable getOracleTable( String _owner, ObjectType _objecttype ){
		OracleHQSQLTable fromORACLE = null;
		String _table_name = null;
		try
		{
			_table_name = _objecttype.getMapingEnty();
			String fromINDEX = ClassUtils.getINDEX( new String[]{"_ORACLE_", _owner != null?_owner:"NULL", "_$_", _table_name } );
			if(( fromORACLE = (OracleHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
				synchronized ( _runtime_repository ) {
					if( ( fromORACLE = (OracleHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
						fromORACLE = new OracleHQSQLTable( _owner, _objecttype.getMapingEnty(), _objecttype );
						fromORACLE.setActive( HQSQLConst.Category.Status.ACTIVE );
						_runtime_repository.put( fromINDEX, fromORACLE );
					}
				}
			}
		}
		catch( java.lang.Exception aEXCEPTION){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{_owner,
					_table_name != null?_table_name:"*",
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		return fromORACLE;
	}
	
	/**
	 * 初始化数据所在用户下主表结构[如用户下不存在此表则抛异常][包含JDBC_SYBASE和JDBC_ORACLE模式]
	 * 判断规则：根据服务表名查询服务持久化SA_PERSISTENT对象，
	 * 如存在该表持久化对象，则采用JDBC_ORACLE模式，否则抛出异常
	 * @param _table_name 表名
	 * @return
	 */
	public static OracleHQSQLTable getOracleTable( String _table_name ){
		OracleHQSQLTable fromORACLE = null;
		try
		{
			ISystemTemplate.IUpfgkmComposite _composite = ISystem.getSFUpfgkmComposite( _table_name );
			if( _composite == null ){ ExceptionFactory.throwOracle("IOS0014025", new String[]{ _table_name } ); }
			ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( _composite.getPERSISTENT() );
			fromORACLE = HQSQLUtils.getOracleTable( null, fromTYPE );
		}
		catch( java.lang.Exception aEXCEPTION ){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{"NULL",
					_table_name, 
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		finally{
			
		}
		return fromORACLE;
	}
	
	/**
	 * 初始化数据所在用户下主表结构[如用户下不存在此表则抛异常][包含JDBC_SYBASE和JDBC_ORACLE模式]
	 * 判断规则：根据服务表名查询服务持久化SA_PERSISTENT对象，
	 * 如存在该表持久化对象，则采用JDBC_ORACLE模式，否则抛出异常
	 * @param _table_name 表名[可带分表]
	 * @param fromEntity 
	 * @return
	 */
	public static OracleHQSQLTable getOracleTable( String _table_name, java.util.Map fromEntity){
		OracleHQSQLTable fromORACLE = null;
		try
		{
			String _owner = OracleUtils.getTransactionName( fromEntity );
			ISystemTemplate.IUpfgkmComposite _composite = ISystem.getSFUpfgkmComposite( _table_name );
			if( _composite == null ) ExceptionFactory.throwOracle("IOS0014025", new String[]{ _table_name } );
			ObjectType _ojecttype = ClassUtils.IClass.getASTBOType( _composite.getPERSISTENT() );
			fromORACLE = HQSQLUtils.getOracleTable( _owner, _ojecttype );
		}
		catch( java.lang.Exception aEXCEPTION ){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{"*",
					_table_name, 
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		finally{
			
		}
		return fromORACLE;
	}
	
	/**
	 * 初始化数据所在用户下主表结构[如用户下不存在此表则抛异常][包含JDBC_SYBASE和JDBC_ORACLE模式]
	 * 判断规则：根据服务表名查询服务持久化SA_PERSISTENT对象，
	 * 如存在该表持久化对象，则采用JDBC_ORACLE模式，否则抛出异常
	 * @param _owner 数据源
	 * @param _table_name 表名
	 * @return
	 */
	public static OracleHQSQLTable getOracleTable( String _owner, String _table_name ){
		OracleHQSQLTable fromORACLE = null;
		try
		{
			ISystemTemplate.IUpfgkmComposite fromSubTable = null;
			fromSubTable = ISystem.getSFUpfgkmComposite( _table_name );
			if( fromSubTable == null ) ExceptionFactory.throwOracle("IOS0014025", new String[]{ _table_name } );
			ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( fromSubTable.getPERSISTENT() );
			fromORACLE = HQSQLUtils.getOracleTable( _owner, fromTYPE );
		}
		catch( java.lang.Exception aEXCEPTION ){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{_owner,
					_table_name, 
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		finally{
			
		}
		return fromORACLE;
	}
	
	/**
	 * 初始化数据库表所在用户下物理分表结构，如用户下不存在物理分表则抛异常
	 * @param fromEntity
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static OracleHQSQLTable getOracleTable( DataStructInterface fromEntity ) throws SFException,Exception{
		OracleHQSQLTable fromORACLE = null;
		try
		{
			ObjectType _objecttype = fromEntity.getObjectType();
			String _owner = OracleUtils.getTransactionName( _objecttype, fromEntity.getProperties() );
			String _table_name = SFSubTableFactory.createTableName( _objecttype.getMapingEnty(), fromEntity.getProperties() );
			String fromINDEX = ClassUtils.getINDEX( new String[]{"_ORACLE_", _owner, "_$_", _table_name, "_$_", _objecttype.getFullName() } );
			if(( fromORACLE = (OracleHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
				synchronized ( _runtime_repository ){
					if(( fromORACLE = (OracleHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
						fromORACLE = new OracleHQSQLTable( _owner, _table_name, _objecttype );
						fromORACLE.setActive( HQSQLConst.Category.Status.ACTIVE );
						_runtime_repository.put( fromINDEX, fromORACLE );
					}
				}
			}
			if( fromORACLE == null || fromORACLE.isACTIVE() == false ){
				ExceptionFactory.throwOracle("IOS0014001", new String[]{ _owner, _table_name } );
			}
		}
		finally{
			
		}
		return fromORACLE;
	}
	
	/**
	 * 初始化数据库表所在用户下物理分表结构，如用户下不存在物理分表则返回为NULL
	 * @param composite 数据仓库类
	 * @param entity 数据实体
	 * @return
	 * @throws SFException
	 */
	public static OracleHQSQLTable getOracleTable(Class<?> composite, DataStructInterface entity ) throws SFException{
		OracleHQSQLTable fromORACLE = null;
		String _table_name_ = null;
		try
		{
			ObjectType __objecttype__ = entity.getObjectType();
			if( composite == null ){ composite = IUpdcConst.IUpdbm.IUpdcDAO; }
			_table_name_ = SFSubTableFactory.createTableName( __objecttype__.getMapingEnty(), entity.getProperties() );
			String fromINDEX = ClassUtils.getINDEX( new String[]{"_ORACLE_", composite.getName(), "_$_", __objecttype__.getMapingEnty(), "_$_", _table_name_ } );
			if(( fromORACLE = (OracleHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
				synchronized ( _runtime_repository ){
					if(( fromORACLE = (OracleHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
						try
						{
							String _owner_name_ = OracleUtils.getTransactionName( composite, entity );
							boolean _table_exist_ = OracleUtils.isExistTable( _owner_name_, _table_name_ );
							if( _table_exist_ == false ){
								fromORACLE = new OracleHQSQLTable( null, _table_name_, __objecttype__ );
								fromORACLE.setActive( HQSQLConst.Category.Status.ACTIVE );
							}
							else{
								HQSQLTable __table__ = OracleUtils.getITableDefine( _owner_name_, _table_name_ );
								fromORACLE = new OracleHQSQLTable( __table__, __objecttype__ );
								fromORACLE.setActive( HQSQLConst.Category.Status.ACTIVE );
							}
						}
						catch( java.lang.Exception exception ){
							fromORACLE = new OracleHQSQLTable( null, _table_name_, __objecttype__ );
							fromORACLE.setActive( HQSQLConst.Category.Status.ACTIVE );
						}
						_runtime_repository.put( fromINDEX, fromORACLE );
					}
				}
			}
		}
		catch( java.lang.Exception _exception ){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{composite.getName(),
					_table_name_, 
					_exception.getMessage()}, 
					_exception );
		}
		finally{
			
		}
		return fromORACLE != null && fromORACLE.isACTIVE()?fromORACLE:null;
	}
	
	/**
	 * 初始化数据库表所在用户下物理分表结构，如用户下不存在物理分表则抛异常
	 * @param composite 数据仓库类
	 * @param _table_name_ 基表表名
	 * @param entity 数据实体
	 * @return
	 * @throws SFException
	 */
	public static HQSQLTable getOracleTable(Class<?> composite, String _table_name_, DataStructInterface entity ) throws SFException{
		HQSQLTable fromORACLE = null;
		try
		{
			ObjectType __objecttype__ = entity.getObjectType();
			if( composite == null ){ composite = IUpdcConst.IUpdbm.IUpdcDAO; }
			_table_name_ = SFSubTableFactory.createTableName( _table_name_, entity.getProperties() );
			String fromINDEX = ClassUtils.getINDEX( new String[]{"_ORACLE_", composite.getName(), "_$_", __objecttype__.getMapingEnty(), "_$_", _table_name_ } );
			if(( fromORACLE = (HQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
				synchronized ( _runtime_repository ){
					if(( fromORACLE = (HQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
						HQSQLTable __table__ = null;
						try
						{
							String _owner_name_ = OracleUtils.getTransactionName( composite, entity );
							boolean _table_exist_ = OracleUtils.isExistTable( _owner_name_, _table_name_ );
							if( _table_exist_ == false ){
								ExceptionFactory.throwOracleConnect("IOS0014001", new String[]{_owner_name_, _table_name_ } );
							}
							else{
								__table__ = OracleUtils.getITableDefine( _owner_name_, _table_name_ );
								fromORACLE = new SybaseHQSQLTable( _owner_name_, _table_name_, __table__ );
								fromORACLE.setActive( HQSQLConst.Category.Status.ACTIVE );
							}
						}
						finally{
							if( __table__ != null ){ __table__ = null; }
						}
						_runtime_repository.put( fromINDEX, fromORACLE );
					}
				}
			}
		}
		catch( java.lang.Exception _exception ){
			ExceptionFactory.throwOracle("IOS0014013", new String[]{composite.getName(),
					_table_name_, 
					_exception.getMessage()}, 
					_exception );
		}
		finally{
			
		}
		return fromORACLE;
	}
	
	/**
	 * 初始化数据库表所在用户下物理分表结构，如用户下不存在物理分表则抛异常
	 * @param _owner
	 * @param fromEntity
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static OracleHQSQLTable getOracleSubTable( String _owner, DataContainer fromEntity ) throws SFException,Exception{
		OracleHQSQLTable fromORACLE = null;
		try
		{
			ObjectType _objecttype = fromEntity.getObjectType();
			String _table_name = SFSubTableFactory.createTableName( _objecttype.getMapingEnty(), fromEntity.getProperties() );
			String fromINDEX = ClassUtils.getINDEX( new String[]{"_ORACLE_", _owner, "_$_", _table_name, "_$_", _objecttype.getFullName() } );
			if(( fromORACLE = (OracleHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
				synchronized ( _runtime_repository ){
					if(( fromORACLE = (OracleHQSQLTable)_runtime_repository.get( fromINDEX ) ) == null ){
						fromORACLE = new OracleHQSQLTable( _owner, _table_name, _objecttype );
						fromORACLE.setActive( HQSQLConst.Category.Status.ACTIVE );
						_runtime_repository.put( fromINDEX, fromORACLE );
					}
				}
			}
		}
		finally{
			
		}
		return fromORACLE;
	}
	
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 是否满足提交数据库
		 * @param fromHQSQL
		 * @return
		 */
		public static boolean isCommit( HQSQLEntityBean fromHQSQL ){
			return fromHQSQL.isDeleted() || fromHQSQL.isNew() || fromHQSQL.isModified();
		}
		
		/**
		 * 
		 * @param _persistent
		 * @return
		 * @throws Exception
		 */
		public static HQSQLEntityBean getASTBOEntity( String _persistent ) throws Exception{
			HQSQLEntityBean fromEntity = null;
			try
			{
				ObjectType fromTYPE = IClass.getASTBOType( _persistent );
				fromEntity = new HQSQLSubSQLBean( fromTYPE );
			}
			finally{
				
			}
			return fromEntity;
		}
		
		/**
		 * 
		 * @param fromTYPE
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean getASTBOEntity( HQSQLTable fromTYPE ) throws SFException, Exception {
			HQSQLEntityBean fromEntity = null;
			try 
			{
				if( fromTYPE instanceof OracleHQSQLTable ){
					fromEntity = new HQSQLSubSQLBean( (OracleHQSQLTable)fromTYPE );
				}
				else{
					fromEntity = new HQSQLEntityBean( fromTYPE );
				}
			} 
			finally{

			}
			return fromEntity;
		}
		
		/**
		 * 
		 * @param fromTYPE
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public HQSQLEntityBean getASTBOEntity( String _persistent, HQSQLEntityBean fromEntity ) throws SFException,Exception{
			HQSQLEntityBean fromSubJect = null;
			try
			{
				fromSubJect = ICustom.getASTBOEntity( _persistent );
				ICustom.transfer( fromEntity, fromSubJect );
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromTYPE
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean getASTBOEntity( HQSQLTable fromTYPE, HQSQLEntityBean fromEntity ) throws SFException,Exception{
			HQSQLEntityBean fromSubJect = null;
			try
			{
				fromSubJect = ICustom.getASTBOEntity( fromTYPE );
				ICustom.transfer( fromEntity, fromSubJect );
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param _container
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean transfer( DataStructInterface _container ) throws SFException, Exception{
			HQSQLEntityBean fromSubJect = null;
			try
			{
				fromSubJect = new HQSQLSubSQLBean( _container.getObjectType() );
				HQSQLUtils.ICustom.transfer( _container, fromSubJect );
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromSubSQL
		 * @param fromSubJect
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean transfer( java.util.Map fromSubSQL, HQSQLEntityBean fromSubJect ) throws SFException, Exception{
			try
			{
				for( java.util.Iterator itera = fromSubSQL.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					fromSubJect.set( (String)fromEntry.getKey(), fromEntry.getValue() );
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromSubSQL
		 * @param fromSubJect
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean transfer( DataStructInterface fromSubSQL, HQSQLEntityBean fromSubJect ) throws SFException, Exception{
			try
			{
				for( java.util.Iterator itera = fromSubSQL.getNewProperties().entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					fromSubJect.set( (String)fromEntry.getKey(), fromEntry.getValue() );
				}
				for( java.util.Iterator itera = fromSubSQL.getOldProperties().entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					fromSubJect.initProperty( (String)fromEntry.getKey(), fromEntry.getValue() );
				}
				if( fromSubSQL.isDeleted() ){ fromSubJect.delete(); }
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromSubJect
		 * @param fromSubSQL
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static DataStructInterface transfer( HQSQLEntityBean fromSubJect, DataContainer fromSubSQL ) throws SFException, Exception{
			try
			{
				for( java.util.Iterator itera = fromSubJect.getNewProperties().entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					String _column_name = (String)fromEntry.getKey();
					if( fromSubSQL.hasPropertyName( _column_name ) ){
						fromSubSQL.set( _column_name, fromEntry.getValue() );
					}
				}
			}
			finally{
				
			}
			return fromSubSQL;
		}
		
		/**
		 * 
		 * @param _objective
		 * @param fromTYPE
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean transfer( Object _objective, HQSQLTable fromTYPE ) throws SFException, Exception{
			HQSQLEntityBean fromEntity = null;
			try 
			{
				if( _objective != null && _objective instanceof HQSQLEntityBean ){
					fromEntity = (HQSQLEntityBean)_objective;
				}
				else if( _objective != null && _objective instanceof java.util.Map ){
					fromEntity = ICustom.getASTBOEntity( fromTYPE );
					java.util.Map fromSubSQL = (java.util.Map)_objective;
					for( java.util.Iterator itera = fromSubSQL.entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
						fromEntity.set( (String)fromEntry.getKey(), fromEntry.getValue() );
					}
				}
				else if( _objective != null && _objective instanceof DataStructInterface ){
					fromEntity = ICustom.getASTBOEntity( fromTYPE );
					DataStructInterface fromSubSQL = (DataStructInterface)_objective;
					for( java.util.Iterator itera = fromSubSQL.getProperties().entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
						fromEntity.set( (String)fromEntry.getKey(), fromEntry.getValue() );
					}
				}
				else if( _objective != null ){
					ExceptionFactory.throwIllegal("IOS0014011", new Object[]{ _objective.getClass().getName() } );
				}
			} 
			finally{

			}
			return fromEntity;
		}
		
		/**
		 * 把fromObject转换为toObject
		 * @param fromObject 原BO对象
		 * @param toObject  目标BO对象
		 * @throws Exception
		 */
		public static void transfer( HQSQLEntityBean fromObject, HQSQLEntityBean toObject ) throws Exception{
			try
			{
				for( java.util.Iterator itera = fromObject.getProperties().keySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					toObject.set( (String)fromEntry.getKey(), fromEntry.getValue() );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromTYPE
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean transferAsHistory( HQSQLEntityBean fromEntity ) throws SFException,Exception{
			HQSQLEntityBean fromSubJect = null;
			try
			{
				ISystemTemplate.IUpfgkmComposite fromHistory = null;
				fromHistory = HQSQLUtils.ISystem.getSFUpfgkmHistory( fromEntity.getObjectType().getMapingEnty() );
				if( fromHistory != null ){
					ObjectType _objectType = ClassUtils.IClass.getASTBOType( fromHistory.getPERSISTENT() );
					OracleHQSQLTable fromMYSQL = HQSQLUtils.getOracleTable( fromEntity.getObjectType().getDataSource(), _objectType );
					fromSubJect = HQSQLUtils.ICustom.getASTBOEntity( fromMYSQL );
					HQSQLUtils.ICustom.transfer( fromEntity, fromSubJect );
					for( java.util.Iterator itera = fromEntity.getLittle().getLittle().iterator(); itera.hasNext(); ){
						HQSQLEntityBean fromChild = (HQSQLEntityBean)itera.next();
						fromSubJect.getLittle().getLittle().add( transferAsHistory( fromChild ) );
					}
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromORACLE
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean transferAsHistory( HQSQLTable fromORACLE, HQSQLEntityBean fromEntity ) throws SFException,Exception{
			HQSQLEntityBean fromSubJect = null;
			try
			{
				ISystemTemplate.IUpfgkmComposite fromHistory = null;
				fromHistory = HQSQLUtils.ISystem.getSFUpfgkmHistory( fromEntity.getObjectType().getMapingEnty() );
				if( fromHistory != null ){
					ObjectType _objectType = ClassUtils.IClass.getASTBOType( fromHistory.getPERSISTENT() );
					OracleHQSQLTable fromMYSQL = HQSQLUtils.getOracleTable( fromORACLE.getDataSource(), _objectType );
					fromSubJect = HQSQLUtils.ICustom.getASTBOEntity( fromMYSQL );
					HQSQLUtils.ICustom.transfer( fromEntity, fromSubJect );
					for( java.util.Iterator itera = fromEntity.getLittle().getLittle().iterator(); itera.hasNext(); ){
						HQSQLEntityBean fromChild = (HQSQLEntityBean)itera.next();
						fromSubJect.getLittle().getLittle().add( transferAsHistory( fromORACLE, fromChild ) );
					}
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromTYPE
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean transferAsFail( HQSQLEntityBean fromEntity ) throws SFException,Exception{
			HQSQLEntityBean fromSubJect = null;
			try
			{
				ISystemTemplate.IUpfgkmComposite fromHistory = null;
				fromHistory = HQSQLUtils.ISystem.getSFUpfgkmFail( fromEntity.getObjectType().getMapingEnty() );
				if( fromHistory != null ){
					ObjectType _objectType = ClassUtils.IClass.getASTBOType( fromHistory.getPERSISTENT() );
					OracleHQSQLTable fromMYSQL = HQSQLUtils.getOracleTable( fromEntity.getObjectType().getDataSource(), _objectType );
					fromSubJect = HQSQLUtils.ICustom.getASTBOEntity( fromMYSQL );
					HQSQLUtils.ICustom.transfer( fromEntity, fromSubJect );
					for( java.util.Iterator itera = fromEntity.getLittle().getLittle().iterator(); itera.hasNext(); ){
						HQSQLEntityBean fromChild = (HQSQLEntityBean)itera.next();
						fromSubJect.getLittle().getLittle().add( transferAsFail( fromChild ) );
					}
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromORACLE
		 * @param fromEntity
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HQSQLEntityBean transferAsFail( HQSQLTable fromORACLE, HQSQLEntityBean fromEntity ) throws SFException,Exception{
			HQSQLEntityBean fromSubJect = null;
			try
			{
				ISystemTemplate.IUpfgkmComposite fromHistory = null;
				fromHistory = HQSQLUtils.ISystem.getSFUpfgkmFail( fromEntity.getObjectType().getMapingEnty() );
				if( fromHistory != null ){
					ObjectType _objectType = ClassUtils.IClass.getASTBOType( fromHistory.getPERSISTENT() );
					OracleHQSQLTable fromMYSQL = HQSQLUtils.getOracleTable( fromORACLE.getDataSource(), _objectType );
					fromSubJect = HQSQLUtils.ICustom.getASTBOEntity( fromMYSQL );
					HQSQLUtils.ICustom.transfer( fromEntity, fromSubJect );
					for( java.util.Iterator itera = fromEntity.getLittle().getLittle().iterator(); itera.hasNext(); ){
						HQSQLEntityBean fromChild = (HQSQLEntityBean)itera.next();
						fromSubJect.getLittle().getLittle().add( transferAsFail( fromORACLE, fromChild ) );
					}
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		public static class IICustom{
			public IICustom(){
				super();
			}
			
		}
	}
	
	public static class ISystem{
		public ISystem(){
			super();
		}
		/**
		 * 
		 * @param fromTableName
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static TableSplit getSFUpfgkmSplit( String fromTableName ) throws SFException,Exception{
			TableSplit fromTableSplit = null;
			try
			{
				fromTableSplit = IUpdcfgFactory.getIBasicSV().getSFSubTableSplit( fromTableName );
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			return fromTableSplit;
		}
		/**
		 * 
		 * @param fromTableName
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static TableSplitMapping[] getSFUpfgkmMapping( String fromTableName ) throws SFException,Exception{
			TableSplitMapping fromTableSplit[] = null;
			try
			{
				fromTableSplit = IUpdcfgFactory.getIBasicSV().getSFSubTableMapping( fromTableName );
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			return fromTableSplit;
		}
		/**
		 * 
		 * @param fromTableName
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ITableSplitWrapper getSFUpfgkmChain( String fromTableName,String fromColumn,String fromClass ) throws SFException,Exception{
			ITableSplitWrapper fromTableSplit = null;
			try
			{
				fromTableSplit = (ITableSplitWrapper)IUpdcfgFactory.getIBasicSV().getSFSubTableChain( fromClass );
				if( fromTableSplit == null ) ExceptionFactory.throwIllegal( "IOS0014006", new String[]{ fromTableName, fromColumn } );
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			return fromTableSplit;
		}
		
		/**
		 * 获取全量物理持久化组
		 * @return
		 */
		public static ISystemTemplate.IUpfgkmGroup getSFUpfgkmComposite( ){
			ISystemTemplate.IUpfgkmGroup fromComposite = null;
			try
			{
				fromComposite = IUpdcfgFactory.getIBasicSV().getSFUpfgkmComposite( );
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			return fromComposite;
		}
		
		/**
		 * 根据表名获取分表对应定义
		 * @param fromTableName
		 * @return
		 */
		public static ISystemTemplate.IUpfgkmComposite getSFUpfgkmComposite( String fromTableName ){
			ISystemTemplate.IUpfgkmComposite fromComposite = null;
			try
			{
				fromComposite = IUpdcfgFactory.getIBasicSV().getSFUpfgkmComposite( fromTableName );
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			return fromComposite;
		}
		
		/**
		 * 根据当前表名获取对应失败分表定义
		 * @param fromTableName
		 * @return
		 */
		public static ISystemTemplate.IUpfgkmComposite getSFUpfgkmFail( String fromTableName ){
			ISystemTemplate.IUpfgkmComposite fromFailure = null;
			try
			{
				ISystemTemplate.IUpfgkmComposite fromComposite = null;
				fromComposite = ISystem.getSFUpfgkmComposite( fromTableName );
				if( fromComposite != null && StringUtils.isBlank( fromComposite.getFAILURE() ) == false ){
					fromFailure = ISystem.getSFUpfgkmComposite( fromComposite.getFAILURE() );
				}
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return fromFailure;
		}
		
		/**
		 * 根据当前表名获取对应历史分表定义
		 * @param fromTableName
		 * @return
		 */
		public static ISystemTemplate.IUpfgkmComposite getSFUpfgkmHistory( String fromTableName ){
			ISystemTemplate.IUpfgkmComposite fromHistory = null;
			try
			{
				ISystemTemplate.IUpfgkmComposite fromComposite = null;
				fromComposite = ISystem.getSFUpfgkmComposite( fromTableName );
				if( fromComposite != null && StringUtils.isBlank( fromComposite.getHISTORY() ) == false ){
					fromHistory = ISystem.getSFUpfgkmComposite( fromComposite.getHISTORY() );
				}
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return fromHistory;
		}
		/**
		 * 根据表名获取该表数据结构
		 * @param fromTableName
		 * @return
		 */
		public static ISystemTemplate.IUpfgkmComposite getSFUpfgkmTable( String fromTableName ){
			ISystemTemplate.IUpfgkmComposite fromComposite = null;
			try
			{
				fromComposite = ISystem.getSFUpfgkmComposite( fromTableName );
				if( fromComposite == null ) ExceptionFactory.throwOracle("IOS0014025", new String[]{ fromTableName } );
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return fromComposite;
		}
		
		/**
		 * 获取网元全量分表规范
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISubTableTemplate.ISubSQLCombine getSFSubTableGroup() throws SFException,Exception{
			ISubTableTemplate.ISubSQLCombine fromSubSQL = null;
			try
			{
				fromSubSQL = IUpdcfgFactory.getIBasicSV().getSFSubTableGroup();
			}
			finally{
				
			}
			return fromSubSQL;
		}
		
		/**
		 * 
		 * @param aPLATFORM
		 * @param aTABLE
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISubTableTemplate.ISubSQLGroup getSFSubTableGroup( String aPLATFORM ) throws SFException,Exception{
			ISubTableTemplate.ISubSQLGroup fromSubSQL = null;
			try
			{
				fromSubSQL = IUpdcfgFactory.getIBasicSV().getSFSubTableGroup( aPLATFORM );
				if( fromSubSQL == null ){
					ExceptionFactory.throwIllegal("IOS0014010", new String[]{ aPLATFORM, "*" } );
				}
			}
			finally{
				
			}
			return fromSubSQL;
		}
		
		/**
		 * 
		 * @param _platform
		 * @param _table_name
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISubTableTemplate.ISubSQLTable getSFSubTableOffer( String _platform, String _table_name ) throws SFException,Exception{
			ISubTableTemplate.ISubSQLTable fromSubJect = null;
			try
			{
				ISubTableTemplate.ISubSQLGroup fromSubSQL = null;
				fromSubSQL = IUpdcfgFactory.getIBasicSV().getSFSubTableGroup( _platform );
				if( fromSubSQL != null ){ fromSubJect = fromSubSQL.getSUBFLOW( _table_name ); }
				if( fromSubJect == null ){
					ExceptionFactory.throwIllegal("IOS0014010", new String[]{ _platform, _table_name } );
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromTableSplit
		 * @param fromCatalog
		 * @param fromPARAM
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String wrap( TableSplit fromTableSplit, TableSplitMapping fromCatalog, java.util.Map fromPARAM ) throws SFException,Exception{
			String fromUpffmx = null;
			try
			{
				Object fromUpffwm = fromPARAM.get( fromCatalog.getColumnName() );
				if( fromUpffwm == null ){
					if( StringUtils.equals( fromCatalog.getColumnName(), IUpdcConst.IUpdbm.IUpdmc.REGION_ID ) ){
						fromUpffwm = SFCenterFactory.getCenterInfo().getREGION_ID();
					}
					else if( StringUtils.equals( fromCatalog.getColumnName(), IUpdcConst.IUpdbm.IUpdmc.REGION_CODE ) ){
						fromUpffwm = SFCenterFactory.getCenterInfo().getREGION_ID();
					}
					else if( StringUtils.equals( fromCatalog.getColumnName(), IUpdcConst.IUpdbm.IUpdbf.CUSTOM ) ){
						fromUpffwm = fromPARAM;
					}
				}
				if( fromUpffwm == null ){
					ExceptionFactory.throwIllegal("IOS0014009", new String[]{fromTableSplit.getTableName(), fromCatalog.getColumnName() } );
				}
				fromUpffmx = ISystem._wrap(fromCatalog, fromUpffwm);
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
		/**
		 * 
		 * @param fromCatalog
		 * @param fromMAPPING
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String _wrap( TableSplitMapping fromCatalog,  Object fromMAPPING ) throws SFException,Exception{
			Object fromUpffmx = null;
			try
			{
				ITableSplitWrapper fromUpffwm = ISystem.getSFUpfgkmChain(fromCatalog.getTableName(), 
						fromCatalog.getColumnName(), 
						fromCatalog.getColumnConvertClass() );
				fromUpffmx = fromUpffwm.wrapper(fromCatalog.getTableName(), 
						fromCatalog.getColumnName(), 
						fromMAPPING );
				if( fromUpffmx == null ){
					ExceptionFactory.throwIllegal("IOS0014009", new String[]{ fromCatalog.getTableName(),
							fromCatalog.getColumnName()} );
				}
			}
			finally{
				
			}
			return fromUpffmx != null?fromUpffmx.toString():"";
		}
		
		/**
		 * 
		 * @param aTableName
		 * @param fromPARAM
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.HashMap getSFUpfgkmThreShold( String aTableName, java.util.Map fromPARAM ) throws SFException,Exception{
			java.util.HashMap fromClique = new java.util.HashMap();
			try
			{
				ISystemTemplate.IUpfgkmComposite fromThreShold = null;
				fromThreShold = HQSQLUtils.ISystem.getSFUpfgkmComposite( aTableName );
				if( fromThreShold == null || fromThreShold.isThreShold() == false ){
					fromClique = new java.util.HashMap( fromPARAM );
				}
				else{
					TableSplit fromTableSplit = HQSQLUtils.ISystem.getSFUpfgkmSplit( aTableName );
					TableSplitMapping fromCatalog[] = HQSQLUtils.ISystem.getSFUpfgkmMapping( fromTableSplit.getTableName() );
					for( int index = 0; fromCatalog != null && index < fromCatalog.length; index++ ){
						Object fromUpffmx = HQSQLUtils.ISystem._wrap(fromTableSplit, 
								fromThreShold, 
								fromCatalog[index], 
								fromPARAM);
						if( IIfElse.isCUSTOM( fromCatalog[index] ) == false ){
							fromClique.put( fromCatalog[index].getColumnName() , fromUpffmx );
						}
						else{
							if( ClassUtils.IClass.isMap( fromUpffmx ) == false ){
								ExceptionFactory.throwIllegal("IOS0014024", new String[]{fromTableSplit.getTableName(), 
										fromCatalog[index].getColumnName() });
							}
							ClassUtils.IMerge.merge( (java.util.Map)fromUpffmx, fromClique, false );
						}
					}
				} 
			}
			finally{
				
			}
			return fromClique;
		}
		
		/**
		 * 
		 * @param fromTableSplit
		 * @param fromThreShold
		 * @param fromCatalog
		 * @param fromPARAM
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _wrap( TableSplit fromTableSplit, 
				ISystemTemplate.IUpfgkmComposite fromThreShold, 
				TableSplitMapping fromCatalog,
				java.util.Map fromPARAM ) throws SFException,Exception{
			Object fromUpffmx = null;
			try
			{
				ITableSplitWrapper fromUpffwm = ISystem.getSFUpfgkmChain(fromCatalog.getTableName(), 
						fromCatalog.getColumnName(), 
						fromCatalog.getColumnConvertClass() );
				fromUpffmx = fromUpffwm.magnetic(fromCatalog.getTableName(), 
						fromCatalog.getColumnName(), 
						fromPARAM );
				if( fromUpffmx == null ){
					ExceptionFactory.throwIllegal("IOS0014009", new String[]{ fromCatalog.getTableName(),
							fromCatalog.getColumnName()} );
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
		public static class ISystemX{
			public ISystemX(){
				super();
			}
			
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
		/**
		 * 是否自定义列
		 * @param fromCatalog
		 * @return
		 */
		public static boolean isCUSTOM(TableSplitMapping fromCatalog){
			return StringUtils.equals( fromCatalog.getColumnName(), IUpdcConst.IUpdbm.IUpdbf.CUSTOM );
		}
		
		/**
		 * 是否历史表持久化
		 * @param _objective
		 * @return
		 */
		public static boolean isHISTROY( Object _objective ){
			String _histroy = _objective != null?_objective.getClass().getName():null;
			return _objective != null && StringUtils.endsWith( _histroy, "His" );
		}
		
		/**
		 * 是否失败表持久化
		 * @param _objective
		 * @return
		 */
		public static boolean isFAILURE( Object _objective ){
			String _histroy = _objective != null?_objective.getClass().getName():null;
			return _objective != null && StringUtils.endsWith( _histroy, "Fail" );
		}
	}
}
