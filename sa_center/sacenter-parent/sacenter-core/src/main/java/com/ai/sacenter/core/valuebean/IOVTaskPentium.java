package com.ai.sacenter.core.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.core.bo.ISATask;
import com.ai.sacenter.core.bo.SATaskFail;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.IPeriodGraphToken;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmDirective;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOperate;
import com.ai.sacenter.valuebean.IProgramTemplate.IUpdfcmpOffer;
import com.ai.sacenter.valuebean.ISystemTemplate.IUpdbpmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务任务</p>
 * <p>Copyright: Copyright (c) 2011-10-13</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVTaskPentium implements java.io.Serializable,java.lang.Comparable{
	private static final long serialVersionUID = -6531541784026503425L;
	private long   TASK_ID       ;                                                                                                                                                               
	private long   ORDER_ID      ;      
	private long   OFFER_ID      ;
	private long   USER_ID       ;                                                                                                                                                               
	private java.sql.Timestamp CREATE_DATE   ;                                                                                                                                                               
	private String REGION_ID     ;                                                                                                                                                               
	private long   SUBFLOW       ;                                                                                                                                                               
	private String PLATFORM      ;                                                                                                                                                               
	private String DIRECTIVE     ;                                                                                                                                                               
	private String PLWK_CODING   ;                                                                                                                                                               
	private java.sql.Timestamp PLWK_CREATE   ;
	private java.sql.Timestamp PLWK_COMPLETE ;
	private long   PRIORITY      ;                                                                                                                                                               
	private long   SORT_BY       ;                                                                                                                                                               
	private String PARAM         ;                                                                                                                                                               
	private long   DEPEND_TASK_ID;                                                                                                                                                               
	private long   CREATE_TASK_ID;                                                                                                                                                               
	private String STATION_ID ;
	private long   REDO_TIMES    ;                                                                                                                                                               
	private long   DONE_TIMES    ;                                                                                                                                                               
	private String DONE_RESULT   ;                                                                                                                                                               
	private String STAFF_ID      ;                                                                                                                                                               
	private String ORG_ID        ;                                                                                                                                                               
	private String FAIL_LOG      ;                                                                                                                                                               
	private java.sql.Timestamp COMPLETE_DATE ;                                                                                                                                                               
	private String STATE         ;
	private java.sql.Timestamp STATE_DATE    ;  
	private ISATask  INSTANCE = null;
	private IOVTaskPentium CREATE  = null;
	private ITaskOfferHome _order = new ITaskOfferHome();
	public IOVTaskPentium() {
		super();
	}
	
	public IOVTaskPentium( ISATask aTASK ) throws Exception{
		super();
		UpdcUtils.ICustom._wrap( aTASK, this );
		INSTANCE = aTASK;
	}
	
	public IOVTaskPentium( IOVTaskPentium fromSRC ) throws Exception{
		super();
		TASK_ID        = fromSRC.TASK_ID       ;                                                                                                                                                               
		ORDER_ID       = fromSRC.ORDER_ID      ;      
		OFFER_ID       = fromSRC.OFFER_ID      ;
		USER_ID        = fromSRC.USER_ID       ;                                                                                                                                                               
		CREATE_DATE    = fromSRC.CREATE_DATE   ;                                                                                                                                                               
		REGION_ID      = fromSRC.REGION_ID     ;                                                                                                                                                               
		SUBFLOW        = fromSRC.SUBFLOW       ;                                                                                                                                                               
		PLATFORM       = fromSRC.PLATFORM      ;                                                                                                                                                               
		DIRECTIVE      = fromSRC.DIRECTIVE     ;                                                                                                                                                               
		PLWK_CODING    = fromSRC.PLWK_CODING   ;                                                                                                                                                               
		PLWK_CREATE    = fromSRC.PLWK_CREATE   ;
		PLWK_COMPLETE  = fromSRC.PLWK_COMPLETE ;
		PRIORITY       = fromSRC.PRIORITY      ;                                                                                                                                                               
		SORT_BY        = fromSRC.SORT_BY       ;                                                                                                                                                               
		PARAM          = fromSRC.PARAM         ;                                                                                                                                                               
		DEPEND_TASK_ID = fromSRC.DEPEND_TASK_ID;                                                                                                                                                               
		CREATE_TASK_ID = fromSRC.CREATE_TASK_ID;                                                                                                                                                               
		STATION_ID     = fromSRC.STATION_ID    ;
		REDO_TIMES     = fromSRC.REDO_TIMES    ;                                                                                                                                                               
		DONE_TIMES     = fromSRC.DONE_TIMES    ;                                                                                                                                                               
		DONE_RESULT    = fromSRC.DONE_RESULT   ;                                                                                                                                                               
		STAFF_ID       = fromSRC.STAFF_ID      ;                                                                                                                                                               
		ORG_ID         = fromSRC.ORG_ID        ;                                                                                                                                                               
		FAIL_LOG       = fromSRC.FAIL_LOG      ;                                                                                                                                                               
		COMPLETE_DATE  = fromSRC.COMPLETE_DATE ;                                                                                                                                                               
		STATE          = fromSRC.STATE         ;
		STATE_DATE     = fromSRC.STATE_DATE    ;
		INSTANCE       = (ISATask)OracleUtils.ISystem.transfer( fromSRC.INSTANCE );
		CREATE         = fromSRC.CREATE        ;
		_order._wrap( fromSRC._order );
	}
	
	public IOVTaskPentium( IOVOrderPentium fromOrder,
			IUpdbpmOffer fromUpdbm ) throws Exception{
		super();
		UpdcUtils.ICustom._wrap(this, fromOrder, fromUpdbm);
	}
	
	public IOVTaskPentium( IOVOrderPentium fromOrder , 
			IUpffmDirective fromUpdfm,
			IUpffmOperate fromUpfom , 
			IUpdbpmOffer fromUpdbm,
			IUpffmOffer fromUpfm ) throws Exception{
		super();
		UpdcUtils.ICustom._wrap(this, 
				fromOrder, 
				fromUpdbm, 
				fromUpfm, 
				fromUpfom);
		DIRECTIVE = fromUpdfm.getID();
	}
	
	/**
	 * @return the sTATION_ID
	 */
	public String getSTATION_ID() {
		return STATION_ID;
	}

	/**
	 * @param sTATION_ID the sTATION_ID to set
	 */
	public void setSTATION_ID(String sTATION_ID) {
		STATION_ID = sTATION_ID;
		if( INSTANCE != null ) INSTANCE.setStationId( sTATION_ID );
	}
	
	/**
	 * @return the cOMPLETE_DATE
	 */
	public java.sql.Timestamp getCOMPLETE_DATE() {
		return COMPLETE_DATE;
	}
	
	/**
	 * @param complete_date the cOMPLETE_DATE to set
	 */
	public void setCOMPLETE_DATE(java.sql.Timestamp complete_date) {
		COMPLETE_DATE = complete_date;
		if( INSTANCE != null ) INSTANCE.setCompleteDate( complete_date );
	}
	
	/**
	 * @return the cREATE
	 */
	public IOVTaskPentium getCREATE() {
		return CREATE;
	}
	
	/**
	 * @param create the cREATE to set
	 */
	public void setCREATE(IOVTaskPentium create) {
		CREATE = create;
	}
	
	/**
	 * @return the cREATE_DATE
	 */
	public java.sql.Timestamp getCREATE_DATE() {
		return CREATE_DATE;
	}
	
	/**
	 * @param create_date the cREATE_DATE to set
	 */
	public void setCREATE_DATE(java.sql.Timestamp create_date) {
		CREATE_DATE = create_date;
		if( INSTANCE != null ) INSTANCE.setCreateDate( create_date );
	}
	
	/**
	 * @return the cREATE_TASK_ID
	 */
	public long getCREATE_TASK_ID() {
		return CREATE_TASK_ID;
	}
	
	/**
	 * @param create_task_id the cREATE_TASK_ID to set
	 */
	public void setCREATE_TASK_ID(long create_task_id) throws Exception{
		CREATE_TASK_ID = create_task_id;
		if( INSTANCE != null && create_task_id > 0 ) INSTANCE.setCreateTaskId( create_task_id );
		else if( INSTANCE != null ) INSTANCE.set( ISATask.S_CreateTaskId, null );
		
	}
	
	/**
	 * @return the dEPEND_TASK_ID
	 */
	public long getDEPEND_TASK_ID() {
		return DEPEND_TASK_ID;
	}
	
	/**
	 * @param depend_task_id the dEPEND_TASK_ID to set
	 */
	public void setDEPEND_TASK_ID(long depend_task_id)  throws Exception{
		DEPEND_TASK_ID = depend_task_id;
		if( INSTANCE != null && depend_task_id > 0 ) INSTANCE.setDependTaskId( depend_task_id );
		else if( INSTANCE != null ) INSTANCE.set( ISATask.S_DependTaskId, null );
	}
	
	/**
	 * @return the dIRECTIVE
	 */
	public String getDIRECTIVE() {
		return DIRECTIVE;
	}
	
	/**
	 * @param directive the dIRECTIVE to set
	 */
	public void setDIRECTIVE(String directive) {
		DIRECTIVE = directive;
		if( INSTANCE != null ) INSTANCE.setDirective( directive );
	}
	
	/**
	 * @return the dONE_RESULT
	 */
	public String getDONE_RESULT() {
		return DONE_RESULT;
	}
	
	/**
	 * @param done_result the dONE_RESULT to set
	 */
	public void setDONE_RESULT(String done_result) {
		DONE_RESULT = done_result;
		if( INSTANCE != null ) INSTANCE.setDoneResult( done_result );
	}
	
	/**
	 * @return the dONE_TIMES
	 */
	public long getDONE_TIMES() {
		return DONE_TIMES;
	}
	
	/**
	 * @param done_times the dONE_TIMES to set
	 */
	public void setDONE_TIMES(long done_times) throws Exception{
		DONE_TIMES = done_times;
		if( INSTANCE != null && done_times >= 0 ) INSTANCE.setDoneTimes( (int)done_times );
		else if( INSTANCE != null ) INSTANCE.set( ISATask.S_DoneTimes, null );
	}
	
	/**
	 * @return the iNSTANCE
	 */
	public ISATask getINSTANCE() {
		return INSTANCE;
	}
	
	/**
	 * @param instance the iNSTANCE to set
	 */
	public void setINSTANCE(ISATask instance) {
		INSTANCE = instance; 
	}
	
	/**
	 * @return the oRDER_ID
	 */
	public long getORDER_ID() {
		return ORDER_ID;
	}
	
	/**
	 * @param order_id the oRDER_ID to set
	 */
	public void setORDER_ID(long order_id) {
		ORDER_ID = order_id;
		if( INSTANCE != null ) INSTANCE.setOrderId( order_id );
	}
	
	/**
	 * @return the oFFER_ID
	 */
	public long getOFFER_ID() {
		return OFFER_ID;
	}
	
	/**
	 * @param oFFER_ID the oFFER_ID to set
	 */
	public void setOFFER_ID(long oFFER_ID) {
		OFFER_ID = oFFER_ID;
		if( INSTANCE != null ) INSTANCE.setOfferId( oFFER_ID );
	}
	
	/**
	 * @return the oRG_ID
	 */
	public String getORG_ID() {
		return ORG_ID;
	}
	
	/**
	 * @param org_id the oRG_ID to set
	 */
	public void setORG_ID(String org_id) {
		ORG_ID = org_id;
		if( INSTANCE != null ) INSTANCE.setOrgId( org_id );
	}
	
	/**
	 * @return the pARAM
	 */
	public String getPARAM() {
		if( _order != null && _order._param.size() > 0 ) PARAM = JdomUtils.ICustom.wrap( _order._param, null );
		return PARAM;
	}
	
	/**
	 * @param param the pARAM to set
	 */
	public void setPARAM(String param) {
		PARAM = param;
		if( INSTANCE != null ) INSTANCE.setParam( param );
		_order._param.clear();
		JdomUtils.ICustom.wrap(param, _order._param );
	}
	
	/**
	 * @return the pLATFORM
	 */
	public String getPLATFORM() {
		return PLATFORM;
	}
	
	/**
	 * @param platform the pLATFORM to set
	 */
	public void setPLATFORM(String platform) {
		PLATFORM = platform;
		if( INSTANCE != null ) INSTANCE.setPlatform( platform );
	}
	
	/**
	 * @return the pLWK_CODING
	 */
	public String getPLWK_CODING() {
		return PLWK_CODING;
	}
	
	/**
	 * @param plwk_coding the pLWK_CODING to set
	 */
	public void setPLWK_CODING(String plwk_coding) {
		PLWK_CODING = plwk_coding;
		if( INSTANCE != null ) INSTANCE.setPlwkCoding( plwk_coding );
	}
	
	/**
	 * @return the pLWK_COMPLETE
	 */
	public java.sql.Timestamp getPLWK_COMPLETE() {
		return PLWK_COMPLETE;
	}
	
	/**
	 * @param plwk_complete the pLWK_COMPLETE to set
	 */
	public void setPLWK_COMPLETE(java.sql.Timestamp plwk_complete) {
		PLWK_COMPLETE = plwk_complete;
		if( INSTANCE != null ) INSTANCE.setPlwkComplete( plwk_complete );
	}
	
	/**
	 * @return the pLWK_CREATE
	 */
	public java.sql.Timestamp getPLWK_CREATE() {
		return PLWK_CREATE;
	}
	
	/**
	 * @param plwk_create the pLWK_CREATE to set
	 */
	public void setPLWK_CREATE(java.sql.Timestamp plwk_create) {
		PLWK_CREATE = plwk_create;
		if( INSTANCE != null ) INSTANCE.setPlwkCreate( plwk_create );
	}
	
	/**
	 * @return the pRIORITY
	 */
	public long getPRIORITY() {
		return PRIORITY;
	}
	
	/**
	 * @param priority the pRIORITY to set
	 */
	public void setPRIORITY(long priority) {
		PRIORITY = priority;
		if( INSTANCE != null ) INSTANCE.setPriority( (int)priority );
	}
	
	/**
	 * @return the rEDO_TIMES
	 */
	public long getREDO_TIMES() {
		return REDO_TIMES;
	}
	
	/**
	 * @param redo_times the rEDO_TIMES to set
	 */
	public void setREDO_TIMES(long redo_times) {
		REDO_TIMES = redo_times;
		if( INSTANCE != null ) INSTANCE.setRedoTimes( (int)redo_times );
	}
	
	/**
	 * @return the rEGION_ID
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}
	
	/**
	 * @param region_id the rEGION_ID to set
	 */
	public void setREGION_ID(String region_id) {
		REGION_ID = region_id;
		if( INSTANCE != null ) INSTANCE.setRegionId( region_id );
	}
	
	/**
	 * @return the fAIL_LOG
	 */
	public String getFAIL_LOG() {
		return FAIL_LOG;
	}
	
	/**
	 * @param fAIL_LOG the FAIL_LOG to set
	 */
	public void setFAIL_LOG(String fAIL_LOG) {
		FAIL_LOG = fAIL_LOG;
		if( INSTANCE != null ) INSTANCE.setFailLog( fAIL_LOG );
	}
	
	/**
	 * @return the sORT_BY
	 */
	public long getSORT_BY() {
		return SORT_BY;
	}
	
	/**
	 * @param sort_by the sORT_BY to set
	 */
	public void setSORT_BY(long sort_by) {
		SORT_BY = sort_by;
		if( INSTANCE != null ) INSTANCE.setSortBy( (int)sort_by );
	}
	
	/**
	 * @return the sTAFF_ID
	 */
	public String getSTAFF_ID() {
		return STAFF_ID;
	}
	
	/**
	 * @param staff_id the sTAFF_ID to set
	 */
	public void setSTAFF_ID(String staff_id) {
		STAFF_ID = staff_id;
		if( INSTANCE != null ) INSTANCE.setStaffId( staff_id );
	}
	
	/**
	 * @return the sTATE
	 */
	public String getSTATE() {
		return STATE;
	}
	
	/**
	 * @param state the sTATE to set
	 */
	public void setSTATE(String state) {
		STATE = state;
		if( INSTANCE != null ) INSTANCE.setState( state );
	}
	
	/**
	 * @return the sTATE_DATE
	 */
	public java.sql.Timestamp getSTATE_DATE() {
		return STATE_DATE;
	}
	
	/**
	 * @param state_date the sTATE_DATE to set
	 */
	public void setSTATE_DATE(java.sql.Timestamp state_date) {
		STATE_DATE = state_date;
		if( INSTANCE != null ) INSTANCE.setStateDate( state_date );
	}
	
	/**
	 * @return the tASK_ID
	 */
	public long getTASK_ID() {
		return TASK_ID;
	}
	
	/**
	 * @param task_id the tASK_ID to set
	 */
	public void setTASK_ID(long task_id) {
		TASK_ID = task_id;
		if( INSTANCE != null ) INSTANCE.setTaskId( task_id );
	}
	
	/**
	 * @return the uSER_ID
	 */
	public long getUSER_ID() {
		return USER_ID;
	}
	
	/**
	 * @param user_id the uSER_ID to set
	 */
	public void setUSER_ID(long user_id) {
		USER_ID = user_id;
		if( INSTANCE != null ) INSTANCE.setUserId( user_id );
	}
	
	/**
	 * @return the sUBFLOW
	 */
	public long getSUBFLOW() {
		return SUBFLOW;
	}
	
	/**
	 * @param sUBFLOW the sUBFLOW to set
	 */
	public void setSUBFLOW(long sUBFLOW) {
		SUBFLOW = sUBFLOW;
		if( INSTANCE != null ) INSTANCE.setSubflow( sUBFLOW );
	}
	
	/**
	 * 沉淀容错机制造成变量
	 *
	 */
	public void setCOMPENSATE(java.util.Map aUpdcpsmLife){
		_order._token.getGraphics().put( "VMICPCSA" , Boolean.TRUE );
	}
	
	/**
	 * @return _order
	 */
	public ITaskOfferHome getORDER() {
		return _order;
	}
	
	/**
	 * 判断是否为落地模式
	 * @return
	 */
	public boolean isHUMAN(){
		return INSTANCE != null && INSTANCE instanceof SATaskFail;
	}
	
	/**
	 * 是否订单任务为容错机制
	 * @return
	 */
	public boolean isCOMPENSATE(){
		return _order._token.getGraphics().containsKey( "VMICPCSA" );
	}
	
	/**
	 * 是否依赖服务定单任务
	 * @return
	 */
	public boolean isDEPEND(){
		return StringUtils.equals( STATE, IUpdcConst.IState.P );
	}
	
	/**
	 * 是否服务任务异常
	 * @return
	 */
	public boolean isEXCEPTION(){
		return StringUtils.contains( STATE , new String[]{IUpdcConst.IState.E});
	}
	/**
	 * 是否开通任务已撤销
	 * @return
	 */
	public boolean isCANCEL(){
		return StringUtils.contains( STATE , new String[]{IUpdcConst.IState.Q});
	}
	/**
	 * 是否开通任务已完成(包含正常完成/人工报竣/容错完成)
	 * @return
	 */
	public boolean isCOMPLETE(){
		return StringUtils.contains( STATE , new String[]{IUpdcConst.IState.O, IUpdcConst.IState.F, IUpdcConst.IState.S});
	}
	/**
	 * 是否已派单
	 * @return
	 */
	public boolean isASSIGNED(){
		return STATION_ID != null && StringUtils.isBlank( STATION_ID ) == false;
	}
	
	/**
	 * 是否立即送网元
	 * @return
	 */
	public boolean isCREATE(){
		return StringUtils.contains( STATE, new String[]{IUpdcConst.IState.C,IUpdcConst.IState.D});
	}
	
	/**
	 * 是否为发起方为服务队列
	 * @return
	 */
	public boolean isQUEUE(){
		return _order._origing != null && _order._origing instanceof IOVQueuePentium;
	}
	
	/**
	 * 是否并行割接任务
	 * @return
	 */
	public boolean isPARALLEL(){
		boolean fromEnable = false;
		try 
		{
			String fromPARALLEL = null;
			IOVOfferPentium.IOfferMBeanHome fromOffer = null;
			if( _order._offer != null ){
				fromOffer = _order._offer.getORDER();
				fromPARALLEL = (String)fromOffer.getOFFER().get( IUpdcConst.ISystem.PARALLEL );
			}
			fromEnable = StringUtils.isBlank( fromPARALLEL ) == false &&
					StringUtils.equals( fromPARALLEL, IUpdcConst.IEnum.IYesNo.Yes );
		}
		finally{
			
		}
		return fromEnable;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		int doCompare = 1;
		doCompare = obj != null && obj instanceof IOVTaskPentium?0:1;
		if( doCompare == 0 ) doCompare = (new Long(TASK_ID)).compareTo( new Long( ((IOVTaskPentium)obj).TASK_ID ) );
		return doCompare;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean doEqual = obj == null || (obj instanceof IOVTaskPentium ) == false?false:true;
		if( doEqual == true ) doEqual = ((IOVTaskPentium)obj).TASK_ID == TASK_ID;
		return doEqual;
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2012-12-31</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ITaskOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 1194924934509782210L;
		/*任务级属性*/
        private java.util.Map     _param    = new java.util.HashMap();
        /*服务流程规范*/
        private IUpdbpmOffer      _subflow  = null;
        /*服务阶段规范*/
        private IUpdfcmpOffer     _suggest  = null;
        /*服务产品订购*/
        private IOVOfferPentium   _offer    = null;
        /*网元归档策略*/
        private ITaskCompleteHome _complete = new ITaskCompleteHome();
        /*发起方工单*/
		private Object            _origing  = null;
        /*其他状态:IIStatefulL为true则已进入网元指令模式*/
        private IPeriodGraphToken _token    = new IPeriodGraphToken();
		public ITaskOfferHome(){
			super();
		}
		
		/**
		 * @return 任务级属性
		 */
		public java.util.Map getPARAM() {
			return _param;
		}

		/**
		 * @return 其他状态
		 */
		public IPeriodGraphToken getTOKEN() {
			return _token;
		}
		
		/**
		 * @return 服务流程规范
		 */
		public IUpdbpmOffer getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * 
		 * @param sUBFLOW 服务流程规范
		 * @throws Exception
		 */
		public void setSUBFLOW(IUpdbpmOffer sUBFLOW) throws Exception{
			_subflow  = sUBFLOW;
			_suggest = UpdcpmUtils.getSUGGEST( sUBFLOW ); 
		}
		
		/**
		 * @return 服务阶段规范
		 */
		public IUpdfcmpOffer getSUGGEST() {
			return _suggest;
		}

		/**
		 * @param pLWK_SUGGEST 服务阶段规范
		 */
		public void setSUGGEST(IUpdfcmpOffer sUGGEST) {
			_suggest = sUGGEST;
		}

		/**
		 * @return 发起方工单
		 */
		public Object getORIGING() {
			return _origing;
		}
	
		/**
		 * @param plwk_origing 发起方工单
		 */
		public void setORIGING(Object origing) {
			_origing = origing;
		}
		
		/**
		 * @return 服务产品订购
		 */
		public IOVOfferPentium getOFFER() {
			return _offer;
		}
		
		/**
		 * @param OFFER 服务产品订购
		 */
		public void setOFFER(IOVOfferPentium OFFER) {
			_offer = OFFER;
		}

		/**
		 * @return 网元归档策略
		 */
		public ITaskCompleteHome getCOMPLETE() {
			return _complete;
		}
		
		/**
		 * 网元异步归档策略
		 * @param fromUpdbm 服务归档流程
		 * @param fromUpfm 服务归档网元
		 */
		public void setCOMPLETE(IUpdbpmOffer fromUpdbm,IUpffmOffer fromUpfm) {
			if( fromUpdbm.isCOMPLETE() ){
				_complete._platform = fromUpfm;
				_complete._complete = fromUpdbm;
			}
		}
		/**
		 * 
		 * @param fromHome
		 * @throws Exception
		 */
		public void _wrap( ITaskOfferHome fromHome ) throws Exception{
			ClassUtils.IMerge.merge( fromHome._param, _param );
			_subflow     = fromHome._subflow     ;
			_suggest     = fromHome._suggest     ;
			_offer       = fromHome._offer       ;
			_complete._wrap( fromHome._complete );
			_origing     = fromHome._origing     ;
			_token._wrap   ( fromHome._token    );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元归档策略</p>
	 * <p>Copyright: Copyright (c) 2015-2-12</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ITaskCompleteHome implements java.io.Serializable{
		private static final long serialVersionUID = -4355038006279578301L;
		/*服务归档网元*/
		private IUpffmOffer    _platform = null;
		/*服务归档流程*/
		private IUpdbpmOffer   _complete = null;
		/*服务归档工单*/
		private java.util.List _subflow = new java.util.ArrayList();
		public ITaskCompleteHome(){
			super();
		}
		
		/**
		 * @return 服务归档流程
		 */
		public IUpdbpmOffer getCOMPLETE() {
			return _complete;
		}
		
		/**
		 * @return 服务归档网元
		 */
		public IUpffmOffer getPLATFORM() {
			return _platform;
		}
		
		/**
		 * @return 服务归档工单
		 */
		public java.util.List getSUBFLOW() {
			return _subflow;
		}
		/**
		 * 
		 * @param fromHome
		 * @throws Exception
		 */
		public void _wrap( ITaskCompleteHome fromHome ) throws Exception{
			_platform   = fromHome._platform  ;
			_complete   = fromHome._complete;
			ClassUtils.IMerge.merge( fromHome._subflow, _subflow );
		}
	}
}
