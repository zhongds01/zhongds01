package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpfvmSRV {
	/**
	 * ����ѭ�����Ժ����������������������嵥
	 * ��ʽΪXXX_NUM=���Ը���;XXX_NAME_1=����1;XXX_VALUE_1=����1ֵ;XXX_NAME_2=����2;XXX_VALUE_2=����2ֵ
	 * @param fromID ģ����
	 * @param fromWHILEX ѭ������
	 * @param fromMODLE ѭ������ 
	 * @param fromOffer ��������
	 * @param fromChain ѭ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbpfChain(String fromID, 
			String fromWHILEX, 
		    String fromMODLE, 
		    java.util.Map fromOffer, 
		    java.util.List fromChain,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * �����������������������������嵥
	 * @param fromID ģ����
	 * @param fromMODLE ��������
	 * @param fromOffer ��������
	 * @param fromChain ѭ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbmfChain(String fromID, 
			String fromMODLE, 
		    java.util.Map fromOffer, 
		    java.util.List fromChain,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ����ѭ�����Ժ�������������ѭ�������嵥
	 * @param fromID ģ����
	 * @param fromWHILEX ѭ������
	 * @param fromMODLE ѭ��ӳ��ģ��
	 * @param fromOffer ��������
	 * @param fromChain ѭ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbfpChain(String fromID, 
			String fromWHILEX, 
		    String fromMODLE, 
		    java.util.Map fromOffer, 
		    java.util.List fromChain,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ����ѭ����������ѭ��ӳ�������嵥
	 * @param fromUpfgsmc ӳ�䵥Ԫ
	 * @param fromMODLE  ѭ������
	 * @param fromOffer ��������
	 * @param fromChain ѭ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbfpChain(IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			String fromMODLE,
			java.util.Map fromOffer, 
			java.util.List fromChain,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݶ������ַ������챣��
	 * @param fromPRIMITIVE ԭʼ������
	 * @param fromCOMPETE ������������
	 * @param fromChain �����Ƽ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishUpdbtfChain( String fromPRIMITIVE , 
			String fromCOMPETE,
			java.util.Map fromChain ) throws SFException,Exception;
	/**
	 * ��������ģ��淶�������̼������б�
	 * @param fromXPath ����ģ��淶,��ʽΪ[����ģ�����]��[����ģ�����.����ת������]
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFXPathChain( String fromXPath,
			java.util.Map fromOffer, 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����ѭ��ӳ���������������嵥
	 * @param fromUpfgsm ѭ��ӳ�䵥Ԫ
	 * @param fromMODULE ģ�����Ա���
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List finishSFUpdforChain( IPlatformTemplate.IUpffgsmOffer fromUpfgsm,
			String fromMODULE,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ����Э��ģ�����������Ԫ�˻�ָ��
	 * @param fromID ���Ա���
	 * @param fromCOMPLEX ����ģ�����
	 * @param fromPROTOCOL Э��ģ�����
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbrfChain( String fromID,
			String fromCOMPLEX,
			String fromPROTOCOL, 
			java.util.Map fromOffer, 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����Э��ģ�����������˻���������
	 * @param fromID ӳ����
	 * @param fromPROTOCOL Э��ģ������
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbwfChain( String fromID ,
			String fromPROTOCOL,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����ѭ�����Ժ�����ģ���������������嵥
	 * @param aID ���Ա���
	 * @param fromWHILEX ѭ�����Ա���
	 * @param fromMODLE ģ�����Ա���
	 * ��ʽΪ"����ģ���$BPF[�������Կ�ͷ]"
	 *  1.��ʽΪ"����ģ��",��aWHILEXΪѭ�����Ա���,������Ϊ���������
	 *  2.��ʽΪ"$BPF[���Կ�ͷ]",��aUpdsmoLife�а���"���Կ�ͷ_NUM"��"���Կ�ͷ_NAME_�±�"��"���Կ�ͷ_VALUE_�±�",
	 *    ����Ϊ$BPF[PARA],fromOffer�а���PARA_NUM=2;PARA_NAME_1=UserType;PARA_VALUE_1=0;PARA_NAME_2=QJCL;PARA_VALUE_2=1
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List finishSFUpdbpfChain( String fromID ,
			String fromWHILEX,
			String fromMODLE,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ����λ�ַ���־����λ�ַ���ӳ��
	 * @param fromUpfgsmc ӳ�䵥Ԫ
	 * @param aPRIMITIVE ԭʼ������
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbtfChain( IPlatformTemplate.IUpffgsmOffer fromUpfgsmc,
			String fromPRIMITIVE,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ����λ�ַ���־����λ�ַ���ӳ��
	 * @param fromUpfgsmc ӳ�䵥Ԫ
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbtfChain( ISystemTemplate.IUpfgsmxOffer fromUpfgsmc,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ����VTL���Ե���ϵͳ������
	 * @param fromID ģ����
	 * @param fromMODULE ��������
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpdfunChain( String fromID,
			String fromMODULE,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ����ö��ֵ��ѯ��̬��������
	 * @param fromUpfgsm ӳ��淶
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IEnumWrapper finishSFUpdbtxChain(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
				java.util.Map fromOffer, 
				IUpdcContext aContext) throws SFException, Exception; 
}
