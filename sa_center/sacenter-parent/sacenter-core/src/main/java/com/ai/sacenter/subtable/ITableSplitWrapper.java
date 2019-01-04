package com.ai.sacenter.subtable;

import com.ai.appframe2.complex.tab.split.function.IFunction;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �ֱ����ת����</p>
 * <p>Copyright: Copyright (c) 2014-12-5</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface ITableSplitWrapper extends IFunction {
	/**
	 * ���ݱ�������ֵת���ֱ���ֵ
	 * @param fromTable �ֱ����
	 * @param fromCol �ֱ�����
	 * @param fromObj �ֱ���ֵ
	 * @return
	 * @throws Exception
	 */
	public String wrapper(String fromTable,
			String fromCol,
			Object fromObj) throws Exception;
	/**
	 * ���ݱ�������ֵת���ֱ��з�ֵ
	 * @param fromTable �ֱ����
	 * @param fromCol �ֱ�����
	 * @param fromPARAM �ֱ�����Դ
	 * @return
	 * @throws Exception
	 */
	public Object magnetic(String fromTable,
			String fromCol,
			java.util.Map fromPARAM) throws Exception;
}
