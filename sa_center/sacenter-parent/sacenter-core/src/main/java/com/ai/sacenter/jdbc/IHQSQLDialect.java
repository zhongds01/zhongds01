package com.ai.sacenter.jdbc;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.SFException;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �������ͷ��ʽӿ�</p>
 * <p>Copyright: Copyright (c) 2014-10-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IHQSQLDialect {
	/**
	 * ��ȡ��ǰϵͳ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.sql.Timestamp getSysdate() throws SFException,Exception;
	/**
	 * 
	 * @param _entity
	 * @throws SFException
	 */
	public void validate( DataStructInterface _entity ) throws SFException;
	/**
	 * 
	 * @param _composite
	 * @param _entity
	 * @throws SFException
	 */
	public void validate( Class<?> _composite, DataStructInterface _entity_ ) throws SFException;
	/**
	 * 
	 * @param _table
	 * @param _column_
	 * @param _objective
	 * @throws SFException
	 */
	public void validate( HQSQLTable _table, HQSQLTable.HQSQLColumn _column_, Object _objective ) throws SFException;
	
	/**
	 * �������ݲֿ����ͷ����ŵ���Ӧ��������[ת��ΪĿ���(�����ֱ��ʶ)]
	 * @param fromObject ���ݲֿ����
	 * @param fromMBean ���������
	 * @throws SFException
	 * @throws Exception
	 */
	public void transfer( Object fromObject, NoSQLDelegate fromMBean) throws SFException,Exception;
	/**
	 * �ύ��ǰ���ݲֿ⵽���ݿ�
	 * @param fromMBean ���������
	 * @param fromDelegate ���ݲֿ�
	 * @throws SFException
	 * @throws Exception
	 */
	public void commit(NoSQLDelegate fromMBean, HQSQLDelegate fromDelegate) throws SFException,Exception;
}
