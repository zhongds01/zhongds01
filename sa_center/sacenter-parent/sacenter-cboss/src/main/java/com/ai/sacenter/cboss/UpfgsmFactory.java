package com.ai.sacenter.cboss;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.cboss.dao.interfaces.IUpfgsmDAO;
import com.ai.sacenter.cboss.service.interfaces.IUpfgsmSV;

/**
 * <p>Title: sacenter-cboss</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê3ÔÂ8ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfgsmFactory {

	public UpfgsmFactory() {
		super();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IUpfgsmDAO getIUpfgsmDAO() throws Exception{
		return (IUpfgsmDAO)ServiceFactory.getService( IUpfgsmDAO.class );
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IUpfgsmSV getIUpfgsmSV() throws Exception{
		return (IUpfgsmSV)ServiceFactory.getCrossCenterService( IUpfgsmSV.class );
	}
}
