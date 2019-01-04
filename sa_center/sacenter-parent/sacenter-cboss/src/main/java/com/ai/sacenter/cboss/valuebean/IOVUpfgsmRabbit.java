package com.ai.sacenter.cboss.valuebean;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.cboss.bo.IISAMcasIndex;
import com.ai.sacenter.cboss.bo.IISARadiusIndex;
import com.ai.sacenter.util.JdomUtils;

public class IOVUpfgsmRabbit extends IOVUpfgsmOrder {
	private static final long serialVersionUID = 1449137639550398282L;
	protected long   MSO_NBR	   ;
	protected long   BUSI_TYPE     ;
	protected String ACT_TYPE      ;
	protected String PS_PARAM      ;
	protected String OLD_BILL_ID   ;
	protected long   BRAND	       ;
	protected String COMPOSITE     ;
	protected java.sql.Timestamp COMMIT_DATE   ;
	protected java.sql.Timestamp PROCESS_DATE  ;
	protected long   SRC	       ;
	protected long   CALLBACK_FLAG ;
	protected long   ORDER_FLAG    ;
	protected String PKG_SEQ	   ;
	protected String SINGLE_SEQ    ;
	protected long   RECONFIRM_FLAG;
	protected String RECONFIRM_CODE;
	protected String RESULT	       ;
	protected String RESULT_DESC   ;
	protected String REMARK	       ;
	public IOVUpfgsmRabbit() {
		super();
	}

	public IOVUpfgsmRabbit(DataStructInterface instance) throws Exception {
		super(instance);
	    if( instance instanceof IISARadiusIndex ){
	    	IISARadiusIndex __instance = (IISARadiusIndex)instance;
	    	MSO_NBR	       = __instance.getMsoNbr	    ();
	    	BUSI_TYPE      = __instance.getBusiType     ();
	    	ACT_TYPE       = __instance.getActType      ();
	    	PS_PARAM       = __instance.getPsParam      ();
	    	OLD_BILL_ID    = __instance.getOldBillId    ();
	    	BRAND	       = __instance.getBrand	    ();
	    	COMPOSITE      = __instance.getComposite    ();
	    	COMMIT_DATE    = __instance.getCommitDate   ();
	    	PROCESS_DATE   = __instance.getProcessDate  ();
	    	SRC	           = __instance.getSrc	        ();
	    	CALLBACK_FLAG  = __instance.getCallbackFlag ();
	    	ORDER_FLAG     = __instance.getOrderFlag    ();
	    	PKG_SEQ	       = __instance.getPkgSeq	    ();
	    	SINGLE_SEQ     = __instance.getSingleSeq    ();
	    	RECONFIRM_FLAG = __instance.getReconfirmFlag();
	    	RECONFIRM_CODE = __instance.getReconfirmCode();
	    	RESULT	       = __instance.getResult	    ();
	    	RESULT_DESC    = __instance.getResultDesc   ();
	    	REMARK	       = __instance.getRemark	    ();
			JdomUtils.ICustom.wrap( __instance.getPsParam(), _little.getSUBFLOW() );
	    }
	    else if( instance instanceof IISAMcasIndex ){
	    	IISAMcasIndex __instance = (IISAMcasIndex)instance;
	    	MSO_NBR	       = __instance.getMsoNbr	    ();
	    	BUSI_TYPE      = __instance.getBusiType     ();
	    	ACT_TYPE       = __instance.getActType      ();
	    	PS_PARAM       = __instance.getPsParam      ();
	    	OLD_BILL_ID    = __instance.getOldBillId    ();
	    	BRAND	       = __instance.getBrand	    ();
	    	COMPOSITE      = __instance.getComposite    ();
	    	COMMIT_DATE    = __instance.getCommitDate   ();
	    	PROCESS_DATE   = __instance.getProcessDate  ();
	    	SRC	           = __instance.getSrc	        ();
	    	CALLBACK_FLAG  = __instance.getCallbackFlag ();
	    	ORDER_FLAG     = __instance.getOrderFlag    ();
	    	PKG_SEQ	       = __instance.getPkgSeq	    ();
	    	SINGLE_SEQ     = __instance.getSingleSeq    ();
	    	RECONFIRM_FLAG = __instance.getReconfirmFlag();
	    	RECONFIRM_CODE = __instance.getReconfirmCode();
	    	RESULT	       = __instance.getResult	    ();
	    	RESULT_DESC    = __instance.getResultDesc   ();
	    	REMARK	       = __instance.getRemark	    ();
			JdomUtils.ICustom.wrap( __instance.getPsParam(), _little.getSUBFLOW() );
	    }
	    else{
	    	throw new java.lang.UnsupportedOperationException( instance.getClass().getName() );
	    }
	}

