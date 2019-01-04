package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpfvmSRV {
	/**
	 * 根据循环属性和批量属性生成批量属性清单
	 * 格式为XXX_NUM=属性个数;XXX_NAME_1=属性1;XXX_VALUE_1=属性1值;XXX_NAME_2=属性2;XXX_VALUE_2=属性2值
	 * @param fromID 模板编号
	 * @param fromWHILEX 循环编码
	 * @param fromMODLE 循环变量 
	 * @param fromOffer 服务能力
	 * @param fromChain 循环变量集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbpfChain(String fromID, 
			String fromWHILEX, 
		    String fromMODLE, 
		    java.util.Map fromOffer, 
		    java.util.List fromChain,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 按照批量属性引用生成批量属性清单
	 * @param fromID 模板编号
	 * @param fromMODLE 批量属性
	 * @param fromOffer 服务能力
	 * @param fromChain 循环变量集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbmfChain(String fromID, 
			String fromMODLE, 
		    java.util.Map fromOffer, 
		    java.util.List fromChain,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据循环属性和批量属性生成循环属性清单
	 * @param fromID 模板编号
	 * @param fromWHILEX 循环变量
	 * @param fromMODLE 循环映射模板
	 * @param fromOffer 服务能力
	 * @param fromChain 循环变量集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbfpChain(String fromID, 
			String fromWHILEX, 
		    String fromMODLE, 
		    java.util.Map fromOffer, 
		    java.util.List fromChain,
		    IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据循环属性生成循环映射属性清单
	 * @param fromUpfgsmc 映射单元
	 * @param fromMODLE  循环变量
	 * @param fromOffer 服务能力
	 * @param fromChain 循环变量集
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdbfpChain(IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			String fromMODLE,
			java.util.Map fromOffer, 
			java.util.List fromChain,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据二进制字符串构造保温
	 * @param fromPRIMITIVE 原始二进制
	 * @param fromCOMPETE 服务能力编码
	 * @param fromChain 二进制集合
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishUpdbtfChain( String fromPRIMITIVE , 
			String fromCOMPETE,
			java.util.Map fromChain ) throws SFException,Exception;
	/**
	 * 采用属性模板规范生成流程级属性列表
	 * @param fromXPath 属性模板规范,格式为[属性模板编码]或[属性模板编码.属性转换编码]
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFXPathChain( String fromXPath,
			java.util.Map fromOffer, 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据循环映射生成批量属性清单
	 * @param fromUpfgsm 循环映射单元
	 * @param fromMODULE 模板属性编码
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List finishSFUpdforChain( IPlatformTemplate.IUpffgsmOffer fromUpfgsm,
			String fromMODULE,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据协议模板编码生成网元人机指令
	 * @param fromID 属性编码
	 * @param fromCOMPLEX 属性模板编码
	 * @param fromPROTOCOL 协议模板编码
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbrfChain( String fromID,
			String fromCOMPLEX,
			String fromPROTOCOL, 
			java.util.Map fromOffer, 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据协议模板内容生成人机语言内容
	 * @param fromID 映射编号
	 * @param fromPROTOCOL 协议模板内容
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbwfChain( String fromID ,
			String fromPROTOCOL,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据循环属性和属性模板生成批量属性清单
	 * @param aID 属性编码
	 * @param fromWHILEX 循环属性编码
	 * @param fromMODLE 模板属性编码
	 * 格式为"属性模板或$BPF[批量属性开头]"
	 *  1.格式为"属性模板",则aWHILEX为循环属性编码,其类型为数组或链表
	 *  2.格式为"$BPF[属性开头]",则aUpdsmoLife中包含"属性开头_NUM"和"属性开头_NAME_下标"和"属性开头_VALUE_下标",
	 *    样例为$BPF[PARA],fromOffer中包含PARA_NUM=2;PARA_NAME_1=UserType;PARA_VALUE_1=0;PARA_NAME_2=QJCL;PARA_VALUE_2=1
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List finishSFUpdbpfChain( String fromID ,
			String fromWHILEX,
			String fromMODLE,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据位字符标志生成位字符串映射
	 * @param fromUpfgsmc 映射单元
	 * @param aPRIMITIVE 原始二进制
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbtfChain( IPlatformTemplate.IUpffgsmOffer fromUpfgsmc,
			String fromPRIMITIVE,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据位字符标志生成位字符串映射
	 * @param fromUpfgsmc 映射单元
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String finishSFUpdbtfChain( ISystemTemplate.IUpfgsmxOffer fromUpfgsmc,
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据VTL语言调用系统级函数
	 * @param fromID 模板编号
	 * @param fromMODULE 函数编码
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpdfunChain( String fromID,
			String fromMODULE,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * 根据枚举值查询静态数据配置
	 * @param fromUpfgsm 映射规范
	 * @param fromOffer 激活能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IEnumWrapper finishSFUpdbtxChain(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
				java.util.Map fromOffer, 
				IUpdcContext aContext) throws SFException, Exception; 
}
