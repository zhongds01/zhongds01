package com.ai.sacenter.receive.exigence.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年6月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcpmSRV {
	/**
	 * 服务固网定单默认异步归档[异步方式]
	 * @param fromRocket 开通异步反馈
	 * @param fromUpdcpm 服务归档能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmDefault( IOVMocketRespone fromRocket,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	
	/**
	 * 服务固网定单异步归档[异步方式]
	 * @param fromRocket 开通异步反馈
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmComplete(IOVMocketRespone fromRocket,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据开通定单项获取当前开通定单项归档解决组件
	 * @param fromRocket 开通定单项
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfgkmComplete( IOVMocketExigence fromRocket,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 完成当前开通定单项异常归档
	 * @param fromMBean 全局事务
	 * @param fromRocket 开通定单项
	 * @param aEXCEPTION 异常类型
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmComplete(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	
}
