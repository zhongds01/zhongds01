package com.ai.sacenter.jeval;

import com.ai.sacenter.jeval.function.FunctionHelper;

/**
 * This class can be used to wrap the result of an expression evaluation. It
 * contains useful methods for evaluating the contents of the result.
 */
public class EvaluationResult {
	// The value returned from the evaluation of an expression.
	private Object result;
	// The quote character specified in the evaluation of the expression.
	private char quoteCharacter;
	public EvaluationResult(Object _result, char _quoteCharacter) {
		result = _result;
		quoteCharacter = _quoteCharacter;
	}

	/**
	 * 
	 * @return
	 */
	public char getQuoteCharacter() {
		return quoteCharacter;
	}

	/**
	 * 
	 * @param _quoteCharacter
	 */
	public void setQuoteCharacter(char _quoteCharacter) {
		quoteCharacter = _quoteCharacter;
	}

	/**
	 * 
	 * @return
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * 
	 * @param _result
	 */
	public void setResult(Object _result) {
		result = _result;
	}

	/**
	 * 是否为布尔类型
	 * @return
	 */
	public boolean isBoolean() {
		if( result != null && EvaluationConstants.BOOLEAN_STRING_TRUE.equals( result ) ) {
			return true;
		}
		else if(  result != null && EvaluationConstants.BOOLEAN_STRING_FALSE.equals( result ) ){
			return true;
		}
		return false;
	}

	/**
	 * 是否字符串,用分割符包含
	 * @return
	 */
	public boolean isString() {
		if( FunctionHelper.isString( result ) ){
			String _result = (String)result;
			if( _result != null && _result.length() >= 2 && _result.charAt(0) == quoteCharacter &&
					_result.charAt(_result.length() - 1) == quoteCharacter ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public Double getAsDouble() {
		java.lang.Double _double = null;
		try{
			if( FunctionHelper.isString( result ) == false ){
				throw new EvaluationException("the variable <" + result + "> value does been numeric type.");
			}
			String _result = (String)result;
			if( _result.length() >= 2 && _result.charAt(0) == quoteCharacter &&
					_result.charAt(_result.length() - 1) == quoteCharacter ){
				_result = FunctionHelper.trimQuote( _result, quoteCharacter );
			}
			_double = new java.lang.Double( _result );
		}
		catch( java.lang.Exception exception ){
			if( exception instanceof IllegalArgumentException ){
				throw (IllegalArgumentException)exception;
			}
			else{
				throw new IllegalArgumentException(exception.getMessage(), exception);
			}
		}
		return _double;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getAsBoolean() {
		if( result != null && EvaluationConstants.BOOLEAN_STRING_TRUE.equals( result ) ) {
			return true;
		}
		else if(  result != null && EvaluationConstants.BOOLEAN_STRING_FALSE.equals( result ) ){
			return false;
		}
		else{
			throw new IllegalArgumentException("result value" + result + " has not been boolean value.");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAsString() {
		if( result != null && FunctionHelper.isString( result ) == false ){
			throw new IllegalArgumentException("result value" + result + " has not been string value.");
		}
		String _result = (String)result;
		if( _result == null || FunctionHelper.isNulllex( _result ) ){
			return null;
		}
		else if( _result.length() > 0 && _result.charAt( 0 ) == quoteCharacter ){
			_result = _result.substring( 1, _result.length() );
			if( _result.length() > 0 && _result.charAt( _result.length() - 1 ) == quoteCharacter ){
				_result = _result.substring( 0, _result.length() - 1 );
			}
		}
		else if( _result.length() > 0 && _result.charAt( _result.length() - 1 ) == quoteCharacter ){
			_result = _result.substring( 0, _result.length() - 1 );
		}
		return _result;
	}
	
	/**
	 * 
	 * @return
	 */
	public Object getAsComplex(){
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public Object getAsObject(){
		if( FunctionHelper.isComplex( result ) ){
			return getAsComplex();
		}
		else if( FunctionHelper.isString( result ) ){
			return getAsString();
		}
		return result;
	}
}
