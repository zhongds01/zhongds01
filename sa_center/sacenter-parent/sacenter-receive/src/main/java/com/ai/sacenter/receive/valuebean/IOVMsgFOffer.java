package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * 
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年1月11日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFOffer implements java.lang.Comparable<Object>,java.io.Serializable {
	private static final long serialVersionUID = 7272564792756092520L;
	protected long   INS_SRVC_ID ;
	protected long   INS_PROD_ID ;
	protected long   USER_ID     ;
	protected long   COMPETE_ID  ;
	protected long   SERVICE_ID  ;
	protected long   PRODUCT_ID  ;
	protected String STATUS      ;
	protected String PROD_TYPE   ;
	protected java.sql.Timestamp EFFECTIVE;
	protected java.sql.Timestamp EXPIRE;
	protected IOVMsgFPlan CENTREX;
	protected CarbonList<IOVMsgFOfferX> FUTURE = new CarbonList<IOVMsgFOfferX>();
	public IOVMsgFOffer() {
		super();
	}
	
	public IOVMsgFOffer(IOVMsgFUser fromUser, long aCOMPETE_ID, String aSTATUS ){
		super();
		INS_SRVC_ID   =                       0 ;
		INS_PROD_ID   =                       0 ;
		USER_ID       = fromUser.getUSER_ID   ();
		COMPETE_ID    = aCOMPETE_ID             ;
		SERVICE_ID    = aCOMPETE_ID             ;
		PRODUCT_ID    = aCOMPETE_ID             ;
		STATUS        = aSTATUS                 ;
		EFFECTIVE     = TimeUtils.getEffective();
		EXPIRE        = TimeUtils.getExpire   ();
	}
	
	public IOVMsgFOffer(IOVMsgFUser fromUser, org.dom4j.Element element) {
		super();
		INS_SRVC_ID    = RocketUtils.IMetaX._jj_long     ( element, "ServInstId" , 0 );
		INS_PROD_ID    = RocketUtils.IMetaX._jj_long     ( element, "ProdInstId" );
		USER_ID        = fromUser.getUSER_ID                                    ();
		COMPETE_ID     = RocketUtils.IMetaX._jj_long     ( element, "ServiceId"  );
		SERVICE_ID     = RocketUtils.IMetaX._jj_long     ( element, "ServiceId"  );
		PRODUCT_ID     = RocketUtils.IMetaX._jj_long     ( element, "ProdId"     );
		STATUS         = RocketUtils.IMetaX._jj_string   ( element, "ProdStatus" );
		PROD_TYPE      = RocketUtils.IMetaX._jj_string   ( element, "ProdType"   , true );
		EFFECTIVE      = RocketUtils.IMetaX._jj_timestamp( element, "EffTime"    );
		EXPIRE         = RocketUtils.IMetaX._jj_timestamp( element, "ExpTime"    );
		org.dom4j.Element _element = RocketUtils.IMetaX._jj_element(element, "OfferInfo", true );
		if( _element != null ){ CENTREX = new IOVMsgFPlan( fromUser, _element ); }
		_element = RocketUtils.IMetaX._jj_element(element, "ProdExtInfo", true );
		if( _element != null ){
			for(java.util.Iterator<org.dom4j.Element> itera = _element.elements("ProdAttrInfo").iterator();itera.hasNext();){
				org.dom4j.Element __element = (org.dom4j.Element)itera.next();
				FUTURE.add( new IOVMsgFOfferX( __element ) );
			}
		}
	}
	
	public IOVMsgFOffer( IOVMsgFOffer centrex ){
		super();
		INS_SRVC_ID = centrex.INS_SRVC_ID      ;
		INS_PROD_ID = centrex.INS_PROD_ID      ;
		USER_ID     = centrex.USER_ID          ;
		COMPETE_ID  = centrex.COMPETE_ID       ;
		SERVICE_ID  = centrex.SERVICE_ID       ;
		PRODUCT_ID  = centrex.PRODUCT_ID       ;
		STATUS      = centrex.STATUS           ;
		PROD_TYPE   = centrex.PROD_TYPE        ;
		EFFECTIVE   = centrex.EFFECTIVE        ;
		EXPIRE      = centrex.EXPIRE           ;
		if( centrex.CENTREX != null ){ CENTREX = new IOVMsgFPlan( centrex.CENTREX ); }
		for( java.util.Iterator<IOVMsgFOfferX> itera = centrex.getFUTURE().iterator(); itera.hasNext(); ){
			IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
			FUTURE.add( new IOVMsgFOfferX( fromOfferX ) );
		}
	}
	
	public IOVMsgFOffer(IOVMsgFOfferX aOfferX) {
		super();
		INS_SRVC_ID =                                      0;
		INS_PROD_ID =                                      0;
		USER_ID     =                                      0;
		COMPETE_ID  = Long.parseLong( aOfferX.getATTR_ID() );
		SERVICE_ID  = Long.parseLong( aOfferX.getATTR_ID() );
		PRODUCT_ID  = Long.parseLong( aOfferX.getATTR_ID() );
		STATUS      = aOfferX.getSTATUS                   ();
		PROD_TYPE   = IUpdcConst.IUpdbm.IUpdbf.MULTLE       ;
		EFFECTIVE   = aOfferX.getEFFECTIVE                ();
		EXPIRE      = aOfferX.getEXPIRE                   ();
	}
	
	/**
	 * @return the iNS_SRVC_ID
	 */
	public long getINS_SRVC_ID() {
		return INS_SRVC_ID;
	}

	/**
	 * @param iNS_SRVC_ID the iNS_SRVC_ID to set
	 */
	public void setINS_SRVC_ID(long iNS_SRVC_ID) {
		INS_SRVC_ID = iNS_SRVC_ID;
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
		if( CENTREX == null ){ return -1l; }
		else{ return CENTREX.getINS_OFFER_ID(); }
	}
	
	/**
	 * @return the cOMPETE_ID
	 */
	public long getCOMPETE_ID() {
		return COMPETE_ID;
	}

	/**
	 * @param cOMPETE_ID the cOMPETE_ID to set
	 */
	public void setCOMPETE_ID(long cOMPETE_ID) {
		COMPETE_ID = cOMPETE_ID;
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
	public IOVMsgFPlan getCENTREX() {
		return CENTREX;
	}

	/**
	 * @param cENTREX the cENTREX to set
	 */
	public void setCENTREX(IOVMsgFPlan cENTREX) {
		CENTREX = cENTREX;
	}

	/**
	 * @return the aTTRIBUTE
	 */
	public CarbonList<IOVMsgFOfferX> getFUTURE() {
		return FUTURE;
	}
	
	/**
	 * 根据服务属性获取当前服务产品中服务属性
	 * @param aFUTURE 服务属性
	 * @return
	 */
	public IOVMsgFOfferX getFUTURE( IOVMsgFOfferX aFUTURE ){
		IOVMsgFOfferX fromOfferX = null;
		try
		{
			for( java.util.Iterator<IOVMsgFOfferX> itera = FUTURE.iterator(); itera.hasNext(); ){
				IOVMsgFOfferX fromOffer = (IOVMsgFOfferX)itera.next();
				if( aFUTURE.getINS_ATTR_ID() > 0 && aFUTURE.getINS_ATTR_ID() == fromOffer.getINS_ATTR_ID() ){
					fromOfferX = fromOffer;
					break;
				}
				else if( aFUTURE.getINS_ATTR_ID() <= 0 && StringUtils.equals( aFUTURE.getATTR_ID(), fromOffer.getATTR_ID() ) ){
					fromOfferX = fromOffer;
					break;
				}
			}
		}
		finally{
			
		}
		return fromOfferX;
	}
	
	/**
	 * 根据属性编码获取当前订购中属性
	 * @param fromAttrId 属性编码
	 * @return
	 */
	public IOVMsgFOfferX getFUTURE( String fromAttrId ){
		IOVMsgFOfferX fromOfferX = null;
		try
		{
			for( java.util.Iterator<IOVMsgFOfferX> itera = FUTURE.iterator(); itera.hasNext(); ){
				IOVMsgFOfferX fromOffer = (IOVMsgFOfferX)itera.next();
				if( StringUtils.equals( fromOffer.getATTR_ID(), fromAttrId ) ){
					fromOfferX = fromOffer;
					break;
				}
			}
		}
		finally{
			
		}
		return fromOfferX;
	}
	
	/**
	 * 根据属性编码获取当前订购属性组
	 * @param fromAttrId 属性编码
	 * @return
	 */
	public IOVMsgFOfferX[] getFUTURE( String fromAttrId[] ){
		CarbonList<IOVMsgFOfferX> fromNature = new CarbonList<IOVMsgFOfferX>();
		try
		{
			for( java.util.Iterator<IOVMsgFOfferX> itera = FUTURE.iterator(); itera.hasNext(); ){
				IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
				if( StringUtils.contains( fromOfferX.getATTR_ID(), fromAttrId ) ){
					fromNature.add( fromOfferX );
				}
			}
		}
		finally{
			
		}
		return (IOVMsgFOfferX[])fromNature.toArray( new IOVMsgFOfferX[]{} );
	}
	
	/**
	 * 根据属性订购编号获取当前订购中属性[如fromInsAttrId为小于等于0则返回NULL]
	 * @param aINS_ATTR_ID 属性订购编号
	 * @return
	 */
	public IOVMsgFOfferX getFUTURE( long aINS_ATTR_ID ){
		IOVMsgFOfferX fromOfferX = null;
		try
		{
			for( java.util.Iterator<IOVMsgFOfferX> itera = FUTURE.iterator(); itera.hasNext(); ){
				IOVMsgFOfferX fromOffer = (IOVMsgFOfferX)itera.next();
				if( fromOffer.getINS_ATTR_ID() > 0 && aINS_ATTR_ID > 0 &&
						fromOffer.getINS_ATTR_ID() == aINS_ATTR_ID ){
					fromOfferX = fromOffer;
					break;
				}
			}
		}
		finally{
			
		}
		return fromOfferX;
	}
	
	/**
	 * 
	 * @param orderoffer
	 */
	public void mergeAsGroup( IOVMsgFOffer orderoffer ){
		try
		{
			for( java.util.Iterator<IOVMsgFOfferX> itera = orderoffer.FUTURE.iterator(); itera.hasNext(); ){
				IOVMsgFOfferX orderofferx = (IOVMsgFOfferX)itera.next();
				if( FUTURE.get( orderofferx ) == null ){ FUTURE.add( new IOVMsgFOfferX( orderofferx ) ); }
			}
		}
		finally{
			
		}
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
		return ( this instanceof IOVMsgFOrdOffer ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S02 );
	}
	
	/**
	 * 是否退订服务产品
	 */
	public boolean isCANCEL(){
		return ( this instanceof IOVMsgFOrdOffer ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S03 );
	}
	
	/**
	 * 是否保持服务产品
	 */
	public boolean isHOLDING(){
		return ( this instanceof IOVMsgFOrdOffer ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S04 );
	}
	
	/**
	 * 是否暂停服务产品
	 * @return
	 */
	public boolean isSUSPEND(){
		return ( ( this instanceof IOVMsgFOrdOffer ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S05 ) ) ||
				( ( this instanceof IOVMsgFUserOffer ) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S03 ) );
	}

	/**
	 * 是否依赖服务产品
	 * @return
	 */
	public boolean isDEPEND(){
		return (this instanceof IOVMsgFUserOffer) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S05 );
	}
	
	/**
	 * 是否恢复服务产品
	 * @return
	 */
	public boolean isRESUME(){
		return ( (this instanceof IOVMsgFOrdOffer) && StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S06 ) );
	}
	
	/**
	 * 是否送网元开通[失效时间>生效时间]
	 * @param fromOffer 开通服务产品订购
	 * @return
	 */
	public boolean isVALID( ){
		java.sql.Timestamp __CREATOR__ = TimeUtils.getSysdate();
		if( this instanceof IOVMsgFUserOffer ){
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
			if( this instanceof IOVMsgFUserOffer /*开通用户测产品资费*/){
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
		return this instanceof IOVMsgFOrdOffer;
	}
	
	/**
	 * 是否属于开通用户测服务产品
	 * @return
	 */
	public boolean isUSER(){
		return this instanceof IOVMsgFUserOffer;
	}

	/**
	 * 
	 * @param useroffer
	 */
	public void msgfOfferToXML( org.dom4j.Element useroffer ){
		try
		{
			useroffer.addAttribute( "VALIDALL", String.valueOf( isVALIDALL() ).toUpperCase  () );
			useroffer.addAttribute( "NETWORK" , String.valueOf( isVALID() ).toUpperCase     () );
			useroffer.addElement("INS_PROD_ID").setText( String.valueOf( INS_PROD_ID         ) );
			useroffer.addElement("COMPETE_ID" ).setText( String.valueOf( COMPETE_ID          ) );
			useroffer.addElement("SERVICE_ID" ).setText( String.valueOf( SERVICE_ID          ) );
			useroffer.addElement("PRODUCT_ID" ).setText( String.valueOf( PRODUCT_ID          ) );
			useroffer.addElement("STATUS"     ).setText( String.valueOf( STATUS              ) );
			useroffer.addElement("PROD_TYPE"  ).setText( PROD_TYPE                             );
			useroffer.addElement("EFFECTIVE"  ).setText( TimeUtils.yyyymmddhhmmss( EFFECTIVE ) );
			useroffer.addElement("EXPIRE"     ).setText( TimeUtils.yyyymmddhhmmss( EXPIRE    ) );
			if( FUTURE != null && FUTURE.size() > 0 ){
				org.dom4j.Element userfuture = useroffer.addElement( "FUTURE" );
				for( java.util.Iterator<IOVMsgFOfferX> itera = FUTURE.iterator(); itera.hasNext(); ){
					IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
					if( fromOfferX.isEFFECTIVE() == false ) continue;
					fromOfferX.msgfOfferToXML( userfuture.addElement( "FUTURE" ) );
				}
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
		else if( objective instanceof IOVMsgFOffer == false ){
			_equal = false;
		}
		else{
			IOVMsgFOffer offer = (IOVMsgFOffer)objective;
			if( INS_PROD_ID > 0 && offer.INS_PROD_ID > 0 ){
				_equal = INS_PROD_ID == offer.INS_PROD_ID?( SERVICE_ID == offer.SERVICE_ID ):false;
			}
			else if( INS_PROD_ID <= 0 && offer.INS_PROD_ID <= 0 ){
				_equal = SERVICE_ID == offer.SERVICE_ID;
			}
			else{
				_equal = false;
			}
		}
		return _equal;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = objective != null && objective instanceof IOVMsgFOffer?0:1;
		if( doCompare == 0 ){
			IOVMsgFOffer offer = (IOVMsgFOffer)objective;
			doCompare = (SERVICE_ID - offer.SERVICE_ID == 0)?EFFECTIVE.compareTo( offer.EFFECTIVE ):(SERVICE_ID - offer.SERVICE_ID);
			if( doCompare == 0 ){ doCompare = INS_PROD_ID - offer.INS_PROD_ID ; }
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}

}
