package com.ai.sacenter.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbpmOffer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFRemoteException;
import com.ai.sacenter.i18n.SFRsRspException;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ���񼤻������</p>
 * <p>Copyright: Copyright (c) 2015-2-5</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdbpmUtils {
	public UpdbpmUtils() {
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * ���ݵ�ǰ�������̹���������̼���������
		 * @param fromOrder ���񶨵�
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdbpmOffer _wrap( IOVOrderPentium fromOrder,
				IUpdcContext aContext ) throws SFException, Exception{
			IOVUpdbpmOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = new IOVUpdbpmOffer( fromOrder );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * ���ݵ�ǰ�������̹���������̼���������
		 * @param fromOrder ���񶨵�
		 * @param fromOffer ���񶩹�
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdbpmOffer _wrap( IOVOrderPentium fromOrder,
				IOVOfferPentium fromOffer,
				IUpdcContext aContext ) throws SFException, Exception{
			IOVUpdbpmOffer fromUpdcpm = null;
			java.util.Map fromUpdfmx = null;
			try
			{
				fromUpdcpm = ICustom._wrap(fromOrder, aContext);
				fromUpdfmx = IUpdcFactory.getITaskSV().getSFTaskOffer( fromOrder );
				IOVUpdbpmOffer.IUpdbmHome fromUpdbpmHome = fromUpdcpm.getSUBFLOW();
				ClassUtils.IMerge.merge( fromUpdfmx, fromUpdbpmHome.getSUBFLOW() );
				fromUpdcpm.getSUBFLOW().mergeAsOffer( fromOffer );
			}
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx.clear(); fromUpdfmx = null; }
			}
			return fromUpdcpm;
		}
		
		/**
		 * ���ݵ�ǰ�������̹���������̼���������
		 * @param fromOrder ���񶨵�
		 * @param fromUpdbm ��������
		 * @param fromUpdspm �������̼�
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdbpmOffer _wrap( IOVOrderPentium fromOrder,
				ISystemTemplate.IUpdbpmOffer fromUpdbm,
				IOVUpdbpmOffer fromUpdspm,
				IUpdcContext aContext ) throws SFException, Exception{
			IOVUpdbpmOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = ICustom._wrap(fromOrder, aContext);
				IOVUpdbpmOffer.IUpdbmHome fromUpdcpmHome = fromUpdcpm.getSUBFLOW();
				IOVUpdbpmOffer.IUpdbmHome fromUpdspmHome = fromUpdspm.getSUBFLOW();
				fromUpdcpm.getSUBFLOW().mergeAsOffer( fromUpdspmHome.getOFFER() );
				ClassUtils.IMerge.merge( fromUpdspmHome.getSUBFLOW(), fromUpdcpmHome.getSUBFLOW() );
				if( StringUtils.isBlank( fromUpdbm.getCOMPLEX() ) == false ){
					IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromUpdbm.getCOMPLEX(), 
							fromUpdcpm.getSUBFLOW().getSUBFLOW(), 
							fromUpdcpm.getSUBFLOW().getEXTEND(), 
							aContext);
				}
				ClassUtils.IMerge.merge( fromUpdcpmHome.getEXTEND() , fromUpdcpmHome.getSUBFLOW() );
			}
			finally{
			
			}
			return fromUpdcpm;
		}
		
		/**
		 * ���ݵ�ǰ�������̹���������̼���������
		 * @param fromOrder ���񶨵�
		 * @param fromTask  ��������
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdbpmOffer _wrap( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException, Exception{
			IOVUpdbpmOffer fromUpdcpm = null;
			try
			{
				IOVTaskPentium.ITaskOfferHome fromOfferHome = fromTASK.getORDER();
				fromUpdcpm = ICustom._wrap(fromOrder, fromOfferHome.getOFFER(), aContext);
				IOVUpdbpmOffer.IUpdbmHome fromUpdbpmHome = fromUpdcpm.getSUBFLOW();
				ClassUtils.IMerge.merge( fromOfferHome.getPARAM(), fromUpdbpmHome.getSUBFLOW(), true );
				SystemUtils.ICustom.IICustom.wrap( fromTASK, aEXCEPTION, fromUpdbpmHome.getSUBFLOW() );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromOffice
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdbpmOffice _wrap( IOVOrderPentium fromOrder, IOVUpdbpmOffice fromOffice ) throws SFException,Exception{
			try
			{
				if( fromOffice == null ){ fromOffice = new IOVUpdbpmOffice( fromOrder ); }
				fromOffice.getSUBFLOW().setUSER_ID        ( fromOrder.getUSER_ID         () );
				fromOffice.getSUBFLOW().setBILL_ID        ( fromOrder.getBILL_ID         () );
				fromOffice.getSUBFLOW().setSUB_BILL_ID    ( fromOrder.getSUB_BILL_ID     () );
				fromOffice.getSUBFLOW().setHEADNUM        ( fromOrder.getBILL_ID         () );
				fromOffice.getSUBFLOW().setCATEGORY       ( IUpdcConst.IUpdbm.IUpdbf.MSISDN );
				fromOffice.getSUBFLOW().setUSER_REGION_ID ( fromOrder.getUSER_REGION_ID  () );
				fromOffice.getSUBFLOW().setORDER_REGION_ID( fromOrder.getORDER_REGION_ID () );
				fromOffice.getSUBFLOW().setREGION_CODE    ( fromOrder.getREGION_CODE     () );
				fromOffice.getSUBFLOW().setREGION_ID      ( fromOrder.getREGION_ID       () );
			}
			finally{
				
			}
			return fromOffice;
		}
	}

	public static class ISystem{
		public ISystem(){
			super();
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		/**
		 * �Ƿ���ں������ӳ��淶
		 * @param fromOrder ���񶨵�
		 * @param fromUpdbm �������̹淶
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isOFFICE(IOVOrderPentium fromOrder, 
				ISystemTemplate.IUpdbpmOffer fromUpdbm,
			    IUpdcContext aContext ) throws SFException,Exception{
			boolean fromOffice = false;
			try
			{
				if( StringUtils.isBlank( fromUpdbm.getCOMPLEX() ) == false ){
					IProgramTemplate.IUpdffgsmOffer fromOfficeX[] = null;
					fromOfficeX = IUpdcfgFactory.getIUpdcpmSV().getSFUpffxmOffice(fromUpdbm.getCOMPLEX());
					fromOffice = fromOfficeX != null && fromOfficeX.length > 0?true:false;
				}
			}
			finally{
				
			}
			return fromOffice;
		}
		/**
		 * ���ݷ�������ƥ������ѯ��ǰ����������ģ��
		 * @param fromOrder ���񶨵�
		 * @param fromUpdbm ��������
		 * @param fromUpdbmOffer �������̶���
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IUpdbpmOffer getSUBFLOW(IOVOrderPentium fromOrder, 
				ISystemTemplate.IUpdbpmOffer fromUpdbm,
			    IOVUpdbpmOffer fromUpdcpm,
			    IUpdcContext aContext) throws SFException, Exception{
			IProfessionalTemplate.IUpdbpmOffer fromUpdbpm = null;
			try
			{
				if( StringUtils.isBlank( fromUpdbm.getJEVAL() ) == false ){
					String aSUBFLOW = UpdcpUtils.IUpfvn.evaluate( fromUpdbm.getJEVAL(), 
							fromUpdcpm.getSUBFLOW().getSUBFLOW(), 
							aContext );
					if( StringUtils.isBlank( aSUBFLOW ) == false ){
						fromUpdbpm = IUpdcFactory.getIUpdbpmSV().getSFUpdbmBpel( aSUBFLOW );
					}
				}
			}
			catch( java.lang.Exception aEXCEPTION ){
				ExceptionFactory.throwJeval("IOS0011083", new String[]{fromUpdbm.getSUBFLOW(), fromUpdbm.getID(), 
						aEXCEPTION.getMessage() } );
			}
			finally{
				
			}
			return fromUpdbpm;
		}
		/**
		 * �ж��Ƿ���������������
		 * @param fromOrder ���񶩵�
		 * @param fromUpdbm �������̹淶
		 * @param fromUpdcpm
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isSUBFLOW(IOVOrderPentium fromOrder,
				ISystemTemplate.IUpdbpmOffer fromUpdbm, 
				IOVUpdbpmOffer fromUpdcpm,
			    IUpdcContext aContext ) throws SFException,Exception{
			boolean fromEnable = true;
			try
			{
				if( StringUtils.isBlank( fromUpdbm.getJEVAL() ) == false ){
					fromEnable = UpdcpUtils.IUpfvn.decision( fromUpdbm.getJEVAL(), 
							fromUpdcpm.getSUBFLOW().getSUBFLOW(), 
							aContext );
				}
			}
			catch( java.lang.Exception aEXCEPTION ){
				ExceptionFactory.throwJeval("IOS0011083", new String[]{fromUpdbm.getSUBFLOW(), 
						fromUpdbm.getID(), aEXCEPTION.getMessage() } );
			}
			finally{
				
			}
			return fromEnable;
		}
		/**
		 * �ж��Ƿ�������ָ��������
		 * @param fromTASK ��������
		 * @param fromUpdbm �������̹淶
		 * @param fromOffer ��������
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isCHILDREN( Object fromTASK, 
				ISystemTemplate.IUpdbpmOffer fromUpdbm,
				java.util.Map fromOffer,
			    IUpdcContext aContext ) throws SFException,Exception{
			boolean fromEnable = true;
			try
			{
				fromEnable = UpdcpUtils.IUpfvn.decision( fromUpdbm.getJEVAL(), 
						fromOffer, 
						aContext );
			}
			catch( java.lang.Exception aEXCEPTION ){
				ExceptionFactory.throwJeval("IOS0011082", new String[]{fromUpdbm.getSUBFLOW(), fromUpdbm.getID(), 
						aEXCEPTION.getMessage() } );
			}
			finally{
				
			}
			return fromEnable;
		}
		/**
		 * �ж����������Ƿ�����������Ԫָ��
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isIMMED( IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				IUpdcContext aContext) throws SFException,Exception{
			boolean fromEnable = false;
			try{
				IPeriodGraphToken fromTOKEN = null;
				fromTOKEN = fromTASK.getORDER().getTOKEN();
				fromEnable = fromTASK.isCREATE() && StringUtils.equals(fromTOKEN.getToken(),
								IPeriodGraphToken.IToken.NONE);
			}
			finally{
				
			}
			return fromEnable;
		}
		/**
		 * �ж���������Ϊͬ��ָ��
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @param fromUpdfwm �߼�ָ�
		 * @param aContext
		 * @return
		 * @throws SFException
		 */
		public static boolean isSYNCHRONIZE( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK , 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext ) throws SFException,Exception{
			boolean aOBJECT = true;
			try
			{
				if( fromOrder.isEXCEPTION() == false/*��������*/ ){
					IOVTaskPentium.ITaskCompleteHome fromHome = fromTASK.getORDER().getCOMPLETE();
					ISystemTemplate.IUpdbpmOffer fromUpdbm = fromHome.getCOMPLETE();
					if( fromUpdbm != null && fromUpdbm.isCOMPLETE() ){
						java.util.Map fromUpfwm = UpfsvcManager.getSession().getIndexs( fromTASK );
						aOBJECT = fromUpfwm == null || fromUpfwm.size() <= 0;
					}
				}
			}
			finally{
				
			}
			return aOBJECT;
		}
		/**
		 * �Ƿ�Զ���߼��쳣
		 * @param aException
		 * @return
		 */
		public static boolean isREMOTE( java.lang.Exception aException ){
			boolean fromRemote = false;
			try
			{
				fromRemote = aException != null && aException instanceof SFRsRspException;
			}
			finally{
				
			}
			return fromRemote;
		}
		/**
		 * �Ƿ���񶨵��������쳣
		 * @param aINSTANCE ���񶨵�
		 * @param aUpdswfLife ���񶨵�����
		 * @return
		 */
		public static boolean isEXCEPTION( IOVOrderPentium aINSTANCE , IOVTaskPentium aUpdswfLife ){
			return aUpdswfLife != null && aUpdswfLife.isEXCEPTION();
		}
		/**
		 * �Ƿ���񶨵�������Ԫָ������쳣
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @param fromUpdfwm ����ָ��
		 * @param aEXCEPTION �����쳣
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isEXCEPTION(  IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				java.lang.Exception aEXCEPTION )  throws SFException,Exception{
			boolean aOBJECT = false;
			try
			{
				aEXCEPTION = ExceptionFactory.getBottom( aEXCEPTION );
				aOBJECT = IIfElse.isEXCEPTION(fromOrder, fromTASK ) || 
				              fromTASK.getDONE_TIMES() >= fromTASK.getREDO_TIMES() || 
				               aEXCEPTION instanceof SFRemoteException;
			}
			finally{
				
			}
			return aOBJECT;
		}
		/**
		 * �Ƿ���񶨵����������(�����쳣��ɺ��������)
		 * @param fromOrder ���񶨵�
		 * @return
		 */
		public static boolean isCOMPLETE( IOVOrderPentium fromOrder ){
			return StringUtils.contains( fromOrder.getSTATE() , new String[]{IUpdcConst.IState.O,
				         IUpdcConst.IState.E, IUpdcConst.IState.Q, IUpdcConst.IState.F } );
		}
		/**
		 * �Ƿ���񶨵�������������(�����쳣��ɺ��������)
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @return
		 */
		public static boolean isCOMPLETE( IOVOrderPentium fromOrder , IOVTaskPentium fromTASK ){
			return StringUtils.contains( fromTASK.getSTATE(), new String[]{IUpdcConst.IState.O,
					IUpdcConst.IState.F,IUpdcConst.IState.Q,IUpdcConst.IState.S } );
		}
		/**
		 * �ж��Ƿ���񶨵�����������
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isREPLY(IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK) throws SFException, Exception{
			boolean fromREPLY = false;
			try
			{
				IOVTaskPentium.ITaskOfferHome fromActive = fromTASK.getORDER();
				fromREPLY = fromOrder.isEXCEPTION() == false
						&& ((fromActive.getSUBFLOW() != null && fromActive
								.getSUBFLOW().isREPLY()) || fromTASK.isEXCEPTION());  
			}
			finally{
				
			}
			return fromREPLY;
		}
		/**
		 * ��ԪӦ���Ƿ�����������
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @param aEXCEPTION �쳣����
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isREPLY(IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				SFException aEXCEPTION) throws SFException, Exception{
			boolean fromREPLY = false;
			try
			{
				IOVTaskPentium.ITaskOfferHome fromActive = fromTASK.getORDER();
				fromREPLY = (fromActive.getSUBFLOW() != null && fromActive.getSUBFLOW().isREPLY() && 
						fromTASK.isCOMPENSATE() == false) && aEXCEPTION == null;
			}
			finally{
				
			}
			return fromREPLY;
		}
		/**
		 * �Ƿ���Ԫ�첽����ģʽ(�첽ģ��ͬ��,��Ԫ����ģʽ,��Ԫ�첽ģʽ)
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @param fromUpdfwm �߼�ָ�
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isREPLY(IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
		        IOVUpdspmLife fromUpdfwm,
		        IUpdcContext aContext) throws SFException, Exception{
			boolean fromREPLY = false;
			try
			{
				ISystemTemplate.IUpdbpmOffer fromUpdbm = null;
				IPlatformTemplate.IUpffmOperate fromUpfom = fromUpdfwm.getOPERATE();
				fromUpdbm = UpdcUtils.ISubFlow.getSUBFLOW(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
				fromREPLY = ( fromUpdbm.isCOMPLETE() || fromUpfom.isREPLY() 
						|| fromUpfom.isSYNCFLG() ) && fromOrder.isEXPIRE() == false ;
			}
			finally{
				
			}
			return fromREPLY;
		}
		/**
		 * ��Ԫ��������Ƿ�֧����Ԫ��������
		 * @param fromTASK ���񶨵�����
		 * @param fromUpfm ��Ԫ��Ϣ
		 * @param fromUpdfwm �߼�ָ�
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isREPLY( Object fromTASK,
				IPlatformTemplate.IUpffmOffer fromUpfm,
				IOVUpdspmLife fromUpdfwm,
			    IUpdcContext aContext) throws SFException, Exception{
			boolean fromObject = false;
			try
			{
				fromObject = fromTASK != null && fromTASK instanceof IOVTaskPentium;
				if( fromObject == true ){
					IOVOrderPentium fromOrder = UpdcUtils.ISubFlow.getORDER( aContext );
					fromObject = fromOrder.isEXCEPTION() == false && fromUpdfwm.getOPERATE().isREPLY();
				}
			}
			finally{
				
			}
			return fromObject;
		}
		/**
		 * �ж������Ƿ�Ϊ�ع����̲�����Ԫָ�������Ƿ����ڴ���
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @param fromUpdfwm �߼�ָ�
		 * @param aContext
		 * @return
		 */
		public static boolean isMEMORY( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm ,
				IUpdcContext aContext){
			boolean fromEnable = false ;
			try
			{
				if( fromOrder.isEXCEPTION() && fromUpdfwm.getPLATFORM().isTable() && 
						fromTASK.getCREATE() != null ){
					IPeriodGraphToken fromTOKEN = null;
					fromTOKEN = fromTASK.getCREATE().getORDER().getTOKEN();
					IOVTaskPentium.ITaskOfferHome fromActive = fromTASK.getORDER();
					fromEnable = fromActive.getSUBFLOW() != null && 
							fromTASK.getCREATE() != null && fromTOKEN.isTokenNone() == false;
				}
			}
			finally{
				
			}
			return fromEnable;
		}
		/**
		 * �жϻع������쳣Ϊҵ���߼��쳣
		 * @param fromOrder
		 * @param fromTASK
		 * @param aEXCEPTION
		 * @return
		 */
		public static boolean isROLLBACK(IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				java.lang.Exception aEXCEPTION){
			boolean fromObject = false;
			try
			{
				fromObject = fromOrder.isEXCEPTION() && fromTASK.isEXCEPTION();
			}
			finally{
				
			}
			return fromObject;
		}
		/**
		 * �Ƿ�Ϊ���񶨵�
		 * @param aOBJECT
		 * @return
		 */
		public static boolean isORDER( Object aOBJECT ){
			return aOBJECT != null && aOBJECT instanceof IOVOrderPentium;
		}
		/**
		 * �Ƿ�Ϊ���񶨵�����
		 * @param aUpdswfLife
		 * @return
		 */
		public static boolean isTASK( Object fromTASK ){
			return fromTASK != null && fromTASK instanceof IOVTaskPentium;
		}
		/**
		 * �Ƿ�Ϊ��Ԫ����
		 * @param fromTASK
		 * @return
		 */
		public static boolean isPROVISION( Object fromTASK ){
			return fromTASK != null && fromTASK instanceof IOVUpfwmOffer;
		}
	}
}
