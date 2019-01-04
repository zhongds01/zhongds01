package com.ai.sacenter.receive.exigence.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.dbcp.IExigenceCapital;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketConsult;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通定单资产</p>
 * <p>Copyright: Copyright (c) 2018年2月27日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class IExigenceCapitalImpl extends UpdcEclipseImpl implements IBusinesCapital,IExigenceCapital {
	public IExigenceCapitalImpl() {
		super();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 开通定单项分解资产</p>
	 * <p>Copyright: Copyright (c) 2018年2月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IRocketExplainImpl extends IExigenceCapitalImpl{
		public IRocketExplainImpl(){
			super();
		}
		
		/**
		 * <p>Library: IUpdfmsxDefaultImpl</p>
		 * <p>Description: 开通定单按用户分解[开通定单分解组件]</p>
		 * @param fromRocket 全局事务
		 * @param fromUpdfmx 开通定单分解组
		 * @param fromUpdcpm 服务接入能力
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMocketConsult finishSFUpdfmxDefault(IOVMsgFExigence fromRocket,
				IOVMocketConsult fromUpdfmx,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVMocketConsult fromConsult = null;
			try
			{
				fromConsult = IExigenceFactory.getIUpdfmxSV().finishSFUpdfmxDefault(fromRocket, 
						fromUpdfmx, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				
			}
			return fromConsult;
		}
	}
}
