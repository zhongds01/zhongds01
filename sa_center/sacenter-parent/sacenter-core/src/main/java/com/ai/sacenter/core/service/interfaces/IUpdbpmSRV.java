package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbpmOffer;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �������̵���</p>
 * <p>Copyright: Copyright (c) 2013-12-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdbpmSRV {
	/**
	 * ���ݷ����������ù��쵱ǰ�������̲�ֶ����嵥
	 * @param fromOrder ���񶨵�
	 * @param fromUpdbm ��������
	 * @param fromUpdcpm �����Ʒ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getSFUpdbmOffer( IOVOrderPentium fromOrder,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��񹤵���ȡ��ǰ��Ԫ�Ŷξ���淶
	 * @param fromOrder ���񹤵�
	 * @param fromUpdbm ��������
	 * @param fromUpdcpm ����������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdbpmOffice getSFUpdbpmOffice(IOVOrderPentium fromOrder,
			ISystemTemplate.IUpdbpmOffer fromUpdbm, 
            IOVUpdbpmOffer fromUpdcpm, 
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��������ģ���Ų�ѯ�������̶���
	 * @param aWORKFLOW ���񼤻�����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IUpdbpmOffer getSFUpdbmBpel( String aWORKFLOW ) throws SFException,Exception;
	/**
	 * ���ݶ��������ѯ����������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbpmOffer getSFUpdbmBpel( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IUpdcContext aContext )  throws SFException,Exception;
	/**
	 * ��ɷ��񼤻�������й�ϵ
	 * @param fromOrder
	 * @param fromUpdbpm
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbmDepend( IOVOrderPentium fromOrder , 
			java.util.List fromUpdbpm ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��񶨵����շ��񼤻����̲�ַ�������
	 * @param fromOrder ���񶨵�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
     * �������̶�����ɷ��񶨵����̵���[��ͨ������ֹ���]
     * @param fromOrder ���񶨵�
     * @param aContext
     * @throws SFException
     * @throws Exception
     */
    public void finishSFUpdbpm( IOVOrderPentium fromOrder[] , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �������̱�Ų�ֵ��ȹ���
	 * @param fromOrder ���񶨵�
	 * @param fromOffer �����Ʒ����
	 * @param aWORKFLOW ���񼤻�����
	 * @param fromUpdcpm ����������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbm( IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			String aWORKFLOW,
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݵ�ǰ�쳣���񶩵�������ɷ��񶩵��쳣�ع����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK  ���񶨵�����
	 * @param fromUpdcmpt �쳣�ص����
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmException( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			IOVUpdcpmOffer fromUpdcmpt,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݵ�ǰ�������񵥲�ַ��񹤵����쳣��������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdcpm �쳣�������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmCompensate( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ݵ�ǰ���񶨵��������쳣�ع�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmRollBack( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * �������̶������������������������̶�������
	 * @param fromOrder ���񶨵�
	 * @param fromOffer �����Ʒ����
	 * @param fromUpdbm ������������
	 * @param fromUpdcpm �������̶���
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			ISystemTemplate.IUpdbpmOffer fromUpdbm, 
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��������ģ������������̶��������嵥
	 * @param fromOrder ���񶨵�
	 * @param fromUpdbpm ����ģ��
	 * @param fromUpdcpm �������̶���
	 * @param fromINDEX ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
    		IProfessionalTemplate.IUpdbpmOffer fromUpdbpm,
    		IOVUpdbpmOffer fromUpdcpm,
    		IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ������ɿ�ͨ��Ԫ���
	 * @param fromOrder ���񶩵�
	 * @param fromOffer ���񶩹�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
    		IOVOfferPentium fromOffer,
    		IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �������̼����Ե��̱߳�����
	 * @param fromOrder ���񶨵�
	 * @param fromUpdbm �������̹淶
	 * @param fromUpdcpm �������̶���
	 * @param fromUpdspm ���̼�����
	 * @param fromVariable ���̼�����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbmOffer(IOVOrderPentium fromOrder,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm,
			java.util.Map fromUpdspm,
			Object fromVariable[][],
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݷ��񼤻���������淶��ɼ�������������ͨ���ƥ��[���񼤻����̲��]
	 * @param fromOrder  ���񶨵�
	 * @param fromOffer  �����Ʒ����
	 * @param fromUpdbm �����������
	 * @param fromUpdcpm �������̶���
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmDefault(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			ISystemTemplate.IUpdbpmOffer fromUpdbm, 
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ݷ��񼤻���������淶��ɼ��������̲��ƥ��[���񼤻����̲��]
	 * @param fromOrder ���񶨵�
	 * @param fromOffer �����Ʒ����
	 * @param fromUpdbm �����������
	 * @param fromUpdcpm �������̶���
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmSubFlow(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ���ݷ��񼤻���������淶��ɼ����߼�����������ƥ��[���񼤻����̲��]
	 * @param fromOrder ���񶨵�
	 * @param fromOffer �����Ʒ����
	 * @param fromUpdbm �����������
	 * @param fromUpdcpm �������̶���
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFUpdbmOffice(IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
			ISystemTemplate.IUpdbpmOffer fromUpdbm,
			IOVUpdbpmOffer fromUpdcpm,
			IUpdcContext aContext) throws SFException,Exception;
}
