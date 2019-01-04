package com.ai.sacenter.receive.custom.valuebean;

import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年3月7日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUserOfferX extends IUpdfmxEntry implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = -4812233599151476623L;
	private long   INS_ATTR_ID   ;
	private String ATTR_ID       ;
	private String ATTR_VALUE    ;
	private String PRE_ATTR_VALUE;
	private String STATUS        ;
	private java.sql.Timestamp EFFECTIVE;
	private java.sql.Timestamp EXPIRE   ;
	public IOVUserOfferX() {
		super();
		INS_ATTR_ID    = 0                             ;
		ATTR_VALUE     = null                          ;
		PRE_ATTR_VALUE = null                          ;
		STATUS         = IUpdbfsConst.IState.IOrder.S01;
		EFFECTIVE      = TimeUtils.getEffective()      ;
		EXPIRE         = TimeUtils.getMaxExpire()      ;
	}
	
	public IOVUserOfferX( IOVUserOfferX userofferx) {
		super( userofferx );
		INS_ATTR_ID    = userofferx.INS_ATTR_ID   ;
		ATTR_ID        = userofferx.ATTR_ID       ;
		ATTR_VALUE     = userofferx.ATTR_VALUE    ;
		PRE_ATTR_VALUE = userofferx.PRE_ATTR_VALUE;
		STATUS         = userofferx.STATUS        ;
		EFFECTIVE      = userofferx.EFFECTIVE     ;
		EXPIRE         = userofferx.EXPIRE        ;
	}
	
	public IOVUserOfferX( String attrId ){
		super();
		INS_ATTR_ID= 0                             ;
		ATTR_ID    = attrId                        ;
		ATTR_VALUE = null                          ;
		STATUS     = IUpdbfsConst.IState.IOrder.S01;
		EFFECTIVE  = TimeUtils.getEffective()      ;
		EXPIRE     = TimeUtils.getMaxExpire()      ;
	}
	
	public IOVUserOfferX(String attrId ,String value){
		super();
		INS_ATTR_ID= 0                             ;
		ATTR_ID    = attrId                        ;
		ATTR_VALUE = value                         ;
		STATUS     = IUpdbfsConst.IState.IOrder.S01;
		EFFECTIVE  = TimeUtils.getEffective()      ;
		EXPIRE     = TimeUtils.getMaxExpire()      ;
	}

	public IOVUserOfferX(String attrId, long attrValue){
		super();
		INS_ATTR_ID= 0                             ;
		ATTR_ID    = attrId                        ;
		ATTR_VALUE = String.valueOf( attrValue )   ;
		STATUS     = IUpdbfsConst.IState.IOrder.S01;
		EFFECTIVE  = TimeUtils.getEffective()      ;
		EXPIRE     = TimeUtils.getMaxExpire()      ;
	}
	
	public IOVUserOfferX(String attrId, java.sql.Timestamp attrValue){
		super();
		INS_ATTR_ID= 0                                    ;
		ATTR_ID    = attrId                               ;
		ATTR_VALUE = TimeUtils.yyyymmddhhmmss( attrValue );
		STATUS     = IUpdbfsConst.IState.IOrder.S01       ;
		EFFECTIVE  = TimeUtils.getEffective()             ;
		EXPIRE     = TimeUtils.getMaxExpire()             ;
	}
	
	/**
	 * @return the iNS_ATTR_ID
	 */
	public long getINS_ATTR_ID() {
		return INS_ATTR_ID;
	}

	/**
	 * @param iNS_ATTR_ID the iNS_ATTR_ID to set
	 */
	public void setINS_ATTR_ID(long iNS_ATTR_ID) {
		INS_ATTR_ID = iNS_ATTR_ID;
	}

	/**
	 * @return the aTTR_ID
	 */
	public String getATTR_ID() {
		return ATTR_ID;
	}

	/**
	 * @param aTTR_ID the aTTR_ID to set
	 */
	public void setATTR_ID(String aTTR_ID) {
		ATTR_ID = aTTR_ID;
	}

	/**
	 * @return the aTTR_VALUE
	 */
	public String getATTR_VALUE() {
		return ATTR_VALUE;
	}

	/**
	 * @param aTTR_VALUE the aTTR_VALUE to set
	 */
	public void setATTR_VALUE(String aTTR_VALUE) {
		ATTR_VALUE = aTTR_VALUE;
	}

	/**
	 * @return the pRE_ATTR_VALUE
	 */
	public String getPRE_ATTR_VALUE() {
		return PRE_ATTR_VALUE;
	}

	/**
	 * @param pRE_ATTR_VALUE the pRE_ATTR_VALUE to set
	 */
	public void setPRE_ATTR_VALUE(String pRE_ATTR_VALUE) {
		PRE_ATTR_VALUE = pRE_ATTR_VALUE;
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
	 * 
	 * @param userofferx
	 */
	public void mergeAsGroup( IOVUserOfferX userofferx ){
		ATTR_VALUE = userofferx.ATTR_VALUE ;
		STATUS     = userofferx.getSTATUS();
		EXPIRE     = userofferx.getEXPIRE();
	}
	
	/**
	 * 
	 * @param _future
	 */
	public void userOfferXToXML( org.dom4j.Element _future ){
		try
		{
			_future.addElement("ATTR_ID"  ).setText( ATTR_ID  );
			if( ATTR_VALUE != null ){
				_future.addElement("ATTR_VALUE"  ).setText( ATTR_VALUE  );
			}
			if( PRE_ATTR_VALUE != null ){
				_future.addElement("PRE_ATTR_VALUE"  ).setText( PRE_ATTR_VALUE  );
			}
			if( STATUS != null ){
				_future.addElement("STATUS"  ).setText( STATUS  );
			}
			if( EFFECTIVE != null ){
				_future.addElement("EFFECTIVE"  ).setText( TimeUtils.yyyymmddhhmmss( EFFECTIVE )  );
			}
			if( EXPIRE != null ){
				_future.addElement("EXPIRE"  ).setText( TimeUtils.yyyymmddhhmmss( EXPIRE )  );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 服务资费是否当前时间有效[本周期和下周期[失效时间大于生效时间,失效时间大于系统时间]]
	 * @return
	 */
	public boolean isVALIDALL(){
		java.sql.Timestamp __sysdate = TimeUtils.getSysdate();
		return ( EXPIRE == null || EFFECTIVE == null ) || ( EXPIRE != null && EFFECTIVE != null && 
				TimeUtils.greater( EXPIRE, EFFECTIVE ) && TimeUtils.greater( EXPIRE, __sysdate ) );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		boolean _equal = false;
		if( objective == null ){
			_equal = false;
		}
		else if( objective instanceof IOVUserOfferX == false ){
			_equal = false;
		}
		else{
			IOVUserOfferX offer = (IOVUserOfferX)objective;
			if( INS_ATTR_ID > 0 && offer.INS_ATTR_ID > 0 ){
				_equal = INS_ATTR_ID == offer.INS_ATTR_ID?(StringUtils.equals( ATTR_ID, offer.ATTR_ID ) ):false;
			}
			else if( INS_ATTR_ID <= 0 && offer.INS_ATTR_ID <= 0 ){
				_equal = StringUtils.equals( ATTR_ID, offer.ATTR_ID );
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
		long doCompare = 0;
		try
		{
			doCompare = objective != null && objective instanceof IOVUserOfferX?0:1;
			if( doCompare == 0 ){
				IOVUserOfferX offer = (IOVUserOfferX)objective;
				doCompare = INS_ATTR_ID > 0 && offer.INS_ATTR_ID > 0?(INS_ATTR_ID - offer.INS_ATTR_ID):1;
				if( doCompare == 0 ){ doCompare = ATTR_ID.compareTo( offer.ATTR_ID ); }
			}
		}
		finally{
			
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
}
