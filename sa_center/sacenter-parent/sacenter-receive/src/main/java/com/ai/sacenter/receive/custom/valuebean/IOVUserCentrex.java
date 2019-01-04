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
 * <p>Description: �û��ʷѰ�</p>
 * <p>Copyright: Copyright (c) 2018��4��2��</p>
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
	 * @return �ʷѱ��
	 */
	public long getINS_PROD_ID() {
		return INS_PROD_ID;
	}

	/**
	 * @param iNS_PROD_ID �ʷѱ��
	 */
	public void setINS_PROD_ID(long iNS_PROD_ID) {
		INS_PROD_ID = iNS_PROD_ID;
	}

	/**
	 * @return �߻����
	 */
	public long getINS_OFFER_ID() {
		return INS_OFFER_ID;
	}

	/**
	 * @param iNS_OFFER_ID �߻����
	 */
	public void setINS_OFFER_ID(long iNS_OFFER_ID) {
		INS_OFFER_ID = iNS_OFFER_ID;
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
	 * @return �û����б��
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}

	/**
	 * @param rEGION_ID �û����б��
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}

	/**
	 * @return ��Ʒ���
	 */
	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	/**
	 * @param pRODUCT_ID ��Ʒ���
	 */
	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	
	/**
	 * @return ��Ʒ����
	 */
	public String getPROD_TYPE() {
		return PROD_TYPE;
	}

	/**
	 * @param pROD_TYPE ��Ʒ����
	 */
	public void setPROD_TYPE(String pROD_TYPE) {
		PROD_TYPE = pROD_TYPE;
	}

	/**
	 * @return �ʷ�״̬
	 */
	public String getSTATUS() {
		return STATUS;
	}

	/**
	 * @param sTATUS �ʷ�״̬
	 */
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
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
	 * @return �����Ʒ
	 */
	public CarbonList<IOVUserOrder> getCENTREX() {
		return CENTREX;
	}

	/**
	 * ���ݷ����Ż�ȡ�û������Ʒ����
	 * @param aSERVICE_ID ������
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
	 * ���ݷ����Ż�ȡ�û������Ʒ����
	 * @param userorder �����Ʒ
	 * @return
	 */
	public IOVUserOrder getCENTREX( IOVUserOrder userorder ){
		return (IOVUserOrder)CENTREX.get( userorder );
	}
	
	/**
	 * �����˶������Ʒ
	 * @param userorder
	 */
	public void orderAsCentrex( IOVUserOrder userorder ){
		EXPIRE = userorder.getEXPIRE();
		STATUS = userorder.getSTATUS();
		if( userorder.isVALIDALL() == false /*��ʧЧ[�˶�������Դ��]*/){
			IOVUserOrder _userorder = (IOVUserOrder)CENTREX.get( userorder );
			if( _userorder != null ){ CENTREX.remove( _userorder ); }
		}
		else/*������/��������Ч*/{
			IOVUserOrder _userorder = (IOVUserOrder)CENTREX.get( userorder );
			if( _userorder == null ){ CENTREX.add( new IOVUserOrder( userorder ) ); }
			else{ _userorder.orderAsCentrex( userorder ); }
		}
	}
	
	/**
	 * �Ƿ���Ч������Ч
	 * @param _validtype ��Ч����
	 * @param _currentdate ��ǰʱ��
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
	 * �Ƿ�������Ч
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDNOW( java.sql.Timestamp _currentdate ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.middle( EFFECTIVE, _currentdate, EXPIRE );
	}
	
	/**
	 * �Ƿ���������Ч
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDNEXT( java.sql.Timestamp _currentdate ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EFFECTIVE, _currentdate );
	}
	
	/**
	 * �����ʷ��Ƿ�ǰʱ����Ч[�����ں�������[ʧЧʱ�������Чʱ��,ʧЧʱ�����ϵͳʱ��]]
	 * @return
	 */
	public boolean isVALIDALL(){
		java.sql.Timestamp __sysdate = TimeUtils.getSysdate();
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, __sysdate );
	}
	
	/**
	 * �Ƿ���������Ч
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDALL( java.sql.Timestamp _currentdate ){
		return TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, _currentdate );
	}
	
	/**
	 * �Ƿ���������Ч
	 * @param _currentdate
	 * @return
	 */
	public boolean isVALIDEXPIRED( java.sql.Timestamp _currentdate ){
		return TimeUtils.greaterEqual( _currentdate, EXPIRE );
	}
	
	/**
	 * �Ƿ������ʷѰ�
	 * @return
	 */
	public boolean isNORMAL(){
		return StringUtils.equals( STATUS, IUpdbfsConst.IState.IOrder.S01 );
	}
	
	/**
	 * �Ƿ���ͣ�ʷѰ�
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
