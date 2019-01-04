package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.dbcp.IUpdcpmCapitalImpl;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务网元工单组件</p>
 * <p>Copyright: Copyright (c) 2014-7-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmSystemImpl extends IUpdcpmCapitalImpl {

	public IUpfwmSystemImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年1月25日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmOfferCreateImpl extends IUpfwmSystemImpl{
		public IUpfwmOfferCreateImpl(){
			super();
		}
		/**
		 * 根据网元工单完成网元级映射类组件
		 * @param fromUpfwm 网元工单
		 * @param fromUpdfwm 激活指令集
		 * @param fromUpdcpm 服务映射组件
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.HashMap finishSFUpfwmOffer(IOVUpfwmOffer fromUpfwm, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			java.util.HashMap fromUpffx = null;
			try
			{
				fromUpffx = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmOffer(fromUpfwm, 
						fromUpdfwm, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				
			}
			return fromUpffx;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元工单异常策略组件</p>
	 * <p>Copyright: Copyright (c) 2014-8-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmSubFlowCreateImpl extends IUpfwmSystemImpl{
		public IUpfwmSubFlowCreateImpl(){
			super();
		}
		/**
		 * 空操作[网元级异常报竣组件]
		 * @param fromUpfwm 网元工单
		 * @param fromUpdfwm 网元指令
		 * @param fromUpdcpm 异常策略组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfwmException( IOVUpfwmOffer fromUpfwm, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
			    IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IUpfwmFactory.getIUpfwmSV().finishSFUpfwmException(fromUpfwm, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * 转重做队列策略[后台队列自动处理]
		 * @param fromUpfwm 网元工单
		 * @param fromUpdfwm 网元指令
		 * @param fromUpdcpm 异常策略组件
		 * @param aEXCEPTION 异常类型
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfwmRetry( IOVUpfwmOffer fromUpfwm, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
			    IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IUpfwmFactory.getIUpfwmSV().finishSFUpfwmQueue(fromUpfwm, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
	}
}
