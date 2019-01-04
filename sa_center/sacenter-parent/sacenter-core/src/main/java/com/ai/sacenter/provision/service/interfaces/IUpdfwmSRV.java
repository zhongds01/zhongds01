package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.dbcp.IUpfwmProtocol;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ����������</p>
 * <p>Copyright: Copyright (c) 2013-7-24</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdfwmSRV {
	/**
	 * ������Ԫָ������ѯ��Ԫָ��
	 * @param aPLATFORM ��Ԫ����
	 * @param aDIRECTIVE ��Ԫָ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdspmLife getSFUpdfwm(String aPLATFORM,
			String aDIRECTIVE,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ��ɷ��񶨵����񵥹�����Ԫָ�����ʵ��
	 * @param fromOrder ���̶���
	 * @param fromTASK ���̶�������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdspmLife getSFUpdfwm( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �����ָ�����񵥹��������ָ����������ִ��
	 * @param fromOrder ���̶���
	 * @param fromTASK ���̶�������
	 * @param fromUpdfwm ��Ԫָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List getSFUpdfwm( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ������񵥹�����������ִ��
	 * @param fromUpfwm ��Ԫ����
	 * @param aContext   
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdspmLife getSFUpdfwm( IOVUpfwmOffer fromUpfwm , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������Ԫ����������ָ�
	 * @param fromUpfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdspmLife getASKUpdfwm( IOVUpfwmOrder fromUpfwm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������Ԫ����ָ��淶��Ԫ����ָ����
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ�
	 * @param fromOffer ����������
	 * @param fromINDEX ��Ԫָ������
	 * @param fromUpdgm ��Ԫָ���б�
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdfwmBpel( Object fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			java.util.Map fromOffer,
			java.util.Map fromINDEX,
			java.util.List fromUpdgm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ������Ԫָ����빹����Ԫָ�
	 * @param fromUpfwm ��Ԫ��������
	 * @param fromUpdfwm ��Ԫָ�����
	 * @param fromUpfm ��Ԫ������Ϣ
	 * @param fromOffer ����������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List getSFUpdfwm(Object fromUpfwm,
			IPlatformTemplate.IUpffmDirective fromUpdfwm , 
			IPlatformTemplate.IUpffmOffer fromUpfm,
			java.util.Map fromOffer,
			IUpdcContext aContext )throws SFException,Exception;
	/**
	 * ���ݷ��񶩵�����������̼���Ԫָ�����
	 * @param fromOrder ���񶩵�
	 * @param fromTASK ���񶩵�����
	 * @param fromUpdfwm ��Ԫָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwm( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ����쳣��������������̼���Ԫָ��[��Ԫ�������ڴ���]����
	 * @param fromOrder �����쳣����
	 * @param fromTASK �����쳣��������
	 * @param fromUpdfwm ��Ԫָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfmc( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ�����Ԫ���������Ԫָ�����(��������Ԫ���ױ��ĳ���)
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwm( IOVUpfwmOffer fromUpfwm , 
			IOVUpdspmLife fromUpdfwm , 
			IUpdcContext aContext ) throws SFException,Exception; 
	/**
	 * ������Ԫ�����������ԪЭ��Ϊָ����Ƚ���
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ��Ԫ����ָ�
	 * @param aContext
	 * @return ��Ԫָ�����
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpdfwm(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	
    /**
     * ���ݵ�ǰ��Ԫ��ѯ��ǰ��ԪЭ��ͨ��
     * @param fromUpfm ��Ԫ��Ϣ
     * @return
     * @throws SFException
     * @throws Exception
     */
    public IUpfwmProtocol getSFUpfwmProtocol( IPlatformTemplate.IUpffmOffer fromUpfm ) throws SFException, Exception;
	/**
	 * ���������������Ԫ��ָ���
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ��Ԫָ�
	 * @param aContext
	 * @return ������Ԫ�������ݰ�
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmRequest finishRQKUpfwm( IOVUpfwmOffer fromUpfwm ,
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * �������ԪЭ�鱨�Ľ���
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpdfwm ��Ԫָ�
	 * @param fromREQ ��Ԫ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishBPKUpfwm( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmRequest fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * �������������Ԫ�ⷴ�����ķ���
	 * @param fromUpfwm �����
	 * @param fromUpdfwm ��Ԫָ�
	 * @param fromRsBody ��Ԫ������
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishASKUpfwm( IOVUpfwmOffer fromUpfwm ,
			IOVUpdspmLife fromUpdfwm, 
			Object fromRsBody,
			IUpdcContext aContext) throws SFException, Exception;
}
