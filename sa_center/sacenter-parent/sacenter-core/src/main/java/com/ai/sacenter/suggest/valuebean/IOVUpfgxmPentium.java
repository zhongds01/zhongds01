package com.ai.sacenter.suggest.valuebean;

import com.ai.sacenter.suggest.bo.ISASuggest;
import com.ai.sacenter.suggest.bo.SASuggest;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.UpfgxmUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务开通阶段类通知</p>
 * <p>Copyright: Copyright (c) 2013-8-29</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpfgxmPentium implements java.io.Serializable{
	private static final long serialVersionUID = -3266937388289117045L;
	private long   MQMSG_ID     ;
	private String CUST_ORDER   ;
	private String DONE_CODE    ;
	private String CATEGORY     ;
	private long   ORDER_ID     ;
	private long   PLQK_ID      ;
	private long   USER_ID      ;
	private String PROGRAM      ;
	private java.sql.Timestamp CREATE_DATE  ;
	private String REGION_ID    ;
	private String ORDER_REGION_ID;
	private java.sql.Timestamp COMPLETE_DATE;
	private String STATE        ;
	private String MSG_01       ;
	private String MSG_02       ;
	private String MSG_03       ;
	private String MSG_04       ;
	private String MSG_05       ;
	private String MSG_06       ;
	private String MSG_07       ;
	private String MSG_08       ;
	private String MSG_09       ;
	private String MSG_10       ;
	private String MSG_11       ;
	private String MSG_12       ;
	private String MSG_13       ;
	private String MSG_14       ;
	private String MSG_15       ;
	private String MSG_16       ;
	private String MSG_17       ;
	private String MSG_18       ;
	private String MSG_19       ;
	private String MSG_20       ;
	private String FAIL_LOG     ;
	private String ORG_ID       ;
	private String STAFF_ID     ;
	private ISASuggest INSTANCE = null;
	public IOVUpfgxmPentium() throws Exception{
		super();
		INSTANCE = new SASuggest();
	}
	public IOVUpfgxmPentium( ISASuggest aSuggest ) throws Exception{
		super();
		UpfgxmUtils.ICustom._wrap(aSuggest, this);
		INSTANCE  = aSuggest;
	}
	public IOVUpfgxmPentium(java.util.HashMap fromSuggest ) throws Exception{
		super();
		ISASuggest aSuggest = new SASuggest();
		OracleUtils.ICustom.transfer( fromSuggest , aSuggest );
		UpfgxmUtils.ICustom._wrap(aSuggest, this);
		aSuggest.setStsToOld();
		INSTANCE = aSuggest;
	}
	/**
	 * @return the mQMSG_ID
	 */
	public long getMQMSG_ID() {
		return MQMSG_ID;
	}
	/**
	 * @param mQMSG_ID the mQMSG_ID to set
	 */
	public void setMQMSG_ID(long mQMSG_ID) {
		MQMSG_ID = mQMSG_ID;
		if( INSTANCE != null ) INSTANCE.setMqmsgId( mQMSG_ID );
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
		if( INSTANCE != null ) INSTANCE.setCustOrder( cUST_ORDER );
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
		if( INSTANCE != null ) INSTANCE.setDoneCode( dONE_CODE );
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
		if( INSTANCE != null ) INSTANCE.setCategory( cATEGORY );
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
		if( INSTANCE != null ) INSTANCE.setOrderId( oRDER_ID );
	}
	/**
	 * @return the pLQK_ID
	 */
	public long getPLQK_ID() {
		return PLQK_ID;
	}
	/**
	 * @param pLQK_ID the pLQK_ID to set
	 */
	public void setPLQK_ID(long pLQK_ID) {
		PLQK_ID = pLQK_ID;
		if( INSTANCE != null ) INSTANCE.setPlqkId( pLQK_ID );
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
		if( INSTANCE != null ) INSTANCE.setUserId( uSER_ID );
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
		if( INSTANCE != null ) INSTANCE.setCreateDate( cREATE_DATE );
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
		if( INSTANCE != null ) INSTANCE.setRegionId( rEGION_ID );
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
		if( INSTANCE != null ) INSTANCE.setState( sTATE );
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
		if( INSTANCE != null ) INSTANCE.setOrderRegionId( oRDER_REGION_ID );
	}
	/**
	 * @return the mSG_01
	 */
	public String getMSG_01() {
		return MSG_01;
	}
	/**
	 * @param mSG_01 the mSG_01 to set
	 */
	public void setMSG_01(String mSG_01) {
		MSG_01 = mSG_01;
		if( INSTANCE != null ) INSTANCE.setMsg01( mSG_01 );
	}
	/**
	 * @return the mSG_02
	 */
	public String getMSG_02() {
		return MSG_02;
	}
	/**
	 * @param mSG_02 the mSG_02 to set
	 */
	public void setMSG_02(String mSG_02) {
		MSG_02 = mSG_02;
		if( INSTANCE != null ) INSTANCE.setMsg02( mSG_02 );
	}
	/**
	 * @return the mSG_03
	 */
	public String getMSG_03() {
		return MSG_03;
	}
	/**
	 * @param mSG_03 the mSG_03 to set
	 */
	public void setMSG_03(String mSG_03) {
		MSG_03 = mSG_03;
		if( INSTANCE != null ) INSTANCE.setMsg03( mSG_03 );
	}
	/**
	 * @return the mSG_04
	 */
	public String getMSG_04() {
		return MSG_04;
	}
	/**
	 * @param mSG_04 the mSG_04 to set
	 */
	public void setMSG_04(String mSG_04) {
		MSG_04 = mSG_04;
		if( INSTANCE != null ) INSTANCE.setMsg04( mSG_04 );
	}
	/**
	 * @return the mSG_05
	 */
	public String getMSG_05() {
		return MSG_05;
	}
	/**
	 * @param mSG_05 the mSG_05 to set
	 */
	public void setMSG_05(String mSG_05) {
		MSG_05 = mSG_05;
		if( INSTANCE != null ) INSTANCE.setMsg05( mSG_05 );
	}
	/**
	 * @return the mSG_06
	 */
	public String getMSG_06() {
		return MSG_06;
	}
	/**
	 * @param mSG_06 the mSG_06 to set
	 */
	public void setMSG_06(String mSG_06) {
		MSG_06 = mSG_06;
		if( INSTANCE != null ) INSTANCE.setMsg06( mSG_06 );
	}
	/**
	 * @return the mSG_07
	 */
	public String getMSG_07() {
		return MSG_07;
	}
	/**
	 * @param mSG_07 the mSG_07 to set
	 */
	public void setMSG_07(String mSG_07) {
		MSG_07 = mSG_07;
		if( INSTANCE != null ) INSTANCE.setMsg07( mSG_07 );
	}
	/**
	 * @return the mSG_08
	 */
	public String getMSG_08() {
		return MSG_08;
	}
	/**
	 * @param mSG_08 the mSG_08 to set
	 */
	public void setMSG_08(String mSG_08) {
		MSG_08 = mSG_08;
		if( INSTANCE != null ) INSTANCE.setMsg08( mSG_08 );
	}
	/**
	 * @return the mSG_09
	 */
	public String getMSG_09() {
		return MSG_09;
	}
	/**
	 * @param mSG_09 the mSG_09 to set
	 */
	public void setMSG_09(String mSG_09) {
		MSG_09 = mSG_09;
		if( INSTANCE != null ) INSTANCE.setMsg09( mSG_09 );
	}
	/**
	 * @return the mSG_10
	 */
	public String getMSG_10() {
		return MSG_10;
	}
	/**
	 * @param mSG_10 the mSG_10 to set
	 */
	public void setMSG_10(String mSG_10) {
		MSG_10 = mSG_10;
		if( INSTANCE != null ) INSTANCE.setMsg10( mSG_10 );
	}
	/**
	 * @return the mSG_11
	 */
	public String getMSG_11() {
		return MSG_11;
	}
	/**
	 * @param mSG_11 the mSG_11 to set
	 */
	public void setMSG_11(String mSG_11) {
		MSG_11 = mSG_11;
		if( INSTANCE != null ) INSTANCE.setMsg11( mSG_11 );
	}
	/**
	 * @return the mSG_12
	 */
	public String getMSG_12() {
		return MSG_12;
	}
	/**
	 * @param mSG_12 the mSG_12 to set
	 */
	public void setMSG_12(String mSG_12) {
		MSG_12 = mSG_12;
		if( INSTANCE != null ) INSTANCE.setMsg12( mSG_12 );
	}
	/**
	 * @return the mSG_13
	 */
	public String getMSG_13() {
		return MSG_13;
	}
	/**
	 * @param mSG_13 the mSG_13 to set
	 */
	public void setMSG_13(String mSG_13) {
		MSG_13 = mSG_13;
		if( INSTANCE != null ) INSTANCE.setMsg13( mSG_13 );
	}
	/**
	 * @return the mSG_14
	 */
	public String getMSG_14() {
		return MSG_14;
	}
	/**
	 * @param mSG_14 the mSG_14 to set
	 */
	public void setMSG_14(String mSG_14) {
		MSG_14 = mSG_14;
		if( INSTANCE != null ) INSTANCE.setMsg14( mSG_14 );
	}
	/**
	 * @return the mSG_15
	 */
	public String getMSG_15() {
		return MSG_15;
	}
	/**
	 * @param mSG_15 the mSG_15 to set
	 */
	public void setMSG_15(String mSG_15) {
		MSG_15 = mSG_15;
		if( INSTANCE != null ) INSTANCE.setMsg15( mSG_15 );
	}
	/**
	 * @return the mSG_16
	 */
	public String getMSG_16() {
		return MSG_16;
	}
	/**
	 * @param mSG_16 the mSG_16 to set
	 */
	public void setMSG_16(String mSG_16) {
		MSG_16 = mSG_16;
		if( INSTANCE != null ) INSTANCE.setMsg16( mSG_16 );
	}
	/**
	 * @return the mSG_17
	 */
	public String getMSG_17() {
		return MSG_17;
	}
	/**
	 * @param mSG_17 the mSG_17 to set
	 */
	public void setMSG_17(String mSG_17) {
		MSG_17 = mSG_17;
		if( INSTANCE != null ) INSTANCE.setMsg17( mSG_17 );
	}
	/**
	 * @return the mSG_18
	 */
	public String getMSG_18() {
		return MSG_18;
	}
	/**
	 * @param mSG_18 the mSG_18 to set
	 */
	public void setMSG_18(String mSG_18) {
		MSG_18 = mSG_18;
		if( INSTANCE != null ) INSTANCE.setMsg18( mSG_18 );
	}
	/**
	 * @return the mSG_19
	 */
	public String getMSG_19() {
		return MSG_19;
	}
	/**
	 * @param mSG_19 the mSG_19 to set
	 */
	public void setMSG_19(String mSG_19) {
		MSG_19 = mSG_19;
		if( INSTANCE != null ) INSTANCE.setMsg19( mSG_19 );
	}
	/**
	 * @return the mSG_20
	 */
	public String getMSG_20() {
		return MSG_20;
	}
	/**
	 * @param mSG_20 the mSG_20 to set
	 */
	public void setMSG_20(String mSG_20) {
		MSG_20 = mSG_20;
		if( INSTANCE != null ) INSTANCE.setMsg20( mSG_20 );
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
		if( INSTANCE != null ) INSTANCE.setFailLog( fAIL_LOG );
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
		if( INSTANCE != null ) INSTANCE.setCompleteDate( cOMPLETE_DATE );
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
		if( INSTANCE != null ) INSTANCE.setOrgId( oRG_ID );
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
		if( INSTANCE != null ) INSTANCE.setStaffId( sTAFF_ID );
	}
	/**
	 * @return the iNSTANCE
	 */
	public ISASuggest getINSTANCE() {
		return INSTANCE;
	}
	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(ISASuggest iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
}
