package com.ai.sacenter.receive.expire.dao.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.receive.expire.bo.ISAExpire;
import com.ai.sacenter.receive.expire.bo.ISAExpireSp;
import com.ai.sacenter.receive.expire.bo.SAExpire;
import com.ai.sacenter.receive.expire.bo.SAExpireSp;
import com.ai.sacenter.receive.expire.dao.interfaces.IExpireDAO;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireOffer;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;
/**
 * 下周期数据
 * @author:HC
 * @date:2016年1月12日
 * @description:
 */
public class ExpireDAOImpl extends ISystemDAOImpl implements IExpireDAO {
	
	public ExpireDAOImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.dao.interfaces.IExpireDAO#getORDER_ID()
	 */
	public long getORDER_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( SAExpire.S_TYPE.getMapingEnty() ).longValue();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.dao.interfaces.IExpireDAO#getExpireUser(long, java.lang.String)
	 */
	public IOVExpireUser[] getExpireUser(long aUSER_ID, String aREGION_ID) throws RemoteException, Exception {
		IOVExpireUser fromUser[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.Map<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		java.util.Map<Long,IOVExpireUser> fromINDEX = new java.util.HashMap<Long,IOVExpireUser>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ").append( "and STATE = :p_STATE");
			fromPARAM.put( "p_USER_ID", new Long( aUSER_ID ) );
			fromPARAM.put( "p_STATE"  , IUpdcConst.IState.C );
			fromPARAM.put( "REGION_ID", aREGION_ID );
			ISAExpire fromExpire[] = (ISAExpire[])retrieve(SAExpire.S_TYPE, fromSQL.toString(), fromPARAM );
			if( fromExpire != null && fromExpire.length > 0 ){
				fromUser = new IOVExpireUser[ fromExpire.length ];
				for( int index = 0; fromExpire != null && index < fromExpire.length; index++ ){
					fromUser[index] = new IOVExpireUser( fromExpire[index] );
					fromINDEX.put( new Long(fromUser[index].getORDER_ID() ), fromUser[index] );
				}
				ISAExpireSp fromExpireSp[] = (ISAExpireSp[])retrieve(SAExpireSp.S_TYPE, fromSQL.toString(), fromPARAM );
				for( int index = 0; fromExpireSp != null && index < fromExpireSp.length; index++ ){
					IOVExpireOffer fromOffer = new IOVExpireOffer( fromExpireSp[index] );
					IOVExpireUser fromUSER = (IOVExpireUser)fromINDEX.get( 
							new Long(fromOffer.getORDER_ID()) );
					if( fromUSER != null ){ fromUSER.getORDER().add( fromOffer) ; }
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.dao.interfaces.IExpireDAO#getExpireUser(com.ai.sacenter.valuebean.IUpfgkmCityHome)
	 */
	public IUpfgkmCityHome getExpireUser(IUpfgkmCityHome fromExpireHome) throws RemoteException, Exception {
		StringBuilder fromSQL = new StringBuilder();
		java.util.Map<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		java.util.Map<Long,IOVExpireUser> fromINDEX = new java.util.HashMap<Long,IOVExpireUser>();
		java.util.List<String> fromNAME = new java.util.ArrayList<String>();
		try
		{
			fromSQL.append(" ORDER_ID IN ( ");
			for( int index = 0; index < fromExpireHome.getCOMPLETE().size(); index++ ){
				IOVExpireUser fromUser = (IOVExpireUser)fromExpireHome.getCOMPLETE().get( index );
				String fromKEY = ClassUtils.getINDEX( new String[]{"p_ORDER_ID_", String.valueOf( index ) });
				fromNAME.add( ClassUtils.getINDEX( new String[]{ ":", fromKEY } ) );
				fromPARAM.put( fromKEY, new Long( fromUser.getORDER_ID() ) );
				fromPARAM.put( "REGION_ID", fromUser.getREGION_ID() );
				fromINDEX.put( new Long( fromUser.getORDER_ID() ), fromUser );
			}
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) );
			fromSQL.append(" ) order by ORDER_ID , SERVICE_ID , PRODUCT_ID , STATUS desc ");
			ISAExpireSp fromExpireSp[] = (ISAExpireSp[])retrieve(SAExpireSp.S_TYPE, fromSQL.toString(), fromPARAM );
			for( int index = 0; fromExpireSp != null && index < fromExpireSp.length; index++ ){
				IOVExpireOffer fromOffer = new IOVExpireOffer( fromExpireSp[index] );
				IOVExpireUser fromUSER = (IOVExpireUser)fromINDEX.get( new Long(fromOffer.getORDER_ID()) );
				if( fromUSER != null ){ fromUSER.getORDER().add( fromOffer) ; }
			}
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null; }
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromExpireHome;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.receive.expire.dao.interfaces.IExpireDAO#getExpireUser(long)
	 */
	public IOVExpireUser[] getExpireUser(long aUser_ID) throws RemoteException, Exception {
		IOVExpireUser fromUser[] = null;
		StringBuilder fromSQL = new StringBuilder();
		StringBuilder fromSql = new StringBuilder();
		java.util.Map<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		java.util.Map<Long,IOVExpireUser> fromINDEX = new java.util.HashMap<Long,IOVExpireUser>();
		java.util.List<String> fromNAME = new java.util.ArrayList<String>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ");
			fromPARAM.put( "p_USER_ID", new Long( aUser_ID ) );
			ISAExpire fromExpire[] = (ISAExpire[])retrieve(SAExpire.S_TYPE, fromSQL.toString(), fromPARAM );
			if( fromExpire != null && fromExpire.length > 0 ){
				fromUser = new IOVExpireUser[ fromExpire.length ];
				fromSql.append(" ORDER_ID in ( ");
				for( int index = 0; fromExpire != null && index < fromExpire.length; index++ ){
					String fromKEY = ClassUtils.getINDEX( new String[]{"p_ORDER_ID_", 
							String.valueOf( index ) });
					fromNAME.add(":"+fromKEY);
					fromUser[index] = new IOVExpireUser( fromExpire[index] );
					fromPARAM.put( fromKEY, new Long( fromUser[index].getORDER_ID() ) );
					fromPARAM.put( "REGION_ID", fromUser[index].getREGION_ID() );
					fromINDEX.put( new Long(fromUser[index].getORDER_ID() ), fromUser[index] );
				}
				fromSql.append( StringUtils.join( fromNAME.iterator(), " , " ) );
				fromSql.append(" ) order by ORDER_ID , SERVICE_ID , PRODUCT_ID , STATUS desc");
				ISAExpireSp fromExpireSp[] = (ISAExpireSp[])retrieve(SAExpireSp.S_TYPE, fromSql.toString(), fromPARAM );
				for( int index = 0; fromExpireSp != null && index < fromExpireSp.length; index++ ){
					IOVExpireOffer fromOffer = new IOVExpireOffer( fromExpireSp[index] );
					IOVExpireUser fromUSER = (IOVExpireUser)fromINDEX.get( 
							new Long(fromOffer.getORDER_ID()) );
					if( fromUSER != null ){ fromUSER.getORDER().add( fromOffer) ; }
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null; }
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromUser;
	}
}
