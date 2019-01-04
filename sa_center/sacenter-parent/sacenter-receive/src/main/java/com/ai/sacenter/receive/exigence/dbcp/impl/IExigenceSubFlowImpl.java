package com.ai.sacenter.receive.exigence.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.dbcp.IUpdcpmCapitalImpl;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.dbcp.IExigenceCapital;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.order.dbcp.impl.IBusinesSubFlowImpl;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 服务定单异步归档</p>
 * <p>Copyright: Copyright (c) 2017年6月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IExigenceSubFlowImpl extends IBusinesSubFlowImpl implements IExigenceCapital{
	public IExigenceSubFlowImpl(){
		super();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 开通定单项异常归档组件</p>
	 * <p>Copyright: Copyright (c) 2018年1月31日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IRocketSubFlowImpl extends IUpdcpmCapitalImpl{
		public IRocketSubFlowImpl(){
			super();
		}
		
		/**
		 * <p>Library: IUpdfvmDefaultImpl</p>
		 * <p>Description: 当前开通定单项失败归档[开通定单项异常组件]</p>
		 * @param fromMBean 全局事务
		 * @param fromRocket 开通定单项
		 * @param fromUpdcpm 异常归档组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfgkmDefaultImpl(MBeanDelegate fromMBean,
				IOVMocketExigence fromRocket,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmException(fromMBean, 
						fromRocket, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
	
		/**
		 * <p>Library: IUpdfvmHistoryImpl</p>
		 * <p>Description: 当前开通定单项历史归档[开通定单项异常组件]</p>
		 * @param fromMBean 全局事务
		 * @param fromRocket 开通定单项
		 * @param fromUpdcpm 异常归档组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfgkmHistoryImpl(MBeanDelegate fromMBean,
				IOVMocketExigence fromRocket,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmHistory(fromMBean, 
						fromRocket, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		
		/**
		 * <p>Library: IUpdfvmQueueImpl</p>
		 * <p>Description: 当前开通定单项重做归档[开通定单项异常组件]</p>
		 * @param fromMBean 全局事务
		 * @param fromRocket 开通定单项
		 * @param fromUpdcpm 异常归档组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfgkmQueueImpl(MBeanDelegate fromMBean,
				IOVMocketExigence fromRocket,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmConnection(fromMBean, 
						fromRocket, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
	}
}
