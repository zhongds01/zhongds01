package com.ai.sacenter.receive.expire;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.receive.expire.dao.interfaces.IExpireDAO;
import com.ai.sacenter.receive.expire.service.interfaces.IExpireSV;

/**
 * 
 * @author:HC
 * @date:2016Äê3ÔÂ14ÈÕ
 * @description:
 */
public class ExpireFactory {
	public ExpireFactory(){
		super();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IExpireDAO getExpireDAO()throws Exception{
		return (IExpireDAO)ServiceFactory.getService(IExpireDAO.class);
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IExpireSV getExpireSV()throws Exception{
		return (IExpireSV)ServiceFactory.getService(IExpireSV.class);
	}
}
