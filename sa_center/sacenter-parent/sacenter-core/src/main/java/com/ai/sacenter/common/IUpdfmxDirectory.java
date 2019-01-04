package com.ai.sacenter.common;

import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018Äê6ÔÂ24ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdfmxDirectory implements java.io.Serializable{
	private static final long serialVersionUID = -2738458242430929419L;
	private String _group_        ;
	private IUpdfmxEntry _bottle_ ;
	private CarbonList<IUpdfmxEntry> _directory = new CarbonList<IUpdfmxEntry>();
	public IUpdfmxDirectory() {
		super();
	}

	public IUpdfmxDirectory(  String __group__ ) {
		super();
		_group_  = __group__;
	}
	
	public IUpdfmxDirectory( String __group__, IUpdfmxEntry __bottle__ ) {
		super();
		_group_  = __group__ ;
		_bottle_ = __bottle__;
	}
	
	public IUpdfmxDirectory(IUpdfmxDirectory directory) {
		super();
		_group_  = directory._group_ ;
		_bottle_ = (IUpdfmxEntry)ClassUtils.IClass.atomDesign( directory._bottle_ );
		for( java.util.Iterator<IUpdfmxEntry> itera = directory._directory.iterator(); itera.hasNext(); ){
			IUpdfmxEntry _entry_ = (IUpdfmxEntry)itera.next();
			_directory.add( (IUpdfmxEntry)ClassUtils.IClass.atomDesign( _entry_ ) );
		}
	}
	
	/**
	 * @return the _group_
	 */
	public String getGroup() {
		return _group_;
	}

	/**
	 * @return the _bottle_
	 */
	public IUpdfmxEntry getBottle() {
		return _bottle_;
	}

	/**
	 * @param bottle
	 */
	public void setBottle(IUpdfmxEntry bottle) {
		_bottle_ = bottle;
	}

	/**
	 * 
	 * @return
	 */
	public CarbonList<IUpdfmxEntry> getDirectory(){
		return _directory; 
	}
}
