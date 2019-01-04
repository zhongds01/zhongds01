package com.ai.sacenter.receive.util;

import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMapMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFObjectMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFOtherMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFRsRspMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFTextMessage;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��3��22��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */

public class RocketUtils {

	public RocketUtils() {
		super();
	}
	
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 
		 * @param message
		 * @return
		 * @throws javax.jms.JMSException
		 * @throws Exception
		 */
		public static RocketFMessage _jj_rocket( javax.jms.Message message ) throws javax.jms.JMSException,Exception{
			RocketFMessage _rocket = null;
			try
			{
				if( message instanceof javax.jms.ObjectMessage ){
					_rocket = new RocketFObjectMessage( message );
					javax.jms.ObjectMessage fromMsgF = (javax.jms.ObjectMessage)message;
					((RocketFObjectMessage)_rocket).setObject( fromMsgF.getObject() );
				}
				else if( message instanceof javax.jms.MapMessage ){
					_rocket = new RocketFMapMessage( message );
					javax.jms.MapMessage fromMsgF = (javax.jms.MapMessage)message;
					for( java.util.Enumeration<String> itera = fromMsgF.getMapNames(); itera.hasMoreElements(); ){
						String fromName = (String)itera.nextElement();
						((RocketFMapMessage)_rocket).getMapMessage().put( fromName, fromMsgF.getObject( fromName ) );
					}
				}
				else if( message instanceof javax.jms.TextMessage ){
					javax.jms.TextMessage fromMsgF = (javax.jms.TextMessage)message;
					_rocket = new RocketFTextMessage( message, fromMsgF.getText() );
					((RocketFTextMessage)_rocket).setText( fromMsgF.getText() );
				}
				else{
					_rocket = new RocketFOtherMessage( message );
				}
				if( _rocket != null ){
					for( java.util.Enumeration<String> itera = message.getPropertyNames(); itera.hasMoreElements(); ){
						String fromEnum = (String)itera.nextElement();
						_rocket.getProperties().put( fromEnum, message.getObjectProperty( fromEnum ) );
					}
				}
			}
			finally{
				
			}
			return _rocket;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static RocketFTextMessage _jj_rocket( RocketFMessage fromRocket ) throws SFException,Exception{
			RocketFTextMessage _rocket = null;
			try
			{
				if( fromRocket == null ){
					ExceptionFactory.throwServiceBody("IOS0011009", new String[]{"IPSCRocket"});
				}
				else if( ( fromRocket instanceof RocketFRsRspMessage ) ){
					RocketFRsRspMessage _response = (RocketFRsRspMessage)fromRocket;
					_rocket = new RocketFTextMessage( _response.getBody() );
					ClassUtils.IMerge.merge( _response.getProperties(), _rocket.getProperties() );
					if( StringUtils.isBlank( _rocket.getText() ) ){
						ExceptionFactory.throwServiceBody("IOS0011009", new String[]{"IPSCRocket"});
					}
				}
				else if( fromRocket instanceof RocketFTextMessage ){
					_rocket = (RocketFTextMessage)fromRocket;
					if( StringUtils.isBlank( _rocket.getText() ) ){
						ExceptionFactory.throwServiceBody("IOS0011009", new String[]{"IPSCRocket"});
					}
				}
				else{
					ExceptionFactory.throwServiceBody( "IOS0011004", new String[]{fromRocket.getClass().getSimpleName()} );
				}
			}
			finally{
				
			}
			return _rocket;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String _jj_message( RocketFMessage fromRocket ) throws SFException,Exception{
			String fromXML = null;
			try
			{
				if( fromRocket instanceof RocketFTextMessage ){
					fromXML = ((RocketFTextMessage)fromRocket).getText();
				}
				else if( fromRocket instanceof RocketFMapMessage ){
					RocketFMapMessage fromMapMessage = (RocketFMapMessage)fromRocket;
					fromXML = fromMapMessage.getMapMessage().toString();
				}
				else if( fromRocket instanceof RocketFRsRspMessage ){
					RocketFRsRspMessage fromRsMessage = (RocketFRsRspMessage)fromRocket;
					fromXML = fromRsMessage.getBody();
				}
			}
			finally{
				
			}
			return fromXML;
		}
		
		public static class ICustomX{
			public ICustomX(){
				super();
			}
		}
	}
	
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		public static class ISystemX{
			public ISystemX(){
				super();
			}
		}
	}
	
	public static class IMetaX{
		public IMetaX(){
			super();
		}
		
		/**
		 * ��ȡXML���ڵ� 
		 * @param element XML�ڵ�
		 * @return
		 */
		public static org.dom4j.Element _jj_root( org.dom4j.Element element ){
			if( element.getParent() == null ) return element;
			return _jj_root( element.getParent() );
		}
		
