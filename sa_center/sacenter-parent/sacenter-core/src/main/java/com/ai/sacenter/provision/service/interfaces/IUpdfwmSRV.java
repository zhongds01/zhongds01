package com.ai.sacenter.provision.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.dbcp.IUpfwmProtocol;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmRequest;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元工单调度类</p>
 * <p>Copyright: Copyright (c) 2013-7-24</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdfwmSRV {
	/**
	 * 根据网元指令编码查询网元指令
	 * @param aPLATFORM 网元编码
	 * @param aDIRECTIVE 网元指令
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdspmLife getSFUpdfwm(String aPLATFORM,
			String aDIRECTIVE,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 完成服务定单任务单构造网元指令调度实例
	 * @param fromOrder 流程订单
	 * @param fromTASK 流程订单任务
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdspmLife getSFUpdfwm( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 完成子指令任务单构造包含子指令批量任务执行
	 * @param fromOrder 流程订单
	 * @param fromTASK 流程订单任务
	 * @param fromUpdfwm 网元指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List getSFUpdfwm( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 完成任务单构造批量任务执行
	 * @param fromUpfwm 网元工单
	 * @param aContext   
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdspmLife getSFUpdfwm( IOVUpfwmOffer fromUpfwm , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据网元定单构造框架指令集
	 * @param fromUpfwm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdspmLife getASKUpdfwm( IOVUpfwmOrder fromUpfwm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据网元二级指令规范网元二级指令拆分
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 服务指令集
	 * @param fromOffer 服务能力集
	 * @param fromINDEX 网元指令索引
	 * @param fromUpdgm 网元指令列表
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdfwmBpel( Object fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			java.util.Map fromOffer,
			java.util.Map fromINDEX,
			java.util.List fromUpdgm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据网元指令编码构造网元指令集
	 * @param fromUpfwm 网元工单类型
	 * @param fromUpdfwm 网元指令编码
	 * @param fromUpfm 网元基本信息
	 * @param fromOffer 激活能力集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List getSFUpdfwm(Object fromUpfwm,
			IPlatformTemplate.IUpffmDirective fromUpdfwm , 
			IPlatformTemplate.IUpffmOffer fromUpfm,
			java.util.Map fromOffer,
			IUpdcContext aContext )throws SFException,Exception;
	/**
	 * 根据服务订单任务完成流程级网元指令调度
	 * @param fromOrder 服务订单
	 * @param fromTASK 服务订单任务
	 * @param fromUpdfwm 网元指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwm( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务异常订单任务完成流程级网元指令[网元数据在内存中]调度
	 * @param fromOrder 服务异常订单
	 * @param fromTASK 服务异常订单任务
	 * @param fromUpdfwm 网元指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfmc( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IOVUpdspmLife fromUpdfwm , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据服务网元工单完成网元指令调度(包含与网元交易报文沉淀)
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 激活指令集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpfwm( IOVUpfwmOffer fromUpfwm , 
			IOVUpdspmLife fromUpdfwm , 
			IUpdcContext aContext ) throws SFException,Exception; 
	/**
	 * 根据网元工单完成与网元协议为指令调度交互
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 网元工单指令集
	 * @param aContext
	 * @return 网元指令反馈集
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishSFUpdfwm(IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	
    /**
     * 根据当前网元查询当前网元协议通道
     * @param fromUpfm 网元信息
     * @return
     * @throws SFException
     * @throws Exception
     */
    public IUpfwmProtocol getSFUpfwmProtocol( IPlatformTemplate.IUpffmOffer fromUpfm ) throws SFException, Exception;
	/**
	 * 完成流程任务构造网元测指令报文
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 网元指令集
	 * @param aContext
	 * @return 返回网元请求数据包
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmRequest finishRQKUpfwm( IOVUpfwmOffer fromUpfwm ,
			IOVUpdspmLife fromUpdfwm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 完成与网元协议报文交互
	 * @param fromUpfwm 网元工单
	 * @param fromUpdfwm 网元指令集
	 * @param fromREQ 网元报文请求
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishBPKUpfwm( IOVUpfwmOffer fromUpfwm, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmRequest fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 完成流程任务网元测反馈报文分析
	 * @param fromUpfwm 激活工单
	 * @param fromUpdfwm 网元指令集
	 * @param fromRsBody 网元反馈集
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfwmResponse finishASKUpfwm( IOVUpfwmOffer fromUpfwm ,
			IOVUpdspmLife fromUpdfwm, 
			Object fromRsBody,
			IUpdcContext aContext) throws SFException, Exception;
}
