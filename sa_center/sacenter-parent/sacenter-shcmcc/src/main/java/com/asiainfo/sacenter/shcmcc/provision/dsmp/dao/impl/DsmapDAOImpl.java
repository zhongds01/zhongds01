package com.asiainfo.sacenter.shcmcc.provision.dsmp.dao.impl;

import java.rmi.RemoteException;
import com.ai.appframe2.bo.DataContainer;
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
import com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.IISADsmpOrder;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.dao.interfaces.IDsmapDAO;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.util.IDsmapUtils;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê3ÔÂ20ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class DsmapDAOImpl extends ISystemDAOImpl implements IDsmapDAO {

	public DsmapDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.impl.ISystemDAOImpl#finish(java.util.List)
	 */
	public void finish(java.util.List fromUpfwm) throws RemoteException, Exception {
		try
		{
			class SFDsmapDAOImpl{
				public SFDsmapDAOImpl(){
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
							Object fromEntity = itera.next();
							if( IDsmapUtils.IIfElse.isPROVISION( fromEntity ) == false ) continue;
							fromNotify = IDsmapUtils.ISystem._jj_notify( fromMBean, (DataContainer)fromEntity, fromUpffm );
							if( fromUpfgsmHome.getINDEX( fromNotify.getINDEX() ) == null ){
								fromUpfgsmHome.getINDEX().put( fromNotify.getINDEX(), fromNotify );
							}
							fromUpfgsmHome.getINDEX( fromNotify.getINDEX() ).getSUBFLOW().add( fromEntity );
						}
					}
					finally{
						
					}
					return fromUpfgsmHome;
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromNotify
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
							DataStructInterface fromEntity = (DataStructInterface)itera.next();
							fromEntity.set( IISADsmpOrder.S_SubPlanNo, java.math.BigDecimal.valueOf( 
									fromINDEX.getORDER_ID() ) );
						}
					}
					finally{
						
					}
					return fromINDEX;
				}
			}
			SFDsmapDAOImpl fromUpfgkmImpl = new SFDsmapDAOImpl();
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
	 * @see com.asiainfo.sacenter.shcmcc.provision.dsmp.dao.interfaces.IDsmapDAO#getSFUpfgkmHome(com.ai.sacenter.valuebean.IUpfgkmCityHome)
	 */
	public IOVUpdfmxOffer getSFUpfgkmHome(IUpfgkmCityHome fromUpfgkmHome) throws RemoteException, Exception {
		IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfgkmHome );
		java.util.HashMap fromPARAM = new java.util.HashMap();
		java.util.List fromNAME = new java.util.ArrayList();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
			ISubTableTemplate.ISubSQLGroup fromSubSQL = HQSQLUtils.ISystem.getSFSubTableGroup( fromUpffm.getID() );
			for( int index = 0; fromUpfgkmHome != null && index < fromUpfgkmHome.getCOMPLETE().size(); index++ ){
				IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)fromUpfgkmHome.getCOMPLETE().get( index );
				String aINDEX = ClassUtils.getINDEX( new String[]{ "SUB_PLAN_NO_" , String.valueOf( index ) } );
				fromNAME.add ( ClassUtils.getINDEX( new String[]{ ":", aINDEX }   ) );
				fromPARAM.put( aINDEX        , new Long( fromINDEX.getORDER_ID   () ) );
				fromPARAM.put( "REGION_ID"   , fromINDEX.getREGION_ID              () );
				fromPARAM.put( "COMPOSITE"   , fromINDEX.getCATEGORY               () );
			}
			fromSQL.append(" SUB_PLAN_NO IN ( ");
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
			       .append(" ) order by SO_NBR ");
			if( fromSubSQL != null && fromSubSQL.getSUBFLOW().size() > 0 ){
				ISystemTemplate.IUpfgkmComposite fromSubSQLTable = null;
				for( java.util.Iterator itera = fromSubSQL.getSUBFLOW().values().iterator(); itera.hasNext(); ){
					ISubTableTemplate.ISubSQLTable fromSubJect = (ISubTableTemplate.ISubSQLTable)itera.next();
					fromSubSQLTable = HQSQLUtils.ISystem.getSFUpfgkmTable( fromSubJect.getTABLE() );
					OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( null, fromSubJect.getTABLE() );
					ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( fromSubSQLTable.getPERSISTENT() );
					java.util.List _provisions = HQSQLFactory.getSyBase().retrieve(getClass().getName(), 
							fromTYPE.getMapingEnty(), 
							fromSQL.toString(), 
							fromPARAM);
					for( java.util.Iterator iterap = _provisions.iterator(); iterap.hasNext(); ){
						HQSQLEntityBean fromSubJSQL = HQSQLUtils.ICustom.transfer( iterap.next(), fromORACLE );
						fromSubJSQL.setStsToOld();
						fromUpdfmx.getORDER().getSUBFLOW( fromTYPE.getMapingEnty() ).add( fromSubJSQL );
					}
				}
			}
		}
		finally{
			if( fromSQL != null ){ fromSQL = null; }
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromUpdfmx;
	}

}
