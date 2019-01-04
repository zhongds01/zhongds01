package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元客户端池化工厂</p>
 * <p>Copyright: Copyright (c) 2015-1-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmPool {
	/**
	 * 获取网元客户端
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfwmClient makeClient() throws SFException,Exception;
	/**
	 * 关闭网元客户端
	 * @param fromClient 网元客户端
	 * @throws SFException
	 * @throws Exception
	 */
	public void returnClient( IUpfwmClient fromClient) throws SFException,Exception;
	/**
	 * @return 网路路由规范
	 */
	public IUpffmNetWork getPLATFORM_();
	/**
	 * @return 网路路由
	 */
	public IUpfwmDefine getNETWORK_();
	/**
	 * @return 网元扩展属性
	 */
	public java.util.Map getSTUB_();
	/**
	 * 是否支持心跳
	 * @return
	 */
	public boolean getHBT();
}
