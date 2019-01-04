package com.ai.sacenter.receive.custom.valuebean;

import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.util.ClassUtils;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: 用户策划关系</p>
 * <p>Copyright: Copyright (c) 2017年3月8日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUserOrderOffer extends IUpdfmxEntry implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = 2291874944468160702L;
	private long   INS_OFFER_ID   ;
	private long   USER_ID        ;
	private long   OFFER_ID       ;
	private long   ROLE_ID        ;
	private int    MAIN_OFFER     ;
	private int    GROUP_USER     ;
	private int    STATUS         ;
	private String COUNTY_CODE    ;
	private String REGION_ID      ;
	private String USER_REGION_ID ;
	private String GROUP_REGION_ID;
	private java.sql.Timestamp   EFFECTIVE   ;
	private java.sql.Timestamp   EXPIRE      ;
	public IOVUserOrderOffer(){
		super();
	}
	
	public IOVUserOrderOffer( IOVUserOrderOffer useroffer ){
		super( useroffer );
		INS_OFFER_ID    = useroffer.INS_OFFER_ID   ;
		USER_ID         = useroffer.USER_ID        ;
		OFFER_ID        = useroffer.OFFER_ID       ;
		ROLE_ID         = useroffer.ROLE_ID        ;
		MAIN_OFFER      = useroffer.MAIN_OFFER     ;
		GROUP_USER      = useroffer.GROUP_USER     ;
		STATUS          = useroffer.STATUS         ;
		COUNTY_CODE     = useroffer.COUNTY_CODE    ;
		REGION_ID       = useroffer.REGION_ID      ;
		USER_REGION_ID  = useroffer.USER_REGION_ID ;
		GROUP_REGION_ID = useroffer.GROUP_REGION_ID;
		EFFECTIVE       = useroffer.EFFECTIVE      ;
		EXPIRE          = useroffer.EXPIRE         ;
	}
	
	/**
	 * @return the iNS_OFFER_ID
	 */
	public long getINS_OFFER_ID() {
		return INS_OFFER_ID;
	}
	
	/**
	 * @param iNS_OFFER_ID the iNS_OFFER_ID to set
	 */
	public void setINS_OFFER_ID(long iNS_OFFER_ID) {
		INS_OFFER_ID = iNS_OFFER_ID;
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
	 * @return the oFFER_ID
	 */
	public long getOFFER_ID() {
		return OFFER_ID;
	}
	
	/**
	 * @param oFFER_ID the oFFER_ID to set
	 */
	public void setOFFER_ID(long oFFER_ID) {
		OFFER_ID = oFFER_ID;
	}
	
	/**
	 * @return the rOLE_ID
	 */
	public long getROLE_ID() {
		return ROLE_ID;
	}
	
	/**
	 * @param rOLE_ID the rOLE_ID to set
	 */
	public void setROLE_ID(long rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}
	
	/**
	 * @return the mAIN_OFFER
	 */
	public int getMAIN_OFFER() {
		return MAIN_OFFER;
	}

	/**
	 * @param mAIN_OFFER the mAIN_OFFER to set
	 */
	public void setMAIN_OFFER(int mAIN_OFFER) {
		MAIN_OFFER = mAIN_OFFER;
	}

	/**
	 * @return the gROUP_USER
	 */
	public int getGROUP_USER() {
		return GROUP_USER;
	}

	/**
	 * @param gROUP_USER the gROUP_USER to set
	 */
	public void setGROUP_USER(int gROUP_USER) {
		GROUP_USER = gROUP_USER;
	}

	/**
	 * @return the sTATUS
	 */
	public int getSTATUS() {
		return STATUS;
	}
	
	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
	/**
	 * @return the cOUNTY_CODE
	 */
	public String getCOUNTY_CODE() {
		return COUNTY_CODE;
	}
	
	/**
	 * @param cOUNTY_CODE the cOUNTY_CODE to set
	 */
	public void setCOUNTY_CODE(String cOUNTY_CODE) {
		COUNTY_CODE = cOUNTY_CODE;
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
	 * @return the gROUP_REGION_ID
	 */
	public String getGROUP_REGION_ID() {
		return GROUP_REGION_ID;
	}
	
	/**
	 * @param gROUP_REGION_ID the gROUP_REGION_ID to set
	 */
	public void setGROUP_REGION_ID(String gROUP_REGION_ID) {
		GROUP_REGION_ID = gROUP_REGION_ID;
	}
	
	/**
	 * @return the eFFECTIVE
	 */
	public java.sql.Timestamp getEFFECTIVE() {
		return EFFECTIVE;
	}
	
	/**
	 * @param eFFECTIVE the eFFECTIVE to set
	 */
	public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
		EFFECTIVE = eFFECTIVE;
	}
	
	/**
	 * @return the eXPIRE
	 */
	public java.sql.Timestamp getEXPIRE() {
		return EXPIRE;
	}
	
	/**
	 * @param eXPIRE the eXPIRE to set
	 */
	public void setEXPIRE(java.sql.Timestamp eXPIRE) {
		EXPIRE = eXPIRE;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective == null ){
			return false;
		}
		else if( objective instanceof IOVUserOrderOffer == false ){
			return false;
		}
		else{
			IOVUserOrderOffer offer = (IOVUserOrderOffer)objective;
			String _left = ClassUtils.getINDEX( new String[]{ String.valueOf( INS_OFFER_ID ), "_$_", String.valueOf( USER_ID ) } );
			String _right = ClassUtils.getINDEX( new String[]{ String.valueOf( offer.INS_OFFER_ID ), "_$_", String.valueOf( offer.USER_ID ) } );
			return _left.equals( _right );
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try
		{
			doCompare = objective != null && objective instanceof IOVUserOrderOffer?0:1;
			if( doCompare == 0 ){
				IOVUserOrderOffer offer = (IOVUserOrderOffer)objective;
				String _left = ClassUtils.getINDEX( new String[]{ String.valueOf( INS_OFFER_ID ), "_$_", String.valueOf( USER_ID ) } );
				String _right = ClassUtils.getINDEX( new String[]{ String.valueOf( offer.INS_OFFER_ID ), "_$_", String.valueOf( offer.USER_ID ) } );
				doCompare = _left.compareTo( _right );
			}
		}
		finally{
			
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
}
