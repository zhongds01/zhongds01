package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.bo.ISAProvision;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.IPeriodGraphToken;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 异步网元工单</p>
 * <p>Copyright: Copyright (c) 2013-4-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpfwmOffer extends IOVUpfwmBase implements java.lang.Comparable{
	private static final long serialVersionUID = 4802995012348973849L;
	private String COMPOSITE      ;
	private IUpfwmOfferHome _order = null;
	public IOVUpfwmOffer() throws Exception {
		super();
		_instance = new ISAProvision   ();
		_order    = new IUpfwmOfferHome();
	}
	
	public IOVUpfwmOffer( java.util.Map provision ) throws Exception{
		super();
		_instance  = new ISAProvision()                      ;
		OracleUtils.ICustom.transfer( provision, _instance  );
		super.transfer( (IISAProvision)_instance            );
		COMPOSITE = ((IISAProvision)_instance).getComposite();
		((IISAProvision)_instance).setStsToOld()             ;
		_order    = new IUpfwmOfferHome( this               );
	}
	
	public IOVUpfwmOffer( IISAProvision provision ) throws Exception{
		super( provision );
		COMPOSITE = provision.getComposite   ();
		_order    = new IUpfwmOfferHome( this );
	}
	
	public IOVUpfwmOffer( IOVUpfwmOffer provision ) throws Exception{
		super( provision );
		COMPOSITE  = provision.COMPOSITE                    ;
		_order     = new IUpfwmOfferHome( provision._order );
	}
	
	/**
	 * @param bill_id the bILL_ID to set
	 */
	public void setBILL_ID(String bill_id) {
		BILL_ID = bill_id;
		if( _instance != null ) ((IISAProvision)_instance).setBillId( bill_id );
	}
	
	/**
	 * @param category the cATEGORY to set
	 */
	public void setCATEGORY(String category) {
		CATEGORY = category;
		if( _instance != null ) ((IISAProvision)_instance).setCategory( category );
	}
	
	/**
	 * @param create_date the cREATE_DATE to set
	 */
	public void setCREATE_DATE(java.sql.Timestamp create_date) {
		CREATE_DATE = create_date;
		if( _instance != null ) ((IISAProvision)_instance).setCreateDate( create_date );
	}
	
	/**
	 * @param directive the dIRECTIVE to set
	 */
	public void setDIRECTIVE(String directive) {
		DIRECTIVE = directive;
		if( _instance != null ) ((IISAProvision)_instance).setDirective( directive );
	}
	
	/**
	 * @param done_code the dONE_CODE to set
	 */
	public void setDONE_CODE(String done_code) {
		DONE_CODE = done_code;
		if( _instance != null ) ((IISAProvision)_instance).setDoneCode( done_code );
	}
	
	/**
	 * @param cUST_ORDER the CUST_ORDER to set
	 */
	public void setCUST_ORDER(String cUST_ORDER) {
		CUST_ORDER = cUST_ORDER;
		if( _instance != null ) ((IISAProvision)_instance).setCustOrder( cUST_ORDER );
	}
	
	/**
	 * @param tASK_ID the TASK_ID to set
	 */
	public void setTASK_ID(long tASK_ID) {
		TASK_ID = tASK_ID;
		if( _instance != null ) ((IISAProvision)_instance).setTaskId( tASK_ID );
	}
	
	/**
	 * @param tASK_ID the END_DATE to set
	 */
	public void setEND_DATE(java.sql.Timestamp end_date) {
		END_DATE = end_date;
		if( _instance != null ) ((IISAProvision)_instance).setEndDate( end_date );
		if( _order._order != null ) _order._order.setEND_DATE( end_date );
	}
	
	/**
	 * @param fail_code the fAIL_CODE to set
	 */
	public void setFAIL_CODE(String fail_code) {
		FAIL_CODE = fail_code;
		if( _instance != null ) ((IISAProvision)_instance).setFailCode( fail_code );
		if( _order._order != null ) _order._order.setFAIL_CODE( fail_code );
	}
	
	/**
	 * @param fail_device the FAIL_DEVICE to set
	 */
	public void setFAIL_DEVICE(String fail_device) {
		FAIL_DEVICE = fail_device;
		if( _instance != null ) ((IISAProvision)_instance).setFailDevice( fail_device );
		if( _order._order != null ) _order._order.setFAIL_DEVICE( fail_device );
	}
	
	/**
	 * @param fail_log the fAIL_LOG to set
	 */
	public void setFAIL_LOG(String fail_log) {
		FAIL_LOG = fail_log;
		if( _instance != null ) ((IISAProvision)_instance).setFailLog( fail_log );
		if( _order._order != null ) _order._order.setFAIL_LOG( fail_log );
	}
	
	/**
	 * @param fail_reason the fAIL_REASON to set
	 */
	public void setFAIL_REASON(String fail_reason) {
		FAIL_REASON = fail_reason;
		if( _instance != null ) ((IISAProvision)_instance).setFailReason( fail_reason );
		if( _order._order != null ) _order._order.setFAIL_REASON( fail_reason );
	}
	
	/**
	 * @param notes the nOTES to set
	 */
	public void setNOTES(String notes) {
		NOTES = notes;
		if( _instance != null ) ((IISAProvision)_instance).setNotes( notes );
	}
	
	/**
	 * @param old_ps_param the oLD_PS_PARAM to set
	 */
	public void setOLD_PS_PARAM(String old_ps_param) {
		OLD_PS_PARAM = old_ps_param;
		_order._offer.clear();
		UpfwmUtils.ICustom.wrap( OLD_PS_PARAM, _order._offer );
		UpfwmUtils.ICustom.wrap( PS_PARAM    , _order._offer );
		if( _instance != null ) ((IISAProvision)_instance).setOldPsParam( old_ps_param );
	}
	
	/**
	 * @param order_date the oRDER_DATE to set
	 */
	public void setORDER_DATE(java.sql.Timestamp order_date) {
		ORDER_DATE = order_date;
		if( _instance != null ) ((IISAProvision)_instance).setOrderDate( order_date );
	}
	
	/**
	 * @param order_id the oRDER_ID to set
	 */
	public void setORDER_ID(long order_id) {
		ORDER_ID = order_id;
		if( _instance != null ) ((IISAProvision)_instance).setOrderId( order_id );
	}
	
	/**
	 * @param org_id the oRG_ID to set
	 */
	public void setORG_ID(String org_id) {
		ORG_ID = org_id;
		if( _instance != null ) ((IISAProvision)_instance).setOrgId( org_id );
	}
	
	/**
	 * @param platform the pLATFORM to set
	 */
	public void setPLATFORM(String platform) throws Exception{
		PLATFORM = platform;
		_order._platform = UpdcUtils.ISubFlow.getPLATFORM( PLATFORM );
		if( _instance != null ) ((IISAProvision)_instance).setPlatform( platform );
	}
	
	/**
	 * @param priority the pRIORITY to set
	 */
	public void setPRIORITY(long priority) {
		PRIORITY = priority;
		_order._priority = priority;
		if( _instance != null ) ((IISAProvision)_instance).setPriority( priority );
	}
	
	/**
	 * @param pROGRAM the pROGRAM to set
	 */
	public void setPROGRAM(String program) throws Exception{
		PROGRAM = program;
		_order._program = UpdcpmUtils.getPROGRAM( PROGRAM );
		if( _instance != null ) ((IISAProvision)_instance).setProgram( program );
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
		if( _instance != null ) ((IISAProvision)_instance).setComposite( cOMPOSITE );
	}
	
	/**
	 * @param ps_id the pS_ID to set
	 */
	public void setPS_ID(long ps_id) {
		PS_ID = ps_id;
		if( _instance != null ) ((IISAProvision)_instance).setPsId( ps_id );
	}
	
	/**
	 * @param ps_param the pS_PARAM to set
	 */
	public void setPS_PARAM(String ps_param) {
		PS_PARAM = ps_param;
		_order._offer.clear();
		UpfwmUtils.ICustom.wrap( OLD_PS_PARAM, _order._offer );
		UpfwmUtils.ICustom.wrap( PS_PARAM    , _order._offer );
		if( _instance != null ) ((IISAProvision)_instance).setPsParam( ps_param );
	}
	
	/**
	 * @param ps_status the pS_STATUS to set
	 */
	public void setPS_STATUS(long ps_status) {
		PS_STATUS = ps_status;
		if( _instance != null ) ((IISAProvision)_instance).setPsStatus( (int)ps_status );
		if( _order._order != null ) _order._order.setPS_STATUS( ps_status );
	}
	
	/**
	 * @param region_id the rEGION_ID to set
	 */
	public void setREGION_ID(String region_id) {
		REGION_ID = region_id;
		if( _instance != null ) ((IISAProvision)_instance).setRegionId( region_id );
	}
	
	/**
	 * @param ret_date the rET_DATE to set
	 */
	public void setRET_DATE(java.sql.Timestamp ret_date) {
		RET_DATE = ret_date;
		if( _instance != null ) ((IISAProvision)_instance).setRetDate( ret_date );
		if( _order._order != null ) _order._order.setRET_DATE( ret_date );
	}
	
	/**
	 * @param retry_times the rETRY_TIMES to set
	 */
	public void setRETRY_TIMES(long retry_times) {
		RETRY_TIMES = retry_times;
		if( _instance != null ) ((IISAProvision)_instance).setRetryTimes( (int)retry_times );
	}
	
	/**
	 * @param staff_id the sTAFF_ID to set
	 */
	public void setSTAFF_ID(String staff_id) {
		STAFF_ID = staff_id;
		if( _instance != null ) ((IISAProvision)_instance).setStaffId( staff_id );
	}
	
	/**
	 * @param start_date the sTART_DATE to set
	 */
	public void setSTART_DATE(java.sql.Timestamp start_date) {
		START_DATE = start_date;
		if( _instance != null ) ((IISAProvision)_instance).setStartDate( start_date );
		if( _order._order != null ) _order._order.setSTART_DATE( start_date );
	}
	
	/**
	 * @param stop_type the sTOP_TYPE to set
	 */
	public void setSTOP_TYPE(long stop_type) {
		STOP_TYPE = stop_type + 1;
		if( _instance != null ) ((IISAProvision)_instance).setStopType( (int)( stop_type + 1 ) );
	}
	
	/**
	 * @param pS_NET_CODE the pS_NET_CODE to set
	 */
	public void setPS_NET_CODE(String pS_NET_CODE) {
		PS_NET_CODE = pS_NET_CODE;
		if( _instance != null ) ((IISAProvision)_instance).setPsNetCode( pS_NET_CODE );
	}

	/**
	 * @param sERVICE_ID the sERVICE_ID to set
	 */
	public void setSERVICE_ID(long sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
		if( _instance != null ) ((IISAProvision)_instance).setServiceId( (int)sERVICE_ID );
	}
	
	/**
	 * @param sub_bill_id the sUB_BILL_ID to set
	 */
	public void setSUB_BILL_ID(String sub_bill_id) {
		SUB_BILL_ID = sub_bill_id;
		if( _instance != null ) ((IISAProvision)_instance).setSubBillId( sub_bill_id );
	}
	
	/**
	 * @param sub_plan_no the sUB_PLAN_NO to set
	 */
	public void setSUB_PLAN_NO(long sub_plan_no) {
		SUB_PLAN_NO = sub_plan_no;
		if( _instance != null ) ((IISAProvision)_instance).setSubPlanNo( sub_plan_no );
	}
	
	/**
	 * @param target_param the tARGET_PARAM to set
	 */
	public void setTARGET_PARAM(String target_param) {
		TARGET_PARAM = target_param;
		if( _instance != null ) ((IISAProvision)_instance).setTargetParam( target_param );
	}
	
	/**
	 * @param user_id the uSER_ID to set
	 */
	public void setUSER_ID(long user_id) {
		USER_ID = user_id;
		if( _instance != null ) ((IISAProvision)_instance).setUserId( user_id );
	}
	
	/**
	 * 订购属性集
	 * @return
	 */
	public IUpfwmOfferHome getORDER(){
		if( _order != null && _order._repository == null &&
				StringUtils.isBlank( PLATFORM ) == false ){
			_order._repository = SystemUtils.ICustom.getIUpfomDAO( PLATFORM );
		}
		return _order;
	}
	
	/**
	 * 是否异步工单模式
	 * @return
	 */
	public boolean isCREATE(){
		return PS_STATUS == IUpfwmConst.IUpdos.CREATE;
	}
	
	/**
	 * 是否下发异步网元成功
	 * @return
	 */
	public boolean isISSUED(){
		return PS_STATUS == IUpfwmConst.IUpdos.ISSUED;
	}
	/**
	 * 是否异常或反馈失败
	 * @return
	 */
	public boolean isEXCEPTION(){
		return PS_STATUS == IUpfwmConst.IUpdos.EXCEPTION
				|| PS_STATUS == IUpfwmConst.IUpdos.FAILURE;
	}
	/**
	 * 是否反馈成功
	 * @return
	 */
	public boolean isSUCCEED(){
		return PS_STATUS == IUpfwmConst.IUpdos.SUCCEED;
	}
	/**
	 * 是否人工报竣
	 * @return
	 */
	public boolean isHUMAN(){
		return PS_STATUS == IUpfwmConst.IUpdos.HUMAN;
	}
	/**
	 * 是否网元归档(包含网元成功,网元异常,人工报俊)
	 * @return
	 */
	public boolean isCOMPLETE(){
		return isSUCCEED() || isHUMAN() || isEXCEPTION();
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
                StringUtils.filling( String.valueOf( PS_ID ), 
                		15, 
                		StringUtils.RIGHT,
                		'0')} );
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		return PS_ID == ((IOVUpfwmOffer)obj).PS_ID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		long doCompare = 0;
		try {
			doCompare = obj != null && obj instanceof IOVUpfwmOffer ? 0 : 1;
			if (doCompare == 0) {
				IOVUpfwmOffer fromUpfwm = (IOVUpfwmOffer) obj;
				doCompare = _order._priority - fromUpfwm._order._priority;
				if (doCompare == 0) {
					doCompare = getTIMESQ().compareTo(fromUpfwm.getTIMESQ());
				}
			}
		} finally {

		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
	
	public static class IUpfwmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -7279895052606873770L;
		/*优先级*/
		private long  _priority  ;
		/*本地仓库*/
		private Class _repository = null;
		/*网元定单*/
		private IOVUpfwmOrder _order = null;
		/*网元工单*/
		private IUpdfmxLittle _passive = null;
		/*资产组件*/
		private IProgramTemplate.IUpdpgmOffer _program = null;
		/*归宿网元*/
		private IPlatformTemplate.IUpffmOffer _platform = null;
		/*服务属性*/
		private java.util.HashMap _subflow  = new java.util.HashMap();
		/*网元属性*/
		private java.util.HashMap _offer    = new java.util.HashMap();
		/*增量属性*/
		private java.util.HashMap _change   = new java.util.HashMap();
		/*全局属性*/
		private java.util.HashMap _graphics = new java.util.HashMap();
		/*网元令牌*/
		private IPeriodGraphToken _token = new IPeriodGraphToken();
		public IUpfwmOfferHome(){
			super();
		}

		public IUpfwmOfferHome( IUpfwmOfferHome __order__ ) throws Exception{
			_priority   = __order__._priority  ;
			_repository = __order__._repository;
			_program    = __order__._program   ;
			_platform   = __order__._platform  ;
			if( __order__._order != null ){ _order  = new IOVUpfwmOrder( __order__._order ); }
			ClassUtils.IMerge.merge( __order__._subflow , _subflow  );
			ClassUtils.IMerge.merge( __order__._offer   , _offer    );
			ClassUtils.IMerge.merge( __order__._change  , _change   );
			ClassUtils.IMerge.merge( __order__._graphics, _graphics );
			_token._wrap           ( __order__._token               );
		}
		
		public IUpfwmOfferHome( IOVUpfwmOffer __order__ ) throws Exception{
			_priority = __order__.PRIORITY                                 ;
			_program  = UpdcpmUtils.getPROGRAM( __order__.PROGRAM          );
			if( StringUtils.isBlank( __order__.PLATFORM ) == false ){
				_platform = UpdcUtils.ISubFlow.getPLATFORM( __order__.PLATFORM );
			}
			_offer.clear();
			UpfwmUtils.ICustom.wrap( __order__.OLD_PS_PARAM , _offer       );
			UpfwmUtils.ICustom.wrap( __order__.PS_PARAM     , _offer       );
		}
		
		/**
		 * @return 优先级
		 */
		public long getPRIORITY() {
			return _priority;
		}
		
		/**
		 * @param priority 优先级
		 */
		public void setPRIORITY(long priority) {
			_priority = priority;
		}
		
		/**
		 * @return 本地仓库
		 */
		public Class getREPOSITORY() {
			return _repository;
		}
		
		/**
		 * @param rEPOSITORY 本地仓库
		 */
		public void setREPOSITORY(Class rEPOSITORY) {
			_repository = rEPOSITORY;
		}
		
		/**
		 * @return 网元定单
		 */
		public IOVUpfwmOrder getORDER() {
			return _order;
		}
		
		/**
		 * @param oRDER 网元定单
		 */
		public void setORDER(IOVUpfwmOrder oRDER) {
			_order = oRDER;
		}
		
		/**
		 * @return 网元工单
		 */
		public IUpdfmxLittle getPASSIVE() {
			return _passive;
		}

		/**
		 * @param passive 网元工单
		 */
		public void setPASSIVE(IUpdfmxLittle passive) {
			_passive = passive;
		}

		/**
		 * @return 资产组件
		 */
		public IProgramTemplate.IUpdpgmOffer getPROGRAM() {
			return _program;
		}

		/**
		 * @return 归属网元
		 */
		public IPlatformTemplate.IUpffmOffer getPLATFORM() {
			return _platform;
		}

		/**
		 * @return 服务属性
		 */
		public java.util.HashMap getSUBFLOW() {
			return _subflow;
		}

		/**
		 * @return 网元属性
		 */
		public java.util.HashMap getOFFER() {
			return _offer;
		}
		
		/**
		 * @return 增量属性
		 */
		public java.util.Map getCHANGE() {
			return _change;
		}
		
		/**
		 * @return 全局属性
		 */
		public java.util.Map getGRAPHICS() {
			return _graphics;
		}
		
		/**
		 * @return 网元令牌
		 */
		public IPeriodGraphToken getTOKEN() {
			return _token;
		}
		
	}
}
