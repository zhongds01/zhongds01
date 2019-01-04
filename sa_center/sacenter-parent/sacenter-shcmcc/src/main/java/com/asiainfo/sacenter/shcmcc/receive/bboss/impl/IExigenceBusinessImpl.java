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
 * <p>Description: �붩�����Ľ����ӿ�</p>
 * <p>Copyright: Copyright (c) 2018��8��17��</p>
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
	 * <p>Description: ���ڹ����鵵���</p>
	 * <p>Copyright: Copyright (c) 2017��6��20��</p>
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
		 * <p>Description: ��ɿ�ͨ����֪ͨ��������</p>
		 * @param fromMBean ��������
		 * @param fromOrder ����鵵��
		 * @param fromUpdcpm ����鵵���
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
