package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;

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
public class IOVMsgFRequest implements java.io.Serializable {
	private static final long serialVersionUID = 4858009927711530520L;
	private long   ROCKET_ID ;
	private String CUST_ORDER;
    private String CATALOG   ;
    private String BUSINESS  ;
    private String BATCHES   ;
    private String ORIGINATOR;
    private String CHANNEL   ;
    private long   PRIORITY  ;
    private String COMPOSITE ;
    private long   USER_ID   ;
    private String BILL_ID   ;
    private String REGION_ID ;
    private String DONE_CODE ;
    private java.sql.Timestamp DONE_DATE;
    private String ORDER_REGION_ID;
    private String ORG_ID    ;
    private String STAFF_ID  ; 
    private String ORGIN_XML ;
    private CarbonList<IOVMsgFUser> _user    = new CarbonList<IOVMsgFUser>();
    private CarbonList<IOVMsgFUser> _centrex = new CarbonList<IOVMsgFUser>(); 
    private IMsgFOfferHome   _order = new IMsgFOfferHome();
    public IOVMsgFRequest() {
    	super();
    }
   
	/**
	 * @return the rOCKET_ID
	 */
	public long getROCKET_ID() {
		return ROCKET_ID;
	}

	/**
	 * @param rOCKET_ID the rOCKET_ID to set
	 */
	public void setROCKET_ID(long rOCKET_ID) {
		ROCKET_ID = rOCKET_ID;
	}

	/**
	 * @return the cUST_ORDER
	 */
	public String getCUST_ORDER() {
		return CUST_ORDER;
	}

