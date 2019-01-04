package com.ai.sacenter.tykt.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.dbcp.impl.ISocketProtocolImpl;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.impl.UpfwmSocket;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.tykt.util.IUpfgkmUtils;
import com.ai.sacenter.tykt.valuebean.IOVKtSyncRequest;
import com.ai.sacenter.tykt.valuebean.IOVKtSyncResponse;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年8月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmProtocolImpl extends ISocketProtocolImpl {
	public IUpfgkmProtocolImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishRQKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmRequest finishRQKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IOVUpfwmRequest fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		IOVKtSyncRequest fromKtSyncRqt = null;
		try
		{
			fromKtSyncRqt = new IOVKtSyncRequest();
			IUpfgkmUtils.ICustom._wrap(fromUpfwm, fromUpdfwm, fromKtSyncRqt, aContext);
			fromUpdcpm.getPLATFORM().setORIGINAL( fromKtSyncRqt.toByteArray() );
			fromUpdcpm.getPLATFORM().setBOTTOM  ( fromKtSyncRqt.toString   () );
		}
		finally{
			if( fromKtSyncRqt != null ){ fromKtSyncRqt = null; }
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.ISocketProtocolImpl#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.mstp.IUpfwmClient, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.IUpdcContext)
	 */
	public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			IUpfwmClient fromNetWork,
			IOVUpfwmRequest fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		byte[] fromBytes = null;
		try
		{
			UpfwmSocket fromClient = (UpfwmSocket)fromNetWork;
			IOVUpfwmRequest.IUpffmxOfferHome fromUpffmxHome = fromUpdcpm.getPLATFORM();
			IPlatformTemplate.IUpffmOffer fromUpfm = fromUpdfwm.getPLATFORM();
			byte aBytes[] = MathUtils.IMath.toByteArray( fromUpffmxHome.getORIGINAL() );
			fromClient._write( aBytes );
			
			byte fromAISC[] = new byte[ 8 + 182 ];
			int fromReadSize = fromClient._read( fromAISC, 0, fromAISC.length );
			if( fromReadSize != fromAISC.length ){
				ExceptionFactory.throwIOException("IOS0012009", new String[]{fromUpfm.getID()} );
			}
			if( new String( fromAISC, 0 ,4 ).equalsIgnoreCase("AISC") == false ){
				ExceptionFactory.throwIOException("IOS0012008", new String[]{fromUpfm.getID()} );
			}
			fromBytes = new byte[ MathUtils.IMath.toInt( fromAISC, 4 ) ];
			fromReadSize = fromClient._read( fromBytes, 0, fromBytes.length );
			if( fromReadSize != fromBytes.length ){
				ExceptionFactory.throwIOException("IOS0012009", new String[]{fromUpfm.getID()} );
			}
		}
		finally{
			
		}
		return fromBytes;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmProtocolImpl#finishASKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
			IOVUpdspmLife fromUpdfwm, 
			Object fromRsBody, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfwmResponse fromUpdcpm = null;
		try
		{
			IOVKtSyncResponse fromKtSyncRsp = new IOVKtSyncResponse();
			fromKtSyncRsp._wrap( (byte[])fromRsBody );
			fromUpdcpm = IUpfgkmUtils.ICustom._wrap(fromUpfwm, 
					fromUpdfwm, 
					fromKtSyncRsp, 
					aContext);
		}
		finally{
			
		}
		return fromUpdcpm;
	}
	/**
	 * 
	 * <p>Title: sacenter-tykt</p>
	 * <p>Description: 基于华为智能网协议(MML)</p>
	 * <p>Copyright: Copyright (c) 2016年8月24日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class HuaWeiVpnProtocolImpl extends IUpfgkmProtocolImpl{
		public HuaWeiVpnProtocolImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.tykt.dbcp.IUpfgkmProtocolImpl#finishASKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				Object fromRsBody,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromUpdcpm = null;
			java.util.Map fromKtRsRsp = null;
			try
			{
				IOVKtSyncResponse fromKtSyncRsp = new IOVKtSyncResponse();
				fromKtSyncRsp._wrap( (byte[])fromRsBody );
				IOVKtSyncResponse.IOVKySyncRsRsp fromRsResult = fromKtSyncRsp.getRspResult();
				fromKtRsRsp = IUpfgkmUtils.ICustom._wrapWithMML( fromRsResult.getRspResult(), 
						fromKtSyncRsp );
				ClassUtils.IMerge.merge( fromKtRsRsp, fromKtSyncRsp.getRspResult().getRspBody() );
				fromUpdcpm = IUpfgkmUtils.ICustom._wrap(fromUpfwm, 
						fromUpdfwm, 
						fromKtSyncRsp, 
						aContext);
			}
			finally{
				if( fromKtRsRsp != null ){ fromKtRsRsp.clear(); fromKtRsRsp = null; }
			}
			return fromUpdcpm;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-tykt</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年11月30日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class HuaWeiHLRProtocolImpl extends IUpfgkmProtocolImpl{
		public HuaWeiHLRProtocolImpl(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.tykt.dbcp.IUpfgkmProtocolImpl#finishASKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				Object fromRsBody,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromUpdcpm = null;
			java.util.Map fromKtRsRsp = null;
			try
			{
				IOVKtSyncResponse fromKtSyncRsp = new IOVKtSyncResponse();
				fromKtSyncRsp._wrapWithPARAM( (byte[])fromRsBody );
				IOVKtSyncResponse.IOVKySyncRsRsp fromRsResult = fromKtSyncRsp.getRspResult();
				fromKtRsRsp = IUpfgkmUtils.ICustom._wrapWithPARAM( fromRsResult.getRspResult(), 
						fromKtSyncRsp );
				ClassUtils.IMerge.merge( fromKtRsRsp, fromKtSyncRsp.getRspResult().getRspBody() );
				fromUpdcpm = IUpfgkmUtils.ICustom._wrap(fromUpfwm, 
						fromUpdfwm, 
						fromKtSyncRsp, 
						aContext);
			}
			finally{
				if( fromKtRsRsp != null ){ fromKtRsRsp.clear(); fromKtRsRsp = null; }
			}
			return fromUpdcpm;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-tykt</p>
	 * <p>Description: 基于华为AAA协议</p>
	 * <p>Copyright: Copyright (c) 2016年8月24日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class HuaWeiAAAProtocolImpl extends IUpfgkmProtocolImpl{
		public HuaWeiAAAProtocolImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.tykt.dbcp.IUpfgkmProtocolImpl#finishASKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, Object fromRsBody,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromUpdcpm = null;
			java.util.Map fromKtRsRsp = null;
			try
			{
				IOVKtSyncResponse fromKtSyncRsp = new IOVKtSyncResponse();
				fromKtSyncRsp._wrap( (byte[])fromRsBody );
				fromUpdcpm = IUpfgkmUtils.ICustom._wrap(fromUpfwm, 
						fromUpdfwm, 
						fromKtSyncRsp, 
						aContext);
			}
			finally{
				if( fromKtRsRsp != null ){ fromKtRsRsp.clear(); fromKtRsRsp = null; }
			}
			return fromUpdcpm;
		}
		
	}
}
