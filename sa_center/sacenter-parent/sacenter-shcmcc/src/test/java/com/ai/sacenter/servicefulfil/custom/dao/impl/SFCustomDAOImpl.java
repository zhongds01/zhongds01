package com.ai.sacenter.servicefulfil.custom.dao.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.bo.InsOffer;
import com.ai.sacenter.receive.custom.bo.InsUser;
import com.ai.sacenter.receive.custom.dbcp.ICustomDAOImpl;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.servicefulfil.custom.dao.interfaces.ISFCustomDAO;

/**
 * <p>Title: sacenter-zjcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê3ÔÂ29ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFCustomDAOImpl extends ICustomDAOImpl implements ISFCustomDAO {
	public SFCustomDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.custom.dao.interfaces.ISFCustomDAO#getIInsUserByUserId(long, java.lang.String)
	 */
	public InsUser getIInsUserByUserId(long aUSER_ID, String aREGION_ID) throws RemoteException, Exception {
		InsUser fromInsUser[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append( " and ").append( CustomUtils.ICustom.getSqlSysdate() )
			       .append( " between EFFECTIVE_DATE and EXPIRE_DATE ");
			fromPARAM.put("p_USER_ID", new Long( aUSER_ID ) );
			fromPARAM.put("REGION_ID", aREGION_ID );
			fromInsUser = (InsUser[])retrieve(InsUser.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromInsUser != null && fromInsUser.length > 0?fromInsUser[0]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.servicefulfil.custom.dao.interfaces.ISFCustomDAO#getIInsOfferByUserId(long, java.lang.String)
	 */
	public InsOffer[] getIInsOfferByUserId(long aUSER_ID, String aREGION_ID) throws RemoteException, Exception {
		InsOffer fromInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append( CustomUtils.ICustom.getSqlValidType( 
			    		   IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ) );
			fromPARAM.put("p_USER_ID", new Long( aUSER_ID ) );
			fromPARAM.put("REGION_ID", aREGION_ID );
			fromInsOffer = (InsOffer[])retrieve(InsOffer.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromInsOffer;
	}
}
