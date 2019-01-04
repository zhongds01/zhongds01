package com.ai.sacenter.cache.interfaces;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 开通缓存机制服务</p>
 * <p>Copyright: Copyright (c) 2015年9月29日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IDialect {
	/**
	 * 根据缓缓区域获取对应所有缓存数据
	 * @param fromCLASS 缓存区域
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap hgetAll( Class fromCLASS ) throws SFException,Exception;
	/**
	 * 根据缓缓区域和键值获取对应缓缓数据
	 * @param fromCLASS 缓存区域
	 * @param fromKEY  缓存键值
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object hget( Class fromCLASS , String fromKEY ) throws SFException,Exception;
	/**
	 * 该键值是否存在
	 * @param fromCLASS 缓存区域
	 * @param fromKEY  缓存键值
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public boolean hexist( Class fromCLASS , String fromKEY ) throws SFException,Exception;
	/**
	 * 根据网元路由查询开通缓存集
	 * @param fromTYPE 开通实体
	 * @param fromCond 开通条件
	 * @param fromPARAM 开通参数
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.ArrayList hgetAll(ObjectType fromTYPE, 
			String fromCond, 
			java.util.Map fromPARAM) throws SFException, Exception;
	/**
	 * 指定集群刷新缓存
	 * @param _group 集群编码
	 * @throws SFException
	 * @throws Exception
	 */
	public void refreshGroup( String _group ) throws SFException, Exception;
}
