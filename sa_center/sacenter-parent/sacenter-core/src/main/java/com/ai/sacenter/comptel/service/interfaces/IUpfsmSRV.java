package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元映射接口服务</p>
 * <p>Copyright: Copyright (c) 2014-4-10</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfsmSRV {
	/**
	 * 根据映射模板完成网元模板映射
	 * @param fromMODULE 映射模板
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmc( String fromMODULE , 
			java.util.Map fromOffer , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 根据映射单元完成网元模板映射
	 * @param fromUpfgsmc 映射单元
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmc( IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据映射单元列表完成网元模板映射
	 * @param fromUpfgsm 映射模板
	 * @param fromCOMPETE 映射单元 
	 * @param fromOffer 服务能力
	 * @param fromUpfwm 映射结果
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgsmc(IPlatformTemplate.IUpffsmOffer fromUpfgsm,
			java.util.List fromCOMPETE,
			java.util.Map fromOffer, 
			IOVUpfgsmCatalog fromUpfwm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 根据映射单元完成网元模板映射
	 * @param fromUpfgsm 映射模板
	 * @param fromUpfgsmc 映射单元
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfgsmc( IPlatformTemplate.IUpffsmOffer fromUpfgsm, 
			IPlatformTemplate.IUpffgsmOffer fromUpfgsmc, 
			java.util.Map aMAPPINGS, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 完成网元模块映射任务
	 * @param fromMODULE 映射模板
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmOffer(String fromMODULE,
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 完成模块映射任务
	 * 如aMODULE不为空则按aMODULE模块映射,否则按aMODULE子元素映射
	 * @param fromMODULE 映射模板
	 * @param fromUpfgsmc 映射单元
	 * @param fromOffer 服务能力
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmOffer( String fromMODULE,
			IPlatformTemplate.IUpffgsmOffer fromUpfgsmc,
			java.util.Map fromOffer, 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 根据服务激活任务完成模块映射任务
	 * @param fromMODULE 服务映射模板
	 * @param fromUpfgsmc 服务激活任务
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishSFUpfgsmOffer( String fromMODULE,
			Object fromUpfgsmc,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 完成网元应答映射任务
	 * @param fromMODULE 映射模板
	 * @param fromUpfwm 网元应答集
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpfgsmCatalog finishASKUpfwmOffer( String fromMODULE,
			Object fromUpfwm, 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * 映射文件转换到映射集
	 * @param aFILE 映射文件
	 * @throws SFException
	 * @throws Exception
	 */
	public void deployUpffsmOracle( String aFILE ) throws SFException, Exception; 
	/**
	 * 映射集转换为文件
	 * @param aMODULE 模板名称
	 * @param rootFilePath 要保存文件的根路径
	 * @throws SFException
	 * @throws Exception
	 */
	public void deployUpffsmFile( String aMODULE , String rootFilePath ) throws SFException, Exception;
}
