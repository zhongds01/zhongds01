package com.ai.sacenter.core;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbpmOffer;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015��11��4��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdbpmCapital {
	/***
     * ���ݷ���ͨ������ַ�����Ԫ����
     * @param fromOrder ���񶨵�
     * @param fromOffer ���񶨵�����
     * @param fromUpdbm ��������
     * @param fromUpdcpm ������������
     * @param aContext
     * @return
     * @throws SFException
     * @throws Exception
     */
    public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
    		IOVOfferPentium fromOffer,
    		ISystemTemplate.IUpdbpmOffer fromUpdbm, 
    		IOVUpdbpmOffer fromUpdcpm,
    		IUpdcContext aContext ) throws SFException,Exception;
}
