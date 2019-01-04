package com.ai.sacenter.comptel.bo;

import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务能力订购集</p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IOVUpdcpCatalog {
	/**
	 * 服务能力操作
	 * @return
	 */
	public String getMODULE();
	/**
	 * 服务能力规范 
	 * @return
	 */
	public IProductOffer  getCOMPETE();
	/**
	 * 全局服务属性
	 * @return
	 */
	public java.util.Map  getCOMPLEX();
	/**
	 * 服务能力订购
	 * @return
	 */
	public java.util.List getCATALOG();
	/**
	 * 服务能力订购
	 * @return
	 */
	public IOVUpdcpOffer[] getCOMPETENCE();
}
