package com.ai.sacenter.comptel;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务网元级属性映射规范</p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgsmSystem {
	/**
	 * 服务激活级属性映射规范
	 * @param fromUpfgsm 映射规范
	 * @param fromOffer 激活能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfgsmc( ISystemTemplate.IUpfgsmxOffer fromUpfgsm ,
			java.util.Map fromOffer ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 服务网元级属性映射规范
	 * @param fromUpfgsm 映射规范
	 * @param fromOffer 激活能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfgsmc( IPlatformTemplate.IUpffgsmOffer fromUpfgsm,
			java.util.Map fromOffer ,
			IUpdcContext aContext ) throws SFException,Exception;
}
