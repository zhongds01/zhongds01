package com.ai.sacenter.comptel;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ������Ԫ������ӳ��淶</p>
 * <p>Copyright: Copyright (c) 2015��10��13��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgsmSystem {
	/**
	 * ���񼤻����ӳ��淶
	 * @param fromUpfgsm ӳ��淶
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfgsmc( ISystemTemplate.IUpfgsmxOffer fromUpfgsm ,
			java.util.Map fromOffer ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������Ԫ������ӳ��淶
	 * @param fromUpfgsm ӳ��淶
	 * @param fromOffer ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfgsmc( IPlatformTemplate.IUpffgsmOffer fromUpfgsm,
			java.util.Map fromOffer ,
			IUpdcContext aContext ) throws SFException,Exception;
}
