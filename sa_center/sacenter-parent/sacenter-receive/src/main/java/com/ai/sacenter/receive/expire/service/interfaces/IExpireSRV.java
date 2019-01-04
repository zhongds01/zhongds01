package com.ai.sacenter.receive.expire.service.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxDirectory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年3月7日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExpireSRV {
	/**
	 * 根据用户编号转载当前到期工单用户
	 * @param aUSER_ID 用户编号
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpdfmxDirectory getSFUpffxUser(long aUSER_ID, String aREGION_ID )  throws SFException, Exception;
	/**
	 * 根据用户编号和到期时间查询当前到期工单用户
	 * @param aUSER_ID 用户编号
	 * @param aREGION_ID 地市编码
	 * @param fromExpire 到期时间
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVExpireUser getSFUpffxUser( long aUSER_ID, String aREGION_ID, long fromExpire) throws SFException, Exception;
	/**
	 * 根据开通定单装载到二级缓存中
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxLoad( IOVMsgFRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 完成到期用户到期工单回收
	 * @param fromRequest 开通定单
	 * @param fromUser 开通用户
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxRecycle(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromUser,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通用户完成当前用户下周期以及其订购关系历史归档
	 * @param fromRequest 开通定单
	 * @param fromUser 开通用户
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxHistory(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromUser,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单订购完成下周期订购关系归档
	 * @param fromOrder 开通定单
	 * @param fromUser 开通用户
	 * @param fromOffer 开通定单订购
	 * @param fromUpdcpm 开通接入能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxHistory( IOVMsgFRequest fromOrder, 
			IOVMsgFUser fromUser, 
			IOVMsgFOffer fromOffer,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据到期用户完成到期工单沉淀
	 * @param fromOrder 开通定单
	 * @param fromUser 开通用户
	 * @param fromExpire 到期时间
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVExpireUser finishSFUpffxUser(IOVMsgFRequest fromOrder, 
			IOVMsgFUser fromUser, 
			java.sql.Timestamp fromExpire,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据开通定单订购完成到期工单订购关系
	 * @param fromOrder 开通定单
	 * @param fromUser 开通用户
	 * @param fromOffer 开通到期订购
	 * @param fromExpire 到期时间
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpffxExpire(IOVMsgFRequest fromOrder, 
			IOVMsgFUser fromUser, 
			IOVMsgFOffer fromOffer,
			java.sql.Timestamp fromExpire,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 完成到期下周期批开
	 * @param fromMBean 事务句柄
	 * @param fromExpireHome 到期工单 
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpffxComplete( MBeanDelegate fromMBean, 
			IUpfgkmCityHome fromExpireHome,
			IUpdcContext aContext) throws RemoteException, Exception;
}
