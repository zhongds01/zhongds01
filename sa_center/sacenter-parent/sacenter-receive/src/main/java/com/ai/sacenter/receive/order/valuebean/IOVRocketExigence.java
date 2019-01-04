package com.ai.sacenter.receive.order.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.order.bo.IISARocket;
import com.ai.sacenter.receive.order.bo.IISARocketX;
import com.ai.sacenter.receive.order.bo.ISARocket;
import com.ai.sacenter.receive.order.bo.ISARocketFail;
import com.ai.sacenter.receive.order.bo.ISARocketHis;
import com.ai.sacenter.receive.order.bo.ISARocketX;
import com.ai.sacenter.receive.order.bo.ISARocketXFail;
import com.ai.sacenter.receive.order.bo.ISARocketXHis;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

public class IOVRocketExigence implements java.io.Serializable {
	private static final long serialVersionUID = 2659565722615442728L;
	private long   ROCKET_ID     ;
	private String CUST_ORDER    ;
	private String ORDER_ITEM_ID ;
	private java.sql.Timestamp DONE_DATE    ;
	private String CATALOG      ;
	private String BUSINESS     ;
	private String BATCHES      ;
	private String ORIGINATOR   ;
	private String CHANNEL      ;
	private long   USER_ID      ;
	private String BILL_ID      ;
	private java.sql.Timestamp CREATE_DATE  ;
	private String REGION_ID    ;
	private String STATE        ;
	private long   PRIORITY     ;
	private String COMPOSITE    ;
	private String ORDER_REGION_ID;
	private String QUEUE_ID     ;
	private java.sql.Timestamp PLWK_CREATE;
	private java.sql.Timestamp PLWK_COMPLETE;
	private String FAIL_LOG     ;
	private java.sql.Timestamp COMPLETE_DATE;
	private String ORG_ID       ;
	private String STAFF_ID     ;
	private IISARocket INSTANCE = null;
	private IOVRocketOfferHome _order = new IOVRocketOfferHome();
	public IOVRocketExigence() throws Exception{
		super();
		CREATE_DATE     = new java.sql.Timestamp( System.currentTimeMillis () );
		PLWK_CREATE     = new java.sql.Timestamp( System.currentTimeMillis () );
		STATE           = IUpdbfsConst.IState.C                                ;
	}
	
	public IOVRocketExigence( String _rocket ) throws Exception{
		super();
		org.dom4j.Element _root = XmlUtils.parseXml( _rocket );
		org.dom4j.Element _pubinfo = RocketUtils.IMetaX._jj_element( _root, "PubInfo" );
		CUST_ORDER      = RocketUtils.IMetaX._jj_string   ( _pubinfo, "CustomerOrderId" , false );
		ORDER_ITEM_ID   = RocketUtils.IMetaX._jj_string   ( _pubinfo, "DoneCode"        , false );
		CATALOG         = RocketUtils.IMetaX._jj_string   ( _pubinfo, "ProdSpec"        , false );
		BUSINESS        = RocketUtils.IMetaX._jj_string   ( _pubinfo, "BusinessId"      , false );
		BATCHES         = RocketUtils.IMetaX._jj_string   ( _pubinfo, "IsBatchOrder"    , "0"   );
		ORIGINATOR      = RocketUtils.IMetaX._jj_string   ( _pubinfo, "OriginId"        , false );
		CHANNEL         = RocketUtils.IMetaX._jj_string   ( _pubinfo, "ChannelId"       , false );
		USER_ID         = RocketUtils.IMetaX._jj_long     ( _pubinfo, "UserId"          , false );
		BILL_ID         = RocketUtils.IMetaX._jj_string   ( _pubinfo, "BillId"          , false );
		ORDER_REGION_ID = RocketUtils.IMetaX._jj_string   ( _pubinfo, "RegionId"        , false );
		DONE_DATE       = RocketUtils.IMetaX._jj_timestamp( _pubinfo, "DoneDate"        , false );
		ORG_ID          = RocketUtils.IMetaX._jj_string   ( _pubinfo, "OrgId"           , false );
		STAFF_ID        = RocketUtils.IMetaX._jj_string   ( _pubinfo, "StaffId"         , false );
		STATE           = IUpdbfsConst.IState.C                                ;
		CREATE_DATE     = new java.sql.Timestamp( System.currentTimeMillis () );
		PLWK_CREATE     = new java.sql.Timestamp( System.currentTimeMillis () );
		_pubinfo        = RocketUtils.IMetaX._jj_element( _root, "BusiInfo" );
		OrderUtils.IRocket.IRocketX._wrapWithRocket( _pubinfo.getTextTrim(), this );
	}
	