	public IOVUpfgsmRabbit(IOVUpfgsmRabbit provision) throws Exception{
		super( provision );
		MSO_NBR	       = provision.getMSO_NBR	     ();
		BUSI_TYPE      = provision.getBUSI_TYPE      ();
		ACT_TYPE       = provision.getACT_TYPE       ();
		PS_PARAM       = provision.getPS_PARAM       ();
		OLD_BILL_ID    = provision.getOLD_BILL_ID    ();
		BRAND	       = provision.getBRAND	         ();
		COMPOSITE      = provision.getCOMPOSITE      ();
		COMMIT_DATE    = provision.getCOMMIT_DATE    ();
		PROCESS_DATE   = provision.getPROCESS_DATE   ();
		SRC	           = provision.getSRC	         ();
		CALLBACK_FLAG  = provision.getCALLBACK_FLAG  ();
		ORDER_FLAG     = provision.getORDER_FLAG     ();
		PKG_SEQ	       = provision.getPKG_SEQ	     ();
		SINGLE_SEQ     = provision.getSINGLE_SEQ     ();
		RECONFIRM_FLAG = provision.getRECONFIRM_FLAG ();
		RECONFIRM_CODE = provision.getRECONFIRM_CODE ();
		RESULT	       = provision.getRESULT	     ();
		RESULT_DESC    = provision.getRESULT_DESC    ();
		REMARK	       = provision.getREMARK	     ();
	}
	
	/**
	 * @return the mSO_NBR
	 */
	public long getMSO_NBR() {
		return MSO_NBR;
	}

