package com.asiainfo.sacenter.shcmcc.provision.dsmp.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.IISADsmpOrder;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.IISADsmpStatus;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.ISADsmpOrderHis;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.bo.ISADsmpStatusHis;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.service.interfaces.ISFDsmapSRV;
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
public class SFDsmapSRVImpl extends UpdcEclipseImpl implements ISFDsmapSRV {
	public SFDsmapSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.asiainfo.sacenter.shcmcc.provision.dsmp.service.interfaces.ISFDsmapSRV#finishSFOfferSync(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFOfferSync(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFDsmapOfferImpl{
				public SFDsmapOfferImpl(){
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
						if( fromTASK.isPARALLEL() == false ){
							IOVUpfwmOffer.IUpfwmOfferHome fromUpfwmHome = fromUpfwm.getORDER();
							IISADsmpOrder fromINDEX = IDsmapUtils.ICustom._jf_dsmpoffer(fromOrder, 
									fromTASK, 
									fromUpdfwm, 
									fromUpfwm, 
									aContext );
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromUpfwmHome.getREPOSITORY(), 
									fromINDEX );
						}
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
					IOVUpfwmOffer fromHISTORY = null;
					try
					{
						fromHISTORY = UpfwmUtils.ICustom._wrap(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								ISADsmpOrderHis.S_TYPE, 
								aContext);
						fromHISTORY.setPS_STATUS( IUpfwmConst.IUpdos.SUCCEED );
						UpfsvcManager.getSession().submitISQLLite( fromTASK,
								fromUpfwm.getORDER().getREPOSITORY(), 
								fromHISTORY.getINSTANCE() );
					}
					finally{
						if( fromHISTORY != null ){ fromHISTORY = null; }
					}
				}
			}
			SFDsmapOfferImpl fromUpfgsmImpl = new SFDsmapOfferImpl();
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
	 * @see com.asiainfo.sacenter.shcmcc.provision.dsmp.service.interfaces.ISFDsmapSRV#finishSFAllSTSSync(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFAllSTSSync(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromASK = null;
		try
		{
			class SFDsmapAllSTSImpl{
				public SFDsmapAllSTSImpl(){
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
						if( fromTASK.isPARALLEL() == false ){
							IOVUpfwmOffer.IUpfwmOfferHome fromUpfwmHome = fromUpfwm.getORDER();
							IISADsmpStatus fromINDEX = IDsmapUtils.ICustom._jf_allsts(fromOrder, 
									fromTASK, 
									fromUpdfwm, 
									fromUpfwm, 
									aContext );
							UpfsvcManager.getSession().submitISQLLite(fromTASK, 
									fromUpfwmHome.getREPOSITORY(), 
									fromINDEX );
						}
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
					IOVUpfwmOffer fromHISTORY = null;
					try
					{
						fromHISTORY = UpfwmUtils.ICustom._wrap(fromOrder, 
								fromTASK, 
								fromUpdfwm, 
								fromUpfwm, 
								ISADsmpStatusHis.S_TYPE, 
								aContext);
						fromHISTORY.setPS_STATUS( IUpfwmConst.IUpdos.SUCCEED );
						UpfsvcManager.getSession().submitISQLLite( fromTASK,
								fromUpfwm.getORDER().getREPOSITORY(), 
								fromHISTORY.getINSTANCE() );
					}
					finally{
						if( fromHISTORY != null ){ fromHISTORY = null; }
					}
				}
			}
			SFDsmapAllSTSImpl fromUpfgsmImpl = new SFDsmapAllSTSImpl();
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

}
