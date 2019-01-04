package com.ai.sacenter.receive.order.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.service.interfaces.IExpireSRV;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.receive.util.ExpireUtils;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFCustom;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdOffer;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserCentrex;
import com.ai.sacenter.receive.valuebean.IOVUpffmxExpire;
import com.ai.sacenter.teaminvoke.UpdcFactory;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于网元到期工单</p>
 * <p>Copyright: Copyright (c) 2017年3月7日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ExpireCSVImpl extends UpdcEclipseImpl implements IExpireSRV {
	public ExpireCSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFMsgFExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFMsgFExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpdfmxExpireImpl{
				public SFUpdfmxExpireImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromUpdfmx
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdcpmOffer getSFUpffxExpire( IUpdfmxExpire fromUpdfmx, IUpdcContext aContext) throws SFException, Exception{
					IOVUpdcpmOffer fromUpdcpm = null;
					try
					{
						IProgramTemplate.IUpdfcmpOffer __EXPIRE__ = UpdcpmUtils.getEXPIRE();
						if( __EXPIRE__ != null ){
							fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromUpdfmx, __EXPIRE__ );
						}
					}
					finally{
						
					}
					return fromUpdcpm;
				}
			}
			SFUpdfmxExpireImpl fromUpdfmxImpl = new SFUpdfmxExpireImpl();
			try
			{
				IUpfgkmOfferHome __BUSINESS__ = IOrderFactory.getIOrdMixSV().getSFExpireBusines( fromMsgFUser );
				if( __BUSINESS__ != null ){
					IUpdfmxExpire fromUpdfmx = ExpireUtils.ICustom._wrap( fromRequest, fromMsgFUser, aContext );
					IOVUpdcpmOffer __EXPIRE__ = fromUpdfmxImpl.getSFUpffxExpire( fromUpdfmx, aContext );
					if( __EXPIRE__ == null /*未配置到期用户批开组件*/){
						finishSFUserExpire(fromRequest, fromMsgFUser, fromUpffmx, fromUpdcpm, aContext);
					}
					else/*采用数据库事务提交时指定到期用户组件批开*/{
						String _expire_user_id_ = CustomUtils.ICatalog._expire_user_id( fromUpdfmx.getUSER_ID() );
						UpfsvcManager.getSession().submitIUpfxExpire( _expire_user_id_, fromUpdfmx );
					}
				}
			}
			finally{
				if( fromUpdfmxImpl != null ){ fromUpdfmxImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFOrdExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOrdExpire(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFOrdExpireImpl{
				public SFOrdExpireImpl(){
					super();
				}
				/**
				 * 根据开通定单订购完成已生效订购关系
				 * @param fromMsgF 开通定单
				 * @param fromMsgFOffer 开通订购
				 * @param fromUpffmx 开通定单组
				 * @param fromUpdcpm 开通接入能力
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOrdEffective(IOVMsgFRequest fromRequest,
						IOVMsgFOffer fromOrdOffer, 
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFRequest.IMsgFOfferHome fromMetaHome = fromRequest.getORDER();
						if( fromOrdOffer.isCREATE() /*订购服务产品生效*/ ){
							IOrderFactory.getIOrdMixSV().finishSFMsgFNetWork(fromRequest, 
									fromOrdOffer, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
						}
						else if( fromOrdOffer.isEXPIRE( fromMetaHome.getCREATOR() )/*次月退订*/){
							
						}
						else/*变更服务产品生效 或者 退订服务产品生效 或者 其它状态服务产品*/{
							IOrderFactory.getIOrdMixSV().finishSFMsgFNetWork(fromRequest, 
									fromOrdOffer, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromOrdOffer
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOrdExpire(IOVMsgFRequest fromRequest, 
						IOVMsgFUser fromMsgFUser,
						IOVMsgFOrdOffer fromOrdOffer,
						IOVUpffmxRequest fromUpffmx, 
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFRequest.IMsgFOfferHome fromMetaHome = fromRequest.getORDER();
						IOVMsgFOffer fromOffer[] = IOrderFactory.getIOrdMixSV().finishSFMsgFReceive(fromRequest,
								fromOrdOffer, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
						for( int index = 0; fromOffer != null && index < fromOffer.length; index++ ){
							if( fromOffer[index].isVALID() == false /*失效时间 <= 生效时间*/) continue;
							if( TimeUtils.greaterEqual( fromMetaHome.getCREATOR(), 
									fromOffer[index].getEFFECTIVE() )/*订购生效*/){
								finishSFOrdEffective(fromRequest, 
										fromOffer[index], 
										fromUpffmx, 
										fromUpdcpm, 
										aContext);
							}
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOrdExpire(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser, 
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						if( fromMsgFUser.getORDER() != null && fromMsgFUser.getORDER().size() > 0
								/*开通定单服务产品发生变化引起网元下周期发生变化*/){
							finishSFMsgFExpire( fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm,
									aContext );
						}
					}
					finally{
						
					}
				}
			}
			SFOrdExpireImpl fromExpireImpl = new SFOrdExpireImpl();
			try
			{
				IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
				for( java.util.Iterator<IOVMsgFOrdCentrex> itera = fromMsgFUser.getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOrdCentrex fromCentrex = (IOVMsgFOrdCentrex)itera.next();
					if( fromOrdUserHome.getSFUpffxUsed( fromCentrex ) != null ) continue;
					fromOrdUserHome.submitSFUpffxUsed( new IOVMsgFOrdCentrex[]{ fromCentrex });
					for( java.util.Iterator<IOVMsgFOffer> iterap = fromCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
						IOVMsgFOrdOffer fromOrdOffer = (IOVMsgFOrdOffer)iterap.next();
						fromExpireImpl.finishSFOrdExpire(fromRequest, 
								fromMsgFUser, 
								fromOrdOffer, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
				fromExpireImpl.finishSFOrdExpire(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				if( fromExpireImpl != null ){ fromExpireImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFOrdEffective(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOrdEffective(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFOrdEffectiveImpl{
				public SFOrdEffectiveImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromOrdOffer
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOrdEffective(IOVMsgFRequest fromRequest, 
						IOVMsgFUser fromMsgFUser,
						IOVMsgFOrdOffer fromOrdOffer,
						IOVUpffmxRequest fromUpffmx, 
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFOffer fromOffer[] = IOrderFactory.getIOrdMixSV().finishSFMsgFReceive(fromRequest,
								fromOrdOffer, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
						for( int index = 0; fromOffer != null && index < fromOffer.length; index++ ){
							if( fromOffer[index].isVALID() == false /*失效时间 <= 生效时间*/) continue;
							IOrderFactory.getIOrdMixSV().finishSFMsgFNetWork(fromRequest, 
									fromOffer[index], 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOrdExpire(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser, 
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IProfessionalTemplate.IBusinesOffer __business__ = fromUpdcpm.getCATALOG().getBUSINES();
						if( __business__ != null && __business__.isEXPIRE() && fromMsgFUser.getORDER().size() > 0 ){
							finishSFMsgFExpire(fromRequest, 
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
			SFOrdEffectiveImpl fromEffectiveImpl = new SFOrdEffectiveImpl();
			try
			{
				IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
				for( java.util.Iterator<IOVMsgFOrdCentrex> itera = fromMsgFUser.getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOrdCentrex fromCentrex = (IOVMsgFOrdCentrex)itera.next();
					if( fromOrdUserHome.getSFUpffxUsed( fromCentrex ) != null ) continue;
					fromOrdUserHome.submitSFUpffxUsed( new IOVMsgFOrdCentrex[]{ fromCentrex });
					for( java.util.Iterator<IOVMsgFOffer> iterap = fromCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
						IOVMsgFOrdOffer fromOrdOffer = (IOVMsgFOrdOffer)iterap.next();
						fromEffectiveImpl.finishSFOrdEffective(fromRequest, 
								fromMsgFUser, 
								fromOrdOffer, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
				fromEffectiveImpl.finishSFOrdExpire(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				if( fromEffectiveImpl != null ){ fromEffectiveImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFUserExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUserExpire(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUserExpireImpl{
				public SFUserExpireImpl(){
					super();
				}
				/**
				 * 根据开通用户获取网元到期接入能力
				 * @param fromRequest 开通定单
				 * @param fromMsgFUser 开通用户
				 * @param fromUpdcpm 开通接入能力
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpffmxExpire finishSFUserHome( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpffmxExpire fromUpffmxHome = null;
					IOVMsgFUser fromMsgFCentrex = null;
					try
					{
						IUpfgkmOfferHome fromExpire = null;
						fromUpffmxHome = new IOVUpffmxExpire( fromRequest );
						fromExpire = IOrderFactory.getIOrdMixSV().getSFExpireBusines( fromMsgFUser );
						if( fromExpire != null ){
							fromMsgFCentrex = IOrderFactory.getICustomSV().getSFUserCentrex( fromRequest, fromMsgFUser );
							if( fromMsgFCentrex != null && fromMsgFCentrex.getUSER() != null ){
								for( java.util.Iterator<IOVMsgFUserCentrex> itera = fromMsgFCentrex.getUSER().iterator(); itera.hasNext(); ){
									IOVMsgFUserCentrex usercentrex = (IOVMsgFUserCentrex)itera.next();
									ClassUtils.IMerge.merge( usercentrex.getCENTREX(), fromUpffmxHome.getORDER() );
								}
							}
							fromUpffmxHome.setCOMPETENCE( fromExpire );
						}
					}
					finally{
						if( fromMsgFCentrex != null ){ fromMsgFCentrex = null; }
					}
					return fromUpffmxHome;
				}
				/**
				 * 
				 * @param fromRequest 开通定单
				 * @param fromMsgFUser 开通用户
				 * @param fromExpire 到期时间
				 * @param fromUpffmxHome 网元到期用户
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpffmxExpire.IUpffmxUser finishSFExpireHome(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser, 
						java.sql.Timestamp fromExpire,
						IOVUpffmxExpire fromUpffmxHome) throws SFException,Exception{
					IOVUpffmxExpire.IUpffmxUser fromUserHome = null;
					try
					{
						fromUserHome = fromUpffmxHome.getUSER( fromMsgFUser.getUSER_ID(), fromExpire );
						if( fromUserHome.getUSER() == null ){
							IOVUser fromUSER = IOrderFactory.getICustomSV().getSFUser( fromMsgFUser.getUSER_ID(), 
									fromMsgFUser.getUSER_REGION_ID() );
							if( fromUSER == null ){
								ExceptionFactory.throwException("IOS0010032", new String[]{String.valueOf( 
										fromMsgFUser.getUSER_ID() ), fromMsgFUser.getUSER_REGION_ID()  } );
							}
							fromUserHome.setUSER( CustomUtils.ICustom._wrap( fromUSER, new IOVMsgFUser() ) );
							IOVCustom fromCustom = IOrderFactory.getICustomSV().getSFCustom(fromUSER.getCUST_ID(), 
									fromUSER.getCUST_TYPE(), 
									fromUSER.getREGION_ID() );
							if( fromCustom != null ){
								fromUserHome.getUSER().setCUSTOM( CustomUtils.ICustom._wrap(fromCustom, 
										new IOVMsgFCustom() ) );
							}
						}
					}
					finally{
						
					}
					return fromUserHome;
				}
				/**
				 * 根据开通定单订购完成到期工单订购关系
				 * @param fromRequest 开通定单
				 * @param fromMsgFUser 开通用户
				 * @param fromMsgFOffer 开通到期订购
				 * @param fromExpire 到期时间
				 * @param fromUpffmxHome 网元到期用户
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				private void finishSFUserExpire(IOVMsgFRequest fromRequest, 
						IOVMsgFUser fromMsgFUser, 
						IOVMsgFOrdOffer fromMsgFOffer,
						java.sql.Timestamp fromExpire,
						IOVUpffmxExpire fromUpffmxHome,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IProfessionalTemplate.IProductCatalog fromExpireGroup[] = null;
						fromExpireGroup = IOrderFactory.getIProductSV().getSFExpireGroup( fromRequest, 
								fromMsgFUser, 
								fromMsgFOffer );
						if( fromExpireGroup == null || fromExpireGroup.length <= 0 ){
							IOVUpffmxExpire.IUpffmxUser fromUserHome = null;
							fromUserHome = finishSFExpireHome(fromRequest, 
									fromMsgFUser, 
									fromExpire, 
									fromUpffmxHome);
							if( fromUserHome != null ){
								fromUserHome.getUSER().mergeAsCentrex( fromMsgFOffer );
							}
						}
					}
					finally{
						
					}
				}
				/**
				 * 根据开通服务产品完成下周期沉淀
				 * @param fromRequest 开通定单
				 * @param fromMsgFUser 开通用户
				 * @param fromMsgFOffer 开通产品
				 * @param fromUpffmxHome 网元到期用户
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				private void finishSFUserExpire( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVMsgFOffer fromMsgFOffer,
						IOVUpffmxExpire fromUpffmxHome,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFRequest.IMsgFOfferHome fromMetaHome = fromRequest.getORDER();
						if( fromMsgFOffer.isEFFECTIVE( fromMetaHome.getCREATOR() )/*到期订购*/){
					    	IOVMsgFOrdOffer fromEffective = new IOVMsgFOrdOffer( fromMsgFOffer );
							fromEffective.setSTATUS( IUpdbfsConst.IState.IOrder.S01 );
							finishSFUserExpire(fromRequest, 
									fromMsgFUser, 
									fromEffective, 
									fromEffective.getEFFECTIVE(), 
									fromUpffmxHome,
									aContext);
						}
						if( fromMsgFOffer.isEXPIRE( fromMetaHome.getCREATOR() )/*次月退订*/){
					    	IOVMsgFOrdOffer fromExpire = new IOVMsgFOrdOffer( fromMsgFOffer );
					    	fromExpire.setSTATUS( IUpdbfsConst.IState.IOrder.S03 );
					    	finishSFUserExpire(fromRequest, 
									fromMsgFUser, 
									fromExpire, 
									fromExpire.getEXPIRE(),
									fromUpffmxHome,
									aContext);
						}
					}
					finally{
						
					}
				}
				/**
				 * 根据开通用户完成网元到期用户分组存放
				 * @param fromRequest 开通定单
				 * @param fromMsgFUser 开通用户
				 * @param fromUpffmxHome 网元到期用户
				 * @param fromUpffmx 开通工单组
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserExpire( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxExpire fromUpffmxHome,
						IOVUpffmxRequest fromUpffmx, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						for( java.util.Iterator<IOVMsgFOffer> itera = fromUpffmxHome.getORDER().iterator(); itera.hasNext(); ){
							IOVMsgFOffer fromMsgFOffer = (IOVMsgFOffer)itera.next();
							IOVMsgFOffer fromOrdOffer[] = IOrderFactory.getIOrdMixSV().finishSFMsgFReceive(fromRequest,
									fromMsgFOffer, 
									fromUpffmx, 
									fromUpffmxHome.getCOMPETENCE(), 
									aContext);
							for( int index = 0; fromOrdOffer != null && index < fromOrdOffer.length; index++ ){
								if( fromMsgFOffer.isVALID() == false /*失效时间 <= 生效时间*/ ) continue;
								finishSFUserExpire(fromRequest, 
										fromMsgFUser, 
										fromOrdOffer[index], 
										fromUpffmxHome, 
										aContext);
							}
						}
					}
					finally{
						
					}
				}
				/**
				 * 根据网元到期用户清单完成网元下周期批开
				 * @param fromRequest 开通定单
				 * @param fromMsgFUser 开通用户
				 * @param fromUpffmx 开通工单组
				 * @param fromUpdcpm 开通能力
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFNetWorkExpire( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser,
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVOrderRequest _request = new IOVOrderRequest();
						UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFUser, _request, fromUpdcpm);
						fromUpffmx.getUSER().beginTransaction(_request, fromUpffmx.getEXPIRE(), fromUpdcpm );
						try
						{
							IOrderFactory.getIOrdOfferSV().finishSFOrdNature(fromRequest, 
									fromMsgFUser, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							fromUpffmx.getUSER().commitTransaction();
						}
						catch( java.lang.Exception aException )
						{
							fromUpffmx.getUSER().rollbackTransaction();
							throw aException;
						}
						finally{
							
						}
					}
					finally{
						
					}
				}
			}
			SFUserExpireImpl fromExpireImpl = new SFUserExpireImpl();
			IOVUpffmxExpire fromUpffmxHome = null;
			try
			{
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromUpffmxHome = fromExpireImpl.finishSFUserHome(fromRequest, 
						fromMsgFUser,
						fromUpdcpm,
						aContext);
				if( fromUpffmxHome != null  && fromUpffmxHome.getCOMPETENCE() != null ){
					fromExpireImpl.finishSFUserExpire(fromRequest, 
							fromMsgFUser, 
							fromUpffmxHome, 
							fromUpffmx,  
							aContext);
					IOVUpffmxExpire.IUpffmxUser fromUserHome[] = null;
					fromUserHome = fromUpffmxHome.getUSER( fromMsgFUser.getUSER_ID() );
					if( fromUserHome == null || fromUserHome.length <= 0 ){
						/*用户退订最后到期服务产品需要默认到期工单[彻底删除用户网元到期工单]*/
						fromExpireImpl.finishSFExpireHome(fromRequest, 
								fromMsgFUser, 
								TimeUtils.addHour( fromMBean.getCREATE(), 2 ), 
								fromUpffmxHome);
					}
					for( java.util.Iterator<IOVUpffmxExpire.IUpffmxUser> itera = fromUpffmxHome.getUSER().values().iterator(); itera.hasNext(); ){
						IOVUpffmxExpire.IUpffmxUser fromOrdUserHome = (IOVUpffmxExpire.IUpffmxUser)itera.next();
						IOVMsgFRequest fromExpireHome = ExpireUtils.ICustom._wrap(fromRequest, fromOrdUserHome);
						fromExpireImpl.finishSFNetWorkExpire(fromExpireHome, 
								fromOrdUserHome.getUSER(), 
								fromUpffmx, 
								fromOrdUserHome.getCOMPETENCE(), 
								aContext);
					}	
				}
			}
			finally{
				if( fromUpffmxHome != null ){ fromUpffmxHome = null; }
				if( fromExpireImpl != null ){ fromExpireImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFUserHistory(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUserHistory(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVOrderRequest fromOrderHome = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromOrderHome = new IOVOrderRequest();
			UpdbfsUtils.ICustom._wrap(fromRequest, 
					fromMsgFUser, 
					fromOrderHome, 
					fromUpdcpm);
			UpdcFactory.getIUpdcSV().cancelSFExpire(fromOrderHome, 
					fromUpdcpm, 
					fromXML);
		}
		finally{
			if( fromOrderHome != null ){ fromOrderHome = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFGroupHistory(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFGroupHistory(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromGroup, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFGroupExpireImpl{
				public SFGroupExpireImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOrdExpire(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser, 
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						finishSFMsgFExpire( fromRequest, 
								fromMsgFUser, 
								fromUpffmx, 
								fromUpdcpm,
								aContext );
					}
					finally{
						
					}
				}
			}
			SFGroupExpireImpl fromExpireImpl = new SFGroupExpireImpl();
			try
			{
				for( java.util.Iterator<IOVMsgFUser> itera = fromRequest.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUser fromMsgFUser = (IOVMsgFUser)itera.next();
					if( fromMsgFUser.getUSER_ID() == fromGroup.getUSER_ID() ) continue;
					fromExpireImpl.finishSFOrdExpire(fromRequest, 
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
}
