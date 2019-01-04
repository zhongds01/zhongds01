package com.ai.sacenter.jdbc.interfaces;

import com.ai.sacenter.SFException;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: ���ݴ洢����</p>
 * <p>Copyright: Copyright (c) 2013-5-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IDataStoreSRV {
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.sql.Timestamp getSysdate() throws SFException,Exception;
	
	/***
	 * ����DAO��������Ԫ·�ɹ��򱣴����ݼ�¼
	 * @param fromDAO ���񼤻�DAO��
	 * @param fromUpdbm
	 * @throws SFException
	 * @throws Exception
	 */
	public void finish( String fromDAO, java.util.List fromUpdbm ) throws SFException,Exception;
}
