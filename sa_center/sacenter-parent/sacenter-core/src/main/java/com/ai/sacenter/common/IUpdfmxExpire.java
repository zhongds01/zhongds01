package com.ai.sacenter.common;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: 到期用户</p>
 * <p>Copyright: Copyright (c) 2018年6月25日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class IUpdfmxExpire extends IUpdfmxEntry implements java.lang.Comparable<Object>,java.io.Serializable {
	private static final long serialVersionUID = -2284859828480351872L;
	private long   ROCKET_ID              ;
	private String CUST_ORDER             ;
	private String DONE_CODE              ;
	private String CATALOG                ;
	private String BUSINESS               ;
	private String ORIGINATOR             ;
	private long   USER_ID                ;
	private java.sql.Timestamp CREATE_DATE;
	private String REGION_ID              ;
	private String ORDER_REGION_ID        ;
	private String USER_REGION_ID         ;
	private String ORG_ID                 ;
	private String STAFF_ID               ;
	public IUpdfmxExpire() {
		super();
	}

	public IUpdfmxExpire( IUpdfmxExpire _expire_) {
		super( _expire_ );
		ROCKET_ID       = _expire_.ROCKET_ID      ;
		CUST_ORDER      = _expire_.CUST_ORDER     ;
		DONE_CODE       = _expire_.DONE_CODE      ;
		CATALOG         = _expire_.CATALOG        ;
		BUSINESS        = _expire_.BUSINESS       ;
		ORIGINATOR      = _expire_.ORIGINATOR     ;
		USER_ID         = _expire_.USER_ID        ;
		CREATE_DATE     = _expire_.CREATE_DATE    ;
		REGION_ID       = _expire_.REGION_ID      ;
		ORDER_REGION_ID = _expire_.ORDER_REGION_ID;
		USER_REGION_ID  = _expire_.USER_REGION_ID ;
		ORG_ID          = _expire_.ORG_ID         ;
		STAFF_ID        = _expire_.STAFF_ID       ;
	}

	/**
	 * @return the rOCKET_ID
	 */
	public long getROCKET_ID() {
		return ROCKET_ID;
	}

	/**
	 * @param rOCKET_ID the rOCKET_ID to set
	 */
	public void setROCKET_ID(long rOCKET_ID) {
		ROCKET_ID = rOCKET_ID;
	}

	/**
	 * @return the cUST_ORDER
	 */
	public String getCUST_ORDER() {
		return CUST_ORDER;
	}

	/**
	 * @param cUST_ORDER the cUST_ORDER to set
	 */
	public void setCUST_ORDER(String cUST_ORDER) {
		CUST_ORDER = cUST_ORDER;
	}

	/**
	 * @return the dONE_CODE
	 */
	public String getDONE_CODE() {
		return DONE_CODE;
	}

	/**
	 * @param dONE_CODE the dONE_CODE to set
	 */
	public void setDONE_CODE(String dONE_CODE) {
		DONE_CODE = dONE_CODE;
	}

	/**
	 * @return the cATALOG
	 */
	public String getCATALOG() {
		return CATALOG;
	}

	/**
	 * @param cATALOG the cATALOG to set
	 */
	public void setCATALOG(String cATALOG) {
		CATALOG = cATALOG;
	}
	
	/**
	 * @return the bUSINESS
	 */
	public String getBUSINESS() {
		return BUSINESS;
	}

	/**
	 * @param bUSINESS the bUSINESS to set
	 */
	public void setBUSINESS(String bUSINESS) {
		BUSINESS = bUSINESS;
	}

	/**
	 * @return the oRIGINATOR
	 */
	public String getORIGINATOR() {
		return ORIGINATOR;
	}

	/**
	 * @param oRIGINATOR the oRIGINATOR to set
	 */
	public void setORIGINATOR(String oRIGINATOR) {
		ORIGINATOR = oRIGINATOR;
	}

	/**
	 * @return the uSER_ID
	 */
	public long getUSER_ID() {
		return USER_ID;
	}

	/**
	 * @param uSER_ID the uSER_ID to set
	 */
	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}

	/**
	 * @return the cREATE_DATE
	 */
	public java.sql.Timestamp getCREATE_DATE() {
		return CREATE_DATE;
	}

	/**
	 * @param cREATE_DATE the cREATE_DATE to set
	 */
	public void setCREATE_DATE(java.sql.Timestamp cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}

	/**
	 * @return the rEGION_ID
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}

	/**
	 * @param rEGION_ID the rEGION_ID to set
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}

	/**
	 * @return the oRDER_REGION_ID
	 */
	public String getORDER_REGION_ID() {
		return ORDER_REGION_ID;
	}

	/**
	 * @param oRDER_REGION_ID the oRDER_REGION_ID to set
	 */
	public void setORDER_REGION_ID(String oRDER_REGION_ID) {
		ORDER_REGION_ID = oRDER_REGION_ID;
	}

	/**
	 * @return the uSER_REGION_ID
	 */
	public String getUSER_REGION_ID() {
		return USER_REGION_ID;
	}

	/**
	 * @param uSER_REGION_ID the uSER_REGION_ID to set
	 */
	public void setUSER_REGION_ID(String uSER_REGION_ID) {
		USER_REGION_ID = uSER_REGION_ID;
	}
	
	/**
	 * @return the oRG_ID
	 */
	public String getORG_ID() {
		return ORG_ID;
	}

	/**
	 * @param oRG_ID the oRG_ID to set
	 */
	public void setORG_ID(String oRG_ID) {
		ORG_ID = oRG_ID;
	}

	/**
	 * @return the sTAFF_ID
	 */
	public String getSTAFF_ID() {
		return STAFF_ID;
	}

	/**
	 * @param sTAFF_ID the sTAFF_ID to set
	 */
	public void setSTAFF_ID(String sTAFF_ID) {
		STAFF_ID = sTAFF_ID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		doCompare = objective != null && objective instanceof IUpdfmxExpire?0:1;
		if( doCompare == 0 ){
			IUpdfmxExpire _expire_ = (IUpdfmxExpire)objective;
			doCompare = USER_ID - _expire_.USER_ID;
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		boolean _doEquals = false;
		if( objective != null && objective instanceof IUpdfmxExpire ){
			IUpdfmxExpire _expire_ = (IUpdfmxExpire)objective;
			_doEquals = USER_ID > 0 && _expire_.USER_ID > 0 && USER_ID == _expire_.USER_ID;
		}
		return _doEquals;
	}

}
