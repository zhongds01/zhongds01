package com.ai.sacenter.receive.exigence.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketConsult;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ����������ʲ�</p>
 * <p>Copyright: Copyright (c) 2018��1��31��</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public interface IUpdfmxSRV {
	/**
	 * ��ǰ��ͨ��������ʷ�鵵[��ͨ����������]
	 * @param fromMBean ȫ������
	 * @param fromRocket ��ͨ������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdfmxHistory(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��ǰ��ͨ�������˹�����[��ͨ����������]
	 * @param fromMBean ȫ������
	 * @param fromRocket ��ͨ������
	 * @param aEXCEPTION �˹�����ԭ��
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdfmxHistory(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��ͨ�������û��ֽ����[��ͨ�����ֽ���]
	 * @param fromRocket ��ͨ����
	 * @param fromUpdfmx ��ͨ�ֽ���
	 * @param fromUpdcpm �����������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMocketConsult finishSFUpdfmxDefault( IOVMsgFExigence fromRocket,
			IOVMocketConsult fromUpdfmx,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ǰ��ͨ��������ʷ�鵵[��ͨ�������쳣���]
	 * @param fromMBean ȫ������
	 * @param fromRocket ��ͨ������
	 * @param fromUpdcpm �쳣�鵵���
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmHistory(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��ǰ��ͨ�����������鵵[��ͨ�������쳣���]
	 * @param fromMBean ȫ������
	 * @param fromRocket ��ͨ������
	 * @param fromUpdcpm �쳣�鵵���
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmConnection(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��ǰ��ͨ������ʧ�ܹ鵵[��ͨ�������쳣���]
	 * @param fromMBean ȫ������
	 * @param fromRocket ��ͨ������
	 * @param fromUpdcpm �쳣�鵵���
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmException(MBeanDelegate fromMBean,
			IOVMocketExigence fromRocket,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��ǰ��ͨ���������ͨ���ù켣
	 * @param fromMBean ��������
	 * @param fromRocket ��ͨ������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdfmxLifite( MBeanDelegate fromMBean, 
			IOVMocketExigence fromRocket,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
}
