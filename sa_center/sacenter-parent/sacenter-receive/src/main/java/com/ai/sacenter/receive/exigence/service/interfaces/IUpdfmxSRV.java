package com.ai.sacenter.receive.exigence.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketConsult;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通定单项组件资产</p>
 * <p>Copyright: Copyright (c) 2018年1月31日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public interface IUpdfmxSRV {
	/**
	 * 当前开通定单项历史归档[开通定单调度类]
	 * @param fromMBean 全局事务
	 * @param fromRocket 开通定单项
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdfmxHistory(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 当前开通定单项人工跳单[开通定单调度类]
	 * @param fromMBean 全局事务
	 * @param fromRocket 开通定单项
	 * @param aEXCEPTION 人工跳单原因
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdfmxHistory(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 开通定单按用户分解组件[开通定单分解类]
	 * @param fromRocket 开通定单
	 * @param fromUpdfmx 开通分解组
	 * @param fromUpdcpm 服务接入能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMocketConsult finishSFUpdfmxDefault( IOVMsgFExigence fromRocket,
			IOVMocketConsult fromUpdfmx,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 当前开通定单项历史归档[开通定单项异常组件]
	 * @param fromMBean 全局事务
	 * @param fromRocket 开通定单项
	 * @param fromUpdcpm 异常归档组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmHistory(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 当前开通定单项重做归档[开通定单项异常组件]
	 * @param fromMBean 全局事务
	 * @param fromRocket 开通定单项
	 * @param fromUpdcpm 异常归档组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmConnection(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 当前开通定单项失败归档[开通定单项异常组件]
	 * @param fromMBean 全局事务
	 * @param fromRocket 开通定单项
	 * @param fromUpdcpm 异常归档组件
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmException(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 当前开通定单项沉淀开通调用轨迹
	 * @param fromMBean 服务事务
	 * @param fromRocket 开通定单项
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdfmxLifite( MBeanDelegate fromMBean, 
			IOVMocketExigence fromRocket,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
}
