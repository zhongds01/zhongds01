package com.ai.sacenter.cboss.tab;

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
public class SFUpfgsmWrapperImpl extends SFSubTableWrapImpl {
	private static final long serialVersionUID = -250972718254192279L;
	public SFUpfgsmWrapperImpl() {
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
		private static final long serialVersionUID = -2772431462709570426L;
		public IBufferTabWrapImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.ucmframe.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
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
