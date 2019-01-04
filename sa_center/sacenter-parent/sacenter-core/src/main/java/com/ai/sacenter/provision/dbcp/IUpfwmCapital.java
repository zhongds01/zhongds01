package com.ai.sacenter.provision.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元插件资产</p>
 * <p>Copyright: Copyright (c) 2015年10月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmCapital {
	/**
     * 完成平台指令执行
     * @param fromOrder 服务定单
     * @param fromTASK 服务定单任务
     * @param fromUpdfwm 激活指令集
     * @param aContext
     * @return 
     * @throws SFException
     * @throws Exception
     */
    public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder ,
    		IOVTaskPentium  fromTASK,
    		IOVUpdspmLife fromUpdfwm,
    		IUpdcContext aContext ) throws SFException,Exception;
    /**
     * 完成网元工单指令执行
     * @param fromUpfwm 网元工单
     * @param fromUpdfwm 激活指令集
     * @param aContext
     * @return 返回清单 FAILURE(Boolean)(网元执行是否异常),
     *                 RESULT(网元执行情况),
     *                 RETN(网元返回编码),
     *                 DESCRIPTION(网元返回编码描述)
     * @throws SFException
     * @throws Exception
     */
    public IOVUpfwmResponse finishSFUpdfwm( IOVUpfwmOffer fromUpfwm,
    		IOVUpdspmLife fromUpdfwm,
    		IUpdcContext aContext ) throws SFException,Exception;
}
