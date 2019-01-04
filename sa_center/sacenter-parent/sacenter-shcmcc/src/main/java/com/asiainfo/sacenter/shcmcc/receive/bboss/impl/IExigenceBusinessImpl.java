package com.asiainfo.sacenter.shcmcc.receive.bboss.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.target.dbcp.IUpdbsSystemImpl;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.asiainfo.sacenter.shcmcc.receive.bboss.IBusinessSystemImpl;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: 与订单中心交互接口</p>
 * <p>Copyright: Copyright (c) 2018年8月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IExigenceBusinessImpl extends IBusinessSystemImpl {

	public IExigenceBusinessImpl() {
		super();
	}

	/**
	 * 
	 * <p>Title: sacenter-shcmcc</p>
	 * <p>Description: 基于固网归档组件</p>
	 * <p>Copyright: Copyright (c) 2017年6月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IExigenceNotifyImpl extends IUpdbsSystemImpl{
		public IExigenceNotifyImpl(){
			super();
		}
		
		/**
		 * 
		 * <p>Library: IUpdbfmxOrderImpl</p>
		 * <p>Description: 完成开通定单通知定单中心</p>
		 * @param fromMBean 服务事务
		 * @param fromOrder 服务归档单
		 * @param fromUpdcpm 服务归档组件
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpdbfmxOrder(MBeanDelegate fromMBean,
				IOVUpdbsComplete fromOrder,
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			IOVMocketRespone fromASK = null;
			try
			{
				fromASK = ExigenceUtils.IRsRsp._wrap(fromOrder, fromUpdcpm, aContext);
				String fromRsRsp = ExigenceUtils.IRocket._jj_response( fromASK );
				if( log.isDebugEnabled() ) log.debug("Centrex:" + fromRsRsp );
				ReflectUtils.IReflect.invokeCallCsf( fromOrder,
						"order_IOpen2OrderCSV_openBack",
						new Object[]{ fromRsRsp }, 
						fromUpdcpm.getPROGRAM().getPLATFORM() );
			}
			finally{
				if( fromASK != null ){ fromASK = null; }
			}
		}
		
	}
}
