package com.ai.sacenter.provision.dao.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.provision.bo.IISANotifyIndex;
import com.ai.sacenter.provision.bo.ISANotifyIndex;
import com.ai.sacenter.provision.dao.interfaces.IUpffmxDAO;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê3ÔÂ6ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpffmxDAOImpl extends ISystemDAOImpl implements IUpffmxDAO {

	public UpffmxDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpffmxDAO#getSFUpffmxHome(long, java.lang.String)
	 */
	public IOVUpfwmNotify[] getSFUpffmxHome(long aUSER_ID, String aREGION_ID) throws RemoteException, Exception {
		IOVUpfwmNotify fromNotifyHome[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.Map fromPARAM = new java.util.HashMap();
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
			fromSQL.append(" USER_ID = :p_USER_ID order by CREATE_DATE , ORDER_ID " );
			fromPARAM.put( "p_USER_ID"  , new Long( aUSER_ID )            );
			fromPARAM.put( "CATEGORY"   , IUpdcConst.IUpdbm.IUpdbf.EXPIRE );
			fromPARAM.put( "PLATFORM"   , fromUpffm.getID              () );
			fromPARAM.put( "REGION_ID"  , aREGION_ID                      );
			IISANotifyIndex fromINDEX[] = (IISANotifyIndex[])retrieve( ISANotifyIndex.S_TYPE, fromSQL.toString(), fromPARAM );
			if( fromINDEX != null && fromINDEX.length > 0 ){
				fromNotifyHome = new IOVUpfwmNotify[ fromINDEX.length ];
				for( int index = 0; fromINDEX != null && index < fromINDEX.length; index++ ){
					fromNotifyHome[index] = new IOVUpfwmNotify( fromINDEX[index] );
				}
			}
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromNotifyHome;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpffmxDAO#getSFUpffmxHome(long[], java.lang.String)
	 */
	public IOVUpfwmNotify[] getSFUpffmxHome(long[] aUSER_ID, String aREGION_ID) throws RemoteException, Exception {
		IOVUpfwmNotify fromNotify[] = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		java.util.List fromNAME = new java.util.ArrayList();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
			fromPARAM.put( "CATEGORY"   , IUpdcConst.IUpdbm.IUpdbf.EXPIRE );
			fromPARAM.put( "PLATFORM"   , fromUpffm.getID              () );
			fromPARAM.put( "REGION_ID"  , aREGION_ID                      );
			for( int index = 0; aUSER_ID != null && index < aUSER_ID.length; index++ ){
				String fromINDEX = ClassUtils.getINDEX( new String[]{ "p_USER_ID_", String.valueOf( index ) } );
				fromNAME.add ( ClassUtils.getINDEX( new String[]{ ":", fromINDEX }   ) );
				fromPARAM.put( fromINDEX , new Long( aUSER_ID[index]                 ) );
			}
			fromSQL.append(" USER_ID IN ( ");
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
			       .append(" ) order by CREATE_DATE , ORDER_ID ");
			IISANotifyIndex fromINDEX[] = (IISANotifyIndex[])retrieve( ISANotifyIndex.S_TYPE, fromSQL.toString(), fromPARAM );
			if( fromINDEX != null && fromINDEX.length > 0 ){
				fromNotify = new IOVUpfwmNotify[ fromINDEX.length ];
				for( int index = 0; fromINDEX != null && index < fromINDEX.length; index++ ){
					fromNotify[index] = new IOVUpfwmNotify( fromINDEX[index] );
				}
			}
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromNotify;
	}

}
