package com.ai.sacenter.jdbc.dialect;

import java.rmi.RemoteException;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLDelegate;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jdbc.NoSQLDelegate;
import com.ai.sacenter.jdbc.dialect.OraclePtmtDelegation;
import com.ai.sacenter.subtable.SFSubTableFactory;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: JDBC_APP模式</p>
 * <p>Copyright: Copyright (c) 2014-10-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class OracleDialectImpl extends AbstractDialectImpl {
	public OracleDialectImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.dialect.AbstractDialectImpl#transfer(java.lang.Object, com.ai.sacenter.jdbc.NoSQLDelegate, )
	 */
	public void transfer(Object fromObject, NoSQLDelegate fromMBean) throws SFException, Exception {
		try
		{
			class OracleTransferImpl{
				public OracleTransferImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromEntity
				 * @throws SFException
				 * @throws Exception
				 */
				private String transferWithBefore(NoSQLDelegate fromMBean, DataContainer fromEntity) throws SFException,Exception{
					String _region_id = null;
					try
					{
						if( fromEntity.hasPropertyName( IUpdcConst.IUpdbm.IUpdmc.REGION_ID ) ){
							_region_id = fromEntity.getAsString( IUpdcConst.IUpdbm.IUpdmc.REGION_ID );
							if( StringUtils.isBlank( _region_id ) ){
								_region_id = CenterUtils.ICustom.getRegionId();
								fromEntity.set( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, _region_id);
							}
						}
						if( fromEntity.hasPropertyName( IUpdcConst.IUpdbm.IUpdmc.REGION_CODE ) ){
							_region_id = fromEntity.getAsString( IUpdcConst.IUpdbm.IUpdmc.REGION_CODE );
							if( StringUtils.isBlank( _region_id ) ){
								_region_id = CenterUtils.ICustom.getRegionId();
								fromEntity.set( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, _region_id);
							}
						}
					}
					finally{
						
					}
					return _region_id;
				}
			}
			OracleTransferImpl fromOracleTfImpl = new OracleTransferImpl();
			try
			{
				Object fromARRAY[] = new Object[]{fromObject};
				if( ClassUtils.IClass.isArray( fromObject ) ){ fromARRAY = (Object[])fromObject; }
				NoSQLDelegate.IUpdfmxOffer fromUpdfmx = fromMBean.getSUBFLOW();
				for( int index = 0 ; fromARRAY != null && index < fromARRAY.length; index++ ){
					DataContainer fromEntity = (DataContainer)fromARRAY[index];
					fromOracleTfImpl.transferWithBefore( fromMBean, fromEntity );
					if( SFSubTableFactory.isThreShold( fromEntity ) == false ){
						OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( fromEntity );
						OracleHQSQLDelegate fromDelegate = (OracleHQSQLDelegate)fromUpdfmx.getSUBFLOW( fromORACLE );
						fromDelegate.getREPOSITORY().add( fromEntity );
					}
				}
			}
			finally{
				if( fromOracleTfImpl != null ){ fromOracleTfImpl = null; }
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.dialect.AbstractDialectImpl#commit(com.ai.sacenter.jdbc.NoSQLDelegate, com.ai.sacenter.jdbc.HQSQLDelegate)
	 */
	public void commit(NoSQLDelegate fromMBean, HQSQLDelegate fromDelegate) throws SFException, Exception {
		java.util.List fromUpdbm = new java.util.ArrayList();
		NoSQLDelegate fromLBean = new NoSQLDelegate(fromMBean, fromDelegate.getPERSISTENT() );
		try
		{
			NoSQLDelegate.IUpdfmxOffer fromUpdfmx = fromMBean.getSUBFLOW();
			OracleHQSQLDelegate fromOracle = (OracleHQSQLDelegate)fromDelegate;
			for( java.util.Iterator itera = fromOracle.getREPOSITORY().iterator();itera.hasNext(); ){
				DataContainer fromEntity = (DataContainer)itera.next();
				if( OracleUtils.ICustom.isCommit( fromEntity ) == false ) continue;
				fromUpdbm.add( fromEntity );
			}
			commitWithGroup(fromLBean, fromUpdbm);
			fromUpdfmx.setSUMING( fromUpdfmx.getSUMING() + fromLBean.getSUBFLOW().getSUMING() );
			fromUpdfmx.setCOMPLETE( new java.sql.Timestamp(System.currentTimeMillis()) );
		}
		finally{
			if( fromLBean != null ){ fromLBean = null; }
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
		}
	}
	
	/**
	 * 
	 * @param fromTYPE
	 * @param fromSQL
	 * @param fromUpdbm
	 * @throws SFException
	 * @throws Exception
	 */
	public void exec( ObjectType fromTYPE, String fromSQL, java.util.HashMap fromUpdbm[] ) throws SFException,Exception{
		java.util.Map fromUpdbc = new java.util.HashMap();
		try
		{
			for( int index = 0 ; fromUpdbm != null && index < fromUpdbm.length; index++ ){
				String fromOWNER = OracleUtils.getTransactionName(fromTYPE, fromUpdbm[index] );
				if( fromUpdbc.containsKey( fromOWNER ) == false ){
					fromUpdbc.put( fromOWNER, new java.util.ArrayList() );
				}
				((java.util.List)fromUpdbc.get( fromOWNER ) ).add( fromUpdbm[index] );
			}
			for( java.util.Iterator itera = fromUpdbc.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				String fromOWNER = (String)fromEntry.getKey();
				java.util.ArrayList fromPARAM = (java.util.ArrayList)fromEntry.getValue();
				OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( fromOWNER, fromTYPE );
				super._exec( fromORACLE.getDataSource(), 
						fromSQL, 
						fromORACLE, 
						fromPARAM);
				userdbsmlog( fromORACLE.getMapingEnty(), fromPARAM );
			}
		}
		finally{
			if( fromUpdbc != null ){ fromUpdbc.clear(); fromUpdbc = null;}
		}
	}
	
	/**
	 * 
	 * @param fromTYPE
	 * @param fromUpdbm
	 * @throws SFException
	 * @throws Exception
	 */
	public void create(ObjectType fromTYPE, java.util.HashMap fromUpdbm[] ) throws SFException,Exception{
		java.util.Map fromUpdbc = new java.util.HashMap();
		try
		{
			for( int index = 0 ; fromUpdbm != null && index < fromUpdbm.length; index++ ){
				String fromOWNER = OracleUtils.getTransactionName(fromTYPE, fromUpdbm[index] );
				OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( fromOWNER, fromTYPE );
				if( fromUpdbc.containsKey( fromORACLE ) == false ){
					fromUpdbc.put( fromORACLE, new java.util.ArrayList() );
				}
				((java.util.List)fromUpdbc.get( fromORACLE ) ).add( fromUpdbm[index] );
			}
			for( java.util.Iterator itera = fromUpdbc.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				OracleHQSQLTable fromORACLE = (OracleHQSQLTable)fromEntry.getKey();
				java.util.ArrayList fromPARAM = (java.util.ArrayList)fromEntry.getValue();
				super._exec( fromORACLE.getDataSource(), 
						fromORACLE.getSQL().getCREATE(), 
						fromORACLE, 
						fromPARAM);
				userdbsmlog( fromORACLE.getMapingEnty() , fromPARAM );
			}
		}
		finally{
			if( fromUpdbc != null ){ fromUpdbc.clear(); fromUpdbc = null;}
		}
	}
	
	/**
	 * 
	 * @param fromTYPE
	 * @param fromUpdbm
	 * @throws SFException
	 * @throws Exception
	 */
	public void delete(ObjectType fromTYPE, java.util.HashMap fromUpdbm[] ) throws SFException,Exception{
		java.util.Map fromUpdbc = new java.util.HashMap();
		try
		{
			for( int index = 0 ; fromUpdbm != null && index < fromUpdbm.length; index++ ){
				String fromOWNER = OracleUtils.getTransactionName(fromTYPE, fromUpdbm[index] );
				OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( fromOWNER, fromTYPE );
				if( fromUpdbc.containsKey( fromORACLE ) == false ){
					fromUpdbc.put( fromORACLE, new java.util.ArrayList() );
				}
				((java.util.List)fromUpdbc.get( fromORACLE ) ).add( fromUpdbm[index] );
			}
			for( java.util.Iterator itera = fromUpdbc.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				OracleHQSQLTable fromORACLE = (OracleHQSQLTable)fromEntry.getKey();
				java.util.ArrayList fromPARAM = (java.util.ArrayList)fromEntry.getValue();
				String fromDELETE = fromORACLE.getSQL().getDELETE();
				if( StringUtils.isBlank( fromDELETE ) ){
					ExceptionFactory.throwOracle("IOS0014019", new String[]{fromORACLE.getDataSource(), 
							fromORACLE.getMapingEnty() });
				}
				super._exec( fromORACLE.getDataSource(), 
						fromDELETE, 
						fromORACLE, 
						fromPARAM);
				userdbsmlog( fromORACLE.getMapingEnty() , fromPARAM );
			}
		}
		finally{
			if( fromUpdbc != null ){ fromUpdbc.clear(); fromUpdbc = null;}
		}
	}
	
	/**
	 * 
	 * @param fromOWNER
	 * @param aSQL
	 * @param fromPARAM
	 * @param fromORACLE
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList retrieve( String fromOWNER, String aSQL, java.util.Map fromPARAM, OracleHQSQLTable fromORACLE) throws SFException,Exception{
		java.util.ArrayList fromArray = new java.util.ArrayList();
		java.sql.Connection aTransaction = null;
    	java.sql.ResultSet resultset = null;
	  	java.sql.PreparedStatement statement = null;
	  	try
		{
	  		aTransaction = OracleUtils.getTransaction( fromOWNER );
	  		HQSQLSQLParser fromSQL = HQSQLSQLParser.getINSTANCE( aSQL );
	  		aSQL = SFSubTableFactory.createTableSQL( fromSQL.getSQL(), fromPARAM );
	  		statement = aTransaction.prepareStatement( aSQL );
	  		wrapWithStat( statement, fromSQL, fromORACLE, fromPARAM );
	  		statement.setFetchSize( 200 );
	  		resultset = statement.executeQuery();
	  	    while( resultset.next() ){
	  	    	DataContainer fromEntity = ClassUtils.IClass.getASTBOEntity( fromORACLE.getSchema() );
	  	    	super.retrieveByResultLevel( resultset, fromORACLE, fromEntity );
				fromArray.add( fromEntity );
		    }
		}
	  	catch( java.lang.Exception aEXCEPTION ){
	  		String fromTABLE = SFSubTableFactory.createTableName( fromORACLE.getMapingEnty(), fromPARAM );
	  		ExceptionFactory.throwOracle("IOS0014016", new String[]{fromOWNER,
	  				fromTABLE,
	  				aEXCEPTION.getMessage()},
	  				aEXCEPTION);
	  	}
		finally{
			if( resultset != null ){ resultset.close(); resultset=null; }
			if( statement != null ){ statement.close(); statement=null; }
			if( aTransaction != null ) { aTransaction.close();}
		}
		return fromArray;
	}
	
	/**
	 * 
	 * @param _table_name
	 * @param condition
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList retrieve( String _table_name, String _condition, java.util.Map fromPARAM) throws SFException, Exception{
		java.util.ArrayList _tables = null;
		try
		{
			ISystemTemplate.IUpfgkmComposite _composite = HQSQLUtils.ISystem.getSFUpfgkmTable( _table_name );
			ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( _composite.getPERSISTENT() );
			_tables = retrieve( fromTYPE, _condition, fromPARAM );
		}
		finally{
			
		}
		return _tables;
	}
	
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList retrieve(ObjectType fromTYPE, String fromCond, java.util.Map fromPARAM) throws SFException, Exception{
		java.util.ArrayList fromArray = null;
		StringBuilder aSQL = new StringBuilder();
		try
		{
			String fromOWNER = OracleUtils.getTransactionName(fromTYPE, fromPARAM);
			OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable(fromOWNER, fromTYPE);
			aSQL.append( fromORACLE.getSQL().getQUERY() );
			if( StringUtils.isBlank( fromCond ) == false ) aSQL.append( " and " ).append( fromCond );
			fromArray = retrieveByResultLevel(fromOWNER, 
					aSQL.toString(), 
					fromPARAM, 
					fromORACLE, 
					-1l);
		}
		finally{
		
		}
		return fromArray;
	}
	
	/**
	 * 
	 * @param _table_name
	 * @param _objecttype
	 * @param _condition
	 * @param fromPARAM
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList retrieve(String _table_name, ObjectType _objecttype, String _condition, java.util.Map fromPARAM) throws RemoteException, Exception{
		java.util.ArrayList fromUpdfmx = null;
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			String _datasource = OracleUtils.getTransactionName( _objecttype, fromPARAM );
			OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( _datasource, _objecttype );
			fromSQL.append( fromORACLE.getSQL().getQUERY() );
			if( StringUtils.isBlank( _condition ) == false ){ fromSQL.append( " and " ).append( _condition ); }
			if( StringUtils.isBlank( _table_name ) ){
				fromUpdfmx = retrieve( _datasource, fromSQL.toString(), fromPARAM, fromORACLE );
			}
			else{
				String _table_sql_ = StringUtils.replace( fromSQL.toString(), _objecttype.getMapingEnty(), _table_name );
				fromUpdfmx = retrieve( _datasource, _table_sql_, fromPARAM, fromORACLE );
			}
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromUpdfmx;
	}
	
	/**
	 * 
	 * @param fromNoSQL 数据员[KEY=#{表名}_$_#{地市编码},DATA=任意]
	 * @param fromCond 查询条件
	 * @param fromPARAM 查询参数
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList retrieve(java.util.HashMap fromNoSQL, String fromCond, java.util.Map fromPARAM) throws SFException, Exception{
		java.util.ArrayList fromUpdfmx = new java.util.ArrayList();
		try
		{
			for( java.util.Iterator itera = fromNoSQL.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				String _table[] = StringUtils.wildcardArray( (String)fromEntry.getKey() , "_$_" );
				ISystemTemplate.IUpfgkmComposite _oracle = HQSQLUtils.ISystem.getSFUpfgkmTable( _table[0] );
				ObjectType _type = ClassUtils.IClass.getASTBOType( _oracle.getPERSISTENT() );
				java.util.HashMap fromSQL = new java.util.HashMap( fromPARAM );
				try
				{
					fromSQL.put( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, _table[1] );
					java.util.List _retrieve = retrieve( _type, fromCond, fromPARAM );
					if( _retrieve != null ){ ClassUtils.IMerge.merge( _retrieve, fromUpdfmx ); }
				}
				finally{
					if( fromSQL != null ){ fromSQL.clear(); fromSQL = null; }
				}
			}
		}
		finally{
			
		}
		return fromUpdfmx;
	}
	
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @param aColumn
	 * @param startRowIndex
	 * @param endRowIndex
	 * @return
	 * @throws Exception
	 */
	public DataStructInterface[] retrieve(ObjectType fromTYPE, String fromCond, java.util.HashMap fromPARAM, String[] aColumn, int startRowIndex, int endRowIndex) throws Exception {
		java.sql.Connection aTransaction = null;
		try
		{
			String fromOWNER = OracleUtils.getTransactionName(fromTYPE, fromPARAM);
			aTransaction = OracleUtils.getTransaction( fromOWNER );
			Class fromCOMPOSITE = Class.forName( fromTYPE.getFullName() );
			return ServiceManager.getDataStore().retrieve(aTransaction ,
					fromCOMPOSITE, 
					fromTYPE, 
					aColumn, 
					fromCond, 
					fromPARAM, 
					startRowIndex, 
					endRowIndex, 
					true, 
					false, 
					null);
		}
		finally{
			if( aTransaction != null ){ aTransaction.close() ; }
		}
	}
	
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws Exception
	 */
	public int retrieveCount(ObjectType fromTYPE, String fromCond, java.util.HashMap fromPARAM) throws Exception{
		int fromCount = 0;
		java.sql.Connection aTransaction = null;
		try
		{
			String fromOWNER = OracleUtils.getTransactionName(fromTYPE, fromPARAM);
			aTransaction = OracleUtils.getTransaction( fromOWNER );
			fromCount = ServiceManager.getDataStore().retrieveCount( aTransaction , 
					fromTYPE, 
					fromCond, 
					fromPARAM, 
					null );
		}
		finally{
			if( aTransaction != null ){ aTransaction.close() ; }
		}
		return fromCount;
	}
	
	/**
	 * 
	 * @param fromOWNER
	 * @param aSQL
	 * @param fromPARAM
	 * @param fromORACLE
	 * @param aMaxRow
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	private java.util.ArrayList retrieveByResultLevel( String fromOWNER, String aSQL, java.util.Map fromPARAM, OracleHQSQLTable fromORACLE, long aMaxRow) throws SFException,Exception{
		java.util.ArrayList fromArray = new java.util.ArrayList();
		java.sql.Connection aTransaction = null;
    	java.sql.ResultSet _resultset = null;
	  	java.sql.PreparedStatement _statement = null;
	  	try
		{
	  		long fromCount = aMaxRow;
	  		aTransaction = OracleUtils.getTransaction( fromOWNER );
	  		HQSQLSQLParser fromSQL = HQSQLSQLParser.getINSTANCE( aSQL );
	  		aSQL = SFSubTableFactory.createTableSQL( fromSQL.getSQL(), fromPARAM );
	  		_statement = aTransaction.prepareStatement( aSQL );
	  		wrapWithStat(_statement, fromSQL, fromORACLE, fromPARAM);
	  		_statement.setFetchSize( 200 );
	  		_resultset = _statement.executeQuery();
	  	    while( _resultset.next() ){
	  	    	DataStructInterface fromBottle = ClassUtils.IClass.getASTBOEntity( fromORACLE.getSchema() );
	  	    	retrieveByResultLevel( _resultset, fromORACLE, fromBottle );
	  	    	fromArray.add( fromBottle );
	    	    if( aMaxRow > 0 ) fromCount--;
	    		if( aMaxRow > 0 && fromCount <= 0 ) break;
		    }
		}
	  	catch( java.lang.Exception aEXCEPTION ){
	  		String fromTABLE = SFSubTableFactory.createTableName( fromORACLE.getMapingEnty(), 
	  				fromPARAM );
	  		ExceptionFactory.throwOracle("IOS0014016", new String[]{fromOWNER,
	  				fromTABLE,
	  				aEXCEPTION.getMessage()});
	  	}
		finally{
			if( _resultset != null ) { _resultset.close(); _resultset=null; }
			if( _statement != null ) { _statement.close(); _statement=null; }
			if( aTransaction != null ) { aTransaction.close();}
		}
		return fromArray;
	}
	
	/**
	 * 
	 * @param fromMBean
	 * @param fromUpdbm
	 * @throws SFException
	 * @throws Exception
	 */
	private void commitWithGroup(NoSQLDelegate fromMBean, java.util.List fromUpdbm ) throws SFException,Exception{
		OraclePtmtDelegation fromDelegation = new OraclePtmtDelegation();
		try
		{
			class OracleCreateImpl{
				public OracleCreateImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromEntity
				 * @param fromUpdbm
				 * @throws SFException
				 * @throws Exception
				 */
				private void transferWithCreate( NoSQLDelegate fromMBean, DataContainer fromEntity, java.util.HashMap fromUpdbm ) throws SFException,Exception{
					try
					{
						OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( fromEntity );
						String fromCREATE = fromORACLE.getSQL().getCREATE();
						OraclePtmtDelegate fromDelegate = (OraclePtmtDelegate)fromUpdbm.get( fromCREATE );
						if( fromDelegate == null ){
							fromDelegate = new OraclePtmtDelegate( fromORACLE );
							fromUpdbm.put( fromCREATE, fromDelegate );
						}
						fromDelegate.getDelegation().add( fromEntity );
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromEntity
				 * @param fromUpdbm
				 * @throws SFException
				 * @throws Exception
				 */
				private void transferWithModify( NoSQLDelegate fromMBean, DataContainer fromEntity, java.util.HashMap fromUpdbm ) throws SFException,Exception{
					java.util.List fromModify = new java.util.ArrayList();
					try
					{
						OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( fromEntity );
						for( java.util.Iterator itera = fromEntity.getNewProperties().entrySet().iterator(); itera.hasNext(); ){
							java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
							HQSQLTable.HQSQLColumn _column = fromORACLE.getProperty( fromEntry.getKey().toString() );
							if( _column == null || _column.isASTVirtual() ) continue;
							String fromINDEX = ClassUtils.getINDEX( new String[]{_column.getName(), " = :", _column.getName() } );
							fromModify.add( fromINDEX );
						}
						if( fromModify != null && fromModify.size() > 0 ){
							String fromUPDATE = fromORACLE.getSQL().getMODIFY();
							if( StringUtils.isBlank( fromUPDATE ) ){
								ExceptionFactory.throwOracle("IOS0014019", new String[]{fromORACLE.getDataSource(), 
										fromORACLE.getMapingEnty() });
							}
							fromUPDATE = StringUtils.replace( fromORACLE.getSQL().getMODIFY(), 
									"{_MODIFY_HQSQL_}", 
									StringUtils.join(fromModify.iterator(), " , "));
							OraclePtmtDelegate fromDelegate = (OraclePtmtDelegate)fromUpdbm.get( fromUPDATE );
							if( fromDelegate == null ){
								fromDelegate = new OraclePtmtDelegate( fromORACLE );
								fromUpdbm.put( fromUPDATE, fromDelegate );
							}
							fromDelegate.getDelegation().add( fromEntity );
						}
					}
					finally{
						if( fromModify != null ){ fromModify.clear(); fromModify = null; }
					}
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromEntity
				 * @param fromUpdbm
				 * @throws SFException
				 * @throws Exception
				 */
				private void transferWithDelete( NoSQLDelegate fromMBean, DataContainer fromEntity, java.util.HashMap fromUpdbm ) throws SFException,Exception{
					try
					{
						OraclePtmtDelegate fromDelegate = null;
						OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( fromEntity );
						String fromDELETE = fromORACLE.getSQL().getDELETE();
						if( StringUtils.isBlank( fromDELETE ) ){
							ExceptionFactory.throwOracle("IOS0014019", new String[]{fromORACLE.getDataSource(), 
									fromORACLE.getMapingEnty() });
						}
						fromDelegate = (OraclePtmtDelegate)fromUpdbm.get( fromDELETE );
						if( fromDelegate == null ){
							fromDelegate = new OraclePtmtDelegate( fromORACLE );
							fromUpdbm.put( fromDELETE, fromDelegate );
						}
						fromDelegate.getDelegation().add( fromEntity );
					}
					finally{
						
					}
				}
			}
			OracleCreateImpl fromOracleImpl = new OracleCreateImpl();
			try
			{
				for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
					DataContainer fromEntity = (DataContainer)itera.next();
					if( OracleUtils.ICustom.isCommit( fromEntity ) == false ) continue;
					if( fromEntity.isNew() ){
						fromOracleImpl.transferWithCreate(fromMBean, 
								fromEntity, 
				    			fromDelegation.getCREATE());
				    }
				    else if( fromEntity.isModified() ){
				    	fromOracleImpl.transferWithModify(fromMBean, 
				    			fromEntity, 
				    			fromDelegation.getUPDATE());
				    }
				    else if( fromEntity.isDeleted() ){
				    	fromOracleImpl.transferWithDelete(fromMBean, 
				    			fromEntity, 
				    			fromDelegation.getDELETE());
				    }
				}
				if( fromDelegation != null && fromDelegation.getDELETE().size() > 0 ){
					commitWithResultLevel(fromMBean, fromDelegation.getDELETE() );
				}
				if( fromDelegation != null && fromDelegation.getUPDATE().size() > 0 ){
					commitWithResultLevel(fromMBean, fromDelegation.getUPDATE() );
				}
				if( fromDelegation != null && fromDelegation.getCREATE().size() > 0 ){
					commitWithResultLevel(fromMBean, fromDelegation.getCREATE() );
				}
			}
			finally{
				if( fromOracleImpl != null ){ fromOracleImpl = null; }
			}
		}
		finally{
			if( fromDelegation != null){ fromDelegation = null; }
		}
	}
}
