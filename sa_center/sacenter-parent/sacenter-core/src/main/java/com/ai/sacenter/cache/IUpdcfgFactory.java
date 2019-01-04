package com.ai.sacenter.cache;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.interfaces.IDialect;
import com.ai.sacenter.cache.interfaces.IUpdcpmSRV;
import com.ai.sacenter.cache.interfaces.IBasicSRV;
import com.ai.sacenter.cache.interfaces.IUpffmSRV;
import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.module.model.ICacheConfigure;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��ͨ������񹤳�</p>
 * <p>Copyright: Copyright (c) 2015��9��27��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdcfgFactory {
	public IUpdcfgFactory() {
		super();
	}
	
	/**
	 * �������[��������]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IDialect getIUpdcfgSV() throws SFException,Exception{
		IDialect fromDialect = null;
		try
		{
			ICacheConfigure.ICacheRoute fromRoute = SFCacheFactory.getCache().hgetRoute();
			fromDialect = (IDialect)UpfsvcFactory.getService( fromRoute.getPERSISTENCE(), 
					IUpdcConst.IEnum.IInvoke.Singleton, 
					IDialect.class.getName(), 
					fromRoute.getPERSISTENCE() );
		}
		finally{
			
		}
		return fromDialect;
	}
	
	/**
	 * ��������[��������]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IBasicSRV getIBasicSV() throws SFException,Exception{
		return (IBasicSRV)UpfsvcFactory.getService( IBasicSRV.class );
	}
	
	/**
	 * ��������[��������]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpmSRV getIUpdcpmSV() throws SFException,Exception{
		return (IUpdcpmSRV)UpfsvcFactory.getService( IUpdcpmSRV.class );
	}
	
	/**
	 * ��Ԫ����[��������]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpffmSRV getIUpffmSV() throws SFException,Exception{
		return (IUpffmSRV)UpfsvcFactory.getService( IUpffmSRV.class );
	}
}
