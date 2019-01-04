package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.util.CarbonList;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 与客户中心对接,并且缓存加载</p>
 * <p>Copyright: Copyright (c) 2016年3月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ICustomSRV {
	/**
	 * 根据用户编号查询客户中心用户资料
	 * @param aUSER_ID 用户编号
	 * @param aREGION_ID 用户归属地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFUser( long aUSER_ID, String aREGION_ID ) throws SFException,Exception; 
	/**
	 * 根据客户编号获取客户信息
	 * @param aCUSTOM_ID 客户编号
	 * @param aCUSTOM_TYPE 客户类型
	 * @param aREGION_ID 客户归属地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVCustom getSFCustom( long aCUSTOM_ID, String aCUSTOM_TYPE, String aREGION_ID ) throws SFException,Exception; 
	/**
	 * 根据开通用户查询用户订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通用户
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] getSFUserOrder( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser ) throws SFException,Exception;
	/**
	 * 根据开通服务订购查询用户对应本周服务订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通用户
	 * @param fromMsgFOffer 开通服务订购
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] getSFUserOrder( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer) throws SFException,Exception;
	/**
	 * 根据用户编号查询用户全部有效订购关系
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通用户
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFUser getSFUserCentrex( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser ) throws SFException,Exception;
	/**
	 * 根据受理时间和生效类型开通用户资费包
	 * @param fromRequest 开通定单
	 * @param fromMsgFUser 开通用户
	 * @param fromVALID 生效类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFUser getSFUserCentrex( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser, int fromVALID ) throws SFException,Exception;
	/**
	 * 根据开通产品查询该产品对应用户资料
	 * @param fromRequest 开通定单
	 * @param fromOffer 开通产品
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFOfferUser( IOVMsgFRequest fromRequest, IOVMsgFOffer fromOffer ) throws SFException,Exception;
	/**
	 * 根据开通用户是否为当前商务虚拟网成员
	 * @param fromUser 开通用户
	 * @return 不为空则为商务虚拟网成员
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFUserVpmnType( IOVMsgFUser fromUser ) throws SFException,Exception;
	/**
	 * 根据开通产品查询该服务产品对应实例策划
	 * @param fromUser 开通用户
	 * @param fromOffer 开通定单服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFGroupOffer( IOVMsgFUser fromUser, IOVMsgFOffer fromOffer ) throws SFException,Exception;
	/**
	 * 根据用户列表加载用户订购信息
	 * @param fromUpdfmx 用户列表
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserLoad( java.util.Map<String, CarbonList<Long>> fromUpdfmx ) throws SFException,Exception;
	/**
	 * 根据用户编号查询预转载用户
	 * @param fromRequest 开通定单
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFCentrexUser( IOVMsgFRequest fromRequest ) throws SFException,Exception;
}
