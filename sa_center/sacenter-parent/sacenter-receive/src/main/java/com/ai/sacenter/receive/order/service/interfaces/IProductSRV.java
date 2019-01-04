package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 与产品中心对接</p>
 * <p>Copyright: Copyright (c) 2016年3月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IProductSRV {
	/**
	 * 根据服务产品查询服务产品规范
	 * @param fromCOMPETE
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFProductOffer( long fromCOMPETE ) throws SFException,Exception;
	/**
	 * 根据服务属性查询服务产品规范
	 * @param fromMsgFOfferX
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFProductOffer( IOVMsgFOfferX fromMsgFOfferX ) throws SFException,Exception;
	/**
	 * 根据服务编号查询是否归属开通服务产品域
	 * @param fromOffer
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFProductBelong( IOVMsgFOffer fromOffer ) throws SFException,Exception;
	/**
	 * 根据用户服务产品查询服务产品规范
	 * @param fromMsgF 开通定单
	 * @param fromOffer 开通定单订购属性
	 * @param fromUpdcpm 开通接入能力
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFProductOffer( IOVMsgFRequest fromMsgF, 
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * 根据用户服务产品查询服务产品开通规范
	 * @param fromCOMPETE
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductComptel getSFProductNature( String fromCOMPETE ) throws SFException,Exception;
	/**
	 * 根据用户服务产品查询服务产品开通模式
	 * @param fromMsgF
	 * @param fromOffer
	 * @param fromUpdcpm
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductComptel getSFProductNature(IOVMsgFRequest fromMsgF, 
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * 根据服务产品组查询服务产品组规范
	 * @param fromGroup 服务产品组
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductGroup getSFProductGroup( String fromGroup ) throws SFException,Exception;
	/**
	 * 根据开通服务产品查询开通同组服务映射规范
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通服务订购
	 * @param fromUpdcpm 开通接入能力
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductGroup getSFProductGroup( IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * 服务产品订购归属到期系统组[非下周期批开]
	 * @param fromRequest 开通定单
	 * @param fromUser 开通用户
	 * @param fromOffer 开通产品
	 * @return 不为NULL则服务产品订购归属到期系统，否则归属开通下周期批开系统
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductCatalog[] getSFExpireGroup( IOVMsgFRequest fromRequest,
			IOVMsgFUser fromUser, 
			IOVMsgFOffer fromOffer) throws SFException,Exception;
	/**
	 * 查询当前虚拟网
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductCombine getSFPVpmnGroup( ) throws SFException,Exception;
}
