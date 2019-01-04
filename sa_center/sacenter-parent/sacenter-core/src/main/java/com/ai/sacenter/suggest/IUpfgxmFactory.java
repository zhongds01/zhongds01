package com.ai.sacenter.suggest;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.core.IUpdcpmCapital;
import com.ai.sacenter.suggest.service.interfaces.IUpfgxmSRV;
import com.ai.sacenter.suggest.service.interfaces.IUpdcpmSRV;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年11月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgxmFactory {
	public IUpfgxmFactory() {
		super();
	}
	/**
	 * 服务反馈内部服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfgxmSRV getIUpfgxmSV() throws SFException,Exception{
		return (IUpfgxmSRV)UpfsvcFactory.getService( IUpfgxmSRV.class );
	}
	/**
	 * 服务反馈组件服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpmSRV getIUpdcpmSV() throws SFException,Exception{
		return (IUpdcpmSRV)UpfsvcFactory.getService( IUpdcpmSRV.class );
	}
	/**
	 * 根据服务组件类获取当前服务组件服务
	 * @param fromJAVA
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpmCapital getIUpdcpmSV( String fromJAVA ) throws SFException,Exception{
		return (IUpdcpmCapital)UpfsvcFactory.getService( fromJAVA, 
				IUpdcConst.IEnum.IInvoke.Singleton, 
				IUpdcpmCapital.class.getName(), 
				fromJAVA );
	}
}
