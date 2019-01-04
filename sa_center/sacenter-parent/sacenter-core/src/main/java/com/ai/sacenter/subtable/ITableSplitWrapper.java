package com.ai.sacenter.subtable;

import com.ai.appframe2.complex.tab.split.function.IFunction;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 分表规则转换器</p>
 * <p>Copyright: Copyright (c) 2014-12-5</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface ITableSplitWrapper extends IFunction {
	/**
	 * 根据表名和列值转换分表列值
	 * @param fromTable 分表表名
	 * @param fromCol 分表列名
	 * @param fromObj 分表列值
	 * @return
	 * @throws Exception
	 */
	public String wrapper(String fromTable,
			String fromCol,
			Object fromObj) throws Exception;
	/**
	 * 根据表名和列值转换分表列阀值
	 * @param fromTable 分表表名
	 * @param fromCol 分表列名
	 * @param fromPARAM 分表数据源
	 * @return
	 * @throws Exception
	 */
	public Object magnetic(String fromTable,
			String fromCol,
			java.util.Map fromPARAM) throws Exception;
}
