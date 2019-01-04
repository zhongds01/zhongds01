package com.ai.sacenter.i18n;

import com.ai.appframe2.util.locale.ICustomLocaleResource;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ��ͨ����������Դ</p>
 * <p>Copyright: Copyright (c) 2017��5��22��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdfxResource extends ICustomLocaleResource {
	/**
	 * ������Դ�����ȡAPP�������Դ[���쳣������Ĭ�Ϲ�����Դ]
	 * @param resource
	 * @param args
	 * @return
	 */
	public String getLocal( String resource, Object args[] );
	
	/**
	 * ��ȡ��ǰ�������� 
	 * @return
	 */
	public java.util.Locale getDefault();
	
	/**
	 * ������Դ�����ȡ������Դ�淶
	 * @param resource ��Դ����
	 * @return
	 */
	public ISystemTemplate.IUpfgkmResource getDefault( String resource );
	
	/**
	 * ������Դ�����ȡ������Դ[���쳣������Ĭ�Ϲ�����Դ]
	 * @param resource ��Դ����
	 * @param args ����
	 * @return
	 */
	public String getDefault( String resource, Object args[] );
	
	/**
	 * ������Դ�����ȡ������Դ[���쳣�����쳣]
	 * @param resource ��Դ����
	 * @param args ����
	 * @return
	 */
	public String getResource( String resource, Object args[] );
	
	/**
	 * �����쳣����ת��Ϊ��ͨ�쳣
	 * @param exception �쳣����
	 * @return
	 */
	public SFException getResource( java.lang.Exception exception );
	
	/**
	 * �����쳣����ת��Ϊ��ͨ�쳣
	 * @param originator ����
	 * @param exception �쳣����
	 * @return
	 */
	public SFException getResource( String originator, java.lang.Exception exception );
	
	/**
	 * �����쳣����ת��Ϊ��ͨ�쳣
	 * @param faultCode ���ʱ���
	 * @param args ���ʲ���
	 * @param exception �쳣����
	 * @return
	 */
	public SFException getResource(String faultCode, Object[] args, java.lang.Exception exception);
	
	/**
	 * �����쳣���ʱ���ת��Ϊ��ͨ�쳣
	 * @param faultCode �쳣���ʱ���
	 * @param args �쳣�������
	 * @param originator ��Ԫ����
	 * @param exception �쳣����
	 * @return
	 */
	public SFException getResource(String faultCode, Object[] args, String originator, java.lang.Exception exception);
	
	/**
	 * �����쳣����ת��Ϊ��ͨ�����쳣
	 * @param exception �쳣����
	 * @param args ����
	 * @return
	 */
	public SFBsException getExtend( java.lang.Exception exception, Object[] args );
}
