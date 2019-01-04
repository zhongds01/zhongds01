package com.ai.sacenter.core.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.core.bo.ISAQueue;
import com.ai.sacenter.core.bo.SAQueue;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.valuebean.IProgramTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务激活消息队列[I_OPEN_QUEUE]</p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVQueuePentium implements java.io.Serializable,java.lang.Comparable  {
	private static final long serialVersionUID = -7072711824147468997L;
	private long   QUEUE_ID     ;              
	private long   ORDER_ID     ;              
	private String CATEGORY     ;              
	private long   PLQK_ID      ;              
	private long   USER_ID      ;              
	private String BILL_ID      ;              
	private java.sql.Timestamp CREATE_DATE  ;              
	private String REGION_ID    ;              
	private String PLATFORM     ;   
	private String PROGRAM      ;
	private long   PRIORITY     ;              
	private String PARAM        ;              
	private String PLWK_CODING  ;              
	private String PLWK_DESCRIBE;              
	private java.sql.Timestamp PLWK_CREATE  ;
	private java.sql.Timestamp PLWK_COMPLETE;
	private long   REDO_TIMES   ;              
	private long   DONE_TIMES   ;              
	private String SRC_SYSTEM   ;
	private String ORG_ID       ;              
	private String STAFF_ID     ;              
	private String RESULT       ;              
	private String STATE        ;
	private java.sql.Timestamp COMPLETE_DATE;   
	private IQueueOfferHome _order = new IQueueOfferHome();
	private ISAQueue  INSTANCE;
	public IOVQueuePentium() throws Exception{
		super();
		INSTANCE = new SAQueue();
	}
	public IOVQueuePentium( ISAQueue aQueue ) throws Exception{
		super();
		INSTANCE = aQueue;
		UpdcUtils.ICustom._wrap( aQueue, this );
		INSTANCE.setStsToOld();
	}
	public IOVQueuePentium( java.util.HashMap aUpdgmLife ) throws Exception{
		super();
		INSTANCE = new SAQueue();
		OracleUtils.ICustom.transfer( aUpdgmLife , INSTANCE );
		UpdcUtils.ICustom._wrap( INSTANCE , this );
		INSTANCE.setStsToOld();
	}
	
	/**
	 * @return the bILL_ID
	 */
	public String getBILL_ID() {
		return BILL_ID;
	}
	/**
	 * @param bill_id the bILL_ID to set
	 */
	public void setBILL_ID(String bill_id) {
		BILL_ID = bill_id;
		if( INSTANCE != null ) INSTANCE.setBillId( bill_id );
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
		if( INSTANCE != null ) INSTANCE.setCategory( category );
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
	 * @return the dONE_TIMES
	 */
	public long getDONE_TIMES() {
		return DONE_TIMES;
	}
	/**
	 * @param done_times the dONE_TIMES to set
	 */
	public void setDONE_TIMES(long done_times) {
		DONE_TIMES = done_times;
		if( INSTANCE != null ) INSTANCE.setDoneTimes( (int)done_times );
	}
	/**
	 * @return the iNSTANCE
	 */
	public ISAQueue getINSTANCE() {
		return INSTANCE;
	}
	/**
	 * @return _order
	 */
	public IQueueOfferHome getORDER() {
		return _order;
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
	 * @return the pROGRAM
	 */
	public String getPROGRAM() {
		return PROGRAM;
	}
	
	/**
	 * @param pROGRAM the pROGRAM to set
	 */
	public void setPROGRAM(String pROGRAM) {
		PROGRAM = pROGRAM;
		if( INSTANCE != null ) INSTANCE.setProgram( pROGRAM );
	}
	/**
	 * @return the pLQK_ID
	 */
	public long getPLQK_ID() {
		return PLQK_ID;
	}
	/**
	 * @param plqk_id the pLQK_ID to set
	 */
	public void setPLQK_ID(long plqk_id) {
		PLQK_ID = plqk_id;
		if( INSTANCE != null ) INSTANCE.setPlqkId( plqk_id );
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
	 * @return the pLWK_DESCRIBE
	 */
	public String getPLWK_DESCRIBE() {
		return PLWK_DESCRIBE;
	}
	/**
	 * @param plwk_describe the pLWK_DESCRIBE to set
	 */
	public void setPLWK_DESCRIBE(String plwk_describe) {
		PLWK_DESCRIBE = plwk_describe;
		if( INSTANCE != null ) INSTANCE.setPlwkDescribe( PLWK_DESCRIBE );
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
		_order.PRIORITY = priority;
		if( INSTANCE != null ) INSTANCE.setPriority( priority );
	}
	
	/**
	 * @return the qUEUE_ID
	 */
	public long getQUEUE_ID() {
		return QUEUE_ID;
	}
	/**
	 * @param queue_id the qUEUE_ID to set
	 */
	public void setQUEUE_ID(long queue_id) {
		QUEUE_ID = queue_id;
		if( INSTANCE != null ) INSTANCE.setQueueId( queue_id );
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
		if( INSTANCE != null ) INSTANCE.setResult( result );
	}
	/**
	 * @return the sRC_SYSTEM
	 */
	public String getSRC_SYSTEM() {
		return SRC_SYSTEM;
	}
	/**
	 * @param src_system the sRC_SYSTEM to set
	 */
	public void setSRC_SYSTEM(String src_system) {
		SRC_SYSTEM = src_system;
		if( INSTANCE != null ) INSTANCE.setSrcSystem( src_system );
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
	 * @return the pARAM
	 */
	public String getPARAM() {
		return PARAM;
	}
	/**
	 * @param param the pARAM to set
	 */
	public void setPARAM(String param) {
		PARAM = param;
		if( INSTANCE != null ) INSTANCE.setParam( param );
		JdomUtils.ICustom.wrap( PARAM, _order.OFFER );
	}
	/**
	 * 工单时序编码
	 * @return
	 */
	public String getTIMESQ( ){
		return ClassUtils.getINDEX( new String[]{ 
                StringUtils.filling( TimeUtils.format( CREATE_DATE, "yyyyMMddHHmmssSSS"), 
                		17,
                		StringUtils.LEFT,
                		' '),
                "_$_",  
                StringUtils.filling( String.valueOf( QUEUE_ID ), 
                		15, 
                		StringUtils.RIGHT,
                		'0')} );
	}
	/**
	 * 是否转重做机制
	 * @return
	 */
	public boolean isRETRY(){
		return DONE_TIMES < REDO_TIMES;
	}
	/**
	 * 判断是否为落地模式
	 * @return
	 */
	public boolean isHUMAN(){
		return StringUtils.equals( SRC_SYSTEM, IUpdcConst.IUpdbm.IUpdbf.HUMAN );
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		int doCompare = 1;
		doCompare = obj != null && obj instanceof IOVQueuePentium?0:1;
		if( doCompare == 0 ) doCompare = (new Long(QUEUE_ID)).compareTo( new Long( ((IOVQueuePentium)obj).QUEUE_ID ) );
		return doCompare;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean doEqual = obj == null || (obj instanceof IOVQueuePentium ) == false?false:true;
		if( doEqual == true ) doEqual = ((IOVQueuePentium)obj).QUEUE_ID == QUEUE_ID;
		return doEqual;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-5-14</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IQueueOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -7279895052606873770L;
		/*临时优先级*/
		private long   PRIORITY ;
		/*队列属性*/
		private java.util.Map OFFER = new java.util.HashMap();
		/*队列归档组件*/
		private IProgramTemplate.IUpdfcmpOffer COMPLETE = null;
		/*发起方工单*/
		private Object ORIGING = null;
		public IQueueOfferHome(){
			super();
		}
		/**
		 * @return 临时优先级
		 */
		public long getPRIORITY() {
			return PRIORITY;
		}
		/**
		 * @param priority 临时优先级
		 */
		public void setPRIORITY(long priority) {
			PRIORITY = priority;
		}
		/**
		 * @return 队列归档组件
		 */
		public IProgramTemplate.IUpdfcmpOffer getCOMPLETE() {
			return COMPLETE;
		}
		/**
		 * @param plwk_complete 队列归档组件
		 */
		public void setCOMPLETE(IProgramTemplate.IUpdfcmpOffer complete) {
			COMPLETE = complete;
		}
		/**
		 * @return 队列属性
		 */
		public java.util.Map getOFFER() {
			return OFFER;
		}
		/**
		 * @return 发起方工单
		 */
		public Object getORIGING() {
			return ORIGING;
		}
		/**
		 * @param origing 发起方工单
		 */
		public void setPLWK_ORIGING(Object origing) {
			ORIGING = origing;
		}
		
	}
}