		/**
		 * ��ȡ��ǰ���ڵ� 
		 * @param element XML�ڵ�
		 * @return
		 */
		public static org.dom4j.Element _jj_parent( org.dom4j.Element element ){
			if( element.getParent() == null ) return element;
			return element.getParent();
		}

		/**
		 * �Ƿ�Ϊnull����ֵΪ��
		 * @param element
		 * @return
		 */
		public static boolean _jj_blank( org.dom4j.Element element ){
			return element == null || StringUtils.isBlank( element.getTextTrim() );
		}
		
		/**
		 * ��ǰ�ڵ��Ƿ����
		 * @param element
		 * @return
		 */
		public static boolean _jj_null( org.dom4j.Element element ){
			return element == null?true:false;
		}
		
		/**
		 * ��ȡ��ǰ�ڵ��쳣��Ϣ[�����嵥{��ǰ���ڵ�,��ǰ�ڵ�,���ڵ�,��ǰ�ڵ�ֵ,�쳣����(ΪNULL��Ϊ���ַ�)}]
		 * @param faultCode �쳣����
		 * @param element XML�ڵ�
		 * @param childname ��ǰ�ڵ�����(����ΪNULL��ǰ�ڵ㲻����,ΪNULL��ڵ����ƶ�Ӧ�ڵ�ֵת������)
		 * @param exception �쳣����
		 * @return
		 */
		public static SFException _jj_fault( String faultCode, org.dom4j.Element element, String childname, java.lang.Exception exception ){
			Object fromArgs[] = null;
			org.dom4j.Element fromRoot = IMetaX._jj_root( element );
			if( childname != null ){
				fromArgs = new String[]{ element.getName(), childname, fromRoot.getName(), 
						"", exception != null?ClassUtils.getINDEX( 
								new String[]{exception.getClass().getName(), "[", 
										exception.getMessage(), "]"}):"" };
			}
			else{
				org.dom4j.Element fromParent = IMetaX._jj_parent( element );
				fromArgs = new String[]{ fromParent.getName(), element.getName(), 
						fromRoot.getName(), element.getTextTrim(), exception != null?
								ClassUtils.getINDEX( new String[]{exception.getClass().getName(), 
										"[", exception.getMessage(), "]"}):"" };
			}
			return ExceptionFactory.getServiceBody( faultCode, fromArgs );
		}
		
		/**
		 * �����ӽڵ����ƻ�ȡ��ǰ�ڵ��Ӧ�ӽڵ�,���ӽڵ㲻�������쳣
		 * @param element ��ǰ�ڵ�
		 * @param childname �ӽڵ�����
		 * @return
		 */
		public static org.dom4j.Element _jj_element( org.dom4j.Element element, String childname ){
			org.dom4j.Element childer = element.element( childname );
			if( _jj_null( childer ) ){
				throw IMetaX._jj_fault("IOS0010007", element, childname, null);
			}
			return childer;
		}
		
		/**
		 * �����ӽڵ����ƻ�ȡ��ǰ�ڵ��Ӧ�ӽڵ�
		 * @param element ��ǰ�ڵ�
		 * @param childname �ӽڵ�����
		 * @param nullable �Ƿ�ɿ�[��Ϊfalseʱ��ǰ�ӽڵ�ֵΪnull�����쳣]
		 * @return
		 */
		public static org.dom4j.Element _jj_element( org.dom4j.Element element, String childname, boolean nullable ){
			org.dom4j.Element childer = element.element( childname );
			if( nullable == false && _jj_null( childer ) ){
				throw IMetaX._jj_fault("IOS0010007", element, childname, null);
			}
			return childer;
		}
		
		/**
		 * 
		 * @param element
		 * @param childname
		 * @return
		 */
		public static java.util.List<org.dom4j.Element> _jj_list( org.dom4j.Element element, String childname ){
			return element.elements( childname );
		}
		
		/**
		 * 
		 * @param element
		 * @param childname
		 * @return
		 */
		public static java.util.Map<Object,Object> _jj_map( org.dom4j.Element element,  String childname ){
			java.util.Map<Object,Object> _bundle = null;
			org.dom4j.Element _element = IMetaX._jj_element( element, childname, false );
			_bundle = XmlUtils.XPath( _element.asXML(), _bundle = new java.util.HashMap<Object,Object>() );
			return _bundle;
		}
		
		/**
		 * 
		 * @param element
		 * @param childname
		 * @param nullable
		 * @return
		 */
		public static java.util.Map<Object,Object> _jj_map( org.dom4j.Element element, String childname, boolean nullable ){
			java.util.Map<Object,Object> _bundle = null;
			org.dom4j.Element _element = IMetaX._jj_element( element, childname, nullable );
			if( _element != null ){
				XmlUtils.XPath( _element.asXML(), _bundle = new java.util.HashMap<Object,Object>() );
			}
			return _bundle;
		}
		
