package com.ai.sacenter.receive.order.service.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.expire.IExpireFactory;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.service.interfaces.IExpireSRV;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdOffer;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserOffer;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: �����û����ڹ���</p>
 * <p>Copyright: Copyright (c) 2017��3��7��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ExpireSRVImpl extends UpdcEclipseImpl implements IExpireSRV {
	public ExpireSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFMsgFExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFMsgFExpire(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			finishSFUserExpire(fromRequest, 
					fromMsgFUser, 
					fromUpffmx, 
					fromUpdcpm, 
					aContext);
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFOrdExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOrdExpire(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFMsgFExpireImpl{
				public SFMsgFExpireImpl(){
					super();
				}
				/**
				 * ���ݿ�ͨ���������������Ч������ϵ
				 * @param fromRequest ��ͨ����
				 * @param fromMsgFOffer ��ͨ����
				 * @param fromUpffmx ��ͨ������
				 * @param fromUpdcpm ��ͨ��������
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFEffective(IOVMsgFRequest fromRequest,
						IOVMsgFOffer fromMsgFOffer, 
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFUser fromUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
						IOVMsgFRequest.IMsgFOfferHome fromMetaHome = fromRequest.getORDER();
						if( fromMsgFOffer.isCREATE() /*���������Ʒ��Ч*/ ){
							IOrderFactory.getIOrdMixSV().finishSFMsgFNetWork(fromRequest, 
									fromMsgFOffer, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
							if( fromMsgFOffer.isEXPIRE( fromMetaHome.getCREATOR() )/*�����˶�*/){
								IOVMsgFOrdOffer fromExpire = new IOVMsgFOrdOffer( fromMsgFOffer );
								fromExpire.setSTATUS( IUpdbfsConst.IState.IOrder.S03 );
								IExpireFactory.getIExpireSV().finishSFUpffxExpire(fromRequest, 
										fromUser, 
										fromExpire, 
										fromExpire.getEXPIRE(), 
										aContext);
							}
						}
						else if( fromMsgFOffer.isEXPIRE( fromMetaHome.getCREATOR() )/*�����˶�*/){
							IOVMsgFOrdOffer fromExpire = new IOVMsgFOrdOffer( fromMsgFOffer );
							fromExpire.setSTATUS( IUpdbfsConst.IState.IOrder.S03 );
							IExpireFactory.getIExpireSV().finishSFUpffxExpire(fromRequest, 
									fromUser, 
									fromExpire, 
									fromExpire.getEXPIRE(), 
									aContext);
						}
						else/*��������Ʒ��Ч ���� �˶������Ʒ��Ч ���� ����״̬�����Ʒ*/{
							IOrderFactory.getIOrdMixSV().finishSFMsgFNetWork(fromRequest, 
									fromMsgFOffer, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
						}
					}
					finally{
						
					}
				}
				/**
				 * ���ݿ�ͨ�������������������Ч������ϵ
				 * @param fromRequest ��ͨ����
				 * @param fromMsgFOffer ��ͨ����
				 * @param fromUpffmx ��ͨ������
				 * @param fromUpdcpm ��ͨ��������
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFNextMonth(IOVMsgFRequest fromRequest,
						IOVMsgFOffer fromMsgFOffer, 
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFUser fromUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
						IOVMsgFRequest.IMsgFOfferHome fromMetaHome = fromRequest.getORDER();
						IOVMsgFOrdOffer fromEffective = new IOVMsgFOrdOffer( fromMsgFOffer );
						fromEffective.setSTATUS( IUpdbfsConst.IState.IOrder.S01 );
						IExpireFactory.getIExpireSV().finishSFUpffxExpire(fromRequest, 
								fromUser, 
								fromEffective, 
								fromEffective.getEFFECTIVE(), 
								aContext);
						if( fromMsgFOffer.isEXPIRE( fromMetaHome.getCREATOR() ) /*�����˶�*/){
							IOVMsgFOrdOffer fromExpire = new IOVMsgFOrdOffer( fromMsgFOffer );
							fromExpire.setSTATUS( IUpdbfsConst.IState.IOrder.S03 );
							IExpireFactory.getIExpireSV().finishSFUpffxExpire(fromRequest, 
									fromUser, 
									fromExpire, 
									fromExpire.getEXPIRE(), 
									aContext);
						}
					}
					finally{
						
					}
				}
				/**
				 * ���ݿ�ͨ����������������ڶ�����ϵ
				 * @param fromRequest ��ͨ����
				 * @param fromMsgFOffer ��ͨ����
				 * @param fromPentium ��ͨ������
				 * @param fromUpdcpm ��ͨ��������
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFMsgFExpire(IOVMsgFRequest fromRequest,
						IOVMsgFOffer fromMsgFOffer, 
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
			            IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
						IOVMsgFRequest.IMsgFOfferHome fromMetaHome = fromRequest.getORDER();
						IExpireFactory.getIExpireSV().finishSFUpffxHistory(fromRequest, 
								fromMsgFUser, 
								fromMsgFOffer, 
								fromUpdcpm, 
								aContext);
						if( fromMsgFOffer.isVALID() /*ʧЧʱ�� > ��Чʱ��*/){
							if( TimeUtils.greaterEqual( fromMetaHome.getCREATOR(), 
									fromMsgFOffer.getEFFECTIVE() )/*������Ч*/){
								finishSFMsgFEffective(fromRequest, 
										fromMsgFOffer, 
										fromUpffmx, 
										fromUpdcpm, 
										aContext);
							}
							else if( TimeUtils.infiniteYYYY( fromMsgFOffer.getEFFECTIVE(), 
									fromMetaHome.getCREATOR() ) == false/*��������Ч*/){
								finishSFMsgFNextMonth(fromRequest, 
										fromMsgFOffer, 
										fromUpffmx, 
										fromUpdcpm, 
										aContext);
							}
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromOrdOffer
				 * @param fromUpffmx
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOrderExpire(IOVMsgFRequest fromRequest, 
						IOVMsgFUser fromMsgFUser,
						IOVMsgFOrdOffer fromOrdOffer,
						IOVUpffmxRequest fromUpffmx, 
						IUpfgkmOfferHome fromUpdcpm,
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFOffer fromOffer[] = IOrderFactory.getIOrdMixSV().finishSFMsgFReceive(fromRequest,
								fromOrdOffer, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
						for( int index = 0; fromOffer != null && index < fromOffer.length; index++ ){
							finishSFMsgFExpire(fromRequest, 
									fromOffer[index], 
									fromUpffmx, 
						    		fromUpdcpm, 
						    		aContext);
						}
					}
					finally{
						
					}
				}
			}
			SFMsgFExpireImpl fromExpireImpl = new SFMsgFExpireImpl();
			try
			{
				IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
				for( java.util.Iterator<IOVMsgFOrdCentrex> itera = fromMsgFUser.getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOrdCentrex fromCentrex = (IOVMsgFOrdCentrex)itera.next();
					if( fromOrdUserHome.getSFUpffxUsed( fromCentrex ) != null ) continue;
					fromOrdUserHome.submitSFUpffxUsed( new IOVMsgFOrdCentrex[]{ fromCentrex });
					for( java.util.Iterator<IOVMsgFOffer> iterap = fromCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
						IOVMsgFOrdOffer fromMsgFOffer = (IOVMsgFOrdOffer)iterap.next();
						fromExpireImpl.finishSFOrderExpire(fromRequest, 
								fromMsgFUser, 
								fromMsgFOffer, 
								fromUpffmx, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromExpireImpl != null ){ fromExpireImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFOrdEffective(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFOrdEffective(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFMsgFEffectiveImpl{
				public SFMsgFEffectiveImpl(){
					super();
				}
			}
			SFMsgFEffectiveImpl fromEffectiveImpl = new SFMsgFEffectiveImpl();
			try
			{
				IOVUpffmxRequest.IUpffmxUserHome fromOrdUserHome = fromUpffmx.getUSER().getUSER();
				for( java.util.Iterator<IOVMsgFOrdCentrex> itera = fromMsgFUser.getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOrdCentrex fromCentrex = (IOVMsgFOrdCentrex)itera.next();
					if( fromOrdUserHome.getSFUpffxUsed( fromCentrex ) != null ) continue;
					fromOrdUserHome.submitSFUpffxUsed( new IOVMsgFOrdCentrex[]{ fromCentrex });
					for( java.util.Iterator<IOVMsgFOffer> iterap = fromCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
						IOVMsgFOrdOffer fromMsgFOffer = (IOVMsgFOrdOffer)iterap.next();
						if( fromMsgFOffer.isVALID()/*ʧЧʱ�� > ��Чʱ��*/ ){
							IOrderFactory.getIOrdMixSV().finishSFMsgFNetWork(fromRequest, 
									fromMsgFOffer, 
									fromUpffmx, 
									fromUpdcpm, 
									aContext);
						}
					}
				}
			}
			finally{
				if( fromEffectiveImpl != null ){ fromEffectiveImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFUserExpire(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUserExpire(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpffmxExpireImpl{
				public SFUpffmxExpireImpl(){
					super();
				}
				/**
				 * ���ݿ�ͨ�û���ȡ�û�������ϵ
				 * @param fromRequest ��ͨ����
				 * @param fromMsgFUser ��ͨ�û�
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public CarbonList<IOVMsgFUserOffer> getSFUserOrderHome( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser, 
						IUpdcContext aContext) throws SFException, Exception{
					CarbonList<IOVMsgFUserOffer> fromORDER = new CarbonList<IOVMsgFUserOffer>();
					try
					{
						for( java.util.Iterator<IOVMsgFUserCentrex> itera = fromMsgFUser.getUSER().iterator(); itera.hasNext(); ){
							IOVMsgFUserCentrex fromCentrex = (IOVMsgFUserCentrex)itera.next();
							ClassUtils.IMerge.merge( fromCentrex.getCENTREX(), fromORDER );
						}
						if( fromORDER == null || fromORDER.size() <= 0 ){
							fromORDER = new CarbonList<IOVMsgFUserOffer>();
							IOVMsgFUser fromMsgFCentrex = IOrderFactory.getICustomSV().getSFUserCentrex( fromRequest, fromMsgFUser );
							if( fromMsgFCentrex != null && fromMsgFCentrex.getUSER() != null ){
								for( java.util.Iterator<IOVMsgFUserCentrex> itera = fromMsgFCentrex.getUSER().iterator(); itera.hasNext(); ){
									IOVMsgFUserCentrex usercentrex = (IOVMsgFUserCentrex)itera.next();
									ClassUtils.IMerge.merge( usercentrex.getCENTREX(), fromORDER );
								}
							}
						}
					}
					finally{
						
					}
					return fromORDER;
				}
				/**
				 * ȫ��ɾ����ͨ�û����ڹ����Լ��䶩����ϵ
				 * @param fromRequest ��ͨ����
				 * @param fromMsgFUser ��ͨ�û�
				 * @param fromUpffmx ��ͨ������
				 * @param fromUpdcpm ��ͨ��������
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffmxHistory(IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser, 
						IOVUpffmxRequest fromUpffmx,
						IUpfgkmOfferHome fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IExpireFactory.getIExpireSV().finishSFUpffxHistory(fromRequest, 
								fromMsgFUser, 
								aContext);
					}
					finally{
						
					}
				}
				/**
				 * ���ݿ�ͨ�����Ʒ��������ڳ���
				 * @param fromRequest ��ͨ����
				 * @param fromMsgFUser ��ͨ�û�
				 * @param fromMsgFOffer ��ͨ��Ʒ
				 * @param fromUpdcpm ��ͨ��������
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFOfferExpire( IOVMsgFRequest fromRequest,
						IOVMsgFUser fromMsgFUser, 
						IOVMsgFOffer fromMsgFOffer,
						IUpfgkmOfferHome fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						IOVMsgFRequest.IMsgFOfferHome fromMetaHome = fromRequest.getORDER();
						if( fromMsgFOffer.isEFFECTIVE( fromMetaHome.getCREATOR() )/*���¶���*/){
					    	IOVMsgFOrdOffer fromEffective = new IOVMsgFOrdOffer( fromMsgFOffer );
							fromEffective.setSTATUS( IUpdbfsConst.IState.IOrder.S01 );
							IExpireFactory.getIExpireSV().finishSFUpffxExpire(fromRequest, 
									fromMsgFUser, 
									fromEffective, 
									fromEffective.getEFFECTIVE(), 
									aContext);
						}
						if( fromMsgFOffer.isEXPIRE( fromMetaHome.getCREATOR() )/*�����˶�*/){
					    	IOVMsgFOrdOffer fromExpire = new IOVMsgFOrdOffer( fromMsgFOffer );
					    	fromExpire.setSTATUS( IUpdbfsConst.IState.IOrder.S03 );
							IExpireFactory.getIExpireSV().finishSFUpffxExpire(fromRequest, 
									fromMsgFUser, 
									fromExpire, 
									fromExpire.getEXPIRE(), 
									aContext);
						}
					}
					finally{
						
					}
				}
			}
			SFUpffmxExpireImpl fromUpffmxImpl = new SFUpffmxExpireImpl();
			try
			{
				fromUpffmxImpl.finishSFUpffmxHistory(fromRequest, 
						fromMsgFUser, 
						fromUpffmx, 
						fromUpdcpm, 
						aContext);
				CarbonList<IOVMsgFUserOffer> fromORDER = fromUpffmxImpl.getSFUserOrderHome(fromRequest, 
						fromMsgFUser, 
						aContext);
				for( java.util.Iterator<IOVMsgFUserOffer> itera = fromORDER.iterator(); itera.hasNext(); ){
					IOVMsgFOffer fromMsgFOffer = (IOVMsgFOffer)itera.next();
					if( fromMsgFOffer.isVALID()/*ʧЧʱ��>��Чʱ��*/){
						fromUpffmxImpl.finishSFOfferExpire(fromRequest, 
								fromMsgFUser, 
								fromMsgFOffer, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpffmxImpl != null ){ fromUpffmxImpl = null; }
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFUserHistory(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFUserHistory(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			IExpireFactory.getIExpireSV().finishSFUpffxHistory(fromRequest, 
					fromMsgFUser, 
					aContext);
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.IExpireSRV#finishSFGroupHistory(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVUpffmxRequest, com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome, com.ai.sacenter.IUpdcContext)
	 */
	public void finishSFGroupHistory(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromGroup, 
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception {
		try
		{
			class SFUpffxGroupImpl{
				public SFUpffxGroupImpl(){
					super();
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromMsgFUser
				 * @param fromMsgFCentrex
				 * @param fromUpdcpm
				 * @param aContext
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUpffxHistory( IOVMsgFRequest fromRequest, 
						IOVMsgFUser fromMsgFUser, 
						IOVMsgFOrdCentrex fromMsgFCentrex, 
						IUpfgkmOfferHome fromUpdcpm, 
						IUpdcContext aContext) throws SFException, Exception{
					try
					{
						for( java.util.Iterator<IOVMsgFOffer> itera = fromMsgFCentrex.getCENTREX().iterator(); itera.hasNext(); ){
							IOVMsgFOrdOffer fromOffer = (IOVMsgFOrdOffer)itera.next();
							IExpireFactory.getIExpireSV().finishSFUpffxHistory(fromRequest, 
									fromMsgFUser, 
									fromOffer, 
									fromUpdcpm, 
									aContext);
						}
					}
					finally{
						
					}
				}
			}
			SFUpffxGroupImpl fromUpffxImpl = new SFUpffxGroupImpl();
			try
			{
				IExpireFactory.getIExpireSV().finishSFUpffxHistory(fromRequest, 
						fromGroup, 
						aContext);
				for( java.util.Iterator<IOVMsgFUser> itera = fromRequest.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUser fromMsgFUser = (IOVMsgFUser)itera.next();
					if( fromMsgFUser.getUSER_ID() == fromGroup.getUSER_ID() ) continue;
					for( java.util.Iterator<IOVMsgFOrdCentrex> iterap = fromMsgFUser.getORDER().iterator(); iterap.hasNext(); ){
						IOVMsgFOrdCentrex ordercentrex = (IOVMsgFOrdCentrex)iterap.next();
						fromUpffxImpl.finishSFUpffxHistory(fromRequest, 
								fromMsgFUser, 
								ordercentrex, 
								fromUpdcpm, 
								aContext);
					}
				}
			}
			finally{
				if( fromUpffxImpl != null ){ fromUpffxImpl = null; }
			}
		}
		finally{
			
		}
	}
}
