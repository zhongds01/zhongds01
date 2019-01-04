package com.ai.sacenter.jeval.function;

import com.ai.sacenter.jeval.EvaluationConstants;
import com.ai.sacenter.jeval.FunctionResult;
import com.ai.sacenter.jeval.JevalEvaluator;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JSONUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * This class contains many methods that are helpful when writing functions.
 * Some of these methods were created to help with the creation of the math and
 * string functions packaged with Evaluator.
 */
public class FunctionHelper {
	public FunctionHelper(){
		super();
	}
	
	/**
	 * Replaces all old string within the expression with new strings.
	 * 
	 * @param expression
	 *            The string being processed.
	 * @param oldString
	 *            The string to replace.
	 * @param newString
	 *            The string to replace the old string with.
	 * 
	 * @return The new expression with all of the old strings replaced with new
	 *         strings.
	 */
	public static String replaceAll(final String expression,
			final String oldString, final String newString) {

		String replacedExpression = expression;

		if (replacedExpression != null) {
			int charCtr = 0;
			int oldStringIndex = replacedExpression.indexOf(oldString, charCtr);

			while (oldStringIndex > -1) {
				// Remove the old string from the expression.
				final StringBuilder buffer = new StringBuilder(replacedExpression
						.substring(0, oldStringIndex)
						+ replacedExpression.substring(oldStringIndex
								+ oldString.length()));

				// Insert the new string into the expression.
				buffer.insert(oldStringIndex, newString);

				replacedExpression = buffer.toString();

				charCtr = oldStringIndex + newString.length();

				// Determine if we need to continue to search.
				if (charCtr < replacedExpression.length()) {
					oldStringIndex = replacedExpression.indexOf(oldString,
							charCtr);
				} else {
					oldStringIndex = -1;
				}
			}
		}

		return replacedExpression;
	}

	/**
	 * 
	 * @param arguments
	 * @param index
	 * @param quoteCharacter
	 * @param _default
	 * @return
	 * @throws FunctionException
	 */
	public static String trimAndRemoveQuoteChars( final java.util.ArrayList strings, 
			final int index, 
			final char quoteCharacter, 
			final String _default ) throws FunctionException{
		String trimmedArgument = _default;
		if( strings.size() > index ){
			trimmedArgument = ((String)strings.get( index ) ).trim();
			if( trimmedArgument.charAt(0) == quoteCharacter ){
				trimmedArgument = trimmedArgument.substring( 1, trimmedArgument.length() );
				if( trimmedArgument.charAt( trimmedArgument.length() - 1 ) != quoteCharacter ){
					throw new FunctionException("Value does not end with a quote.");
				}
				trimmedArgument = trimmedArgument.substring( 0, trimmedArgument.length() - 1 );
			}
		}
		return trimmedArgument;
	}
	
	/**
	 * 
	 * @param arguments
	 * @param quoteCharacter
	 * @return
	 * @throws FunctionException
	 */
	public static String trimAndRemoveQuoteChars(final String arguments,
			final char quoteCharacter) throws FunctionException{
		String trimmedArgument = arguments;
		trimmedArgument = trimmedArgument.trim();
		if (trimmedArgument.charAt(0) == quoteCharacter) {
			trimmedArgument = trimmedArgument.substring(1, trimmedArgument.length());
		} 
		else {
			throw new FunctionException("Value does not start with a quote.");
		}
		if (trimmedArgument.charAt(trimmedArgument.length() - 1) == quoteCharacter) {
			trimmedArgument = trimmedArgument.substring(0, trimmedArgument.length() - 1);
		}
		else {
			throw new FunctionException("Value does not end with a quote.");
		}
		return trimmedArgument;
	}
	
	/**
	 * 
	 * @param arguments
	 * @param quoteCharacter
	 * @return
	 * @throws FunctionException
	 */
	public static String trimQuote( final String arguments,
			final char quoteCharacter) throws FunctionException{
		String trimmedArgument = arguments;
		trimmedArgument = trimmedArgument.trim();
		if( trimmedArgument.charAt(0) != quoteCharacter ){
			if (trimmedArgument.charAt(trimmedArgument.length() - 1) == quoteCharacter)
				throw new FunctionException("Value does end with a quote.");
		}
		else{
			trimmedArgument = trimmedArgument.substring(1, trimmedArgument
					.length());
			if (trimmedArgument.charAt(trimmedArgument.length() - 1) != quoteCharacter)
				throw new FunctionException("Value does not end with a quote.");
			trimmedArgument = trimmedArgument.substring(0, trimmedArgument
					.length() - 1);
		}
		return trimmedArgument;
	}
	
