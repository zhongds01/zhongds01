package com.ai.sacenter.receive.exigence.valuebean;

import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ�����ֽ���</p>
 * <p>Copyright: Copyright (c) 2017��5��8��</p>
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
	 * @return ��ͨ�������
	 */
	public IUpfgkmOfferHome getBUSINES() {
		return _busines;
	}

	/**
	 * @param busines ��ͨ�������
	 */
	public void setBUSINES(IUpfgkmOfferHome busines) {
		_busines = busines;
	}

	/**
	 * @return ��ͨ������[��]
	 */
	public IOVMsgFOrderBase getORDER() {
		if( _order == null && _subflow != null && _subflow.getORDER().getORDER().size() > 0 ){
			_order = (IOVMsgFOrderBase)_subflow.getORDER().getORDER().get( 0 );
		}
		return _order;
	}

	/**
	 * @param order ��ͨ������[��]
	 */
	public void setORDER(IOVMsgFOrderBase order) {
		_order = order;
	}

	/**
	 * ���ÿ�ͨ��������
	 * @param order ��ͨ������
	 * @param busines ��ͨ�������
	 * @param fromUpffmx 
	 */
	/**
	 * ���ÿ�ͨ��������
	 * @param order ��ͨ������
	 * @param busines ��ͨ�������
	 * @throws Exception
	 */
	public void mergeAsConsult( IOVMsgFOrderBase order, IUpfgkmOfferHome busines) throws Exception{
		_subflow.getORDER().getORDER().add( order );
		if( order.isCOMPETENCE() /*��ͨ��������*/){
			_order   = order;
			_busines = busines;
		}
		else if( _busines == null && busines != null ){
			_busines = busines;
		}
	}
	
	/**
	 * @return ��ͨ������[��]
	 */
	public IOVMsgFExigence getSUBFLOW() {
		return _subflow;
	}

	/**
	 * @param _subflow ��ͨ������[��]
	 */
	public void setSUBFLOW(IOVMsgFExigence subflow) {
		_subflow = subflow;
	}
	
}
