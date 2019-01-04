package com.ai.sacenter.cache.redis;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.competence.bo.ISACompensation;
import com.ai.sacenter.base.competence.bo.ISAComponent;
import com.ai.sacenter.base.competence.bo.ISAComponentRel;
import com.ai.sacenter.base.competence.bo.ISADistribute;
import com.ai.sacenter.base.competence.bo.ISAException;
import com.ai.sacenter.base.competence.bo.ISAMappingX;
import com.ai.sacenter.base.competence.bo.ISAProgram;
import com.ai.sacenter.base.competence.bo.ISAProgramRel;
import com.ai.sacenter.base.competence.bo.ISARollBack;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IProgramTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务组件层[基础配置]</p>
 * <p>Copyright: Copyright (c) 2014-3-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IIComponentCacheImpl extends ISystemCacheImpl {

	public IIComponentCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromPROGRAM = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithProgram( fromPROGRAM );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromPROGRAM;
	}
	/**
	 * 结构化服务激活解决方案
	 * @param fromPROGRAM
	 * @throws SFException
	 * @throws Exception
	 */
	private void _wrapWithProgram( java.util.HashMap fromPROGRAM ) throws SFException,Exception{
		IUpdpgmCreateImpl fromUpdpgmImpl = new IUpdpgmCreateImpl();
		try
		{
			/*结构化服务激活组件*/
			_finishSFUpdcmpOffer(fromUpdpgmImpl, fromPROGRAM);
			_finishSFUpdcmpCatalog(fromUpdpgmImpl, fromPROGRAM);
			/*结构化服务激活属性组件*/
			_finishSFUpdcmpMapping(fromUpdpgmImpl, fromPROGRAM);
			/*结构化服务激活补偿组件*/
			_finishSFUpdcmpCompensa(fromUpdpgmImpl, fromPROGRAM);
			/*结构化服务激活派单组件*/
			_finishSFUpdcmpClaim(fromUpdpgmImpl, fromPROGRAM);
			/*结构化服务激活异常原因组件*/
			_finishSFUpdcmpException(fromUpdpgmImpl, fromPROGRAM);
			/*结构化服务激活解决方案*/
			_finishSFUpdpgmOffer(fromUpdpgmImpl, fromPROGRAM);
		}
		finally{
			if( fromUpdpgmImpl != null ){ fromUpdpgmImpl = null; }
		}
	}
	
	/**
	 * 结构化服务激活策略组件
	 * @param fromUpdpgmImpl
	 * @param fromPROGRAM
	 * @throws SFException
	 * @throws Exception
	 */
	private void _finishSFUpdcmpOffer(IUpdpgmCreateImpl fromUpdpgmImpl,
			java.util.Map fromPROGRAM ) throws SFException,Exception{
		java.util.List fromUpdpgm = null;
		try
		{
			fromUpdpgm = BasicFactory.getIUpdcpmSV().getIUpdcmptOffer();
			if( fromUpdpgm != null && fromUpdpgm.size() > 0 ){
				try
				{
					IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
					fromUpdpgmImpl.finishSFUpdcmptRollBack();
					for( java.util.Iterator itera = fromUpdpgm.iterator() ; itera.hasNext() ; ){
						ISAComponent aComponent = (ISAComponent)itera.next();
						fromUpdcmpt = fromUpdpgmImpl._wrap( aComponent );
						String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_COMPONENT, 
								new String[]{ fromUpdcmpt.getID() } );
						fromPROGRAM.put( fromINDEX , fromUpdcmpt );
						fromUpdpgmImpl.finishSFUpdfcmptOffer( fromUpdcmpt );
					}
				}
				finally{
					
				}
			}
		}
		finally{
			if( fromUpdpgm != null ){ fromUpdpgm.clear(); fromUpdpgm = null; }
		}
	}
	
	/**
	 * 结构化服务激活策略组件关联
	 * @param fromUpdpgmImpl
	 * @param fromPROGRAM
	 * @throws SFException
	 * @throws Exception
	 */
	private void _finishSFUpdcmpCatalog(IUpdpgmCreateImpl fromUpdpgmImpl,
			java.util.Map fromPROGRAM ) throws SFException,Exception{
		java.util.List fromUpdpgm = null;
		try
		{
			fromUpdpgm = BasicFactory.getIUpdcpmSV().getIUpdcmptCatalog();
			if( fromUpdpgm != null && fromUpdpgm.size() > 0 ){
				IProgramTemplate.IUpdfcmpCatalog fromCatalog = null;
				IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
				for( java.util.Iterator itera = fromUpdpgm.iterator() ; itera.hasNext() ; ){
					ISAComponentRel aComponentRel = (ISAComponentRel)itera.next();
					fromCatalog = new IProgramTemplate.IUpdfcmpCatalog( aComponentRel );
					if( ( fromUpdcmpt = fromUpdpgmImpl.getCOMPONENT( fromCatalog.getCOMPONENT() ) ) != null ){
						fromUpdcmpt.getCATALOG().add( fromCatalog );
					}
				}
			}
		}
		finally{
			if( fromUpdpgm != null ){ fromUpdpgm.clear(); fromUpdpgm = null; }
		}
	}
	
	/**
	 * 结构化服务激活属性组件
	 * @param fromUpdpgmImpl
	 * @param fromPROGRAM
	 * @throws SFException
	 * @throws Exception
	 */
	private void _finishSFUpdcmpMapping( IUpdpgmCreateImpl fromUpdpgmImpl, java.util.Map fromPROGRAM ) throws SFException,Exception{
		java.util.List fromUpffsm = null;
		try
		{
			IProgramTemplate.IUpdffgsmOffer fromUpffxm = null;
			IProgramTemplate.IUpdffsmOffer fromUpdcmpt = null;
			fromUpffsm = BasicFactory.getIUpdcpmSV().getIUpdcmptMapping();
			for( java.util.Iterator itera = fromUpffsm.iterator() ; itera.hasNext() ; ){
				ISAMappingX aMAPPING = (ISAMappingX)itera.next();
				fromUpffxm = new IProgramTemplate.IUpdffgsmOffer( aMAPPING );
				fromUpdcmpt = fromUpdpgmImpl.getMAPPING( fromUpffxm.getCOMPONENT() );
				if( fromUpdcmpt == null ) continue;
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PROGRAM_COMPONENT_MAPPING , 
						new String[]{fromUpffxm.getCOMPONENT(), fromUpffxm.getCODE()} );
				fromPROGRAM.put( fromINDEX , fromUpffxm );
				fromUpdcmpt.getCOMPETENCE().add( fromUpffxm );
			}
		}
		finally{
			if( fromUpffsm != null ){ fromUpffsm.clear(); fromUpffsm = null; }
		}
	}
	
	/**
	 * 结构化服务激活补偿组件
	 * @param fromUpdpgmImpl
	 * @param fromPROGRAM
	 * @throws SFException
	 * @throws Exception
	 */
	private void _finishSFUpdcmpCompensa(IUpdpgmCreateImpl fromUpdpgmImpl,java.util.Map fromPROGRAM ) throws SFException,Exception{
		java.util.List fromUpdpgm = null;
		try
		{
			IProgramTemplate.IUpdfcmpOffer fromUpdcmp = null;
			fromUpdpgm = BasicFactory.getIUpdcpmSV().getIUpdcmptCompensation();
			for( java.util.Iterator itera = fromUpdpgm.iterator() ; itera.hasNext() ; ){
				ISACompensation aCompensation = (ISACompensation)itera.next();
				fromUpdcmp = fromUpdpgmImpl.getCOMPENSA( aCompensation.getComponent() );
				if( fromUpdcmp != null ){ fromUpdcmp.subscribe( aCompensation ); }
			}
		}
		finally{
			if( fromUpdpgm != null ){ fromUpdpgm.clear(); fromUpdpgm = null; }
		}
	}
	
	/**
	 * 结构化服务激活派单组件
	 * @param fromUpdpgmImpl
	 * @param fromPROGRAM
	 * @throws SFException
	 * @throws Exception
	 */
	private void _finishSFUpdcmpClaim(IUpdpgmCreateImpl fromUpdpgmImpl,java.util.Map fromPROGRAM ) throws SFException,Exception{
		java.util.List fromUpdpgm = null;
		try
		{
			fromUpdpgm = BasicFactory.getIUpdcpmSV().getIUpdcmptDistribute();
			if( fromUpdpgm != null && fromUpdpgm.size() > 0 ){
				IProgramTemplate.IUpdfcmpOffer fromUpdcmp = null;
				for( java.util.Iterator itera = fromUpdpgm.iterator() ; itera.hasNext() ; ){
					ISADistribute aDistribute = (ISADistribute)itera.next();
					fromUpdcmp = fromUpdpgmImpl.getDISTRIBUTE( aDistribute.getComponent() );
					if( fromUpdcmp != null ){ fromUpdcmp.subscribe( aDistribute ); }
				}
			}
		}
		finally{
			if( fromUpdpgm != null ){ fromUpdpgm.clear(); fromUpdpgm = null; }
		}
	}
	
	/**
	 * 结构化服务激活异常原因组件
	 * @param fromUpdpgmImpl
	 * @param fromPROGRAM
	 * @throws SFException
	 * @throws Exception
	 */
	private void _finishSFUpdcmpException(IUpdpgmCreateImpl fromUpdpgmImpl,java.util.Map fromPROGRAM ) throws SFException,Exception{
		java.util.List fromUpdpgm = null;
		try
		{
			fromUpdpgm = BasicFactory.getIUpdcpmSV().getIUpdcmptCausation();
			if( fromUpdpgm != null && fromUpdpgm.size() > 0 ){
				IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
				for( java.util.Iterator itera = fromUpdpgm.iterator() ; itera.hasNext() ; ){
					ISAException aEXCEPTION = (ISAException)itera.next();
					fromUpdcmpt = fromUpdpgmImpl.getCOMPONENT( aEXCEPTION.getComponent() );
					if( fromUpdcmpt != null ) { fromUpdcmpt.subscribe( aEXCEPTION) ;}
				}
			}
		}
		finally{
			if( fromUpdpgm != null ){ fromUpdpgm.clear(); fromUpdpgm = null; }
		}
	}
	
	/**
	 * 结构化服务激活解决方案
	 * @param fromUpdpgmImpl
	 * @param fromPROGRAM
	 * @throws SFException
	 * @throws Exception
	 */
	private void _finishSFUpdpgmOffer(IUpdpgmCreateImpl fromUpdpgmImpl,
			java.util.Map fromPROGRAM ) throws SFException,Exception{
		java.util.List fromUpdcpm = null;
		java.util.Map fromSubFlow = new java.util.HashMap();
		try
		{
			IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
			IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog fromCatalog = null;
			fromUpdcpm = BasicFactory.getIUpdcpmSV().getIUpdpgmCatalog();
			for( java.util.Iterator itera = fromUpdcpm.iterator(); itera.hasNext(); ){
				ISAProgramRel aPROGRAM = (ISAProgramRel)itera.next();
				fromUpdcmpt = fromUpdpgmImpl.getCOMPONENT( aPROGRAM.getComponent() );
				fromCatalog = new IProgramTemplate.IUpdpgmOffer.IUpdpgmCatalog( aPROGRAM, fromUpdcmpt );
				if( fromSubFlow.containsKey( fromCatalog.getPROGRAM() ) == false ){
					fromSubFlow.put( fromCatalog.getPROGRAM() , new java.util.HashMap() );
				}
				((java.util.Map)fromSubFlow.get( fromCatalog.getPROGRAM() ) ).put( 
						fromCatalog.getCATEGORY(), fromCatalog );
			}
			fromUpdcpm = BasicFactory.getIUpdcpmSV().getIUpdpgmOffer();
			for( java.util.Iterator itera = fromUpdcpm.iterator(); itera.hasNext(); ){
				ISAProgram aProgram = (ISAProgram)itera.next();
				IProgramTemplate.IUpdpgmOffer fromUpdpgm = new IProgramTemplate.IUpdpgmOffer( aProgram );
				String aINDEX = ClassUtils.getINDEX(IUpdcConst.ICache.ICachePref.I_PROGRAM_PROGRAM,
						new String[]{ fromUpdpgm.getID() });
				if( fromSubFlow.get( fromUpdpgm.getID() ) != null ){
					fromUpdpgm.getPROGRAM().putAll( (java.util.Map)fromSubFlow.get( 
							fromUpdpgm.getID() ) );
				}
				fromPROGRAM.put( aINDEX , fromUpdpgm );
			}
		}
		finally{
			if( fromSubFlow != null ){ fromSubFlow.clear(); fromSubFlow = null; }
			if( fromUpdcpm != null ){ fromUpdcpm.clear(); fromUpdcpm = null; }
		}
	}
	
	
	
	
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-5-18</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public class IUpdpgmCreateImpl{
		/*结构化组件映射*/
		java.util.Map  _component = new java.util.HashMap();
		/*异常回滚流程*/
		java.util.Map  _subflow   = new java.util.HashMap();
		public IUpdpgmCreateImpl(){
			super();
		}
		/**
		 * 
		 * @return
		 */
		public java.util.Map getCOMPONENT(){
			return _component;
		}
		
		/**
		 * 
		 * @param aComponent
		 * @return
		 */
		public IProgramTemplate.IUpdfcmpOffer _wrap( ISAComponent aComponent ){
			IProgramTemplate.IUpdfcmpOffer fromUpdcmpt = null;
			try
			{
				if( StringUtils.equals( aComponent.getCategory(), 
						IUpdcConst.IUpdcp.IUpdbm.PROGRAM_COMPENSA ) /*容错策略类组件*/){
					fromUpdcmpt = new IProgramTemplate.IUpdfmptOffer( aComponent );
				}
				else if( StringUtils.equals( aComponent.getCategory(), 
						IUpdcConst.IUpdcp.IUpdbm.PROGRAM_ROLLBACK ) /*回滚策略类组件*/){
					fromUpdcmpt = new IProgramTemplate.IUpdfbpmOffer( aComponent );
				}
				else if( StringUtils.equals( aComponent.getCategory(), 
						IUpdcConst.IUpdcp.IUpdbm.PROGRAM_DISTRIBUTE ) /*派单策略类组件*/){
					fromUpdcmpt = new IProgramTemplate.IUpdffwmOffer( aComponent );
				}
				else if( StringUtils.equals( aComponent.getCategory(), 
						IUpdcConst.IUpdcp.IUpdbm.PROGRAM_MAPPING ) /*一级属性策略类组件*/ ){
					fromUpdcmpt = new IProgramTemplate.IUpdffsmOffer( aComponent );
				}
				else if( StringUtils.equals( aComponent.getCategory(), 
						IUpdcConst.IUpdcp.IUpdbm.PROGRAM_COMPOSITE ) /*二级属性策略类组件*/){
					fromUpdcmpt = new IProgramTemplate.IUpdffsmOffer( aComponent );
				}
				else if( StringUtils.equals( aComponent.getCategory(), 
						IUpdcConst.IUpdcp.IUpdbm.PROGRAM_COMPLEX ) /*流程属性类组件*/){
					fromUpdcmpt = new IProgramTemplate.IUpdffsmOffer( aComponent );
				}
				else if( StringUtils.equals( aComponent.getCategory(), 
						IUpdcConst.IUpdcp.IUpdbm.PROGRAM_EXCEPTION ) /*异常原因类组件*/){
					fromUpdcmpt = new IProgramTemplate.IUpdfcauOffer( aComponent );
				}
				else/*其他策略类组件*/{
					fromUpdcmpt = new IProgramTemplate.IUpdfcwmOffer( aComponent );
				}
			}
			finally{
				
			}
			return fromUpdcmpt;
		}
		/**
		 * 
		 * @param fromUpdcpm
		 */
		public void finishSFUpdfcmptOffer( IProgramTemplate.IUpdfcmpOffer fromUpdcpm ){
			try
			{
				_component.put( fromUpdcpm.getID(), fromUpdcpm );
				java.util.List fromUpdbmc = (java.util.List)_subflow.get( fromUpdcpm.getID() );
				if( fromUpdbmc != null && isROLLBACK( fromUpdcpm ) ){
					for( java.util.Iterator iterap = fromUpdbmc.iterator(); iterap.hasNext(); ){
						ISARollBack aROLLBACK = (ISARollBack)iterap.next();
						fromUpdcpm.submitWorkFlow( aROLLBACK );
					}
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param aCOMPONENT
		 * @return
		 * @throws Exception
		 */
		public IProgramTemplate.IUpdfcmpOffer getCOMPONENT( String aCOMPONENT ) throws Exception{
			IProgramTemplate.IUpdfcmpOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = (IProgramTemplate.IUpdfcmpOffer)_component.get( aCOMPONENT );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 
		 * @param aCOMPONENT
		 * @return
		 * @throws Exception
		 */
		public IProgramTemplate.IUpdffsmOffer getMAPPING( String aCOMPONENT ) throws Exception{
			IProgramTemplate.IUpdffsmOffer fromUpffmx = null;
			try
			{
				fromUpffmx = (IProgramTemplate.IUpdffsmOffer)getCOMPONENT( aCOMPONENT );
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException("IOS0011087", 
						new String[]{ aCOMPONENT, aException.getMessage()} );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
		/**
		 * 
		 * @param aCOMPONENT
		 * @return
		 * @throws Exception
		 */
		public IProgramTemplate.IUpdfcmpOffer getCOMPENSA( String aCOMPONENT ) throws Exception{
			IProgramTemplate.IUpdfcmpOffer fromUpffcwm = null;
			try
			{
				fromUpffcwm = (IProgramTemplate.IUpdfcmpOffer)getCOMPONENT( aCOMPONENT );
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException("IOS0011087", 
						new String[]{ aCOMPONENT, aException.getMessage()} );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return fromUpffcwm;
		}
		
		/**
		 * 
		 * @param aCOMPONENT
		 * @return
		 */
		public IProgramTemplate.IUpdfcmpOffer getDISTRIBUTE( String aCOMPONENT ) throws Exception{
			IProgramTemplate.IUpdfcmpOffer fromUpffcwm = null;
			try
			{
				fromUpffcwm = (IProgramTemplate.IUpdfcmpOffer)getCOMPONENT( aCOMPONENT );
			}
			catch( java.lang.Exception aException ){
				SFException aEXCEPTION = ExceptionFactory.getException("IOS0011087", 
						new String[]{ aCOMPONENT, aException.getMessage()} );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return fromUpffcwm;
		}
		
		/**
		 * 是否支持异常回滚组件
		 * @param fromUpdcmp
		 * @return
		 */
		public boolean isROLLBACK( IProgramTemplate.IUpdfcmpOffer fromUpdcmp){
			return StringUtils.contains( fromUpdcmp.getCATEGORY(), new String[]{
				      IUpdcConst.IUpdcp.IUpdbm.PROGRAM_PROVISION,
				         IUpdcConst.IUpdcp.IUpdbm.PROGRAM_ROLLBACK,
				            IUpdcConst.IUpdcp.IUpdbm.PROGRAM_SUBFLOW});
		}
		/**
		 * 结构化服务激活异常回滚策略组件
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.Map finishSFUpdcmptRollBack() throws SFException,Exception{
			java.util.List fromUpdbmc = null;
			try
			{
				fromUpdbmc = BasicFactory.getIUpdcpmSV().getIUpdcmptRollBack();
				for( java.util.Iterator itera = fromUpdbmc.iterator() ; itera.hasNext() ; ){
					ISARollBack aROLLBACK = (ISARollBack)itera.next();
					if( _subflow.get( aROLLBACK.getComponent() ) == null ){
						_subflow.put( aROLLBACK.getComponent(), new java.util.ArrayList() );
					}
					((java.util.List)_subflow.get( aROLLBACK.getComponent() ) ).add( aROLLBACK );
				}
			}
			finally{
				if( fromUpdbmc != null ){ fromUpdbmc.clear(); fromUpdbmc = null; }
			}
			return _subflow;
		}
	}
}
