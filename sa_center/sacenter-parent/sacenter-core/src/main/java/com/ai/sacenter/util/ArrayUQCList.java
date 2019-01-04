package com.ai.sacenter.util;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: 类唯一性列表</p>
 * <p>Copyright: Copyright (c) 2014-7-2</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class ArrayUQCList extends java.util.ArrayList{
	private static final long serialVersionUID = -7866479365476202777L;
	private WeakHashMap INDEX = new WeakHashMap();
	public ArrayUQCList() {
		super();
	}
	/* （非 Javadoc）
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(Object element) {
		if( INDEX.containsKey( element ) == false){ 
			INDEX.put( element , new Integer( super.size() )); 
			super.add( element );
		}
		else{
			Integer index = (Integer)INDEX.get( element ); 
			super.set( index.intValue() , element );
		}
		return true;
	}

	/* （非 Javadoc）
	 * @see java.util.ArrayList#add(int, java.lang.Object)
	 */
	public void add( int index, Object element ) {
		throw new UnsupportedOperationException();
	}

	/* （非 Javadoc）
	 * @see java.util.ArrayList#addAll(java.util.Collection)
	 */
	public boolean addAll(java.util.Collection c) {
		return addAll( size() - 1 ,c );
	}

	/* （非 Javadoc）
	 * @see java.util.ArrayList#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, java.util.Collection c) {
		throw new UnsupportedOperationException();
	}

	/* （非 Javadoc）
	 * @see java.util.ArrayList#clear()
	 */
	public void clear() {
		INDEX.clear();
		super.clear();
	}

	/* (non-Javadoc)
	 * @see java.util.ArrayList#contains(java.lang.Object)
	 */
	public boolean contains(Object elem) {
		return indexOf(elem) >= 0;
	}
	/* （非 Javadoc）
	 * @see java.util.ArrayList#indexOf(java.lang.Object)
	 */
	public int indexOf(Object elem) {
		Object index = INDEX.get( elem );
		return index != null ? ((Integer)index).intValue():-1;
	}

	/* （非 Javadoc）
	 * @see java.util.ArrayList#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object elem) {
		return indexOf(elem);
	}

	/* （非 Javadoc）
	 * @see java.util.ArrayList#remove(int)
	 */
	public Object remove(int index) {
		Object dataSetForRemove = super.get( index );
		super.remove(index);
		INDEX.remove( dataSetForRemove );
        update( index );
		return dataSetForRemove;
	}

	/* （非 Javadoc）
	 * @see java.util.ArrayList#removeRange(int, int)
	 */
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	/* （非 Javadoc）
	 * @see java.util.AbstractCollection#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		boolean rtn = INDEX.containsKey( o );
		if( rtn == true) remove( ((Integer)INDEX.get( o )).intValue() );
		return rtn;
	}
	
	/* （非 Javadoc）
	 * @see java.util.AbstractCollection#removeAll(java.util.Collection)
	 */
	public boolean removeAll(java.util.Collection c) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	public Object get( Object element ){
		java.lang.Integer index = (java.lang.Integer)INDEX.get( element );
		if( index != null && index.intValue() >= 0 ){
			return super.get( index.intValue() );
		}
		return null;
	}
	
	/* （非 Javadoc）
	 * @see java.util.ArrayList#set(int, java.lang.Object)
	 */
	public Object set(int index, Object element) {
		Object oldValue = null;
		if( INDEX.containsKey( element ) == false)
			throw new IllegalArgumentException(element + " not exist");
		Integer indexs = (Integer)INDEX.get( element );
		if( indexs.intValue() != index ) 
			throw new IllegalArgumentException(element + " Laws of different instance of the index ");
		oldValue = super.get( index );
		super.set( index ,  element);
		return oldValue;
	}
	
	/**
	 * 
	 * @param fromIndex
	 */
	private void update( int fromIndex){
		Object dataSet = null;
		while( fromIndex < size() ){
			dataSet = get( fromIndex );
			INDEX.put( dataSet , new Integer( fromIndex ));
			fromIndex++;
		}
	}
}
