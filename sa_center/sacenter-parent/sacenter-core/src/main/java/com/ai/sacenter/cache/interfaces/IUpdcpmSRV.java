package com.ai.sacenter.cache.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IUpdcpmGroup;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��������[��������]</p>
 * <p>Copyright: Copyright (c) 2015��9��29��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpmSRV extends IDialect {
	/**
	 * ��ѯ��ͨ��������ù淶
	 * @param fromCATALOG ��Ʒ�����
	 * @param fromBUSINES ҵ���������
	 * @param fromORIGINATE ��������
	 * @param fromCATEGORY ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesOffer getSFUpdbfxBusines(String fromCATALOG, 
			String fromBUSINES, 
			String fromORIGINATE,
			String fromCATEGORY) throws SFException, Exception;
	/**
	 * ��ѯ��ͨ�������չ���ù淶
	 * @param fromPROGRAM  ����Ŀ¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesCombine getSFUpdbfxKernel( String fromPROGRAM ) throws SFException, Exception;
	/**
	 * ��ѯ��ͨ�������չ���ù淶
	 * @param fromCATEGORY ��չ����
	 * @param fromPROGRAM  ����Ŀ¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesKernel getSFUpdbfxKernel(String fromCATEGORY,
			String fromPROGRAM ) throws SFException, Exception;
	/**
	 * ��ѯ��ͨ������Ʒ��չ���ù淶
	 * @param fromCATALOG ��Ʒ���
	 * @param fromBUSINES ��Ʒ����
	 * @param fromPRODUCT ��Ʒ����
	 * @param fromCATEGORY ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesCatalog getSFUpdbfxCatalog( String fromCATALOG, 
			String fromBUSINES, 
			String fromPRODUCT,
			String fromCATEGORY) throws SFException, Exception;
	
	/**
	 * ���ݷ�������ģ���ѯ��������ģ��淶
	 * @param fromMODULE ��������ģ��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.ICompetenceBusines getSFUpdbfxCompete( String fromMODULE ) throws SFException, Exception;

	/**
	 * ���ݲ�Ʒ��Ų�ѯ�����Ʒ��Ԫ�淶
	 * @param fromPRODUCT ��Ʒ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpOffer( long fromPRODUCT ) throws SFException, Exception;
	/**
	 * ���ݲ�Ʒ�����ѯ�����Ʒ��Ԫ�淶
	 * @param fromPRODUCT ��Ʒ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpComptel( String fromPRODUCT ) throws SFException, Exception;
	/**
	 * 
	 * @param fromPRODUCT
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductComptel getSFUpdcpSubject( String fromPRODUCT ) throws SFException, Exception;
	/**
	 * ���ݲ�Ʒ���ѯ�����Ʒ���嵥
	 * @param fromGroup ��Ʒ�����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductGroup getSFUpdcpGroup( String fromGroup ) throws SFException, Exception;
	/**
	 * ���ݲ�Ʒ��źͲ�ѯ�����Ʒ���淶
	 * @param fromPRODUCT ��Ʒ����
	 * @param fromCATEGORY ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductCombine getSFUpdcpCombine( String fromPRODUCT, 
			String fromCATEGORY ) throws SFException, Exception;
	/**
	 * ���ݲ�Ʒ���Ͳ�Ʒ������ѯ����������淶
	 * @param fromCATALOG ��Ʒ���
	 * @param fromBUSINES ��Ʒ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpBusines( String fromCATALOG, 
			String fromBUSINES ) throws SFException, Exception;
	/**
	 * ���ݷ���������Ų�ѯ��������������淶
	 * @param fromCOMPETE ������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpProperty( long fromCOMPETE ) throws SFException, Exception;
	/**
	 * ���ݷ�����������ѯ��������淶
	 * @param fromCOMPETE �����������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IComptelKernel getSFUpdcpKernel( String fromCOMPETE ) throws SFException, Exception;
	/**
	 * �������̱����ѯ������������
	 * @param fromWORKFLOW ���̱���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IUpdbpmOffer getSFUpdbpmOffer( String fromWORKFLOW ) throws SFException,Exception;
	/**
	 * ���������Ų�ѯ����������
	 * @param fromSUBFLOW ����������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbpmOffer getSFUpdbpmCatalog( String fromSUBFLOW ) throws SFException, Exception;
	/**
	 * ������Ԫ����ģ���ѯ��Ԫ��չ����ӳ��
	 * @param fromMODULE ��Ԫ����ģ��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffsmOffer getSFUpffwmOffer( String fromMODULE ) throws SFException, Exception;
	/**
	 * ������Ԫ����ģ�����Ԫ���Ա����ѯ��Ԫ��չ����ӳ��
	 * @param fromMODULE ��Ԫ����ģ��
	 * @param fromFEATURE ӳ�����Ա���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffgsmOffer getSFUpffxmOffer( String fromMODULE , 
			String fromFEATURE ) throws SFException, Exception;
	/**
	 * ������Ԫ����ģ�����Ԫ���Ա����ѯ��Ԫ����
	 * @param fromMODULE
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffgsmOffer[] getSFUpffxmOffice( String fromMODULE ) throws SFException, Exception;
	/**
	 * ���ݷ��������ѯ�������
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdpgmOffer getSFUpdpgmOffer( String fromPROGRAM ) throws SFException, Exception;
	/**
	 * ������������������Ͳ�ѯ��������淶
	 * @param aCOMPONENT �������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcmpOffer getSFUpdcmptOffer( String fromCOMPONENT ) throws SFException,Exception;
	/**
	 * ���ݽ�����������ѯ��������������,���������������δ��������õ�ǰ�������
	 * @param fromUpdcmpt �������
	 * @param fromJEVAL ���񶩹�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcmpOffer getSFUpdcmptOffer( IProgramTemplate.IUpdfcmpOffer fromUpdcmpt,
			java.util.HashMap fromOffer,
			IUpdcContext aContext)  throws SFException, Exception;
	/**
	 * ��������ʲ������ѯ��������ʲ�,���������ʲ�δ��������õ�ǰ����ʲ�
	 * @param aCOMPONENT ����ʲ�����
	 * @param fromOffer ���������� 
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpdcpmGroup getSFUpdcmptCatalog( String aCOMPONENT,
			java.util.Map fromOffer,
			IUpdcContext aContext)  throws SFException, Exception;
	/**
	 * ���ݽ��������ȡ��ǰһ��ӳ�������
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffsmOffer getSFUpdcmptMapping( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ����ӳ�������
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffsmOffer getSFUpdcmptComposite( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ�쳣���������
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptSubFlow( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ�쳣���������
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptQueue( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ���������
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptRocket( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ��Ԫ�鵵���
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptComplete( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ��Ԫ���쳣�����
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptPlatform( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ�쳣�������
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfmptOffer getSFUpdcmptCompensation( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ�쳣�ع������
	 * @param fromPROGRAM ��������
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfbpmOffer getSFUpdcmptRollBack( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ�쳣�ɵ����
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffwmOffer getSFUpdcmptDistribute( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ����׶����
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptSuggest( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * ���ݽ��������ȡ��ǰ���������
	 * @param fromPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptExpire( String fromPROGRAM ) throws SFException,Exception;
}
