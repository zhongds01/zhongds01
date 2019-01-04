package com.ai.sacenter.comptel.valuebean;

import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;
import com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务产品订购扩展属性类</p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdcpfxOfferImpl extends IOVUpdcpSystemImpl{
	public IOVUpdcpfxOfferImpl() {
		super();
	}
	
	public IOVUpdcpfxOfferImpl( long fromCOMPETE,
			IUpfgsmOffer fromCATALOG,
			IProductOffer fromPROVIDER){
		super( fromCOMPETE, fromCOMPETE, fromCATALOG, fromPROVIDER );
	}
}
