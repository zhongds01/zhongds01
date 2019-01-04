package com.ai.sacenter.receive.custom.valuebean;

import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 用户服务产品</p>
 * <p>Copyright: Copyright (c) 2016年3月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUserOrder extends IUpdfmxEntry implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = -7243309080227567446L;
	private long   INS_SERV_ID ;
	private long   INS_PROD_ID ;
	private long   INS_OFFER_ID;
	private long   USER_ID     ;
	private long   SERVICE_ID  ;
	private long   PRODUCT_ID  ;
	private String PROD_TYPE   ;
	private String STATUS      ;
	private java.sql.Timestamp   EFFECTIVE;
	private java.sql.Timestamp   EXPIRE   ;
	private IOVUserOrderOffer    GROUP    ;
	private CarbonList<IOVUserOfferX> FUTURE = new CarbonList<IOVUserOfferX>(); 
	public IOVUserOrder() {
		super();
	}
	
	public IOVUserOrder( IOVUserOrder userorder ) {
		super( userorder );
		INS_SERV_ID  = userorder.INS_SERV_ID ;
		INS_PROD_ID  = userorder.INS_PROD_ID ;
		INS_OFFER_ID = userorder.INS_OFFER_ID;
		USER_ID      = userorder.USER_ID     ;
		SERVICE_ID   = userorder.SERVICE_ID  ;
		PRODUCT_ID   = userorder.PRODUCT_ID  ;
		PROD_TYPE    = userorder.PROD_TYPE   ;
		STATUS       = userorder.STATUS      ;
		EFFECTIVE    = userorder.EFFECTIVE   ;
		EXPIRE       = userorder.EXPIRE      ;
		if( userorder.GROUP != null ){ GROUP = new IOVUserOrderOffer( userorder.GROUP ); }
		for( java.util.Iterator<IOVUserOfferX> itera = userorder.FUTURE.iterator(); itera.hasNext(); ){
			IOVUserOfferX userofferx = (IOVUserOfferX)itera.next();
			if( userofferx.isVALIDALL() == false ){ continue; }
			FUTURE.add( new IOVUserOfferX( userofferx ) );
		}
	}
	
	/**
	 * @return the iNS_SERV_ID
	 */
	public long getINS_SERV_ID() {
		return INS_SERV_ID;
	}

	/**
	 * @param iNS_SERV_ID the iNS_SERV_ID to set
	 */
	public void setINS_SERV_ID(long iNS_SERV_ID) {
		INS_SERV_ID = iNS_SERV_ID;
	}

	/**
	 * @return the iNS_PROD_ID
	 */
	public long getINS_PROD_ID() {
		return INS_PROD_ID;
	}
	
	/**
	 * @param iNS_PROD_ID the iNS_PROD_ID to set
	 */
	public void setINS_PROD_ID(long iNS_PROD_ID) {
		INS_PROD_ID = iNS_PROD_ID;
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
	 * @return the sERVICE_ID
	 */
	public long getSERVICE_ID() {
		return SERVICE_ID;
	}
	
	/**
	 * @param sERVICE_ID the sERVICE_ID to set
	 */
	public void setSERVICE_ID(long sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
	}
	
	/**
	 * @return the pRODUCT_ID
	 */
	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	
	/**
	 * @param pRODUCT_ID the pRODUCT_ID to set
	 */
	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	
	/**
	 * @return the pROD_TYPE
	 */
	public String getPROD_TYPE() {
		return PROD_TYPE;
	}
	
	/**
	 * @param pROD_TYPE the pROD_TYPE to set
	 */
	public void setPROD_TYPE(String pROD_TYPE) {
		PROD_TYPE = pROD_TYPE;
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
	 * @return the gROUP
	 */
	public IOVUserOrderOffer getGROUP() {
		return GROUP;
	}
	
	/**
	 * @param gROUP the gROUP to set
	 */
	public void setGROUP(IOVUserOrderOffer gROUP) {
		GROUP = gROUP;
	}
	
	/**
	 * @return the fUTURE
	 */
	public CarbonList<IOVUserOfferX> getFUTURE() {
		return FUTURE;
	}
	
	/**
	 * @return the userofferx
	 */
	public IOVUserOfferX getFUTURE( IOVUserOfferX userofferx ) {
		return (IOVUserOfferX)FUTURE.get( userofferx );
	}
	
	/**
	 * 订购退订服务产品
	 * @param userorder
	 */
	public void orderAsCentrex( IOVUserOrder userorder ){
		EXPIRE = userorder.getEXPIRE();
		STATUS = userorder.getSTATUS();
		if( userorder.GROUP != null ){ GROUP = new IOVUserOrderOffer( userorder.GROUP ); }
		for( java.util.Iterator<IOVUserOfferX> itera = userorder.FUTURE.iterator(); itera.hasNext(); ){
			IOVUserOfferX userofferx = (IOVUserOfferX)itera.next();
			IOVUserOfferX _userofferx = getFUTURE( userofferx );
			if( userofferx.isVALIDALL() == false ){
				if( _userofferx != null ){ FUTURE.remove( _userofferx ); }
			}
			else if( _userofferx == null ){ 
				FUTURE.add( new IOVUserOfferX( userofferx ) ); 
			}
			else{
				_userofferx.mergeAsGroup( userofferx );
			}
		}
	}
	
	/**
	 * 合并服务产品属性[如用户测无服务产品属性则订购服务产品属性]
	 * @param userorder
	 */
	public void userAsCentrex( IOVUserOrder userorder ){
		if( userorder.GROUP != null && GROUP == null ){ GROUP = new IOVUserOrderOffer( userorder.GROUP ); }
		for( java.util.Iterator<IOVUserOfferX> itera = userorder.FUTURE.iterator(); itera.hasNext(); ){
			IOVUserOfferX userofferx = (IOVUserOfferX)itera.next();
			IOVUserOfferX _userofferx = getFUTURE( userofferx );
			if( _userofferx == null ){ FUTURE.add( new IOVUserOfferX( userofferx ) ); }
		}
	}
	
	/**
	 * 合并服务产品属性[如用户测无服务产品属性则订购服务产品属性]
	 * @param userorder
	 * @param orderoffer
	 */
	public void userAsCentrex( IOVUserOrder useroffer, IOVUserOrder orderoffer ){
		if( useroffer.GROUP != null && GROUP == null ){ GROUP = new IOVUserOrderOffer( useroffer.GROUP ); }
		for( java.util.Iterator<IOVUserOfferX> itera = useroffer.FUTURE.iterator(); itera.hasNext(); ){
			IOVUserOfferX userofferx = (IOVUserOfferX)itera.next();
			IOVUserOfferX _userofferx = getFUTURE( userofferx );
			IOVUserOfferX _orderofferx = orderoffer.getFUTURE( userofferx );
			if( _userofferx == null && _orderofferx == null ){
				FUTURE.add( new IOVUserOfferX( userofferx ) );
			}
		}
	}
	
	/**
	 * 
	 * @param _centrex
	 */
	public void userOfferToXML( org.dom4j.Element _centrex ){
		try
		{
			_centrex.addElement("INS_PROD_ID").setText( String.valueOf( INS_PROD_ID         ) );
			_centrex.addElement("SERVICE_ID" ).setText( String.valueOf( SERVICE_ID          ) );
			_centrex.addElement("PRODUCT_ID" ).setText( String.valueOf( PRODUCT_ID          ) );
			_centrex.addElement("STATUS"     ).setText( String.valueOf( STATUS              ) );
			_centrex.addElement("PROD_TYPE"  ).setText( PROD_TYPE                             );
			_centrex.addElement("EFFECTIVE"  ).setText( TimeUtils.yyyymmddhhmmss( EFFECTIVE ) );
			_centrex.addElement("EXPIRE"     ).setText( TimeUtils.yyyymmddhhmmss( EXPIRE    ) );
			if( FUTURE != null && FUTURE.size() > 0 ){
				org.dom4j.Element _extinfo = _centrex.addElement( "FUTURE" );
				for( java.util.Iterator<IOVUserOfferX> itera = FUTURE.iterator(); itera.hasNext(); ){
					IOVUserOfferX fromOfferX = (IOVUserOfferX)itera.next();
					fromOfferX.userOfferXToXML( _extinfo.addElement( "FUTURE" ) );
				}
			}
			
		}
		finally{
			
		}
	}
	
	/**
	 * 是否为群组订购
	 * @return
	 */
	public boolean isGROUP(){
		return StringUtils.equals( PROD_TYPE, IUpdbfsConst.IUpdbm.IProdType.GROUP );
	}
	
	/**
	 * 是否用户服务产品正常
	 * @return
	 */
	public boolean isNORMAL(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S01 );
	}
	
	/**
	 * 是否暂停服务产品
	 * @return
	 */
	public boolean isSUSPEND(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S03 );
	}
	
	/**
	 * 服务产品是否有效
	 * @return
	 */
	public boolean isVALID( ){
		return StringUtils.isBlank( STATUS ) == false && TimeUtils.greater( EXPIRE, EFFECTIVE );
	}
	
	/**
	 * 是否有效类型有效
	 * @param _validtype 有效类型
	 * @param _currentdate 当前时间
	 * @return
	 */
	public boolean isVALID( int _validtype, java.sql.Timestamp _currentdate ){
		boolean fromVALIDY = false;
		try
		{
			if( _validtype == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NOW ){
				fromVALIDY = isVALIDNOW( _currentdate );
			}
			else if( _validtype == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NEXT ){
				fromVALIDY = isVALIDNEXT( _currentdate );
			}
			else if( _validtype == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ){
				fromVALIDY = isVALIDALL( _currentdate );
			}
			else if( _validtype == IUpdbfsConst.IEnum.IEffective.VALID_TYPE_EXPIRED ){
				fromVALIDY = isVALIDEXPIRED( _currentdate );
			}
		}
		finally{
			
		}
		return fromVALIDY;
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
	 * 是否下周期有效
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDALL( java.sql.Timestamp _currentdate ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, _currentdate );
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
	 * 是否无效订购
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDEXPIRED( java.sql.Timestamp _currentdate ){
		return TimeUtils.greaterEqual( _currentdate, EXPIRE ) || TimeUtils.greaterEqual( EFFECTIVE, EXPIRE );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective == null ){
			return false;
		}
		else if( objective instanceof IOVUserOrder == false ){
			return false;
		}
		else{
			IOVUserOrder offer = (IOVUserOrder)objective;
			boolean _equal = INS_PROD_ID > 0 && offer.INS_PROD_ID > 0 && INS_PROD_ID == offer.INS_PROD_ID;
			if( _equal == true ){ _equal = SERVICE_ID == offer.SERVICE_ID ; }
			return _equal;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try
		{
			doCompare = objective != null && objective instanceof IOVUserOrder?0:1;
			if( doCompare == 0 ){
				IOVUserOrder offer = (IOVUserOrder)objective;
				doCompare = INS_PROD_ID > 0 && offer.INS_PROD_ID > 0?(INS_PROD_ID - offer.INS_PROD_ID):1;
				if( doCompare == 0 ){ doCompare = SERVICE_ID - offer.SERVICE_ID; }
			}
		}
		finally{
			
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}

}