		/**
    	 * ���ݽڵ�ת��Ϊ����
    	 * @param element һ���ڵ�
    	 * @param childname �����ڵ�����
    	 * @return
    	 */
    	public static long _jj_long( org.dom4j.Element element, String childname ){
    		org.dom4j.Element childer = element.element( childname );
    		if( IMetaX._jj_blank( childer ) ){
    			throw IMetaX._jj_fault("IOS0010007", element, childname, null);
    		}
    		try
    		{
    			return Long.parseLong( childer.getTextTrim() );
    		}
    		catch( java.lang.Exception exception ){
    			throw IMetaX._jj_fault("IOS0010033", childer, null , exception );
    		}
    	}
    	
    	/**
    	 * ���ݽڵ�ת��Ϊ����,���ӽڵ㲻���ڻ����Լ��ӽڵ�Ϊ���򷵻�Ĭ��ֵ
    	 * @param element һ���ڵ�
    	 * @param childname �����ڵ�����
    	 * @param _default Ĭ��ֵ
    	 * @return
    	 */
    	public static long _jj_long( org.dom4j.Element element, String childname, long _default ){
    		long __long = _default;
    		org.dom4j.Element childer = element.element( childname );
    		if( IMetaX._jj_blank( childer ) == false ){
    			try
        		{
    				__long = Long.parseLong( childer.getTextTrim() );
        		}
        		catch( java.lang.Exception exception ){
        			throw IMetaX._jj_fault("IOS0010033", childer, null , exception );
        		}
    		}
    		return __long;
    	}
    	
    	/**
    	 * �����ӽڵ��Ӧֵת��Ϊ����
    	 * @param element XML�ڵ�
    	 * @param childname �ӽڵ�����
    	 * @param nullable �Ƿ�ɿ�[��Ϊfalseʱ��ǰ�ӽڵ�ֵΪnull�����쳣]
    	 * @return
    	 */
    	public static long _jj_long( org.dom4j.Element element, String childname, boolean nullable ){
    		org.dom4j.Element childer = element.element( childname );
    		if( nullable == false && IMetaX._jj_blank( childer ) ){
    			throw IMetaX._jj_fault("IOS0010007", element, childname, null);
    		}
    		if( IMetaX._jj_blank( childer ) == false ){
    			try
        		{
        			return Long.parseLong( childer.getTextTrim() );
        		}
        		catch( java.lang.Exception exception ){
        			throw IMetaX._jj_fault("IOS0010033", childer, null , exception );
        		}
    		}
    		return -1;
    	}
    	
    	/**
    	 * ���ݽڵ�ת��Ϊ�ַ���
    	 * @param element XML�ڵ�
    	 * @param childname �ӽڵ�����
    	 * @return
    	 */
    	public static String _jj_string( org.dom4j.Element element, String childname ){
    		org.dom4j.Element childer = element.element( childname );
    		if( IMetaX._jj_null( childer ) ){
    			throw IMetaX._jj_fault("IOS0010007", element, childname, null);
    		}
    		return childer.getTextTrim();
    	}
    	
    	/**
    	 * ���ݽڵ�ת��Ϊ�ַ���,���ӽڵ㲻�����򷵻�Ĭ��ֵ
    	 * @param element XML�ڵ�
    	 * @param childname �ӽڵ�����
    	 * @param _default Ĭ��ֵ
    	 * @return
    	 */
    	public static String _jj_string( org.dom4j.Element element, String childname, String _default ){
    		String __string = _default;
    		org.dom4j.Element childer = element.element( childname );
    		if( IMetaX._jj_null( childer ) == false ){
    			__string = childer.getTextTrim();
    		}
    		return __string;
    	}
    	
    	/**
    	 * �����ӽڵ��Ӧֵת��Ϊ�ַ���
    	 * @param element XML�ڵ�
    	 * @param childname �ӽڵ�����
    	 * @param nullable �Ƿ�ɿ�[��Ϊfalseʱ��ǰ�ӽڵ�ֵΪnull�����쳣]
    	 * @return
    	 */
    	public static String _jj_string( org.dom4j.Element element, String childname, boolean nullable ){
    		org.dom4j.Element childer = element.element( childname );
    		if( nullable == false && IMetaX._jj_blank( childer ) ){
    			throw IMetaX._jj_fault("IOS0010007", element, childname, null);
    		}
    		return childer != null?childer.getTextTrim():null;
    	}
    	
