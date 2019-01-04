package com.ai.sacenter.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.aif.csf.common.exception.CsfException;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.complex.cache.ICache;
import com.ai.appframe2.complex.xml.XMLHelper;
import com.ai.appframe2.complex.xml.cfg.caches.Cache;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.common.IUpfvmsSTKLocal;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.common.UpfsvcVantage;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.core.valuebean.IOVUpdbmtcLife;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFESCsfException;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.module.IConfigDefine.IModuleDefine;
import com.ai.sacenter.module.IUpdcLifeCycle;
import com.ai.sacenter.module.proxy.BaseProxyCreate;
import com.ai.sacenter.provision.mstp.IUpfwmDefine;
import com.ai.sacenter.provision.mstp.impl.UpfwmHttpClient;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.asiainfo.appframe.ext.exeframe.http.query.po.CfgHttpClient;
import com.asiainfo.appframe.ext.exeframe.tf.config.CfgTf;

/**
 * 
 * <p>Title: openframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009-12-13</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SystemUtils extends org.apache.commons.lang.SystemUtils{
	private final static Log log = LogFactory.getLog( SystemUtils.class );
    public SystemUtils() {
		super();
	}
    
    /**
     * 集群服务名
     * @return
     */
    public static String getWEBLOGIC(){
    	String _weblogic = null;
    	try
    	{
    		String fromWAS[] = JVMUtils.getWEBLOGIC();
    		_weblogic = fromWAS != null && fromWAS.length > 1?fromWAS[1]:"*";
    	}
    	finally{
    		
    	}
    	
    	return _weblogic;
    }
    
    /**
     * 集群
     * @return
     */
    public static String getCLUSTER(){
    	StringBuilder _cluster = new StringBuilder();
    	try
    	{
    		String fromWAS[] = JVMUtils.getWEBLOGIC();
    		_cluster.append( fromWAS[1] )
    		        .append( "{" ).append( fromWAS[0] )
    		        .append( "{" ).append( Thread.currentThread().getName() ).append("}}");
    	}
    	catch( java.lang.Exception exception ){
    		_cluster = new StringBuilder();
    		_cluster.append( "*{*}{" ).append( Thread.currentThread().getName() ).append("}");
    	}
    	return _cluster.toString();
    }
    
    /**
     * 集群主机
     * @return
     */
    public static String getHOST(){
    	String _host = null;
    	try
    	{
    		String fromWAS[] = JVMUtils.getWEBLOGIC();
    		_host = fromWAS != null && fromWAS.length > 0?fromWAS[0]:"*";
    	}
    	finally{
    		
    	}
    	return _host;
    }
    
	/**
	 * 
	 * @param aEXCEPTION
	 * @return
	 */
	public static String getISTKThrow( java.lang.Exception aEXCEPTION ){
		String fromThrow = null;
		try
		{
			java.lang.Exception aPRIMITIVE = ExceptionFactory.getPrimitive( aEXCEPTION );
			fromThrow = StringUtils.trimRight( aPRIMITIVE , 1900 );
		}
		finally{
			
		}
		return fromThrow;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-10-24</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 服务定单反馈代码转换为正值表达式所需变量
		 * @param fromTASK 服务定单
		 * @param fromUpdfwm 激活指令集
		 * @param fromJEVAL
		 */
		public static void wrap( Object fromTASK,
				IOVUpdspmLife fromUpdfwm, 
				java.util.Map fromJEVAL){
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm = fromUpdfwm.getPLATFORM();
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				ClassUtils.IMerge.merge( new Object[][]{
						{IUpdcConst.IUpdbm.IUpdbf.PLATFORM , fromUpffm},
						{IUpdcConst.IUpdbm.IUpdbf.OPERATE  , fromUpfom}}, 
						fromJEVAL, 
						true );
			}
			finally{
				
			}
		}
		/**
		 * 服务定单反馈代码转换为正值表达式所需变量
		 * @param fromTASK 服务定单
		 * @param fromASK 服务反馈集
		 * @param fromNetWork 网元反馈集
		 * @param aEXCEPTION 异常类型
		 * @param fromJEVAL 表达式变量
		 */
		public static void wrap(Object fromTASK,
				IOVUpfwmResponse fromASK, 
				IOVUpfwmResponse fromNetWork, 
			    SFException aEXCEPTION, 
			    java.util.Map fromJEVAL){
			try
			{
				if( fromASK != null ){
					IICustom.wrap(fromTASK, fromASK, fromJEVAL);
				}
				if( fromNetWork != null ){
					java.util.Map _network = new java.util.HashMap();
					fromJEVAL.put( IUpdcConst.IUpfwm.PLWK_NETWORK, fromNetWork );
					IICustom.wrap(fromTASK, fromNetWork, _network );
				}
				if( aEXCEPTION != null ){
					IICustom.wrap(fromTASK, aEXCEPTION, fromJEVAL);
				}
			}
			finally{
				
			}
		}
		/**
		 * 框架反馈规范转换为统一反馈对象
		 * @param fromUpfgm 框架反馈规范
		 * @param fromASK 统一反馈对象
		 */
		private static IOVUpfwmResponse _wrap( IPlatformTemplate.IUpffmsOffer aConfigure , 
				IOVUpfwmResponse fromASK ){
			try
			{
				fromASK.setFAILURE  ( aConfigure.isSUCCEED()?Boolean.FALSE:Boolean.TRUE );
				fromASK.setRspCode  ( aConfigure.getID      () );
				fromASK.setRspDesc  ( aConfigure.getNAME    () );
				fromASK.setRspHome  ( aConfigure.getPLATFORM() );
			}
			finally{
				
			}
			return fromASK;
		}
		/**
		 * 根据网元反馈转换为统一反馈对象
		 * @param fromTASK
		 * @param fromNetWork
		 * @param fromASK
		 */
		private static void _wrap( Object fromTASK, IOVUpfwmResponse fromNetWork, IOVUpfwmResponse fromASK){
			try
			{
				if (fromASK.getFAILURE() == null && fromNetWork.getFAILURE() != null) {
					fromASK.setFAILURE( fromNetWork.getFAILURE() );
				}
				if (fromASK != null && StringUtils.isBlank(fromASK.getRspCode())
						&& fromNetWork.isRsRspNull() == false) {
					fromASK.setRspCode( fromNetWork.getRspCode () );
				}
				if (StringUtils.isBlank(fromNetWork.getRspDesc()) == false) {
					fromASK.setRspDesc( fromNetWork.getRspDesc () );
				}
				fromASK.setRspHome ( fromNetWork.getRspHome() );
				fromASK.setRspBody ( fromNetWork.getRspBody() );
				if( fromNetWork.getRspResult() != null ) {
					fromASK.setRspResult( fromNetWork.getRspResult() );
				}
				ClassUtils.IMerge.merge(fromNetWork.getORDER().getSUBFLOW(), 
						fromASK.getORDER().getSUBFLOW() );
			}
			finally{
				
			}
		}
		/**
		 * 框架反馈规范转换为统一反馈对象
		 * @param fromTASK 工单对象
		 * @param aEXCEPTION 框架原反馈集
		 * @param fromASK 统一反馈对象
		 */
		private static void _wrap( Object fromTASK,
				SFException aEXCEPTION,
				IOVUpfwmResponse fromASK){
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				fromUpffm = UpdcUtils.ISubFlow.getPLATFORM( aEXCEPTION );
				fromASK.setFAILURE ( Boolean.TRUE              );
				fromASK.setRspCode ( aEXCEPTION.getFaultCode() );
				fromASK.setRspDesc ( aEXCEPTION.getMessage  () );
				fromASK.setRspHome ( fromUpffm.getID        () );
			}
			finally{
				
			}
		}
		
		/**
		 * 框架反馈规范转换为统一反馈对象
		 * @param aConfigure 框架反馈规范
		 * @param fromUpfgm 框架原反馈集
		 * @param aEXCEPTION 激活异常
		 * @param aUpdgrspLife 统一反馈目标对象
		 */
		public static IOVUpfwmResponse _wrap( IPlatformTemplate.IUpffmsOffer aConfigure , 
				IOVUpfwmResponse fromUpfgm, 
				SFException aEXCEPTION ){
			IOVUpfwmResponse fromASK;
			try
			{
				fromASK = new IOVUpfwmResponse( aConfigure );
				ICustom._wrap( aConfigure , fromASK );
				if( aEXCEPTION == null && fromUpfgm != null ){
					ICustom._wrap(aConfigure, fromUpfgm, fromASK);
				}
				else if( aEXCEPTION != null ){
					ICustom._wrap(aConfigure, aEXCEPTION, fromASK);
				}
			}
			finally{
				
			}
			return fromASK;
		}
		/**
		 * 框架反馈规范转换为统一反馈对象
		 * @param fromTASK 工单对象
		 * @param aConfigure 框架反馈规范
		 * @param aEXCEPTION 激活异常
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmResponse _wrap( Object fromTASK, 
				IPlatformTemplate.IUpffmsOffer aConfigure,
				SFException aEXCEPTION) throws SFException,Exception{
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = new IOVUpfwmResponse( fromTASK );
				if( aConfigure != null ) ICustom._wrap( aConfigure , fromASK );
				if( aEXCEPTION != null ) ICustom._wrap( fromTASK , aEXCEPTION , fromASK );
			}
			finally{
				
			}
			return fromASK;
		}
		/**
		 * 框架反馈规范转换为统一反馈对象
		 * @param fromTASK 工单对象
		 * @param fromOriging 发起方
		 * @param fromRespond 服务反馈规范
		 * @param fromNetWork 网元反馈
		 * @param aEXCEPTION 激活异常
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmResponse _wrap( Object fromTASK,
				IPlatformTemplate.IUpffmOffer fromOriging,
				IPlatformTemplate.IUpffmsOffer fromRespond,
				IOVUpfwmResponse fromNetWork,
				SFException aEXCEPTION) throws SFException,Exception{
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = new IOVUpfwmResponse( fromTASK );
				if( fromRespond != null ){
					ICustom._wrap( fromRespond , fromASK );
					if( fromOriging != null ){ 
						fromASK.setRspHome( fromOriging.getID() );
					}
					if( fromNetWork != null ){
						fromASK.setRspDesc( StringUtils.isBlank( fromNetWork.getRspDesc() ) == false?
								fromNetWork.getRspDesc():fromASK.getRspDesc() );
						ClassUtils.IMerge.merge( fromNetWork.getRspBody(), fromASK.getRspBody() );
					}
				}
				if( aEXCEPTION != null ){
					ICustom._wrap( fromTASK , aEXCEPTION , fromASK );
					ClassUtils.IMerge.merge( aEXCEPTION.getORDER(), fromASK.getRspBody() );
				}
			}
			finally{
				
			}
			return fromASK;
		}
		
		/**
		 * 将方法调用转行为全局事务(不带服务交易流水)
		 * @param fromImpl 接口类
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static MBeanDelegate _wrap( Object fromImpl ) throws SFException, Exception{
			MBeanDelegate fromMBean = null;
			try
			{
				fromMBean = new MBeanDelegate( fromImpl );
				fromMBean.setORDER_ID  ( 0l                                               );
				fromMBean.setREPOSITORY( IUpdcConst.IUpdbm.IUpdcDAO                       );
				fromMBean.setCHANNEL   ( IUpdcConst.IEnum.SYSTEM                          );
				fromMBean.setCREATE    ( BasicFactory.getIBaseSV().getSysdate          () );
				fromMBean.setCREATOR   ( TimeUtils.addSecond( fromMBean.getCREATE(), 10 ) );
				SFCenterOffer _centeroffer = SFCenterFactory.getCenterBlank();
				if( _centeroffer != null ){
					fromMBean.setREGION_ID( _centeroffer.getREGION_ID           () );
					fromMBean.setORDER_ID ( UpdcFactory.getIUpdcSV().getORDER_ID() );
				}
			}
			finally{
				
			}
			return fromMBean;
		}
		/**
		 * 将方法调用转行为全局事务(带服务交易流水)
		 * @param fromImpl 接口类
		 * @param fromMethod 方法名
		 * @param fromArray 形参参数
		 * @return
		 * @throws Exception
		 */
		public static MBeanDelegate _wrap( Object fromImpl, java.lang.reflect.Method fromMethod, Object[] fromArray) throws Exception{
			MBeanDelegate fromMBean = null;
			try
			{
				fromMBean = ICustom._wrap( fromImpl );
				SFCenterOffer _centeroffer = SFCenterFactory.getCenterBlank();
				if( _centeroffer != null && fromMBean.getORDER_ID() > 0 ){
					fromMBean.setREGION_ID( _centeroffer.getREGION_ID           () );
					fromMBean.setORDER_ID ( UpdcFactory.getIUpdcSV().getORDER_ID() );
				}
			}
			catch( java.lang.Exception aEXCEPPTION ){
				ExceptionFactory.throwException("IOS0010017",
						new String[] { aEXCEPPTION.getMessage() }, 
						aEXCEPPTION);
			}
			finally{
				
			}
			return fromMBean;
		}
		
		/**
		 * 
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdbmtcLife getICSTKUpdbmtc( IUpdcContext aContext )  throws SFException, Exception{
			IOVUpdbmtcLife fromINDEX = null;
			try
			{
				UpfsvcVantage.IUpdfmxDeque fromUpdbmtc = UpfsvcManager.getRocket().getBlankDeque();
				if( fromUpdbmtc != null ){
					fromINDEX = (IOVUpdbmtcLife)fromUpdbmtc.getMotion().get( IUpdcConst.ISystem.CONTROL );
					if( fromINDEX == null ){
						fromINDEX = new IOVUpdbmtcLife( 10000000l );
						fromUpdbmtc.getMotion().put( IUpdcConst.ISystem.CONTROL, fromINDEX );
					}
				}
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/**
		 * 查询表接口存储DAO类
		 * @param aPLATFORM 网元编码
		 * @return
		 * @throws Exception
		 */
		public static Class getIUpfomDAO( String aPLATFORM ){
			Class fromREPOSITORY = null;
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm[] = null;
				IPlatformTemplate.IUpffmOffer.LittleEndian fromUpffmx = null;
				fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( aPLATFORM );
				for( int index = fromUpffm.length - 1 ; fromUpffm != null && index >= 0 ; index-- ){
					if( StringUtils.isBlank( fromUpffm[index].getENDIAN().getREPOSITORY() ) == false ){
						fromUpffmx = fromUpffm[index].getENDIAN();
						break;
					}
				}
				fromREPOSITORY = fromUpffmx != null?Class.forName( fromUpffmx.getREPOSITORY() ):
					IUpdcConst.IUpdbm.IUpdcDAO;
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException( aException );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return fromREPOSITORY;
		}
		/**
		 * 查询表接口存储表类
		 * @param aPLATFORM 网元编码
		 * @return
		 * @throws Exception
		 */
		public static DataStructInterface getIUpfomDCL( String aPLATFORM ) throws Exception{
			DataStructInterface fromPersiste = null;
			try
			{
				String aPERSISTENT = null;
				IPlatformTemplate.IUpffmOffer fromUpfm[] = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( aPLATFORM );
				for( int index = 0 ; fromUpfm != null && index < fromUpfm.length; index++ ){
					aPERSISTENT = fromUpfm[index].getENDIAN().getPERSISTENT();
					if( StringUtils.isBlank( aPERSISTENT ) == false ){
						fromPersiste = (DataStructInterface)ReflectUtils.IReflect.invokeConstructor(
								Class.forName( aPERSISTENT ), new Object[]{});
						break;
					}
				}
				if( fromPersiste == null ) ExceptionFactory.throwException( "IOS0011012" , new String[]{ aPLATFORM } );
			}
			finally{
				
			}
			return fromPersiste;
		}
		/**
		 * 查询二级网元系统存储仓库规范
		 * @param fromUpfm 网元信息
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String getICSTKDepot( IPlatformTemplate.IUpffmOffer fromUpfm ) throws SFException,Exception{
			IPlatformTemplate.IUpffmOffer.LittleEndian fromUpffmx = null;
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpffm[] = null;
				fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( fromUpfm.getID() );
				for( int index = fromUpffm.length - 1 ; fromUpffm != null && index >= 0 ; index-- ){
					if( StringUtils.isBlank( fromUpffm[index].getENDIAN().getCOMPOSITE() ) == false ){
						fromUpffmx = fromUpffm[index].getENDIAN();
						break;
					}
				}
			}
			finally{
				
			}
			return fromUpffmx != null?fromUpffmx.getCOMPOSITE():null;
		}
		
		/**
		 * 根据配置最大字计数分组属性列表
		 * @param fromOffer
		 * @param aSymbol
		 * @return
		 */
		public static String[] substringAsL( java.util.Map fromOffer , String aSymbol ){
			java.util.List fromASK = new java.util.ArrayList();
			try
			{
				long aReadByte = 0 ,aMaxByte = ISystem.getSFMaxBytes();
				StringBuilder fromAsL = new StringBuilder();
				if( StringUtils.isBlank( aSymbol ) ) aSymbol = ";";
				for( java.util.Iterator itera = fromOffer.entrySet().iterator(); itera.hasNext(); ) {
		        	java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
		        	StringBuilder aFEATURE = new StringBuilder();
		        	aFEATURE.append( fromEntry.getKey() ).append( "=" ).append( fromEntry.getValue() );
		        	aReadByte += aFEATURE.toString().getBytes().length + 1 ;
			        if (aReadByte > aMaxByte) {
			        	fromASK.add( fromAsL.toString() );
			        	fromAsL = new StringBuilder();
			        	aReadByte = 0;
			        }
			        else if (fromAsL.toString().length() > 0) {
			        	fromAsL.append( aSymbol );
			        }
			        fromAsL.append( aFEATURE.toString() );
		        }
				if( fromAsL.toString().length() > 0 ) fromASK.add( fromAsL.toString() );
			}
			catch( java.lang.Exception tt ){
				throw new java.lang.RuntimeException( tt );
			}
			finally{
				
			}
			return (String[])fromASK.toArray( new String[]{} );
		}
		/**
		 * 根据配置最大字计数分组报文列表
		 * @param fromOffer
		 * @return
		 */
		public static String[] substringAsL( String fromOffer ){
			String fromAsL[] = null;
			try
			{
				long fromMaxBytes = ISystem.getSFMaxBytes();
				fromAsL = StringUtils.substringAsL( fromOffer, (int)fromMaxBytes );
			}
			catch( java.lang.Exception aEXCEPTION ){
				throw new java.lang.RuntimeException( aEXCEPTION );
			}
			finally{
				
			}
			return fromAsL;
		}
		/**
		 * 
		 * @param aCfgTfCode
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static CfgTf getISTKCfgTf( String aCfgTfCode ) throws SFException,Exception{
			return com.asiainfo.appframe.ext.exeframe.tf.config.CfgQuery.getCfgTfByCode( aCfgTfCode );
		}
		
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2012-9-19</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public static class IICustom{
			public IICustom(){
				super();
			}
			/**
			 * 将服务反馈应答集转换正值表达式所需变量
			 * @param fromTASK 服务定单
			 * @param fromASK 服务应答集
			 * @param fromJEVAL 表达式变量
			 */
			public static void wrap( Object fromTASK, IOVUpfwmResponse fromASK, java.util.Map fromJEVAL){
				try
				{
					ClassUtils.IMerge.merge(new Object[][]{
							{IUpdcConst.IUpfwm.PLWK_CODING   , fromASK.getRspCode()  },
							{IUpdcConst.IUpfwm.PLWK_DESCRIBE , fromASK.getRspDesc()  },
							{IUpdcConst.IUpfwm.PLWK_ORIGING  , fromASK.getRspHome()  }}, 
							fromJEVAL, 
							false);
				}
				finally{
					
				}
			}
			/**
			 * 将异常类型转换正值表达式所需变量
			 * @param fromTASK 服务定单
			 * @param aEXCEPTION 异常类型
			 * @param fromJEVAL 表达式变量
			 */
			public static void wrap( Object fromTASK, SFException aEXCEPTION, java.util.Map fromJEVAL){
				try
				{
					java.util.Map aPLWK_EXCEPTION = new java.util.HashMap();
					fromJEVAL.put( IUpdcConst.IUpfwm.PLWK_EXCEPTION, aPLWK_EXCEPTION );
					ClassUtils.IMerge.merge(new Object[][]{
							{IUpdcConst.IUpfwm.PLWK_CODING  , aEXCEPTION.getFaultCode ()},
							{IUpdcConst.IUpfwm.PLWK_DESCRIBE, aEXCEPTION.getMessage   ()},
							{IUpdcConst.IUpfwm.PLWK_ORIGING , aEXCEPTION.getOriginator()}}, 
							aPLWK_EXCEPTION, 
							false);
				}
				finally{
					
				}
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2012-3-16</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ISystem{
		public ISystem(){
			super();
		}
		/**
		 * 初始化即开即通环境
		 * @param fromRuntime
		 * @throws SFException
		 * @throws Exception
		 */
		public static void initialize( IConfigDefine fromRuntime ) throws SFException,Exception{
			try
			{
				ClassUtils.IClass.environ("log4j.properties");
				IUpfvmsSTKLocal.getINSTANCE().finishIEnviron( fromRuntime.getConfigItem().getVELOCITY() );
				IModuleDefine.IModuleIDefine.IInitalizeDefine[] fromInitalize = fromRuntime.getInitalize();
	    		for( int index = 0 ; fromInitalize != null && index < fromInitalize.length; index++ ){
	    			if( StringUtils.isBlank( fromInitalize[index].getCLASS() ) ) continue;
	    			IUpdcLifeCycle fromLifeCycle = (IUpdcLifeCycle)Class.forName(fromInitalize[index].getCLASS()).newInstance();
	    			fromLifeCycle.initalize( fromInitalize[index] );
	    		}
	    		if( log.isDebugEnabled() ) log.debug("initializate configuration [ISystem::Initialize] successfully");
			}
			finally{
				
			}
		}
		
		/**
		 * 查询数据库表中最大字符串字节数
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static long getSFMaxBytes() throws SFException,Exception{
			long fromMaxByte = 2000;
			try
			{
				ISystemTemplate.IStaticOffer fromStatic = null;
				fromStatic = IUpdcfgFactory.getIBasicSV().getSFStaticBytes();
				if( fromStatic != null ) fromMaxByte = Long.parseLong( fromStatic.getVALUE());
			}
			finally{
				
			}
			return fromMaxByte;
		}
		
		/**
		 * 
		 *
		 */
		public static void freeEnviron (){
			try
			{
				BaseProxyCreate.getINSTANCE().finalizeService();
			}
			catch( java.lang.Exception tt){
				log.error( tt.getMessage() , tt );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _category_
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IStaticCategory getSFStaticCategory( String _category_ ) throws SFException,Exception{
			ISystemTemplate.IStaticCategory ___category__ = null;
			try
			{
				___category__ = IUpdcfgFactory.getIBasicSV().getSFStaticCategory( _category_ );
			}
			finally{
				
			}
			return ___category__;
		}
		
		/**
		 * 
		 * @param _group_
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IStaticGroup getSFStaticGroup( String _group_ ) throws SFException,Exception{
			ISystemTemplate.IStaticGroup __group__ = null;
			try
			{
				__group__ = IUpdcfgFactory.getIBasicSV().getSFStaticGroup( _group_ );
			}
			finally{
				
			}
			return __group__;
		}
		
		/**
		 * 
		 * @param aIMPLCLASS
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IImplCapital getSFUpfgkmCapital( String aIMPLCLASS ) throws SFException,Exception{
			ISystemTemplate.IImplCapital fromJAVA = null;
			try
			{
				fromJAVA = IUpdcfgFactory.getIBasicSV().getSFUpfgkmLibrary( aIMPLCLASS );
			}
			finally{
				
			}
			return fromJAVA;
		}
		
		/**
		 * 根据地市编码获取地市并行割接规范
		 * @param _originator 发起方类型
		 * @param _region_id 地市编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpfgkmParallel getSFUpfgkmParallel( String _originator, 
				String _region_id ) throws SFException,Exception{
			ISystemTemplate.IUpfgkmParallel fromParallel = null;
			try
			{
				fromParallel = IUpdcfgFactory.getIBasicSV().getSFUpfgkmParallel( _originator, _region_id );
			}
			finally{
				
			}
			return fromParallel;
		}
		
		/**
		 * 
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IImplCapital getSFUpfgkmLibrary( IUpfgkmOfferHome fromUpdcpm  ) throws SFException,Exception{
			ISystemTemplate.IImplCapital fromLibrary = null;
			try
			{
				IProfessionalTemplate.IBusinesOffer fromBusines = null;
				if( fromUpdcpm != null ){ fromBusines = fromUpdcpm.getCATALOG().getBUSINES(); }
				if( fromBusines != null ){
					fromLibrary = IUpdcfgFactory.getIBasicSV().getSFUpfgkmLibrary( fromBusines.getIMPLCLASS() );
				}
			}
			finally{
				
			}
			return fromLibrary;
		}
		
		/**
		 * 
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffmOffer getSFUpfgkmNetWork( IUpfgkmOfferHome fromUpdcpm  ) throws SFException,Exception{
			IPlatformTemplate.IUpffmOffer fromNetWork = null;
			try
			{
				ISystemTemplate.IImplCapital fromLibrary = ISystem.getSFUpfgkmLibrary( fromUpdcpm );
				if( fromLibrary != null ){ 
					fromNetWork = CenterUtils.ICustom.getSFCenterNetWork( fromLibrary.getIMPLCLASS() ); 
				}
				else{
					fromNetWork = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer();
				}
			}
			finally{
				
			}
			return fromNetWork;
		}
		
		/**
		 * 获取默认业务级优先级规范
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpdbfsLimite getSFUpffmxOffer() throws SFException,Exception{
			ISystemTemplate.IUpdbfsLimite fromLimite = null;
			try
			{
				ISystemTemplate.IUpdbfsGroup fromGroup = null;
				fromGroup = IUpdcfgFactory.getIBasicSV().getSFUpffmxOffer();
				if( fromGroup != null ){ fromLimite = fromGroup.getSUBFLOW(); }
			}
			finally{
				
			}
			return fromLimite;
		}
		
		/**
		 * 获取默认系统级时限规范
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpdbfsLimite getSFUpffmxLimite() throws SFException,Exception{
			ISystemTemplate.IUpdbfsLimite fromUpffmx = null;
			try
			{
				ISystemTemplate.IUpdbfsGroup fromGroup = null;
				fromGroup = IUpdcfgFactory.getIBasicSV().getSFUpffmxOffer();
				if( fromGroup != null ){ fromUpffmx = fromGroup.getLMXFLOW(); }
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
		/**
		 * 根据业务优先级获取服务开通优先级规范
		 * @param aPRIORITY 业务优先级编号
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer( long aPRIORITY ) throws SFException,Exception{
			ISystemTemplate.IUpdbfsGroup fromGroup = null;
			try
			{
				fromGroup = IUpdcfgFactory.getIBasicSV().getSFUpffmxOffer( aPRIORITY );
			}
			finally{
				
			}
			return fromGroup;
		}
		
		/**
		 * 根据业务优先级获取网元优先级规范
		 * @param aPRIORITY 业务优先级编号
		 * @param aPLATFORM 归属网元编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer( long aPRIORITY, 
				String aPLATFORM ) throws SFException,Exception{
			ISystemTemplate.IUpdbfsGroup fromGroup = null;
			try
			{
				fromGroup = IUpdcfgFactory.getIBasicSV().getSFUpffmxOffer( aPRIORITY, aPLATFORM );
			}
			finally{
				
			}
			return fromGroup;
		}
		
		/**
		 * 获取开通所有缓存配置路由
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Cache[] getSFUpfgkmCache() throws SFException,Exception{
			Cache _cache_[] = null;
			try
			{
				_cache_ = XMLHelper.getInstance().getCaches().getCaches();
			}
			finally{
				
			}
			return _cache_;
		}
		
		/**
		 * 根据缓存实体查询开通缓存配置路由 
		 * @param _cache 缓存实体
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Cache getSFUpfgkmCache( ICache _cache ) throws SFException,Exception{
			Cache fromCache = null;
			try
			{
				Cache fromCaches[] = XMLHelper.getInstance().getCaches().getCaches();
				if( _cache != null && fromCaches != null && fromCaches.length > 0 ){
					for( int index = 0; fromCaches != null && index < fromCaches.length; index++ ){
						if( StringUtils.equals( _cache.getClass().getName(), fromCaches[index].getId() ) ){
							fromCache = fromCaches[index];
							break;
						}
					}
				}
			}
			finally{
				
			}
			return fromCache;
		}
		
		/**
		 * 根据缓存表查询开通缓存配置路由 
		 * @param _entity 缓存表
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Cache[] getSFUpfgkmCache( String _entity ) throws SFException,Exception{
			java.util.List fromCache = new java.util.ArrayList();
			try
			{
				com.ai.appframe2.complex.xml.cfg.defaults.Property _propertys[] = null;
				Cache fromCaches[] = XMLHelper.getInstance().getCaches().getCaches();
				for( int itera = 0; fromCaches != null && itera < fromCaches.length; itera++ ){
					_propertys = fromCaches[itera].getPropertys();
					for( int iterap = 0; _propertys != null && iterap < _propertys.length; iterap++ ){
						if( StringUtils.equalsIgnoreCase( _propertys[iterap].getType(), "TABLE" ) &&
								StringUtils.equalsIgnoreCase( _propertys[iterap].getName(), _entity ) ){
							fromCache.add( fromCaches[itera] );
							break;
						}
					}
				}
			}
			finally{
				
			}
			return (Cache[])fromCache.toArray( new Cache[]{} );
		}
		/**
		 * 根据资源编码查询国际资源规范
		 * @param resource 资源编码
		 * @param locale 语言类型
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpfgkmResource getSFUpfgkmResource( String resource, java.util.Locale locale ) throws SFException,Exception{
			ISystemTemplate.IUpfgkmResource fromResource = null;
			try
			{
				fromResource = IUpdcfgFactory.getIBasicSV().getSFUpfgkmResource( resource, locale.toString() );
			}
			finally{
				
			}
			return fromResource;
		}
		
		/**
		 * 
		 * @param aHttpClientCode
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static CfgHttpClient getSFUpfgkmHttp( IUpfwmDefine fromNetWork, IUpffmNetWork fromUpffm ) throws SFException,Exception{
			CfgHttpClient fromClient = null;
			try
			{
				UpfwmHttpClient.IUpfwmHttpDefine fromHttpClient = null;
				for (java.util.Iterator itera = fromNetWork.getNETWORK_().iterator(); itera.hasNext();) {
					UpfwmHttpClient.IUpfwmHttpDefine fromHttpDefine = (UpfwmHttpClient.IUpfwmHttpDefine) itera.next();
					if( fromHttpDefine != null && StringUtils.isBlank( fromHttpDefine.getURL() ) == false ){
						fromHttpClient = fromHttpDefine;
						break;
					}
				}
				if( fromHttpClient != null ){
					fromClient = IUpdcfgFactory.getIBasicSV().getHttpClient( fromHttpClient.getURL() );
				}
				if( fromClient == null ){
					ExceptionFactory.throwIllegal("IOS0011072", new String[] { fromUpffm.getID(), fromNetWork.getID_() });
				}
			}
			finally{
				
			}
			return fromClient;
		}
		
		/**
		 * 将异常类型转换为开通内部编码
		 * @param aEXCEPTION 异常类型
		 * @return
		 */
		public static IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( SFException aEXCEPTION ){
			IPlatformTemplate.IUpffmsOffer fromUpffms = null;
			try
			{
				fromUpffms = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer( aEXCEPTION.getFaultCode() );
			}
			catch( java.lang.Exception exception ){
				fromUpffms = new IPlatformTemplate.IUpffmsOffer( aEXCEPTION );
			}
			finally{
				
			}
			return fromUpffms;
		}
		
		/**
		 * 将CSF服务异常转换为开通内部编码
		 * @param _exception CSF异常
		 * @param _platform 网元编码
		 * @return
		 */
		public static IPlatformTemplate.IUpffmsOffer getSFUpfgkmRespond( CsfException _exception, String _platform ){
			IPlatformTemplate.IUpffmsOffer fromUpffmx = null;
			try
			{
				fromUpffmx = IUpdcfgFactory.getIUpffmSV().getSFUpffmsOffer(_exception, _platform);
				if( fromUpffmx == null ){
					SFException aEXCEPTION = new SFESCsfException( IUpdcConst.IUpdfx.REMOTE, new Object[]{_platform} );
					fromUpffmx = new IPlatformTemplate.IUpffmsOffer( aEXCEPTION );
				}
			}
			catch( java.lang.Exception exception ){
				SFException aEXCEPTION = new SFESCsfException( IUpdcConst.IUpdfx.REMOTE, new Object[]{_platform} );
				fromUpffmx = new IPlatformTemplate.IUpffmsOffer( aEXCEPTION );
			}
			return fromUpffmx;
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2011-11-10</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public static class IISystem{
			public IISystem(){
				super();
			}
		
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年6月6日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMagic{
		public IMagic(){
			super();
		}
		
		/**
		 * 根据开通优先级编号获取开通优先级组
		 * @param aPRIORITY 优先级编号
		 * @return
		 */
		public static String _priority( long aPRIORITY ){
			return  ClassUtils.getINDEX( new String[]{"JPI", 
					StringUtils.filling( String.valueOf( aPRIORITY ), 
							4, 
							StringUtils.RIGHT, 
							'0')} );
		}
	}
}
