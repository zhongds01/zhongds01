package com.ai.sacenter.receive.exigence.valuebean;

import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.exigence.bo.IISPCRocket;
import com.ai.sacenter.receive.exigence.bo.ISPCRocket;
import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通异步定单索引</p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMocketExigence implements java.io.Serializable, java.lang.Comparable<Object>{
	private static final long serialVersionUID = 6440912433219427483L;
	private long   ORDER_ID       ;                        
	private String CUST_ORDER     ;                        
	private String DONE_CODE      ;                        
	private java.sql.Timestamp DONE_DATE    ;                        
	private String CATALOG_ID     ;                        
	private String BUSINESS_ID    ;                        
	private String ORIGINATOR     ;                        
	private String CHANNEL_ID     ;                        
	private long   USER_ID        ;                        
	private String BILL_ID        ;                        
	private java.sql.Timestamp CREATE_DATE  ; 
	private String REGION_ID      ;
	private String ORDER_REGION_ID;                        
	private String STATE          ;                        
	private long   PRIORITY       ; 
	private String FAIL_CODE      ;                       
	private String FAIL_REASON    ;   
	private String FAIL_LOG       ;                        
	private java.sql.Timestamp COMPLETE_DATE;
	private long   RETRY_TIMES    ;
	private java.sql.Timestamp ORDER_DATE     ;
	private java.sql.Timestamp PLWK_CREATE;
	private java.sql.Timestamp PLWK_COMPLETE;
	private String ORG_ID         ;                        
	private String STAFF_ID       ; 
	private IISPCRocket INSTANCE  ;
	private IRocketOfferHome _order = null;
	public IOVMocketExigence() throws Exception{
		super();
		INSTANCE = new ISPCRocket            ();
		_order   = new IRocketOfferHome( this );
	}
	
	public IOVMocketExigence( org.dom4j.Element element ) throws Exception{
		super();
		INSTANCE         = new ISPCRocket();
		setCUST_ORDER     ( RocketUtils.IMetaX._jj_string   ( element, "OrderId"         ));
		setDONE_CODE      ( RocketUtils.IMetaX._jj_string   ( element, "SalesDoneCode"   ));
		setDONE_DATE      ( RocketUtils.IMetaX._jj_timestamp( element, "SalesDoneDate"   ));
		setCATALOG_ID     ( RocketUtils.IMetaX._jj_string   ( element, "ProductCode"     ));
		setBUSINESS_ID    ( RocketUtils.IMetaX._jj_string   ( element, "BusinessCode"    ));
		setORIGINATOR     ( RocketUtils.IMetaX._jj_string   ( element, "OriginatorCode"  ));
		setCHANNEL_ID     ( RocketUtils.IMetaX._jj_string   ( element, "AccessChanelType"));
		setUSER_ID        ( RocketUtils.IMetaX._jj_long     ( element, "OwnerId"         ));
		setBILL_ID        ( RocketUtils.IMetaX._jj_string   ( element, "ServiceNumber"   ));
		setORDER_REGION_ID( RocketUtils.IMetaX._jj_string   ( element, "CityId"          ));
		setORG_ID         ( RocketUtils.IMetaX._jj_string   ( element, "SalesOrganizeId" ));
		setSTAFF_ID       ( RocketUtils.IMetaX._jj_string   ( element, "SalesPersonId"   ));
		_order           = new IRocketOfferHome( this                                     );
	}
	
	public IOVMocketExigence( IISPCRocket _rocket_ ) throws Exception{
		super();
		SFCenterOffer _center_ = CenterUtils.ISystem._custom( _rocket_ );
		ORDER_ID        = _rocket_.getOrderId       ();                        
		CUST_ORDER      = _rocket_.getCustOrder     ();                        
		DONE_CODE       = _rocket_.getDoneCode      ();                        
		DONE_DATE       = _rocket_.getDoneDate      ();                        
		CATALOG_ID      = _rocket_.getCatalogId     ();                        
		BUSINESS_ID     = _rocket_.getBusinessId    ();                        
		ORIGINATOR      = _rocket_.getOriginate     ();                        
		CHANNEL_ID      = _rocket_.getChannelId     ();                        
		USER_ID         = _rocket_.getUserId        ();                        
		BILL_ID         = _rocket_.getBillId        ();                        
		CREATE_DATE     = _rocket_.getCreateDate    ();                        
		ORDER_REGION_ID = _rocket_.getRegionId      ();
		REGION_ID       = _center_.getREGION_ID     ();
		STATE           = _rocket_.getState         ();                        
		PRIORITY        = _rocket_.getPriority      (); 
		FAIL_CODE       = _rocket_.getFailCode      ();
		FAIL_LOG        = _rocket_.getFailLog       ();                        
		COMPLETE_DATE   = _rocket_.getCompleteDate  ();   
		RETRY_TIMES     = _rocket_.getRetryTimes    ();
		ORDER_DATE      = _rocket_.getOrderDate     ();
		PLWK_CREATE     = _rocket_.getPlwkCreate    ();
		PLWK_COMPLETE   = _rocket_.getPlwkComplete  ();
		ORG_ID          = _rocket_.getOrgId         ();                        
		STAFF_ID        = _rocket_.getStaffId       ();
		INSTANCE        = _rocket_                    ;
		_order          = new IRocketOfferHome( this );
	}
	
	public IOVMocketExigence( java.util.Map<String,Object> fromRocket ) throws Exception{
		super();
		IISPCRocket _rocket_ = new ISPCRocket();
		OracleUtils.ICustom.transfer( fromRocket, _rocket_ );
		SFCenterOffer _center_ = CenterUtils.ISystem._custom( _rocket_ );
		ORDER_ID        = _rocket_.getOrderId       ();                        
		CUST_ORDER      = _rocket_.getCustOrder     ();                        
		DONE_CODE       = _rocket_.getDoneCode      ();                        
		DONE_DATE       = _rocket_.getDoneDate      ();                        
		CATALOG_ID      = _rocket_.getCatalogId     ();                        
		BUSINESS_ID     = _rocket_.getBusinessId    ();                        
		ORIGINATOR      = _rocket_.getOriginate     ();                        
		CHANNEL_ID      = _rocket_.getChannelId     ();                        
		USER_ID         = _rocket_.getUserId        ();                        
		BILL_ID         = _rocket_.getBillId        ();                        
		CREATE_DATE     = _rocket_.getCreateDate    ();                        
		ORDER_REGION_ID = _rocket_.getRegionId      ();  
		REGION_ID       = _center_.getREGION_ID     ();
		STATE           = _rocket_.getState         ();                        
		PRIORITY        = _rocket_.getPriority      ();    
		FAIL_CODE       = _rocket_.getFailCode      ();
		FAIL_LOG        = _rocket_.getFailLog       ();                        
		COMPLETE_DATE   = _rocket_.getCompleteDate  ();
		RETRY_TIMES     = _rocket_.getRetryTimes    ();
		ORDER_DATE      = _rocket_.getOrderDate     ();
		PLWK_CREATE     = _rocket_.getPlwkCreate    ();
		PLWK_COMPLETE   = _rocket_.getPlwkComplete  ();
		ORG_ID          = _rocket_.getOrgId         ();                        
		STAFF_ID        = _rocket_.getStaffId       ();
		INSTANCE        = _rocket_                    ;
		_order          = new IRocketOfferHome( this );
		INSTANCE.setStsToOld();
	}
	
	public IOVMocketExigence( IOVMocketExigence _rocket_ ) throws Exception{
		super();
		ORDER_ID        = _rocket_.ORDER_ID                            ;                        
		CUST_ORDER      = _rocket_.CUST_ORDER                          ;                        
		DONE_CODE       = _rocket_.DONE_CODE                           ;                        
		DONE_DATE       = _rocket_.DONE_DATE                           ;                        
		CATALOG_ID      = _rocket_.CATALOG_ID                          ;                        
		BUSINESS_ID     = _rocket_.BUSINESS_ID                         ;                        
		ORIGINATOR      = _rocket_.ORIGINATOR                          ;                        
		CHANNEL_ID      = _rocket_.CHANNEL_ID                          ;                        
		USER_ID         = _rocket_.USER_ID                             ;                        
		BILL_ID         = _rocket_.BILL_ID                             ;                        
		CREATE_DATE     = _rocket_.CREATE_DATE                         ;                        
		ORDER_REGION_ID = _rocket_.ORDER_REGION_ID                     ;  
		REGION_ID       = _rocket_.REGION_ID                           ;
		STATE           = _rocket_.STATE                               ;                        
		PRIORITY        = _rocket_.PRIORITY                            ;    
		FAIL_CODE       = _rocket_.FAIL_CODE                           ;
		FAIL_LOG        = _rocket_.FAIL_LOG                            ;                        
		COMPLETE_DATE   = _rocket_.COMPLETE_DATE                       ;
		RETRY_TIMES     = _rocket_.RETRY_TIMES                         ;
		ORDER_DATE      = _rocket_.ORDER_DATE                          ;
		PLWK_CREATE     = _rocket_.PLWK_CREATE                         ;
		PLWK_COMPLETE   = _rocket_.PLWK_COMPLETE                       ;
		ORG_ID          = _rocket_.ORG_ID                              ;                        
		STAFF_ID        = _rocket_.STAFF_ID                            ;
		_order          = new IRocketOfferHome( this, _rocket_._order );
		INSTANCE        = (ISPCRocket)OracleUtils.ISystem.transfer( _rocket_.INSTANCE );
	}
	
	/**
	 * @return the oRDER_ID
	 */
	public long getORDER_ID() {
		return ORDER_ID;
	}

	/**
	 * @param oRDER_ID the oRDER_ID to set
	 */
	public void setORDER_ID(long oRDER_ID) {
		ORDER_ID = oRDER_ID;
		if (INSTANCE != null) INSTANCE.setOrderId(oRDER_ID);
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
		if (INSTANCE != null) INSTANCE.setCustOrder(cUST_ORDER);
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
		if (INSTANCE != null) INSTANCE.setDoneCode(dONE_CODE);
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
		if (INSTANCE != null) INSTANCE.setDoneDate(dONE_DATE);
	}

	/**
	 * @return the cATALOG_ID
	 */
	public String getCATALOG_ID() {
		return CATALOG_ID;
	}

	/**
	 * @param cATALOG_ID the cATALOG_ID to set
	 */
	public void setCATALOG_ID(String cATALOG_ID) {
		CATALOG_ID = cATALOG_ID;
		if (INSTANCE != null) INSTANCE.setCatalogId(cATALOG_ID);
	}

	/**
	 * @return the bUSINESS_ID
	 */
	public String getBUSINESS_ID() {
		return BUSINESS_ID;
	}

	/**
	 * @param bUSINESS_ID the bUSINESS_ID to set
	 */
	public void setBUSINESS_ID(String bUSINESS_ID) {
		BUSINESS_ID = bUSINESS_ID;
		if (INSTANCE != null) INSTANCE.setBusinessId(bUSINESS_ID);
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
		if (INSTANCE != null) INSTANCE.setOriginate(oRIGINATOR);
	}

	/**
	 * @return the cHANNEL_ID
	 */
	public String getCHANNEL_ID() {
		return CHANNEL_ID;
	}

	/**
	 * @param cHANNEL_ID the cHANNEL_ID to set
	 */
	public void setCHANNEL_ID(String cHANNEL_ID) {
		CHANNEL_ID = cHANNEL_ID;
		if (INSTANCE != null) INSTANCE.setChannelId(cHANNEL_ID);
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
		if (INSTANCE != null) INSTANCE.setUserId(uSER_ID);
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
		if (INSTANCE != null) INSTANCE.setBillId(bILL_ID);
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
		if (INSTANCE != null) INSTANCE.setCreateDate(cREATE_DATE);
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
		if (INSTANCE != null) INSTANCE.setRegionId( oRDER_REGION_ID );
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
		if (INSTANCE != null) INSTANCE.setState(sTATE);
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
		_order._priority = pRIORITY;
		if (INSTANCE != null) INSTANCE.setPriority(pRIORITY);
	}

	/**
	 * @return the fAIL_CODE
	 */
	public String getFAIL_CODE() {
		return FAIL_CODE;
	}

	/**
	 * @param fAIL_CODE the fAIL_CODE to set
	 */
	public void setFAIL_CODE(String fAIL_CODE) {
		FAIL_CODE = fAIL_CODE;
		//if (INSTANCE != null) INSTANCE.setFailCode(fAIL_CODE);
	}

	/**
	 * @return the fAIL_REASON
	 */
	public String getFAIL_REASON() {
		return FAIL_REASON;
	}

	/**
	 * @param fAIL_REASON the fAIL_REASON to set
	 */
	public void setFAIL_REASON(String fAIL_REASON) {
		FAIL_REASON = fAIL_REASON;
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
		if (INSTANCE != null) INSTANCE.setFailLog(fAIL_LOG);
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
		if (INSTANCE != null) INSTANCE.setCompleteDate(cOMPLETE_DATE);
	}

	/**
	 * @return the rETRY_TIMES
	 */
	public long getRETRY_TIMES() {
		return RETRY_TIMES;
	}

	/**
	 * @param rETRY_TIMES the rETRY_TIMES to set
	 */
	public void setRETRY_TIMES(long rETRY_TIMES) {
		RETRY_TIMES = rETRY_TIMES;
		//if (INSTANCE != null) INSTANCE.setRetryTimes( (int)rETRY_TIMES );
	}

	/**
	 * @return the oRDER_DATE
	 */
	public java.sql.Timestamp getORDER_DATE() {
		return ORDER_DATE;
	}

	/**
	 * @param oRDER_DATE the oRDER_DATE to set
	 */
	public void setORDER_DATE(java.sql.Timestamp oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
		//if (INSTANCE != null) INSTANCE.setOrderDate( oRDER_DATE );
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
		if (INSTANCE != null) INSTANCE.setPlwkCreate(pLWK_CREATE);
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
		if (INSTANCE != null) INSTANCE.setPlwkComplete(pLWK_COMPLETE);
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
		if (INSTANCE != null) INSTANCE.setOrgId(oRG_ID);
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
		if (INSTANCE != null) INSTANCE.setStaffId(sTAFF_ID);
	}

	/**
	 * @return the iNSTANCE
	 */
	public IISPCRocket getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(IISPCRocket iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
	
	/**
	 * 是否为报竣定单
	 * @return
	 */
	public boolean isCOMPLETE(){
		return STATE != null && StringUtils.equals( STATE, IUpdbfsConst.IState.F );
	}
	
	/**
	 * 是否为历史定单
	 * @return
	 */
	public boolean isHISTORY(){
		return STATE != null && StringUtils.equals( STATE, IUpdbfsConst.IState.H );
	}
	
	/**
	 * 是否为网元定单
	 * @return
	 */
	public boolean isNETWORK(){
		return STATE != null && StringUtils.contains( STATE, new String[]{ 
				IUpdbfsConst.IState.F, IUpdbfsConst.IState.H } ) == false;
	}
	
	/**
	 * 工单时序
	 * @return
	 */
	public String getTIMESQ( ){
		return ClassUtils.getINDEX( new String[]{ 
                StringUtils.filling( TimeUtils.format( CREATE_DATE, "yyyyMMddHHmmssSSS"), 
                		17,
                		StringUtils.LEFT,
                		' '),
                "_$_",  
                StringUtils.filling( String.valueOf( ORDER_ID ), 
                		15, 
                		StringUtils.RIGHT,
                		'0')} );
	}
	
	/**
	 * @return the _order
	 */
	public IRocketOfferHome getORDER() {
		return _order;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective!=null && objective instanceof IOVMocketExigence){
			return ((IOVMocketExigence)objective).ORDER_ID == ORDER_ID;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try {
			doCompare = objective != null && objective instanceof IOVMocketExigence ? 0 : 1;
			if (doCompare == 0) {
				IOVMocketExigence aExigence = (IOVMocketExigence)objective;
				doCompare = _order._priority - aExigence._order._priority;
				if (doCompare == 0) {
					doCompare = getTIMESQ().compareTo(aExigence.getTIMESQ());
				}
			}
		} finally {

		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年4月26日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IRocketOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -3196106623801604211L;
		/*包体*/
		private String _body;
		/*优先级*/
		private long   _priority;
		/*开通定单项*/
		private IOVMocketExigence _rocket_ = null;
		/*资产组件*/
		private ISystemTemplate.IImplCapital _component_;
		/*归属网元*/
		private IPlatformTemplate.IUpffmOffer _complete_;
		/*报文清单*/
		private CarbonList<IOVMocketOffer> _order = new CarbonList<IOVMocketOffer>();
		public IRocketOfferHome(){
			super();
		}
		
		public IRocketOfferHome( IOVMocketExigence __rocket__ ){
			super();
			_rocket_  = __rocket__       ;
			_priority = _rocket_.PRIORITY;
		}
		
		public IRocketOfferHome( IRocketOfferHome __order__ ) throws Exception{
			super();
			_body       = __order__._body      ;
			_priority   = __order__._priority  ;
			_component_ = __order__._component_;
			_complete_  = __order__._complete_ ;
			for( java.util.Iterator<IOVMocketOffer> itera = __order__._order.iterator(); itera.hasNext(); ){
				IOVMocketOffer __rocketx__ = (IOVMocketOffer)itera.next();
				_order.add( new IOVMocketOffer( __rocketx__ ) );
			}
		}
		
		public IRocketOfferHome( IOVMocketExigence __rocket__, IRocketOfferHome __order__ ) throws Exception{
			super();
			_rocket_    = __rocket__           ;
			_body       = __order__._body      ;
			_priority   = __order__._priority  ;
			_component_ = __order__._component_;
			_complete_  = __order__._complete_ ;
			for( java.util.Iterator<IOVMocketOffer> itera = __order__._order.iterator(); itera.hasNext(); ){
				IOVMocketOffer __rocketx__ = (IOVMocketOffer)itera.next();
				_order.add( new IOVMocketOffer( __rocketx__ ) );
			}
		}
		
		/**
		 * @return 包体
		 */
		public String getBODY() {
			StringBuilder fromBODY = new StringBuilder();
			try
			{
				if( StringUtils.isBlank( _body ) ){
					for( java.util.Iterator<IOVMocketOffer> itera = _order.iterator(); itera.hasNext(); ){
						IOVMocketOffer fromOffer = (IOVMocketOffer)itera.next();
						String fromMSG = ExigenceUtils.ICustom.ICustomX._mergex( fromOffer );
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
		 * @return 资产组件
		 */
		public ISystemTemplate.IImplCapital getCOMPONENT() {
			if( _component_ == null && _rocket_ != null ){
				try
				{
					IProfessionalTemplate.IBusinesOffer __component__ = null;
					if( ( __component__ = ExigenceUtils.ISystem.getBUSINESS( _rocket_ ) ) != null ){
						_component_ = SystemUtils.ISystem.getSFUpfgkmCapital( __component__.getIMPLCLASS() ); 
					}
					
				}
				catch( java.lang.Exception exception){
					
				}
			}
			return _component_;
		}

		/**
		 * @return 归属网元
		 */
		public IPlatformTemplate.IUpffmOffer getCOMPLETE() {
			if( _complete_ == null && _rocket_ != null ){
				try
				{
					IProfessionalTemplate.IBusinesOffer __component__ = null;
					if( _component_ != null ){
						_complete_ = UpdcUtils.ISubFlow.getPLATFORM( _component_ );
					}
					else if( ( __component__ = ExigenceUtils.ISystem.getBUSINESS( _rocket_ ) ) != null ) {
						_component_ = SystemUtils.ISystem.getSFUpfgkmCapital( __component__.getIMPLCLASS() ); 
						_complete_ = UpdcUtils.ISubFlow.getPLATFORM( _component_ );
					}
					else{
						_complete_ = UpdcUtils.ISubFlow.getPLATFORM();
					}
				}
				catch( java.lang.Exception exception ){
					try{ _complete_ = UpdcUtils.ISubFlow.getPLATFORM(); }catch( java.lang.Exception _exception ){}
				}
			}
			return _complete_;
		}

		/**
		 * @return 报文清单
		 */
		public CarbonList<IOVMocketOffer> getORDER() {
			return _order;
		}
		
	}
}
