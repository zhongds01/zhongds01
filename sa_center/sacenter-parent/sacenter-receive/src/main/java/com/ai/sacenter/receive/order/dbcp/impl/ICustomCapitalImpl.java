package com.ai.sacenter.receive.order.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmMiscHome;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.receive.util.UpdbfxUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于开通定单扩展类</p>
 * <p>Copyright: Copyright (c) 2016年3月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ICustomCapitalImpl extends UpdcEclipseImpl implements IBusinesCapital {
	public ICustomCapitalImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 基于开通定单用户转载用户订购</p>
	 * <p>Copyright: Copyright (c) 2017年3月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdffmxCustomImpl extends  ICustomCapitalImpl{
		public IUpdffmxCustomImpl(){
			super();
		}
		/**
		 * 
		 * <p>Library: IUpdffmxDefaultImpl</p>
		 * <p>Description: 开通用户预转载组件[开通定单接收类]</p>
		 * @param fromRequest 开通定单
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFMetaMXDefaultImpl(IOVMsgFRequest fromRequest, 
				IUpfgkmOfferHome fromUpdcpm,
	            IUpdcContext aContext) throws SFException, Exception{
			try
			{
				
			}
			finally{
				
			}
		}
		/**
		 * 开通用户预转载组件[开通定单接收类]
		 * <p>Library: IUpdffmxCustomImpl</p>
		 * <p>Description: 开通用户预转载组件[开通定单接收类]</p>
		 * @param fromRequest 开通定单
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFMetaMXUserImpl(IOVMsgFRequest fromRequest, 
				IUpfgkmOfferHome fromUpdcpm,
	            IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOrderFactory.getICustomSV().finishSFCentrexUser( fromRequest );
			}
			finally{
			
			}
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 基于开通工单扩展类</p>
	 * <p>Copyright: Copyright (c) 2018年2月28日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IUpdffvmCustomImpl extends ICustomCapitalImpl{
		public IUpdffvmCustomImpl(){
			super();
		}
		
		/**
		 * 开通定单默认扩展资产[手机规格][GSM]
		 * <p>Library: IUpdffvmDefaultImpl</p>
		 * <p>Description: 开通定单默认扩展资产</p>
		 * @param fromRequest 开通定单
		 * @param IOVOrderUser 开通用户
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpdfvmDefault(IOVMsgFRequest fromRequest,
				IOVOrderUser fromOrdUser,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext) throws SFException,Exception{
			try
			{
				
			}
			finally{
				
			}
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 基于服务产品扩展类</p>
	 * <p>Copyright: Copyright (c) 2017年3月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbfxCustomImpl extends ICustomCapitalImpl{
		public IUpdbfxCustomImpl(){
			super();
		}
		
		/**
		 * 用户订购局数据[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2MiscImpl</p>
		 * <p>Description: 根据开通产品获取服务产品测对应局数据</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2MiscImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			IUpfgkmMiscHome fromUpfgkmHome = null;
			try
			{
				/*SPID企业代码BIZCODE业务代码BILLFLG计费类型GLOBAL内容计费[G是L否]SERVTYPE业务类型*/
				fromUpfgkmHome = UpdbfsFactory.getIProductSV().getUpSpInfoByProdId( fromMsgFOffer.getPRODUCT_ID() );
				if( fromUpfgkmHome == null || fromUpfgkmHome.getOFFER() == null || fromUpfgkmHome.getOFFER().size() <= 0 ){
					fromUpdfmx.getORDER().getORDER().add( UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer) );
				}
				else{
					for( java.util.Iterator<IUpfgkmMiscHome.IUpfgkmOfferHome> itera = fromUpfgkmHome.getOFFER().iterator(); itera.hasNext(); ){
						IUpfgkmMiscHome.IUpfgkmOfferHome fromOfferHome = (IUpfgkmMiscHome.IUpfgkmOfferHome)itera.next();
						IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
						UpdbfxUtils.ICustom._mergeAsSpInfo(fromRequest, 
								fromNature, 
								fromOfferHome, 
								fromUpdfmx, 
								aContext);
						fromUpdfmx.getORDER().getORDER().add( fromNature );
					}
				}
			}
			finally{
				if( fromUpfgkmHome != null ){ fromUpfgkmHome = null; }
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * 用户订购局数据[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2LmscImpl</p>
		 * <p>Description: 根据开通产品获取服务产品测对应局数据</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2LmscImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			IUpfgkmMiscHome fromUpfgkmHome = null;
			try
			{
				/*SPID企业代码BIZCODE业务代码BILLFLG计费类型GLOBAL内容计费[G是L否]SERVTYPE业务类型*/
				fromUpfgkmHome = UpdbfsFactory.getIProductSV().getSpInfoByProdId( fromMsgFOffer.getPRODUCT_ID() );
				if( fromUpfgkmHome == null || fromUpfgkmHome.getOFFER() == null || fromUpfgkmHome.getOFFER().size() <= 0 ){
					fromUpdfmx.getORDER().getORDER().add( UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer) );
				}
				else{
					for( java.util.Iterator<IUpfgkmMiscHome.IUpfgkmOfferHome> itera = fromUpfgkmHome.getOFFER().iterator(); itera.hasNext(); ){
						IUpfgkmMiscHome.IUpfgkmOfferHome fromOfferHome = (IUpfgkmMiscHome.IUpfgkmOfferHome)itera.next();
						IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
						UpdbfxUtils.ICustom._mergeAsSpInfo(fromRequest, 
								fromNature, 
								fromOfferHome, 
								fromUpdfmx, 
								aContext);
						fromUpdfmx.getORDER().getORDER().add( fromNature );
					}
				}
			}
			finally{
				if( fromUpfgkmHome != null ){ fromUpfgkmHome = null; }
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * 用户订购全量属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2LbfxImpl</p>
		 * <p>Description: 根据开通产品获取服务产品测对应全量属性</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2LbfxImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			try
			{
				IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromNature.getUSER_ID() );
				if( fromNature.isORDER() ){
					UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
							fromMsgFUser, 
							fromNature, 
							fromUpdfmx, 
							aContext);
				}
				fromUpdfmx.getORDER().getORDER().add( fromNature );
			}
			finally{
				
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * 用户订购服务属性成员规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2PLMXImpl</p>
		 * <p>Description: 根据开通产品获取服务属性成员规范</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2PLMXImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			IOVUpdfmxOffer fromAsGroup = null;
			try
			{
				IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromNature.getUSER_ID() );
				if( fromNature.isORDER() ){
					fromAsGroup = UpdbfxUtils.ICustom._mergeAsMultle(fromRequest, 
							fromNature, 
							fromUpdfmx, 
							aContext);
					for( java.util.Iterator<IOVMsgFOffer> itera = fromAsGroup.getORDER().getORDER().iterator(); itera.hasNext(); ){
						IOVMsgFOffer fromAsOffer = (IOVMsgFOffer)itera.next();
						fromUpdfmx.getORDER().getORDER().add( fromAsOffer );
					}
					UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
							fromMsgFUser, 
							fromNature, 
							fromUpdfmx, 
							aContext);
				}
				fromUpdfmx.getORDER().getORDER().add( fromNature );
			}
			finally{
				if( fromAsGroup != null ){ fromAsGroup = null; }
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * 集团成员连带集团规范[手机规格][GSM]
		 * <p>Library: IUpdbfxVGL2PLAXImpl</p>
		 * <p>Description:根据集团成员查询集团服务产品</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishVGL2PLAXImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			try
			{
				IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromNature.getUSER_ID() );
				if( fromMsgFOffer.isORDER() /*集团用户角色*/){
					UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
							fromMsgFUser, 
							fromNature, 
							fromUpdfmx, 
							aContext);
				}
				fromUpdfmx.getORDER().getORDER().add( fromNature );
			}
			finally{
			
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * 集团成员订购局数据规范[手机规格][GSM]
		 * <p>Library: IUpdbfxVGL2MiscImpl</p>
		 * <p>Description:根据集团成员服务产品测对应局数据</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishVGL2MiscImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			IUpfgkmMiscHome fromUpfgkmHome = null;
			try
			{
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
				fromUpfgkmHome = UpdbfsFactory.getIProductSV().getUpSpInfoByProdId( fromMsgFOffer.getPRODUCT_ID() );
				if( fromUpfgkmHome == null || fromUpfgkmHome.getOFFER() == null || fromUpfgkmHome.getOFFER().size() <= 0 ){
					IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
					UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
							fromMsgFUser, 
							fromNature, 
							fromUpdfmx, 
							aContext);
					fromUpdfmx.getORDER().getORDER().add( fromNature );
				}
				else{
					for( java.util.Iterator<IUpfgkmMiscHome.IUpfgkmOfferHome> itera = fromUpfgkmHome.getOFFER().iterator(); itera.hasNext(); ){
						IUpfgkmMiscHome.IUpfgkmOfferHome fromOfferHome = (IUpfgkmMiscHome.IUpfgkmOfferHome)itera.next();
						IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
						UpdbfxUtils.ICustom._mergeAsSpInfo(fromRequest, 
								fromNature, 
								fromOfferHome, 
								fromUpdfmx, 
								aContext);
						UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
								fromMsgFUser, 
								fromNature, 
								fromUpdfmx, 
								aContext);
						fromUpdfmx.getORDER().getORDER().add( fromNature );
					}
				}
			}
			finally{
				if( fromUpfgkmHome != null ){ fromUpfgkmHome = null; }
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
	}
}
