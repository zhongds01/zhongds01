package com.ai.sacenter.teaminvoke.valuebean;

import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务产品订购属性</p>
 * <p>Copyright: Copyright (c) 2015年9月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVOrderOfferX implements java.io.Serializable{
	private static final long serialVersionUID = 3692351173835684886L;
	private long   OFFER_ID      ;
	private String COMPETE       ;
	private String CUSTOM        ;
	private String ATTR_VALUE    ;
	private String PRE_ATTR_VALUE;
	private String STATUS        ; 
	private java.sql.Timestamp EFFECTIVE;
	private java.sql.Timestamp EXPIRE   ;
	public IOVOrderOfferX() {
		super();
		OFFER_ID   = 0                       ;
		EFFECTIVE  = TimeUtils.getEffective();
		EXPIRE     = TimeUtils.getMaxExpire();
	}
	
	public IOVOrderOfferX( IOVOrderOfferX fromOfferX ){
		super();
		OFFER_ID       = fromOfferX.OFFER_ID      ;
		COMPETE        = fromOfferX.COMPETE       ;
		CUSTOM         = fromOfferX.CUSTOM        ;
		ATTR_VALUE     = fromOfferX.ATTR_VALUE    ;
		PRE_ATTR_VALUE = fromOfferX.PRE_ATTR_VALUE;
		STATUS         = fromOfferX.STATUS        ; 
		EFFECTIVE      = fromOfferX.EFFECTIVE     ;
		EXPIRE         = fromOfferX.EXPIRE        ;
	}
	
	public IOVOrderOfferX( String aCOMPETE, String aAttrValue ){
		super();
		OFFER_ID   = 0                       ;
		COMPETE    = aCOMPETE                ;
		ATTR_VALUE = aAttrValue              ;
		STATUS     = "C"                     ;
		EFFECTIVE  = TimeUtils.getEffective();
		EXPIRE     = TimeUtils.getMaxExpire();
	}
	
	public IOVOrderOfferX( String aCOMPETE, String aAttrValue, String aSTATUS ){
		super();
		OFFER_ID   = 0                       ;
		COMPETE    = aCOMPETE                ;
		ATTR_VALUE = aAttrValue              ;
		STATUS     = aSTATUS                 ;
		EFFECTIVE  = TimeUtils.getEffective();
		EXPIRE     = TimeUtils.getMaxExpire();
	}
	
	public IOVOrderOfferX( String aCOMPETE, long aAttrValue ){
		super();
		OFFER_ID   = 0                            ;
		COMPETE    = aCOMPETE                     ;
		ATTR_VALUE = String.valueOf( aAttrValue ) ;
		STATUS     = "C"                          ;
		EFFECTIVE  = TimeUtils.getEffective()     ;
		EXPIRE     = TimeUtils.getMaxExpire()     ;
	}
	
	public IOVOrderOfferX( String aCOMPETE, java.sql.Timestamp aAttrValue ){
		super();
		OFFER_ID   = 0                                     ;
		COMPETE    = aCOMPETE                              ;
		ATTR_VALUE = TimeUtils.yyyymmddhhmmss( aAttrValue );
		STATUS     = "C"                                   ;
		EFFECTIVE  = TimeUtils.getEffective()              ;
		EXPIRE     = TimeUtils.getMaxExpire()              ;
	}

	/**
	 * @return 订购编号
	 */
	public long getOFFER_ID() {
		return OFFER_ID;
	}

	/**
	 * @param oFFER_ID 订购编号
	 */
	public void setOFFER_ID(long oFFER_ID) {
		OFFER_ID = oFFER_ID;
	}

	/**
	 * @return 属性编号
	 */
	public String getCOMPETE() {
		return COMPETE;
	}
	
	/**
	 * @param cOMPETE 属性编号
	 */
	public void setCOMPETE(String cOMPETE) {
		COMPETE = cOMPETE;
	}
	
	/**
	 * @return 功能编码
	 */
	public String getCUSTOM() {
		return CUSTOM;
	}

	/**
	 * @param cUSTOM 功能编码
	 */
	public void setCUSTOM(String cUSTOM) {
		CUSTOM = cUSTOM;
	}

	/**
	 * @return 属性值
	 */
	public String getATTR_VALUE() {
		return ATTR_VALUE;
	}
	
	/**
	 * @param aTTR_VALUE 属性值
	 */
	public void setATTR_VALUE(String aTTR_VALUE) {
		ATTR_VALUE = aTTR_VALUE;
	}
	
	/**
	 * @return 属性老值
	 */
	public String getPRE_ATTR_VALUE() {
		return PRE_ATTR_VALUE;
	}
	
	/**
	 * @param pRE_ATTR_VALUE 属性老值
	 */
	public void setPRE_ATTR_VALUE(String pRE_ATTR_VALUE) {
		PRE_ATTR_VALUE = pRE_ATTR_VALUE;
	}
	
	/**
	 * @return 属性状态
	 */
	public String getSTATUS() {
		return STATUS;
	}
	
	/**
	 * @param sTATUS 属性状态
	 */
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
		
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
	 * 
	 * @param fromFuture
	 */
	public void toXML( org.dom4j.Element fromFuture ){
		try
		{
			fromFuture.addElement("ATTR_ID"  ).setText( COMPETE  );
			if( CUSTOM != null ){
				fromFuture.addElement("CUSTOM"  ).setText( CUSTOM  );
			}
			if( ATTR_VALUE != null ){
				fromFuture.addElement("ATTR_VALUE"  ).setText( ATTR_VALUE  );
			}
			if( PRE_ATTR_VALUE != null ){
				fromFuture.addElement("PRE_ATTR_VALUE"  ).setText( PRE_ATTR_VALUE  );
			}
			if( STATUS != null ){
				fromFuture.addElement("STATUS"  ).setText( STATUS  );
			}
			if( EFFECTIVE != null ){
				fromFuture.addElement("EFFECTIVE"  ).setText( TimeUtils.yyyymmddhhmmss( EFFECTIVE )  );
			}
			if( EXPIRE != null ){
				fromFuture.addElement("EXPIRE"  ).setText( TimeUtils.yyyymmddhhmmss( EXPIRE )  );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String fromXML = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( "InterBOSS" );
			toXML( fromRoot.addElement( "FUTURE" ) );
			fromXML = XmlUtils.IXml._format( document.asXML() );
		}
		catch( java.lang.Exception exception ){
			fromXML = super.toString();
		}
		finally{
			
		}
		return fromXML;
	}
}
