package com.ai.sacenter.comptel.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.comptel.IUpdcpSystem;
import com.ai.sacenter.comptel.IUpfgsmSystem;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê10ÔÂ13ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IMappingSystemImpl extends UpdcEclipseImpl implements IUpdcpSystem, IUpfgsmSystem {

	public IMappingSystemImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.IUpdcpSystem#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.IUpdcpSystem#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm,
			IOVOrderUser fromUser, 
			IUpdcContext aContext) throws SFException, Exception {
		return null;
	}

	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.IUpdcpSystem#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer, com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.comptel.bo.IOVUpdcpOffer, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgsmc(IProfessionalTemplate.IProductOffer fromUpdbcpm, 
			IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, 
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.IUpdcpSystem#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer, com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.comptel.bo.IOVUpdcpOffer, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgsmc(IProfessionalTemplate.IProductOffer fromUpdbcpm, 
			IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, 
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.IUpfgsmSystem#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, 
			java.util.Map fromOffer,
			IUpdcContext aContext) throws SFException, Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.IUpfgsmSystem#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, 
			java.util.Map fromOffer,
			IUpdcContext aContext) throws SFException, Exception {
		return null;
	}
}
