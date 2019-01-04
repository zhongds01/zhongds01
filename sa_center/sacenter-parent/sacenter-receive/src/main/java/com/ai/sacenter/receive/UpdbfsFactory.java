package com.ai.sacenter.receive;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.receive.teaminvoke.in.interfaces.IProductSV;
import com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpdbcSV;
import com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpdcSV;
import com.ai.sacenter.receive.teaminvoke.in.interfaces.IUpffmxSV;
import com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcFSV;

public class UpdbfsFactory {
	public UpdbfsFactory(){
		super();
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static IProductSV getIProductSV() throws Exception{
		return (IProductSV)ServiceFactory.getService( IProductSV.class );
	} 
	/**
	 * 对接CSF服务
	 * @return
	 * @throws Exception
	 */
	public static IUpdcFSV getIUpdcFSV() throws Exception{
		return (IUpdcFSV)ServiceFactory.getService( IUpdcFSV.class );
	}
    
	/**
	 * 开通定单接收服务[内部][嵌套事务]
	 * @return
	 * @throws Exception
	 */
	public static IUpffmxSV getIUpffmxSV() throws Exception{
		return (IUpffmxSV)ServiceFactory.getService( IUpffmxSV.class );
	}
	
	/**
	 * 开通定单接收服务[内部][嵌套事务]
	 * @return
	 * @throws Exception
	 */
	public static IUpdcSV getIUpdcSV() throws Exception{
		return (IUpdcSV)ServiceFactory.getService( IUpdcSV.class );
	}
	/**
	 * 开通定单接收[内部][独立事务]
	 * @return
	 * @throws Exception
	 */
	public static IUpdbcSV getIUpdbcSV() throws Exception{
		return (IUpdbcSV)ServiceFactory.getService( IUpdbcSV.class );
	}
}
