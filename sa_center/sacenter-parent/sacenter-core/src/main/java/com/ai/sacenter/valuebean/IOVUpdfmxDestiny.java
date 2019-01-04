package com.ai.sacenter.valuebean;

import java.util.ConcurrentModificationException;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.Property;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.subtable.SFSubTableFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OracleUtils;

public class IOVUpdfmxDestiny implements java.io.Serializable{
	private static final long serialVersionUID = -1155832527595894008L;
	private Object _objective;
	private java.util.HashMap<String, IUpdfmxOffer> _destiny = new java.util.HashMap<String, IUpdfmxOffer>();
	public IOVUpdfmxDestiny( Object objective ){
		super();
		_objective = objective;
	}
	
	/**
	 * @return the _objective
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return the _destiny
	 */
	public java.util.HashMap<String, IUpdfmxOffer> getDestiny() {
		return _destiny;
	}
	
	/**
	 * 
	 * @param destiny
	 * @param bottle
	 * @return
	 * @throws Exception
	 */
	public IUpdfmxDestiny getDestiny( Class<?> destiny ) throws Exception {
		IUpdfmxDestiny fromDestiny = null; 
		String fromINDEX = ClassUtils.getINDEX( new String[]{ destiny.getName() } );
		fromDestiny = (IUpdfmxDestiny)_destiny.get( fromINDEX );
		if( fromDestiny == null ){
			_destiny.put( fromINDEX, fromDestiny = new IUpdfmxDestiny( destiny ) ); 
		}
		return fromDestiny;
	}
	
	/**
	 * 
	 * @param destiny
	 * @param bottle
	 * @return
	 * @throws Exception
	 */
	public IUpdfmxBottle getBottle( Class<?> destiny, DataStructInterface bottle ) throws Exception {
		IUpdfmxBottle fromBottle = null; 
		String _table_name = SFSubTableFactory.createTableName( bottle );
		String fromINDEX = ClassUtils.getINDEX( new String[]{ destiny.getName(), "_$_", _table_name } );
		fromBottle = (IUpdfmxBottle)_destiny.get( fromINDEX );
		if( fromBottle == null ){
			_destiny.put( fromINDEX, fromBottle = new IUpdfmxBottle( destiny, _table_name ) ); 
		}
		return fromBottle;
	}
	
	public static class IUpdfmxOffer implements java.io.Serializable{
		private static final long serialVersionUID = 3669299211566946701L;
		private Class<?>  _destiny;
		public IUpdfmxOffer( Class<?> destiny ){
			super();
			_destiny    = destiny;
		}
		
		/**
		 * @return the _destiny
		 */
		public Class<?> getDestiny() {
			return _destiny;
		}
	}
	
	public static class IUpdfmxDestiny extends IUpdfmxOffer{
		private static final long serialVersionUID = -4668925132157934519L;
		private java.util.ArrayList<DataStructInterface> _bottle = new java.util.ArrayList<DataStructInterface>();
		public IUpdfmxDestiny( Class<?> destiny ){
			super( destiny );
		}
		
		/**
		 * @return the _bottle
		 */
		public java.util.ArrayList<DataStructInterface> getBottle() {
			return _bottle;
		}
	}
	
	public static class IUpdfmxBottle extends IUpdfmxOffer{
		private static final long serialVersionUID = -1976815981035975336L;
		private String _subject;
		private HQSQLBottle _bottle = new HQSQLBottle();
		public IUpdfmxBottle( Class<?> destiny, String subject ){
			super( destiny );
			_subject = subject;
		}

		/**
		 * @return the _subject
		 */
		public String getSubject() {
			return _subject;
		}
		
		/**
		 * @return the _bottle
		 */
		public HQSQLBottle getBottle() {
			return _bottle;
		}
	}
	
