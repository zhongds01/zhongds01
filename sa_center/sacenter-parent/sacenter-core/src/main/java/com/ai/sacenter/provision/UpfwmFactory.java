package com.ai.sacenter.provision;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.provision.dao.interfaces.IUpdfmxDAO;
import com.ai.sacenter.provision.dao.interfaces.IUpffmxDAO;
import com.ai.sacenter.provision.dao.interfaces.IUpfpmDAO;
import com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO;
import com.ai.sacenter.provision.service.interfaces.IUpdfdpSV;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ��������ӿ�</p>
 * <p>Copyright: Copyright (c) 2015��9��24��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmFactory {
	public UpfwmFactory() {
		super();
	}
	/**
	 * ��Ԫ����DAO��
	 * @return
	 * @throws Exception
	 */
	public static IUpfwmDAO getIUpfwmDAO() throws Exception{
		return (IUpfwmDAO)ServiceFactory.getService( IUpfwmDAO.class );
	}
	/**
	 * ���������ƻ�DAO��
	 * @return
	 * @throws Exception
	 */
	public static IUpfpmDAO getIUpfpmDAO() throws Exception{
		return (IUpfpmDAO)ServiceFactory.getService( IUpfpmDAO.class );
	}
	/**
	 * ��Ϣ�ƻ�DAO��
	 * @return
	 * @throws Exception
	 */
	public static IUpdfmxDAO getIUpdfmxDAO() throws Exception{
		return (IUpdfmxDAO)ServiceFactory.getService( IUpdfmxDAO.class );
	}
	/**
	 * ��Ԫ����DAO��
	 * @return
	 * @throws Exception
	 */
	public static IUpffmxDAO getIUpffmxDAO() throws Exception{
		return (IUpffmxDAO)ServiceFactory.getService( IUpffmxDAO.class );
	}
	/**
	 * ������ԪDAO���ȡ��ԪDAO��ӿ�
	 * @param fromUpfwm
	 * @return
	 * @throws Exception
	 */
	public static IUpfwmDAO getIUpfwmDAO( Class fromUpfwm ) throws Exception{
		if( fromUpfwm == null ) fromUpfwm = IUpfwmDAO.class;
		return (IUpfwmDAO)ServiceFactory.getService( fromUpfwm );
	}
	/**
	 * ���ȶ�������
	 * @return
	 * @throws Exception
	 */
	public static IUpdfdpSV getIUpdfdpSV() throws Exception{
		return (IUpdfdpSV)ServiceFactory.getService( IUpdfdpSV.class );
	}
}
