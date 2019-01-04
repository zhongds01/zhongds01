package com.ai.sacenter.suggest;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.suggest.dao.interfaces.IUpfgxmDAO;
import com.ai.sacenter.suggest.service.interfaces.IUpfgxmSV;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016��11��22��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfgxmFactory {
	public UpfgxmFactory() {
		super();
	}
	/**
	 * ����洢�ӿ�
	 * @return
	 * @throws Exception
	 */
	public static IUpfgxmDAO getIUpfgxmDAO() throws Exception{
		return (IUpfgxmDAO)ServiceFactory.getService( IUpfgxmDAO.class );
	}
	
	/**
	 * �������ӿ�
	 * @return
	 * @throws Exception
	 */
	public static IUpfgxmSV getIUpfgxmSV() throws Exception{
		return (IUpfgxmSV)ServiceFactory.getService( IUpfgxmSV.class );
	}
}
