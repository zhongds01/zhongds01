/*
 * Copyright 2002-2007 Robert Breidecker.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ai.sacenter.jeval;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ai.sacenter.jeval.function.FunctionException;
import com.ai.sacenter.jeval.function.FunctionGroup;
import com.ai.sacenter.jeval.function.FunctionHelper;
import com.ai.sacenter.jeval.function.math.MathFunctions;
import com.ai.sacenter.jeval.function.string.StringFunctions;
import com.ai.sacenter.jeval.operator.AbstractOperator;
import com.ai.sacenter.jeval.operator.Operator;
import com.ai.sacenter.util.ArrayDeque;
import com.ai.sacenter.util.MathUtils;

/**
 * This class is used to evaluate mathematical, string, Boolean and functional
 * expressions. It is the main entry point into the JEval API.<br>
 * <br>
 * The following types of expressions are supported:<br>
 * <ul>
 * <li><i>mathematical</i> Expression involving numbers. Numbers are treated
 * as doubles, so resulting numbers will contain at least one decimal place.</li>
 * <li><i>string</i> String can also be added together, compared, etc...</li>
 * <li><i>Boolean</i> Expression that evaluate to true (1.0) and false (0.0).</li>
 * <li><i>functional</i> Custom functions can be created or there are many
 * Math and String functions that JEval supplies with this class.</li>
 * </ul>
 * The following operators are supported:<br>
 * <ul>
 * <li>( open parentheses</li>
 * <li>) closed parentheses</li>
 * <li>+ addition (for numbers and strings)</li>
 * <li>- subtraction</li>
 * <li>* multiplication</li>
 * <li>/ division</li>
 * <li>% modulus</li>
 * <li>+ unary plus</li>
 * <li>- unary minus</li>
 * <li>= equal (for numbers and strings)</li>
 * <li>!= not equal (for numbers and strings)</li>
 * <li>< less than (for numbers and strings)</li>
 * <li><= less than or equal (for numbers and strings)</li>
 * <li>> greater than (for numbers and strings)</li>
 * <li>>= greater than or equal (for numbers and strings)</li>
 * <li>&& boolean and</li>
 * <li>|| boolean or</li>
 * <li>! boolean not</li>
 * </ul>
 * Allows for prebuilt and custom functions.<br>
 * <ul>
 * <li>JEval already comes with many functions which represent most of the
 * methods in the Math and String classes in the standard JDK.</li>
 * <li>Thirty-nine math and string functions come built in. See the
 * com.ai.sacenter.jeval.functions.math and
 * com.ai.sacenter.jeval.functions.string packages for details on these ready to
 * use functions. You can choose to not load these functions if we you want to
 * gain a small improvement in performance.</li>
 * <li>Functions must be followed by an open parentheses and a closed
 * parentheses which contain any required parameters.</li>
 * <li>For more details on functions, see the Function class and the test
 * classes.</li>
 * </ul>
 * Allows for variables.<br>
 * <ul>
 * <li>Variable must be enclosed by a pound sign and open brace #{ and a closed
 * brace }. i.e. expression = "#{a} + #{b}"</li>
 * <li>Two math variables come built in. The E and PI variables represent the
 * same value as the Math.E and Math.PI constants in the standard Java SDK. You
 * can choose not to load these variables.</li>
 * </ul>
 * Notes on expression parsing:
 * <ul>
 * <li>Spaces are ignored when parsing expressions.</li>
 * <li>The order of precedence used by this class is as follows from highest to
 * lowest.</li>
 * <li>The expression is evaluated as one or more subexpressions.
 * Subexpressions within open parentheses and closed parentheses are evaluated
 * before other parts of the expression.</li>
 * <li>Inner most subexpression are evaluated first working outward.</li>
 * <li>Subexpressions at the same level are evaluated from left to right.</li>
 * <li>When evaluating expressions and subexpressions, operators are evaluated
 * with the following precedence listed below.</li>
 * <li>Operators with with the same precedence are evaluated from left to
 * right.</li>
 * <li>Once the expression is parsed, Variables are replaced with their values.
 * The evaluator has its own internal variable map that it used to resolve
 * variable values. All of the variable related methods on the evaluator refer
 * to this internal map. You can choose to set you own variable resolver on your
 * evaluator instance. If you do this, then variables resolved by your resolver
 * will override any variables in the evaluator's internal variable map.</li>
 * <li>Functions are then executed and replaced with their results. Function
 * arguments are each individually evaluated as subexpressions that are comma
 * separated. This gives you the ability to use nested functions in your
 * expressions. You can choose not to evaluate function arguments as expressions
 * and instead let the functions handle the arguments themselves. This in effect
 * turns off nested expressions, unless you code nested expression support into
 * your own custom functions.</li>
 * <li>Once all variables and functions are resolved, then the parsed
 * expression and subexpressions are evaluated according to operator precedence.</li>
 * </ul>
 * Operator precedence:
 * <ul>
 * <li>+ unary plus, - unary minus, ! boolean not</li>
 * <li>* multiplication, / division, % modulus</li>
 * <li>+ addition, - subtraction</li>
 * <li>< less than, <= less than or equal, > greater than, >= greater than or
 * equal</li>
 * <li>= equal, != not equal</li>
 * <li>&& boolean and</li>
 * <li>|| boolean or</li>
 * </ul>
 * Function and variable names can not break any of the following rules:<br>
 * <ul>
 * <li>can not start with a number</li>
 * <li>can not contain an operator (see the above list of operators)/li>
 * <li>can not contain a quote character - single or double/li>
 * <li>can not contain a brace character - open or closed/li>
 * <li>can not contain one of the following special characters: #, ~ , ^ !</li>
 * </ul>
 * Other Notes:
 * <ul>
 * <li>This class is not thread safe.</li>
 * <li>Allows for the quote character (single or double) to be specified at run
 * time. Quote characters are required for specifying string values.</li>
 * <li>Expressions can contain different types of expressions within the same
 * expression. However, Numeric and string types can not be mixed in a left /
 * right operand pair.</li>
 * <li>An expression can be parsed before being evaluated by calling the parse()
 * method. This may save on response time if parsing takes more than a few 
 * seconds. However, parsing is usually very fast, so this is probably not 
 * needed.</li>
 * <li>If an expression does not change, it will not be parsed each
 * time the expression is evaluated. Therefore, variables values can change and
 * the expression can be evaluated again without having to re-parse the
 * expression.</li>
 * <li>Nested functions calls are supported. Nested function support can be
 * turned off to improve performance. Custom functions can be coded to handle
 * nested calls instead if desired.</li>
 * <li>The string used to start variables, "#{", can not appear in an
 * expression.
 * <li>See the evaluate methods in this class, JUnit tests and samples for more
 * details.</li>
 * </ul>
 */
