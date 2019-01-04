package com.ai.sacenter.tykt.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: sacenter-tykt</p>
 * <p>Description: ��Ԫ�����ڲ�����</p>
 * <p>Copyright: Copyright (c) 2016��2��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISFUpfgkmSRV {
	/**
	 * 
	 * @param fromOrder
	 * @param fromTASK
	 * @param fromUpdfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwmCreate(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromOrder
	 * @param fromTASK
	 * @param fromUpdfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwmChange(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ɷ���ͨ���������
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome Ӫҵ������������
	 * @param aContext ������Ϣ
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmUrgency( MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ����ͨ�⵽ͳһ��ͨ��ͬ��
	 * @param fromMBean ����ȫ������
	 * @param fromUpfgkmHome ��Ԫ������
	 * @param fromASK ������Ϣ
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmSync(MBeanDelegate fromMBean,
			IUpfgkmCityHome fromUpfgkmHome,
			IUpdcContext aContext) throws SFException, Exception;
}
