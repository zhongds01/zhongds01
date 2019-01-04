package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年1月11日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFOfferX implements java.lang.Comparable<Object>, java.io.Serializable {
	private static final long serialVersionUID = 8757745972500252717L;
	private long   INS_ATTR_ID   ;
	private String ATTR_ID       ;
	private String ATTR_VALUE    ;
	private String PRE_ATTR_VALUE;
	private String STATUS        ;
	private java.sql.Timestamp EFFECTIVE;
	private java.sql.Timestamp EXPIRE   ;
	public IOVMsgFOfferX() {
		super();
	}
	
	public IOVMsgFOfferX( String attrId ){
		super();
		INS_ATTR_ID= 0                             ;
		ATTR_ID    = attrId                        ;
		ATTR_VALUE = null                          ;
		STATUS     = IUpdbfsConst.IState.IOrder.S01;
		EFFECTIVE  = TimeUtils.getEffective      ();
		EXPIRE     = TimeUtils.getMaxExpire      ();
	}
	
	public IOVMsgFOfferX(String attrId, String attrValue){
		super();
		INS_ATTR_ID= 0                             ;
		ATTR_ID    = attrId                        ;
		ATTR_VALUE = attrValue                     ;
		STATUS     = IUpdbfsConst.IState.IOrder.S01;
		EFFECTIVE  = TimeUtils.getEffective()      ;
		EXPIRE     = TimeUtils.getMaxExpire()      ;
	}
	
	public IOVMsgFOfferX(String attrId, long attrValue){
		super();
		INS_ATTR_ID= 0                             ;
		ATTR_ID    = attrId                        ;
		ATTR_VALUE = String.valueOf( attrValue )   ;
		STATUS     = IUpdbfsConst.IState.IOrder.S01;
		EFFECTIVE  = TimeUtils.getEffective      ();
		EXPIRE     = TimeUtils.getMaxExpire      ();
	}
	
	public IOVMsgFOfferX(String attrId, java.sql.Timestamp attrValue){
		super();
		INS_ATTR_ID= 0                                    ;
		ATTR_ID    = attrId                               ;
		ATTR_VALUE = TimeUtils.yyyymmddhhmmss( attrValue );
		STATUS     = IUpdbfsConst.IState.IOrder.S01       ;
		EFFECTIVE  = TimeUtils.getEffective()             ;
		EXPIRE     = TimeUtils.getMaxExpire()             ;
	}
	
	public IOVMsgFOfferX(org.dom4j.Element element) {
		super();
		INS_ATTR_ID    = RocketUtils.IMetaX._jj_long     ( element, "InstAttrId"  , 0    );
		ATTR_ID        = RocketUtils.IMetaX._jj_string   ( element, "AttrId"             );
		ATTR_VALUE     = RocketUtils.IMetaX._jj_string   ( element, "AttrValue"          );
		PRE_ATTR_VALUE = RocketUtils.IMetaX._jj_string   ( element, "PreAttrValue", true );
		STATUS         = RocketUtils.IMetaX._jj_string   ( element, "AttrStatus"  , true );
		EFFECTIVE      = RocketUtils.IMetaX._jj_timestamp( element, "EffTime"     , true );
		EXPIRE         = RocketUtils.IMetaX._jj_timestamp( element, "ExpTime"     , true );
	}

	public IOVMsgFOfferX(IOVMsgFOfferX aOfferX){
		super();
		INS_ATTR_ID    = aOfferX.INS_ATTR_ID   ;
		ATTR_ID        = aOfferX.ATTR_ID       ;
		ATTR_VALUE     = aOfferX.ATTR_VALUE    ;
		PRE_ATTR_VALUE = aOfferX.PRE_ATTR_VALUE;
		STATUS         = aOfferX.STATUS        ;
		EFFECTIVE      = aOfferX.EFFECTIVE     ;
		EXPIRE         = aOfferX.EXPIRE        ;
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
	 * 是否送网元开通
	 * @return
	 */
	public boolean isVALID(){
		return StringUtils.isBlank( ATTR_ID ) == false && 
				StringUtils.isBlank( ATTR_VALUE ) == false;
	}
	
	/**
	 * 是否有效[本周期下周期生效]
	 * @return
	 */
	public boolean isVALIDALL(){
		boolean __validall = false;
		java.sql.Timestamp __sysdate = TimeUtils.getSysdate();
		if( StringUtils.isBlank( STATUS ) ){
			__validall = StringUtils.isBlank( ATTR_ID ) == false && StringUtils.isBlank( ATTR_VALUE ) == false;
		}
		else{
			__validall = StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S03 ) == false &&
					StringUtils.isBlank( ATTR_ID ) == false && StringUtils.isBlank( ATTR_VALUE ) == false && 
					TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, __sysdate );
		}
		return __validall;
	}
	
	/**
	 * 是否订购服务属性
	 * @return
	 */
	public boolean isCREATE(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S01 );
	}
	
	/**
	 * 是否变更服务属性
	 */
	public boolean isMODIFY(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S02 );
	}
	
	/**
	 * 是否退订服务属性
	 */
	public boolean isCANCEL(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S03 );
	}
	
	/**
	 * 是否保持服务属性
	 */
	public boolean isHOLDING(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S04 );
	}
	
	/**
	 * 是否服务属性有效
	 * @return
	 */
	public boolean isEFFECTIVE(){
		return StringUtils.isBlank( ATTR_ID ) == false && ( 
				StringUtils.isBlank( ATTR_VALUE ) == false || 
				   StringUtils.isBlank( PRE_ATTR_VALUE ) == false);
	}
	
	/**
	 * 
	 * @param fromProdAttrInfo
	 */
	public void msgfOfferToXML( org.dom4j.Element userfuture ){
		try
		{
			userfuture.addAttribute( "VALIDALL", String.valueOf( isVALIDALL() ).toUpperCase() );
			userfuture.addAttribute( "NETWORK", String.valueOf( isVALID() ).toUpperCase    () );
			userfuture.addElement("ATTR_ID"  ).setText( ATTR_ID  );
			if( ATTR_VALUE != null ){
				userfuture.addElement("ATTR_VALUE"  ).setText( ATTR_VALUE  );
			}
			if( PRE_ATTR_VALUE != null ){
				userfuture.addElement("PRE_ATTR_VALUE"  ).setText( PRE_ATTR_VALUE  );
			}
			if( STATUS != null ){
				userfuture.addElement("STATUS"  ).setText( STATUS  );
			}
			if( EFFECTIVE != null ){
				userfuture.addElement("EFFECTIVE"  ).setText( TimeUtils.yyyymmddhhmmss( EFFECTIVE )  );
			}
			if( EXPIRE != null ){
				userfuture.addElement("EXPIRE"  ).setText( TimeUtils.yyyymmddhhmmss( EXPIRE )  );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		boolean _equal = false;
		if( objective == null ){
			_equal = false;
		}
		else if( objective instanceof IOVMsgFOfferX == false ){
			_equal = false;
		}
		else{
			IOVMsgFOfferX offer = (IOVMsgFOfferX)objective;
			if( INS_ATTR_ID > 0 && offer.INS_ATTR_ID > 0 ){
				_equal = INS_ATTR_ID == offer.INS_ATTR_ID?(StringUtils.equals( ATTR_ID, offer.ATTR_ID ) ):false;
			}
			else if( INS_ATTR_ID <= 0 && offer.INS_ATTR_ID <= 0 ){
				_equal = StringUtils.equals( ATTR_ID, offer.ATTR_ID );
			}
			else{
				_equal = false;
			}
		}
		return _equal;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try
		{
			doCompare = objective != null && objective instanceof IOVMsgFOfferX?0:1;
			if( doCompare == 0 ){
				IOVMsgFOfferX offer = (IOVMsgFOfferX)objective;
				doCompare = INS_ATTR_ID > 0 && offer.INS_ATTR_ID > 0?(INS_ATTR_ID - offer.INS_ATTR_ID):1;
				if( doCompare == 0 ){ doCompare = ATTR_ID.compareTo( offer.ATTR_ID ); }
			}
		}
		finally{
			
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
}