	/**
	 * 
	 * @param src
	 * @param dest
	 * @throws FunctionException
	 */
	public static void _trimQuote( final java.util.Map src , 
			final java.util.Map dest ) throws FunctionException{
		for( java.util.Iterator itera = src.entrySet().iterator(); itera.hasNext() ; ){
			java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
			if( aEntry.getValue() == null ) continue;
			String trimmedArgument = (String)aEntry.getValue();
			if( StringUtils.isBlank( trimmedArgument ) || trimmedArgument.charAt(0) != 
				EvaluationConstants.SINGLE_QUOTE )  dest.put( aEntry.getKey() , trimmedArgument );
			else
				dest.put( aEntry.getKey() , trimQuote( trimmedArgument , EvaluationConstants.SINGLE_QUOTE ) );
		}
	}
	
	/**
	 * 
	 * @param argument
	 * @param fromPARAM
	 * @return
	 * @throws FunctionException
	 */
	public static java.util.Map _trimQuote( String argument, java.util.Map fromPARAM ) throws FunctionException{
		if( fromPARAM == null ) fromPARAM = new java.util.HashMap();
		if( StringUtils.isBlank( argument ) == false ){
			argument = trimQuote( argument, EvaluationConstants.SINGLE_QUOTE );
			String arguments[] = StringUtils.split( argument , ";" );
			for( int index = 0 ; arguments != null && index < arguments.length; index++ ){
				String aPARAM[] = StringUtils.wildcardTail( arguments[index] , "=" );
				if( StringUtils.isBlank( aPARAM[0] ) ) continue;
				if( aPARAM.length <= 1 || StringUtils.isBlank( aPARAM[1] ) || 
						aPARAM[1].charAt(0) != EvaluationConstants.SINGLE_QUOTE ){
					fromPARAM.put( aPARAM[0], aPARAM.length > 1?aPARAM[1]:"" );
				}
				else
				{
					fromPARAM.put( aPARAM[0] , trimQuote( aPARAM[1], EvaluationConstants.SINGLE_QUOTE ) );
				}
			}
		}
		return fromPARAM;
	}
	
    /**
     * 
     * @param arguments
     * @param quoteCharacter
     * @param startIndex
     * @return
     * @throws FunctionException
     */
	public static String[] trimAndRemoveQuoteChars(final java.util.ArrayList arguments, final char quoteCharacter, final int startIndex ) throws FunctionException {
		java.util.List strings = new java.util.ArrayList();
		for(int index = startIndex ; index < arguments.size() ; index++){
			String trimmedArgument = (String)arguments.get( index );
			if( trimmedArgument.charAt(0) == '$' ){
				strings.add( trimmedArgument );
			}
			else{
				strings.add( trimAndRemoveQuoteChars((String)arguments.get( index ) , quoteCharacter ) );
			}
		}
		return (String[])strings.toArray( new String[]{} );
	}
	
	/**
     * 
     * @param arguments
     * @param quoteCharacter
     * @param startIndex
     * @return
     * @throws FunctionException
     */
	public static java.util.ArrayList trimAndRemoveQuoteStrings(final java.util.ArrayList arguments, final char quoteCharacter, final int startIndex ) throws FunctionException {
		java.util.ArrayList strings = new java.util.ArrayList();
		for(int index = startIndex ; index < arguments.size() ; index++){
			String trimmedArgument = (String)arguments.get( index );
			if( trimmedArgument.charAt(0) == '$' ){
				strings.add( trimmedArgument );
			}
			else if( trimmedArgument.equals( EvaluationConstants.RESULT_NULL_STRING ) ){
				strings.add("");
			}
			else{
				strings.add( trimAndRemoveQuoteChars((String)arguments.get( index ) , quoteCharacter ) );
			}
		}
		return strings;
	}
	
