package com.ai.sacenter.jdbc;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.SFException;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 数据类型访问接口</p>
 * <p>Copyright: Copyright (c) 2014-10-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IHQSQLDialect {
	/**
	 * 获取当前系统日期
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
	 * 按照数据仓库类型分组存放到对应缓存区中[转换为目标表(不带分表标识)]
	 * @param fromObject 数据仓库对象
	 * @param fromMBean 激活本地事务
	 * @throws SFException
	 * @throws Exception
	 */
	public void transfer( Object fromObject, NoSQLDelegate fromMBean) throws SFException,Exception;
	/**
	 * 提交当前数据仓库到数据库
	 * @param fromMBean 激活本地事务
	 * @param fromDelegate 数据仓库
	 * @throws SFException
	 * @throws Exception
	 */
	public void commit(NoSQLDelegate fromMBean, HQSQLDelegate fromDelegate) throws SFException,Exception;
}
