package com.ai.sacenter.tykt.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.dbcp.impl.IUpfbpmCapitalImpl;
import com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.tykt.IUpfgkmFactory;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 与统一开通指令资产</p>
 * <p>Copyright: Copyright (c) 2011-10-29</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmCapitalImpl extends IUpfwmCapitalImpl {
	public IUpfgkmCapitalImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-tykt</p>
	 * <p>Description: 与统一开通浙江版本同步指令</p>
	 * <p>Copyright: Copyright (c) 2016年1月26日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmProtocolImpl extends IUpfbpmCapitalImpl{
		public IUpfgkmProtocolImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfbpmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmSync(fromOrder, 
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
	 * <p>Title: sacenter-tykt</p>
	 * <p>Description: 与统一开通异步单(开通中心版本)</p>
	 * <p>Copyright: Copyright (c) 2016年1月26日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmDirectImpl extends IUpfwmCapitalImpl{
		public IUpfgkmDirectImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfgkmFactory.getIUpfgkmSV().finishSFUpfwmCreate(fromOrder, 
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
	 * <p>Title: sacenter-tykt</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年1月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmChangeImpl extends IUpfwmCapitalImpl{
		public IUpfgkmChangeImpl(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfgkmFactory.getIUpfgkmSV().finishSFUpfwmChange(fromOrder, 
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
