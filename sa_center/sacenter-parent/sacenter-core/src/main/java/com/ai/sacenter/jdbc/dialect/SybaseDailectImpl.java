package com.ai.sacenter.jdbc.dialect;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLDelegate;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jdbc.NoSQLDelegate;
import com.ai.sacenter.subtable.ISubSQLOffer;
import com.ai.sacenter.subtable.ISubTableWrapper;
import com.ai.sacenter.subtable.SFSubTableFactory;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISubTableTemplate;
import com.ai.sacenter.valuebean.ISubTableTemplate.ISubSQLTable;
import com.ai.sacenter.valuebean.ISubTableTemplate.ISubSQLTableRel;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 基于JDBC_MAP模式</p>
 * <p>Copyright: Copyright (c) 2014-10-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SybaseDailectImpl extends AbstractDialectImpl {

	public SybaseDailectImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.dialect.AbstractDialectImpl#transfer(java.lang.Object, com.ai.sacenter.jdbc.NoSQLDelegate)
	 */
	public void transfer(Object fromObject, NoSQLDelegate fromMBean) throws SFException, Exception {
		try
		{
			class SybaseTransferImpl{
				public SybaseTransferImpl(){
					super();
				}
				
				/**
				 * 按照二级网元系统数据仓库规范结构化工单
				 * @param fromUpdbc
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				private java.util.Map transferWithGroup( java.util.Map fromUpdbc ) throws SFException,Exception{
					java.util.Map fromGroup = new java.util.HashMap();
					try
					{
						OraclePtmtDelegate fromOraclePtmt = null;
						for( java.util.Iterator itera = fromUpdbc.entrySet().iterator(); itera.hasNext(); ){
							java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
							String _table_name = (String)fromEntry.getKey();
							OracleHQSQLTable _table = HQSQLUtils.getOracleTable( _table_name );
							java.util.List _ptmtoffer = (java.util.List)fromEntry.getValue();
							for( java.util.Iterator iterap = _ptmtoffer.iterator(); iterap.hasNext(); ){
								HQSQLEntityBean fromEntity = HQSQLUtils.ICustom.transfer( iterap.next(), _table );
								OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( _table.getMapingEnty(), fromEntity.getProperties() );
								if( ( fromOraclePtmt = (OraclePtmtDelegate)fromGroup.get( fromORACLE ) ) == null ){
									fromGroup.put( fromORACLE, fromOraclePtmt = new OraclePtmtDelegate( fromORACLE ) );
								}
								fromOraclePtmt.getDelegation().add( fromEntity );
							}
						}
					}
					finally{
						
					}
					return fromGroup;
				}
				/**
				 * 按照当前数据仓库结构化删除数据
				 * @param fromORACLE
				 * @param fromOraclePtmt
				 * @param fromMBean
				 * @throws SFException
				 * @throws Exception
				 */
				private void transferWithDelete( OracleHQSQLTable fromORACLE, OraclePtmtDelegate fromOraclePtmt, NoSQLDelegate fromMBean) throws SFException,Exception{
					try
					{
						for( java.util.Iterator itera = fromOraclePtmt.getDelegation().iterator(); itera.hasNext(); ){
							HQSQLEntityBean fromSubJect = (HQSQLEntityBean)itera.next();
							fromSubJect.setStsToOld(); fromSubJect.delete();
							HQSQLFactory.getMySQL5().transfer( fromSubJect, fromMBean );
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 按照当前数据仓库结构化历史数据
				 * @param fromORACLE
				 * @param fromSyptmt
				 * @param fromMBean
				 * @throws SFException
				 * @throws Exception
				 */
				private void transferWithHistory(OracleHQSQLTable fromORACLE, OraclePtmtDelegate fromSyptmt, NoSQLDelegate fromMBean) throws SFException,Exception{
					try
					{
						for( java.util.Iterator itera = fromSyptmt.getDelegation().iterator(); itera.hasNext(); ){
							HQSQLEntityBean fromEntity = (HQSQLEntityBean)itera.next();
							HQSQLEntityBean fromHistory = HQSQLUtils.ICustom.transferAsHistory( fromORACLE, fromEntity );
							fromHistory.setStsToNew();
							HQSQLFactory.getMySQL5().transfer( fromHistory, fromMBean );
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 按照激活分表规范结构化数据仓库
				 * @param fromORACLE
				 * @param fromPtmts
				 * @param fromSubTable
				 * @param fromMBean
				 * @throws SFException
				 * @throws Exception
				 */
				private void transferWithSubTable( OracleHQSQLTable fromORACLE, OraclePtmtDelegate fromPtmts, ISubSQLTable fromSubTable, NoSQLDelegate fromMBean) throws SFException,Exception{
					IUpdcContext aContext = ClassUtils.getIContextImpl();
					try
					{
						for( java.util.Iterator itera = fromSubTable.getTARGET().values().iterator(); itera.hasNext(); ){
							ISubSQLTableRel _subtablerel = (ISubSQLTableRel)itera.next();
							for( java.util.Iterator iterap = fromPtmts.getDelegation().iterator(); iterap.hasNext(); ){
								HQSQLEntityBean fromEntity = (HQSQLEntityBean)iterap.next();
								ISubSQLOffer fromUpdfmx = new ISubSQLOffer( fromORACLE, fromEntity, fromSubTable, _subtablerel );
								SFCenterFactory.pushCenterInfo( Class.forName( _subtablerel.getPERSISTENT() ), fromEntity );
								UpfsvcManager.getRocket().beginTransaction( fromEntity, fromUpdfmx.getSubFlow().getSubFlow(), aContext);
								try
								{
									_transferWithSubTabRel( fromEntity, fromUpdfmx, fromMBean, aContext );
									UpfsvcManager.getRocket().commitTransaction();
								}
								catch( java.lang.Exception exception ){
									UpfsvcManager.getRocket().rollbackTransaction();
									throw exception;
								}
								finally{
									SFCenterFactory.popCenterInfo();
									if( fromUpdfmx != null ){ fromUpdfmx = null; }
								}
							}
						}
					}
					finally{
						if( aContext != null ){ aContext.clear(); aContext = null; }
					}
				}
				
				/**
				 * 按照激活分表规范结构化数据仓库
				 * @param fromEntity
				 * @param fromUpdfmx
				 * @param fromMBean
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferWithSubTabRel(HQSQLEntityBean fromEntity, ISubSQLOffer fromUpdfmx, NoSQLDelegate fromMBean, IUpdcContext aContext ) throws SFException,Exception{
					java.util.Map fromSQLLite = null;
					try
					{
						ISubTableTemplate.ISubSQLTableRel _subtablerel = fromUpdfmx.getSubFlow().getSubJsql();
						ISubTableWrapper fromWrapper = HQSQLFactory.getIDataStoreSV( _subtablerel.getPERSISTENT() );
						fromSQLLite = fromWrapper.transform( fromEntity, fromUpdfmx, aContext );
						if( fromSQLLite != null && fromSQLLite.size() > 0 ){
							HQSQLTable fromSYBASE = fromUpdfmx.getSubFlow().getSubJect();
							for( java.util.Iterator itera = fromSQLLite.entrySet().iterator(); itera.hasNext(); ){
								java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
								String _table_name = (String)fromEntry.getKey();
								MySQL5HQSQLTable fromMYSQL = HQSQLUtils.getMYSQLTable( fromSYBASE.getDataSource(), _table_name );
								java.util.List fromTarget = (java.util.List)fromEntry.getValue();
								for( java.util.Iterator iterap = fromTarget.iterator(); iterap.hasNext(); ){
									HQSQLEntityBean fromSubJect = HQSQLUtils.ICustom.transfer( iterap.next(), fromMYSQL );
									HQSQLFactory.getMySQL5().transfer( fromSubJect, fromMBean );
								}
							}
						}
					}
					finally{
						if( fromSQLLite != null ){ fromSQLLite.clear(); fromSQLLite = null; }
					}
				}
			}
			SybaseTransferImpl fromSyBaseImpl = new SybaseTransferImpl();
			java.util.Map fromGroup = null;
			try
			{
				ISubTableTemplate.ISubSQLTable fromSubTable = null;
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( fromMBean.getSUBFLOW().getREPOSITORY() );
				fromGroup = fromSyBaseImpl.transferWithGroup( (java.util.HashMap)fromObject );
				for( java.util.Iterator itera = fromGroup.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					OracleHQSQLTable fromORACLE = (OracleHQSQLTable)fromEntry.getKey();
					OraclePtmtDelegate fromPtmts = (OraclePtmtDelegate)fromEntry.getValue();
					fromSubTable = HQSQLUtils.ISystem.getSFSubTableOffer( fromUpffm.getID(), fromORACLE.getMapingEnty() );
					//1根据激活分表关系目标规范创建远端结构化数据仓库
					fromSyBaseImpl.transferWithSubTable(fromORACLE, fromPtmts, fromSubTable, fromMBean);
					//2激活分表规范中基础表名不为空则删除基础表数据仓库
					if( StringUtils.isBlank( fromSubTable.getBASE() ) == false ){
						fromSyBaseImpl.transferWithDelete(fromORACLE, fromPtmts, fromMBean);
					}
					//3激活分表规范中历史表名不为空则备份数据表数据仓库
					if( StringUtils.isBlank( fromSubTable.getHISTORY() ) == false ){
						fromORACLE = HQSQLUtils.getOracleTable(fromORACLE.getDataSource(), fromSubTable.getHISTORY() );
						fromSyBaseImpl.transferWithHistory(fromORACLE, fromPtmts, fromMBean);
					}
				}
			}
			finally{
				if( fromGroup != null ){ fromGroup.clear(); fromGroup = null; }
				if( fromSyBaseImpl != null ){ fromSyBaseImpl = null; }
			}
			
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.dialect.AbstractDialectImpl#commit(com.ai.sacenter.jdbc.NoSQLDelegate, com.ai.sacenter.jdbc.HQSQLDelegate)
	 */
	public void commit(NoSQLDelegate fromMBean, HQSQLDelegate fromDelegate) throws SFException, Exception {
		NoSQLDelegate fromLMBean = new NoSQLDelegate( fromMBean, fromDelegate.getPERSISTENT() );
		try
		{
			MBeanDelegate fromGlobal = UpfsvcManager.getMBean().getQuality();
			NoSQLDelegate.IUpdfmxOffer fromUpdfmx = fromMBean.getSUBFLOW();
			SybaseHQSQLDelegate fromSysbase = (SybaseHQSQLDelegate)fromDelegate;
			if( fromSysbase.getDELETE() != null && fromSysbase.getDELETE().size() > 0 ){
				deleteWithBatch(fromGlobal, 
						fromLMBean, 
						fromSysbase.getDELETE() );
			}
			if( fromSysbase.getHISTORY() != null && fromSysbase.getHISTORY().size() > 0 ){
				createWithBatch(fromGlobal, 
						fromLMBean, 
						fromSysbase.getHISTORY() );
			}
			if( fromSysbase.getCREATE() != null && fromSysbase.getCREATE().size() > 0 ){
				createWithBatch(fromGlobal, 
						fromLMBean, 
						fromSysbase.getCREATE() );
			}
			fromLMBean.getSUBFLOW().setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			fromUpdfmx.setSUMING( fromUpdfmx.getSUMING() + fromLMBean.getSUBFLOW().getSUMING() );
		}
		finally{
			if( fromLMBean != null ){ fromLMBean = null;}
		}
	}
	/**
	 * 
	 * @param fromTable
	 * @param fromPARAM
	 * @param fromMBean
	 * @throws SFException
	 * @throws Exception
	 */
	public void create(String fromTable , 
			java.util.HashMap fromPARAM[],
			NoSQLDelegate fromMBean ) throws SFException,Exception{
		java.util.Map fromUpdbm = null;
		java.util.HashMap fromUpdbc = new java.util.HashMap();
		MBeanDelegate fromGlobal = new MBeanDelegate();
		try
		{
			fromUpdbm = groupWithOwner(fromPARAM, fromMBean );
			for( java.util.Iterator itera = fromUpdbm.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				String fromOWNER = (String)fromEntry.getKey();
				java.util.List fromList = (java.util.List)fromEntry.getValue();
				String aINDEX = ClassUtils.getINDEX(new String[]{fromOWNER,".",fromTable } );
				if( fromUpdbc.containsKey( aINDEX ) == false ){
					fromUpdbc.put( aINDEX , new java.util.ArrayList() );
				}
				ClassUtils.IMerge.merge( fromList , (java.util.List)fromUpdbc.get( aINDEX ) );
			}
			createWithBatch(fromGlobal, fromMBean,  fromUpdbc );
			fromMBean.getSUBFLOW().setCREATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
		}
		finally{
			if( fromGlobal != null ){ fromGlobal = null; }
			if( fromUpdbc != null ){ fromUpdbc.clear(); fromUpdbc = null; }
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
		}
	}
	/**
	 * 
	 * @param fromTable
	 * @param fromPARAM
	 * @param fromMBean
	 * @throws SFException
	 * @throws Exception
	 */
	public void delete(String fromTable , 
			java.util.HashMap fromPARAM[],
			NoSQLDelegate fromMBean ) throws SFException,Exception{
		java.util.Map fromUpdbm = null;
		java.util.HashMap fromUpdbc = new java.util.HashMap();
		MBeanDelegate fromGlobal = new MBeanDelegate();
		try
		{
			fromUpdbm = groupWithOwner(fromPARAM, fromMBean );
			for( java.util.Iterator itera = fromUpdbm.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				String fromOWNER = (String)fromEntry.getKey();
				java.util.List fromList = (java.util.List)fromEntry.getValue();
				String aINDEX = ClassUtils.getINDEX(new String[]{fromOWNER,".",fromTable } );
				if( fromUpdbc.containsKey( aINDEX ) == false ){
					fromUpdbc.put( aINDEX , new java.util.ArrayList() );
				}
				ClassUtils.IMerge.merge( fromList , (java.util.List)fromUpdbc.get( aINDEX ) );
			}
			deleteWithBatch(fromGlobal, fromMBean,  fromUpdbc );
			fromMBean.getSUBFLOW().setCREATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
		}
		finally{
			if( fromGlobal != null ){ fromGlobal = null; }
			if( fromUpdbc != null ){ fromUpdbc.clear(); fromUpdbc = null; }
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
		}
	}
	/**
	 * 
	 * @param fromSQL
	 * @param fromPARAM
	 * @param fromMBean
	 * @throws SFException
	 * @throws Exception
	 */
	public void exec(String fromSQL, java.util.HashMap fromPARAM[], NoSQLDelegate fromGlobal) throws SFException,Exception{
		java.util.Map fromUpdbc = null;
		NoSQLDelegate fromMBean = new NoSQLDelegate( fromGlobal, fromGlobal.getSUBFLOW().getREPOSITORY() );
		try
		{
			NoSQLDelegate.IUpdfmxOffer fromUpdfmx = fromMBean.getSUBFLOW();
			fromUpdbc = groupWithOwner(fromPARAM, fromMBean );
			for( java.util.Iterator itera = fromUpdbc.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				String fromOWNER = (String)fromEntry.getKey();
				java.util.ArrayList fromUpdbm = (java.util.ArrayList)fromEntry.getValue();
				super._exec(fromOWNER, 
						fromSQL, 
						null, 
						fromUpdbm);
				fromMBean.getSUBFLOW().setSUMING( fromMBean.getSUBFLOW().getSUMING() + fromUpdbm.size() );
			}
			fromMBean.getSUBFLOW().setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			fromUpdfmx.setSUMING( fromUpdfmx.getSUMING() + fromMBean.getSUBFLOW().getSUMING() );
			if( log.isDebugEnabled() ) log.debug("batch Execute finish[REGION_ID:" + "NULL" + ",REGION:NULL" + 
					"[Routing Information by the itself JVM settings]], Data Table [" + fromMBean.getSUBFLOW().getSUMING() 
					+"] ,Time-consuming ["+(fromMBean.getSUBFLOW().getCOMPLETE().getTime() - 
							fromMBean.getSUBFLOW().getCREATE().getTime() )+"]ms");
		}
		finally{
			if( fromMBean != null ){ fromMBean = null; }
			if( fromUpdbc != null ){ fromUpdbc.clear(); fromUpdbc = null; }
		}
	}
	/**
	 * 
	 * @param fromDAO
	 * @param fromTable
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList retrieve(String fromDAO, String fromTable, String fromCond, java.util.HashMap fromPARAM) throws SFException, Exception{
		java.util.ArrayList fromTABLE = null;
		NoSQLDelegate fromMBean = new NoSQLDelegate( fromTable, fromDAO );
		try
		{
			fromTABLE = retrieve(fromTable, fromCond, fromPARAM, fromMBean);
		}
		finally{
			if( fromMBean != null ){ fromMBean = null; }
		}
		return fromTABLE;
	}
	/**
	 * 
	 * @param fromDAO
	 * @param fromTable
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList retrieve(String fromTable, String fromCond, java.util.HashMap fromPARAM, NoSQLDelegate fromMBean) throws SFException, Exception{
		java.util.ArrayList fromTABLE = null;
		java.util.Map fromDelegate = null;
		try
		{
			fromDelegate = groupWithOwner(new java.util.HashMap[]{fromPARAM}, fromMBean );
			String fromOWNER = ((String[])fromDelegate.keySet().toArray( new String[]{}))[0];
			SybaseHQSQLTable fromSYBASE = HQSQLUtils.getSYBASETable( fromOWNER, fromTable );
			StringBuilder fromSQL = new StringBuilder( fromSYBASE.getSQL().getQUERY() );
			if( StringUtils.isBlank( fromCond ) == false ) fromSQL.append(" and ").append( fromCond );
			fromTABLE = retrieveByResultLevel(fromSYBASE, 
					fromSQL.toString(), 
					fromPARAM, 
					-1l);
			fromMBean.getSUBFLOW().setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
		}
		finally{
			if( fromDelegate != null ){ fromDelegate.clear(); fromDelegate = null; }
		}
		return fromTABLE;
	}
	
	/**
	 * 
	 * @param fromUpdbm
	 * @param fromMBean
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	private java.util.Map groupWithOwner( java.util.HashMap fromUpdbm[], NoSQLDelegate fromMBean) throws SFException,Exception{
		java.util.Map fromORACLE = new java.util.HashMap();
		try
		{
			for( int index = 0 ; fromUpdbm != null && index < fromUpdbm.length; index++ ){
				String fromOWNER = OracleUtils.getTransactionName( fromUpdbm[index] );
				if( fromORACLE.containsKey( fromOWNER ) == false ){
					fromORACLE.put( fromOWNER, new java.util.ArrayList() );
				}
				((java.util.List)fromORACLE.get( fromOWNER )).add( fromUpdbm[index] );
			}
		}
		finally{
			
		}
		return fromORACLE;
	}
	/**
	 * 
	 * @param fromGlobal
	 * @param fromMBean
	 * @param fromUpdbc
	 * @throws SFException
	 * @throws Exception
	 */
	private void createWithBatch( MBeanDelegate fromGlobal, NoSQLDelegate fromMBean, java.util.Map fromUpdbc) throws SFException,Exception{
		try
		{
			NoSQLDelegate.IUpdfmxOffer fromUpdfmx = fromMBean.getSUBFLOW();
			for( java.util.Iterator itera = fromUpdbc.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
                String fromOWNER[] = StringUtils.wildcardArray( (String)fromEntry.getKey() , "." );
                SybaseHQSQLTable fromSYBASE = HQSQLUtils.getSYBASETable( fromOWNER[0], fromOWNER[1] );
				java.util.ArrayList fromPARAM = (java.util.ArrayList)fromEntry.getValue();
				super._exec(fromSYBASE.getDataSource(), 
						fromSYBASE.getSQL().getCREATE(), 
						fromSYBASE, 
						fromPARAM);
				super.userdbsmlog(fromSYBASE.getMapingEnty(), fromPARAM);
				fromUpdfmx.setSUMING( fromUpdfmx.getSUMING() + fromPARAM.size() );
			}
		}
		finally{
			
		}
	}
	/**
	 * 
	 * @param fromGlobal
	 * @param fromMBean
	 * @param fromUpdbm
	 * @throws SFException
	 * @throws Exception
	 */
	private void deleteWithBatch( MBeanDelegate fromGlobal, NoSQLDelegate fromMBean, java.util.Map fromUpdbm) throws SFException,Exception{
		try
		{
			NoSQLDelegate.IUpdfmxOffer fromUpdfmx = fromMBean.getSUBFLOW();
			for( java.util.Iterator itera = fromUpdbm.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
                String fromOWNER[] = StringUtils.wildcardArray( (String)fromEntry.getKey() , "." );
                SybaseHQSQLTable fromSYBASE = HQSQLUtils.getSYBASETable( fromOWNER[0], fromOWNER[1] );
                java.util.ArrayList fromPARAM = (java.util.ArrayList)fromEntry.getValue();
				String fromDELETE = fromSYBASE.getSQL().getDELETE();
				if( StringUtils.isBlank( fromDELETE ) ){
					ExceptionFactory.throwOracle("IOS0014019", new String[]{fromSYBASE.getDataSource(), 
							fromSYBASE.getMapingEnty() });
				}
				super._exec(fromSYBASE.getDataSource(), 
						fromDELETE, 
						fromSYBASE, 
						fromPARAM);
				super.userdbsmlog(fromSYBASE.getMapingEnty(), fromPARAM);
				fromUpdfmx.setSUMING( fromUpdfmx.getSUMING() + fromPARAM.size() );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromSYBASE
	 * @param fromCond
	 * @param fromPARAM
	 * @param aMaxRow
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	private java.util.ArrayList retrieveByResultLevel(SybaseHQSQLTable fromSYBASE, String fromSQL, java.util.HashMap fromPARAM, long aMaxRow) throws SFException, Exception{
		java.util.ArrayList fromArray = new java.util.ArrayList();
		java.sql.Connection aTransaction = null;
    	java.sql.ResultSet aResultset = null;
	  	java.sql.PreparedStatement aStatement = null;
	  	try
		{
	  		long fromCount = aMaxRow;
	  		aTransaction = OracleUtils.getTransaction( fromSYBASE.getDataSource() );
	  		HQSQLSQLParser fromSQLParser = HQSQLSQLParser.getINSTANCE( fromSQL );
	  		fromSQL = SFSubTableFactory.createTableSQL( fromSQLParser.getSQL(), fromPARAM );
	  		aStatement = aTransaction.prepareStatement( fromSQL );
	  		wrapWithStat(aStatement, fromSQLParser, fromSYBASE, fromPARAM);
	  		aStatement.setFetchSize( 200 );
	  	    aResultset = aStatement.executeQuery();
	  	    while( aResultset.next() ){
	  	    	java.util.HashMap fromDelegate = new java.util.HashMap();
	  	    	for( java.util.Iterator itera = fromSYBASE.getProperties().values().iterator(); itera.hasNext(); ){
  	    			HQSQLTable.HQSQLColumn _column = (HQSQLTable.HQSQLColumn)itera.next();
  	    			if( _column.isASTVirtual() ){ continue; }
  	    			fromDelegate.put( _column.getName(), aResultset.getObject( _column.getName() ) );
  	    		}
	  	    	fromArray.add( fromDelegate );
	    	    if( aMaxRow > 0 ) fromCount--;
	    		if( aMaxRow > 0 && fromCount <= 0 ) break;
		    }
		}
		finally{
			if( aResultset != null ) {aResultset.close();aResultset=null;}
			if( aStatement != null ) {aStatement.close();aStatement=null;}
			if( aTransaction != null ) { aTransaction.close();}
		}
		return fromArray;
	}
}
