package com.ai.sacenter.base.platform.dao.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.base.platform.bo.SAClient;
import com.ai.sacenter.base.platform.bo.SADebuging;
import com.ai.sacenter.base.platform.bo.SADirective;
import com.ai.sacenter.base.platform.bo.SADirectiveS;
import com.ai.sacenter.base.platform.bo.SAFeature;
import com.ai.sacenter.base.platform.bo.SAMapping;
import com.ai.sacenter.base.platform.bo.SAMappingRel;
import com.ai.sacenter.base.platform.bo.SAMisc;
import com.ai.sacenter.base.platform.bo.SAOffice;
import com.ai.sacenter.base.platform.bo.SAOperate;
import com.ai.sacenter.base.platform.bo.SAOperateX;
import com.ai.sacenter.base.platform.bo.SAPhone;
import com.ai.sacenter.base.platform.bo.SAPlatform;
import com.ai.sacenter.base.platform.bo.SAPlatformX;
import com.ai.sacenter.base.platform.bo.SAProtocol;
import com.ai.sacenter.base.platform.bo.SARespond;
import com.ai.sacenter.base.platform.bo.SARespondRel;
import com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;

/**
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê10ÔÂ6ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class CfgUpffmDAOImpl extends ISystemDAOImpl implements ICfgUpffmDAO{
	public CfgUpffmDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmOffer()
	 */
	public java.util.ArrayList getIUpffmOffer() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAPlatform.S_State ).append( " = :p_STATE")
			       .append(" order by ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAPlatform.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmNetWork()
	 */
	public java.util.ArrayList getIUpffmNetWork() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAPlatform.S_State ).append( " = :p_STATE")
			       .append(" order by ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAClient.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpfmxCatalog()
	 */
	public java.util.ArrayList getIUpfmxCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAPlatformX.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , SORT_BY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAPlatformX.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmOperate()
	 */
	public java.util.ArrayList getIUpffmOperate() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAOperate.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAOperate.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmOperateX()
	 */
	public java.util.ArrayList getIUpffmOperateX() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAOperateX.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , OPERATE , SORT_BY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAOperateX.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmLogical()
	 */
	public java.util.ArrayList getIUpffmLogical() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SADirective.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SADirective.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmSubFlow()
	 */
	public java.util.ArrayList getIUpffmSubFlow() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SADirectiveS.S_State ).append( " = :p_STATE")
			       .append(" order by SUBFLOW , SORT_BY , NAME ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SADirectiveS.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmProtocol()
	 */
	public java.util.ArrayList getIUpffmProtocol() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAProtocol.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAProtocol.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmOffice()
	 */
	public java.util.ArrayList getIUpffmOffice() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = new java.util.ArrayList();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromCond = new StringBuilder();
			fromCond.append(" STATE = :p_STATE order by CATEGORY , HEADNUM , START_NUM , END_NUM " );
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAOffice.S_TYPE, 
					fromCond.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmPhone()
	 */
	public java.util.ArrayList getIUpffmPhone() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAPhone.S_State ).append( " = :p_STATE")
			       .append(" order by ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAPhone.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmDebug()
	 */
	public java.util.ArrayList getIUpffmDebug() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SADebuging.S_State ).append( " = :p_STATE")
			       .append(" order by NAME ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SADebuging.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffsmModule()
	 */
	public java.util.ArrayList getIUpffsmModule() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAMapping.S_State ).append( " = :p_STATE")
			       .append(" order by CODE ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAMapping.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffsmCatalog()
	 */
	public java.util.ArrayList getIUpffsmCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAMappingRel.S_State ).append( " = :p_STATE")
			       .append(" order by TEMPLATE , PARENT_ID , SORT_BY ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAMappingRel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffsmOffer()
	 */
	public java.util.HashMap getIUpffsmOffer() throws RemoteException, Exception {
		java.util.HashMap fromUpffsm = new java.util.HashMap();
		java.util.Map fromModule = null;
		try
		{
			class IUpffsmOfferImpl{
				public IUpffsmOfferImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMODULE
				 * @return
				 * @throws RemoteException
				 * @throws Exception
				 */
				public java.util.HashMap finishSFUpffsmModule( java.util.HashMap fromMODULE ) throws RemoteException,Exception{
					java.util.HashMap fromModel = new java.util.HashMap();
					java.util.List fromArray = null;
					try
					{
						fromArray = getIUpffsmModule();
						for( java.util.Iterator itera = fromArray.iterator(); itera.hasNext(); ){
							SAMapping aMODULE = (SAMapping)itera.next();
							fromModel.put( aMODULE.getCode() , aMODULE );
							fromMODULE.put( aMODULE , new java.util.ArrayList() );
						}
					}
					finally{
						if( fromArray != null ){ fromArray.clear(); fromArray = null; }
					}
					return fromModel;
				}
				/**
				 * 
				 * @param aIUcm2JWfvmL
				 * @param aIUcm2JWfmsL
				 * @param aIUcm2UWfmxL
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpffsmCatalog(java.util.HashMap fromMODEL,
						java.util.HashMap fromMODULE, 
				        java.util.HashMap fromCATALOG ) throws RemoteException,Exception{
					java.util.List fromArray = null;
					try
					{
						fromArray = getIUpffsmCatalog();
						for( java.util.Iterator itera = fromArray.iterator(); itera.hasNext(); ){
							SAMappingRel aCatalog = (SAMappingRel)itera.next();
							if( aCatalog.getParentId() <= 0 && fromMODEL.containsKey( aCatalog.getTemplate() ) ){
					    		SAMapping aMODULE = (SAMapping)fromMODEL.get( aCatalog.getTemplate() );
					    		((java.util.List)fromMODULE.get( aMODULE ) ).add( aCatalog );
					    	}
					    	else if( aCatalog.getParentId() > 0 ){
					    		String aINDEX = String.valueOf( aCatalog.getParentId() );
					    		if( fromCATALOG.containsKey( aINDEX ) == false ) fromCATALOG.put( aINDEX , new java.util.ArrayList() );
					    		((java.util.List)fromCATALOG.get( aINDEX ) ).add( aCatalog );
					    	}
						}
					}
					finally{
						if( fromArray != null ){ fromArray.clear(); fromArray = null; }
					}
				}
			}
			IUpffsmOfferImpl fromUpffsmImpl = new IUpffsmOfferImpl();
			java.util.HashMap fromMODEL = null;
			try
			{
				java.util.HashMap fromMODULE = new java.util.HashMap();
				java.util.HashMap fromCATALOG = new java.util.HashMap();
				fromUpffsm.put("MODULE", fromMODULE );
				fromUpffsm.put("MAPPING", fromCATALOG );
				fromMODEL = fromUpffsmImpl.finishSFUpffsmModule( fromMODULE );
				fromUpffsmImpl.finishSFUpffsmCatalog(fromMODEL, 
						fromMODULE, 
						fromCATALOG);
			}
			finally{
				if( fromMODEL != null ){ fromMODEL.clear(); fromMODEL = null; }
				if( fromUpffsmImpl != null ){ fromUpffsmImpl = null; }
			}
		}
		finally{
			if( fromModule != null ){ fromModule.clear(); fromModule = null; }
		}
		return fromUpffsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#deployUpffsmOffer(java.lang.String, java.util.ArrayList, java.util.ArrayList)
	 */
	public void deployUpffsmOffer(String fromModule, 
			java.util.ArrayList fromMODULE,
			java.util.ArrayList fromCATALOG) throws RemoteException, Exception {
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append(" delete from ")
			       .append(SAMapping.S_TYPE.getMapingEnty())
			       .append(" where  ")
			       .append(SAMapping.S_Module).append(" = :p_MODULE  ");	
			fromPARAM.put( "p_MODULE", fromModule );
			HQSQLFactory.getOracle().exec(SAMapping.S_TYPE ,
					fromSQL.toString(),
					new java.util.HashMap[]{ fromPARAM } );
			
			fromSQL = new StringBuilder();
			fromSQL.append(" delete from ")
			       .append(SAMappingRel.S_TYPE.getMapingEnty())
			       .append(" where  ")
			       .append(SAMapping.S_Module).append(" = :p_MODULE  ");	 
			fromPARAM.put( "p_MODULE", fromModule );
			HQSQLFactory.getOracle().exec( SAMappingRel.S_TYPE , 
					fromSQL.toString(),
					new java.util.HashMap[]{ fromPARAM } );
			
			HQSQLFactory.getOracle().create( SAMapping.S_TYPE, 
					(java.util.HashMap[])fromMODULE.toArray( new java.util.HashMap[]{} ) );

			HQSQLFactory.getOracle().create( SAMappingRel.S_TYPE, 
					(java.util.HashMap[])fromCATALOG.toArray( new java.util.HashMap[]{} ) );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmMisc()
	 */
	public java.util.ArrayList getIUpffmMisc() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAMisc.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAMisc.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffxmOffer()
	 */
	public java.util.ArrayList getIUpffxmOffer() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAFeature.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , CODE ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAFeature.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmsOffer()
	 */
	public java.util.ArrayList getIUpffmsOffer() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SARespond.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , CATEGORY , CODE ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SARespond.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO#getIUpffmsCatalog()
	 */
	public java.util.ArrayList getIUpffmsCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SARespondRel.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , CATEGORY , CODE ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SARespondRel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

}
