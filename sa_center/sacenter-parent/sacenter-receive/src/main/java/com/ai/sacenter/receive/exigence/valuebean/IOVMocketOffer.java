package com.ai.sacenter.receive.exigence.valuebean;

import com.ai.sacenter.receive.exigence.bo.IISPCRocketX;
import com.ai.sacenter.receive.exigence.bo.ISPCRocketX;
import com.ai.sacenter.util.OracleUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通异步定单消息</p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMocketOffer implements java.io.Serializable{
	private static final long serialVersionUID = -7849343039336755080L;
	private long   OFFER_ID     ;                        
	private long   ORDER_ID     ;                        
	private long   USER_ID      ;                        
	private long   SORT_BY      ;                        
	private java.sql.Timestamp CREATE_DATE  ;                        
	private String REGION_ID    ;                        
	private String STATE        ;                        
	private java.sql.Timestamp COMPLETE_DATE;                        
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
	private IISPCRocketX INSTANCE = null;
	public IOVMocketOffer() throws Exception{
		super();
		INSTANCE = new ISPCRocketX();
	}
	
	public IOVMocketOffer( IISPCRocketX _rocket_ ) throws Exception{
		super();
		OFFER_ID      = _rocket_.getOfferId     ();
		ORDER_ID      = _rocket_.getOrderId     ();
		USER_ID       = _rocket_.getUserId      ();
		SORT_BY       = _rocket_.getSortBy      ();
		CREATE_DATE   = _rocket_.getCreateDate  ();
		REGION_ID     = _rocket_.getRegionId    ();
		STATE         = _rocket_.getState       ();
		COMPLETE_DATE = _rocket_.getCompleteDate();
		MSG_01        = _rocket_.getMsg01       ();
		MSG_02        = _rocket_.getMsg02       ();
		MSG_03        = _rocket_.getMsg03       ();
		MSG_04        = _rocket_.getMsg04       ();
		MSG_05        = _rocket_.getMsg05       ();
		MSG_06        = _rocket_.getMsg06       ();
		MSG_07        = _rocket_.getMsg07       ();
		MSG_08        = _rocket_.getMsg08       ();
		MSG_09        = _rocket_.getMsg09       ();
		MSG_10        = _rocket_.getMsg10       ();
		MSG_11        = _rocket_.getMsg11       ();
		MSG_12        = _rocket_.getMsg12       ();
		MSG_13        = _rocket_.getMsg13       ();
		MSG_14        = _rocket_.getMsg14       ();
		MSG_15        = _rocket_.getMsg15       ();
		MSG_16        = _rocket_.getMsg16       ();
		MSG_17        = _rocket_.getMsg17       ();
		MSG_18        = _rocket_.getMsg18       ();
		MSG_19        = _rocket_.getMsg19       ();
		MSG_20        = _rocket_.getMsg20       ();
		INSTANCE      = _rocket_                  ;
	}
	
	public IOVMocketOffer( IOVMocketOffer _rocket_ ) throws Exception{
		super();
		OFFER_ID      = _rocket_.OFFER_ID      ;
		ORDER_ID      = _rocket_.ORDER_ID      ;
		USER_ID       = _rocket_.USER_ID       ;
		SORT_BY       = _rocket_.SORT_BY       ;
		CREATE_DATE   = _rocket_.CREATE_DATE   ;
		REGION_ID     = _rocket_.REGION_ID     ;
		STATE         = _rocket_.STATE         ;
		COMPLETE_DATE = _rocket_.COMPLETE_DATE ;
		MSG_01        = _rocket_.MSG_01        ;
		MSG_02        = _rocket_.MSG_02        ;
		MSG_03        = _rocket_.MSG_03        ;
		MSG_04        = _rocket_.MSG_04        ;
		MSG_05        = _rocket_.MSG_05        ;
		MSG_06        = _rocket_.MSG_06        ;
		MSG_07        = _rocket_.MSG_07        ;
		MSG_08        = _rocket_.MSG_08        ;
		MSG_09        = _rocket_.MSG_09        ;
		MSG_10        = _rocket_.MSG_10        ;
		MSG_11        = _rocket_.MSG_11        ;
		MSG_12        = _rocket_.MSG_12        ;
		MSG_13        = _rocket_.MSG_13        ;
		MSG_14        = _rocket_.MSG_14        ;
		MSG_15        = _rocket_.MSG_15        ;
		MSG_16        = _rocket_.MSG_16        ;
		MSG_17        = _rocket_.MSG_17        ;
		MSG_18        = _rocket_.MSG_18        ;
		MSG_19        = _rocket_.MSG_19        ;
		MSG_20        = _rocket_.MSG_20        ;
		INSTANCE      = (IISPCRocketX)OracleUtils.ISystem.transfer( _rocket_.INSTANCE );
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
		if (INSTANCE != null) INSTANCE.setOfferId(oFFER_ID);
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
		if (INSTANCE != null) INSTANCE.setSortBy((int)sORT_BY);
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
		if (INSTANCE != null) INSTANCE.setRegionId(rEGION_ID);
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
		if (INSTANCE != null) INSTANCE.setMsg01(mSG_01);
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
		if (INSTANCE != null) INSTANCE.setMsg02(mSG_02);
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
		if (INSTANCE != null) INSTANCE.setMsg03(mSG_03);
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
		if (INSTANCE != null) INSTANCE.setMsg04(mSG_04);
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
		if (INSTANCE != null) INSTANCE.setMsg05(mSG_05);
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
		if (INSTANCE != null) INSTANCE.setMsg06(mSG_06);
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
		if (INSTANCE != null) INSTANCE.setMsg07(mSG_07);
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
		if (INSTANCE != null) INSTANCE.setMsg08(mSG_08);
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
		if (INSTANCE != null) INSTANCE.setMsg09(mSG_09);
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
		if (INSTANCE != null) INSTANCE.setMsg10(mSG_10);
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
		if (INSTANCE != null) INSTANCE.setMsg11(mSG_11);
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
		if (INSTANCE != null) INSTANCE.setMsg12(mSG_12);
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
		if (INSTANCE != null) INSTANCE.setMsg13(mSG_13);
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
		if (INSTANCE != null) INSTANCE.setMsg14(mSG_14);
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
		if (INSTANCE != null) INSTANCE.setMsg15(mSG_15);
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
		if (INSTANCE != null) INSTANCE.setMsg16(mSG_16);
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
		if (INSTANCE != null) INSTANCE.setMsg17(mSG_17);
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
		if (INSTANCE != null) INSTANCE.setMsg18(mSG_18);
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
		if (INSTANCE != null) INSTANCE.setMsg19(mSG_19);
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
		if (INSTANCE != null) INSTANCE.setMsg20(mSG_20);
	}

	/**
	 * @return the iNSTANCE
	 */
	public IISPCRocketX getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(IISPCRocketX iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
	
}
