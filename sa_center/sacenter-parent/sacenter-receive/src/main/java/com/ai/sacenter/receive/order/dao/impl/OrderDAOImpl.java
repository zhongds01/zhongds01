package com.ai.sacenter.receive.order.dao.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.receive.order.bo.IISARocket;
import com.ai.sacenter.receive.order.bo.IISARocketX;
import com.ai.sacenter.receive.order.bo.ISARocket;
import com.ai.sacenter.receive.order.bo.ISARocketFail;
import com.ai.sacenter.receive.order.bo.ISARocketHis;
import com.ai.sacenter.receive.order.bo.ISARocketX;
import com.ai.sacenter.receive.order.bo.ISARocketXFail;
import com.ai.sacenter.receive.order.bo.ISARocketXHis;
import com.ai.sacenter.receive.order.dao.interfaces.IOrderDAO;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.order.valuebean.IOVRocketOffer;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;

public class OrderDAOImpl extends  ISystemDAOImpl implements IOrderDAO {
	public OrderDAOImpl(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.dao.interfaces.IOrderDAO#getORDER_ID()
	 */
	public long getORDER_ID(String aREGION_ID) throws RemoteException, Exception {
		return super.getSEQUENCE( ISARocket.S_TYPE.getMapingEnty(), aREGION_ID ).longValue();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.dao.interfaces.IOrderDAO#getORDER_ID()
	 */
	public long getORDER_ID() throws RemoteException, Exception {
		return super.getSEQUENCE(ISARocket.S_TYPE.getMapingEnty()).longValue();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.dao.interfaces.IOrderDAO#getSFRocketByOrderId(long, java.lang.String)
	 */
	public IOVRocketExigence getSFRocketByOrderId(long aORDER_ID, String aREGION_ID) throws RemoteException, Exception {
		IOVRocketExigence fromRocket[] = null;
		SFOrderDAOImpl fromUpdfmxImpl = new SFOrderDAOImpl();
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" ORDER_ID = :p_ORDER_ID ");
			fromPARAM.put("p_ORDER_ID", new Long( aORDER_ID ));
			fromPARAM.put("REGION_ID" , aREGION_ID           );
			ObjectType fromTYPE[] = new ObjectType[]{ISARocket.S_TYPE, ISARocketFail.S_TYPE};
			for( int index = 0; index < fromTYPE.length; index++ ){
				fromRocket = fromUpdfmxImpl._jj_rocket( fromTYPE[index] , fromSQL.toString(), fromPARAM );
				if( fromRocket != null && fromRocket.length > 0 ){ break; }
			}
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM=null; }
			if( fromUpdfmxImpl != null ){ fromUpdfmxImpl = null; }
		}
		return fromRocket != null && fromRocket.length > 0?fromRocket[ fromRocket.length - 1]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.dao.interfaces.IOrderDAO#getSFRocketByUserId(long)
	 */
	public IOVRocketExigence[] getSFRocketByUserId(long aUSER_ID) throws RemoteException, Exception {
		IOVRocketExigence fromMeta[] = null;
		SFOrderDAOImpl fromUpdfmxImpl = new SFOrderDAOImpl();
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID= :p_USER_ID ");
			fromPARAM.put("p_USER_ID", new Long( aUSER_ID ));
			fromMeta = fromUpdfmxImpl._jj_rocket( ISARocket.S_TYPE, fromSQL.toString(), fromPARAM );
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM=null; }
			if( fromUpdfmxImpl != null ){ fromUpdfmxImpl = null; }
		}
		return fromMeta;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.dao.interfaces.IOrderDAO#getSFRocketDispatch(java.util.List)
	 */
	public java.util.List<IOVRocketExigence> getSFRocketDispatch(java.util.List<IOVRocketExigence> fromDispatch) throws RemoteException, Exception {
		SFOrderDAOImpl fromUpdfmxImpl = new SFOrderDAOImpl();
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		java.util.List<String> fromNAME = new java.util.ArrayList<String>();
		try
		{
			fromSQL.append( " USER_ID in (");
			IOVRocketExigence fromOrder[] = (IOVRocketExigence[])fromDispatch.toArray( new IOVRocketExigence[]{} );
			for( int index = 0; fromOrder != null && index < fromOrder.length; index++ ){
				Long aUSER_ID = new Long( fromOrder[index].getUSER_ID() );
				if( fromPARAM.values().contains( aUSER_ID )  ) continue;
				String fromINDEX = ClassUtils.getINDEX( new String[]{"p_USER_ID_" + String.valueOf( index ) } );
				fromNAME.add( ClassUtils.getINDEX( new String[]{ ":", fromINDEX } ) );
				fromPARAM.put( fromINDEX , aUSER_ID );
			}
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
			       .append(" ) order by USER_ID , DONE_DATE , ORDER_ID " );
			IOVRocketExigence _rocket_[] = fromUpdfmxImpl._jj_rocket( ISARocket.S_TYPE, fromSQL.toString(), fromPARAM );
			if( _rocket_ != null && _rocket_.length > 0 ){
				for( int index = 0; _rocket_ != null && index < _rocket_.length; index++ ){
					int fromIndexOf = fromDispatch.indexOf( _rocket_[index] );
					if( fromIndexOf < 0 ) fromDispatch.add( _rocket_[index] );
					else{
						IOVRocketExigence ___rocket__ = (IOVRocketExigence)fromDispatch.get( fromIndexOf );
						if( ___rocket__.getORDER().getORDER().size() <= 0 ){
							ClassUtils.IMerge.merge( _rocket_[index].getORDER().getORDER(), ___rocket__.getORDER().getORDER() );
						}
					}
				}
			}
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
			if( fromSQL != null ){ fromSQL = null ; }
			if( fromUpdfmxImpl != null ){ fromUpdfmxImpl = null; }
		}
		return fromDispatch;
	}
	
