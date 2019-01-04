package com.ai.sacenter.cboss.valuebean;

import com.ai.sacenter.cboss.bo.IISARadiusX;
import com.ai.sacenter.cboss.bo.ISARadiusX;

public class IOVUpfgsmRocket extends IOVUpfgsmOffer {
	private static final long serialVersionUID = -6725708351875093553L;
	private long   MSO_NBR	   ;
	private long   SORT_BY	   ;
	private String PARAM_01    ;                        
	private String PARAM_02    ;                        
	private String PARAM_03    ;                        
	private String PARAM_04    ;                        
	private String PARAM_05    ;                        
	private String PARAM_06    ;                        
	private String PARAM_07    ;                        
	private String PARAM_08    ;                        
	private String PARAM_09    ;                        
	private String PARAM_10    ;                        
	private String PARAM_11    ;                        
	private String PARAM_12    ;                        
	private String PARAM_13    ;                        
	private String PARAM_14    ;                        
	private String PARAM_15    ;                        
	private String PARAM_16    ;                        
	private String PARAM_17    ;                        
	private String PARAM_18    ;                        
	private String PARAM_19    ;                        
	private String PARAM_20    ;
	public IOVUpfgsmRocket() throws Exception{
		super();
		_instance = new ISARadiusX();
	}

	public IOVUpfgsmRocket(IISARadiusX instance) throws Exception{
		super( instance );
		MSO_NBR	 = instance.getMsoNbr ();
		SORT_BY	 = instance.getSortBy ();
		PARAM_01 = instance.getParam01();                        
		PARAM_02 = instance.getParam02();                        
		PARAM_03 = instance.getParam03();                        
		PARAM_04 = instance.getParam04();                        
		PARAM_05 = instance.getParam05();                        
		PARAM_06 = instance.getParam06();                        
		PARAM_07 = instance.getParam07();                        
		PARAM_08 = instance.getParam08();                        
		PARAM_09 = instance.getParam09();                        
		PARAM_10 = instance.getParam10();                        
		PARAM_11 = instance.getParam11();                        
		PARAM_12 = instance.getParam12();                        
		PARAM_13 = instance.getParam13();                        
		PARAM_14 = instance.getParam14();                        
		PARAM_15 = instance.getParam15();                        
		PARAM_16 = instance.getParam16();                        
		PARAM_17 = instance.getParam17();                        
		PARAM_18 = instance.getParam18();                        
		PARAM_19 = instance.getParam19();                        
		PARAM_20 = instance.getParam20();
	}
	
	public IOVUpfgsmRocket( IOVUpfgsmRocket provision ) throws Exception{
		super( provision );
		MSO_NBR	 = provision.getMSO_NBR	();
		SORT_BY	 = provision.getSORT_BY	();
		PARAM_01 = provision.getPARAM_01();                        
		PARAM_02 = provision.getPARAM_02();                        
		PARAM_03 = provision.getPARAM_03();                        
		PARAM_04 = provision.getPARAM_04();                        
		PARAM_05 = provision.getPARAM_05();                        
		PARAM_06 = provision.getPARAM_06();                        
		PARAM_07 = provision.getPARAM_07();                        
		PARAM_08 = provision.getPARAM_08();                        
		PARAM_09 = provision.getPARAM_09();                        
		PARAM_10 = provision.getPARAM_10();                        
		PARAM_11 = provision.getPARAM_11();                        
		PARAM_12 = provision.getPARAM_12();                        
		PARAM_13 = provision.getPARAM_13();                        
		PARAM_14 = provision.getPARAM_14();                        
		PARAM_15 = provision.getPARAM_15();                        
		PARAM_16 = provision.getPARAM_16();                        
		PARAM_17 = provision.getPARAM_17();                        
		PARAM_18 = provision.getPARAM_18();                        
		PARAM_19 = provision.getPARAM_19();                        
		PARAM_20 = provision.getPARAM_20();
	}
	
	/**
	 * @return the mSO_NBR
	 */
	public long getMSO_NBR() {
		return MSO_NBR;
	}

	/**
	 * @param mSO_NBR the mSO_NBR to set
	 */
	public void setMSO_NBR(long mSO_NBR) {
		MSO_NBR = mSO_NBR;
		if( _instance != null ){ ((IISARadiusX)_instance).setMsoNbr( mSO_NBR ); }
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
		if( _instance != null ){ ((IISARadiusX)_instance).setSortBy( (int)sORT_BY ); }
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
	public void setPARAM_01(String pARAM_01) {
		PARAM_01 = pARAM_01;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam01( pARAM_01 ); }
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
	public void setPARAM_02(String pARAM_02) {
		PARAM_02 = pARAM_02;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam02( pARAM_02 ); }
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
	public void setPARAM_03(String pARAM_03) {
		PARAM_03 = pARAM_03;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam03( pARAM_03 ); }
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
	public void setPARAM_04(String pARAM_04) {
		PARAM_04 = pARAM_04;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam04( pARAM_04 ); }
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
	public void setPARAM_05(String pARAM_05) {
		PARAM_05 = pARAM_05;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam05( pARAM_05 ); }
	}

