package com.ai.sacenter.servicefulfil;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.servicefulfil.cboss.dao.interfaces.ISFCBossDAO;
import com.ai.sacenter.servicefulfil.custom.dao.interfaces.ISFCustomDAO;
import com.ai.sacenter.servicefulfil.dao.interfaces.ISFUpdcDAO;
import com.ai.sacenter.servicefulfil.service.interfaces.ISFUpdcFSV;
import com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年1月12日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpdcFactory {
	public SFUpdcFactory() {
		super();
	}
	/**
	 * 服务激活内部服务
	 * @return
	 * @throws Exception
	 */
	public static ISFUpdcFSV getIUpdcFSV() throws Exception{
		return (ISFUpdcFSV)ServiceFactory.getService( ISFUpdcFSV.class );
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ISFUpdcDAO getIUpdcDAO() throws Exception{
		//return (ISFUpdcDAO)ServiceFactory.getService( ISFUpdcDAO.class );
		return (ISFUpdcDAO)ServiceFactory.getService( ISFUpdcDAO.class.getName() );
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ISFCustomDAO getICustomDAO() throws Exception{
		return (ISFCustomDAO)ServiceFactory.getService( ISFCustomDAO.class );
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ISFCBossDAO getICBossDAO() throws Exception{
		return (ISFCBossDAO)ServiceFactory.getService( ISFCBossDAO.class );
	}
}
