package com.asiainfo.sacenter.shcmcc.provision.dsmp;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sacenter.shcmcc.provision.dsmp.dao.interfaces.IDsmapDAO;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê3ÔÂ20ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class DsmapFactory {
	public DsmapFactory() {
		super();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IDsmapDAO getIDsmapDAO() throws Exception{
		return (IDsmapDAO)ServiceFactory.getService( IDsmapDAO.class );
	}

}
