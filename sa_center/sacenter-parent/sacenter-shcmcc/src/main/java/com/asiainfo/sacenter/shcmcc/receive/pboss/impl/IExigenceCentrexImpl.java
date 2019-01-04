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
 * <p>Description: ���������̷���[pboss]</p>
 * <p>Copyright: Copyright (c) 2017��6��15��</p>
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
	 * <p>Description: ���ڹ����������</p>
	 * <p>Copyright: Copyright (c) 2018��1��31��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class ICentrexCapitalImpl extends IBusinessCapitalImpl{
		public ICentrexCapitalImpl(){
			super();
		}
		
		/**
		 * ��������������[��������ת��]
		 * IUpdbfsMsgFCentrexImpl
		 * @param fromCentrex ��ͨ����
		 * @param fromUpdcpm ��ͨ����
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
				//����PBOSS����͸����������
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
	 * <p>Description: ���ڹ����鵵���</p>
	 * <p>Copyright: Copyright (c) 2017��6��20��</p>
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
		 * <p>Description: ��ɿ�ͨ����֪ͨPBOSS</p>
		 * @param fromMBean ��������
		 * @param fromOrder ����鵵��
		 * @param fromUpdcpm ����鵵���
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
				//����PBOSS����֪ͨ��Ԫʩ��������
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
	 * <p>Description: ����PBOSS�ⱨ���鵵</p>
	 * <p>Copyright: Copyright (c) 2017��6��20��</p>
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
		 * <p>Description: ������ͨ��������֪ͨ�鵵[������ͨ�鵵]</p>
		 * @param fromRocket ����鵵
		 * @param fromUpdcpm ��������
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
