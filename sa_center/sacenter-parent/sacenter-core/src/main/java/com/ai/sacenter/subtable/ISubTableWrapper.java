package com.ai.sacenter.subtable;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.jdbc.HQSQLEntityBean;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-4-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISubTableWrapper {
	/**
	 * 根据当前数据源记录转换为目标源记录
	 * @param fromBroke 当前表数据行记录
	 * @param fromSubSQL 目标表规范
	 * @param aContext
	 * @return 返回数据[KEY=目标表[带分表标志],VALUE=数据记录列表(java.util.ArrayList)[远端数据表记录]]
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap transform( HQSQLEntityBean fromBroke,
			ISubSQLOffer fromSubSQL,
			IUpdcContext aContext ) throws SFException,Exception;
}
