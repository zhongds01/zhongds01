package com.ai.sacenter.suggest;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.suggest.dao.interfaces.IUpfgxmDAO;
import com.ai.sacenter.suggest.service.interfaces.IUpfgxmSV;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年11月22日</p>
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
	 * 服务存储接口
	 * @return
	 * @throws Exception
	 */
	public static IUpfgxmDAO getIUpfgxmDAO() throws Exception{
		return (IUpfgxmDAO)ServiceFactory.getService( IUpfgxmDAO.class );
	}
	
	/**
	 * 服务服务接口
	 * @return
	 * @throws Exception
	 */
	public static IUpfgxmSV getIUpfgxmSV() throws Exception{
		return (IUpfgxmSV)ServiceFactory.getService( IUpfgxmSV.class );
	}
}