public class JevalEvaluator {

	// Contains all of the operators.
	private List operators = new ArrayList();

	// Contains all of the functions in use.
	private Map functions = new HashMap();

	// Contains all of the variables in use.
	private Map variables = new HashMap();

	// The quote character in use.
	private char quoteCharacter = EvaluationConstants.SINGLE_QUOTE;

	// The open parentheses operator.
	private Operator openParenthesesOperator = new AbstractOperator.OpenParenthesesOperator();

	// The closed parentheses operator.
	private Operator closedParenthesesOperator = new AbstractOperator.ClosedParenthesesOperator();

	// Indicates if the user wants to load the system math variables.
	private boolean loadMathVariables;

	// Indicates if the user wants to load the system math functions.
	private boolean loadMathFunctions;

	// Indicates if the user wants to load the system string functions.
	private boolean loadStringFunctions;
	
	// Indicates if the user wants to process nested function calls.
	private boolean processNestedFunctions;

	// Saves the previous expression, because we do not want to parse it, if
	// it did not change.
	private String previousExpression = null;

	// The previous stack of parsed operators
	private ArrayDeque previousOperatorStack = null;

	// The previous stack of parsed operands.
	private ArrayDeque previousOperandStack = null;

	// The stack of parsed operators
	private ArrayDeque operatorStack = null;

	// The stack of parsed operands.
	private ArrayDeque operandStack = null;
	
	// Allows for user to set their own variable resolver.
	private VariableResolver variableResolver = null;

	/**
	 * The default constructor. This constructor calls the five parameter
	 * Evaluator constructor and passes in the following default values:
	 * SINGLE_QUOTE, true, true, true and true.
	 */
	public JevalEvaluator() {
		this(EvaluationConstants.SINGLE_QUOTE, true, true, true, true);
	}

	/**
	 * The main constructor for Evaluator.
	 * 
	 * @param quoteCharacter
	 *            The quote character to use when evaluating expression.
	 * @param loadMathVariables
	 *            Indicates if the standard Math variables should be loaded or
	 *            not.
	 * @param loadMathFunctions
	 *            Indicates if the standard Math functions should be loaded or
	 *            not.
	 * @param loadStringFunctions
	 *            Indicates if the standard String functions should be loaded or
	 *            not.
	 * @param processNestedFunctions
	 *            Indicates if nested function calls should be processed or not.
	 * 
	 * @exception IllegalArgumentException
	 *                Thrown when the quote character is not a valid quote
	 *                character.
	 */
	public JevalEvaluator(final char quoteCharacter,
			final boolean loadMathVariables, final boolean loadMathFunctions,
			final boolean loadStringFunctions,
			final boolean processNestedFunctions) {

		// Install the operators used by Evaluator.
		installOperators();

		// Install the system variables.
		this.loadMathVariables = loadMathVariables;
		loadSystemVariables();

		// Install the system functions.
		this.loadMathFunctions = loadMathFunctions;
		this.loadStringFunctions = loadStringFunctions;
		loadSystemFunctions();

		// Set the default quote character.
		setQuoteCharacter(quoteCharacter);

		// Process nested function calls.
		this.processNestedFunctions = processNestedFunctions;
	}

	/**
	 * Returns the current quote character in use.
	 * 
	 * @return The quote character in use.
	 */
	public char getQuoteCharacter() {
		return quoteCharacter;
	}

	/**
	 * Sets the quote character to use when evaluating expressions.
	 * 
	 * @param quoteCharacter
	 *            The quote character to use when evaluating expressions.
	 * 
	 * @exception IllegalArgumentException
	 *                Thrown when the quote character is not a valid quote
	 *                character.
	 */
	public void setQuoteCharacter(final char quoteCharacter) {
		if (quoteCharacter == EvaluationConstants.SINGLE_QUOTE
				|| quoteCharacter == EvaluationConstants.DOUBLE_QUOTE) {
			this.quoteCharacter = quoteCharacter;
		} else {
			throw new IllegalArgumentException("Invalid quote character.");
		}
	}

	/**
	 * Adds a function to the list of functions to use when evaluating
	 * expressions.
	 * 
	 * @param function
	 *            The function being added.
	 * 
	 * @exception IllegalArgumentException
	 *                Thrown when the function name is not valid or the function
	 *                name is already in use.
	 */
	public void putFunction(final FunctionGroup.Function function) {
		// Make sure the function name is valid.
		isValidName(function.getName());

		// Make sure the function name isn't already in use.
		final FunctionGroup.Function existingFunction = (FunctionGroup.Function) functions.get(function
				.getName());

		if (existingFunction == null) {
			functions.put(function.getName(), function);
		} else {
			throw new IllegalArgumentException("A function with the same name "
					+ "already exists.");
		}
	}

	/**
	 * Returns a funtion from the list of functions. If the function can not be
	 * found in the list of functions, then null will be returned.
	 * 
	 * @param functionName
	 *            The name of the function to retrieve the value for.
	 * 
	 * @return The value for a function in the list of function.
	 */
	public FunctionGroup.Function getFunction(final String functionName) {
		return (FunctionGroup.Function) functions.get(functionName);
	}

	/**
	 * Removes the function from the list of functions to use when evaluating
	 * expressions.
	 * 
	 * @param functionName
	 *            The name of the function to remove.
	 */
	public void removeFunction(final String functionName) {
		if (functions.containsKey(functionName)) {
			functions.remove(functionName);
		} else {
			throw new IllegalArgumentException("The function does not exist.");
		}
	}

	/**
	 * Removes all of the functions at one time.
	 */
	public void clearFunctions() {
		// Remove all functions.
		functions.clear();

		// Reload the system functions if necessary.
		loadSystemFunctions();
	}
	
	/**
	 * Rturns the map of functions currently set on this object.
	 * 
	 * @return the map of functions currently set on this object.
	 */
	public Map getFunctions() {
		return functions;
	}
	
	/**
	 * Sets the map of functions for this object.
	 * 
	 * @param functions The map of functions for this object.
	 */
	public void setFunctions(Map functions) {
		this.functions = functions;
	}

	/**
	 * Adds or replaces a variable to the list of variables to use when
	 * evaluating expressions. If the variable already exists, then its value
	 * will be overlaid.
	 * 
	 * @param variableName
	 *            The name of the variable being set.
	 * @param variableValue
	 *            The value for the variable being set.
	 */
	public void putVariable(final String variableName, final Object variableValue) {
		isValidName( variableName );
		variables.put( variableName, variableValue );
	}

