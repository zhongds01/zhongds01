package com.ai.sacenter.core;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbpmOffer;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年11月4日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdbpmCapital {
	/***
     * 根据服务开通工单拆分服务网元任务单
     * @param fromOrder 服务定单
     * @param fromOffer 服务定单订购
     * @param fromUpdbm 服务流程
     * @param fromUpdcpm 服务流程属性
     * @param aContext
     * @return
     * @throws SFException
     * @throws Exception
     */
    public IOVTaskPentium[] finishSFUpdbpm( IOVOrderPentium fromOrder,
    		IOVOfferPentium fromOffer,
    		ISystemTemplate.IUpdbpmOffer fromUpdbm, 
    		IOVUpdbpmOffer fromUpdcpm,
    		IUpdcContext aContext ) throws SFException,Exception;
}
