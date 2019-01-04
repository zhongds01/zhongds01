package com.ai.sacenter.teaminvoke.valuebean;

import com.ai.sacenter.valuebean.IOrderRsRspHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��ͨ��������</p>
 * <p>Copyright: Copyright (c) 2015��9��24��</p>
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
	 * @return �������
	 */
	public long getROCKET_ID() {
		return ROCKET_ID;
	}

	/**
	 * @param rOCKET_ID �������
	 */
	public void setROCKET_ID(long rOCKET_ID) {
		ROCKET_ID = rOCKET_ID;
	}
	
	/**
	 * @return �ͻ�������
	 */
	public String getCUST_ORDER() {
		return CUST_ORDER;
	}
	
	/**
	 * @param cUST_ORDER �ͻ�������
	 */
	public void setCUST_ORDER(String cUST_ORDER) {
		CUST_ORDER = cUST_ORDER;
	}
	
	/**
	 * @return ��Ʒ���
	 */
	public String getCATALOG() {
		return CATALOG;
	}
	
	/**
	 * @param cATALOG ��Ʒ���
	 */
	public void setCATALOG(String cATALOG) {
		CATALOG = cATALOG;
	}
	
	/**
	 * @return ��Ʒ����
	 */
	public String getBUSINESS() {
		return BUSINESS;
	}
	
	/**
	 * @param bUSINESS ��Ʒ����
	 */
	public void setBUSINESS(String bUSINESS) {
		BUSINESS = bUSINESS;
	}
	
	/**
	 * @return ���𷽱���
	 */
	public String getORIGINATOR() {
		return ORIGINATOR;
	}
	
	/**
	 * @param oRIGINATOR ���𷽱���
	 */
	public void setORIGINATOR(String oRIGINATOR) {
		ORIGINATOR = oRIGINATOR;
	}
	
	/**
	 * @return ��������
	 */
	public String getCHANNEL() {
		return CHANNEL;
	}
	
	/**
	 * @param cHANNEL ��������
	 */
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}
	
	/**
	 * @return �û����
	 */
	public long getUSER_ID() {
		return USER_ID;
	}
	
	/**
	 * @param uSER_ID �û����
	 */
	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	/**
	 * @return �û�����
	 */
	public String getBILL_ID() {
		return BILL_ID;
	}

	/**
	 * @param bILL_ID �û�����
	 */
	public void setBILL_ID(String bILL_ID) {
		BILL_ID = bILL_ID;
	}

	/**
	 * @return ���б���
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}
	
	/**
	 * @param rEGION_ID ���б���
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	
	/**
	 * @return ������ˮ
	 */
	public String getDONE_CODE() {
		return DONE_CODE;
	}
	
	/**
	 * @param dONE_CODE ������ˮ
	 */
	public void setDONE_CODE(String dONE_CODE) {
		DONE_CODE = dONE_CODE;
	}
	
	/**
	 * @return ����ʱ��
	 */
	public java.sql.Timestamp getDONE_DATE() {
		return DONE_DATE;
	}
	
	/**
	 * @param dONE_DATE ����ʱ��
	 */
	public void setDONE_DATE(java.sql.Timestamp dONE_DATE) {
		DONE_DATE = dONE_DATE;
	}
	
	/**
	 * @return �������
	 */
	public IOrderRsRspHome getRESULT() {
		return RESULT;
	}

}
