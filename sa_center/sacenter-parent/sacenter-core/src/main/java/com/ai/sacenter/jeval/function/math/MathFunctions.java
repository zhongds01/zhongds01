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

package com.ai.sacenter.jeval.function.math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ai.sacenter.jeval.EvaluationConstants;
import com.ai.sacenter.jeval.FunctionResult;
import com.ai.sacenter.jeval.JevalEvaluator;
import com.ai.sacenter.jeval.function.FunctionException;
import com.ai.sacenter.jeval.function.FunctionGroup;
import com.ai.sacenter.jeval.function.FunctionHelper;

/**
 * A groups of functions that can loaded at one time into an instance of
 * Evaluator. This group contains all of the functions located in the
 * com.ai.sacenter.jeval.function.math package.
 */
public class MathFunctions implements FunctionGroup {
	/**
	 * Used to store instances of all of the functions loaded by this class.
	 */
	private List functions = new ArrayList();

	/**
	 * Default contructor for this class. The functions loaded by this class are
	 * instantiated in this constructor.
	 */
	public MathFunctions() {
		functions.add(new Abs());
		functions.add(new Acos());
		functions.add(new Asin());
		functions.add(new Atan());
		functions.add(new Atan2());
		functions.add(new Ceil());
		functions.add(new Cos());
		functions.add(new Exp());
		functions.add(new Floor());
		functions.add(new IEEEremainder());
		functions.add(new Log());
		functions.add(new Max());
		functions.add(new Min());
		functions.add(new Pow());
		functions.add(new Random());
		functions.add(new Rint());
		functions.add(new Round());
		functions.add(new Sin());
		functions.add(new Sqrt());
		functions.add(new Tan());
		functions.add(new ToDegrees());
		functions.add(new ToRadians());
	}

	/**
	 * Returns the name of the function group - "numberFunctions".
	 * 
	 * @return The name of this function group class.
	 */
	public String getName() {
		return "numberFunctions";
	}

	/**
	 * Returns a list of the functions that are loaded by this class.
	 * 
	 * @return A list of the functions loaded by this class.
	 */
	public List getFunctions() {
		return functions;
	}

