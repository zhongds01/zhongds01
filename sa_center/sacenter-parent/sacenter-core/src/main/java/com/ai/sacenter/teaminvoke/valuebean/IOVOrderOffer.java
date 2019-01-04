package com.ai.sacenter.teaminvoke.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务产品订购</p>
 * <p>Copyright: Copyright (c) 2015年9月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVOrderOffer implements java.io.Serializable{
	private static final long serialVersionUID = -3759940685533042015L;
	private long   OFFER_ID ;
	private long   COMPETE  ;
	private long   COMPTEL  ;
	private long   PRODUCT  ;
	private String CATALOG  ;
	private String COMPOSITE;
	private String STATUS   ;
	private java.sql.Timestamp EFFECTIVE;
	private java.sql.Timestamp EXPIRE   ;
	private java.util.Map<String, Object> COMPLEX = new java.util.HashMap<String, Object>();
	private java.util.List<IOVOrderOfferX> FEATURE = new java.util.ArrayList<IOVOrderOfferX>();
	public IOVOrderOffer() {
		super();
	}
	
	public IOVOrderOffer( IOVOrderOffer orderoffer ){
		super();
		OFFER_ID  = orderoffer.OFFER_ID ;
		COMPETE   = orderoffer.COMPETE  ;
		PRODUCT   = orderoffer.PRODUCT  ;
		COMPTEL   = orderoffer.COMPTEL  ;
		CATALOG   = orderoffer.CATALOG  ;
		COMPOSITE = orderoffer.COMPOSITE;
		STATUS    = orderoffer.STATUS   ;
		EFFECTIVE = orderoffer.EFFECTIVE;
		EXPIRE    = orderoffer.EXPIRE   ;
		COMPLEX.putAll( orderoffer.getCOMPLEX() );
		for( java.util.Iterator<IOVOrderOfferX> itera = orderoffer.getFEATURE().iterator(); itera.hasNext(); ){
			IOVOrderOfferX orderofferx = (IOVOrderOfferX)itera.next();
			FEATURE.add( new IOVOrderOfferX( orderofferx ) );
		}
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
	 * @return 能力编号
	 */
	public long getCOMPETE() {
		return COMPETE;
	}
	
	/**
	 * @param cOMPETE 能力编号
	 */
	public void setCOMPETE(long cOMPETE) {
		COMPETE = cOMPETE;
	}
	
	/**
	 * @return 服务编号
	 */
	public long getCOMPTEL() {
		return COMPTEL;
	}

	/**
	 * @param cOMPTEL 服务编号
	 */
	public void setCOMPTEL(long cOMPTEL) {
		COMPTEL = cOMPTEL;
	}

	/**
	 * @return 产品编号
	 */
	public long getPRODUCT() {
		return PRODUCT;
	}
	
	/**
	 * @param pRODUCT 产品编号
	 */
	public void setPRODUCT(long pRODUCT) {
		PRODUCT = pRODUCT;
	}
	
	/**
	 * @return 角色编号
	 */
	public String getCATALOG() {
		return CATALOG;
	}
	
	/**
	 * @param cATALOG 角色编号
	 */
	public void setCATALOG(String cATALOG) {
		CATALOG = cATALOG;
	}
	
	/**
	 * @return 开通类型
	 */
	public String getCOMPOSITE() {
		return COMPOSITE;
	}

	/**
	 * @param cOMPOSITE 开通类型
	 */
	public void setCOMPOSITE(String cOMPOSITE) {
		COMPOSITE = cOMPOSITE;
	}

	/**
	 * @return 动作类型
	 */
	public String getSTATUS() {
		return STATUS;
	}
	
	/**
	 * @param sTATUS 动作类型
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
	 * @return 产品属性集
	 */
	public java.util.Map<String, Object> getCOMPLEX() {
		return COMPLEX;
	}
	
	/**
	 * @return 产品属性列表
	 */
	public java.util.List<IOVOrderOfferX> getFEATURE() {
		return FEATURE;
	}
	
	/**
	 * 根据属性编码获取服务产品属性
	 * @param aCOMPETE
	 * @return
	 */
	public IOVOrderOfferX getFEATURE( String aCOMPETE ){
		IOVOrderOfferX fromOfferX = null;
		try
		{
			for( java.util.Iterator<IOVOrderOfferX> itera = FEATURE.iterator(); itera.hasNext(); ){
				IOVOrderOfferX fromOffer = (IOVOrderOfferX)itera.next();
				if( StringUtils.equals( fromOffer.getCOMPETE(), aCOMPETE ) ){
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
	 * 是否服务类型开通
	 * @return
	 */
	public boolean isCAPITY(){
		return StringUtils.isBlank( COMPOSITE ) || 
				StringUtils.equals( COMPOSITE, IUpdcConst.IUpdcp.SERVICE );
	}
	
	/**
	 * 是否产品类开通
	 * @return
	 */
	public boolean isPRICE(){
		return StringUtils.equals( COMPOSITE, IUpdcConst.IUpdcp.PRICE );
	}
	
	/**
	 * 是否多产品类开通
	 * @return
	 */
	public boolean isMULTLE(){
		return StringUtils.equals( COMPOSITE, IUpdcConst.IUpdcp.MULTLE );
	}
	
	/**
	 * 是否订购服务产品
	 * @return
	 */
	public boolean isCREATE(){
		return StringUtils.equals( STATUS, IUpdcConst.IState.C );
	}
	
	/**
	 * 是否变更服务产品
	 */
	public boolean isMODIFY(){
		return StringUtils.equals( STATUS, IUpdcConst.IState.X );
	}
	
	/**
	 * 是否退订服务产品
	 */
	public boolean isCANCEL(){
		return StringUtils.equals( STATUS, IUpdcConst.IState.E );
	}
	
	/**
	 * 是否保持服务产品
	 */
	public boolean isHOLDING(){
		return StringUtils.equals( STATUS, IUpdcConst.IState.U );
	}
	
	/**
	 * 是否依赖服务产品
	 * @return
	 */
	public boolean isDEPEND(){
		return StringUtils.equals( STATUS, IUpdcConst.IState.D ) || 
				StringUtils.startWith( STATUS, IUpdcConst.IState.D );
	}
	
	/**
	 * 
	 * @param _centrex
	 * @throws Exception
	 */
	public void toXML( org.dom4j.Element _centrex ) throws Exception{
		try
		{
			_centrex.addElement("OFFER_ID"   ).setText( String.valueOf( OFFER_ID            ) );
			_centrex.addElement("COMPETE_ID" ).setText( String.valueOf( COMPETE             ) );
			_centrex.addElement("SERVICE_ID" ).setText( String.valueOf( COMPTEL             ) );
			_centrex.addElement("PRODUCT_ID" ).setText( String.valueOf( PRODUCT             ) );
			_centrex.addElement("STATUS"     ).setText( STATUS                                );
			_centrex.addElement("EFFECTIVE"  ).setText( TimeUtils.yyyymmddhhmmss( EFFECTIVE ) );
			_centrex.addElement("EXPIRE"     ).setText( TimeUtils.yyyymmddhhmmss( EXPIRE    ) );
			if( FEATURE != null && FEATURE.size() > 0 ){
				org.dom4j.Element _FUTURE_ = _centrex.addElement( "FUTURE" );
				for( java.util.Iterator<IOVOrderOfferX> itera = FEATURE.iterator(); itera.hasNext(); ){
					IOVOrderOfferX fromOfferX = (IOVOrderOfferX)itera.next();
					fromOfferX.toXML( _FUTURE_.addElement( "FUTURE" ) );
				}
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
			org.dom4j.Element _root = document.addElement( "InterBOSS" );
			toXML( _root.addElement( "CENTREX" ) );
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
