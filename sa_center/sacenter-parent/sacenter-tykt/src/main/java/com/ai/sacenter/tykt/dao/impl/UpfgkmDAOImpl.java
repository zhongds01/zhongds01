package com.ai.sacenter.tykt.dao.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLTable;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRabbit;
import com.ai.sacenter.tykt.bo.IISAEquipment;
import com.ai.sacenter.tykt.dao.interfaces.IUpfgkmDAO;
import com.ai.sacenter.tykt.util.IUpfgkmUtils;
import com.ai.sacenter.tykt.valuebean.IOVUpfgkmOffer;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISubTableTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-25</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfgkmDAOImpl extends ISystemDAOImpl implements IUpfgkmDAO {

	public UpfgkmDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.impl.ISystemDAOImpl#finish(java.util.List)
	 */
	public void finish(java.util.List fromUpfwm) throws RemoteException, Exception {
		try
		{
			class SFUpfgkmDAOImpl{
				public SFUpfgkmDAOImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfwm
				 * @param fromUpffm
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmRabbit getSFUpfgkmHome(MBeanDelegate fromMBean,
						java.util.List fromUpfwm, 
						IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
					IOVUpfwmRabbit fromUpfgsmHome = null;
					try
					{
						IOVUpfwmRabbit.IUpfwmNotify fromNotify = null;
						fromUpfgsmHome = new IOVUpfwmRabbit( fromUpffm );
						for( java.util.Iterator itera = fromUpfwm.iterator(); itera.hasNext(); ){
							IOVUpfgkmOffer fromINDEX = IUpfgkmUtils.ICustom._wrapWithLmst( itera.next() );
							if( fromINDEX == null || fromINDEX.getINSTANCE().isNew() == false ){ continue; }
							fromNotify = IUpfgkmUtils.ICustom._wrapWithNotify( fromMBean, fromINDEX, fromUpffm );
							if( fromNotify.isEXPIRE() && fromINDEX.getINSTANCE().isNew() ){
								if( fromUpfgsmHome.getINDEX( fromNotify.getINDEX() ) == null ){
									fromUpfgsmHome.getINDEX().put( fromNotify.getINDEX(), fromNotify );
								}
								fromUpfgsmHome.getINDEX( fromNotify.getINDEX() ).getSUBFLOW().add( fromINDEX.getINSTANCE() );
							}
						}
					}
					finally{
						
					}
					return fromUpfgsmHome;
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromNotifyHome
				 * @param fromUpffm
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmNotify finishSFUpfgkmIndex( MBeanDelegate fromMBean,
						IOVUpfwmRabbit.IUpfwmNotify fromNotify, 
						IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
					IOVUpfwmNotify fromINDEX = null;
					try
					{
						fromINDEX = UpfwmUtils.ICustom._wrap(fromMBean, fromNotify, fromUpffm);
						for( java.util.Iterator itera = fromNotify.getSUBFLOW().iterator(); itera.hasNext(); ){
							IISAEquipment fromEntity = (IISAEquipment)itera.next();
							fromEntity.setSubPlanNo( fromINDEX.getORDER_ID() );
						}
					}
					finally{
						
					}
					return fromINDEX;
				}
			}
			SFUpfgkmDAOImpl fromUpfgkmImpl = new SFUpfgkmDAOImpl();
			IOVUpfwmRabbit fromUpfgsmHome = null;
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
				fromUpfgsmHome = fromUpfgkmImpl.getSFUpfgkmHome(fromMBean, fromUpfwm, fromUpffm);
				if( fromUpfgsmHome != null && fromUpfgsmHome.getINDEX().size() > 0 ){
					for( java.util.Iterator itera = fromUpfgsmHome.getINDEX().values().iterator(); itera.hasNext(); ){
						IOVUpfwmRabbit.IUpfwmNotify fromNotify = (IOVUpfwmRabbit.IUpfwmNotify)itera.next();
						IOVUpfwmNotify fromINDEX = fromUpfgkmImpl.finishSFUpfgkmIndex(fromMBean, 
								fromNotify, 
								fromUpffm);
						fromUpfwm.add( fromINDEX.getINSTANCE() );
					}
				}
				super.finish( fromUpfwm );
			}
			finally{
				if( fromUpfgsmHome != null ){ fromUpfgsmHome = null; }
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.tykt.dao.interfaces.IUpfgkmDAO#getSFNotifyPassage(com.ai.sacenter.valuebean.IUpfgkmCityHome)
	 */
	public IUpfgkmCityHome getSFNotifyPassage(IUpfgkmCityHome fromUpfgkmHome) throws RemoteException, Exception {
		try
		{
			class SFUpfgkmTfImpl{
				public SFUpfgkmTfImpl(){
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
				public SFUpfgkmNotify _jj_param( IUpfgkmCityHome fromSubCity ) throws SFException,Exception{
					SFUpfgkmNotify _notify = new SFUpfgkmNotify();
					java.util.List fromNAME = new java.util.ArrayList();
					try
					{
						for( int index = 0; fromSubCity != null && index < fromSubCity.getCOMPLETE().size(); index++ ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)fromSubCity.getCOMPLETE().get( index );
							String aINDEX = ClassUtils.getINDEX( new String[]{ "SUB_PLAN_NO_" , String.valueOf( index ) } );
							fromNAME.add ( ClassUtils.getINDEX( new String[]{ ":", aINDEX }   ) );
							_notify._param.put( aINDEX        , new Long( fromINDEX.getORDER_ID   () ) );
							_notify._param.put( "REGION_ID"   , fromINDEX.getREGION_ID              () );
							_notify._param.put( "REGION_CODE" , fromINDEX.getREGION_ID              () );
							_notify._param.put( "COMPOSITE"   , fromINDEX.getCATEGORY               () );
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
				 * @param fromSubJect
				 * @param fromUpdfmx
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfgkmNotify( SFUpfgkmNotify fromNotify, ISubTableTemplate.ISubSQLTable fromSubJect, IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
					try
					{
						ISystemTemplate.IUpfgkmComposite fromSubSQL = null;
						fromSubSQL = HQSQLUtils.ISystem.getSFUpfgkmTable( fromSubJect.getTABLE() );
						ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( fromSubSQL.getPERSISTENT() );
						java.util.List _provision = HQSQLFactory.getOracle().retrieve(fromTYPE, fromNotify._sql.toString(), fromNotify._param );
						for( java.util.Iterator itera = _provision.iterator(); itera.hasNext(); ){
							IISAEquipment __provision = (IISAEquipment)itera.next();
							IOVUpfgkmOffer ___provision = new IOVUpfgkmOffer( __provision );
							fromUpdfmx.getORDER().getSUBFLOW( ___provision.getSUB_PLAN_NO() ).add( ___provision );
						}
					}
					finally{
						
					}
				}
				class SFUpfgkmNotify{
					StringBuilder _sql = new StringBuilder();
					java.util.HashMap _param  = new java.util.HashMap();
					public SFUpfgkmNotify(){
						super();
					}
				}
			}
			SFUpfgkmTfImpl fromUpfgkmTfImpl = new SFUpfgkmTfImpl();
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
				ISubTableTemplate.ISubSQLGroup fromSubSQL = HQSQLUtils.ISystem.getSFSubTableGroup( fromUpffm.getID() );
				SFUpfgkmTfImpl.SFUpfgkmNotify _jj_notify = fromUpfgkmTfImpl._jj_param( fromUpfgkmHome );
				if( fromSubSQL != null && fromSubSQL.getSUBFLOW().size() > 0 ){
					IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfgkmHome );
					for( java.util.Iterator itera = fromSubSQL.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						ISubTableTemplate.ISubSQLTable fromSubJect = (ISubTableTemplate.ISubSQLTable)itera.next();
						fromUpfgkmTfImpl.finishSFUpfgkmNotify( _jj_notify, fromSubJect, fromUpdfmx );
					}
					
					for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
						IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
						CarbonList<IOVUpfgkmOffer> _jj_provision = fromUpdfmx.getORDER().getSUBFLOW( fromNotify.getORDER_ID() );
						for( java.util.Iterator<IOVUpfgkmOffer> iterap = _jj_provision.iterator(); iterap.hasNext(); ){
							IOVUpfgkmOffer __provision = (IOVUpfgkmOffer)iterap.next();
							fromNotify.getLittle().getLITTLE().add( __provision );
						}
					}
				}
			}
			finally{
				if( fromUpfgkmTfImpl != null ){ fromUpfgkmTfImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpfgkmHome;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.tykt.dao.interfaces.IUpfgkmDAO#getSFNotifyLimite(com.ai.sacenter.valuebean.IUpfgkmCityHome)
	 */
	public IOVUpdfmxOffer getSFNotifyLimite(IUpfgkmCityHome fromUpfgkmHome) throws RemoteException, Exception {
		IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfgkmHome );
		try
		{
			class SFUpfgkmTfImpl{
				public SFUpfgkmTfImpl(){
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
				public SFUpfgkmNotify _jj_param( IUpfgkmCityHome fromSubCity ) throws SFException,Exception{
					SFUpfgkmNotify _notify = new SFUpfgkmNotify();
					java.util.List fromNAME = new java.util.ArrayList();
					try
					{
						for( int index = 0; fromSubCity != null && index < fromSubCity.getCOMPLETE().size(); index++ ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)fromSubCity.getCOMPLETE().get( index );
							String aINDEX = ClassUtils.getINDEX( new String[]{ "SUB_PLAN_NO_" , String.valueOf( index ) } );
							fromNAME.add ( ClassUtils.getINDEX( new String[]{ ":", aINDEX }   ) );
							_notify._param.put( aINDEX        , new Long( fromINDEX.getORDER_ID   () ) );
							_notify._param.put( "REGION_ID"   , fromINDEX.getREGION_ID              () );
							_notify._param.put( "REGION_CODE" , fromINDEX.getREGION_ID              () );
							_notify._param.put( "COMPOSITE"   , fromINDEX.getCATEGORY               () );
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
				 * @param fromSubJect
				 * @param fromUpdfmx
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfgkmNotify( SFUpfgkmNotify fromNotify,
						ISubTableTemplate.ISubSQLTable fromSubJect, 
						IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
					try
					{
						ISystemTemplate.IUpfgkmComposite fromSubSQL = null;
						fromSubSQL = HQSQLUtils.ISystem.getSFUpfgkmTable( fromSubJect.getTABLE() );
						ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( fromSubSQL.getPERSISTENT() );
						OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( null, fromSubJect.getTABLE() );
						java.util.List _provision = HQSQLFactory.getOracle().retrieve(fromTYPE, fromNotify._sql.toString(), fromNotify._param );
						for( java.util.Iterator itera = _provision.iterator(); itera.hasNext(); ){
							DataStructInterface _datacontainer = (DataStructInterface)itera.next();
							HQSQLEntityBean fromSubJSQL = HQSQLUtils.ICustom.transfer( _datacontainer, fromORACLE );
							fromUpdfmx.getORDER().getSUBFLOW( fromTYPE.getMapingEnty() ).add( fromSubJSQL );
						}
					}
					finally{
						
					}
				}
				class SFUpfgkmNotify{
					StringBuilder _sql = new StringBuilder();
					java.util.HashMap _param  = new java.util.HashMap();
					public SFUpfgkmNotify(){
						super();
					}
				}
			}
			SFUpfgkmTfImpl fromUpfgkmTfImpl = new SFUpfgkmTfImpl();
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
				ISubTableTemplate.ISubSQLGroup fromSubSQL = HQSQLUtils.ISystem.getSFSubTableGroup( fromUpffm.getID() );
				SFUpfgkmTfImpl.SFUpfgkmNotify fromNotify = fromUpfgkmTfImpl._jj_param( fromUpfgkmHome );
				if( fromSubSQL != null && fromSubSQL.getSUBFLOW().size() > 0 ){
					for( java.util.Iterator itera = fromSubSQL.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						ISubTableTemplate.ISubSQLTable fromSubJect = (ISubTableTemplate.ISubSQLTable)itera.next();
						fromUpfgkmTfImpl.finishSFUpfgkmNotify(fromNotify, fromSubJect, fromUpdfmx);
					}
				}
			}
			finally{
				if( fromUpfgkmTfImpl != null ){ fromUpfgkmTfImpl = null; }
			}
		}
		finally{
			
		}
		return fromUpdfmx;
	}
}
