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
 * <p>Copyright: Copyright (c) 2017年3月28日</p>
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
	 * 根据适配格式C=1;U=1等转换为属性值 
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
	 * 根据适配格式C=1;U=1等转换为属性值[如存在则值为aMAPPING]
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
	 * 根据网元属性配置规范生产网元属性列表
	 * 格式为PARAM_NUM=2;PARAM_NAME_1=USER_TYPE;PARAM_VALUE_1=1;PARAM_NAME_1=QTCL;PARAM_VALUE_1=1;
	 * @param fromPLMMX 协议模板编码
	 * @param fromPARA 网元属性头
	 * @param fromPLMX 网元属性列表
	 * @param fromOffer 服务订购集
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
	 * 根据网元属性列表生产网元对应报文
	 * 格式为PARAM_NUM=2;PARAM_NAME_1=USER_TYPE;PARAM_VALUE_1=1;PARAM_NAME_1=QTCL;PARAM_VALUE_1=1;
	 * @param fromPLMMX 协议模板编码
	 * @param fromPARA 网元属性头
	 * @param fromOffer 服务订购集
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
	 * 根据产品编号查询服务编码[如不存在产品规范则返回产品编号,否则返回服务编码]
	 * @param aCOMPETE_ID 产品编号
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
	 * 根据产品编号查询服务编码[如aCOMPETE_X为NULL则[如不存在产品规范则返回产品编号,否则返回服务编码]否则变量路径对应服务属性值]
	 * @param aCOMPETE 产品编号
	 * @param aCOMPLEX 变量路径
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
	 * 根据产品编号查询服务编码[如aCOMPETE_X为NULL则[如不存在产品规范则返回产品编号,否则返回服务编码]否则变量路径对应服务属性值]
	 * @param aCOMPETE 产品编号
	 * @param aCOMPLEX 变量路径
	 * @param aDEFAULT 默认值
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
	 * 根据枚举值和枚举类型转换枚举默认值
	 * @param aSTATIC 枚举值
	 * @param aGROUP 枚举类型
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
	 * 根据枚举值和枚举类型转换枚举默认值
	 * @param aSTATIC 枚举值
	 * @param aGROUP 枚举类型
	 * @param aDEFAULT 缺省值
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
