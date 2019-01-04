package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.SFException;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元客户端池化类</p>
 * <p>Copyright: Copyright (c) 2015-1-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmClient {
	/**
	 * @return 客户端编码
	 */
	public UUID getID();
	/**
	 * 当前网元网路路由
	 * @return
	 */
	public IUpfwmDefine getNETWORK_();
	/**
	 * 当前网元适配器
	 * @return
	 */
	public IUpffmNetWork getPLATFORM_();
	/**
	 * 
	 * @return
	 */
	public java.util.Map getSTUB_();
	/**
	 * 是否当前网元协议就绪
	 * @return
	 */
	public boolean isClientReady();
	/**
	 * 服务激活测登录网元服务器
	 * @param fromMonitor 网元监听器
	 * @throws SFException
	 * @throws Exception
	 */
	public void login( IUpfwmMonitor fromMonitor ) throws SFException,Exception;
	/**
	 * 服务激活测定期发送心跳
	 * @throws SFException
	 * @throws Exception
	 */
	public void hbhbt() throws SFException, Exception;
	/**
	 * 服务激活测注销网元适配器
	 * @throws SFException
	 * @throws Exception
	 */
	public void logout( ) throws SFException,Exception;
}
