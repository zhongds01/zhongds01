package com.ai.sacenter.receive.expire.valuebean;

import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.expire.bo.ISAExpireSp;
import com.ai.sacenter.receive.expire.bo.SAExpireSp;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JSONUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;

public class IOVExpireOffer implements java.io.Serializable{
	private static final long serialVersionUID = -7682282525219000694L;
	private long   OFFER_ID     ;
	private long   ORDER_ID     ;
	private String CUST_ORDER   ;
	private String DONE_CODE    ;
	private long   USER_ID      ;
	private java.sql.Timestamp CREATE_DATE;
	private String REGION_ID    ;
	private long   INS_PROD_ID  ;
	private long   SERVICE_ID   ;
	private long   PRODUCT_ID   ;
	private String PROD_TYPE    ;
	private String STATUS       ;
	private String PARAM_01     ;
	private String PARAM_02     ;
	private String PARAM_03     ;
	private String PARAM_04     ;
	private String PARAM_05     ;
	private String STATE        ;
	private java.sql.Timestamp COMPLETE_DATE;
	private CarbonList<IOVExpireOfferX> ORDER = new CarbonList<IOVExpireOfferX>();
	private ISAExpireSp INSTANCE;
	public IOVExpireOffer() throws Exception {
		super();
		INSTANCE=new SAExpireSp();
	}

	public IOVExpireOffer(ISAExpireSp aExpire) throws Exception {
		super();
		_readfrombottle( aExpire );
		INSTANCE = aExpire        ;
	}

	public IOVExpireOffer(IOVExpireOffer expire) throws Exception {
		super();
		INSTANCE = (ISAExpireSp)OracleUtils.ISystem.transfer( expire.INSTANCE );
		_readfrombottle( INSTANCE );
	}
	
	/**
	 * 
	 * @param aExpire
	 * @throws Exception
	 */
	private void _readfrombottle( ISAExpireSp aExpire ) throws Exception{
		OFFER_ID      = aExpire.getOfferId     (); 
		ORDER_ID      = aExpire.getOrderId     ();
		CUST_ORDER    = aExpire.getCustOrder   ();
		DONE_CODE     = aExpire.getDoneCode    ();
		USER_ID       = aExpire.getUserId      ();
		CREATE_DATE   = aExpire.getCreateDate  ();
		REGION_ID     = aExpire.getRegionId    ();
		INS_PROD_ID   = aExpire.getInsProdId   ();
		SERVICE_ID    = aExpire.getServiceId   ();
		PRODUCT_ID    = aExpire.getProductId   ();
		PROD_TYPE     = aExpire.getProdType    ();
		STATUS        = aExpire.getStatus      (); 
		PARAM_01      = aExpire.getParam01     ();
		PARAM_02      = aExpire.getParam02     ();
		PARAM_03      = aExpire.getParam03     ();
		PARAM_04      = aExpire.getParam04     ();
		PARAM_05      = aExpire.getParam05     ();
		STATE         = aExpire.getState       (); 
		COMPLETE_DATE = aExpire.getCompleteDate();
		String fromPARAM = _readfromparam( aExpire );
		if( StringUtils.isBlank( fromPARAM ) == false ){
			if( StringUtils.isBlank( fromPARAM.toString() ) == false ){
				java.util.List<IOVExpireOfferX> _order = JSONUtils.fromList( fromPARAM.toString(), IOVExpireOfferX.class );
				if( _order != null && _order.size() > 0 ){ ClassUtils.IMerge.merge( _order, ORDER ); }
			}
		}
	}
	
