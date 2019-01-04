package com.ai.sacenter.comptel.valuebean;

import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;

public class IOVUpfgsmCatalogImpl implements IOVUpfgsmCatalog, java.io.Serializable {
	private static final long serialVersionUID = 6993581833327438918L;
	private String MODULE    = null;
	private Object OBJECTIVE = null;
	private java.util.Map  MAPPINGS = new java.util.HashMap();
	public IOVUpfgsmCatalogImpl() {
		super();
	}
	
	public IOVUpfgsmCatalogImpl( String fromMODULE, Object fromOBJECTIVE ){
		super();
		MODULE    = fromMODULE;
		OBJECTIVE = fromOBJECTIVE; 
	}
	
	/**
	 * @return Ó³Éä¹æ·¶Ä£¿é
	 */
	public String getMODULE() {
		return MODULE;
	}

	/**
	 * @return Ó³Éä¹æ·¶Ä£¿é
	 */
	public Object getOBJECTIVE() {
		return OBJECTIVE;
	}

	/**
	 * @param mODULE Ó³Éä¹æ·¶Ä£¿é
	 */
	public void setMODULE(String mODULE) {
		MODULE = mODULE;
	}

	/**
	 * @return Ó³Éä½á¹û
	 */
	public java.util.Map getMAPPINGS() {
		return MAPPINGS;
	}
}
