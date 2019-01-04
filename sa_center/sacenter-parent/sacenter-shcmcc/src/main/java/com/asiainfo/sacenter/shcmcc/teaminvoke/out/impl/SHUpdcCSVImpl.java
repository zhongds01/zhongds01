package com.asiainfo.sacenter.shcmcc.teaminvoke.out.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.IUpdcContextImpl;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.order.OrderFactory;
import com.ai.sacenter.receive.valuebean.IOVMsgFResponse;
import com.ai.sacenter.util.ClassUtils;
import com.asiainfo.sacenter.shcmcc.SHRocketConst;
import com.asiainfo.sacenter.shcmcc.teaminvoke.out.interfaces.ISHUpdcCSV;
import com.asiainfo.sacenter.shcmcc.util.ExigenceUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.receive.IUpdbfsFactory;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFRsRspMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFTextMessage;

/**
 *
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0
 *
 */
public class SHUpdcCSVImpl implements ISHUpdcCSV {
	protected final static Log log = LogFactory.getLog( SHUpdcCSVImpl.class );
	public SHUpdcCSVImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.asiainfo.sacenter.shcmcc.teaminvoke.out.interfaces.ISHUpdcCSV#orderReceive(java.lang.String)
	 */
	public String orderReceive(String fromMetaMX) throws RemoteException, Exception {
		RocketFRsRspMessage fromRsRsp = null;
		RocketFTextMessage fromRocket = null;
		try
		{
			fromRocket = new RocketFTextMessage( fromMetaMX );
			if( log.isDebugEnabled() ) log.debug( fromRocket.getMsgId() + "{" + fromRocket.getText() + "}" );
			fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRocket.getMsgId() + "{" + fromRsRsp.getBody() + "}" );
		}
		catch( java.lang.Exception exception ){
			log.error( (fromRocket != null?fromRocket.getMsgId():exception.getMessage()), exception );
			throw exception;
		}
		finally{
			if( fromRocket != null ){ fromRocket = null; }
		}
		return fromRsRsp.getBody();
	}

	/* (non-Javadoc)
	 * @see com.asiainfo.sacenter.shcmcc.teaminvoke.out.interfaces.ISHUpdcCSV#orderComplete(java.lang.String)
	 */
	public String orderComplete(String fromMetaMX) throws RemoteException, Exception {
		RocketFRsRspMessage fromRsRsp = null;
		RocketFTextMessage fromRocket = null;
		try
		{
			fromRocket = new RocketFTextMessage( fromMetaMX );
			if( log.isDebugEnabled() ) log.debug( fromRocket.getMsgId() + "{" + fromRocket.getText() + "}" );
			fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketCompleteAsyn( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRocket.getMsgId() + "{" + fromRsRsp.getBody() + "}" );
		}
		catch( java.lang.Exception exception ){
			log.error( (fromRocket != null?fromRocket.getMsgId():exception.getMessage()), exception );
			throw exception;
		}
		finally{
			if( fromRocket != null ){ fromRocket = null; }
		}
		return fromRsRsp.getBody();
	}

	/**
	 * 修改Radius系统用户速率接口
	 * @Override 服务-2017-24327 中移在线新一代客服系统_标准化家庭宽带业务功能规格说明书-品质部
	 * 修改Radius系统用户速率接口
	 * @param busiType 4040	固网包年家庭宽带
	 *                  4041	东方有线合作家庭宽带
	 *                  4042	光纤宽带套餐
	 *                  4043	限时宽带—校园
	 *                  4044	校园宽带套餐
	 * @param velocity 速率
	 * @param userName 登陆名 （bill_id）
	 * @return 返回编码::返回信息
	 * @throws Exception
	 */
	public String alterRadiusSpeed(String busiType, String userName, String velocity ) throws Exception {
		SFCenterFactory.pushCenterInfo(SHRocketConst.ICustom.REGION_ID);
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		String retStr = "0::成功";
		try
		{
			IOVUpffmxOffer fromUpffmx = new IOVUpffmxOffer(userName);
			IOVUpfwmOffer fromUpfwm = ExigenceUtils.ICustom._jj_provision(SHRocketConst.ICustom.USER_ID,
					userName,
					SHRocketConst.ICustom.REGION_ID,
					"HangbanZhcx_PBOSSV3",
					"Z9040060510001");
			fromUpffmx.getMAPPING().getMAPPING().put("BusiType",busiType);
			fromUpffmx.getMAPPING().getMAPPING().put("Velocity",velocity);
			fromUpffmx.getMAPPING().getMAPPING().put("UserName",userName);
			fromUpffmx.getMAPPING().getMAPPING().put("Area","021");
			IOVMsgFResponse fromRsRsp = UpdbfsFactory.getIUpdcFSV().orderTransparent(fromUpfwm, fromUpffmx, aContext);
			String retCode = fromRsRsp.getRESULT().getRspCode();
			if(!"IOS0000000".equals(retCode)){
				throw new Exception(fromRsRsp.getRESULT().getRspResult() == null? fromRsRsp.getRESULT().getRspDesc() : fromRsRsp.getRESULT().getRspResult().toString());
			}
		}catch(Exception exception){
			log.error(exception);
			retStr = "1::"+ exception.getMessage();
		}finally{
			SFCenterFactory.popCenterInfo();
			if( aContext !=null ){ aContext.clear(); aContext = null;}
		}

		return retStr;
	}

	/**
	 * 修改radius系统账号状态
	 * @Override 服务-2017-24327 中移在线新一代客服系统_标准化家庭宽带业务功能规格说明书-品质部
	 * @param busiType 4040	固网包年家庭宽带
	 *                  4041	东方有线合作家庭宽带
	 *                  4042	光纤宽带套餐
	 *                  4043	限时宽带—校园
	 *                  4044	校园宽带套餐
	 * @param opType 用户状态 0、正常；1、锁定；
	 * @param userName 登陆名 （bill_id）
	 * @return
	 * @throws Exception
	 */
	public String alterRadiusState(String busiType, String userName, String opType ) throws Exception {
		SFCenterFactory.pushCenterInfo(SHRocketConst.ICustom.REGION_ID);
		IUpdcContext aContext = ClassUtils.getIContextImpl();
		String retStr = "0::成功";
		try
		{
			IOVUpffmxOffer fromUpffmx = new IOVUpffmxOffer(userName);
			IOVUpfwmOffer fromUpfwm = ExigenceUtils.ICustom._jj_provision(SHRocketConst.ICustom.USER_ID,
					userName,
					SHRocketConst.ICustom.REGION_ID,
					"HangbanZhcx_PBOSSV3",
					"Z9040060510001");
			fromUpffmx.getMAPPING().getMAPPING().put("BusiType",busiType);
			fromUpffmx.getMAPPING().getMAPPING().put("OpType",opType);
			fromUpffmx.getMAPPING().getMAPPING().put("UserName",userName);
			fromUpffmx.getMAPPING().getMAPPING().put("Area","021");
			IOVMsgFResponse fromRsRsp = UpdbfsFactory.getIUpdcFSV().orderTransparent(fromUpfwm, fromUpffmx, aContext);
			String retCode = fromRsRsp.getRESULT().getRspCode();
			if(!"IOS0000000".equals(retCode)){
				throw new Exception(fromRsRsp.getRESULT().getRspResult() == null? fromRsRsp.getRESULT().getRspDesc() : fromRsRsp.getRESULT().getRspResult().toString());
			}
		}catch(Exception exception){
			log.error(exception);
			retStr = "1::"+ exception.getMessage();
		}finally{
			SFCenterFactory.popCenterInfo();
			if( aContext !=null ){ aContext.clear(); aContext = null;}
		}

		return retStr;
	}


}