	/**
	 * 
	 * @param aExpire
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String _readfromparam( ISAExpireSp aExpire ) throws Exception{
		StringBuilder fromPARAM = new StringBuilder();
		try
		{
			for( int index = 0 ; index < 5; index++ ){
				String aCOMPLEX = ClassUtils.getINDEX( new String[]{"PARAM_",index < 9 ?
						"0":"",String.valueOf( index + 1 ) } );
				aCOMPLEX = (String)aExpire.get( aCOMPLEX );
				if( StringUtils.isBlank( aCOMPLEX ) ) continue;
				fromPARAM.append( aCOMPLEX );
			}
		}
		finally{
		
		}
		return fromPARAM.toString();
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
		if(INSTANCE!=null)
		INSTANCE.setOfferId(oFFER_ID);
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
		if(INSTANCE!=null)
		INSTANCE.setOrderId(oRDER_ID);
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
		if(INSTANCE!=null)
		INSTANCE.setCustOrder(cUST_ORDER);
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
		if(INSTANCE!=null)
		INSTANCE.setDoneCode(dONE_CODE);
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
		if(INSTANCE!=null)
		INSTANCE.setUserId(uSER_ID);
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
		if(INSTANCE!=null)
		INSTANCE.setCreateDate(cREATE_DATE);
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
		if(INSTANCE!=null)
		INSTANCE.setRegionId(rEGION_ID);
	}
	
	/**
	 * @return the iNS_PROD_ID
	 */
	public long getINS_PROD_ID() {
		return INS_PROD_ID;
	}
	
	/**
	 * @param iNS_PROD_ID the iNS_PROD_ID to set
	 */
	public void setINS_PROD_ID(long iNS_PROD_ID) {
		INS_PROD_ID = iNS_PROD_ID;
		if(INSTANCE!=null)
		INSTANCE.setInsProdId(iNS_PROD_ID);
	}
	
	/**
	 * @return the sERVICE_ID
	 */
	public long getSERVICE_ID() {
		return SERVICE_ID;
	}
	
	/**
	 * @param sERVICE_ID the sERVICE_ID to set
	 */
	public void setSERVICE_ID(long sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
		if(INSTANCE!=null)
		INSTANCE.setServiceId(sERVICE_ID);
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
		if(INSTANCE!=null)
		INSTANCE.setProductId(pRODUCT_ID);
	}
	
	/**
	 * @return the pROD_TYPE
	 */
	public String getPROD_TYPE() {
		return PROD_TYPE;
	}

	/**
	 * @param pROD_TYPE the pROD_TYPE to set
	 */
	public void setPROD_TYPE(String pROD_TYPE) {
		PROD_TYPE = pROD_TYPE;
		if(INSTANCE!=null)
		INSTANCE.setProdType( pROD_TYPE );
	}

	/**
	 * @return the sTATUS
	 */
	public String getSTATUS() {
		return STATUS;
	}
	
	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
		if(INSTANCE!=null)
		INSTANCE.setStatus(sTATUS);
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
		if(INSTANCE!=null)
		INSTANCE.setState(sTATE);
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
		if(INSTANCE!=null)
		INSTANCE.setCompleteDate(cOMPLETE_DATE);
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
		if(INSTANCE!=null)
		INSTANCE.setParam01(pARAM_01);
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
		if(INSTANCE!=null)
		INSTANCE.setParam02(pARAM_02);
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
		if(INSTANCE!=null)
		INSTANCE.setParam03(pARAM_03);
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
		if(INSTANCE!=null)
		INSTANCE.setParam04(pARAM_04);
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
		if(INSTANCE!=null)
		INSTANCE.setParam05(pARAM_05);
	}
	
	/**
	 * @return the oRDER
	 */
	public CarbonList<IOVExpireOfferX> getORDER() {
		return ORDER;
	}

	/**
	 * @param oRDER the oRDER to set
	 */
	public void setORDER(CarbonList<IOVExpireOfferX> oRDER) {
		ORDER = oRDER;
	}

	/**
	 * @return the iNSTANCE
	 */
	public ISAExpireSp getINSTANCE() {
		return INSTANCE;
	}
	
	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public void setINSTANCE(SAExpireSp iNSTANCE) {
		INSTANCE = iNSTANCE;
	}
}
