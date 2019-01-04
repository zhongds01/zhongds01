package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ���Ʒ���ĶԽ�</p>
 * <p>Copyright: Copyright (c) 2016��3��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IProductSRV {
	/**
	 * ���ݷ����Ʒ��ѯ�����Ʒ�淶
	 * @param fromCOMPETE
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFProductOffer( long fromCOMPETE ) throws SFException,Exception;
	/**
	 * ���ݷ������Բ�ѯ�����Ʒ�淶
	 * @param fromMsgFOfferX
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFProductOffer( IOVMsgFOfferX fromMsgFOfferX ) throws SFException,Exception;
	/**
	 * ���ݷ����Ų�ѯ�Ƿ������ͨ�����Ʒ��
	 * @param fromOffer
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFProductBelong( IOVMsgFOffer fromOffer ) throws SFException,Exception;
	/**
	 * �����û������Ʒ��ѯ�����Ʒ�淶
	 * @param fromMsgF ��ͨ����
	 * @param fromOffer ��ͨ������������
	 * @param fromUpdcpm ��ͨ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFProductOffer( IOVMsgFRequest fromMsgF, 
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * �����û������Ʒ��ѯ�����Ʒ��ͨ�淶
	 * @param fromCOMPETE
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductComptel getSFProductNature( String fromCOMPETE ) throws SFException,Exception;
	/**
	 * �����û������Ʒ��ѯ�����Ʒ��ͨģʽ
	 * @param fromMsgF
	 * @param fromOffer
	 * @param fromUpdcpm
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductComptel getSFProductNature(IOVMsgFRequest fromMsgF, 
			IOVMsgFOffer fromOffer, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * ���ݷ����Ʒ���ѯ�����Ʒ��淶
	 * @param fromGroup �����Ʒ��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductGroup getSFProductGroup( String fromGroup ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�����Ʒ��ѯ��ͨͬ�����ӳ��淶
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ���񶩹�
	 * @param fromUpdcpm ��ͨ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductGroup getSFProductGroup( IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser, 
			IUpfgkmOfferHome fromUpdcpm ) throws SFException,Exception;
	/**
	 * �����Ʒ������������ϵͳ��[������������]
	 * @param fromRequest ��ͨ����
	 * @param fromUser ��ͨ�û�
	 * @param fromOffer ��ͨ��Ʒ
	 * @return ��ΪNULL������Ʒ������������ϵͳ�����������ͨ����������ϵͳ
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductCatalog[] getSFExpireGroup( IOVMsgFRequest fromRequest,
			IOVMsgFUser fromUser, 
			IOVMsgFOffer fromOffer) throws SFException,Exception;
	/**
	 * ��ѯ��ǰ������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductCombine getSFPVpmnGroup( ) throws SFException,Exception;
}
