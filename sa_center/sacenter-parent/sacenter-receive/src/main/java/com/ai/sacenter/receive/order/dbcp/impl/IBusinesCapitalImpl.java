package com.ai.sacenter.receive.order.dbcp.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVUpffmxConsult;
import com.ai.sacenter.teaminvoke.UpdcFactory;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

public class IBusinesCapitalImpl extends UpdcEclipseImpl implements IBusinesCapital {
	public IBusinesCapitalImpl(){
		super();
	}
	
	/**
	 * 普通开通定单[下周期开通][开通接入能力规范]
	 * IUpdbfsMsgFExpireImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIMsgFExpireImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFMsgFExpire(fromRequest, 
					fromUpdcpm, 
					aContext);
			IOVOrderRequest fromOrdHome = fromUpffmx.getPLATFORM().getPLATFORM();
			fromASK = UpdcFactory.getIUpdcSV().applySFOrder(fromOrdHome, 
					fromUpdcpm, 
					fromXML );
			for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
				IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
				UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(), 
						fromOrdUserHome.getCOMPETENCE(), 
						fromXML );
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
	/**
	 * 普通开通定单[全部立即开通][开通接入能力规范]
	 * IUpdbfsMsgFEffectiveImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIMsgFEffectiveImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFMsgFEffective(fromRequest, 
					fromUpdcpm, 
					aContext);
			IOVOrderRequest fromOrdHome = fromUpffmx.getPLATFORM().getPLATFORM();
			fromASK = UpdcFactory.getIUpdcSV().applySFOrder(fromOrdHome, 
					fromUpdcpm, 
					fromXML );
			for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
				IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
				UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(),
						fromOrdUserHome.getCOMPETENCE(), 
						fromXML );
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
	/**
	 * 群组开通定单[全部立即开通][开通接入能力规范]
	 * IUpdbfsGroupEffectiveImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIGroupEffectiveImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFGroupEffective(fromRequest, 
					fromUpdcpm, 
					aContext);
			IOVOrderRequest fromOrdHome = fromUpffmx.getPLATFORM().getPLATFORM();
			fromASK = UpdcFactory.getIUpdcSV().applySFGroup(fromOrdHome, 
					fromUpdcpm, 
					fromXML );
			for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
				IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
				UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(), 
						fromOrdUserHome.getCOMPETENCE(), 
						fromXML );
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
	/**
	 * 群组开通定单[下周期开通][开通接入能力规范]
	 * IUpdbfsGroupExpireImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIGroupExpireImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFGroupExpire(fromRequest, 
					fromUpdcpm, 
					aContext);
			IOVOrderRequest fromOrdHome = fromUpffmx.getPLATFORM().getPLATFORM();
			fromASK = UpdcFactory.getIUpdcSV().applySFGroup(fromOrdHome, 
					fromUpdcpm, 
					fromXML );
			for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
				IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
				UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(), 
						fromOrdUserHome.getCOMPETENCE(),
						fromXML );
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
	/**
	 * 群组成员定单[用户测开通][开通接入能力规范]
	 * IUpdbfsMemberNatureImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIMemberNatureImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFMemberNature(fromRequest, 
					fromUpdcpm, 
					aContext);
			IOVOrderRequest fromOrdHome = fromUpffmx.getPLATFORM().getPLATFORM();
			fromASK = UpdcFactory.getIUpdcSV().applySFBatch(fromOrdHome, 
					fromUpdcpm, 
					fromXML );
			for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
				IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
				UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(), 
						fromOrdUserHome.getCOMPETENCE(), 
						fromXML );
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
	/**
	 * 群组成员定单[无下周期开通][开通接入能力规范]
	 * IUpdbfsMemberEffectiveImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIMemberEffectiveImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFMemberEffective(fromRequest, 
					fromUpdcpm, 
					aContext);
			IOVOrderRequest fromOrdHome = fromUpffmx.getPLATFORM().getPLATFORM();
			fromASK = UpdcFactory.getIUpdcSV().applySFBatch(fromOrdHome, 
					fromUpdcpm, 
					fromXML );
			for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
				IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
				UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(), 
						fromOrdUserHome.getCOMPETENCE(), 
						fromXML );
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
	/**
	 * 群组成员定单[下周期开通][开通接入能力规范]
	 * IUpdbfsMemberExpireImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIMemberExpireImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFMemberExpire(fromRequest, 
					fromUpdcpm, 
					aContext);
			IOVOrderRequest fromOrdHome = fromUpffmx.getPLATFORM().getPLATFORM();
			fromASK = UpdcFactory.getIUpdcSV().applySFBatch(fromOrdHome, 
					fromUpdcpm, 
					fromXML );
			for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
				IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
				UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(), 
						fromOrdUserHome.getCOMPETENCE(), 
						fromXML );
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
	/**
	 * 下周期数据更新[下周期开通][开通接入能力规范]
	 * IUpdbfsUserExpireImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIUserExpireImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFMsgFExpire(fromRequest, 
					fromUpdcpm, 
					aContext);
			for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
				IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
				UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(), 
						fromOrdUserHome.getCOMPETENCE(), 
						fromXML );
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
	/**
	 * 用户拆机开通[删除下周期][开通接入能力规范]
	 * IUpdbfsMsgFCeaseImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIMsgFCeaseImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext)throws SFException,Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFMsgFGroup(fromRequest, 
					fromUpdcpm, 
					aContext);
			if( fromUpffmx != null && fromUpffmx.getPLATFORM() != null ){
				IOVOrderRequest fromOrdHome = fromUpffmx.getPLATFORM().getPLATFORM();
				fromASK = UpdcFactory.getIUpdcSV().applySFOrder(fromOrdHome, 
						fromUpdcpm, 
						fromXML );
				for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
					IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
					UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(), 
							fromOrdUserHome.getCOMPETENCE(), 
							fromXML );
				}
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
		
	}
	
	/**
	 * 用户变更定单[用户产品变更][开通接入能力规范]
	 * IUpdbfsMsgFNatureImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIMsgFNatureImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext)throws SFException,Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFMsgFNature(fromRequest, 
					fromUpdcpm, 
					aContext);
			IOVOrderRequest fromOrdHome = fromUpffmx.getPLATFORM().getPLATFORM();
			if( fromOrdHome != null ){
				fromASK = UpdcFactory.getIUpdcSV().applySFGroup(fromOrdHome, 
						fromUpdcpm, 
						fromXML );
				for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
					IOVUpffmxConsult fromOrdUserHome = (IOVUpffmxConsult)itera.next();
					 UpdcFactory.getIUpdcSV().applySFOrder(fromOrdUserHome.getPLATFORM(), 
							 fromOrdUserHome.getCOMPETENCE(), 
							 fromXML );
				}
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
	/**
	 * 网元异常单[用户异常处理][开通接入能力规范]
	 * IUpdbfsMsgFNetBollImpl
	 * @param fromRequest 开通定单
	 * @param fromUpdcpm 开通能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIMsgFNetBollImpl(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext)throws SFException,Exception{
		IOVOrderResponse fromASK = null;
		java.util.HashMap<Object,Object> fromPARAM = new java.util.HashMap<Object,Object>();
		try
		{
			IOVMsgFUser fromMsgUser = fromRequest.getUSER( fromRequest.getUSER_ID() );
			IOVMsgFOfferX fromOPERTYPE = fromMsgUser.getNATURE( "OPERTYPE" );
			IOVMsgFOfferX fromTASK     = fromMsgUser.getNATURE( "TASK_ID"  );
			IOVMsgFOfferX fromREASON   = fromMsgUser.getNATURE( "REASON"   );
			if( StringUtils.equals( fromOPERTYPE.getATTR_VALUE(), "NETWORK" )/*网元重发*/){
				UpdcFactory.getIUpdcSV().finishSFTaskRedo( new long[]{Long.parseLong( fromTASK.getATTR_VALUE() ) }, 
						fromRequest.getORG_ID(), 
						fromRequest.getSTAFF_ID(), 
						fromPARAM);
			}
			else if( StringUtils.equals(fromOPERTYPE.getATTR_VALUE(), "COMPLETE" )/*人工跳单*/){
				UpdcFactory.getIUpdcSV().finishSFTaskComplete( new long[]{Long.parseLong( fromTASK.getATTR_VALUE() ) }, 
						fromREASON != null?fromREASON.getATTR_VALUE():"",
						fromRequest.getORG_ID(), 
						fromRequest.getSTAFF_ID(), 
						fromPARAM);
			}
			else if( StringUtils.equals(fromOPERTYPE.getATTR_VALUE(), "CANCEL" )/*退单回滚*/){
				UpdcFactory.getIUpdcSV().finishSFTaskException(new long[]{Long.parseLong( fromTASK.getATTR_VALUE() ) }, 
						fromREASON != null?fromREASON.getATTR_VALUE():"",
						fromRequest.getORG_ID(), 
						fromRequest.getSTAFF_ID(), 
						fromPARAM);
			}
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromASK;
	}
}