	/**
	 * 
	 * @param strings
	 * @param index
	 * @param quoteCharacter
	 * @return
	 * @throws FunctionException
	 */
	public static Double getDouble( final java.util.ArrayList strings, final int index, final char quoteCharacter) throws FunctionException {
		String trimmedArgument = "0";
		if( strings.size() > index ){
			trimmedArgument = ((String)strings.get( index)).trim();
			if( trimmedArgument.length() > 0 && trimmedArgument.charAt( 0 ) == quoteCharacter ){
				trimmedArgument = trimmedArgument.substring( 1, trimmedArgument.length() );
				if( trimmedArgument.charAt( trimmedArgument.length() - 1 ) != quoteCharacter ){
					throw new FunctionException("Value <" + trimmedArgument + "> does end with a quote.");
				}
				trimmedArgument = trimmedArgument.substring( 0, trimmedArgument.length() - 1 );
			}
		}
		return new Double( trimmedArgument );
	}
	
	/**
	 * 
	 * @param arguments
	 * @param delimiter
	 * @return
	 * @throws FunctionException
	 */
	public static java.util.ArrayList getDoubles(final String arguments, final char delimiter) throws FunctionException {
		java.util.ArrayList returnValues = new java.util.ArrayList();
		try {

			final JevalEvaluator.ArgumentTokenizer tokenizer = new JevalEvaluator.ArgumentTokenizer(
					arguments, delimiter);

			while (tokenizer.hasMoreTokens()) {
				final String token = tokenizer.nextToken().trim();
				returnValues.add(new Double(token));
			}
		} catch (Exception e) {
			throw new FunctionException("Invalid values in string.", e);
		}

		return returnValues;
	}

	/**
	 * 
	 * @param arguments
	 * @param delimiter
	 * @return
	 * @throws FunctionException
	 */
	public static java.util.ArrayList getStrings(final String arguments,
			final char delimiter) throws FunctionException {

		final java.util.ArrayList returnValues = new java.util.ArrayList();

		try {
			JevalEvaluator.ArgumentTokenizer tokenizer = new JevalEvaluator.ArgumentTokenizer(arguments,
					delimiter);

			while (tokenizer.hasMoreTokens()) {
				final String token = tokenizer.nextToken();
				if( token != null && token.length() > 0 ) returnValues.add(token);
			}
		} catch (Exception e) {
			throw new FunctionException("Invalid values in string.", e);
		}

		return returnValues;
	}

	/**
	 * 
	 * @param arguments
	 * @param delimiter
	 * @param quoteCharacter
	 * @return
	 * @throws FunctionException
	 */
	public static java.util.ArrayList getStrings(final String arguments,
			final char delimiter,
			final char quoteCharacter ) throws FunctionException {

		final java.util.ArrayList returnValues = new java.util.ArrayList();

		try {
			JevalEvaluator.ArgumentTokenizer tokenizer = new JevalEvaluator.ArgumentTokenizer(arguments,
					delimiter);

			while (tokenizer.hasMoreTokens()) {
				final String token = tokenizer.nextToken();
				if( token != null && token.length() > 0 ){
					returnValues.add( FunctionHelper.trimQuote( token, quoteCharacter ) );
				}
			}
		} catch (Exception e) {
			throw new FunctionException("Invalid values in string.", e);
		}

		return returnValues;
	}
	
	/**
	 * 
	 * @param arguments
	 * @param delimiter
	 * @return
	 * @throws FunctionException
	 */
	public static java.util.ArrayList getOneStringAndOneInteger(final String arguments,
			final char delimiter) throws FunctionException {

		java.util.ArrayList returnValues = new java.util.ArrayList();

		try {
			final JevalEvaluator.ArgumentTokenizer tokenizer = new JevalEvaluator.ArgumentTokenizer(
					arguments, delimiter);

			int tokenCtr = 0;
			while (tokenizer.hasMoreTokens()) {
				if (tokenCtr == 0) {
					final String token = tokenizer.nextToken();
					returnValues.add(token);
				} else if (tokenCtr == 1) {
					final String token = tokenizer.nextToken().trim();
					returnValues.add(new Integer(new Double(token).intValue()));
				} else {
					throw new FunctionException("Invalid values in string.");
				}

				tokenCtr++;
			}
		} catch (Exception e) {
			throw new FunctionException("Invalid values in string.", e);
		}

		return returnValues;
	}

