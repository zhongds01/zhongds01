package com.ai.sacenter.provision.mstp.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.mstp.IUpfwmDefine;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;
import com.asiainfo.appframe.ext.exeframe.ws.client.WsClient;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-1-28</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmWebService extends UpfwmDefault {
	private static final long serialVersionUID = 6400622983379061920L;
	/*客户端*/
	private WsClient _client_ = null;
	public UpfwmWebService(IUpffmNetWork fromUpfm, IUpfwmDefine fromNetWork) throws Exception{
		super(fromUpfm, fromNetWork);
		try {
			IUpfwmWebServiceDefine fromHttp = null;
			for (java.util.Iterator itera = fromNetWork.getNETWORK_()
					.iterator(); itera.hasNext();) {
				fromHttp = (IUpfwmWebServiceDefine) itera.next();
				if (StringUtils.isBlank(fromHttp.getURL()) == false) {
					_client_ = new WsClient( fromHttp.getURL() );
					break;
				}
			}
			if (_client_ == null){
				ExceptionFactory.throwIllegal("IOS0011072", new String[] {
						PLATFORM_.getID(), NETWORK_.getID_() });
			}
		} 
		catch (java.lang.Exception aEXCEPTON) {
			ExceptionFactory.throwIllegal("IOS0011072", new String[] {
					PLATFORM_.getID(), NETWORK_.getID_() }, aEXCEPTON);
		} finally {

		}
	}
	/**
	 * 调用远端服务WS
	 * @param fromMethod 方法名
	 * @param fromPARAM 形式参数
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object call( String fromMethod, Object fromPARAM[] ) throws SFException,Exception{
		Object fromASK = null;
		try {
			fromASK = _client_.invoke(fromMethod, fromPARAM);
		} finally {

		}
		return fromASK;
	}
	/**
     * 
     * <p>Title: ucmframe</p>
     * <p>Description: WAS客户配置</p>
     * <p>Copyright: Copyright (c) 2015-1-28</p>
     * <p>Company: AI(NanJing)</p>
     * @author maohuiyun
     * @version 3.0
     */
	public static class IUpfwmWebServiceDefine extends IUpfwmDefine.IUpfwmCauDefine{
		private static final long serialVersionUID = -8039698888876065298L;
		public IUpfwmWebServiceDefine(org.dom4j.Element aElement ) throws Exception{
			super( aElement );
		}
	}
}
