package com.ai.sacenter.suggest.dbcp;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.dbcp.IUpdcpmCapitalImpl;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.suggest.valuebean.IOVUpfgxmPentium;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务阶段异步归档</p>
 * <p>Copyright: Copyright (c) 2014-12-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgxmSystemImpl extends IUpdcpmCapitalImpl {
	private final static Log log = LogFactory.getLog( IUpfgxmSystemImpl.class );
	public IUpfgxmSystemImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年11月23日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgxmSuggestImpl extends IUpfgxmSystemImpl{
		public IUpfgxmSuggestImpl(){
			super();
		}
		/**
		 * 默认阶段组件[服务阶段通知组件]
		 * IUpdfgtmDefaultImpl
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromSuggest
		 * @param fromUpdcpm
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfgxmDefault(IOVOrderPentium fromOrder,
				IOVTaskPentium[] fromTASK, 
				IOVUpfgxmPentium fromSuggest,
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				for( int index = 0; fromTASK != null && index < fromTASK.length; index++ ){
					if( log.isDebugEnabled() ) log.debug( fromOrder.getORDER_ID() + "\t" + fromTASK[index].getTASK_ID() + "\t" + 
				         fromUpdcpmHome.getCOMPONENT().getID() + "\t" + fromUpdcpmHome.getCOMPONENT().getNAME() );
				}
			}
			finally{
				
			}
		}
		/**
		 * 默认阶段组件[服务阶段通知组件]
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromSuggest
		 * @param fromUpdcpm
		 * @param aEXCEPTION
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfgxmDefault(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpfgxmPentium fromSuggest,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				if( log.isDebugEnabled() ) log.debug( fromTASK.getTASK_ID() + "\t" + fromUpdcpmHome.getCOMPONENT().getID() + "\t" + 
				    fromUpdcpmHome.getCOMPONENT().getNAME() );
			}
			finally{
				
			}
		}
		/**
		 * 默认阶段组件[服务阶段通知组件]
		 * IUpdfgtmDefaultImpl
		 * @param fromMBean
		 * @param fromUpfgkmHome
		 * @param fromUpdcpm
		 * @param aContext
		 * @throws RemoteException
		 * @throws Exception
		 */
		public void finishSFUpfgxmDefault(MBeanDelegate fromMBean,
				IOVUpfgxmPentium fromUpfgkmHome,
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext) throws RemoteException, Exception{
			try
			{
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				if( log.isDebugEnabled() ) log.debug( fromUpfgkmHome.getMQMSG_ID() + "\t" + fromUpfgkmHome.getPLQK_ID() + "\t" + 
				    fromUpdcpmHome.getCOMPONENT().getID() + "\t" + fromUpdcpmHome.getCOMPONENT().getNAME() );
			}
			finally{
				
			}
		}
	}
}
