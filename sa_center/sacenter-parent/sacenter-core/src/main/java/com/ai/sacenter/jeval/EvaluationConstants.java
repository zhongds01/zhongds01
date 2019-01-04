package com.ai.sacenter.jeval;

/**
 * Contains constants used by classes in this package.
 */
public class EvaluationConstants {
	/**
	 * The single quote character.
	 */
	public static final char SINGLE_QUOTE = '\'';

	/**
	 * The double quote character.
	 */
	public static final char DOUBLE_QUOTE = '"';

	/**
	 * The open brace character.
	 */
	public static final char OPEN_BRACE = '{';

	/**
	 * The closed brace character.
	 */
	public static final char CLOSED_BRACE = '}';

	/**
	 * The pound sign character.
	 */
	public static final char POUND_SIGN = '#';

	/**
	 * The open variable string.
	 */
	public static final String OPEN_CONSTANT = "#[";

	/**
	 * The closed brace string.
	 */
	public static final String CLOSED_CONSTANT = "]";
	
	/**
	 * The open variable string.
	 */
	public static final String OPEN_VARIABLE = String.valueOf(POUND_SIGN) + String.valueOf(OPEN_BRACE);

	/**
	 * The closed brace string.
	 */
	public static final String CLOSED_VARIABLE = String.valueOf(CLOSED_BRACE);
	
	/**
	 * The NULL string.
	 */
	public final static String RESULT_NULL_STRING = "'NULL'";
	
	/**
	 * Indicates that the function result is a param value.
	 */
	public static final String PARAM_RESULT_STRING = "PARAM";
	
	/**
	 * Indicates that the function result is a ldap value.
	 */
	public static final String LDPAP_RESULT_STRING = "LDPAP";
	
	/**
	 * Indicates that the function result is a param value.
	 */
	public static final String VARIABLE_PARAM_STRING = "#{" + PARAM_RESULT_STRING + "}";

	/**
	 * Indicates that the function result is a param value.
	 */
	public static final String VARIABLE_LDPAP_STRING = "#{" + LDPAP_RESULT_STRING + "}";
	
	/**
	 * The true value for a Boolean string.
	 */
	public static final String BOOLEAN_STRING_TRUE = "1.0";

	/**
	 * The false value for a Boolean string.
	 */
	public static final String BOOLEAN_STRING_FALSE = "0.0";
	
	/**
	 * The comma character.
	 */
	public static final char COMMA = ',';
	
	
	/**
	 * The function argument separator.
	 */
	public static final char FUNCTION_ARGUMENT_SEPARATOR = COMMA;
	
	/**
	 * Indicates that the function result is a null value.
	 */
	public static final String FUNCTION_RESULT_TYPE_NULL = "NULL";

	/**
	 * Indicates that the function result is a numeric or Boolean value.
	 */
	public static final int FUNCTION_RESULT_TYPE_NUMERIC = 0;

	/**
	 * Indicates that the function result is a string value.
	 */
	public static final int FUNCTION_RESULT_TYPE_STRING = 1;
	
	/**
	 * Indicates that the function result is a string value.
	 */
	public static final int FUNCTION_RESULT_TYPE_OBJECT = 2;
}