	/**
	 * Returns the value for a variable in the list of variables. If the
	 * variable can not be found in the list of variables, then null will be
	 * returned.
	 * 
	 * @param variableName
	 *            The name of the variable to retrieve the value for.
	 * 
	 * @return The value for a variable in the list of variables.
	 * 
	 * @throws
	 *              if the variable name can not be resolved.
	 */
	public Object getVariable(final String variableName) throws EvaluationException {
		Object variableValue = null;
		FunctionResult result = null;
		try
		{
			variableValue = variables.get( variableName );
			if( variableValue == null && variableResolver != null ){
				result = variableResolver.resolveVariable( this , variableName );
				if( result != null && result.getType() == EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC ){
					variableValue = result.getAsDigital();
				}
				else if( result != null && result.getType() == EvaluationConstants.FUNCTION_RESULT_TYPE_STRING ){
					variableValue = result.getAsString();
				}
				else if( result != null ){
					variableValue = result.getAsObject();
				}
			}
		}
		catch( java.lang.Exception exception ){
			throw new EvaluationException( exception.getMessage(), exception );
		}
		finally{
			if( result != null ){ result = null; }
		}
		return variableValue != null?variableValue:EvaluationConstants.RESULT_NULL_STRING;
	}
	
    /**
	 * Returns the value for a variable in the list of variables. If the
	 * variable can not be found in the list of variables, then null will be
	 * returned.
	 * 
	 * @param variableName
	 *            The name of the variable to retrieve the value for.
	 * 
	 * @return The value for a variable in the list of variables.
	 * 
	 * @throws
	 *              if the variable name can not be
	 *             resolved.
	 */
	public String getVariableValue(final String variableName) throws EvaluationException {
		String variableValue = null;
		FunctionResult result = null;
		try
		{
			variableValue = (String)variables.get( variableName );
			if( variableValue == null && variableResolver != null ){
				result = variableResolver.resolveVariable( this , variableName );
				if( result != null ){ variableValue = result.getAsString(); }
			}
		}
		catch( EvaluationException exception ){
			throw exception;
		}
		catch( java.lang.Exception exception ){
			throw new EvaluationException( exception.getMessage(), exception );
		}
		finally{
			if( result != null ){ result = null; }
		}
		return variableValue != null?variableValue:EvaluationConstants.RESULT_NULL_STRING;
	}

	/**
	 * Removes the variable from the list of variables to use when evaluating
	 * expressions.
	 * 
	 * @param variableName
	 *            The name of the variable to remove.
	 */
	public void removeVaraible(final String variableName) {
		if( variables.containsKey( variableName ) ) {
			variables.remove(variableName);
		} 
		else {
			throw new IllegalArgumentException("The variable does not exist.");
		}
	}

	/**
	 * Removes all of the variables at one time.
	 */
	public void clearVariables() {
		// Remove all functions.
		variables.clear();

		// Reload the system variables if necessary.
		loadSystemVariables();
	}
	
	/**
	 * Rturns the map of variables currently set on this object.
	 * 
	 * @return the map of variables currently set on this object.
	 */
	public Map getVariables() {
		return variables;
	}
	
	/**
	 * Sets the map of variables for this object.
	 * 
	 * @param variables The map of variables for this object.
	 */
	public void setVariables(Map variables) {
		this.variables = variables;
	}	
	
	/**
	 * Returns the variable resolver.  The variable resolver can be used by 
	 * the user to resolve their own variables.  Variables in the variable
	 * resolver override any variables that are in this classes internal
	 * variable map.
	 * 
	 * @return The variable resolver.
	 */
	public VariableResolver getVariableResolver() {
		return variableResolver;
	}

	/**
	 * Sets the variable resolver for this class.  Varaibles resolved by the
	 * variable resolver will override any variables in this class's internal
	 * variable map.
	 * 
	 * @param variableResolver The variable resolver for this class.
	 */
	public void setVariableResolver(VariableResolver variableResolver) {
		this.variableResolver = variableResolver;
	}

	/**
	 * This method evaluates mathematical, boolean or functional expressions.
	 * See the class description and test classes for more information on how to
	 * write an expression. If quotes exist around a string expression, then
	 * they will be left in the result string. Function will also have their
	 * results wrapped with the appripriate quote characters.
	 * 
	 * @param expression
	 *            The expression to evaluate.
	 * 
	 * @return The result of the evaluated. expression. Numbers are treated as
	 *         doubles, so resulting numbers will contain at least one decimal
	 *         place.
	 * 
	 * @exception
	 *
	 */
	public String evaluate(final String expression) throws EvaluationException {
		return evaluate(expression, true, true);
	}

	/**
	 * This method evaluates mathematical, boolean or functional expressions.
	 * See the class description and test classes for more information on how to
	 * write an expression. The expression used will be the one previously
	 * specified when using the parse method. If the parse method has not been
	 * called before calling this method, then an exception will be thrown. If
	 * quotes exist around a string expression, then they will be left in the
	 * result string. Function will also have their results wrapped with the
	 * appropriate quote characters.
	 * 
	 * @return The result of the evaluated. expression. Numbers are treated as
	 *         doubles, so resulting numbers will contain at least one decimal
	 *         place.
	 * 
	 * @exception
	 *
	 */
	public String evaluate() throws EvaluationException {
		// Get the previously parsed expression.
		final String expression = previousExpression;

		if (expression == null || expression.length() == 0) {
			throw new EvaluationException("No expression has been specified.");
		}

		return evaluate(expression, true, true);
	}

	/**
	 * This method evaluates mathematical, boolean or functional expressions.
	 * See the class description and test classes for more information on how to
	 * write an expression.
	 * 
	 * @param expression
	 *            The expression to evaluate.
	 * @param keepQuotes
	 *            Indicates if the the quotes should be kept in the result or
	 *            not. This is only for string expression that are enclosed in
	 *            quotes prior to being evaluated.
	 * @param wrapStringFunctionResults
	 *            Indicates if the results from functions that return strings
	 *            should be wrapped in quotes. The quote character used will be
	 *            whatever is the current quote character for this object.
	 * 
	 * @return The result of the evaluated expression. Numbers are treated as
	 *         doubles, so resulting numbers will contain at least one decimal
	 *         place.
	 * 
	 * @exception
	 *
	 */
	public String evaluate(final String expression, final boolean keepQuotes,
			final boolean wrapStringFunctionResults) throws EvaluationException {

		// Parse the expression.
		parse(expression);

		String result = getResult(operatorStack, operandStack,
				wrapStringFunctionResults);

		// Remove the quotes if necessary.
		if (isExpressionString(result) && !keepQuotes) {
			result = result.substring(1, result.length() - 1);
		}

		return result;
	}

