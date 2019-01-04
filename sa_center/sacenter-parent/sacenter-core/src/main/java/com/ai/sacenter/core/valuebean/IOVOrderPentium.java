package com.ai.sacenter.core.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.core.bo.ISAOrder;
import com.ai.sacenter.core.bo.SAOrderFail;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.IPeriodGraphToken;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.valuebean.IOrderRsRspHome;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务定单</p>
 * <p>Copyright: Copyright (c) 2011-10-13</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVOrderPentium implements java.io.Serializable,java.lang.Comparable {
	private static final long serialVersionUID = 3358683086036683060L;
	private long   ORDER_ID       ;
	private String CUST_ORDER     ;
	private String DONE_CODE      ;
	private String CATEGORY       ;
	private String CATALOG        ;
	private String BUSINESS       ;
	private long   USER_ID        ;
	private String BILL_ID        ;
	private String SUB_BILL_ID    ;
	private java.sql.Timestamp CREATE_DATE    ;
	private String REGION_ID      ;
	private String REGION_CODE    ;
	private String COMPETENCE     ;
	private long   CREATE_ORDER_ID;
	private long   CREATE_TASK_ID ;
	private long   GROUP_ORDER_ID ;
	private String USER_REGION_ID ;
	private String ORDER_REGION_ID;
	private long   PRIORITY       ;
	private String COMPOSITE      ;
	private java.sql.Timestamp ORDER_DATE;
	private String CHANNEL        ;
	private String FAIL_LOG       ;
	private String ORG_ID         ;
	private String STAFF_ID       ;
	private java.sql.Timestamp COMPLETE_DATE  ;
	private String STATE          ;
	private java.sql.Timestamp STATE_DATE     ;
	private ISAOrder  INSTANCE = null;
	private IOrderOfferHome _order = new IOrderOfferHome();
	public IOVOrderPentium(){
		super();
	}
	
	public IOVOrderPentium( ISAOrder aORDER ) throws Exception{
		super();
		UpdcUtils.ICustom._wrap( aORDER, this );
		INSTANCE = aORDER;
	}
	
	public IOVOrderPentium( IOVOrderPentium aORDER ) throws Exception{
		super();
		ORDER_ID        = aORDER.ORDER_ID       ;
		CUST_ORDER      = aORDER.CUST_ORDER     ;
		DONE_CODE       = aORDER.DONE_CODE      ;
		CATEGORY        = aORDER.CATEGORY       ;
		CATALOG         = aORDER.CATALOG        ;
		BUSINESS        = aORDER.BUSINESS       ;
		USER_ID         = aORDER.USER_ID        ;
		BILL_ID         = aORDER.BILL_ID        ;
		SUB_BILL_ID     = aORDER.SUB_BILL_ID    ;
		CREATE_DATE     = aORDER.CREATE_DATE    ;
		REGION_ID       = aORDER.REGION_ID      ;
		REGION_CODE     = aORDER.REGION_CODE    ;
		COMPETENCE      = aORDER.COMPETENCE     ;
		CREATE_ORDER_ID = aORDER.CREATE_ORDER_ID;
		CREATE_TASK_ID  = aORDER.CREATE_TASK_ID ;
		GROUP_ORDER_ID  = aORDER.GROUP_ORDER_ID ;
		USER_REGION_ID  = aORDER.USER_REGION_ID ;
		ORDER_REGION_ID = aORDER.ORDER_REGION_ID;
		PRIORITY        = aORDER.PRIORITY       ;
		COMPOSITE       = aORDER.COMPOSITE      ;
		ORDER_DATE      = aORDER.ORDER_DATE     ;    
		CHANNEL         = aORDER.CHANNEL        ;
		FAIL_LOG        = aORDER.FAIL_LOG       ;
		ORG_ID          = aORDER.ORG_ID         ;
		STAFF_ID        = aORDER.STAFF_ID       ;
		COMPLETE_DATE   = aORDER.COMPLETE_DATE  ;
		STATE           = aORDER.STATE          ;
		STATE_DATE      = aORDER.STATE_DATE     ;
		INSTANCE        = (ISAOrder)OracleUtils.ISystem.transfer( aORDER.INSTANCE );
		_order._wrap( aORDER._order );
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
		if(INSTANCE != null ){ INSTANCE.setOrderId( oRDER_ID ); }
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
		if(INSTANCE != null ){ INSTANCE.setCustOrder( cUST_ORDER ); }
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
		if(INSTANCE != null ){ INSTANCE.setDoneCode( dONE_CODE ); }
	}

	/**
	 * @return the cATEGORY
	 */
	public String getCATEGORY() {
		return CATEGORY;
	}

	/**
	 * @param cATEGORY the cATEGORY to set
	 */
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
		if(INSTANCE != null ){ INSTANCE.setCategory( cATEGORY ); }
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
		if(INSTANCE != null ){ INSTANCE.setCatalog( cATALOG ); }
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
		if(INSTANCE != null ){ INSTANCE.setBusiness( bUSINESS ); }
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
		if(INSTANCE != null ){ INSTANCE.setUserId( uSER_ID ); }
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
		if(INSTANCE != null ){ INSTANCE.setBillId( bILL_ID ); }
	}

	/**
	 * @return the sUB_BILL_ID
	 */
	public String getSUB_BILL_ID() {
		return SUB_BILL_ID;
	}

	/**
	 * @param sUB_BILL_ID the sUB_BILL_ID to set
	 */
	public void setSUB_BILL_ID(String sUB_BILL_ID) {
		SUB_BILL_ID = sUB_BILL_ID;
		if(INSTANCE != null ){ INSTANCE.setSubBillId( sUB_BILL_ID ); }
	}

	/**
	 * @return the cOMPETENCE
	 */
	public String getCOMPETENCE() {
		return COMPETENCE;
	}

	/**
	 * @param cOMPETENCE the cOMPETENCE to set
	 */
	public void setCOMPETENCE(String cOMPETENCE) {
		COMPETENCE = cOMPETENCE;
		if(INSTANCE != null ){ INSTANCE.setCompetence( cOMPETENCE ); }
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
		if(INSTANCE != null ){ INSTANCE.setCreateDate( cREATE_DATE ); }
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
		if(INSTANCE != null ){ INSTANCE.setRegionId( rEGION_ID ); }
	}

	/**
	 * @return the rEGION_CODE
	 */
	public String getREGION_CODE() {
		return REGION_CODE;
	}

	/**
	 * @param rEGION_CODE the rEGION_CODE to set
	 */
	public void setREGION_CODE(String rEGION_CODE) {
		REGION_CODE = rEGION_CODE;
		if(INSTANCE != null ){ INSTANCE.setRegionCode( rEGION_CODE ); }
	}

	/**
	 * @return the cREATE_ORDER_ID
	 */
	public long getCREATE_ORDER_ID() {
		return CREATE_ORDER_ID;
	}

	/**
	 * @param cREATE_ORDER_ID the cREATE_ORDER_ID to set
	 */
	public void setCREATE_ORDER_ID(long cREATE_ORDER_ID) throws Exception{
		CREATE_ORDER_ID = cREATE_ORDER_ID;
		if(INSTANCE != null && cREATE_ORDER_ID > 0 ) { INSTANCE.setCreateOrderId( cREATE_ORDER_ID ); }
		else if(INSTANCE != null ){ INSTANCE.set( ISAOrder.S_CreateOrderId, null );}
	}

	/**
	 * @return the cREATE_TASK_ID
	 */
	public long getCREATE_TASK_ID() {
		return CREATE_TASK_ID;
	}

	/**
	 * @param cREATE_TASK_ID the cREATE_TASK_ID to set
	 */
	public void setCREATE_TASK_ID(long cREATE_TASK_ID) throws Exception{
		CREATE_TASK_ID = cREATE_TASK_ID;
		if(INSTANCE != null && cREATE_TASK_ID > 0 ) { INSTANCE.setCreateTaskId( cREATE_TASK_ID ); }
		else if(INSTANCE != null ){ INSTANCE.set( ISAOrder.S_CreateTaskId, null ); }
	}

	/**
	 * @return the gROUP_ORDER_ID
	 */
	public long getGROUP_ORDER_ID() {
		return GROUP_ORDER_ID;
	}

	/**
	 * @param gROUP_ORDER_ID the gROUP_ORDER_ID to set
	 */
	public void setGROUP_ORDER_ID(long gROUP_ORDER_ID) throws Exception{
		GROUP_ORDER_ID = gROUP_ORDER_ID;
		if(INSTANCE != null && gROUP_ORDER_ID > 0 ) { INSTANCE.setGroupOrderId( gROUP_ORDER_ID ); }
		else if(INSTANCE != null ){ INSTANCE.set( ISAOrder.S_GroupOrderId, null ); }
	}

	/**
	 * @return the uSER_REGION_ID
	 */
	public String getUSER_REGION_ID() {
		return USER_REGION_ID;
	}

	/**
	 * @param uSER_REGION_ID the uSER_REGION_ID to set
	 */
	public void setUSER_REGION_ID(String uSER_REGION_ID) {
		USER_REGION_ID = uSER_REGION_ID;
		if( INSTANCE != null ){ INSTANCE.setUserRegionId( uSER_REGION_ID ); }
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
		if( INSTANCE != null ){ INSTANCE.setOrderRegionId( oRDER_REGION_ID ); }
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
		if(INSTANCE != null ){ INSTANCE.setPriority( pRIORITY ); }
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
		if( INSTANCE != null ){ INSTANCE.setComposite( cOMPOSITE ); }
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
		if( INSTANCE != null ){ INSTANCE.setOrderDate( oRDER_DATE ); }
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
		if(INSTANCE != null ){ INSTANCE.setChannelId( cHANNEL ); }
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
		if( INSTANCE != null ){ INSTANCE.setFailLog( fAIL_LOG ); }
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
		if(INSTANCE != null ){ INSTANCE.setOrgId( oRG_ID ); }
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
		if(INSTANCE != null ){ INSTANCE.setStaffId( sTAFF_ID ); }
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
		if(INSTANCE != null ){ INSTANCE.setCompleteDate( cOMPLETE_DATE ); }
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
		if(INSTANCE != null ){ INSTANCE.setState( sTATE ); }
	}
	/**
	 * 
	 * @param fromFirst
	 * @param fromSecond
	 */
	public void setSTATE( String fromFirst, String fromSecond ){
		StringBuilder fromSTATE = new StringBuilder();
		try
		{
			if( fromSecond.length() > 1 ) fromSTATE.append( fromSecond );
			else fromSTATE.append(" ").append( fromSecond );
			if( StringUtils.isBlank( fromFirst ) == false ){
				fromSTATE.setCharAt( 0, fromFirst.charAt( fromFirst.length() - 1 ) );
			}
			else{
				fromSTATE.setCharAt( 0, ' ' );
			}
			setSTATE( fromSTATE.toString().trim() );
		}
		finally{
			if( fromSTATE != null ){ fromSTATE = null; }
		}
	}
	/**
	 * @return the sTATE_DATE
	 */
	public java.sql.Timestamp getSTATE_DATE() {
		return STATE_DATE;
	}

	/**
	 * @param sTATE_DATE the sTATE_DATE to set
	 */
	public void setSTATE_DATE(java.sql.Timestamp sTATE_DATE) {
		STATE_DATE = sTATE_DATE;
		if(INSTANCE != null ){ INSTANCE.setStateDate( sTATE_DATE ); }
	}

	/**
	 * @return the iNSTANCE
	 */
	public ISAOrder getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(ISAOrder iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	/**
	 * @return _order
	 */
	public IOrderOfferHome getORDER() {
		return _order;
	}

	/**
	 * 是否到期服务定单 
	 * @return
	 */
	public boolean isEXPIRE(){
		return StringUtils.equals( COMPOSITE, IUpdcConst.IUpdbm.IUpdbf.EXPIRE ) ;
	}
	
	/**
	 * 是否为正常服务定单
	 * @return
	 */
	public boolean isNORMALLY(){
		return StringUtils.equals( CATEGORY, IUpdcConst.IUpdbm.IUpdbf.NORMAL ) ;
	}
	
	/**
	 * 是否为服务异常定单
	 * @return
	 */
	public boolean isEXCEPTION(){
		return StringUtils.wildcardMatch( CATEGORY, IUpdcConst.IUpdbm.IUpdbf.EXCEPTION );
	}
	
	/**
	 * 是否为群组定单
	 * @return
	 */
	public boolean isGROUP(){
		return StringUtils.wildcardMatch( CATEGORY, IUpdcConst.IUpdbm.IUpdbf.GROUP );
	}
	
	/**
	 * 是否为成员定单
	 * @return
	 */
	public boolean isMEMBER(){
		return StringUtils.wildcardMatch( CATEGORY, IUpdcConst.IUpdbm.IUpdbf.MEMBER );
	}
	
	/**
	 * 判断服务定单是否为落地定单
	 * @return
	 */
	public boolean isHUMAN(){
		return INSTANCE != null && INSTANCE instanceof SAOrderFail;
	}
	
	/**
	 * 是否具备工单拆分条件
	 * @return
	 */
	public boolean isSUBFLOW(){
		return StringUtils.equals( STATE, IUpdcConst.IState.C ) && _order._offer.size() > 0;
	}
	
	/**
	 * 正常竣工
	 * @return
	 */
	public boolean isCOMPLETE(){
		return StringUtils.contains( STATE, new String[]{IUpdcConst.IState.O,IUpdcConst.IState.F});
	}
	
	/**
	 * 在途工单
	 * @return
	 */
	public boolean isRUNNING(){
		return StringUtils.contains( STATE, new String[]{IUpdcConst.IState.C,IUpdcConst.IState.R});
	}
	
	/**
	 * 判断流程是否满足反馈外部系统
	 * @return
	 */
	public boolean isCHECKIN(){
		boolean fromCHECKIN = false;
		try
		{
			fromCHECKIN = _order._competence != null && StringUtils.isBlank( 
					_order._competence.getCOMPLETE() ) == false;
			if (fromCHECKIN == true) {
				fromCHECKIN = StringUtils.contains(STATE, new String[] {
						IUpdcConst.IState.O, IUpdcConst.IState.E,
						IUpdcConst.IState.Q, IUpdcConst.IState.F,
						IUpdcConst.IState.S, IUpdcConst.IState.H });
			}
		}
		finally{
			
		}
		return fromCHECKIN;
	}
	
	/**
	 * 流程单归档到历史表
	 * @return
	 */
	public boolean isHISTORY(){
		return StringUtils.contains( STATE, new String[]{IUpdcConst.IState.O, IUpdcConst.IState.F, IUpdcConst.IState.K } )
				|| StringUtils.startWith( STATE, new String[]{IUpdcConst.IState.Q, IUpdcConst.IState.E } );
	}
	
	/**
	 * 流程单归档到落地表
	 * @return
	 */
	public boolean isFAILURE(){
		return isHUMAN() == false && StringUtils.startWith( STATE, new String[]{
				IUpdcConst.IState.H, IUpdcConst.IState.S } );
	}
	
	/**
	 * 无流程单归档
	 * @return
	 */
	public boolean isOFFLINE(){
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		int doCompare = 1;
		doCompare = obj != null && obj instanceof IOVOrderPentium ? 0 : 1;
		if (doCompare == 0)
			doCompare = (new Long(ORDER_ID)).compareTo(new Long(
					((IOVOrderPentium) obj).ORDER_ID));
		return doCompare;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean doEqual = obj == null || (obj instanceof IOVOrderPentium) == false ? false: true;
		if (doEqual == true){
			doEqual = ((IOVOrderPentium) obj).ORDER_ID == ORDER_ID;
		}
		return doEqual;
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-4-7</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IOrderOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -7587375352690752540L;
		/*服务激活令牌*/
        private IPeriodGraphToken _token = new IPeriodGraphToken();
        /*服务能力模板*/
        private IProfessionalTemplate.ICompetenceOffer  _competence;
        /*服务产品订购*/
        private java.util.List    _offer   = new java.util.ArrayList();
        /*外部反馈*/
        private IOrderRsRspHome   _respond = null;
        public IOrderOfferHome(){
			super();
		}
        
		/**
		 * @return 服务令牌
		 */
		public IPeriodGraphToken getTOKEN() {
			return _token;
		}
		
		/**
		 * @return 服务能力模板
		 */
		public IProfessionalTemplate.ICompetenceOffer getCOMPETENCE() {
			return _competence;
		}
		
		/**
		 * @param cOMPETENCE 服务能力模板
		 */
		public void setCOMPETENCE(IProfessionalTemplate.ICompetenceOffer cOMPETENCE) {
			_competence = cOMPETENCE;
		}
		
		/**
		 * @return 服务产品订购
		 */
		public java.util.List getOFFER() {
			return _offer;
		}
		
		/**
		 * @return 外部反馈
		 */
		public IOrderRsRspHome getRESPOND() {
			return _respond;
		}

		/**
		 * @param respond 外部反馈
		 */
		public void setRESPOND(IOrderRsRspHome respond) {
			_respond = respond;
		}

		/**
		 * 合并开通反馈报文[添加开通结果]
		 * @param fromRsRspHome 开通反馈明细
		 */
		public void mergeAsRespond( IOVUpfwmResponse result ){
			if( _respond == null ){ _respond = new IOrderRsRspHome(); }
			_respond.mergeAsGroup( result );
		}
		
		/**
		 * 根据服务订购编号查询服务产品订购
		 * @param aOFFER_ID 服务订购编号
		 * @return
		 */
		public IOVOfferPentium getOFFER( long aOFFER_ID ){
			try
			{
				for( java.util.Iterator itera = _offer.iterator(); itera.hasNext(); ){
					IOVOfferPentium fromOffer = (IOVOfferPentium) itera.next();
					if( fromOffer.getOFFER_ID() == aOFFER_ID){
						   return fromOffer;
					}
				}
			}
			finally{
				
			}
			return null;
		}
		
		/**
		 * 
		 * @param fromHome
		 * @throws Exception
		 */
		public void _wrap( IOrderOfferHome fromHome ) throws Exception{
			_token._wrap( fromHome._token );
			_competence = fromHome._competence;
			if( fromHome._respond != null ){
				_respond = new IOrderRsRspHome( fromHome._respond );
			}
			for( java.util.Iterator itera = fromHome._offer.iterator(); itera.hasNext(); ){
				IOVOfferPentium fromOffer = (IOVOfferPentium)itera.next();
				_offer.add( new IOVOfferPentium( fromOffer ) );
			}
		}
		
		/**
		 * 是否存在有效开通产品订购拆分
		 * @return
		 */
		public boolean isSUBFLOW(){
			return _offer != null && _offer.size() > 0?true:false;
		}
	}
}
