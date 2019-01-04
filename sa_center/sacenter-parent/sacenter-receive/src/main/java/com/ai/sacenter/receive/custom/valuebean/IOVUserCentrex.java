package com.ai.sacenter.receive.custom.valuebean;

import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.bo.InsProd;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 用户资费包</p>
 * <p>Copyright: Copyright (c) 2018年4月2日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUserCentrex extends IUpdfmxEntry implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = 4330434395570987878L;
	private long   INS_PROD_ID ;
	private long   INS_OFFER_ID;
	private long   USER_ID     ;
	private String REGION_ID   ;
	private long   PRODUCT_ID  ;
	private String PROD_TYPE   ;
	private String STATUS      ;
	private java.sql.Timestamp EFFECTIVE;
	private java.sql.Timestamp EXPIRE   ;
	private CarbonList<IOVUserOrder> CENTREX = new CarbonList<IOVUserOrder>();
	public IOVUserCentrex() {
		super();
	}
	
	public IOVUserCentrex(IOVUserCentrex centrex) {
		super( centrex );
		INS_PROD_ID  = centrex.INS_PROD_ID ;
		INS_OFFER_ID = centrex.INS_OFFER_ID;
		USER_ID      = centrex.USER_ID     ;
		REGION_ID    = centrex.REGION_ID   ;
		PRODUCT_ID   = centrex.PRODUCT_ID  ;
		PROD_TYPE    = centrex.PROD_TYPE   ;
		STATUS       = centrex.STATUS      ;
		EFFECTIVE    = centrex.EFFECTIVE   ;
		EXPIRE       = centrex.EXPIRE      ;
		for( java.util.Iterator<IOVUserOrder> itera = centrex.CENTREX.iterator(); itera.hasNext(); ){
			IOVUserOrder userorder = (IOVUserOrder)itera.next();
			if( userorder.isVALIDALL() == false ){ continue; }
			CENTREX.add( new IOVUserOrder( userorder ) );
		}
	}
	
	public IOVUserCentrex(InsProd insProd) {
		super();
		INS_PROD_ID  = insProd.getProdInstId             ();
		INS_OFFER_ID = insProd.getOfferInstId            ();
		USER_ID      = insProd.getUserId                 ();
		REGION_ID    = insProd.getRegionId               ();
		PRODUCT_ID   = insProd.getProdId                 ();
		PROD_TYPE    = insProd.getProdType               ();
		STATUS       = String.valueOf( insProd.getState() );
		EFFECTIVE    = insProd.getEffectiveDate          ();
		EXPIRE       = insProd.getExpireDate             ();
	}
	
	public IOVUserCentrex( IOVUserOrder userorder ){
		super( userorder );
		INS_PROD_ID = userorder.getINS_PROD_ID ();
		INS_OFFER_ID= userorder.getINS_OFFER_ID();
		USER_ID     = userorder.getUSER_ID     ();
		PRODUCT_ID  = userorder.getPRODUCT_ID  ();
		PROD_TYPE   = userorder.getPROD_TYPE   ();
		STATUS      = userorder.getSTATUS      ();
		EFFECTIVE   = userorder.getEFFECTIVE   ();
		EXPIRE      = userorder.getEXPIRE      ();
	}
	
	/**
	 * @return 资费编号
	 */
	public long getINS_PROD_ID() {
		return INS_PROD_ID;
	}

	/**
	 * @param iNS_PROD_ID 资费编号
	 */
	public void setINS_PROD_ID(long iNS_PROD_ID) {
		INS_PROD_ID = iNS_PROD_ID;
	}

	/**
	 * @return 策划编号
	 */
	public long getINS_OFFER_ID() {
		return INS_OFFER_ID;
	}

	/**
	 * @param iNS_OFFER_ID 策划编号
	 */
	public void setINS_OFFER_ID(long iNS_OFFER_ID) {
		INS_OFFER_ID = iNS_OFFER_ID;
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
	 * @return 用户地市编号
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}

	/**
	 * @param rEGION_ID 用户地市编号
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}

	/**
	 * @return 产品编号
	 */
	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	/**
	 * @param pRODUCT_ID 产品编号
	 */
	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	
	/**
	 * @return 产品类型
	 */
	public String getPROD_TYPE() {
		return PROD_TYPE;
	}

	/**
	 * @param pROD_TYPE 产品类型
	 */
	public void setPROD_TYPE(String pROD_TYPE) {
		PROD_TYPE = pROD_TYPE;
	}

	/**
	 * @return 资费状态
	 */
	public String getSTATUS() {
		return STATUS;
	}

	/**
	 * @param sTATUS 资费状态
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
	 * @return 服务产品
	 */
	public CarbonList<IOVUserOrder> getCENTREX() {
		return CENTREX;
	}

	/**
	 * 根据服务编号获取用户服务产品订购
	 * @param aSERVICE_ID 服务编号
	 * @return
	 */
	public IOVUserOrder getCENTREX( long aSERVICE_ID ){
		IOVUserOrder fromOrder = null;
		try
		{
			for( java.util.Iterator<IOVUserOrder> itera = CENTREX.iterator(); itera.hasNext(); ){
				IOVUserOrder fromUserOrder = (IOVUserOrder)itera.next();
				if( fromUserOrder.getSERVICE_ID() == aSERVICE_ID ){
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
	 * 根据服务编号获取用户服务产品订购
	 * @param userorder 服务产品
	 * @return
	 */
	public IOVUserOrder getCENTREX( IOVUserOrder userorder ){
		return (IOVUserOrder)CENTREX.get( userorder );
	}
	
	/**
	 * 订购退订服务产品
	 * @param userorder
	 */
	public void orderAsCentrex( IOVUserOrder userorder ){
		EXPIRE = userorder.getEXPIRE();
		STATUS = userorder.getSTATUS();
		if( userorder.isVALIDALL() == false /*已失效[退订服务资源包]*/){
			IOVUserOrder _userorder = (IOVUserOrder)CENTREX.get( userorder );
			if( _userorder != null ){ CENTREX.remove( _userorder ); }
		}
		else/*本周期/下周期有效*/{
			IOVUserOrder _userorder = (IOVUserOrder)CENTREX.get( userorder );
			if( _userorder == null ){ CENTREX.add( new IOVUserOrder( userorder ) ); }
			else{ _userorder.orderAsCentrex( userorder ); }
		}
	}
	
	/**
	 * 是否有效类型有效
	 * @param _validtype 有效类型
	 * @param _currentdate 当前时间
	 * @return
	 */
	public boolean isVALID( int _validtype, java.sql.Timestamp _currentdate ){
		boolean _validall = false;
		try
		{
			if( _validtype == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NOW ){
				_validall = isVALIDNOW( _currentdate );
			}
			else if( _validtype == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NEXT ){
				_validall = isVALIDNEXT( _currentdate );
			}
			else if( _validtype == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ){
				_validall = isVALIDALL( _currentdate );
			}
			else if( _validtype == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_EXPIRED ){
				_validall = isVALIDEXPIRED( _currentdate );
			}
		}
		finally{
			
		}
		return _validall;
	}
	
	/**
	 * 是否本周期有效
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDNOW( java.sql.Timestamp _currentdate ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.middle( EFFECTIVE, _currentdate, EXPIRE );
	}
	
	/**
	 * 是否下周期有效
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDNEXT( java.sql.Timestamp _currentdate ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EFFECTIVE, _currentdate );
	}
	
	/**
	 * 服务资费是否当前时间有效[本周期和下周期[失效时间大于生效时间,失效时间大于系统时间]]
	 * @return
	 */
	public boolean isVALIDALL(){
		java.sql.Timestamp __sysdate = TimeUtils.getSysdate();
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, __sysdate );
	}
	
	/**
	 * 是否下周期有效
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDALL( java.sql.Timestamp _currentdate ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, _currentdate );
	}
	
	/**
	 * 是否下周期有效
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDEXPIRED( java.sql.Timestamp _currentdate ){
		return TimeUtils.greaterEqual( _currentdate, EXPIRE );
	}
	
	/**
	 * 是否正常资费包
	 * @return
	 */
	public boolean isNORMAL(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S01 );
	}
	
	/**
	 * 是否暂停资费包
	 * @return
	 */
	public boolean isSUSPEND(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S03 );
	}
	
	/**
	 * 
	 * @param usercentrex
	 * @throws Exception
	 */
	public void userCentrexToXml( org.dom4j.Element usercentrex ) throws Exception{
		try
		{
			usercentrex.addElement("INS_PROD_ID").setText( String.valueOf( INS_PROD_ID         ) );
			usercentrex.addElement("PRODUCT_ID" ).setText( String.valueOf( PRODUCT_ID          ) );
			usercentrex.addElement("STATUS"     ).setText( String.valueOf( STATUS              ) );
			usercentrex.addElement("EFFECTIVE"  ).setText( TimeUtils.yyyymmddhhmmss( EFFECTIVE ) );
			usercentrex.addElement("EXPIRE"     ).setText( TimeUtils.yyyymmddhhmmss( EXPIRE    ) );
			for( java.util.Iterator<IOVUserOrder> itera = CENTREX.iterator(); itera.hasNext(); ){
				IOVUserOrder useroffer = (IOVUserOrder)itera.next();
				useroffer.userOfferToXML( usercentrex.addElement( "COMPETE" ) );
			}
		}
		finally{
			
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective == null ){
			return false;
		}
		else if( objective instanceof IOVUserOrder ){
			IOVUserOrder _offer = (IOVUserOrder)objective;
			return INS_PROD_ID > 0 && _offer.getINS_PROD_ID() > 0 && INS_PROD_ID == _offer.getINS_PROD_ID();
		}
		else if( objective instanceof IOVUserCentrex ){
			IOVUserCentrex _cabinet = (IOVUserCentrex)objective;
			return INS_PROD_ID > 0 && _cabinet.INS_PROD_ID > 0 && INS_PROD_ID == _cabinet.INS_PROD_ID;
		}
		else{
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try
		{
			doCompare = objective != null && objective instanceof IOVUserCentrex?0:1;
			if( doCompare == 0 ){
				IOVUserCentrex _cabinet = (IOVUserCentrex)objective;
				doCompare = INS_PROD_ID > 0 && _cabinet.INS_PROD_ID > 0?0:1;
				if( doCompare == 0 ){ doCompare = INS_PROD_ID - _cabinet.INS_PROD_ID; }
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
			userCentrexToXml( _root.addElement( "CENTREX" ) );
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
