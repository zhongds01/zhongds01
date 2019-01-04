package com.ai.sacenter.receive.order.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.service.interfaces.IOrdOfferSRV;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdOffer;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserCentrex;
import com.ai.sacenter.receive.valuebean.IOVUpffmxDepend;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年3月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class OrdOfferSRVImpl extends UpdcEclipseImpl implements IOrdOfferSRV {

	public OrdOfferSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdOfferSRV#finishSFUserDepend(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUserDepend(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IProfessionalTemplate.IProductCatalog fromCatalog = null;
			IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
			IOVMsgFUser fromNature = IOrderFactory.getICustomSV().getSFUserCentrex(fromRequest, fromMsgFUser, IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NOW );
			if( fromNature != null && fromNature.getUSER() != null ){
				for( java.util.Iterator<IOVMsgFUserCentrex> itera = fromNature.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUserCentrex fromCentrex = (IOVMsgFUserCentrex)itera.next();
					if( fromOrdUserHome.getSFUpffxUsed( fromCentrex ) != null ) continue;
					fromOrdUserHome.submitSFUpffxUsed( new IOVMsgFUserCentrex[]{ fromCentrex } );
					for( java.util.Iterator<IOVMsgFOffer> iterap = fromCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
						IOVMsgFUserOffer fromMsgFOffer = (IOVMsgFUserOffer)iterap.next();
						fromCatalog = fromOrdUserHome.getDEPENDENT().getProduction( fromMsgFOffer );
						if( fromCatalog != null ){
							IOVMsgFUserOffer fromUserOffer = UpdbfsUtils.ICustom._depend(fromRequest, 
									fromMsgFUser, 
									fromMsgFOffer);
							IOrderFactory.getIOrdMixSV().finishSFMsgFNetWork(fromRequest, 
									fromUserOffer, 
									fromUpffmx, 
						    		fromUpdcpm, 
						    		aContext);
						}
					}
				}
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdOfferSRV#finishSFOrdNature(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOrdNature(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFOrdNetWorkImpl{
				public SFOrdNetWorkImpl(){
					super();
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromPentium
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOrdOffer(IOVMsgFRequest fromRequest, 
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx, 
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
						for( java.util.Iterator<IOVMsgFOrdCentrex> itera = fromMsgFUser.getORDER().iterator(); itera.hasNext(); ){
							IOVMsgFOrdCentrex fromCentrex = (IOVMsgFOrdCentrex)itera.next();
							if( fromOrdUserHome.getSFUpffxUsed( fromCentrex ) != null ) continue;
							fromOrdUserHome.submitSFUpffxUsed( new IOVMsgFOrdCentrex[]{ fromCentrex });
							for( java.util.Iterator<IOVMsgFOffer> iterap = fromCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
								IOVMsgFOrdOffer fromMsgFOffer = (IOVMsgFOrdOffer)iterap.next();
								if( fromMsgFOffer.isVALID()/*失效时间 > 生效时间*/){
									IOrderFactory.getIOrdMixSV().finishSFMsgFNetWork(fromRequest, 
											fromMsgFOffer, 
											fromUpffmx, 
											fromUpdcpm, 
											aContext);
								}
							}
						}
					}
					finally{
						
					}
				}
			}
			SFOrdNetWorkImpl fromNetWorkImpl = new SFOrdNetWorkImpl();
			try
			{
				IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
				IOVUpffmxDepend fromDepend = fromOrdUserHome.getDEPENDENT();
				fromMsgFUser.userCentrexLimite();
				fromNetWorkImpl.finishSFOrdOffer(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
				if( fromDepend != null && fromDepend.getINSTANCE().size() > 0 && 
						fromOrdUserHome.getUSER().getPRODUCTION().size() > 0 ){
					finishSFUserDepend(fromRequest, 
							fromMsgFUser, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				if( fromNetWorkImpl != null ){ fromNetWorkImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdOfferSRV#finishSFOrdExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOrdExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFOfferExpireImpl{
				public SFOfferExpireImpl(){
					super();
				}
			}
			SFOfferExpireImpl fromExpireImpl = new SFOfferExpireImpl();
			try
			{
				IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
				IOVUpffmxDepend fromDepend = fromOrdUserHome.getDEPENDENT();
				fromMsgFUser.userCentrexLimite();
				IOrderFactory.getIExpireSV().finishSFOrdExpire(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
				if( fromDepend != null && fromDepend.getINSTANCE().size() > 0 && 
						fromOrdUserHome.getUSER().getPRODUCTION().size() > 0 ){
					finishSFUserDepend(fromRequest, 
							fromMsgFUser, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				if( fromExpireImpl != null ){ fromExpireImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdOfferSRV#finishSFOrdEffective(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOrdEffective(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFOfferEffectiveImpl{
				public SFOfferEffectiveImpl(){
					super();
				}
			}
			SFOfferEffectiveImpl fromMsgFEffectImpl = new SFOfferEffectiveImpl();
			try
			{
				IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
				IOVUpffmxDepend fromDependHome = fromOrdUserHome.getDEPENDENT();
				fromMsgFUser.userCentrexLimite();
				IOrderFactory.getIExpireSV().finishSFOrdEffective(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
				if( fromDependHome != null && fromDependHome.getINSTANCE().size() > 0 && 
						fromOrdUserHome.getUSER().getPRODUCTION().size() > 0 ){
					finishSFUserDepend(fromRequest, 
							fromMsgFUser, 
							fromUpffmx, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				if( fromMsgFEffectImpl != null ){ fromMsgFEffectImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdOfferSRV#finishSFMsgFNature(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFMsgFNature(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
			IOVMsgFUser fromUserNature = IOrderFactory.getICustomSV().getSFUserCentrex(fromRequest, fromMsgFUser, IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NOW );
			if( fromUserNature != null && fromUserNature.getUSER() != null ){
				for( java.util.Iterator<IOVMsgFUserCentrex> itera = fromUserNature.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUserCentrex fromCentrex = (IOVMsgFUserCentrex)itera.next();
					if( fromOrdUserHome.getSFUpffxUsed( fromCentrex ) == null ){
						for( java.util.Iterator<IOVMsgFOffer> iterap = fromCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
							IOVMsgFUserOffer fromMsgFOffer = (IOVMsgFUserOffer)iterap.next();
							String fromSTATUS = UpdbfsUtils.ICustom.ICustomX._os_status( fromRequest, 
									fromMsgFOffer, 
									fromUpdcpm );
							if( StringUtils.equals( fromSTATUS, IUpdbfsConst.IState.T ) == false ){
								IOrderFactory.getIOrdMixSV().finishSFMsgFNetWork(fromRequest, 
							    		fromMsgFOffer, 
							    		fromUpffmx, 
							    		fromUpdcpm, 
							    		aContext);
							}
						}
					}
				}
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdOfferSRV#finishSFMsgFExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFMsgFExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVUpffmxRequest fromUpffmx,  
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			if( UpdbfsUtils.IIfElse.isORDER(fromRequest, fromUpdcpm)/*开通产品订购来源[订单模型]*/){
				IOrderFactory.getIOrdOfferSV().finishSFOrdExpire(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
			}
			else if( UpdbfsUtils.IIfElse.isUSER(fromRequest, fromUpdcpm)/*开通产品订购来源[订购模型]*/){
				IOrderFactory.getIExpireSV().finishSFMsgFExpire(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
			}
		}
		finally{
		
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IOrdOfferSRV#finishSFMsgFEffective(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFMsgFEffective(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			if( UpdbfsUtils.IIfElse.isORDER(fromRequest, fromUpdcpm)/*开通产品订购来源[订单模型]*/){
				IOrderFactory.getIOrdOfferSV().finishSFOrdEffective(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
			}
			else if( UpdbfsUtils.IIfElse.isUSER(fromRequest, fromUpdcpm)/*开通产品订购来源[订购模型]*/){
				IOrderFactory.getIOrdOfferSV().finishSFMsgFNature(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
			}
		}
		finally{
		
		}
	}

}
