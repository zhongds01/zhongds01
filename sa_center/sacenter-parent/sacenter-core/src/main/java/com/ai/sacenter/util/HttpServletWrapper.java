package com.ai.sacenter.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-2-9</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class HttpServletWrapper implements java.io.Serializable{
	private static final long serialVersionUID = 5369110771444182527L;
    protected String PROTOCOL;
    protected String HOST;
    protected int    PORT;
    protected java.util.Map QUERY = new java.util.HashMap();
    private String ORIGINALURL;
	public HttpServletWrapper() {
		super();
	}
	public HttpServletWrapper( java.net.URI fromURI ) throws Exception{
		super();
		ORIGINALURL = fromURI.toString();
		parse( fromURI );
	}
	public HttpServletWrapper( String fromPARAM ) throws Exception{
		super();
		ORIGINALURL = fromPARAM;
		java.net.URI fromURI = null;
		try
		{
			fromURI = new java.net.URI(encodePercent(fromPARAM));
			if (StringUtils.isBlank(fromURI.getScheme()) == false) {
				parse(fromURI);
			} else {
				parse( fromPARAM.toString() );
			}
		}
		catch( java.lang.Exception aEXCEPTION ){
			parse( fromPARAM );
		}
		finally{
			if( fromURI != null ){ fromURI = null; }
		}
	}
	/**
	 * 
	 * @param fromURI
	 * @throws Exception
	 */
	private void parse(java.net.URI fromURI) throws Exception{
		PROTOCOL = fromURI.getScheme();
		HOST =  decodePercent(resolveHost(fromURI.getHost()));
		PORT = fromURI.getPort();
		String fromQuery = fromURI.getQuery();
		if( fromQuery != null ){
			StringUtils.manifest(fromURI.getQuery(), QUERY);
		}
	}
	/**
	 * 
	 * @param fromURI
	 * @throws Exception
	 */
	private void parse( String fromURI ) throws Exception{
		StringUtils.manifest(fromURI, QUERY);
	}
	/***
	 * 
	 * @param s
	 * @return
	 */
	protected String encodePercent(String s){
		if (s == null) return null;
		java.util.StringTokenizer st = new java.util.StringTokenizer(s, "%");
		StringBuilder sb = new StringBuilder();
	    int limit = st.countTokens() - 1;
	    for (int i = 0; i < limit; i++){
	    	String token = st.nextToken();
	        sb.append(token).append("%25");
	    }
	    sb.append(st.nextToken());
	    return sb.toString();
	}
	/***
	 * 
	 * @param s
	 * @return
	 */
	protected String decodePercent(String s){
		if (s == null) return null;
		StringBuilder sb = new StringBuilder();
	    int fromIndex = 0;
	    int index = s.indexOf("%25", fromIndex);
	    while (index >= 0){
	    	sb.append(s.substring(fromIndex, index)).append('%');
	        fromIndex = index + 3;
	        index = s.indexOf("%25", fromIndex);
	    }
	    sb.append(s.substring(fromIndex));
	    return sb.toString();
	}
	/***
	 * 
	 * @param host
	 * @return
	 */
	private String resolveHost(String host){
		if (host == null) host = fixRemoteAddress(host);
	    return host;
	}
	/***
	 * 
	 * @param address
	 * @return
	 */
	private String fixRemoteAddress(String address){
		if(address == null){
			try{
				address = (String)AccessController.doPrivileged( new PrivilegedExceptionAction(){
	               public Object run() throws UnknownHostException
	               {
	                  String bindByHost = System.getProperty("ucmframe.bind_by_host", "true");
	                  boolean byHost = Boolean.valueOf(bindByHost).booleanValue();
	                  if(byHost)
	                     return InetAddress.getLocalHost().getHostName();
	                  else
	                     return InetAddress.getLocalHost().getHostAddress();
	               }
	            });
			}
	        catch (PrivilegedActionException e){
	        }
	    }
        return address;
    }
	/**
	 * @return 主机地址
	 */
	public String getHOST() {
		return HOST;
	}
	/**
	 * @return 参数清单
	 */
	public String getPARAM() {
		return ORIGINALURL;
	}
	/**
	 * @return 参数列表
	 */
	public java.util.Map getQUERY() {
		return QUERY;
	}
	/**
	 * @return 主机端口
	 */
	public int getPORT() {
		return PORT;
	}
	/**
	 * @return 协议类型
	 */
	public String getPROTOCOL() {
		return PROTOCOL;
	}
	/**
	 * 
	 * @return
	 */
	public String getAsString( String fromKEY ){
		return ClassUtils.IClass.getAsString( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public short getAsShort( String fromKEY ){
		return ClassUtils.IClass.getAsShort( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public int getAsInt( String fromKEY ){
		return ClassUtils.IClass.getAsInt( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public long getAsLong( String fromKEY ){
		return ClassUtils.IClass.getAsLong( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public double getAsDouble( String fromKEY ){
		return ClassUtils.IClass.getAsDouble( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public float getAsFloat( String fromKEY ){
		return ClassUtils.IClass.getAsFloat( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public boolean getAsBoolean( String fromKEY ){
		return ClassUtils.IClass.getAsBoolean( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public char getAsChar( String fromKEY ){
		return ClassUtils.IClass.getAsChar( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public java.sql.Date getAsDate( String fromKEY ){
		return ClassUtils.IClass.getAsDate( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public java.sql.Time getAsTime( String fromKEY ){
		return ClassUtils.IClass.getAsTime( QUERY.get( fromKEY ) );
	}
	/**
	 * 
	 * @param fromKEY
	 * @return
	 */
	public java.sql.Timestamp getAsTimestamp( String fromKEY ){
		return ClassUtils.IClass.getAsTimestamp( QUERY.get( fromKEY ) );
	}
}