	/**
	 * 
	 * @param arguments
	 * @param delimiter
	 * @return
	 * @throws FunctionException
	 */
	public static java.util.ArrayList getTwoStringsAndOneInteger(final String arguments,
			final char delimiter) throws FunctionException {

		final java.util.ArrayList returnValues = new java.util.ArrayList();

		try {
			final JevalEvaluator.ArgumentTokenizer tokenizer = new JevalEvaluator.ArgumentTokenizer(
					arguments, delimiter);

			int tokenCtr = 0;
			while (tokenizer.hasMoreTokens()) {
				if (tokenCtr == 0 || tokenCtr == 1) {
					final String token = tokenizer.nextToken();
					returnValues.add(token);
				} else if (tokenCtr == 2) {
					final String token = tokenizer.nextToken().trim();
					returnValues.add(new Integer(new Double(token).intValue()));
				} else {
					throw new FunctionException("Invalid values in string.");
				}

				tokenCtr++;
			}
		} catch (Exception e) {
			throw new FunctionException("Invalid values in string.", e);
		}

		return returnValues;
	}

	/**
	 * 
	 * @param arguments
	 * @param delimiter
	 * @return
	 * @throws FunctionException
	 */
	public static java.util.ArrayList getOneStringAndTwoIntegers(final String arguments,
			final char delimiter) throws FunctionException {

		final java.util.ArrayList returnValues = new java.util.ArrayList();

		try {
			final JevalEvaluator.ArgumentTokenizer tokenizer = new JevalEvaluator.ArgumentTokenizer(
					arguments, delimiter);

			int tokenCtr = 0;
			while (tokenizer.hasMoreTokens()) {
				if (tokenCtr == 0) {
					final String token = tokenizer.nextToken().trim();
					returnValues.add(token);
				} else if (tokenCtr == 1 || tokenCtr == 2) {
					final String token = tokenizer.nextToken().trim();
					returnValues.add(new Integer(new Double(token).intValue()));
				} else {
					throw new FunctionException("Invalid values in string.");
				}

				tokenCtr++;
			}
		} catch (Exception e) {
			throw new FunctionException("Invalid values in string.", e);
		}

		return returnValues;
	}
	
