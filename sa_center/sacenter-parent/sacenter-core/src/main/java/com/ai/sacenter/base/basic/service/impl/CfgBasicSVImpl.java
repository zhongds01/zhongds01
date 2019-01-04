package com.ai.sacenter.base.basic.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.basic.bo.ISAIdGenerator;
import com.ai.sacenter.base.basic.bo.ISALibrary;
import com.ai.sacenter.base.basic.bo.ISASubTable;
import com.ai.sacenter.base.basic.bo.ISASubTableRel;
import com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV;

/**
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê9ÔÂ30ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class CfgBasicSVImpl implements ICfgBasicSV {
	public CfgBasicSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getAllStatic()
	 */
	public java.util.ArrayList getAllStatic() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getIAllStatic();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getAllDiction()
	 */
	public java.util.ArrayList getAllDiction() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getAllDiction();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getAllDistrict()
	 */
	public java.util.ArrayList getAllDistrict() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getAllDistrict();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getICenterRoute()
	 */
	public java.util.ArrayList getICenterRoute() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getICenterRoute();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getICenterCatalog()
	 */
	public java.util.ArrayList getICenterCatalog() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getICenterCatalog();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getICenterMapping()
	 */
	public java.util.ArrayList getICenterMapping() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getICenterMapping();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getICenterWrapper()
	 */
	public java.util.ArrayList getICenterWrapper() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getICenterWrapper();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getILibraryOffer()
	 */
	public ISALibrary[] getILibraryOffer() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getILibraryOffer();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getIIdGenerator()
	 */
	public ISAIdGenerator[] getIIdGenerator() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getIIdGenerator();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getISubTableOffer()
	 */
	public java.util.ArrayList getISubTableOffer() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getISubTableOffer();
	}

	/*(non-Javadoc)
	 * 
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getISubSQLTable()
	 */
	public ISASubTable[] getISubSQLTable() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getISubSQLTable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getISubSQLTableRel()
	 */
	public ISASubTableRel[] getISubSQLTableRel()
			throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getISubSQLTableRel();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getISubSQLTableCol()
	 */
	public java.util.ArrayList getISubSQLTableCol() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getISubSQLTableCol();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getISubSQLTableCau()
	 */
	public java.util.ArrayList getISubSQLTableCau() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getISubSQLTableCau();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getIUpfgkmParallel()
	 */
	public ArrayList getIUpfgkmParallel() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getIUpfgkmParallel();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV#getIUpfgkmResource()
	 */
	public ArrayList getIUpfgkmResource() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getIUpfgkmResource();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgCompeteSV#getIUpdbfsBusines()
	 */
	public java.util.ArrayList getIUpdbfsBusines() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getIUpdbfsBusines();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgCompeteSV#getIUpdbfsCatalog()
	 */
	public java.util.ArrayList getIUpdbfsCatalog() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getIUpdbfsCatalog();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgCompeteSV#getIUpdbfsLimite()
	 */
	public java.util.ArrayList getIUpdbfsLimite() throws RemoteException, Exception {
		return BasicFactory.getIBasicDAO().getIUpdbfsLimite();
	}
}
