package com.ai.sacenter.subtable.impl;

import com.ai.appframe2.complex.tab.id.IIdGeneratorWrapper;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务定单分表机制</p>
 * <p>Copyright: Copyright (c) 2014-8-25</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SFUpdbmWrapImpl extends SFSubTableWrapImpl {
	private static final long serialVersionUID = -5452756386706653002L;
	public SFUpdbmWrapImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-3-17</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class OrderIdWrapperImpl extends SFUpdbmWrapImpl implements IIdGeneratorWrapper{
		private static final long serialVersionUID = -4519791385495018582L;
		public OrderIdWrapperImpl(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.appframe2.complex.tab.id.IIdGeneratorWrapper#wrapper(long)
		 */
		public long wrapper(long orderId) {
			long fromOrder = 0;
			try 
			{
				ISystemTemplate.ICenterRoute fromRoute = SFCenterFactory.getCenterInfo().getSUBFLOW().getRoute();
				java.sql.Timestamp fromCREATE = new java.sql.Timestamp( System.currentTimeMillis() );
				String fromMMDD = TimeUtils.format( fromCREATE, "MMdd" );
				fromOrder = fromRoute.getNUMBER() * 1000000000000l + Long.parseLong( fromMMDD ) * 100000000l + orderId;
			} 
			finally {

			}
			return fromOrder;
		}
	}
}