	/**
	 * This method evaluates mathematical, boolean or functional expressions.
	 * The expression used will be the one previously specified when using the
	 * parse method. If the parse method has not been called before calling this
	 * method, then an exception will be thrown. See the class description and
	 * test classes for more information on how to write an expression.
	 * 
	 * @param keepQuotes
	 *            Indicates if the the quotes should be kept in the result or
	 *            not. This is only for string expressions that are enclosed in
	 *            quotes prior to being evaluated.
	 * @param wrapStringFunctionResults
	 *            Indicates if the results from functions that return strings
	 *            should be wrapped in quotes. The quote character used will be
	 *            whatever is the current quote character for this object.
	 * 
	 * @return The result of the evaluated expression. Numbers are treated as
	 *         doubles, so resulting numbers will contain at least one decimal
	 *         place.
	 * 
	 * @exception
	 *
	 */
	public String evaluate(final boolean keepQuotes,
			final boolean wrapStringFunctionResults) throws EvaluationException {

		// Get the previously parsed expression.
		final String expression = previousExpression;

		if (expression == null || expression.length() == 0) {
			throw new EvaluationException("No expression has been specified.");
		}

		return evaluate(expression, keepQuotes, wrapStringFunctionResults);
	}

	/**
	 * This method is a simple wrapper around the evaluate(String) method. Its
	 * purpose is to return a more friendly boolean return value instead of the
	 * string "1.0" (for true) and "0.0" (for false) that is normally returned.
	 * 
	 * @param expression
	 *            The expression to evaluate.
	 * 
	 * @return A boolean value that represents the result of the evaluated
	 *         expression.
	 * 
	 * @exception
	 *
	 */
	public boolean getBooleanResult(final String expression)
			throws EvaluationException {

		final String result = evaluate(expression);

		try {
			Double doubleResult = new Double(result);

			if (doubleResult.doubleValue() == 1.0) {
				return true;
			}
		} catch (NumberFormatException exception) {
			return false;
		}

		return false;
	}

	/**
	 * This method is a simple wrapper around the evaluate(String) method. Its
	 * purpose is to return a more friendly double return value instead of the
	 * string number that is normally returned.
	 * 
	 * @param expression
	 *            The expression to evaluate.
	 * 
	 * @return A double value that represents the result of the evaluated
	 *         expression.
	 * 
	 * @exception
	 *
	 */
	public double getNumberResult(final String expression)
			throws EvaluationException {

		final String result = evaluate(expression);
		Double doubleResult = null;

		try {
			doubleResult = new Double(result);
		} catch (NumberFormatException nfe) {
			throw new EvaluationException(
					"Expression does not produce a number.", nfe);
		}

		return doubleResult.doubleValue();
	}

	/**
	 * This method parses a mathematical, boolean or functional expressions.
	 * When the expression is eventually evaluated, as long as the expression
	 * has not changed, it will not have to be reparsed. See the class
	 * description and test classes for more information on how to write an
	 * expression.
	 * 
	 * @param expression
	 *            The expression to evaluate.
	 * 
	 * @exception
	 *
	 */
	public void parse(final String expression) throws EvaluationException {

		// Save the expression.
		boolean parse = true;
		if (!expression.equals(previousExpression)) {
			previousExpression = expression;
		} else {
			parse = false;
			operatorStack = (ArrayDeque) previousOperatorStack.clone();
			operandStack = (ArrayDeque) previousOperandStack.clone();
		}

		try {
			if (parse) {
				// These stacks will keep track of the operands and operators.
				operandStack = new ArrayDeque();
				operatorStack = new ArrayDeque();

				// Flags to help us keep track of what we are processing.
				boolean haveOperand = false;
				boolean haveOperator = false;
				Operator unaryOperator = null;

				// We are going to process until we get to the end, so get the
				// length.
				int numChars = expression.length();
				int charCtr = 0;

				// Process until the counter exceeds the length. The goal is to
				// get
				// all of the operands and operators.
				while (charCtr < numChars) {
					Operator operator = null;
					int operatorIndex = -1;

					// Skip any white space.
					if (FunctionHelper.isSpace(expression.charAt(charCtr))) {
						charCtr++;
						continue;
					}

					// Get the next operator.
					ExpressionTree.NextOperator nextOperator = getNextOperator(expression,
							charCtr, null);

					if (nextOperator != null) {
						operator = nextOperator.getOperator();
						operatorIndex = nextOperator.getIndex();
					}

					// Check if it is time to process an operand.
					if (operatorIndex > charCtr || operatorIndex == -1) {
						charCtr = processOperand(expression, charCtr,
								operatorIndex, operandStack, unaryOperator);

						haveOperand = true;
						haveOperator = false;
						unaryOperator = null;
					}

					// Check if it is time to process an operator.
					if (operatorIndex == charCtr) {
						if (nextOperator.getOperator().isUnary()
								&& (haveOperator || charCtr == 0)) {
							charCtr = processUnaryOperator(operatorIndex,
									nextOperator.getOperator());

							if (unaryOperator == null) {
								// We have an unary operator.
								unaryOperator = nextOperator.getOperator();
							} else {
								throw new EvaluationException(
										"Consecutive unary "
												+ "operators are not allowed (index="
												+ charCtr + ").");
							}
						} else {
							charCtr = processOperator(expression,
									operatorIndex, operator, operatorStack,
									operandStack, haveOperand, unaryOperator);

							unaryOperator = null;
						}

						if (!(nextOperator.getOperator() instanceof AbstractOperator.ClosedParenthesesOperator)) {
							haveOperand = false;
							haveOperator = true;
						}
					}
				}

				// Save the parsed operators and operands.
				previousOperatorStack = (ArrayDeque) operatorStack.clone();
				previousOperandStack = (ArrayDeque) operandStack.clone();
			}
		} catch (Exception e) {
			// Clear the previous expression, because it is invalid.
			previousExpression = "";

			throw new EvaluationException(e.getMessage(), e);
		}
	}

	/**
	 * Install all of the operators into the list of operators to use when
	 * evaluating expressions.
	 */
	private void installOperators() {
		// Install the most used operators first.
		operators.add(openParenthesesOperator);
		operators.add(closedParenthesesOperator);
		operators.add(new AbstractOperator.AdditionOperator());
		operators.add(new AbstractOperator.SubtractionOperator());
		operators.add(new AbstractOperator.MultiplicationOperator());
		operators.add(new AbstractOperator.DivisionOperator());
		operators.add(new AbstractOperator.EqualOperator());
		operators.add(new AbstractOperator.NotEqualOperator());
		operators.add( new AbstractOperator.CommaThesesOperator() );
		
		// If there is a first character conflict between two operators,
		// then install the operator with the greatest length first.
		operators.add(new AbstractOperator.LessThanOrEqualOperator()); // Length of 2.
		operators.add(new AbstractOperator.LessThanOperator()); // Length of 1.
		operators.add(new AbstractOperator.GreaterThanOrEqualOperator()); // Length of 2.
		operators.add(new AbstractOperator.GreaterThanOperator()); // Length of 1.

		// Install the least used operators last.
		operators.add(new AbstractOperator.BooleanAndOperator());
		operators.add(new AbstractOperator.BooleanOrOperator());
		operators.add(new AbstractOperator.BooleanNotOperator());
		operators.add(new AbstractOperator.ModulusOperator());
		
	}

