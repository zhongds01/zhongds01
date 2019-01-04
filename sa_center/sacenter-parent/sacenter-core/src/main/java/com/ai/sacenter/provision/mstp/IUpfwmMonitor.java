package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.SFException;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元客户端监控类</p>
 * <p>Copyright: Copyright (c) 2015-1-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmMonitor {
	/**
	 * 登录验证
	 * @param fromClient
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmLogin( IUpfwmClient fromClient ) throws SFException,Exception;
	/**
	 * 验证与网元会话
	 * @param fromClient
	 * @throws SFException
	 * @throws Exception
	 */
    public void finishSFUpfwmHbhbt( IUpfwmClient fromClient ) throws SFException,Exception;
	/**
	 * 注销与网元会话
	 * @param fromClient
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmLogout( IUpfwmClient fromClient ) throws SFException,Exception;
}
