package com.ai.sacenter.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ���񶨵��ͻ�</p>
 * <p>Copyright: Copyright (c) 2017��2��23��</p>
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
	 * @return �ͻ����
	 */
	public long getCUST_ID() {
		return CUST_ID;
	}
	
	/**
	 * @param cUST_ID �ͻ����
	 */
	public void setCUST_ID(long cUST_ID) {
		CUST_ID = cUST_ID;
	}
	
	/**
	 * @return �ͻ�����
	 */
	public String getCUST_CODE() {
		return CUST_CODE;
	}
	
	/**
	 * @param cUST_CODE �ͻ�����
	 */
	public void setCUST_CODE(String cUST_CODE) {
		CUST_CODE = cUST_CODE;
	}
	
	/**
	 * @return �ͻ�����
	 */
	public String getCUST_NAME() {
		return CUST_NAME;
	}
	
	/**
	 * @param cUST_NAME �ͻ�����
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
	 * @param cUST_TYPE �ͻ�����
	 */
	public void setCUST_TYPE(String cUST_TYPE) {
		CUST_TYPE = cUST_TYPE;
	}
	
	/**
	 * @return �ͻ�����
	 */
	public String getCUST_LEVEL() {
		return CUST_LEVEL;
	}
	
	/**
	 * @param cUST_LEVEL �ͻ��ȼ�
	 */
	public void setCUST_LEVEL(String cUST_LEVEL) {
		CUST_LEVEL = cUST_LEVEL;
	}
	
	/**
	 * @return ��ҵ���
	 */
	public String getCUST_VOCATION() {
		return CUST_VOCATION;
	}
	
	/**
	 * @param cUST_VOCATION ��ҵ���
	 */
	public void setCUST_VOCATION(String cUST_VOCATION) {
		CUST_VOCATION = cUST_VOCATION;
	}
	
	/**
	 * @return ֤������
	 */
	public String getCUST_CERTTYPE() {
		return CUST_CERTTYPE;
	}

	/**
	 * @param cUST_CERTTYPE ֤������
	 */
	public void setCUST_CERTTYPE(String cUST_CERTTYPE) {
		CUST_CERTTYPE = cUST_CERTTYPE;
	}

	/**
	 * @return ֤������
	 */
	public String getCUST_CERTCODE() {
		return CUST_CERTCODE;
	}

	/**
	 * @param cUST_CERTCODE ֤������
	 */
	public void setCUST_CERTCODE(String cUST_CERTCODE) {
		CUST_CERTCODE = cUST_CERTCODE;
	}

	/**
	 * @return ��ϵ��
	 */
	public String getCONTACT_NAME() {
		return CONTACT_NAME;
	}
	
	/**
	 * @param cONTACT_NAME ��ϵ��
	 */
	public void setCONTACT_NAME(String cONTACT_NAME) {
		CONTACT_NAME = cONTACT_NAME;
	}
	
	/**
	 * @return ��ϵ��Ӣ������
	 */
	public String getCONTACT_ENGLISH() {
		return CONTACT_ENGLISH;
	}

	/**
	 * @param cONTACT_ENGLISH ��ϵ��Ӣ������
	 */
	public void setCONTACT_ENGLISH(String cONTACT_ENGLISH) {
		CONTACT_ENGLISH = cONTACT_ENGLISH;
	}

	/**
	 * @return ��ϵ�˵绰
	 */
	public String getCONTACT_PHONE() {
		return CONTACT_PHONE;
	}
	
	/**
	 * @param cONTACT_PHONE ��ϵ�˵绰
	 */
	public void setCONTACT_PHONE(String cONTACT_PHONE) {
		CONTACT_PHONE = cONTACT_PHONE;
	}
	
	/**
	 * @return ���б���
	 */
	public String getCOUNTRY_CODE() {
		return COUNTRY_CODE;
	}
	
	/**
	 * @param cOUNTRY_CODE ���б���
	 */
	public void setCOUNTRY_CODE(String cOUNTRY_CODE) {
		COUNTRY_CODE = cOUNTRY_CODE;
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
	 * @return ��Чʱ��
	 */
	public java.sql.Timestamp getEFFECTIVE() {
		return EFFECTIVE;
	}
	
	/**
	 * @param eFFECTIVE ��Чʱ��
	 */
	public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
		EFFECTIVE = eFFECTIVE;
	}
	
	/**
	 * @return ʧЧʱ��
	 */
	public java.sql.Timestamp getEXPIRE() {
		return EXPIRE;
	}
	
	/**
	 * @param eXPIRE ʧЧʱ��
	 */
	public void setEXPIRE(java.sql.Timestamp eXPIRE) {
		EXPIRE = eXPIRE;
	}
	
	/**
	 * @return �ͻ���չ����
	 */
	public java.util.Map<String, IOVOrderOfferX> getNATURE() {
		return NATURE;
	}
	
	/**
	 * �������Ա�Ų�ѯ�ͻ���չ����
	 * @param aCOMPETE
	 * @return
	 */
	public IOVOrderOfferX getNATURE( String aCOMPETE ){
		return (IOVOrderOfferX)NATURE.get( aCOMPETE );
	}

	/**
	 * @return ��ȡ�ͻ���ַ
	 */
	public String getCUST_ADDRESS() {
		return CUST_ADDRESS;
	}

	/**
	 * @return ��ȡ�ͻ���ַ
	 */
	public void setCUST_ADDRESS(String CUST_ADDRESS) {
		this.CUST_ADDRESS = CUST_ADDRESS;
	}
}
