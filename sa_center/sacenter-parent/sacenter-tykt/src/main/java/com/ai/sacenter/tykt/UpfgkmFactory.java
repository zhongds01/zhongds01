package com.ai.sacenter.tykt;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.tykt.dao.interfaces.IUpfgkmDAO;
import com.ai.sacenter.tykt.service.interfaces.ISFUpfgkmSV;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê9ÔÂ23ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfgkmFactory {

	public UpfgkmFactory() {
		super();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IUpfgkmDAO getIUpfgkmDAO() throws Exception{
		return (IUpfgkmDAO)ServiceFactory.getService( IUpfgkmDAO.class );
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ISFUpfgkmSV getIUpfgkmSV() throws Exception{
		return (ISFUpfgkmSV)ServiceFactory.getCrossCenterService( ISFUpfgkmSV.class );
	}
}
