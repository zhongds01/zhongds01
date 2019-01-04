package com.ai.sacenter.jeval;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.jeval.function.FunctionHelper;
import com.ai.sacenter.jeval.function.PreferenceResolver;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: JEVAL������</p>
 * <variable id = "SINGLE" >
 *   <name>�򵥱���,����ΪVMICPIID</name>
 *   <value>��������</value>
 * </variable>
 * <variable id = "PACKAGE">
 *   <name>����·��,��ʽΪ�õ�ŷָ�,����ΪUSER.NATURE.VMICPIID��VMICPIID</name>
 *   <value>�������ͻ�����JAVA����</value>
 * </variable>
 * <variable id = "SYSTEM">
 *   <name>ϵͳ·��,��ʽΪ��\�ָ�,����ΪUSER\NATURE\VMICPIID��VMICPIID</name>
 *   <value>ĩ�˱���[�������ͻ�����JAVA����]</value>
 * </variable>
 * <p>Copyright: Copyright (c) 2017��7��13��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class JevalSTKEngine {
	private JevalEvaluator DEFAULT_FACTORY = new JevalEvaluator();
	public JevalSTKEngine() {
		super();
		DEFAULT_FACTORY.setVariableResolver( new PreferenceResolver() );
	}
	
	/**
	 * ������ֵ���ʽ���������
	 * @param fromOffer �������Լ�
	 * @param aContext
	 * @return
	 * @throws Exception
	 */
	public java.util.HashMap getICTKJevaL( java.util.Map fromOffer, IUpdcContext aContext ) throws Exception{
		java.util.HashMap fromJEVAL = new java.util.HashMap();
		try
		{
			ReflectUtils.getICTKJevaL( new Object[]{fromOffer, aContext}, fromJEVAL);
			ClassUtils.IMerge.merge( new Object[][]{{IUpdcConst.IUpdbm.IUpdbf.PARAM, fromOffer},
				                                    {IUpdcConst.IUpdbm.IUpdbf.LDPAP, aContext  }}, 
				                                    fromJEVAL, false );
		}
		finally{
			
		}
		return fromJEVAL;
	}
	
	/**
	 * 
	 * @return
	 */
	public JevalEvaluator getEvaluator(){
		return DEFAULT_FACTORY;
	}
	
	/**
	 * ��ȡ��ǰ�����б�
	 * @return
	 */
	public java.util.Map getVariables() {
		return DEFAULT_FACTORY.getVariables();
	}
	
	/**
	 * ���ݱ������ƻ�ȡ��ǰ�����б��б���ֵ
	 * @param variableName ��������
	 * @return
	 * @throws Exception
	 */
	public Object getVariable( final String variableName ) throws Exception{
		Object _variableValue = null;
		EvaluationResult _result = null;
		try
		{
			if( IIfElse.isVariable( variableName ) == false ){
				throw new IllegalArgumentException("The variable name[" + variableName + "] Illegal variable.");
			}
			_variableValue = DEFAULT_FACTORY.getVariable( variableName );
			if( _variableValue != null ){
				_result = new EvaluationResult( _variableValue, DEFAULT_FACTORY.getQuoteCharacter() );
				_variableValue = _result.getAsObject();
			}
		}
		finally{
			if( _result != null ){ _result = null; }
		}
		return _variableValue;
	}
	
	/**
	 * ��ӻ��滻��ǰ�������ж�Ӧ�������Լ�ֵ
	 * @param variableName ��������
	 * @param variableValue ����ֵ
	 */
	public void putVariable(final String variableName, final Object variableValue) {
		try
		{
			if( IIfElse.isVariable( variableName ) == false ){
				throw new IllegalArgumentException("The variable name[" + variableName + "] Illegal variable.");
			}
			if( variableValue != null ){
				ICustom._submit( DEFAULT_FACTORY, variableName, variableValue );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * �ύ��ֵ���ʽ����(ɾ����ǰ�����б�������±����б�)
	 * @param fromJEVAL
	 * @throws Exception
	 */
	public void submitVariables( java.util.Map fromJEVAL ) throws Exception{
		try
		{
			DEFAULT_FACTORY.clearVariables();
			ICustom._submit( DEFAULT_FACTORY , fromJEVAL );
		}
		finally{
			
		}
	}
	
	/**
	 * �ύ��ǰ����������(ɾ����ǰ�����б�������±����б�)
	 * @param fromOffer ��������
	 * @param aContext 
	 * @throws Exception
	 */
	public void submitVariables( java.util.Map fromOffer, IUpdcContext aContext ) throws Exception{
		java.util.Map fromJEVAL = null;
		try
		{
			DEFAULT_FACTORY.clearVariables();
			fromJEVAL = getICTKJevaL( fromOffer, aContext );
			ICustom._submit( DEFAULT_FACTORY, fromJEVAL );
		}
		finally{
			if( fromJEVAL != null ){ fromJEVAL.clear(); fromJEVAL = null; }
		}
	}
	
	/**
	 * ���ݱ�����ɾ����ǰ�����б�
	 * @param variableName ��ɾ��������
	 */
	public void removeVaraible(final String variableName) {
		if( DEFAULT_FACTORY.getVariables().containsKey( variableName ) ){
			DEFAULT_FACTORY.getVariables().remove( variableName );
		}
	}
	
	/**
	 * ɾ�����е�ǰ�����б�
	 */
	public void clearVariables() {
		DEFAULT_FACTORY.clearVariables();
	}
	
	/**
	 * �ж���ֵ�������ʽ(��Ԥ�ñ��ʽ����)�Ƿ����
	 * @param expression ��ֵ���ʽ
	 * @return
	 * @throws Exception
	 */
    public boolean decision( String expression ) throws Exception{
    	boolean aOBJECT = true;
    	try
    	{
    		if( StringUtils.isBlank( expression ) == false ){
    			String _boolean = ICustom._evaluate(DEFAULT_FACTORY, expression);
    			aOBJECT = ICustom._IfElse(expression, _boolean);
    		}
    	}
    	finally{
    	
    	}
    	return aOBJECT;
    }
    
	/**
	 * �ж���ֵ�������ʽ(������ֵ���ʽ�����ع�)�Ƿ����
	 * @param expression ��ֵ���ʽ
	 * @param fromOffer �������Լ�
	 * @param aContext
	 * @return
	 * @throws Exception
	 */
    public boolean decision( String expression, java.util.Map fromOffer, IUpdcContext aContext ) throws Exception{
    	boolean aOBJECT = false;
    	java.util.Map fromJEVAL = null;
    	try
    	{
    		DEFAULT_FACTORY.clearVariables();
    		fromJEVAL = getICTKJevaL( fromOffer, aContext );
    		String _boolean = ICustom._evaluate(DEFAULT_FACTORY, expression, fromJEVAL );
    		aOBJECT = ICustom._IfElse( expression, _boolean );
    	}
    	finally{
    		if( fromJEVAL != null ){ fromJEVAL.clear(); fromJEVAL = null;}
    	}
    	return aOBJECT;
    }
    
    /**
     * �ж���ֵ�������ʽ�Ƿ����
     * @param expression ��ֵ���ʽ
     * @param fromJEVAL ���������
     * @return
     * @throws Exception
     */
    public boolean decision( String expression, java.util.Map fromJEVAL ) throws Exception{
    	boolean aOBJECT = false;
    	try
    	{
    		DEFAULT_FACTORY.clearVariables();
        	String _boolean = ICustom._evaluate(DEFAULT_FACTORY, expression , fromJEVAL );
        	aOBJECT = ICustom._IfElse( expression, _boolean );
        }
    	finally{
    		
    	}
    	return aOBJECT;
    }
    
    /**
	 * ������ֵ�������ʽ(��Ԥ�ñ��ʽ����)
	 * @param expression ��ֵ���ʽ
	 * @return
	 * @throws Exception
	 */
	public String evaluate ( String expression ) throws Exception{
		String aOBJECT = null;
		try
		{
			if( StringUtils.isBlank( expression ) == false ){
				aOBJECT = ICustom._evaluate(DEFAULT_FACTORY, expression);
				aOBJECT = ICustom._transfer( aOBJECT );
			}
		}
		finally{
			
		}
		return aOBJECT;
	}
	
	/**
	 * ������ֵ�������ʽ
	 * @param expression ��ֵ���ʽ
	 * @param fromJEVAL ���������
	 * @return
	 * @throws Exception
	 */
	public String evaluate( String expression, java.util.Map fromJEVAL ) throws Exception{
		String aOBJECT = "";
		try
		{
			DEFAULT_FACTORY.clearVariables();
			aOBJECT = ICustom._evaluate(DEFAULT_FACTORY, expression, fromJEVAL);
		    aOBJECT = ICustom._transfer( aOBJECT );  
	    }
	    finally{
		   
	    }
	    return aOBJECT;
	}
	
	/**
	 * 
	 * @param aJEXP
	 * @param fromJEVAL
	 * @return
	 * @throws Exception
	 */
	public String arguments( String expression, java.util.Map fromJEVAL ) throws Exception{
		String aOBJECT = "";
		try
		{
			DEFAULT_FACTORY.clearVariables();
			aOBJECT = ICustom._evaluate(DEFAULT_FACTORY, expression, fromJEVAL);
			aOBJECT = ICustom._arguments( aOBJECT );
	    }
	    finally{
		   
	    }
	    return aOBJECT;
	}
	
    /**
     * ������ֵ�������ʽ(������ֵ���ʽ�����ع�)
     * @param aJEXP ��ֵ���ʽ
     * @param fromOffer ���̶������Լ�
     * @param aContext
     * @return
     * @throws Exception
     */
	public String evaluate( String expression, java.util.Map fromOffer, IUpdcContext aContext ) throws Exception{
    	String aOBJECT = "";
    	java.util.Map fromJEVAL = null;
    	try
    	{
    		DEFAULT_FACTORY.clearVariables();
    		fromJEVAL = getICTKJevaL( fromOffer, aContext );
    		aOBJECT = ICustom._evaluate(DEFAULT_FACTORY, expression, fromJEVAL);
    		aOBJECT = ICustom._transfer( aOBJECT );
    	}
    	finally{
    		if( fromJEVAL != null ){fromJEVAL.clear(); fromJEVAL = null;}
    	}
    	return aOBJECT;
    }
	
	/**
     * ������ֵ�������ʽ(������ֵ���ʽ�����ع�)
     * @param expression ��ֵ���ʽ
     * @param fromOffer ���̶������Լ�
     * @param aContext
     * @return
     * @throws Exception
     */
	public String arguments( String expression, java.util.Map fromOffer, IUpdcContext aContext ) throws Exception{
    	String aOBJECT = "";
    	java.util.Map fromJEVAL = null;
    	try
    	{
    		DEFAULT_FACTORY.clearVariables();
    		fromJEVAL = getICTKJevaL( fromOffer, aContext );
    		aOBJECT = ICustom._evaluate(DEFAULT_FACTORY, expression, fromJEVAL);
    		aOBJECT = ICustom._arguments( aOBJECT );
    	}
    	finally{
    		if( fromJEVAL != null ){fromJEVAL.clear(); fromJEVAL = null;}
    	}
    	return aOBJECT;
    }
	
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
		/**
		 * 
		 * @param name
		 * @return
		 */
		public static boolean isVariable( String name ){
			if( name.length() <= 0 )  return false;
			if (name.indexOf( EvaluationConstants.SINGLE_QUOTE ) > -1 ) return false;
			else if ( name.indexOf( EvaluationConstants.DOUBLE_QUOTE ) > -1 ) return false;
			if (name.indexOf( EvaluationConstants.OPEN_BRACE) > -1)  return false;
			else if (name.indexOf( EvaluationConstants.CLOSED_BRACE) > -1) return false;
			else if (name.indexOf( EvaluationConstants.POUND_SIGN) > -1) return false;
			if ( name.indexOf("!") > -1 ) return false;
			else if (name.indexOf("~") > -1) return false;
			else if (name.indexOf("^") > -1) return false;
			else if (name.indexOf(",") > -1) return false;
			return true;
		}
		
		/**
		 * 
		 * @param variableName
		 * @param variableValue
		 * @return
		 */
		public static boolean isVariable( Object variableName, Object variableValue ){
			return variableName != null && ClassUtils.IClass.isString( variableName ) &&
					IIfElse.isVariable( variableName.toString() ) && variableValue != null;
		}
		
		/**
		 * �Ƿ��������
		 * @param variableValue
		 * @return
		 */
		public static boolean isPrimitive( Object variableValue ){
			return FunctionHelper.isPrimitive( variableValue );
		}
		
		/**
		 * �Ƿ��������
		 * @param variableValue
		 * @return
		 */
		public static boolean isComplex( Object variableValue ){
			return variableValue != null && FunctionHelper.isPrimitive( variableValue ) == false;
		}
		
		/**
		 * �Ƿ���������
		 * @param variableValue
		 * @return
		 */
		public static boolean isDigital( Object variableValue ){
			return variableValue != null && FunctionHelper.isDigital( variableValue );
		}
		
		/**
		 * �Ƿ�NULL����
		 * @param variableValue
		 * @return
		 */
		public static boolean isNulllex( Object variableValue ){
			return variableValue != null && FunctionHelper.isNulllex( variableValue ) ;
		}
		
		/**
		 * �Ƿ��ַ�����
		 * @param variableValue
		 * @return
		 */
		public static boolean isString( Object variableValue ){
			return variableValue != null && FunctionHelper.isString( variableValue );
		}
	}
    
    public static class ICustom{
	   public ICustom(){
		   super();
	   }
	   
		/**
		 * 
		 * @param expression
		 * @param fromIfElse
		 * @return
		 * @throws
		 * @throws Exception
		 */
		private static boolean _IfElse(String expression, String fromIfElse ) throws Exception{
			boolean fromOBJECT = false;
			try
			{
				if( !(StringUtils.equals( fromIfElse, EvaluationConstants.BOOLEAN_STRING_FALSE ) || 
		        		  StringUtils.equals( fromIfElse , EvaluationConstants.BOOLEAN_STRING_TRUE ) )) {
					throw new EvaluationException("the expression <"+ expression + "> return value must be a Boolean type ");
		        }
				fromOBJECT = StringUtils.equals( fromIfElse , 
						EvaluationConstants.BOOLEAN_STRING_FALSE )?false:true;
			}
			finally{
				
			}
			return fromOBJECT;
		}
		/**
		 * 
		 * @param arguments
		 * @param quoteCharacter
		 * @return
		 * @throws Exception
		 */
		private static String _trimQuote( final String arguments, final char quoteCharacter) throws Exception{
			String trimmedArgument = arguments;
			trimmedArgument = trimmedArgument.trim();
			if( trimmedArgument.length() <= 0 || trimmedArgument.charAt(0) != quoteCharacter ){
				if (trimmedArgument.length() > 0 && trimmedArgument.charAt(trimmedArgument.length() - 1) == quoteCharacter){
					throw new EvaluationException("the expression <" + arguments + "> Value does end with a quote.");
				}
				return trimmedArgument;
			}
			trimmedArgument = trimmedArgument.substring(1, trimmedArgument.length());
			if (trimmedArgument.charAt(trimmedArgument.length() - 1) != quoteCharacter){
				throw new EvaluationException("the expression <" + arguments + "> Value does end with a quote.");
			}
			trimmedArgument = trimmedArgument.substring(0, trimmedArgument.length() - 1);
		    return ICustom._trimQuote( trimmedArgument , quoteCharacter );
		}
		/**
		 * 
		 * @param
		 * @return
		 */
		private static String _transfer( String arguments ) throws Exception{
			arguments = ICustom._trimQuote( arguments, EvaluationConstants.SINGLE_QUOTE);
			if( StringUtils.isDigital( arguments ) && StringUtils.endsWith( arguments , ".0") ){
				arguments = StringUtils.trimLeft( arguments , "." );
			}
			return StringUtils.equals( arguments , "NULL")?null:arguments;
		}
		
		/**
		 * 
		 * @param _engine
		 * @param _variables
		 * @throws Exception
		 */
		public static void _submit( JevalEvaluator _engine, java.util.Map _variables ) throws Exception{
			try
			{
				for( java.util.Iterator itera = _variables.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					Object variableName = fromEntry.getKey();
					Object variableValue = fromEntry.getValue();
					if( IIfElse.isVariable( variableName, variableValue ) == false ) continue;
					ICustom._submit(_engine, (String)variableName, variableValue);
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _engine
		 * @param variableName
		 * @param variableValue
		 */
		public static void _submit( JevalEvaluator _engine, final String variableName, final Object variableValue ){
			try
			{
				if( IIfElse.isComplex( variableValue ) /*��������*/){
					_engine.getVariables().put( (String)variableName, variableValue );
				}
				else if( IIfElse.isDigital( variableValue )/*��������*/){
					_engine.getVariables().put( (String)variableName, variableValue.toString() );
				}
				else/*������������*/{
					_engine.getVariables().put( (String)variableName, FunctionHelper.quoteString( 
							variableValue.toString(), EvaluationConstants.SINGLE_QUOTE ) );
				}
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param arguments
		 * @return
		 * @throws Exception
		 */
		private static String _arguments( String arguments ) throws Exception{
			String fromJEVAL = null;
			java.util.ArrayList strings = null;
			try
			{
				strings = FunctionHelper.getStrings(arguments, 
						EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
				for( int index = 0; strings != null && index < strings.size(); index++ ){
					String aArgument = (String)strings.get( index );
					aArgument = ICustom._transfer( aArgument );
					strings.set( index, aArgument != null?aArgument:"NULL" );
				}
				if( strings != null ){
					fromJEVAL = StringUtils.join( strings.iterator(), 
							EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR );
				}
			}
			finally{
				if( strings != null ){ strings.clear(); strings = null; }
			}
			return fromJEVAL;
		}
		/**
		 * 
		 * @param fromENGINE
		 * @param expression
		 * @param fromJEVAL
		 * @return
		 * @throws Exception
		 */
		private static String _evaluate ( JevalEvaluator fromENGINE, String expression, java.util.Map fromJEVAL ) throws Exception{
			String aOBJECT = null;
			try
			{
				ICustom._submit( fromENGINE , fromJEVAL );
				aOBJECT = ICustom._evaluate( fromENGINE, expression );
			}
			finally{
				
			}
			return aOBJECT;
		}
		/**
		 * 
		 * @param fromENGINE
		 * @param aJEXP
		 * @return
		 * @throws Exception
		 */
		private static String _evaluate ( JevalEvaluator fromENGINE, String expression ) throws Exception{
			String aOBJECT = null;
			try
			{
				aOBJECT = fromENGINE.evaluate( expression );
			}
			finally{
				
			}
			return aOBJECT;
		}
   }
}