	/**
	 * 
	 * @param aResult
	 * @return
	 * @throws Exception
	 */
	public static FunctionResult getResult(final String variableName, final Object _variableValue ) throws Exception{
		FunctionResult result = null;
		try
		{
			if( _variableValue == null ){
				result = new FunctionResult(variableName,
						EvaluationConstants.FUNCTION_RESULT_TYPE_NULL, 
						EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
			}
			else if( isDigital( _variableValue ) /*数字类型*/){
				result = new FunctionResult(variableName,
						_variableValue, 
						EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
			}
			else if( isBoolean( _variableValue ) /*布尔类型*/){
				result = new FunctionResult(variableName,
						StringUtils.equalsIgnoreCase(_variableValue.toString(), Boolean.TRUE.toString())?
								EvaluationConstants.BOOLEAN_STRING_TRUE:EvaluationConstants.BOOLEAN_STRING_FALSE, 
					    EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
			}
			else if( isPrimitive( _variableValue ) /*基本类型*/){
				result = new FunctionResult(variableName,
						_variableValue, 
						EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
			}
			else/*复合类型*/{
				result = new FunctionResult(variableName,
						_variableValue, 
						EvaluationConstants.FUNCTION_RESULT_TYPE_OBJECT);
			}
		}
		finally{
			
		}
		return result;
	}
	
	/**
	 * 
	 * @param aResult
	 * @return
	 * @throws Exception
	 */
	public static FunctionResult getFunctionResult( final Object _result ) throws Exception{
		FunctionResult result = null;
		try
		{
			if( _result == null ){
				result = new FunctionResult(EvaluationConstants.FUNCTION_RESULT_TYPE_NULL, 
						EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
			}
			else if( ClassUtils.IClass.isAssignable( _result , new Class[]{java.lang.Boolean.class,boolean.class}) ){
				result = new FunctionResult( StringUtils.equalsIgnoreCase(_result.toString(), Boolean.TRUE.toString())?
						EvaluationConstants.BOOLEAN_STRING_TRUE:
					    EvaluationConstants.BOOLEAN_STRING_FALSE, 
					    EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
			}
			else if( ClassUtils.IClass.isDigital( _result ) ){
				result = new FunctionResult(_result.toString(), 
						EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
			}
			else if( ClassUtils.IClass.isPrimitive( _result ) ){
				result = new FunctionResult(_result.toString(), 
						EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
			}
			else{
				result = new FunctionResult( JSONUtils.fromBean( _result ), 
						EvaluationConstants.FUNCTION_RESULT_TYPE_OBJECT);
			}
		}
		finally{
			
		}
		return result;
	}
	
	/**
	 * Determines if a character is a space or white space.
	 * 
	 * @param character
	 *            The character being evaluated.
	 * 
	 * @return True if the character is a space or white space and false if not.
	 */
	public static boolean isSpace(final char character) {

		if (character == ' ' || character == '\t' || character == '\n'
				|| character == '\r' || character == '\f') {
			return true;
		}

		return false;
	}
	
	/**
	 * 
	 * @param varaible
	 * @return
	 */
	public static final String quoteString( final String varaible ){
		return FunctionHelper.quoteString( varaible, EvaluationConstants.SINGLE_QUOTE );
	}
	
	/**
	 * 
	 * @param varaible
	 * @param quoteCharacter
	 * @return
	 */
	public static final String quoteString( final String varaible, final char quoteCharacter ){
		StringBuilder _varaible = new StringBuilder( varaible );
		if( varaible.length() == 0 ){
			_varaible.insert( 0, quoteCharacter ).append( quoteCharacter );
		}
		else if( varaible.charAt( 0 ) != quoteCharacter ){
			_varaible.insert( 0, quoteCharacter );
			if( varaible.charAt( varaible.length() - 1 ) != quoteCharacter ){
				_varaible.append( quoteCharacter );
			}
		}
		else if( varaible.charAt( varaible.length() - 1 ) != quoteCharacter ){
			_varaible.append( quoteCharacter );
		}
		return _varaible.toString();
	}
	
	/**
	 * 
	 * @param string
	 * @return
	 */
	public static final boolean isQuoteString( String string ){
		return string.startsWith( String.valueOf( EvaluationConstants.SINGLE_QUOTE ) ) &&
				string.endsWith( String.valueOf( EvaluationConstants.SINGLE_QUOTE ) );
	}
	
	/**
	 * 是否基本类型
	 * @param variableValue
	 * @return
	 */
	public static boolean isPrimitive( Object variableValue ){
		return variableValue != null && ClassUtils.IClass.isPrimitive( variableValue );
	}
	
	/**
	 * 是否基本类型
	 * @param variableValue
	 * @return
	 */
	public static boolean isComplex( Object variableValue ){
		return variableValue != null && ClassUtils.IClass.isPrimitive( variableValue ) == false;
	}
	
	/**
	 * 是否数字类型
	 * @param variableValue
	 * @return
	 */
	public static boolean isDigital( Object variableValue ){
		return variableValue != null && ClassUtils.IClass.isDigital( variableValue );
	}
	
	/**
	 * 是否布尔类型
	 * @param variableValue
	 * @return
	 */
	public static boolean isBoolean( Object variableValue ){
		return variableValue != null && ClassUtils.IClass.isBoolean( variableValue );
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static final boolean isNumeric( String string ){
		if (string == null)  return false;
        int sz = string.length();
        for (int i = 0; i < sz; i++) {
            if ( string.charAt(i) != '-' && string.charAt(i) != '.' && Character.isDigit(string.charAt(i)) == false) 
            	return false;
        }
        return true;
	}
	
	/**
	 * 是否NULL变量
	 * @param variableValue
	 * @return
	 */
	public static boolean isNulllex( Object variableValue ){
		return variableValue != null && ClassUtils.IClass.isString( variableValue ) && 
				StringUtils.equals( (String)variableValue, EvaluationConstants.RESULT_NULL_STRING );
	}
	
	/**
	 * 是否字符变量
	 * @param variableValue
	 * @return
	 */
	public static boolean isString( Object variableValue ){
		return ClassUtils.IClass.isString( variableValue );
	}
	
	/**
	 * 是否为变量路径
	 * @param fromXPath
	 * @return
	 */
	public static boolean isPackage( String fromXPath ){
		String fromLike[] = new String[]{ "\\", "/", "." };
		for( int index = 0; index < fromLike.length; index++ ){
			if( StringUtils.contains( fromXPath, fromLike[index] ) ){
				return true;
			}
		}
		return false;
	}
}
