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
	 * ��ͨ��ͨ����[�����ڿ�ͨ][��ͨ���������淶]
	 * IUpdbfsMsgFExpireImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * ��ͨ��ͨ����[ȫ��������ͨ][��ͨ���������淶]
	 * IUpdbfsMsgFEffectiveImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * Ⱥ�鿪ͨ����[ȫ��������ͨ][��ͨ���������淶]
	 * IUpdbfsGroupEffectiveImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * Ⱥ�鿪ͨ����[�����ڿ�ͨ][��ͨ���������淶]
	 * IUpdbfsGroupExpireImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * Ⱥ���Ա����[�û��⿪ͨ][��ͨ���������淶]
	 * IUpdbfsMemberNatureImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * Ⱥ���Ա����[�������ڿ�ͨ][��ͨ���������淶]
	 * IUpdbfsMemberEffectiveImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * Ⱥ���Ա����[�����ڿ�ͨ][��ͨ���������淶]
	 * IUpdbfsMemberExpireImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * ���������ݸ���[�����ڿ�ͨ][��ͨ���������淶]
	 * IUpdbfsUserExpireImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * �û������ͨ[ɾ��������][��ͨ���������淶]
	 * IUpdbfsMsgFCeaseImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * �û��������[�û���Ʒ���][��ͨ���������淶]
	 * IUpdbfsMsgFNatureImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
	 * ��Ԫ�쳣��[�û��쳣����][��ͨ���������淶]
	 * IUpdbfsMsgFNetBollImpl
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ����
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
			if( StringUtils.equals( fromOPERTYPE.getATTR_VALUE(), "NETWORK" )/*��Ԫ�ط�*/){
				UpdcFactory.getIUpdcSV().finishSFTaskRedo( new long[]{Long.parseLong( fromTASK.getATTR_VALUE() ) }, 
						fromRequest.getORG_ID(), 
						fromRequest.getSTAFF_ID(), 
						fromPARAM);
			}
			else if( StringUtils.equals(fromOPERTYPE.getATTR_VALUE(), "COMPLETE" )/*�˹�����*/){
				UpdcFactory.getIUpdcSV().finishSFTaskComplete( new long[]{Long.parseLong( fromTASK.getATTR_VALUE() ) }, 
						fromREASON != null?fromREASON.getATTR_VALUE():"",
						fromRequest.getORG_ID(), 
						fromRequest.getSTAFF_ID(), 
						fromPARAM);
			}
			else if( StringUtils.equals(fromOPERTYPE.getATTR_VALUE(), "CANCEL" )/*�˵��ع�*/){
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
