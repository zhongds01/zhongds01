package com.ai.sacenter.comptel.valuebean;

import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer;
import com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务产品订购类</p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdcpOfferImpl extends IOVUpdcpSystemImpl {
	public IOVUpdcpOfferImpl() {
		super();
	}
	
	public IOVUpdcpOfferImpl( long fromCOMPETE, 
			long fromPRODUCT,
			IUpfgsmOffer fromCATALOG,
			IProductOffer fromPROVIDER){
		super( fromCOMPETE, fromPRODUCT, fromCATALOG, fromPROVIDER );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpSystemImpl#getSUBFLOW()
	 */
	public String getSUBFLOW() {
		return ((IUpdbfgsmOffer)_catalog).getSUBFLOW();
	}
	
}
