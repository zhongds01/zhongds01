package com.ai.sacenter.provision.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元协议资产</p>
 * <p>Copyright: Copyright (c) 2015年10月24日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmProtocol {
	/**
     * 完成平台构造请求报文
     * @param fromUpfwm  网元工单
     * @param fromUpdfwm 网元指令集
     * @param fromUpdcpm 订单属性集
     * @param aContext
     * @return 
     * @throws SFException
     * @throws Exception
     */
    public IOVUpfwmRequest finishRQKUpfwm(IOVUpfwmOffer fromUpfwm,
    		IOVUpdspmLife fromUpdfwm,
    		IOVUpfwmRequest fromUpdcpm,
    		IUpdcContext aContext ) throws SFException,Exception;
    /**
     * 完成网元数据同步到网元平台
     * @param fromUpfwm 网元工单
     * @param fromUpdfwm 激活指令集
     * @param fromNetWork 网路客户端
     * @param fromUpdcpm 请求报文
     * @param aContext
     * @return
     * @throws SFException
     * @throws Exception
     */
    public Object finishBPKUpfwm( IOVUpfwmOffer fromUpfwm,
    		IOVUpdspmLife fromUpdfwm,
    		IUpfwmClient fromNetWork,
    		IOVUpfwmRequest fromUpdcpm,
    		IUpdcContext aContext ) throws SFException,Exception;
    /**
     * 完成平台分析回应报文
     * @param fromUpfwm 网元工单
     * @param fromUpdfwm 网元指令集
     * @param fromRsBody 网元反馈集
     * @param aContext
     * @return 返回数组[0网元应答集(HashMap),1二次映射报文,2沉淀交易报文]
     * @throws SFException
     * @throws Exception
     */
    public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
    		IOVUpdspmLife fromUpdfwm,
    		Object fromRsBody,
    		IUpdcContext aContext ) throws SFException,Exception;
}
