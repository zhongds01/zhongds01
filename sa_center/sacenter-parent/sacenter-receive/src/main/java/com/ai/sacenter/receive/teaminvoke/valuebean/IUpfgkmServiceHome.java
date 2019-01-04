package com.ai.sacenter.receive.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年5月2日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmServiceHome implements java.io.Serializable{
	private static final long serialVersionUID = 4806023643758366505L;
	/*服务编号*/
	private long SERVICE_ID ;
	/*产品编号*/
	private long PRODUCT_ID ;
	/*产品关联*/
	private IUpfgkmRelatHome _offer = null;
	public IUpfgkmServiceHome( long pRODUCT_ID ) {
		super();
		PRODUCT_ID = pRODUCT_ID;
	}
	
	/**
	 * @return 服务编号
	 */
	public long getSERVICE_ID() {
		return SERVICE_ID;
	}

	/**
	 * @param sERVICE_ID 服务编号
	 */
	public void setSERVICE_ID(long sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
	}

	/**
	 * @param pRODUCT_ID 产品编号
	 */
	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	/**
	 * @return 产品编号
	 */
	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	/**
	 * @return 产品服务
	 */
	public IUpfgkmRelatHome getOFFER() {
		return _offer;
	}

	/**
	 * @param offer 产品服务
	 */
	public void setOFFER(IUpfgkmRelatHome offer) {
		_offer = offer;
	}
}
