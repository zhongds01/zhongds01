package com.asiainfo.sacenter.shcmcc.provision.dsmp.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.IDsmapFactory;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年3月20日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IDsmapCapitalImpl extends IUpfwmCapitalImpl {
	public IDsmapCapitalImpl() {
		super();
	}
	/**
	 * IDsmapJWPIfoImpl
	 * <p>Title: sacenter-shcmcc</p>
	 * <p>Description: 本地DSMP订购关系同步</p>
	 * <p>Copyright: Copyright (c) 2017年3月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IDsmapJWPIfoImpl extends IDsmapCapitalImpl{
		public IDsmapJWPIfoImpl(){
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
				fromASK = IDsmapFactory.getIDsmapSV().finishSFOfferSync(fromOrder, 
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
	 * IDsmapAllSTSImpl
	 * <p>Title: sacenter-zjcmcc</p>
	 * <p>Description: 本地DSMP全量状态同步</p>
	 * <p>Copyright: Copyright (c) 2017年3月21日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IDsmapAllSTSImpl extends IDsmapCapitalImpl{
		public IDsmapAllSTSImpl(){
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
				fromASK = IDsmapFactory.getIDsmapSV().finishSFAllSTSSync(fromOrder, 
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
