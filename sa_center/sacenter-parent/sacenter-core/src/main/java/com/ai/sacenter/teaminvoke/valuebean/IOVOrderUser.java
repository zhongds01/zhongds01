package com.ai.sacenter.teaminvoke.valuebean;

import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务定单用户</p>
 * <p>Copyright: Copyright (c) 2015年9月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVOrderUser implements java.io.Serializable{
	private static final long serialVersionUID = -206486469772296991L;
	private long   USER_ID       ;
	private String CATALOG_ID    ;
	private String BILL_ID       ;
	private String SUB_BILL_ID   ;
	private String BRAND_ID      ;
	private String USER_TYPE     ;
	private String RISK_FLAG     ;
	private String NOTICE_FLAG   ;
	private String IS_OUT_NET    ;
	private String STATE         ;
	private String OS_STATE      ;
	private String OS_STATUS     ;
	private String REGION_ID     ;
	private String USER_REGION_ID;
	private String COUNTRY_CODE  ;
	private String ROLE_ID       ;
	private java.sql.Timestamp EFFECTIVE    ;
	private java.sql.Timestamp EXPIRE       ;
	private IOVOrderCustom CUSTOM = null;
	private IOVOrderGroup  GROUP = null;
	private java.util.Map<String, IOVOrderOfferX> NATURE = new java.util.HashMap<String, IOVOrderOfferX>();
	private java.util.List<IOVOrderOffer> PRODUCTION = new java.util.ArrayList<IOVOrderOffer>();
	public IOVOrderUser() {
		super();
	}

	public IOVOrderUser( IOVOrderUser user ) {
		super();
		USER_ID        = user.USER_ID       ;
		CATALOG_ID     = user.CATALOG_ID    ;
		BILL_ID        = user.BILL_ID       ;
		SUB_BILL_ID    = user.SUB_BILL_ID   ;
		BRAND_ID       = user.BRAND_ID      ;
		USER_TYPE      = user.USER_TYPE     ;
		RISK_FLAG      = user.RISK_FLAG     ;
		NOTICE_FLAG    = user.NOTICE_FLAG   ;
		IS_OUT_NET     = user.IS_OUT_NET    ;
		STATE          = user.STATE         ;
		OS_STATE       = user.OS_STATE      ;
		OS_STATUS      = user.OS_STATUS     ;
		REGION_ID      = user.REGION_ID     ;
		USER_REGION_ID = user.USER_REGION_ID;
		COUNTRY_CODE   = user.COUNTRY_CODE  ;
		ROLE_ID        = user.ROLE_ID       ;
		EFFECTIVE      = user.EFFECTIVE     ;
		EXPIRE         = user.EXPIRE        ;
		if( user.CUSTOM != null ){ CUSTOM = new IOVOrderCustom( user.CUSTOM ); }
		if( user.GROUP != null ){ GROUP = new IOVOrderGroup( user.GROUP ); }
		
		for( java.util.Iterator<IOVOrderOfferX> itera = user.NATURE.values().iterator(); itera.hasNext(); ){
			IOVOrderOfferX orderoffer = (IOVOrderOfferX)itera.next();
			NATURE.put( orderoffer.getCOMPETE(), new IOVOrderOfferX( orderoffer ) );
		}
		
		for( java.util.Iterator<IOVOrderOffer> itera = user.PRODUCTION.iterator(); itera.hasNext(); ){
			IOVOrderOffer orderoffer = (IOVOrderOffer)itera.next();
			PRODUCTION.add( new IOVOrderOffer( orderoffer ) );
		}
	}
	
	/**
	 * @return 用户编号
	 */
	public long getUSER_ID() {
		return USER_ID;
	}
	
	/**
	 * @param uSER_ID 用户编号
	 */
	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	/**
	 * @return 产品规格
	 */
	public String getCATALOG_ID() {
		return CATALOG_ID;
	}
	
	/**
	 * @param cATALOG_ID 产品规格
	 */
	public void setCATALOG_ID(String cATALOG_ID) {
		CATALOG_ID = cATALOG_ID;
	}
	
	/**
	 * @return 用户号码
	 */
	public String getBILL_ID() {
		return BILL_ID;
	}
	
	/**
	 * @param bILL_ID 用户号码
	 */
	public void setBILL_ID(String bILL_ID) {
		BILL_ID = bILL_ID;
	}
	
	/**
	 * @return 次计费号
	 */
	public String getSUB_BILL_ID() {
		return SUB_BILL_ID;
	}
	
	/**
	 * @param sUB_BILL_ID 次计费号
	 */
	public void setSUB_BILL_ID(String sUB_BILL_ID) {
		SUB_BILL_ID = sUB_BILL_ID;
	}
	
	/**
	 * @return 用户品牌
	 */
	public String getBRAND_ID() {
		return BRAND_ID;
	}
	
	/**
	 * @param bRAND_ID 用户品牌
	 */
	public void setBRAND_ID(String bRAND_ID) {
		BRAND_ID = bRAND_ID;
	}
	
	/**
	 * @return 用户类型
	 */
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	
	/**
	 * @param uSER_TYPE 用户类型
	 */
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	
	/**
	 * @return 风险控制
	 */
	public String getRISK_FLAG() {
		return RISK_FLAG;
	}
	
	/**
	 * @param rISK_FLAG 风险控制
	 */
	public void setRISK_FLAG(String rISK_FLAG) {
		RISK_FLAG = rISK_FLAG;
	}
	
	/**
	 * @return 催停标志
	 */
	public String getNOTICE_FLAG() {
		return NOTICE_FLAG;
	}
	
	/**
	 * @param nOTICE_FLAG 催停标志
	 */
	public void setNOTICE_FLAG(String nOTICE_FLAG) {
		NOTICE_FLAG = nOTICE_FLAG;
	}
	
	/**
	 * @return 他网标志
	 */
	public String getIS_OUT_NET() {
		return IS_OUT_NET;
	}
	
	/**
	 * @param iS_OUT_NET 他网标志
	 */
	public void setIS_OUT_NET(String iS_OUT_NET) {
		IS_OUT_NET = iS_OUT_NET;
	}
	
	/**
	 * @return 停复机值
	 */
	public String getOS_STATE() {
		return OS_STATE;
	}
	
	/**
	 * @param oS_STATE 停复机值
	 */
	public void setOS_STATE(String oS_STATE) {
		OS_STATE = oS_STATE;
	}
	
	/**
	 * @return 用户最终停机位
	 */
	public String getOS_STATUS() {
		return OS_STATUS;
	}
	
	/**
	 * @param oS_STATUS 用户最终停机位
	 */
	public void setOS_STATUS(String oS_STATUS) {
		OS_STATUS = oS_STATUS;
	}
	
	/**
	 * @return 用户状态
	 */
	public String getSTATE() {
		return STATE;
	}
	
	/**
	 * @param sTATE 用户状态
	 */
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	
	/**
	 * @return 用户地市
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}
	
	/**
	 * @param rEGION_ID 用户地市
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	
	/**
	 * @return 用户所在地市编码
	 */
	public String getUSER_REGION_ID() {
		return USER_REGION_ID;
	}
	
	/**
	 * @param uSER_REGION_ID 用户所在地市编码
	 */
	public void setUSER_REGION_ID(String uSER_REGION_ID) {
		USER_REGION_ID = uSER_REGION_ID;
	}
	
	/**
	 * @return 县市地市
	 */
	public String getCOUNTRY_CODE() {
		return COUNTRY_CODE;
	}
	
	/**
	 * @param cOUNTRY_CODE 县市地市
	 */
	public void setCOUNTRY_CODE(String cOUNTRY_CODE) {
		COUNTRY_CODE = cOUNTRY_CODE;
	}
	
	/**
	 * 
	 * @return 角色编号
	 */
	public String getROLE_ID() {
		return ROLE_ID;
	}
	
	/**
	 * 角色编号
	 * @param rOLE_ID
	 */
	public void setROLE_ID(String rOLE_ID) {
		ROLE_ID = rOLE_ID;
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
	 * @return 服务客户
	 */
	public IOVOrderCustom getCUSTOM() {
		return CUSTOM;
	}
	
	/**
	 * @param cUSTOM 服务客户
	 */
	public void setCUSTOM(IOVOrderCustom cUSTOM) {
		CUSTOM = cUSTOM;
	}
	
	/**
	 * @return 服务定单群
	 */
	public IOVOrderGroup getGROUP() {
		return GROUP;
	}

	/**
	 * @param gROUP 服务定单群
	 */
	public void setGROUP(IOVOrderGroup gROUP) {
		GROUP = gROUP;
	}

	/**
	 * @return 扩展属性
	 */
	public java.util.Map<String, IOVOrderOfferX> getNATURE() {
		return NATURE;
	}
	
	/**
	 * @param nATURE 扩展属性
	 */
	public void setNATURE(java.util.Map<String, IOVOrderOfferX> nATURE) {
		NATURE = nATURE;
	}
	
	/**
	 * 根据属性编号查询用户级服务属性
	 * @param aCOMPETE
	 * @return
	 */
	public IOVOrderOfferX getNATURE( String aCOMPETE ){
		return (IOVOrderOfferX)NATURE.get( aCOMPETE );
	}
	
	/**
	 * @return 用户订购列表
	 */
	public java.util.List<IOVOrderOffer> getPRODUCTION() {
		return PRODUCTION;
	}
	
	/**
	 * 根据产品编号查询开通订购关系
	 * @param aPRODUCT_ID 产品编号
	 * @return
	 */
	public IOVOrderOffer[] getPRODUCT( long aPRODUCT_ID ){
		java.util.List<IOVOrderOffer> fromArray = new java.util.ArrayList<IOVOrderOffer>();
		try
		{
			for( java.util.Iterator<IOVOrderOffer> itera = PRODUCTION.iterator(); itera.hasNext(); ){
				IOVOrderOffer fromOffer = (IOVOrderOffer)itera.next();
				if( fromOffer.getPRODUCT() == aPRODUCT_ID ){
					fromArray.add( fromOffer );
				}
			}
		}
		finally{
			
		}
		return (IOVOrderOffer[])fromArray.toArray( new IOVOrderOffer[]{});
	}
	
	/**
	 * 根据服务编号查询开通订购关系
	 * @param aCOMPETE_ID 服务编号
	 * @return
	 */
	public IOVOrderOffer[] getCOMPETE( long aCOMPETE_ID ){
		java.util.List<IOVOrderOffer> fromArray = new java.util.ArrayList<IOVOrderOffer>();
		try
		{
			for( java.util.Iterator<IOVOrderOffer> itera = PRODUCTION.iterator(); itera.hasNext(); ){
				IOVOrderOffer fromOffer = (IOVOrderOffer)itera.next();
				if( fromOffer.isCAPITY() && fromOffer.getCOMPETE() == aCOMPETE_ID  ){
					fromArray.add( fromOffer );
				}
			}
		}
		finally{
			
		}
		return (IOVOrderOffer[])fromArray.toArray( new IOVOrderOffer[]{});
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String fromXML = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "InterBOSS" );
			org.dom4j.Element _user = _root.addElement( "OrdUser" );
			_user.addElement( "USER_ID"        ).setText( String.valueOf( USER_ID )             );
			_user.addElement( "CATALOG_ID"     ).setText( CATALOG_ID                            );
			_user.addElement( "BILL_ID"        ).setText( BILL_ID                               );
			_user.addElement( "SUB_BILL_ID"    ).setText( SUB_BILL_ID != null?SUB_BILL_ID:""    );
			_user.addElement( "OS_STATE"       ).setText( OS_STATE                              );
			_user.addElement( "OS_STATUS"      ).setText( OS_STATUS != null?OS_STATUS:""        );
			_user.addElement( "REGION_ID"      ).setText( REGION_ID                             );
			_user.addElement( "USER_REGION_ID" ).setText( USER_REGION_ID                        );
			_user.addElement( "COUNTRY_CODE"   ).setText( COUNTRY_CODE != null?COUNTRY_CODE:""  );
			_user.addElement( "EFFECTIVE"      ).setText( TimeUtils.yyyymmddhhmmss( EFFECTIVE ) );
			_user.addElement( "EXPIRE"         ).setText( TimeUtils.yyyymmddhhmmss( EXPIRE    ) );
			org.dom4j.Element _nature = _user.addElement( "NATURE" );
			for( java.util.Iterator<IOVOrderOfferX> itera = NATURE.values().iterator(); itera.hasNext(); ){
				IOVOrderOfferX fromOrdOffer = (IOVOrderOfferX)itera.next();
				fromOrdOffer.toXML( _nature.addElement( "FUTURE" ) );
			}
			org.dom4j.Element _centrex = _user.addElement( "SUBFLOW" );
			for( java.util.Iterator<IOVOrderOffer> itera = PRODUCTION.iterator(); itera.hasNext(); ){
				IOVOrderOffer fromOrdOffer = (IOVOrderOffer)itera.next();
				fromOrdOffer.toXML( _centrex.addElement( "CENTREX" ) );
			}
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