	public static class HQSQLBottle extends java.util.ArrayList<DataStructInterface> implements java.util.List<DataStructInterface>, java.lang.Cloneable, java.io.Serializable {
		private static final long serialVersionUID = -5386211405470154388L;
		private java.util.ArrayList<DataStructInterface> _bottle = new java.util.ArrayList<DataStructInterface>();
		public HQSQLBottle() {
			super();
		}
		
		/**
		 * 
		 * @return
		 */
		public int size() {
			return super.size();
		}

		/**
		 * 
		 * @return
		 */
		public boolean isEmpty() {
			return super.size() == 0;
		}
		
		/**
		 * 
		 * @return
		 */
		public java.util.ArrayList<DataStructInterface> getBottle(){
			return _bottle;
		}
		
		/**
		 * 
		 * @param element
		 * @return
		 */
		public DataStructInterface get( DataStructInterface element ){
			DataStructInterface _element = null;
			int _indexOf = indexOf( element );
			if( _indexOf >= 0 ){ _element = (DataStructInterface)super.get( _indexOf ); }
			return _element;
		}
		
		/**
		 * 
		 * @param element
		 * @return
		 */
		public boolean contains(Object element) {
			return indexOf( element ) >= 0;
		}
		
		/**
		 * 
		 * @param element
		 * @return
		 */
		public int indexOf(Object element) {
			if( element == null ) {
				for( int index = 0; index < super.size(); index++ ) {
					DataStructInterface __bottle = (DataStructInterface)super.get( index );
					if( __bottle == null ){ return index; }
				}
			} 
			else if( element instanceof DataStructInterface ){
				DataStructInterface _element = (DataStructInterface)element;
				for( int index = 0; index < super.size(); index++ ) {
					DataStructInterface __bottle = (DataStructInterface)super.get( index );
					if( _element.equals( __bottle ) ){ return index; }
					else if( OracleUtils.ICustom.equals( _element, __bottle ) ){ return index; }
				}
			}
			return -1;
		}
		
		/**
		 * 
		 * @param element
		 * @return
		 */
		private int _indexOfBottle( Object element ){
			if( element != null && element instanceof DataStructInterface ){
				DataStructInterface _element = (DataStructInterface)element;
				for( int index = 0; index < _bottle.size(); index++ ){
					DataStructInterface __bottle = (DataStructInterface)super.get( index );
					if( _element.equals( __bottle ) ){ return index; }
					else if( OracleUtils.ICustom.equals( _element, __bottle ) ){ return index; }
				}
			}
			return -1;
		}
		
		/**
		 * 
		 * @param element
		 * @return
		 */
		public int lastIndexOf(Object element) {
			return indexOf( element );
		}

		/**
		 * 
		 * @param element
		 */
		private void _unqiuceAsRabot( DataStructInterface element ){
			DataStructInterface fromEntity = (DataStructInterface)element;
			_bottle.add( fromEntity );
			if( OracleUtils.ICustom.isCommit( fromEntity ) ){
				super.add( fromEntity );
				trajectory( fromEntity );
			}
		}
		
		/**
		 * 
		 * @param element
		 * @return
		 */
		private void _deleteAsRabot( Object element ){
			int _indexOf = _indexOfBottle( element );
			while( _indexOf >= 0 ){ 
				_bottle.remove( _indexOf); 
				_indexOf = _indexOfBottle( element ); 
			}
			_indexOf = indexOf( element );
			if( _indexOf >= 0 ){ super.remove( _indexOf ); }
		}
		
		/**
		 * 
		 * @param index
		 * @return
		 */
		public DataStructInterface remove(int index) {
			throw new java.lang.UnsupportedOperationException();
		}

		/**
		 * 
		 * @param fromIndex
		 * @param toIndex
		 * @return
		 */
		protected void removeRange(int fromIndex, int toIndex) {
			throw new java.lang.UnsupportedOperationException();
		}
		
		/**
		 * 
		 * @param element
		 * @return
		 */
		public boolean remove(Object element) {
			_deleteAsRabot( element );
			return true;
		}

