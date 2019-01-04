package com.ai.sacenter.util;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê10ÔÂ23ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class AssertUtils {

	public AssertUtils() {
		super();
	}

	/**
	 * 
	 * @param expression
	 * @param message
	 */
	public static void isTrue(boolean expression, String message) {
		if (!(expression))
			throw new IllegalArgumentException(message);
	}

	/**
	 * 
	 * @param expression
	 */
	public static void isTrue(boolean expression) {
		isTrue(expression,
				"[Assertion failed] - this expression must be true");
	}

	/**
	 * 
	 * @param object
	 * @param message
	 */
	public static void isNull(Object object, String message) {
		if (object == null)
			throw new IllegalArgumentException(message);
	}

	/**
	 * 
	 * @param object
	 */
	public static void isNull(Object object) {
		isNull(object,
				"[Assertion failed] - the object argument must be null");
	}

	/**
	 * 
	 * @param object
	 * @param message
	 */
	public static void notNull(Object object, String message) {
		if (object == null)
			throw new IllegalArgumentException(message);
	}

	/**
	 * 
	 * @param object
	 */
	public static void notNull(Object object) {
		notNull(object,
				"[Assertion failed] - this argument is required; it cannot be null");
	}

	/**
	 * 
	 * @param text
	 * @param message
	 */
	public static void hasLength(String text, String message) {
		if ((text != null) && (text.length() > 0))
			return;
		throw new IllegalArgumentException(message);
	}

	/**
	 * 
	 * @param text
	 */
	public static void hasLength(String text) {
		hasLength(
				text,
				"[Assertion failed] - this String argument must have length; it cannot be <code>null</code> or empty");
	}

	/**
	 * 
	 * @param text
	 * @param message
	 */
	public static void hasText(String text, String message) {
		if ((text != null) && (text.length() > 0))
			return;
		throw new IllegalArgumentException(message);
	}

	/**
	 * 
	 * @param text
	 */
	public static void hasText(String text) {
		hasText(
				text,
				"[Assertion failed] - this String argument must have text; it cannot be <code>null</code>, empty, or blank");
	}

	/**
	 * 
	 * @param textToSearch
	 * @param substring
	 * @param message
	 */
	public static void doesNotContain(String textToSearch,
			String substring, String message) {
		if (textToSearch.indexOf(substring) != -1)
			throw new IllegalArgumentException(message);
	}

	/**
	 * 
	 * @param textToSearch
	 * @param substring
	 */
	public static void doesNotContain(String textToSearch, String substring) {
		doesNotContain(textToSearch, substring,
				"[Assertion failed] - this String argument must not contain the substring ["
						+ substring + "]");
	}

	/**
	 * 
	 * @param array
	 * @param message
	 */
	public static void notEmpty(Object[] array, String message) {
		if ((array == null) || (array.length == 0))
			throw new IllegalArgumentException(message);
	}

	/**
	 * 
	 * @param array
	 */
	public static void notEmpty(Object[] array) {
		notEmpty(
				array,
				"[Assertion failed] - this array must not be empty: it must contain at least 1 element");
	}

	/**
	 * 
	 * @param collection
	 * @param message
	 */
	public static void notEmpty(java.util.Collection collection,
			String message) {
		if ((collection == null) || (collection.isEmpty()))
			throw new IllegalArgumentException(message);
	}

	/**
	 * 
	 * @param collection
	 */
	public static void notEmpty(java.util.Collection collection) {
		notEmpty(
				collection,
				"[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
	}

	/**
	 * 
	 * @param map
	 * @param message
	 */
	public static void notEmpty(java.util.Map map, String message) {
		if ((map == null) || (map.isEmpty()))
			throw new IllegalArgumentException(message);
	}

	/**
	 * 
	 * @param map
	 */
	public static void notEmpty(java.util.Map map) {
		notEmpty(
				map,
				"[Assertion failed] - this map must not be empty; it must contain at least one entry");
	}

	/**
	 * 
	 * @param clazz
	 * @param obj
	 */
	public static void isInstanceOf(Class clazz, Object obj) {
		isInstanceOf(clazz, obj, "");
	}

	/**
	 * 
	 * @param clazz
	 * @param obj
	 * @param message
	 */
	public static void isInstanceOf(Class clazz, Object obj, String message) {
		notNull(clazz,
				"The clazz to perform the instanceof assertion cannot be null");
		isTrue(clazz.isInstance(obj), message + "Object of class '"
				+ ((obj != null) ? obj.getClass().getName() : "[null]")
				+ "' must be an instance of '" + clazz.getName() + "'");
	}

	/**
	 * 
	 * @param expression
	 * @param message
	 */
	public static void state(boolean expression, String message) {
		if (!(expression))
			throw new IllegalStateException(message);
	}

	/**
	 * 
	 * @param expression
	 */
	public static void state(boolean expression) {
		state(expression,
				"[Assertion failed] - this state invariant must be true");
	}
}
