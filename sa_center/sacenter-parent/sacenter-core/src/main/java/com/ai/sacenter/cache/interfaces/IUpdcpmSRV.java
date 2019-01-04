package com.ai.sacenter.cache.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IUpdcpmGroup;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 能力基础[基础配置]</p>
 * <p>Copyright: Copyright (c) 2015年9月29日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpmSRV extends IDialect {
	/**
	 * 查询开通接入层配置规范
	 * @param fromCATALOG 产品规格编号
	 * @param fromBUSINES 业务操作编码
	 * @param fromORIGINATE 渠道编码
	 * @param fromCATEGORY 调度类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesOffer getSFUpdbfxBusines(String fromCATALOG, 
			String fromBUSINES, 
			String fromORIGINATE,
			String fromCATEGORY) throws SFException, Exception;
	/**
	 * 查询开通接入层扩展配置规范
	 * @param fromPROGRAM  接入目录
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesCombine getSFUpdbfxKernel( String fromPROGRAM ) throws SFException, Exception;
	/**
	 * 查询开通接入层扩展配置规范
	 * @param fromCATEGORY 扩展类型
	 * @param fromPROGRAM  接入目录
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesKernel getSFUpdbfxKernel(String fromCATEGORY,
			String fromPROGRAM ) throws SFException, Exception;
	/**
	 * 查询开通接入层产品扩展配置规范
	 * @param fromCATALOG 产品规格
	 * @param fromBUSINES 产品操作
	 * @param fromPRODUCT 产品编码
	 * @param fromCATEGORY 调度类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IBusinesCatalog getSFUpdbfxCatalog( String fromCATALOG, 
			String fromBUSINES, 
			String fromPRODUCT,
			String fromCATEGORY) throws SFException, Exception;
	
	/**
	 * 根据服务能力模板查询服务能力模板规范
	 * @param fromMODULE 能力接入模板
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.ICompetenceBusines getSFUpdbfxCompete( String fromMODULE ) throws SFException, Exception;

	/**
	 * 根据产品编号查询服务产品单元规范
	 * @param fromPRODUCT 产品编号
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpOffer( long fromPRODUCT ) throws SFException, Exception;
	/**
	 * 根据产品编码查询服务产品单元规范
	 * @param fromPRODUCT 产品编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpComptel( String fromPRODUCT ) throws SFException, Exception;
	/**
	 * 
	 * @param fromPRODUCT
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductComptel getSFUpdcpSubject( String fromPRODUCT ) throws SFException, Exception;
	/**
	 * 根据产品组查询服务产品组清单
	 * @param fromGroup 产品组编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductGroup getSFUpdcpGroup( String fromGroup ) throws SFException, Exception;
	/**
	 * 根据产品编号和查询服务产品包规范
	 * @param fromPRODUCT 产品编码
	 * @param fromCATEGORY 关联类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductCombine getSFUpdcpCombine( String fromPRODUCT, 
			String fromCATEGORY ) throws SFException, Exception;
	/**
	 * 根据产品规格和产品操作查询服务能力组规范
	 * @param fromCATALOG 产品规格
	 * @param fromBUSINES 产品操作
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpBusines( String fromCATALOG, 
			String fromBUSINES ) throws SFException, Exception;
	/**
	 * 根据服务能力编号查询服务能力属性组规范
	 * @param fromCOMPETE 服务编号
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IProductOffer getSFUpdcpProperty( long fromCOMPETE ) throws SFException, Exception;
	/**
	 * 根据服务变量编码查询服务变量规范
	 * @param fromCOMPETE 服务变量编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IComptelKernel getSFUpdcpKernel( String fromCOMPETE ) throws SFException, Exception;
	/**
	 * 根据流程编码查询调度流程配置
	 * @param fromWORKFLOW 流程编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProfessionalTemplate.IUpdbpmOffer getSFUpdbpmOffer( String fromWORKFLOW ) throws SFException,Exception;
	/**
	 * 根据任务编号查询流程任务定义
	 * @param fromSUBFLOW 流程任务编号
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbpmOffer getSFUpdbpmCatalog( String fromSUBFLOW ) throws SFException, Exception;
	/**
	 * 根据网元属性模板查询网元扩展属性映射
	 * @param fromMODULE 网元属性模板
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffsmOffer getSFUpffwmOffer( String fromMODULE ) throws SFException, Exception;
	/**
	 * 根据网元属性模板和网元属性编码查询网元扩展属性映射
	 * @param fromMODULE 网元属性模板
	 * @param fromFEATURE 映射属性编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffgsmOffer getSFUpffxmOffer( String fromMODULE , 
			String fromFEATURE ) throws SFException, Exception;
	/**
	 * 根据网元属性模板和网元属性编码查询网元局向
	 * @param fromMODULE
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffgsmOffer[] getSFUpffxmOffice( String fromMODULE ) throws SFException, Exception;
	/**
	 * 根据方案编码查询解决方案
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdpgmOffer getSFUpdpgmOffer( String fromPROGRAM ) throws SFException, Exception;
	/**
	 * 根据组件编码和组件类型查询方案组件规范
	 * @param aCOMPONENT 组件编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcmpOffer getSFUpdcmptOffer( String fromCOMPONENT ) throws SFException,Exception;
	/**
	 * 根据解决方案组件查询解决方案二级组件,如解决方案二级组件未关联则采用当前组件策略
	 * @param fromUpdcmpt 组件策略
	 * @param fromJEVAL 服务订购
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcmpOffer getSFUpdcmptOffer( IProgramTemplate.IUpdfcmpOffer fromUpdcmpt,
			java.util.HashMap fromOffer,
			IUpdcContext aContext)  throws SFException, Exception;
	/**
	 * 根据组件资产编码查询二级组件资产,如二级组件资产未关联则采用当前组件资产
	 * @param aCOMPONENT 组件资产编码
	 * @param fromOffer 服务能力集 
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpdcpmGroup getSFUpdcmptCatalog( String aCOMPONENT,
			java.util.Map fromOffer,
			IUpdcContext aContext)  throws SFException, Exception;
	/**
	 * 根据解决方案获取当前一级映射类组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffsmOffer getSFUpdcmptMapping( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前二级映射类组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffsmOffer getSFUpdcmptComposite( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前异常策略类组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptSubFlow( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前异常队列类组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptQueue( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前定单项组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptRocket( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前网元归档组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptComplete( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前网元级异常类组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptPlatform( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前异常补偿组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfmptOffer getSFUpdcmptCompensation( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前异常回滚类组件
	 * @param fromPROGRAM 方案编码
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfbpmOffer getSFUpdcmptRollBack( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前异常派单组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffwmOffer getSFUpdcmptDistribute( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前服务阶段组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptSuggest( String fromPROGRAM ) throws SFException,Exception;
	/**
	 * 根据解决方案获取当前服务到期组件
	 * @param fromPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdfcwmOffer getSFUpdcmptExpire( String fromPROGRAM ) throws SFException,Exception;
}
