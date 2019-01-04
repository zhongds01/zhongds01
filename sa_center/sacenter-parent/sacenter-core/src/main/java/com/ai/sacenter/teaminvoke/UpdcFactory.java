package com.ai.sacenter.teaminvoke;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.teaminvoke.in.interfaces.IUpdbcSV;
import com.ai.sacenter.teaminvoke.in.interfaces.IUpdcSV;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ���񼤻�ӿڷ���</p>
 * <p>Copyright: Copyright (c) 2015��11��5��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcFactory {
	public UpdcFactory() {
		super();
	}
	/**
	 * ���񼤻��ڲ�����
	 * @return
	 * @throws Exception
	 */
	public static IUpdcSV getIUpdcSV() throws Exception{
		return (IUpdcSV)ServiceFactory.getService( IUpdcSV.class );
	}
	/**
	 * ��������ڲ�����
	 * @return
	 * @throws Exception
	 */
	public static IUpdbcSV getIUpdbcFSV() throws Exception{
		return (IUpdbcSV)ServiceFactory.getService( IUpdbcSV.class );
	}
}
