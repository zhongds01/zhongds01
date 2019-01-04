package com.ai.sacenter.jeval.operator;

import com.ai.sacenter.jeval.EvaluationConstants;
import com.ai.sacenter.jeval.EvaluationException;
import com.ai.sacenter.jeval.function.FunctionHelper;

/**
 * This is the standard operator that is the parent to all operators found in
 * expressions.
 */
public abstract class AbstractOperator implements Operator {

	private String symbol = null;

	private int precedence = 0;

	private boolean unary = false;

	/**
	 * A constructor that takes the operator symbol and precedence as input.
	 * 
	 * @param symbol
	 *            The character(s) that makes up the operator.
	 * @param precedence
	 *            The precedence level given to this operator.
	 */
	public AbstractOperator(final String symbol, final int precedence) {

		this.symbol = symbol;
		this.precedence = precedence;
	}

	/**
	 * A constructor that takes the operator symbol, precedence, unary indicator
	 * and unary precedence as input.
	 * 
	 * @param symbol
	 *            The character(s) that makes up the operator.
	 * @param precedence
	 *            The precedence level given to this operator.
	 * @param unary
	 *            Indicates of the operator is a unary operator or not.
	 */
	public AbstractOperator(

	String symbol, int precedence, boolean unary) {

		this.symbol = symbol;
		this.precedence = precedence;
		this.unary = unary;
	}

	/**
	 * Evaluates two double operands.
	 * 
	 * @param leftOperand
	 *            The left operand being evaluated.
	 * @param rightOperand
	 *            The right operand being evaluated.
	 */
	public double evaluate(final double leftOperand, final double rightOperand) {
		return 0;
	}

	/**
	 * Evaluates two string operands.
	 * 
	 * @param leftOperand
	 *            The left operand being evaluated.
	 * @param rightOperand
	 *            The right operand being evaluated.
	 * 
	 * @return String The value of the evaluated operands.
	 * 
	 * @exception EvaluationException
	 *                Thrown when an error is found while evaluating the
	 *                expression.
	 */
	public String evaluate(final String leftOperand, final String rightOperand)
			throws EvaluationException {
		if( FunctionHelper.isNumeric( leftOperand ) == false || 
				FunctionHelper.isNumeric( rightOperand ) == false )
			throw new EvaluationException("Invalid operation for a string.");
		return String.valueOf( evaluate( Double.parseDouble( leftOperand ) , 
					Double.parseDouble( rightOperand ) ) );
	}

	/**
	 * Evaluate one double operand.
	 * 
	 * @param operand
	 *            The operand being evaluated.
	 */
	public double evaluate(double operand) {
		return 0;
	}

	/**
	 * Returns the character(s) that makes up the operator.
	 * 
	 * @return The operator symbol.
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Returns the precedence given to this operator.
	 * 
	 * @return The precedecne given to this operator.
	 */
	public int getPrecedence() {
		return precedence;
	}

	/**
	 * Returns the length of the operator symbol.
	 * 
	 * @return The length of the operator symbol.
	 */
	public int getLength() {
		return symbol.length();
	}

	/**
	 * Returns an indicator of if the operator is unary or not.
	 * 
	 * @return An indicator of if the operator is unary or not.
	 */
	public boolean isUnary() {
		return unary;
	}

	/**
	 * Determines if this operator is equal to another operator. Equality is
	 * determined by comparing the operator symbol of both operators.
	 * 
	 * @param object
	 *            The object to compare with this operator.
	 * 
	 * @return True if the object is equal and false if not.
	 * 
	 * @exception IllegalStateException
	 *                Thrown if the input object is not of the Operator type.
	 */
	public boolean equals(final Object object) {
		if (object == null) {
			return false;
		}

		if (!(object instanceof AbstractOperator)) {
			throw new IllegalStateException("Invalid operator object.");
		}

		AbstractOperator operator = (AbstractOperator) object;

		if (symbol.equals(operator.getSymbol())) {
			return true;
		}

		return false;
	}

