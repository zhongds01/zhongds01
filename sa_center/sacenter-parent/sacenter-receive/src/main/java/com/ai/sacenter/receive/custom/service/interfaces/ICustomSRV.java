package com.ai.sacenter.receive.custom.service.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrderOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireOffer;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 客户中心内部服务</p>
 * <p>Copyright: Copyright (c) 2016年3月23日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ICustomSRV {
	/**
	 * 根据用户编号查询预转载用户以及其订购关系
	 * @param aUserId 用户编号
	 * @param aRegionId 用户所在地市
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUser getSFUserByUserId( long aUserId, String aRegionId) throws SFException,Exception;
	/**
	 * 根据用户编号查询预转载用户[下周期专用]
	 * @param aUserId 用户编号
	 * @param aRegionId 地市编码
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserLoader( long aUserId[], String aRegionId) throws SFException,Exception;
	/**
	 * 根据用户编号查询用户策划信息
	 * @param aUserId 用户编号
	 * @param aRegionId 用户所在地市
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUser getSFUserOfferByUserId( long aUserId, String aRegionId) throws SFException,Exception;
	/**
	 * 根据策划实例编号查询对应策划关系
	 * @param aInsOfferId 策划实例编号
	 * @param aRegionId 策划所在地市
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFUserOfferByInsOfferId( long aInsOfferId, String aRegionId ) throws SFException,Exception;
	/**
	 * 根据开通用户查询用户订购关系
	 * @param aUserId 用户编号
	 * @param aRegionid 地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFUserOrderByUserId( long aUserId, String aRegionid ) throws SFException,Exception;
	/**
	 * 根据用户编号查询用户群组关系
	 * @param aUserId 用户编号
	 * @param aRegionId 地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFUserGroupByUserId( long aUserId, String aRegionId ) throws SFException,Exception;
	/**
	 * 根据用户服务订购查询用户订购组
	 * @param fromMsgFUser
	 * @param fromMsgFOffer
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserCentrex getSFUserCentrex( IOVMsgFUser fromMsgFUser, 
			IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * 根据用户服务订购查询用户订购关系
	 * @param fromMsgFUser 开通用户
	 * @param fromMsgFOffer 开通产品
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrder getSFUserOrder( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * 根据策划实例编号查询对应群组策划关系
	 * @param aInsOfferId 策划实例编号
	 * @param aRegionId 策划所在地市
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrderOffer getSFGroupOrderOffer( long aInsOfferId, String aRegionId ) throws SFException,Exception;
	/**
	 * 根据用户定单服务查询用户产品对应策划关系
	 * @param fromMsgFUser 开通用户
	 * @param fromMsgFOffer 开通产品
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOrderOffer getSFOrderOffer( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * 根据开通定单服务查询该产品对应策划用户
	 * @param fromMsgFUser 开通用户
	 * @param fromMsgFOffer 开通定单服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFOfferUser( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * 根据开通定单服务查询该产品对应群组主用户
	 * @param fromMsgFUser 开通用户
	 * @param fromMsgFOffer 开通定单服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFGroupUser( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * 根据开通用户查询该用户对应当前生效套餐
	 * @param fromMsgFUser 开通用户
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFUserOffer( IOVMsgFUser fromMsgFUser ) throws SFException,Exception;
	/**
	 * 根据开通定单服务查询该服务产品对应实例策划
	 * @param fromMsgFUser 开通用户
	 * @param fromMsgFOffer 开通定单服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFUserOffer( IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer ) throws SFException,Exception;
	/**
	 * 根据到期服务产品获取用户订购关系
	 * @param fromExpUser 到期工单
	 * @param fromExpOffer 到期服务产品
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUserOrder getSFUserOrder( IOVExpireUser fromExpUser, IOVExpireOffer fromExpOffer ) throws SFException,Exception; 
	/**
	 * 根据客户编号查询客户信息
	 * @param aCustomId 客户编号
	 * @param aCustomType 客户类型
	 * @param aRegionId 地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVCustom getSFCustom( long aCustomId, String aCustomType, String aRegionId ) throws SFException,Exception;
}
