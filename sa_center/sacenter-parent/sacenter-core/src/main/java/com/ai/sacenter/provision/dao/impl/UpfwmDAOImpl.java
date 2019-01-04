package com.ai.sacenter.provision.dao.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLTable;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.bo.ISANotifyIndex;
import com.ai.sacenter.provision.bo.ISAProvision;
import com.ai.sacenter.provision.bo.ISAProvisionReset;
import com.ai.sacenter.provision.bo.ISAWorkOrder;
import com.ai.sacenter.provision.bo.SAWorkOrder;
import com.ai.sacenter.provision.bo.SAWorkOrderFail;
import com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO;
import com.ai.sacenter.provision.valuebean.IOVUpfwmComplete;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRabbit;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.util.ArrayUQCList;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-4-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfwmDAOImpl extends ISystemDAOImpl implements IUpfwmDAO {

	public UpfwmDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getPS_ID()
	 */
	public long getPS_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( ISAProvision.S_TYPE.getMapingEnty() ).longValue();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getORDER_ID()
	 */
	public java.math.BigDecimal getORDER_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( ISANotifyIndex.S_TYPE.getMapingEnty() );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getORDER_ID(java.lang.String)
	 */
	public java.math.BigDecimal getORDER_ID(String aREGION_ID) throws RemoteException, Exception {
		return super.getSEQUENCE( ISANotifyIndex.S_TYPE.getMapingEnty(), aREGION_ID );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.impl.ISystemDAOImpl#finish(java.util.HashMap)
	 */
	public void finish(java.util.HashMap fromUpdbm) throws RemoteException, Exception {
		java.util.ArrayList fromUpdbc = new java.util.ArrayList();
		try
		{
			fromUpdbc.add( fromUpdbm );
			super.finish( fromUpdbc );
		}
		finally{
			if( fromUpdbc != null ){ fromUpdbc.clear(); fromUpdbc = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.impl.ISystemDAOImpl#finish(java.util.HashMap[])
	 */
	public void finish(java.util.HashMap[] fromUpdbm) throws RemoteException, Exception {
		java.util.ArrayList fromUpdbc = new java.util.ArrayList();
		try
		{
			String fromTable = ISAProvision.S_TYPE.getMapingEnty();
			fromUpdbc.add(  OracleUtils.ISystem.wrap( fromTable, fromUpdbm ) );
			super.finish( fromUpdbc );
		}
		finally{
			if( fromUpdbc != null ){ fromUpdbc.clear(); fromUpdbc = null;}
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.impl.ISystemDAOImpl#finish(java.util.List)
	 */
	public void finish(java.util.List fromUpfwm) throws RemoteException, Exception {
		try
		{
			class SFUpfwmDAOImpl{
				public SFUpfwmDAOImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpdbm
				 * @param fromUpffm
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmRabbit getSFUpfwmNotifyHome(MBeanDelegate fromMBean,
						java.util.List fromUpdbm, 
						IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
					IOVUpfwmRabbit fromUpffmxHome = null;
					try
					{
						IOVUpfwmRabbit.IUpfwmNotify fromNotify = null;
						for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
							IOVUpfwmOffer fromINDEX = UpfwmUtils.ICustom._wrapWithLmst( itera.next() );
							if( fromINDEX == null || fromINDEX.getINSTANCE().isNew() == false ){ continue; }
							fromNotify = UpfwmUtils.ICustom._wrapWithNotify(fromMBean, fromINDEX, fromUpffm);
							if( fromNotify.isEXPIRE() && fromINDEX.getINSTANCE().isNew() ){
								if( fromUpffmxHome == null ) fromUpffmxHome = new IOVUpfwmRabbit( fromUpffm );
								if( fromUpffmxHome.getINDEX( fromNotify.getINDEX() ) == null ){
									fromUpffmxHome.getINDEX().put( fromNotify.getINDEX(), fromNotify );
								}
								fromUpffmxHome.getINDEX( fromNotify.getINDEX() ).getSUBFLOW().add( fromINDEX.getINSTANCE() );
							}
						}
					}
					finally{
						
					}
					return fromUpffmxHome;
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromNotify
				 * @param fromUpffm
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmNotify finishSFUpfwmNotifyIndex( MBeanDelegate fromMBean,
						IOVUpfwmRabbit.IUpfwmNotify fromNotify, 
						IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
					IOVUpfwmNotify fromINDEX = null;
					try
					{
						fromINDEX = UpfwmUtils.ICustom._wrap(fromMBean, fromNotify, fromUpffm);
						for( java.util.Iterator itera = fromNotify.getSUBFLOW().iterator(); itera.hasNext(); ){
							DataStructInterface fromEntity = (DataStructInterface)itera.next();
							fromEntity.set( IISAProvision.S_SubPlanNo, java.math.BigDecimal.valueOf( 
									fromINDEX.getORDER_ID() ) );
						}
					}
					finally{
						
					}
					return fromINDEX;
				}
			}
			SFUpfwmDAOImpl fromUpfwmImpl = new SFUpfwmDAOImpl();
			IOVUpfwmRabbit fromUpfwmHome = null;
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
				fromUpfwmHome = fromUpfwmImpl.getSFUpfwmNotifyHome(fromMBean, fromUpfwm, fromUpffm);
				if( fromUpfwmHome != null && fromUpfwmHome.getINDEX().size() > 0 ){
					for( java.util.Iterator itera = fromUpfwmHome.getINDEX().values().iterator(); itera.hasNext(); ){
						IOVUpfwmRabbit.IUpfwmNotify fromNotify = (IOVUpfwmRabbit.IUpfwmNotify)itera.next();
						IOVUpfwmNotify fromINDEX = fromUpfwmImpl.finishSFUpfwmNotifyIndex(fromMBean, 
								fromNotify, 
								fromUpffm);
						fromUpfwm.add( fromINDEX.getINSTANCE() );
					}
				}
				super.finish( fromUpfwm );
			}
			finally{
				if( fromUpfwmHome != null ){ fromUpfwmHome = null; }
				if( fromUpfwmImpl != null ){ fromUpfwmImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFUpfwmOrder(long)
	 */
	public IOVUpfwmOrder getSFUpfwmOrder(long aPS_ID) throws RemoteException, Exception {
		IOVUpfwmOrder fromASK = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.Map fromPARAM = new java.util.HashMap();
		try
		{
			fromSQL.append(" PS_ID = :p_PS_ID " );
			fromPARAM.put("p_PS_ID", new Long( aPS_ID ) );
			ISAWorkOrder _workorder[] = (ISAWorkOrder[])retrieve( SAWorkOrder.S_TYPE, fromSQL.toString(), fromPARAM );
			if( _workorder == null || _workorder.length <= 0 ){
				_workorder = (ISAWorkOrder[])retrieve( SAWorkOrderFail.S_TYPE, fromSQL.toString(), fromPARAM );
			}
			if( _workorder != null && _workorder.length > 0 ) fromASK = new IOVUpfwmOrder( _workorder[0] );
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFUpfwmOrder(long[])
	 */
	public IOVUpfwmOrder[] getSFUpfwmOrder(long[] aPLWK_ID) throws RemoteException, Exception {
		IOVUpfwmOrder fromASK[] = null;
		java.util.ArrayList fromPLWK = new java.util.ArrayList();
		java.util.ArrayList fromOrder = null;
		try
		{
			for( int index = 0; aPLWK_ID != null && index < aPLWK_ID.length; index++ ){
				fromPLWK.add( new Long( aPLWK_ID[index] ) );
			}
			fromOrder = getSFUpfwmOrder( fromPLWK );
			if( fromOrder != null && fromOrder.size() > 0 ){
				fromASK = new IOVUpfwmOrder[ fromOrder.size() ];
				for( int index = 0; fromOrder != null && index < fromOrder.size(); index++ ){
					ISAWorkOrder aWorkOrder = (ISAWorkOrder)fromOrder.get( index );
					fromASK[index] = new IOVUpfwmOrder( aWorkOrder );
				}
			}
		}
		finally{
			if( fromOrder != null ){ fromOrder.clear(); fromOrder = null;}
			if( fromPLWK != null ){ fromPLWK.clear(); fromPLWK = null;}
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFUpfwmOrder(java.util.ArrayList)
	 */
	public java.util.ArrayList getSFUpfwmOrder(java.util.ArrayList fromPLWK) throws RemoteException, Exception {
		java.util.ArrayList fromASK = new java.util.ArrayList();
		java.util.Map  fromPARAM  = new java.util.HashMap();
		java.util.List fromNAME = new java.util.ArrayList();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			for( int index = 0 ; index < fromPLWK.size(); index++ ){
				Object aPLWK_IDO = fromPLWK.get( index );
				String fromINDEX = ClassUtils.getINDEX( new String[]{ "PS_ID_" , String.valueOf( index ) } );
				fromNAME.add( ClassUtils.getINDEX( new String[]{ ":", fromINDEX } ) );
				fromPARAM.put( fromINDEX, aPLWK_IDO );
			}
			fromSQL.append( " PS_ID IN ( " )
			       .append( StringUtils.join( fromNAME.iterator(), " , " ) )
			       .append(" ) order by PS_ID ");
			ISAWorkOrder _workorder[] = (ISAWorkOrder[])retrieve( SAWorkOrder.S_TYPE, fromSQL.toString(), fromPARAM );
			if( _workorder != null && _workorder.length > 0 ){ ClassUtils.IMerge.merge( _workorder, fromASK ); }
			if( fromASK.size() != fromPLWK.size() ){
				_workorder = (ISAWorkOrder[])retrieve( SAWorkOrderFail.S_TYPE, fromSQL.toString(), fromPARAM );
				if( _workorder != null && _workorder.length > 0 ){ ClassUtils.IMerge.merge( _workorder , fromASK ); }
			}
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFUpfwmOrder(com.ai.sacenter.provision.valuebean.IOVUpfwmCouple[])
	 */
	public java.util.HashMap getSFUpfwmOrder(IOVUpfwmCouple[] fromUpfwm) throws RemoteException, Exception {
		java.util.HashMap fromASK = new java.util.HashMap();
		java.util.HashMap fromINDEX = new java.util.HashMap();
		java.util.ArrayList fromID = new java.util.ArrayList();
		try
		{
			for( int index = 0 ; index < fromUpfwm.length ; index++ ){
				Long fromPLWK = new Long( fromUpfwm[index].getPS_ID() );
				fromINDEX.put( fromPLWK , fromUpfwm[index] );
				fromID.add( fromPLWK );
			}
			java.util.List fromUpfwom = getSFUpfwmOrder( fromID );
			for( java.util.Iterator itera = fromUpfwom.iterator(); itera.hasNext(); ){
				ISAWorkOrder aWorkOrder = (ISAWorkOrder)itera.next();
				Long fromPLWK = new Long( aWorkOrder.getPsId() );
				fromASK.put( aWorkOrder, fromINDEX.get( fromPLWK ) );
			}
		}
		finally{
			if( fromID != null ){ fromID.clear(); fromID = null;}
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
		return fromASK;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFUpfwmOrder(java.util.HashMap[])
	 */
	public java.util.HashMap getSFUpfwmOrder(java.util.HashMap[] fromUpfwm) throws RemoteException, Exception {
		java.util.HashMap fromASK = new java.util.HashMap();
		java.util.HashMap fromINDEX = new java.util.HashMap();
		java.util.ArrayList fromPWLKID = new java.util.ArrayList();
		try
		{
			for( int index = 0 ; index < fromUpfwm.length ; index++ ){
				IISAProvision fromCouple = new ISAProvisionReset();
				OracleUtils.ICustom.transfer( fromUpfwm[index], fromCouple );
				fromCouple.setStsToOld();
				Long fromPLWK = new Long( fromCouple.getPsId() );
				fromINDEX.put( fromPLWK , fromCouple );
				fromPWLKID.add( fromPLWK );
			}
			java.util.List fromORDER = getSFUpfwmOrder( fromPWLKID );
			try
			{
				for( java.util.Iterator itera = fromORDER.iterator(); itera.hasNext(); ){
					ISAWorkOrder aWorkOrder = (ISAWorkOrder)itera.next();
					Long fromPLWK = new Long( aWorkOrder.getPsId() );
					fromASK.put( aWorkOrder, fromINDEX.get( fromPLWK ) );
				}
			}
			finally{
				if( fromORDER != null ){ fromORDER.clear(); fromORDER = null; }
			}
		}
		finally{
			if( fromPWLKID != null ){ fromPWLKID.clear(); fromPWLKID = null;}
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFUpfwmOrder(com.ai.sacenter.provision.valuebean.IOVUpfwmComplete[])
	 */
	public java.util.HashMap getSFUpfwmOrder(IOVUpfwmComplete[] fromUpfmon) throws RemoteException, Exception {
		java.util.HashMap fromASK = new java.util.HashMap();
		java.util.HashMap fromINDEX = new java.util.HashMap();
		java.util.ArrayList fromPWLKID = new java.util.ArrayList();
		try
		{
			for( int index = 0 ; index < fromUpfmon.length ; index++ ){
				Long fromPLWK = new Long( fromUpfmon[index].getPS_ID() );
				fromINDEX.put( fromPLWK , fromUpfmon[index] );
				fromPWLKID.add( fromPLWK );
			}
			java.util.List fromORDER = getSFUpfwmOrder( fromPWLKID );
			try
			{
				for( java.util.Iterator itera = fromORDER.iterator(); itera.hasNext(); ){
					ISAWorkOrder aWorkOrder = (ISAWorkOrder)itera.next();
					Long fromPLWK = new Long( aWorkOrder.getPsId() );
					fromASK.put( aWorkOrder, fromINDEX.get( fromPLWK ) );
				}
			}
			finally{
				if( fromORDER != null ){ fromORDER.clear(); fromORDER = null; }
			}
		}
		finally{
			if( fromPWLKID != null ){ fromPWLKID.clear(); fromPWLKID = null;}
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null;}
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFUpfwmLimite(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, java.util.Map, java.lang.String, java.util.List)
	 */
	public java.util.ArrayList getSFUpfwmLimite(IOVUpfwmOffer fromOffer, 
			java.util.Map fromUser,
			String fromBUFFER, 
			java.util.List fromUpfwm) throws RemoteException, Exception {
		java.util.ArrayList fromList = null;
		java.util.Map  fromPARAM = new java.util.HashMap( fromUser );
		java.util.List fromNAME = new java.util.ArrayList();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			for( java.util.Iterator itera = fromUser.keySet().iterator(); itera.hasNext(); ){
				Long fromUSERID = (Long)itera.next();
				fromNAME.add( ClassUtils.getINDEX(new String[]{":", fromUSERID.toString()}) );
			}
			fromSQL.append( " USER_ID in ( " )
			       .append( StringUtils.join( fromNAME.iterator(), " , " ) )
			       .append( " ) order by CREATE_DATE , PS_ID " );
			fromPARAM.put( IISAProvision.S_RegionId , fromOffer.getREGION_ID() );
			fromPARAM.put( IISAProvision.S_Platform , fromOffer.getPLATFORM () );
			fromPARAM.put( IISAProvision.S_Composite, fromOffer.getCOMPOSITE() );
			fromList = HQSQLFactory.getOracle().retrieve(ISAProvision.S_TYPE, fromSQL.toString(), fromPARAM);
			if( fromList != null && fromList.size() > 0 ) ClassUtils.IMerge.merge( fromList, fromUpfwm );
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromList;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFUpfwmGroup(com.ai.sacenter.util.ArrayUQCList)
	 */
	public ArrayUQCList getSFUpfwmGroup(ArrayUQCList fromUpfwm) throws RemoteException, Exception {
		java.util.Map fromUSER = new java.util.HashMap();
		java.util.List fromACTIVE = new java.util.ArrayList();
		try
		{
			IOVUpfwmOffer fromUpfpm[] = (IOVUpfwmOffer[])fromUpfwm.toArray( new IOVUpfwmOffer[]{} );
			for( int index = 0 ; fromUpfpm != null && index < fromUpfpm.length; index++ ){
				Long aUSER_ID = new Long( fromUpfpm[index].getUSER_ID() );
				if( fromUSER.values().contains( aUSER_ID )  ) continue;
				String fromINDEX = ClassUtils.getINDEX( new String[]{"p_USER_ID_" , String.valueOf( index ) } );
				fromUSER.put( fromINDEX, aUSER_ID );
			}
			if( fromUpfpm != null && fromUpfpm.length > 0 ){
				getSFUpfwmLimite(fromUpfpm[0], 
						fromUSER, 
						IUpdcConst.IUpdbm.IUpdbf.NORMAL, 
						fromACTIVE);
				getSFUpfwmLimite(fromUpfpm[0], 
						fromUSER, 
						IUpdcConst.IUpdbm.IUpdbf.BUFFER, 
						fromACTIVE);
				for( java.util.Iterator itera = fromACTIVE.iterator(); itera.hasNext(); ){
					IISAProvision _provision = (IISAProvision)itera.next();
					IOVUpfwmOffer fromLimite = new IOVUpfwmOffer( _provision );
					if( fromUpfwm.contains( fromLimite ) ) continue;
					fromUpfwm.add( fromLimite );
				}
			}
		}
		finally{
			if( fromACTIVE != null ){ fromACTIVE.clear(); fromACTIVE = null;}
			if( fromUSER != null ){ fromUSER.clear(); fromUSER = null;}
		}
		return fromUpfwm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFUpfwmActive(com.ai.sacenter.util.ArrayUQCList)
	 */
	public ArrayUQCList getSFUpfwmActive(ArrayUQCList fromUpfwm) throws RemoteException, Exception {
		java.util.Map fromINDEX = new java.util.HashMap();
		java.util.ArrayList fromPARAM = new java.util.ArrayList();
		java.util.ArrayList fromORDER = new java.util.ArrayList();
		try
		{
			IOVUpfwmOffer _provision = null;
			fromUpfwm = getSFUpfwmGroup( fromUpfwm );
			for( java.util.Iterator itera = fromUpfwm.iterator(); itera.hasNext(); ){
				_provision = (IOVUpfwmOffer)itera.next();
				java.lang.Long fromPLWK_ID = new java.lang.Long( _provision.getPS_ID() );
				fromINDEX.put( fromPLWK_ID, _provision );
				fromPARAM.add( fromPLWK_ID );
			}
			fromORDER = getSFUpfwmOrder( fromPARAM );
			for( java.util.Iterator itera = fromORDER.iterator(); itera.hasNext(); ){
				ISAWorkOrder aWorkOrder = (ISAWorkOrder)itera.next();
				IOVUpfwmOrder fromOrder = new IOVUpfwmOrder( aWorkOrder );
				_provision = (IOVUpfwmOffer)fromINDEX.get( new Long( fromOrder.getPS_ID() ) );
				if( _provision != null ){
					_provision.getORDER().setORDER( fromOrder );
				}
			}
		}
		finally{
			if( fromORDER != null ){ fromORDER.clear(); fromORDER = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
		}
		return fromUpfwm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFNotifyPassage(com.ai.sacenter.valuebean.IUpfgkmCityHome)
	 */
	public IUpfgkmCityHome getSFNotifyPassage(IUpfgkmCityHome fromUpffmx) throws RemoteException, Exception {
		try
		{
			class SFUpffmxTfImpl{
				public SFUpffmxTfImpl(){
					super();
				}
				/**
				 * 
				 * @param fromSubCity
				 * @param fromSQL
				 * @param fromPARAM
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public SFUpfwmNotify _jj_param( IUpfgkmCityHome fromSubCity ) throws SFException,Exception{
					SFUpfwmNotify _notify = new SFUpfwmNotify();
					java.util.List fromNAME = new java.util.ArrayList();
					try
					{
						for( int index = 0; fromSubCity != null && index < fromSubCity.getCOMPLETE().size(); index++ ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)fromSubCity.getCOMPLETE().get( index );
							String aINDEX = ClassUtils.getINDEX( new String[]{ "SUB_PLAN_NO_" , String.valueOf( index ) } );
							fromNAME.add( ClassUtils.getINDEX( new String[]{":",aINDEX} ) );
							_notify._param.put( aINDEX , new Long ( fromINDEX.getORDER_ID       () ) );
							_notify._param.put( IISAProvision.S_Composite,  fromINDEX.getCATEGORY () );
							_notify._param.put( IISAProvision.S_RegionId ,  fromINDEX.getREGION_ID() );
						}
						_notify._sql.append(" SUB_PLAN_NO IN ( ");
						_notify._sql.append( StringUtils.join( fromNAME.iterator(), " , " ) )
						            .append(" ) order by PS_ID ");
					}
					finally{
						if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
					}
					return _notify;
				}
				
				/**
				 * 
				 * @param fromNotify
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdfmxOffer _jj_provision( IUpfgkmCityHome fromUpfgkmHome, SFUpfwmNotify fromNotify ) throws SFException,Exception{
					IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfgkmHome );
					try
					{
						java.util.ArrayList<DataStructInterface> _provision = null;
						_provision = HQSQLFactory.getOracle().retrieve( ISAProvision.S_TYPE.getMapingEnty(), fromNotify._sql.toString(), fromNotify._param );
						if( _provision != null && _provision.size() > 0 ){
							for( java.util.Iterator itera = _provision.iterator(); itera.hasNext(); ){
								IISAProvision ___provision = (IISAProvision)itera.next();
								IOVUpfwmOffer fromUpfwm = new IOVUpfwmOffer( ___provision );
								fromUpdfmx.getORDER().getSUBFLOW( fromUpfwm.getSUB_PLAN_NO() ).add( fromUpfwm );
							}
						}
					}
					finally{
						
					}
					return fromUpdfmx;
				}
				
				class SFUpfwmNotify{
					StringBuilder _sql = new StringBuilder();
					java.util.HashMap _param  = new java.util.HashMap();
					public SFUpfwmNotify(){
						super();
					}
				}
			}
			SFUpffmxTfImpl fromUpfwmImpl = new SFUpffmxTfImpl();
			try
			{
				SFUpffmxTfImpl.SFUpfwmNotify __jj_param = fromUpfwmImpl._jj_param( fromUpffmx );
				if( fromUpffmx != null && fromUpffmx.getCOMPLETE().size() > 0 ){
					IOVUpdfmxOffer fromUpdfmx = fromUpfwmImpl._jj_provision( fromUpffmx, __jj_param );
					for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpffmx.getCOMPLETE().iterator(); itera.hasNext(); ){
						IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
						CarbonList<IOVUpfwmOffer> _jj_provision = fromUpdfmx.getORDER().getSUBFLOW( fromNotify.getORDER_ID() );
						for( java.util.Iterator<IOVUpfwmOffer> iterap = _jj_provision.iterator(); iterap.hasNext(); ){
							IOVUpfwmOffer __provision = (IOVUpfwmOffer)iterap.next();
							fromNotify.getLittle().getLITTLE().add( __provision );
						}
					}
				}
			}
			finally{
				if( fromUpfwmImpl != null ){ fromUpfwmImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO#getSFNotifyLimite(com.ai.sacenter.valuebean.IUpfgkmCityHome)
	 */
	public IOVUpdfmxOffer getSFNotifyLimite(IUpfgkmCityHome fromUpfgkmHome) throws RemoteException, Exception {
		IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfgkmHome );
		try
		{
			class SFUpfwmTfImpl{
				public SFUpfwmTfImpl(){
					super();
				}
				/**
				 * 
				 * @param fromSubCity
				 * @param fromSQL
				 * @param fromPARAM
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public SFUpfwmNotify _jj_param( IUpfgkmCityHome fromSubCity ) throws SFException,Exception{
					SFUpfwmNotify _notify = new SFUpfwmNotify();
					java.util.List fromNAME = new java.util.ArrayList();
					try
					{
						for( int index = 0; fromSubCity != null && index < fromSubCity.getCOMPLETE().size(); index++ ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)fromSubCity.getCOMPLETE().get( index );
							String aINDEX = ClassUtils.getINDEX( new String[]{ "SUB_PLAN_NO_" , String.valueOf( index ) } );
							fromNAME.add( ClassUtils.getINDEX( new String[]{":",aINDEX} ) );
							_notify._param.put( aINDEX , new Long ( fromINDEX.getORDER_ID       () ) );
							_notify._param.put( IISAProvision.S_Composite,  fromINDEX.getCATEGORY () );
							_notify._param.put( IISAProvision.S_RegionId ,  fromINDEX.getREGION_ID() );
						}
						_notify._sql.append(" SUB_PLAN_NO IN ( ");
						_notify._sql.append( StringUtils.join( fromNAME.iterator(), " , " ) )
						            .append(" ) order by PS_ID ");
					}
					finally{
						if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
					}
					return _notify;
				}
				
				class SFUpfwmNotify{
					StringBuilder _sql = new StringBuilder();
					java.util.HashMap _param  = new java.util.HashMap();
					public SFUpfwmNotify(){
						super();
					}
				}
			}
			SFUpfwmTfImpl fromUpfwmImpl = new SFUpfwmTfImpl();
			try
			{
				SFUpfwmTfImpl.SFUpfwmNotify fromNotify = fromUpfwmImpl._jj_param( fromUpfgkmHome );
				if( fromUpfgkmHome != null && fromUpfgkmHome.getCOMPLETE().size() > 0 ){
					OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( null, ISAProvision.S_TYPE );
					java.util.List _provision = HQSQLFactory.getOracle().retrieve( fromORACLE.getSchema(), fromNotify._sql.toString(), fromNotify._param );
					for( java.util.Iterator itera = _provision.iterator(); itera.hasNext(); ){
						DataStructInterface _datacontainer = (DataStructInterface)itera.next();
						HQSQLEntityBean fromSubJSQL = HQSQLUtils.ICustom.transfer( _datacontainer, fromORACLE );
						fromUpdfmx.getORDER().getSUBFLOW( fromORACLE.getSchema().getMapingEnty() ).add( fromSubJSQL );
					}
				}
			}
			finally{
				if( fromUpfwmImpl != null ){ fromUpfwmImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpdfmx;
	}
}
