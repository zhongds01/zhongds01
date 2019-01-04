package com.ai.sacenter.jeval.function.string;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.jeval.EvaluationConstants;
import com.ai.sacenter.jeval.EvaluationException;
import com.ai.sacenter.jeval.FunctionResult;
import com.ai.sacenter.jeval.JevalEvaluator;
import com.ai.sacenter.jeval.function.FunctionException;
import com.ai.sacenter.jeval.function.FunctionGroup;
import com.ai.sacenter.jeval.function.FunctionHelper;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * A groups of functions that can loaded at one time into an instance of
 * Evaluator. This group contains all of the functions located in the
 * com.ai.sacenter.jeval.function.string package.
 */
public class StringFunctions implements FunctionGroup {
	/**
	 * Used to store instances of all of the functions loaded by this class.
	 */
	private java.util.List functions = new java.util.ArrayList();

	/**
	 * Default contructor for this class. The functions loaded by this class are
	 * instantiated in this constructor.
	 */
	public StringFunctions() {
		functions.add(new CharAt());
		functions.add(new CompareTo());
		functions.add(new CompareToIgnoreCase());
		functions.add(new Concat());
		functions.add(new EndsWith());
		functions.add(new Equals());
		functions.add(new EqualsIgnoreCase());
		functions.add(new Eval());
		functions.add(new IndexOf());
		functions.add(new LastIndexOf());
		functions.add(new Length());
		functions.add(new Replace());
		functions.add(new StartsWith());
		functions.add(new Substring());
		functions.add(new ToLowerCase());
		functions.add(new ToUpperCase());
		functions.add(new Trim());
		functions.add(new Expr());
		functions.add(new Expm());
		functions.add(new Like());
		functions.add(new NotLike());
		functions.add(new Contains() );
		functions.add(new NotContains() );
		functions.add(new Format() );
		functions.add(new Sysdate() );
		functions.add(new Decode() );
		functions.add(new Middle() );
		functions.add(new ToDouble() );
		functions.add(new Lmic() );
		functions.add(new Ltrim() );
		functions.add(new Rtrim() );
	}

	/**
	 * Returns the name of the function group - "stringFunctions".
	 * 
	 * @return The name of this function group class.
	 */
	public String getName() {
		return "stringFunctions";
	}

	/**
	 * Returns a list of the functions that are loaded by this class.
	 * 
	 * @return A list of the functions loaded by this class.
	 */
	public java.util.List getFunctions() {
		return functions;
	}

	/**
	 * Loads the functions in this function group into an instance of Evaluator.
	 * 
	 * @param evaluator
	 *            An instance of Evaluator to load the functions into.
	 */
	public void load(final JevalEvaluator evaluator) {
		java.util.Iterator functionIterator = functions.iterator();
		while (functionIterator.hasNext()) {
			evaluator.putFunction((Function) functionIterator.next());
		}
	}