		/**
		 * 
		 * @param collection
		 * @return
		 */
		public boolean removeAll(java.util.Collection<?> collection) {
			for( java.util.Iterator<?> itera = collection.iterator(); itera.hasNext(); ){
				Object element = itera.next();
				if( element != null && element instanceof DataStructInterface ){
					_deleteAsRabot( element );
				}
			}
			return true;
		}

		/**
		 * 
		 * @param collection
		 * @return
		 */
		public boolean retainAll(java.util.Collection<?> collection) {
			throw new java.lang.UnsupportedOperationException();
		}

		/**
		 * 
		 */
	    public void clear() {
	    	super.clear();
	    	_bottle.clear();
	    }
	    
		/**
		 * 
		 * @param _change
		 * @param __bottle
		 * @throws Exception
		 */
		private void _mergeAsRabot( java.util.Map<String, Object> _change, DataStructInterface __bottle ) throws Exception{
			try 
			{
				java.util.Map<String, Property> fromPrimary = __bottle.getKeyProperties();
				for( java.util.Iterator<java.util.Map.Entry<String, Object>> itera = _change.entrySet().iterator(); itera.hasNext(); ) {
					java.util.Map.Entry<String, Object> fromEntry = itera.next();
					String fromKEY = fromEntry.getKey().toUpperCase();
					Object fromLeft = fromEntry.getValue();
					if( __bottle.getObjectType().hasProperty( fromKEY ) && fromPrimary.containsKey( fromKEY ) == false ) {
						if( __bottle.isNew() ){
							__bottle.set( fromKEY, fromLeft );
						} 
						else if( __bottle.isDeleted() ) {
							__bottle.initProperty( fromKEY, fromLeft );
						} 
						else{
							Object fromRight = __bottle.getNewProperties().get( fromKEY );
							if( ClassUtils.IMerge.equals( fromLeft, fromRight ) == false ) {
								__bottle.set(fromKEY, fromLeft);
							}
						}
					}
				}
			} 
			finally{

			}
		}
		
		/**
		 * 
		 * @param fromChange
		 * @param fromTail
		 * @return
		 * @throws Exception
		 */
		private DataStructInterface trajectory(DataStructInterface fromChange, DataStructInterface fromTail) throws Exception {
			try
			{
				if( fromTail.isNew() ) {
					if( fromChange.isNew() ) {
						super.remove( fromTail );
						fromTail = fromChange;
					} 
					else if( fromChange.isModified() ) {
						_mergeAsRabot(fromChange.getNewProperties(), fromTail);
						super.remove( fromChange );
					} 
					else if( fromChange.isDeleted() ) {
						super.remove( fromChange );
						super.remove( fromTail );
						fromTail = null;
					}
				} 
				else if( fromTail.isModified() ) {
					if( fromChange.isNew() ) {
						_mergeAsRabot(fromChange.getNewProperties(), fromTail);
						super.remove( fromChange );
					} 
					else if( fromChange.isModified() ) {
						_mergeAsRabot(fromChange.getNewProperties(), fromTail);
						super.remove( fromChange );
					} 
					else if( fromChange.isDeleted() ) {
						super.remove( fromTail );
						fromTail = fromChange;
					}
				} 
				else if( fromTail.isDeleted() ) {
					if( fromChange.isNew() ) {
						fromTail.setStsToOld();
						_mergeAsRabot(fromChange.getNewProperties(), fromTail);
						super.remove( fromChange );
					} 
					else if( fromChange.isModified() ) {
						_mergeAsRabot(fromChange.getNewProperties(), fromTail);
						super.remove( fromChange );
					} 
					else if( fromChange.isDeleted() ) {
						super.remove( fromTail );
						fromTail = fromChange;
					}
				}
			} 
			finally{

			}
			return fromTail;
		}
		
