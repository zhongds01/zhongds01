package com.ai.sacenter.core.service.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.core.service.interfaces.IUpdcSV;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê11ÔÂ5ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class UpdcSVImpl extends UpdcEclipseImpl implements IUpdcSV {

	public UpdcSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcSV#getORDER_ID()
	 */
	public long getORDER_ID() throws RemoteException, Exception {
		return UpdcFactory.getIUpdcDAO().getDONE_CODE();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdcSV#orderComplteAsyn(com.ai.sacenter.valuebean.IOVUpdfmxOffer)
	 */
	public void orderComplteAsyn(IOVUpdfmxOffer fromUpdfmx) throws RemoteException, Exception {
		UpfsvcManager.getMBean().beginTransaction();
		try
		{
			IOVUpdfmxOffer.IUpdfmxOfferHome fromOrderHome = fromUpdfmx.getORDER();
			java.sql.Timestamp aCOMPLETE = new java.sql.Timestamp( System.currentTimeMillis() );
			for( java.util.Iterator itera = fromOrderHome.getORDER().iterator(); itera.hasNext(); ){
				DataStructInterface fromEntity = (DataStructInterface)itera.next();
				if( OracleUtils.ICustom.isCommit( fromEntity ) == false ) continue;
				if( fromEntity.isNew() || fromEntity.isModified() ){
					if( fromEntity.hasProperty( "COMPLETE_DATE" ) ){
						fromEntity.set( "COMPLETE_DATE", aCOMPLETE );
					}
					UpfsvcManager.getSession().submitISQLLite( IUpdcConst.IUpdbm.IUpdfmxDAO, fromEntity );
				}
				else if( fromEntity.isDeleted() ){
					if( fromEntity.hasProperty( "COMPLETE_DATE" ) ){
						fromEntity.set( "COMPLETE_DATE", aCOMPLETE );
					}
					fromEntity.setStsToOld();
					fromEntity.delete();
					UpfsvcManager.getSession().submitISQLLite( IUpdcConst.IUpdbm.IUpdfmxDAO, fromEntity );
				}
			}
			UpfsvcManager.getMBean().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
			UpfsvcManager.getMBean().rollbackTransaction();
		}
		finally{
		
		}
	}

}
