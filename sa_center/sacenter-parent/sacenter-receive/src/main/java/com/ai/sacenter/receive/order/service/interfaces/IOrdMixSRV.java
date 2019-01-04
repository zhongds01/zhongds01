package com.ai.sacenter.receive.order.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ������������</p>
 * <p>Copyright: Copyright (c) 2016��3��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrdMixSRV {
	/**
	 * ���ݿ�ͨ���󵥲�ѯ��ͨ���������淶
	 * @param fromCATALOG ��Ʒ�����
	 * @param fromBUSINES ҵ���������
	 * @param fromORIGINATE ���𷽱���
	 * @param fromCATEGORY ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( String fromCATALOG, 
			String fromBUSINES, 
			String fromORIGINATE,
			String fromCATEGORY)  throws RemoteException,Exception;
	/**
	 * ���ݿ�ͨ�û���ѯ��ͨ�������������淶
	 * @param fromMsgFUser ��ͨ�û�
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFExpireBusines( IOVMsgFUser fromMsgFUser )  throws RemoteException,Exception;
	/**
	 * ���ݿ�ͨ�첽����ѯ��ͨ�첽�����������淶
	 * @param fromExigence ��ͨ�첽��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( IOVMocketExigence fromExigence) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�첽����ѯ��ͨ�첽�����������淶
	 * @param fromExigence ��ͨ�첽��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( IOVMsgFExigence fromExigence) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�첽����ѯ��ͨ�첽�����������淶
	 * @param fromUpdfmx ���ڶ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( IUpdfmxExpire fromUpdfmx) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ������ѯ��ͨ����淶
	 * @param fromRequest
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesOffer getSFMsgFComptel( IOVRocketExigence fromRequest) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ������ѯ��ͨ����淶
	 * @param fromRequest
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesOffer getSFMsgFComptel( IOVMocketExigence fromExigence) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ��Ϣ��ѯ��ͨ��Ϣ���������淶
	 * @param fromMsgF ��ͨ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines( IOVRocketExigence fromRequest) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�첽����ѯ��ͨ�첽�����������淶
	 * @param fromRequest ��ͨ�첽��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFComplete( IOVRocketExigence fromRequest) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ������ѯ��ͨ�������������淶
	 * @param fromRequest
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IOVOrderRequest fromRequest) throws SFException, Exception;
	
	/**
	 * ���ݿ�ͨ������ѯ��ͨ�������������淶
	 * @param fromRequest ��ͨ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFMsgFBusines(IOVMsgFRequest fromRequest) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�޸�����ѯ��ͨ�������������淶
	 * @param fromRequest ��ͨ�޸���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmOfferHome getSFUrgencyBusines(IOVMsgFRequest fromRequest) throws SFException,Exception;
	/**
	 * ���ݷ����Ų�ѯ�����Ʒ��չ�淶
	 * @param fromRequest ��ͨ����
	 * @param fromOffer ��ͨ��������
	 * @param fromUpdcpm ��ͨ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesCatalog getSFMsgFBusines( IOVMsgFRequest fromRequest, 
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * ���ݷ����Ų�ѯ����ͨ����������չ�淶
	 * @param fromRequest ��ͨ����
	 * @param fromOffer ��ͨ��������
	 * @param fromUpdcpm ��ͨ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesCatalog getSFMsgFReceive( IOVMsgFRequest fromRequest, 
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ��Ϣ���㵱ǰ��ͨ�����Ʒ���ȼ�
	 * @param fromRequest ��ͨ����
	 * @param fromBusines ҵ�����ȼ�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsOffer getSFMsgFPriority(IOVMsgFRequest fromRequest,
			ISystemTemplate.IUpdbfsBusines fromBusines) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�������㵱ǰ��ͨ�������ȼ�
	 * @param fromMsgF ��ͨ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsOffer getSFMsgFPriority( IOVMsgFRequest fromRequest ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ��Ϣ���㵱ǰ��ͨ�������ȼ�
	 * @param fromMsgF ��ͨ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsOffer getSFMsgFPriority( IOVRocketExigence fromMsgF ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ���������Ʒ�淶��ɿ�ͨ���������ƷԤ����
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFOffer ��ͨ��������
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] finishSFMsgFReceive( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromMsgFOffer,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݷ����Ʒ��չ�淶��ɷ����Ʒ��չ����
	 * @param fromPentium ��ͨ����
	 * @param fromOffer ��ͨ��������
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] finishSFOfferNature( IOVMsgFRequest fromPentium,
			IOVMsgFOffer fromOffer,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ��Ϣ�û�ͣ����״̬����û�ͣ��������
	 * @param fromRequest ��ͨ��Ϣ
	 * @param fromMsgFUser ��ͨ��Ϣ�û�
	 * @param fromOrdUser ��ͨ�����û�
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOsStatusTrail(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser, 
			IOVOrderUser fromOrdUser ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ���������Ʒ�����Ԫ������Ʒ������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromOffer ��ͨ�����Ʒ
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOfferDepend( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromOffer,
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ�������񶩹���ɿ�ͨͬ�����ӳ���ϵ
	 * @param fromPentium ��ͨ����
	 * @param fromMsgFOffer ��ͨ�����Ʒ
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] finishSFOfferGroup( IOVMsgFRequest fromPentium,
			IOVMsgFOffer fromMsgFOffer,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���շ��񶩹�ģ����ɿ�ͨ�����Ʒ����
	 * @param fromRequest ��ͨ����
	 * @param fromNature ��ͨ��������
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOfferCompete( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromNature,  
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���յ���Ʒ����ģ����ɿ�ͨ�����Ʒ����
	 * @param fromRequest ��ͨ����
	 * @param fromNature ��ͨ��������
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOfferPrice( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromNature,  
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���շ����Ʒ��ζ���ģ����ɿ�ͨ�����Ʒ����
	 * @param fromRequest ��ͨ����
	 * @param fromNature ��ͨ��������
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFOfferMultle( IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromNature,  
			IOVUpffmxRequest fromUpffmx,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ����������ɿ�ͨ����������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFOffer ��ͨ����
	 * @param fromUpffmx ��ͨ������
	 * @param fromUpdcpm ��ͨ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFMsgFNetWork( IOVMsgFRequest fromRequest, 
			IOVMsgFOffer fromMsgFOffer,
            IOVUpffmxRequest fromUpffmx,  
            IUpfgkmOfferHome fromUpdcpm,
            IUpdcContext aContext) throws SFException, Exception;
}
