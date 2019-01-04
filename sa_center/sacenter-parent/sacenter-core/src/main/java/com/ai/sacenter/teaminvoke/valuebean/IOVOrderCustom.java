package com.ai.sacenter.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 服务定单客户</p>
 * <p>Copyright: Copyright (c) 2017年2月23日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVOrderCustom implements java.io.Serializable{
	private static final long serialVersionUID = 2802906657951318648L;
	private long   CUST_ID       ;
	private String CUST_CODE     ;
	private String CUST_NAME     ;
	private String CUST_TYPE     ;
	private String CUST_LEVEL    ;
	private String CUST_VOCATION ;
	private String CUST_ADDRESS  ;
	private String CUST_CERTTYPE ;
	private String CUST_CERTCODE ;
	private String CONTACT_NAME  ;
	private String CONTACT_ENGLISH;
	private String CONTACT_PHONE ;
	private String COUNTRY_CODE  ;
	private String REGION_ID     ;
	private java.sql.Timestamp EFFECTIVE;
    private java.sql.Timestamp EXPIRE   ;
	private java.util.Map<String, IOVOrderOfferX> NATURE = new java.util.HashMap<String, IOVOrderOfferX>();
	public IOVOrderCustom() {
		super();
	}

	public IOVOrderCustom( IOVOrderCustom custom ) {
		super();
		CUST_ID         = custom.CUST_ID        ;
		CUST_CODE       = custom.CUST_CODE      ;
		CUST_NAME       = custom.CUST_NAME      ;
		CUST_TYPE       = custom.CUST_TYPE      ;
		CUST_LEVEL      = custom.CUST_LEVEL     ;
		CUST_VOCATION   = custom.CUST_VOCATION  ;
		CUST_ADDRESS    = custom.CUST_ADDRESS   ;
		CUST_CERTTYPE   = custom.CUST_CERTTYPE  ;
		CUST_CERTCODE   = custom.CUST_CERTCODE  ;
		CONTACT_NAME    = custom.CONTACT_NAME   ;
		CONTACT_ENGLISH = custom.CONTACT_ENGLISH;
		CONTACT_PHONE   = custom.CONTACT_PHONE  ;
		COUNTRY_CODE    = custom.COUNTRY_CODE   ;
		REGION_ID       = custom.REGION_ID      ;
		EFFECTIVE       = custom.EFFECTIVE      ;
		EXPIRE          = custom.EXPIRE         ;
		for( java.util.Iterator<IOVOrderOfferX> itera = custom.NATURE.values().iterator(); itera.hasNext(); ){
			IOVOrderOfferX orderoffer = (IOVOrderOfferX)itera.next();
			NATURE.put( orderoffer.getCOMPETE(), new IOVOrderOfferX( orderoffer ) );
		}
	}
	
	/**
	 * @return 客户编号
	 */
	public long getCUST_ID() {
		return CUST_ID;
	}
	
	/**
	 * @param cUST_ID 客户编号
	 */
	public void setCUST_ID(long cUST_ID) {
		CUST_ID = cUST_ID;
	}
	
	/**
	 * @return 客户编码
	 */
	public String getCUST_CODE() {
		return CUST_CODE;
	}
	
	/**
	 * @param cUST_CODE 客户编码
	 */
	public void setCUST_CODE(String cUST_CODE) {
		CUST_CODE = cUST_CODE;
	}
	
	/**
	 * @return 客户名称
	 */
	public String getCUST_NAME() {
		return CUST_NAME;
	}
	
	/**
	 * @param cUST_NAME 客户名称
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
	 * @param cUST_TYPE 客户类型
	 */
	public void setCUST_TYPE(String cUST_TYPE) {
		CUST_TYPE = cUST_TYPE;
	}
	
	/**
	 * @return 客户类型
	 */
	public String getCUST_LEVEL() {
		return CUST_LEVEL;
	}
	
	/**
	 * @param cUST_LEVEL 客户等级
	 */
	public void setCUST_LEVEL(String cUST_LEVEL) {
		CUST_LEVEL = cUST_LEVEL;
	}
	
	/**
	 * @return 行业类别
	 */
	public String getCUST_VOCATION() {
		return CUST_VOCATION;
	}
	
	/**
	 * @param cUST_VOCATION 行业类别
	 */
	public void setCUST_VOCATION(String cUST_VOCATION) {
		CUST_VOCATION = cUST_VOCATION;
	}
	
	/**
	 * @return 证件类型
	 */
	public String getCUST_CERTTYPE() {
		return CUST_CERTTYPE;
	}

	/**
	 * @param cUST_CERTTYPE 证件类型
	 */
	public void setCUST_CERTTYPE(String cUST_CERTTYPE) {
		CUST_CERTTYPE = cUST_CERTTYPE;
	}

	/**
	 * @return 证件号码
	 */
	public String getCUST_CERTCODE() {
		return CUST_CERTCODE;
	}

	/**
	 * @param cUST_CERTCODE 证件号码
	 */
	public void setCUST_CERTCODE(String cUST_CERTCODE) {
		CUST_CERTCODE = cUST_CERTCODE;
	}

	/**
	 * @return 联系人
	 */
	public String getCONTACT_NAME() {
		return CONTACT_NAME;
	}
	
	/**
	 * @param cONTACT_NAME 联系人
	 */
	public void setCONTACT_NAME(String cONTACT_NAME) {
		CONTACT_NAME = cONTACT_NAME;
	}
	
	/**
	 * @return 联系人英文名称
	 */
	public String getCONTACT_ENGLISH() {
		return CONTACT_ENGLISH;
	}

	/**
	 * @param cONTACT_ENGLISH 联系人英文名称
	 */
	public void setCONTACT_ENGLISH(String cONTACT_ENGLISH) {
		CONTACT_ENGLISH = cONTACT_ENGLISH;
	}

	/**
	 * @return 联系人电话
	 */
	public String getCONTACT_PHONE() {
		return CONTACT_PHONE;
	}
	
	/**
	 * @param cONTACT_PHONE 联系人电话
	 */
	public void setCONTACT_PHONE(String cONTACT_PHONE) {
		CONTACT_PHONE = cONTACT_PHONE;
	}
	
	/**
	 * @return 县市编码
	 */
	public String getCOUNTRY_CODE() {
		return COUNTRY_CODE;
	}
	
	/**
	 * @param cOUNTRY_CODE 县市编码
	 */
	public void setCOUNTRY_CODE(String cOUNTRY_CODE) {
		COUNTRY_CODE = cOUNTRY_CODE;
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
	 * @return 生效时间
	 */
	public java.sql.Timestamp getEFFECTIVE() {
		return EFFECTIVE;
	}
	
	/**
	 * @param eFFECTIVE 生效时间
	 */
	public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
		EFFECTIVE = eFFECTIVE;
	}
	
	/**
	 * @return 失效时间
	 */
	public java.sql.Timestamp getEXPIRE() {
		return EXPIRE;
	}
	
	/**
	 * @param eXPIRE 失效时间
	 */
	public void setEXPIRE(java.sql.Timestamp eXPIRE) {
		EXPIRE = eXPIRE;
	}
	
	/**
	 * @return 客户扩展属性
	 */
	public java.util.Map<String, IOVOrderOfferX> getNATURE() {
		return NATURE;
	}
	
	/**
	 * 根据属性编号查询客户扩展属性
	 * @param aCOMPETE
	 * @return
	 */
	public IOVOrderOfferX getNATURE( String aCOMPETE ){
		return (IOVOrderOfferX)NATURE.get( aCOMPETE );
	}

	/**
	 * @return 获取客户地址
	 */
	public String getCUST_ADDRESS() {
		return CUST_ADDRESS;
	}

	/**
	 * @return 获取客户地址
	 */
	public void setCUST_ADDRESS(String CUST_ADDRESS) {
		this.CUST_ADDRESS = CUST_ADDRESS;
	}
}
