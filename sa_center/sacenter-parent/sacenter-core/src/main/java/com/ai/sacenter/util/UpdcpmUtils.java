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
 * <p>Description: �������</p>
 * <p>Copyright: Copyright (c) 2016��1��20��</p>
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
	 * ���ݷ������������ȡ���������淶
	 * @param aCOMPETENCE ������������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProfessionalTemplate.ICompetenceBusines getCOMPETENCE( String aCOMPETENCE ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdbfxCompete( aCOMPETENCE );
	}
	
	/**
	 * ��������ʲ������ȡ����ʲ��淶
	 * @param aCOMPONENT ����ʲ�����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdfcmpOffer getCOMPONENT( String aCOMPONENT ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptOffer( aCOMPONENT );
	}
	
	/**
	 * ������������ȡĬ�Ͻ�������淶
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
	 * ������������ȡ��������淶
	 * @param aPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdpgmOffer getPROGRAM( String aPROGRAM ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdpgmOffer( aPROGRAM );
	}
	
	/**
	 * ������������ȡ����鵵����ʲ�
	 * @param aPROGRAM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdfcmpOffer getCOMPLETE( String aPROGRAM ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptComplete( aPROGRAM );
	}
	
	/**
	 * ���ݷ������̻�ȡ�׶�֪ͨ����ʲ�
	 * @param fromUpdbpm ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdfcmpOffer getSUGGEST( ISystemTemplate.IUpdbpmOffer fromUpdbpm ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptSuggest( fromUpdbpm.getPROGRAM() );
	}
	
	/**
	 * ������������ȡ��Ԫӳ������������ʲ�
	 * @param aPROGRAM �������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdffsmOffer getMAPPING( String aPROGRAM ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptMapping( aPROGRAM );
	}
	
	/**
	 * ������������ȡ��ͨ������չ���
	 * @param aObjective ����
	 * @param fromUpdcpm ��ͨ��������
	 * @param aPROGRAM �������
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
	 * ��ȡ����������Ʒ�ṹ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static HQSQLTable getCOMPOSITE() throws SFException,Exception{
		return HQSQLUtils.getCheckSum( SAOffer.S_TYPE );
	}
	
	/**
	 * ������������ȡ��Ԫӳ�����������ʲ�
	 * @param aPROGRAM �������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IProgramTemplate.IUpdffsmOffer getCOMPOSITE( String aPROGRAM ) throws SFException,Exception{
		return IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptComposite( aPROGRAM );
	}
	
	/**
	 * ����Ĭ����������ȡĬ�ϵ�������ʲ�
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
	 * ������������ȡ��������ʲ�
	 * @param aPROGRAM �������
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
		 * ���ݷ��𷽹��������ʵ��
		 * @param _objective ����
		 * @param aEXCEPTION �����쳣
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
		 * ���ݷ��𷽹��������ʵ��
		 * @param _objective ����
		 * @param fromUpdcmpt ������
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
		 * ���ݷ��𷽹��������ʵ��
		 * @param _objective ����
		 * @param fromUpdcmpt ������
		 * @param aEXCEPTION �����쳣
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
		 * ���ݷ��𷽹��������ʵ��
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ��������
		 * @param fromUpdcmpt ������
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
		 * ���ݷ��𷽹��������ʵ��
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ��������
		 * @param fromUpdcmpt ������
		 * @param aEXCEPTION �����쳣
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
		 * ���ݷ��𷽹��������ʵ��
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ��������
		 * @param fromUpdcmpt ������
		 * @param fromNetWork ��Ԫ����
		 * @param aEXCEPTION �����쳣
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
		 * ����������ӳ��淶
		 * @param aIMPLCLASS ������������
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IUpdcpSystem getIUpdcpSV( String aIMPLCLASS ) throws SFException,Exception{
			return (IUpdcpSystem)ISystem.getSingleton( aIMPLCLASS ); 
		}
		
		/**
		 * ���񼤻ӳ��淶
		 * @param aIMPLCLASS ��Ԫӳ�����
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IUpfgsmSystem getIUpffxmSV( String aIMPLCLASS ) throws SFException,Exception{
			return (IUpfgsmSystem)ISystem.getSingleton( aIMPLCLASS ); 
		}
		
		/**
		 * ��Ԫ��ӳ��淶
		 * @param aIMPLCLASS ��Ԫӳ�����
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IUpfgsmSystem getIUpfgsmSV( String aIMPLCLASS ) throws SFException,Exception{
			return (IUpfgsmSystem)ISystem.getSingleton( aIMPLCLASS ); 
		}
		
		/**
		 * ��������ʲ�ִ������ʲ�����
		 * @param aPROGRAM ����ʲ�
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
		 * ��������ʲ�ִ������ʲ�����
		 * @param aPROGRAM ����ʲ�
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
		 * ��������ʲ�ִ������ʲ�����
		 * @param aPROGRAM ����ʲ�
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
		 * ��������ʲ�ִ������ʲ�����
		 * @param aPROGRAM ����ʲ�
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
