package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.impl.UpfwmSocket;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.ByteBuffer;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 基于SOCKET协议封装</p>
 * <p>Copyright: Copyright (c) 2015年10月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ISocketProtocolImpl extends IUpfwmProtocolImpl {
	public ISocketProtocolImpl() {
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
		byte[] fromASK = null;
		try
		{
			UpfwmSocket fromClient = (UpfwmSocket)fromNetWork;
			IOVUpfwmRequest.IUpffmxOfferHome fromUpffmxHome = fromUpdcpm.getPLATFORM();
			byte fromBytes[] = MathUtils.IMath.toByteArray( fromUpffmxHome.getORIGINAL() );
			fromClient._write( fromBytes );
			int s = fromClient.getInputStream().read();
			if( s == -1 ) throw new java.io.IOException( "Connection lost" );
			int aAvailable = fromClient.getInputStream().available();
			if( aAvailable <= 0 ) fromASK = new byte[1];
			else{
				fromASK = new byte[ aAvailable + 1 ];
				fromClient.getInputStream().read( fromASK, 1, aAvailable );
			}
			fromASK[0] = (byte)s;
		}
		finally{
			
		}
		return fromASK;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 基于亚信3A认证系统协议封装</p>
	 * <p>Copyright: Copyright (c) 2015年10月28日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IObsProtocolImpl extends ISocketProtocolImpl{
		public IObsProtocolImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.ISocketProtocolImpl#finishBPKUpfwm(com.ai.sacenter.provision.valuebean.IOVUpfwmOffer, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.provision.dbcp.IUpfwmClient, com.ai.sacenter.provision.valuebean.IOVUpfwmRequest, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishBPKUpfwm(IOVUpfwmOffer fromUpfwm,
				IOVUpdspmLife fromUpdfwm, 
				IUpfwmClient fromNetWork,
				IOVUpfwmRequest fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception {
			byte[] fromASK = null;
			ByteBuffer writeBuffer = null,readBuffer = null;
			try
			{
				UpfwmSocket aSocketClient = (UpfwmSocket)fromNetWork;
				IOVUpfwmRequest.IUpffmxOfferHome fromUpffmxHome = fromUpdcpm.getPLATFORM();
				byte fromBytes[] = MathUtils.IMath.toByteArray( fromUpffmxHome.getORIGINAL() );
				writeBuffer = new ByteBuffer( fromBytes.length + 1 );
				writeBuffer.append( fromBytes );
				writeBuffer.append((byte)0x0A);
				aSocketClient._write( writeBuffer.toByteArray() );
				readBuffer = new ByteBuffer(4096);
				int length = 0;
				byte readByte = 0;
				do{
					readByte = (byte) aSocketClient.getInputStream().read();
		            readBuffer.append(readByte);
		            length++;
				}while( readByte != 0x0A );
				fromASK = readBuffer.toByteArray( length );
			}
			finally{
				if( writeBuffer != null ){ writeBuffer = null; }
				if( readBuffer != null ){ readBuffer = null; }
			}
			return fromASK;
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
				String fromRsRaw = fromRsBody != null && fromRsBody instanceof byte[]? 
						new String( (byte[])fromRsBody ):fromRsBody.toString();
				java.util.Map fromUpfgsm = new java.util.HashMap();
				String fromPARAM[] = StringUtils.substring( fromRsRaw, "{", "}" );
				for( int index = 0 ; fromPARAM != null && index < fromPARAM.length; index++ ){
					String aINDEX = ClassUtils.getINDEX( new String[]{"RETN_",String.valueOf( index ) } );
					fromUpfgsm.put( aINDEX , fromPARAM[index] );
				}
				String aFAILURE = (String)fromUpfgsm.get( "RETN_1" );
				fromUpdcpm.setFAILURE( aFAILURE != null && StringUtils.equals( aFAILURE, "OK" )?
						Boolean.FALSE:Boolean.TRUE );
				fromUpdcpm.setRspCode  ( aFAILURE                           );
				fromUpdcpm.setRspDesc  ( (String)fromUpfgsm.get( "RETN_2" ) );
				fromUpdcpm.setRspBody  ( fromUpfgsm                         );
				fromUpdcpm.setRspBottom( fromRsRaw                          );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
	}
}
