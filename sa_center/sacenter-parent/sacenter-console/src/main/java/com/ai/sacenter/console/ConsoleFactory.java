package com.ai.sacenter.console;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.console.base.dao.interfaces.IBaseDAO;
import com.ai.sacenter.console.base.service.interfaces.IBaseSV;
import com.ai.sacenter.console.workpaper.dao.interfaces.IConsoleDAO;
import com.ai.sacenter.console.workpaper.service.interfaces.IConsoleSV;
import com.ai.sacenter.console.workpaper.service.interfaces.ISfCommSV;
import com.ai.sacenter.console.workpaper.service.interfaces.ISfSecSV;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-5-31</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ConsoleFactory {
	public ConsoleFactory(){
		super();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IBaseDAO getIBaseDAO() throws Exception{
		return (IBaseDAO)ServiceFactory.getService( IBaseDAO.class);
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IBaseSV getIBaseSV() throws Exception{
		return (IBaseSV)ServiceFactory.getService( IBaseSV.class);
	}
    /**
     * 
     * @return
     */
    public static IConsoleDAO getIConsoleDAO(){
    	 return  (IConsoleDAO)ServiceFactory.getService( IConsoleDAO.class );    	
    }
    /**
     * 
     * @return
     */
    public static ISfSecSV  getISfCommSV(){
 	    return (ISfSecSV)ServiceFactory.getService( ISfSecSV.class );
    }
    /**
     * 
     * @return
     */
    public static IConsoleSV getIConsoleSV(){
    	return (IConsoleSV) ServiceFactory.getService( IConsoleSV.class );
    }
    /**
     * 
     * @return
     */
    public static ISfCommSV getCom2UcmSV(){
    	return (ISfCommSV)ServiceFactory.getService( ISfCommSV.class );
    }
    
}
