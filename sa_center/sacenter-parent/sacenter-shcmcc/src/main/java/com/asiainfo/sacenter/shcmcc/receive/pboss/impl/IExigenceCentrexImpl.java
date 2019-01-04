package com.asiainfo.sacenter.shcmcc.receive.pboss.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.dbcp.impl.IExigenceSubFlowImpl;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.receive.valuebean.IOVUpffmxConsult;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.target.dbcp.IUpdbsSystemImpl;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.teaminvoke.UpdcFactory;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.asiainfo.sacenter.shcmcc.receive.ISHOrderFactory;
import com.asiainfo.sacenter.shcmcc.receive.dbcp.impl.IBusinessCapitalImpl;
import com.asiainfo.sacenter.shcmcc.receive.dbcp.impl.IExigenceSystemImpl;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: 固网长流程反馈[pboss]</p>
 * <p>Copyright: Copyright (c) 2017年6月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IExigenceCentrexImpl extends IExigenceSystemImpl {
	public IExigenceCentrexImpl(){
		super();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-shcmcc</p>
	 * <p>Description: 基于固网请求组件</p>
	 * <p>Copyright: Copyright (c) 2018年1月31日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class ICentrexCapitalImpl extends IBusinessCapitalImpl{
		public ICentrexCapitalImpl(){
			super();
		}
		
		/**
		 * 服务服务固网定单[固网定单转发]
		 * IUpdbfsMsgFCentrexImpl
		 * @param fromCentrex 开通定单
		 * @param fromUpdcpm 开通能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVOrderResponse finishIMsgFCentrexImpl(IOVMsgFExigence fromCentrex,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVOrderResponse fromASK = null;
			IOVUpffmxRequest fromUpffmx = null;
			try
			{
				IOVMocketExigence __rocket__ = fromCentrex.getORDER().getMOCKET();
				String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
				fromUpffmx = ISHOrderFactory.getIOrderSV().getSFMsgFCentrex(fromCentrex, 
						fromUpdcpm, 
						aContext);
				//调用PBOSS服务透传固网报文
				if( __rocket__ == null || __rocket__.isNETWORK() ){
					ReflectUtils.IReflect.invokeCallCsf( fromCentrex,
							"adapter_IAdapter4KtCSV_orderReceive",
							new Object[]{ fromCentrex.getAsXml() }, 
							fromUpdcpm.getCATALOG().getPLATFORM() );
				}
				if( fromUpffmx.getCENTREX() != null && fromUpffmx.getCENTREX().getORDER().size() > 0 ){
					for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getCENTREX().getORDER().iterator(); itera.hasNext(); ){
						IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
						fromASK = UpdcFactory.getIUpdcSV().applySFCentrex(fromOrdUserHome.getPLATFORM(), 
								fromOrdUserHome.getCOMPETENCE(), 
								fromXML);
					}
				}
			}
			finally{
				if( fromUpffmx != null ){ fromUpffmx = null; }
			}
			return fromASK;
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-shcmcc</p>
	 * <p>Description: 基于固网归档组件</p>
	 * <p>Copyright: Copyright (c) 2017年6月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IExigenceNotifyImpl extends IUpdbsSystemImpl{
		public IExigenceNotifyImpl(){
			super();
		}
				
		/**
		 * 
		 * <p>Library: IUpdbfmxCentrexImpl</p>
		 * <p>Description: 完成开通定单通知PBOSS</p>
		 * @param fromMBean 服务事务
		 * @param fromOrder 服务归档单
		 * @param fromUpdcpm 服务归档组件
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpdbfmxCentrex(MBeanDelegate fromMBean,
				IOVUpdbsComplete fromOrder,
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			IOVMocketRespone fromASK = null;
			try
			{
				fromASK = ExigenceUtils.IRsRsp._wrap(fromOrder, fromUpdcpm, aContext);
				String fromRsRsp = ExigenceUtils.IRocket._jj_response( fromASK );
				if( log.isDebugEnabled() ) log.debug("CENTREX->PBOSS:" + fromRsRsp );
				//调用PBOSS服务通知网元施工报竣工
				ReflectUtils.IReflect.invokeCallCsf( fromOrder,
						"adapter_IAdapter4KtCSV_orderComplete",
						new Object[]{ fromRsRsp }, 
						fromUpdcpm.getPROGRAM().getPLATFORM() );
			}
			finally{
				if( fromASK != null ){ fromASK = null; }
			}
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-shcmcc</p>
	 * <p>Description: 基于PBOSS测报竣归档</p>
	 * <p>Copyright: Copyright (c) 2017年6月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICentrexNotifyImpl extends IExigenceSubFlowImpl{
		public ICentrexNotifyImpl(){
			super();
		}
		
		/**
		 * 
		 * <p>Library: IUpdbfoMsgFCentrexImpl</p>
		 * <p>Description: 固网开通定单报竣通知归档[固网开通归档]</p>
		 * @param fromRocket 服务归档
		 * @param fromUpdcpm 服务能力
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFMsgFDefaultImpl( IOVMocketRespone fromRocket,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				String fromXML = ExigenceUtils.IRocket._jj_network( fromRocket );
				if( log.isDebugEnabled() ) log.debug( "CENTREX:" + fromXML );
				IExigenceFactory.getIUpdcpmSV().finishSFUpfgkmDefault(fromRocket, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				
			}
		}
	}
}
