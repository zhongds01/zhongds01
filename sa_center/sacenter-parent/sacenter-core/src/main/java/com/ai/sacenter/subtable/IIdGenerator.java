package com.ai.sacenter.subtable;

import com.ai.appframe2.complex.tab.id.IIdGeneratorWrapper;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.ISubTableTemplate.IdGenerator;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫͳһ���ת��</p>
 * <p>Copyright: Copyright (c) 2013-8-15</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IIdGenerator extends IIdGeneratorWrapper{
	/**
	 * ����ͳһ��������ȡͳһ�������
	 * @param aTABLE
	 * @param aDelegation
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object wrapper( String aTABLE , 
			IdGenerator aDelegation , 
			IUpdcContext aContext ) throws SFException,Exception;
}
