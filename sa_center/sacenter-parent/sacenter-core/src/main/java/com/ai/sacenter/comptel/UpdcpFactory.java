package com.ai.sacenter.comptel;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.comptel.dao.interfaces.IUpdcpDAO;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015��10��30��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcpFactory {
	public UpdcpFactory() {
		super();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IUpdcpDAO getIUpdcpDAO() throws Exception{
		return (IUpdcpDAO)ServiceFactory.getService( IUpdcpDAO.class );
	}
}
