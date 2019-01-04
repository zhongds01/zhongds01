package com.asiainfo.sacenter.shcmcc.comptel.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.comptel.dbcp.IMappingSystemImpl;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.asiainfo.sacenter.shcmcc.comptel.dbcp.IMappingComptelImpl;
import com.asiainfo.sacenter.shcmcc.util.ExigenceUtils;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年4月19日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IMappingExigenceImpl extends IMappingComptelImpl {

	public IMappingExigenceImpl() {
		super();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: RC2密码解密映射规范</p>
	 * <p>Copyright: Copyright (c) 2017年1月25日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingPSWDImpl extends IMappingSystemImpl{
		
		public IMappingPSWDImpl() {
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm,
				IOVOrderUser fromUser, 
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				Object fromUpffmx = UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromUser.getNATURE(), 
						aCOMPLEX, 
						aContext);
				if( fromUpffmx != null && ClassUtils.IClass.isPrimitive( fromUpffmx ) ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, 
							ExigenceUtils.RC2._password( fromUpffmx.toString() ) );
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpdffsm(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, 
				java.util.Map fromOffer,
				IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						aCOMPLEX, 
						aContext);
				if( fromUpffmx != null ){
					fromUpffmx = ExigenceUtils.RC2._password( fromUpffmx.toString() );
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
}
