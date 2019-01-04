package com.ai.sacenter.receive.exigence.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��6��15��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdcpmSRV {
	/**
	 * �����������Ĭ���첽�鵵[�첽��ʽ]
	 * @param fromRocket ��ͨ�첽����
	 * @param fromUpdcpm ����鵵����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmDefault( IOVMocketRespone fromRocket,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	
	/**
	 * ������������첽�鵵[�첽��ʽ]
	 * @param fromRocket ��ͨ�첽����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmComplete(IOVMocketRespone fromRocket,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�������ȡ��ǰ��ͨ������鵵������
	 * @param fromRocket ��ͨ������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfgkmComplete( IOVMocketExigence fromRocket,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��ɵ�ǰ��ͨ�������쳣�鵵
	 * @param fromMBean ȫ������
	 * @param fromRocket ��ͨ������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmComplete(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	
}
