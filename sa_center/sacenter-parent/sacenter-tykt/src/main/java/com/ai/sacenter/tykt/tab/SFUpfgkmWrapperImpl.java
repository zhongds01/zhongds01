package com.ai.sacenter.tykt.tab;

import com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl;
import com.ai.sacenter.subtable.impl.SFSubTableWrapImpl;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.ISubTableTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012-6-10</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpfgkmWrapperImpl extends SFSubTableWrapImpl {
	private static final long serialVersionUID = -5761264457651610005L;
	public SFUpfgkmWrapperImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2012-6-10</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IBufferTabWrapImpl extends SFTableSplitWrapImpl{
		private static final long serialVersionUID = 5831135854177227015L;
		public IBufferTabWrapImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.ucmframe.subtable.impl.ITableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, 
				String fromCol, 
				Object fromObj) throws Exception {
			String fromBUFF = "";
			try
			{
				ISubTableTemplate.ISubSQLTableCau fromCAU = null;
				fromCAU = UpfwmUtils.ISystem.getSubTableCau(fromTable, 
						fromCol, 
						(String)fromObj);
				if( fromCAU != null ) fromBUFF = fromCAU.getSUFFIX_A();
			}
			finally{
				
			}
			return fromBUFF;
		}
	}
}
