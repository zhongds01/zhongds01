package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.bo.IOVUpdcpCatalog;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务产品能力服务</p>
 * <p>Copyright: Copyright (c) 2014-4-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpSRV {
	/**
	 * 根据服务产品规范完成对应服务能力属性规范
	 * @param fromUpfgsm 服务属性规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务产品规范完成对应服务能力属性规范
	 * @param fromUpfgsm 服务能力规范
	 * @param fromCOMPETE 服务属性集
	 * @param fromUser 服务定单用户
	 * @param fromUpdcpm 服务订购集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpfgsmc(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			java.util.List fromCOMPETE,
			IOVOrderUser fromUser,
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务能力规范完成对应服务能力下服务能力规范
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param fromUpdcpm 服务订购集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpOffer( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据当前服务激活能力完成静态数据配置[服务静态遍历规范]规范
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IEnumWrapper finishSFUpdbtxChain( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据当前服务激活能力完成服务能力[服务变化遍历规范]规范
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpChange( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务能力规范完成当前用户服务产品能力遍历规范[服务能力规范]
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer[] finishSFUpdcpOffer( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务能力规范完成当前用户服务类能力遍历规范[服务能力规范]
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpComptel( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务能力规范完成当前用户服务类组遍历规范[服务能力规范]
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpLifite(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务能力规范完成当前用户服务类组合遍历规范[服务能力规范]
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer[] finishSFUpdcpMultle(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务能力规范完成当前用户服务类组合遍历规范[服务能力规范]
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpPriority(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	
	/**
	 * 根据服务能力规范完成当前用户服务批量属性遍历规范[服务能力规范]
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpBatchX( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务能力规范完成当前用户服务用户变量遍历规范[服务能力规范]
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser 服务定单用户
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpUserX( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务能力模板完成服务能力订购规范
	 * @param fromUpfgsm 服务产品规范
	 * @param fromUser  服务用户
	 * @param fromUpdcpm 服务能力模板
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpCatalog finishSFUpdcpModule( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据服务能力模板完成服务能力订购规范
	 * @param fromUser  服务用户
	 * @param fromUpdcpm 服务能力模板
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpCatalog finishSFUpdcpOffer( IOVOrderUser fromUser,
			IProfessionalTemplate.IProductOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据服务能力模板完成服务能力订购规范
	 * @param fromUser 定单用户
	 * @param fromGroup 群组用户
	 * @param fromUpdcpm 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpCatalog finishSFUpdcpOffer(IOVOrderUser fromUser,
			IOVOrderUser fromGroup,
			IProfessionalTemplate.ICompetenceOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 完成服务定单对应服务产品能力订购规范
	 * @param fromRequest 开通定单
	 * @param fromOrder 服务定单
	 * @param fromUser  服务用户
	 * @param fromGroup 群组用户
	 * @param fromUpdcwm 服务能力模板 
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdcpOffer(IOVOrderRequest fromRequest,
			IOVOrderPentium fromOrder,
			IOVOrderUser fromUser,
			IOVOrderUser fromGroup,
			IProfessionalTemplate.ICompetenceOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException, Exception;
}
