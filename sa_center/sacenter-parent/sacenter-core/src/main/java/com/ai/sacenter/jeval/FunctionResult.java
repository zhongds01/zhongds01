package com.ai.sacenter.jeval;

import com.ai.sacenter.jeval.function.FunctionException;
import com.ai.sacenter.jeval.function.FunctionHelper;

/**
 * This is a wrapper for the result value returned from a function that not only
 * contains the result, but the type. All custom functions must return a
 * FunctionResult.
 */
public class FunctionResult {
	private String variable;
	private Object result;
	private int type;
	public FunctionResult(Object _result, int _type) throws FunctionException {
		this( "*", _result, _type);
	}

	public FunctionResult(String _variable, Object _result, int _type) throws FunctionException {
		if( _type < EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC
				|| _type > EvaluationConstants.FUNCTION_RESULT_TYPE_OBJECT ) {
			throw new FunctionException("Invalid function result type.");
		}
		variable = _variable;
		result   = _result  ;
		type     = _type    ;
	}
	
	/**
	 * @return the variable
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * 
	 * @return
	 * @throws FunctionException
	 */
	public String getAsResult() throws FunctionException{
		if( type == EvaluationConstants.FUNCTION_RESULT_TYPE_OBJECT ){
			throw new FunctionException("the result type [" + variable + "] does been numeric/string type.");
		}
		return (String)result;
	}
	
	/**
	 * 
	 * @return
	 * @throws FunctionException
	 */
	public String getAsDigital() throws FunctionException{
		if( type != EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC ){
			throw new FunctionException("the result type[" + variable + "] does been numeric type.");
		}
		return result.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAsString() throws FunctionException{
		if( type != EvaluationConstants.FUNCTION_RESULT_TYPE_STRING && 
				type != EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC ){
			throw new FunctionException("the result type[" + variable + "] does been string type.");
		}
		return FunctionHelper.quoteString( result.toString() );
	}
	
	/**
	 * 
	 * @return
	 * @throws FunctionException
	 */
	public Object getAsObject() throws FunctionException{
		if( type != EvaluationConstants.FUNCTION_RESULT_TYPE_OBJECT ){
			throw new FunctionException("the result type[" + variable + "] does been complex type.");
		}
		return result;
	}
}