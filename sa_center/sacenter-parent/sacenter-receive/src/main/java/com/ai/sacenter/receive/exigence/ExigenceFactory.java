package com.ai.sacenter.receive.exigence;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.receive.exigence.dao.interfaces.IRocketDAO;
import com.ai.sacenter.receive.exigence.dao.remote.interfaces.IRemoteDAO;
import com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSV;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ExigenceFactory {
	public ExigenceFactory() {
		super();
	}
	
	/**
	 * 异步定单[开通中心测]DAO
	 * @return
	 * @throws Exception
	 */
	public static IRocketDAO getIRocketDAO() throws Exception{
		return (IRocketDAO)ServiceFactory.getService( IRocketDAO.class );
	}
	
	/**
	 * 异步定单[订单中心测]DAO
	 * @return
	 * @throws Exception
	 */
	public static IRemoteDAO getIRemoteDAO() throws Exception{
		return (IRemoteDAO)ServiceFactory.getService( IRemoteDAO.class );
	}
	
	/**
	 * 异步定单DAO
	 * @param _repository
	 * @return
	 * @throws Exception
	 */
	public static IRocketDAO getIRocketDAO( Class _repository) throws Exception{
		return (IRocketDAO)ServiceFactory.getService( _repository );
	}
	
	/**
	 * 异步定单SV
	 * @return
	 * @throws Exception
	 */
	public static IExigenceSV getIUpdcSV() throws Exception{
		return (IExigenceSV)ServiceFactory.getService( IExigenceSV.class );
	}
	
}
