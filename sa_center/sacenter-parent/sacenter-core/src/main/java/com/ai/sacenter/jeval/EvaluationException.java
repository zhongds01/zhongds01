package com.ai.sacenter.jeval;

/**
 * This exception is thrown when an error occurs during the evaluation process.
 */
public class EvaluationException extends Exception {

	private static final long serialVersionUID = -3010333364122748053L;

	/**
	 * This constructor takes a custom message as input.
	 * 
	 * @param message
	 *            A custom message for the exception to display.
	 */
	public EvaluationException(String message) {
		super(message);
	}

	/**
	 * This constructor takes an exception as input.
	 * 
	 * @param exception
	 *            An exception.
	 */
	public EvaluationException(Exception exception) {
		super(exception);
	}

	/**
	 * This constructor takes an exception as input.
	 * 
	 * @param message
	 *            A custom message for the exception to display.
	 * @param exception
	 *            An exception.
	 */
	public EvaluationException(String message, Exception exception) {
		super(message, exception);
	}
}
