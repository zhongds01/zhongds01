package com.ai.sacenter.suggest.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �������ڲ�����</p>
 * <p>Copyright: Copyright (c) 2014-12-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgxmSRV {
	/**
	 * ���ݵ�ǰ����������ɷ���׶�֪ͨ
	 * @param fromOrder ���񶨵�
	 * @param fromTASK  ���񶨵�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK[],
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ����������ɷ���׶�֪ͨ
	 * @param fromOrder ���񶨵�
	 * @param fromTASK  ���񶨵�����
	 * @param aEXCEPTION �쳣����(ΪNULL��ɹ��������쳣���)
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ����׶ε�����ⲿ�׶�֪ͨ
	 * @param fromMBean
	 * @param fromUpfgkmHome
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgxmComplete( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception;
}
