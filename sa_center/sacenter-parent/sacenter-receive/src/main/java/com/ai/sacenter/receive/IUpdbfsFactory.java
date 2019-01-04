package com.ai.sacenter.receive;

import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.receive.teaminvoke.out.interfaces.IUpdcCSV;

public class IUpdbfsFactory {

	public IUpdbfsFactory() {
		super();
	}
	/**
     * ��ͨ��������[�ڲ�����]
     * @return
     * @throws Exception
     */
	public static IUpdcCSV getIUpdcSV() throws Exception{
		return (IUpdcCSV)UpfsvcFactory.getService(IUpdcCSV.class);
	}
}
