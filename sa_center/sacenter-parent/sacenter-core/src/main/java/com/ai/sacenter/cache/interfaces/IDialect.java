package com.ai.sacenter.cache.interfaces;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��ͨ������Ʒ���</p>
 * <p>Copyright: Copyright (c) 2015��9��29��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IDialect {
	/**
	 * ���ݻ��������ȡ��Ӧ���л�������
	 * @param fromCLASS ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap hgetAll( Class fromCLASS ) throws SFException,Exception;
	/**
	 * ���ݻ�������ͼ�ֵ��ȡ��Ӧ��������
	 * @param fromCLASS ��������
	 * @param fromKEY  �����ֵ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object hget( Class fromCLASS , String fromKEY ) throws SFException,Exception;
	/**
	 * �ü�ֵ�Ƿ����
	 * @param fromCLASS ��������
	 * @param fromKEY  �����ֵ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public boolean hexist( Class fromCLASS , String fromKEY ) throws SFException,Exception;
	/**
	 * ������Ԫ·�ɲ�ѯ��ͨ���漯
	 * @param fromTYPE ��ͨʵ��
	 * @param fromCond ��ͨ����
	 * @param fromPARAM ��ͨ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList hgetAll(ObjectType fromTYPE, 
			String fromCond, 
			java.util.Map fromPARAM) throws SFException, Exception;
	/**
	 * ָ����Ⱥˢ�»���
	 * @param _group ��Ⱥ����
	 * @throws SFException
	 * @throws Exception
	 */
	public void refreshGroup( String _group ) throws SFException, Exception;
}
