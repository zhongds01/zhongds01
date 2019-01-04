package com.ai.sacenter.receive.exigence.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.IUpdcpmCapital;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.service.interfaces.IUpdcpmSRV;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFOrderBase;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.teaminvoke.UpdcFactory;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpdcpmGroup;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年6月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdcpmSRVImpl extends UpdcEclipseImpl implements IUpdcpmSRV {
	public UpdcpmSRVImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdcpmSRV#finishSFUpfgkmDefault(com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmDefault(IOVMocketRespone fromRocket, 
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IOVMocketRespone.IRocketRsRspHome fromRsRspHome = null;
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			IOVMocketRespone.IRocketOfferHome fromOrderHome = fromRocket.getORDER();
			for( java.util.Iterator<IOVMocketRespone.IRocketRsRspHome> itera = fromOrderHome.getORDER().iterator(); itera.hasNext(); ){
				fromRsRspHome = (IOVMocketRespone.IRocketRsRspHome)itera.next(); 
				IOVOrderResponse fromRequest = ExigenceUtils.IRsRsp._wrap(fromRocket, 
						fromRsRspHome, 
						fromUpdcpm, 
						aContext);
				UpdcFactory.getIUpdcSV().applySFCentrex(fromRequest, 
						fromUpdcpm, 
						fromXML);
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdcpmSRV#finishSFUpfgkmComplete(com.ai.sacenter.receive.exigence.valuebean.IOVMocketRespone, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmComplete(IOVMocketRespone fromRocket, 
			IUpdcContext aContext) throws SFException, Exception {
		IUpfgkmOfferHome fromUpdcpm = null;
		try
		{
			IOVMsgFOrderBase fromOrder = fromRocket.getORDER().getROCKET();
			fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFComplete( fromOrder );
			if( fromUpdcpm == null /*按开通定单默认归档*/){
				finishSFUpfgkmDefault(fromRocket, 
						fromUpdcpm, 
						aContext);
			}
			else/*按照指定开通归档配置调度*/{
				ISystemTemplate.IImplCapital fromCapital = SystemUtils.ISystem.getSFUpfgkmLibrary( fromUpdcpm );
				IBusinesCapital fromUpdcpmImpl = IOrderFactory.getIUpdcpmSV( fromCapital.getIMPLCLASS() );
				ReflectUtils.IReflect.invokeMethod(fromUpdcpmImpl, 
						fromCapital.getMETHOD(), 
						new Object[]{fromRocket,
					                 fromUpdcpm,
					                 aContext},
						new Class[]{IOVMocketRespone.class,
					                IUpfgkmOfferHome.class, 
					                IUpdcContext.class});
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdcpmSRV#getSFUpfgkmComplete(com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFUpfgkmComplete(IOVMocketExigence fromRocket, SFException aEXCEPTION, IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			class SFUpfgkmNotifyImpl{
				public SFUpfgkmNotifyImpl(){
					super();
				}
			}
			SFUpfgkmNotifyImpl fromUpfgkmImpl = new SFUpfgkmNotifyImpl();
			IUpdcpmGroup fromGroup = null;
			try
			{
				fromUpdcpm = ExigenceUtils.ISystem.getROCKET( fromRocket, aEXCEPTION, aContext );
				IProgramTemplate.IUpdpgmOffer fromUpdpgm = ExigenceUtils.ISystem.getPROGRAM( fromRocket );
				if( fromUpdpgm != null && fromUpdpgm.getROCKET() != null ){
					fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog(fromUpdpgm.getROCKET().getCOMPONENT(), 
							fromUpdcpm.getSUBFLOW(), 
							aContext);
					if( fromGroup != null ){ fromUpdcpm.getPROGRAM().setCOMPONENT( fromGroup.getPROGRAM().getPROJECT() ); }
					fromUpdcpm.getPROGRAM().setPROGRAM( fromUpdpgm );
				}
				else if( fromUpdpgm != null && fromUpdpgm.getCOMPLETE() != null ){
					IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
					fromUpdcmpt = UpdcpmUtils.getCOMPONENT( fromUpdpgm.getCOMPLETE().getCOMPONENT() );
					fromUpdcpm.getPROGRAM().setCOMPONENT( fromUpdcmpt );
					fromUpdcpm.getPROGRAM().setPROGRAM  ( fromUpdpgm  );
				}
			}
			finally{
				if( fromGroup != null ){ fromGroup = null; }
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
		
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.exigence.service.interfaces.IUpdcpmSRV#finishSFUpfgkmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgkmComplete(MBeanDelegate fromMBean, 
			IOVMocketExigence fromRocket, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpfgkmNotifyImpl{
				public SFUpfgkmNotifyImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromMBean
				 * @param fromRocket
				 * @param fromUpdcpm
				 * @param aEXCEPTION
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpfgkmRocket( MBeanDelegate fromMBean, 
						IOVMocketExigence fromRocket, 
						IOVUpdcpmOffer fromUpdcpm,
						SFException aEXCEPTION,
						IUpdcContext aContext) throws SFException, Exception{
					IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRocket );
					try
					{
						ISystemTemplate.IImplCapital fromNature = fromUpdcpm.getPROGRAM().getIMPLCLASS();
						IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( fromNature.getIMPLCLASS() );
						ReflectUtils.IReflect.invokeMethod( fromUpdcpmImpl, 
								fromNature.getMETHOD(), 
								new Object[]{fromMBean,
										fromRocket,
										fromUpdcpm,
										aEXCEPTION,
										aContext},
							    new Class[]{MBeanDelegate.class,
							    		IOVMocketExigence.class,
							    		IOVUpdcpmOffer.class,
							    		SFException.class,
							    		IUpdcContext.class});
					}
					finally{
						if( fromUpdfmx != null ){ fromUpdfmx = null; }
					}
				}
			}
			SFUpfgkmNotifyImpl fromUpfgkmImpl = new SFUpfgkmNotifyImpl();
			try
			{
				IOVUpdcpmOffer fromUpdcpm = getSFUpfgkmComplete(fromRocket, aEXCEPTION, aContext);
				IProgramTemplate.IUpdpgmOffer fromUpdpgm = fromUpdcpm.getPROGRAM().getPROGRAM();
				if( fromUpdpgm == null/*默认归档组件[开通异常失败组件]*/ ){
					IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmException(fromMBean, 
							fromRocket, 
							fromUpdcpm, 
							aEXCEPTION, 
							aContext);
				}
				else if( fromUpdpgm.getROCKET() == null/*开通报竣通知组件[开通异常失败组件]*/){
					IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmException(fromMBean, 
							fromRocket, 
							fromUpdcpm, 
							aEXCEPTION, 
							aContext);
				}
				else/*指定异常归档组件[开通异常资产组件]*/{
					fromUpfgkmImpl.finishSFUpfgkmRocket(fromMBean, 
							fromRocket, 
							fromUpdcpm, 
							aEXCEPTION, 
							aContext);
				}
			}
			finally{
				if( fromUpfgkmImpl != null ){ fromUpfgkmImpl = null; }
			}
		}
		finally{
			
		}
	}

}
