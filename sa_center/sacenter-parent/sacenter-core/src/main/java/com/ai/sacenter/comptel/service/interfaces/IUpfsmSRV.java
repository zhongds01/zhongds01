package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫӳ��ӿڷ���</p>
 * <p>Copyright: Copyright (c) 2014-4-10</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfsmSRV {
	/**
	 * ����ӳ��ģ�������Ԫģ��ӳ��
	 * @param fromMODULE ӳ��ģ��
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmc( String fromMODULE , 
			java.util.Map fromOffer , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ����ӳ�䵥Ԫ�����Ԫģ��ӳ��
	 * @param fromUpfgsmc ӳ�䵥Ԫ
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmc( IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ����ӳ�䵥Ԫ�б������Ԫģ��ӳ��
	 * @param fromUpfgsm ӳ��ģ��
	 * @param fromCOMPETE ӳ�䵥Ԫ 
	 * @param fromOffer ��������
	 * @param fromUpfwm ӳ����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgsmc(IPlatformTemplate.IUpffsmOffer fromUpfgsm,
			java.util.List fromCOMPETE,
			java.util.Map fromOffer, 
			IOVUpfgsmCatalog fromUpfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ����ӳ�䵥Ԫ�����Ԫģ��ӳ��
	 * @param fromUpfgsm ӳ��ģ��
	 * @param fromUpfgsmc ӳ�䵥Ԫ
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfgsmc( IPlatformTemplate.IUpffsmOffer fromUpfgsm, 
			IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			java.util.Map aMAPPINGS, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * �����Ԫģ��ӳ������
	 * @param fromMODULE ӳ��ģ��
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmOffer(String fromMODULE,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ģ��ӳ������
	 * ��aMODULE��Ϊ����aMODULEģ��ӳ��,����aMODULE��Ԫ��ӳ��
	 * @param fromMODULE ӳ��ģ��
	 * @param fromUpfgsmc ӳ�䵥Ԫ
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmOffer( String fromMODULE,
			IPlatformTemplate.IUpffgsmOffer fromUpfgsmc,
			java.util.Map fromOffer, 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݷ��񼤻��������ģ��ӳ������
	 * @param fromMODULE ����ӳ��ģ��
	 * @param fromUpfgsmc ���񼤻�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmOffer( String fromMODULE,
			Object fromUpfgsmc,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * �����ԪӦ��ӳ������
	 * @param fromMODULE ӳ��ģ��
	 * @param fromUpfwm ��ԪӦ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishASKUpfwmOffer( String fromMODULE,
			Object fromUpfwm, 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ӳ���ļ�ת����ӳ�伯
	 * @param aFILE ӳ���ļ�
	 * @throws SFException
	 * @throws Exception
	 */
	public void deployUpffsmOracle( String aFILE ) throws SFException, Exception; 
	/**
	 * ӳ�伯ת��Ϊ�ļ�
	 * @param aMODULE ģ������
	 * @param rootFilePath Ҫ�����ļ��ĸ�·��
	 * @throws SFException
	 * @throws Exception
	 */
	public void deployUpffsmFile( String aMODULE , String rootFilePath ) throws SFException, Exception;
}
