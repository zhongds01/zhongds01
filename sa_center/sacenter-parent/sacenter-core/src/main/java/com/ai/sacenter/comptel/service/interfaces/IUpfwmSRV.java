package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ����ģ�����</p>
 * <p>Copyright: Copyright (c) 2014-12-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmSRV {
	/**
	 * ����ӳ�����Ժͷ�����������ģ��������
	 * @param fromUpfwm ӳ�䵥Ԫ
	 * @param fromOffer ��������
	 * @param fromUpfgsm ��Ԫ����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map getSFUpdbmChain( Object fromUpfwm,
			java.util.Map fromOffer,
			java.util.Map fromUpfgsm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �������Ա��ʽ������ʽ�����嵥
	 * @param fromJEXP ���Ա��ʽ
	 * @param fromOffer ��������
	 * @param fromUpfgsm ת������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map finishSFUpdbmChain(String fromJEXP , 
			java.util.Map fromOffer , 
			java.util.Map fromUpfgsm ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݹ淶���ʽ������������ӳ��淶
	 * @param fromCOMPLEX ������ʽ
	 * @param fromOffer ����������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfvnChain(String fromCOMPLEX,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����ģ��ӳ�䵥Ԫת���������嵥
	 * @param fromUpffxm ģ��ӳ�䵥Ԫ
	 * @param fromOffer ����������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpdbmOffer( ISystemTemplate.IUpfgsmxOffer fromUpffxm,
			java.util.Map fromOffer ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����ӳ�����ת���������嵥
	 * @param fromUpffwm ӳ�����
	 * @param fromOffer ��������
	 * @param fromUpfgsm ӳ������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map finishSFUpdbmOffer( IProgramTemplate.IUpdffsmOffer fromUpffwm,
			java.util.Map fromOffer ,
			java.util.Map fromUpfgsm ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����ӳ��ģ��ת���������嵥
	 * @param fromMODULE  ģ�����
	 * @param fromOffer ��������
	 * @param fromUpfwm ӳ������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map finishSFUpdbmOffer( String fromMODULE ,
			java.util.Map fromOffer ,
			java.util.Map fromUpfwm ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����Э��ģ�����������˻���������
	 * @param fromID     ģ����,�������쳣Ψһ����
	 * @param fromFILE   ģ������  
	 * @param fromPROTOCOL ģ������ 
	 * @param fromOffer  ��������
	 * @param fromUpfgsm ��Ԫ����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( String fromID,
			String fromFILE,
			String fromPROTOCOL, 
			java.util.Map fromOffer,
			java.util.Map fromUpfgsm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����ģ���������ģ��淶����
	 * @param fromID     ģ����,�������쳣Ψһ����
	 * @param fromMODULE ģ�����  
	 * @param fromOffer  ��������
	 * @param fromUpfgsm ��Ԫ����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( String fromID,
			String fromMODULE, 
			java.util.Map fromOffer,
			java.util.Map fromUpfgsm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����ģ���������ģ��淶����
	 * @param fromMODULE ģ�����  
	 * @param fromOffer  ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( String fromMODULE,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����ӳ�䵥Ԫ����˻�ģ��ӳ��
	 * @param fromUpfgsm ӳ�䵥Ԫ
	 * @param fromUpfgsmc ����ӳ�䵥Ԫ
	 * @param fromOffer ��������
	 * @param fromUpfsm ӳ������
	 * @param fromPROTOCOL ģ�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( IPlatformTemplate.IUpffgsmOffer fromUpfgsm,
			IPlatformTemplate.IUpffgsmOffer fromUpfgsmc[],
			java.util.Map fromOffer,
			java.util.Map fromUpfsm,
			String fromPROTOCOL,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ����ӳ�䵥Ԫ����˻�ģ��ӳ��
	 * @param fromMODULE ӳ��ģ��
	 * @param fromUpfgsm ӳ�䵥Ԫ
	 * @param fromOffer ��������
	 * @param fromPROTOCOL ģ�����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( String fromMODULE , 
			IPlatformTemplate.IUpffgsmOffer fromUpfgsm,
			java.util.Map fromOffer,
			String fromPROTOCOL,
			IUpdcContext aContext ) throws SFException, Exception;
}
