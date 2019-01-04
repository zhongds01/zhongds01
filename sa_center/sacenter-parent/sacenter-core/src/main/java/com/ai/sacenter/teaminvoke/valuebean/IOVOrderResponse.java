package com.ai.sacenter.teaminvoke.valuebean;

import com.ai.sacenter.valuebean.IOrderRsRspHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 开通定单反馈</p>
 * <p>Copyright: Copyright (c) 2015年9月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVOrderResponse implements java.io.Serializable{
	private static final long serialVersionUID = -125578844232778314L;
	private long   ROCKET_ID  ;
	private String CUST_ORDER ;
	private String CATALOG    ;
	private String BUSINESS   ;
	private String ORIGINATOR ;
	private String CHANNEL    ;
	private long   USER_ID    ;
	private String BILL_ID    ;
	private String REGION_ID  ;
	private String DONE_CODE  ;
	private java.sql.Timestamp DONE_DATE  ;
	private IOrderRsRspHome RESULT = new IOrderRsRspHome();
	public IOVOrderResponse() {
		super();
	}
	
	/**
	 * @return 定单编号
	 */
	public long getROCKET_ID() {
		return ROCKET_ID;
	}

	/**
	 * @param rOCKET_ID 定单编号
	 */
	public void setROCKET_ID(long rOCKET_ID) {
		ROCKET_ID = rOCKET_ID;
	}
	
	/**
	 * @return 客户定单号
	 */
	public String getCUST_ORDER() {
		return CUST_ORDER;
	}
	
	/**
	 * @param cUST_ORDER 客户定单号
	 */
	public void setCUST_ORDER(String cUST_ORDER) {
		CUST_ORDER = cUST_ORDER;
	}
	
	/**
	 * @return 产品规格
	 */
	public String getCATALOG() {
		return CATALOG;
	}
	
	/**
	 * @param cATALOG 产品规格
	 */
	public void setCATALOG(String cATALOG) {
		CATALOG = cATALOG;
	}
	
	/**
	 * @return 产品操作
	 */
	public String getBUSINESS() {
		return BUSINESS;
	}
	
	/**
	 * @param bUSINESS 产品操作
	 */
	public void setBUSINESS(String bUSINESS) {
		BUSINESS = bUSINESS;
	}
	
	/**
	 * @return 发起方编码
	 */
	public String getORIGINATOR() {
		return ORIGINATOR;
	}
	
	/**
	 * @param oRIGINATOR 发起方编码
	 */
	public void setORIGINATOR(String oRIGINATOR) {
		ORIGINATOR = oRIGINATOR;
	}
	
	/**
	 * @return 渠道类型
	 */
	public String getCHANNEL() {
		return CHANNEL;
	}
	
	/**
	 * @param cHANNEL 渠道类型
	 */
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}
	
	/**
	 * @return 用户编号
	 */
	public long getUSER_ID() {
		return USER_ID;
	}
	
	/**
	 * @param uSER_ID 用户编号
	 */
	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	/**
	 * @return 用户号码
	 */
	public String getBILL_ID() {
		return BILL_ID;
	}

	/**
	 * @param bILL_ID 用户号码
	 */
	public void setBILL_ID(String bILL_ID) {
		BILL_ID = bILL_ID;
	}

	/**
	 * @return 地市编码
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}
	
	/**
	 * @param rEGION_ID 地市编码
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	
	/**
	 * @return 操作流水
	 */
	public String getDONE_CODE() {
		return DONE_CODE;
	}
	
	/**
	 * @param dONE_CODE 操作流水
	 */
	public void setDONE_CODE(String dONE_CODE) {
		DONE_CODE = dONE_CODE;
	}
	
	/**
	 * @return 操作时间
	 */
	public java.sql.Timestamp getDONE_DATE() {
		return DONE_DATE;
	}
	
	/**
	 * @param dONE_DATE 操作时间
	 */
	public void setDONE_DATE(java.sql.Timestamp dONE_DATE) {
		DONE_DATE = dONE_DATE;
	}
	
	/**
	 * @return 反馈结果
	 */
	public IOrderRsRspHome getRESULT() {
		return RESULT;
	}

}
