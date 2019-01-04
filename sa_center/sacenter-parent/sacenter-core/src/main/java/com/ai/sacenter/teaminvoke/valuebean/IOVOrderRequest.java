package com.ai.sacenter.teaminvoke.valuebean;

import com.ai.sacenter.util.CarbonList;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务定单请求</p>
 * <p>Copyright: Copyright (c) 2015年9月24日</p>
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
	 * @param cATALOG_ID 产品规格
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
	 * @param cHANNEL_ID 渠道类型
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
	 * @return 受理时间
	 */
	public java.sql.Timestamp getDONE_DATE() {
		return DONE_DATE;
	}
	
	/**
	 * @param dONE_DATE 受理时间
	 */
	public void setDONE_DATE(java.sql.Timestamp dONE_DATE) {
		DONE_DATE = dONE_DATE;
	}
	
	/**
	 * @return 优先级
	 */
	public long getPRIORITY() {
		return PRIORITY;
	}
	
	/**
	 * @param pRIORITY 优先级
	 */
	public void setPRIORITY(long pRIORITY) {
		PRIORITY = pRIORITY;
	}
	
	/**
	 * @return 工单类型
	 */
	public String getCOMPOSITE() {
		return COMPOSITE;
	}
	
	/**
	 * @param cOMPOSITE 工单类型
	 */
	public void setCOMPOSITE(String cOMPOSITE) {
		COMPOSITE = cOMPOSITE;
	}
	
	/**
	 * @return 订单所在地市
	 */
	public String getORDER_REGION_ID() {
		return ORDER_REGION_ID;
	}
	
	/**
	 * @param oRDER_REGION_ID 订单所在地市
	 */
	public void setORDER_REGION_ID(String oRDER_REGION_ID) {
		ORDER_REGION_ID = oRDER_REGION_ID;
	}
	
	/**
	 * @return 预约时间
	 */
	public java.sql.Timestamp getORDER_DATE() {
		return ORDER_DATE;
	}
	
	/**
	 * @param oRDER_DATE 预约时间
	 */
	public void setORDER_DATE(java.sql.Timestamp oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}
	
	/**
	 * @return 组织编号
	 */
	public String getORG_ID() {
		return ORG_ID;
	}
	
	/**
	 * @param oRG_ID 组织编号
	 */
	public void setORG_ID(String oRG_ID) {
		ORG_ID = oRG_ID;
	}
	
	/**
	 * @return 操作员工号
	 */
	public String getSTAFF_ID() {
		return STAFF_ID;
	}
	
	/**
	 * @param sTAFF_ID 操作员工号
	 */
	public void setSTAFF_ID(String sTAFF_ID) {
		STAFF_ID = sTAFF_ID;
	}
	
	/**
	 * @return 用户或群组用户
	 */
	public IOVOrderUser getUSER() {
		return USER;
	}
	
	/**
	 * @param uSER 群组用户
	 */
	public void setUSER(IOVOrderUser uSER) {
		USER = uSER;
	}
	
	/**
	 * @return 群组成员
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
