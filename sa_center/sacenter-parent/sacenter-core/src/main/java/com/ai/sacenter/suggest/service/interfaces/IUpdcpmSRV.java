package com.ai.sacenter.suggest.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.suggest.valuebean.IOVUpfgxmPentium;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �������������</p>
 * <p>Copyright: Copyright (c) 2015��11��9��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpmSRV {
	/**
	 * ���ݵ�ǰ���񶨵���ѯ����׶����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFTaskComplete( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK[],
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ����������ɷ���׶�֪ͨ
	 * @param fromOrder ���񶨵�
	 * @param fromTASK  ���񶨵�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgxmPentium finishSFTaskComplete( IOVOrderPentium fromOrder, 
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
	public IOVUpfgxmPentium finishSFTaskComplete( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ����׶ε���ѯ����׶����
	 * @param fromMBean
	 * @param fromUpfgkmHome
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpdcpmOffer getSFUpfgxmComplete( MBeanDelegate fromMBean,
			IOVUpfgxmPentium fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * ���ݵ�ǰ����׶ε�����ⲿ�׶�֪ͨ
	 * @param fromMBean
	 * @param fromUpfgkmHome
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgxmComplete( MBeanDelegate fromMBean,
			IOVUpfgxmPentium fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception;
}
