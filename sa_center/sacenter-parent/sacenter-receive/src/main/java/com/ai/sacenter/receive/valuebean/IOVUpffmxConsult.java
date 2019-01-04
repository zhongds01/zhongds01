package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通分解定单</p>
 * <p>Copyright: Copyright (c) 2018年4月11日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpffmxConsult implements java.io.Serializable{
	private static final long serialVersionUID = -8203698147008885879L;
	/*用户编号*/
	private long    _user_id;
	/*预约时间*/
	private java.sql.Timestamp _order_date;
	/*开通工单*/
	private IOVOrderRequest _platform = null;
	/*开通能力*/
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
	 * @return 用户编号
	 */
	public long getUSER_ID() {
		return _user_id;
	}
	
	/**
	 * @param user_id 用户编号
	 */
	public void setUSER_ID(long user_id) {
		_user_id = user_id;
	}
	
	/**
	 * @return 预约时间
	 */
	public java.sql.Timestamp getORDER_DATE() {
		return _order_date;
	}
	
	/**
	 * @param order_date 预约时间
	 */
	public void setORDER_DATE(java.sql.Timestamp order_date) {
		_order_date = order_date;
	}

	/**
	 * @return 开通工单
	 */
	public IOVOrderRequest getPLATFORM() {
		return _platform;
	}
	
	/**
	 * @param platform 开通工单
	 */
	public void setPLATFORM(IOVOrderRequest platform) {
		_user_id    = platform.getUSER().getUSER_ID();
		_order_date = platform.getORDER_DATE       ();
		_platform   = platform                       ;
	}
	
	/**
	 * @param platform 开通工单
	 * @param competence 开通能力
	 */
	public void setPLATFORM(IOVOrderRequest platform, IUpfgkmOfferHome competence) {
		_user_id    = platform.getUSER().getUSER_ID();
		_order_date = platform.getORDER_DATE       ();
		_platform   = platform                       ;
		_competence = competence                     ;
	}
	
	/**
	 * @return 开通能力
	 */
	public IUpfgkmOfferHome getCOMPETENCE() {
		return _competence;
	}

	/**
	 * @param _competence 开通能力
	 */
	public void setCOMPETENCE(IUpfgkmOfferHome competence) {
		_competence = competence;
	}
}
