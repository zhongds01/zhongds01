package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 用户策划</p>
 * <p>Copyright: Copyright (c) 2018年2月27日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class IOVMsgFPlan implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = -7129889585190008312L;
    private long   INS_OFFER_ID ;
    private long   USER_ID      ;
	private long   OFFER_ID     ;
	private String OFFER_NAME   ;
	private String OFFER_TYPE   ;
	private String STATUS       ;
	private java.sql.Timestamp EFFECTIVE;
	private java.sql.Timestamp EXPIRE   ;
	private CarbonList<IOVMsgFOfferX>  FUTURE = new CarbonList<IOVMsgFOfferX>();
    public IOVMsgFPlan() {
		super();
	}

    public IOVMsgFPlan( IOVMsgFPlan centrex ){
    	super();
    	INS_OFFER_ID   = centrex.INS_OFFER_ID ;
    	USER_ID        = centrex.USER_ID      ;
    	OFFER_ID       = centrex.OFFER_ID     ;
		OFFER_NAME     = centrex.OFFER_NAME   ;
		OFFER_TYPE     = centrex.OFFER_TYPE   ;
		STATUS         = centrex.STATUS       ;
		EFFECTIVE      = centrex.EFFECTIVE    ;
		EXPIRE         = centrex.EXPIRE       ;
		for(java.util.Iterator<IOVMsgFOfferX> itera = centrex.FUTURE.iterator();itera.hasNext();){
			IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
			FUTURE.add( new IOVMsgFOfferX( fromOfferX ) );
		}
    }
    
    public IOVMsgFPlan(IOVMsgFUser fromUser, org.dom4j.Element element ){
		super();
		INS_OFFER_ID   = RocketUtils.IMetaX._jj_long     ( element, "InsOfferId"         );
		USER_ID        = fromUser.getUSER_ID                                            ();
		OFFER_ID       = RocketUtils.IMetaX._jj_long     ( element, "OfferId"            );
		OFFER_NAME     = RocketUtils.IMetaX._jj_string   ( element, "OfferName"   , true );
		OFFER_TYPE     = RocketUtils.IMetaX._jj_string   ( element, "OfferType"          );
		STATUS         = RocketUtils.IMetaX._jj_string   ( element, "OfferStatus"        );
		EFFECTIVE      = RocketUtils.IMetaX._jj_timestamp( element, "EffTime"     , true );
		EXPIRE         = RocketUtils.IMetaX._jj_timestamp( element, "ExpTime"     , true );
		org.dom4j.Element fromAttrList = element.element("OfferExtInfo");
		if( fromAttrList != null ){
			for(java.util.Iterator<org.dom4j.Element> itera = fromAttrList.elements("AttrInfo").iterator();itera.hasNext();){
				FUTURE.add( new IOVMsgFOfferX( (org.dom4j.Element)itera.next() ) );
			}
		}
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
	 * @return the oFFER_NAME
	 */
	public String getOFFER_NAME() {
		return OFFER_NAME;
	}

	/**
	 * @param oFFER_NAME the oFFER_NAME to set
	 */
	public void setOFFER_NAME(String oFFER_NAME) {
		OFFER_NAME = oFFER_NAME;
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
	 * @return the fUTURE
	 */
	public CarbonList<IOVMsgFOfferX> getFUTURE() {
		return FUTURE;
	}

	/**
	 * 是否有效[失效时间>生效时间]
	 * @return
	 */
	public boolean isVALID( ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE );
	}
	
	/**
	 * 是否有效[本周期下周期生效]
	 * @return
	 */
	public boolean isVALIDALL(){
		boolean _validall = false;
		try
		{
			java.sql.Timestamp __sysdate = TimeUtils.getSysdate();
			if( this instanceof IOVMsgFUserPlan /*开通用户测用户策划*/){
				_validall = isVALID() && TimeUtils.greater( EXPIRE, __sysdate );
			}
			else if( isVALID() == false/*开通定单测用户策划[立即退订]*/){
				_validall = TimeUtils.greaterEqual( EFFECTIVE, __sysdate );
			}
			else if( StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S03 ) /*开通定单测用户策划[立即退订]*/){
				_validall = ( TimeUtils.infiniteYYYY( EXPIRE, __sysdate ) || TimeUtils.greater( __sysdate, EXPIRE ) )?false:true;
			}
			else/*开通定单测用户策划*/{
				_validall = TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, __sysdate );
			}
		}
		finally{
			
		}
		return _validall;
	}
	
	/**
	 * 是否基本套餐
	 * @return
	 */
	public boolean isBASIC(){
		return StringUtils.startsWith( OFFER_TYPE, "OFFER_PLAN" );
	}
	
	/**
	 * 是否增值套餐
	 * @return
	 */
	public boolean isVAS(){
		return StringUtils.startsWith( OFFER_TYPE, "OFFER_PLAN" ) == false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective == null ){
			return false;
		}
		else if( objective instanceof IOVMsgFPlan == false ){
			return false;
		}
		else{
			IOVMsgFPlan offer = (IOVMsgFPlan)objective;
			return INS_OFFER_ID > 0 && offer.INS_OFFER_ID > 0 && INS_OFFER_ID == offer.INS_OFFER_ID;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try
		{
			doCompare = objective != null && objective instanceof IOVMsgFPlan?0:1;
			if( doCompare == 0 ){
				IOVMsgFPlan offer = (IOVMsgFPlan)objective;
				doCompare = INS_OFFER_ID > 0 && offer.INS_OFFER_ID > 0?0:1;
				if( doCompare == 0 ){
					doCompare = INS_OFFER_ID - offer.INS_OFFER_ID;
				}
			}
		}
		finally{
			
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
}
