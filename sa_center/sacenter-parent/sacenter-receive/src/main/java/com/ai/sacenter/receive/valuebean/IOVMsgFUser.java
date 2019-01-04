package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年1月10日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFUser implements java.lang.Comparable<Object>,java.io.Serializable {
	private static final long serialVersionUID = -6173336841824718222L;
	private long   USER_ID       ;
	private String CATALOG       ;
	private String BILL_ID       ;
	private String SUB_BILL_ID   ;
	private String BRAND_ID      ;
	private String USER_TYPE     ;
	private String USER_STATUS   ;
	private String PARAM         ;
	private String OS_STATUS     ;
	private String PRE_OS_STATUS ;
	private String RISK_FLAG     ;
	private String NOTICE_FLAG   ;
	private String ROLE_ID       ;
	private String USER_REGION_ID;
	private String REGION_ID     ;
	private String COUNTRY_CODE  ;
	private String IS_OUT_NET    ;
    private java.sql.Timestamp EFFECTIVE;
    private java.sql.Timestamp EXPIRE;
    private IOVMsgFCustom  CUSTOM  = null;
    private IOVMsgFGroup   GROUP   = null;
    private CarbonList<IOVMsgFOfferX>      NATURE  = new CarbonList<IOVMsgFOfferX>();
    private CarbonList<IOVMsgFOrdCentrex>  ORDER   = new CarbonList<IOVMsgFOrdCentrex>();
    private CarbonList<IOVMsgFUserCentrex> USER    = new CarbonList<IOVMsgFUserCentrex>();
    private CarbonList<IOVMsgFPlan>        CENTREX = new CarbonList<IOVMsgFPlan>();
    private java.util.Map<String,Object>   FUTURE  = new java.util.HashMap<String,Object>();
    private IUserOfferHome _subflow = new IUserOfferHome();
    public IOVMsgFUser() {
    	super();
    }
    
    public IOVMsgFUser( IOVMsgFUser fromUser ) throws Exception{
    	super();
    	USER_ID        = fromUser.USER_ID       ;
    	CATALOG        = fromUser.CATALOG       ;
    	BILL_ID        = fromUser.BILL_ID       ;
    	SUB_BILL_ID    = fromUser.SUB_BILL_ID   ;
    	REGION_ID      = fromUser.REGION_ID     ;
    	BRAND_ID       = fromUser.BRAND_ID      ;
    	USER_TYPE      = fromUser.USER_TYPE     ;
    	USER_STATUS    = fromUser.USER_STATUS   ;
    	RISK_FLAG      = fromUser.RISK_FLAG     ;
    	NOTICE_FLAG    = fromUser.NOTICE_FLAG   ;
    	ROLE_ID        = fromUser.ROLE_ID       ;
    	USER_REGION_ID = fromUser.USER_REGION_ID;
    	COUNTRY_CODE   = fromUser.COUNTRY_CODE  ;
    	OS_STATUS      = fromUser.OS_STATUS     ;
    	PRE_OS_STATUS  = fromUser.PRE_OS_STATUS ;
    	IS_OUT_NET     = fromUser.IS_OUT_NET    ;
    	EFFECTIVE      = fromUser.EFFECTIVE     ;
    	EXPIRE         = fromUser.EXPIRE        ;
    	mergeAsOffer( fromUser );
    }
    
    public IOVMsgFUser( org.dom4j.Element element ) throws Exception{
    	super();
    	USER_ID        = RocketUtils.IMetaX._jj_long     ( element, "UserId"     );
    	CATALOG        = RocketUtils.IMetaX._jj_string   ( element, "ProdSpec"   );
    	BILL_ID        = RocketUtils.IMetaX._jj_string   ( element, "BillId"     );
    	SUB_BILL_ID    = RocketUtils.IMetaX._jj_string   ( element, "SubBillId"  , true );
    	BRAND_ID       = RocketUtils.IMetaX._jj_string   ( element, "BrandId"    , true );
    	USER_TYPE      = RocketUtils.IMetaX._jj_string   ( element, "UserType"   , true );
    	USER_STATUS    = RocketUtils.IMetaX._jj_string   ( element, "UserStatus" );
    	RISK_FLAG      = RocketUtils.IMetaX._jj_string   ( element, "RiskFlag"   , true );
    	NOTICE_FLAG    = RocketUtils.IMetaX._jj_string   ( element, "NoticeFlag" , true );
    	ROLE_ID        = RocketUtils.IMetaX._jj_string   ( element, "RoleCode"   , true );
    	USER_REGION_ID = RocketUtils.IMetaX._jj_string   ( element, "CityId"     );
    	COUNTRY_CODE   = RocketUtils.IMetaX._jj_string   ( element, "CountryCode", true );
    	OS_STATUS      = RocketUtils.IMetaX._jj_string   ( element, "OsStatus"   , true );
    	PRE_OS_STATUS  = RocketUtils.IMetaX._jj_string   ( element, "PreOsStatus", true );
    	IS_OUT_NET     = RocketUtils.IMetaX._jj_string   ( element, "IsOutNet"   );
    	EFFECTIVE      = RocketUtils.IMetaX._jj_timestamp( element, "EffTime"    , true );
    	EXPIRE         = RocketUtils.IMetaX._jj_timestamp( element, "ExpTime"    , true );
    	SFCenterOffer fromRoute = CenterUtils.ISystem._custom( this );
    	REGION_ID      = fromRoute.getREGION_ID          (                       );
    	//用户扩展属性
    	org.dom4j.Element fromUserInfo = element.element( "CustInfo" );
    	if( fromUserInfo != null ){ CUSTOM = new IOVMsgFCustom( fromUserInfo ); }
    	fromUserInfo = element.element( "UserExtInfo" );
    	if( fromUserInfo != null ){
    		for(java.util.Iterator<org.dom4j.Element> itera = fromUserInfo.elements("AttrInfo").iterator();itera.hasNext();){
    			org.dom4j.Element aElement = (org.dom4j.Element)itera.next();
    			IOVMsgFOfferX fromOfferX = new IOVMsgFOfferX( aElement );
    			if( fromOfferX.isVALID() ){ NATURE.add( fromOfferX ); }
    		}
    	}
    	//用户组属性
    	fromUserInfo = element.element("UserGroupInfo");
    	if( fromUserInfo != null && fromUserInfo.elements().size() > 0 ){
    		GROUP = new IOVMsgFGroup( fromUserInfo );
    	}
    	//定单测订购
    	fromUserInfo = element.element("OrderProdInfo");
    	if( fromUserInfo != null ){
    		for(java.util.Iterator<org.dom4j.Element> itera = fromUserInfo.elements("ProdInfo").iterator();itera.hasNext();){
    			org.dom4j.Element aElement = (org.dom4j.Element)itera.next();
    			IOVMsgFOrdOffer fromOffer = new IOVMsgFOrdOffer( this, aElement );
    			if( OrderUtils.IIfElse.isCOMPETE( fromOffer ) == false ) continue;
    			if( fromOffer.getCENTREX() != null && CENTREX.contains( fromOffer.getCENTREX() ) == false ){
    				CENTREX.add( new IOVMsgFOrdPlan( fromOffer.getCENTREX() ) );
    			}
    			mergeAsCentrex( fromOffer );
    		}
    	}
    	//用户测订购
    	fromUserInfo = element.element("UserProdInfo");
    	if( fromUserInfo != null ){
    		for(java.util.Iterator<org.dom4j.Element> itera = fromUserInfo.elements("ProdInfo").iterator();itera.hasNext();){
    			org.dom4j.Element aElement = (org.dom4j.Element)itera.next();
    			IOVMsgFUserOffer fromOffer = new IOVMsgFUserOffer(  this, aElement  );
    			if( OrderUtils.IIfElse.isCOMPETE( fromOffer ) == false ) continue;
    			if( fromOffer.getCENTREX() != null && CENTREX.contains( fromOffer.getCENTREX() ) == false ){
    				CENTREX.add( new IOVMsgFUserPlan( fromOffer.getCENTREX() ) );
    			}
    			mergeAsCentrex( fromOffer );
    		}
    	}
    	fromUserInfo = element.element( "UserPlanInfo" );
    	if( fromUserInfo != null ){
    		for(java.util.Iterator<org.dom4j.Element> itera = fromUserInfo.elements("PlanInfo").iterator();itera.hasNext();){
    			org.dom4j.Element aElement = (org.dom4j.Element)itera.next();
    			IOVMsgFUserPlan _centrex = new IOVMsgFUserPlan( this, aElement );
    			if( CENTREX.contains( _centrex ) == false ){ CENTREX.add( _centrex ); }
    		}
    	}
    	//工单协作
    	fromUserInfo = element.element( "CooperationInfo" );
    	if( fromUserInfo != null ){ XmlUtils.XPath( fromUserInfo.asXML(), FUTURE ); }
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
	 * @return the cATALOG
	 */
	public String getCATALOG() {
		return CATALOG;
	}

	/**
	 * @param cATALOG the cATALOG to set
	 */
	public void setCATALOG(String cATALOG) {
		CATALOG = cATALOG;
	}

	/**
	 * @return the bILL_ID
	 */
	public String getBILL_ID() {
		return BILL_ID;
	}

	/**
	 * @param bILL_ID the bILL_ID to set
	 */
	public void setBILL_ID(String bILL_ID) {
		BILL_ID = bILL_ID;
	}

	/**
	 * @return the sUB_BILL_ID
	 */
	public String getSUB_BILL_ID() {
		return SUB_BILL_ID;
	}

	/**
	 * @param sUB_BILL_ID the sUB_BILL_ID to set
	 */
	public void setSUB_BILL_ID(String sUB_BILL_ID) {
		SUB_BILL_ID = sUB_BILL_ID;
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
	 * @return the uSER_TYPE
	 */
	public String getUSER_TYPE() {
		return USER_TYPE;
	}

	/**
	 * @param uSER_TYPE the uSER_TYPE to set
	 */
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}

	/**
	 * @return the uSER_STATUS
	 */
	public String getUSER_STATUS() {
		return USER_STATUS;
	}

	/**
	 * @param uSER_STATUS the uSER_STATUS to set
	 */
	public void setUSER_STATUS(String uSER_STATUS) {
		USER_STATUS = uSER_STATUS;
	}

	/**
	 * @return the oS_STATUS
	 */
	public String getOS_STATUS() {
		return OS_STATUS;
	}

	/**
	 * @param oS_STATUS the oS_STATUS to set
	 */
	public void setOS_STATUS(String oS_STATUS) {
		OS_STATUS = oS_STATUS;
	}

	/**
	 * @return the pARAM
	 */
	public String getPARAM() {
		return PARAM;
	}

	/**
	 * @param pARAM the pARAM to set
	 */
	public void setPARAM(String pARAM) {
		PARAM = pARAM;
	}

	/**
	 * @return the pRE_OS_STATUS
	 */
	public String getPRE_OS_STATUS() {
		return PRE_OS_STATUS;
	}

	/**
	 * @param pRE_OS_STATUS the pRE_OS_STATUS to set
	 */
	public void setPRE_OS_STATUS(String pRE_OS_STATUS) {
		PRE_OS_STATUS = pRE_OS_STATUS;
	}

	/**
	 * @return the rISK_FLAG
	 */
	public String getRISK_FLAG() {
		return RISK_FLAG;
	}

	/**
	 * @param rISK_FLAG the rISK_FLAG to set
	 */
	public void setRISK_FLAG(String rISK_FLAG) {
		RISK_FLAG = rISK_FLAG;
	}

	/**
	 * @return the nOTICE_FLAG
	 */
	public String getNOTICE_FLAG() {
		return NOTICE_FLAG;
	}

	/**
	 * @param nOTICE_FLAG the nOTICE_FLAG to set
	 */
	public void setNOTICE_FLAG(String nOTICE_FLAG) {
		NOTICE_FLAG = nOTICE_FLAG;
	}

	/**
	 * @return the rOLE_ID
	 */
	public String getROLE_ID() {
		return ROLE_ID;
	}

	/**
	 * @param rOLE_ID the rOLE_ID to set
	 */
	public void setROLE_ID(String rOLE_ID) {
		ROLE_ID = rOLE_ID;
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
	 * @return the iS_OUT_NET
	 */
	public String getIS_OUT_NET() {
		return IS_OUT_NET;
	}

	/**
	 * @param iS_OUT_NET the iS_OUT_NET to set
	 */
	public void setIS_OUT_NET(String iS_OUT_NET) {
		IS_OUT_NET = iS_OUT_NET;
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
	 * @return the cUSTOM
	 */
	public IOVMsgFCustom getCUSTOM() {
		return CUSTOM;
	}

	/**
	 * @param cUSTOM the cUSTOM to set
	 */
	public void setCUSTOM(IOVMsgFCustom cUSTOM) {
		CUSTOM = cUSTOM;
	}

	/**
	 * @return the gROUP
	 */
	public IOVMsgFGroup getGROUP() {
		return GROUP;
	}

	/**
	 * @param gROUP the gROUP to set
	 */
	public void setGROUP(IOVMsgFGroup gROUP) {
		GROUP = gROUP;
	}

	/**
	 * @return the nATURE
	 */
	public CarbonList<IOVMsgFOfferX> getNATURE() {
		return NATURE;
	}

	/**
	 * @return the oRDER
	 */
	public CarbonList<IOVMsgFOrdCentrex> getORDER() {
		return ORDER;
	}
	
	/**
	 * @return 用户服务产品订购
	 */
	public CarbonList<IOVMsgFUserCentrex> getUSER() {
		return USER;
	}
	
	/**
	 * @return 用户套餐
	 */
	public CarbonList<IOVMsgFPlan> getCENTREX() {
		return CENTREX;
	}

	/**
	 * @return 工单协作
	 */
	public java.util.Map<String,Object> getFUTURE() {
		return FUTURE;
	}

	/**
	 * 根据服务编号查询用户资费包
	 * @param aINS_PROD_ID
	 * @return
	 */
	public IOVMsgFUserCentrex getUSER(long aINS_PROD_ID){
		IOVMsgFUserCentrex fromNATURE = null;
		try
		{
			for( java.util.Iterator<IOVMsgFUserCentrex> itera = USER.iterator(); itera.hasNext(); ){
				IOVMsgFUserCentrex fromOrdOff = (IOVMsgFUserCentrex)itera.next();
				if( aINS_PROD_ID > 0 && fromOrdOff.getINS_PROD_ID() == aINS_PROD_ID ){
					fromNATURE = fromOrdOff;
					break;
				}
			}
		}
		finally{
			
		}
		return fromNATURE;
	}
	
	/**
	 * 根据服务编号查询用户实例订购关系
	 * @param aSERVICE_ID
	 * @return
	 */
	public IOVMsgFOffer[] getUserOffer( long aSERVICE_ID ){
		CarbonList<IOVMsgFOffer> aCentrex = new CarbonList<IOVMsgFOffer>();
		try
		{
			for( java.util.Iterator<IOVMsgFUserCentrex> itera = USER.iterator(); itera.hasNext(); ){
				IOVMsgFUserCentrex usercentrex = (IOVMsgFUserCentrex)itera.next();
				IOVMsgFUserOffer useroffer = (IOVMsgFUserOffer)usercentrex.getCENTREX( aSERVICE_ID );
				if( useroffer != null ){ aCentrex.add( useroffer ); }
			}
		}
		finally{
			
		}
		return (IOVMsgFOffer[])aCentrex.toArray( new IOVMsgFOffer[]{} );
	}
	
	/**
	 * 根据服务编号查询用户实例订购关系
	 * @param aINS_PROD_ID
	 * @param aSERVICE_ID
	 * @return
	 */
	public IOVMsgFUserOffer getUserOffer(long aINS_PROD_ID, long aSERVICE_ID ){
		IOVMsgFUserOffer userorder = null;
		try
		{
			for( java.util.Iterator<IOVMsgFUserCentrex> itera = USER.iterator(); itera.hasNext(); ){
				IOVMsgFUserCentrex usercentrex = (IOVMsgFUserCentrex)itera.next();
				if( aINS_PROD_ID > 0 && usercentrex.getINS_PROD_ID() == aINS_PROD_ID ){
					userorder = (IOVMsgFUserOffer)usercentrex.getCENTREX( aSERVICE_ID );
					break;
				}
			}
		}
		finally{
			
		}
		return userorder;
	}
	
	/**
	 * 根据服务订购编号查询开通定单订购
	 * @param aINS_PROD_ID 服务订购编号
	 * @return
	 */
	public IOVMsgFOrdCentrex getORDER( long aINS_PROD_ID ){
		IOVMsgFOrdCentrex userorder = null;
		try
		{
			for( java.util.Iterator<IOVMsgFOrdCentrex> itera = ORDER.iterator(); itera.hasNext(); ){
				IOVMsgFOrdCentrex usercentrex = (IOVMsgFOrdCentrex)itera.next();
				if( aINS_PROD_ID > 0 && usercentrex.getINS_PROD_ID() == aINS_PROD_ID ){
					userorder = usercentrex;
					break;
				}
			}
		}
		finally{
			
		}
		return userorder;
	}
	
	/**
	 * 根据服务编号查询用户订单订购关系
	 * @param aSERVICE_ID
	 * @return
	 */
	public IOVMsgFOffer[] getOrdOffer( long aSERVICE_ID ){
		CarbonList<IOVMsgFOffer> aCentrex = new CarbonList<IOVMsgFOffer>();
		try
		{
			for( java.util.Iterator<IOVMsgFOrdCentrex> itera = ORDER.iterator(); itera.hasNext(); ){
				IOVMsgFOrdCentrex ordercentrex = (IOVMsgFOrdCentrex)itera.next();
				IOVMsgFOrdOffer orderoffer = (IOVMsgFOrdOffer)ordercentrex.getCENTREX( aSERVICE_ID );
				if( orderoffer != null ){ aCentrex.add( orderoffer ); }
			}
		}
		finally{
			
		}
		return (IOVMsgFOffer[])aCentrex.toArray( new IOVMsgFOffer[]{} );
	}
	
	/**
	 * 根据服务编号查询用户订单订购关系
	 * @param aINS_PROD_ID
	 * @param aSERVICE_ID
	 * @return
	 */
	public IOVMsgFOrdOffer getOrdOffer(long aINS_PROD_ID, long aSERVICE_ID ){
		IOVMsgFOrdOffer orderoffer = null;
		try
		{
			for( java.util.Iterator<IOVMsgFOrdCentrex> itera = ORDER.iterator(); itera.hasNext(); ){
				IOVMsgFOrdCentrex ordercentrex = (IOVMsgFOrdCentrex)itera.next();
				if( aINS_PROD_ID > 0 && ordercentrex.getINS_PROD_ID() == aINS_PROD_ID ){
					orderoffer = (IOVMsgFOrdOffer)ordercentrex.getCENTREX( aSERVICE_ID );
					break;
				}
			}
		}
		finally{
			
		}
		return orderoffer;
	}
	
	/**
	 * 根据服务订购编号查询开通服务订购
	 * @param aINS_PROD_ID 服务订购编号
	 * @return
	 */
	public IOVMsgFCentrex getOFFER( long aINS_PROD_ID ){
		IOVMsgFCentrex usercentrex = null;
		try
		{
			for( java.util.Iterator<IOVMsgFOrdCentrex> itera = ORDER.iterator(); itera.hasNext(); ){
				IOVMsgFOrdCentrex fromOrdOff = (IOVMsgFOrdCentrex)itera.next();
				if( aINS_PROD_ID > 0 && fromOrdOff.getINS_PROD_ID() == aINS_PROD_ID ){
					usercentrex = fromOrdOff;
					break;
				}
			}
			if( usercentrex == null && USER != null ){
				for( java.util.Iterator<IOVMsgFUserCentrex> itera = USER.iterator(); itera.hasNext(); ){
					IOVMsgFUserCentrex fromOrdOff = (IOVMsgFUserCentrex)itera.next();
					if( aINS_PROD_ID > 0 && fromOrdOff.getINS_PROD_ID() == aINS_PROD_ID ){
						usercentrex = fromOrdOff;
						break;
					}
				}
			}
		}
		finally{
			
		}
		return usercentrex;
	}
	
	/**
	 * 根据用户订购查询所在服务编号所有订购关系
	 * @param fromOffer
	 * @return
	 */
	public IOVMsgFOffer[] getOFFER( IOVMsgFOffer fromOffer ){
		IOVMsgFOffer fromNATURE[] = null;
		try
		{
			if( fromOffer.isORDER() ){
				fromNATURE = getOrdOffer( fromOffer.getSERVICE_ID() );
			}
			else{
				fromNATURE = getUserOffer( fromOffer.getSERVICE_ID() );
			}
		}
		finally{
			
		}
		return fromNATURE;
	}
	
	/**
	 * 根据用户扩展属性编码查询用户扩展属性
	 * @param aCOMPETE_ID
	 * @return
	 */
	public IOVMsgFOfferX getNATURE( String aCOMPETE_ID ){
		IOVMsgFOfferX fromNATURE = null;
		try
		{
			for( java.util.Iterator<IOVMsgFOfferX> itera = NATURE.iterator(); itera.hasNext(); ){
				IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
				if( StringUtils.equals( fromOfferX.getATTR_ID() , aCOMPETE_ID ) ){
					fromNATURE = fromOfferX;
					break;
				}
			}
		}
		finally{
			
		}
		return fromNATURE;
	}
	
	/**
	 * 
	 * @param fromUser
	 * @throws Exception
	 */
	private void mergeAsOffer( IOVMsgFUser fromUser  ) throws Exception{
		try
		{
			//用户扩展信息
	    	for(java.util.Iterator<IOVMsgFOfferX> itera = fromUser.NATURE.iterator();itera.hasNext();){
				IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
				if( NATURE.indexOf( fromOfferX ) <= 0 ){NATURE.add( new IOVMsgFOfferX( fromOfferX ) );}
			}
	    	//用户客户信息
			if( CUSTOM == null && fromUser.CUSTOM != null ){
				CUSTOM = new IOVMsgFCustom( fromUser.CUSTOM );
			}
			else if( CUSTOM != null && fromUser.CUSTOM != null ){
				CUSTOM.mergeAsCustom( fromUser.CUSTOM );
			}
	    	//定单测订购
	    	for(java.util.Iterator<IOVMsgFOrdCentrex> itera = fromUser.ORDER.iterator();itera.hasNext();){
	    		IOVMsgFOrdCentrex fromCentrex = (IOVMsgFOrdCentrex)itera.next();
	    		mergeAsCentrex( fromCentrex );
	    	}
	    	//用户测订购
	    	for(java.util.Iterator<IOVMsgFPlan> itera = fromUser.CENTREX.iterator();itera.hasNext();){
	    		IOVMsgFPlan fromPlot = (IOVMsgFPlan)itera.next();
	    		if( CENTREX.get( fromPlot ) != null ){ continue; }
	    		if( fromPlot instanceof IOVMsgFUserPlan ){
	    			CENTREX.add( new IOVMsgFUserPlan( fromPlot ) );
	    		}
	    		else if( fromPlot instanceof IOVMsgFOrdPlan ){
	    			CENTREX.add( new IOVMsgFOrdPlan( fromPlot ) );
	    		}
	    		else{
	    			CENTREX.add( new IOVMsgFPlan( fromPlot ) );
	    		}
			}
	    	for(java.util.Iterator<IOVMsgFUserCentrex> itera = fromUser.USER.iterator();itera.hasNext();){
	    		IOVMsgFUserCentrex fromCentrex = (IOVMsgFUserCentrex)itera.next();
	    		mergeAsCentrex( fromCentrex );
			}
	    	//用户组属性
	    	if( fromUser.GROUP != null ){ GROUP = new IOVMsgFGroup( fromUser.GROUP ); }
	    	//工单协作
	    	ClassUtils.IMerge.merge( fromUser.FUTURE, FUTURE, true );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param fromUser
	 * @throws Exception
	 */
	public void mergeAsUser( IOVMsgFUser fromUser ) throws Exception{
		try
		{
			mergeAsOffer( fromUser );
		}
		finally{
			
		}
	}
	
	/**
	 * 当前开通服务订购合并到指定开通资费包中
	 * @param fromOffer
	 */
	public void mergeAsCentrex( IOVMsgFOffer fromOffer ){
		try
		{
			if( fromOffer.isORDER() /*开通定单服务*/){
				IOVMsgFOrdCentrex ordercentrex = (IOVMsgFOrdCentrex)ORDER.get( fromOffer );
	    		if( ordercentrex == null ){ ORDER.add( ordercentrex = new IOVMsgFOrdCentrex( fromOffer ) ); }
	    		ordercentrex.getCENTREX().add( fromOffer );
			}
			else if( fromOffer.isUSER() /*开通用户服务*/ ){
				IOVMsgFUserCentrex usercentrex = (IOVMsgFUserCentrex)USER.get( fromOffer );
	    		if( usercentrex == null ){ USER.add( usercentrex = new IOVMsgFUserCentrex( fromOffer ) ); }
	    		usercentrex.getCENTREX().add( fromOffer );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 当前开通服务订购合并到指定开通资费包中
	 * @param fromCentrex
	 * @throws Exception
	 */
	public void mergeAsCentrex( IOVMsgFCentrex fromCentrex ) throws Exception{
		try
		{
			if( fromCentrex.isORDER() /*开通定单服务*/){
				IOVMsgFOrdCentrex ordercentrex = (IOVMsgFOrdCentrex)ORDER.get( fromCentrex );
	    		if( ordercentrex == null ){ ORDER.add( new IOVMsgFOrdCentrex( fromCentrex ) ); }
	    		else{ ordercentrex.mergeAsCentrex( fromCentrex ); }
			}
			else if( fromCentrex.isUSER() /*开通用户服务*/ ){
				IOVMsgFUserCentrex usercentrex = (IOVMsgFUserCentrex)USER.get( fromCentrex );
	    		if( usercentrex == null ){ USER.add( new IOVMsgFUserCentrex( fromCentrex ) ); }
	    		else{ usercentrex.mergeAsCentrex( fromCentrex ); }
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 开通定单服务产品时序
	 * @throws Exception
	 */
	public void userCentrexLimite() throws Exception{
		//开通定单服务产品时序
		for( java.util.Iterator<IOVMsgFOrdCentrex> itera = ORDER.iterator(); itera.hasNext(); ){
			IOVMsgFOrdCentrex ordercentrex = (IOVMsgFOrdCentrex)itera.next();
			java.util.Collections.sort( ordercentrex.CENTREX );
		}
		java.util.Collections.sort( ORDER );
		//开通用户服务产品时序
		for( java.util.Iterator<IOVMsgFUserCentrex> itera = USER.iterator(); itera.hasNext(); ){
			IOVMsgFUserCentrex usercentrex = (IOVMsgFUserCentrex)itera.next();
			java.util.Collections.sort( usercentrex.CENTREX );
		}
		java.util.Collections.sort( USER );
	}
	
	/**
	 * 是否为群组用户
	 * @return
	 */
    public boolean isGROUP(){
    	return StringUtils.equals( ROLE_ID, IUpdbfsConst.IUpdbm.IRole.GROUP );
    }
    
    /**
     * 是否为群组成员
     * @return
     */
    public boolean isMEMBER(){
    	return StringUtils.equals( ROLE_ID, IUpdbfsConst.IUpdbm.IRole.MEMBER );
    }
    
    /**
	 * @return 用户扩展属性清单
	 */
	public IUserOfferHome getSUBFLOW() {
		return _subflow;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective == null ){
			return false;
		}
		else if( objective instanceof IOVMsgFUser == false ){
			return false;
		}
		else{
			IOVMsgFUser user = (IOVMsgFUser)objective;
			return USER_ID > 0 && user.USER_ID > 0 && USER_ID == user.USER_ID;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try
		{
			doCompare = objective != null && objective instanceof IOVMsgFUser?0:1;
			if( doCompare == 0 ){
				IOVMsgFUser user = (IOVMsgFUser)objective;
				doCompare = USER_ID > 0 && user.USER_ID > 0?(USER_ID - user.USER_ID):1;
			}
		}
		finally{
			
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
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
			org.dom4j.Element _userorder = _root.addElement( "UserOrder" );
			_userorder.addElement("USER_ID"       ).setText( String.valueOf(USER_ID) );
			_userorder.addElement("CATALOG"       ).setText( CATALOG                 );
			_userorder.addElement("BILL_ID"       ).setText( BILL_ID                 );
			_userorder.addElement("SUB_BILL_ID"   ).setText( SUB_BILL_ID             );
			_userorder.addElement("USER_REGION_ID").setText( USER_REGION_ID          );
			_userorder.addElement("REGION_ID"     ).setText( REGION_ID               );
			org.dom4j.Element _usercentrex = _userorder.addElement( "OrderCentrex" );
			for( java.util.Iterator<IOVMsgFOrdCentrex> itera = ORDER.iterator(); itera.hasNext(); ){
				IOVMsgFOrdCentrex usercentrex = (IOVMsgFOrdCentrex)itera.next();
				usercentrex.userCentrexToXml( _usercentrex.addElement( "CENTREX" ) );
			}
			_usercentrex = _userorder.addElement( "UserCentrex" );
			for( java.util.Iterator<IOVMsgFUserCentrex> itera = USER.iterator(); itera.hasNext(); ){
				IOVMsgFUserCentrex usercentrex = (IOVMsgFUserCentrex)itera.next();
				usercentrex.userCentrexToXml( _usercentrex.addElement( "CENTREX" ) );
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

	public static class IUserOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 304340632423781104L;
		public IUserOfferHome(){
    		super();
    	}
    }
}
