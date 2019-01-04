package com.ai.sacenter.center;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ����ת����</p>
 * <p>Copyright: Copyright (c) 2012-4-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ICenterWrapper {
	/**
	 * ��������ת���淶
	 * @param fromCENTER ��������ֵ
	 * @param fromCatalog �������Ĺ淶
	 * @param fromLDAP
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public SFCenterOffer wrapper(Object fromCENTER, 
			SFCenterCatalog fromCatalog,
			IUpdcContext fromLDAP) throws SFException,Exception;
}
