package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 网元到期指令资产</p>
 * <p>Copyright: Copyright (c) 2017年2月27日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfwmExpireImpl extends IUpfwmCapitalImpl {
	public IUpfwmExpireImpl() {
		super();
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception {
		return super.finishSFUpdfwm(fromOrder, fromTASK, fromUpdfwm, aContext);
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Library: IUpffmxSuspendImpl</p>
	 * <p>Description: 网元到期停机资产[到期指令][服务开通资产]</p>
	 * <p>Copyright: Copyright (c) 2017年2月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmSuspendImpl extends IUpfwmExpireImpl{
		public IUpfwmSuspendImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmExpireImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfwmFactory.getIUpffmxSV().finishSFUpfgkmSuspend(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Library: IUpffmxResumeImpl</p>
	 * <p>Description: 网元到期复机资产[到期指令][服务开通资产]</p>
	 * <p>Copyright: Copyright (c) 2017年2月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmResumeImpl extends IUpfwmExpireImpl{
		public IUpfwmResumeImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmExpireImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfwmFactory.getIUpffmxSV().finishSFUpfgkmResume(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Library: IUpffmxChangeImpl</p>
	 * <p>Description: 网元到期变更资产[到期指令][服务开通资产]</p>
	 * <p>Copyright: Copyright (c) 2017年2月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmChangeImpl extends IUpfwmExpireImpl{
		public IUpfwmChangeImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmExpireImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfwmFactory.getIUpffmxSV().finishSFUpfgkmChange(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Library: IUpffmxHistoryImpl</p>
	 * <p>Description: 网元到期转历史资产[到期指令][服务开通资产]</p>
	 * <p>Copyright: Copyright (c) 2017年2月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmHistoryImpl extends IUpfwmExpireImpl{
		public IUpfwmHistoryImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmExpireImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfwmFactory.getIUpffmxSV().finishSFUpfgkmHistory(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}
	}
}
