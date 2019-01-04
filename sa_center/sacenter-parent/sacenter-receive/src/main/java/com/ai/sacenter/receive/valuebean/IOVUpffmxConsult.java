package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ�ֽⶨ��</p>
 * <p>Copyright: Copyright (c) 2018��4��11��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpffmxConsult implements java.io.Serializable{
	private static final long serialVersionUID = -8203698147008885879L;
	/*�û����*/
	private long    _user_id;
	/*ԤԼʱ��*/
	private java.sql.Timestamp _order_date;
	/*��ͨ����*/
	private IOVOrderRequest _platform = null;
	/*��ͨ����*/
	private IUpfgkmOfferHome _competence = null;
	public IOVUpffmxConsult(){
		super();
		_user_id    = 0;
		_order_date = new java.sql.Timestamp( System.currentTimeMillis() );
	}
	
	public IOVUpffmxConsult( IOVOrderRequest platform, IUpfgkmOfferHome competence ){
		super();
		_user_id    = platform.getUSER().getUSER_ID   ();
		_order_date = platform.getORDER_DATE          ();
		_platform   = platform                          ;
		_competence = competence                        ;
	}
	
	/**
	 * @return �û����
	 */
	public long getUSER_ID() {
		return _user_id;
	}
	
	/**
	 * @param user_id �û����
	 */
	public void setUSER_ID(long user_id) {
		_user_id = user_id;
	}
	
	/**
	 * @return ԤԼʱ��
	 */
	public java.sql.Timestamp getORDER_DATE() {
		return _order_date;
	}
	
	/**
	 * @param order_date ԤԼʱ��
	 */
	public void setORDER_DATE(java.sql.Timestamp order_date) {
		_order_date = order_date;
	}

	/**
	 * @return ��ͨ����
	 */
	public IOVOrderRequest getPLATFORM() {
		return _platform;
	}
	
	/**
	 * @param platform ��ͨ����
	 */
	public void setPLATFORM(IOVOrderRequest platform) {
		_user_id    = platform.getUSER().getUSER_ID();
		_order_date = platform.getORDER_DATE       ();
		_platform   = platform                       ;
	}
	
	/**
	 * @param platform ��ͨ����
	 * @param competence ��ͨ����
	 */
	public void setPLATFORM(IOVOrderRequest platform, IUpfgkmOfferHome competence) {
		_user_id    = platform.getUSER().getUSER_ID();
		_order_date = platform.getORDER_DATE       ();
		_platform   = platform                       ;
		_competence = competence                     ;
	}
	
	/**
	 * @return ��ͨ����
	 */
	public IUpfgkmOfferHome getCOMPETENCE() {
		return _competence;
	}

	/**
	 * @param _competence ��ͨ����
	 */
	public void setCOMPETENCE(IUpfgkmOfferHome competence) {
		_competence = competence;
	}
}