	/**
	 * @param cUST_ORDER the cUST_ORDER to set
	 */
	public void setCUST_ORDER(String cUST_ORDER) {
		CUST_ORDER = cUST_ORDER;
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
	 * @return the bUSINESS
	 */
	public String getBUSINESS() {
		return BUSINESS;
	}

	/**
	 * @param bUSINESS the bUSINESS to set
	 */
	public void setBUSINESS(String bUSINESS) {
		BUSINESS = bUSINESS;
	}

	/**
	 * @return the bATCHES
	 */
	public String getBATCHES() {
		return BATCHES;
	}

	/**
	 * @param bATCHES the bATCHES to set
	 */
	public void setBATCHES(String bATCHES) {
		BATCHES = bATCHES;
	}

	/**
	 * @return the oRIGINATOR
	 */
	public String getORIGINATOR() {
		return ORIGINATOR;
	}

	/**
	 * @param oRIGINATOR the oRIGINATOR to set
	 */
	public void setORIGINATOR(String oRIGINATOR) {
		ORIGINATOR = oRIGINATOR;
	}

	/**
	 * @return the pRIORITY
	 */
	public long getPRIORITY() {
		return PRIORITY;
	}

	/**
	 * @param pRIORITY the pRIORITY to set
	 */
	public void setPRIORITY(long pRIORITY) {
		PRIORITY = pRIORITY;
	}

	/**
	 * @return the cOMPOSITE
	 */
	public String getCOMPOSITE() {
		return COMPOSITE;
	}

	/**
	 * @param cOMPOSITE the cOMPOSITE to set
	 */
	public void setCOMPOSITE(String cOMPOSITE) {
		COMPOSITE = cOMPOSITE;
	}

	/**
	 * @return the cHANNEL
	 */
	public String getCHANNEL() {
		return CHANNEL;
	}

	/**
	 * @param cHANNEL the cHANNEL to set
	 */
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
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
	 * @return the dONE_CODE
	 */
	public String getDONE_CODE() {
		return DONE_CODE;
	}

	/**
	 * @param dONE_CODE the dONE_CODE to set
	 */
	public void setDONE_CODE(String dONE_CODE) {
		DONE_CODE = dONE_CODE;
	}

	/**
	 * @return the dONE_DATE
	 */
	public java.sql.Timestamp getDONE_DATE() {
		return DONE_DATE;
	}

	/**
	 * @param dONE_DATE the dONE_DATE to set
	 */
	public void setDONE_DATE(java.sql.Timestamp dONE_DATE) {
		DONE_DATE = dONE_DATE;
	}

	/**
	 * @return the oRDER_REGION_ID
	 */
	public String getORDER_REGION_ID() {
		return ORDER_REGION_ID;
	}

	/**
	 * @param oRDER_REGION_ID the oRDER_REGION_ID to set
	 */
	public void setORDER_REGION_ID(String oRDER_REGION_ID) {
		ORDER_REGION_ID = oRDER_REGION_ID;
	}

	/**
	 * @return the oRG_ID
	 */
	public String getORG_ID() {
		return ORG_ID;
	}

	/**
	 * @param oRG_ID the oRG_ID to set
	 */
	public void setORG_ID(String oRG_ID) {
		ORG_ID = oRG_ID;
	}

	/**
	 * @return the sTAFF_ID
	 */
	public String getSTAFF_ID() {
		return STAFF_ID;
	}

	/**
	 * @param sTAFF_ID the sTAFF_ID to set
	 */
	public void setSTAFF_ID(String sTAFF_ID) {
		STAFF_ID = sTAFF_ID;
	}

	/**
	 * @return the oRGIN_XML
	 */
	public String getORGIN_XML() {
		return ORGIN_XML;
	}

	/**
	 * @param oRGIN_XML the oRGIN_XML to set
	 */
	public void setORGIN_XML(String oRGIN_XML) {
		ORGIN_XML = oRGIN_XML;
	}

	/**
	 * @return the uSER
	 */
	public CarbonList<IOVMsgFUser> getUSER() {
		return _user;
	}
	
	/**
	 * 获取主用户[如不存在随机获取用户]
	 * @return
	 */
	public IOVMsgFUser getLITTLE(){
		IOVMsgFUser _littleuser = null;
		try
		{
			_littleuser = getUSER( USER_ID );
			if( _littleuser == null && _user != null && _user.size() > 0 ){
				_littleuser = (IOVMsgFUser)_user.get( _user.size() - 1 );
			}
		}
		finally{
			
		}
		return _littleuser;
	}
	
	/**
	 * 根据用户编号查询当前用户基本信息
	 * @param aUSER_ID
	 * @return
	 */
	public IOVMsgFUser getUSER( long aUSER_ID ){
		IOVMsgFUser fromMsgFUser = null;
		try
		{
			for( java.util.Iterator<IOVMsgFUser> itera = _user.iterator(); itera.hasNext(); ){
				IOVMsgFUser fromUser = (IOVMsgFUser)itera.next();
				if( fromUser.getUSER_ID() == aUSER_ID ){
					fromMsgFUser = fromUser;
					break;
				}
			}
		}
		finally{
			
		}
		return fromMsgFUser;
	}
	
	/**
	 * 获取群组用户定单
	 * @return
	 */
	public IOVMsgFUser getGROUP(){
		IOVMsgFUser fromGroupUser = null;
		try
		{
			for( java.util.Iterator<IOVMsgFUser> itera = _user.iterator(); itera.hasNext(); ){
				IOVMsgFUser fromUser = (IOVMsgFUser)itera.next();
				if( StringUtils.equals( fromUser.getROLE_ID(), IUpdbfsConst.IUpdbm.IRole.GROUP )){
					fromGroupUser = fromUser;
				}
			}
		}
		finally{
			
		}
		return fromGroupUser;
	}
	
	/**
	 * 获取开通成员定单
	 * @return
	 */
	public IOVMsgFUser[] getMEMBER(){
		CarbonList<IOVMsgFUser> fromMEMBER = new CarbonList<IOVMsgFUser>();
		try
		{
			for( java.util.Iterator<IOVMsgFUser> itera = _user.iterator(); itera.hasNext(); ){
				IOVMsgFUser fromUser = (IOVMsgFUser)itera.next();
				if( StringUtils.equals( fromUser.getROLE_ID(), IUpdbfsConst.IUpdbm.IRole.GROUP ) == false ){
					fromMEMBER.add( fromUser );
				}
			}
		}
		finally{
			
		}
		return (IOVMsgFUser[])fromMEMBER.toArray( new IOVMsgFUser[]{} );
	}
	
	/**
	 * @return the _centrex
	 */
	public CarbonList<IOVMsgFUser> getCENTREX() {
		return _centrex;
	}
	
	/**
	 * 根据用户编号获取关联用户
	 * @param aUSER_ID 用户编号
	 * @return
	 */
	public IOVMsgFUser getCENTREX( long aUSER_ID ){
		IOVMsgFUser fromMsgFUser = null;
		try
		{
			for( java.util.Iterator<IOVMsgFUser> itera = _centrex.iterator(); itera.hasNext(); ){
				IOVMsgFUser fromUser = (IOVMsgFUser)itera.next();
				if( fromUser.getUSER_ID() == aUSER_ID ){
					fromMsgFUser = fromUser;
					break;
				}
			}
		}
		finally{
			
		}
		return fromMsgFUser;
	}
	
	/**
	 * 
	 * @return
	 */
	public IMsgFOfferHome getORDER(){
		return _order;
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月22日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
    public static class IMsgFOfferHome implements java.io.Serializable{
 		private static final long serialVersionUID = 3500816812863463349L;
 		/*发起方*/
 		private Object _objective = null;
 		/*服务产品时间*/
 		private java.sql.Timestamp _creator;
 		public IMsgFOfferHome(){
    		super();
    		_creator = new java.sql.Timestamp( System.currentTimeMillis() );
    	}
 		
		/**
		 * @return 发起方
		 */
		public Object getOBJECTIVE() {
			return _objective;
		}
		
		/**
		 * @param oBJECTIVE 发起方
		 */
		public void setOBJECTIVE(Object oBJECTIVE) {
			_objective = oBJECTIVE;
		}
		
		/**
		 * @return 服务产品时间
		 */
		public java.sql.Timestamp getCREATOR() {
			return _creator;
		}
		
		/**
		 * @param cREATOR 服务产品时间
		 */
		public void setCREATOR(java.sql.Timestamp cREATOR) {
			_creator = cREATOR;
		}
    }
}
