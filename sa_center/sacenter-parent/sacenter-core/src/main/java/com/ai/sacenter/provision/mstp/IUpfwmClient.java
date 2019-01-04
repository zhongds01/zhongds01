package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.SFException;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ�ͻ��˳ػ���</p>
 * <p>Copyright: Copyright (c) 2015-1-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmClient {
	/**
	 * @return �ͻ��˱���
	 */
	public UUID getID();
	/**
	 * ��ǰ��Ԫ��··��
	 * @return
	 */
	public IUpfwmDefine getNETWORK_();
	/**
	 * ��ǰ��Ԫ������
	 * @return
	 */
	public IUpffmNetWork getPLATFORM_();
	/**
	 * 
	 * @return
	 */
	public java.util.Map getSTUB_();
	/**
	 * �Ƿ�ǰ��ԪЭ�����
	 * @return
	 */
	public boolean isClientReady();
	/**
	 * ���񼤻���¼��Ԫ������
	 * @param fromMonitor ��Ԫ������
	 * @throws SFException
	 * @throws Exception
	 */
	public void login( IUpfwmMonitor fromMonitor ) throws SFException,Exception;
	/**
	 * ���񼤻�ⶨ�ڷ�������
	 * @throws SFException
	 * @throws Exception
	 */
	public void hbhbt() throws SFException, Exception;
	/**
	 * ���񼤻��ע����Ԫ������
	 * @throws SFException
	 * @throws Exception
	 */
	public void logout( ) throws SFException,Exception;
}
