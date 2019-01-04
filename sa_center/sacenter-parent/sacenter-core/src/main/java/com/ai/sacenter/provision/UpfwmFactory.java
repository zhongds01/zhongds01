package com.ai.sacenter.provision;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.provision.dao.interfaces.IUpdfmxDAO;
import com.ai.sacenter.provision.dao.interfaces.IUpffmxDAO;
import com.ai.sacenter.provision.dao.interfaces.IUpfpmDAO;
import com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO;
import com.ai.sacenter.provision.service.interfaces.IUpdfdpSV;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元工单服务接口</p>
 * <p>Copyright: Copyright (c) 2015年9月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmFactory {
	public UpfwmFactory() {
		super();
	}
	/**
	 * 网元工单DAO类
	 * @return
	 * @throws Exception
	 */
	public static IUpfwmDAO getIUpfwmDAO() throws Exception{
		return (IUpfwmDAO)ServiceFactory.getService( IUpfwmDAO.class );
	}
	/**
	 * 批量工单计划DAO类
	 * @return
	 * @throws Exception
	 */
	public static IUpfpmDAO getIUpfpmDAO() throws Exception{
		return (IUpfpmDAO)ServiceFactory.getService( IUpfpmDAO.class );
	}
	/**
	 * 消息计划DAO类
	 * @return
	 * @throws Exception
	 */
	public static IUpdfmxDAO getIUpdfmxDAO() throws Exception{
		return (IUpdfmxDAO)ServiceFactory.getService( IUpdfmxDAO.class );
	}
	/**
	 * 网元到期DAO类
	 * @return
	 * @throws Exception
	 */
	public static IUpffmxDAO getIUpffmxDAO() throws Exception{
		return (IUpffmxDAO)ServiceFactory.getService( IUpffmxDAO.class );
	}
	/**
	 * 根据网元DAO类获取网元DAO类接口
	 * @param fromUpfwm
	 * @return
	 * @throws Exception
	 */
	public static IUpfwmDAO getIUpfwmDAO( Class fromUpfwm ) throws Exception{
		if( fromUpfwm == null ) fromUpfwm = IUpfwmDAO.class;
		return (IUpfwmDAO)ServiceFactory.getService( fromUpfwm );
	}
	/**
	 * 调度独立事务
	 * @return
	 * @throws Exception
	 */
	public static IUpdfdpSV getIUpdfdpSV() throws Exception{
		return (IUpdfdpSV)ServiceFactory.getService( IUpdfdpSV.class );
	}
}
