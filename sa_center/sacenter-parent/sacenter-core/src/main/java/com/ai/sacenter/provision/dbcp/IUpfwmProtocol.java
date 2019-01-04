package com.ai.sacenter.provision.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��ԪЭ���ʲ�</p>
 * <p>Copyright: Copyright (c) 2015��10��24��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmProtocol {
	/**
     * ���ƽ̨����������
     * @param fromUpfwm  ��Ԫ����
     * @param fromUpdfwm ��Ԫָ�
     * @param fromUpdcpm �������Լ�
     * @param aContext
     * @return 
     * @throws SFException
     * @throws Exception
     */
    public IOVUpfwmRequest finishRQKUpfwm(IOVUpfwmOffer fromUpfwm,
    		IOVUpdspmLife fromUpdfwm,
    		IOVUpfwmRequest fromUpdcpm,
    		IUpdcContext aContext ) throws SFException,Exception;
    /**
     * �����Ԫ����ͬ������Ԫƽ̨
     * @param fromUpfwm ��Ԫ����
     * @param fromUpdfwm ����ָ�
     * @param fromNetWork ��·�ͻ���
     * @param fromUpdcpm ������
     * @param aContext
     * @return
     * @throws SFException
     * @throws Exception
     */
    public Object finishBPKUpfwm( IOVUpfwmOffer fromUpfwm,
    		IOVUpdspmLife fromUpdfwm,
    		IUpfwmClient fromNetWork,
    		IOVUpfwmRequest fromUpdcpm,
    		IUpdcContext aContext ) throws SFException,Exception;
    /**
     * ���ƽ̨������Ӧ����
     * @param fromUpfwm ��Ԫ����
     * @param fromUpdfwm ��Ԫָ�
     * @param fromRsBody ��Ԫ������
     * @param aContext
     * @return ��������[0��ԪӦ��(HashMap),1����ӳ�䱨��,2�����ױ���]
     * @throws SFException
     * @throws Exception
     */
    public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
    		IOVUpdspmLife fromUpdfwm,
    		Object fromRsBody,
    		IUpdcContext aContext ) throws SFException,Exception;
}
