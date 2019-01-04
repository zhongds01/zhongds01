package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-1-28</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmClientFactory {
	/**
	 * @return 网路路由
	 */
	public IUpfwmDefine getNETWORK_();
	/**
	 * @return 网路网元
	 */
	public IUpffmNetWork getPLATFORM_();
	/**
	 * @return 扩展信息
	 */
	public java.util.Map getSTUB_();
	/**
	 * 初始化与服务端网路路由配置
	 * @param fromUpfwsx 网路配置
	 * @param fromUpfgsm 网路路由
	 * @throws SFException
	 * @throws Exception
	 */
	public void configure( IUpfwsxDefine fromUpfwsx,
			org.dom4j.Element fromUpfgsm ) throws SFException,Exception;
	/**
	 * 创建与服务端通道
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfwmClient makeChannel() throws SFException,Exception;
	/**
	 * 与服务端通道心跳通信
	 * @param fromChannel 服务端通道
	 * @throws SFException
	 * @throws Exception
	 */
	public void hbhbtChannel(IUpfwmClient fromChannel) throws SFException,Exception;
	/**
	 * 摧毁与服务端通道
	 * @param fromChannel 服务端通道
	 * @throws SFException
	 * @throws Exception
	 */
	public void destroyChannel(IUpfwmClient fromChannel) throws SFException,Exception;
}