	public IOVRocketExigence( String _rocket, SFException aEXCEPTION ) throws Exception{
		super();
		CUST_ORDER     = String.valueOf( System.currentTimeMillis        () );
		ORDER_ITEM_ID  = String.valueOf( System.currentTimeMillis        () );
		DONE_DATE      = new java.sql.Timestamp( System.currentTimeMillis() );
		CATALOG        = IUpdbfsConst.IUpdbm.ICatalog.RECEIVE                ;
		BUSINESS       = IUpdbfsConst.IUpdbm.IBusines.RECEIVE                ;
		BATCHES        = IUpdbfsConst.IUpdbm.IBatches.NO                     ;
		ORIGINATOR     = IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_RECEIVE      ;
		CHANNEL        = IUpdbfsConst.IUpdbm.ICustom.CHANNEL                 ;
		USER_ID        = 0l                                                  ;
		BILL_ID        = IUpdbfsConst.IUpdbm.ICustom.BILL_ID                 ;
		PRIORITY       = IUpdbfsConst.IUpdbm.ICustom.PRIORITY                ;
		COMPOSITE      = IUpdcConst.IUpdbm.IUpdbf.NORMAL                     ;
		CREATE_DATE    = new java.sql.Timestamp( System.currentTimeMillis() );
		ORG_ID         = IUpdbfsConst.IUpdbm.ICustom.ORGANIZE                ;
		STAFF_ID       = IUpdbfsConst.IUpdbm.ICustom.STAFF                   ;
		PLWK_CREATE    = new java.sql.Timestamp( System.currentTimeMillis() );
		ORDER_REGION_ID= "*"                                                 ;
		_order._body   = _rocket                                             ;
		OrderUtils.IRocket.IRocketX._wrapWithRocket( _rocket, this );
	}
	
