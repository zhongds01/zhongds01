package com.ai.sacenter.util;

import java.util.ConcurrentModificationException;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.Property;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.OracleUtils;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: 最终数据存储清单</p>
 * <p>Copyright: Copyright (c) 2015-1-4</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class PeriodLatenList extends java.util.ArrayList<DataStructInterface> implements java.util.List<DataStructInterface>, java.lang.Cloneable, java.io.Serializable {
	private static final long serialVersionUID = -5386211405470154388L;
	protected java.util.ArrayList<DataStructInterface> _trajectory = new java.util.ArrayList<DataStructInterface>();
	public PeriodLatenList() {
		super();
	}
	
	/**
	 * Returns the number of elements in this list.
	 * @return
	 */
	public int size() {
		return super.size();
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * @return
	 */
	public boolean isEmpty() {
		return super.size() == 0;
	}
	
	/**
	 * 
	 * @param element element whose presence in this list is to be tested
	 * @return
	 */
	public DataStructInterface get( DataStructInterface element ){
		DataStructInterface _element = null;
		int _indexOf = indexOf( element );
		if( _indexOf >= 0 ){ _element = (DataStructInterface)super.get( _indexOf ); }
		return _element;
	}
	
	/**
	 * Returns <tt>true</tt> if this list contains the specified element. More
	 * @param element element whose presence in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 */
	public boolean contains(Object element) {
		return indexOf( element ) >= 0;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this list, or -1 if this list does not contain the element.
	 */
	public int indexOf(Object element) {
		if( element == null ) {
			for( int index = 0; index < super.size(); index++ ) {
				DataStructInterface fromLaten = (DataStructInterface)super.get( index );
				if( fromLaten == null ){ 
					return index; 
				}
			}
		} 
		else if( element instanceof DataStructInterface ){
			for( int index = 0; index < super.size(); index++ ) {
				DataStructInterface fromLaten = (DataStructInterface)super.get( index );
				if( element.equals( fromLaten ) ){ 
					return index; 
				}
				else if( OracleUtils.ICustom.equals( (DataStructInterface)element, fromLaten ) ){
					return index;
				}
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally,
	 * returns the highest index 
	 * or -1 if there is no such index.
	 */
	public int lastIndexOf(Object element) {
		return indexOf( element );
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return
	 */
	public DataStructInterface set(int index, DataStructInterface element) {
		throw new java.lang.UnsupportedOperationException();
	}
	
	/**
	 * 
	 * @param _change
	 * @param fromEntity
	 * @throws Exception
	 */
	private void transfer( java.util.Map<String, Object> _change, DataStructInterface fromEntity ) throws Exception{
		try 
		{
			java.util.Map<String, Property> fromPrimary = fromEntity.getKeyProperties();
			for( java.util.Iterator<java.util.Map.Entry<String, Object>> itera = _change.entrySet().iterator(); itera.hasNext(); ) {
				java.util.Map.Entry<String, Object> fromEntry = itera.next();
				String fromKEY = fromEntry.getKey().toUpperCase();
				Object fromLeft = fromEntry.getValue();
				if( fromEntity.getObjectType().hasProperty( fromKEY ) && fromPrimary.containsKey( fromKEY ) == false ) {
					if( fromEntity.isNew() ){
						fromEntity.set( fromKEY, fromLeft );
					} 
					else if( fromEntity.isDeleted() ) {
						fromEntity.set( fromKEY, fromLeft );
					} 
					else{
						Object fromRight = fromEntity.getNewProperties().get( fromKEY );
						if( ClassUtils.IMerge.equals( fromLeft, fromRight ) == false ) {
							fromEntity.set(fromKEY, fromLeft);
						}
					}
				}
			}
		} 
		finally{

		}
	}
	
	/**
	 * Inserts the specified element at the end of this deque.
	 * @param fromChange  the element to change before
	 * @param fromTail the element to change after
	 */
	private DataStructInterface trajectory(DataStructInterface fromChange, DataStructInterface fromTail) throws Exception {
		try
		{
			if( fromTail.isNew() ) {
				if( fromChange.isNew() ) {
					remove(fromTail);
					fromTail = fromChange;
				} 
				else if( fromChange.isModified() ) {
					transfer(fromChange.getNewProperties(), fromTail);
					remove(fromChange);
				} 
				else if( fromChange.isDeleted() ) {
					remove(fromChange);
					remove(fromTail);
					fromTail = null;
				}
			} 
			else if( fromTail.isModified() ) {
				if( fromChange.isNew() ) {
					transfer(fromChange.getNewProperties(), fromTail);
					remove(fromChange);
				} 
				else if( fromChange.isModified() ) {
					transfer(fromChange.getNewProperties(), fromTail);
					remove(fromChange);
				} 
				else if( fromChange.isDeleted() ) {
					remove(fromTail);
					fromTail = fromChange;
				}
			} 
			else if( fromTail.isDeleted() ) {
				if( fromChange.isNew() ) {
					fromTail.setStsToOld();
					transfer(fromChange.getNewProperties(), fromTail);
					remove(fromChange);
				} 
				else if( fromChange.isModified() ) {
					remove(fromChange);
					/*fromTail.setStsToOld();
					transfer(fromChange.getNewProperties(), fromTail);
					remove(fromChange);*/
				} 
				else if( fromChange.isDeleted() ) {
					remove(fromTail);
					fromTail = fromChange;
				}
			}
		} 
		finally{

		}
		return fromTail;
	}
	
	/**
     * Retrieves, but does not remove, the first element of this list.
     * @param element the element
     * @return the first of this trajectory
     * 
     */
	private DataStructInterface getFirst( DataStructInterface element ){
		DataStructInterface fromFirst = null;
		try
		{
			for( int index = 0; index < _trajectory.size(); index++ ){
				DataStructInterface fromEntity = _trajectory.get( index );
				if( OracleUtils.ICustom.isCommit( fromEntity ) && OracleUtils.ICustom.equals(element, fromEntity) ){
					fromFirst = fromEntity;
					break;
				}
			}
		}
		finally{
			
		}
		return fromFirst;
	}
	
	/**
	 * the specified element list at this laten list.
	 * @param element the element
	 *
	 */
	private java.util.List<DataStructInterface> getPeriod(DataStructInterface element) {
		java.util.List<DataStructInterface> _delegation = new java.util.ArrayList<DataStructInterface>();
		try
		{
			for( int index = 0; index < super.size(); index++ ){
				DataStructInterface fromEntity = (DataStructInterface)super.get( index );
				if( OracleUtils.ICustom.isCommit( fromEntity ) && OracleUtils.ICustom.equals(element, fromEntity) ){
					_delegation.add( fromEntity );
				}
			}
		}
		finally{
			
		}
		return _delegation;
	}
	
	/**
	 * Inserts the specified element at the end of this deque.
	 * @param element the element to change before
	 */
	public void trajectory(DataStructInterface element) {
		java.util.List<DataStructInterface> _delegation = null;
		try
		{
			_delegation = getPeriod( element );
			DataStructInterface fromHead = getFirst( element );
			if( fromHead != null && _delegation != null && _delegation.size() <= 1 ){
				if(  fromHead.equals( element ) == false ){
					super.add( fromHead );
					trajectory( element, fromHead );
				}
			}
			else if (_delegation != null && _delegation.size() > 1) {
				DataStructInterface fromTail = null, fromChange = null;
				for (java.util.Iterator<DataStructInterface> itera = _delegation.iterator(); itera.hasNext();) {
					if( fromTail == null ) {
						fromTail = itera.next();
					} 
					else{
						fromChange = itera.next();
						fromTail = trajectory(fromChange, fromTail);
					}
				}
			}
		} 
		catch (java.lang.Exception aEXCEPTION) {
			ExceptionFactory.throwOracle("IOS0014000", new String[] { 
					aEXCEPTION.getMessage() }, aEXCEPTION);
		} 
		finally {
			if (_delegation != null) { _delegation.clear(); _delegation = null; }
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#add(java.lang.Object)
	 */
	public boolean add(DataStructInterface element) {
		DataStructInterface fromEntity = (DataStructInterface)element;
		_trajectory.add( fromEntity );
		if( OracleUtils.ICustom.isCommit( fromEntity ) ){
			super.add( fromEntity );
			trajectory( fromEntity );
		}
		return true;
	}

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 */
	public void add(int index, DataStructInterface element) {
		throw new java.lang.UnsupportedOperationException();
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * 
	 * @param index
	 *            the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 */
	public DataStructInterface remove(int index) {
		throw new java.lang.UnsupportedOperationException();
	}
	
	/**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
    	super.clear();
    	_trajectory.clear();
    }
	/**
	 *
	 * @param collection collection containing elements to be added to this list
	 * @return 
	 */
	public boolean addAll(java.util.Collection<? extends DataStructInterface> collection) {
		int numNew = collection.size();
		for( java.util.Iterator<? extends DataStructInterface> itera = collection.iterator(); itera.hasNext(); ) {
			DataStructInterface element = (DataStructInterface)itera.next();
			add(element);
		}
		return numNew != 0;
	}

	/**
	 * 
	 * @param index index at which to insert the first element from the specified  collection
	 * @param collection collection containing elements to be added to this list
	 * @return 
	 */
	public boolean addAll(int index, java.util.Collection<? extends DataStructInterface> collection) {
		return addAll( collection );
	}

	/**
	 * Save the state of the <tt>ArrayList</tt> instance to a stream (that is,
	 * serialize it).
	 * 
	 * @serialData 
	 */
	private void writeObject(java.io.ObjectOutputStream _out) throws java.io.IOException {
		int expectedModCount = modCount;
		_out.defaultWriteObject();
		_out.writeInt(super.size());
		for( int index = 0; index < super.size(); index++ ){
			DataStructInterface element = (DataStructInterface)super.get( index );
			_out.writeObject(element);
		}
		_out.writeInt( _trajectory.size() );
		for( int index = 0; index < _trajectory.size(); index++ ){
			DataStructInterface element = _trajectory.get( index );
			_out.writeObject(element);
		}
		if( modCount != expectedModCount ) {
			throw new ConcurrentModificationException();
		}
	}

	/**
	 * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
	 * deserialize it).
	 */
	private void readObject(java.io.ObjectInputStream _in) throws java.io.IOException, ClassNotFoundException {
		_in.defaultReadObject();
		int arrayLength = _in.readInt();
		for (int index = 0; index < arrayLength; index++)
			super.add( (DataStructInterface)_in.readObject() );
		arrayLength = _in.readInt();
		for (int index = 0; index < arrayLength; index++)
			_trajectory.add( (DataStructInterface)_in.readObject() );
	}
	
}