	/**
	 * Unloads the functions in this function group from an instance of
	 * Evaluator.
	 * 
	 * @param evaluator
	 *            An instance of Evaluator to unload the functions from.
	 */
	public void unload(final JevalEvaluator evaluator) {
		java.util.Iterator functionIterator = functions.iterator();
		while (functionIterator.hasNext()) {
			evaluator.removeFunction(((Function) functionIterator.next())
					.getName());
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the character at the specified index in the source string. See the
	 * String.charAt(int) method in the JDK for a complete description of how this
	 * function works.
	 */
	public static class CharAt implements Function {

		public CharAt(){
			super();
		}
		
		/**
		 * 
		 */
		public String getName() {
			return "charAt";
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.FunctionGroup.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "One string and one integer argument are required.";
			java.util.ArrayList strings = FunctionHelper.getOneStringAndOneInteger(arguments, 
					EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 2 ) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String)strings.get(0), evaluator.getQuoteCharacter());
				int argumentTwo = ((Integer)strings.get(1)).intValue();
				result = new String(new char[]{ argumentOne.charAt( argumentTwo ) });
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
		
	}
	/**
	 * This class is a function that executes within Evaluator. The function
	 * compares two strings lexicographically. See the String.compareTo(String)
	 * method in the JDK for a complete description of how this function works.
	 */
	public static class CompareTo implements Function {
		public CompareTo(){
			super();
		}
		
		public String getName() {
			return "compareTo";
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.FunctionGroup.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			Integer result = null;
			String exceptionMessage = "Two string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, 
					EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 2 ) { throw new FunctionException(exceptionMessage); }
			try{
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				result = new Integer(argumentOne.compareTo(argumentTwo));
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result.toString(), EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function
	 * compares two strings lexicographically, ignoreing case considerations. See
	 * the String.compareTo(String) method in the JDK for a complete description of
	 * how this function works.
	 */
	public static class CompareToIgnoreCase implements Function {
		public CompareToIgnoreCase(){
			super();
		}
		
		public String getName() {
			return "compareToIgnoreCase";
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.FunctionGroup.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Integer result = null;
			String exceptionMessage = "Two string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 2 ) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				result = new Integer(argumentOne.compareToIgnoreCase(argumentTwo));
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result.toString(), EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function
	 * concatenates the second string to the end of the first. See the
	 * String.concat(String) method in the JDK for a complete description of how
	 * this function works.
	 */
	public static class Concat implements Function {
		public Concat(){
			super();
		}
		
		public String getName() {
			return "concat";
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.FunctionGroup.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			String result = null;
			String exceptionMessage = "Two more string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() < 1 ) { throw new FunctionException(exceptionMessage);}
			java.util.ArrayList _concatStrings = null;
			try{
				_concatStrings = FunctionHelper.trimAndRemoveQuoteStrings(strings, evaluator.getQuoteCharacter(), 0 );
				if( _concatStrings == null || _concatStrings.size()<= 0 ){
					result = EvaluationConstants.FUNCTION_RESULT_TYPE_NULL;
				}
				else{
					result = StringUtils.join( _concatStrings.iterator(), "" );
				}
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			finally{
				if( _concatStrings != null ){ _concatStrings.clear(); _concatStrings = null; }
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
	}
	public static class Contains implements Function {

		public Contains() {
			super();
		}

		public String getName() {
			return "contain";
		}
		
		public FunctionResult execute(JevalEvaluator evaluator, String arguments)
				throws FunctionException {
			String result = null;
			String exceptionMessage = "GreeterTwo string arguments argument are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() < 2 ) throw new FunctionException(exceptionMessage);
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars((String) strings.get(0), evaluator.getQuoteCharacter() );
				String argumentTwo[] = FunctionHelper.trimAndRemoveQuoteChars(strings, evaluator.getQuoteCharacter(), 1 );
				result = StringUtils.wildcardMatch( argumentOne , argumentTwo )? EvaluationConstants.BOOLEAN_STRING_TRUE:
					EvaluationConstants.BOOLEAN_STRING_FALSE;
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}


	}
	/**
	 * This class is a function that executes within Evaluator. The function tests
	 * if the string starts with a specified prefix beginning at a specified index.
	 * See the String.startsWith(String, int) method in the JDK for a complete
	 * description of how this function works.
	 */
	public static class StartsWith implements Function {
		public StartsWith(){
			super();
		}
		
		public String getName() {
			return "startsWith";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "Two string arguments and one integer argument are required.";
			java.util.ArrayList strings = FunctionHelper.getTwoStringsAndOneInteger(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 2) { throw new FunctionException(exceptionMessage); }
			try{
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				result = argumentOne.startsWith(argumentTwo)?EvaluationConstants.BOOLEAN_STRING_TRUE:
					EvaluationConstants.BOOLEAN_STRING_FALSE;
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function tests
	 * if the string ends with a specified suffix. See the String.endswith(String)
	 * method in the JDK for a complete description of how this function works.
	 */
	public static class EndsWith implements Function {

		public EndsWith(){
			super();
		}
		
		public String getName() {
			return "endsWith";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			String result = null;
			String exceptionMessage = "Two string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 2 ) { throw new FunctionException(exceptionMessage); }
			try{
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				result = argumentOne.endsWith( argumentTwo )?EvaluationConstants.BOOLEAN_STRING_TRUE:
					EvaluationConstants.BOOLEAN_STRING_FALSE;
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function tests
	 * one string equals another. See the String.equals(String) method in the JDK
	 * for a complete description of how this function works.
	 */
	public static class Equals implements Function {
		public Equals(){
			super();
		}
		
		public String getName() {
			return "equals";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "Two string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 2 ) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				result = argumentOne.equals(argumentTwo)?EvaluationConstants.BOOLEAN_STRING_TRUE:
					EvaluationConstants.BOOLEAN_STRING_FALSE;
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function tests
	 * one string equals another, but ignores case. See the
	 * String.equalsIgnoreCase(String) method in the JDK for a complete description
	 * of how this function works.
	 */
	public static class EqualsIgnoreCase implements Function {
		public EqualsIgnoreCase(){
			super();
		}
		
		public String getName() {
			return "equalsIgnoreCase";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			String result = null;
			String exceptionMessage = "Two string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);

			if( strings.size() != 2 ) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				result = argumentOne.equalsIgnoreCase(argumentTwo)?EvaluationConstants.BOOLEAN_STRING_TRUE:
					EvaluationConstants.BOOLEAN_STRING_FALSE;
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the result of a Evaluator compatible expression. See the
	 * Evaluator.evaluate(String) method for a complete description of how this
	 * function works.
	 */
	public static class Eval implements Function {
		public Eval(){
			super();
		}
		
		public String getName() {
			return "eval";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			try{
				result = evaluator.evaluate(arguments, false, true);
			} 
			catch (EvaluationException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			}
			int resultType = EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC;
			try {
				Double.parseDouble(result);
			} catch (NumberFormatException exception) {
				resultType = EvaluationConstants.FUNCTION_RESULT_TYPE_STRING;
			}
			return new FunctionResult(result, resultType);
		}
	}
	
	public static class Expr implements Function {

		public Expr() {
			super();
		}

		public String getName() {
			return "expr";
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "third string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings( arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR );
			if ( strings.size() < 2 ){ throw new FunctionException(exceptionMessage); }
			try {
				boolean _boolean = evaluator.getBooleanResult( strings.get( 0 ).toString() );
				result = _boolean?(String)strings.get( 1 ):( strings.size() == 3?(String)strings.get( 2 ):
					EvaluationConstants.FUNCTION_RESULT_TYPE_NULL ); 
			}
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}

	}
	
	public static class Expm implements Function{
		public Expm(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.Function#getName()
		 */
		public String getName() {
			return "expm";
		}

		/**
		 * 
		 * @param aTEMPLATE
		 * @param fromPARAM
		 * @param evaluator
		 * @return
		 * @throws Exception
		 */
		private java.util.Map getResult( String aTEMPLATE, java.util.Map fromPARAM, JevalEvaluator evaluator ) throws Exception{
			java.util.Map fromJEXP = new java.util.HashMap();
			try
			{
				int aUberIndex = 1;
				aTEMPLATE = StringUtils.replace(StringUtils.replace( aTEMPLATE, "&", ";" ),"$", "#" );
				evaluator.getVariables().put( "literalCount", String.valueOf( fromPARAM.size() ) );
				for( java.util.Iterator itera = fromPARAM.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry aUberInfo = (java.util.Map.Entry)itera.next();
					evaluator.putVariable("literalIndex", String.valueOf( aUberIndex ));
				    evaluator.getVariables().put("literalKey", aUberInfo.getKey() );
				    evaluator.getVariables().put("literalValue", aUberInfo.getValue() );
				    FunctionHelper._trimQuote( evaluator.evaluate( aTEMPLATE ), fromJEXP );
				    aUberIndex++;
				}
			}
			finally{
				evaluator.getVariables().remove("literalIndex");
				evaluator.getVariables().remove("literalCount");
				evaluator.getVariables().remove("literalKey");
				evaluator.getVariables().remove("literalValue");
			}
			return fromJEXP;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			java.util.Map fromJEXP = null;
			java.util.Map fromPARA = new java.util.HashMap();
			String exceptionMessage = "two string arguments are required.";
			try
			{
				java.util.ArrayList strings = FunctionHelper.getStrings( arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR );
				if ( strings.size() < 2 ) throw new FunctionException(exceptionMessage);
				java.util.Map fromPARAM = (java.util.Map)evaluator.getVariables().get( IUpdcConst.IUpdbm.IUpdbf.PARAM );
				IUpdcContext fromLDAP = (IUpdcContext)evaluator.getVariables().get( IUpdcConst.IUpdbm.IUpdbf.LDPAP );
				String aTEMPLATE = StringUtils.replace( (String)strings.get( 0 ), "&", ";" );
				aTEMPLATE = FunctionHelper.trimQuote( aTEMPLATE, EvaluationConstants.SINGLE_QUOTE );
				IUpdcpFactory.getIUpfwmSV().finishSFUpdbmChain( aTEMPLATE, 
						fromPARAM, 
						fromPARA, 
						fromLDAP );
				if( fromPARA != null && fromPARA.size() > 0 ){
					fromJEXP = getResult( (String)strings.get( 1 ), fromPARA, evaluator);
					result = JdomUtils.ICustom.wrap( fromJEXP, null );
				}
			}
			catch (Exception exception) {
				if( exception instanceof FunctionException ){ throw (FunctionException)exception; }
				else { throw new FunctionException( exceptionMessage, exception); }
		    }
			finally{
				if( fromJEXP != null ){ fromJEXP.clear(); fromJEXP = null; }
				if( fromPARA != null ){ fromPARA.clear(); fromPARA = null; }
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the index within the source string of the first occurrence of the substring,
	 * starting at the specified index. See the String.indexOf(String, int) method
	 * in the JDK for a complete description of how this function works.
	 */
	public static class IndexOf implements Function {
		public IndexOf(){
			super();
		}
		
		public String getName() {
			return "indexOf";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "Two string arguments and one integer argument are required.";
			java.util.ArrayList strings = FunctionHelper.getTwoStringsAndOneInteger(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 3 ) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				int argumentThree = ((Integer) strings.get(2)).intValue();
				result = String.valueOf( argumentOne.indexOf( argumentTwo, argumentThree ) );
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the index within the source string of the last occurrence of the substring,
	 * starting at the specified index. See the String.lastIndexOf(String, int)
	 * method in the JDK for a complete description of how this function works.
	 */
	public static class LastIndexOf implements Function {
		public LastIndexOf(){
			super();
		}
		
		public String getName() {
			return "lastIndexOf";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "Two string arguments and one integer argument are required.";
			java.util.ArrayList strings = FunctionHelper.getTwoStringsAndOneInteger(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 3 ) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				int argumentThree = ((Integer) strings.get(2)).intValue();
				result = String.valueOf( argumentOne.lastIndexOf(argumentTwo, argumentThree) );
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result.toString(), EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the length of the source string. See the String.length() method in the JDK
	 * for a complete description of how this function works.
	 */
	public static class Length implements Function {
		public Length(){
			super();
		}
		
		public String getName() {
			return "length";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "One string argument is required.";
			java.util.ArrayList strings = FunctionHelper.getTwoStringsAndOneInteger(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 1 ) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				result = String.valueOf( argumentOne.length() );
			} 
			catch (FunctionException exception) {
				throw new FunctionException(exception.getMessage(), exception);
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the like of the source string. See the String.like() method in the JDK
	 * for a complete description of how this function works.
	 */
	public static class Like implements Function {

		public Like(){
			super();
		}
		
		public String getName() {
			return "like";
		}
		
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "Two string arguments argument are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() != 2 ) throw new FunctionException(exceptionMessage);
			try{
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				result = StringUtils.wildcardMatch( argumentOne , argumentTwo )?EvaluationConstants.BOOLEAN_STRING_TRUE:
					EvaluationConstants.BOOLEAN_STRING_FALSE;
			} 
			catch (FunctionException exception) {
				throw exception;
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * @author Administrator
	 *
	 */
	public static class NotContains implements Function {

		public NotContains() {
			super();
		}

		public String getName() {
			return "ncontain";
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "GreeterTwo string arguments argument are required.";
			java.util.ArrayList strings = FunctionHelper.getTwoStringsAndOneInteger(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if( strings.size() <= 2 ) throw new FunctionException(exceptionMessage);
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				result = StringUtils.contains( argumentOne, FunctionHelper.trimAndRemoveQuoteChars(strings, 
						evaluator.getQuoteCharacter(), 1 ) )?EvaluationConstants.BOOLEAN_STRING_FALSE:
							EvaluationConstants.BOOLEAN_STRING_TRUE;
			} 
			catch (FunctionException exception) {
				throw exception;
			} 
			catch (Exception exception) {
				throw new FunctionException(exceptionMessage, exception);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}

	}
	/**
	 * @author Administrator
	 * The nlike operator.
	 */
	public static class NotLike implements Function {
		public NotLike(){
			super();
		}
		
		public String getName() {
			return "nlike";
		}
		
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "Two string arguments argument are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 2) throw new FunctionException(exceptionMessage);
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				result = StringUtils.wildcardMatch( argumentOne , argumentTwo )?EvaluationConstants.BOOLEAN_STRING_FALSE:
					EvaluationConstants.BOOLEAN_STRING_TRUE;
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}

			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * a new string with all of the occurances of the old character in the source
	 * string replaced with the new character. See the String.replace(char, char)
	 * method in the JDK for a complete description of how this function works.
	 */
	public static class Replace implements Function {
		public Replace(){
			super();
		}
		
		public String getName() {
			return "replace";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "One string argument and two character arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 3) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				String argumentThree = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(2), evaluator.getQuoteCharacter());
				char oldCharacter = ' ';
				if (argumentTwo.length() == 1) {
					oldCharacter = argumentTwo.charAt(0);
				} else {
					throw new FunctionException(exceptionMessage);
				}
				char newCharacter = ' ';
				if (argumentThree.length() == 1) {
					newCharacter = argumentThree.charAt(0);
				} else {
					throw new FunctionException(exceptionMessage);
				}
				result = argumentOne.replace(oldCharacter, newCharacter);
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
	}
	
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * a string that is a substring of the source string. See the
	 * String.substring(int, int) method in the JDK for a complete description of
	 * how this function works.
	 */
	public static class Substring implements Function {
		public Substring(){
			super();
		}
		
		public String getName() {
			return "substring";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			String result = null;
			String exceptionMessage = "One string argument and two integer arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getOneStringAndTwoIntegers(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 3) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				int beginningIndex = ((Integer) strings.get(1)).intValue();
				if( beginningIndex < 0 ){ beginningIndex = 0; }
				int endingIndex = ((Integer) strings.get(2)).intValue();
				if( endingIndex > argumentOne.length() ){ endingIndex = argumentOne.length(); }
				result = argumentOne.substring(beginningIndex, endingIndex);
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the source string in lower case. See the String.toLowerCase() method in the
	 * JDK for a complete description of how this function works.
	 */
	public static class ToLowerCase implements Function {
		public ToLowerCase(){
			super();
		}
		
		public String getName() {
			return "toLowerCase";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "One string argument is required.";
			java.util.ArrayList strings = FunctionHelper.getOneStringAndTwoIntegers(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 1) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				result = argumentOne.toLowerCase();
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the source string in upper case. See the String.toUpperCase() method in the
	 * JDK for a complete description of how this function works.
	 */
	public static class ToUpperCase implements Function {
		public ToUpperCase(){
			super();
		}
		
		public String getName() {
			return "toUpperCase";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "One string argument is required.";
			java.util.ArrayList strings = FunctionHelper.getOneStringAndTwoIntegers(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 1) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				result = argumentOne.toUpperCase();
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the source string with white space removed from both ends. See the
	 * String.trim() method in the JDK for a complete description of how this
	 * function works.
	 */
	public static class Trim implements Function {
		public Trim(){
			super();
		}
		
		public String getName() {
			return "trim";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "One string argument is required.";
			java.util.ArrayList strings = FunctionHelper.getOneStringAndTwoIntegers(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 1) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				result = argumentOne.trim();
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
	}
	
	public static class Ltrim implements Function{
		public Ltrim(){
			super();
		}
		
		public String getName() {
			return "ltrim";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "one string arguments and one integer " + "argument are required.";
			java.util.ArrayList strings = FunctionHelper.getOneStringAndOneInteger(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 2) throw new FunctionException(exceptionMessage);
			try{
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				int endingIndex = ((Integer) strings.get(1)).intValue();
				result = StringUtils.substring( argumentOne , 0, endingIndex );
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
	}
	
	public static class Rtrim implements Function{
		public Rtrim(){
			super();
		}
		
		public String getName() {
			return "rtrim";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "one string arguments and one integer argument are required.";
			java.util.ArrayList strings = FunctionHelper.getOneStringAndOneInteger(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 2) throw new FunctionException(exceptionMessage);
			try{
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				int endingIndex = ((Integer) strings.get(1)).intValue();
				if( argumentOne.length() < endingIndex ) endingIndex = argumentOne.length();
				result = StringUtils.substring( argumentOne , argumentOne.length() - endingIndex , argumentOne.length() );
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the source string with white space removed from both ends. See the
	 * Timesamp.Format() method in the JDK for a complete description of how this
	 * function works.
	 */
	public static class Format implements Function{
		public Format(){
			super();
		}
		
		public String getName() {
			return "format";
		}
		
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "Two string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments,  EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 2) { throw new FunctionException(exceptionMessage); }
			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(1), evaluator.getQuoteCharacter());
				result = TimeUtils.format( TimeUtils.getTime( argumentOne ), argumentTwo );
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result, EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}		
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the source string with white space removed from both ends. See the
	 * Decode method in the JDK for a complete description of how this
	 * function works.
	 */
	public static class Decode implements Function{
		public Decode(){
			super();
		}
		
		public String getName() {
			return "decode";
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.FunctionGroup.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "More than three string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() < 3) { throw new FunctionException(exceptionMessage); }

			try {
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars( (String) strings.get(0), evaluator.getQuoteCharacter());
				String argumentTwo[] = FunctionHelper.trimAndRemoveQuoteChars( strings, evaluator.getQuoteCharacter() , 1 );
				for(int index = 0 ; argumentTwo.length >= 2 && index < argumentTwo.length / 2 ;index++ ){
					if( argumentTwo[index*2].equals( argumentOne ) ){ result = argumentTwo[index*2+1];break;}
				}
				if( result == null && argumentTwo.length == argumentTwo.length / 2*2 + 1 ) result = argumentTwo[argumentTwo.length-1];
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result != null?result:EvaluationConstants.FUNCTION_RESULT_TYPE_NULL, 
					EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}		
	}
	
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the source string with white space removed from both ends. See the
	 * Decode method in the JDK for a complete description of how this
	 * function works.
	 */
	public static class Sysdate implements Function{
		public Sysdate(){
			super();
		}
		
		public String getName() {
			return "sysdate";
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.FunctionGroup.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "two string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR );
			try 
			{
				String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(strings, 0, evaluator.getQuoteCharacter(), "NULL" );
				String argumentTwo = strings.size() > 1?((String)strings.get( 1 )).trim():null;
				java.sql.Timestamp _sysdate = TimeUtils.getTime( argumentOne );
				if( argumentTwo == null ){
					result = TimeUtils.format( _sysdate, "yyyyMMddHHmmss" );
				}
				else if( FunctionHelper.isQuoteString( argumentTwo ) == false && 
						FunctionHelper.isNumeric( argumentTwo ) ){
					Double _double = new Double( argumentTwo );
					_sysdate = TimeUtils.addSecond( _sysdate, _double.intValue() );
					result = TimeUtils.format( _sysdate, "yyyyMMddHHmmss" );
				}
				else{
					argumentTwo = FunctionHelper.trimAndRemoveQuoteChars( argumentTwo, evaluator.getQuoteCharacter() );
					result = TimeUtils.format( _sysdate, argumentTwo );
				}
			} 
			catch (FunctionException exception) {
				throw exception;
			} 
			catch (Exception exception) {
				throw new FunctionException( exceptionMessage, exception );
			}
			return new FunctionResult(result != null?result:EvaluationConstants.FUNCTION_RESULT_TYPE_NULL, 
					EvaluationConstants.FUNCTION_RESULT_TYPE_STRING);
		}		
	}
	
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the source string with white space removed from both ends. See the
	 * Decode method in the JDK for a complete description of how this
	 * function works.
	 */
	public static class Middle implements Function{
		public Middle(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.FunctionGroup.Function#getName()
		 */
		public String getName() {
			return "middle";
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.function.FunctionGroup.Function#execute(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "three string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR );
			if( strings.size() < 3 ) { throw new FunctionException( exceptionMessage ); }
			try 
			{
				String argumentOne = (String)strings.get( 0 ), argumentTwo = (String) strings.get( 1 ),
						argumentThree = (String)strings.get( 2 );
				result = argumentTwo.compareTo( argumentOne ) >= 0 && argumentThree.compareTo( argumentTwo ) >= 0?
						EvaluationConstants.BOOLEAN_STRING_TRUE:EvaluationConstants.BOOLEAN_STRING_FALSE;
			}
			catch (Exception exception) {
				throw new FunctionException( exceptionMessage, exception );
			}
			return new FunctionResult( result, EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC );
		}		
	}
	
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the source string with white space removed from both ends. See the
	 * Decode method in the JDK for a complete description of how this
	 * function works.
	 */
	public static class ToDouble implements Function{
		public ToDouble(){
			super();
		}
		
		public String getName() {
			return "toDouble";
		}
		
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			String result = null;
			String exceptionMessage = "More than one string arguments are required.";
			java.util.ArrayList strings = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
			if (strings.size() != 1 ) throw new FunctionException(exceptionMessage);
			try {
				String argumentOne = (String) strings.get(0);
				if( StringUtils.equals( argumentOne , EvaluationConstants.FUNCTION_RESULT_TYPE_NULL ) ) argumentOne = "'0'";
				result = FunctionHelper.trimQuote( argumentOne, evaluator.getQuoteCharacter());
			} 
			catch (FunctionException fe) {
				throw new FunctionException(fe.getMessage(), fe);
			} 
			catch (Exception e) {
				throw new FunctionException(exceptionMessage, e);
			}
			return new FunctionResult(result , EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}	
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the source string with white space removed from both ends. See the
	 * Decode method in the local for a complete description of how this
	 * function works.
	 */
	public static class Lmic implements Function{
		public Lmic(){
			super();
		}
		
		public String getName() {
			return "lmic";
		}
		
		public FunctionResult execute(JevalEvaluator evaluator, String arguments) throws FunctionException {
			FunctionResult result = null;
			try
			{
				String exceptionMessage = "More than one string arguments are required.";
				java.util.ArrayList fromPARAM = FunctionHelper.getStrings(arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
				if( fromPARAM.size() < 1 ) throw new FunctionException( exceptionMessage );
				String fromMethod = (String)fromPARAM.get( 0 );
				String strings[] = FunctionHelper.trimAndRemoveQuoteChars( fromPARAM, evaluator.getQuoteCharacter(), 1 );
				Object fromResult = ReflectUtils.IReflect.invokeLmic(fromMethod, 
						strings, 
						evaluator.getVariables() );
				result = FunctionHelper.getFunctionResult( fromResult );
			}
			catch( FunctionException aException ){
				throw aException;
			}
			catch (Exception aException) {
				throw new FunctionException(aException.getMessage(), aException);
			}
			return result;
		}
	}
}
