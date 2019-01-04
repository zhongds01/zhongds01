package com.ai.sacenter.receive.order.dao.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.receive.order.bo.IISAUrgencyX;
import com.ai.sacenter.receive.order.bo.ISAUrgency;
import com.ai.sacenter.receive.order.bo.ISAUrgencyX;
import com.ai.sacenter.receive.order.dao.interfaces.IUrgencyDAO;
import com.ai.sacenter.receive.order.valuebean.IOVUrgencyOffer;
import com.ai.sacenter.receive.order.valuebean.IOVUrgencyUser;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê10ÔÂ31ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UrgencyDAOImpl extends ISystemDAOImpl implements IUrgencyDAO {
	public UrgencyDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.dao.interfaces.IUrgencyDAO#getORDER_ID()
	 */
	public long getORDER_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( ISAUrgency.S_TYPE.getMapingEnty() ).longValue();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.dao.interfaces.IUrgencyDAO#getSFUrgencyUser(com.ai.sacenter.valuebean.IUpfgkmCityHome)
	 */
	public java.util.List<IOVUrgencyUser> getSFUrgencyUser(IUpfgkmCityHome fromCsosHome) throws RemoteException, Exception {
		java.util.List<IOVUrgencyUser> fromQueue = new java.util.ArrayList<IOVUrgencyUser>();
		StringBuilder fromSQL = new StringBuilder();
		java.util.Map<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		java.util.Map<Long,IOVUrgencyUser> fromINDEX = new java.util.HashMap<Long,IOVUrgencyUser>();
		java.util.List<String> fromNAME = new java.util.ArrayList<String>();
		try
		{
			fromSQL.append(" ORDER_ID in ( ");
			ClassUtils.IMerge.merge( fromCsosHome.getCOMPLETE(), fromQueue );
			for( int index = 0; index < fromQueue.size(); index++ ){
				IOVUrgencyUser fromUser = (IOVUrgencyUser)fromCsosHome.getCOMPLETE().get( index );
				String fromKEY = ClassUtils.getINDEX( new String[]{"p_ORDER_ID_", String.valueOf( index ) });
				fromNAME.add( ClassUtils.getINDEX( new String[]{ ":", fromKEY } ) );
				fromPARAM.put( fromKEY, new Long( fromUser.getORDER_ID() ) );
				fromPARAM.put( "REGION_ID", fromUser.getREGION_ID() );
				fromINDEX.put( new Long(fromUser.getORDER_ID() ), fromUser );
			}
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) );
			fromSQL.append(" ) order by PRODUCT_ID , STATUS desc ");
			IISAUrgencyX urgencyx[] = (IISAUrgencyX[])retrieve(ISAUrgencyX.S_TYPE, fromSQL.toString(), fromPARAM );
			for( int index = 0; urgencyx != null && index < urgencyx.length; index++ ){
				IOVUrgencyOffer fromOsOffer = new IOVUrgencyOffer( urgencyx[index] );
				IOVUrgencyUser fromOsUser = (IOVUrgencyUser)fromINDEX.get( new Long(fromOsOffer.getORDER_ID()) );
				if( fromOsUser != null ){ fromOsUser.getORDER().add( fromOsOffer ); }
			}
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null; }
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromQueue;
	}
}
