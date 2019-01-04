package com.ai.sacenter.jeval;

import com.ai.sacenter.jeval.function.FunctionException;
import com.ai.sacenter.jeval.function.FunctionGroup;
import com.ai.sacenter.jeval.function.FunctionHelper;
import com.ai.sacenter.jeval.operator.Operator;
import com.ai.sacenter.util.MathUtils;

/**
 * Represents an expression tree made up of a left operand, right operand,
 * operator and unary operator.
 */
public class ExpressionTree {

	// The left node in the tree.
	private Object leftOperand = null;

	// The right node in the tree.
	private Object rightOperand = null;

	// The operator for the two operands.
	private Operator operator = null;

	// The unary operator, if one exists.
	private Operator unaryOperator = null;

	// The Evaluator object processing this tree.
	private JevalEvaluator evaluator = null;

	/**
	 * Creates a new ExpressionTree.
	 * 
	 * @param evaluator
	 *            The Evaluator object processing this tree.
	 * @param leftOperand
	 *            The left operand to place as the left node of the tree.
	 * @param rightOperand
	 *            The right operand to place as the right node of the tree.
	 * @param operator
	 *            The operator to place as the operator node of the tree.
	 * @param unaryOperator
	 *            The new unary operator for this tree.
	 */
	public ExpressionTree(final JevalEvaluator evaluator, final Object leftOperand,
			final Object rightOperand, final Operator operator,
			final Operator unaryOperator) {

		this.evaluator = evaluator;
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operator = operator;
		this.unaryOperator = unaryOperator;
	}

	/**
	 * Returns the left operand of this tree.
	 * 
	 * @return The left operand of this tree.
	 */
	public Object getLeftOperand() {
		return leftOperand;
	}

	/**
	 * Returns the right operand of this tree.
	 * 
	 * @return The right operand of this tree.
	 */
	public Object getRightOperand() {
		return rightOperand;
	}

	/**
	 * Returns the operator for this tree.
	 * 
	 * @return The operator of this tree.
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * Returns the unary operator for this tree.
	 * 
	 * @return The unary operator of this tree.
	 */
	public Operator getUnaryOperator() {
		return unaryOperator;
	}