	/**
	 * Processes the operand that has been found in the expression.
	 * 
	 * @param expression
	 *            The expression being evaluated.
	 * @param operatorIndex
	 *            The position in the expression where the current operator
	 *            being processed is located.
	 * @param operandStack
	 *            The stack of operands.
	 * @param unaryOperator
	 *            The unary operator if we are working with one.
	 * 
	 * @return The new position in the expression where processing should
	 *         continue.
	 * 
	 * @exception
	 *
	 */
	private int processOperand(final String expression, final int charCtr,
			final int operatorIndex, final ArrayDeque operandStack,
			final Operator unaryOperator) throws EvaluationException {

		String operandString = null;
		int rtnCtr = -1;

		// Get the operand to process.
		if (operatorIndex == -1) {
			operandString = expression.substring(charCtr).trim();
			rtnCtr = expression.length();
		} else {
			operandString = expression.substring(charCtr, operatorIndex).trim();
			rtnCtr = operatorIndex;
		}

		if (operandString.length() == 0) {
			throw new EvaluationException("Expression is invalid.");
		}

		final ExpressionTree.ExpressionOperand operand = new ExpressionTree.ExpressionOperand(operandString,
				unaryOperator);
		operandStack.push(operand);

		return rtnCtr;
	}

	/**
	 * Processes the operator that has been found in the expression.
	 * 
	 * @param expression
	 *            The expression being evaluated.
	 * @param originalOperatorIndex
	 *            The position in the expression where the current operator
	 *            being processed is located.
	 * @param originalOperator
	 *            The operator being processed.
	 * @param operatorStack
	 *            The stack of operators.
	 * @param operandStack
	 *            The stack of operands.
	 * @param haveOperand
	 *            Indicates if have an operand to process.
	 * @param unaryOperator
	 *            The unary operand associated with thi operator. This may be
	 *            null.
	 * 
	 * @return The new position in the expression where processing should
	 *         continue.
	 * 
	 * @exception
	 *
	 */
	private int processOperator(final String expression,
			final int originalOperatorIndex, final Operator originalOperator,
			final ArrayDeque operatorStack, final ArrayDeque operandStack,
			final boolean haveOperand, final Operator unaryOperator)
			throws EvaluationException {

		int operatorIndex = originalOperatorIndex;
		Operator operator = originalOperator;

		// If we have and operand and the current operator is an instance
		// of OpenParenthesesOperator, then we are ready to process a function.
		if (haveOperand && operator instanceof AbstractOperator.OpenParenthesesOperator) {
			ExpressionTree.NextOperator nextOperator = processFunction(expression,
					operatorIndex, operandStack);

			operator = nextOperator.getOperator();
			operatorIndex = nextOperator.getIndex() + operator.getLength();

			nextOperator = getNextOperator(expression, operatorIndex, null);

			// Look to see if there is another operator.
			// If there is, the process it, else get out of this routine.
			if (nextOperator != null) {
				operator = nextOperator.getOperator();
				operatorIndex = nextOperator.getIndex();
			} else {
				return operatorIndex;
			}
		}

		// Determine what type of operator we are left with and process
		// accordingly.
		if (operator instanceof AbstractOperator.OpenParenthesesOperator) {
			final ExpressionTree.ExpressionOperator expressionOperator = new ExpressionTree.ExpressionOperator(
					operator, unaryOperator);
			operatorStack.push(expressionOperator);
		} else if (operator instanceof AbstractOperator.ClosedParenthesesOperator) {
			ExpressionTree.ExpressionOperator stackOperator = null;

			if (operatorStack.size() > 0) {
				stackOperator = (ExpressionTree.ExpressionOperator) operatorStack.peek();
			}

			// Process until we reach an open parentheses.
			while (stackOperator != null
					&& !(stackOperator.getOperator() instanceof AbstractOperator.OpenParenthesesOperator)) {
				processTree(operandStack, operatorStack);

				if (operatorStack.size() > 0) {
					stackOperator = (ExpressionTree.ExpressionOperator) operatorStack.peek();
				} else {
					stackOperator = null;
				}
			}

			if (operatorStack.isEmpty()) {
				throw new EvaluationException("Expression is invalid.");
			}

			// Pop the open parameter from the stack.
			final ExpressionTree.ExpressionOperator expressionOperator = (ExpressionTree.ExpressionOperator) operatorStack
					.pop();

			if (!(expressionOperator.getOperator() instanceof AbstractOperator.OpenParenthesesOperator)) {
				throw new EvaluationException("Expression is invalid.");
			}

			// Process the unary operator if we have one.
			if (expressionOperator.getUnaryOperator() != null) {
				Object operand = operandStack.pop();

				ExpressionTree tree = new ExpressionTree(this, operand, null,
						null, expressionOperator.getUnaryOperator());

				operandStack.push(tree);
			}
		} else {
			// Process non-param operator.
			if (operatorStack.size() > 0) {
				ExpressionTree.ExpressionOperator stackOperator = (ExpressionTree.ExpressionOperator) operatorStack
						.peek();

				while (stackOperator != null
						&& stackOperator.getOperator().getPrecedence() >= operator
								.getPrecedence()) {
					processTree(operandStack, operatorStack);

					if (operatorStack.size() > 0) {
						stackOperator = (ExpressionTree.ExpressionOperator) operatorStack
								.peek();
					} else {
						stackOperator = null;
					}
				}
			}

			ExpressionTree.ExpressionOperator expressionOperator = new ExpressionTree.ExpressionOperator(
					operator, unaryOperator);

			operatorStack.push(expressionOperator);
		}

		final int rtnCtr = operatorIndex + operator.getLength();

		return rtnCtr;
	}

	/**
	 * Processes the unary operator that has been found in the expression.
	 * 
	 * @param operatorIndex
	 *            The position in the expression where the current operator
	 *            being processed is located.
	 * @param operator
	 *            The operator being processed.
	 * 
	 * @return The new position in the expression where processing should
	 *         continue.
	 */
	private int processUnaryOperator(final int operatorIndex,
			final Operator operator) {

		final int rtnCtr = operatorIndex + operator.getSymbol().length();

		return rtnCtr;
	}

