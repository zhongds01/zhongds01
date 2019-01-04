package com.ai.sacenter.comptel.valuebean;

import com.ai.sacenter.comptel.bo.IOVUpdcpCatalog;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdcpCatalogImpl implements IOVUpdcpCatalog, java.io.Serializable {
	private static final long serialVersionUID = 3860073779396882862L;
	private String         MODULE ;
	private IProductOffer  COMPETE;
	private java.util.Map  COMPLEX = new java.util.HashMap();
	private java.util.List CATALOG = new java.util.ArrayList();
	public IOVUpdcpCatalogImpl() {
		super();
	}
	
	public IOVUpdcpCatalogImpl( String fromMODULE, 
			IProductOffer fromCOMPETE ){
		super();
		MODULE  = fromMODULE;
		COMPETE = fromCOMPETE;
	}
	
	/**
	 * @return 服务能力操作
	 */
	public String getMODULE() {
		return MODULE;
	}
	
	/**
	 * @param mODULE 服务能力操作
	 */
	public void setMODULE(String mODULE) {
		MODULE = mODULE;
	}
	
	/**
	 * @return 服务能力规范 
	 */
	public IProductOffer getCOMPETE() {
		return COMPETE;
	}
	
	/**
	 * @param cOMPETE 服务能力规范 
	 */
	public void setCOMPETE(IProductOffer cOMPETE) {
		COMPETE = cOMPETE;
	}
	
	/**
	 * @return 全局服务属性
	 */
	public java.util.Map getCOMPLEX() {
		return COMPLEX;
	}

	/**
	 * @return 服务能力订购
	 */
	public java.util.List getCATALOG() {
		return CATALOG;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.bo.IOVUpdcpCatalog#getCOMPETENCE()
	 */
	public IOVUpdcpOffer[] getCOMPETENCE() {
		return (IOVUpdcpOffer[])CATALOG.toArray( new IOVUpdcpOffer[]{} );
	}
	
}
