package com.asiainfo.sacenter.shcmcc.provision.tykt.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.tykt.util.IUpfgkmUtils;
import com.ai.sacenter.tykt.valuebean.IOVUpfgkmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: 上海本地统一开通资产</p>
 * <p>Copyright: Copyright (c) 2017年4月6日</p>
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
	 * <p>Title: sacenter-shcmcc</p>
	 * <p>library: IUpfgkmModifyCfuImpl</p>
	 * <p>Description: 功能变更带清数据属性</p>
	 * <p>Copyright: Copyright (c) 2017年4月6日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmModifyImpl extends IUpfgkmCapitalImpl{
		public IUpfgkmModifyImpl(){
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
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmCreate(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				if( fromTASK.isPARALLEL() == false ){
					IOVUpfwmOffer.IUpfwmOfferHome fromOffer = fromUpfwm.getORDER();
					IOVUpfgkmOffer fromINDEX = IUpfgkmUtils.ICustom._wrap(fromOrder, 
							fromTASK, 
							fromUpdfwm, 
							fromUpfwm, 
							aContext);
					fromINDEX.setACTION_ID( fromOffer != null && fromOffer.getCHANGE().size() > 0 ?6:85 );
					UpfsvcManager.getSession().submitISQLLite(fromTASK, 
							fromUpfwm.getORDER().getREPOSITORY(), 
							fromINDEX.getINSTANCE() );
				}
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmCreate(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpfwm, 
						aContext);
			}
			finally{
				if( fromUpfwm != null ){ fromUpfwm = null; }
			}
			return fromASK;
		}
	}
}
