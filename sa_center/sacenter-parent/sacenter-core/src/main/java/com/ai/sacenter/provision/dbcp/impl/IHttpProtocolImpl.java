package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.impl.UpfwmHttpClient;
import com.ai.sacenter.provision.mstp.impl.UpfwmSoapClient;
import com.ai.sacenter.provision.mstp.impl.UpfwmTsnpClient;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 基于XML报文Http协议封装</p>
 * <p>Copyright: Copyright (c) 2015年10月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IHttpProtocolImpl extends IUpfwmProtocolImpl {
	public IHttpProtocolImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.dbcp.IUpfwmClient, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IUpfwmClient fromNetWork,
			IOVUpfwmRequest fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		String  fromRsBody = null;
		try
		{
			UpfwmHttpClient fromClient = (UpfwmHttpClient)fromNetWork;
			String fromPLMMX = (String)fromUpdcpm.getPLATFORM().getORIGINAL();
			fromRsBody = (String)fromClient.call( fromPLMMX );
		}
		finally{
			
		}
		return fromRsBody;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 基于Map报文Http协议封装</p>
	 * <p>Copyright: Copyright (c) 2015年10月28日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class HttpMapProtocolImpl extends IUpfwmProtocolImpl{
		public HttpMapProtocolImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishRQKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpfwmRequest finishRQKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				IOVUpfwmRequest fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception {
			try
			{
				java.util.HashMap fromUpfgsm = new java.util.HashMap();
				IPlatformTemplate.IUpffgsmOffer fromUpfgsmc[] = null;
				fromUpfgsmc = UpfgsmUtils.ICustom.getICSTKUpfgsmc();
				for( int index = 0; fromUpfgsmc != null && index < fromUpfgsmc.length; index++){
					Object fromPARAM = fromUpdcpm.getSUBFLOW().getPLATFORM().get( 
							fromUpfgsmc[index].getMAPPING() );
					Class fromTYPE = ClassUtils.IClass.wrap( fromUpfgsmc[index].getCATEGORY() );
					fromUpfgsm.put( fromUpfgsmc[index].getMAPPING(), 
							ClassUtils.IClass.transfer( fromPARAM , fromTYPE ) );
				}
				fromUpdcpm.getPLATFORM().setORIGINAL( fromUpfgsm );
				fromUpdcpm.getPLATFORM().setBOTTOM( XmlUtils.createNoformatXml( 
						"ucmframe", fromUpfgsm ) );
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.dbcp.IUpfwmClient, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				IUpfwmClient fromNetWork,
				IOVUpfwmRequest fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception {
			Object  fromRsBody = null;
			try
			{
				UpfwmHttpClient fromClient = (UpfwmHttpClient)fromNetWork;
				java.util.Map fromPLMMX = (java.util.Map)fromUpdcpm.getPLATFORM().getORIGINAL();
				fromRsBody = fromClient.call( fromPLMMX );
			}
			finally{
				
			}
			return fromRsBody;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 基于SOAP通信协议封装</p>
	 * <p>Copyright: Copyright (c) 2015年10月28日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class HttpSoapProtocolImpl extends IUpfwmProtocolImpl{
		public HttpSoapProtocolImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.dbcp.IUpfwmClient, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				IUpfwmClient fromNetWork,
				IOVUpfwmRequest fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception {
			String fromASK = null;
			try 
			{
				UpfwmSoapClient fromClient = (UpfwmSoapClient)fromNetWork;
				IOVUpfwmRequest.IUpffmxOfferHome fromUpffmxHome = fromUpdcpm.getPLATFORM();
				fromASK = fromClient.call( (String)fromUpffmxHome.getORIGINAL() );
			}
			finally{

			}
			return fromASK;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 基于网状网通信协议封装</p>
	 * <p>Copyright: Copyright (c) 2015年10月28日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class HttpTsnpProtocolImpl extends IUpfwmProtocolImpl{
		public HttpTsnpProtocolImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishRQKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpfwmRequest finishRQKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				IOVUpfwmRequest fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception {
			try
			{
				fromUpdcpm.getPLATFORM().setORIGINAL( new java.util.HashMap( 
						fromUpdcpm.getSUBFLOW().getPLATFORM() ) );
				fromUpdcpm.getPLATFORM().setBOTTOM( XmlUtils.createNoformatXml( 
						"ucmframe", fromUpdcpm.getSUBFLOW().getPLATFORM() ) );
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.dbcp.IUpfwmClient, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				IUpfwmClient fromNetWork,
				IOVUpfwmRequest fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception {
			UpfwmTsnpClient.UpfwmTsnpRsp fromRsRsp = null;
			UpfwmTsnpClient.UpfwmTsnpReq fromRsReq = null;
			try 
			{
				UpfwmTsnpClient fromClient = (UpfwmTsnpClient) fromNetWork;
				IOVUpfwmRequest.IUpffmxOfferHome fromUpffmxHome = fromUpdcpm.getPLATFORM();
				fromRsReq = new UpfwmTsnpClient.UpfwmTsnpReq();
				ClassUtils.IClass.transfer( (java.util.Map)fromUpffmxHome.getORIGINAL(), fromRsReq);
				fromRsRsp = fromClient.call(fromRsReq);
			} 
			finally{
				if( fromRsReq != null ){ fromRsReq = null; }
			}
			return fromRsRsp;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishASKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				Object fromRsBody,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromUpdcpm = null;
			UpfwmTsnpClient.UpfwmTsnpRsp fromRsRsp = null;
			try
			{
				fromUpdcpm = new IOVUpfwmResponse( fromUpfwm );
				fromRsRsp = (UpfwmTsnpClient.UpfwmTsnpRsp)fromRsBody;
				fromUpdcpm.setRspCode  ( fromRsRsp.getRsRspCode() );
				fromUpdcpm.setRspDesc  ( fromRsRsp.getRsRspDesc() );
				fromUpdcpm.setRspBottom( fromRsRsp.getXmlHome  () );
			}
			finally{
				if( fromRsRsp != null ){ fromRsRsp = null; }
			}
			return fromUpdcpm;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 基于HSS/HLR通信协议封装</p>
	 * <p>Copyright: Copyright (c) 2015年10月28日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class HSSSoapProtocolImpl extends HttpSoapProtocolImpl{
		public HSSSoapProtocolImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishASKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				Object fromRsBody,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromUpdcpm = null;
			try
			{
				fromUpdcpm = new IOVUpfwmResponse( fromUpfwm );
				String fromXML = (String)fromRsBody.toString();
				XmlUtils.XPath( fromXML, fromUpdcpm.getORDER().getSUBFLOW() );
				String aResultCode = (String)ReflectUtils.xPath("Body/*/Result/ResultCode", 
						fromUpdcpm.getORDER().getSUBFLOW() );
				String aResultDesc = (String)ReflectUtils.xPath("Body/*/Result/ResultDesc", 
						fromUpdcpm.getORDER().getSUBFLOW() );
				fromUpdcpm.setFAILURE( StringUtils.equals( aResultCode, "0" )?
						Boolean.FALSE:Boolean.TRUE );
				fromUpdcpm.setRspCode  ( aResultCode );
				fromUpdcpm.setRspDesc  ( aResultDesc );
				fromUpdcpm.setRspBottom( fromXML     );
			}
			finally{
			
			}
			return fromUpdcpm;
		}
	}
}
