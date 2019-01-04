package com.ai.sacenter.jdbc.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-6-21</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ISystemDAOImpl extends UpdcEclipseImpl implements IUpdbmDAOLife {

	public ISystemDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#getSysdate()
	 */
	public java.sql.Timestamp getSysdate() throws RemoteException, Exception {
		return HQSQLFactory.getOracle().getSysdate();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#getSEQUENCE(java.lang.String)
	 */
	public java.math.BigDecimal getSEQUENCE(String _table_name) throws RemoteException, Exception {
		java.math.BigDecimal fromDecimal = null;
		String aTransactionName = null;
		try
		{
			SFCenterOffer _centeroffer = SFCenterFactory.getCenterInfo();
			aTransactionName = OracleUtils.getTransactionName( _centeroffer.getREGION_ID() );
			long fromSEQUENCE = ServiceManager.getIdGenerator().getNewId( aTransactionName, _table_name );
			fromDecimal = new java.math.BigDecimal( fromSEQUENCE );
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwOracleInside("IOS0014026", new String[]{aTransactionName != null?aTransactionName:"NULL",
					_table_name,
	  				exception.getMessage()},
					exception);
		}
		finally{
			
		}
		return fromDecimal;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#getSEQUENCE(java.lang.String, java.lang.String)
	 */
	public java.math.BigDecimal getSEQUENCE(String _table_name, String _region_id) throws RemoteException, Exception {
		java.math.BigDecimal fromDecimal = null;
		SFCenterFactory.pushCenterInfo( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, _region_id );
		String aTransactionName = null;
		try
		{
			aTransactionName = OracleUtils.getTransactionName( _region_id );
			long fromSEQUENCE = ServiceManager.getIdGenerator().getNewId( aTransactionName , _table_name );
			fromDecimal = new java.math.BigDecimal( fromSEQUENCE );
		}
		catch( java.lang.Exception aException ){
			ExceptionFactory.throwOracleInside("IOS0014026", new String[]{aTransactionName != null?aTransactionName:"NULL",
					_table_name,
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
		return getSEQUENCE("SA_DONE").longValue();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieveCount(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.HashMap)
	 */
	public int retrieveCount(ObjectType fromTYPE, String fromCond, java.util.HashMap fromPARAM) throws RemoteException, Exception {
		return HQSQLFactory.getOracle().retrieveCount(fromTYPE, fromCond, fromPARAM);
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieve(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.HashMap, java.lang.String[], int, int)
	 */
	public DataStructInterface[] retrieve(ObjectType fromTYPE, String fromCond, java.util.HashMap fromPARAM, String[] fromCol, int startRowIndex, int endRowIndex) throws RemoteException, Exception {
		return HQSQLFactory.getOracle().retrieve(fromTYPE, 
				fromCond, 
				fromPARAM, 
				fromCol, 
				startRowIndex, 
				endRowIndex);
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieve(java.lang.String, java.lang.String, java.util.Map)
	 */
	public java.util.ArrayList retrieve(String _table_name, String fromCond, java.util.Map fromPARAM) throws RemoteException, Exception {
		java.util.ArrayList fromUpdfmx = null;
		try
		{
			ISystemTemplate.IUpfgkmComposite _composite = HQSQLUtils.ISystem.getSFUpfgkmTable( _table_name );
			ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( _composite.getPERSISTENT() );
			fromUpdfmx = HQSQLFactory.getOracle().retrieve( fromTYPE, fromCond, fromPARAM );
		}
		finally{
			
		}
		return fromUpdfmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieve(com.ai.appframe2.common.ObjectType, java.lang.String, java.util.Map)
	 */
	public DataContainer[] retrieve(ObjectType fromTYPE, String fromCond, java.util.Map fromPARAM) throws SFException, Exception {
		DataContainer fromArray[] = null;
		java.util.ArrayList fromUpdfmx = null;
		try
		{
			Class fromCLASS = Class.forName( fromTYPE.getFullName() );
			fromUpdfmx = HQSQLFactory.getOracle().retrieve( fromTYPE, fromCond, fromPARAM );
			fromArray = (DataContainer[])ClassUtils.IClass.arrayCopy( fromUpdfmx, fromCLASS );
		}
		finally{
			if( fromUpdfmx != null ){ fromUpdfmx.clear(); fromUpdfmx = null; }
		}
		return fromArray;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#retrieve(java.lang.String, com.ai.appframe2.common.ObjectType, java.lang.String, java.util.Map)
	 */
	public java.util.ArrayList retrieve(String _table_name, ObjectType _objecttype, String _condition, java.util.Map fromPARAM) throws RemoteException, Exception{
		java.util.ArrayList fromUpdfmx = null;
		try
		{
			fromUpdfmx = HQSQLFactory.getOracle().retrieve(_table_name, _objecttype, _condition, fromPARAM);
		}
		finally{
		
		}
		return fromUpdfmx;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(com.ai.appframe2.common.DataStructInterface[])
	 */
	public void finish(DataStructInterface[] fromContain) throws RemoteException, Exception {
		java.util.List fromUpdbm = new java.util.ArrayList();
		try
		{
			String fromCLASS = getClass().getName();
			ClassUtils.IMerge.merge( fromContain , fromUpdbm );
			if( fromUpdbm != null && fromUpdbm.size() > 0 ){
				HQSQLFactory.getIDataStoreSV().finish(fromCLASS, fromUpdbm);
			}
		}
		finally{
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(com.ai.sacenter.valuebean.IOVUpdfmxOffer)
	 */
	public void finish(IOVUpdfmxOffer fromUpdfmx) throws SFException, Exception {
		try
		{
			String fromCLASS = getClass().getName();
			IOVUpdfmxOffer.IUpdfmxOfferHome fromOrderHome = fromUpdfmx.getORDER();
			if( fromOrderHome != null && fromOrderHome.getORDER() != null && 
					fromOrderHome.getORDER().size() > 0 ){
				HQSQLFactory.getIDataStoreSV().finish( fromCLASS, fromOrderHome.getORDER() );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(java.util.List)
	 */
	public void finish(java.util.List fromUpdbm) throws RemoteException, Exception {
		try
		{
			String fromDAO = getClass().getName();
			if( fromUpdbm != null && fromUpdbm.size() > 0 ){
				HQSQLFactory.getIDataStoreSV().finish(fromDAO, fromUpdbm);
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(java.util.HashMap)
	 */
	public void finish(java.util.HashMap fromUpdbm) throws RemoteException, Exception {
		java.util.ArrayList fromUpdbc = new java.util.ArrayList();
		try
		{
			String fromDAO = getClass().getName();
			fromUpdbc.add( fromUpdbm );
			HQSQLFactory.getIDataStoreSV().finish( fromDAO, fromUpdbc );
		}
		finally{
			if( fromUpdbc != null ){ fromUpdbc.clear(); fromUpdbc = null; }
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.IUpdbmDAOLife#finish(java.util.HashMap[])
	 */
	public void finish(java.util.HashMap[] fromUpdbm) throws RemoteException, Exception {
		ExceptionFactory.throwOracle("IOS0014011", new String[]{ ISystemDAOImpl.class.getName() });
	}
}
