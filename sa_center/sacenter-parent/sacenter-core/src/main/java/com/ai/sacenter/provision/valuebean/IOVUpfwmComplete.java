package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.bo.ISAProvisionReset;
import com.ai.sacenter.util.OracleUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 异步回执工单</p>
 * <p>Copyright: Copyright (c) 2015-1-15</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfwmComplete extends IOVUpfwmBase {
	private static final long serialVersionUID = 4627566806247522607L;
	private String COMPOSITE      ;
	private IUpfwmOfferHome _order;
	public IOVUpfwmComplete() throws Exception{
		super();
		_instance = new ISAProvisionReset();
		_order    = new IUpfwmOfferHome  ();
	}
	
	public IOVUpfwmComplete( java.util.Map provision ) throws Exception{
		super();
		_instance = new ISAProvisionReset                  ();
		_order    = new IUpfwmOfferHome                    ();
		OracleUtils.ICustom.transfer( provision, _instance  );
		super.transfer( (IISAProvision)_instance            );
		COMPOSITE = ((IISAProvision)_instance).getComposite();
		((IISAProvision)_instance).setStsToOld()             ;
	}
	
	public IOVUpfwmComplete( IISAProvision provision ) throws Exception{
		super( provision );
		COMPOSITE = provision.getComposite();
		_order    = new IUpfwmOfferHome   ();
	}
	
	public IOVUpfwmComplete( IOVUpfwmComplete provision ) throws Exception{
		super( provision );
		COMPOSITE = provision.COMPOSITE                    ;
		_order    = new IUpfwmOfferHome( provision._order );
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
	 * @param cust_order the cUST_ORDER to set
	 */
	public void setCUST_ORDER(String cust_order) {
		CUST_ORDER = cust_order;
		if( _instance != null ) ((IISAProvision)_instance).setCustOrder( cust_order );
	}
	
	/**
	 * @param tASK_ID the TASK_ID to set
	 */
	public void setTASK_ID(long tASK_ID) {
		TASK_ID = tASK_ID;
		if( _instance != null ) ((IISAProvision)_instance).setTaskId( tASK_ID );
	}
	
	/**
	 * @param directive the dIRECTIVE to set
	 */
	public void setDIRECTIVE(String directive) {
		DIRECTIVE = directive;
		if( _instance != null ) ((IISAProvision)_instance).setDirective( directive );
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
	 * @param done_code the dONE_CODE to set
	 */
	public void setDONE_CODE(String done_code) {
		DONE_CODE = done_code;
		if( _instance != null ) ((IISAProvision)_instance).setDoneCode( done_code );
	}
	
	/**
	 * @param end_date the eND_DATE to set
	 */
	public void setEND_DATE(java.sql.Timestamp end_date) {
		END_DATE = end_date;
		if( _instance != null ) ((IISAProvision)_instance).setEndDate( end_date );
	}
	
	/**
	 * @param fail_code the fAIL_CODE to set
	 */
	public void setFAIL_CODE(String fail_code) {
		FAIL_CODE = fail_code;
		if( _instance != null ) ((IISAProvision)_instance).setFailCode( fail_code );
	}
	
	/**
	 * @param fail_device the FAIL_DEVICE to set
	 */
	public void setFAIL_DEVICE(String fail_device) {
		FAIL_DEVICE = fail_device;
		if( _instance != null ) ((IISAProvision)_instance).setFailDevice( fail_device );
	}
	
	/**
	 * @param fail_log the fAIL_LOG to set
	 */
	public void setFAIL_LOG(String fail_log) {
		FAIL_LOG = fail_log;
		if( _instance != null ) ((IISAProvision)_instance).setFailLog( fail_log );
	}
	
	/**
	 * @param fail_reason the fAIL_REASON to set
	 */
	public void setFAIL_REASON(String fail_reason) {
		FAIL_REASON = fail_reason;
		if( _instance != null ) ((IISAProvision)_instance).setFailReason( fail_reason );
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
		if( _instance != null ) ((IISAProvision)_instance).setPlatform( platform );
	}
	
	/**
	 * @param priority the pRIORITY to set
	 */
	public void setPRIORITY(long priority) {
		PRIORITY = priority;
		if( _instance != null ) ((IISAProvision)_instance).setPriority( priority );
	}
	
	/**
	 * @param pROGRAM the pROGRAM to set
	 */
	public void setPROGRAM(String program) throws Exception{
		PROGRAM = program;
		if( _instance != null ) ((IISAProvision)_instance).setProgram( program );
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
		if( _instance != null ) ((IISAProvision)_instance).setPsParam( ps_param );
	}
	
	/**
	 * @param ps_status the pS_STATUS to set
	 */
	public void setPS_STATUS(long ps_status) {
		PS_STATUS = ps_status;
		if( _instance != null ) ((IISAProvision)_instance).setPsStatus( (int)ps_status );
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
	}
	
	/**
	 * @param stop_type the sTOP_TYPE to set
	 */
	public void setSTOP_TYPE(long stop_type) {
		STOP_TYPE = stop_type;
		if( _instance != null && stop_type > 0 ) ((IISAProvision)_instance).setStopType( (int)stop_type );
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
	 * @return 网元激活单
	 */
	public IUpfwmOfferHome getORDER() {
		return _order;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-1-15</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -785589740318786778L;
		public IUpfwmOfferHome(){
			super();
		}
		
		public IUpfwmOfferHome( IUpfwmOfferHome order ){
			super();
		}
	}
}
