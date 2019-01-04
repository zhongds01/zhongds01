package com.ai.sacenter.provision.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpffmxOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmComplete;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ��������</p>
 * <p>Copyright: Copyright (c) 2013-4-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpfwmSRV {
	/**
	 * ���ݷ��񶨵�����������Ԫ������ͨ���Լ���ͨ���ȼ�
	 * @param fromOrder ��ͨ����
	 * @param fromTASK ��ͨ����
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ��Ԫָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxOffer finishSFUpfwmLifite(IOVOrderPentium fromOrder,
			IOVTaskPentium  fromTASK,
			IOVUpfwmOffer fromUpfwm,
	        IOVUpdspmLife  fromUpdfwm, 
	        IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ��Ԫӳ�����������̼���Ԫ�����������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����ӳ�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap finishSFUpfwmOffer( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ������Ԫ������ѯ��ǰ��Ԫ�������������嵥
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ��������ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmRequest getSFUpfwmOffer(IOVUpfwmOffer fromUpfwm,
	        IOVUpdspmLife fromUpdfwm, 
	        IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ����������ɷ���ͨ�����̼���Ԫ����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmOffer finishSFUpfwmCreate( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ����������ɷ���ͨ�����̼���Ԫ�仯����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmOffer finishSFUpfwmChange( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ����������ɷ���ͨ�����̼���Ԫ����(����ת��Ԫ��ʷ��������Ԫ��������)
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmOffer finishSFUpfwmActive( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݷ��񶨵������������Ԫʵʱ����(������Ԫ��ʷ�������쳣��Ԫ��ع���)
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwmSync(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ѯ��ǰ��Ԫ����·�ɹ���
	 * @param fromBILL �û�����
	 * @param fromUpfm ������Ԫ
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmPhone getSFUpfwmUser( String fromBILL , 
			IPlatformTemplate.IUpffmOffer fromUpfm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��񶨵���ѯ��ǰ�������嵥
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdfwm ��Ԫָ�
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmPhone getSFUpfwmUser( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��ѯ��Ԫ���Է�������
	 * @param fromUpfm ��Ԫ��Ϣ
	 * @param fromUpdfm ��Ԫָ����Ϣ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public byte[] getSFUpfwmDebug( IPlatformTemplate.IUpffmOffer fromUpfm,
			IPlatformTemplate.IUpffmDirective fromUpdfm) throws SFException,Exception;	
	/**
	 * ��ɷ��񶨵��첽��洢
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwm( IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �����Ԫ�����鵵����
	 * @param fromUpfwm
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete( IOVUpfwmOffer fromUpfwm[] , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������Ԫ���������������
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ�
	 * @param fromASK ��Ԫ������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwm( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromASK,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ������Ԫ��������쳣����
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ�
	 * @param aEXCEPTION ��Ԫ�쳣��
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwm( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ������Ԫ�����������Ԫʵʱ����
	 * @param fromUpfwm ��Ԫ����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmNetWork( IOVUpfwmOffer fromUpfwm, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ת�������в���[��̨�����Զ�����]
	 * @param fromUpfwm ��Ԫ����
	 * @param aUpdspmLife ��Ԫָ��
	 * @param fromUpdcpm �쳣�������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmQueue( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * �����쳣����[�쳣�����鵵]
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ��Ԫָ��
	 * @param fromUpdcpm �쳣�������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmException( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ������Ԫ���������ԪӦ�����(������Ԫ����������ʷ��)
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ�
	 * @param fromASK ��Ԫ������
	 * @param aEXCEPTION ��Ԫ�쳣��
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfwmMonitor( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ��Ԫ��ִ���鵵�����񹤵���ʷ����
	 * @param fromMBean ����ȫ������
	 * @param fromUpfwm ��Ԫ�����嵥
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmHistory(IOVUpfwmComplete fromUpfwm, 
            IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * �����Ԫ�ⷴ�����鵵�����񼤻���ʷ��ͷ�����Ԫ������
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome ��Ԫ�����嵥
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmComplete(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * ����ͨ��ʵʱͬ������Ԫ��
	 * @param fromUpfwm ��Ԫ����
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwmSync(IOVUpfwmOffer fromUpfwm,
			IUpdcContext aContext) throws RemoteException, Exception;
	/**
	 * ��ɷ�����Ԫ��������Ԫ�⼤��
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome ��Ԫ�����嵥
	 * @param aContext
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finishSFUpfwmNetWork(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws RemoteException, Exception;
}
