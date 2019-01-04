package com.ai.sacenter.receive.order.service.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.common.UpfsvcVantage;
//import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.order.service.interfaces.IProductSRV;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê3ÔÂ17ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ProductSRVImpl extends UpdcEclipseImpl implements IProductSRV {
	public ProductSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFProductOffer(long)
	 */
	public IProfessionalTemplate.IProductOffer getSFProductOffer(long fromCOMPETE) throws SFException, Exception {
		IProfessionalTemplate.IProductOffer fromOffer = null;
		try
		{
			fromOffer = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpOffer( fromCOMPETE );
		}
		finally{
			
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFProductOffer(com.ai.sacenter.receive.valuebean.IOVMsgFOfferX)
	 */
	public IProfessionalTemplate.IProductOffer getSFProductOffer(IOVMsgFOfferX fromMsgFOfferX) throws SFException, Exception {
		IProfessionalTemplate.IProductOffer fromOffer = null;
		try
		{
			if( StringUtils.isBlank( fromMsgFOfferX.getATTR_ID() ) == false && 
					StringUtils.isNumeric( fromMsgFOfferX.getATTR_ID() ) ){
				long aCOMPETE = Long.parseLong( fromMsgFOfferX.getATTR_ID() );
				fromOffer = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpOffer( aCOMPETE );
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFProductBelong(com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IProfessionalTemplate.IProductOffer getSFProductBelong(IOVMsgFOffer fromOffer) throws SFException, Exception {
		IProfessionalTemplate.IProductOffer fromNature = null;
		try
		{
			fromNature = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpOffer( fromOffer.getSERVICE_ID() );
			if( fromNature == null ){
				fromNature = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpOffer( fromOffer.getPRODUCT_ID() );
			}
		}
		finally{
			
		}
		return fromNature;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFProductOffer(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome)
	 */
	public IProfessionalTemplate.IProductOffer getSFProductOffer(IOVMsgFRequest fromMsgF,
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm) throws SFException, Exception {
		IProfessionalTemplate.IProductOffer fromProduct = null;
		try
		{
			fromProduct = getSFProductOffer( fromOffer.getPRODUCT_ID() );
			if( fromProduct == null ){
				fromProduct = getSFProductOffer( fromOffer.getCOMPETE_ID() );
			}
			if( fromProduct == null ){
				fromProduct = getSFProductOffer( fromOffer.getSERVICE_ID() );
			}
		}
		finally{
			
		}
		return fromProduct;
	}

	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFProductNature(java.lang.String)
	 */
	public IProfessionalTemplate.IProductComptel getSFProductNature(String fromCOMPETE) throws SFException, Exception {
		IProfessionalTemplate.IProductComptel fromNature = null;
		try
		{
			fromNature = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpSubject( fromCOMPETE );
		}
		finally{
			
		}
		return fromNature;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFProductGroup(java.lang.String)
	 */
	public IProfessionalTemplate.IProductGroup getSFProductGroup(String fromGroup) throws SFException, Exception {
		IProfessionalTemplate.IProductGroup fromCombine = null;
		try
		{
			fromCombine = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpGroup( fromGroup );
		}
		finally{
			
		}
		return fromCombine;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFProductNature(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome)
	 */
	public IProfessionalTemplate.IProductComptel getSFProductNature(IOVMsgFRequest fromMsgF, 
			IOVMsgFOffer fromOffer,
			IUpfgkmOfferHome fromUpdcpm) throws SFException, Exception {
		IProfessionalTemplate.IProductComptel fromNature = null;
		try
		{
			IProfessionalTemplate.IProductOffer fromProduct = null;
			fromProduct = getSFProductOffer( fromOffer.getPRODUCT_ID() );
			if( fromProduct == null ){
				fromProduct = getSFProductOffer( fromOffer.getCOMPETE_ID() );
			}
			if( fromProduct == null ){
				fromProduct = getSFProductOffer( fromOffer.getSERVICE_ID() );
			}
			if( fromProduct != null ) { fromNature = fromProduct.getCOMPTEL(); }
		}
		finally{
			
		}
		return fromNature;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFProductGroup(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome)
	 */
	public IProfessionalTemplate.IProductGroup getSFProductGroup(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IUpfgkmOfferHome fromUpdcpm) throws SFException, Exception {
		IProfessionalTemplate.IProductGroup fromGroup = null;
		try
		{
			UpfsvcVantage.IUpdfmxCustom _rocket_factory_ = UpfsvcManager.getRocket().getIUpfxCustom();
			String _group_catalog_ = ClassUtils.getINDEX( new String[]{IUpdbfsConst.IUpdbm.ICache.PROGRAM_GROUP, "_$_", fromMsgFUser.getCATALOG() } );
			fromGroup = (IProfessionalTemplate.IProductGroup)_rocket_factory_.getIUpfxMotion( _group_catalog_ );
			if( fromGroup == null && fromUpdcpm.getCATALOG().getPROGRAM() != null ){
				IProfessionalTemplate.IBusinesKernel fromKernel = null;
				IProfessionalTemplate.IProductOffer fromCatalog = null;
				fromCatalog = getSFProductOffer( Long.parseLong( fromMsgFUser.getCATALOG() ) );
				if( fromCatalog != null ){
					fromKernel = fromUpdcpm.getCATALOG().getPROGRAM( ClassUtils.getINDEX( new String[]{
							IUpdbfsConst.IUpdbm.ICache.PROGRAM_GROUP, "_", fromCatalog.getCOMPETE() } ) );
					if( fromKernel != null && StringUtils.isBlank( fromKernel.getCOMPLEX() ) == false ){
						fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpGroup( fromKernel.getCOMPLEX() );
					}
				}
				_rocket_factory_.submitIUpfxMotion( _group_catalog_, fromGroup );
			}
		}
		finally{
			
		}
		return fromGroup;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFExpireGroup(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IProfessionalTemplate.IProductCatalog[] getSFExpireGroup(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromUser, 
			IOVMsgFOffer fromOffer) throws SFException, Exception {
		IProfessionalTemplate.IProductCatalog fromExpire[] = null;
		try
		{
			java.util.List<IProfessionalTemplate.IProductCatalog> fromGroupExpire = null;
			IProfessionalTemplate.IProductGroup fromGroup = null;
			fromGroup = getSFProductGroup( IUpdbfsConst.IUpdbm.IProduct.PROGRAM_EXPIRE_GROUP );
			if( fromGroup != null && fromGroup.getSUBFLOW().size() > 0 ){
				String fromCOMPETE = String.valueOf( fromOffer.getPRODUCT_ID() );
				fromGroupExpire = fromGroup.getCOMBINE( fromCOMPETE );
				if( fromGroupExpire == null ){
					fromCOMPETE = String.valueOf( fromOffer.getSERVICE_ID() );
					fromGroupExpire = fromGroup.getCOMBINE( fromCOMPETE );
				}
				if( fromGroupExpire != null ){
					fromExpire = (IProfessionalTemplate.IProductCatalog[])fromGroupExpire.toArray( 
							new IProfessionalTemplate.IProductCatalog[]{} );
				}
			}
		}
		finally{
			
		}
		return fromExpire;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IProductSRV#getSFPVpmnGroup()
	 */
	public IProfessionalTemplate.IProductCombine getSFPVpmnGroup() throws SFException, Exception {
		IProfessionalTemplate.IProductCombine fromGroup = null;
		try
		{
			fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpCombine(
					IUpdbfsConst.IUpdbm.IProduct.PROGRAM_GROUP_PLAN, 
					IUpdbfsConst.IUpdbm.IProduct.PROGRAM_PVPMN_COMPETE );
		}
		finally{
			
		}
		return fromGroup;
	}

}
