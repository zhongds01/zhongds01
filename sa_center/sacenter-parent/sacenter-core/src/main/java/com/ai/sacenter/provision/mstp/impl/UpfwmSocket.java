package com.ai.sacenter.provision.mstp.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.IUpfwmDefine;
import com.ai.sacenter.provision.mstp.IUpfwmMonitor;
import com.ai.sacenter.util.HttpServletWrapper;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.SocketClient;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-1-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmSocket extends SocketClient implements IUpfwmClient,java.io.Serializable{
	private final static Log log = LogFactory.getLog( UpfwmSocket.class );
	private static final long serialVersionUID = 8366344994745221904L;
	private   UUID ID = null;
	protected IUpffmNetWork PLATFORM_;
	protected IUpfwmDefine  NETWORK_;
	protected java.util.Map STUB_ = new java.util.HashMap();
	protected java.util.List MONITOR_ = new java.util.ArrayList();
	public UpfwmSocket( IUpffmNetWork fromUpfm , IUpfwmDefine fromPool) throws Exception{
		super();
		ID = UUID.getUUID();
		PLATFORM_ = fromUpfm;
		NETWORK_ = fromPool;
	}
	/**
	 * @return 客户端编码
	 */
	public UUID getID() {
		return ID;
	}
	/**
	 * @return 网路路由
	 */
	public IUpfwmDefine getNETWORK_() {
		return NETWORK_;
	}
	/**
	 * @return 网元配置
	 */
	public IUpffmNetWork getPLATFORM_() {
		return PLATFORM_;
	}
	/**
	 * @return 扩展属性
	 */
	public java.util.Map getSTUB_() {
		return STUB_;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmClient#isClientReady()
	 */
	public boolean isClientReady() {
		boolean aClientReady = false;
		try
		{
			Boolean fromLogin = (Boolean)STUB_.get( "PLATFORM$LOGINED_PLATFORM" );
			aClientReady = super.isConnected() && (fromLogin != null && fromLogin.equals( Boolean.TRUE ) );
		}
		finally{
			
		}
		return aClientReady;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmClient#login(com.ai.sacenter.provision.mstp.IUpfwmMonitor)
	 */
	public void login(IUpfwmMonitor fromMonitor) throws SFException, Exception {
		try
		{
			Boolean fromLogin = (Boolean)STUB_.get( "PLATFORM$LOGINED_PLATFORM" );
			if( fromLogin == null || fromLogin.equals( Boolean.FALSE ) ){
				int aRandom = MathUtils.IMath.random( NETWORK_.getNETWORK_().size() );
				IUpfwmSocketDefine aSocketDefine = (IUpfwmSocketDefine)NETWORK_.getNETWORK_().get( aRandom );
				if( super.isConnected() == false ){
					STUB_.clear();
					if( _connect( aSocketDefine ) == false ){
						aSocketDefine = null;
						for( int index = 0 ; index < NETWORK_.getNETWORK_().size() ; index++ ){
							if( index == aRandom ) continue;
							aSocketDefine = (IUpfwmSocketDefine)NETWORK_.getNETWORK_().get( index );
							if( _connect( aSocketDefine ) ) break;
							aSocketDefine = null;
						}
					}
					if( aSocketDefine == null ) ExceptionFactory.throwConnect("IOS0012002", new String[]{PLATFORM_.getID()+"["+NETWORK_.getID_()+"]"});
				}
				if( MONITOR_.contains( fromMonitor ) == false ){ MONITOR_.clear() ;MONITOR_.add( fromMonitor );}
				for( java.util.Iterator itera = MONITOR_.iterator() ; itera.hasNext() ; ){
					fromMonitor = (IUpfwmMonitor)itera.next();
					fromMonitor.finishSFUpfwmLogin( this );
				}
				STUB_.put( "PLATFORM$LOGINED_PLATFORM" , Boolean.TRUE );
				if( log.isDebugEnabled() ) log.debug( "ucmframe connection network["+PLATFORM_.getID() + "] successfully");
			}
		}
		catch( java.lang.Exception aException ){
			if( log.isErrorEnabled() ) log.error( aException.getMessage(), aException );
			throw aException;
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmClient#hbhbt()
	 */
	public void hbhbt() throws SFException, Exception {
		try 
		{
			for (java.util.Iterator itera = MONITOR_.iterator(); itera.hasNext();) {
				IUpfwmMonitor fromMonitor = (IUpfwmMonitor) itera.next();
				fromMonitor.finishSFUpfwmHbhbt( this );
			}
		} 
		finally{

		}
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmClient#logout()
	 */
	public void logout() throws SFException, Exception {
		try 
		{
			if( super._socket_ != null && super.isConnected() ) {
				if( isClientReady() ) {
					try 
					{
						for (java.util.Iterator itera = MONITOR_.iterator(); itera.hasNext();) {
							IUpfwmMonitor fromMonitor = (IUpfwmMonitor) itera.next();
							fromMonitor.finishSFUpfwmLogout( this );
						}
					} 
					catch (java.lang.Exception aEXCEPTION) {

					}
				}
				try 
				{
					super.disconnect();
				} 
				catch (java.lang.Exception aEXCEPTION) {
					if( log.isErrorEnabled() ) log.error( aEXCEPTION.getMessage(), aEXCEPTION );
				}
			}
			MONITOR_.clear(); STUB_.clear();
			if( log.isDebugEnabled() ) log.debug( "ucmframe client disconnect network["+PLATFORM_.getID() + "] successfully");
		} 
		finally {

		}
	}
	/**
	 * 
	 * @param fromCAU
	 * @throws Exception
	 */
	private boolean _connect( IUpfwmSocketDefine fromCAU ) throws Exception{
		boolean aConnection = true;
		try
		{
			super.setDefaultTimeout( fromCAU.getTIMEOUT() );
			super.connect( PLATFORM_.getID(), fromCAU.HOST , fromCAU.PORT, fromCAU.CONECTTIMEOUT );
		}
		catch( java.lang.Exception aException ){
			if( log.isErrorEnabled() ) log.error( aException.getMessage(), aException );
			aConnection = false;
		}
		return aConnection;
	}
	/**
	 * 
	 * @param fromByte
	 * @throws Exception
	 */
	public void _write( byte fromByte[] ) throws Exception{
		getOutputStream().write( fromByte );
		getOutputStream().flush();
	}
	/**
	 * 
	 * @param fromByte
	 * @param off
	 * @param len
	 * @throws Exception
	 */
	public void _write( byte fromByte[] , int off, int len ) throws Exception{
		getOutputStream().write( fromByte, off, len );
		getOutputStream().flush();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public int _read() throws Exception{
		return getInputStream().read();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public byte _readByte() throws Exception{
		return getInputStream().readByte();
	}
	/**
	 * 
	 * @param fromByte
	 * @return
	 * @throws Exception
	 */
	public int _read( byte [] fromByte ) throws Exception{
		return getInputStream().read( fromByte );
	}

    /**
     *
     * @param fromByte
     * @param off
     * @param len
     * @return
     * @throws Exception
     */
	public int _read( byte [] fromByte , int off, int len ) throws Exception{
		int aReadBytes = len,aReadSize = 0;
		try
		{
			while( aReadBytes > 0 ){
				int aReadNum = getInputStream().read( fromByte , off + aReadSize , aReadBytes );
				aReadSize += aReadNum;
				aReadBytes -= aReadNum;
			}
		}
		finally{
			
		}
		return aReadSize;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: SOCKET客戶端网路路由</p>
	 * <p>Copyright: Copyright (c) 2015-1-27</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmSocketDefine extends IUpfwmDefine.IUpfwmCauDefine{
		private static final long serialVersionUID = 7779190024727708745L;
		private String HOST;
		private int    PORT;
	    private int    TIMEOUT = 0;
	    private int    CONECTTIMEOUT = 0;
	    private java.util.Map STUB = new java.util.HashMap();
		public IUpfwmSocketDefine(org.dom4j.Element aElement ) throws Exception{
			super(aElement);
			HttpServletWrapper fromHttp = null;
			try{
				java.net.URI fromURI = new java.net.URI(aElement
						.attributeValue("url"));
				fromHttp = new HttpServletWrapper(fromURI);
				HOST = fromHttp.getHOST();
				PORT = fromHttp.getPORT();
				TIMEOUT = fromHttp.getAsInt( "timeout" );
				CONECTTIMEOUT = fromHttp.getAsInt( "connecttimeout" );
				STUB.putAll( fromHttp.getQUERY() );
			}
			finally{
				if( fromHttp != null ){ fromHttp.getQUERY().clear() ; fromHttp = null; }
			}
		}
		/**
		 * @return 连接超时(毫秒)
		 */
		public int getCONECTTIMEOUT() {
			return CONECTTIMEOUT;
		}
		/**
		 * @return 主机地址
		 */
		public String getHOST() {
			return HOST;
		}
		/**
		 * @return 扩展属性
		 */
		public java.util.Map getSTUB() {
			return STUB;
		}
		/**
		 * @return 主机端口
		 */
		public int getPORT() {
			return PORT;
		}
		/**
		 * @return 等待超时(毫秒)
		 */
		public int getTIMEOUT() {
			return TIMEOUT;
		}
	}
}
