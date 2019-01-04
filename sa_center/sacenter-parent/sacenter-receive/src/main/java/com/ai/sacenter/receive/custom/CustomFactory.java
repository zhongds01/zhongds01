package com.ai.sacenter.receive.custom;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO;
import com.ai.sacenter.receive.custom.group.dao.interfaces.IGroupCustDAO;
import com.ai.sacenter.receive.custom.service.interfaces.ICustomSV;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: 客户中心服务[APP]</p>
 * <p>Copyright: Copyright (c) 2016年3月21日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class CustomFactory {
	public CustomFactory(){
		super();
	}
	/**
	 * 客户中心DAO
	 * @return
	 * @throws Exception
	 */
	public static ICustomDAO getICustomDAO() throws Exception{
		return (ICustomDAO)ServiceFactory.getService(ICustomDAO.class);
	}
	/**
	 * 集团客户DAO
	 * @return
	 * @throws Exception
	 */
	public static IGroupCustDAO getIGroupDAO() throws Exception{
		return (IGroupCustDAO)ServiceFactory.getService(IGroupCustDAO.class);
	}
	/**
	 * 客户中心SV
	 * @return
	 * @throws Exception
	 */
	public static ICustomSV getICustomSV() throws Exception{
		return (ICustomSV)ServiceFactory.getService(ICustomSV.class);
	}
}
