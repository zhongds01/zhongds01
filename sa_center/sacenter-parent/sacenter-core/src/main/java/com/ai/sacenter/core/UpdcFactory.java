package com.ai.sacenter.core;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.core.dao.interfaces.IUpdcDAO;
import com.ai.sacenter.core.dao.interfaces.IUpdfmxDAO;
import com.ai.sacenter.core.service.interfaces.IUpdcSV;
import com.ai.sacenter.jdbc.IUpdbmDAOLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务激活服务接口</p>
 * <p>Copyright: Copyright (c) 2011-10-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdcFactory {

	public UpdcFactory() {
		super();
	}
	
	/**
	 * 调度DAO类
	 * @return
	 * @throws Exception
	 */
	public static IUpdcDAO getIUpdcDAO() throws Exception{
		return (IUpdcDAO)ServiceFactory.getService( IUpdcDAO.class );
	}
	
	/**
	 * 
	 * @param fromDAO
	 * @return
	 * @throws Exception
	 */
	public static IUpdbmDAOLife getIUpdcDAO( Class fromDAO ) throws Exception{
		return (IUpdbmDAOLife)ServiceFactory.getService( fromDAO );
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IUpdfmxDAO getIUpdfmxDAO() throws Exception{
		return (IUpdfmxDAO)ServiceFactory.getService( IUpdfmxDAO.class );
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IUpdcSV getIUpdcSV() throws Exception{
		return (IUpdcSV)ServiceFactory.getService( IUpdcSV.class );
	}
}
