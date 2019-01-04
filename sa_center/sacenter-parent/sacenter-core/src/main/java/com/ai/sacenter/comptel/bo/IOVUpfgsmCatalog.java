package com.ai.sacenter.comptel.bo;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: 服务网元映射集</p>
 * <p>Copyright: Copyright (c) 2015年11月6日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public interface IOVUpfgsmCatalog {
	/***
	 * 映射规范编码
	 * @return
	 */
	public String getMODULE();
	/**
	 * 映射规范模块
	 * @return
	 */
	public Object getOBJECTIVE();
	/***
	 * 映射结果
	 * @return 
	 */
	public java.util.Map getMAPPINGS();
}