	/**
	 * Processes the function that has been found in the expression.
	 * 
	 * @param expression
	 *            The expression being evaluated.
	 * @param operatorIndex
	 *            The position in the expression where the current operator
	 *            being processed is located.
	 * @param operandStack
	 *            The stack of operands.
	 *
	 * @return The next operator in the expression. This should be the closed
	 *         parentheses operator.
	 * 
	 * @exception 
	 *
	 */
	private ExpressionTree.NextOperator processFunction(final String expression,
			final int operatorIndex, final ArrayDeque operandStack)
			throws EvaluationException {

		int parenthesisCount = 1;
		ExpressionTree.NextOperator nextOperator = null;
		int nextOperatorIndex = operatorIndex;

		// Loop until we find the function's closing parentheses.
		while (parenthesisCount > 0) {
			nextOperator = getNextOperator(expression, nextOperatorIndex + 1,
					null);

			if (nextOperator == null) {
				throw new EvaluationException("Function is not closed.");
			} else if (nextOperator.getOperator() instanceof AbstractOperator.OpenParenthesesOperator) {
				parenthesisCount++;
			} else if (nextOperator.getOperator() instanceof AbstractOperator.ClosedParenthesesOperator) {
				parenthesisCount--;
			}

			// Get the next operator index.
			nextOperatorIndex = nextOperator.getIndex();
		}

		// Get the function argument.
		String arguments = expression.substring(operatorIndex + 1,
				nextOperatorIndex);

		// Pop the function name from the stack.
		final ExpressionTree.ExpressionOperand operand = (ExpressionTree.ExpressionOperand) operandStack
				.pop();
		final Operator unaryOperator = operand.getUnaryOperator();
		final String functionName = operand.getValue();

		// Validate that the function name is valid.
		try {
			isValidName(functionName);
		} catch (IllegalArgumentException iae) {
			throw new EvaluationException("Invalid function name of \""
					+ functionName + "\".", iae);
		}

		// Get the function object.
		final FunctionGroup.Function function = (FunctionGroup.Function) functions.get(functionName);

		if (function == null) {
			throw new EvaluationException("A function is not defined (index="
					+ operatorIndex + ").");
		}

		final ExpressionTree.ParsedFunction parsedFunction = new ExpressionTree.ParsedFunction(function,
				arguments, unaryOperator);
		operandStack.push(parsedFunction);

		return nextOperator;
	}

	/**
	 * Processes an expresssion tree that has been parsed into an operand stack
	 * and oeprator stack.
	 * 
	 * @param operandStack
	 *            The stack of operands.
	 * @param operatorStack
	 *            The stack of operators.
	 */
	private void processTree(final ArrayDeque operandStack, final ArrayDeque operatorStack) {

		Object rightOperand = null;
		Object leftOperand = null;
		Operator operator = null;

		// Get the right operand node from the tree.
		if (operandStack.size() > 0) {
			rightOperand = operandStack.pop();
		}

		// Get the left operand node from the tree.
		if (operandStack.size() > 0) {
			leftOperand = operandStack.pop();
		}

		// Get the operator node from the tree.
		operator = ((ExpressionTree.ExpressionOperator) operatorStack.pop()).getOperator();

		// Build an expressin tree from the nodes.
		final ExpressionTree tree = new ExpressionTree(this, leftOperand,
				rightOperand, operator, null);

		// Push the tree onto the stack.
		operandStack.push(tree);
	}

	/**
	 * Returns the final result of the evaluated expression.
	 * 
	 * @param operatorStack
	 *            The stack of operators.
	 * @param operandStack
	 *            The stack of operands.
	 * @param wrapStringFunctionResults
	 *            Indicates if the results from functions that return strings
	 *            should be wrapped in quotes. The quote character used will be
	 *            whatever is the current quote character for this object.
	 * 
	 * @return The final result of the evaluated expression.
	 * 
	 * @exception
	 *
	 */
	private String getResult(final ArrayDeque operatorStack,
			final ArrayDeque operandStack, 
			final boolean wrapStringFunctionResults)
			throws EvaluationException {

		// The result to return.
		String resultString = null;

		while (operatorStack.size() > 0) {
			processTree(operandStack, operatorStack);
		}
		if (operandStack.size() != 1) {
			throw new EvaluationException("Expression is invalid.");
		}
		final Object finalOperand = operandStack.pop();
		if (finalOperand instanceof ExpressionTree) {
			resultString = ((ExpressionTree) finalOperand).evaluate(wrapStringFunctionResults);
		}
		else if (finalOperand instanceof ExpressionTree.ExpressionOperand) {
			ExpressionTree.ExpressionOperand resultExpressionOperand = (ExpressionTree.ExpressionOperand) finalOperand;
			resultString = ((ExpressionTree.ExpressionOperand) finalOperand).getValue();
			resultString = replaceVariables(resultString);
			if (!isExpressionString(resultString)) {
				Double resultDouble = null;
				try {
					resultDouble = new Double(resultString);
				} catch (Exception e) {
					throw new EvaluationException("Expression is invalid.", e);
				}
				if (resultExpressionOperand.getUnaryOperator() != null) {
					resultDouble = new Double(resultExpressionOperand.getUnaryOperator().evaluate( resultDouble.doubleValue()));
				}
				resultString = MathUtils.IMath.toString( resultDouble );
			} 
			else {
				if (resultExpressionOperand.getUnaryOperator() != null) {
					throw new EvaluationException("Invalid operand for " + "unary operator.");
				}
			}
		} 
		else if (finalOperand instanceof ExpressionTree.ParsedFunction) {
			final ExpressionTree.ParsedFunction parsedFunction = (ExpressionTree.ParsedFunction) finalOperand;
			final FunctionGroup.Function function = parsedFunction.getFunction();
			String arguments = parsedFunction.getArguments();
			if (processNestedFunctions) {
				arguments = processNestedFunctions(arguments);
			}
			arguments = replaceVariables(arguments);
			try {				
				FunctionResult functionResult = function.execute(this, arguments);
				resultString = functionResult.getAsResult();
				if (functionResult.getType() == EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC) {
					Double resultDouble = new Double(resultString);
					if (parsedFunction.getUnaryOperator() != null) {
						resultDouble = new Double(parsedFunction.getUnaryOperator().evaluate(resultDouble.doubleValue()));
					}
					resultString = MathUtils.IMath.toString( resultDouble );
				} 
				else if (functionResult.getType() == EvaluationConstants.FUNCTION_RESULT_TYPE_STRING) {
					if (wrapStringFunctionResults && FunctionHelper.isQuoteString( resultString ) == false ) {
						resultString = FunctionHelper.quoteString( resultString, quoteCharacter );
					}
					if (parsedFunction.getUnaryOperator() != null) {
						throw new EvaluationException("Invalid operand for " + "unary operator.");
					}
				}
			} 
			catch (FunctionException fe) {
				throw new EvaluationException(fe.getMessage(), fe);
			}
		} 
		else {
			throw new EvaluationException("Expression is invalid.");
		}

		return resultString;
	}