	class SFOrderDAOImpl{
		public SFOrderDAOImpl(){
			super();
		}
		
		/**
		 * 
		 * @param fromTYPE
		 * @param fromSQL
		 * @param fromPARAM
		 * @return
		 * @throws RemoteException
		 * @throws Exception
		 */
		public IOVRocketExigence[] _jj_rocket( ObjectType fromTYPE, String fromSQL, java.util.HashMap<String,Object> fromPARAM) throws SFException, Exception{
			IOVRocketExigence fromOrder[] = null;
			java.util.Map<Long,IOVRocketExigence> fromINDEX = new java.util.HashMap<Long,IOVRocketExigence>();
			try
			{
				java.util.List<IISARocket> _rocket = HQSQLFactory.getOracle().retrieve( fromTYPE, fromSQL.toString(), fromPARAM );
				if( _rocket != null && _rocket.size() > 0 ){
					fromOrder = new IOVRocketExigence[ _rocket.size() ];
					for( int index = 0; _rocket != null && index < _rocket.size(); index++ ){
						fromOrder[index] = new IOVRocketExigence( (IISARocket)_rocket.get( index ) );
						fromINDEX.put( new Long( fromOrder[index].getROCKET_ID() ), fromOrder[index] );
					}
					IOVRocketOffer fromOffer[] = _jj_rocketx( _jj_rocketx( fromTYPE ), fromPARAM, fromOrder);
					for( int index = 0; fromOffer != null && index < fromOffer.length; index++ ){
						IOVRocketExigence fromOsOffer = (IOVRocketExigence)fromINDEX.get( new Long( fromOffer[index].getORDER_ID() ) );
						if( fromOsOffer != null ) fromOsOffer.getORDER().getORDER().add( fromOffer[index] );
					}
				}
			}
			finally{
				if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
			}
			return fromOrder;
		}
		
		/**
		 * 
		 * @param fromTYPE
		 * @param fromPARAM
		 * @param fromOrder
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVRocketOffer[] _jj_rocketx( ObjectType fromTYPE, java.util.Map<String,Object> fromPARAM, IOVRocketExigence fromOrder[] ) throws SFException,Exception{
			IOVRocketOffer fromOffer[] = null;
			java.util.List<String> fromNAME = new java.util.ArrayList<String>();
			try
			{
				StringBuilder fromSQL = new StringBuilder(" ORDER_ID in ( ");
				for( int index = 0 ; fromOrder != null && index < fromOrder.length; index++ ){
					String fromINDEX = ClassUtils.getINDEX( new String[]{ "p_ORDER_ID_", String.valueOf( index ) } );
					fromNAME.add( ClassUtils.getINDEX( new String[]{ ":", fromINDEX } ) );
					fromPARAM.put( fromINDEX , new Long( fromOrder[index].getROCKET_ID() ) );
				}
				fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
				      .append(" ) order by ORDER_ID , SORT_BY ");
				java.util.List<IISARocketX> _rocketx = HQSQLFactory.getOracle().retrieve( fromTYPE, fromSQL.toString(), fromPARAM );
				if( _rocketx != null && _rocketx.size() > 0 ){
					fromOffer = new IOVRocketOffer[ _rocketx.size() ];
					for( int index = 0; _rocketx != null && index < _rocketx.size(); index++ ){
						fromOffer[index] = new IOVRocketOffer( (IISARocketX)_rocketx.get( index ) );
					}
				}
			}
			finally{
				if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			}
			return fromOffer;
		}
		
		/**
		 * 根据源表持久化类型转换二级持久化类型
		 * @param fromTYPE
		 * @return
		 */
		public ObjectType _jj_rocketx( ObjectType fromTYPE ){
			ObjectType fromGloal = null;
			try
			{
				if( fromTYPE.equals( ISARocket.S_TYPE ) ){
					fromGloal = ISARocketX.S_TYPE;
				}
				else if( fromTYPE.equals( ISARocketFail.S_TYPE ) ){
					fromGloal = ISARocketXFail.S_TYPE;
				}
				else if( fromTYPE.equals( ISARocketHis.S_TYPE ) ){
					fromGloal = ISARocketXHis.S_TYPE;
				}
			}
			finally{
				
			}
			return fromGloal;
		}
	}
}
