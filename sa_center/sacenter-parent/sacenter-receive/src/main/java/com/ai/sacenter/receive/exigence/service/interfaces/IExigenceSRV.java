package com.ai.sacenter.receive.exigence.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ�첽�����ڲ�����</p>
 * <p>Copyright: Copyright (c) 2017��4��26��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExigenceSRV {
	/**
	 * ��ͨ�����ַ�����
	 * @param fromExigence ��ͨ�����ַ�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMocketRespone rocketDistribute( IOVMsgFExigence fromExigence,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ͨ�첽����[����]������
	 * @param fromMBean ȫ������
	 * @param fromUpfgkmHome ��ͨ������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��ͨ���������[ͬ����ʽ]
	 * @param fromExigence ��ͨ������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMocketRespone rocketReceive( IOVMsgFExigence fromExigence ) throws SFException,Exception;
	/**
	 * ��ͨ���������[�첽��ʽ]
	 * @param fromExigence ��ͨ������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void rocketReceiveAsyn( IOVMsgFExigence fromExigence[] ) throws SFException,Exception;
	/**
     * ��ͨ���������쳣[�첽��ʽ]
     * @param fromExigence ��ͨ����
     * @param aEXCEPTION ҵ������
     * @return
     * @throws SFException
     * @throws Exception
     */
	public void rocketReceiveAsyn(IOVMsgFExigence fromExigence[], SFException aEXCEPTION) throws SFException,Exception;
	/**
	 * ��ͨ������鵵[�첽��ʽ]
	 * @param fromRocket ��ͨ�첽����
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVMocketRespone rocketComplete( IOVMocketRespone fromRocket ) throws SFException,Exception;
	/**
	 * ��ͨ���������[�첽�뿪ͨ�첽��]
	 * @param fromExigence ��ͨ����
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void rabbitReceiveAsyn( IOVMocketExigence fromExigence[] ) throws SFException, Exception;
}
