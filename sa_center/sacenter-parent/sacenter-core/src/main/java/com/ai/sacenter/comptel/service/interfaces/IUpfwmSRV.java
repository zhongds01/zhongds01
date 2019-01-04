package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务模板服务</p>
 * <p>Copyright: Copyright (c) 2014-12-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfwmSRV {
	/**
	 * 根据映射属性和服务能力生成模板能力集
	 * @param fromUpfwm 映射单元
	 * @param fromOffer 服务能力
	 * @param fromUpfgsm 网元能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map getSFUpdbmChain( Object fromUpfwm,
			java.util.Map fromOffer,
			java.util.Map fromUpfgsm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据属性表达式计算表达式属性清单
	 * @param fromJEXP 属性表达式
	 * @param fromOffer 服务能力
	 * @param fromUpfgsm 转换能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map finishSFUpdbmChain(String fromJEXP , 
			java.util.Map fromOffer , 
			java.util.Map fromUpfgsm ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据规范表达式分析服务属性映射规范
	 * @param fromCOMPLEX 规则表达式
	 * @param fromOffer 服务能力集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfvnChain(String fromCOMPLEX,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 按照模板映射单元转换其属性清单
	 * @param fromUpffxm 模板映射单元
	 * @param fromOffer 服务能力集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpdbmOffer( ISystemTemplate.IUpfgsmxOffer fromUpffxm,
			java.util.Map fromOffer ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据映射组件转换其属性清单
	 * @param fromUpffwm 映射组件
	 * @param fromOffer 服务能力
	 * @param fromUpfgsm 映射结果集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map finishSFUpdbmOffer( IProgramTemplate.IUpdffsmOffer fromUpffwm,
			java.util.Map fromOffer ,
			java.util.Map fromUpfgsm ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 按照映射模板转换其属性清单
	 * @param fromMODULE  模板编码
	 * @param fromOffer 服务能力
	 * @param fromUpfwm 映射结果集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map finishSFUpdbmOffer( String fromMODULE ,
			java.util.Map fromOffer ,
			java.util.Map fromUpfwm ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据协议模板内容生成人机语言内容
	 * @param fromID     模板编号,用于抛异常唯一编码
	 * @param fromFILE   模板类型  
	 * @param fromPROTOCOL 模板内容 
	 * @param fromOffer  服务能力
	 * @param fromUpfgsm 网元能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( String fromID,
			String fromFILE,
			String fromPROTOCOL, 
			java.util.Map fromOffer,
			java.util.Map fromUpfgsm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据模板编码生成模板规范内容
	 * @param fromID     模板编号,用于抛异常唯一编码
	 * @param fromMODULE 模板编码  
	 * @param fromOffer  服务能力
	 * @param fromUpfgsm 网元能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( String fromID,
			String fromMODULE, 
			java.util.Map fromOffer,
			java.util.Map fromUpfgsm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据模板编码生成模板规范内容
	 * @param fromMODULE 模板编码  
	 * @param fromOffer  服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( String fromMODULE,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据映射单元完成人机模板映射
	 * @param fromUpfgsm 映射单元
	 * @param fromUpfgsmc 二级映射单元
	 * @param fromOffer 服务能力
	 * @param fromUpfsm 映射能力
	 * @param fromPROTOCOL 模板编码
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( IPlatformTemplate.IUpffgsmOffer fromUpfgsm,
			IPlatformTemplate.IUpffgsmOffer fromUpfgsmc[],
			java.util.Map fromOffer,
			java.util.Map fromUpfsm,
			String fromPROTOCOL,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据映射单元完成人机模板映射
	 * @param fromMODULE 映射模板
	 * @param fromUpfgsm 映射单元
	 * @param fromOffer 服务能力
	 * @param fromPROTOCOL 模板编码
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbmChain( String fromMODULE , 
			IPlatformTemplate.IUpffgsmOffer fromUpfgsm,
			java.util.Map fromOffer,
			String fromPROTOCOL,
			IUpdcContext aContext ) throws SFException, Exception;
}