	/**
	 * 
	 * @param mSO_NBR
	 * @throws Exception
	 */
	public void setMSO_NBR(long mSO_NBR) throws Exception{
		MSO_NBR = mSO_NBR;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setMsoNbr( mSO_NBR );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setMsoNbr( mSO_NBR );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_MsoNbr, new Long( mSO_NBR ) );
		}
	}

	/**
	 * @return the bUSI_TYPE
	 */
	public long getBUSI_TYPE() {
		return BUSI_TYPE;
	}

	/**
	 * 
	 * @param bUSI_TYPE
	 * @throws Exception
	 */
	public void setBUSI_TYPE(long bUSI_TYPE) throws Exception{
		BUSI_TYPE = bUSI_TYPE;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setBusiType( (int)bUSI_TYPE );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setBusiType( (int)bUSI_TYPE );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_BusiType, new Integer( (int)bUSI_TYPE ) );
		}
	}

	/**
	 * @return the aCT_TYPE
	 */
	public String getACT_TYPE() {
		return ACT_TYPE;
	}

	/**
	 * 
	 * @param aCT_TYPE
	 * @throws Exception
	 */
	public void setACT_TYPE(String aCT_TYPE) throws Exception{
		ACT_TYPE = aCT_TYPE;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setActType( aCT_TYPE );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setActType( aCT_TYPE );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_ActType, aCT_TYPE );
		}
	}

	/**
	 * @return the pS_PARAM
	 */
	public String getPS_PARAM() {
		return PS_PARAM;
	}

	/**
	 * 
	 * @param pS_PARAM
	 * @throws Exception
	 */
	public void setPS_PARAM(String pS_PARAM) throws Exception{
		PS_PARAM = pS_PARAM;
		JdomUtils.ICustom.wrap( pS_PARAM, _little.getSUBFLOW() );
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setPsParam( pS_PARAM );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setPsParam( pS_PARAM );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_PsParam, pS_PARAM );
		}
	}

	/**
	 * @return the oLD_BILL_ID
	 */
	public String getOLD_BILL_ID() {
		return OLD_BILL_ID;
	}

	/**
	 * 
	 * @param oLD_BILL_ID
	 * @throws Exception
	 */
	public void setOLD_BILL_ID(String oLD_BILL_ID) throws Exception{
		OLD_BILL_ID = oLD_BILL_ID;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setOldBillId( oLD_BILL_ID );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setOldBillId( oLD_BILL_ID );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_OldBillId, oLD_BILL_ID );
		}
	}

	/**
	 * @return the bRAND
	 */
	public long getBRAND() {
		return BRAND;
	}

	/**
	 * 
	 * @param bRAND
	 * @throws Exception
	 */
	public void setBRAND(long bRAND) throws Exception{
		BRAND = bRAND;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setBrand( (int)bRAND );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setBrand( (int)bRAND );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_Brand, new Integer( (int)bRAND ) );
		}
	}

	/**
	 * @return the cOMPOSITE
	 */
	public String getCOMPOSITE() {
		return COMPOSITE;
	}

	/**
	 * 
	 * @param cOMPOSITE
	 * @throws Exception
	 */
	public void setCOMPOSITE(String cOMPOSITE) throws Exception{
		COMPOSITE = cOMPOSITE;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setComposite( cOMPOSITE );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setComposite( cOMPOSITE );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_Composite, cOMPOSITE );
		}
	}

	/**
	 * @return the cOMMIT_DATE
	 */
	public java.sql.Timestamp getCOMMIT_DATE() {
		return COMMIT_DATE;
	}

	/**
	 * 
	 * @param cOMMIT_DATE
	 * @throws Exception
	 */
	public void setCOMMIT_DATE(java.sql.Timestamp cOMMIT_DATE) throws Exception {
		COMMIT_DATE = cOMMIT_DATE;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setCommitDate( cOMMIT_DATE );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setCommitDate( cOMMIT_DATE );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_CommitDate, cOMMIT_DATE );
		}
	}

	/**
	 * @return the pROCESS_DATE
	 */
	public java.sql.Timestamp getPROCESS_DATE() {
		return PROCESS_DATE;
	}

	/**
	 * 
	 * @param pROCESS_DATE
	 * @throws Exception
	 */
	public void setPROCESS_DATE(java.sql.Timestamp pROCESS_DATE) throws Exception{
		PROCESS_DATE = pROCESS_DATE;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setProcessDate( pROCESS_DATE );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setProcessDate( pROCESS_DATE );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_ProcessDate, pROCESS_DATE );
		}
	}

	/**
	 * @return the sRC
	 */
	public long getSRC() {
		return SRC;
	}

	/**
	 * 
	 * @param sRC
	 * @throws Exception
	 */
	public void setSRC(long sRC) throws Exception{
		SRC = sRC;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setSrc( (int)sRC );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setSrc( (int)sRC );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_Src, new Integer( (int)sRC ) );
		}
	}

	/**
	 * @return the cALLBACK_FLAG
	 */
	public long getCALLBACK_FLAG() {
		return CALLBACK_FLAG;
	}

	/**
	 * 
	 * @param cALLBACK_FLAG
	 * @throws Exception
	 */
	public void setCALLBACK_FLAG(long cALLBACK_FLAG) throws Exception{
		CALLBACK_FLAG = cALLBACK_FLAG;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setCallbackFlag( (int)cALLBACK_FLAG );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setCallbackFlag( (int)cALLBACK_FLAG );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_CallbackFlag, new Integer( (int)cALLBACK_FLAG ) );
		}
	}

	/**
	 * @return the oRDER_FLAG
	 */
	public long getORDER_FLAG() {
		return ORDER_FLAG;
	}

	/**
	 * 
	 * @param oRDER_FLAG
	 * @throws Exception
	 */
	public void setORDER_FLAG(long oRDER_FLAG) throws Exception{
		ORDER_FLAG = oRDER_FLAG;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setOrderFlag( (int)oRDER_FLAG );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setOrderFlag( (int)oRDER_FLAG );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_OrderFlag, new Integer( (int)oRDER_FLAG ) );
		}
	}
	
	/**
	 * @return the pKG_SEQ
	 */
	public String getPKG_SEQ() {
		return PKG_SEQ;
	}

	/**
	 * 
	 * @param pKG_SEQ
	 * @throws Exception
	 */
	public void setPKG_SEQ(String pKG_SEQ) throws Exception{
		PKG_SEQ = pKG_SEQ;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setPkgSeq( pKG_SEQ );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setPkgSeq( pKG_SEQ );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_PkgSeq, pKG_SEQ );
		}
	}

	/**
	 * @return the sINGLE_SEQ
	 */
	public String getSINGLE_SEQ() {
		return SINGLE_SEQ;
	}

	/**
	 * 
	 * @param sINGLE_SEQ
	 * @throws Exception
	 */
	public void setSINGLE_SEQ(String sINGLE_SEQ) throws Exception{
		SINGLE_SEQ = sINGLE_SEQ;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setSingleSeq( sINGLE_SEQ );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setSingleSeq( sINGLE_SEQ );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_SingleSeq, sINGLE_SEQ );
		}
	}
	
	/**
	 * @return the rECONFIRM_FLAG
	 */
	public long getRECONFIRM_FLAG() {
		return RECONFIRM_FLAG;
	}

	/**
	 * 
	 * @param rECONFIRM_FLAG
	 * @throws Exception
	 */
	public void setRECONFIRM_FLAG(long rECONFIRM_FLAG) throws Exception{
		RECONFIRM_FLAG = rECONFIRM_FLAG;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setReconfirmFlag( (int)rECONFIRM_FLAG );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setReconfirmFlag( (int)rECONFIRM_FLAG );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_ReconfirmFlag, new Integer( (int)rECONFIRM_FLAG ) );
		}
	}

	/**
	 * @return the rECONFIRM_CODE
	 */
	public String getRECONFIRM_CODE() {
		return RECONFIRM_CODE;
	}

	/**
	 * 
	 * @param rECONFIRM_CODE
	 * @throws Exception
	 */
	public void setRECONFIRM_CODE(String rECONFIRM_CODE) throws Exception{
		RECONFIRM_CODE = rECONFIRM_CODE;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setReconfirmCode( rECONFIRM_CODE );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setReconfirmCode( rECONFIRM_CODE );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_ReconfirmCode, rECONFIRM_CODE );
		}
	}

	/**
	 * @return the rESULT
	 */
	public String getRESULT() {
		return RESULT;
	}

	/**
	 * 
	 * @param rESULT
	 * @throws Exception
	 */
	public void setRESULT(String rESULT) throws Exception{
		RESULT = rESULT;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setResult( rESULT );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setResult( rESULT );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_Result, rESULT );
		}
	}

	/**
	 * @return the rESULT_DESC
	 */
	public String getRESULT_DESC() {
		return RESULT_DESC;
	}

	/**
	 * 
	 * @param rESULT_DESC
	 * @throws Exception
	 */
	public void setRESULT_DESC(String rESULT_DESC) throws Exception {
		RESULT_DESC = rESULT_DESC;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setResultDesc( rESULT_DESC );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setResultDesc( rESULT_DESC );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_ResultDesc, rESULT_DESC );
		}
	}

	/**
	 * @return the rEMARK
	 */
	public String getREMARK() {
		return REMARK;
	}

	/**
	 * 
	 * @param rEMARK
	 * @throws Exception
	 */
	public void setREMARK(String rEMARK) throws Exception{
		REMARK = rEMARK;
		if( _instance != null && _instance instanceof IISARadiusIndex ){
			((IISARadiusIndex)_instance).setRemark( rEMARK );
		}
		else if( _instance != null && _instance instanceof IISAMcasIndex ){
			((IISAMcasIndex)_instance).setRemark( rEMARK );
		}
		else if( _instance != null ){
			_instance.set( IISARadiusIndex.S_Remark, rEMARK );
		}
	}
}
