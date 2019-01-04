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
public class IUpdfmxEntry implements java.io.Serializable{
	private static final long serialVersionUID = 5747490934848629788L;
	private CarbonList<IUpdfmxEntry> _subject = new CarbonList<IUpdfmxEntry>();
	public IUpdfmxEntry() {
		super();
	}
	
	public IUpdfmxEntry(IUpdfmxEntry _entry_) {
		super();
		for( java.util.Iterator<IUpdfmxEntry> itera = _entry_._subject.iterator(); itera.hasNext(); ){
			IUpdfmxEntry __entry__ = (IUpdfmxEntry)itera.next();
			_subject.add( (IUpdfmxEntry)ClassUtils.IClass.atomDesign( __entry__ ) );
		}
	}

	/**
	 * 
	 * @return
	 */
	public CarbonList<IUpdfmxEntry> getSUBJECT(){
		return _subject;
	}
}