		/**
		 * 
		 * @param element
		 * @return
		 */
		private DataStructInterface getFirst( DataStructInterface element ){
			DataStructInterface fromFirst = null;
			try
			{
				for( int index = 0; index < _bottle.size(); index++ ){
					DataStructInterface ___bottle = _bottle.get( index );
					if( OracleUtils.ICustom.isCommit( ___bottle ) && OracleUtils.ICustom.equals(element, ___bottle) ){
						fromFirst = ___bottle;
						break;
					}
				}
			}
			finally{
				
			}
			return fromFirst;
		}
		
		/**
		 * 
		 * @param element
		 * @return
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
		 * 
		 * @param element
		 */
		public void trajectory(DataStructInterface element) {
			try
			{
				DataStructInterface fromHead = getFirst( element );
				java.util.List<DataStructInterface> __bottle = getPeriod( element );
				if( fromHead != null && __bottle != null && __bottle.size() <= 1 ){
					if(  fromHead.equals( element ) == false ){
						super.add( fromHead );
						trajectory( element, fromHead );
					}
				}
				else if( __bottle != null && __bottle.size() > 1 ) {
					DataStructInterface fromTail = null, fromChange = null;
					for (java.util.Iterator<DataStructInterface> itera = __bottle.iterator(); itera.hasNext();) {
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
			finally{
				
			}
		}

		/**
		 * 
		 * @param index
		 * @param element
		 * @return
		 */
		public DataStructInterface set(int index, DataStructInterface element) {
			DataStructInterface _element = get( element );
			_unqiuceAsRabot( element );
			return _element;
		}
		
		/**
		 * 
		 * @param element
		 * @return
		 */
		public boolean add(DataStructInterface element) {
			_unqiuceAsRabot( element );
			return true;
		}

		/**
		 * 
		 * @param index
		 * @param element
		 * @return
		 */
		public void add(int index, DataStructInterface element) {
			_unqiuceAsRabot( element );
		}
		
	    /**
		 * 
		 * @param collection
		 * @return
		 */
		public boolean addAll(java.util.Collection<? extends DataStructInterface> collection) {
			int numNew = collection.size();
			for( java.util.Iterator<? extends DataStructInterface> itera = collection.iterator(); itera.hasNext(); ) {
				DataStructInterface element = (DataStructInterface)itera.next();
				_unqiuceAsRabot( element );
			}
			return numNew != 0;
		}

	    /**
	     * 
	     * @param index
	     * @param collection
	     * @return
	     */
		public boolean addAll(int index, java.util.Collection<? extends DataStructInterface> collection) {
			int numNew = collection.size();
			for( java.util.Iterator<? extends DataStructInterface> itera = collection.iterator(); itera.hasNext(); ) {
				DataStructInterface element = (DataStructInterface)itera.next();
				_unqiuceAsRabot( element );
			}
			return numNew != 0;
		}

	    /**
	     * 
	     * @param _out
	     */
		private void writeObject(java.io.ObjectOutputStream _out) throws java.io.IOException {
			int expectedModCount = modCount;
			_out.defaultWriteObject();
			_out.writeInt(super.size());
			for( int index = 0; index < super.size(); index++ ){
				DataStructInterface element = (DataStructInterface)super.get( index );
				_out.writeObject(element);
			}
			_out.writeInt( _bottle.size() );
			for( int index = 0; index < _bottle.size(); index++ ){
				DataStructInterface element = _bottle.get( index );
				_out.writeObject(element);
			}
			if( modCount != expectedModCount ) {
				throw new ConcurrentModificationException();
			}
		}
		
		/**
	     * 
	     * @param _in
	     */
		private void readObject(java.io.ObjectInputStream _in) throws java.io.IOException, ClassNotFoundException {
			_in.defaultReadObject();
			int arrayLength = _in.readInt();
			for (int index = 0; index < arrayLength; index++){
				super.add( (DataStructInterface)_in.readObject() );
			}
			arrayLength = _in.readInt();
			for (int index = 0; index < arrayLength; index++){
				_bottle.add( (DataStructInterface)_in.readObject() );
			}
		}
		
	}
}
