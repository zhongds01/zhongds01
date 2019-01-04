package com.ai.sacenter.util;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê10ÔÂ21ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class StackDeque extends ArrayList {
	private static final long serialVersionUID = 8494554526581870090L;
	public StackDeque() {
		super();
	}
	/**
	 * 
	 * @param item
	 * @return
	 */
	public Object push( Object item ){
		super.add( item );
		return item;
	}
	/**
	 * 
	 * @return
	 */
	public Object pop() {
		Object obj;
		int	len = size();
		obj = peek();
		super.remove( len - 1 );
		return obj;
	}
	/**
	 * 
	 * @return
	 */
	public Object peek() {
		int	len = size();
		if (len == 0) throw new EmptyStackException();
		return super.get( len - 1 );
	}
	/**
	 * 
	 * @return
	 */
	public boolean empty() {
		return size() == 0;
	}
	/**
	 * 
	 * @param item
	 * @return
	 */
	public int search(Object item) {
		int fromINDEX = lastIndexOf( item );
		if( fromINDEX >= 0 ) { return size() - fromINDEX;}
		return -1;
	}
}
