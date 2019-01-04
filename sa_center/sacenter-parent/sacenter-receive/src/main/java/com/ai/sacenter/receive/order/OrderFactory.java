package com.ai.sacenter.receive.order;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.receive.order.dao.interfaces.IUrgencyDAO;
import com.ai.sacenter.receive.order.dao.interfaces.IOrderDAO;

public class OrderFactory {
	public OrderFactory(){
		super();
	}
	/**
	 * 开通定单DAO
	 * @return
	 * @throws Exception
	 */
	public static IOrderDAO getIOrderDAO() throws Exception{
		return (IOrderDAO)ServiceFactory.getService(IOrderDAO.class);
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IUrgencyDAO getIUrgencyDAO() throws Exception{
		return (IUrgencyDAO)ServiceFactory.getService(IUrgencyDAO.class);
	}
}
