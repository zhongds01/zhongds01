package com.ai.sacenter.base;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.base.basic.dao.interfaces.IBaseDAO;
import com.ai.sacenter.base.basic.dao.interfaces.ICfgBasicDAO;
import com.ai.sacenter.base.basic.service.interfaces.IBaseSV;
import com.ai.sacenter.base.basic.service.interfaces.ICfgBasicSV;
import com.ai.sacenter.base.competence.dao.interfaces.ICfgUpdcpmDAO;
import com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV;
import com.ai.sacenter.base.platform.dao.interfaces.ICfgUpffmDAO;
import com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV;

/**
 * <p>Title: sacenter</p>
 * <p>Description: ��������</p>
 * <p>Copyright: Copyright (c) 2015��9��30��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class BasicFactory {
	public BasicFactory() {
		super();
	}
	/**
	 * ��������
	 * @return
	 * @throws Exception
	 */
	public static IBaseDAO getIBaseDAO() throws Exception{
		return (IBaseDAO)ServiceFactory.getService( IBaseDAO.class );
	}
	/**
	 * ����SV��
	 * @return
	 * @throws Exception
	 */
	public static IBaseSV getIBaseSV() throws Exception{
		return (IBaseSV)ServiceFactory.getService( IBaseSV.class );
	}
	/**
	 * ��������[��������]
	 * @return
	 * @throws Exception
	 */
	public static ICfgBasicDAO getIBasicDAO() throws Exception{
		return (ICfgBasicDAO)ServiceFactory.getService( ICfgBasicDAO.class );
	}
	/**
	 * ��������[��������]
	 * @return
	 * @throws Exception
	 */
	public static ICfgBasicSV getIBasicSV() throws Exception{
		return (ICfgBasicSV)ServiceFactory.getService( ICfgBasicSV.class );
	}
	/**
	 * ��������[��������]
	 * @return
	 * @throws Exception
	 */
	public static ICfgUpdcpmDAO getIUpdcpmDAO() throws Exception{
		return (ICfgUpdcpmDAO)ServiceFactory.getService( ICfgUpdcpmDAO.class );
	}
	/**
	 * ��������[��������]
	 * @return
	 * @throws Exception
	 */
	public static ICfgUpdcpmSV getIUpdcpmSV() throws Exception{
		return (ICfgUpdcpmSV)ServiceFactory.getService( ICfgUpdcpmSV.class );
	}
	/**
	 * ��Ԫ����[��������]
	 * @return
	 * @throws Exception
	 */
	public static ICfgUpffmDAO getIUpffmDAO() throws Exception{
		return (ICfgUpffmDAO)ServiceFactory.getService( ICfgUpffmDAO.class );
	}
	/**
	 * @return
	 * @throws Exception
	 */
	public static ICfgUpffmSV getIUpffmSV() throws Exception{
		return (ICfgUpffmSV)ServiceFactory.getService( ICfgUpffmSV.class );
	}
}
