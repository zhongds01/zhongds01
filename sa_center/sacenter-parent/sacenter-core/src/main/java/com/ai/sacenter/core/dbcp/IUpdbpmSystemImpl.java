package com.ai.sacenter.core.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.core.IUpdbpmCapital;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbpmOffer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Library: IUpdbpmDefaultImpl</p>
 * <p>Description: 默认工单拆分规范[开通工单拆分]</p>
 * <p>Copyright: Copyright (c) 2015-5-6</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class IUpdbpmSystemImpl extends UpdcEclipseImpl implements IUpdbpmCapital {
	public IUpdbpmSystemImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.IUpdbpmSystem#finishSFUpdbpm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
	 */
	public IOVTaskPentium[] finishSFUpdbpm(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer, 
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm, 
			IUpdcContext aContext)throws SFException, Exception {
		IOVTaskPentium fromTASK[] = null;
		try 
		{
			fromTASK = IUpdcFactory.getIUpdbpmSV().finishSFUpdbmDefault(fromOrder, 
					fromOffer,
					fromUpdbm, 
					fromUpdcpm, 
					aContext);
		} 
		finally {

		}
		return fromTASK;
	}
    
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Library: IUpdbpmOfficeImpl</p>
	 * <p>Description: 逻辑局向拆分规范[开通工单拆分]</p>
	 * <p>Copyright: Copyright (c) 2015-5-6</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbpmOfficeImpl extends IUpdbpmSystemImpl{
		public IUpdbpmOfficeImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.core.dbcp.IUpdbpmSystemImpl#finishSFUpdbpm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
		 */
		public IOVTaskPentium[] finishSFUpdbpm(IOVOrderPentium fromOrder,
				IOVOfferPentium fromOffer, 
				ISystemTemplate.IUpdbpmOffer fromUpdbm,
				IOVUpdbpmOffer fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception {
			IOVTaskPentium fromTASK[] = null;
			try
			{
				fromTASK = IUpdcFactory.getIUpdbpmSV().finishSFUpdbmOffice(fromOrder,
						fromOffer,
						fromUpdbm, 
						fromUpdcpm,
						aContext);
			}
			finally{
				
			}
			return fromTASK;
		}
		
	}

	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Library: IUpdbpmSubFlowImpl</p>
	 * <p>Description: 二级工单拆分规范[开通工单拆分]</p>
	 * <p>Copyright: Copyright (c) 2015-5-6</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbpmSubFlowImpl extends IUpdbpmSystemImpl{
		public IUpdbpmSubFlowImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.core.dbcp.IUpdbpmSystemImpl#finishSFUpdbpm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVOfferPentium, com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer, com.ai.sacenter.core.valuebean.IOVUpdbpmOffer, com.ai.sacenter.IUpdcContext)
		 */
		public IOVTaskPentium[] finishSFUpdbpm(IOVOrderPentium fromOrder,
				IOVOfferPentium fromOffer, 
				ISystemTemplate.IUpdbpmOffer fromUpdbm,
				IOVUpdbpmOffer fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception {
			IOVTaskPentium fromTASK[] = null;
			try
			{
				if( StringUtils.isBlank( fromUpdbm.getJEVAL() ) ){ 
					ExceptionFactory.throwIllegal("IOS0011060", new String[]{fromUpdbm.getID(),"JEVAL"});
				}
				fromTASK = IUpdcFactory.getIUpdbpmSV().finishSFUpdbmSubFlow(fromOrder,
						fromOffer,
						fromUpdbm, 
						fromUpdcpm,
						aContext);
			}
			finally{
				
			}
			return fromTASK;
		}
		
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-5-6</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ISystemSpliteImpl extends IUpdbpmSystemImpl{
		public ISystemSpliteImpl(){
			super();
		}

	}
}
