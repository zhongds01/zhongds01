package com.ai.sacenter.subtable.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.ISubTableTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 调度队列分表机制</p>
 * <p>Copyright: Copyright (c) 2013-7-25</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFQueueWrapimpl extends SFSubTableWrapImpl {
	private static final long serialVersionUID = -6042444071060140999L;
	public SFQueueWrapimpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 队列网元分表机制</p>
	 * <p>Copyright: Copyright (c) 2013-7-25</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmWrappImpl extends ITableSplitWrapImpl{
		public IUpfwmWrappImpl(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.ITableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, String fromCol, Object fromObj) throws Exception {
			ISubTableTemplate.ISubSQLTableCau fromCAU = null;
			try
			{
				fromCAU = IUpdcfgFactory.getIBasicSV().getSFSubTableCau(IUpdcConst.IUpfwm.IUpfm.ucmframe, 
						fromTable, 
						fromCol, 
						(String)fromObj );
			}
			finally{
				
			}
			return fromCAU != null && StringUtils.isBlank( fromCAU.getSUFFIX_A() ) == false ?fromCAU.getSUFFIX_A():"";
		}
	}
}
