package com.ai.sacenter.receive.exigence.dao.remote.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.custom.dbcp.ICustomDAOImpl;
import com.ai.sacenter.receive.exigence.bo.IISPCRocket;
import com.ai.sacenter.receive.exigence.bo.IISPCRocketX;
import com.ai.sacenter.receive.exigence.bo.ISPCRocket;
import com.ai.sacenter.receive.exigence.bo.ISPCRocketX;
import com.ai.sacenter.receive.exigence.dao.remote.interfaces.IRemoteDAO;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketOffer;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月31日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class RemoteDAOImpl extends ICustomDAOImpl implements IRemoteDAO {
	public RemoteDAOImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.dao.interfaces.IRocketDAO#getORDER_ID()
	 */
	public long getORDER_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( ISPCRocket.S_TYPE.getMapingEnty() ).longValue();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.dao.remote.interfaces.IRemoteDAO#getORDER_ID(java.lang.String)
	 */
	public long getORDER_ID(String aREGION_ID) throws RemoteException, Exception {
		return super.getSEQUENCE( ISPCRocket.S_TYPE.getMapingEnty(), aREGION_ID).longValue();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.dao.interfaces.IRocketDAO#getOFFER_ID()
	 */
	public long getOFFER_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( ISPCRocket.S_TYPE.getMapingEnty() ).longValue();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.dao.remote.interfaces.IRemoteDAO#getOFFER_ID(java.lang.String)
	 */
	public long getOFFER_ID(String aREGION_ID) throws RemoteException, Exception {
		return super.getSEQUENCE( ISPCRocket.S_TYPE.getMapingEnty(), aREGION_ID).longValue();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.dao.interfaces.IRocketDAO#getSFRocketPassage(com.ai.sacenter.util.CarbonList)
	 */
	public CarbonList<IOVMocketExigence> getSFRocketPassage(CarbonList<IOVMocketExigence> fromOrder) throws RemoteException, Exception {
		SFRemoteDAOImpl fromRemoteImpl = new SFRemoteDAOImpl();
		try
		{
			CarbonList<IOVMocketExigence> _rocket_home = fromRemoteImpl.getSFRocketPassage( fromOrder );
			if( _rocket_home != null && _rocket_home.size() > 0 ){
				for( java.util.Iterator<IOVMocketExigence> itera =_rocket_home.iterator(); itera.hasNext(); ){
					IOVMocketExigence __rocket_dbhome = (IOVMocketExigence)itera.next();
					IOVMocketExigence __rocket_home = (IOVMocketExigence)fromOrder.get( __rocket_dbhome );
					if( __rocket_home == null ){
						fromOrder.add( __rocket_dbhome );
					}
					else{
						__rocket_home.getORDER().getORDER().clear();
						ClassUtils.IMerge.merge( __rocket_dbhome.getORDER().getORDER(), __rocket_home.getORDER().getORDER() );
					}
				}
			}
		}
		finally{
			if( fromRemoteImpl != null ){ fromRemoteImpl = null; }
		}
		return fromOrder;
	}


	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.dao.interfaces.IRocketDAO#getSFRocketLimite(com.ai.sacenter.util.CarbonList)
	 */
	public CarbonList<IOVMocketExigence> getSFRocketLimite(CarbonList<IOVMocketExigence> fromOrder) throws RemoteException, Exception {
		SFRemoteDAOImpl fromRemoteImpl = new SFRemoteDAOImpl();
		try
		{
			CarbonList<IOVMocketExigence> _rocket_home = fromRemoteImpl.getSFRocketLimite( fromOrder );
			if( _rocket_home != null && _rocket_home.size() > 0 ){
				for( java.util.Iterator<IOVMocketExigence> itera =_rocket_home.iterator(); itera.hasNext(); ){
					IOVMocketExigence __rocket_dbhome = (IOVMocketExigence)itera.next();
					IOVMocketExigence __rocket_home = (IOVMocketExigence)fromOrder.get( __rocket_dbhome );
					if( __rocket_home == null ){
						fromOrder.add( __rocket_dbhome );
					}
					else{
						__rocket_home.getORDER().getORDER().clear();
						ClassUtils.IMerge.merge( __rocket_dbhome.getORDER().getORDER(), __rocket_home.getORDER().getORDER() );
					}
				}
			}
		}
		finally{
			if( fromRemoteImpl != null ){ fromRemoteImpl = null; }
		}
		return fromOrder;
	}

	/**
     * 
     * <p>Title: sacenter-receive</p>
     * <p>Description: </p>
     * <p>Copyright: Copyright (c) 2017年5月4日</p>
     * <p>Company: AI(NanJing)</p>
     * @author maohuiyun
     * @version 2.0 
     *
     */
	class SFRemoteDAOImpl{
		public SFRemoteDAOImpl(){
			super();
		}
		
		/**
		 * 
		 * @param _rocket_home
		 * @return
		 * @throws RemoteException
		 * @throws Exception
		 */
		public CarbonList<IOVMocketExigence> getSFRocketPassage( CarbonList<IOVMocketExigence> _rocket_home) throws RemoteException, Exception{
			CarbonList<IOVMocketExigence> fromUpdfmx;
			StringBuilder fromSQL = new StringBuilder();
			java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
			java.util.List<String> fromNAME = new java.util.ArrayList<String>();
			try
			{
				fromSQL.append( " ORDER_ID in ( ");
				for( int index = 0; _rocket_home != null && index < _rocket_home.size(); index++ ){
					IOVMocketExigence fromRocket = (IOVMocketExigence)_rocket_home.get( index );
					Long aORDER_ID = new Long( fromRocket.getORDER_ID() );
					if( fromPARAM.values().contains( aORDER_ID )  ) continue;
					String fromINDEX = ClassUtils.getINDEX( new String[]{"p_ORDER_ID_" + String.valueOf( index ) } );
					fromNAME.add( ClassUtils.getINDEX( new String[]{ ":", fromINDEX }  ) );
					fromPARAM.put( "REGION_ID", fromRocket.getORDER_REGION_ID() );
					fromPARAM.put( fromINDEX  , aORDER_ID );
				}
				fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
				       .append(" ) order by USER_ID , DONE_DATE , ORDER_ID " );
				fromUpdfmx = getSFRocket( fromSQL.toString(), fromPARAM );
			}
			finally{
				if( fromNAME != null ){ fromNAME.clear(); fromNAME = null; }
				if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
				if( fromSQL != null ){ fromSQL = null ; }
			}
			return fromUpdfmx;
		}
		
		/**
		 * 
		 * @param _rocket_timeby_home
		 * @return
		 * @throws RemoteException
		 * @throws Exception
		 */
		public CarbonList<IOVMocketExigence> getSFRocketLimite( CarbonList<IOVMocketExigence> _rocket_limite_home) throws RemoteException, Exception{
			CarbonList<IOVMocketExigence> fromUpdfmx;
			StringBuilder fromSQL = new StringBuilder();
			java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
			java.util.List<String> fromNAME = new java.util.ArrayList<String>();
			try
			{
				fromSQL.append( " USER_ID in ( ");
				for( int index = 0; _rocket_limite_home != null && index < _rocket_limite_home.size(); index++ ){
					IOVMocketExigence fromRocket = (IOVMocketExigence)_rocket_limite_home.get( index );
					Long aUSER_ID = new Long( fromRocket.getUSER_ID() );
					if( fromPARAM.values().contains( aUSER_ID )  ) continue;
					String fromINDEX = ClassUtils.getINDEX( new String[]{"p_USER_ID_" + String.valueOf( index ) } );
					fromNAME.add( ClassUtils.getINDEX( new String[]{ ":", fromINDEX }  ) );
					fromPARAM.put( "REGION_ID", fromRocket.getORDER_REGION_ID() );
					fromPARAM.put( fromINDEX  , aUSER_ID );
				}
				fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
				       .append(" ) order by USER_ID , DONE_DATE , ORDER_ID " );
				fromUpdfmx = getSFRocket( fromSQL.toString(), fromPARAM );
			}
			finally{
				if( fromNAME != null ){ fromNAME.clear(); fromNAME = null; }
				if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
				if( fromSQL != null ){ fromSQL = null ; }
			}
			return fromUpdfmx;
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
		public CarbonList<IOVMocketExigence> getSFRocket( String fromSQL, java.util.HashMap<String,Object> fromPARAM) throws RemoteException, Exception{
			CarbonList<IOVMocketExigence> fromUpdfmx = new CarbonList<IOVMocketExigence>();
			java.util.Map<Long,IOVMocketExigence> fromINDEX = new java.util.HashMap<Long,IOVMocketExigence>();
			try
			{
				java.util.ArrayList _rocket_home = retrieve( ISPCRocket.S_TYPE.getMapingEnty(), fromSQL, fromPARAM );
				if( _rocket_home != null && _rocket_home.size() > 0 ){
					for( java.util.Iterator<IISPCRocket> itera = _rocket_home.iterator(); itera.hasNext(); ){
						ISPCRocket __rocket = (ISPCRocket)itera.next();
						IOVMocketExigence fromRocket = new IOVMocketExigence( __rocket );
						fromINDEX.put( new Long( fromRocket.getORDER_ID() ), fromRocket );
						fromUpdfmx.add( fromRocket );
					}
					CarbonList<IOVMocketOffer> _rocketx_home = getSFRocketX( fromPARAM, fromUpdfmx);
					for( int index = 0; _rocketx_home != null && index < _rocketx_home.size(); index++ ){
						IOVMocketOffer __rocketx = (IOVMocketOffer)_rocketx_home.get( index );
						IOVMocketExigence __rocket = (IOVMocketExigence)fromINDEX.get( new Long( __rocketx.getORDER_ID() ) );
						if( __rocket != null ){ __rocket.getORDER().getORDER().add( __rocketx ); }
					}
				}
			}
			finally{
				if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
			}
			return fromUpdfmx;
		}
		
		/**
		 * 
		 * @param fromPARAM
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public CarbonList<IOVMocketOffer> getSFRocketX( java.util.HashMap<String,Object> fromPARAM, CarbonList<IOVMocketExigence> fromRocket ) throws SFException,Exception{
			CarbonList<IOVMocketOffer> fromUpdfmx = new CarbonList<IOVMocketOffer>();
			java.util.HashMap<Long, CarbonList<IOVMocketExigence>> fromBatch = new java.util.HashMap<Long, CarbonList<IOVMocketExigence>>();
			try
			{
				for( int index = 0,fromSortBy = 10000; fromRocket != null && index < fromRocket.size(); fromSortBy++ ){
					java.lang.Long ___batch_id_home = new java.lang.Long( fromSortBy );
					CarbonList<IOVMocketExigence> __batch_rocket_home = new CarbonList<IOVMocketExigence>();
					for( int __batch_no = 0; index < fromRocket.size() && __batch_no < 50; __batch_no++,index++ ){
						__batch_rocket_home.add( (IOVMocketExigence)fromRocket.get( index ) );
					}
					fromBatch.put( ___batch_id_home, __batch_rocket_home );
				}
				for( java.util.Iterator<java.util.Map.Entry<Long, CarbonList<IOVMocketExigence>>> itera = fromBatch.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry<Long, CarbonList<IOVMocketExigence>> fromEntry = (java.util.Map.Entry<Long, CarbonList<IOVMocketExigence>>)itera.next();
					CarbonList<IOVMocketExigence> __batch_rocket_home = (CarbonList<IOVMocketExigence>)fromEntry.getValue();
					CarbonList<IOVMocketOffer> __batch_offer_home = getSFRocketX( fromPARAM, __batch_rocket_home, fromRocket );
					for( java.util.Iterator<IOVMocketOffer> iterap = __batch_offer_home.iterator(); iterap.hasNext(); ){
						IOVMocketOffer _batch_rocktx_home = (IOVMocketOffer)iterap.next();
						fromUpdfmx.add( _batch_rocktx_home );
					}
				}
			}
			finally{
				if( fromBatch != null ){ fromBatch.clear(); fromBatch = null; }
			}
			return fromUpdfmx;
		}
		
		/**
		 * 
		 * @param fromPARAM
		 * @param fromBatch
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public CarbonList<IOVMocketOffer> getSFRocketX( java.util.HashMap<String,Object> fromPARAM, CarbonList<IOVMocketExigence> fromBatch, CarbonList<IOVMocketExigence> fromRocket ) throws SFException,Exception{
			CarbonList<IOVMocketOffer> fromUpdfmx = new CarbonList<IOVMocketOffer>();
			java.util.List<String> fromNAME = new java.util.ArrayList<String>();
			java.util.HashMap<String,Object> fromPARA = new java.util.HashMap<String,Object>( fromPARAM );
			try
			{
				StringBuilder fromSQL = new StringBuilder(" ORDER_ID in ( ");
				for( int index = 0; fromBatch != null && index < fromBatch.size(); index++ ){
					IOVMocketExigence _rocket = (IOVMocketExigence)fromBatch.get( index );
					String fromINDEX = ClassUtils.getINDEX( new String[]{ "p_ORDER_ID_", String.valueOf( index ) } );
					fromNAME.add ( ClassUtils.getINDEX( new String[]{ ":", fromINDEX } ) );
					fromPARA.put( fromINDEX , new Long( _rocket.getORDER_ID() ) );
				}
				fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
				      .append(" ) order by ORDER_ID , SORT_BY ");
				java.util.ArrayList _rocketx_home = retrieve( ISPCRocketX.S_TYPE.getMapingEnty(), fromSQL.toString(), fromPARA );
				if( _rocketx_home != null && _rocketx_home.size() > 0 ){
					for( java.util.Iterator<IISPCRocketX> itera = _rocketx_home.iterator(); itera.hasNext(); ){
						IISPCRocketX __rocketx_home = (IISPCRocketX)itera.next();
						fromUpdfmx.add( new IOVMocketOffer( __rocketx_home ) );
					}
				}
			}
			finally{
				if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			}
			return fromUpdfmx;
		}
	}

}
