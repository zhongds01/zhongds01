package com.ai.sacenter.provision.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ����ʲ�</p>
 * <p>Copyright: Copyright (c) 2015��10��24��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmCapital {
	/**
     * ���ƽָ̨��ִ��
     * @param fromOrder ���񶨵�
     * @param fromTASK ���񶨵�����
     * @param fromUpdfwm ����ָ�
     * @param aContext
     * @return 
     * @throws SFException
     * @throws Exception
     */
    public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder ,
    		IOVTaskPentium  fromTASK,
    		IOVUpdspmLife fromUpdfwm,
    		IUpdcContext aContext ) throws SFException,Exception;
    /**
     * �����Ԫ����ָ��ִ��
     * @param fromUpfwm ��Ԫ����
     * @param fromUpdfwm ����ָ�
     * @param aContext
     * @return �����嵥 FAILURE(Boolean)(��Ԫִ���Ƿ��쳣),
     *                 RESULT(��Ԫִ�����),
     *                 RETN(��Ԫ���ر���),
     *                 DESCRIPTION(��Ԫ���ر�������)
     * @throws SFException
     * @throws Exception
     */
    public IOVUpfwmResponse finishSFUpdfwm( IOVUpfwmOffer fromUpfwm,
    		IOVUpdspmLife fromUpdfwm,
    		IUpdcContext aContext ) throws SFException,Exception;
}