	/**
	 * Returns the next operator in the expression.
	 * 
	 * @param expression
	 *            The expression being evaluated.
	 * @param start
	 *            The position in the expression to start searching for the next
	 *            operator.
	 * @param match
	 *            The operator to search for. This can be null if you want the
	 *            very next operator. If it is not null, it searches until it
	 *            finds the match.
	 * 
	 * @return The next operator in the expression. Returns null if no next
	 *         operator is returned.
	 */
	private ExpressionTree.NextOperator getNextOperator(final String expression,
			final int start, final Operator match) {

		final int numChars = expression.length();
		int numQuoteCharacters = 0;

		for (int charCtr = start; charCtr < numChars; charCtr++) {
			// Keep track of open strings.
			if (expression.charAt(charCtr) == quoteCharacter) {
				numQuoteCharacters++;
			}

			// Do not look into open strings.
			if ((numQuoteCharacters % 2) == 1) {
				continue;
			}

			// Assumes the operators are installed in order of length.
			final int numOperators = operators.size();
			for (int operatorCtr = 0; operatorCtr < numOperators; operatorCtr++) {
				Operator operator = (Operator) operators.get(operatorCtr);

				if (match != null) {
					// Look through the operators until we find the
					// one we are searching for.
					if (!match.equals(operator)) {
						continue;
					}
				}

				// The operator can 1 or 2 characters in length.
				if (operator.getLength() == 2) {
					int endCtr = -1;
					if (charCtr + 2 <= expression.length()) {
						endCtr = charCtr + 2;
					} else {
						endCtr = expression.length();
					}

					// Look for a match.
					if (expression.substring(charCtr, endCtr).equals(
							operator.getSymbol())) {
						ExpressionTree.NextOperator nextOperator = new ExpressionTree.NextOperator(operator,
								charCtr);

						return nextOperator;
					}
				} else {
					// Look for a match.
					if (expression.charAt(charCtr) == operator.getSymbol()
							.charAt(0)) {
						ExpressionTree.NextOperator nextOperator = new ExpressionTree.NextOperator(operator,
								charCtr);

						return nextOperator;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Determines if the string represents a valid expression string or not.
	 * Valid expression strings must start and end with a quote character.
	 * 
	 * @param expressionString
	 *            The string being evaluated.
	 * 
	 * @return True if the string is a valid string and false if not.
	 */
	protected boolean isExpressionString(final String expressionString)
			throws EvaluationException {
        
		return StringUtils.isNumeric( expressionString )?false:true;
		
	}

	/**
	 * This method verifies if a function or variable name is valid or not.
	 * 
	 * Function and variable names must follow these rules...
	 * <ul>
	 * <li>can not start with a number</li>
	 * <li>can not contain an operator (see the above list of operators)</li>
	 * <li>can not contain a quote character - single or double</li>
	 * <li>can not contain a brace character - open or closed</li>
	 * <li>can not contain one of the following special characters: #, ~ , ^ !</li>
	 * <ul>
	 * 
	 * @param name
	 *            The function or variable name being validated.
	 * 
	 * @exception IllegalArgumentException
	 *                Thrown if the name is invalid.
	 */
	public void isValidName(final String name) throws IllegalArgumentException {

		if (name.length() == 0) throw new IllegalArgumentException("Variable is empty.");
		
		// Check if name starts with a number.
		/*final char firstChar = name.charAt(0);
		if (firstChar >= '0' && firstChar <= '9')
			throw new IllegalArgumentException("A variable or function name " + "can not start with a number.");*/

		// Check if name contains with a quote character.
		if (name.indexOf(EvaluationConstants.SINGLE_QUOTE) > -1) 
			throw new IllegalArgumentException("A variable or function name " + "can not contain a quote character.");
		else if (name.indexOf(EvaluationConstants.DOUBLE_QUOTE) > -1)
			throw new IllegalArgumentException("A variable or function name " + "can not contain a quote character.");
		
		// Check if name contains with a brace character.
		if (name.indexOf(EvaluationConstants.OPEN_BRACE) > -1) 
			throw new IllegalArgumentException("A variable or function name " + "can not contain an open brace character.");
		else if (name.indexOf(EvaluationConstants.CLOSED_BRACE) > -1) 
			throw new IllegalArgumentException("A variable or function name " + "can not contain a closed brace character.");
		else if (name.indexOf(EvaluationConstants.POUND_SIGN) > -1) 
			throw new IllegalArgumentException("A variable or function name " + "can not contain a pound sign character.");
		
		// Check if name contains an operator character.
		final Iterator operatorIterator = operators.iterator();
		while (operatorIterator.hasNext()) {
			final Operator operator = (Operator) operatorIterator.next();
			if (name.indexOf(operator.getSymbol()) > -1)
				throw new IllegalArgumentException( "A variable or function name [" + name +"]can not contain an operator symbol.");
		}

		// Check if name contains other special characters.
		if (name.indexOf("!") > -1) 
			throw new IllegalArgumentException("A variable or function name " + "can not contain a special character.");
		else if (name.indexOf("~") > -1) 
			throw new IllegalArgumentException("A variable or function name " + "can not contain a special character.");
		else if (name.indexOf("^") > -1) 
			throw new IllegalArgumentException("A variable or function name " + "can not contain a special character.");
		else if (name.indexOf(",") > -1)
			throw new IllegalArgumentException("A variable or function name " + "can not contain a special character.");
	}

	/**
	 * This method loads the system functions is necessary.
	 */
	private void loadSystemFunctions() {
		// Install the math functions.
		if (loadMathFunctions) {
			final FunctionGroup mathFunctions = new MathFunctions();

			mathFunctions.load(this);
		}

		// Install the string functions.
		if (loadStringFunctions) {
			final FunctionGroup stringFunctions = new StringFunctions();

			stringFunctions.load(this);
		}
	}

	/**
	 * This method loads the system variables is necessary.
	 */
	private void loadSystemVariables() {
		// Install the math variables.
		if (loadMathVariables) {
			// Add the two math variables.
			putVariable("E", new Double(Math.E).toString());
			putVariable("PI", new Double(Math.PI).toString());
		}
	}

	/**
	 * Replaces the variables in the expression with the values of the variables
	 * for this instance of the evaluator.
	 * 
	 * @param expression
	 *            The expression being processed.
	 * 
	 * @return A new expression with the variables replaced with their values.
	 * 
	 * @exception 
	 *
	 */
	public String replaceVariables(final String expression)
			throws EvaluationException {

		int openIndex = expression.indexOf(EvaluationConstants.OPEN_VARIABLE);

		if (openIndex < 0) {
			return expression;
		}

		String replacedExpression = expression;

		while (openIndex >= 0) {

			int closedIndex = -1;
			if (openIndex >= 0) {

				closedIndex = replacedExpression.indexOf(
						EvaluationConstants.CLOSED_VARIABLE, openIndex + 1);
				if (closedIndex > openIndex) {

					String variableName = replacedExpression.substring(
							openIndex
									+ EvaluationConstants.OPEN_VARIABLE
											.length(), closedIndex);
					
					// Validate that the variable name is valid.
					try {
						isValidName(variableName);
					} catch (IllegalArgumentException iae) {
						throw new EvaluationException("Invalid variable name of \""
								+ variableName + "\".", iae);
					}
					
					String variableValue = getVariableValue(variableName);

					String variableString = EvaluationConstants.OPEN_VARIABLE
							+ variableName
							+ EvaluationConstants.CLOSED_VARIABLE;

					replacedExpression = FunctionHelper.replaceAll(
							replacedExpression, variableString, variableValue);
				} else {

					break;
				}
			}

			// Start looking at the beginning of the string, since
			// the length string has changed and characters have moved
			// positions.
			openIndex = replacedExpression.indexOf(
					EvaluationConstants.OPEN_VARIABLE);
		}

		// If an open brace is left over, then a variable could not be replaced.
		int openBraceIndex = replacedExpression
				.indexOf(EvaluationConstants.OPEN_VARIABLE);
		if (openBraceIndex > -1) {
			throw new EvaluationException(
					"A variable has not been closed (index=" + openBraceIndex
							+ ").");
		}

		return replacedExpression;
	}
	
	/**
	 * This method process nested function calls that may be in the arguments
	 * passed into a higher level function.
	 * 
	 * @param arguments The arguments to process.
	 * 
	 * @return The arguments with any nested function calls evaluated.
	 * 
	 * @throws EvaluationException Thrown if an error occurs.
	 */
	protected String processNestedFunctions(final String arguments)
			throws EvaluationException {

		StringBuilder evaluatedArguments = new StringBuilder();

		// Process nested function calls.
		if (arguments.length() > 0) {

			JevalEvaluator argumentsEvaluator = new JevalEvaluator(quoteCharacter,
					loadMathVariables, loadMathFunctions, loadStringFunctions,
					processNestedFunctions);
			argumentsEvaluator.setFunctions(getFunctions());
			argumentsEvaluator.setVariables(getVariables());
			argumentsEvaluator.setVariableResolver(getVariableResolver());

			final ArgumentTokenizer tokenizer = new ArgumentTokenizer(
					arguments, EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);

			List evalautedArgumentList = new ArrayList();
			while (tokenizer.hasMoreTokens()) {

				String argument = tokenizer.nextToken().trim();

				try {
					argument = argumentsEvaluator.evaluate(argument);
				} catch (Exception e) {
					throw new EvaluationException(e.getMessage(), e);
				}

				evalautedArgumentList.add(argument);
			}

			Iterator evaluatedArgumentIterator = evalautedArgumentList
					.iterator();

			while (evaluatedArgumentIterator.hasNext()) {

				if (evaluatedArguments.length() > 0) {

					evaluatedArguments
							.append(EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);
				}

				String evaluatedArgument = (String) evaluatedArgumentIterator
						.next();
				evaluatedArguments.append(evaluatedArgument);
			}
		}

		return evaluatedArguments.toString();
	}

	/**
	 * Returns the value used during construction of this object to specify if
	 * math variables should be loaded.
	 * 
	 * @return the loadMathVariables
	 */
	public boolean isLoadMathVariables() {
		return loadMathVariables;
	}

	/**
	 * Returns the value used during construction of this object to specify if
	 * math functions should be loaded.
	 * 
	 * @return the loadMathFunctions
	 */
	public boolean getLoadMathFunctions() {
		return loadMathFunctions;
	}

	/**
	 * Returns the value used during construction of this object to specify if
	 * string functions should be loaded.
	 * 
	 * @return the loadStringFunctions
	 */
	public boolean getLoadStringFunctions() {
		return loadStringFunctions;
	}

	/**
	 * Returns the value used during construction of this object to specify if
	 * nested functions should be processed.
	 * 
	 * @return the processNestedFunctions
	 */
	public boolean getProcessNestedFunctions() {
		return processNestedFunctions;
	}
	
	/**
	 * This class allow for tokenizer methods to be called on a String of arguments.
	 */
	public static class ArgumentTokenizer implements Enumeration {

		/**
		 * The default delimitor.
		 */
		public final char defaultDelimiter = 
			EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR;

		// The arguments to be tokenized. This is updated every time the nextToken
		// method is called.
		private String arguments = null;

		// The separator between the arguments.
		private char delimiter = defaultDelimiter;

		/**
		 * Constructor that takes a String of arguments and a delimitoer.
		 * 
		 * @param arguments
		 *            The String of srguments to be tokenized.
		 * @param delimiter
		 *            The argument tokenizer.
		 */
		public ArgumentTokenizer(final String arguments, final char delimiter) {
			this.arguments = arguments;
			this.delimiter = delimiter;
		}

		/**
		 * Indicates if there are more elements.
		 * 
		 * @return True if there are more elements and false if not.
		 */
		public boolean hasMoreElements() {
			return hasMoreTokens();
		}

		/**
		 * Indicates if there are more tokens.
		 * 
		 * @return True if there are more tokens and false if not.
		 */
		public boolean hasMoreTokens() {

			if (arguments.length() > 0) {
				return true;
			}

			return false;
		}

		/**
		 * Returns the next element.
		 * 
		 * @return The next element.
		 */
		public Object nextElement() {
			return nextToken();
		}

		/**
		 * Returns the next token.
		 * 
		 * @return The next element.
		 */
		public String nextToken() {
			int charCtr = 0;
			int size = arguments.length();
			int parenthesesCtr = 0;
			String returnArgument = null;

			// Loop until we hit the end of the arguments String.
			while (charCtr < size) {
				if (arguments.charAt(charCtr) == '(') {
					parenthesesCtr++;
				} else if (arguments.charAt(charCtr) == ')') {
					parenthesesCtr--;
				} else if (arguments.charAt(charCtr) == delimiter
						&& parenthesesCtr == 0) {

					returnArgument = arguments.substring(0, charCtr);
					arguments = arguments.substring(charCtr + 1);
					break;
				}

				charCtr++;
			}

			if (returnArgument == null) {
				returnArgument = arguments;
				arguments = "";
			}

			return returnArgument;
		}
	}
	
}