	/**
	 * Returns the String representation of this operator, which is the symbol.
	 * 
	 * @return The operator symbol.
	 */
	public String toString() {
		return getSymbol();
	}
	/**
	 * The addition operator.
	 */
	public static class AdditionOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public AdditionOperator() {
			super("+", 5, true);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			Double rtnValue = new Double(leftOperand + rightOperand);
			return rtnValue.doubleValue();
		}

		/**
		 * Evaluates two string operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public String evaluate(final String leftOperand, final String rightOperand) {
			String rtnValue = null;
			try
			{
				String aLeftOperand = FunctionHelper.quoteString( leftOperand );
				String aRightOperand = FunctionHelper.quoteString( rightOperand );
				rtnValue = new String(aLeftOperand.substring(0, aLeftOperand.length() - 1 )
						              + aRightOperand.substring(1, aRightOperand.length()));
			}
			finally{
				
			}
			return rtnValue;
		}

		/**
		 * Evaluate one double operand.
		 * 
		 * @param operand
		 *            The operand being evaluated.
		 */
		public double evaluate(double operand) {
			return operand;
		}
	}
	/**
	 * The boolean and operator.
	 */
	public static class BooleanAndOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public BooleanAndOperator() {
			super("&&", 2);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			if (leftOperand == 1 && rightOperand == 1) {
				return 1;
			}
			return 0;
		}
	}/**
	 * The boolean not operator.
	 */
	public static class BooleanNotOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public BooleanNotOperator() {
			super("!", 0, true);
		}

		/**
		 * Evaluate one double operand.
		 * 
		 * @param operand
		 *            The operand being evaluated.
		 */
		public double evaluate(final double operand) {
			if (operand == 1) {
				return 0;
			}

			return 1;
		}
	}
	/**
	 * The boolean or operator.
	 */
	public static class BooleanOrOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public BooleanOrOperator() {
			super("||", 1);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			if (leftOperand == 1 || rightOperand == 1) {
				return 1;
			}

			return 0;
		}
	}
	/**
	 * The division operator.
	 */
	public static class DivisionOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public DivisionOperator() {
			super("/", 6);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			Double rtnValue = new Double(leftOperand / rightOperand);

			return rtnValue.doubleValue();
		}
	}
	/**
	 * The equal operator.
	 */
	public static class EqualOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public EqualOperator() {
			super("==", 3);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			if (leftOperand == rightOperand) {
				return 1;
			}

			return 0;
		}

		/**
		 * Evaluates two string operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public String evaluate(String leftOperand, String rightOperand) {
			if (leftOperand.compareTo(rightOperand) == 0) 
				return EvaluationConstants.BOOLEAN_STRING_TRUE;
			return EvaluationConstants.BOOLEAN_STRING_FALSE;
		}
	}
	/**
	 * The greater than operator.
	 */
	public static class GreaterThanOperator extends AbstractOperator {
		/**
		 * Default constructor.
		 */
		public GreaterThanOperator() {
			super(">", 4);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			if (leftOperand > rightOperand) {
				return 1;
			}

			return 0;
		}

		/**
		 * Evaluates two string operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public String evaluate(final String leftOperand, final String rightOperand) {
			if (leftOperand.compareTo(rightOperand) > 0) 
				return EvaluationConstants.BOOLEAN_STRING_TRUE;
			return EvaluationConstants.BOOLEAN_STRING_FALSE;
		}
	}
	/**
	 * The greater than or equal operator.
	 */
	public static class GreaterThanOrEqualOperator extends AbstractOperator {
		/**
		 * Default constructor.
		 */
		public GreaterThanOrEqualOperator() {
			super(">=", 4);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			if (leftOperand >= rightOperand) {
				return 1;
			}

			return 0;
		}

		/**
		 * Evaluates two string operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public String evaluate(final String leftOperand, final String rightOperand) {
			if (leftOperand.compareTo(rightOperand) >= 0)
				return EvaluationConstants.BOOLEAN_STRING_TRUE;
			return EvaluationConstants.BOOLEAN_STRING_FALSE;
		}
	}
	/**
	 * The less than operator.
	 */
	public static class LessThanOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public LessThanOperator() {
			super("<", 4);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			if (leftOperand < rightOperand) {
				return 1;
			}

			return 0;
		}

		/**
		 * Evaluates two string operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public String evaluate(final String leftOperand, final String rightOperand) {
			if (leftOperand.compareTo(rightOperand) < 0) 
				return EvaluationConstants.BOOLEAN_STRING_TRUE;
			return EvaluationConstants.BOOLEAN_STRING_FALSE;
		}
	}
	/**
	 * The less than or equal operator.
	 */
	public static class LessThanOrEqualOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public LessThanOrEqualOperator() {
			super("<=", 4);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			if (leftOperand <= rightOperand) {
				return 1;
			}

			return 0;
		}

		/**
		 * Evaluates two string operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public String evaluate(String leftOperand, String rightOperand) {
			if (leftOperand.compareTo(rightOperand) <= 0) {
				return EvaluationConstants.BOOLEAN_STRING_TRUE;
			}

			return EvaluationConstants.BOOLEAN_STRING_FALSE;
		}
	}
	/**
	 * The modulus operator.
	 */
	public static class ModulusOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public ModulusOperator() {
			super("%", 6);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			Double rtnValue = new Double(leftOperand % rightOperand);

			return rtnValue.doubleValue();
		}
	}
	/**
	 * The multiplication operator.
	 */
	public static class MultiplicationOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public MultiplicationOperator() {
			super("*", 6);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			Double rtnValue = new Double(leftOperand * rightOperand);

			return rtnValue.doubleValue();
		}
	}
	/**
	 * The not equal operator.
	 */
	public static class NotEqualOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public NotEqualOperator() {
			super("!=", 3);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			if (leftOperand != rightOperand) {
				return 1;
			}

			return 0;
		}

		/**
		 * Evaluates two string operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public String evaluate(String leftOperand, String rightOperand) {
			if (leftOperand.compareTo(rightOperand) != 0) 
				return EvaluationConstants.BOOLEAN_STRING_TRUE;
			return EvaluationConstants.BOOLEAN_STRING_FALSE;
		}
	}
	/**
	 * The subtraction operator.
	 */
	public static class SubtractionOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public SubtractionOperator() {
			super("-", 5, true);
		}

		/**
		 * Evaluates two double operands.
		 * 
		 * @param leftOperand
		 *            The left operand being evaluated.
		 * @param rightOperand
		 *            The right operand being evaluated.
		 */
		public double evaluate(final double leftOperand, final double rightOperand) {
			Double rtnValue = new Double(leftOperand - rightOperand);

			return rtnValue.doubleValue();
		}

		/**
		 * Evaluate one double operand.
		 * 
		 * @param operand
		 *            The operand being evaluated.
		 */
		public double evaluate(final double operand) {
			return -operand;
		}
	}
	/**
	 * The open parentheses operator.
	 */
	public static class OpenParenthesesOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public OpenParenthesesOperator() {
			super("(", 0);
		}
	}
	/**
	 * The closed parentheses operator.
	 */
	public static class ClosedParenthesesOperator extends AbstractOperator {

		/**
		 * Default constructor.
		 */
		public ClosedParenthesesOperator() {
			super(")", 0);
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017Äê1ÔÂ25ÈÕ</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class CommaThesesOperator extends AbstractOperator{
		/**
		 * Default constructor.
		 */
		public CommaThesesOperator() {
			super(",", 5,true);
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.jeval.operator.AbstractOperator#evaluate(java.lang.String, java.lang.String)
		 */
		public String evaluate(String leftOperand, String rightOperand)throws EvaluationException {
			StringBuilder rtnValue = new StringBuilder();
			try
			{
				String aLeftOperand = FunctionHelper.quoteString( leftOperand );
				String aRightOperand = FunctionHelper.quoteString( rightOperand );
				rtnValue.append( aLeftOperand )
				        .append( getSymbol() )
				        .append( aRightOperand );
			}
			finally{
				
			}
			return rtnValue.toString();
		}
	}
}