package com.ai.sacenter.util;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018Äê4ÔÂ2ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class CarbonList<E> extends java.util.ArrayList<E> implements java.util.List<E>{
	private static final long serialVersionUID = 6770804397640280057L;
	public CarbonList() {
		super();
	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	public int indexOf(Object element) {
		if( element == null ){
			for( int index = 0; index < super.size(); index++ ){
				if( super.get( index ) == null ){ return index; }
			}
		}
		else{
			for( int index = 0; index < super.size(); index++ ){
				E _objective = super.get( index );
				if( _objective != null && _objective.equals( element ) ){
					return index;
				}
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	public E get( Object element ){
		int indexOf = indexOf( element );
		if( indexOf < 0 ){ return null; }
		else{ return super.get( indexOf ); }
	}
}
