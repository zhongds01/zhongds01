package com.ai.sacenter.cboss.valuebean;

import com.ai.sacenter.cboss.bo.ISABrandChg;

/**
 * <p>Title: sacenter-cboss</p>
 * <p>Description: 用户品牌</p>
 * <p>Copyright: Copyright (c) 2018年4月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfgsmBrand extends IOVUpfgsmOrder {
	private static final long serialVersionUID = 2219797103460163321L;
	private long   BRAND	  ;
	private long   OLD_BRAND  ;
	private java.sql.Timestamp COMMIT_DATE;
	private long   DONE_CODE  ;
	private java.sql.Timestamp DONE_DATE  ;
	private String EXT1	      ;
	private String EXT2	      ;
	private String EXT3	      ;
	private String REMARK     ;
	public IOVUpfgsmBrand() throws Exception{
		super();
		_instance = new ISABrandChg();
	}

	public IOVUpfgsmBrand(ISABrandChg instance) throws Exception{
		super(instance);
		BRAND	    = instance.getBrand	    ();
		OLD_BRAND   = instance.getOldBrand  ();
		COMMIT_DATE = instance.getCommitDate();
		DONE_CODE   = instance.getDoneCode  ();
		DONE_DATE   = instance.getDoneDate  ();
		EXT1	    = instance.getExt1	    ();
		EXT2	    = instance.getExt2	    ();
		EXT3	    = instance.getExt3	    ();
		REMARK      = instance.getRemark    ();
	}

	public IOVUpfgsmBrand(IOVUpfgsmBrand provision) throws Exception{
		super( provision );
		BRAND	    = provision.getBRAND      ();   
		OLD_BRAND   = provision.getOLD_BRAND  ();
		COMMIT_DATE = provision.getCOMMIT_DATE();
		DONE_CODE   = provision.getDONE_CODE  ();
		DONE_DATE   = provision.getDONE_DATE  ();
		EXT1	    = provision.getEXT1	      ();
		EXT2	    = provision.getEXT2	      ();
		EXT3	    = provision.getEXT3	      ();
		REMARK      = provision.getREMARK     ();
	}
	
	/**
	 * @return the bRAND
	 */
	public long getBRAND() {
		return BRAND;
	}

	/**
	 * @param bRAND the bRAND to set
	 */
	public void setBRAND(long bRAND) {
		BRAND = bRAND;
		if( _instance != null ){ ((ISABrandChg)_instance).setBrand( (int)bRAND ); }
	}

	/**
	 * @return the oLD_BRAND
	 */
	public long getOLD_BRAND() {
		return OLD_BRAND;
	}

	/**
	 * @param oLD_BRAND the oLD_BRAND to set
	 */
	public void setOLD_BRAND(long oLD_BRAND) {
		OLD_BRAND = oLD_BRAND;
		if( _instance != null ){ ((ISABrandChg)_instance).setOldBrand( (int)oLD_BRAND ); }
	}

	/**
	 * @return the cOMMIT_DATE
	 */
	public java.sql.Timestamp getCOMMIT_DATE() {
		return COMMIT_DATE;
	}

	/**
	 * @param cOMMIT_DATE the cOMMIT_DATE to set
	 */
	public void setCOMMIT_DATE(java.sql.Timestamp cOMMIT_DATE) {
		COMMIT_DATE = cOMMIT_DATE;
		if( _instance != null ){ ((ISABrandChg)_instance).setCommitDate( cOMMIT_DATE ); }
	}

	/**
	 * @return the dONE_CODE
	 */
	public long getDONE_CODE() {
		return DONE_CODE;
	}

	/**
	 * @param dONE_CODE the dONE_CODE to set
	 */
	public void setDONE_CODE(long dONE_CODE) {
		DONE_CODE = dONE_CODE;
		if( _instance != null ){ ((ISABrandChg)_instance).setDoneCode( dONE_CODE ); }
	}

	/**
	 * @return the dONE_DATE
	 */
	public java.sql.Timestamp getDONE_DATE() {
		return DONE_DATE;
	}

	/**
	 * @param dONE_DATE the dONE_DATE to set
	 */
	public void setDONE_DATE(java.sql.Timestamp dONE_DATE) {
		DONE_DATE = dONE_DATE;
		if( _instance != null ){ ((ISABrandChg)_instance).setDoneDate( dONE_DATE ); }
	}

	/**
	 * @return the eXT1
	 */
	public String getEXT1() {
		return EXT1;
	}

	/**
	 * @param eXT1 the eXT1 to set
	 */
	public void setEXT1(String eXT1) {
		EXT1 = eXT1;
		if( _instance != null ){ ((ISABrandChg)_instance).setExt1( eXT1 ); }
	}

	/**
	 * @return the eXT2
	 */
	public String getEXT2() {
		return EXT2;
	}

	/**
	 * @param eXT2 the eXT2 to set
	 */
	public void setEXT2(String eXT2) {
		EXT2 = eXT2;
		if( _instance != null ){ ((ISABrandChg)_instance).setExt2( eXT2 ); }
	}

	/**
	 * @return the eXT3
	 */
	public String getEXT3() {
		return EXT3;
	}

	/**
	 * @param eXT3 the eXT3 to set
	 */
	public void setEXT3(String eXT3) {
		EXT3 = eXT3;
		if( _instance != null ){ ((ISABrandChg)_instance).setExt3( eXT3 ); }
	}

	/**
	 * @return the rEMARK
	 */
	public String getREMARK() {
		return REMARK;
	}

	/**
	 * @param rEMARK the rEMARK to set
	 */
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
		if( _instance != null ){ ((ISABrandChg)_instance).setRemark( rEMARK ); }
	}

	/**
	 * @return the _brandChg
	 */
	public ISABrandChg getOsBrand() {
		return (ISABrandChg)_instance;
	}
}
