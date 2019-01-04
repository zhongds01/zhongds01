package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IUpfgsmTemplate;
import com.ai.sacenter.valuebean.IUpfgsmTemplate.IUpfgsmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 针对网元MISC映射</p>
 * <p>Copyright: Copyright (c) 2015-5-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgsmSRV {
	/**
	 * 根据网元工单查询网元属性扩展规范
	 * @param fromUpfwm 网元工单
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgsmTemplate.IUpfgsmOffer getSFUpfgsmMisc( IOVUpfwmOffer fromUpfwm, 
				IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据网元属性扩展规范生成网元属性开通串
	 * @param fromUpfwm 网元工单
	 * @param fromUpfgsm 网元属性规范
	 * @param fromUpfgsmx 网元属性扩展规范
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfgsmMisc(IOVUpfwmOffer fromUpfwm,
				IUpfgsmOffer fromUpfgsm,
				IUpfgsmTemplate.IUpfgsmxOffer fromUpfgsmx,
				IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据网元工单完成网元属性扩展转换
	 * @param fromUpfwm 网元工单
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap finishSFUpfgsmMisc( IOVUpfwmOffer fromUpfwm,
				IUpdcContext aContext ) throws SFException,Exception;
}
