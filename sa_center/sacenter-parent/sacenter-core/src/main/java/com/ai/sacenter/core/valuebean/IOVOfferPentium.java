package com.ai.sacenter.core.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.core.bo.ISAOffer;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务定单订购</p>
 * <p>Copyright: Copyright (c) 2015年10月12日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVOfferPentium implements java.io.Serializable,java.lang.Comparable{
	private static final long serialVersionUID = 2810472256591932945L;
	private long   OFFER_ID     ;
	private long   ORDER_ID     ;
	private long   USER_ID      ;
	private java.sql.Timestamp CREATE_DATE  ;
	private String REGION_ID    ;
	private long   COMPETE_ID   ;
	private long   PRODUCT_ID   ;
	private String SUBFLOW      ;
	private long   SORT_BY      ;
	private String COMPTEL      ;
	private String PARAM_01     ;
	private String PARAM_02     ;
	private String PARAM_03     ;
	private String PARAM_04     ;
	private String PARAM_05     ;
	private java.sql.Timestamp COMPLETE_DATE;
	private String STATE        ;
	private ISAOffer INSTANCE = null;
	private IOfferMBeanHome _order = new IOfferMBeanHome();
	public IOVOfferPentium() {
		super();
	}
	public IOVOfferPentium( IOVOfferPentium fromOffer ) throws Exception{
		super();
		OFFER_ID      = fromOffer.OFFER_ID      ;
		ORDER_ID      = fromOffer.ORDER_ID      ;
		USER_ID       = fromOffer.USER_ID       ;
		CREATE_DATE   = fromOffer.CREATE_DATE   ;
		REGION_ID     = fromOffer.REGION_ID     ;
		COMPETE_ID    = fromOffer.COMPETE_ID    ;
		PRODUCT_ID    = fromOffer.PRODUCT_ID    ;
		SUBFLOW       = fromOffer.SUBFLOW       ;
		SORT_BY       = fromOffer.SORT_BY       ;
		COMPTEL       = fromOffer.COMPTEL       ;
		PARAM_01      = fromOffer.PARAM_01      ;
		PARAM_02      = fromOffer.PARAM_02      ;
		PARAM_03      = fromOffer.PARAM_03      ;
		PARAM_04      = fromOffer.PARAM_04      ;
		PARAM_05      = fromOffer.PARAM_05      ;
		COMPLETE_DATE = fromOffer.COMPLETE_DATE ;
		STATE         = fromOffer.STATE         ;
		INSTANCE      = (ISAOffer)OracleUtils.ISystem.transfer( fromOffer.INSTANCE );
		_order._wrap( fromOffer._order );
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
		if( INSTANCE != null ){ INSTANCE.setOfferId( oFFER_ID ); }
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
		if( INSTANCE != null ){ INSTANCE.setOrderId( oRDER_ID ); }
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
		if( INSTANCE != null ){ INSTANCE.setUserId( uSER_ID ); }
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
		if( INSTANCE != null ){ INSTANCE.setCreateDate( cREATE_DATE ); }
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
		if( INSTANCE != null ){ INSTANCE.setRegionId( rEGION_ID ); }
	}

	/**
	 * @return the cOMPETE_ID
	 */
	public long getCOMPETE_ID() {
		return COMPETE_ID;
	}

	/**
	 * @param cOMPETE_ID the cOMPETE_ID to set
	 */
	public void setCOMPETE_ID(long cOMPETE_ID) {
		COMPETE_ID = cOMPETE_ID;
		if( INSTANCE != null ){ INSTANCE.setCompeteId( cOMPETE_ID ); }
	}

	/**
	 * @return the pRODUCT_ID
	 */
	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	/**
	 * @param pRODUCT_ID the pRODUCT_ID to set
	 */
	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
		if( INSTANCE != null ){ INSTANCE.setProductId( pRODUCT_ID ); }
	}

	/**
	 * @return the sUBFLOW
	 */
	public String getSUBFLOW() {
		return SUBFLOW;
	}

	/**
	 * @param sUBFLOW the sUBFLOW to set
	 */
	public void setSUBFLOW(String sUBFLOW) {
		SUBFLOW = sUBFLOW;
		if( INSTANCE != null ){ INSTANCE.setSubflow( sUBFLOW ); }
	}

	/**
	 * @return the sORT_BY
	 */
	public long getSORT_BY() {
		return SORT_BY;
	}

	/**
	 * @param sORT_BY the sORT_BY to set
	 */
	public void setSORT_BY(long sORT_BY) {
		SORT_BY = sORT_BY;
		if( INSTANCE != null ){ INSTANCE.setSortBy( (int)sORT_BY ); }
	}

	/**
	 * @return the cOMPTEL
	 */
	public String getCOMPTEL() {
		return COMPTEL;
	}

	/**
	 * @param cOMPTEL the cOMPTEL to set
	 */
	public void setCOMPTEL(String cOMPTEL) {
		COMPTEL = cOMPTEL;
		if( INSTANCE != null ) INSTANCE.setComptel( cOMPTEL );
	}

	/**
	 * @return the pARAM_01
	 */
	public String getPARAM_01() {
		return PARAM_01;
	}

	/**
	 * @param pARAM_01 the pARAM_01 to set
	 */
	public void setPARAM_01(String pARAM_01) throws Exception{
		PARAM_01 = pARAM_01;
		if( INSTANCE != null && pARAM_01 != null ){ INSTANCE.setParam01( pARAM_01 ); }
		else if( INSTANCE != null ){ INSTANCE.set( ISAOffer.S_Param01, null ); }
	}

	/**
	 * @return the pARAM_02
	 */
	public String getPARAM_02() {
		return PARAM_02;
	}

	/**
	 * @param pARAM_02 the pARAM_02 to set
	 */
	public void setPARAM_02(String pARAM_02) throws Exception {
		PARAM_02 = pARAM_02;
		if( INSTANCE != null && pARAM_02 != null ){ INSTANCE.setParam02( pARAM_02 ); }
		else if( INSTANCE != null ){ INSTANCE.set( ISAOffer.S_Param02, null ); }
	}

	/**
	 * @return the pARAM_03
	 */
	public String getPARAM_03() {
		return PARAM_03;
	}

	/**
	 * @param pARAM_03 the pARAM_03 to set
	 */
	public void setPARAM_03(String pARAM_03) throws Exception {
		PARAM_03 = pARAM_03;
		if( INSTANCE != null && pARAM_03 != null ){ INSTANCE.setParam03( pARAM_03 ); }
		else if( INSTANCE != null ){ INSTANCE.set( ISAOffer.S_Param03, null ); }
	}

	/**
	 * @return the pARAM_04
	 */
	public String getPARAM_04() {
		return PARAM_04;
	}

	/**
	 * @param pARAM_04 the pARAM_04 to set
	 */
	public void setPARAM_04(String pARAM_04) throws Exception {
		PARAM_04 = pARAM_04;
		if( INSTANCE != null && pARAM_04 != null ){ INSTANCE.setParam04( pARAM_04 ); }
		else if( INSTANCE != null ){ INSTANCE.set( ISAOffer.S_Param04, null ); }
	}

	/**
	 * @return the pARAM_05
	 */
	public String getPARAM_05() {
		return PARAM_05;
	}

	/**
	 * @param pARAM_05 the pARAM_05 to set
	 */
	public void setPARAM_05(String pARAM_05) throws Exception {
		PARAM_05 = pARAM_05;
		if( INSTANCE != null && pARAM_05 != null ){ INSTANCE.setParam05( pARAM_05 ); }
		else if( INSTANCE != null ){ INSTANCE.set( ISAOffer.S_Param05, null ); }
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
		if( INSTANCE != null ){ INSTANCE.setCompleteDate( cOMPLETE_DATE ); }
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
		if( INSTANCE != null ){ INSTANCE.setState( sTATE ); }
	}

	/**
	 * @return the iNSTANCE
	 */
	public ISAOffer getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(ISAOffer iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	/**
	 * @return order
	 */
	public IOfferMBeanHome getORDER() {
		return _order;
	}
	
	/**
	 * 是否服务产品已取消
	 * @return
	 */
	public boolean isCANCEL(){
		return StringUtils.equals( STATE, IUpdcConst.IState.D );
	}
	
	/**
	 * 是否具备工单拆分能力
	 * @return
	 */
	public boolean isSUBFLOW(){
		return StringUtils.equals( STATE, IUpdcConst.IState.C ) && 
				StringUtils.isBlank( SUBFLOW ) == false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object _objective) {
		int doCompare = 1;
		doCompare = ( _objective != null && _objective instanceof IOVOfferPentium )?0:1;
		if( doCompare == 0 ){
			doCompare = (new Long(OFFER_ID)).compareTo( new Long( ((IOVOfferPentium)_objective).OFFER_ID ) );
		}
		return doCompare;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object _objective) {
		boolean doEqual = ( _objective == null || ( _objective instanceof IOVOfferPentium ) == false )?false:true;
		if( doEqual == true ){ doEqual = ((IOVOfferPentium) _objective).OFFER_ID == OFFER_ID; }
		return doEqual;
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月12日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IOfferMBeanHome implements java.io.Serializable{
		private static final long serialVersionUID = -4483623948258752424L;
		/*开通功能串*/
		private java.util.HashMap _offer = new java.util.HashMap();
		public IOfferMBeanHome(){
			super();
		}
		
		/**
		 * @return the oFFER
		 */
		public java.util.HashMap getOFFER() {
			return _offer;
		}
		
		/**
		 * 
		 * @param fromHome
		 * @throws Exception
		 */
		public void _wrap( IOfferMBeanHome fromHome ) throws Exception{
			ClassUtils.IMerge.merge( fromHome._offer, _offer );
		}
	}
}
