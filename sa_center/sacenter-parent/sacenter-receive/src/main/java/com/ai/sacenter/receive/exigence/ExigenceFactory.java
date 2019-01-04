package com.ai.sacenter.receive.exigence;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.receive.exigence.dao.interfaces.IRocketDAO;
import com.ai.sacenter.receive.exigence.dao.remote.interfaces.IRemoteDAO;
import com.ai.sacenter.receive.exigence.service.interfaces.IExigenceSV;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��4��26��</p>
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
	 * �첽����[��ͨ���Ĳ�]DAO
	 * @return
	 * @throws Exception
	 */
	public static IRocketDAO getIRocketDAO() throws Exception{
		return (IRocketDAO)ServiceFactory.getService( IRocketDAO.class );
	}
	
	/**
	 * �첽����[�������Ĳ�]DAO
	 * @return
	 * @throws Exception
	 */
	public static IRemoteDAO getIRemoteDAO() throws Exception{
		return (IRemoteDAO)ServiceFactory.getService( IRemoteDAO.class );
	}
	
	/**
	 * �첽����DAO
	 * @param _repository
	 * @return
	 * @throws Exception
	 */
	public static IRocketDAO getIRocketDAO( Class _repository) throws Exception{
		return (IRocketDAO)ServiceFactory.getService( _repository );
	}
	
	/**
	 * �첽����SV
	 * @return
	 * @throws Exception
	 */
	public static IExigenceSV getIUpdcSV() throws Exception{
		return (IExigenceSV)ServiceFactory.getService( IExigenceSV.class );
	}
	
}
