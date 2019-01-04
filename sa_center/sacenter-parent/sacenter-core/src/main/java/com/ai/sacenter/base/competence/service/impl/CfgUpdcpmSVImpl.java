package com.ai.sacenter.base.competence.service.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV;

/**
 * <p>Title: sacenter</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê9ÔÂ30ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class CfgUpdcpmSVImpl implements ICfgUpdcpmSV {
	public CfgUpdcpmSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdbfxBusines()
	 */
	public java.util.ArrayList getIUpdbfxBusines() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdbfxBusines();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdbfxKernel()
	 */
	public java.util.ArrayList getIUpdbfxKernel() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdbfxKernel();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdbfxCatalog()
	 */
	public java.util.ArrayList getIUpdbfxCatalog() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdbfxCatalog();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdcpmOffer()
	 */
	public java.util.ArrayList getIUpdcpmOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdcpmOffer();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdcpmCatalog()
	 */
	public java.util.ArrayList getIUpdcpmCatalog() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdcpmCatalog();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIProductOffer()
	 */
	public java.util.ArrayList getIProductOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIProductOffer();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIProductComptel()
	 */
	public java.util.ArrayList getIProductComptel() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIProductComptel();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIProductCatalog()
	 */
	public java.util.ArrayList getIProductCatalog() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIProductCatalog();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIComptelOffer()
	 */
	public java.util.ArrayList getIComptelOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIComptelOffer();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIComptelCatalog()
	 */
	public java.util.ArrayList getIComptelCatalog() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIComptelCatalog();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIComptelKernel()
	 */
	public java.util.ArrayList getIComptelKernel() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIComptelKernel();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdbpmOffer()
	 */
	public java.util.ArrayList getIUpdbpmOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdbpmOffer();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdbmSubFlow()
	 */
	public java.util.ArrayList getIUpdbpmCatalog() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdbpmCatalog();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdpgmOffer()
	 */
	public java.util.ArrayList getIUpdpgmOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdpgmOffer();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdpgmCatalog()
	 */
	public java.util.ArrayList getIUpdpgmCatalog() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdpgmCatalog();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdcmptOffer()
	 */
	public java.util.ArrayList getIUpdcmptOffer() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdcmptOffer();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdcmptCatalog()
	 */
	public java.util.ArrayList getIUpdcmptCatalog() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdcmptCatalog();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdcmptMapping()
	 */
	public java.util.ArrayList getIUpdcmptMapping() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdcmptMapping();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdcmptRollBack()
	 */
	public java.util.ArrayList getIUpdcmptRollBack() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdcmptRollBack();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdcmptCompensation()
	 */
	public java.util.ArrayList getIUpdcmptCompensation() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdcmptCompensation();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdcmptDistribute()
	 */
	public java.util.ArrayList getIUpdcmptDistribute() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdcmptDistribute();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.base.competence.service.interfaces.ICfgUpdcpmSV#getIUpdcmptCausation()
	 */
	public java.util.ArrayList getIUpdcmptCausation() throws RemoteException, Exception {
		return BasicFactory.getIUpdcpmDAO().getIUpdcmptCausation();
	}
}
