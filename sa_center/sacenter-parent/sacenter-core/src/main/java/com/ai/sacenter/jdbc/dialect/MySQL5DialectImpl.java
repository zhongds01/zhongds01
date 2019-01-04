package com.ai.sacenter.jdbc.dialect;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLDelegate;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jdbc.NoSQLDelegate;
import com.ai.sacenter.jdbc.dialect.OraclePtmtDelegation;
import com.ai.sacenter.subtable.SFSubTableFactory;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: JDBC_HQSQLģʽ</p>
 * <p>Copyright: Copyright (c) 2014-10-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class MySQL5DialectImpl extends AbstractDialectImpl {

	public MySQL5DialectImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.dialect.AbstractDialectImpl#transfer(java.lang.Object, com.ai.sacenter.jdbc.NoSQLDelegate)
	 */
	public void transfer(Object fromObject, NoSQLDelegate fromMBean) throws SFException, Exception {
		try
		{
			class MYSQLTransferImpl{
				public MYSQLTransferImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromEntity
				 * @throws SFException
				 * @throws Exception
				 */
				private void transferWithBefore( HQSQLEntityBean fromEntity ) throws SFException,Exception{
					try
					{
						if( fromEntity.hasPropertyName( IUpdcConst.IUpdbm.IUpdmc.REGION_ID ) &&
								fromEntity.get( IUpdcConst.IUpdbm.IUpdmc.REGION_ID ) == null ){
							String _region_id = CenterUtils.ICustom.getRegionId();
							fromEntity.set( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, _region_id );
						}
						if( fromEntity.hasPropertyName( IUpdcConst.IUpdbm.IUpdmc.REGION_CODE ) &&
								fromEntity.get( IUpdcConst.IUpdbm.IUpdmc.REGION_CODE ) == null ){
							String _region_id = CenterUtils.ICustom.getRegionId();
							fromEntity.set( IUpdcConst.IUpdbm.IUpdmc.REGION_CODE, _region_id );
						}
					}
					finally{
						
					}
				}
			}
			MYSQLTransferImpl fromMYSQLTfImpl = new MYSQLTransferImpl();
			try
			{
				Object fromARRAY[] = new Object[]{fromObject};
				if( ClassUtils.IClass.isArray( fromObject ) ){ fromARRAY = (Object[])fromObject; }
				for( int index = 0 ; fromARRAY != null && index < fromARRAY.length; index++ ){
					HQSQLEntityBean fromEntity = (HQSQLEntityBean)fromARRAY[index];
					HQSQLTable fromMYSQL = fromEntity.getObjectType();
					fromMYSQLTfImpl.transferWithBefore( fromEntity );
					if( SFSubTableFactory.isThreShold( fromMYSQL.getMapingEnty() , fromEntity.getProperties() ) == false ){
						MySQL5HQSQLTable fromMYSQL5 = HQSQLUtils.getMYSQLTable( fromEntity );
						MySQL5HQSQLDelegate fromDelegate = (MySQL5HQSQLDelegate)fromMBean.getSUBFLOW().getSUBFLOW( fromMYSQL5 );
						String aINDEX = ClassUtils.getINDEX( new String[]{fromMYSQL5.getDataSource(), ".", fromMYSQL5.getMapingEnty() });
						if( fromDelegate.getREPOSITORY().containsKey( aINDEX ) == false ){
							fromDelegate.getREPOSITORY().put( aINDEX , new java.util.ArrayList() );
						}
						((java.util.List)fromDelegate.getREPOSITORY().get( aINDEX ) ).add( fromEntity );
					}
				}
			}
			finally{
				if( fromMYSQLTfImpl != null ){ fromMYSQLTfImpl = null; }
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.dialect.AbstractDialectImpl#commit(com.ai.sacenter.jdbc.NoSQLDelegate, com.ai.sacenter.jdbc.HQSQLDelegate)
	 */
	public void commit(NoSQLDelegate fromMBean, HQSQLDelegate fromDelegate) throws SFException, Exception {
		OraclePtmtDelegation fromORACLE = new OraclePtmtDelegation();
		try
		{
			class MYSQLCommitTfImpl{
				public MYSQLCommitTfImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromMYSQL
				 * @param fromEntity
				 * @param fromPtmt
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferWithCreate( MySQL5HQSQLTable fromMYSQL, HQSQLEntityBean fromEntity, OraclePtmtDelegation fromPtmt) throws SFException, Exception{
					try
					{
						String fromCREATE = fromMYSQL.getSQL().getCREATE();
						OraclePtmtDelegate fromMYSQLPtmt = (OraclePtmtDelegate)fromPtmt.getCREATE().get( fromCREATE );
						if( fromMYSQLPtmt == null ){
							fromPtmt.getCREATE().put( fromCREATE, fromMYSQLPtmt = new OraclePtmtDelegate( fromMYSQL ) );
						}
						fromMYSQLPtmt.getDelegation().add( fromEntity );
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMYSQL
				 * @param fromEntity
				 * @param fromPtmt
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferWithModify( MySQL5HQSQLTable fromMYSQL, HQSQLEntityBean fromEntity, OraclePtmtDelegation fromPtmt) throws SFException, Exception{
					java.util.List fromModify = new java.util.ArrayList();
					try
					{
						for( java.util.Iterator itera = fromEntity.getNewProperties().entrySet().iterator(); itera.hasNext(); ){
							java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
							HQSQLTable.HQSQLColumn _column = fromMYSQL.getProperty( fromEntry.getKey().toString() );
							if( _column == null || _column.isASTVirtual() ) continue;
							String fromINDEX = ClassUtils.getINDEX( new String[]{ _column.getName(), " = :", _column.getName() } );
							fromModify.add( fromINDEX );
						}
						if( fromModify != null && fromModify.size() > 0 ){
							OraclePtmtDelegate fromMYSQLPtmt = null;
							String fromUPDATE = fromMYSQL.getSQL().getMODIFY();
							if( StringUtils.isBlank( fromUPDATE ) ){
								ExceptionFactory.throwOracle("IOS0014019", new String[]{fromMYSQL.getDataSource(), 
										fromMYSQL.getMapingEnty() });
							}
							fromUPDATE = StringUtils.replace( fromUPDATE, "{_MODIFY_HQSQL_}", StringUtils.join(fromModify.iterator(), " , "));
							fromMYSQLPtmt = (OraclePtmtDelegate)fromPtmt.getUPDATE().get( fromUPDATE );
							if( fromMYSQLPtmt == null ){
								fromPtmt.getUPDATE().put( fromUPDATE, fromMYSQLPtmt = new OraclePtmtDelegate( fromMYSQL )  );
							}
							fromMYSQLPtmt.getDelegation().add( fromEntity );
						}
					}
					finally{
						if( fromModify != null ){ fromModify.clear(); fromModify = null; }
					}
				}
				
				/**
				 * 
				 * @param fromMYSQL
				 * @param fromEntity
				 * @param fromPtmt
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferWithDelete( MySQL5HQSQLTable fromMYSQL, HQSQLEntityBean fromEntity, OraclePtmtDelegation fromPtmt) throws SFException, Exception{
					try
					{
						OraclePtmtDelegate fromMYSQLPtmt = null;
						String fromDELETE = fromMYSQL.getSQL().getDELETE();
						if( StringUtils.isBlank( fromDELETE ) ){
							ExceptionFactory.throwOracle("IOS0014019", new String[]{fromMYSQL.getDataSource(), 
									fromMYSQL.getMapingEnty() });
						}
						fromMYSQLPtmt = (OraclePtmtDelegate)fromPtmt.getDELETE().get( fromDELETE );
						if( fromMYSQLPtmt == null ){
							fromPtmt.getDELETE().put( fromDELETE, fromMYSQLPtmt = new OraclePtmtDelegate( fromMYSQL ) );
						}
						fromMYSQLPtmt.getDelegation().add( fromEntity );
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMYSQL
				 * @param fromEntity
				 * @param fromPtmt
				 * @throws SFException
				 * @throws Exception
				 */
				private void transferWithGroup(MySQL5HQSQLTable fromMYSQL, HQSQLEntityBean fromEntity, OraclePtmtDelegation fromPtmt ) throws SFException, Exception{
					try
					{
						if( fromEntity.isNew() ){
							_transferWithCreate( fromMYSQL, fromEntity, fromPtmt );
						}
						else if( fromEntity.isModified() ){
							_transferWithModify( fromMYSQL, fromEntity, fromPtmt );
						}
						else if( fromEntity.isDeleted() ){
							_transferWithDelete( fromMYSQL, fromEntity, fromPtmt );
						}
						for( java.util.Iterator itera = fromEntity.getLittle().getLittle().iterator(); itera.hasNext(); ){
							HQSQLEntityBean fromSubJect = (HQSQLEntityBean)itera.next();
							MySQL5HQSQLTable fromORACLE = HQSQLUtils.getMYSQLTable( fromSubJect );
							transferWithGroup( fromORACLE, fromSubJect, fromPtmt );
						}
					}
					finally{
						
					}
				}
				
			}
			MYSQLCommitTfImpl fromMYSQLTfImpl = new MYSQLCommitTfImpl();
			try
			{
				MBeanDelegate fromGlobal = UpfsvcManager.getMBean().getQuality();
				MySQL5HQSQLDelegate fromMYSQL5 = (MySQL5HQSQLDelegate)fromDelegate;
				for( java.util.Iterator itera = fromMYSQL5.getREPOSITORY().entrySet().iterator();itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					String fromKEY[] = StringUtils.wildcardArray( (String)fromEntry.getKey() , "." );
					java.util.List fromUpdfmx = (java.util.List)fromEntry.getValue();
					MySQL5HQSQLTable fromMYSQL = HQSQLUtils.getMYSQLTable( fromKEY[0], fromKEY[1] );
					for( java.util.Iterator iterap = fromUpdfmx.iterator(); iterap.hasNext(); ){
						HQSQLEntityBean fromEntity = (HQSQLEntityBean)iterap.next();
						fromMYSQLTfImpl.transferWithGroup(fromMYSQL, fromEntity, fromORACLE);
					}
				}
				if( fromORACLE != null && fromORACLE.getDELETE().size() > 0 ){
					commitWithResultLevel(fromORACLE.getDELETE(), fromMBean, fromGlobal);
				}
				if( fromORACLE != null && fromORACLE.getUPDATE().size() > 0 ){
					commitWithResultLevel(fromORACLE.getUPDATE(), fromMBean, fromGlobal);
				}
				if( fromORACLE != null && fromORACLE.getCREATE().size() > 0 ){
					commitWithResultLevel(fromORACLE.getCREATE(), fromMBean, fromGlobal);
				}
			}
			finally{
				if( fromMYSQLTfImpl != null ){ fromMYSQLTfImpl = null; }
			}
			
		}
		finally{
			if( fromORACLE != null ){ fromORACLE = null; }
		}
	}
	
	/**
	 * 
	 * @param fromUpdbm
	 * @param fromMBean
	 * @param fromGlobal
	 * @throws SFException
	 * @throws Exception
	 */
	private void commitWithResultLevel(java.util.Map fromUpdbm, NoSQLDelegate fromMBean, MBeanDelegate fromGlobal) throws SFException,Exception{
		try
		{
			OraclePtmtDelegate fromDelegation = null;
			NoSQLDelegate.IUpdfmxOffer fromUpdfmx = fromMBean.getSUBFLOW();
			for( java.util.Iterator itera = fromUpdbm.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				String fromSQL = (String)fromEntry.getKey();
				fromDelegation = (OraclePtmtDelegate)fromEntry.getValue();
				HQSQLTable fromMYSQL = fromDelegation.getTable();
				java.util.ArrayList fromPARAM = new java.util.ArrayList();
				try
				{
					for( java.util.Iterator iterap = fromDelegation.getDelegation().iterator(); iterap.hasNext(); ){
						HQSQLEntityBean fromEntity = (HQSQLEntityBean)iterap.next();
						fromPARAM.add( fromEntity.getProperties() );
					}
					super._exec(fromMYSQL.getDataSource(), fromSQL, fromMYSQL, fromPARAM);
					super.userdbsmlog(fromMYSQL.getMapingEnty(), fromPARAM);
					fromUpdfmx.setSUMING( fromUpdfmx.getSUMING() + fromPARAM.size() );
				}
				catch( java.lang.Exception aEXCEPTION ){
					ExceptionFactory.throwOracleInside("IOS0014016", new String[]{fromMYSQL.getDataSource(),
							fromMYSQL.getMapingEnty(), aEXCEPTION.getMessage() }, 
							aEXCEPTION);
				}
				finally{
					if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
				}
			}
		}
		finally{
			
		}
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
	public java.util.ArrayList retrieve(ObjectType fromTYPE, String fromCond, java.util.HashMap fromPARAM) throws SFException, Exception{
		java.util.ArrayList fromArray = null;
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			String _owner = OracleUtils.getTransactionName(fromTYPE, fromPARAM);
			OracleHQSQLTable _oracle = HQSQLUtils.getOracleTable( _owner, fromTYPE );
			fromSQL.append( _oracle.getSQL().getQUERY() );
			if( StringUtils.isBlank( fromCond ) == false ){ fromSQL.append( " and " ).append( fromCond ); }
			fromArray = retrieveByResultLevel( _oracle, fromSQL.toString(), fromPARAM,  -1l );
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromArray;
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
	public java.util.ArrayList retrieve(String fromTYPE, String fromCond, java.util.HashMap fromPARAM) throws SFException, Exception{
		java.util.ArrayList fromArray = null;
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			String fromOWNER = OracleUtils.getTransactionName( fromPARAM );
			MySQL5HQSQLTable fromMYSQL = HQSQLUtils.getMYSQLTable( fromOWNER, fromTYPE );
			fromSQL.append( fromMYSQL.getSQL().getQUERY() );
			if( StringUtils.isBlank( fromCond ) == false ){ fromSQL.append( " and " ).append( fromCond ); }
			fromArray = retrieveByResultLevel( fromMYSQL, fromSQL.toString(), fromPARAM,  -1l );
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromArray;
	}
	
	/**
	 * 
	 * @param fromMYSQL
	 * @param fromSQL
	 * @param fromPARAM
	 * @param aMaxRow
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	private java.util.ArrayList retrieveByResultLevel(HQSQLTable fromMYSQL, String fromSQL, java.util.HashMap fromPARAM, long aMaxRow) throws SFException, Exception{
		java.util.ArrayList fromArray = new java.util.ArrayList();
		java.sql.Connection aTransaction = null;
    	java.sql.ResultSet _resultset = null;
	  	java.sql.PreparedStatement _statement = null;
	  	try
		{
	  		long fromCount = aMaxRow;
	  		aTransaction = OracleUtils.getTransaction( fromMYSQL.getDataSource() );
	  		HQSQLSQLParser fromSQLParser = HQSQLSQLParser.getINSTANCE( fromSQL );
	  		fromSQL = SFSubTableFactory.createTableSQL( fromSQLParser.getSQL(), fromPARAM );
	  		_statement = aTransaction.prepareStatement( fromSQL );
	  		wrapWithStat(_statement, fromSQLParser, fromMYSQL, fromPARAM);
	  		_statement.setFetchSize( 200 );
	  		_resultset = _statement.executeQuery();
	  	    while( _resultset.next() ){
	  	    	HQSQLEntityBean fromSubSQL = HQSQLUtils.ICustom.getASTBOEntity( fromMYSQL );
	  	    	retrieveByResultLevel( _resultset, fromMYSQL, fromSubSQL );
	  	    	fromArray.add( fromSubSQL );
	  	    	if( aMaxRow > 0 ) fromCount--;
	    		if( aMaxRow > 0 && fromCount <= 0 ) break;
		    }
		}
		finally{
			if( _resultset != null ) {_resultset.close();_resultset=null;}
			if( _statement != null ) {_statement.close();_statement=null;}
			if( aTransaction != null ) { aTransaction.close();}
		}
		return fromArray;
	}
	
}
