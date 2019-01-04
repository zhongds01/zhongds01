package com.ai.sacenter.cboss.service.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.cboss.IUpfgsmConst;
import com.ai.sacenter.cboss.UpfgsmFactory;
import com.ai.sacenter.cboss.bo.IISARadiusIndex;
import com.ai.sacenter.cboss.bo.ISARadiusHis;
import com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV;
import com.ai.sacenter.cboss.util.IUpfgsmUtils;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmBrand;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmHistory;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmMcas;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmRadius;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmStatus;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFOLQException;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.provision.valuebean.IOVUpfwmUnique;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxUnique;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;
import com.ai.sacenter.valuebean.IUpfgsmTemplate;

public class UpfgsmSRVImpl extends UpdcEclipseImpl implements IUpfgsmSRV {
	public UpfgsmSRVImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV#finishSFUpfgkmOffer(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfgkmOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpfgsmRadiusImpl extends SFUpffxMiscImpl{
				public SFUpfgsmRadiusImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmOffer finishSFUpfgsmSync( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
			            IUpdcContext aContext) throws SFException, Exception{
					IOVUpfwmOffer fromUpfwm = null;
					try
					{
						IOVUpfwmUnique fromUnique = null;
						fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder,
								fromTASK, 
								fromUpdfwm,
								aContext);
						IOVUpfgsmRadius fromINDEX = IUpfgsmUtils.ICustom._jf_miscoffer(fromOrder, 
								fromTASK, 
								fromUpdfwm,
								fromUnique,
								fromUpfwm, 
								aContext );
						if( fromTASK.isPARALLEL() == false /*正式割接*/){
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromUpfwm.getORDER().getREPOSITORY(), 
									fromINDEX );
						}
						fromUpfwm.getORDER().setPASSIVE( fromINDEX );
					}
					finally{
						
					}
					return fromUpfwm;
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param fromUpfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmComplete(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
						IOVUpfwmOffer fromUpfwm,
						IUpdcContext aContext ) throws SFException, Exception{
					IOVUpfgsmHistory fromHISTORY = null;
					try
					{
						fromHISTORY = IUpfgsmUtils.ICustom._jj_mischistory(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								aContext);
						UpfsvcManager.getSession().submitISQLLite( fromTASK,
								fromUpfwm.getORDER().getREPOSITORY(), 
								fromHISTORY );
						if( fromHISTORY.isCREATE() /*等待网元反馈流程*/){
							IUpfwmFactory.getIUpffmSV().finishSFUpfwmComplete(fromOrder, 
									fromTASK, 
									fromUpdfwm, 
									fromUpfwm, 
									aContext);
						}
					}
					finally{
						if( fromHISTORY != null ){ fromHISTORY = null; }
					}
				}
			}
			SFUpfgsmRadiusImpl fromUpfgsmImpl = new SFUpfgsmRadiusImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = fromUpfgsmImpl.finishSFUpfgsmSync(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				fromUpfgsmImpl.finishSFUpfwmComplete(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV#finishSFUpfgxmOffer(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfgxmOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpfgsmMcasImpl extends SFUpffxMiscImpl{
				public SFUpfgsmMcasImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmOffer finishSFUpfgsmSync( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
			            IUpdcContext aContext) throws SFException, Exception{
					IOVUpfwmOffer fromUpfwm = null;
					try
					{
						IOVUpfwmUnique fromUnique = null;
						fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder,
								fromTASK, 
								fromUpdfwm,
								aContext);
						IOVUpfgsmMcas fromINDEX = IUpfgsmUtils.ICustom._jf_mcasoffer(fromOrder, 
								fromTASK, 
								fromUpdfwm,
								fromUnique,
								fromUpfwm, 
								aContext);
						if( fromTASK.isPARALLEL() == false /*正式割接*/){
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromUpfwm.getORDER().getREPOSITORY(), 
									fromINDEX );
						}
						fromUpfwm.getORDER().setPASSIVE( fromINDEX );
					}
					finally{
						
					}
					return fromUpfwm;
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param fromUpfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmComplete(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
						IOVUpfwmOffer fromUpfwm,
						IUpdcContext aContext ) throws SFException, Exception{
					IOVUpfgsmHistory fromHISTORY = null;
					try
					{
						fromHISTORY = IUpfgsmUtils.ICustom._jj_mcashistory(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								aContext);
						UpfsvcManager.getSession().submitISQLLite( fromTASK,
								fromUpfwm.getORDER().getREPOSITORY(), 
								fromHISTORY );
					}
					finally{
						if( fromHISTORY != null ){ fromHISTORY = null; }
					}
				}
			}
			SFUpfgsmMcasImpl fromUpfgsmImpl = new SFUpfgsmMcasImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = fromUpfgsmImpl.finishSFUpfgsmSync(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				fromUpfgsmImpl.finishSFUpfwmComplete(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV#finishSFUpfgsmStatus(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfgsmStatus(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpfgsmMiscImpl extends SFUpffxMiscImpl{
				public SFUpfgsmMiscImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmOffer finishSFUpfgsmSync( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
			            IUpdcContext aContext) throws SFException, Exception{
					IOVUpfwmUnique fromUpfwm = null;
					try
					{
						fromUpfwm = _jj_uniquestatus(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								aContext );
						IOVUpfgsmStatus fromINDEX = IUpfgsmUtils.ICustom._jf_allsts(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								aContext);
						if( fromTASK.isPARALLEL() == false /*正式割接*/){
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromUpfwm.getPROVISION().getORDER().getREPOSITORY(), 
									fromINDEX );
						}
						fromUpfwm.getPROVISION().getORDER().setPASSIVE( fromINDEX );
					}
					finally{
						
					}
					return fromUpfwm.getPROVISION();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param fromUpfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmComplete(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
						IOVUpfwmOffer fromUpfwm,
						IUpdcContext aContext ) throws SFException, Exception{
					IOVUpfgsmHistory fromHISTORY = null;
					try
					{
						fromHISTORY = IUpfgsmUtils.ICustom._jj_statushistory(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								aContext);
						UpfsvcManager.getSession().submitISQLLite( fromTASK,
								fromUpfwm.getORDER().getREPOSITORY(), 
								fromHISTORY );
					}
					finally{
						if( fromHISTORY != null ){ fromHISTORY = null; }
					}
				}
			}
			SFUpfgsmMiscImpl fromUpfgsmImpl = new SFUpfgsmMiscImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = fromUpfgsmImpl.finishSFUpfgsmSync(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				fromUpfgsmImpl.finishSFUpfwmComplete(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV#finishSFUpfgsmBrand(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfgsmBrand(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpfgsmMiscImpl{
				public SFUpfgsmMiscImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmOffer finishSFUpfgsmSync( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
			            IUpdcContext aContext) throws SFException, Exception{
					IOVUpfwmOffer fromUpfwm = null;
					try
					{
						fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder,
								fromTASK, 
								fromUpdfwm,
								aContext);
						IOVUpfgsmBrand fromINDEX = IUpfgsmUtils.ICustom._jf_brandchg(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								aContext);
						if( fromTASK.isPARALLEL() == false /*正式割接*/){
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromUpfwm.getORDER().getREPOSITORY(), 
									fromINDEX );
						}
						fromUpfwm.getORDER().setPASSIVE( fromINDEX );
					}
					finally{
						
					}
					return fromUpfwm;
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param fromUpfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmComplete(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
						IOVUpfwmOffer fromUpfwm,
						IUpdcContext aContext ) throws SFException, Exception{
					IOVUpfgsmHistory fromHISTORY = null;
					try
					{
						fromHISTORY = IUpfgsmUtils.ICustom._jj_brandhistory(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								aContext);
						UpfsvcManager.getSession().submitISQLLite( fromTASK,
								fromUpfwm.getORDER().getREPOSITORY(), 
								fromHISTORY );
					}
					finally{
						if( fromHISTORY != null ){ fromHISTORY = null; }
					}
				}
			}
			SFUpfgsmMiscImpl fromUpfgsmImpl = new SFUpfgsmMiscImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = fromUpfgsmImpl.finishSFUpfgsmSync(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				fromUpfgsmImpl.finishSFUpfwmComplete(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV#finishSFUpfgkmPassive(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpfgkmPassive(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext)throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpfgsmMiscImpl extends SFUpffxMiscImpl{
				public SFUpfgsmMiscImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmOffer finishSFUpfgsmSync( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
			            IUpdcContext aContext) throws SFException, Exception{
					IOVUpfwmOffer fromUpfwm = null;
					try
					{
						fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder,
								fromTASK, 
								fromUpdfwm,
								aContext);
						IOVUpfwmUnique fromUnique = _jj_uniquestatus(fromOrder, 
								fromTASK, 
								fromUpdfwm,
								fromUpfwm,
								aContext);
						IOVUpfgsmRadius fromINDEX = IUpfgsmUtils.ICustom._jf_miscosstatus(fromOrder, 
								fromTASK, 
								fromUpdfwm,
								fromUnique,
								fromUpfwm, 
								aContext );
						if( fromTASK.isPARALLEL() == false /*正式割接*/){
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromUpfwm.getORDER().getREPOSITORY(), 
									fromINDEX );
						}
						fromUpfwm.getORDER().setPASSIVE( fromINDEX );
					}
					finally{
						
					}
					return fromUpfwm;
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param fromUpfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmComplete(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
						IOVUpfwmOffer fromUpfwm,
						IUpdcContext aContext ) throws SFException, Exception{
					IOVUpfgsmHistory fromHISTORY = null;
					try
					{
						fromHISTORY = IUpfgsmUtils.ICustom._jj_mischistory(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								aContext);
						fromHISTORY.setPS_STATUS( IUpfwmConst.IUpdos.SUCCEED );
						UpfsvcManager.getSession().submitISQLLite( fromTASK,
								fromUpfwm.getORDER().getREPOSITORY(), 
								fromHISTORY );
					}
					finally{
						if( fromHISTORY != null ){ fromHISTORY = null; }
					}
				}
			}
			SFUpfgsmMiscImpl fromUpfgsmImpl = new SFUpfgsmMiscImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = fromUpfgsmImpl.finishSFUpfgsmSync(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				fromUpfgsmImpl.finishSFUpfwmComplete(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV#finishSUpfgxmPassive(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSUpfgxmPassive(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFUpfgsmMiscImpl extends SFUpffxMiscImpl{
				public SFUpfgsmMiscImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpfwmOffer finishSFUpfgsmSync( IOVOrderPentium fromOrder,
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
			            IUpdcContext aContext) throws SFException, Exception{
					IOVUpfwmOffer fromUpfwm = null;
					try
					{
						fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder,
								fromTASK, 
								fromUpdfwm,
								aContext);
						IOVUpfwmUnique fromUnique = _jj_uniquestatus(fromOrder, 
								fromTASK, 
								fromUpdfwm,
								fromUpfwm, 
								aContext);
						IOVUpfgsmMcas fromINDEX = IUpfgsmUtils.ICustom._jf_mcasosstatus(fromOrder, 
								fromTASK, 
								fromUpdfwm,
								fromUnique,
								fromUpfwm, 
								aContext);
						if( fromTASK.isPARALLEL() == false /*正式割接*/){
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromUpfwm.getORDER().getREPOSITORY(), 
									fromINDEX );
						}
						fromUpfwm.getORDER().setPASSIVE( fromINDEX );
					}
					finally{
						
					}
					return fromUpfwm;
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfwm
				 * @param fromUpfwm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfwmComplete(IOVOrderPentium fromOrder, 
						IOVTaskPentium fromTASK, 
						IOVUpdspmLife fromUpdfwm,
						IOVUpfwmOffer fromUpfwm,
						IUpdcContext aContext ) throws SFException, Exception{
					IOVUpfgsmHistory fromHISTORY = null;
					try
					{
						fromHISTORY = IUpfgsmUtils.ICustom._jj_mcashistory(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								aContext);
						fromHISTORY.setPS_STATUS( IUpfwmConst.IUpdos.SUCCEED );
						UpfsvcManager.getSession().submitISQLLite( fromTASK,
								fromUpfwm.getORDER().getREPOSITORY(), 
								fromHISTORY );
					}
					finally{
						if( fromHISTORY != null ){ fromHISTORY = null; }
					}
				}
			}
			SFUpfgsmMiscImpl fromUpfgsmImpl = new SFUpfgsmMiscImpl();
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = fromUpfgsmImpl.finishSFUpfgsmSync(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				fromUpfgsmImpl.finishSFUpfwmComplete(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
			
		}
		return fromASK;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV#finishSFUpfgsmMisc(java.util.HashMap, com.ai.sacenter.IUpdcContext)
	 */
	public java.util.HashMap finishSFUpfgsmMisc(java.util.HashMap fromUpfwm, IUpdcContext aContext) throws SFException, Exception {
		java.util.HashMap fromUpffsm = new java.util.HashMap();
		try
		{
			String fromCATEGORY = fromUpfwm.get( IISARadiusIndex.S_BusiType ).toString();
			IUpfgsmTemplate.IUpfgsmOffer fromUpfgsm = IUpdcfgFactory.getIUpffmSV().getSFUpfgsmMisc( fromCATEGORY );
			if( fromUpfgsm != null && fromUpfgsm.getCOMPETENCE().size() > 0 ){
				for( java.util.Iterator itera = fromUpfgsm.getCOMPETENCE().iterator(); itera.hasNext(); ){
					IUpfgsmTemplate.IUpfgsmxOffer fromUpfgsmx = (IUpfgsmTemplate.IUpfgsmxOffer)itera.next();
					Object fromUpffx = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromUpfgsmx, fromUpfwm, aContext);
					if( fromUpffx != null ){ fromUpffsm.put( fromUpfgsmx.getMAPPING() , fromUpffx );}
				}
			}
		}
		finally{
			
		}
		return fromUpffsm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV#finishSFUpfgsmSync(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgsmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception {
		try
		{
			class SFUpfgsmSyncImpl{
				public SFUpfgsmSyncImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpfgsmSync( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome, IUpdcContext aContext) throws RemoteException, Exception{
					try
					{
						IOVUpdfmxOffer fromUpdfmx = UpfgsmFactory.getIUpfgsmDAO().getSFNotifyLimite(fromUpfgkmHome);
						if( fromUpdfmx != null && fromUpdfmx.getORDER().getSUBFLOW().size() > 0 ){
							for( java.util.Iterator itera = fromUpdfmx.getORDER().getSUBFLOW().values().iterator(); itera.hasNext(); ){
								CarbonList fromNotify = (CarbonList)itera.next();
								for( java.util.Iterator iterap = fromNotify.iterator(); iterap.hasNext(); ){
									HQSQLEntityBean fromSubJect = (HQSQLEntityBean)iterap.next();
									IUpfgsmUtils.ICustom._jj_extendx( fromSubJect );
								}
							}
							UpfgsmFactory.getIUpfgsmDAO().finish( fromUpdfmx.getORDER().getSUBFLOW() );
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpfgsmHistory( MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome, IUpdcContext aContext) throws RemoteException, Exception{
					try
					{
						for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)itera.next();
							UpfwmUtils.ICustom._wrap(fromMBean, null, fromINDEX);
							fromINDEX.getINSTANCE().setStsToOld();
							fromINDEX.getINSTANCE().delete();
							UpfsvcManager.getSession().submitISQLHistory( fromINDEX.getINSTANCE() );
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpfgsmConnection(  MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome, SFException aEXCEPTION, IUpdcContext aContext) throws RemoteException, Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)itera.next();
							UpfwmUtils.ICustom._wrap(fromMBean, aEXCEPTION, fromINDEX);
							UpfsvcManager.getSession().submitISQLLite( fromINDEX.getINSTANCE() );
						}
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						log.error( exception.getMessage(), exception );
						UpfsvcManager.getMBean().rollbackTransaction();
						throw exception;
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromUpfgkmHome
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpfgsmException(  MBeanDelegate fromMBean, IUpfgkmCityHome fromUpfgkmHome, SFException aEXCEPTION, IUpdcContext aContext) throws RemoteException, Exception{
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						for( java.util.Iterator itera = fromUpfgkmHome.getCOMPLETE().iterator(); itera.hasNext(); ){
							IOVUpfwmNotify fromINDEX = (IOVUpfwmNotify)itera.next();
							IUpfgkmCityHome fromCityHome = null;
							UpfsvcManager.getMBean().beginTransaction();
							try
							{
								fromCityHome = new IUpfgkmCityHome( fromINDEX.getREGION_ID() ) ;
								fromCityHome.getCOMPLETE().add( fromINDEX );
								finishSFUpfgsmSync(fromMBean, fromCityHome, aContext);
								finishSFUpfgsmHistory(fromMBean, fromCityHome, aContext);
								UpfsvcManager.getMBean().commitTransaction();
							}
							catch( java.lang.Exception exception ){
								log.error( exception.getMessage(), exception );
								UpfsvcManager.getMBean().rollbackTransaction();
								aEXCEPTION = ExceptionFactory.getException( exception );
								UpfwmUtils.ICustom._wrap(fromMBean, aEXCEPTION, fromINDEX);
								fromINDEX.getINSTANCE().setStsToOld();
								fromINDEX.getINSTANCE().delete();
								UpfsvcManager.getSession().submitISQLLifite( fromINDEX.getINSTANCE() );
							}
							finally{
								if( fromCityHome != null ){ fromCityHome = null; }
							}
						}
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						log.error( exception.getMessage(), exception );
						UpfsvcManager.getMBean().rollbackTransaction();
						throw exception;
					}
					finally{
						
					}
				}
			}
			SFUpfgsmSyncImpl fromUpfgsmImpl = new SFUpfgsmSyncImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try{
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				fromUpfgsmImpl.finishSFUpfgsmSync(fromMBean, 
						fromUpfgkmHome, 
						aContext);
				fromUpfgsmImpl.finishSFUpfgsmHistory(fromMBean, 
						fromUpfgkmHome, 
						aContext);
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( SFOLQException exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromUpfgsmImpl.finishSFUpfgsmConnection(fromMBean, 
						fromUpfgkmHome, 
						aEXCEPTION, 
						aContext);
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				fromMBean.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				fromUpfgsmImpl.finishSFUpfgsmException(fromMBean, 
						fromUpfgkmHome, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cboss.service.interfaces.IUpfgsmSRV#finishSFUpfgsmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.valuebean.IUpfgkmCityHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgsmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception {
		try
		{
			class SFUpfgsmReplyImpl{
				public SFUpfgsmReplyImpl(){
					super();
				}
				/**
				 * 
				 * @param fromMBean
				 * @param fromCouple
				 * @param aContext
				 * @throws RemoteException
				 * @throws Exception
				 */
				public void finishSFUpfgsmHistory(MBeanDelegate fromMBean,
						IOVUpfwmCouple fromCouple[], 
						IUpdcContext aContext) throws RemoteException, Exception{
					try
					{
						for( int index = 0; fromCouple != null && index < fromCouple.length; index++ ){
							IISAProvision fromHistory = new ISARadiusHis();
							fromHistory.setPsId        ( fromCouple[index].getPS_ID       () );  
							fromHistory.setRegionId    ( fromCouple[index].getREGION_ID   () );
							fromHistory.setCreateDate  ( fromCouple[index].getCREATE_DATE () );
							fromHistory.setStsToOld();
							UpfwmUtils.ICustom.transfer(fromCouple[index], fromHistory);
							UpfsvcManager.getSession().submitISQLLite( fromHistory );
						}
					}
					finally{
						
					}
				}
			}
			SFUpfgsmReplyImpl fromUpfgsmImpl = new SFUpfgsmReplyImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IOVUpfwmCouple fromCouple[] = null;
				fromCouple = (IOVUpfwmCouple[])fromUpfgkmHome.getCOMPLETE( IOVUpfwmCouple.class );
				fromUpfgsmImpl.finishSFUpfgsmHistory(fromMBean, 
						fromCouple, 
						aContext);
				if( fromCouple != null && fromCouple.length > 0 ){
					IUpfwmFactory.getIUpffmSV().finishSFUpfwmComplete(fromMBean,
							fromCouple, 
							aContext);
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
				throw exception;
			}
			finally{
				if( fromUpfgsmImpl != null ){ fromUpfgsmImpl = null; }
			}
		}
		finally{
			
		}
	}
}

class SFUpffxMiscImpl{
	public SFUpffxMiscImpl(){
		super();
	}
	
	/**
	 * 
	 * @param fromOrder
	 * @param fromTASK
	 * @param fromUpdfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmUnique _jj_uniquestatus( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
            IUpdcContext aContext) throws SFException, Exception{
		IOVUpfwmUnique __unique__ = null;
		try
		{
			IOVUpdfmxUnique fromUpdfmx = UpfsvcManager.getSession().getIUpfxUnique( SFUpffxMiscImpl.class.getName() );
			IOVUpfwmOffer fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder, fromTASK, fromUpdfwm, aContext);
			IOVUpfwmUnique ___unique___ = new IOVUpfwmUnique( IUpfgsmConst.ISubscribe.STATUS, fromUpfwm );
			__unique__ = (IOVUpfwmUnique)fromUpdfmx.getUNIQUE( ___unique___.getINDEX() );
			if( __unique__ != null ){
				IOVUpfwmOffer __provision__ = (IOVUpfwmOffer)__unique__.getPROVISION();
				__provision__.setBILL_ID      ( fromUpfwm.getBILL_ID	  () );   
				__provision__.setSUB_BILL_ID  ( fromUpfwm.getSUB_BILL_ID  () );
				__provision__.setCREATE_DATE  ( fromUpfwm.getCREATE_DATE  () );
				__provision__.setREGION_ID    ( fromUpfwm.getREGION_ID    () );
				__provision__.setPRIORITY     ( fromUpfwm.getPRIORITY	  () );
				__provision__.setPLATFORM     ( fromUpfwm.getPLATFORM	  () );
				__provision__.setDIRECTIVE    ( fromUpfwm.getDIRECTIVE    () );
				__provision__.setPROGRAM      ( fromUpfwm.getPROGRAM	  () );   
				__provision__.setOLD_PS_PARAM ( fromUpfwm.getOLD_PS_PARAM () );
				__provision__.setPS_PARAM     ( fromUpfwm.getPS_PARAM	  () );
				__provision__.setPS_STATUS    ( fromUpfwm.getPS_STATUS    () );
				__provision__.setSTOP_TYPE    ( fromUpfwm.getSTOP_TYPE    () );
				__provision__.setPS_NET_CODE  ( fromUpfwm.getPS_NET_CODE  () );
				__provision__.setSUB_PLAN_NO  ( fromUpfwm.getSUB_PLAN_NO  () );
				__provision__.setCOMPOSITE    ( fromUpfwm.getCOMPOSITE    () );
			}
			else{
				__unique__ = new IOVUpfwmUnique( ___unique___ );
				__unique__.setCOMPOSITE( IUpfgsmConst.ISubscribe.STATUS );
				__unique__.setPROVISION( fromUpfwm                      );
				fromUpdfmx.getUNIQUE().put( __unique__.getINDEX(), __unique__ );
			}
		}
		finally{
			
		}
		return __unique__;
	}
	
	/**
	 * 
	 * @param fromOrder
	 * @param fromTASK
	 * @param fromUpdfwm
	 * @param fromUpfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmUnique _jj_uniquestatus(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm,
            IUpdcContext aContext) throws SFException, Exception{
		IOVUpfwmUnique __unique__ = null;
		try
		{
			IOVUpdfmxUnique fromUpdfmx = UpfsvcManager.getSession().getIUpfxUnique( SFUpffxMiscImpl.class.getName() );
			IOVUpfwmUnique ___unique___ = new IOVUpfwmUnique( IUpfgsmConst.ISubscribe.STATUS, fromUpfwm );
			__unique__ = (IOVUpfwmUnique)fromUpdfmx.getUNIQUE( ___unique___.getINDEX() );
			if( __unique__ != null ){
				__unique__.getSUBFLOW().add( fromUpfwm );
			}
			else{
				IOVUpfwmOffer __provision__ = new IOVUpfwmOffer( fromUpfwm );
				__provision__.setPS_ID( UpfwmFactory.getIUpfwmDAO().getPS_ID() );
				__unique__ = new IOVUpfwmUnique( ___unique___ );
				__unique__.setCOMPOSITE( IUpfgsmConst.ISubscribe.STATUS );
				__unique__.setPROVISION( __provision__                  );
				__unique__.getSUBFLOW().add( fromUpfwm );
				fromUpdfmx.getUNIQUE().put( __unique__.getINDEX(), __unique__ );
			}
		}
		finally{
			
		}
		return __unique__;
	}
	
	/**
	 * 
	 * @param fromOrder
	 * @param fromTASK
	 * @param fromUpdfwm
	 * @param fromUpfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmUnique _jj_uniqueoffer(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmOffer fromUpfwm,
            IUpdcContext aContext) throws SFException, Exception{
		IOVUpfwmUnique fromUnique = null;
		IOVUpfgsmHistory fromHISTORY = null;
		try
		{
			IOVUpdfmxUnique fromUpdfmx = UpfsvcManager.getSession().getIUpfxUnique( SFUpffxMiscImpl.class.getName() );
			IOVUpfwmUnique ___unique___ = new IOVUpfwmUnique( fromUpfwm.getCOMPOSITE(), fromUpfwm );
			fromUnique = (IOVUpfwmUnique)fromUpdfmx.getUNIQUE( ___unique___.getINDEX() );
			if( fromUnique != null ){
				fromUnique.getSUBFLOW().add( fromUpfwm );
			}
			else{
				IOVUpfwmOffer __provision__ = new IOVUpfwmOffer( fromUpfwm );
				__provision__.setPS_ID ( UpfwmFactory.getIUpfwmDAO().getPS_ID() );
				fromUnique = new IOVUpfwmUnique( ___unique___ );
				fromUnique.setCOMPOSITE( IUpfgsmConst.ISubscribe.ORDER );
				fromUnique.setPROVISION( __provision__                  );
				fromHISTORY = _jj_miscstatus(fromOrder, fromTASK, fromUpdfwm, fromUnique, aContext);
				fromHISTORY.setCATEGORY   ( fromUpdfmx.getPLATFORM().getCATEGORY() );
				fromHISTORY.setPLATFORM   ( fromUpdfmx.getPLATFORM().getID      () );
				fromHISTORY.setDIRECTIVE  ( IUpfwmConst.IUpfwm.IUpffs.NORMAL       );
				fromHISTORY.setPROGRAM    ( null                                   );
				fromHISTORY.setPS_PARAM   ( null                                   );
				fromHISTORY.setPS_NET_CODE( null                                   );
				UpfsvcManager.getSession().submitISQLLite(fromTASK, 
						fromUnique.getPROVISION().getORDER().getREPOSITORY(), 
						fromHISTORY );
				fromUnique.getSUBFLOW().add( fromUpfwm );
				fromUpdfmx.getUNIQUE().put( fromUnique.getINDEX(), fromUnique );
			}
		}
		finally{
			if( fromHISTORY != null ){ fromHISTORY = null; }
		}
		return fromUnique;
	}
	
	/**
	 * 
	 * @param fromOrder
	 * @param fromTASK
	 * @param fromUpdfwm
	 * @param fromUnique
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	private IOVUpfgsmHistory _jj_miscstatus( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmUnique fromUnique,
            IUpdcContext aContext) throws SFException, Exception{
		IOVUpfgsmHistory fromHISTORY = null;
		try
		{
			fromHISTORY = IUpfgsmUtils.ICustom._jj_statushistory(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					fromUnique.getPROVISION(), 
					aContext);
			fromHISTORY.getLittle().setREPOSITORY( fromUnique.getPROVISION().getORDER().getREPOSITORY() );
			IOVUpfgsmStatus fromINDEX = IUpfgsmUtils.ICustom._jf_allsts(fromOrder, 
					fromTASK, 
					fromUpdfwm, 
					fromUnique, 
					aContext);
			if( fromTASK.isPARALLEL() == false /*正式割接*/){
				fromHISTORY.getLittle().getLITTLE().add( fromINDEX );
			}
			fromUnique.getPROVISION().getORDER().setPASSIVE( fromINDEX );
		}
		finally{
			
		}
		return fromHISTORY;
	}
}