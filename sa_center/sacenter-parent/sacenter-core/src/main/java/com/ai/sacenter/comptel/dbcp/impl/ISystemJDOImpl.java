package com.ai.sacenter.comptel.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.ISystemKernelImpl;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��3��28��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ISystemJDOImpl extends ISystemKernelImpl {
	public ISystemJDOImpl() {
		super();
	}
	
	/**
	 * ���������ʽC=1;U=1��ת��Ϊ����ֵ 
	 * @param aCOMPETE 
	 * @param aCOMPLEX
	 * @return
	 */
	public String getMULTLE( String aCOMPETE, String aCOMPLEX ){
		StringBuilder fromMultle = new StringBuilder();
		try
		{
			if( StringUtils.isBlank( aCOMPETE ) == false && 
					ClassUtils.IClass.isNULL( aCOMPETE ) == false ){
				String fromArray[] = UpdcpUtils.ICustom.batchx( aCOMPETE );
				for(int index = 0 ; fromArray != null && index < fromArray.length ; index++){
					String fromColum[] = StringUtils.wildcardArray( fromArray[index], "=");
					if( fromColum.length <= 1 ){ ExceptionFactory.throwJeval("IOS0011001", new String[]{ 
							ClassUtils.getINDEX( new String[]{aCOMPETE,"," ,fromArray[index] })} );
					}
					Object fromUpffmx = fromColum[1];
					if( ClassUtils.IClass.isNULL( aCOMPLEX ) == false && StringUtils.isBlank( aCOMPLEX ) == false ){
						fromUpffmx = UpfgsmUtils.IUpfsm.IIUpfsm._jj_splite( fromColum[1] , aCOMPLEX );
					}
					if( fromUpffmx != null ){
						if( fromMultle.length() > 0 ) fromMultle.append(";");
						fromMultle.append( fromColum[0] ).append( "=" ).append( fromUpffmx );
					}
				}
			}
		}
		finally{

		}
		return fromMultle != null && fromMultle.length() > 0?fromMultle.toString():null;
	}
	
	/**
	 * ���������ʽC=1;U=1��ת��Ϊ����ֵ[�������ֵΪaMAPPING]
	 * @param aCOMPETE
	 * @param aCOMPLEX
	 * @param aMAPPING
	 * @return
	 */
	public String getMULTLE( String aCOMPETE, String aCOMPLEX, String aMAPPING ){
		String fromDepend = null;
		try
		{
			String fromMultle = getMULTLE( aCOMPETE, aCOMPLEX );
			if( fromMultle != null && StringUtils.isBlank( aMAPPING ) == false && 
					ClassUtils.IClass.isNULL( aMAPPING ) == false ){
				fromDepend = aMAPPING;
			}
		}
		finally{
			
		}
		return fromDepend;
	}
	
	/**
	 * 
	 * @param fromPARA
	 * @param fromOffer
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List getSUBJECT( String fromPARA, java.util.HashMap fromOffer, IUpdcContext aContext ) throws SFException,Exception{
		java.util.List fromSubJect = null;
		try
		{
			String _param_num = ClassUtils.getINDEX( new String[]{ fromPARA, "_NUM" } );
			if( fromOffer.get( _param_num ) != null ){
				int _para_num = Integer.parseInt( (String)fromOffer.get( _param_num ) );
				for( int _index = 0; _para_num > 0 && _index < _para_num; _index++ ){
					String _para_name = (String)fromOffer.get( ClassUtils.getINDEX( new String[]{ fromPARA, "_NAME_", String.valueOf( _index + 1 ) } ) );
					String _para_value = (String)fromOffer.get( ClassUtils.getINDEX( new String[]{ fromPARA, "_VALUE_", String.valueOf( _index + 1 ) } ) );
					if( _para_name == null || _para_value == null ){ continue; }
					if( fromSubJect == null ){ fromSubJect = new java.util.ArrayList(); }
					fromSubJect.add( new java.util.HashMap() );
					((java.util.Map)fromSubJect.get( fromSubJect.size() - 1 ) ).put( _para_name, _para_value );
				}
			}
		}
		finally{
			
		}
		return fromSubJect;
	}
	
	/**
	 * ������Ԫ�������ù淶������Ԫ�����б�
	 * ��ʽΪPARAM_NUM=2;PARAM_NAME_1=USER_TYPE;PARAM_VALUE_1=1;PARAM_NAME_1=QTCL;PARAM_VALUE_1=1;
	 * @param fromPLMMX Э��ģ�����
	 * @param fromPARA ��Ԫ����ͷ
	 * @param fromPLMX ��Ԫ�����б�
	 * @param fromOffer ���񶩹���
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String getSUBJECT( String fromPLMMX, String fromPARA, String fromPLMX, java.util.HashMap fromOffer, IUpdcContext aContext ) throws SFException,Exception{
		java.util.Map fromUpfwm = new java.util.HashMap();
		try
		{
			ClassUtils.IMerge.merge( fromOffer, fromUpfwm );
			fromUpfwm.put( "SUBJECT", fromPARA );
			fromPLMMX = IUpdcpFactory.getIUpfvmSV().finishSFUpdbrfChain(fromPLMMX, 
					fromPLMX, 
					fromPLMMX, 
					fromUpfwm, 
					aContext);
		}
		finally{
			if( fromUpfwm != null ){ fromUpfwm.clear(); fromUpfwm = null; }
		}
		return fromPLMMX;
	}
	
	/**
	 * ������Ԫ�����б�������Ԫ��Ӧ����
	 * ��ʽΪPARAM_NUM=2;PARAM_NAME_1=USER_TYPE;PARAM_VALUE_1=1;PARAM_NAME_1=QTCL;PARAM_VALUE_1=1;
	 * @param fromPLMMX Э��ģ�����
	 * @param fromPARA ��Ԫ����ͷ
	 * @param fromOffer ���񶩹���
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String getSUBJECT( String fromPLMMX, String fromPARA, java.util.HashMap fromOffer, IUpdcContext aContext ) throws SFException,Exception{
		String fromPLMM = null;
		java.util.Map fromUpfwm = new java.util.HashMap();
		try
		{
			String fromPARAM = ClassUtils.getINDEX( new String[]{ fromPARA, "_NUM" } );
			if( fromOffer.get( fromPARAM ) != null ){
				int fromPARANUM = Integer.parseInt( (String)fromOffer.get( fromPARAM ) );
				for( int fromINDEX = 0; fromINDEX < fromPARANUM; fromINDEX++ ){
					String fromPARANAME = ClassUtils.getINDEX( new String[]{ fromPARA, "_NAME_" , 
							String.valueOf( fromINDEX + 1 ) } );
					String fromPARAVALUE = ClassUtils.getINDEX( new String[]{ fromPARA, "_VALUE_" , 
							String.valueOf( fromINDEX + 1 ) } );
					fromUpfwm.put( fromOffer.get( fromPARANAME ), fromOffer.get( fromPARAVALUE ) );
				}
				fromPLMM = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmChain(fromPLMMX, 
						fromPLMMX, 
						fromOffer, 
						fromUpfwm, 
						aContext);
			}
		}
		finally{
			if( fromUpfwm != null ){ fromUpfwm.clear(); fromUpfwm = null; }
		}
		return fromPLMM;
	}
	
	/**
	 * ���ݲ�Ʒ��Ų�ѯ�������[�粻���ڲ�Ʒ�淶�򷵻ز�Ʒ���,���򷵻ط������]
	 * @param aCOMPETE_ID ��Ʒ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object getCOMPETE( Object aCOMPETE_ID ) throws SFException,Exception{
		Object aCOMPETE = null;
		try
		{
			Object fromUpdfmx = getCOMPETE( aCOMPETE_ID, null );
			aCOMPETE = fromUpdfmx != null?fromUpdfmx.toString():aCOMPETE_ID;
		}
		finally{
			
		}
		return aCOMPETE;
	}
	
	/**
	 * ���ݲ�Ʒ��Ų�ѯ�������[��aCOMPETE_XΪNULL��[�粻���ڲ�Ʒ�淶�򷵻ز�Ʒ���,���򷵻ط������]�������·����Ӧ��������ֵ]
	 * @param aCOMPETE ��Ʒ���
	 * @param aCOMPLEX ����·��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object getCOMPETE( Object aCOMPETE, String aCOMPLEX ) throws SFException,Exception{
		Object fromUpdfmx = null;
		try
		{
			if( aCOMPETE != null && StringUtils.isBlank( aCOMPETE.toString() ) == false ){
				IProfessionalTemplate.IProductOffer fromUpdcpm = null;
				fromUpdcpm = UpdcpUtils.ISystem.getCOMPETE( aCOMPETE.toString() );
				if( aCOMPLEX == null ){
					fromUpdfmx = fromUpdcpm != null?fromUpdcpm.getCOMPETE():aCOMPETE;
				}
				else if( aCOMPLEX != null && fromUpdcpm != null ){
					fromUpdfmx = ReflectUtils.xPath( aCOMPLEX, fromUpdcpm );
				}
			}
		}
		finally{
			
		}
		return fromUpdfmx;
	}
	
	/**
	 * ���ݲ�Ʒ��Ų�ѯ�������[��aCOMPETE_XΪNULL��[�粻���ڲ�Ʒ�淶�򷵻ز�Ʒ���,���򷵻ط������]�������·����Ӧ��������ֵ]
	 * @param aCOMPETE ��Ʒ���
	 * @param aCOMPLEX ����·��
	 * @param aDEFAULT Ĭ��ֵ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object getCOMPETE( Object aCOMPETE, String aCOMPLEX, String aDEFAULT ) throws SFException,Exception{
		Object fromUpffmx = null;
		try
		{
			Object fromUpdfmx = getCOMPETE( aCOMPETE, aCOMPLEX );
			fromUpffmx = fromUpdfmx != null?fromUpdfmx:( aDEFAULT != null?aDEFAULT:null );
		}
		finally{
			
		}
		return fromUpffmx;
	}
	
	/**
	 * ����ö��ֵ��ö������ת��ö��Ĭ��ֵ
	 * @param aSTATIC ö��ֵ
	 * @param aGROUP ö������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String getENUM( String aSTATIC, String aGROUP ) throws SFException,Exception{
		String fromUpffmx = null;
		try
		{
			ISystemTemplate.IEnumWrapper fromEnum = null;
			if( StringUtils.isBlank( aSTATIC ) ){ aSTATIC = "NULL"; }
			fromEnum = UpdcpUtils.ISystem.getENUM( aGROUP, aSTATIC );
			if( fromEnum != null ){ fromUpffmx = fromEnum.getTARGET(); }
		}
		finally{
			
		}
		return fromUpffmx;
	}
	
	/**
	 * ����ö��ֵ��ö������ת��ö��Ĭ��ֵ
	 * @param aSTATIC ö��ֵ
	 * @param aGROUP ö������
	 * @param aDEFAULT ȱʡֵ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String getENUM( String aSTATIC, String aGROUP, String aDEFAULT ) throws SFException,Exception{
		String fromUpffmx = null;
		try
		{
			fromUpffmx = getENUM( aSTATIC, aGROUP );
			if( fromUpffmx == null && aDEFAULT != null ){ fromUpffmx = aDEFAULT; }
		}
		finally{
			
		}
		return fromUpffmx;
	}
}
