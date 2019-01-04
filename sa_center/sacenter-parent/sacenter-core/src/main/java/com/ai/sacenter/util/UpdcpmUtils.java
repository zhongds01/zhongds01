package com.ai.sacenter.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.comptel.IUpdcpSystem;
import com.ai.sacenter.comptel.IUpfgsmSystem;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.IUpdcpmCapital;
import com.ai.sacenter.core.bo.SAOffer;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 组件工具</p>
 * <p>Copyright: Copyright (c) 2016年1月20日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdcpmUtils {
	private static java.util.Map _runtime_singleton = new java.util.concurrent.ConcurrentHashMap();
	public UpdcpmUtils() {
		super();
	}
	
	/**
	 * 根据服务能力编码获取服务能力规范
	 * @param aCOMPETENCE 服务能力编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProfessionalTemplate.ICompetenceBusines getCOMPETENCE( String aCOMPETENCE ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxCompete( aCOMPETENCE );
	}
	
	/**
	 * 根据组件资产编码获取组件资产规范
	 * @param aCOMPONENT 组件资产编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdfcmpOffer getCOMPONENT( String aCOMPONENT ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptOffer( aCOMPONENT );
	}
	
	/**
	 * 根据组件编码获取默认解决方案规范
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdpgmOffer getPROGRAM() throws SFException,Exception{
		IProgramTemplate.IUpdpgmOffer __PROGRAM__ = null;
		IConfigDefine.IGlobalDefine.IControlDefine __control__ = IConfigDefine.getINSTANCE().getControl();
		if( __control__ != null && StringUtils.isBlank( __control__.getPROGRAM() ) == false ){
			__PROGRAM__ = IUpdcfgFactory.getIUpdcpmSV().getSFUpdpgmOffer( __control__.getPROGRAM() );
		}
		return __PROGRAM__;
	}
	
	/**
	 * 根据组件编码获取解决方案规范
	 * @param aPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdpgmOffer getPROGRAM( String aPROGRAM ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdpgmOffer( aPROGRAM );
	}
	
	/**
	 * 根据组件编码获取服务归档组件资产
	 * @param aPROGRAM 方案编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdfcmpOffer getCOMPLETE( String aPROGRAM ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptComplete( aPROGRAM );
	}
	
	/**
	 * 根据服务流程获取阶段通知组件资产
	 * @param fromUpdbpm 服务流程
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdfcmpOffer getSUGGEST( ISystemTemplate.IUpdbpmOffer fromUpdbpm ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptSuggest( fromUpdbpm.getPROGRAM() );
	}
	
	/**
	 * 根据组件编码获取网元映射主属性组件资产
	 * @param aPROGRAM 组件编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdffsmOffer getMAPPING( String aPROGRAM ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptMapping( aPROGRAM );
	}
	
	/**
	 * 根据组件编码获取开通接入扩展组件
	 * @param aObjective 发起方
	 * @param fromUpdcpm 开通接入能力
	 * @param aPROGRAM 组件编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProfessionalTemplate.IBusinesKernel getCUSTOM( Object aObjective, 
			IUpfgkmOfferHome fromUpdcpm, 
			String aPROGRAM ) throws SFException,Exception{
		IProfessionalTemplate.IBusinesKernel fromKernel = null;
		try
		{
			IProfessionalTemplate.IBusinesCombine fromCombine = null;
			if( fromUpdcpm != null ){ fromCombine = fromUpdcpm.getCATALOG().getPROGRAM(); }
			if( fromCombine != null ){ fromKernel = fromCombine.getPROGRAM( aPROGRAM ); } 
		}
		finally{
			
		}
		return fromKernel;
	}
	
	/**
	 * 获取服务能力产品结构
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static HQSQLTable getCOMPOSITE() throws SFException,Exception{
		return HQSQLUtils.getCheckSum( SAOffer.S_TYPE );
	}
	
	/**
	 * 根据组件编码获取网元映射次属性组件资产
	 * @param aPROGRAM 组件编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdffsmOffer getCOMPOSITE( String aPROGRAM ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptComposite( aPROGRAM );
	}
	
	/**
	 * 根据默认组件编码获取默认到期组件资产
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdfcwmOffer getEXPIRE() throws SFException,Exception{
		IProgramTemplate.IUpdfcwmOffer __EXPIRE__ = null;
		IProgramTemplate.IUpdpgmOffer __PROGRAM__ = UpdcpmUtils.getPROGRAM();
		if( __PROGRAM__ != null && __PROGRAM__.getEXPIRE() != null ){
			__EXPIRE__ = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptExpire( __PROGRAM__.getID() );
		}
		return __EXPIRE__;
	}
	
	/**
	 * 根据组件编码获取到期组件资产
	 * @param aPROGRAM 组件编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdfcwmOffer getEXPIRE( String aPROGRAM ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptExpire( aPROGRAM );
	}
	
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 根据发起方构造解决组件实体
		 * @param _objective 发起方
		 * @param aEXCEPTION 服务异常
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( Object _objective, SFException aEXCEPTION ) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				IPlatformTemplate.IUpffmsOffer __respond__ = null;
				fromUpdcpm = new IOVUpdcpmOffer( _objective, aEXCEPTION );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE, _objective );
				if( aEXCEPTION != null ){
					SystemUtils.ICustom.IICustom.wrap( _objective, aEXCEPTION, fromUpdcpm.getSUBFLOW() );
					__respond__ = SystemUtils.ISystem.getSFUpffmsOffer( aEXCEPTION );
					fromUpdcpm.getPROGRAM().setRESPOND( __respond__ );
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据发起方构造解决组件实体
		 * @param _objective 发起方
		 * @param fromUpdcmpt 解决组件
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( Object _objective, IProgramTemplate.IUpdfcmpOffer fromUpdcmpt ) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = new IOVUpdcpmOffer( _objective );
				fromUpdcpm.getPROGRAM().setCOMPONENT( fromUpdcmpt );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE, _objective );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据发起方构造解决组件实体
		 * @param _objective 发起方
		 * @param fromUpdcmpt 解决组件
		 * @param aEXCEPTION 服务异常
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( Object _objective, IProgramTemplate.IUpdfcmpOffer fromUpdcmpt, SFException aEXCEPTION ) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = ICustom.wrap( _objective, aEXCEPTION );
				fromUpdcpm.getPROGRAM().setCOMPONENT( fromUpdcmpt );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据发起方构造解决组件实体
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdcmpt 解决组件
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( IOVOrderPentium fromOrder, IOVTaskPentium fromTASK, IProgramTemplate.IUpdfcmpOffer fromUpdcmpt ) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				IOVOfferPentium.IOfferMBeanHome fromOfferHome = null;
				fromUpdcpm = ICustom.wrap( fromTASK, fromUpdcmpt );
				fromOfferHome = fromTASK.getORDER().getOFFER().getORDER();
				ISystemTemplate.IUpdbpmOffer fromUpdbpm = fromTASK.getORDER().getSUBFLOW();
				fromUpdcpm.getPROGRAM().setPROGRAM( UpdcpmUtils.getPROGRAM( fromUpdbpm.getPROGRAM() ) );
				ClassUtils.IMerge.merge( fromOfferHome.getOFFER(), fromUpdcpm.getSUBFLOW() );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.ORDER, fromOrder     );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.TASK , fromTASK      );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据发起方构造解决组件实体
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdcmpt 解决组件
		 * @param aEXCEPTION 服务异常
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				IProgramTemplate.IUpdfcmpOffer fromUpdcmpt,
				SFException aEXCEPTION ) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = ICustom.wrap( fromTASK, fromUpdcmpt, aEXCEPTION );
				IOVOfferPentium fromOffer = fromTASK.getORDER().getOFFER();
				ISystemTemplate.IUpdbpmOffer fromUpdbpm = fromTASK.getORDER().getSUBFLOW();
				fromUpdcpm.getPROGRAM().setPROGRAM( UpdcpmUtils.getPROGRAM( fromUpdbpm.getPROGRAM() ) );
				ClassUtils.IMerge.merge( fromOffer.getORDER().getOFFER(), fromUpdcpm.getSUBFLOW() );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.ORDER, fromOrder     );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.TASK , fromTASK      );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据发起方构造解决组件实体
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdcmpt 解决组件
		 * @param fromNetWork 网元反馈
		 * @param aEXCEPTION 服务异常
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpmOffer wrap( IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				IProgramTemplate.IUpdfcmpOffer fromUpdcmpt,
				IOVUpfwmResponse fromNetWork,
				SFException aEXCEPTION ) throws SFException,Exception{
			IOVUpdcpmOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = ICustom.wrap( fromTASK, fromUpdcmpt, aEXCEPTION );
				IOVOfferPentium fromOffer = fromTASK.getORDER().getOFFER();
				ISystemTemplate.IUpdbpmOffer fromUpdbpm = fromTASK.getORDER().getSUBFLOW();
				fromUpdcpm.getPROGRAM().setPROGRAM( UpdcpmUtils.getPROGRAM( fromUpdbpm.getPROGRAM() ) );
				ClassUtils.IMerge.merge( fromOffer.getORDER().getOFFER(), fromUpdcpm.getSUBFLOW() );
				SystemUtils.ICustom.wrap( fromTASK, null, fromNetWork, aEXCEPTION, fromUpdcpm.getSUBFLOW() );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.ORDER, fromOrder     );
				fromUpdcpm.getSUBFLOW().put( IUpdcConst.IUpdbm.IUpdbf.TASK , fromTASK      );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * 
		 * @param aIMPLCLASS
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object getSingleton( String aIMPLCLASS ) throws SFException,Exception{
			Object fromUpfgsmImpl = null;
			try
			{
				fromUpfgsmImpl = _runtime_singleton.get( aIMPLCLASS );
				if( (fromUpfgsmImpl = _runtime_singleton.get( aIMPLCLASS )) == null ){
					synchronized( _runtime_singleton ){
						if( (fromUpfgsmImpl = _runtime_singleton.get( aIMPLCLASS )) == null ){
							ISystemTemplate.IImplCapital fromJAVA = null;
							fromJAVA = SystemUtils.ISystem.getSFUpfgkmCapital( aIMPLCLASS );
							_runtime_singleton.put( fromJAVA.getID(), fromUpfgsmImpl = 
									Class.forName( fromJAVA.getIMPLCLASS() ).newInstance() );
						}
					}
				}
			}
			finally{
				
			}
			return fromUpfgsmImpl;
		}
		
		/**
		 * 服务能力级映射规范
		 * @param aIMPLCLASS 服务能力编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IUpdcpSystem getIUpdcpSV( String aIMPLCLASS ) throws SFException,Exception{
			return (IUpdcpSystem)ISystem.getSingleton( aIMPLCLASS ); 
		}
		
		/**
		 * 服务激活级映射规范
		 * @param aIMPLCLASS 网元映射编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IUpfgsmSystem getIUpffxmSV( String aIMPLCLASS ) throws SFException,Exception{
			return (IUpfgsmSystem)ISystem.getSingleton( aIMPLCLASS ); 
		}
		
		/**
		 * 网元级映射规范
		 * @param aIMPLCLASS 网元映射编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IUpfgsmSystem getIUpfgsmSV( String aIMPLCLASS ) throws SFException,Exception{
			return (IUpfgsmSystem)ISystem.getSingleton( aIMPLCLASS ); 
		}
		
		/**
		 * 根据组件资产执行组件资产任务
		 * @param aPROGRAM 组件资产
		 * @param parameter
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_program( final IOVUpdcpmOffer aPROGRAM, 
				final Object parameter[]) throws SFException,Exception{
			Object _objective = null;
			try
			{
				ISystemTemplate.ISystemNative fromNative = null;
				IOVUpdcpmOffer.IUpdcpmHome frommUpdcpmHome = aPROGRAM.getPROGRAM();
				ISystemTemplate.IImplCapital _capital = frommUpdcpmHome.getIMPLCLASS();
				fromNative = ReflectUtils.getNative( ReflectUtils.IReflect.getCLASS( _capital.getIMPLCLASS() ) );
				java.lang.reflect.Method fromMethod = fromNative.getMethod( _capital.getMETHOD(), parameter );
				if( fromMethod == null ){
					throw new NoSuchMethodException( "component <" + frommUpdcpmHome.getPROGRAM().getID() + 
							"> No such accessible method <" + _capital.getMETHOD() + 
							"> on object " + fromNative.getType().getName() + "." );
				}
				IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( _capital.getIMPLCLASS() );
				_objective = fromMethod.invoke( fromUpdcpmImpl, parameter );
			}
			finally{
				
			}
			return _objective;
		}
		
		/**
		 * 根据组件资产执行组件资产任务
		 * @param aPROGRAM 组件资产
		 * @param parameter
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_program( final IProgramTemplate.IUpdfcmpOffer aPROGRAM, 
				final Object parameter[]) throws SFException,Exception{
			Object _objective = null;
			try
			{
				ISystemTemplate.ISystemNative fromNative = null;
				ISystemTemplate.IImplCapital _capital = SystemUtils.ISystem.getSFUpfgkmCapital( aPROGRAM.getIMPLCLASS() );
				fromNative = ReflectUtils.getNative( ReflectUtils.IReflect.getCLASS( _capital.getIMPLCLASS() ) );
				java.lang.reflect.Method fromMethod = fromNative.getMethod( _capital.getMETHOD(), parameter );
				if( fromMethod == null ){
					throw new NoSuchMethodException( "component <" + aPROGRAM.getID() + 
							"> No such accessible method <" + _capital.getMETHOD() + 
							"> on object " + fromNative.getType().getName() + "." );
				}
				IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( _capital.getIMPLCLASS() );
				_objective = fromMethod.invoke( fromUpdcpmImpl, parameter );
			}
			finally{
				
			}
			return _objective;
		}
		
		/**
		 * 根据组件资产执行组件资产任务
		 * @param aPROGRAM 组件资产
		 * @param parameter 
		 * @param parameterTypes
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_program( final IOVUpdcpmOffer aPROGRAM, 
				final Object parameter[], 
				final Class parameterTypes[]) throws SFException,Exception{
			Object _objective = null;
			try
			{
				ISystemTemplate.ISystemNative fromNative = null;
				IOVUpdcpmOffer.IUpdcpmHome frommUpdcpmHome = aPROGRAM.getPROGRAM();
				ISystemTemplate.IImplCapital _capital = frommUpdcpmHome.getIMPLCLASS();
				fromNative = ReflectUtils.getNative( ReflectUtils.IReflect.getCLASS( _capital.getIMPLCLASS() ) );
				java.lang.reflect.Method fromMethod = fromNative.getMethod( _capital.getMETHOD(), parameterTypes );
				if( fromMethod == null ){
					throw new NoSuchMethodException( "component <" + aPROGRAM.getPROGRAM().getCOMPONENT().getID() + 
							"> No such accessible method <" + _capital.getMETHOD() + 
							"> on object " + fromNative.getType().getName() + "." );
				}
				IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( _capital.getIMPLCLASS() );
				_objective = fromMethod.invoke( fromUpdcpmImpl, parameter );
			}
			finally{
				
			}
			return _objective;
		}
		
		/**
		 * 根据组件资产执行组件资产任务
		 * @param aPROGRAM 组件资产
		 * @param parameter 
		 * @param parameterTypes
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _jj_program( final IProgramTemplate.IUpdfcmpOffer aPROGRAM, 
				final Object parameter[], 
				final Class parameterTypes[]) throws SFException,Exception{
			Object _objective = null;
			try
			{
				ISystemTemplate.ISystemNative fromNative = null;
				ISystemTemplate.IImplCapital _capital = SystemUtils.ISystem.getSFUpfgkmCapital( aPROGRAM.getIMPLCLASS() );
				fromNative = ReflectUtils.getNative( ReflectUtils.IReflect.getCLASS( _capital.getIMPLCLASS() ) );
				java.lang.reflect.Method fromMethod = fromNative.getMethod( _capital.getMETHOD(), parameterTypes );
				if( fromMethod == null ){
					throw new NoSuchMethodException( "component <" + aPROGRAM.getID() + 
							"> No such accessible method <" + _capital.getMETHOD() + 
							"> on object " + fromNative.getType().getName() + "." );
				}
				IUpdcpmCapital fromUpdcpmImpl = IUpdcFactory.getIUpdcpmSV( _capital.getIMPLCLASS() );
				_objective = fromMethod.invoke( fromUpdcpmImpl, parameter );
			}
			finally{
				
			}
			return _objective;
		}
	}
}
