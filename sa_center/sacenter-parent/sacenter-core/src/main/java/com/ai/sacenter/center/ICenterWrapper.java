package com.ai.sacenter.center;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 中心转换类</p>
 * <p>Copyright: Copyright (c) 2012-4-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ICenterWrapper {
	/**
	 * 服务中心转换规范
	 * @param fromCENTER 服务中心值
	 * @param fromCatalog 服务中心规范
	 * @param fromLDAP
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public SFCenterOffer wrapper(Object fromCENTER, 
			SFCenterCatalog fromCatalog,
			IUpdcContext fromLDAP) throws SFException,Exception;
}
