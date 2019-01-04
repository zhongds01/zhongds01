package com.ai.sacenter.cache.interfaces;

import com.ai.aif.csf.common.exception.CsfException;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IUpfgsmTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元基础[基础配置]</p>
 * <p>Copyright: Copyright (c) 2015年10月6日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpffmSRV extends IDialect {
	/**
	 * 获取开通系统网元规范
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOffer getSFUpffmOffer() throws SFException, Exception;
	/**
	 * 根据平台编号查询平台定义配置
	 * @param fromPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOffer getSFUpffmOffer(String fromPLATFORM) throws SFException, Exception;
	/**
	 * 根据平台编号查询网元网路配置
	 * @param fromPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmNetWork getSFUpffmNetWork(String fromPLATFORM) throws SFException, Exception;
	/**
	 * 查询父级网元平台
	 * @param fromPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOffer[] getSFUpffmParent( String fromPLATFORM ) throws SFException,Exception;
	/**
	 * 查询子级网元平台
	 * @param fromPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOffer[] getSFUpffmChild( String fromPLATFORM ) throws SFException,Exception;
	/**
	 * 根据平台操作代码查询平台操作定义
	 * @param fromOPERATE 网元操作编码
	 * @param fromUpffm 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOperate getSFUpffmOperate(String fromOPERATE, 
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception;
	/**
	 * 根据逻辑指令编码查询逻辑操作定义
	 * @param fromDIRECTIVE 逻辑指令编码
	 * @param fromPLATFORM 逻辑网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOperate getSFUpffmOperate( String fromDIRECTIVE,
			String fromPLATFORM )  throws SFException, Exception;
	/**
	 * 根据指令编号查询主指令定义
	 * @param fromDIRECTIVE 网元指令编码
	 * @param fromUpffm 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmDirective getSFUpffmLogical( String fromDIRECTIVE, 
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception;
	/**
	 * 根据子指令流程和网元查询子指令定义
	 * @param fromSUBFLOW 二级流程编码
	 * @param aPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffbpmOffer getSFUpffmSubFlow( String fromSUBFLOW, 
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception;
	/**
	 * 根据网元模板编码查询模板定义信息
	 * @param fromPROTOCOL 模板编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmProtocol getSFUpffmProtocol( String fromPROTOCOL ) throws SFException, Exception;
	/**
	 * 查询用户号码名单路由
	 * @param fromBILL 用户号码
	 * @param fromUpffm 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmPhone getSFUpffmPhone( String fromBILL , 
			IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException, Exception;
	/**
	 * 查询网元调试模拟报文
	 * @param fromDIRECTIVE 指令编码
	 * @param fromPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmDebuging  getSFUpffmDebug( String fromDIRECTIVE , 
			String fromPLATFORM ) throws SFException,Exception;
	/**
	 * 根据映射集编码查询映射集信息
	 * @param fromMODULE 映射集编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffsmOffer getSFUpffsmOffer( String fromMODULE ) throws SFException,Exception;
	/**
	 * 根据网元类型查询网元属性扩展规范
	 * @param fromMODULE 网元类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgsmTemplate.IUpfgsmOffer getSFUpfgsmMisc( String fromMODULE ) throws SFException, Exception;
	/**
	 * 查询服务激活能力级属性定义
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map getSFUpffxOffer( ) throws SFException, Exception;
	/**
	 * 根据网元编码查询网元属性定义
	 * @param fromPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map getSFUpffxOffer( String fromPLATFORM ) throws SFException, Exception; 
	/**
	 * 根据网元编码和属性编码查询网元属性定义
	 * @param fromFEATURE 网元属性编码
	 * @param fromPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffxOffer getSFUpffxOffer( String fromFEATURE , 
			String fromPLATFORM ) throws SFException, Exception; 
	/**
	 * 根据网元编码查询服务反馈规范组
	 * @param _platform 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsGroup getSFUpffmsGroup( String _platform) throws SFException, Exception;
	/**
	 * 根据反馈代码查询服务反馈规范
	 * @param _coding 反馈代码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( String _coding ) throws SFException, Exception;
	/**
	 * 根据反馈代码和物理网元查询统一反馈定义
	 * @param _coding 反馈代码
	 * @param _platform 物理网元
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer(String _coding,
			String _platform) throws SFException, Exception;
	/**
	 * 根据反馈代码和物理指令编码查询框架反馈定义
	 * @param _coding   反馈代码
	 * @param _category 反馈类型
	 * @param _platform 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( String _coding , 
			String _category, 
			String _platform ) throws SFException, Exception;
	/**
	 * 根据异常类型获取异常代码规范策略
	 * @param _exception 异常类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( SFException _exception ) throws SFException, Exception;
	/**
	 * 根据异常类型获取异常代码规范策略
	 * @param _exception 异常类型
	 * @param _category 反馈类型
	 * @param _platform 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( SFException _exception,
			String _category,
			String _platform ) throws SFException, Exception;
	/**
	 * 根据异常类型获取异常代码规范策略
	 * @param _exception 异常类型
	 * @param _platform 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( CsfException _exception,
			String _platform ) throws SFException, Exception;
	/**
	 * 根据异常类型获取异常代码规范策略
	 * @param _exception 异常类型
	 * @param _category 反馈类型
	 * @param _platform 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( CsfException _exception,
			String _category,
			String _platform ) throws SFException, Exception;
	/**
	 * 根据反馈代码和物理指令编码查询框架反馈归类定义
	 * @param _coding 反馈代码
	 * @param _category 反馈类型
	 * @param fromPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsCatalog getSFUpffmsCatalog( String _coding , 
			String _category, 
			String _platform ) throws SFException, Exception;
}
