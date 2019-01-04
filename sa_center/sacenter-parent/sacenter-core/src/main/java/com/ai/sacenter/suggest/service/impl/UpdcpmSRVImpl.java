package com.ai.sacenter.suggest.service.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.IUpdcpmCapital;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.suggest.service.interfaces.IUpdcpmSRV;
import com.ai.sacenter.suggest.valuebean.IOVUpfgxmPentium;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.UpfgxmUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê11ÔÂ9ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcpmSRVImpl extends UpdcEclipseImpl implements IUpdcpmSRV {
	public UpdcpmSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.service.interfaces.IUpdbsgtSRV#getSFTaskComplete(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium[], com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFTaskComplete(IOVOrderPentium fromOrder,
			IOVTaskPentium[] fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			IOVTaskPentium.ITaskOfferHome fromTaskHome = null;
			for( int index = 0; fromTASK != null && index < fromTASK.length; index++ ){
				fromTaskHome = fromTASK[index].getORDER();
				if( fromTaskHome.getSUGGEST() != null ){
					fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromOrder, fromTaskHome.getSUGGEST() );
					IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
					fromUpdcpmHome.setPROGRAM( UpdcpmUtils.getPROGRAM( fromTaskHome.getSUBFLOW().getPROGRAM() ) );
				}
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.service.interfaces.IUpdbsgtSRV#finishSFTaskComplete(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium[], com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfgxmPentium finishSFTaskComplete(IOVOrderPentium fromOrder,
			IOVTaskPentium[] fromTASK, 
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfgxmPentium fromSuggest = null;
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFTaskComplete(fromOrder, fromTASK, aContext);
			if( fromUpdcpm != null ){
				try
				{
					fromSuggest = UpfgxmUtils.ICustom._wrap( fromOrder, fromUpdcpm, aContext);
					IOVUpdcpmOffer.IUpdcpmHome fromPROGRAM = fromUpdcpm.getPROGRAM();
					ISystemTemplate.IImplCapital fromJAVA = fromPROGRAM.getIMPLCLASS();
					IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( fromJAVA.getIMPLCLASS() );
					IOVTaskPentium fromPending[] = UpfgxmUtils.ISystem.getSFSuggestTask(fromOrder, 
							fromTASK, 
							null, 
							aContext);
					ReflectUtils.IReflect.invokeMethod( fromUpdcpmImpl, 
							fromJAVA.getMETHOD(), 
							new Object[]{fromOrder,
									fromPending,
									fromSuggest,
									fromUpdcpm,
									aContext},
						    new Class[]{IOVOrderPentium.class,
						    		IOVTaskPentium[].class,
						    		IOVUpfgxmPentium.class,
						    		IOVUpdcpmOffer.class,
						    		IUpdcContext.class});
				}
				finally{
					
				}
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
		return fromSuggest;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.service.interfaces.IUpdcpmSRV#finishSFTaskComplete(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.SFException, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpfgxmPentium finishSFTaskComplete(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception {
		IOVUpfgxmPentium fromSuggest = null;
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFTaskComplete(fromOrder, new IOVTaskPentium[]{fromTASK}, aContext);
			if( fromUpdcpm != null ){
				try
				{
					fromSuggest = UpfgxmUtils.ICustom._wrap(fromOrder, fromTASK, fromUpdcpm, aContext);
					ISystemTemplate.IImplCapital fromJAVA = fromUpdcpm.getPROGRAM().getIMPLCLASS();
					IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( fromJAVA.getIMPLCLASS() );
					ReflectUtils.IReflect.invokeMethod( fromUpdcpmImpl, 
							fromJAVA.getMETHOD(), 
							new Object[]{fromOrder,
									fromTASK,
									fromSuggest,
									fromUpdcpm,
									aEXCEPTION,
									aContext},
						    new Class[]{IOVOrderPentium.class,
						    		IOVTaskPentium.class,
						    		IOVUpfgxmPentium.class,
						    		IOVUpdcpmOffer.class,
						    		SFException.class,
						    		IUpdcContext.class});
				}
				finally{
					
				}
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
		return fromSuggest;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.service.interfaces.IUpdcpmSRV#getSFUpfgxmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.suggest.valuebean.IOVUpfgxmPentium, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpmOffer getSFUpfgxmComplete(MBeanDelegate fromMBean,
			IOVUpfgxmPentium fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
			fromUpdcmpt = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptSuggest( fromUpfgkmHome.getPROGRAM() );
			if( fromUpdcmpt != null ){
				fromUpdcpm = UpdcpmUtils.ICustom.wrap( fromUpfgkmHome, fromUpdcmpt );
				IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
				fromUpdcpmHome.setPROGRAM( UpdcpmUtils.getPROGRAM( fromUpfgkmHome.getPROGRAM() ) );
			}
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.suggest.service.interfaces.IUpdcpmSRV#finishSFUpfgxmComplete(com.ai.sacenter.common.MBeanDelegate, com.ai.sacenter.suggest.valuebean.IOVUpfgxmPentium, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUpfgxmComplete(MBeanDelegate fromMBean,
			IOVUpfgxmPentium fromUpfgkmHome, 
			IUpdcContext aContext) throws RemoteException, Exception {
		IOVUpdcpmOffer fromUpdcpm = null;
		try
		{
			fromUpdcpm = getSFUpfgxmComplete(fromMBean, fromUpfgkmHome, aContext);
			if( fromUpdcpm != null ){
				try
				{
					ISystemTemplate.IImplCapital fromJAVA = fromUpdcpm.getPROGRAM().getIMPLCLASS();
					IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( fromJAVA.getIMPLCLASS() );
					ReflectUtils.IReflect.invokeMethod( fromUpdcpmImpl, 
							fromJAVA.getMETHOD(), 
							new Object[]{fromMBean,
									fromUpfgkmHome,
									fromUpdcpm,
									aContext},
						    new Class[]{MBeanDelegate.class,
						    		IOVUpfgxmPentium.class,
						    		IOVUpdcpmOffer.class,
						    		IUpdcContext.class});
				}
				finally{
					
				}
			}
		}
		finally{
			if( fromUpdcpm != null ){ fromUpdcpm = null; }
		}
	}
}
