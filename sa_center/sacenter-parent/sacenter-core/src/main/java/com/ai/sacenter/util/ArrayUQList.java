package com.ai.sacenter.util;

import java.util.Collection;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-3-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class ArrayUQList extends java.util.ArrayList {
	private static final long serialVersionUID = 2366277342831252685L;
	public ArrayUQList() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(Object element) {
		boolean retn = false;
		try
		{
			int indexOf = super.indexOf( element );
			if( indexOf < 0 ) retn = super.add( element );
			else retn = super.set( indexOf , element ) != null;
		}
		finally{
			
		}
		return retn;
	}
	/* (non-Javadoc)
	 * @see java.util.ArrayList#add(int, java.lang.Object)
	 */
	public void add(int index, Object element) {
		try
		{
			if (index > super.size() || index < 0) throw new IndexOutOfBoundsException("Index: "+index+", Size: "+super.size());
			int indexOf = super.indexOf( element );
			if( indexOf < 0 ) super.add( index , element );
			else super.set( indexOf , element );
		}
		finally{
			
		}
	}
	/* (non-Javadoc)
	 * @see java.util.ArrayList#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection collection) {
		boolean retn = false;
		java.util.ArrayList lstAdds = new java.util.ArrayList();
		try
		{
			for( java.util.Iterator itera = collection.iterator(); itera.hasNext() ; ){
				Object element = itera.next();
				int indexOf = super.indexOf( element );
				if( indexOf < 0 ) lstAdds.add( element );
				else super.set( indexOf , element );
			}
			retn = super.addAll( lstAdds );
		}
		finally{
			
		}
		return retn;
	}
	/* (non-Javadoc)
	 * @see java.util.ArrayList#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection collection) {
		boolean retn = false;
		java.util.ArrayList lstAdds = new java.util.ArrayList();
		try
		{
			for( java.util.Iterator itera = collection.iterator(); itera.hasNext() ; ){
				Object element = itera.next();
				int indexOf = super.indexOf( element );
				if( indexOf < 0 ) lstAdds.add( element );
				else super.set( indexOf , element );
			}
			retn = super.addAll( index , lstAdds );
		}
		finally{
			
		}
		return retn;
	}
	/* (non-Javadoc)
	 * @see java.util.ArrayList#set(int, java.lang.Object)
	 */
	public Object set(int index, Object element) {
		Object oldValue = null;
		try
		{
			if (index > super.size() || index < 0) throw new IndexOutOfBoundsException("Index: "+index+", Size: "+super.size());
			int indexOf = super.indexOf( element );
			if( indexOf < 0 ) super.add( index , element );
			else super.set( indexOf , element );
		}
		finally{
			
		}
		return oldValue;
	}
}
