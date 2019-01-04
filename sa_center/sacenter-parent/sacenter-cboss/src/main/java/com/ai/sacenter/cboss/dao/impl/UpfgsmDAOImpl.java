package com.ai.sacenter.cboss.dao.impl;

import java.rmi.RemoteException;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cboss.bo.IISARadiusIndex;
import com.ai.sacenter.cboss.bo.IISARadiusX;
import com.ai.sacenter.cboss.dao.interfaces.IUpfgsmDAO;
import com.ai.sacenter.cboss.util.IUpfgsmUtils;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmOffer;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmOrder;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmRocket;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLTable;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRabbit;
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
 * <p>Copyright: Copyright (c) 2011-10-26</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfgsmDAOImpl extends ISystemDAOImpl implements IUpfgsmDAO{
	public UpfgsmDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.impl.ISystemDAOImpl#finish(java.util.List)
	 */
	public void finish(java.util.List fromUpfwm) throws RemoteException, Exception {
		try
		{
			class SFUpfgsmDAOImpl{
				public SFUpfgsmDAOImpl(){
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
				public IOVUpfwmRabbit getSFUpfgsmHome(MBeanDelegate fromMBean,
						java.util.List fromUpfwm, 
						IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
					IOVUpfwmRabbit fromUpfgsmHome = null;
					try
					{
						IOVUpfwmRabbit.IUpfwmNotify fromNotify = null;
						for( java.util.Iterator itera = fromUpfwm.iterator(); itera.hasNext(); ){
							IOVUpfgsmOffer fromUpffmx = IUpfgsmUtils.ICustom._jj_miscnotify( itera.next() );
							if( fromUpffmx == null ){ continue; }
							if( fromUpfgsmHome == null ){ fromUpfgsmHome = new IOVUpfwmRabbit( fromUpffm ); }
							fromNotify = IUpfgsmUtils.ICustom._jj_notify( fromMBean, fromUpffmx, fromUpffm );
							if( fromUpfgsmHome.getINDEX( fromNotify.getINDEX() ) == null ){
								fromUpfgsmHome.getINDEX().put( fromNotify.getINDEX(), fromNotify );
							}
							fromUpfgsmHome.getINDEX( fromNotify.getINDEX() ).getSUBFLOW().add( fromUpffmx.getINSTANCE() );
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
				public IOVUpfwmNotify finishSFUpfgsmIndex( MBeanDelegate fromMBean,
						IOVUpfwmRabbit.IUpfwmNotify fromNotify, 
						IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException,Exception{
					IOVUpfwmNotify fromINDEX = null;
					try
					{
						fromINDEX = UpfwmUtils.ICustom._wrap(fromMBean, fromNotify, fromUpffm);
						for( java.util.Iterator itera = fromNotify.getSUBFLOW().iterator(); itera.hasNext(); ){
							DataStructInterface fromEntity = (DataStructInterface)itera.next();
							fromEntity.set( IISARadiusIndex.S_SubPlanNo, java.math.BigDecimal.valueOf( 
									fromINDEX.getORDER_ID() ) );
						}
					}
					finally{
						
					}
					return fromINDEX;
				}
			}
			SFUpfgsmDAOImpl fromUpfgsmImpl = new SFUpfgsmDAOImpl();
			IOVUpfwmRabbit fromUpfgsmHome = null;
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
				fromUpfgsmHome = fromUpfgsmImpl.getSFUpfgsmHome(fromMBean, fromUpfwm, fromUpffm);
				if( fromUpfgsmHome != null && fromUpfgsmHome.getINDEX().size() > 0 ){
					IOVUpfwmRabbit.IUpfwmNotify fromNotifyHome = null;
					for( java.util.Iterator itera = fromUpfgsmHome.getINDEX().values().iterator(); itera.hasNext(); ){
						fromNotifyHome = (IOVUpfwmRabbit.IUpfwmNotify)itera.next();
						IOVUpfwmNotify fromINDEX = fromUpfgsmImpl.finishSFUpfgsmIndex(fromMBean, 
								fromNotifyHome, 
								fromUpffm);
						fromUpfwm.add( fromINDEX.getINSTANCE() );
					}
				}
				super.finish( fromUpfwm );
			}
			finally{
				if( fromUpfgsmHome != null ){ fromUpfgsmHome = null; }
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
		
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.dao.interfaces.IUpfgsmDAO#getSFNotifyPassage(com.ai.sacenter.valuebean.IUpfgkmCityHome)
	 */
	public IUpfgkmCityHome getSFNotifyPassage(IUpfgkmCityHome fromUpfgkmHome) throws RemoteException, Exception {
		class SFUpfgsmTfImpl{
			public SFUpfgsmTfImpl(){
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
			public SFUpfgsmNotify _jj_param( IUpfgkmCityHome fromSubCity ) throws SFException,Exception{
				SFUpfgsmNotify _notify = new SFUpfgsmNotify();
				java.util.List fromNAME = new java.util.ArrayList();
				try
				{
					for( int index = 0; fromSubCity != null && index < fromSubCity.getCOMPLETE().size(); index++ ){
						IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)fromSubCity.getCOMPLETE().get( index );
						String fromINDEX = ClassUtils.getINDEX( new String[]{ "SUB_PLAN_NO_" , String.valueOf( index ) } );
						fromNAME.add ( ClassUtils.getINDEX( new String[]{ ":", fromINDEX }   ) );
						_notify._param.put( fromINDEX  , new Long( fromNotify.getORDER_ID() ) );
						_notify._param.put( "REGION_ID", fromNotify.getREGION_ID           () );
						_notify._param.put( "CATEGORY" , fromNotify.getCATEGORY            () );
					}
					_notify._index.append(" SUB_PLAN_NO IN ( ");
					_notify._index.append( StringUtils.join( fromNAME.iterator(), " , " ) )
					              .append(" ) order by SO_NBR ");
					_notify._extend.append(" SUB_PLAN_NO IN ( ");
					_notify._extend.append( StringUtils.join( fromNAME.iterator(), " , " ) )
					               .append(" ) order by MSO_NBR , SORT_BY , SO_NBR ");
				}
				finally{
					if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
				}
				return _notify;
			}
			
			/**
			 * 
			 * @param fromSubSQL
			 * @param fromSubCity
			 * @throws SFException
			 * @throws Exception
			 */
			public void finishSFUpfgsmExtend( ISubTableTemplate.ISubSQLGroup fromSubSQL, IUpfgkmCityHome fromSubCity, SFUpfgsmNotify fromNotify ) throws SFException,Exception{
				java.util.HashMap _tables = new java.util.HashMap();
				try
				{
					for( java.util.Iterator itera = fromSubSQL.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						ISubTableTemplate.ISubSQLTable fromSubJect = (ISubTableTemplate.ISubSQLTable)itera.next();
						if( StringUtils.isBlank( fromSubJect.getMULTIPLE() ) ){ continue; }
						if( _tables.get( fromSubJect.getMULTIPLE() ) == null ){
							OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( null, fromSubJect.getMULTIPLE() );
							_tables.put( fromSubJect.getMULTIPLE(), fromORACLE );
						}
					}
					for( java.util.Iterator itera = _tables.entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
						String _table_name = (String)fromEntry.getKey();
						java.util.List _provision = HQSQLFactory.getOracle().retrieve(_table_name, 
								fromNotify._index.toString(), 
								fromNotify._param );
						for( java.util.Iterator iterap = _provision.iterator(); iterap.hasNext(); ){
							DataStructInterface __provision = (DataStructInterface)iterap.next();
							IOVUpfgsmRocket ___provision = (IOVUpfgsmRocket)IUpfgsmUtils.ICustom._jj_miscoffer( __provision );
							fromNotify.getSUBJECT( ___provision ).add( ___provision );
						}
					}
				}
				finally{
					if( _tables != null ){ _tables.clear(); _tables = null; }
				}
			}
			
			/**
			 * 
			 * @param fromNotify
			 * @param fromSubJect
			 * @param fromUpdfmx
			 * @throws SFException
			 * @throws Exception
			 */
			public void finishSFUpfgsmNotify( SFUpfgsmNotify fromNotify, ISubTableTemplate.ISubSQLTable fromSubJect, IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
				try
				{
					ISystemTemplate.IUpfgkmComposite fromSubSQL = null;
					fromSubSQL = HQSQLUtils.ISystem.getSFUpfgkmTable( fromSubJect.getTABLE() );
					ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( fromSubSQL.getPERSISTENT() );
					java.util.List _provision = HQSQLFactory.getOracle().retrieve(fromTYPE, fromNotify._index.toString(), fromNotify._param );
					for( java.util.Iterator itera = _provision.iterator(); itera.hasNext(); ){
						DataStructInterface __provision = (DataStructInterface)itera.next();
						IOVUpfgsmOffer fromINDEX = IUpfgsmUtils.ICustom._jj_miscoffer( __provision );
						if( StringUtils.isBlank( fromSubJect.getMULTIPLE() ) == false ){
							fromNotify._jj_subject( fromSubJect, fromINDEX );
						}
						fromUpdfmx.getORDER().getSUBFLOW( fromINDEX.getSUB_PLAN_NO() ).add( fromINDEX );
					}
				}
				finally{
					
				}
			}
			class SFUpfgsmNotify{
				StringBuilder _index  = new StringBuilder();
				StringBuffer  _extend = new StringBuffer (); 
				java.util.HashMap _param  = new java.util.HashMap();
				java.util.HashMap _subject = new java.util.HashMap();
				public SFUpfgsmNotify(){
					super();
				}
				
				/**
				 * 
				 * @param fromRocket
				 * @return
				 * @throws Exception
				 */
				public java.util.List<IOVUpfgsmRocket> getSUBJECT( IOVUpfgsmRocket fromRocket ) throws Exception{
					java.util.List<IOVUpfgsmRocket> _tables = null;
					ObjectType _table = fromRocket.getINSTANCE().getObjectType();
					String fromINDEX = ClassUtils.getINDEX( new String[]{ _table.getMapingEnty(), ".", String.valueOf( fromRocket.getMSO_NBR() ) });
					_tables = (java.util.List<IOVUpfgsmRocket>)_subject.get( fromINDEX );
					if( _tables == null ){ _subject.put( fromINDEX, _tables = new java.util.ArrayList<IOVUpfgsmRocket>() ); }
					return _tables;
				}
				
				/**
				 * 
				 * @param fromSubJect
				 * @param fromINDEX
				 * @throws SFException
				 * @throws Exception
				 */
				public void _jj_subject( ISubTableTemplate.ISubSQLTable fromSubJect, IOVUpfgsmOffer fromINDEX ) throws SFException,Exception{
					try
					{
						String _index = ClassUtils.getINDEX( new String[]{ fromSubJect.getMULTIPLE(), ".", String.valueOf( fromINDEX.getSO_NBR() ) });
						java.util.List<IOVUpfgsmRocket> _tables = (java.util.List<IOVUpfgsmRocket>)_subject.get( _index );
						if( _tables != null && _tables.size() > 0 ){ 
							for( java.util.Iterator<IOVUpfgsmRocket> itera = _tables.iterator(); itera.hasNext(); ){
								IOVUpfgsmRocket fromRocket = (IOVUpfgsmRocket)itera.next();
								fromINDEX.getLittle().getLITTLE().add( fromRocket );
							}
						}
					}
					finally{
						
					}
				}
			}
		}
		SFUpfgsmTfImpl fromUpfgsmImpl = new SFUpfgsmTfImpl();
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
			ISubTableTemplate.ISubSQLGroup fromSubSQL = HQSQLUtils.ISystem.getSFSubTableGroup( fromUpffm.getID() );
			SFUpfgsmTfImpl.SFUpfgsmNotify _jj_notify = fromUpfgsmImpl._jj_param( fromUpfgkmHome );
			if( fromSubSQL != null && fromSubSQL.getSUBFLOW().size() > 0 ){
				IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfgkmHome );
				fromUpfgsmImpl.finishSFUpfgsmExtend( fromSubSQL, fromUpfgkmHome, _jj_notify );
				for( java.util.Iterator itera = fromSubSQL.getSUBFLOW().values().iterator(); itera.hasNext(); ){
					ISubTableTemplate.ISubSQLTable fromSubJect = (ISubTableTemplate.ISubSQLTable)itera.next();
					fromUpfgsmImpl.finishSFUpfgsmNotify( _jj_notify, fromSubJect, fromUpdfmx );
				}
				
				for( java.util.Iterator<IOVUpfwmNotify> itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)itera.next();
					CarbonList<IOVUpfgsmOrder> _jj_provision = fromUpdfmx.getORDER().getSUBFLOW( fromNotify.getORDER_ID() );
					for( java.util.Iterator<IOVUpfgsmOrder> iterap = _jj_provision.iterator(); iterap.hasNext(); ){
						IOVUpfgsmOrder __provision = (IOVUpfgsmOrder)iterap.next();
						fromNotify.getLittle().getLITTLE().add( __provision );
					}
				}
			}
		}
		finally{
			if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
		}
		return fromUpfgkmHome;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.dao.interfaces.IUpfgsmDAO#getSFNotifyLimite(com.ai.sacenter.valuebean.IUpfgkmCityHome)
	 */
	public IOVUpdfmxOffer getSFNotifyLimite(IUpfgkmCityHome fromUpfgkmHome) throws RemoteException, Exception {
		IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromUpfgkmHome );
		try
		{
			class SFUpfgsmTfImpl{
				public SFUpfgsmTfImpl(){
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
				public SFUpfgsmNotify _jj_param( IUpfgkmCityHome fromSubCity ) throws SFException,Exception{
					SFUpfgsmNotify _notify = new SFUpfgsmNotify();
					java.util.List fromNAME = new java.util.ArrayList();
					try
					{
						for( int index = 0; fromSubCity != null && index < fromSubCity.getCOMPLETE().size(); index++ ){
							IOVUpfwmNotify fromNotify = (IOVUpfwmNotify)fromSubCity.getCOMPLETE().get( index );
							String fromINDEX = ClassUtils.getINDEX( new String[]{ "SUB_PLAN_NO_" , String.valueOf( index ) } );
							fromNAME.add ( ClassUtils.getINDEX( new String[]{ ":", fromINDEX }   ) );
							_notify._param.put( fromINDEX  , new Long( fromNotify.getORDER_ID() ) );
							_notify._param.put( "REGION_ID", fromNotify.getREGION_ID           () );
							_notify._param.put( "CATEGORY" , fromNotify.getCATEGORY            () );
						}
						_notify._index.append(" SUB_PLAN_NO IN ( ");
						_notify._index.append( StringUtils.join( fromNAME.iterator(), " , " ) )
						              .append(" ) order by SO_NBR ");
						_notify._extend.append(" SUB_PLAN_NO IN ( ");
						_notify._extend.append( StringUtils.join( fromNAME.iterator(), " , " ) )
						               .append(" ) order by MSO_NBR , SORT_BY , SO_NBR ");
					}
					finally{
						if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
					}
					return _notify;
				}
				
				/**
				 * 
				 * @param fromSubSQL
				 * @param fromSubCity
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfgsmExtend( ISubTableTemplate.ISubSQLGroup fromSubSQL, 
						IUpfgkmCityHome fromSubCity, 
						SFUpfgsmNotify fromNotify ) throws SFException,Exception{
					java.util.HashMap _tables = new java.util.HashMap();
					try
					{
						for( java.util.Iterator itera = fromSubSQL.getSUBFLOW().values().iterator(); itera.hasNext(); ){
							ISubTableTemplate.ISubSQLTable fromSubJect = (ISubTableTemplate.ISubSQLTable)itera.next();
							if( StringUtils.isBlank( fromSubJect.getMULTIPLE() ) ){ continue; }
							if( _tables.get( fromSubJect.getMULTIPLE() ) == null ){
								OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( null, fromSubJect.getMULTIPLE() );
								_tables.put( fromSubJect.getMULTIPLE(), fromORACLE );
							}
						}
						for( java.util.Iterator itera = _tables.entrySet().iterator(); itera.hasNext(); ){
							java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
							String _table_name = (String)fromEntry.getKey();
							OracleHQSQLTable fromORACLE = (OracleHQSQLTable)fromEntry.getValue();
							java.util.List _provision = HQSQLFactory.getOracle().retrieve(_table_name, 
									fromNotify._index.toString(), 
									fromNotify._param );
							for( java.util.Iterator iterap = _provision.iterator(); iterap.hasNext(); ){
								DataStructInterface _datacontainer = (DataStructInterface)iterap.next();
								HQSQLEntityBean fromSubJSQL = HQSQLUtils.ICustom.transfer( _datacontainer, fromORACLE );
								fromNotify.getSUBJECT( fromSubJSQL ).add( fromSubJSQL );
							}
						}
					}
					finally{
						if( _tables != null ){ _tables.clear(); _tables = null; }
					}
				}
				
				/**
				 * 
				 * @param fromNotify
				 * @param fromSubJect
				 * @param fromUpdfmx
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfgsmNotify( SFUpfgsmNotify fromNotify,
						ISubTableTemplate.ISubSQLTable fromSubJect, 
						IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
					try
					{
						ISystemTemplate.IUpfgkmComposite fromSubSQL = null;
						fromSubSQL = HQSQLUtils.ISystem.getSFUpfgkmTable( fromSubJect.getTABLE() );
						ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( fromSubSQL.getPERSISTENT() );
						OracleHQSQLTable fromORACLE = HQSQLUtils.getOracleTable( null, fromSubJect.getTABLE() );
						java.util.List _provision = HQSQLFactory.getOracle().retrieve(fromTYPE, fromNotify._index.toString(), fromNotify._param );
						for( java.util.Iterator itera = _provision.iterator(); itera.hasNext(); ){
							DataStructInterface _datacontainer = (DataStructInterface)itera.next();
							HQSQLEntityBean fromSubJSQL = HQSQLUtils.ICustom.transfer( _datacontainer, fromORACLE );
							if( StringUtils.isBlank( fromSubJect.getMULTIPLE() ) == false ){
								fromNotify._jj_subject( fromSubJect, fromSubJSQL );
							}
							fromUpdfmx.getORDER().getSUBFLOW( fromTYPE.getMapingEnty() ).add( fromSubJSQL );
						}
					}
					finally{
						
					}
				}
				class SFUpfgsmNotify{
					StringBuilder _index  = new StringBuilder();
					StringBuffer  _extend = new StringBuffer (); 
					java.util.HashMap _param  = new java.util.HashMap();
					java.util.HashMap _subject = new java.util.HashMap();
					public SFUpfgsmNotify(){
						super();
					}
					
					/**
					 * 
					 * @param fromSubJSQL
					 * @return
					 */
					public java.util.List getSUBJECT( HQSQLEntityBean fromSubJSQL ){
						java.util.List _tables = null;
						HQSQLTable fromTable = fromSubJSQL.getObjectType();
						long _mso_nbr = fromSubJSQL.getAsLong( IISARadiusX.S_MsoNbr );
						String fromINDEX = ClassUtils.getINDEX( new String[]{ fromTable.getMapingEnty(), ".", String.valueOf( _mso_nbr ) });
						_tables = (java.util.List)_subject.get( fromINDEX );
						if( _tables == null ){ _subject.put( fromINDEX, _tables = new java.util.ArrayList() ); }
						return _tables;
					}
					
					/**
					 * 
					 * @param fromSubJect
					 * @param fromINDEX
					 * @throws SFException
					 * @throws Exception
					 */
					public void _jj_subject( ISubTableTemplate.ISubSQLTable fromSubJect, HQSQLEntityBean fromINDEX ) throws SFException,Exception{
						try
						{
							java.util.List _tables = null;
							long _so_nbr = fromINDEX.getAsLong( IISARadiusIndex.S_SoNbr );
							String _index = ClassUtils.getINDEX( new String[]{ fromSubJect.getMULTIPLE(), ".", String.valueOf( _so_nbr ) });
							_tables = (java.util.List)_subject.get( _index );
							if( _tables != null ){ 
								for( java.util.Iterator itera = _tables.iterator(); itera.hasNext(); ){
									HQSQLEntityBean fromSubJSQL = (HQSQLEntityBean)itera.next();
									fromINDEX.getLittle().getLittle().add( fromSubJSQL );
								}
							}
						}
						finally{
							
						}
					}
				}
			}
			SFUpfgsmTfImpl fromUpfgsmImpl = new SFUpfgsmTfImpl();
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				fromUpffm = CenterUtils.ICustom.getSFCenterNetWork( getClass().getName() );
				ISubTableTemplate.ISubSQLGroup fromSubSQL = HQSQLUtils.ISystem.getSFSubTableGroup( fromUpffm.getID() );
				SFUpfgsmTfImpl.SFUpfgsmNotify fromNotify = fromUpfgsmImpl._jj_param( fromUpfgkmHome );
				if( fromSubSQL != null && fromSubSQL.getSUBFLOW().size() > 0 ){
					fromUpfgsmImpl.finishSFUpfgsmExtend( fromSubSQL, fromUpfgkmHome, fromNotify );
					for( java.util.Iterator itera = fromSubSQL.getSUBFLOW().values().iterator(); itera.hasNext(); ){
						ISubTableTemplate.ISubSQLTable fromSubJect = (ISubTableTemplate.ISubSQLTable)itera.next();
						fromUpfgsmImpl.finishSFUpfgsmNotify(fromNotify, fromSubJect, fromUpdfmx);
					}
				}
			}
			finally{
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
 		finally{
			
		}
		return fromUpdfmx;
	}
}
