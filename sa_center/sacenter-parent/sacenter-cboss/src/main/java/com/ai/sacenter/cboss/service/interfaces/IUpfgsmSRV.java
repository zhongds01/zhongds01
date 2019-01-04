package com.ai.sacenter.cboss.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

public interface IUpfgsmSRV {
	/**
	 * ���ݿ�ͨ��������CBOSS��ҵ��ƽ̨��������ͬ��
	 * @param fromOrder ��ͨ����
	 * @param fromTASK ��ͨ����
	 * @param fromUpdfwm ��ָͨ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ��������CBOSS�����ݼƷ���������ͬ��
	 * @param fromOrder ��ͨ����
	 * @param fromTASK ��ͨ����
	 * @param fromUpdfwm ��ָͨ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgxmOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ��������CBOSS��ȫ���û�״̬ͬ��
	 * @param fromOrder ��ͨ����
	 * @param fromTASK ��ͨ����
	 * @param fromUpdfwm ��ָͨ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgsmStatus(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ��������CBOSS���û�Ʒ�Ʊ仯ͬ��
	 * @param fromOrder ��ͨ����
	 * @param fromTASK ��ͨ����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgsmBrand( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	
	/**
	 * ���ݿ�ͨ��������CBOSS��ҵ��ƽ̨��������ͬ��
	 * @param fromOrder ��ͨ����
	 * @param fromTASK ��ͨ����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfgkmPassive(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext)throws SFException, Exception;
	
	/**
	 * ���ݿ�ͨ��������CBOSS�����ݼƷѱ�������ͬ��
	 * @param fromOrder ��ͨ����
	 * @param fromTASK ��ͨ����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSUpfgxmPassive(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext)throws SFException, Exception;
	/**
	 * 
	 * @param fromUpfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap finishSFUpfgsmMisc( java.util.HashMap fromUpfwm, 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���񼤻�⵽CBOSS��ͬ��
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome ��Ԫ������
	 * @param fromASK ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgsmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * �����Ԫ���첽���������񼤻���
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome �첽��Ԫ����
	 * @param aContext ������Ϣ
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfgsmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws RemoteException, Exception;
	
}
