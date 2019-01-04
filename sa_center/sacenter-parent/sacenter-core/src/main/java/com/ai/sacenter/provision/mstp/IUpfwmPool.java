package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ�ͻ��˳ػ�����</p>
 * <p>Copyright: Copyright (c) 2015-1-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmPool {
	/**
	 * ��ȡ��Ԫ�ͻ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfwmClient makeClient() throws SFException,Exception;
	/**
	 * �ر���Ԫ�ͻ���
	 * @param fromClient ��Ԫ�ͻ���
	 * @throws SFException
	 * @throws Exception
	 */
	public void returnClient( IUpfwmClient fromClient) throws SFException,Exception;
	/**
	 * @return ��··�ɹ淶
	 */
	public IUpffmNetWork getPLATFORM_();
	/**
	 * @return ��··��
	 */
	public IUpfwmDefine getNETWORK_();
	/**
	 * @return ��Ԫ��չ����
	 */
	public java.util.Map getSTUB_();
	/**
	 * �Ƿ�֧������
	 * @return
	 */
	public boolean getHBT();
}
