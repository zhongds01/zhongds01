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
	 * @return ��··��
	 */
	public IUpfwmDefine getNETWORK_();
	/**
	 * @return ��·��Ԫ
	 */
	public IUpffmNetWork getPLATFORM_();
	/**
	 * @return ��չ��Ϣ
	 */
	public java.util.Map getSTUB_();
	/**
	 * ��ʼ����������··������
	 * @param fromUpfwsx ��·����
	 * @param fromUpfgsm ��··��
	 * @throws SFException
	 * @throws Exception
	 */
	public void configure( IUpfwsxDefine fromUpfwsx,
			org.dom4j.Element fromUpfgsm ) throws SFException,Exception;
	/**
	 * ����������ͨ��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfwmClient makeChannel() throws SFException,Exception;
	/**
	 * ������ͨ������ͨ��
	 * @param fromChannel �����ͨ��
	 * @throws SFException
	 * @throws Exception
	 */
	public void hbhbtChannel(IUpfwmClient fromChannel) throws SFException,Exception;
	/**
	 * �ݻ�������ͨ��
	 * @param fromChannel �����ͨ��
	 * @throws SFException
	 * @throws Exception
	 */
	public void destroyChannel(IUpfwmClient fromChannel) throws SFException,Exception;
}
