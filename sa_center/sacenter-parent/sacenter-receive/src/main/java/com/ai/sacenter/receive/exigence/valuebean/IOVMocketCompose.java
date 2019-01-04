package com.ai.sacenter.receive.exigence.valuebean;

import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通定单分解项</p>
 * <p>Copyright: Copyright (c) 2017年5月8日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMocketCompose implements java.io.Serializable{
	private static final long serialVersionUID = -3854280694899420985L;
	private IUpfgkmOfferHome _busines;
	private IOVMsgFOrderBase _order   = null;
	private IOVMsgFExigence  _subflow = null;
	public IOVMocketCompose(){
		super();
	}
	
	public IOVMocketCompose(IUpfgkmOfferHome busines){
		super();
		_busines   = busines;
	}
	
	public IOVMocketCompose(IOVMsgFOrderBase order, IUpfgkmOfferHome busines){
		super();
		_order     = order    ;
		_busines   = busines  ;
	}
	
	/**
	 * @return 开通组件编码
	 */
	public IUpfgkmOfferHome getBUSINES() {
		return _busines;
	}

	/**
	 * @param busines 开通组件编码
	 */
	public void setBUSINES(IUpfgkmOfferHome busines) {
		_busines = busines;
	}

	/**
	 * @return 开通定单项[主]
	 */
	public IOVMsgFOrderBase getORDER() {
		if( _order == null && _subflow != null && _subflow.getORDER().getORDER().size() > 0 ){
			_order = (IOVMsgFOrderBase)_subflow.getORDER().getORDER().get( 0 );
		}
		return _order;
	}

	/**
	 * @param order 开通定单项[主]
	 */
	public void setORDER(IOVMsgFOrderBase order) {
		_order = order;
	}

	/**
	 * 设置开通定单附加
	 * @param order 开通定单项
	 * @param busines 开通组件编码
	 * @param fromUpffmx 
	 */
	/**
	 * 设置开通定单附加
	 * @param order 开通定单项
	 * @param busines 开通组件编码
	 * @throws Exception
	 */
	public void mergeAsConsult( IOVMsgFOrderBase order, IUpfgkmOfferHome busines) throws Exception{
		_subflow.getORDER().getORDER().add( order );
		if( order.isCOMPETENCE() /*开通主定单项*/){
			_order   = order;
			_busines = busines;
		}
		else if( _busines == null && busines != null ){
			_busines = busines;
		}
	}
	
	/**
	 * @return 开通定单项[子]
	 */
	public IOVMsgFExigence getSUBFLOW() {
		return _subflow;
	}

	/**
	 * @param _subflow 开通定单项[子]
	 */
	public void setSUBFLOW(IOVMsgFExigence subflow) {
		_subflow = subflow;
	}
	
}