	/**
	 * Evaluates the operands for this tree using the operator and the unary
	 * operator.
	 * 
	 * @param wrapStringFunctionResults
	 *            Indicates if the results from functions that return strings
	 *            should be wrapped in quotes. The quote character used will be
	 *            whatever is the current quote character for this object.
	 * 
	 * @exception EvaluationException
	 *                Thrown is an error is encountered while processing the
	 *                expression.
	 */
	public String evaluate(final boolean wrapStringFunctionResults) throws EvaluationException {
		String rtnResult = null;

		String leftResultString = null;
		Double leftResultDouble = null;
		if (leftOperand instanceof ExpressionTree) {
			leftResultString = ((ExpressionTree) leftOperand).evaluate(wrapStringFunctionResults);
			try {
				leftResultDouble = new Double(leftResultString);
				leftResultString = null;
			} catch (NumberFormatException exception) {
				leftResultDouble = null;
			}
		} else if (leftOperand instanceof ExpressionOperand) {
			final ExpressionOperand leftExpressionOperand = (ExpressionOperand) leftOperand;
			leftResultString = leftExpressionOperand.getValue();
			leftResultString = evaluator.replaceVariables(leftResultString);
			if (!evaluator.isExpressionString(leftResultString)) {
				try {
					leftResultDouble = new Double(leftResultString);
					leftResultString = null;
				} catch (NumberFormatException nfe) {
					throw new EvaluationException("Expression is invalid.", nfe);
				}
				if (leftExpressionOperand.getUnaryOperator() != null) {
					leftResultDouble = new Double(leftExpressionOperand.getUnaryOperator().evaluate(leftResultDouble.doubleValue()));
				}
			} else {
				if (leftExpressionOperand.getUnaryOperator() != null) {
					throw new EvaluationException("Invalid operand for " + "unary operator.");
				}
			}
		} else if (leftOperand instanceof ParsedFunction) {
			final ParsedFunction parsedFunction = (ParsedFunction) leftOperand;
			final FunctionGroup.Function function = parsedFunction.getFunction();
			String arguments = parsedFunction.getArguments();
			arguments = evaluator.replaceVariables(arguments);
			if (evaluator.getProcessNestedFunctions()) {
				arguments = evaluator.processNestedFunctions(arguments);
			}
			try {
				FunctionResult functionResult = function.execute(evaluator, arguments);
				leftResultString = functionResult.getAsResult();
				if (functionResult.getType() == EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC) {
					Double resultDouble = new Double(leftResultString);
					if (parsedFunction.getUnaryOperator() != null) {
						resultDouble = new Double(parsedFunction.getUnaryOperator().evaluate(resultDouble.doubleValue()));
					}
					leftResultString = MathUtils.IMath.toString( resultDouble );
				} 
				else if (functionResult.getType() == EvaluationConstants.FUNCTION_RESULT_TYPE_STRING) {
					if (wrapStringFunctionResults && FunctionHelper.isQuoteString( leftResultString ) == false ) {
						leftResultString = FunctionHelper.quoteString( leftResultString, evaluator.getQuoteCharacter() );
					}
					if (parsedFunction.getUnaryOperator() != null) {
						throw new EvaluationException("Invalid operand for " + "unary operator.");
					}
				}
			} catch (FunctionException fe) {
				throw new EvaluationException(fe.getMessage(), fe);
			}
			if (!evaluator.isExpressionString(leftResultString)) {
				try {
					leftResultDouble = new Double(leftResultString);
					leftResultString = null;
				} catch (NumberFormatException nfe) {
					throw new EvaluationException("Expression is invalid.", nfe);
				}
			}
		} else {
			if (leftOperand != null) {
				throw new EvaluationException("Expression is invalid.");
			}
		}

		String rightResultString = null;
		Double rightResultDouble = null;
		if (rightOperand instanceof ExpressionTree) {
			rightResultString = ((ExpressionTree) rightOperand).evaluate(wrapStringFunctionResults);
			try {
				rightResultDouble = new Double(rightResultString);
				rightResultString = null;
			} catch (NumberFormatException exception) {
				rightResultDouble = null;
			}
		} else if (rightOperand instanceof ExpressionOperand) {
			final ExpressionOperand rightExpressionOperand = (ExpressionOperand) rightOperand;
			rightResultString = ((ExpressionOperand) rightOperand).getValue();
			rightResultString = evaluator.replaceVariables(rightResultString);

			if (!evaluator.isExpressionString(rightResultString)) {
				try {
					rightResultDouble = new Double(rightResultString);
					rightResultString = null;
				} catch (NumberFormatException nfe) {
					throw new EvaluationException("Expression is invalid.", nfe);
				}

				if (rightExpressionOperand.getUnaryOperator() != null) {
					rightResultDouble = new Double(rightExpressionOperand.getUnaryOperator().evaluate( rightResultDouble.doubleValue()));
				}
			} else {
				if (rightExpressionOperand.getUnaryOperator() != null) {
					throw new EvaluationException("Invalid operand for "
							+ "unary operator.");
				}
			}
		} else if (rightOperand instanceof ParsedFunction) {
			final ParsedFunction parsedFunction = (ParsedFunction) rightOperand;
			final FunctionGroup.Function function = parsedFunction.getFunction();
			String arguments = parsedFunction.getArguments();
			arguments = evaluator.replaceVariables(arguments);
			if (evaluator.getProcessNestedFunctions()) {
				arguments = evaluator.processNestedFunctions(arguments);
			}
			try {				
				FunctionResult functionResult = function.execute(evaluator, arguments);
				rightResultString = functionResult.getAsResult();
				if (functionResult.getType() == EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC) {
					Double resultDouble = new Double(rightResultString);
					if (parsedFunction.getUnaryOperator() != null) {
						resultDouble = new Double(parsedFunction.getUnaryOperator().evaluate( resultDouble.doubleValue() ) );
					}
					rightResultString = MathUtils.IMath.toString( resultDouble );
				}
				else if (functionResult.getType() == EvaluationConstants.FUNCTION_RESULT_TYPE_STRING) {
					if (wrapStringFunctionResults && FunctionHelper.isQuoteString( rightResultString ) == false ) {
						rightResultString = FunctionHelper.quoteString( rightResultString, evaluator.getQuoteCharacter() );
					}
					if (parsedFunction.getUnaryOperator() != null) {
						throw new EvaluationException("Invalid operand for " + "unary operator.");
					}
				}
			} 
			catch (FunctionException fe) {
				throw new EvaluationException(fe.getMessage(), fe);
			}

			if (!evaluator.isExpressionString(rightResultString)) {
				try {
					rightResultDouble = new Double(rightResultString);
					rightResultString = null;
				} catch (NumberFormatException nfe) {
					throw new EvaluationException("Expression is invalid.", nfe);
				}
			}
		} else if (rightOperand == null) {
			// Do nothing.
		} else {
			throw new EvaluationException("Expression is invalid.");
		}

		// Evaluate the the expression.
		if (leftResultDouble != null && rightResultDouble != null) {
			double doubleResult = operator.evaluate(leftResultDouble.doubleValue(), rightResultDouble.doubleValue());
			if (getUnaryOperator() != null) {
				doubleResult = getUnaryOperator().evaluate(doubleResult);
			}
			rtnResult = new Double(doubleResult).toString();
		} 
		else if (leftResultString != null && rightResultString != null) {
			rtnResult = operator.evaluate(leftResultString, rightResultString);
		}
		else if( (leftResultString != null && rightResultDouble != null) ){
			rightResultString = MathUtils.IMath.toString( rightResultDouble );
			if( FunctionHelper.isQuoteString( leftResultString ) ){
				rightResultString = FunctionHelper.quoteString( rightResultString, 
						evaluator.getQuoteCharacter() );
			}
			rtnResult = operator.evaluate(leftResultString, rightResultString );
		}
		else if( leftResultDouble != null && rightResultString != null){
			leftResultString = MathUtils.IMath.toString( leftResultDouble );
			if( FunctionHelper.isQuoteString( rightResultString ) ){
				leftResultString = FunctionHelper.quoteString( leftResultString, 
						evaluator.getQuoteCharacter() );
			}
			rtnResult = operator.evaluate( leftResultString, rightResultString );
		}
		else if (leftResultDouble != null && rightResultDouble == null) {
			double doubleResult = -1;
			if (unaryOperator != null) {
				doubleResult = unaryOperator.evaluate(leftResultDouble.doubleValue());
			} 
			else {
				throw new EvaluationException("Expression is invalid.");
			}
			rtnResult = new Double(doubleResult).toString();
		} 
		else {
			throw new EvaluationException("Expression is invalid.");
		}
		return rtnResult;
	}
	/**
	 * Represents an operator being processed in the expression.
	 */
	public static class ExpressionOperator {

