package com.ai.sacenter.receive;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.pce.service.interfaces.IProductFSV;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016��5��19��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class OtherFactory {
	public OtherFactory() {
		super();
	}
	/**
	 * ��ȡ��Ʒ����SV
	 * @return
	 * @throws Exception
	 */
	public static IProductFSV getIProductSV() throws Exception{
		return (IProductFSV)ServiceFactory.getService( IProductFSV.class );
	}
}
