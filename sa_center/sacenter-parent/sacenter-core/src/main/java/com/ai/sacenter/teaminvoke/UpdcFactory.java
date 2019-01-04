package com.ai.sacenter.teaminvoke;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.teaminvoke.in.interfaces.IUpdbcSV;
import com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务激活接口服务</p>
 * <p>Copyright: Copyright (c) 2015年11月5日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcFactory {
	public UpdcFactory() {
		super();
	}
	/**
	 * 服务激活内部服务
	 * @return
	 * @throws Exception
	 */
	public static IUpdcSV getIUpdcSV() throws Exception{
		return (IUpdcSV)ServiceFactory.getService( IUpdcSV.class );
	}
	/**
	 * 服务进程内部服务
	 * @return
	 * @throws Exception
	 */
	public static IUpdbcSV getIUpdbcFSV() throws Exception{
		return (IUpdbcSV)ServiceFactory.getService( IUpdbcSV.class );
	}
}
