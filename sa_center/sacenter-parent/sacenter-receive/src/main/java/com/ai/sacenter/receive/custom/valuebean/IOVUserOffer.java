package com.ai.sacenter.receive.custom.valuebean;

import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 用户策划</p>
 * <p>Copyright: Copyright (c) 2016年3月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUserOffer extends IUpdfmxEntry implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = -103000434758249073L;
	private long   INS_OFFER_ID;
	private long   USER_ID     ;
	private long   OFFER_ID    ;
	private String OFFER_TYPE  ;
	private String BRAND_ID    ;
	private long   STATUS      ;
	private String COUNTY_CODE ;
	private String REGION_ID   ;
	private int    SALE_TYPE   ;
	private java.sql.Timestamp   EFFECTIVE   ;
	private java.sql.Timestamp   EXPIRE      ;
	public IOVUserOffer() {
		super();
	}
	
	public IOVUserOffer( IOVUserOffer useroffer ) {
		super( useroffer );
		INS_OFFER_ID = useroffer.INS_OFFER_ID;
		USER_ID      = useroffer.USER_ID     ;
		OFFER_ID     = useroffer.OFFER_ID    ;
		OFFER_TYPE   = useroffer.OFFER_TYPE  ;
		BRAND_ID     = useroffer.BRAND_ID    ;
		STATUS       = useroffer.STATUS      ;
		COUNTY_CODE  = useroffer.COUNTY_CODE ;
		REGION_ID    = useroffer.REGION_ID   ;
		SALE_TYPE    = useroffer.SALE_TYPE   ;
		EFFECTIVE    = useroffer.EFFECTIVE   ;
		EXPIRE       = useroffer.EXPIRE      ;
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
	 * @return the oFFER_TYPE
	 */
	public String getOFFER_TYPE() {
		return OFFER_TYPE;
	}


	/**
	 * @param oFFER_TYPE the oFFER_TYPE to set
	 */
	public void setOFFER_TYPE(String oFFER_TYPE) {
		OFFER_TYPE = oFFER_TYPE;
	}


	/**
	 * @return the bRAND_ID
	 */
	public String getBRAND_ID() {
		return BRAND_ID;
	}


	/**
	 * @param bRAND_ID the bRAND_ID to set
	 */
	public void setBRAND_ID(String bRAND_ID) {
		BRAND_ID = bRAND_ID;
	}


	/**
	 * @return the sTATUS
	 */
	public long getSTATUS() {
		return STATUS;
	}


	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(long sTATUS) {
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
	 * @return the sALE_TYPE
	 */
	public int getSALE_TYPE() {
		return SALE_TYPE;
	}


	/**
	 * @param sALE_TYPE the sALE_TYPE to set
	 */
	public void setSALE_TYPE(int sALE_TYPE) {
		SALE_TYPE = sALE_TYPE;
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

	/**
	 * 是否基本套餐
	 * @return
	 */
	public boolean isOfferPlan(){
		return StringUtils.startWith( OFFER_TYPE, "OFFER_PLAN" );
	}
	
	/**
	 * 是否有效类型有效
	 * @param fromVALID 有效类型
	 * @param fromCREATE 当前时间
	 * @return
	 */
	public boolean isVALID( int fromVALID, java.sql.Timestamp fromCREATE ){
		boolean fromVALIDY = false;
		try
		{
			if( fromVALID == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NOW ){
				fromVALIDY = isVALIDNOW( fromCREATE );
			}
			else if( fromVALID == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NEXT ){
				fromVALIDY = isVALIDNEXT( fromCREATE );
			}
			else if( fromVALID == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ){
				fromVALIDY = isVALIDALL( fromCREATE );
			}
			else if( fromVALID == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_EXPIRED ){
				fromVALIDY = isVALIDEXPIRED( fromCREATE );
			}
		}
		finally{
			
		}
		return fromVALIDY;
	}
	
	/**
	 * 是否本周期有效
	 * @param fromCREATE
	 * @return
	 */
	public boolean isVALIDNOW( java.sql.Timestamp fromCREATE ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.middle( EFFECTIVE, fromCREATE, EXPIRE );
	}
	
	/**
	 * 是否下周期有效
	 * @param fromCREATE
	 * @return
	 */
	public boolean isVALIDNEXT( java.sql.Timestamp fromCREATE ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EFFECTIVE, fromCREATE );
	}
	
	/**
	 * 是否下周期有效
	 * @param fromCREATE
	 * @return
	 */
	public boolean isVALIDALL( java.sql.Timestamp fromCREATE ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, fromCREATE );
	}
	
	/**
	 * 是否下周期有效
	 * @param fromCREATE
	 * @return
	 */
	public boolean isVALIDEXPIRED( java.sql.Timestamp fromCREATE ){
		return TimeUtils.greaterEqual( fromCREATE, EXPIRE );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective == null ){
			return false;
		}
		else if( objective instanceof IOVUserOffer == false ){
			return false;
		}
		else{
			IOVUserOffer offer = (IOVUserOffer)objective;
			return INS_OFFER_ID == offer.INS_OFFER_ID;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try
		{
			doCompare = objective != null && objective instanceof IOVUser?0:1;
			if( doCompare == 0 ){
				IOVUserOffer offer = (IOVUserOffer)objective;
				doCompare = INS_OFFER_ID - offer.INS_OFFER_ID;
			}
		}
		finally{
			
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
}