		// The operator that this object represents.
		private Operator operator = null;

		// The unary operator for this object, if there is one.
		private Operator unaryOperator = null;

		/**
		 * Creates a new ExpressionOperator.
		 * 
		 * @param operator
		 *            The operator this object represents.
		 * @param unaryOperator
		 *            The unary operator for this object.
		 */
		public ExpressionOperator(final Operator operator,
				final Operator unaryOperator) {
			this.operator = operator;
			this.unaryOperator = unaryOperator;
		}

		/**
		 * Returns the operator for this object.
		 * 
		 * @return The operator for this object.
		 */
		public Operator getOperator() {
			return operator;
		}

		/**
		 * Returns the unary operator for this object.
		 * 
		 * @return The unary operator for this object.
		 */
		public Operator getUnaryOperator() {
			return unaryOperator;
		}
	}
	/**
	 * Represents an operand being processed in the expression.
	 */
	public static class ExpressionOperand {

		// The value of the operand.
		private String value = null;

		// The unary operator for the operand, if one exists.
		private Operator unaryOperator = null;

		/**
		 * Create a new ExpressionOperand.
		 * 
		 * @param value
		 *            The value for the new ExpressionOperand.
		 * @param unaryOperator
		 *            The unary operator for this object.
		 */
		public ExpressionOperand(final String value, final Operator unaryOperator) {
			this.value = value;
			this.unaryOperator = unaryOperator;
		}

		/**
		 * Returns the value of this object.
		 * 
		 * @return The value of this object.
		 */
		public String getValue() {
			return value;
		}

		/**
		 * Returns the unary operator for this object.
		 * 
		 * @return The unary operator for this object.
		 */
		public Operator getUnaryOperator() {
			return unaryOperator;
		}
	}
	/**
	 * Represents the next operator in the expression to process.
	 */
	public static class NextOperator {

		// The operator this object represetns.
		private Operator operator = null;

		// The index of the operator in the expression.
		private int index = -1;

		/**
		 * Create a new NextOperator from an operator and index.
		 * 
		 * @param operator
		 *            The operator this object represents.
		 * @param index
		 *            The index of the operator in the expression.
		 */
		public NextOperator(final Operator operator, final int index) {
			this.operator = operator;
			this.index = index;
		}

		/**
		 * Returns the operator for this object.
		 * 
		 * @return The operator represented by this object.
		 */
		public Operator getOperator() {
			return operator;
		}

		/**
		 * Returns the index for this object.
		 * 
		 * @return The index of the operator in the expression.
		 */
		public int getIndex() {
			return index;
		}
	}
	/**
	 * This class represents a function that has been parsed.
	 */
	public static class ParsedFunction {

		// The function that has been parsed.
		// FIXME Make all class instance methods final if possible.
		private final FunctionGroup.Function function;

		// The arguments to the function.
		private final String arguments;

		// The unary operator for this object, if there is one.
		private final Operator unaryOperator;

		/**
		 * The constructor for this class.
		 * 
		 * @param function
		 *            The function that has been parsed.
		 * @param arguments
		 *            The arguments to the function.
		 * @param unaryOperator
		 *            The unary operator for this object, if there is one.
		 */
		public ParsedFunction(final FunctionGroup.Function function, final String arguments,
				final Operator unaryOperator) {

			this.function = function;
			this.arguments = arguments;
			this.unaryOperator = unaryOperator;
		}

		/**
		 * Returns the function that has been parsed.
		 * 
		 * @return The function that has been parsed.
		 */
		public FunctionGroup.Function getFunction() {
			return function;
		}

		/**
		 * Returns the arguments to the function.
		 * 
		 * @return The arguments to the function.
		 */
		public String getArguments() {
			return arguments;
		}

		/**
		 * Returns the unary operator for this object, if there is one.
		 * 
		 * @return The unary operator for this object, if there is one.
		 */
		public Operator getUnaryOperator() {
			return unaryOperator;
		}
	}
}