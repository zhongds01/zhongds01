package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.SFException;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ�ͻ��˼����</p>
 * <p>Copyright: Copyright (c) 2015-1-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmMonitor {
	/**
	 * ��¼��֤
	 * @param fromClient
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmLogin( IUpfwmClient fromClient ) throws SFException,Exception;
	/**
	 * ��֤����Ԫ�Ự
	 * @param fromClient
	 * @throws SFException
	 * @throws Exception
	 */
    public void finishSFUpfwmHbhbt( IUpfwmClient fromClient ) throws SFException,Exception;
	/**
	 * ע������Ԫ�Ự
	 * @param fromClient
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmLogout( IUpfwmClient fromClient ) throws SFException,Exception;
}
