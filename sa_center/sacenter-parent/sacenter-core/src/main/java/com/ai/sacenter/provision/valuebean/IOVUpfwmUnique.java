package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.valuebean.IOVUpdfmxUnique.IUpdfmxUnique;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ��Ԫ��������</p>
 * <p>Copyright: Copyright (c) 2018��8��7��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfwmUnique extends IUpdfmxUnique implements java.io.Serializable{
	private static final long serialVersionUID = 6333809591760786896L;
	/*��������*/
	private String _composite;
	/*һ������*/
	private IOVUpfwmOffer _provision;
	/*��������*/
	private CarbonList<IOVUpfwmOffer> _subflow = new CarbonList<IOVUpfwmOffer>();
	public IOVUpfwmUnique(){
		super();
	}
	
	public IOVUpfwmUnique( IOVUpfwmUnique _unique_ ) throws Exception{
		super( _unique_ );
		_composite   = _unique_._composite   ;
		if( _unique_._provision != null ){_provision = new IOVUpfwmOffer( _unique_._provision );}
		for( java.util.Iterator<IOVUpfwmOffer> itera = _unique_._subflow.iterator(); itera.hasNext(); ){
			IOVUpfwmOffer __little__ = (IOVUpfwmOffer)itera.next();
			if( __little__ == null ){ continue; }
			_subflow.add( new IOVUpfwmOffer( __little__ ) );
		}
	}
	
	public IOVUpfwmUnique( IOVUpfwmOffer _provision_ ) throws Exception{
		super();
		_order_id    = _provision_.getORDER_ID  ();   
		_category    = _provision_.getCOMPOSITE ();
		_user_id     = _provision_.getUSER_ID   ();
		_create_date = _provision_.getORDER_DATE();
		_region_id   = _provision_.getREGION_ID ();
	}
	
	public IOVUpfwmUnique(String _category_, IOVUpfwmOffer _provision_ ) throws Exception{
		super();
		_order_id    = _provision_.getORDER_ID  ();   
		_category    = _category_                 ;
		_user_id     = _provision_.getUSER_ID   ();
		_create_date = _provision_.getORDER_DATE();
		_region_id   = _provision_.getREGION_ID ();
	}
	
	public IOVUpfwmUnique(String _category_, IOVOrderPentium _order_ ) throws Exception{
		super();
		_order_id    = _order_.getORDER_ID     ();   
		_category    = _category_                ;
		_user_id     = _order_.getUSER_ID      ();
		_create_date = _order_.getORDER_DATE   ();
		_region_id   = _order_.getREGION_ID    ();
	}
	
	/**
	 * @return _composite ��������
	 */
	public String getCOMPOSITE() {
		return _composite;
	}

	/**
	 * @param composite ��������
	 */
	public void setCOMPOSITE(String composite) {
		_composite = composite;
	}

	/**
	 * @return order һ������
	 */
	public IOVUpfwmOffer getPROVISION() {
		return _provision;
	}
	
	/**
	 * @param order һ������
	 */
	public void setPROVISION(IOVUpfwmOffer provision) {
		_provision = provision;
	}
	
	/**
	 * @return ��������
	 */
	public CarbonList<IOVUpfwmOffer> getSUBFLOW() {
		return _subflow;
	}
}
