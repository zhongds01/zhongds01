package com.ai.sacenter.net;

import com.ai.sacenter.util.ByteBuffer;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

public class TimeIORequest implements java.io.Serializable{
	private static final long serialVersionUID = -7555130741497730426L;
	private long   psId         ;
	private String psNetCode    ;
	private String psServiceType;
	private long   actionId     ;
	private String billId       ;
	private String regionId     ;
	private String doneCode     ;
	private String psParam      ;
	public TimeIORequest() {
		super();
	}
	/**
	 * @return the psId
	 */
	public long getPsId() {
		return psId;
	}
	/**
	 * @param psId the psId to set
	 */
	public void setPsId(long psId) {
		this.psId = psId;
	}
	/**
	 * @return the psNetCode
	 */
	public String getPsNetCode() {
		return psNetCode;
	}
	/**
	 * @param psNetCode the psNetCode to set
	 */
	public void setPsNetCode(String psNetCode) {
		this.psNetCode = psNetCode;
	}
	/**
	 * @return the psServiceType
	 */
	public String getPsServiceType() {
		return psServiceType;
	}
	/**
	 * @param psServiceType the psServiceType to set
	 */
	public void setPsServiceType(String psServiceType) {
		this.psServiceType = psServiceType;
	}
	/**
	 * @return the actionId
	 */
	public long getActionId() {
		return actionId;
	}
	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(long actionId) {
		this.actionId = actionId;
	}
	/**
	 * @return the billId
	 */
	public String getBillId() {
		return billId;
	}
	/**
	 * @param billId the billId to set
	 */
	public void setBillId(String billId) {
		this.billId = billId;
	}
	/**
	 * @return the regionId
	 */
	public String getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	/**
	 * @return the doneCode
	 */
	public String getDoneCode() {
		return doneCode;
	}
	/**
	 * @param doneCode the doneCode to set
	 */
	public void setDoneCode(String doneCode) {
		this.doneCode = doneCode;
	}
	/**
	 * @return the psParam
	 */
	public String getPsParam() {
		return psParam;
	}
	/**
	 * @param psParam the psParam to set
	 */
	public void setPsParam(String psParam) {
		this.psParam = psParam;
	}
	/**
	 * 
	 * @return
	 */
	public byte[] toByteArray(){
		ByteBuffer fromBytes = null;
		try
		{
			int fromBodyL = psParam.getBytes().length;
			fromBytes = new ByteBuffer( 4 + 4 + 182 + fromBodyL );
			fromBytes.append( "AISC" );
			fromBytes.append( fromBodyL );
			fromBytes.append( StringUtils.trimLeft( psNetCode != null?psNetCode:""        , 20, ' ' ) );
			fromBytes.append( StringUtils.trimLeft( String.valueOf( psId )                , 16, ' ' ) );
			fromBytes.append( StringUtils.trimLeft( String.valueOf( actionId )            , 10, ' ' ) );
			fromBytes.append( StringUtils.trimLeft( psServiceType != null?psServiceType:"", 32, ' ' ) );
			fromBytes.append( StringUtils.trimLeft( billId != null?billId:""              , 32, ' ' ) );
			fromBytes.append( StringUtils.trimLeft( regionId != null?regionId:""          ,  8, ' ' ) );
			fromBytes.append( StringUtils.trimLeft( doneCode != null?doneCode:""          , 64, ' ' ) );
			fromBytes.append( psParam );
		}
		finally{
			
		}
		return fromBytes != null ?fromBytes.toByteArray():null;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String fromXML = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		try
		{
			fromPARAM.put("PS_ID"          , String.valueOf( psId )  );
			fromPARAM.put("DONE_CODE"      , doneCode                );
			fromPARAM.put("BILL_ID"        , billId                  );
			fromPARAM.put("REGION_ID"      , regionId                );
			fromPARAM.put("PS_SERVICE_TYPE", psServiceType           );
			fromPARAM.put("ACTION_ID"      , String.valueOf(actionId));
			fromPARAM.put("PS_PARAM"       , psParam                 );
			fromPARAM.put("PS_NET_CODE"    , psNetCode               );
			fromXML = XmlUtils.createNoformatXml( "InterBOSS", 
					fromPARAM );
		}
		catch( java.lang.Exception aEXCEPTION ){
			
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromXML;
	}
}
