package com.ai.sacenter.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpVersion;

import com.ai.sacenter.SFException;
import com.asiainfo.appframe.ext.exeframe.http.query.po.CfgHttpClient;

/**
 * 
 * <p>Title: crm-lteboss2-trunk</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-6-25</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class HttpUtils {
	public HttpUtils(){
		super();
	}
	/**
	 * 
	 * @param fromHttp
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static java.net.URL _wrap( final CfgHttpClient fromHttp ) throws SFException,Exception{
		java.net.URL fromEndpoint  = null;
		try {
			fromEndpoint = new java.net.URL(new java.net.URL(fromHttp
					.getUrlAddress()), fromHttp.getUrlAddress(),
					new java.net.URLStreamHandler() {
						protected java.net.URLConnection openConnection(
								java.net.URL url) throws java.io.IOException {
							java.net.URL target = new java.net.URL(url
									.toString());
							java.net.URLConnection connection = target
									.openConnection();
							connection.setConnectTimeout(fromHttp
									.getTimeoutSeconds());
							connection.setReadTimeout(fromHttp
									.getTimeoutSeconds());
							return (connection);
						}
					});

		} finally {

		}
		return fromEndpoint;
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * 
		 * @param _httpclient_
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static HttpClient wrap( CfgHttpClient _httpclient_ ) throws SFException,Exception{
			HttpClient fromClient = null;
			try
			{
				fromClient = new HttpClient();
				fromClient.getParams().setParameter("http.protocol.version",HttpVersion.HTTP_1_1);
				fromClient.getParams().setParameter("http.protocol.content-charset","UTF-8");
				if( _httpclient_.getTimeoutSeconds() > 0 ){
					fromClient.getHttpConnectionManager().getParams().setConnectionTimeout( _httpclient_.getTimeoutSeconds() );
					fromClient.getHttpConnectionManager().getParams().setSoTimeout( _httpclient_.getTimeoutSeconds() );
				}
			}
			finally{
				
			}
			return fromClient;
		}
	}
}
