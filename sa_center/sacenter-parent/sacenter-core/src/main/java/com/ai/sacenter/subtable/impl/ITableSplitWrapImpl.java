package com.ai.sacenter.subtable.impl;


import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.subtable.ITableSplitWrapper;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 分表规则转换抽象类</p>
 * <p>Copyright: Copyright (c) 2014-12-5</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ITableSplitWrapImpl extends UpdcEclipseImpl implements ITableSplitWrapper {

	public ITableSplitWrapImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.subtable.ITableSplitWrapper#wrapper(java.lang.String, java.lang.String, java.lang.Object)
	 */
	public String wrapper(String fromTable, String fromCol, Object fromObj)
			throws Exception {
		return fromObj != null?fromObj.toString():"";
	}

	/* (non-Javadoc)
	 * @see com.ai.appframe2.complex.tab.split.function.IFunction#convert(java.lang.Object)
	 */
	public String convert(Object fromObj) throws Exception {
		return wrapper( "*" , "*" , fromObj );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.subtable.ITableSplitWrapper#magnetic(java.lang.String, java.lang.String, java.util.Map)
	 */
	public Object magnetic(String fromTable, String fromCol, java.util.Map fromPARAM) throws Exception {
		return fromPARAM.get( fromCol );
	}
}
