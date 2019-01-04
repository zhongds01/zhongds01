package com.ai.sacenter.base.platform.service.impl;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê10ÔÂ6ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class CfgUpffmSVImpl implements ICfgUpffmSV {
	private final static Log log = LogFactory.getLog( CfgUpffmSVImpl.class );
	public CfgUpffmSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmOffer()
	 */
	public java.util.ArrayList getIUpffmOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmOffer();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmNetWork()
	 */
	public java.util.ArrayList getIUpffmNetWork() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmNetWork();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpfmxCatalog()
	 */
	public java.util.ArrayList getIUpfmxCatalog() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpfmxCatalog();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmOperate()
	 */
	public java.util.ArrayList getIUpffmOperate() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmOperate();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmOperateX()
	 */
	public java.util.ArrayList getIUpffmOperateX() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmOperateX();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmLogical()
	 */
	public java.util.ArrayList getIUpffmLogical() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmLogical();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmSubFlow()
	 */
	public java.util.ArrayList getIUpffmSubFlow() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmSubFlow();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmProtocol()
	 */
	public java.util.ArrayList getIUpffmProtocol() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmProtocol();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmOffice()
	 */
	public java.util.ArrayList getIUpffmOffice() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmOffice();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmPhone()
	 */
	public java.util.ArrayList getIUpffmPhone() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmPhone();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmDebug()
	 */
	public java.util.ArrayList getIUpffmDebug() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmDebug();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffsmOffer()
	 */
	public java.util.HashMap getIUpffsmOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffsmOffer();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#deployUpffsmOffer(java.util.HashMap)
	 */
	public void deployUpffsmOffer(java.util.HashMap fromUpffsm) throws RemoteException, Exception {
		try 
		{
			for( java.util.Iterator itera = fromUpffsm.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				java.util.ArrayList fromMODULE = new java.util.ArrayList();
				java.util.ArrayList fromCATALOG = new java.util.ArrayList();
				try
				{
					IPlatformTemplate.IUpffsmOffer aMappingsDefine = null;
					String aMODULE = fromEntry.getKey().toString();
					try
					{
						for( java.util.Iterator iterap = ((java.util.List)fromEntry.getValue()).iterator(); iterap.hasNext(); ){
							aMappingsDefine = (IPlatformTemplate.IUpffsmOffer)iterap.next();
							aMappingsDefine.baleUcm2Jdbm( fromMODULE, fromCATALOG );
						}
						BasicFactory.getIUpffmDAO().deployUpffsmOffer(aMODULE, 
								fromMODULE, 
								fromCATALOG);
					}
					catch( java.lang.Exception aEXCEPTION ){
						if( log.isErrorEnabled() ) log.error( aMODULE, aEXCEPTION );
						throw aEXCEPTION;
					}
					
				}
				finally{
					if (fromCATALOG != null) {fromCATALOG.clear();fromCATALOG = null;}
					if (fromMODULE != null) {fromMODULE.clear();fromMODULE = null;}
				}
			}
		} 
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmMisc()
	 */
	public java.util.ArrayList getIUpffmMisc() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmMisc();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffxmOffer()
	 */
	public java.util.ArrayList getIUpffxmOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffxmOffer();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmsOffer()
	 */
	public java.util.ArrayList getIUpffmsOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmsOffer();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.base.platform.service.interfaces.ICfgUpffmSV#getIUpffmsCatalog()
	 */
	public java.util.ArrayList getIUpffmsCatalog() throws RemoteException, Exception {
		return BasicFactory.getIUpffmDAO().getIUpffmsCatalog();
	}

}
