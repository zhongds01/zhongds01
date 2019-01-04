package com.ai.sacenter.core.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.service.interfaces.IUpdosSRV;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbmtcLife;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-5-21</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdosSRVImpl extends UpdcEclipseImpl implements IUpdosSRV {
	public UpdosSRVImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdosSRV#getSFUpdbmToken()
	 */
	public IOVUpdbmtcLife getSFUpdbmToken() throws SFException, Exception {
		IOVUpdbmtcLife fromUpdbmtc = null;
		try
		{
			java.util.Map fromUpdgma = UpfsvcManager.getMBean().getGraphics();
			if(( fromUpdbmtc = (IOVUpdbmtcLife)fromUpdgma.get( IUpdcConst.ISystem.CONTROL ) ) == null ){
				fromUpdbmtc = new IOVUpdbmtcLife();
				java.util.Map fromGraph = fromUpdbmtc.getTOKEN().getGraphics();
				if( fromGraph.containsKey( IUpdcConst.IEnum.MSDNLST ) == false ){
					ISystemTemplate.IStaticGroup fromStatic = null;
					fromStatic = IUpdcfgFactory.getIBasicSV().getSFStaticGroup( IUpdcConst.IEnum.MSDNLST );
					if( fromStatic != null ){ fromUpdbmtc.setACCOUNT( fromStatic.getLITTLE() ); }
					fromGraph.put( IUpdcConst.IEnum.MSDNLST , Boolean.TRUE );
				}
				fromUpdgma.put( IUpdcConst.ISystem.CONTROL , fromUpdbmtc );
			}
		}
		finally{
			
		}
		return fromUpdbmtc;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.service.interfaces.IUpdosSRV#getSFUpdbmClaim(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.valuebean.IOVUpdpgmOffer, com.ai.sacenter.SFException, com.ai.sacenter.common.IUpdcContext)
	 */
	public IProgramTemplate.IUpdffwmOffer.IUpdfcmpDistribute getSFUpdbmClaim(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm, 
			IOVUpdcpmOffer fromUpdcpm, 
			SFException aEXCEPTION, 
			IUpdcContext aContext) throws SFException, Exception {
		IProgramTemplate.IUpdffwmOffer.IUpdfcmpDistribute fromUpffxm = null;
		UpfsvcManager.getRocket().beginTransaction( fromTASK, fromUpdcpm.getSUBFLOW(), aContext );
		try
		{
			IProgramTemplate.IUpdffwmOffer fromUpfgmc = null;
			IOVUpdcpmOffer.IUpdcpmHome fromUpdcpmHome = fromUpdcpm.getPROGRAM();
			IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
			IPlatformTemplate.IUpffmOffer fromUpffm = fromUpdfwm.getPLATFORM();
			fromUpfgmc = (IProgramTemplate.IUpdffwmOffer)fromUpdcpmHome.getCOMPONENT();
			java.util.List fromClaim = fromUpfgmc.getDISTRIBUTE( fromUpffm.getID(), fromUpfom.getCATEGORY() );
			if( fromClaim != null && fromClaim.size() > 0 ){
				IProgramTemplate.IUpdffwmOffer.IUpdfcmpDistribute aDistribute = null;
				for( java.util.Iterator itera = fromClaim.iterator(); itera.hasNext(); ){
					aDistribute = (IProgramTemplate.IUpdffwmOffer.IUpdfcmpDistribute)itera.next();
					if( UpdcpUtils.IUpfvn.decision( aDistribute.getCOMPLEX(), fromUpdcpm.getSUBFLOW(), aContext ) ){
						fromUpffxm = aDistribute;
						break;
					}
				}
			}
			UpfsvcManager.getRocket().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getRocket().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromUpffxm;
	}
}
