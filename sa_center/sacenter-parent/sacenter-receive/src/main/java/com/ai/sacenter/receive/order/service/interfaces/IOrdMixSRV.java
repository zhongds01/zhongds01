package com.ai.sacenter.receive.order.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通定单其他服务</p>
 * <p>Copyright: Copyright (c) 2016年3月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrdMixSRV {
	/**
	 * 根据开通请求单查询开通能力接入层规范
	 * @param fromCATALOG 产品规格编号
	 * @param fromBUSINES 业务操作编码
	 * @param fromORIGINATE 发起方编码
	 * @param fromCATEGORY 调度类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( String fromCATALOG, 
			String fromBUSINES, 
			String fromORIGINATE,
			String fromCATEGORY)  throws RemoteException,Exception;
	/**
	 * 根据开通用户查询开通到期能力接入层规范
	 * @param fromMsgFUser 开通用户
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFExpireBusines( IOVMsgFUser fromMsgFUser )  throws RemoteException,Exception;
	/**
	 * 根据开通异步单查询开通异步单接入能力规范
	 * @param fromExigence 开通异步单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( IOVMocketExigence fromExigence) throws SFException,Exception;
	/**
	 * 根据开通异步单查询开通异步单接入能力规范
	 * @param fromExigence 开通异步单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( IOVMsgFExigence fromExigence) throws SFException,Exception;
	/**
	 * 根据开通异步单查询开通异步单接入能力规范
	 * @param fromUpdfmx 到期定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( IUpdfmxExpire fromUpdfmx) throws SFException,Exception;
	/**
	 * 根据开通定单查询开通组件规范
	 * @param fromRequest
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesOffer getSFMsgFComptel( IOVRocketExigence fromRequest) throws SFException,Exception;
	/**
	 * 根据开通定单查询开通组件规范
	 * @param fromRequest
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesOffer getSFMsgFComptel( IOVMocketExigence fromExigence) throws SFException,Exception;
	/**
	 * 根据开通消息查询开通消息接入能力规范
	 * @param fromMsgF 开通消费
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( IOVRocketExigence fromRequest) throws SFException,Exception;
	/**
	 * 根据开通异步单查询开通异步单接入能力规范
	 * @param fromRequest 开通异步单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFComplete( IOVRocketExigence fromRequest) throws SFException,Exception;
	/**
	 * 根据开通定单查询开通定单接入能力规范
	 * @param fromRequest
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IOVOrderRequest fromRequest) throws SFException, Exception;
	
	/**
	 * 根据开通定单查询开通定单接入能力规范
	 * @param fromRequest 开通定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IOVMsgFRequest fromRequest) throws SFException,Exception;
	/**
	 * 根据开通修复单查询开通定单接入能力规范
	 * @param fromRequest 开通修复单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFUrgencyBusines(IOVMsgFRequest fromRequest) throws SFException,Exception;
	/**
	 * 根据服务编号查询服务产品扩展规范
	 * @param fromRequest 开通定单
	 * @param fromOffer 开通定单订购
	 * @param fromUpdcpm 开通接入能力
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesCatalog getSFMsgFBusines( IOVMsgFRequest fromRequest, 
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * 根据服务编号查询服开通定单订购扩展规范
	 * @param fromRequest 开通定单
	 * @param fromOffer 开通定单订购
	 * @param fromUpdcpm 开通接入能力
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesCatalog getSFMsgFReceive( IOVMsgFRequest fromRequest, 
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * 根据开通消息计算当前开通服务产品优先级
	 * @param fromRequest 开通定单
	 * @param fromBusines 业务优先级
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsOffer getSFMsgFPriority(IOVMsgFRequest fromRequest,
			ISystemTemplate.IUpdbfsBusines fromBusines) throws SFException,Exception;
	/**
	 * 根据开通定单计算当前开通定单优先级
	 * @param fromMsgF 开通定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsOffer getSFMsgFPriority( IOVMsgFRequest fromRequest ) throws SFException,Exception;
	/**
	 * 根据开通消息计算当前开通定单优先级
	 * @param fromMsgF 开通定单
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsOffer getSFMsgFPriority( IOVRocketExigence fromMsgF ) throws SFException,Exception;
	/**
	 * 根据开通定单服务产品规范完成开通定单服务产品预处理
	 * @param fromRequest 开通定单
	 * @param fromMsgFOffer 开通定单订购
	 * @param fromUpffmx 开通工单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] finishSFMsgFReceive( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromMsgFOffer,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据服务产品扩展规范完成服务产品扩展属性
	 * @param fromPentium 开通定单
	 * @param fromOffer 开通定单订购
	 * @param fromUpffmx 开通工单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] finishSFOfferNature( IOVMsgFRequest fromPentium,
			IOVMsgFOffer fromOffer,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通消息用户停复机状态完成用户停复机分析
	 * @param fromRequest 开通消息
	 * @param fromMsgFUser 开通消息用户
	 * @param fromOrdUser 开通工单用户
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOsStatusTrail(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVOrderUser fromOrdUser ) throws SFException,Exception;
	/**
	 * 根据开通定单服务产品完成网元侧服务产品依赖关系
	 * @param fromRequest 开通定单
	 * @param fromOffer 开通服务产品
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOfferDepend( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromOffer,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单服务订购完成开通同组服务映射关系
	 * @param fromPentium 开通定单
	 * @param fromMsgFOffer 开通服务产品
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] finishSFOfferGroup( IOVMsgFRequest fromPentium,
			IOVMsgFOffer fromMsgFOffer,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 按照服务订购模型完成开通服务产品生成
	 * @param fromRequest 开通定单
	 * @param fromNature 开通定单服务
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOfferCompete( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromNature,  
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 按照单产品订购模型完成开通服务产品生成
	 * @param fromRequest 开通定单
	 * @param fromNature 开通定单服务
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOfferPrice( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromNature,  
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 按照服务产品多次订购模型完成开通服务产品生成
	 * @param fromRequest 开通定单
	 * @param fromNature 开通定单服务
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOfferMultle( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromNature,  
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单订购完成开通工单订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFOffer 开通订购
	 * @param fromUpffmx 开通定单组
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFNetWork( IOVMsgFRequest fromRequest, 
			IOVMsgFOffer fromMsgFOffer,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
}
