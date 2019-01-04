package com.ai.sacenter.base.competence.dao.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.base.competence.bo.SABusines;
import com.ai.sacenter.base.competence.bo.SABusinesRel;
import com.ai.sacenter.base.competence.bo.SABusinesX;
import com.ai.sacenter.base.competence.bo.SACompensation;
import com.ai.sacenter.base.competence.bo.SACompetence;
import com.ai.sacenter.base.competence.bo.SACompetenceRel;
import com.ai.sacenter.base.competence.bo.SAComponent;
import com.ai.sacenter.base.competence.bo.SAComponentRel;
import com.ai.sacenter.base.competence.bo.SAComptel;
import com.ai.sacenter.base.competence.bo.SAComptelRel;
import com.ai.sacenter.base.competence.bo.SAComptelX;
import com.ai.sacenter.base.competence.bo.SADistribute;
import com.ai.sacenter.base.competence.bo.SAException;
import com.ai.sacenter.base.competence.bo.SAMappingX;
import com.ai.sacenter.base.competence.bo.SAProduct;
import com.ai.sacenter.base.competence.bo.SAProductRel;
import com.ai.sacenter.base.competence.bo.SAProductX;
import com.ai.sacenter.base.competence.bo.SAProgram;
import com.ai.sacenter.base.competence.bo.SAProgramRel;
import com.ai.sacenter.base.competence.bo.SARollBack;
import com.ai.sacenter.base.competence.bo.SASubFlow;
import com.ai.sacenter.base.competence.bo.SAWorkFlow;
import com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;

/**
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015��9��30��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class CfgUpdcpmDAOImpl extends ISystemDAOImpl implements ICfgUpdcpmDAO {
	public CfgUpdcpmDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdbfxBusines()
	 */
	public java.util.ArrayList getIUpdbfxBusines() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SABusines.S_State ).append( " = :p_STATE")
			       .append(" order by CATALOG , BUSINESS , ORIGINATE , CATEGORY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SABusines.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdbfxKernel()
	 */
	public java.util.ArrayList getIUpdbfxKernel() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SABusinesX.S_State ).append( " = :p_STATE")
			       .append(" order by PROGRAM , CODE , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SABusinesX.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdbfxCatalog()
	 */
	public java.util.ArrayList getIUpdbfxCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SABusinesRel.S_State ).append( " = :p_STATE")
			       .append(" order by CATEGORY , CATALOG , BUSINESS , PRODUCT ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SABusinesRel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdcpmOffer()
	 */
	public java.util.ArrayList getIUpdcpmOffer() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SACompetence.S_State ).append( " = :p_STATE")
			       .append(" order by CATALOG , BUSINESS , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SACompetence.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdcpmCatalog()
	 */
	public java.util.ArrayList getIUpdcpmCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SACompetenceRel.S_State ).append( " = :p_STATE")
			       .append(" order by COMPETENCE , CATALOG_ID , CATEGORY ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SACompetenceRel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIProductOffer()
	 */
	public java.util.ArrayList getIProductOffer() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAProduct.S_State ).append( " = :p_STATE")
			       .append(" order by CATEGORY , PRODUCT_ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAProduct.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIProductComptel()
	 */
	public java.util.ArrayList getIProductComptel() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAProductX.S_State ).append( " = :p_STATE")
			       .append(" order by PRODUCT_ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAProductX.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIProductCatalog()
	 */
	public java.util.ArrayList getIProductCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAProductRel.S_State ).append( " = :p_STATE")
			       .append(" order by PRODUCT_ID , PROD_RELAT_KIND_ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAProductRel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIComptelOffer()
	 */
	public java.util.ArrayList getIComptelOffer() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAComptel.S_State ).append( " = :p_STATE")
			       .append(" order by BUSINESS , SORT_BY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAComptel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIComptelCatalog()
	 */
	public java.util.ArrayList getIComptelCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAComptelRel.S_State ).append( " = :p_STATE")
			       .append(" order by COMPETE_ID , SORT_BY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAComptelRel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIComptelKernel()
	 */
	public java.util.ArrayList getIComptelKernel() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAComptelX.S_State ).append( " = :p_STATE")
			       .append(" order by CATEGORY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAComptelX.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdbpmOffer()
	 */
	public java.util.ArrayList getIUpdbpmOffer() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAWorkFlow.S_State ).append( " = :p_STATE")
			       .append(" order by ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAWorkFlow.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdbpmCatalog()
	 */
	public java.util.ArrayList getIUpdbpmCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SASubFlow.S_State ).append( " = :p_STATE")
			       .append(" order by SUBFLOW , SORT_BY , NAME ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SASubFlow.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdpgmOffer()
	 */
	public java.util.ArrayList getIUpdpgmOffer() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAProgram.S_State ).append( " = :p_STATE")
			       .append(" order by CATEGORY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAProgram.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdpgmCatalog()
	 */
	public java.util.ArrayList getIUpdpgmCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAProgramRel.S_State ).append( " = :p_STATE")
			       .append(" order by PROGRAM , CATEGORY , COMPONENT , SORT_BY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAProgramRel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdcmptOffer()
	 */
	public java.util.ArrayList getIUpdcmptOffer() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAComponent.S_State ).append( " = :p_STATE")
			       .append(" order by CATEGORY, ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAComponent.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdcmptCatalog()
	 */
	public java.util.ArrayList getIUpdcmptCatalog() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAComponentRel.S_State ).append( " = :p_STATE")
			       .append(" order by COMPONENT, CATEGORY, SORT_BY, ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAComponentRel.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdcmptMapping()
	 */
	public java.util.ArrayList getIUpdcmptMapping() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAMappingX.S_State ).append( " = :p_STATE")
			       .append(" order by COMPONENT , PLATFORM , SORT_BY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAMappingX.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdcmptRollBack()
	 */
	public java.util.ArrayList getIUpdcmptRollBack() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SARollBack.S_State ).append( " = :p_STATE")
			       .append(" order by COMPONENT , SORT_BY , NAME ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SARollBack.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdcmptCompensation()
	 */
	public java.util.ArrayList getIUpdcmptCompensation() throws RemoteException,
			Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SACompensation.S_State ).append( " = :p_STATE")
			       .append(" order by COMPONENT, CATEGORY , SORT_BY , ID ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SACompensation.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdcmptDistribute()
	 */
	public java.util.ArrayList getIUpdcmptDistribute() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SADistribute.S_State ).append( " = :p_STATE")
			       .append(" order by COMPONENT , PLATFORM , CATEGORY , SORT_BY ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SADistribute.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO#getIUpdcmptCausation()
	 */
	public java.util.ArrayList getIUpdcmptCausation() throws RemoteException, Exception {
		java.util.ArrayList fromUpdbm = null;
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( SAException.S_State ).append( " = :p_STATE")
			       .append(" order by COMPONENT , PLATFORM , CATEGORY , SORT_BY ");
			fromPARAM.put("p_STATE", "U");
			fromUpdbm = SFCacheFactory.getCache().hgetAll(SAException.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM);
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpdbm;
	}
}
