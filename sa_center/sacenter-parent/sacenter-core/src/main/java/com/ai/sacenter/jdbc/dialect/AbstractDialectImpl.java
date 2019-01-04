package com.ai.sacenter.jdbc.dialect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.appframe2.bo.ObjectTypeNull;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLDelegate;
import com.ai.sacenter.jdbc.HQSQLNull;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jdbc.IHQSQLDialect;
import com.ai.sacenter.jdbc.NoSQLDelegate;
import com.ai.sacenter.subtable.SFSubTableFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.EncryptUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-10-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public abstract class AbstractDialectImpl implements IHQSQLDialect {
	protected final static Log log = LogFactory.getLog( AbstractDialectImpl.class );
	public AbstractDialectImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IHQSQLIDialect#getSysdate()
	 */
	public java.sql.Timestamp getSysdate() throws SFException, Exception {
		return ServiceManager.getIdGenerator().getSysDate();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IHQSQLDialect#transfer(java.lang.Object, com.ai.sacenter.jdbc.NoSQLDelegate)
	 */
	public void transfer(Object fromObject, NoSQLDelegate fromMBean) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IHQSQLDialect#commit(com.ai.sacenter.jdbc.NoSQLDelegate, com.ai.sacenter.jdbc.HQSQLDelegate)
	 */
	public void commit(NoSQLDelegate fromMBean, HQSQLDelegate fromDelegate) throws SFException, Exception {
		
	}
	
	/**
	 * 
	 * @param resultset
	 * @param fromOracle
	 * @param fromSubSQL
	 * @throws SFException
	 * @throws Exception
	 */
	protected void retrieveByResultLevel( java.sql.ResultSet resultset, HQSQLTable fromOracle, DataStructInterface fromSubSQL ) throws SFException,Exception{
		try
		{
			java.sql.ResultSetMetaData _metadata = resultset.getMetaData();
			if( fromSubSQL.getObjectType() instanceof ObjectTypeNull ){
				for( int index = 0; index < _metadata.getColumnCount(); index++ ){
					String _columnname = _metadata.getColumnName( index + 1 );
					fromSubSQL.initProperty( _columnname, resultset.getObject( _columnname ) );
				}
			}
			else if( fromSubSQL.getObjectType() instanceof HQSQLNull ){
				for( int index = 0; index < _metadata.getColumnCount(); index++ ){
					String _columnname = _metadata.getColumnName( index + 1 );
					fromSubSQL.initProperty( _columnname, resultset.getObject( _columnname ) );
				}
			}
			else{
				for( java.util.Iterator itera = fromOracle.getProperties().values().iterator(); itera.hasNext(); ){
					HQSQLTable.HQSQLColumn _column_ = (HQSQLTable.HQSQLColumn)itera.next();
					if( _column_.isASTVirtual() ){ continue; }
					Object __bottle__ = resultset.getObject( _column_.getName() );
					__bottle__ = ClassUtils.IClass.transfer( __bottle__, _column_.getJavaType() );
					if( __bottle__ != null ){ fromSubSQL.initProperty( _column_.getName(), __bottle__ ); }
				}
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromMBean
	 * @param fromTablePtmtHome
	 * @throws SFException
	 * @throws Exception
	 */
	protected void commitWithResultLevel(NoSQLDelegate fromMBean, java.util.HashMap fromTablePtmtHome ) throws SFException,Exception{
		try
		{
			NoSQLDelegate.IUpdfmxOffer fromUpdfmx = fromMBean.getSUBFLOW();
			for( java.util.Iterator itera = fromTablePtmtHome.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				String fromSQL = (String)fromEntry.getKey();
				OraclePtmtDelegate fromPtmtHome = (OraclePtmtDelegate)fromEntry.getValue();
				if( fromPtmtHome != null && fromPtmtHome.getDelegation().size() > 0 ){
					HQSQLTable fromORACLE = fromPtmtHome.getTable();
					java.util.ArrayList fromPARAM = new java.util.ArrayList();
					try
					{
						for( java.util.Iterator iterap = fromPtmtHome.getDelegation().iterator(); iterap.hasNext(); ){
							DataStructInterface fromEntity = (DataStructInterface)iterap.next();
							fromPARAM.add( fromEntity.getProperties() );
						}
						_exec( fromORACLE.getDataSource(), fromSQL, fromORACLE, fromPARAM );
						fromUpdfmx.setSUMING( fromUpdfmx.getSUMING() + fromPARAM.size() );
						if( log.isDebugEnabled() ) log.debug("batch Execute finish[REGION_ID:NULL"+
		    					"][Routing Information by the itself JVM settings]], Data Table ["+ fromORACLE.getMapingEnty() 
		    					+ "]. Data Count [" + fromPARAM.size() +"]");
					}
					catch( java.lang.Exception aEXCEPTION ){
						ExceptionFactory.throwOracle("IOS0014016", new String[]{fromORACLE.getDataSource(),
								fromORACLE.getMapingEnty(),
								aEXCEPTION.getMessage()}, 
								aEXCEPTION);
					}
					finally{
						if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
					}
				}
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromOWNER
	 * @param fromSQL
	 * @param fromORACLE
	 * @param fromPARAM
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _exec( String fromOWNER, String fromSQL, HQSQLTable fromORACLE, java.util.ArrayList fromPARAM ) throws SFException,Exception{
		java.sql.Connection aTransaction = null;
    	java.util.Map fromUpdbm = new java.util.HashMap();
	  	try
		{
	  		aTransaction = OracleUtils.getTransaction( fromOWNER );
	  		HQSQLSQLParser fromSQLParser = HQSQLSQLParser.getINSTANCE( fromSQL );
	  		for( java.util.Iterator itera = fromPARAM.iterator(); itera.hasNext(); ){
	  			java.util.HashMap fromUpdbc = (java.util.HashMap)itera.next();
	  			fromSQL = SFSubTableFactory.createTableSQL( fromSQLParser.SQL , fromUpdbc );
	  			if( fromUpdbm.containsKey( fromSQL ) == false )
	  				fromUpdbm.put( fromSQL , new java.util.ArrayList() );
	  			((java.util.List)fromUpdbm.get( fromSQL ) ).add( fromUpdbc );
	  		}
	  		for( java.util.Iterator itera = fromUpdbm.entrySet().iterator() ; itera.hasNext() ; ){
	  			java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
	  			fromSQL = (String)fromEntry.getKey();
	  			fromPARAM = (java.util.ArrayList)fromEntry.getValue();
	  			java.sql.PreparedStatement aStatement = null;
	  			try
	  			{
	  				aStatement = aTransaction.prepareStatement( fromSQL );
	  				for( java.util.Iterator iterap = fromPARAM.iterator(); iterap.hasNext(); ){
	  					java.util.HashMap fromUpdbc = (java.util.HashMap)iterap.next();
	  					wrapWithStat(aStatement, fromSQLParser, fromORACLE , fromUpdbc );
	  					aStatement.addBatch();
	  				}
		  			aStatement.executeBatch();
	  			}
	  			catch( java.lang.Exception aEXCEPTION ){
	  				if(log.isErrorEnabled()){log.error(aEXCEPTION.getMessage(), aEXCEPTION );}
	  				ExceptionFactory.throwOracleInside("IOS0014016", new String[]{fromOWNER,
	  		  				fromORACLE.getMapingEnty(), aEXCEPTION.getMessage()},
	  		  				aEXCEPTION);
	  		  	}
	  			finally{
	  				if( aStatement != null ){ aStatement.close(); aStatement=null;}
	  			}
	  		}
	 	}
	  	finally{
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null;}
			if( aTransaction != null ) { aTransaction.close();}
		}
	}
	
	/**
	 * 
	 * @param _stmt
	 * @param fromSQL
	 * @param fromHQSQL
	 * @param fromNoSQL
	 * @throws Exception
	 */
	protected void wrapWithStat(java.sql.PreparedStatement _stmt, HQSQLSQLParser _sql, HQSQLTable _table, java.util.Map _param ) throws Exception{
		try
		{
			for(int _index = 0; _sql.getColumn() != null && _index < _sql.getColumn().length ; _index++){
				String column = _sql.getColumn()[_index];
				Object _object = _param.get( column );
				try
				{
					HQSQLTable.HQSQLColumn _column = _table.getProperty( column );
					if( _object == null && _column == null ){
						_column = new HQSQLTable.HQSQLColumn( column );
						Transfer._jj_object( this, _stmt, _table, _column, _index + 1, _object );
					}
					else if( _object == null && _column != null ){
						_column = new HQSQLTable.HQSQLColumn( _column, _object );
						Transfer._jj_object( this, _stmt, _table, _column, _index + 1, _object );
					}
					else if( _object != null && _column == null ){
						_column = new HQSQLTable.HQSQLColumn( column, _object.getClass() );
						Transfer._jj_object( this, _stmt, _table, _column, _index + 1, _object );
					}
					else if( _object != null && _column != null ){
						Transfer._jj_object( this, _stmt, _table, _column, _index + 1, _object );
					}
				}
				catch( java.lang.Exception aEXCEPTION ){
					if(log.isErrorEnabled()){log.error(aEXCEPTION.getMessage(), aEXCEPTION );}
					ExceptionFactory.throwOracleInside("IOS0014018", new String[]{_table.getDataSource(),
							_table.getMapingEnty(), column, aEXCEPTION.getMessage()}, 
							aEXCEPTION);
				}
				finally{
					
				}
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromTABLE
	 * @param fromDelegate
	 */
	public void userdbsmlog( String fromTABLE, java.util.List fromDelegate ){
		java.util.Map fromUpdbm = new java.util.HashMap();
		try
		{
			if( log.isDebugEnabled() ) {
				for( java.util.Iterator itera = fromDelegate.iterator(); itera.hasNext(); ){
					java.util.Map fromPARAM = (java.util.Map)itera.next();
					String aTABLE = SFSubTableFactory.createTableName( fromTABLE, fromPARAM );
					if( fromUpdbm.containsKey( aTABLE ) == false ) fromUpdbm.put( aTABLE, new java.util.ArrayList() );
					((java.util.List)fromUpdbm.get( aTABLE ) ).add( fromPARAM );
				}
				for(java.util.Iterator itera = fromUpdbm.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					String fromTable = (String)fromEntry.getKey();
	    			java.util.List fromPARAM = (java.util.List)fromEntry.getValue();
	    			log.debug("batch Execute finish[REGION_ID:NULL][Routing Information by the itself JVM settings]], Data Table ["+ 
	    					fromTable + "]. Data Count [" + fromPARAM.size() +"]");
				}
			}
		}
		catch( java.lang.Exception tt){
			
		}
		finally{
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null;}
		}
	}
	
	/**
	 * 
	 * @param _table_
	 * @param _column_
	 * @param _objective
	 * @throws SFException
	 */
	public void validate( HQSQLTable _table_, HQSQLTable.HQSQLColumn _column_, Object _objective ) throws SFException{
		try
		{
			if( _column_ == null /*不校验数据合法性*/){
				
			}
			else if( _column_.isASTVirtual() /*虚拟字段*/){
				
			}
			else if( _column_.isASTBlank() /*非表字段*/){
				
			}
			else if( _column_.isASTNoNull() && _objective == null ){
				ExceptionFactory.throwOracle("IOS0014003", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
			}
			else if( _objective == null /*可空字段类型*/){
				
			}
			else if( _column_.isASTString() /*字符串类型*/){
				if( _objective.toString().length() == 0 && _column_.isASTNoNull() ){
					ExceptionFactory.throwOracle("IOS0014003", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
				}
				else if( _objective.toString().length() > _column_.getMaxLength() ){
					ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
				}
			}
			else if( _column_.isASTArray() /*CLOB/BLOB类型*/){
				
			}
			else if( _column_.isASTByte() /*字节类型*/){
				if( MathUtils.isNumeric( _objective.toString() ) == false ){
					ExceptionFactory.throwOracle("IOS0014029", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
				}
				else{
					java.math.BigDecimal _decimal_ = new java.math.BigDecimal( _objective.toString() );
					if( _decimal_.longValue() > Byte.MAX_VALUE || _decimal_.longValue() < Byte.MIN_VALUE ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
					else if( _decimal_.precision() > _column_.getMaxLength() ||  _decimal_.scale() > 0 ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
				}
			}
			else if( _column_.isASTShort() /*短整数类型*/){
				if( MathUtils.isNumeric( _objective.toString() ) == false ){
					ExceptionFactory.throwOracle("IOS0014029", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
				}
				else{
					java.math.BigDecimal _decimal_ = new java.math.BigDecimal( _objective.toString() );
					if( _decimal_.longValue() > Short.MAX_VALUE || _decimal_.longValue() < Short.MIN_VALUE ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
					else if( _decimal_.precision() > _column_.getMaxLength() ||  _decimal_.scale() > 0 ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
				}
			}
			else if( _column_.isASTInt() /*整数类型*/){
				if( MathUtils.isNumeric( _objective.toString() ) == false ){
					ExceptionFactory.throwOracle("IOS0014029", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
				}
				else{
					java.math.BigDecimal _decimal_ = new java.math.BigDecimal( _objective.toString() );
					if( _decimal_.longValue() > Integer.MAX_VALUE || _decimal_.longValue() < Integer.MIN_VALUE ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
					else if( _decimal_.precision() > _column_.getMaxLength() ||  _decimal_.scale() > 0 ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
				}
			}
			else if( _column_.isASTLong() /*长整数类型*/){
				if( MathUtils.isNumeric( _objective.toString() ) == false ){
					ExceptionFactory.throwOracle("IOS0014029", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
				}
				else{
					java.math.BigDecimal _decimal_ = new java.math.BigDecimal( _objective.toString() );
					if( _decimal_.longValue() > Long.MAX_VALUE || _decimal_.longValue() < Long.MIN_VALUE ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
					else if( _decimal_.precision() > _column_.getMaxLength() ||  _decimal_.scale() > 0 ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
				}
			}
			else if( _column_.isASTFloat() /*单精度浮点类型*/){
				if( MathUtils.isDecimal( _objective.toString() ) == false ){
					ExceptionFactory.throwOracle("IOS0014029", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
				}
				else{
					java.math.BigDecimal _decimal_ = new java.math.BigDecimal( _objective.toString() );
					if( _decimal_.longValue() > Float.MAX_VALUE || _decimal_.longValue() < Float.MIN_VALUE ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
					else if( _decimal_.precision() > _column_.getMaxLength() ||  _decimal_.scale() > _column_.getFloatLength() ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
				}
			}
			else if( _column_.isASTDouble() /*双精度浮点类型*/){
				if( MathUtils.isDecimal( _objective.toString() ) == false ){
					ExceptionFactory.throwOracle("IOS0014029", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
				}
				else{
					java.math.BigDecimal _decimal_ = new java.math.BigDecimal( _objective.toString() );
					if( _decimal_.longValue() > Double.MAX_VALUE || _decimal_.longValue() < Double.MIN_VALUE ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
					else if( _decimal_.precision() > _column_.getMaxLength() ||  _decimal_.scale() > _column_.getFloatLength() ){
						ExceptionFactory.throwOracle("IOS0014027", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
					}
				}
			}
			else if( _column_.isASTDigital() /*其他数字类型*/){
				if( MathUtils.isDecimal( _objective.toString() ) == false ){
					ExceptionFactory.throwOracle("IOS0014029", new Object[]{ _table_.getDataSource(), _table_.getMapingEnty(), _column_.getName() } );
				}
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param _entity
	 * @param _field
	 * @param _objective
	 * @throws SFException
	 */
	public void validate( DataStructInterface _entity ) throws SFException{
		try
		{
			HQSQLTable __table__ = HQSQLUtils.getCheckSum( _entity.getObjectType() );
			if( __table__ != null && _entity.isNew() /*新增*/){
				for( java.util.Iterator itera = __table__.getProperties().values().iterator(); itera.hasNext(); ){
					HQSQLTable.HQSQLColumn _column_ = (HQSQLTable.HQSQLColumn)itera.next();
					if( _column_ == null || _column_.isASTVirtual() ){ continue; }
					validate( __table__, _column_, _entity.getNewProperties().get( _column_.getName() ) );
				}
			}
			else if( __table__ != null && _entity.isDeleted() /*删除*/){
				for( java.util.Iterator itera = __table__.getKeyProperties().values().iterator(); itera.hasNext(); ){
					HQSQLTable.HQSQLColumn _column_ = (HQSQLTable.HQSQLColumn)itera.next();
					if( _column_ == null || _column_.isASTVirtual() ){ continue; }
					validate( __table__, _column_, _entity.getOldObj( _column_.getName() ) );
				}
			}
			else if( __table__ != null && _entity.isModified() ){
				for( java.util.Iterator itera = __table__.getKeyProperties().values().iterator(); itera.hasNext(); ){
					HQSQLTable.HQSQLColumn _column_ = (HQSQLTable.HQSQLColumn)itera.next();
					if( _column_ == null || _column_.isASTVirtual() ){ continue; }
					validate( __table__, _column_, _entity.getOldObj( _column_.getName() ) );
				}
				for( java.util.Iterator itera = _entity.getNewProperties().keySet().iterator(); itera.hasNext(); ){
					String __field__ = (String)itera.next();
					HQSQLTable.HQSQLColumn _column_ = __table__.getProperty( __field__ );
					if( _column_ == null || _column_.isASTVirtual() ){ continue; }
					validate( __table__, _column_, _entity.getNewProperties().get( _column_.getName() ) );
				}
			}
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwOracleInside("IOS0014000", 
					new String[]{exception.getMessage()}, 
					exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param _composite
	 * @param _entity_
	 * @throws SFException
	 */
	public void validate(Class<?> _composite, DataStructInterface _entity_) throws SFException {
		try
		{
			HQSQLTable __table__  = HQSQLUtils.getOracleTable( _composite, _entity_ );
			if( __table__ != null && _entity_.isNew() /*插入*/){
				for( java.util.Iterator<HQSQLTable.HQSQLColumn> itera = __table__.getProperties().values().iterator(); itera.hasNext(); ){
					HQSQLTable.HQSQLColumn  __column__ = (HQSQLTable.HQSQLColumn)itera.next();
					if( __column__ == null || __column__.isASTVirtual() ){ continue; }
					Object __object__ = (Object)_entity_.getNewProperties().get( __column__.getName() );
					validate( __table__, __column__, __object__);
				}
			}
			else if( __table__ != null && _entity_.isModified() /*更新*/){
				for( java.util.Iterator<HQSQLTable.HQSQLColumn> itera = __table__.getKeyProperties().values().iterator(); itera.hasNext(); ){
					HQSQLTable.HQSQLColumn  __column__ = (HQSQLTable.HQSQLColumn)itera.next();
					if( __column__ == null || __column__.isASTVirtual() ){ continue; }
					Object __object__ = (Object)_entity_.getOldProperties().get( __column__.getName() );
					validate( __table__, __column__, __object__);
				}
				for( java.util.Iterator<String> itera = _entity_.getNewProperties().keySet().iterator(); itera.hasNext(); ){
					String __field__ = (String)itera.next();
					HQSQLTable.HQSQLColumn  __column__ = __table__.getProperty( __field__ );
					if( __column__ == null || __column__.isASTVirtual() ){ continue; }
					Object __object__ = (Object)_entity_.getNewProperties().get( __column__.getName() );
					validate( __table__, __column__, __object__);
				}
			}
			else if( __table__ != null && _entity_.isDeleted() /*删除*/){
				for( java.util.Iterator<HQSQLTable.HQSQLColumn> itera = __table__.getKeyProperties().values().iterator(); itera.hasNext(); ){
					HQSQLTable.HQSQLColumn  __column__ = (HQSQLTable.HQSQLColumn)itera.next();
					if( __column__ == null || __column__.isASTVirtual() ){ continue; }
					Object __object__ = (Object)_entity_.getOldProperties().get( __column__.getName() );
					validate(__table__, __column__, __object__);
				}
			}
		}
		finally{
			
		}
	}

	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2014-10-29</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class HQSQLSQLParser{
		private String SQL;
		private String[] column = null;
		public HQSQLSQLParser( String strSQL ){
			SQL = strSQL + " ";
			column = StringUtils.substring( SQL , ":", " " );
			for(int index = 0 ; index < column.length ; index++){
				column[index] = StringUtils.trim( column[index] );
		    	SQL = StringUtils.replace( SQL , ":"+column[index]+" ", "? ");
		    }
		}
		/**
		 * 
		 * @param strSQL
		 * @return
		 */
		public static HQSQLSQLParser getINSTANCE( String strSQL ){
			return new HQSQLSQLParser( strSQL );
		}
		
		/**
		 * @return the column
		 */
		public String[] getColumn() {
			return column;
		}
		/**
		 * @return the sQL
		 */
		public String getSQL() {
			return SQL;
		}
	}
	
	public static class Transfer{
		public Transfer(){
			super();
		}
		
		/**
		 * 
		 * @param _pref
		 * @param _table
		 * @param _column
		 * @param _object
		 */
		public static void userlog( String _pref, HQSQLTable _table ) throws SFException,Exception{
			if( _table != null ){ EncryptUtils.ICustom.userlog("ucmframe", _table.toString() ); }
		}
		
		/**
		 * 
		 * @param _pref
		 * @param _table
		 * @param _column
		 * @param _object
		 */
		public static void userlog( String _pref, HQSQLTable _table,  HQSQLTable.HQSQLColumn _column, Object _object ) throws SFException,Exception{
			EncryptUtils.ICustom.userlog("ucmframe", _pref + ( _table != null?_table.getDataSource()+ "[" + _table.getMapingEnty() + "]":"NULL") + 
					"\t" +  _column.getName() + "\t" + ( _object != null?_object:"NULL") );
		}
		
		/**
		 * 
		 * @param _pref
		 * @param _table
		 * @param _column
		 * @param _object
		 */
		public static void userlog( String _pref, HQSQLTable _table,  String _column, Object _object ) throws SFException,Exception{
			EncryptUtils.ICustom.userlog("ucmframe", _pref + ( _table != null?_table.getDataSource()+ "[" + _table.getMapingEnty() + "]":"NULL") + 
					"\t" +  _column + "\t" + ( _object != null?_object:"NULL") );
		}
		
		/**
		 * 
		 * @param _dialect
		 * @param _stmt
		 * @param _column
		 * @param index
		 * @param _objective
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _jj_object(AbstractDialectImpl _dialect, java.sql.PreparedStatement _stmt, HQSQLTable _table, HQSQLTable.HQSQLColumn _column, int _index, Object _object) throws SFException,Exception{
			try
			{
				_dialect.validate( _table, _column, _object );
				if( _column.isASTBlank() ){
					Transfer._null(_stmt, _table, _column, _index, _object);
				}
				else if( _column.isASTBoolean() ){
					Transfer._boolean(_stmt, _table, _column, _index, _object);
				}
				else if( _column.isASTDigital() ){
					Transfer._digital(_stmt, _table, _column, _index, _object);
				}
				else if( _column.isASTDate() ){
					Transfer._timestamp(_stmt, _table, _column, _index, _object);
				}
				else if( _column.isASTTime() ){
					Transfer._timestamp(_stmt, _table, _column, _index, _object);
				}
				else if( _column.isASTTimestamp() ){
					Transfer._timestamp(_stmt, _table, _column, _index, _object);
				}
				else if( _column.isASTChar() ){
					Transfer._string( _stmt, _table, _column, _index, _object );
				}
				else if( _column.isASTString() ){
					Transfer._string( _stmt, _table, _column, _index, _object );
				}
				else{
					_object = ClassUtils.IClass.transfer( _object, _column.getJavaType() );
					_stmt.setObject( _index, _object, _column.getDataType() );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _stmt
		 * @param _table
		 * @param _column
		 * @param _index
		 * @param _object
		 * @throws SFException
		 * @throws Exception
		 */
		private static void _null( java.sql.PreparedStatement _stmt, HQSQLTable _table, HQSQLTable.HQSQLColumn _column, int _index, Object _object) throws SFException,Exception{
			try
			{
				_stmt.setNull( _index, java.sql.Types.NULL );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _stmt
		 * @param _table
		 * @param _column
		 * @param _index
		 * @param _object
		 * @throws SFException
		 * @throws Exception
		 */
		private static void _boolean( java.sql.PreparedStatement _stmt, HQSQLTable _table, HQSQLTable.HQSQLColumn _column, int _index, Object _object) throws SFException,Exception{
			try
			{
				_stmt.setBoolean( _index, Boolean.parseBoolean( _object.toString() ) );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _stmt
		 * @param _column
		 * @param index
		 * @param _objective
		 * @throws SFException
		 * @throws Exception
		 */
		private static void _digital( java.sql.PreparedStatement _stmt, HQSQLTable _table, HQSQLTable.HQSQLColumn _column, int _index, Object _object) throws SFException,Exception{
			try
			{
				if( _column.isASTArray() ){
					byte _byte[] = new byte[ ((java.lang.Byte[])_object).length ];
					for( int index = 0; _byte != null && index < _byte.length; index++ ){
						_byte[index] = ((java.lang.Byte[])_object)[index].byteValue();
					}
					_stmt.setBinaryStream( _index, new java.io.ByteArrayInputStream( _byte ) );
				}
				else if( _column.isASTByte() ){
					if( _object instanceof java.math.BigDecimal ){
						java.math.BigDecimal _decimal = (java.math.BigDecimal)_object;
						_stmt.setByte( _index, _decimal.byteValue() );
					}
					else{
						_stmt.setByte( _index, Byte.parseByte( _object.toString() ) );
					}
				}
				else if( _column.isASTShort() ){
					if( _object instanceof java.math.BigDecimal ){
						java.math.BigDecimal _decimal = (java.math.BigDecimal)_object;
						_stmt.setShort( _index, _decimal.shortValue() );
					}
					else{
						_stmt.setShort( _index, Short.parseShort( _object.toString() ) );
					}
				}
				else if( _column.isASTInt() ){
					if( _object instanceof java.math.BigDecimal ){
						java.math.BigDecimal _decimal = (java.math.BigDecimal)_object;
						_stmt.setInt( _index, _decimal.intValue() );
					}
					else{
						_stmt.setInt( _index, Integer.parseInt( _object.toString() ) );
					}
				}
				else if( _column.isASTLong() ){
					if( _object instanceof java.math.BigDecimal ){
						java.math.BigDecimal _decimal = (java.math.BigDecimal)_object;
						_stmt.setLong( _index, _decimal.longValue() );
					}
					else{
						_stmt.setLong( _index, Long.parseLong( _object.toString() ) );
					}
				}
				else if( _column.isASTFloat() ){
					if( _object instanceof java.math.BigDecimal ){
						java.math.BigDecimal _decimal = (java.math.BigDecimal)_object;
						_stmt.setFloat( _index, _decimal.floatValue() );
					}
					else{
						_stmt.setFloat( _index, Float.parseFloat( _object.toString() ) );
					}
				}
				else if( _column.isASTDouble() ){
					if( _object instanceof java.math.BigDecimal ){
						java.math.BigDecimal _decimal = (java.math.BigDecimal)_object;
						_stmt.setDouble( _index, _decimal.doubleValue() );
					}
					else{
						_stmt.setDouble( _index, Double.parseDouble( _object.toString() ) );
					}
				}
				else{
					_stmt.setObject( _index, _object, _column.getDataType() );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _stmt
		 * @param _column
		 * @param index
		 * @param _objective
		 * @throws SFException
		 * @throws Exception
		 */
		private static void _timestamp( java.sql.PreparedStatement _stmt, HQSQLTable _table, HQSQLTable.HQSQLColumn _column, int _index, Object _object) throws SFException,Exception{
			try
			{
				java.sql.Timestamp _time = TimeUtils.getTime( _object );
				if( _column.isASTDate() ){
					_stmt.setDate( _index, new java.sql.Date( _time.getTime() ) );
				}
				else if( _column.isASTTime() ){
					_stmt.setTime( _index, new java.sql.Time( _time.getTime() ) );
				}
				else if( _column.isASTTimestamp() ){
					_stmt.setTimestamp( _index, _time );
				}
				else{
					_stmt.setObject( _index, _object, _column.getDataType() );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _stmt
		 * @param _column
		 * @param index
		 * @param _objective
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _string( java.sql.PreparedStatement _stmt, HQSQLTable _table, HQSQLTable.HQSQLColumn _column, int _index, Object _object) throws SFException,Exception{
			try
			{
				String _string = _object.toString();
				if( _column.isASTChar() ){
					_stmt.setString( _index,  _string );
				}
				else if( _column.isASTString() ){
					if( _string.length() > 2000 ){
						_stmt.setCharacterStream( _index, new java.io.StringReader( _string ), _string.length() );
					}
					else{
						_stmt.setString( _index, _string );
					}
				}
				else{
					_stmt.setObject( _index, _object, _column.getDataType() );
				}
			}
			finally{
				
			}
		}
		
	}
}