	/**
	 * @return the pARAM_06
	 */
	public String getPARAM_06() {
		return PARAM_06;
	}

	/**
	 * @param pARAM_06 the pARAM_06 to set
	 */
	public void setPARAM_06(String pARAM_06) {
		PARAM_06 = pARAM_06;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam06( pARAM_06 ); }
	}

	/**
	 * @return the pARAM_07
	 */
	public String getPARAM_07() {
		return PARAM_07;
	}

	/**
	 * @param pARAM_07 the pARAM_07 to set
	 */
	public void setPARAM_07(String pARAM_07) {
		PARAM_07 = pARAM_07;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam07( pARAM_07 ); }
	}

	/**
	 * @return the pARAM_08
	 */
	public String getPARAM_08() {
		return PARAM_08;
	}

	/**
	 * @param pARAM_08 the pARAM_08 to set
	 */
	public void setPARAM_08(String pARAM_08) {
		PARAM_08 = pARAM_08;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam08( pARAM_08 ); }
	}

	/**
	 * @return the pARAM_09
	 */
	public String getPARAM_09() {
		return PARAM_09;
	}

	/**
	 * @param pARAM_09 the pARAM_09 to set
	 */
	public void setPARAM_09(String pARAM_09) {
		PARAM_09 = pARAM_09;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam09( pARAM_09 ); }
	}

	/**
	 * @return the pARAM_10
	 */
	public String getPARAM_10() {
		return PARAM_10;
	}

	/**
	 * @param pARAM_10 the pARAM_10 to set
	 */
	public void setPARAM_10(String pARAM_10) {
		PARAM_10 = pARAM_10;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam10( pARAM_10 ); }
	}

	/**
	 * @return the pARAM_11
	 */
	public String getPARAM_11() {
		return PARAM_11;
	}

	/**
	 * @param pARAM_11 the pARAM_11 to set
	 */
	public void setPARAM_11(String pARAM_11) {
		PARAM_11 = pARAM_11;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam11( pARAM_11 ); }
	}

	/**
	 * @return the pARAM_12
	 */
	public String getPARAM_12() {
		return PARAM_12;
	}

	/**
	 * @param pARAM_12 the pARAM_12 to set
	 */
	public void setPARAM_12(String pARAM_12) {
		PARAM_12 = pARAM_12;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam12( pARAM_12 ); }
	}

	/**
	 * @return the pARAM_13
	 */
	public String getPARAM_13() {
		return PARAM_13;
	}

	/**
	 * @param pARAM_13 the pARAM_13 to set
	 */
	public void setPARAM_13(String pARAM_13) {
		PARAM_13 = pARAM_13;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam13( pARAM_13 ); }
	}

	/**
	 * @return the pARAM_14
	 */
	public String getPARAM_14() {
		return PARAM_14;
	}

	/**
	 * @param pARAM_14 the pARAM_14 to set
	 */
	public void setPARAM_14(String pARAM_14) {
		PARAM_14 = pARAM_14;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam14( pARAM_14 ); }
	}

	/**
	 * @return the pARAM_15
	 */
	public String getPARAM_15() {
		return PARAM_15;
	}

	/**
	 * @param pARAM_15 the pARAM_15 to set
	 */
	public void setPARAM_15(String pARAM_15) {
		PARAM_15 = pARAM_15;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam15( pARAM_15 ); }
	}

	/**
	 * @return the pARAM_16
	 */
	public String getPARAM_16() {
		return PARAM_16;
	}

	/**
	 * @param pARAM_16 the pARAM_16 to set
	 */
	public void setPARAM_16(String pARAM_16) {
		PARAM_16 = pARAM_16;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam16( pARAM_16 ); }
	}

	/**
	 * @return the pARAM_17
	 */
	public String getPARAM_17() {
		return PARAM_17;
	}

	/**
	 * @param pARAM_17 the pARAM_17 to set
	 */
	public void setPARAM_17(String pARAM_17) {
		PARAM_17 = pARAM_17;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam17( pARAM_17 ); }
	}

	/**
	 * @return the pARAM_18
	 */
	public String getPARAM_18() {
		return PARAM_18;
	}

	/**
	 * @param pARAM_18 the pARAM_18 to set
	 */
	public void setPARAM_18(String pARAM_18) {
		PARAM_18 = pARAM_18;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam18( pARAM_18 ); }
	}

	/**
	 * @return the pARAM_19
	 */
	public String getPARAM_19() {
		return PARAM_19;
	}

	/**
	 * @param pARAM_19 the pARAM_19 to set
	 */
	public void setPARAM_19(String pARAM_19) {
		PARAM_19 = pARAM_19;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam19( pARAM_19 ); }
	}

	/**
	 * @return the pARAM_20
	 */
	public String getPARAM_20() {
		return PARAM_20;
	}

	/**
	 * @param pARAM_20 the pARAM_20 to set
	 */
	public void setPARAM_20(String pARAM_20) {
		PARAM_20 = pARAM_20;
		if( _instance != null ){ ((IISARadiusX)_instance).setParam20( pARAM_20 ); }
	}

}
