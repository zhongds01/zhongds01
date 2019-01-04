package com.ai.sacenter.center;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.interfaces.ICenterSRV;
import com.ai.sacenter.common.UpfsvcFactory;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê9ÔÂ26ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ICenterFactory {
	public ICenterFactory() {
		super();
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static ICenterSRV getICenterSV() throws SFException,Exception{
		return (ICenterSRV)UpfsvcFactory.getService( ICenterSRV.class );
	}
	/**
	 * 
	 * @param fromImpl
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static ICenterWrapper getIUpdbcSV( String fromImpl ) throws SFException,Exception{
		return (ICenterWrapper)UpfsvcFactory.getService( fromImpl, 
				IUpdcConst.IEnum.IInvoke.Singleton, 
				ICenterWrapper.class.getName(), 
				fromImpl);
	}
}
