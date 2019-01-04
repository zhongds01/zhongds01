package com.ai.sacenter.receive.custom.valuebean;

import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: �û���Ϣ</p>
 * <p>Copyright: Copyright (c) 2016��3��22��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUser extends IUpdfmxEntry implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = -6795233982102437567L;
	private long   USER_ID     ;
	private String CATALOG     ;
	private long   CUST_ID     ;
	private String CUST_TYPE   ;
	private String BILL_ID     ;
	private String REGION_ID   ;
	private String SUB_BILL_ID ;
	private String STATUS      ;
	private String OS_STATUS   ;
	private String IS_OUT_NET  ;
	private String BRAND_ID    ;
	private String USER_TYPE   ;
	private String NOTICE_FLAG ;
	private String RISK_FLAG   ;
	private String COUNTRY_CODE;
	private long   ADDRESS_ID  ;
	private String ADDRESS_DESC;
    private java.sql.Timestamp EFFECTIVE;
    private java.sql.Timestamp EXPIRE   ;
    private IOVCustom CUSTOM = null;
    private CarbonList<IOVUserOfferX> NATURE = new CarbonList<IOVUserOfferX>();
    private CarbonList<IOVUserOffer>  OFFER  = null;
    private CarbonList<IOVUserCentrex>  ORDER  = null;
    private CarbonList<IOVUserOrderOffer> GROUP  = null;
    public IOVUser() {
		super();
	}
    
    public IOVUser( IOVUser user ) {
		super( user );
		USER_ID      = user.USER_ID      ;
		CATALOG      = user.CATALOG      ;
		CUST_ID      = user.CUST_ID      ;
		CUST_TYPE    = user.CUST_TYPE    ;
		BILL_ID      = user.BILL_ID      ;
		REGION_ID    = user.REGION_ID    ;
		SUB_BILL_ID  = user.SUB_BILL_ID  ;
		STATUS       = user.STATUS       ;
		OS_STATUS    = user.OS_STATUS    ;
		IS_OUT_NET   = user.IS_OUT_NET   ;
		BRAND_ID     = user.BRAND_ID     ;
		USER_TYPE    = user.USER_TYPE    ;
		NOTICE_FLAG  = user.NOTICE_FLAG  ;
		RISK_FLAG    = user.RISK_FLAG    ;
		COUNTRY_CODE = user.COUNTRY_CODE ;
		ADDRESS_ID   = user.ADDRESS_ID   ;
		ADDRESS_DESC = user.ADDRESS_DESC ;
		EFFECTIVE    = user.EFFECTIVE    ;
		EXPIRE       = user.EXPIRE       ;
		if( CUSTOM != null ){ CUSTOM = new IOVCustom( user.CUSTOM ); }
		for( java.util.Iterator<IOVUserOfferX> itera = user.NATURE.iterator(); itera.hasNext(); ){
			IOVUserOfferX fromOfferX = (IOVUserOfferX)itera.next();
			NATURE.add( new IOVUserOfferX( fromOfferX ) );
		}
		
		if( user.OFFER != null ){
			OFFER = new CarbonList<IOVUserOffer>();
			for( java.util.Iterator<IOVUserOffer> itera = user.OFFER.iterator(); itera.hasNext(); ){
				IOVUserOffer useroffer = (IOVUserOffer)itera.next();
				OFFER.add( new IOVUserOffer( useroffer ) );
			}
		}
		
		if( user.ORDER != null ){
			ORDER = new CarbonList<IOVUserCentrex>();
			for( java.util.Iterator<IOVUserCentrex> itera = user.ORDER.iterator(); itera.hasNext(); ){
				IOVUserCentrex userorder = (IOVUserCentrex)itera.next();
				ORDER.add( new IOVUserCentrex( userorder ) );
			}
		}
		
		if( user.GROUP != null ){
			GROUP = new CarbonList<IOVUserOrderOffer>();
			for( java.util.Iterator<IOVUserOrderOffer> itera = user.GROUP.iterator(); itera.hasNext(); ){
				IOVUserOrderOffer usergroup = (IOVUserOrderOffer)itera.next();
				GROUP.add( new IOVUserOrderOffer( usergroup ) );
			}
		}
		
	}
    
	/**
	 * @return �û����
	 */
	public long getUSER_ID() {
		return USER_ID;
	}
	
	/**
	 * @param uSER_ID �û����
	 */
	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	/**
	 * @return ��Ʒ����
	 */
	public String getCATALOG() {
		return CATALOG;
	}
	
	/**
	 * @param cATALOG ��Ʒ����
	 */
	public void setCATALOG(String cATALOG) {
		CATALOG = cATALOG;
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
	 * @return �û�����
	 */
	public String getBILL_ID() {
		return BILL_ID;
	}
	
	/**
	 * @param bILL_ID �û�����
	 */
	public void setBILL_ID(String bILL_ID) {
		BILL_ID = bILL_ID;
	}
	
	/**
	 * @return �û�����
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}
	
	/**
	 * @param rEGION_ID �û�����
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	
	/**
	 * @return �μƷѺ�
	 */
	public String getSUB_BILL_ID() {
		return SUB_BILL_ID;
	}
	
	/**
	 * @param sUB_BILL_ID �μƷѺ�
	 */
	public void setSUB_BILL_ID(String sUB_BILL_ID) {
		SUB_BILL_ID = sUB_BILL_ID;
	}
	
	/**
	 * @return �û�״̬
	 */
	public String getSTATUS() {
		return STATUS;
	}
	
	/**
	 * @param sTATUS �û�״̬
	 */
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	/**
	 * @return �û�ͣ��λ
	 */
	public String getOS_STATUS() {
		return OS_STATUS;
	}
	
	/**
	 * @param oS_STATUS �û�ͣ��λ
	 */
	public void setOS_STATUS(String oS_STATUS) {
		OS_STATUS = oS_STATUS;
	}
	
	/**
	 * @return �Ƿ������û�
	 */
	public String getIS_OUT_NET() {
		return IS_OUT_NET;
	}
	/**
	 * @param iS_OUT_NET �Ƿ������û�
	 */
	public void setIS_OUT_NET(String iS_OUT_NET) {
		IS_OUT_NET = iS_OUT_NET;
	}
	
	/**
	 * @return �û�Ʒ��
	 */
	public String getBRAND_ID() {
		return BRAND_ID;
	}
	
	/**
	 * @param bRAND_ID �û�Ʒ��
	 */
	public void setBRAND_ID(String bRAND_ID) {
		BRAND_ID = bRAND_ID;
	}
	
	/**
	 * @return �û�����
	 */
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	
	/**
	 * @param uSER_TYPE �û�����
	 */
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	
	/**
	 * @return ��ͣ��־
	 */
	public String getNOTICE_FLAG() {
		return NOTICE_FLAG;
	}
	
	/**
	 * @param nOTICE_FLAG ��ͣ��־
	 */
	public void setNOTICE_FLAG(String nOTICE_FLAG) {
		NOTICE_FLAG = nOTICE_FLAG;
	}
	
	/**
	 * @return ���տ����û���ʶ
	 */
	public String getRISK_FLAG() {
		return RISK_FLAG;
	}
	
	/**
	 * @param rISK_FLAG ���տ����û���ʶ
	 */
	public void setRISK_FLAG(String rISK_FLAG) {
		RISK_FLAG = rISK_FLAG;
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
	 * @return ��ַ���
	 */
	public long getADDRESS_ID() {
		return ADDRESS_ID;
	}

	/**
	 * @param aDDRESS_ID ��ַ���
	 */
	public void setADDRESS_ID(long aDDRESS_ID) {
		ADDRESS_ID = aDDRESS_ID;
	}

	/**
	 * @return ��ϸ��ַ
	 */
	public String getADDRESS_DESC() {
		return ADDRESS_DESC;
	}

	/**
	 * @param aDDRESS_DESC ��ϸ��ַ
	 */
	public void setADDRESS_DESC(String aDDRESS_DESC) {
		ADDRESS_DESC = aDDRESS_DESC;
	}

	/**
	 * @return ��Ч����
	 */
	public java.sql.Timestamp getEFFECTIVE() {
		return EFFECTIVE;
	}
	
	/**
	 * @param eFFECTIVE ��Ч����
	 */
	public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
		EFFECTIVE = eFFECTIVE;
	}
	
	/**
	 * @return ʧЧ����
	 */
	public java.sql.Timestamp getEXPIRE() {
		return EXPIRE;
	}
	
	/**
	 * @param eXPIRE ʧЧ����
	 */
	public void setEXPIRE(java.sql.Timestamp eXPIRE) {
		EXPIRE = eXPIRE;
	}
	
	/**
	 * @return �û��߻�
	 */
	public CarbonList<IOVUserOffer> getOFFER() {
		return OFFER;
	}
	
	/**
	 * ���ݲ߻�ʵ����Ż�ȡ�û��߻�
	 * @param aInsOfferId
	 * @return
	 */
	public IOVUserOffer getOFFER( long aInsOfferId ){
		IOVUserOffer useroffer = null;
		try
		{
			for( int index = 0; OFFER != null && index < OFFER.size(); index++ ){
				IOVUserOffer fromUserOffer = (IOVUserOffer)OFFER.get( index );
				if( fromUserOffer.getINS_OFFER_ID() == aInsOfferId ){
					useroffer = fromUserOffer;
					break;
				}
			}
		}
		finally{
			
		}
		return useroffer;
	}

	/**
	 * ָ��ʱ�䱾�����ײ�
	 * @param _currentdate ��Чʱ��
	 * @return
	 */
	public IOVUserOffer getOFFER( java.sql.Timestamp _currentdate ){
		IOVUserOffer useroffer = null;
		try
		{
			for( int index = 0; OFFER != null && index < OFFER.size(); index++ ){
				IOVUserOffer fromUserOffer = (IOVUserOffer)OFFER.get( index );
				if( fromUserOffer.isOfferPlan() && fromUserOffer.isVALIDNOW( _currentdate ) ){
					useroffer = fromUserOffer;
					break;
				}
			}
		}
		finally{
			
		}
		return useroffer;
	}
	
	/**
	 * @param oFFER �û��߻�
	 */
	public void setOFFER(CarbonList<IOVUserOffer> oFFER) {
		OFFER = oFFER;
	}
	
	/**
	 * @return �û���Ʒ
	 */
	public CarbonList<IOVUserCentrex> getORDER() {
		return ORDER;
	}
	
	/**
	 * 
	 * @param aINS_PROD_ID �û���Ʒ
	 * @return
	 */
	public IOVUserCentrex getORDER( long aINS_PROD_ID ){
		IOVUserCentrex fromOrder = null;
		try
		{
			for( int index = 0; ORDER != null && index < ORDER.size(); index++ ){
				IOVUserCentrex fromUserOrder = (IOVUserCentrex)ORDER.get( index );
				if( fromUserOrder.getINS_PROD_ID() == aINS_PROD_ID ){
					fromOrder = fromUserOrder;
					break;
				}
			}
		}
		finally{
			
		}
		return fromOrder;
	}
	
	/**
	 * �����û��ʷѰ���ȡ��ǰ�û���Ӧ�ʷѰ�
	 * @param _usercentrex
	 * @return
	 */
	public IOVUserCentrex getORDER( IOVUserCentrex _usercentrex ){
		IOVUserCentrex usercentrex = null;
		try
		{
			if( _usercentrex.getINS_PROD_ID() > 0 ){ 
				usercentrex = (IOVUserCentrex)ORDER.get( _usercentrex );
			}
		}
		finally{
			
		}
		return usercentrex;
	}
	
	/**
	 * 
	 * @param aINS_PROD_ID �û���Ʒ
	 * @param aSERVICE_ID ������
	 * @return
	 */
	public IOVUserOrder getORDER( long aINS_PROD_ID, long aSERVICE_ID ){
		IOVUserOrder fromOrder = null;
		try
		{
			for( int index = 0; ORDER != null && index < ORDER.size(); index++ ){
				IOVUserCentrex fromUserOrder = (IOVUserCentrex)ORDER.get( index );
				if( fromUserOrder.getINS_PROD_ID() == aINS_PROD_ID ){
					fromOrder = fromUserOrder.getCENTREX( aSERVICE_ID );
				}
			}
		}
		finally{
			
		}
		return fromOrder;
	}
	
	/**
	 * @param oRDER �û���Ʒ
	 */
	public void setORDER(CarbonList<IOVUserCentrex> oRDER) {
		ORDER = oRDER;
	}
	
	/**
	 * @return �û������߻�
	 */
	public CarbonList<IOVUserOrderOffer> getGROUP() {
		return GROUP;
	}
	
	/**
	 * ���ݲ߻�ʵ����Ż��û�Ⱥ���ϵ
	 * @param aInsOfferId
	 * @return
	 */
	public IOVUserOrderOffer getGROUP( long aInsOfferId ){
		try
		{
			for( java.util.Iterator<IOVUserOrderOffer> itera = GROUP.iterator(); itera.hasNext(); ){
				IOVUserOrderOffer fromOffer = (IOVUserOrderOffer)itera.next();
				if( fromOffer.getINS_OFFER_ID() == aInsOfferId ){
					return fromOffer;
				}
			}
		}
		finally{
			
		}
		return null;
	}
	
	/**
	 * @param gROUP �û������߻�
	 */
	public void setGROUP(CarbonList<IOVUserOrderOffer> gROUP) {
		GROUP = gROUP;
	}
	
	/**
	 * @return �û��ͻ�
	 */
	public IOVCustom getCUSTOM() {
		return CUSTOM;
	}
	
	/**
	 * @param cUSTOM �û��ͻ�
	 */
	public void setCUSTOM(IOVCustom cUSTOM) {
		CUSTOM    = cUSTOM;
		CUST_ID   = cUSTOM != null?cUSTOM.getCUST_ID  ():-1  ;
		CUST_TYPE = cUSTOM != null?cUSTOM.getCUST_TYPE():null;
	}
	
	/**
	 * @return �û���չ����
	 */
	public CarbonList<IOVUserOfferX> getNATURE() {
		return NATURE;
	}
	
	/**
	 * 
	 * @param aATTR_ID
	 * @return
	 */
	public IOVUserOfferX getNATURE( String aATTR_ID ){
		IOVUserOfferX userofferx = null;
		try
		{
			for( java.util.Iterator<IOVUserOfferX> itera = NATURE.iterator(); itera.hasNext(); ){
				IOVUserOfferX aUserOfferX = (IOVUserOfferX)itera.next();
				if( StringUtils.equals( aUserOfferX.getATTR_ID(), aATTR_ID ) ){
					userofferx = aUserOfferX;
					break;
				}
			}
		}
		finally{
			
		}
		return userofferx;
	}
	
	/**
	 * 
	 * @param usercentrex
	 */
	public void orderAsCentrex( IOVUserCentrex usercentrex ){
		for( java.util.Iterator<IOVUserOrder> itera = usercentrex.getCENTREX().iterator(); itera.hasNext(); ){
			IOVUserOrder userorder = (IOVUserOrder)itera.next();
			IOVUserCentrex _usercentrex = (IOVUserCentrex)ORDER.get( userorder );
			if( userorder.isVALIDALL() /*������/��������Ч*/){
				if( _usercentrex == null ){ ORDER.add( _usercentrex = new IOVUserCentrex( userorder ) ); }
				_usercentrex.orderAsCentrex( userorder );
			}
			else if( _usercentrex != null )/*��ʧЧ[�˶�������Դ��]*/{
				_usercentrex.orderAsCentrex( userorder);
				if( _usercentrex.getCENTREX().size()<= 0 ){ ORDER.remove( _usercentrex ); }
			}
		}
	}
	
	/**
	 * 
	 * @param usercentrex
	 * @param ordercentrex
	 */
	public void userAsCentrex( IOVUserCentrex usercentrex, IOVUserCentrex ordercentrex ){
		IOVUserCentrex _usercentrex = (IOVUserCentrex)ORDER.get( usercentrex );
		if( _usercentrex != null ){
			for( java.util.Iterator<IOVUserOrder> itera = usercentrex.getCENTREX().iterator(); itera.hasNext(); ){
				IOVUserOrder useroffer = (IOVUserOrder)itera.next();
				if( useroffer.isVALIDALL() == false ){ continue; }
				IOVUserOrder _orderoffer = ordercentrex.getCENTREX( useroffer.getSERVICE_ID() );
				IOVUserOrder _useroffer  = _usercentrex.getCENTREX( useroffer.getSERVICE_ID() );
				if( _orderoffer == null /*���������Ʒ*/){
					_usercentrex.orderAsCentrex( useroffer );
				}
				else if( _useroffer != null && _orderoffer.isVALIDALL()/*�ϲ���������*/){
					_useroffer.userAsCentrex( useroffer, _orderoffer );
				}
			}
		}
	}
	
	/**
	 * 
	 * @param aUserOfferX
	 */
	public void mergeAsNature( IOVUserOfferX aUserOfferX ){
		IOVUserOfferX userofferx = (IOVUserOfferX)NATURE.get( aUserOfferX );
		if( userofferx == null ){ 
			NATURE.add( new IOVUserOfferX( aUserOfferX ) ); 
		}
		else if( StringUtils.equals( userofferx.getATTR_VALUE(), aUserOfferX.getATTR_VALUE() ) == false ){
			userofferx.mergeAsGroup( aUserOfferX );
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective == null ){
			return false;
		}
		else if( objective instanceof IOVUser == false ){
			return false;
		}
		else{
			IOVUser user = (IOVUser)objective;
			return USER_ID == user.USER_ID;
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
				IOVUser user = (IOVUser)objective;
				doCompare = USER_ID - user.USER_ID;
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
			_userorder.addElement("USER_ID"       ).setText( String.valueOf(USER_ID)            );
			_userorder.addElement("CATALOG"       ).setText( CATALOG                            );
			_userorder.addElement("BILL_ID"       ).setText( BILL_ID                            );
			_userorder.addElement("SUB_BILL_ID"   ).setText( SUB_BILL_ID != null?SUB_BILL_ID:"" );
			_userorder.addElement("OS_STATUS"     ).setText( OS_STATUS != null?OS_STATUS:""     );
			_userorder.addElement("USER_REGION_ID").setText( REGION_ID                          );
			/*if( NATURE != null && NATURE.size() > 0 ){
				org.dom4j.Element _userextinfo = _userorder.addElement( "UserExtInfo" );
				for( java.util.Iterator<IOVUserOfferX> itera = NATURE.iterator(); itera.hasNext(); ){
					IOVUserOfferX _userofferx = (IOVUserOfferX)itera.next();
					_userofferx.userOfferXToXML( _userextinfo.addElement( "AttrInfo" ) );
				}
			}*/
			org.dom4j.Element _usercentrex = _userorder.addElement( "UserCentrex" );
			for( java.util.Iterator<IOVUserCentrex> itera = ORDER.iterator(); itera.hasNext(); ){
				IOVUserCentrex usercentrex = (IOVUserCentrex)itera.next();
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
}
