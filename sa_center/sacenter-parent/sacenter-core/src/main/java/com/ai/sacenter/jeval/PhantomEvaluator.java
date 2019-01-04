package com.ai.sacenter.jeval;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.jeval.EvaluationConstants;
import com.ai.sacenter.jeval.EvaluationException;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JSONUtils;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StackDeque;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 本地类计算器</p>
 * <p>Copyright: Copyright (c) 2017年9月4日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class PhantomEvaluator {
	private final static Log log = LogFactory.getLog( PhantomEvaluator.class );
	private String _expression = null;
	private CarbonOperator _operator = null;
	private java.util.Map  _variables = new java.util.HashMap();
	public PhantomEvaluator(){
		super();
	}
	
	public PhantomEvaluator( java.util.Map variables){
		super();
		_variables.putAll( variables );
	}
	
	public PhantomEvaluator( final String expression, java.util.Map variables){
		_expression = expression;
		_variables.putAll( variables );
	}
	
	/**
	 * @return the _function
	 */
	public String getExpression() {
		return _expression;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public CarbonOperator getOperator() throws Exception{
		if( _operator == null && _expression != null ){
			_operator = CarbonOperator.getOperator( _expression );
		}
		return _operator;
	}

	/**
	 * @return the _variables
	 */
	public java.util.Map getVariables() {
		return _variables;
	}
	
	/**
	 * 
	 * @param variableName
	 * @return
	 * @throws Exception
	 */
	public Object getVariable(final String variableName) throws Exception{
		Object _variableValue = null;
		try
		{
			if( isNULL( variableName ) /*NULL类*/){
				_variableValue = null;
			}
			else if( StringUtils.equals( variableName, EvaluationConstants.VARIABLE_PARAM_STRING ) /*变量集合*/){
				_variableValue = _variables.get( EvaluationConstants.PARAM_RESULT_STRING );
				if( _variableValue == null ){ _variableValue = _variables; }
			}
			else if( StringUtils.equals( variableName, EvaluationConstants.VARIABLE_LDPAP_STRING ) ){
				_variableValue = _variables.get( EvaluationConstants.LDPAP_RESULT_STRING );
				if( _variableValue == null ){ _variableValue = ClassUtils.getIContextImpl( _variables ); }
			}
			else if( variableName.charAt( 0 ) == EvaluationConstants.SINGLE_QUOTE /*字符串类*/){
				if( variableName.charAt( variableName.length() - 1 ) != EvaluationConstants.SINGLE_QUOTE ){
					throw new EvaluationException("string value <" + variableName + "> does not end with a quote.");
				}
				_variableValue = variableName.substring( 1, variableName.length() - 1 );
			}
			else if( variableName.indexOf( EvaluationConstants.OPEN_VARIABLE ) >= 0 /*变量类*/){
				String _variable = variableName;
				if( StringUtils.endsWith( _variable, EvaluationConstants.CLOSED_VARIABLE ) == false ){
					throw new EvaluationException("string variable <" + _variable + "> does not end with " + EvaluationConstants.CLOSED_VARIABLE );
				}
				_variable = _variable.substring( EvaluationConstants.OPEN_VARIABLE.length(), 
						variableName.length() - EvaluationConstants.CLOSED_VARIABLE.length() );
				_variableValue = ReflectUtils.xPath( _variable, _variables );
			}
			else/*数字类*/{
				_variableValue = new java.math.BigDecimal( variableName );
			}
		}
		finally{
			
		}
		return _variableValue;
	}
	
	/**
	 * 是否为NULL
	 * @param variableName
	 * @return
	 */
	public boolean isNULL( final String variableName ){
		return variableName == null || StringUtils.isBlank( variableName ) || 
				StringUtils.equals( variableName, EvaluationConstants.RESULT_NULL_STRING );
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object evaluate( ) throws Exception{
		return evaluate( _expression );
	}
	
	/**
	 * 
	 * @param expression
	 * @return
	 * @throws Exception
	 */
	public Object evaluate(final String expression) throws Exception{
		Object _objective = null;
		try
		{
			_expression = expression;
			_operator = CarbonOperator.getOperator( _expression );
			_objective = _operator.evaluate( this );
		}
		finally{
			
		}
		return _objective;
	}

	/**
	 * 
	 * @param expression
	 * @param fromPARAM
	 * @return
	 * @throws Exception
	 */
	public Object evaluate(final String expression, final java.util.Map fromPARAM ) throws Exception{
		Object _objective = null;
		try
		{
			_variables.putAll( fromPARAM );
			_objective = evaluate( expression );
		}
		finally{
			
		}
		return _objective;
	}

	/**
	 * 
	 * @param expression
	 * @param fromPARAM
	 * @param aContext
	 * @return
	 * @throws Exception
	 */
	public Object evaluate(final String expression, final java.util.Map fromPARAM, final IUpdcContext aContext ) throws Exception{
		Object _objective = null;
		try
		{
			ClassUtils.IMerge.merge( aContext, _variables, true );
			ClassUtils.IMerge.merge( aContext, fromPARAM, true );
			_variables.put( EvaluationConstants.PARAM_RESULT_STRING, fromPARAM );
			_variables.put( EvaluationConstants.LDPAP_RESULT_STRING, aContext  );
			_objective = evaluate( expression );
		}
		finally{
			
		}
		return _objective;
	}
	
	public String asXml(){
		String fromXML = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( "InterBOSS" );
			fromRoot.addElement("function").setText( _expression );
			org.dom4j.Element fromPhantom = fromRoot.addElement( "phantom" );
			try
			{
				CarbonOperator _phantom = getOperator();
				for( java.util.Iterator itera = _phantom.getCarbon().iterator(); itera.hasNext(); ){
					DefaultOperator __operator = (DefaultOperator)itera.next();
					__operator.asXML( fromPhantom );
				}
				Object _return = evaluate( _expression );
				if( _return == null ){ 
					fromPhantom.addElement( "return" ).setText( "NULL" ); 
				}
				else if( ClassUtils.IClass.isPrimitive( _return ) ){
					fromPhantom.addElement( "return" ).setText( _return.toString() ); 
				}
				else{
					String _string = JSONUtils.fromBean( _return );
					fromPhantom.addElement( "return" ).setText( _string ); 
				}
				fromXML = document.asXML();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				throw new java.lang.RuntimeException( exception );
			}
		}
		finally{
			
		}
		return fromXML;
	}
	public static class WeakOperator{
		private StringBuilder _expression = new StringBuilder();
		public WeakOperator(){
			super();
		}

		/**
		 * @return the _expression
		 */
		public String getExpression() {
			return _expression.toString().trim();
		}
		
		/**
		 * 是否为NULL
		 * @return
		 */
		public boolean isEmpty(){
			String expression = _expression.toString().trim();
			return expression.length() == 0;
		}
		
		/**
		 * 
		 * @param _char
		 */
		public void phantom( char _char ){
			_expression.append( _char );
		}
		
		/**
		 * 
		 */
		public void empty(){
			_expression = new StringBuilder(); 	
		}
		
		/**
		 * 函数调用
		 * @return
		 */
		public boolean isFunciton(){
			String expression = _expression.toString().trim();
			return StringUtils.startWith( expression, "$FUN." );
		}
		
		/**
		 * 变量类
		 * @return
		 */
		public boolean isVariable(){
			String expression = _expression.toString().trim();
			return StringUtils.startWith( expression, EvaluationConstants.OPEN_VARIABLE ) || 
					( expression.length() > 0 && expression.charAt( 0 ) == EvaluationConstants.POUND_SIGN );
		}
		
		/**
		 * 增加字符是否变量类
		 * @return
		 */
		public boolean isVariable( char _char ){
			String expression = _expression.toString().trim();
			if( expression.length() > 0 ){
				if( StringUtils.startWith( expression, EvaluationConstants.OPEN_VARIABLE ) ){
					return _char == EvaluationConstants.CLOSED_BRACE && StringUtils.endsWith( expression, EvaluationConstants.CLOSED_VARIABLE ) == false;
				}
				else if( expression.length() == 1 && expression.charAt(0) == EvaluationConstants.POUND_SIGN ){
					return _char == EvaluationConstants.OPEN_BRACE;
				}
			}
			return false;
		}
		
		/**
		 * 字符串类
		 * @return
		 */
		public boolean isString(){
			String expression = _expression.toString().trim();
			return expression.length() > 0 && expression.charAt( 0 ) == EvaluationConstants.SINGLE_QUOTE ;
		}
		
		/**
		 * 数字类
		 * @return
		 */
		public boolean isDecimal(){
			String expression = _expression.toString().trim();
			return MathUtils.isDecimal( expression );
		}
		
	}
	
	public static class DefaultPhantom{
		protected String _expression;
		protected java.util.List _carbon = new java.util.ArrayList();
		public DefaultPhantom( String expression ){
			super();
			_expression = expression.trim();
		}
		
		/**
		 * @return the _expression
		 */
		public String getExpression() {
			return _expression;
		}

		/**
		 * @return the _phantom
		 */
		public java.util.List getCarbon() {
			return _carbon;
		}
		
		/**
		 * 
		 * @param character
		 * @return
		 */
		public boolean isSpace(final char character) {
			if (character == ' ' || character == '\t' || character == '\n'
					|| character == '\r' || character == '\f') {
				return true;
			}
			return false;
		}
	}
	
	public static class CarbonOperator extends DefaultPhantom{
		private static java.util.Map _runtime_phantom = new java.util.concurrent.ConcurrentHashMap();
		public CarbonOperator( String expression ) throws Exception{
			super( expression );
			_processOperator( expression );
		}
		
		/**
		 * 
		 * @param _phantomRef
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		private DefaultOperator getOperator( final WeakOperator _phantomRef ) throws SFException,Exception{
			DefaultOperator _operator = null;
			try
			{
				String _expression = _phantomRef != null?_phantomRef.getExpression():null;
				if( _expression == null ){
					_operator = new DefaultOperator( "" );
				}
				else if( _phantomRef.isString() /*字符串类*/){
					if( _expression.charAt( _expression.length() - 1 ) != EvaluationConstants.SINGLE_QUOTE ){
						throw new EvaluationException("string value <" + _expression + "> does not end with a quote.");
					}
					_operator = new StringPhantom( _expression );
				}
				else if( _phantomRef.isVariable() /*变量类*/){
					if( StringUtils.endsWith( _expression, EvaluationConstants.CLOSED_VARIABLE ) == false ){
						throw new EvaluationException("string variable <" + _expression + "> does not end with " + 
					           EvaluationConstants.CLOSED_VARIABLE );
					}
					_operator = new VariablePhantom( _expression );
				}
				else if( _phantomRef.isDecimal() == false/*常量类*/ ){
					_operator = new ConstonPhantom( _expression );
				}
				else/*数字类*/{
					_operator = new DecimalPhantom( _expression );
				}
			}
			finally{
				
			}
			return _operator;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextVariable( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				_phantomRef.phantom( expression.charAt( fromINDEX ) );
				DefaultOperator _operator = getOperator( _phantomRef );
				_phantom.getCarbon().add( _operator );
				_phantomRef.empty();
				fromINDEX += 1;
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextFunction( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				FunctionPhantom _operator = new FunctionPhantom( _phantomRef.getExpression() );
				_stackDeque.push( _operator );
				fromINDEX = fromINDEX + 1;
				fromINDEX = processNextOperator( expression, fromINDEX, _operator, _stackDeque );
				_phantom.getCarbon().add( _operator );
				_phantomRef.empty();
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextBracket( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				BracketPhantom _operator = new BracketPhantom( _phantomRef.getExpression() );
				_stackDeque.push( _operator );
				fromINDEX = fromINDEX + 1;
				fromINDEX = processNextOperator( expression, fromINDEX, _operator, _stackDeque );
				_phantom.getCarbon().add( _operator );
				_phantomRef.empty();
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextParallel( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				ParallelPhantom _operator = new ParallelPhantom( _phantomRef.getExpression() );
				_stackDeque.push( _operator );
				fromINDEX = fromINDEX + 1;
				fromINDEX = processNextOperator( expression, fromINDEX, _operator, _stackDeque );
				_phantom.getCarbon().add( _operator );
				_phantomRef.empty();
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextParallelx( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				if( _phantomRef.isEmpty() ){
					_phantomRef.empty();
					fromINDEX += 1;
				}
				else{
					DefaultOperator _operator = getOperator( _phantomRef );
					if( ( _phantom instanceof ParallelPhantom ) == false ){
						throw new EvaluationException( "multiple choice expressions <" + expression + "> must be included as {}" );
					}
					_phantom.getCarbon().add( _operator );
					_phantomRef.empty();fromINDEX += 1;
				}
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextCommarae( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				if( _phantomRef != null && _phantomRef.isEmpty() == false ){
					DefaultOperator _operator = getOperator( _phantomRef );
					_phantom.getCarbon().add( _operator );
					_phantomRef.empty();
				}
				fromINDEX = fromINDEX + 1;
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextClosbrace( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				if( _phantomRef != null && _phantomRef.isEmpty() == false ){
					DefaultOperator _operator = getOperator( _phantomRef );
					_phantom.getCarbon().add( _operator );
					_phantomRef.empty();
				}
				_stackDeque.pop();
				fromINDEX = fromINDEX + 1;
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextCurrency( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				if( _phantomRef != null && _phantomRef.isEmpty() == false ){
					DefaultOperator _operator = getOperator( _phantomRef );
					_phantom.getCarbon().add( _operator );
					_phantomRef.empty();
				}
				_phantomRef._expression.append( expression.charAt( fromINDEX ) );
				fromINDEX = fromINDEX + 1;
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextOperator( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				if( _phantomRef != null && _phantomRef.isEmpty() == false ){
					DefaultOperator _operator = getOperator( _phantomRef );
					_phantom.getCarbon().add( _operator );
					_phantomRef.empty();
				}
				fromINDEX = fromINDEX + 1;
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _phantomRef
		 * @param _phantom
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextPhantom( final String expression, int fromINDEX, WeakOperator _phantomRef, final DefaultPhantom _phantom, final StackDeque _stackDeque ) throws Exception{
			try
			{
				_phantomRef.phantom( expression.charAt( fromINDEX ) );
				fromINDEX += 1;
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @param fromINDEX
		 * @param _operator
		 * @param _stackDeque
		 * @return
		 * @throws Exception
		 */
		private int processNextOperator(final String expression, int fromINDEX, final DefaultPhantom _operator, final StackDeque _stackDeque ) throws Exception{
			try
			{
				WeakOperator _phantomref = new WeakOperator();
				while( fromINDEX < expression.length() ){
					if( isSpace( expression.charAt( fromINDEX ) ) && _phantomref == null ){ 
						fromINDEX += 1; 
						continue; 
					}
					else if( expression.charAt( fromINDEX ) == '&' ){
						fromINDEX = processNextParallelx(expression, fromINDEX, _phantomref, _operator, _stackDeque);
					}
					else if( expression.charAt( fromINDEX ) == '$' ){
						fromINDEX = processNextCurrency(expression, fromINDEX, _phantomref, _operator, _stackDeque);
					}
					else if( expression.charAt( fromINDEX ) == '#' ){
						fromINDEX = processNextCurrency(expression, fromINDEX, _phantomref, _operator, _stackDeque);
					}
					else if( expression.charAt( fromINDEX ) == '(' ){
						if( _phantomref.isFunciton() ){
							fromINDEX = processNextFunction(expression, fromINDEX, _phantomref, _operator, _stackDeque);
						}
						else{
							fromINDEX = processNextBracket(expression, fromINDEX, _phantomref, _operator, _stackDeque);
						}
					}
					else if( expression.charAt( fromINDEX ) == ')' ){
						fromINDEX = processNextClosbrace(expression, fromINDEX, _phantomref, _operator, _stackDeque);
						break;
					}
					else if( expression.charAt( fromINDEX ) == '{' ){
						if( _phantomref.isVariable( expression.charAt( fromINDEX ) ) ){
							fromINDEX = processNextPhantom(expression, fromINDEX, _phantomref, _operator, _stackDeque);
						}
						else{
							fromINDEX = processNextParallel(expression, fromINDEX, _phantomref, _operator, _stackDeque);
						}
					}
					else if( expression.charAt( fromINDEX ) == '}' ){
						if( _phantomref.isVariable( expression.charAt( fromINDEX ) ) ){
							fromINDEX = processNextVariable(expression, fromINDEX, _phantomref, _operator, _stackDeque);
						}
						else{
							fromINDEX = processNextClosbrace(expression, fromINDEX, _phantomref, _operator, _stackDeque);
							break;
						}
					}
					else if( expression.charAt( fromINDEX ) == ',' ) {
						fromINDEX = processNextCommarae(expression, fromINDEX, _phantomref, _operator, _stackDeque);
					}
					else{
						fromINDEX = processNextPhantom(expression, fromINDEX, _phantomref, _operator, _stackDeque);
					}
				}
				if( _phantomref.isEmpty() == false ){
					processNextOperator(expression, fromINDEX, _phantomref, _operator, _stackDeque);
				}
			}
			finally{
			
			}
			return fromINDEX;
		}
		
		/**
		 * 
		 * @param expression
		 * @return
		 * @throws Exception
		 */
		public void _processOperator( final String expression ) throws Exception{
			StackDeque _stackDeque = new StackDeque();
			try
			{
				int fromINDEX = 0;
				_stackDeque.push( this );
				processNextOperator( expression, fromINDEX, this, _stackDeque );
				_stackDeque.pop();
				if( _stackDeque != null && _stackDeque.size() > 0 ){
					throw new EvaluationException( "function expression <" + expression + "> invalid parameter" );
				}
			}
			finally{
				if( _stackDeque != null ){ _stackDeque.clear(); _stackDeque = null; }
			}
		
		}
		
		/**
		 * 
		 * @param expression
		 * @return
		 * @throws Exception
		 */
		public static CarbonOperator getOperator( final String expression ) throws Exception{
			CarbonOperator _operator = null;
			try
			{
				_operator = (CarbonOperator)_runtime_phantom.get( expression );
				if( _operator == null ){
					synchronized ( _runtime_phantom ) {
						_operator = (CarbonOperator)_runtime_phantom.get( expression );
						if( _operator == null ){
							_operator = new CarbonOperator( expression );
							_runtime_phantom.put( expression, _operator );
						}
					}
				}
			}
			finally{
				
			}
			return _operator;
		}
		
		/**
		 * 
		 * @param _evaluator
		 * @return
		 * @throws Exception
		 */
		public Object evaluate( PhantomEvaluator _evaluator ) throws Exception{
			Object _objective = null;
			try
			{
				if( _carbon != null && _carbon.size() == 1 ){
					for( java.util.Iterator itera = _carbon.iterator(); itera.hasNext(); ){
						DefaultOperator _operator = (DefaultOperator)itera.next();
						_objective = _operator.execute( _evaluator );
						if( _objective != null ){ break; }
					}
				}
				else if( _carbon != null && _carbon.size() > 0 ){
					StringBuilder _bundles = new StringBuilder();
					for( java.util.Iterator itera = _carbon.iterator(); itera.hasNext(); ){
						DefaultOperator _operator = (DefaultOperator)itera.next();
						Object __objective = _operator.execute( _evaluator );
						if( __objective != null && ClassUtils.IClass.isPrimitive( __objective ) ){
							_bundles.append( __objective.toString() );
						}
						else if( __objective != null ){
							throw new EvaluationException("string variable <" + _operator._expression + "> return must simple type" );
						}
					}
					_objective = _bundles.toString();
				}
			}
			finally{
				
			}
			return _objective;
		}
		
		/**
		 * 
		 * @return
		 */
		public String asXml(){
			String fromXML = null;
			try
			{
				org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
				org.dom4j.Element fromRoot = document.addElement( "InterBOSS" );
				fromRoot.addElement("function").setText( _expression );
				org.dom4j.Element phantom = fromRoot.addElement( "phantom" );
				try
				{
					for( java.util.Iterator itera = _carbon.iterator(); itera.hasNext(); ){
						DefaultOperator __operator = (DefaultOperator)itera.next();
						__operator.asXML( phantom );
					}
					fromXML = document.asXML();
				}
				catch( java.lang.Exception exception ){
					log.error( exception.getMessage(), exception );
					throw new java.lang.RuntimeException( exception );
				}
			}
			finally{
				
			}
			return fromXML;
		}
		
	}

	public static class DefaultOperator extends DefaultPhantom{
		public DefaultOperator( String expression ){
			super( expression );
		}
		
		/**
		 * 
		 * @param _evaluator
		 * @return
		 * @throws Exception
		 */
		public Object execute( final PhantomEvaluator _evaluator ) throws Exception{
			Object _objective = null;
			String phantom[] = StringUtils.wildcardArray( _expression, "&" );
			for( int index = 0; index < phantom.length; index++ ){
				_objective = _evaluator.getVariable( phantom[index] );
				if( _objective != null ){ break; }
			}
			return _objective;
		}
		
		/**
		 * 
		 * @param _element
		 * @throws Exception
		 */
		public void asXML( org.dom4j.Element element ) throws Exception{
			org.dom4j.Element _element = element.addElement( "return" );
			_element.addAttribute( "name", _expression != null?_expression:"" ).setText( "" );
		}
		
	}
	
	public static class StringPhantom extends DefaultOperator{
		public StringPhantom( String expression ){
			super( expression );
		}

		/**
		 * 
		 * @param _evaluator
		 * @return
		 * @throws Exception
		 */
		public Object execute( final PhantomEvaluator _evaluator ) throws Exception{
			return _evaluator.getVariable( _expression );
		}
		
		/**
		 * 
		 * @param _element
		 * @throws Exception
		 */
		public void asXML( org.dom4j.Element element ) throws Exception {
			org.dom4j.Element _element = element.addElement( "string" );
			_element.addAttribute( "name", _expression != null?_expression:"" ).setText( "" );
		}
	}
	
	public static class DecimalPhantom extends DefaultOperator{
		public DecimalPhantom( String expression ){
			super( expression );
		}

		/**
		 * 
		 * @param _evaluator
		 * @return
		 * @throws Exception
		 */
		public Object execute( final PhantomEvaluator _evaluator ) throws Exception{
			return _evaluator.getVariable( _expression );
		}
		
		/**
		 * 
		 * @param _element
		 * @throws Exception
		 */
		public void asXML( org.dom4j.Element element ) throws Exception {
			org.dom4j.Element _element = element.addElement( "decimal" );
			_element.addAttribute( "name", _expression != null?_expression:"" ).setText( "" );
		}
	}
	
	public static class ConstonPhantom extends DefaultOperator{
		public ConstonPhantom( String expression ){
			super( expression );
		}

		/**
		 * 
		 * @param _evaluator
		 * @return
		 * @throws Exception
		 */
		public Object execute( final PhantomEvaluator _evaluator ) throws Exception{
			return _expression;
		}
		
		/**
		 * 
		 * @param _element
		 * @throws Exception
		 */
		public void asXML( org.dom4j.Element element ) throws Exception {
			org.dom4j.Element _element = element.addElement( "conston" );
			_element.addAttribute( "name", _expression != null?_expression:"" ).setText( _expression != null?_expression:"" );
		}
	}
	
	public static class VariablePhantom extends DefaultOperator{
		public VariablePhantom( String expression ){
			super( expression );
		}

		/**
		 * 
		 * @param _evaluator
		 * @return
		 * @throws Exception
		 */
		public Object execute( final PhantomEvaluator _evaluator ) throws Exception {
			return super.execute( _evaluator );
		}
		
		/**
		 * 
		 * @param _element
		 * @throws Exception
		 */
		public void asXML(org.dom4j.Element element) throws Exception {
			org.dom4j.Element _element = element.addElement( "variable" );
			_element.addAttribute("name", _expression != null?_expression:"" ).setText( "" );
		}
	}
	
	public static class ParallelPhantom extends DefaultOperator{
		public ParallelPhantom( String expression ){
			super( expression );
		}
		
		/**
		 * 
		 * @param _evaluator
		 * @return
		 * @throws Exception
		 */
		public Object execute( final PhantomEvaluator _evaluator ) throws Exception{
			Object _return = null;
			for( int index = 0; index < _carbon.size(); index++ ){
				DefaultOperator __operator = (DefaultOperator)_carbon.get( index );
				_return = __operator.execute( _evaluator );
				if( _return != null ){ break; }
			}
			return _return;
		}
		
		/**
		 * 
		 * @param _element
		 * @throws Exception
		 */
		public void asXML(org.dom4j.Element element) throws Exception {
			try
			{
				org.dom4j.Element _element = element.addElement("parallel");
				for( int index = 0; index < _carbon.size(); index++ ){
					DefaultOperator __operator = (DefaultOperator)_carbon.get( index );
					__operator.asXML( _element );
				}
			}
			finally{
				
			}
			
		}
	}
	
	public static class BracketPhantom extends DefaultOperator{
		public BracketPhantom( String expression ){
			super( expression );
		}
		
		/**
		 * 
		 * @param _evaluator
		 * @return
		 * @throws Exception
		 */
		public Object execute( final PhantomEvaluator _evaluator ) throws Exception{
			StringBuilder _return = null;
			for( int index = 0; index < _carbon.size(); index++ ){
				DefaultOperator __operator = (DefaultOperator)_carbon.get( index );
				Object __return = __operator.execute( _evaluator );
				if( __return != null && ClassUtils.IClass.isPrimitive( __return ) ){
					if( _return != null ){ _return.append( __return.toString() ); }
					else{ _return = new StringBuilder( __return.toString() ); }
				}
				else if( __return != null ){
					throw new EvaluationException("string variable <" + __operator._expression + "> return must simple type" );
				}
			}
			return _return != null?_return.toString():null;
		}
		
		/**
		 * 
		 * @param _element
		 * @throws Exception
		 */
		public void asXML(org.dom4j.Element element) throws Exception {
			try
			{
				org.dom4j.Element _element = element.addElement("bracket");
				for( int index = 0; index < _carbon.size(); index++ ){
					DefaultOperator __operator = (DefaultOperator)_carbon.get( index );
					__operator.asXML( _element );
				}
			}
			finally{
				
			}
			
		}
	}
	
	public static class FunctionPhantom extends DefaultOperator{
		public FunctionPhantom( String expression ){
			super( expression );
		}
		
		/**
		 * 
		 * @param _evaluator
		 * @return
		 * @throws Exception
		 */
		public Object execute( final PhantomEvaluator _evaluator ) throws Exception {
			Object _return = null;
			try
			{
				Object _arguments[] = new Object[ _carbon.size() ];
				for( int index = 0; _carbon != null && index < _carbon.size(); index++ ){
					DefaultOperator __operator = (DefaultOperator)_carbon.get( index );
					_arguments[index] = __operator.execute( _evaluator );
				}
				_return = ReflectUtils.IReflect.invokeCompatible( _expression, _arguments );
			}
			finally{
				
			}
			return _return;
		}
		
		/**
		 * 
		 * @param _element
		 * @throws Exception
		 */
		public void asXML(org.dom4j.Element element) throws Exception {
			try
			{
				org.dom4j.Element _element = element.addElement("function");
				_element.addAttribute("method", _expression );
				for( int index = 0; index < _carbon.size(); index++ ){
					DefaultOperator __operator = (DefaultOperator)_carbon.get( index );
					__operator.asXML( _element );
				}
			}
			finally{
				
			}
		}
	}
}
