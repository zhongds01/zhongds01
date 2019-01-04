package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê2ÔÂ23ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFCustom implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = 4090809069712403262L;
	private long   CUST_ID        ;
	private String CUST_CODE      ;
	private String CUST_NAME      ;
	private String CUST_TYPE      ;
	private String CUST_LEVEL     ;
	private String CUST_ADDRESS   ;
	private String CUST_VOCATION  ;
	private String CUST_CERTTYPE  ;
	private String CUST_CERTCODE  ;
	private String CONTACT_NAME   ;
	private String CONTACT_ENGLISH;
	private String CONTACT_PHONE  ;
	private String COUNTRY_CODE   ;
	private String REGION_ID      ;
	private java.sql.Timestamp EFFECTIVE;
    private java.sql.Timestamp EXPIRE   ;
	private CarbonList<IOVMsgFOfferX> NATURE = new CarbonList<IOVMsgFOfferX>();
	public IOVMsgFCustom() {
		super();
	}
	
	public IOVMsgFCustom( IOVMsgFCustom custom ) {
		super();
		CUST_ID         = custom.CUST_ID         ;
		CUST_CODE       = custom.CUST_CODE       ;
		CUST_NAME       = custom.CUST_NAME       ;
		CUST_TYPE       = custom.CUST_TYPE       ;
		CUST_LEVEL      = custom.CUST_LEVEL      ;
		CUST_ADDRESS    = custom.CUST_ADDRESS    ;
		CUST_VOCATION   = custom.CUST_VOCATION   ;
		CUST_CERTTYPE   = custom.CUST_CERTTYPE   ;
		CUST_CERTCODE   = custom.CUST_CERTCODE   ;
		CONTACT_NAME    = custom.CONTACT_NAME    ;
		CONTACT_PHONE   = custom.CONTACT_PHONE   ;
		CONTACT_ENGLISH = custom.CONTACT_ENGLISH ;
		COUNTRY_CODE    = custom.COUNTRY_CODE    ;
		REGION_ID       = custom.REGION_ID       ;
		EFFECTIVE       = custom.EFFECTIVE       ;
		EXPIRE          = custom.EXPIRE          ;
		for( java.util.Iterator<IOVMsgFOfferX> itera = custom.NATURE.iterator(); itera.hasNext(); ){
			IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
			NATURE.add( new IOVMsgFOfferX( fromOfferX ) );
		}
	}
	
	public IOVMsgFCustom( org.dom4j.Element element ){
		super();
		CUST_ID         = RocketUtils.IMetaX._jj_long     ( element, "CustId"         );
		CUST_CODE       = RocketUtils.IMetaX._jj_string   ( element, "CustCode"       , true );
		CUST_NAME       = RocketUtils.IMetaX._jj_string   ( element, "CustName"       , true );
		CUST_TYPE       = RocketUtils.IMetaX._jj_string   ( element, "CustType"       , true );
		CUST_LEVEL      = RocketUtils.IMetaX._jj_string   ( element, "CustLevel"      , true );
		CUST_ADDRESS    = RocketUtils.IMetaX._jj_string   ( element, "CustAddress"    , true );
		CUST_VOCATION   = RocketUtils.IMetaX._jj_string   ( element, "CustVocation"   , true );
		CUST_CERTTYPE   = RocketUtils.IMetaX._jj_string   ( element, "CertType"       , true );
		CUST_CERTCODE   = RocketUtils.IMetaX._jj_string   ( element, "CertCode"       , true );
		CONTACT_NAME    = RocketUtils.IMetaX._jj_string   ( element, "ContactName"    , true );
		CONTACT_PHONE   = RocketUtils.IMetaX._jj_string   ( element, "ContactPhone"   , true );
		CONTACT_ENGLISH = RocketUtils.IMetaX._jj_string   ( element, "ContactEnglish" , true );
		COUNTRY_CODE    = RocketUtils.IMetaX._jj_string   ( element, "CountryCode"    , true );
		REGION_ID       = RocketUtils.IMetaX._jj_string   ( element, "RegionId"       , true );
		EFFECTIVE       = RocketUtils.IMetaX._jj_timestamp( element, "EffTime"        , true );
		EXPIRE          = RocketUtils.IMetaX._jj_timestamp( element, "ExpTime"        , true );
		org.dom4j.Element custextinfo = element.element( "CustExtInfo" );
		if( custextinfo != null ){
			for(java.util.Iterator<org.dom4j.Element> itera = custextinfo.elements("AttrInfo").iterator();itera.hasNext();){
				org.dom4j.Element _element = (org.dom4j.Element)itera.next();
				IOVMsgFOfferX fromOfferX = new IOVMsgFOfferX( _element );
				if( fromOfferX.isVALID() ){ NATURE.add( fromOfferX ); }
			}
		}
	}

	/**
	 * @return the cUST_ID
	 */
	public long getCUST_ID() {
		return CUST_ID;
	}

	/**
	 * @param cUST_ID the cUST_ID to set
	 */
	public void setCUST_ID(long cUST_ID) {
		CUST_ID = cUST_ID;
	}

	/**
	 * @return the cUST_CODE
	 */
	public String getCUST_CODE() {
		return CUST_CODE;
	}

	/**
	 * @param cUST_CODE the cUST_CODE to set
	 */
	public void setCUST_CODE(String cUST_CODE) {
		CUST_CODE = cUST_CODE;
	}

	/**
	 * @return the cUST_NAME
	 */
	public String getCUST_NAME() {
		return CUST_NAME;
	}

	/**
	 * @param cUST_NAME the cUST_NAME to set
	 */
	public void setCUST_NAME(String cUST_NAME) {
		CUST_NAME = cUST_NAME;
	}

	/**
	 * @return the cUST_TYPE
	 */
	public String getCUST_TYPE() {
		return CUST_TYPE;
	}

	/**
	 * @param cUST_TYPE the cUST_TYPE to set
	 */
	public void setCUST_TYPE(String cUST_TYPE) {
		CUST_TYPE = cUST_TYPE;
	}

	/**
	 * @return the cUST_LEVEL
	 */
	public String getCUST_LEVEL() {
		return CUST_LEVEL;
	}

	/**
	 * @param cUST_LEVEL the cUST_LEVEL to set
	 */
	public void setCUST_LEVEL(String cUST_LEVEL) {
		CUST_LEVEL = cUST_LEVEL;
	}

	/**
	 * @return the cUST_ADDRESS
	 */
	public String getCUST_ADDRESS() {
		return CUST_ADDRESS;
	}

	/**
	 * @param cUST_ADDRESS the cUST_ADDRESS to set
	 */
	public void setCUST_ADDRESS(String cUST_ADDRESS) {
		CUST_ADDRESS = cUST_ADDRESS;
	}

	/**
	 * @return the cUST_VOCATION
	 */
	public String getCUST_VOCATION() {
		return CUST_VOCATION;
	}

	/**
	 * @param cUST_VOCATION the cUST_VOCATION to set
	 */
	public void setCUST_VOCATION(String cUST_VOCATION) {
		CUST_VOCATION = cUST_VOCATION;
	}

	/**
	 * @return the cUST_CERTTYPE
	 */
	public String getCUST_CERTTYPE() {
		return CUST_CERTTYPE;
	}

	/**
	 * @param cUST_CERTTYPE the cUST_CERTTYPE to set
	 */
	public void setCUST_CERTTYPE(String cUST_CERTTYPE) {
		CUST_CERTTYPE = cUST_CERTTYPE;
	}

	/**
	 * @return the cUST_CERTCODE
	 */
	public String getCUST_CERTCODE() {
		return CUST_CERTCODE;
	}

	/**
	 * @param cUST_CERTCODE the cUST_CERTCODE to set
	 */
	public void setCUST_CERTCODE(String cUST_CERTCODE) {
		CUST_CERTCODE = cUST_CERTCODE;
	}

	/**
	 * @return the cONTACT_NAME
	 */
	public String getCONTACT_NAME() {
		return CONTACT_NAME;
	}

	/**
	 * @param cONTACT_NAME the cONTACT_NAME to set
	 */
	public void setCONTACT_NAME(String cONTACT_NAME) {
		CONTACT_NAME = cONTACT_NAME;
	}

	/**
	 * @return the cONTACT_ENGLISH
	 */
	public String getCONTACT_ENGLISH() {
		return CONTACT_ENGLISH;
	}

	/**
	 * @param cONTACT_ENGLISH the cONTACT_ENGLISH to set
	 */
	public void setCONTACT_ENGLISH(String cONTACT_ENGLISH) {
		CONTACT_ENGLISH = cONTACT_ENGLISH;
	}

	/**
	 * @return the cONTACT_PHONE
	 */
	public String getCONTACT_PHONE() {
		return CONTACT_PHONE;
	}

	/**
	 * @param cONTACT_PHONE the cONTACT_PHONE to set
	 */
	public void setCONTACT_PHONE(String cONTACT_PHONE) {
		CONTACT_PHONE = cONTACT_PHONE;
	}

	/**
	 * @return the cOUNTRY_CODE
	 */
	public String getCOUNTRY_CODE() {
		return COUNTRY_CODE;
	}

	/**
	 * @param cOUNTRY_CODE the cOUNTRY_CODE to set
	 */
	public void setCOUNTRY_CODE(String cOUNTRY_CODE) {
		COUNTRY_CODE = cOUNTRY_CODE;
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
	 * @return the nATURE
	 */
	public CarbonList<IOVMsgFOfferX> getNATURE() {
		return NATURE;
	}
	
	/**
	 * 
	 * @param aFUTURE
	 * @return
	 */
	public IOVMsgFOfferX getFUTURE( String aFUTURE ){
		IOVMsgFOfferX fromFUTURE = null;
		try
		{
			for( java.util.Iterator<IOVMsgFOfferX> itera = NATURE.iterator(); itera.hasNext(); ){
				IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
				if( StringUtils.equals( fromOfferX.getATTR_ID(), aFUTURE ) ){
					fromFUTURE = fromOfferX;
					break;
				}
			}
		}
		finally{
			
		}
		return fromFUTURE;
	}
	
	/**
	 * 
	 * @param custom
	 */
	public void mergeAsCustom( IOVMsgFCustom custom ){
		try
		{
			for( java.util.Iterator<IOVMsgFOfferX> itera = custom.NATURE.iterator(); itera.hasNext(); ){
				IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
				if( NATURE.get( fromOfferX ) == null ) { NATURE.add( new IOVMsgFOfferX( fromOfferX ) ); }
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
		else if( ( objective instanceof IOVMsgFCustom ) == false ){
			_equal = false;
		}
		else{
			IOVMsgFCustom custom = (IOVMsgFCustom)objective;
			String _left = CustomUtils.ICatalog._custom_cust_id( CUST_ID, CUST_TYPE );
			String _right = CustomUtils.ICatalog._custom_cust_id( custom.CUST_ID, custom.CUST_TYPE );
			_equal = _left.equals( _right );
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
			doCompare = objective != null && objective instanceof IOVMsgFCustom ? 0 : 1;
			if (doCompare == 0) {
				IOVMsgFCustom custom = (IOVMsgFCustom)objective;
				String _left = CustomUtils.ICatalog._custom_cust_id( CUST_ID, CUST_TYPE );
				String _right = CustomUtils.ICatalog._custom_cust_id( custom.CUST_ID, custom.CUST_TYPE );
				doCompare = _left.compareTo( _right );
			}
		} 
		finally{

		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
}
