package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通资费包</p>
 * <p>Copyright: Copyright (c) 2018年4月3日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVMsgFCentrex implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = 6971058904660522328L;
	private long   INS_PROD_ID ;
	private long   USER_ID     ;
	private String REGION_ID   ;
	private long   PRODUCT_ID  ;
	private String STATUS      ;
	private java.sql.Timestamp EFFECTIVE;
	private java.sql.Timestamp EXPIRE   ;
	protected CarbonList<IOVMsgFOffer> CENTREX = new CarbonList<IOVMsgFOffer>();
	public IOVMsgFCentrex() {
		super();
	}
	
	public IOVMsgFCentrex( IOVMsgFOffer centrex ){
		super();
		INS_PROD_ID = centrex.getINS_PROD_ID ();
		USER_ID     = centrex.getUSER_ID     ();
		PRODUCT_ID  = centrex.getPRODUCT_ID  ();
		STATUS      = centrex.getSTATUS      ();
		EFFECTIVE   = centrex.getEFFECTIVE   ();
		EXPIRE      = centrex.getEXPIRE      ();
	}
	
	public IOVMsgFCentrex( IOVMsgFCentrex centrex ){
		super();
		INS_PROD_ID = centrex.INS_PROD_ID;
		USER_ID     = centrex.USER_ID    ;
		PRODUCT_ID  = centrex.PRODUCT_ID ;
		STATUS      = centrex.STATUS     ;
		EFFECTIVE   = centrex.EFFECTIVE  ;
		EXPIRE      = centrex.EXPIRE     ;
	}
	
	public IOVMsgFCentrex( IOVUserCentrex centrex ){
		super();
		INS_PROD_ID = centrex.getINS_PROD_ID      ();
		USER_ID     = centrex.getUSER_ID          ();
		PRODUCT_ID  = centrex.getPRODUCT_ID       ();
		STATUS      = IUpdbfsConst.IState.IOrder.S01;
		EFFECTIVE   = centrex.getEFFECTIVE        ();
		EXPIRE      = centrex.getEXPIRE           ();
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
	 * 
	 * @return
	 */
	public long getINS_OFFER_ID(){
		long _InstOfferId = -1l;
		for( java.util.Iterator<IOVMsgFOffer> itera = CENTREX.iterator(); itera.hasNext(); ){
			IOVMsgFOffer _msgfoffer = (IOVMsgFOffer)itera.next();
			_InstOfferId = _msgfoffer.getINS_OFFER_ID();
			if( _InstOfferId > 0 ){ break; }
		}
		return _InstOfferId;
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
	 * @return the cENTREX
	 */
	public CarbonList<IOVMsgFOffer> getCENTREX() {
		return CENTREX;
	}
	
	/**
	 * 根据服务编号获取当前资费包服务定单
	 * @param aSERVICE_ID
	 * @return
	 */
	public IOVMsgFOffer getCENTREX( long aSERVICE_ID ){
		IOVMsgFOffer fromOffer = null;
		try
		{
			for( java.util.Iterator<IOVMsgFOffer> itera = CENTREX.iterator(); itera.hasNext(); ){
				IOVMsgFOffer fromOrder = (IOVMsgFOffer)itera.next();
				if( fromOrder.getSERVICE_ID() == aSERVICE_ID ){
					fromOffer = fromOrder;
					break;
				}
			}
		}
		finally{
			
		}
		return fromOffer;
	}
	
	/**
	 * 
	 * @param centrex
	 * @throws Exception
	 */
	public void mergeAsCentrex( IOVMsgFOffer centrex ) throws Exception{
		
	}
	
	/**
	 * 
	 * @param centrex
	 * @throws Exception
	 */
	public void mergeAsCentrex( IOVMsgFCentrex centrex ) throws Exception{
		
	}
	
	/**
	 * 是否基于定单订购或基于用户服务产品
	 * @return
	 */
	public boolean isCREATE(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S01 );
	}
	
	/**
	 * 是否基于定单变更服务产品
	 */
	public boolean isMODIFY(){
		return ( this instanceof IOVMsgFOrdCentrex ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S02 );
	}
	
	/**
	 * 是否退订服务产品
	 */
	public boolean isCANCEL(){
		return ( this instanceof IOVMsgFOrdCentrex ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S03 );
	}
	
	/**
	 * 是否保持服务产品
	 */
	public boolean isHOLDING(){
		return ( this instanceof IOVMsgFOrdCentrex ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S04 );
	}
	
	/**
	 * 是否暂停服务产品
	 * @return
	 */
	public boolean isSUSPEND(){
		return ( ( this instanceof IOVMsgFOrdCentrex ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S05 ) ) ||
				( ( this instanceof IOVMsgFUserCentrex ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S03 ) );
	}

	/**
	 * 是否依赖服务产品
	 * @return
	 */
	public boolean isDEPEND(){
		return (this instanceof IOVMsgFUserCentrex) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S05 );
	}
	
	/**
	 * 是否恢复服务产品
	 * @return
	 */
	public boolean isRESUME(){
		return ( (this instanceof IOVMsgFOrdCentrex) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S06 ) );
	}
	
	/**
	 * 是否送网元开通
	 * @return
	 */
	public boolean isVALID( ){
		java.sql.Timestamp __CREATOR__ = TimeUtils.getSysdate();
		if( this instanceof IOVMsgFUserCentrex ){
			return TimeUtils.greater( EXPIRE, EFFECTIVE );
		}
		else if( STATUS != null && STATUS.equals( IUpdbfsConst.IState.IOrder.S03 ) ){
			if( TimeUtils.greaterEqual( EFFECTIVE, EXPIRE ) /*立即已生效退订[判断是否为扣费操作]*/){
				return TimeUtils.greater( __CREATOR__, EFFECTIVE );
			}
			else{
				return TimeUtils.greater( EXPIRE, EFFECTIVE ); 
			}
		}
		else/*服务定单非立即退订*/{
			return TimeUtils.greater( EXPIRE, EFFECTIVE ); 
		}
	}
	
	/**
	 * 是否有效[本周期下周期生效]
	 * @return
	 */
	public boolean isVALIDALL(){
		boolean _validall = false;
		try
		{
			java.sql.Timestamp __sysdate = TimeUtils.getSysdate();
			if( this instanceof IOVMsgFUserCentrex /*开通用户测产品资费*/){
				_validall = TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, __sysdate );
			}
			else if( TimeUtils.greater( EXPIRE, EFFECTIVE ) == false/*开通定单测服务产品[立即退订]*/){
				_validall = TimeUtils.greaterEqual( EFFECTIVE, __sysdate );
			}
			else if( isCANCEL() /*开通定单测服务产品[立即退订]*/){
				_validall = ( TimeUtils.infiniteYYYY( EXPIRE, __sysdate ) || TimeUtils.greater( __sysdate, EXPIRE ) )?false:true;
			}
			else/*开通定单测产品资费*/{
				_validall = TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, __sysdate );
			}
		}
		finally{
			
		}
		return _validall;
	}
	
	/**
	 * 是否为立即开通服务产品(失效时间为无穷大 或者 当前时间大于失效时间)
	 * @param aCREATOR 受理时间
	 * @return
	 */
	public boolean isPROMPTLY( java.sql.Timestamp aCREATOR ){
		if( StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S01 ) && 
				TimeUtils.greaterEqual( aCREATOR, EFFECTIVE ) ){
			return true;
		}
		else if( TimeUtils.infiniteYYYY( EXPIRE, aCREATOR ) || 
				TimeUtils.greaterEqual( aCREATOR, EXPIRE ) ){
			return true;
		}
		return false;
	}
	
	/**
	 * 是否下周期服务产品(次月订购)
	 * @param aCREATOR 受理时间
	 * @return
	 */
	public boolean isEFFECTIVE( java.sql.Timestamp aCREATOR ){
		return TimeUtils.infiniteYYYY( EFFECTIVE, aCREATOR ) == false && 
				TimeUtils.greater( EXPIRE, EFFECTIVE ) &&  TimeUtils.greater( EFFECTIVE, aCREATOR );
	}
	
	/**
	 * 是否下周期服务产品(次月退订)
	 * @param aCREATOR 受理时间
	 * @return
	 */
	public boolean isEXPIRE( java.sql.Timestamp aCREATOR ){
		return TimeUtils.infiniteYYYY( EXPIRE, aCREATOR ) == false &&
				TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, aCREATOR );
	}
	
	/**
	 * 是否属于开通定单测服务产品
	 * @return
	 */
	public boolean isORDER(){
		return this instanceof IOVMsgFOrdCentrex;
	}
	
	/**
	 * 是否属于开通用户测服务产品
	 * @return
	 */
	public boolean isUSER(){
		return this instanceof IOVMsgFUserCentrex;
	}
	
	/**
	 * 
	 * @param usercentrex
	 * @throws Exception
	 */
	public void userCentrexToXml( org.dom4j.Element usercentrex ) throws Exception{
		try
		{
			usercentrex.addAttribute( "VALIDALL", String.valueOf( isVALIDALL() ).toUpperCase  () );
			usercentrex.addAttribute( "NETWORK", String.valueOf( isVALID() ).toUpperCase      () );
			usercentrex.addElement("INS_PROD_ID").setText( String.valueOf( INS_PROD_ID         ) );
			usercentrex.addElement("PRODUCT_ID" ).setText( String.valueOf( PRODUCT_ID          ) );
			usercentrex.addElement("STATUS"     ).setText( String.valueOf( STATUS              ) );
			usercentrex.addElement("EFFECTIVE"  ).setText( TimeUtils.yyyymmddhhmmss( EFFECTIVE ) );
			usercentrex.addElement("EXPIRE"     ).setText( TimeUtils.yyyymmddhhmmss( EXPIRE    ) );
			for( java.util.Iterator<IOVMsgFOffer> itera = CENTREX.iterator(); itera.hasNext(); ){
				IOVMsgFOffer msgfoffer = (IOVMsgFOffer)itera.next();
				msgfoffer.msgfOfferToXML( usercentrex.addElement( "COMPETE" ) );
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
		else if( objective instanceof IOVMsgFOffer ){
			IOVMsgFOffer _offer = (IOVMsgFOffer)objective;
			return INS_PROD_ID > 0 && _offer.getINS_PROD_ID() > 0 && INS_PROD_ID == _offer.getINS_PROD_ID();
		}
		else if( objective instanceof IOVMsgFCentrex ){
			IOVMsgFCentrex _cabinet = (IOVMsgFCentrex)objective;
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
		long doCompare = objective != null && objective instanceof IOVMsgFCentrex?0:1;
		if( doCompare == 0 ){
			IOVMsgFCentrex _centrex = (IOVMsgFCentrex)objective;
			doCompare = EFFECTIVE.compareTo( _centrex.EFFECTIVE );
			if( doCompare == 0 ){ 
				doCompare = (PRODUCT_ID - _centrex.PRODUCT_ID == 0)?(INS_PROD_ID - _centrex.INS_PROD_ID):
					(PRODUCT_ID - _centrex.PRODUCT_ID); 
			}
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
}
