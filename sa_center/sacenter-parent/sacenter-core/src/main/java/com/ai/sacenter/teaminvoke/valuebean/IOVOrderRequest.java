package com.ai.sacenter.teaminvoke.valuebean;

import com.ai.sacenter.util.CarbonList;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ���񶨵�����</p>
 * <p>Copyright: Copyright (c) 2015��9��24��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVOrderRequest implements java.io.Serializable{
	private static final long serialVersionUID = 4269792250651562610L;
	private long   ROCKET_ID      ;
	private String CUST_ORDER     ;
	private String CATALOG        ;
	private String BUSINESS       ;
	private String ORIGINATOR     ;
	private String CHANNEL        ;
	private long   USER_ID        ;
	private String BILL_ID        ;
	private String REGION_ID      ;
	private long   PRIORITY       ;
	private String COMPOSITE      ;
	private String DONE_CODE      ;
	private String ORG_ID         ;
	private String STAFF_ID       ;
	private String ORDER_REGION_ID;
	private java.sql.Timestamp ORDER_DATE ;
	private java.sql.Timestamp DONE_DATE  ;
	private IOVOrderUser USER  = null;
	private CarbonList<IOVOrderUser> ORDER = new CarbonList<IOVOrderUser>();
	public IOVOrderRequest() {
		super();
	}
	
	public IOVOrderRequest( IOVOrderRequest request ) {
		super();
		ROCKET_ID       = request.ROCKET_ID      ;
		CUST_ORDER      = request.CUST_ORDER     ;
		CATALOG         = request.CATALOG        ;
		BUSINESS        = request.BUSINESS       ;
		ORIGINATOR      = request.ORIGINATOR     ;
		CHANNEL         = request.CHANNEL        ;
		USER_ID         = request.USER_ID        ;
		BILL_ID         = request.BILL_ID        ;
		REGION_ID       = request.REGION_ID      ;
		PRIORITY        = request.PRIORITY       ;
		COMPOSITE       = request.COMPOSITE      ;
		DONE_CODE       = request.DONE_CODE      ;
		ORG_ID          = request.ORG_ID         ;
		STAFF_ID        = request.STAFF_ID       ;
		ORDER_REGION_ID = request.ORDER_REGION_ID;
		ORDER_DATE      = request.ORDER_DATE     ;
		DONE_DATE       = request.DONE_DATE      ;
		if( request.USER != null ){ USER = new IOVOrderUser( request.USER ); }
		for( java.util.Iterator<IOVOrderUser> itera = request.ORDER.iterator(); itera.hasNext(); ){
			IOVOrderUser orderuser = (IOVOrderUser)itera.next();
			ORDER.add( new IOVOrderUser( orderuser ) ) ;
		}
	}
	
	public IOVOrderRequest( IOVOrderRequest request, IOVOrderUser user ){
		super();
		ROCKET_ID       = request.ROCKET_ID       ;
		CUST_ORDER      = request.CUST_ORDER      ;
		CATALOG         = request.CATALOG         ;
		BUSINESS        = request.BUSINESS        ;
		ORIGINATOR      = request.ORIGINATOR      ;
		CHANNEL         = request.CHANNEL         ;
		USER_ID         = request.USER_ID         ;
		BILL_ID         = request.BILL_ID         ;
		REGION_ID       = request.REGION_ID       ;
		PRIORITY        = request.PRIORITY        ;
		COMPOSITE       = request.COMPOSITE       ;
		DONE_CODE       = request.DONE_CODE       ;
		ORG_ID          = request.ORG_ID          ;
		STAFF_ID        = request.STAFF_ID        ;
		ORDER_REGION_ID = request.ORDER_REGION_ID ;
		ORDER_DATE      = request.ORDER_DATE      ;
		DONE_DATE       = request.DONE_DATE       ;
		USER            = new IOVOrderUser( user );
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
	 * @param cATALOG_ID ��Ʒ���
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
	 * @param cHANNEL_ID ��������
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
	 * @return ���ȼ�
	 */
	public long getPRIORITY() {
		return PRIORITY;
	}
	
	/**
	 * @param pRIORITY ���ȼ�
	 */
	public void setPRIORITY(long pRIORITY) {
		PRIORITY = pRIORITY;
	}
	
	/**
	 * @return ��������
	 */
	public String getCOMPOSITE() {
		return COMPOSITE;
	}
	
	/**
	 * @param cOMPOSITE ��������
	 */
	public void setCOMPOSITE(String cOMPOSITE) {
		COMPOSITE = cOMPOSITE;
	}
	
	/**
	 * @return �������ڵ���
	 */
	public String getORDER_REGION_ID() {
		return ORDER_REGION_ID;
	}
	
	/**
	 * @param oRDER_REGION_ID �������ڵ���
	 */
	public void setORDER_REGION_ID(String oRDER_REGION_ID) {
		ORDER_REGION_ID = oRDER_REGION_ID;
	}
	
	/**
	 * @return ԤԼʱ��
	 */
	public java.sql.Timestamp getORDER_DATE() {
		return ORDER_DATE;
	}
	
	/**
	 * @param oRDER_DATE ԤԼʱ��
	 */
	public void setORDER_DATE(java.sql.Timestamp oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}
	
	/**
	 * @return ��֯���
	 */
	public String getORG_ID() {
		return ORG_ID;
	}
	
	/**
	 * @param oRG_ID ��֯���
	 */
	public void setORG_ID(String oRG_ID) {
		ORG_ID = oRG_ID;
	}
	
	/**
	 * @return ����Ա����
	 */
	public String getSTAFF_ID() {
		return STAFF_ID;
	}
	
	/**
	 * @param sTAFF_ID ����Ա����
	 */
	public void setSTAFF_ID(String sTAFF_ID) {
		STAFF_ID = sTAFF_ID;
	}
	
	/**
	 * @return �û���Ⱥ���û�
	 */
	public IOVOrderUser getUSER() {
		return USER;
	}
	
	/**
	 * @param uSER Ⱥ���û�
	 */
	public void setUSER(IOVOrderUser uSER) {
		USER = uSER;
	}
	
	/**
	 * @return Ⱥ���Ա
	 */
	public CarbonList<IOVOrderUser> getORDER() {
		return ORDER;
	}
	
	/**
	 * 
	 * @param aUSER_ID
	 * @return
	 */
	public IOVOrderUser getUSER( long aUSER_ID ){
		IOVOrderUser fromUSER = null;
		try
		{
			if( USER != null && USER.getUSER_ID() == aUSER_ID ){
				fromUSER = USER;
			}
			else if( ORDER != null && ORDER.size() > 0 ){
				for( java.util.Iterator<IOVOrderUser> itera = ORDER.iterator(); itera.hasNext(); ){
					IOVOrderUser aUSER = (IOVOrderUser)itera.next();
					if( aUSER.getUSER_ID() == aUSER_ID ){
						fromUSER = aUSER;
						break;
					}
				}
			}
		}
		finally{
			
		}
		return fromUSER;
	}
}
