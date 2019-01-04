package com.ai.sacenter.receive.custom.dbcp;

import java.rmi.RemoteException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.jdbc.NoSQLDelegate;
import com.ai.sacenter.jdbc.dialect.AbstractDialectImpl;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLTable;
import com.ai.sacenter.jdbc.dialect.OraclePtmtDelegate;
import com.ai.sacenter.jdbc.dialect.OraclePtmtDelegation;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于客户中心DAO</p>
 * <p>Copyright: Copyright (c) 2016年11月3日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ICustomDAOImpl extends AbstractDialectImpl implements IUpdbmDAOLife {
	private final static Log log = LogFactory.getLog( ICustomDAOImpl.class );
	public ICustomDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#getSEQUENCE(java.lang.String)
	 */
	public java.math.BigDecimal getSEQUENCE(String _table_name) throws RemoteException, Exception {
		java.math.BigDecimal fromDecimal = null;
		String aTransactionName = null;
		try
		{
			String _region_id = CenterUtils.ICustom.getRegionId();
			aTransactionName = CustomUtils.ISystem.getTransactionName( _region_id );
			long fromSEQUENCE = ServiceManager.getIdGenerator().getNewId( aTransactionName, _table_name );
			fromDecimal = new java.math.BigDecimal( fromSEQUENCE );
		}
		catch( java.lang.Exception aException ){
			ExceptionFactory.throwOracleInside("IOS0014016", new String[]{aTransactionName != null?aTransactionName:"NULL",
					_table_name,
	  				aException.getMessage()},
					aException);
		}
		finally{
			
		}
		return fromDecimal;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#getSEQUENCE(java.lang.String, java.lang.String)
	 */
	public java.math.BigDecimal getSEQUENCE(String fromTABLE, String aREGION_ID) throws RemoteException, Exception {
		java.math.BigDecimal fromDecimal = null;
		SFCenterFactory.pushCenterInfo( IUpdcConst.IUpdbm.IUpdmc.DISTRICT_ID, aREGION_ID );
		String aTransactionName = null;
		try
		{
			aTransactionName = CustomUtils.ISystem.getTransactionName( aREGION_ID );
			long fromSEQUENCE = ServiceManager.getIdGenerator().getNewId( aTransactionName , fromTABLE );
			fromDecimal = new java.math.BigDecimal( fromSEQUENCE );
		}
		catch( java.lang.Exception aException ){
			ExceptionFactory.throwOracleInside("IOS0014016", new String[]{aTransactionName != null?aTransactionName:"NULL",
	  				fromTABLE,
	  				aException.getMessage()},
					aException);
		}
		finally{
			SFCenterFactory.popCenterInfo();
		}
		return fromDecimal;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#getDONE_CODE()
	 */
	public long getDONE_CODE() throws RemoteException, Exception {
		throw new java.lang.UnsupportedOperationException( ICustomDAOImpl.class.getName() );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#getSysdate()
	 */
	public java.sql.Timestamp getSysdate() throws RemoteException, Exception {
		return TimeUtils.getSysdate();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieveCount(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.HashMap)
	 */
	public int retrieveCount(ObjectType fromTYPE, 
			String fromCond,
			java.util.HashMap fromPARAM) throws RemoteException, Exception {
		throw new java.lang.UnsupportedOperationException( ICustomDAOImpl.class.getName() );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieve(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.HashMap, java.lang.String[], int, int)
	 */
	public DataStructInterface[] retrieve(ObjectType fromTYPE, 
			String fromCond,
			java.util.HashMap fromPARAM,
			String[] fromCol, 
			int startRowIndex,
			int endRowIndex) throws RemoteException, Exception {
		throw new java.lang.UnsupportedOperationException( ICustomDAOImpl.class.getName() );
	}
    
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieve(java.lang.String, java.lang.String, java.util.Map)
	 */
	public java.util.ArrayList retrieve(String _table_name, String fromCond, java.util.Map fromPARAM) throws RemoteException, Exception {
		java.util.ArrayList fromUpdfmx = null;
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			ISystemTemplate.IUpfgkmComposite _composite = HQSQLUtils.ISystem.getSFUpfgkmTable( _table_name );
			ObjectType _objecttype = ClassUtils.IClass.getASTBOType( _composite.getPERSISTENT() );
			String _datasource = CustomUtils.ISystem.getTransactionName( _objecttype, fromPARAM );
			OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( _datasource, _objecttype );
			fromSQL.append( fromORACLE.getSQL().getQUERY() );
			if( StringUtils.isBlank( fromCond ) == false ) fromSQL.append( " and " ).append( fromCond );
			fromUpdfmx = HQSQLFactory.getOracle().retrieve( _datasource, fromSQL.toString(), fromPARAM, fromORACLE );
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromUpdfmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieve(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.Map)
	 */
	public DataContainer[] retrieve(ObjectType fromTYPE, String fromCond, java.util.Map fromPARAM) throws SFException, Exception {
		DataContainer fromEntity[] = null;
		java.sql.Connection aTransaction = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.List fromPtmtHome = null;
		try
		{
			Class fromCLASS = Class.forName( fromTYPE.getFullName() );
			String fromOWNER = CustomUtils.ISystem.getTransactionName( fromTYPE, fromPARAM );
			OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable(fromOWNER, fromTYPE);
			fromSQL.append( fromORACLE.getSQL().getQUERY() );
			if( StringUtils.isBlank( fromCond ) == false ) fromSQL.append( " and " ).append( fromCond );
			fromPtmtHome = HQSQLFactory.getOracle().retrieve( fromOWNER, fromSQL.toString(), fromPARAM, fromORACLE );
			fromEntity = (DataContainer[])ClassUtils.IClass.arrayCopy( fromPtmtHome, fromCLASS );
		}
		finally{
			if( fromPtmtHome != null ){ fromPtmtHome.clear(); fromPtmtHome = null;}
			if( fromSQL != null ){ fromSQL = null; }
			if( aTransaction != null ){ aTransaction.close() ; }
		}
		return fromEntity;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieve(java.lang.String, com.ai.appframe2.common.ObjectType, java.lang.String, java.util.Map)
	 */
	public java.util.ArrayList retrieve(String _table_name, ObjectType _objecttype, String _condition, java.util.Map fromPARAM) throws RemoteException, Exception {
		java.util.ArrayList fromUpdfmx = null;
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			String _datasource = CustomUtils.ISystem.getTransactionName( _objecttype, fromPARAM );
			OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( _datasource, _objecttype );
			fromSQL.append( fromORACLE.getSQL().getQUERY() );
			if( StringUtils.isBlank( _condition ) == false ){ fromSQL.append( " and " ).append( _condition ); }
			if( StringUtils.isBlank( _table_name ) ){
				fromUpdfmx = HQSQLFactory.getOracle().retrieve( _datasource, fromSQL.toString(), fromPARAM, fromORACLE );
			}
			else{
				String _table_sql_ = StringUtils.replace( fromSQL.toString(), _objecttype.getMapingEnty(), _table_name );
				fromUpdfmx = HQSQLFactory.getOracle().retrieve( _datasource, _table_sql_, fromPARAM, fromORACLE );
			}
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromUpdfmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(com.ai.appframe2.common.DataStructInterface[])
	 */
	public void finish(DataStructInterface[] fromEntity) throws RemoteException, Exception {
		java.util.ArrayList fromPtmtHome = new java.util.ArrayList();
		try
		{
			for( int index = 0; fromEntity != null && index < fromEntity.length; index++ ){
				if( OracleUtils.ICustom.isCommit( fromEntity[index] ) == false ) continue;
				fromPtmtHome.add( fromEntity[index] );
			}
			if( fromPtmtHome != null && fromPtmtHome.size() > 0 ){ finish( fromPtmtHome ); }
		}
		finally{
			if( fromPtmtHome != null ){ fromPtmtHome.clear(); fromPtmtHome = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(com.ai.sacenter.valuebean.IOVUpdfmxOffer)
	 */
	public void finish(IOVUpdfmxOffer fromUpdfmx) throws SFException, Exception {
		java.util.ArrayList fromPtmtHome = null;
		try
		{
			IOVUpdfmxOffer.IUpdfmxOfferHome fromOrderHome = fromUpdfmx.getORDER();
			if( fromOrderHome != null && fromOrderHome.getORDER().size() > 0 ){
				for( java.util.Iterator itera = fromOrderHome.getORDER().iterator(); itera.hasNext(); ){
					DataStructInterface fromEntity = (DataStructInterface)itera.next();
					if( OracleUtils.ICustom.isCommit( fromEntity ) == false ) continue;
					if( fromPtmtHome == null ){ fromPtmtHome = new java.util.ArrayList(); }
					fromPtmtHome.add( fromEntity );
				}
				if( fromPtmtHome != null && fromPtmtHome.size() > 0 ){ finish( fromPtmtHome ); }
			}
		}
		finally{
			if( fromPtmtHome != null ){ fromPtmtHome.clear(); fromPtmtHome = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(java.util.List)
	 */
	public void finish(java.util.List fromUpdbm) throws RemoteException, Exception {
		NoSQLDelegate fromMBean = new NoSQLDelegate( fromUpdbm, getClass().getName() );
		try
		{
			SFCustomPtmtImpl fromPtmtImpl = new SFCustomPtmtImpl();
			CustomPtmtHome fromPtmtHome = new CustomPtmtHome();
			try
			{
				for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
					DataContainer fromEntity = (DataContainer)itera.next();
					if( OracleUtils.ICustom.isCommit( fromEntity ) == false ) continue;
					if( fromEntity.isNew() ){
						fromPtmtImpl.transferWithCreate( fromMBean, 
								fromEntity, 
								fromPtmtHome.getCREATE() );
					}
					else if( fromEntity.isModified() ){
						fromPtmtImpl.transferWithModify( fromMBean, 
								fromEntity, 
								fromPtmtHome.getUPDATE());
					}
					else if( fromEntity.isDeleted() ){
						fromPtmtImpl.transferWithDelete( fromMBean, 
								fromEntity, 
								fromPtmtHome.getDELETE() );
					}
				}
				if( fromPtmtHome != null && fromPtmtHome.getDELETE().size() > 0 ){
					commitWithResultLevel(fromMBean, fromPtmtHome.getDELETE() );
				}
				if( fromPtmtHome != null && fromPtmtHome.getUPDATE().size() > 0 ){
					commitWithResultLevel(fromMBean, fromPtmtHome.getUPDATE() );
				}
				if( fromPtmtHome != null && fromPtmtHome.getCREATE().size() > 0 ){
					commitWithResultLevel(fromMBean, fromPtmtHome.getCREATE() );
				}
				fromMBean.getSUBFLOW().setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				if( fromMBean.getSUBFLOW().getSUMING() > 0 && log.isDebugEnabled() ) log.debug("batch Execute finish[REGION_ID:" + "NULL" + ",REGION:NULL" + 
						"[Routing Information by the itself JVM settings]], Data Table [" + fromMBean.getSUBFLOW().getSUMING() 
						+"] ,Time-consuming ["+(fromMBean.getSUBFLOW().getCOMPLETE().getTime() - 
								fromMBean.getSUBFLOW().getCREATE().getTime() )+"]ms");
			}
			finally{
				if( fromPtmtHome != null ){ fromPtmtHome = null; }
				if( fromPtmtImpl != null ){ fromPtmtImpl = null; }
			}
		}
		finally{
			if( fromMBean != null ){ fromMBean = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(java.util.HashMap[])
	 */
	public void finish(java.util.HashMap[] fromUpdbm) throws RemoteException, Exception {
		throw new java.lang.UnsupportedOperationException( ICustomDAOImpl.class.getName() );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(java.util.HashMap)
	 */
	public void finish(java.util.HashMap fromUpdbm) throws RemoteException, Exception {
		throw new java.lang.UnsupportedOperationException( ICustomDAOImpl.class.getName() );
	}
}
/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月10日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
class SFCustomPtmtImpl{
	public SFCustomPtmtImpl(){
		super();
	}
	
	/**
	 * 
	 * @param fromMBean
	 * @param fromEntity
	 * @param fromCustmPtmtHome
	 * @throws SFException
	 * @throws Exception
	 */
	public void transferWithCreate( NoSQLDelegate fromMBean, 
			DataContainer fromEntity , 
			java.util.HashMap fromCustmPtmtHome ) throws SFException,Exception{
		try
		{
			String fromOWNER = CustomUtils.ISystem.getTransactionName( fromEntity );
			OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleSubTable( fromOWNER, fromEntity );
			String fromCREATE = fromORACLE.getSQL().getCREATE();
			OraclePtmtDelegate fromPtmtHome = (OraclePtmtDelegate)fromCustmPtmtHome.get( fromCREATE );
			if( fromPtmtHome == null ){
				fromPtmtHome = new OraclePtmtDelegate( fromORACLE );
				fromCustmPtmtHome.put( fromCREATE, fromPtmtHome );
			}
			fromPtmtHome.getDelegation().add( fromEntity );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromMBean
	 * @param fromEntity
	 * @param fromCustmPtmtHome
	 * @throws SFException
	 * @throws Exception
	 */
	public void transferWithModify( NoSQLDelegate fromMBean , 
			DataContainer fromEntity , 
			java.util.HashMap fromCustmPtmtHome ) throws SFException,Exception{
		java.util.List fromModify = new java.util.ArrayList();
		try
		{
			String fromOWNER = CustomUtils.ISystem.getTransactionName( fromEntity );
			OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleSubTable( fromOWNER, fromEntity );
			for( java.util.Iterator itera = fromEntity.getNewProperties().entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				HQSQLTable.HQSQLColumn fromCol = fromORACLE.getProperty( fromEntry.getKey().toString() );
				if( fromCol == null ) continue;
				String aINDEX = ClassUtils.getINDEX( new String[]{fromCol.getName() ,
						" = :",
						fromCol.getName() } );
				fromModify.add( aINDEX );
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
				OraclePtmtDelegate fromPtmtHome = (OraclePtmtDelegate)fromCustmPtmtHome.get( fromUPDATE );
				if( fromPtmtHome == null ){
					fromPtmtHome = new OraclePtmtDelegate( fromORACLE );
					fromCustmPtmtHome.put( fromUPDATE, fromPtmtHome );
				}
				fromPtmtHome.getDelegation().add( fromEntity );
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
	 * @param fromCustmPtmtHome
	 * @throws SFException
	 * @throws Exception
	 */
	public void transferWithDelete( NoSQLDelegate fromMBean , 
			DataContainer fromEntity , 
			java.util.HashMap fromCustmPtmtHome ) throws SFException,Exception{
		try
		{
			String fromOWNER = CustomUtils.ISystem.getTransactionName( fromEntity );
			OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleSubTable( fromOWNER, fromEntity );
			String fromDELETE = fromORACLE.getSQL().getDELETE();
			if( StringUtils.isBlank( fromDELETE ) ){
				ExceptionFactory.throwOracle("IOS0014019", new String[]{fromORACLE.getDataSource(), 
						fromORACLE.getMapingEnty() });
			}
			OraclePtmtDelegate fromPtmtHome = (OraclePtmtDelegate)fromCustmPtmtHome.get( fromDELETE );
			if( fromPtmtHome == null ){
				fromPtmtHome = new OraclePtmtDelegate( fromORACLE );
				fromCustmPtmtHome.put( fromDELETE, fromPtmtHome );
			}
			fromPtmtHome.getDelegation().add( fromEntity );
		}
		finally{
			
		}
	}
}

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月10日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
class CustomPtmtHome extends OraclePtmtDelegation{
	private static final long serialVersionUID = 8094648231464356453L;
	public CustomPtmtHome(){
		super();
	}
}