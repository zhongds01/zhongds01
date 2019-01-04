package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.dbcp.IUpdcpmCapitalImpl;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务网元定单组件</p>
 * <p>Copyright: Copyright (c) 2015-1-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdffmSystemImpl extends IUpdcpmCapitalImpl {

	public IUpdffmSystemImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元定单归档组件</p>
	 * <p>Copyright: Copyright (c) 2014-7-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdffmCompleteImpl extends IUpdffmSystemImpl{
		public IUpdffmCompleteImpl(){
			super();
		}

		/**
		 * [网元反馈单反馈转历史[服务定单流程调度]]
		 * @param fromOrder 网元定单
		 * @param fromUpdcpm 服务监控组件
		 * @param aContext
		 * @throws Exception
		 */
		public void finishSFUpfwmDefault( IOVUpfwmOrder fromOrder , 
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmHistory(fromOrder, 
						fromUpdcpm,
						aContext);
			}
			finally{
				
			}
		}
		
		/**
		 * [网元反馈单反馈到服务定单[服务定单流程调度]]
		 * @param fromOrder 网元定单
		 * @param fromUpdcpm 服务归档组件
		 * @param aContext
		 * @throws IOpenException
		 * @throws Exception
		 */
		public void finishSFTaskComplete( IOVUpfwmOrder fromOrder , 
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IUpfwmFactory.getIUpffmSV().finishSFTaskComplete(fromOrder, 
						fromUpdcpm,
						aContext);
			}
			finally{
				
			}
		}

		/**
		 * 根据网元反馈业务级策略完成[转错误单[服务定单异常界面,转失败单人工界面]]
		 * @param fromOrder 服务反馈单
		 * @param fromUpdcpm 服务策略组件
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfwmException( IOVUpfwmOrder fromOrder,
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmException(fromOrder, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				
			}
		}
	}
}
