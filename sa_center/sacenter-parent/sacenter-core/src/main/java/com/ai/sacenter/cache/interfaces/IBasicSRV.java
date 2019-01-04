package com.ai.sacenter.cache.interfaces;

import com.ai.appframe2.complex.self.po.TableSplit;
import com.ai.appframe2.complex.self.po.TableSplitMapping;
import com.ai.appframe2.complex.tab.split.function.IFunction;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISubTableTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.asiainfo.appframe.ext.exeframe.http.query.po.CfgHttpClient;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 公共基础[基础配置]</p>
 * <p>Copyright: Copyright (c) 2015年9月29日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IBasicSRV extends IDialect{
	/**
	 * 根据HTTP客户端编码查询HTTP客户端配置
	 * @param aHttpClientCode HTTP客户端编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public CfgHttpClient getHttpClient( String aHttpClientCode ) throws SFException,Exception;
	/**
	 * 根据枚举值清单查询枚举值转换配置
	 * @param fromCatalog 枚举清单,用逗号分隔[第1位枚举类型,第2位开始为枚举值清单]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IEnumWrapper getSFEnumChain( String fromCatalog ) throws SFException,Exception;
	/**
	 * 根据枚举组类型查询字典组信息
	 * @param fromCATEGORY 字段类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IEnumGroup getSFEnumGroup( String fromCATEGORY ) throws SFException,Exception;
	/**
	 * 根据静态组类型查询静态列表组
	 * @param aCATEGORY 静态组类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticCategory getSFStaticCategory( String aCATEGORY ) throws SFException,Exception;
	/**
	 * 根据静态组类型查询静态列表组
	 * @param aGROUP 静态组编码
	 * @param aCATEGORY 静态组类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticGroup getSFStaticGroup( String aGROUP, String aCATEGORY ) throws SFException,Exception;
	/**
	 * 根据静态组编码查询静态列表组
	 * @param aGROUP 静态组编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticGroup getSFStaticGroup( String aGROUP ) throws SFException,Exception; 
	/**
	 * 获取数据字段最大存储长度
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticOffer getSFStaticBytes() throws SFException,Exception; 
	/**
	 * 查询枚举值配置
	 * @param aCATEGORY 类型
	 * @param aSTATIC 值
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticOffer getSFStaticOffer( String aCATEGORY, 
			String aSTATIC ) throws SFException,Exception;
	/**
	 * 查询枚举值配置
	 * @param aCATEGORY 类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticOffer[] getSFStaticOffer( String aCATEGORY ) throws SFException,Exception;
	/**
	 * 根据表名和渠道类型和地市编码查询地市编号转换类配置
	 * @param aTABLE 表名
	 * @param aCHANNEL 渠道类型
	 * @param aREGION  地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.IdGenerator getSFIdGenerator( String aTABLE,
			String aCHANNEL,
			String aREGION ) throws SFException,Exception;
	/**
	 * 根据地区编号查询地市编号转换类配置
	 * @param aREGION_NUMBER 统一地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.IdGenerator getSFIdGenerator( String aREGION_NUMBER )  throws SFException,Exception;
	/** 
	 * 根据组件类型查询对应实现定义规则,如不存在则抛异常
	 * @param aIMPLCLASS 组件编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IImplCapital getSFUpfgkmLibrary( String aIMPLCLASS ) throws SFException, Exception;
	/**
	 * 获取物理表持久化配置
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmGroup getSFUpfgkmComposite( ) throws SFException,Exception;
	/**
	 * 根据物理表名查询物理表持久化配置
	 * @param _table_name
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmComposite getSFUpfgkmComposite( String _table_name ) throws SFException,Exception;
	/**
	 * 根据表名获取当前表对应分表规则
	 * @param fromTableName 表名
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public TableSplit getSFSubTableSplit( String fromTableName ) throws SFException,Exception;
	/**
	 * 根据表名获取当前表对应分表列转换规则
	 * @param fromTableName 表名
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public TableSplitMapping[] getSFSubTableMapping( String fromTableName ) throws SFException,Exception;
	/**
	 * 根据分表转换类获取当前表对应类适配器
	 * @param fromCLASS
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IFunction getSFSubTableChain( String fromCLASS ) throws SFException,Exception;
	/**
	 * 获取网元全量分表规范
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.ISubSQLCombine getSFSubTableGroup() throws SFException,Exception;
	/**
	 * 根据网元编码查询网元分表规范
	 * @param aPLATFORM 网元编码
	 * @param aTableName 表名
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.ISubSQLGroup getSFSubTableGroup( String aPLATFORM ) throws SFException,Exception;
	/**
	 * 根据网元编码和列名和列值查询网元表配置
	 * @param aPLATFORM 网元编码
	 * @param aTABLE 表名
	 * @param aCOLUMN 列名
	 * @param aVALUE 列值
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.ISubSQLTableCau getSFSubTableCau( String aPLATFORM, 
			String aTABLE,
			String aCOLUMN , 
			String aVALUE ) throws SFException,Exception;
	/**
	 * 根据网元编码和路由类型查询服务路由中心组
	 * @param aPLATFORM 网元编码
	 * @param aCATEGORY 路由类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterGroup getSFCenterGroup(String aPLATFORM,
			String aCATEGORY) throws SFException,Exception;
	/**
	 * 根据路由编码和网元编码查询服务中心信息
	 * @param aROUTE 路由编码
	 * @param aCATEGORY 路由类型
	 * @param aPLATFORM 归属编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute getSFCenterOffer( String aROUTE,
			String aCATEGORY,
			String aPLATFORM ) throws SFException,Exception;
	/**
	 * 根据路由编码和网元编码查询网元中心信息
	 * @param aROUTE_ID 路由编码
	 * @param aROUTE_TYPE 路由类型
	 * @param fromUpfm 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute getSFCenterOffer( String aROUTE_ID ,
			String aROUTE_TYPE,
			IPlatformTemplate.IUpffmOffer fromUpfm ) throws SFException, Exception;
	/**
	 * 获取服务开通地市路由规范
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute[] getSFCenterSubFlow( ) throws SFException, Exception;
	/**
	 * 根据地市编码查询服务开通地市路由信息
	 * @param aREGION_ID 地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute getSFCenterSubFlow( String aREGION_ID ) throws SFException, Exception;
	/**
	 * 根据地市编码查询服务开通地市路由信息
	 * @param aREGION_NUMBER 地市编号
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute getSFCenterSubFlow( long aREGION_NUMBER ) throws SFException, Exception;
	/**
	 * 根据类和网元查询网元中心转换配置
	 * @param aIMPLCLASS 类
	 * @param fromUpfm 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterWrapper getSFCenterWrapper( String aIMPLCLASS , 
			IPlatformTemplate.IUpffmOffer fromUpfm ) throws SFException, Exception;
	/**
	 * 根据服务中心类型查询服务中心转换规范
	 * @param aCATEGORY 服务中心类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterMapping getSFCenterMapping( String aCATEGORY ) throws SFException, Exception;
	/**
	 * 根据服务类型查询服务中心目录配置规范
	 * @param fromGROUP 服务类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterCombine getSFCenterCatalog( String fromGROUP ) throws SFException, Exception;
	/**
	 * 根据服务类和服务中心类型查询当前服务类对应服务中心目录
	 * @param aIMPLCLASS 服务类
	 * @param fromGROUP 服务类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterCatalog getSFCenterCatalog( String aIMPLCLASS, String fromGROUP ) throws SFException, Exception;
	/**
	 * 根据类名查询并行割接策略信息
	 * @param orignate 发起方编码
	 * @param regionId 地市编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmParallel getSFUpfgkmParallel(String orignate,String regionId) throws SFException,Exception;
	/**
	 * 根据资源编码查询国际资源规范
	 * @param resource 资源编码
	 * @param category 资源类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmResource getSFUpfgkmResource( String resource, String category ) throws SFException,Exception;
	/**
	 * 根据号码和地区编码和号段类型查询号段信息
	 * @param fromBILL 用户号码
	 * @param fromCATEGORY 号段类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmOfficeX getSFUpfgkmOffice( String fromBILL,
			String fromCATEGORY) throws SFException,Exception;
	/**
	 * 根据局向规则查询局向规则信息
	 * @param fromBILL_ID 用户号码
	 * @param fromHEADNUM 号码号段
	 * @param fromCATEGORY 号段类型
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmOfficeX getSFUpfgkmOffice( String fromBILL_ID,
			String fromHEADNUM,
			String fromCATEGORY) throws SFException,Exception;
	/**
	 * 根据业务操作查询开通接入能力优先级规范
	 * @param fromCatalog 业务大类
	 * @param fromBusines 业务编码
	 * @param fromBatches 是否批量(1是0否)
	 * @param fromChannel 渠道编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsCombine getSFUpdbfsOffer(String fromCatalog,
			String fromBusines,
			String fromBatches,
			String fromChannel) throws SFException,Exception;
	/**
	 * 查询开通默认优先级规范
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer() throws SFException,Exception;
	/**
	 * 根据服务优先级编号获取服务优先级规范
	 * @param aPRIORITY 服务优先级编号
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer( long aPRIORITY ) throws SFException,Exception;
	/**
	 * 根据业务级优先级编码获取开通网元工单优先级规范
	 * @param aPRIORITY 服务优先级编号
	 * @param aPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer( long aPRIORITY,
			String aPLATFORM ) throws SFException,Exception;
}