	public IOVRocketExigence( org.dom4j.Element fromCustOrder, org.dom4j.Element fromOrderItem ) throws Exception{
		super();
		CUST_ORDER      = RocketUtils.IMetaX._jj_string   ( fromCustOrder, "OrderId"         , false );
		ORDER_ITEM_ID   = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "OrderItemId"     , false );
		CATALOG         = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "ItemCode"        , false );
		BUSINESS        = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "BusinessCode"    , false );
		BATCHES         = RocketUtils.IMetaX._jj_string   ( fromCustOrder, "IsBatchOrder"    , "0"   );
		ORIGINATOR      = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "OriginatorCode"  , false );
		CHANNEL         = RocketUtils.IMetaX._jj_string   ( fromCustOrder, "AccessChanelType", false );
		USER_ID         = RocketUtils.IMetaX._jj_long     ( fromOrderItem, "OwnerId"         , false );
		BILL_ID         = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "ServiceNumber"   , false );
		ORDER_REGION_ID = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "BeId"            , false );
		DONE_DATE       = RocketUtils.IMetaX._jj_timestamp( fromOrderItem, "SendTime"        , false );
		ORG_ID          = RocketUtils.IMetaX._jj_string   ( fromCustOrder, "SalesOrganizeId" , false );
		STAFF_ID        = RocketUtils.IMetaX._jj_string   ( fromCustOrder, "SalesPersonId"   , false );
		STATE           = IUpdbfsConst.IState.C                                ;
		CREATE_DATE     = new java.sql.Timestamp( System.currentTimeMillis () );
		PLWK_CREATE     = new java.sql.Timestamp( System.currentTimeMillis () );
	}
	
	public IOVRocketExigence( IISARocket aRocket ) throws Exception{
		super();
		INSTANCE = aRocket    ;
		_wrap( aRocket, this );
		INSTANCE.setStsToOld();
	}
	
	public IOVRocketExigence( java.util.Map<String,Object> fromRocket ) throws Exception{
		super();
		INSTANCE = new ISARocket();
		OracleUtils.ICustom.transfer( fromRocket, INSTANCE );
		_wrap( INSTANCE, this );
		INSTANCE.setStsToOld() ;
	}
	
	public IOVRocketExigence( IOVRocketExigence fromSRC ) throws Exception{
		super();
		ROCKET_ID        = fromSRC.ROCKET_ID       ;
		CUST_ORDER       = fromSRC.CUST_ORDER      ;
		ORDER_ITEM_ID    = fromSRC.ORDER_ITEM_ID   ;
		DONE_DATE        = fromSRC.DONE_DATE       ;
		CATALOG          = fromSRC.CATALOG         ;
		BUSINESS         = fromSRC.BUSINESS        ;
		BATCHES          = fromSRC.BATCHES         ;
		ORIGINATOR       = fromSRC.ORIGINATOR      ;
		CHANNEL          = fromSRC.CHANNEL         ;
		USER_ID          = fromSRC.USER_ID         ;
		BILL_ID          = fromSRC.BILL_ID         ;
		CREATE_DATE      = fromSRC.CREATE_DATE     ;
		REGION_ID        = fromSRC.REGION_ID       ;
		STATE            = fromSRC.STATE           ;
		PRIORITY         = fromSRC.PRIORITY        ;
		COMPOSITE        = fromSRC.COMPOSITE       ;
		ORDER_REGION_ID  = fromSRC.ORDER_REGION_ID ;
		QUEUE_ID         = fromSRC.QUEUE_ID        ;
		PLWK_CREATE      = fromSRC.PLWK_CREATE     ;
		PLWK_COMPLETE    = fromSRC.PLWK_COMPLETE   ;
		FAIL_LOG         = fromSRC.FAIL_LOG        ;
		COMPLETE_DATE    = fromSRC.COMPLETE_DATE   ;
		ORG_ID           = fromSRC.ORG_ID          ;
		STAFF_ID         = fromSRC.STAFF_ID        ;
		_order._priority = fromSRC._order._priority;
		_order._body     = fromSRC._order._body    ;
		_order._complete = fromSRC._order._complete;
		INSTANCE         = (IISARocket)OracleUtils.ISystem.transfer( fromSRC.INSTANCE );
		for( java.util.Iterator<IOVRocketOffer> itera = fromSRC._order._order.iterator(); itera.hasNext(); ){
			IOVRocketOffer fromRocketX = (IOVRocketOffer)itera.next();
			_order._order.add( new IOVRocketOffer( fromRocketX ) );
		}
	}
	
	public IOVRocketExigence( IOVRocketExigence fromSRC, IISARocket aRocket ) throws Exception{
		super();
		ROCKET_ID        = fromSRC.ROCKET_ID       ;
		CUST_ORDER       = fromSRC.CUST_ORDER      ;
		ORDER_ITEM_ID    = fromSRC.ORDER_ITEM_ID   ;
		DONE_DATE        = fromSRC.DONE_DATE       ;
		CATALOG          = fromSRC.CATALOG         ;
		BUSINESS         = fromSRC.BUSINESS        ;
		BATCHES          = fromSRC.BATCHES         ;
		ORIGINATOR       = fromSRC.ORIGINATOR      ;
		CHANNEL          = fromSRC.CHANNEL         ;
		USER_ID          = fromSRC.USER_ID         ;
		BILL_ID          = fromSRC.BILL_ID         ;
		CREATE_DATE      = fromSRC.CREATE_DATE     ;
		REGION_ID        = fromSRC.REGION_ID       ;
		STATE            = fromSRC.STATE           ;
		PRIORITY         = fromSRC.PRIORITY        ;
		COMPOSITE        = fromSRC.COMPOSITE       ;
		ORDER_REGION_ID  = fromSRC.ORDER_REGION_ID ;
		QUEUE_ID         = fromSRC.QUEUE_ID        ;
		PLWK_CREATE      = fromSRC.PLWK_CREATE     ;
		PLWK_COMPLETE    = fromSRC.PLWK_COMPLETE   ;
		FAIL_LOG         = fromSRC.FAIL_LOG        ;
		COMPLETE_DATE    = fromSRC.COMPLETE_DATE   ;
		ORG_ID           = fromSRC.ORG_ID          ;
		STAFF_ID         = fromSRC.STAFF_ID        ;
		_order._priority = fromSRC._order._priority;
		_order._body     = fromSRC._order._body    ;
		_order._complete = fromSRC._order._complete;
		if( aRocket != null ){ _wrap( fromSRC, INSTANCE = aRocket ); }
		if( fromSRC._order._order != null && fromSRC._order._order.size() > 0 ){
			for( java.util.Iterator<IOVRocketOffer> itera = fromSRC._order._order.iterator(); itera.hasNext(); ){
				IOVRocketOffer fromRocketX = (IOVRocketOffer)itera.next();
				if( INSTANCE != null && INSTANCE instanceof ISARocket ){
					IISARocketX aRocketX = new ISARocketX();
					_order._order.add( new IOVRocketOffer( fromRocketX, aRocketX ) );
				}
				else if( INSTANCE != null && INSTANCE instanceof ISARocketFail ){
					IISARocketX aRocketX = new ISARocketXFail();
					_order._order.add( new IOVRocketOffer( fromRocketX, aRocketX ) );
				}
				else if( INSTANCE != null && INSTANCE instanceof ISARocketHis ){
					IISARocketX aRocketX = new ISARocketXHis();
					_order._order.add( new IOVRocketOffer( fromRocketX, aRocketX ) );
				}
				else{
					_order._order.add( new IOVRocketOffer( fromRocketX ) );
				}
			}
		}
	}
	
	/**
	 * 
	 * @param aRocket
	 * @param fromRocket
	 */
	private void _wrap( IISARocket aRocket, IOVRocketExigence fromRocket ){
		fromRocket.setROCKET_ID      ( aRocket.getOrderId       () );
		fromRocket.setCUST_ORDER     ( aRocket.getCustOrder     () );
		fromRocket.setORDER_ITEM_ID  ( aRocket.getDoneCode      () );
		fromRocket.setDONE_DATE      ( aRocket.getDoneDate      () );
		fromRocket.setCATALOG        ( aRocket.getCatalogId     () );
		fromRocket.setBUSINESS       ( aRocket.getBusinessId    () );
		fromRocket.setORIGINATOR     ( aRocket.getOriginate     () );
		fromRocket.setCHANNEL        ( aRocket.getChannelId     () );
		fromRocket.setUSER_ID        ( aRocket.getUserId        () );
		fromRocket.setBILL_ID        ( aRocket.getBillId        () );
		fromRocket.setCREATE_DATE    ( aRocket.getCreateDate    () );
		fromRocket.setREGION_ID      ( aRocket.getRegionId      () );
		fromRocket.setSTATE          ( aRocket.getState         () );
		fromRocket.setPRIORITY       ( aRocket.getPriority      () );
		fromRocket.setCOMPOSITE      ( aRocket.getComposite     () );
		fromRocket.setORDER_REGION_ID( aRocket.getOrderRegionId () );
		fromRocket.setQUEUE_ID       ( aRocket.getQueueId       () );
		fromRocket.setPLWK_CREATE    ( aRocket.getPlwkCreate    () );
		fromRocket.setPLWK_COMPLETE  ( aRocket.getPlwkComplete  () );
		fromRocket.setFAIL_LOG       ( aRocket.getFailLog       () );
		fromRocket.setCOMPLETE_DATE  ( aRocket.getCompleteDate  () );
		fromRocket.setORG_ID         ( aRocket.getOrgId         () );
		fromRocket.setSTAFF_ID       ( aRocket.getStaffId       () );
	}
	
	/**
	 * 
	 * @param fromRocket
	 * @param aRocket
	 */
	private void _wrap( IOVRocketExigence fromRocket, IISARocket aRocket ) throws Exception{
		aRocket.setOrderId       ( fromRocket.getROCKET_ID      () );
		aRocket.setCustOrder     ( fromRocket.getCUST_ORDER     () );
		aRocket.setDoneCode      ( fromRocket.getORDER_ITEM_ID  () );
		aRocket.setDoneDate      ( fromRocket.getDONE_DATE      () );
		aRocket.setCatalogId     ( fromRocket.getCATALOG        () );
		aRocket.setBusinessId    ( fromRocket.getBUSINESS       () );
		aRocket.setOriginate     ( fromRocket.getORIGINATOR     () );
		aRocket.setChannelId     ( fromRocket.getCHANNEL        () );
		aRocket.setUserId        ( fromRocket.getUSER_ID        () );
		aRocket.setBillId        ( fromRocket.getBILL_ID        () );
		aRocket.setCreateDate    ( fromRocket.getCREATE_DATE    () );
		aRocket.setRegionId      ( fromRocket.getREGION_ID      () );
		aRocket.setState         ( fromRocket.getSTATE          () );
		aRocket.setPriority      ( fromRocket.getPRIORITY       () );
		aRocket.setComposite     ( fromRocket.getCOMPOSITE      () );
		aRocket.setOrderRegionId ( fromRocket.getORDER_REGION_ID() );
		aRocket.setQueueId       ( fromRocket.getQUEUE_ID       () );
		aRocket.setPlwkCreate    ( fromRocket.getPLWK_CREATE    () );
		aRocket.setPlwkComplete  ( fromRocket.getPLWK_COMPLETE  () );
		aRocket.setFailLog       ( fromRocket.getFAIL_LOG       () );
		aRocket.setCompleteDate  ( fromRocket.getCOMPLETE_DATE  () );
		aRocket.setOrgId         ( fromRocket.getORG_ID         () );
		aRocket.setStaffId       ( fromRocket.getSTAFF_ID       () );
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
		if( INSTANCE != null ) INSTANCE.setOrderId( rOCKET_ID );
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
		if( INSTANCE != null ) INSTANCE.setCustOrder(cUST_ORDER);
	}

	/**
	 * @return the oRDER_ITEM_ID
	 */
	public String getORDER_ITEM_ID() {
		return ORDER_ITEM_ID;
	}

	/**
	 * @param oRDER_ITEM_ID the oRDER_ITEM_ID to set
	 */
	public void setORDER_ITEM_ID(String oRDER_ITEM_ID) {
		ORDER_ITEM_ID = oRDER_ITEM_ID;
		if( INSTANCE != null ) INSTANCE.setDoneCode(oRDER_ITEM_ID);
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
		if( INSTANCE != null ) INSTANCE.setDoneDate(dONE_DATE);
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
		if( INSTANCE != null ) INSTANCE.setCatalogId( cATALOG );
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
		if( INSTANCE != null ) INSTANCE.setBusinessId( bUSINESS );
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
		if( INSTANCE != null ) INSTANCE.setOriginate( oRIGINATOR );
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
		if( INSTANCE != null ) INSTANCE.setChannelId( cHANNEL );
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
		if( INSTANCE != null ) INSTANCE.setUserId(uSER_ID);
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
		if( INSTANCE != null ) INSTANCE.setBillId(bILL_ID);
	}

	/**
	 * @return the cREATE_DATE
	 */
	public java.sql.Timestamp getCREATE_DATE() {
		return CREATE_DATE;
	}

	/**
	 * @param cREATE_DATE the cREATE_DATE to set
	 */
	public void setCREATE_DATE(java.sql.Timestamp cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
		if( INSTANCE != null ) INSTANCE.setCreateDate(cREATE_DATE);
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
		if( INSTANCE != null ) INSTANCE.setRegionId(rEGION_ID);
	}

	/**
	 * @return the sTATE
	 */
	public String getSTATE() {
		return STATE;
	}

	/**
	 * @param sTATE the sTATE to set
	 */
	public void setSTATE(String sTATE) {
		STATE = sTATE;
		if( INSTANCE != null ) INSTANCE.setState(sTATE);
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
		if( INSTANCE != null ) INSTANCE.setPriority( (int)pRIORITY );
		_order._priority = pRIORITY;
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
		if( INSTANCE != null ) INSTANCE.setComposite( cOMPOSITE );
	}

	/**
	 * @return the qUEUE_ID
	 */
	public String getQUEUE_ID() {
		return QUEUE_ID;
	}

	/**
	 * @param qUEUE_ID the qUEUE_ID to set
	 */
	public void setQUEUE_ID(String qUEUE_ID) {
		QUEUE_ID = qUEUE_ID;
		if( INSTANCE != null ) INSTANCE.setQueueId( qUEUE_ID );
	}

	/**
	 * @return the pLWK_CREATE
	 */
	public java.sql.Timestamp getPLWK_CREATE() {
		return PLWK_CREATE;
	}

	/**
	 * @param pLWK_CREATE the pLWK_CREATE to set
	 */
	public void setPLWK_CREATE(java.sql.Timestamp pLWK_CREATE) {
		PLWK_CREATE = pLWK_CREATE;
		if( INSTANCE != null ) INSTANCE.setPlwkCreate( pLWK_CREATE );
	}

	/**
	 * @return the pLWK_COMPLETE
	 */
	public java.sql.Timestamp getPLWK_COMPLETE() {
		return PLWK_COMPLETE;
	}

	/**
	 * @param pLWK_COMPLETE the pLWK_COMPLETE to set
	 */
	public void setPLWK_COMPLETE(java.sql.Timestamp pLWK_COMPLETE) {
		PLWK_COMPLETE = pLWK_COMPLETE;
		if( INSTANCE != null ) INSTANCE.setPlwkComplete( pLWK_COMPLETE );
	}

	/**
	 * @return the fAIL_LOG
	 */
	public String getFAIL_LOG() {
		return FAIL_LOG;
	}

	/**
	 * @param fAIL_LOG the fAIL_LOG to set
	 */
	public void setFAIL_LOG(String fAIL_LOG) {
		FAIL_LOG = fAIL_LOG;
		if( INSTANCE != null ) INSTANCE.setFailLog(fAIL_LOG);
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
		if( INSTANCE != null ) INSTANCE.setOrderRegionId(oRDER_REGION_ID);
	}

	/**
	 * @return the cOMPLETE_DATE
	 */
	public java.sql.Timestamp getCOMPLETE_DATE() {
		return COMPLETE_DATE;
	}

	/**
	 * @param cOMPLETE_DATE the cOMPLETE_DATE to set
	 */
	public void setCOMPLETE_DATE(java.sql.Timestamp cOMPLETE_DATE) {
		COMPLETE_DATE = cOMPLETE_DATE;
		if( INSTANCE != null ) INSTANCE.setCompleteDate(cOMPLETE_DATE);
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
		if( INSTANCE != null ) INSTANCE.setOrgId(oRG_ID);
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
		if( INSTANCE != null ) INSTANCE.setStaffId(sTAFF_ID);
	}

	/**
	 * @return the iNSTANCE
	 */
	public IISARocket getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(IISARocket iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	/**
	 * 是否为开通主定单
	 * @return
	 * @throws Exception
	 */
	public boolean isCOMPETENCE() throws Exception{
		return false;
	}
	
	/**
	 * @return 开通定单项
	 */
	public IOVRocketOfferHome getORDER() {
		return _order;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object paramObject) {
		if(paramObject!=null && paramObject instanceof IOVRocketExigence){
			return ((IOVRocketExigence)paramObject).ROCKET_ID == ROCKET_ID;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String _xml = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "IPSCRocket" );
			org.dom4j.Element _pubinfo = _root.addElement( "PubInfo" );
			_pubinfo.addElement( "CustomerOrderId" ).setText( CUST_ORDER                          );
			_pubinfo.addElement( "ProdSpec"        ).setText( CATALOG                             );
			_pubinfo.addElement( "BusinessId"      ).setText( BUSINESS                            );
			_pubinfo.addElement( "IsBatchOrder"    ).setText( BATCHES                             );
			_pubinfo.addElement( "OriginId"        ).setText( ORIGINATOR                          );
			_pubinfo.addElement( "ChannelId"       ).setText( CHANNEL                             );
			_pubinfo.addElement( "UserId"          ).setText( String.valueOf( USER_ID )           );
			_pubinfo.addElement( "BillId"          ).setText( BILL_ID                             );
			_pubinfo.addElement( "RegionId"        ).setText( ORDER_REGION_ID                     );
			_pubinfo.addElement( "OrgId"           ).setText( ORG_ID                              );
			_pubinfo.addElement( "StaffId"         ).setText( STAFF_ID                            );
			_pubinfo.addElement( "DoneCode"        ).setText( ORDER_ITEM_ID                       );
			_pubinfo.addElement( "DoneDate"        ).setText( TimeUtils.yyyymmddhhmmss(DONE_DATE) );
			if( _order._order != null && _order._order.size() > 0 ){
				_root.addElement( "BusiInfo" ).addCDATA( _order.getBODY() );
			}
			_xml = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_xml = super.toString();
		}
		finally{
			
		}
		return _xml;
	}


	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月16日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IOVRocketOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -3634626135995823635L;
		/*包体*/
		private String _body;
		/*优先级*/
		private long   _priority;
		/*报文清单*/
		private CarbonList<IOVRocketOffer> _order = new CarbonList<IOVRocketOffer>();
		/*开通定单归档*/
		private IOVRocketExigence _complete = null;
		public IOVRocketOfferHome(){
			super();
		}
		
		/**
		 * @return 包体
		 */
		public String getBODY() {
			StringBuilder fromBODY = new StringBuilder();
			try
			{
				if( StringUtils.isBlank( _body ) ){
					for( java.util.Iterator<IOVRocketOffer> itera = _order.iterator(); itera.hasNext(); ){
						IOVRocketOffer fromOffer = (IOVRocketOffer)itera.next();
						String fromMSG = OrderUtils.ICustom._mergex( fromOffer );
						if( StringUtils.isBlank( fromMSG ) == false ) fromBODY.append( fromMSG );
					}
					_body = fromBODY.toString();
				}
			}
			finally{
				if( fromBODY != null ){ fromBODY = null; }
			}
			return _body;
		}
		
		/**
		 * @param bODY 包体
		 */
		public void setBODY(String bODY) {
			_body = bODY;
		}
		
		/**
		 * @return 优先级
		 */
		public long getPRIORITY() {
			return _priority;
		}
		
		/**
		 * @param pRIORITY 优先级
		 */
		public void setPRIORITY(long pRIORITY) {
			_priority = pRIORITY;
		}
		
		/**
		 * @return 开通定单项
		 */
		public CarbonList<IOVRocketOffer> getORDER() {
			return _order;
		}

		/**
		 * @return 开通定单归档
		 */
		public IOVRocketExigence getCOMPLETE() {
			return _complete;
		}

		/**
		 * @param complete 开通定单归档
		 */
		public void setCOMPLETE(IOVRocketExigence complete) {
			_complete = complete;
		}
		
	}
}
