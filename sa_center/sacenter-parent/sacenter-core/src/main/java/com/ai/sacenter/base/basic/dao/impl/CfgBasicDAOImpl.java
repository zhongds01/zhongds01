package com.ai.sacenter.base.basic.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.ai.sacenter.base.basic.bo.ISAIdGenerator;
import com.ai.sacenter.base.basic.bo.ISALibrary;
import com.ai.sacenter.base.basic.bo.ISASubTable;
import com.ai.sacenter.base.basic.bo.ISASubTableRel;
import com.ai.sacenter.base.basic.bo.SACenterCatalog;
import com.ai.sacenter.base.basic.bo.SACenterMapping;
import com.ai.sacenter.base.basic.bo.SACenterWrapper;
import com.ai.sacenter.base.basic.bo.SADistrict;
import com.ai.sacenter.base.basic.bo.SAI18nResource;
import com.ai.sacenter.base.basic.bo.SAIdGenerator;
import com.ai.sacenter.base.basic.bo.SALibrary;
import com.ai.sacenter.base.basic.bo.SAParallel;
import com.ai.sacenter.base.basic.bo.SAPersistent;
import com.ai.sacenter.base.basic.bo.SAPriorityBusines;
import com.ai.sacenter.base.basic.bo.SAPriorityLimite;
import com.ai.sacenter.base.basic.bo.SAPriorityCompete;
import com.ai.sacenter.base.basic.bo.SAStatic;
import com.ai.sacenter.base.basic.bo.SASubTable;
import com.ai.sacenter.base.basic.bo.SASubTableCau;
import com.ai.sacenter.base.basic.bo.SASubTableCol;
import com.ai.sacenter.base.basic.bo.SASubTableRel;
import com.ai.sacenter.base.basic.bo.SACenter;
import com.ai.sacenter.base.basic.bo.SADiction;
import com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;

/**
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê9ÔÂ30ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class CfgBasicDAOImpl extends ISystemDAOImpl implements ICfgBasicDAO {
	public CfgBasicDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getIAllStatic()
	 */
	public java.util.ArrayList getIAllStatic() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAStatic.S_State ).append( " = :p_STATE")
			       .append(" order by KIND , CODE ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAStatic.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getAllDiction()
	 */
	public java.util.ArrayList getAllDiction() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SADiction.S_State ).append( " = :p_STATE")
			       .append(" order by CATEGORY , CODE , ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SADiction.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getAllDistrict()
	 */
	public java.util.ArrayList getAllDistrict() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SADistrict.S_State ).append( " = :p_STATE")
			       .append(" order by DISTRICT_TYPE_ID , DISTRICT_ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SADistrict.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.IBaseDAO#getICenterRoute()
	 */
	public java.util.ArrayList getICenterRoute() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SACenter.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , ROUTE ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SACenter.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.IBaseDAO#getICenterCatalog()
	 */
	public java.util.ArrayList getICenterCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SACenterCatalog.S_State ).append( " = :p_STATE")
			       .append(" order by CATEGORY , IMPLCLASS ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SACenterCatalog.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.IBaseDAO#getICenterMapping()
	 */
	public java.util.ArrayList getICenterMapping() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SACenterMapping.S_State ).append( " = :p_STATE")
			       .append(" order by CATEGORY , CODE ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SACenterMapping.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.IBaseDAO#getICenterWrapper()
	 */
	public java.util.ArrayList getICenterWrapper() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SACenterWrapper.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , IMPLCLASS ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SACenterWrapper.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getILibraryOffer()
	 */
	public ISALibrary[] getILibraryOffer() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SALibrary.S_State ).append( " = :p_STATE")
			       .append(" order by ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SALibrary.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return (SALibrary[])fromDelegate.toArray( new SALibrary[]{});
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getIIdGenerator()
	 */
	public ISAIdGenerator[] getIIdGenerator() throws RemoteException,
			Exception {
		java.util.List fromDelegate = new java.util.ArrayList();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromCond = new StringBuilder();
			fromCond.append(" STATE = :p_STATE order by TABLE_NAME , CHANNEL_ID  , REGION_ID " );
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAIdGenerator.S_TYPE, 
					fromCond.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return (ISAIdGenerator[])fromDelegate.toArray( new ISAIdGenerator[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getISubTableOffer()
	 */
	public java.util.ArrayList getISubTableOffer() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = new java.util.ArrayList();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromCond = new StringBuilder();
			fromCond.append(" STATE = :p_STATE order by CODE , ID " );
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAPersistent.S_TYPE, 
					fromCond.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromDelegate;
	}


	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.IBaseDAO#getISubSQLTable()
	 */
	public ISASubTable[] getISubSQLTable() throws RemoteException, Exception {
		java.util.List fromDelegate = new java.util.ArrayList();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromCond = new StringBuilder();
			fromCond.append(" STATE = :p_STATE order by PLATFORM , TABLE_NAME " );
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SASubTable.S_TYPE, 
					fromCond.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return (ISASubTable[])fromDelegate.toArray( new ISASubTable[]{} );
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.IBaseDAO#getISubSQLTableRel()
	 */
	public ISASubTableRel[] getISubSQLTableRel() throws RemoteException, Exception {
		java.util.List fromDelegate = new java.util.ArrayList();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromCond = new StringBuilder();
			fromCond.append(" STATE = :p_STATE order by PLATFORM , TABLE_NAME " );
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SASubTableRel.S_TYPE, 
					fromCond.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return (ISASubTableRel[])fromDelegate.toArray( new ISASubTableRel[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.IBaseDAO#getISubSQLTableCol()
	 */
	public java.util.ArrayList getISubSQLTableCol() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = new java.util.ArrayList();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromCond = new StringBuilder();
			fromCond.append(" STATE = :p_STATE order by PLATFORM , TABLE_NAME , CATEGORY , SORT_BY " );
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SASubTableCol.S_TYPE, 
					fromCond.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromDelegate;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.IBaseDAO#getISubSQLTableCau()
	 */
	public java.util.ArrayList getISubSQLTableCau() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = new java.util.ArrayList();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromCond = new StringBuilder();
			fromCond.append(" STATE = :p_STATE order by PLATFORM , TABLE_NAME , COLUMN_NAME , COLUMN_VALUE " );
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SASubTableCau.S_TYPE, 
					fromCond.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromDelegate;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getIUpfgkmParallel()
	 */
	public ArrayList getIUpfgkmParallel() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = new java.util.ArrayList();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append(" STATE = :p_STATE order by ID " );
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAParallel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromDelegate;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getIUpfgkmResource()
	 */
	public ArrayList getIUpfgkmResource() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = new java.util.ArrayList();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append(" STATE = :p_STATE order by CATEGORY , CODE , ID " );
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAI18nResource.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromDelegate;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getIUpdbfsBusines()
	 */
	public java.util.ArrayList getIUpdbfsBusines() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAPriorityBusines.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , CATALOG , BUSINESS , CHANNEL , SORT_BY ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAPriorityBusines.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getIUpdbfsCatalog()
	 */
	public java.util.ArrayList getIUpdbfsCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAPriorityCompete.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , PROGRAM , COMPETE , SORT_BY ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAPriorityCompete.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO#getIUpdbfsLimite()
	 */
	public java.util.ArrayList getIUpdbfsLimite() throws RemoteException, Exception {
		java.util.ArrayList fromDelegate = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAPriorityCompete.S_State ).append( " = :p_STATE")
			       .append(" order by PLATFORM , CATEGORY , CODE , SORT_BY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromDelegate = SFCacheFactory.getCache().hgetAll(SAPriorityLimite.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromDelegate;
	}
}
