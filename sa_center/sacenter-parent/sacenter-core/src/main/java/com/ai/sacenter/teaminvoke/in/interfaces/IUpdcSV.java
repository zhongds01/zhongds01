package com.ai.sacenter.teaminvoke.in.interfaces;

import java.rmi.RemoteException;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务请求接口服务</p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcSV {
	/**
	 * 申请服务普通定单
	 * @param fromPentium 服务请求单
	 * @param fromUpdcpm 服务能力模板
	 * @param fromXML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFOrder(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * 申请成员服务定单
	 * @param fromPentium
	 * @param fromUpdcpm
	 * @param fromXML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFBatch(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * 申请服务群组定单
	 * @param fromPentium 服务群组定单
	 * @param fromUpdcpm 服务群组能力
	 * @param fromXML 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFGroup(IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * 申请服务服务固网定单
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param fromXML
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFCentrex( IOVOrderRequest fromRequest, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * 申请服务服务定单反馈
	 * @param fromRequest 服务定单反馈
	 * @param fromUpdcpm 开通能力
	 * @param fromXML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse applySFCentrex( IOVOrderResponse fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * 申请撤销网元下周期单
	 * @param fromPentium 服务请求单
	 * @param fromUpdcpm 服务能力
	 * @param fromXML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse cancelSFExpire( IOVOrderRequest fromPentium, 
			IUpfgkmOfferHome fromUpdcpm,
			String fromXML ) throws RemoteException,Exception;
	/**
	 * 挂起服务激活落地定单
	 * @param aVM_ORDER_ID 业务流水号
	 * @param aBILL_ID  用户号码
	 * @param aVM_REASON 挂起原因
	 * @param aADDIN_XML
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void suspendSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * 激活服务激活落地定单
	 * @param aVM_ORDER_ID 业务流水号
	 * @param aBILL_ID 用户号码
	 * @param aVM_REASON 激活原因
	 * @param aADDIN_XML
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void resumeSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * 服务激活落地定单撤单
	 * @param aVM_ORDER_ID 服务订单
	 * @param aBILL_ID 用户号码
	 * @param aVM_REASON 撤单原因
	 * @param aADDIN_XML
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void cancelSFOrder( String aVM_ORDER_ID ,  
			String aBILL_ID ,
			String aVM_REASON,
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * 查询离线记录信息
	 * IOpenApplicException    即开即通查询未处理完成
	 * IOpenRemoteException    即开即通远程处理异常
	 * IOpenException          即开即通[aVM_ORDER_ID]对应记录无效
	 * @param aVM_ORDER_ID
	 * @param aBILL_ID
	 * @param aADDIN_XML
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.HashMap getASKOrder( long aVM_ORDER_ID , 
			String aBILL_ID , 
			String aADDIN_XML ) throws RemoteException,Exception;
	/**
	 * 服务激活任务单转重做
	 * @param aTASK_ID 服务落地单编号
	 * @param aVM_ORG_ID 操作员所在组织编号
	 * @param aVM_STAFF_ID 操作员编号
	 * @param fromASK 其他服务参数
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFTaskRedo(long aTASK_ID[],
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK ) throws RemoteException,Exception;
	/**
	 * 服务激活任务单人工报竣
	 * @param aTASK_ID 服务落地单编号
	 * @param aVM_REASON 人工报竣原因
	 * @param aVM_ORG_ID 操作员所在组织编号
	 * @param aVM_STAFF_ID 操作员编号
	 * @param fromASK 其他服务参数
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFTaskComplete(long aTASK_ID[],
			String aVM_REASON,
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK ) throws RemoteException,Exception;
	/**
	 * 服务激活任务单异常回单
	 * @param aTASK_ID 服务落地单编号
	 * @param aVM_REASON 异常原因描述
	 * @param aVM_ORG_ID 操作员所在组织编号
	 * @param aVM_STAFF_ID 操作员编号
	 * @param fromASK 其他服务参数
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFTaskException( long aTASK_ID[],
			String aVM_REASON,
			String aVM_ORG_ID,
			String aVM_STAFF_ID,
			java.util.HashMap fromASK) throws RemoteException,Exception;
}