	/**
	 * Loads the functions in this function group into an instance of Evaluator.
	 * 
	 * @param evaluator
	 *            An instance of Evaluator to load the functions into.
	 */
	public void load(final JevalEvaluator evaluator) {
		Iterator functionIterator = functions.iterator();

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
		Iterator functionIterator = functions.iterator();

		while (functionIterator.hasNext()) {
			evaluator.removeFunction(((Function) functionIterator.next())
					.getName());
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the absolute value of a double value. See the Math.abs(double) method in the
	 * JDK for a complete description of how this function works.
	 */
	public static class Abs implements Function {
		public Abs(){
			super();
		}
		
		public String getName() {
			return "abs";
		}

		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments) throws FunctionException {
			Double result = null;
			Double number = null;
			try {
				number = new Double(arguments);
				result = new Double(Math.abs(number.doubleValue()));
			} 
			catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}
			return new FunctionResult(result.toString(), EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the arc cosine of an angle. See the Math.ceil(double) method in the JDK for a
	 * complete description of how this function works.
	 */
	public static class Acos implements Function {
		/**
		 * Returns the name of the function - "acos".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "acos";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return The arc cosine value of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;
			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}
			result = new Double(Math.acos(number.doubleValue()));
			return new FunctionResult(result.toString(), EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the arc sine of an angle See the Math.asin(double) method in the JDK for a
	 * complete description of how this function works.
	 */
	public static class Asin implements Function {
		/**
		 * Returns the name of the function - "asin".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "asin";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return The arc sine of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;
			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}
			result = new Double(Math.asin(number.doubleValue()));
			return new FunctionResult(result.toString(), EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the arc tangent of an angle. See the Math.atan(double) method in the JDK for
	 * a complete description of how this function works.
	 */
	public static class Atan implements Function {
		/**
		 * Returns the name of the function - "atan".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "atan";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return The arc tangent of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.atan(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function
	 * converts rectangular coordinates to polar. See the Math.atan2(double, double)
	 * method in the JDK for a complete description of how this function works.
	 */
	public static class Atan2 implements Function {
		/**
		 * Returns the name of the function - "atan2".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "atan2";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted into two double
		 *            values and evaluated.
		 * 
		 * @return The arc tangent2 value of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;

			ArrayList numbers = FunctionHelper.getDoubles(arguments, 
					EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);

			if (numbers.size() != 2) {
				throw new FunctionException("Two numeric arguments are required.");
			}

			try {
				double argumentOne = ((Double) numbers.get(0)).doubleValue();
				double argumentTwo = ((Double) numbers.get(1)).doubleValue();
				result = new Double(Math.atan2(argumentOne, argumentTwo));
			} catch (Exception e) {
				throw new FunctionException("Two numeric arguments are required.", e);
			}

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the ceiling value of a double value. See the Math.ceil(double) method in the
	 * JDK for a complete description of how this function works.
	 */
	public static class Ceil implements Function {
		/**
		 * Returns the name of the function - "ceil".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "ceil";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return The ceiling of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.ceil(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the trigonometric cosine of an angle. See the Math.cos(double) method in the
	 * JDK for a complete description of how this function works.
	 */
	public static class Cos implements Function {
		/**
		 * Returns the name of the function - "cos".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "cos";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return The cosine of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.cos(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the exponential number e (i.e., 2.718...) raised to the power of a double
	 * value. See the Math.exp(double) method in the JDK for a complete description
	 * of how this function works.
	 */
	public static class Exp implements Function {
		/**
		 * Returns the name of the function - "exp".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "exp";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return The the value e to the argument power, where e is the base of the
		 *         natural logarithms
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.exp(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the floor value of a double value. See the Math.floor(double) method in the
	 * JDK for a complete description of how this function works.
	 */
	public static class Floor implements Function {
		/**
		 * Returns the name of the function - "floor".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "floor";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return The floor of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.floor(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the remainder operation on two arguments as prescribed by the IEEE 754
	 * standard. See the Math.IEEERemainder(double, double) method in the JDK for a
	 * complete description of how this function works.
	 */
	public static class IEEEremainder implements Function {
		/**
		 * Returns the name of the function - "IEEEremainder".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "IEEEremainder";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted into two double
		 *            values and evaluated.
		 * 
		 * @return The the remainder operation on two arguments as prescribed by the
		 *         IEEE 754 standard.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;

			ArrayList numbers = FunctionHelper.getDoubles(arguments, 
					EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);

			if (numbers.size() != 2) {
				throw new FunctionException("Two numeric arguments are required.");
			}

			try {
				double argumentOne = ((Double) numbers.get(0)).doubleValue();
				double argumentTwo = ((Double) numbers.get(1)).doubleValue();
				result = new Double(Math.IEEEremainder(argumentOne, argumentTwo));
			} catch (Exception e) {
				throw new FunctionException("Two numeric arguments are required.", e);
			}

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the natural logarithm (base e) of a double value. See the Math.log(double)
	 * method in the JDK for a complete description of how this function works.
	 */
	public static class Log implements Function {
		/**
		 * Returns the name of the function - "log".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "log";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return The natural logarithm of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.log(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the greater of two double values. See the Math.max(double) method in the JDK
	 * for a complete description of how this function works.
	 */
	public static class Max implements Function {
		/**
		 * Returns the name of the function - "max".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "max";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted into two double
		 *            values and evaluated.
		 * 
		 * @return The greater of two values.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;

			ArrayList numbers = FunctionHelper.getDoubles(arguments, 
					EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);

			if (numbers.size() != 2) {
				throw new FunctionException("Two numeric arguments are required.");
			}

			try {
				double argumentOne = ((Double) numbers.get(0)).doubleValue();
				double argumentTwo = ((Double) numbers.get(1)).doubleValue();
				result = new Double(Math.max(argumentOne, argumentTwo));
			} catch (Exception e) {
				throw new FunctionException("Two numeric arguments are required.", e);
			}

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the smaller of two double values. See the Math.min(double, double) method in
	 * the JDK for a complete description of how this function works.
	 */
	public static class Min implements Function {
		/**
		 * Returns the name of the function - "min".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "min";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted into two double
		 *            values and evaluated.
		 * 
		 * @return The smaller of two values.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;

			ArrayList numbers = FunctionHelper.getDoubles(arguments, 
					EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);

			if (numbers.size() != 2) {
				throw new FunctionException("Two numeric arguments are required.");
			}

			try {
				double argumentOne = ((Double) numbers.get(0)).doubleValue();
				double argumentTwo = ((Double) numbers.get(1)).doubleValue();
				result = new Double(Math.min(argumentOne, argumentTwo));
			} catch (Exception e) {
				throw new FunctionException("Two numeric arguments are required.", e);
			}

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the value of the first argument raised to the second power of the second
	 * argument. See the Math.pow(double, double) method in the JDK for a complete
	 * description of how this function works.
	 */
	public static class Pow implements Function {
		/**
		 * Returns the name of the function - "pow".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "pow";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted into two double
		 *            values and evaluated.
		 * 
		 * @return The value of the first argument raised to the second power of the
		 *         second argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;

			ArrayList numbers = FunctionHelper.getDoubles(arguments, 
					EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);

			if (numbers.size() != 2) {
				throw new FunctionException("Two numeric arguments are required.");
			}

			try {
				double argumentOne = ((Double) numbers.get(0)).doubleValue();
				double argumentTwo = ((Double) numbers.get(1)).doubleValue();
				result = new Double(Math.pow(argumentOne, argumentTwo));
			} catch (Exception e) {
				throw new FunctionException("Two numeric arguments are required.", e);
			}

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * a random double value greater than or equal to 0.0 and less than 1.0. See the
	 * Math.random() method in the JDK for a complete description of how this
	 * function works.
	 */
	public static class Random implements Function {
		/**
		 * Returns the name of the function - "random".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "random";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            Not used.
		 * 
		 * @return A random double value greater than or equal to 0.0 and less than
		 *         1.0.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = new Double(Math.random());

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the double value that is closest in value to the argument and is equal to a
	 * mathematical integer. See the Math.rint(double) method in the JDK for a
	 * complete description of how this function works.
	 */
	public static class Rint implements Function {
		/**
		 * Returns the name of the function - "rint".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "rint";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return A double value that is closest in value to the argument and is
		 *         equal to a mathematical integer.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.rint(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the closet long to a double value. See the Math.round(double) method in the
	 * JDK for a complete description of how this function works.
	 */
	public static class Round implements Function {
		/**
		 * Returns the name of the function - "round".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "round";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return A long value that is closest to the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Long result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Long(Math.round(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * the sine of an angle. See the Math.sin(double) method in the JDK for a
	 * complete description of how this function works.
	 */
	public static class Sin implements Function {
		/**
		 * Returns the name of the function - "sin".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "sin";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return The sine of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.sin(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * a square root of a double value. See the Math.sqrt(double) method in the JDK
	 * for a complete description of how this function works.
	 */
	public static class Sqrt implements Function {
		/**
		 * Returns the name of the function - "sqrt".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "sqrt";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return A square root of the argument.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(final JevalEvaluator evaluator, final String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.sqrt(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function returns
	 * trigonometric tangent of an angle. See the Math.tan(double) method in the JDK
	 * for a complete description of how this function works.
	 */
	public static class Tan implements Function {
		/**
		 * Returns the name of the function - "tan".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "tan";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return A trigonometric tangent of an angle.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.tan(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function
	 * converts an angle measured in radians to the equivalent angle measured in
	 * degrees. See the Math.toDegrees(double) method in the JDK for a complete
	 * description of how this function works.
	 */
	public static class ToDegrees implements Function {
		/**
		 * Returns the name of the function - "toDegrees".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "toDegrees";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return A measurement of the argument in degrees.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.toDegrees(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
	/**
	 * This class is a function that executes within Evaluator. The function
	 * converts an angle measured in degress to the equivalent angle measured in
	 * radians. See the Math.toRadians(double) method in the JDK for a complete
	 * description of how this function works.
	 */
	public static class ToRadians implements Function {
		/**
		 * Returns the name of the function - "toRadians".
		 * 
		 * @return The name of this function class.
		 */
		public String getName() {
			return "toRadians";
		}

		/**
		 * Executes the function for the specified argument. This method is called
		 * internally by Evaluator.
		 * 
		 * @param evaluator
		 *            An instance of Evaluator.
		 * @param arguments
		 *            A string argument that will be converted to a double value and
		 *            evaluated.
		 * 
		 * @return A measurement of the argument in radians.
		 * 
		 * @exception FunctionException
		 *                Thrown if the argument(s) are not valid for this function.
		 */
		public FunctionResult execute(JevalEvaluator evaluator, String arguments)
				throws FunctionException {
			Double result = null;
			Double number = null;

			try {
				number = new Double(arguments);
			} catch (Exception e) {
				throw new FunctionException("Invalid argument.", e);
			}

			result = new Double(Math.toRadians(number.doubleValue()));

			return new FunctionResult(result.toString(), 
					EvaluationConstants.FUNCTION_RESULT_TYPE_NUMERIC);
		}
	}
}
