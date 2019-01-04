package com.ai.sacenter.provision.valuebean;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.bo.ISAProvisionFail;
import com.ai.sacenter.provision.bo.ISAProvisionReset;
import com.ai.sacenter.provision.bo.ISAWorkOrder;
import com.ai.sacenter.provision.bo.SAWorkOrder;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmsOffer;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: 异步网元定单</p>
 * <p>Copyright: Copyright (c) 2013-7-5</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpfwmOrder extends IOVUpfwmBase implements java.io.Serializable,java.lang.Comparable{
	private static final long serialVersionUID = -4868473414032827404L;
	private String ORIGINATE      ;
	private String COMPLETE       ;
	private String STATE          ;
	private String RESULT         ;
	private java.sql.Timestamp COMPLETE_DATE;
	private IUpfwmOfferHome _order;
	public IOVUpfwmOrder() throws Exception{
		super();
		_instance = new SAWorkOrder    ();
		_order    = new IUpfwmOfferHome();
	}
	
	public IOVUpfwmOrder( java.util.Map provision ) throws Exception{
		super();
		_instance     = new SAWorkOrder                          ();
		OracleUtils.ICustom.transfer( provision, _instance        );
		super.transfer( (ISAWorkOrder)_instance                   );
		ORIGINATE     = ((ISAWorkOrder)_instance).getOriginate   ();
		COMPLETE      = ((ISAWorkOrder)_instance).getComplete    ();
		STATE         = ((ISAWorkOrder)_instance).getState       ();
		RESULT        = ((ISAWorkOrder)_instance).getResult      ();
		COMPLETE_DATE = ((ISAWorkOrder)_instance).getCompleteDate();
		((ISAWorkOrder)_instance).setStsToOld()                    ;
		_order        = new IUpfwmOfferHome( this                 );
	}
	
	public IOVUpfwmOrder( ISAWorkOrder provision ) throws Exception{
		super( provision );
		ORIGINATE     = provision.getOriginate   ();
		COMPLETE      = provision.getComplete    ();
		STATE         = provision.getState       ();
		RESULT        = provision.getResult      ();
		COMPLETE_DATE = provision.getCompleteDate();
		_order        = new IUpfwmOfferHome( this );
	}
	
	public IOVUpfwmOrder( IOVUpfwmOrder provision ) throws Exception{
		super( provision );
		ORIGINATE     = provision.ORIGINATE                    ;
		COMPLETE      = provision.COMPLETE                     ;
		STATE         = provision.STATE                        ;
		RESULT        = provision.RESULT                       ;
		COMPLETE_DATE = provision.COMPLETE_DATE                ;
		_order        = new IUpfwmOfferHome( provision._order );
	}
	
	/**
	 * @param bill_id the bILL_ID to set
	 */
	public void setBILL_ID(String bill_id) {
		BILL_ID = bill_id;
		if( _instance != null ) ((ISAWorkOrder)_instance).setBillId( bill_id );
	}
	
	/**
	 * @return the cUST_ORDER
	 */
	public String getCUST_ORDER() {
		return CUST_ORDER;
	}
	
	
	/**
	 * @return the cATEGORY
	 */
	public String getCATEGORY() {
		return CATEGORY;
	}
	
	/**
	 * @param category the cATEGORY to set
	 */
	public void setCATEGORY(String category) {
		CATEGORY = category;
		if( _instance != null ) ((ISAWorkOrder)_instance).setCategory( category );
	}
	
	/**
	 * @return the oRIGINATE
	 */
	public String getORIGINATE() {
		return ORIGINATE;
	}
	/**
	 * @param originate the oRIGINATE to set
	 */
	public void setORIGINATE(String originate) {
		ORIGINATE = originate;
		if( _instance != null ) ((ISAWorkOrder)_instance).setOriginate( originate );
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
		if( _instance != null ) ((ISAWorkOrder)_instance).setCompleteDate( complete_date );
	}
	
	/**
	 * @param create_date the cREATE_DATE to set
	 */
	public void setCREATE_DATE(java.sql.Timestamp create_date) {
		CREATE_DATE = create_date;
		if( _instance != null ) ((ISAWorkOrder)_instance).setCreateDate( create_date );
	}
	
	/**
	 * @param cust_order the cUST_ORDER to set
	 */
	public void setCUST_ORDER(String cust_order) {
		CUST_ORDER = cust_order;
		if( _instance != null ) ((ISAWorkOrder)_instance).setCustOrder( cust_order );
	}
	
	/**
	 * @param directive the dIRECTIVE to set
	 */
	public void setDIRECTIVE(String directive) {
		DIRECTIVE = directive;
		if( _instance != null ) ((ISAWorkOrder)_instance).setDirective( directive );
	}
	
	/**
	 * @param done_code the dONE_CODE to set
	 */
	public void setDONE_CODE(String done_code) {
		DONE_CODE = done_code;
		if( _instance != null ) ((ISAWorkOrder)_instance).setDoneCode( done_code );
	}
	
	/**
	 * @param end_date the eND_DATE to set
	 */
	public void setEND_DATE(java.sql.Timestamp end_date) {
		END_DATE = end_date;
		if( _instance != null ) ((ISAWorkOrder)_instance).setEndDate( end_date );
	}
	
	/**
	 * @param fail_code the fAIL_CODE to set
	 */
	public void setFAIL_CODE(String fail_code) {
		FAIL_CODE = fail_code;
		_order._rspCode = FAIL_CODE;
		if( _instance != null ) ((ISAWorkOrder)_instance).setFailCode( fail_code );
	}
	
	/**
	 * @param fail_device the FAIL_DEVICE to set
	 */
	public void setFAIL_DEVICE(String fail_device) {
		FAIL_DEVICE = fail_device;
		if( _instance != null ) ((ISAWorkOrder)_instance).setFailDevice( fail_device );
		if( StringUtils.isBlank( fail_device ) == false ) _order._rspHome = fail_device;
	}
	
	/**
	 * @param fail_log the fAIL_LOG to set
	 */
	public void setFAIL_LOG(String fail_log) {
		FAIL_LOG = fail_log;
		if( _instance != null ) ((ISAWorkOrder)_instance).setFailLog( fail_log );
	}
	
	/**
	 * @param fail_reason the fAIL_REASON to set
	 */
	public void setFAIL_REASON(String fail_reason) {
		FAIL_REASON = fail_reason;
		_order._rspDesc = fail_reason;
		if( _instance != null ) ((ISAWorkOrder)_instance).setFailReason( fail_reason );
	}
	
	/**
	 * @param notes the nOTES to set
	 */
	public void setNOTES(String notes) {
		NOTES = notes;
		if( _instance != null ) ((ISAWorkOrder)_instance).setNotes( notes );
	}
	
	/**
	 * @param old_ps_param the oLD_PS_PARAM to set
	 */
	public void setOLD_PS_PARAM(String old_ps_param) {
		OLD_PS_PARAM = old_ps_param;
		if( _instance != null ) ((ISAWorkOrder)_instance).setOldPsParam( old_ps_param );
	}
	
	/**
	 * @param order_date the oRDER_DATE to set
	 */
	public void setORDER_DATE(java.sql.Timestamp order_date) {
		ORDER_DATE = order_date;
		if( _instance != null ) ((ISAWorkOrder)_instance).setOrderDate( order_date );
	}
	
	/**
	 * @param order_id the oRDER_ID to set
	 */
	public void setORDER_ID(long order_id) {
		ORDER_ID = order_id;
		if( _instance != null ) ((ISAWorkOrder)_instance).setOrderId( order_id );
	}
	
	/**
	 * @param org_id the oRG_ID to set
	 */
	public void setORG_ID(String org_id) {
		ORG_ID = org_id;
		if( _instance != null ) ((ISAWorkOrder)_instance).setOrgId( org_id );
	}
	
	/**
	 * @param platform the pLATFORM to set
	 */
	public void setPLATFORM(String platform) throws Exception{
		PLATFORM = platform;
		if( StringUtils.isBlank( _order._rspHome ) ){
			_order._rspHome = platform;
		}
		if( _instance != null ) ((ISAWorkOrder)_instance).setPlatform( platform );
	}
	
	/**
	 * @param program the pROGRAM to set
	 */
	public void setPROGRAM(String program) throws Exception{
		PROGRAM = program;
		if( _instance != null ) ((ISAWorkOrder)_instance).setProgram( program );
	}
	
	/**
	 * @param priority the pRIORITY to set
	 */
	public void setPRIORITY(long priority) {
		PRIORITY = priority;
		if( _instance != null ) ((ISAWorkOrder)_instance).setPriority( priority );
	}
	
	/**
	 * @param ps_id the pS_ID to set
	 */
	public void setPS_ID(long ps_id) {
		PS_ID = ps_id;
		if( _instance != null ) ((ISAWorkOrder)_instance).setPsId( ps_id );
	}
	
	/**
	 * @param ps_param the pS_PARAM to set
	 */
	public void setPS_PARAM(String ps_param) {
		PS_PARAM = ps_param;
		if( _instance != null ) ((ISAWorkOrder)_instance).setPsParam( ps_param );
	}
	
	/**
	 * @param ps_status the pS_STATUS to set
	 */
	public void setPS_STATUS(long ps_status) {
		PS_STATUS = ps_status;
		_order._status = ps_status;
		if( _instance != null ) ((ISAWorkOrder)_instance).setPsStatus( (int)ps_status );
	}
	
	/**
	 * @param region_id the rEGION_ID to set
	 */
	public void setREGION_ID(String region_id) {
		REGION_ID = region_id;
		if( _instance != null ) ((ISAWorkOrder)_instance).setRegionId( region_id );
	}
	
	/**
	 * @param ret_date the rET_DATE to set
	 */
	public void setRET_DATE(java.sql.Timestamp ret_date) {
		RET_DATE = ret_date;
		if( _instance != null ) ((ISAWorkOrder)_instance).setRetDate( ret_date );
	}
	
	/**
	 * @param retry_times the rETRY_TIMES to set
	 */
	public void setRETRY_TIMES(long retry_times) {
		RETRY_TIMES = retry_times;
		if( _instance != null ) ((ISAWorkOrder)_instance).setRetryTimes( (int)retry_times );
	}
	
	/**
	 * @param staff_id the sTAFF_ID to set
	 */
	public void setSTAFF_ID(String staff_id) {
		STAFF_ID = staff_id;
		if( _instance != null ) ((ISAWorkOrder)_instance).setStaffId( staff_id );
	}
	
	/**
	 * @param start_date the sTART_DATE to set
	 */
	public void setSTART_DATE(java.sql.Timestamp start_date) {
		START_DATE = start_date;
		if( _instance != null ) ((ISAWorkOrder)_instance).setStartDate( start_date );
	}
	
	/**
	 * @param stop_type the sTOP_TYPE to set
	 */
	public void setSTOP_TYPE(long stop_type) {
		STOP_TYPE = stop_type;
		if( _instance != null ) ((ISAWorkOrder)_instance).setStopType( (int)stop_type );
	}
	
	/**
	 * @param pS_NET_CODE the pS_NET_CODE to set
	 */
	public void setPS_NET_CODE(String pS_NET_CODE) {
		PS_NET_CODE = pS_NET_CODE;
		if( _instance != null ) ((ISAWorkOrder)_instance).setPsNetCode( pS_NET_CODE );
	}

	/**
	 * @param sERVICE_ID the sERVICE_ID to set
	 */
	public void setSERVICE_ID(long sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
		if( _instance != null ) ((ISAWorkOrder)_instance).setServiceId( (int)sERVICE_ID );
	}
	
	/**
	 * @return the cOMPLETE
	 */
	public String getCOMPLETE() {
		return COMPLETE;
	}
	
	/**
	 * @param complete the cOMPLETE to set
	 */
	public void setCOMPLETE(String complete) {
		COMPLETE = complete;
		if( _instance != null ) ((ISAWorkOrder)_instance).setComplete( complete );
	}
	
	/**
	 * @return the rESULT
	 */
	public String getRESULT() {
		return RESULT;
	}
	
	/**
	 * @param result the rESULT to set
	 */
	public void setRESULT(String result) {
		RESULT = result;
		if( _instance != null ) ((ISAWorkOrder)_instance).setResult( result );
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
		if( _instance != null ) ((ISAWorkOrder)_instance).setState( state );
	}
	
	/**
	 * @param sub_bill_id the sUB_BILL_ID to set
	 */
	public void setSUB_BILL_ID(String sub_bill_id) {
		SUB_BILL_ID = sub_bill_id;
		if( _instance != null ) ((ISAWorkOrder)_instance).setSubBillId( sub_bill_id );
	}
	
	/**
	 * @param sub_plan_no the sUB_PLAN_NO to set
	 */
	public void setSUB_PLAN_NO(long sub_plan_no) {
		SUB_PLAN_NO = sub_plan_no;
		if( _instance != null ) ((ISAWorkOrder)_instance).setSubPlanNo( sub_plan_no );
	}
	
	/**
	 * @param target_param the tARGET_PARAM to set
	 */
	public void setTARGET_PARAM(String target_param) {
		TARGET_PARAM = target_param;
		_order._rspResult = target_param;
		if( _instance != null ) ((ISAWorkOrder)_instance).setTargetParam( target_param );
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
		if( _instance != null ) ((ISAWorkOrder)_instance).setTaskId( task_id );
	}
	
	/**
	 * @param user_id the uSER_ID to set
	 */
	public void setUSER_ID(long user_id) {
		USER_ID = user_id;
		if( _instance != null ) ((ISAWorkOrder)_instance).setUserId( user_id );
	}

	/**
	 * @return the _order
	 */
	public IUpfwmOfferHome getORDER() {
		return _order;
	}
	
	/**
	 * 网元归档策略为异步模拟同步机制
	 * @return
	 */
	public boolean isSUBFLOW(){
		return StringUtils.equals( COMPLETE, IUpdcConst.IUpdbm.IUpdbf.SUBFLOW );
	}
	
	/**
	 * 是否人工报竣
	 * @return
	 */
	public boolean isMANUAL(){
		return StringUtils.equals( STATE, IUpdcConst.IState.F ) || 
				_order._status == IUpfwmConst.IUpdos.HUMAN;
	}
	
	/**
	 * 是否网元工单报竣工(包含人工报竣工)
	 * @return
	 */
	public boolean isACHIEVE(){
		return isMANUAL() || isNETWORK();
	}
	
	/**
	 * 是否网元报竣
	 * @return
	 */
	public boolean isNETWORK(){
		return _order._status == IUpfwmConst.IUpdos.SUCCEED;
	}
	
	/**
	 * 是否网元异常
	 * @return
	 */
	public boolean isEXCEPTION(){
		return _order._status == IUpfwmConst.IUpdos.EXCEPTION;
	}
	
	/**
	 * 是否为失败表网元定单
	 * @return
	 */
	public boolean isFAILURE(){
		return _instance != null && _instance instanceof ISAProvisionFail;
	}
	
	/**
	 * 判断是否工单来源为落地模式
	 * @return
	 */
	public boolean isHUMAN(){
		return StringUtils.equals( ORIGINATE, IUpdcConst.IUpdbm.IUpdbf.HUMAN );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		int doCompare = 1;
		doCompare = obj != null && obj instanceof IOVUpfwmOrder ? 0 : 1;
		if( doCompare == 0 ){
			doCompare = (new Long(PS_ID)).compareTo(new Long( ((IOVUpfwmOrder)obj).PS_ID));
		}
		return doCompare;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean doEqual = obj == null || ( obj instanceof IOVUpfwmOrder ) == false ? false: true;
		if (doEqual == true){
			doEqual = ((IOVUpfwmOrder)obj).PS_ID == PS_ID;
		}
		return doEqual;
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2014-7-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 7139966111849263718L;
		/*工单状态*/
		private long   _status    ;
		/*反馈代码*/
		private String _rspCode	  ;
		/*反馈网元*/
		private String _rspHome   ;
		/*反馈描述*/
		private String _rspDesc   ;
		/*查询结果*/
		private String _rspResult ;
		/*反馈规范*/
		private IUpffmsOffer _respond = null;
		/*服务指令集*/
		private IOVUpdspmLife _bottom = null;
		/*反馈单*/
		private IUpfwmOrigHome _origing = null;
		/*网元属性*/
		private java.util.Map _offer = new java.util.HashMap();
		public IUpfwmOfferHome(){
			super();
		}
		
		public IUpfwmOfferHome( IUpfwmOfferHome order ){
			super();
			_status     = order._status    ;
			_rspCode    = order._rspCode   ;
			_rspHome    = order._rspHome   ;
			_rspDesc    = order._rspDesc   ;
			_rspResult  = order._rspResult ;
			ClassUtils.IMerge.merge( order._offer, _offer );
			_bottom     = order._bottom     ;
			_respond    = order._respond    ;
			if( order._origing != null ){
				_origing   = new IUpfwmOrigHome( order._origing );
			}
		}
		
		public IUpfwmOfferHome( IOVUpfwmOrder order ){
			super();
			if( _rspCode == null ){
				_rspCode = order.FAIL_CODE;
				if( _rspCode == null ) _rspCode = String.valueOf( order.PS_STATUS );
			}
			_offer.clear();
			JdomUtils.ICustom.wrap( order.OLD_PS_PARAM , _offer );
			JdomUtils.ICustom.wrap( order.PS_PARAM     , _offer );
		}
		
		/**
		 * @return 服务指令集
		 */
		public IOVUpdspmLife getBottom() {
			return _bottom;
		}
		
		/**
		 * @param bottom 服务指令集
		 */
		public void setBottom(IOVUpdspmLife bottom) {
			_bottom = bottom;
		}
		
		/**
		 * @return 获取反馈代码
		 */
		public String getRspCode() {
			return _rspCode;
		}
		
		/**
		 * @param rspCode 设置反馈代码
		 */
		public void setRspCode(String rspCode) {
			_rspCode = rspCode;
		}
		
		/**
		 * @return 反馈网元
		 */
		public String getRspHome() {
			return _rspHome;
		}
		
		/**
		 * @param rspHome 反馈网元
		 */
		public void setRspHome(String rspHome) {
			_rspHome = rspHome;
		}
		
		/**
		 * @return 反馈描述
		 */
		public String getRspDesc() {
			return _rspDesc;
		}
		
		/**
		 * @param rspDesc 设置反馈描述
		 */
		public void setRspDesc(String rspDesc) {
			_rspDesc = rspDesc;
		}
		
		/**
		 * @return 获取网元属性
		 */
		public java.util.Map getOFFER() {
			return _offer;
		}
		
		/**
		 * @return 获取反馈单
		 */
		public IUpfwmOrigHome getORIGING() {
			return _origing;
		}
		
		/**
		 * @param origing 设置反馈单
		 */
		public void setORIGING(IUpfwmOrigHome origing) {
			_origing = origing;
		}
		
		/**
		 * @return 工单状态
		 */
		public long getSTATUS() {
			return _status;
		}
		
		/**
		 * @param status 工单状态
		 */
		public void setSTATUS(long status) {
			_status = status;
		}
		
		/**
		 * @return 查询结果
		 */
		public String getRspResult() {
			return _rspResult;
		}
		
		/**
		 * @param target 查询结果
		 */
		public void setRspResult(String target) {
			_rspResult = target;
		}
		
		/**
		 * @return 反馈规范
		 */
		public IUpffmsOffer getRespond() {
			return _respond;
		}
		
		/**
		 * @param respond 反馈规范
		 */
		public void setRespond(IUpffmsOffer respond) {
			_respond = respond;
		}
		
		/**
		 * 是否为服务开通侧网元工单
		 * @return
		 */
		public boolean isPROVISION(){
			return _origing != null && _origing._origing
					instanceof ISAProvisionReset;
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年5月1日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmOrigHome implements java.io.Serializable{
		private static final long serialVersionUID = -2495501490488698642L;
		/*数据访问DAO类*/
		private Class  _repository;
		/*反馈单*/
		private DataStructInterface _origing = null;
		public IUpfwmOrigHome( IUpfwmOrigHome order ){
			super();
			_repository = order._repository;
			_origing    = order._origing   ;
		}
		
		public IUpfwmOrigHome( Class rEPOSITORY, DataStructInterface oRIGING){
			super();
			_repository   = rEPOSITORY  ;
			_origing      = oRIGING; 
		}
		
		/**
		 * @return 数据访问
		 */
		public Class getREPOSITORY() {
			return _repository;
		}
		
		/**
		 * @param rEPOSITORY 数据访问
		 */
		public void setREPOSITORY(Class rEPOSITORY) {
			_repository = rEPOSITORY;
		}

		/**
		 * @return 反馈单
		 */
		public DataStructInterface getORIGING() {
			return _origing;
		}

		/**
		 * @param oRIGING 反馈单
		 */
		public void setORIGING(DataStructInterface oRIGING) {
			_origing = oRIGING;
		}
		
		/**
		 * 
		 * @param order
		 */
		public void _wrap( IUpfwmOrigHome order ){
			_repository = order._repository;
			_origing    = order._origing   ;
		}
	}
}
