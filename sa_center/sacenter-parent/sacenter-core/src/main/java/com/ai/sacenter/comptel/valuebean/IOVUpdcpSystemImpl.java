package com.ai.sacenter.comptel.valuebean;

import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;
import com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdcpSystemImpl implements IOVUpdcpOffer {
	protected long   _compete ;
	protected long   _product ;
	protected String _comptel ;
	protected IUpfgsmOffer  _catalog;
	protected IProductOffer _provider;
	protected java.util.Map _complex = new java.util.HashMap();
	public IOVUpdcpSystemImpl() {
		super();
	}
	
	public IOVUpdcpSystemImpl( long fromCOMPETE, 
			long fromPRODUCT,
			IUpfgsmOffer fromCATALOG,
			IProductOffer fromPROVIDER){
		super();
		_compete  = fromCOMPETE ;
		_product  = fromPRODUCT ;
		_catalog  = fromCATALOG ;
		_provider = fromPROVIDER;
	}
	
	/**
	 * @return 服务能力编号
	 */
	public long getCOMPETE() {
		return _compete;
	}
	
	/**
	 * @param cOMPETE 服务能力编号
	 */
	public void setCOMPETE(long cOMPETE) {
		_compete = cOMPETE;
	}
	
	/**
	 * @return 服务产品编号
	 */
	public long getPRODUCT() {
		return _product;
	}
	
	/**
	 * @param pRODUCT 服务产品编号
	 */
	public void setPRODUCT(long pRODUCT) {
		_product = pRODUCT;
	}
	
	/**
	 * @return 服务属性值
	 */
	public String getCOMPTEL() {
		return _comptel;
	}
	
	/**
	 * @param cOMPTEL 服务属性值
	 */
	public void setCOMPTEL(String cOMPTEL) {
		_comptel = cOMPTEL;
	}
	
	/**
	 * 服务流程编码
	 */
	public String getSUBFLOW() {
		return null;
	}

	/**
	 * @return 服务映射规范
	 */
	public IUpfgsmOffer getCATALOG() {
		return _catalog;
	}
	
	/**
	 * @param cATALOG 服务映射规范
	 */
	public void setCATALOG(IUpfgsmOffer cATALOG) {
		_catalog = cATALOG;
	}
	
	/**
	 * @return 服务产品
	 */
	public IProductOffer getPROVIDER() {
		return _provider;
	}

	/**
	 * @param pROVIDER 服务产品
	 */
	public void setPROVIDER(IProductOffer pROVIDER) {
		_provider = pROVIDER;
	}

	/**
	 * @return 服务能力属性
	 */
	public java.util.Map getCOMPLEX() {
		return _complex;
	}
}
