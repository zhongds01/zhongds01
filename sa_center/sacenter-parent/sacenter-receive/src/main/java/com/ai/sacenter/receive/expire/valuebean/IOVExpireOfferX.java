package com.ai.sacenter.receive.expire.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 下周期订购属性</p>
 * <p>Copyright: Copyright (c) 2016年3月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVExpireOfferX implements java.io.Serializable{
	private static final long serialVersionUID = -647543052626380486L;
	private long   INS_ATTR_ID   ;
	private String ATTR_ID       ;
	private String ATTR_VALUE    ;
	private String PRE_ATTR_VALUE;
	private String STATUS        ;
	private String EFFECTIVE;
	private String EXPIRE   ;
	public IOVExpireOfferX() {
		super();
	}
	
	public IOVExpireOfferX( IOVExpireOfferX expireofferx ) {
		super();
		INS_ATTR_ID    = expireofferx.getINS_ATTR_ID   ();
		ATTR_ID        = expireofferx.getATTR_ID       ();
		ATTR_VALUE     = expireofferx.getATTR_VALUE    ();
		PRE_ATTR_VALUE = expireofferx.getPRE_ATTR_VALUE();
		STATUS         = expireofferx.getSTATUS        ();
		EFFECTIVE      = expireofferx.getEFFECTIVE     ();
		EXPIRE         = expireofferx.getEXPIRE        ();
	}
	
	/**
	 * @return the iNS_ATTR_ID
	 */
	public long getINS_ATTR_ID() {
		return INS_ATTR_ID;
	}
	
	/**
	 * @param iNS_ATTR_ID the iNS_ATTR_ID to set
	 */
	public void setINS_ATTR_ID(long iNS_ATTR_ID) {
		INS_ATTR_ID = iNS_ATTR_ID;
	}
	
	/**
	 * @return the aTTR_ID
	 */
	public String getATTR_ID() {
		return ATTR_ID;
	}
	
	/**
	 * @param aTTR_ID the aTTR_ID to set
	 */
	public void setATTR_ID(String aTTR_ID) {
		ATTR_ID = aTTR_ID;
	}
	
	/**
	 * @return the aTTR_VALUE
	 */
	public String getATTR_VALUE() {
		return ATTR_VALUE;
	}
	
	/**
	 * @param aTTR_VALUE the aTTR_VALUE to set
	 */
	public void setATTR_VALUE(String aTTR_VALUE) {
		ATTR_VALUE = aTTR_VALUE;
	}
	
	/**
	 * @return the pRE_ATTR_VALUE
	 */
	public String getPRE_ATTR_VALUE() {
		return PRE_ATTR_VALUE;
	}
	
	/**
	 * @param pRE_ATTR_VALUE the pRE_ATTR_VALUE to set
	 */
	public void setPRE_ATTR_VALUE(String pRE_ATTR_VALUE) {
		PRE_ATTR_VALUE = pRE_ATTR_VALUE;
	}
	
	/**
	 * @return the sTATUS
	 */
	public String getSTATUS() {
		return STATUS;
	}
	
	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	/**
	 * @return the eFFECTIVE
	 */
	public String getEFFECTIVE() {
		return EFFECTIVE;
	}
	
	/**
	 * @param eFFECTIVE the eFFECTIVE to set
	 */
	public void setEFFECTIVE(String eFFECTIVE) {
		EFFECTIVE = eFFECTIVE;
	}
	
	/**
	 * @return the eXPIRE
	 */
	public String getEXPIRE() {
		return EXPIRE;
	}
	
	/**
	 * @param eXPIRE the eXPIRE to set
	 */
	public void setEXPIRE(String eXPIRE) {
		EXPIRE = eXPIRE;
	}
	
}