    	/**
    	 * ���ݽڵ�ת��Ϊ������
    	 * @param element ��ǰ�ڵ�
    	 * @param childname �ӽڵ�����
    	 * @return
    	 */
    	public static boolean _jj_boolean( org.dom4j.Element element, String childname ){
    		org.dom4j.Element childer = element.element( childname );
    		if( IMetaX._jj_blank( childer ) ){
    			throw IMetaX._jj_fault("IOS0010007", element, childname, null);
    		}
    		try
    		{
    			return Boolean.parseBoolean( childer.getTextTrim() );
    		}
    		catch( java.lang.Exception exception ){
    			throw IMetaX._jj_fault("IOS0010033", childer, null , exception );
    		}
    	}
    	
    	/**
    	 * �����ӽڵ��Ӧֵת��Ϊ������,���ӽڵ㲻���ڻ����Լ��ӽڵ�Ϊ���򷵻�Ĭ��ֵ
    	 * @param element XML�ڵ�
    	 * @param childname �ӽڵ�����
    	 * @param nullable �Ƿ�ɿ�[��Ϊfalseʱ��ǰ�ӽڵ�ֵΪnull�����쳣]
    	 * @param _default ��ɿ���ȡĬ��ֵ
    	 * @return
    	 */
    	public static boolean _jj_boolean( org.dom4j.Element element, String childname, boolean nullable, boolean _default ){
    		boolean __boolean = _default;
    		org.dom4j.Element childer = element.element( childname );
    		if( nullable == false && IMetaX._jj_blank( childer ) ){
    			throw IMetaX._jj_fault("IOS0010007", element, childname, null);
    		}
    		if( IMetaX._jj_blank( childer ) == false ){
    			try
        		{
    				__boolean = Boolean.parseBoolean( childer.getTextTrim() );
        		}
        		catch( java.lang.Exception exception ){
        			throw IMetaX._jj_fault("IOS0010033", childer, null , exception );
        		}
    		}
    		return __boolean;
    	}
    	
    	/**
    	 * ����ʱ��ڵ�ڵ�ת��Ϊʱ���ʽ
    	 * @param element ��ǰ�ڵ�
    	 * @param childname �ӽڵ�����
    	 * @return
    	 */
    	public static java.sql.Timestamp _jj_timestamp( org.dom4j.Element element, String childname ){
    		org.dom4j.Element childer = element.element( childname );
    		if( IMetaX._jj_blank( childer ) ){
    			throw IMetaX._jj_fault("IOS0010007", element, childname, null);
    		}
    		try
    		{
    			return TimeUtils.getTimestamp( childer.getTextTrim() );
    		}
    		catch( java.lang.Exception exception ){
    			throw IMetaX._jj_fault("IOS0010033", childer, null , exception );
    		}
    	}
    	
    	/**
    	 * ����ʱ��ڵ�ڵ�ת��Ϊʱ���ʽ
    	 * @param element ��ǰ�ڵ�
    	 * @param childname �ӽڵ�����
    	 * @param _default  Ĭ��ֵ(��Ϊnull��ȡĬ��ֵ)
    	 * @return
    	 */
    	public static java.sql.Timestamp _jj_timestamp( org.dom4j.Element element, String childname, java.sql.Timestamp _default ){
    		java.sql.Timestamp __timestamp = _default;
    		org.dom4j.Element childer = element.element( childname );
    		if( IMetaX._jj_blank( childer ) == false ){
    			try
        		{
    				__timestamp = TimeUtils.getTimestamp( childer.getTextTrim() );
        		}
        		catch( java.lang.Exception exception ){
        			throw IMetaX._jj_fault("IOS0010033", childer, null , exception );
        		}
    		}
    		return __timestamp;
    	}
    	
    	/**
    	 * ����ʱ��ڵ�ڵ�ת��Ϊʱ���ʽ
    	 * @param element ��ǰ�ڵ�
    	 * @param childname �ӽڵ�����
    	 * @param nullable �Ƿ�ɿ�[��Ϊfalseʱ��ǰ�ӽڵ�ֵΪnull�����쳣]
    	 * @return
    	 */
    	public static java.sql.Timestamp _jj_timestamp( org.dom4j.Element element, String childname, boolean nullable ){
    		org.dom4j.Element childer = element.element( childname );
    		if( nullable == false && IMetaX._jj_blank( childer ) ){
    			throw IMetaX._jj_fault("IOS0010007", element, childname, null);
    		}
    		if( IMetaX._jj_blank( childer ) == false ){
    			try
        		{
        			return TimeUtils.getTimestamp( childer.getTextTrim() );
        		}
        		catch( java.lang.Exception exception ){
        			throw IMetaX._jj_fault("IOS0010033", childer, null , exception );
        		}
    		}
    		return null;
    	}
    	
		public static class IMetaXX{
			public IMetaXX(){
				super();
			}
		}
	}
	
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
	}
}
