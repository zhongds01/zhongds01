package com.ai.sacenter.comptel.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.bo.IOVUpdcpCatalog;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.comptel.dbcp.IMappingSystemImpl;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbmtcLife;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpdcpmGroup;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务模板遍历规范</p>
 * <p>Copyright: Copyright (c) 2015年10月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IMappingModuleImpl extends IMappingSystemImpl {
	public IMappingModuleImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromOffer[] = null;
		try
		{
			IOVUpdcpCatalog fromChain = null;
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			IOVOrderPentium fromPentium = UpdcpUtils.ISystem.getORDER( aContext );
			fromUpdcpm = UpdcpUtils.ISystem.getBUSINES(fromPentium, fromUpfgsm);
			fromChain = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromUser, 
					fromUpdcpm, 
					aContext);
			if(  fromChain != null && fromChain.getCATALOG().size() > 0 ){
				fromOffer = fromChain.getCOMPETENCE();
			}
		}
		finally{
			
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromUpdcpm = null;
		try
		{
			String aCOMPLEX = fromUpfgsm.getCOMPLEX();
			if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
			fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, null );
			IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromUpfgsm, 
					fromUser, 
					fromUpdcpm, 
					aContext);
		}
		finally{
			
		}
		return fromUpdcpm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
		java.util.Map fromUpffmx = null;
		try
		{
			Object aCOMPLEX[] = UpfgsmUtils.IUpfsm._jj_jexp( fromUpfgsm, 
					fromUpfgsm.getCOMPETE() , 
					fromUpfgsm.getCOMPLEX(), 
					fromOffer, 
					aContext);
			String aMODULE = aCOMPLEX != null && aCOMPLEX.length > 0?(String)aCOMPLEX[0]:null;
			if( aMODULE != null && StringUtils.isBlank( aMODULE ) == false ){
				IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(aMODULE, 
						fromOffer, 
						fromUpffmx = new java.util.HashMap(), 
						aContext);
			}
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
		IOVUpfgsmCatalog fromUpffmx = null;
		try
		{
			Object aCOMPLEX[] = UpfgsmUtils.IUpfsm._jj_jexp( fromUpfgsm, 
					fromUpfgsm.getCOMPETE() , 
					fromUpfgsm.getCOMPLEX(), 
					fromOffer, 
					aContext);
			String aMODULE = aCOMPLEX == null || aCOMPLEX.length < 1?null:(String)aCOMPLEX[0];
			fromUpffmx = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmOffer( aMODULE , 
					fromUpfgsm, 
					fromOffer, 
					aContext); 
		}
		finally{
			
		}
		return fromUpffmx != null?fromUpffmx.getMAPPINGS():null;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 二级模板遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingChildImpl extends IMappingModuleImpl{
		public IMappingChildImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.impl.IMappingModuleImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
			try
			{
				fromUpffmx = super.finishSFUpfgsmc(fromUpfgsm, 
						fromOffer, 
						aContext);
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getRocket().rollbackTransaction();
				throw exception;
			}
			finally{
				
			}
			return fromUpffmx;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.impl.IMappingModuleImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
			try
			{
				fromUpffmx = super.finishSFUpfgsmc(fromUpfgsm, 
						fromOffer, 
						aContext);
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getRocket().rollbackTransaction();
				throw exception;
			}
			finally{
				
			}
			return fromUpffmx;
		}	
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务调用遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月16日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJMMIImpl extends IMappingSystemImpl{
		public IMappingJMMIImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				String fromUpffmx = UpfgsmUtils.IUpfsm._jj_velocity(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromUser.getNATURE(), 
						fromUpfgsm.getCOMPLEX(), 
						aContext);
				if( fromUpffmx != null && StringUtils.isNULL( fromUpffmx ) == false ){ 
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromUpffmx ); 
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_velocity(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						fromUpfgsm.getCOMPLEX(), 
						aContext);
			}
			finally{
				
			}
			return fromUpffmx;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_velocity(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						fromUpfgsm.getCOMPLEX(), 
						aContext);
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 组件调用遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月16日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJMSIImpl extends IMappingSystemImpl{
		public IMappingJMSIImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				Object fromUpffmx = UpfgsmUtils.IUpfsm._jj_phantom(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromUpfgsm.getCOMPLEX(), 
						fromUser.getNATURE(), 
						aContext);
				if( fromUpffmx != null && StringUtils.isNULL( fromUpffmx.toString() ) == false ){ 
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromUpffmx.toString() ); 
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_phantom(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromUpfgsm.getCOMPLEX(), 
						fromOffer, 
						aContext);
			}
			finally{
				
			}
			return fromUpffmx;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_phantom(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromUpfgsm.getCOMPLEX(), 
						fromOffer, 
						aContext);
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年10月11日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingJMMSImpl extends IMappingSystemImpl{
		public IMappingJMMSImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_velocity(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						fromUpfgsm.getCOMPLEX(), 
						aContext);
				if( ClassUtils.IClass.isString( fromUpffmx ) && 
						StringUtils.contains( (String)fromUpffmx, "=" ) ){
					fromUpffmx = UpfgsmUtils.IUpfsm._jj_splite(fromUpfgsm, 
							fromUpfgsm.getCOMPETE(), 
							fromOffer, 
							(String)fromUpffmx, 
							null, 
							aContext);
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 模板引用遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月16日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJMMXImpl extends IMappingSystemImpl{
		public IMappingJMMXImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				if( StringUtils.isBlank(fromUpfgsm.getCOMPLEX() ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				String fromUpffmx = IUpdcpFactory.getIUpfvmSV().finishSFUpdbwfChain(fromUpfgsm.getCOMPETE(), 
						fromUpfgsm.getCOMPLEX(), 
						fromUser.getNATURE(),
						aContext);
				if( fromUpffmx != null && StringUtils.isNULL( fromUpffmx ) == false ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromUpffmx ); 
				}
			}
			finally{
			
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			String fromUpffmx = null;
			try
			{
				if( StringUtils.isBlank( fromUpfgsm.getCOMPLEX() ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				fromUpffmx = IUpdcpFactory.getIUpfvmSV().finishSFUpdbwfChain(fromUpfgsm.getCOMPETE(), 
						fromUpfgsm.getCOMPLEX(), 
						fromOffer, 
						aContext);
			}
			finally{
				
			}
			return fromUpffmx;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			String fromUpffmx = null;
			try
			{
				if( StringUtils.isBlank( fromUpfgsm.getCOMPLEX() ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				fromUpffmx = IUpdcpFactory.getIUpfvmSV().finishSFUpdbwfChain(fromUpfgsm.getCOMPETE(), 
						fromUpfgsm.getCOMPLEX(), 
						fromOffer, 
						aContext);
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 人机指令遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月16日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJMMLImpl extends IMappingSystemImpl{
		public IMappingJMMLImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			String fromUpffmx = null;
			try
			{
				if( StringUtils.isBlank( fromUpfgsm.getCOMPLEX() ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				aCOMPLEX = new String[] { aCOMPLEX[0], (aCOMPLEX == null || aCOMPLEX.length <= 1
								|| StringUtils.isBlank(aCOMPLEX[1]) ? null : aCOMPLEX[1]) };
				fromUpffmx = IUpdcpFactory.getIUpfvmSV().finishSFUpdbrfChain(fromUpfgsm.getCOMPETE(), 
						aCOMPLEX[1], 
						aCOMPLEX[0], 
						fromOffer, 
						aContext);
			}
			finally{
			
			}
			return fromUpffmx;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			String fromUpffmx = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){
					aCOMPLEX = UpdcUtils.ISubFlow.getDIRECTIVE( null, aContext );
				}
				if( StringUtils.isBlank( aCOMPLEX ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX/DIRECTIVE" } );
				}
				fromUpffmx = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmChain(null,
						fromUpfgsm, 
						fromOffer, 
						aCOMPLEX, 
						aContext);
			}
			finally{
			
			}
			return fromUpffmx;
		}
	}
	
	/***
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2018年5月14日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingSubJectImpl extends IMappingSystemImpl{
		public IMappingSubJectImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromSubJect = null;
			IUpffxSubJectImpl fromSubJectImpl = new IUpffxSubJectImpl();
			try
			{
				if( fromUpfgsm instanceof IProgramTemplate.IUpdffgsmOffer/*基于网元组件*/ ){
					IProgramTemplate.IUpdffgsmOffer fromUpffmx = (IProgramTemplate.IUpdffgsmOffer)fromUpfgsm;
					fromSubJect = fromSubJectImpl._jj_catalog( fromUpffmx, fromOffer, aContext );
				}
				else{
					fromSubJect = fromSubJectImpl._jj_subject( fromUpfgsm, fromOffer, aContext );
				}
			}
			finally{
				if( fromSubJectImpl != null ){ fromSubJectImpl = null; }
			}
			return fromSubJect;
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2018年5月17日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingCarbonImpl extends IMappingSystemImpl{
		public IMappingCarbonImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromSubJect = null;
			IUpffxSubJectImpl fromSubJectImpl = new IUpffxSubJectImpl();
			try
			{
				if( fromUpfgsm instanceof IProgramTemplate.IUpdffgsmOffer/*基于SA_MAPPING_X组件*/ ){
					IProgramTemplate.IUpdffgsmOffer fromUpffmx = (IProgramTemplate.IUpdffgsmOffer)fromUpfgsm;
					fromSubJect = fromSubJectImpl._jj_carbon( fromUpffmx, fromOffer, aContext );
				}
				else{
					fromSubJect = fromSubJectImpl._jj_subject( fromUpfgsm, fromOffer, aContext );
				}
			}
			finally{
				if( fromSubJectImpl != null ){ fromSubJectImpl = null; }
			}
			return fromSubJect;
		}
	}
	
	/***
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2018年5月14日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingArrayImpl extends IMappingSystemImpl{
		public IMappingArrayImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromSubJect = null;
			IUpffxSubJectImpl fromSubJectImpl = new IUpffxSubJectImpl();
			try
			{
				if( fromUpfgsm instanceof IProgramTemplate.IUpdffgsmOffer/*基于SA_MAPPING_X组件*/ ){
					IProgramTemplate.IUpdffgsmOffer fromUpffmx = (IProgramTemplate.IUpdffgsmOffer)fromUpfgsm;
					fromSubJect = fromSubJectImpl._jj_array( fromUpffmx, fromOffer, aContext );
				}
				else{
					fromSubJect = fromSubJectImpl._jj_subject( fromUpfgsm, fromOffer, aContext );
				}
			}
			finally{
				if( fromSubJectImpl != null ){ fromSubJectImpl = null; }
			}
			return fromSubJect;
		}
	}
	
	public static class IUpffxSubJectImpl extends IMappingSystemImpl{
		public IUpffxSubJectImpl(){
			super();
		}
		
		/**
		 * 
		 * @param fromUpffx
		 * @param fromOffer
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.Map _jj_catalog( IProgramTemplate.IUpdffgsmOffer fromUpffx, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception{
			java.util.Map fromSubJect = null;
			try
			{
				IUpdcpmGroup fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog( fromUpffx.getCOMPLEX(), fromOffer, aContext);
				if( fromGroup != null && fromGroup.getPROGRAM().getGROUP().size() > 0 ){
					for( java.util.Iterator itera = fromGroup.getPROGRAM().getGROUP().iterator(); itera.hasNext(); ){
						IProgramTemplate.IUpdffsmOffer fromUpffwm = (IProgramTemplate.IUpdffsmOffer)itera.next();
						java.util.Map fromSubJSQL = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( fromUpffwm, fromOffer, new java.util.HashMap(), aContext );
						if( fromSubJSQL == null || fromSubJSQL.size() <= 0 ){ continue; }
						if( fromSubJect == null ){
							fromSubJect = new java.util.HashMap();
							fromSubJect.put( fromUpffx.getMAPPING(), new java.util.ArrayList() );
						}
						((java.util.List)fromSubJect.get( fromUpffx.getMAPPING() ) ).add( fromSubJSQL );
					}
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromUpffx
		 * @param fromOffer
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.Map _jj_carbon( IProgramTemplate.IUpdffgsmOffer fromUpffx, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception{
			java.util.Map fromSubJect = new java.util.HashMap();
			try
			{
				java.util.Map fromSubJSQL = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( fromUpffx.getCOMPLEX(), fromOffer, new java.util.HashMap(), aContext );
				if( fromSubJSQL != null && fromSubJSQL.size() > 0 ){ _jj_array( fromUpffx, fromSubJSQL, fromSubJect, aContext ); }
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromUpffx
		 * @param fromOffer
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.Map _jj_array( IProgramTemplate.IUpdffgsmOffer fromUpffx, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception{
			java.util.Map fromSubJect = new java.util.HashMap();
			try
			{
				IUpdcpmGroup fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog( fromUpffx.getCOMPLEX(), fromOffer, aContext);
				if( fromGroup != null && fromGroup.getPROGRAM().getGROUP().size() > 0 ){
					java.util.ArrayList fromArray = new java.util.ArrayList();
					for( java.util.Iterator itera = fromGroup.getPROGRAM().getGROUP().iterator(); itera.hasNext(); ){
						IProgramTemplate.IUpdffsmOffer fromUpffwm = (IProgramTemplate.IUpdffsmOffer)itera.next();
						java.util.Map fromSubJSQL = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( fromUpffwm, fromOffer, new java.util.HashMap(), aContext );
						if( fromSubJSQL == null || fromSubJSQL.size() <= 0 ){ continue; }
						fromArray.add( fromSubJSQL );
					}
					if( fromArray != null && fromArray.size() > 0 ){ _jj_array( fromUpffx, fromArray, fromSubJect, aContext ); }
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param fromUpffx
		 * @param fromSubJSQL
		 * @param fromSubJect
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		private void _jj_array( IProgramTemplate.IUpdffgsmOffer fromUpffx, java.util.Map fromSubJSQL, java.util.Map fromSubJect, IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVUpdbmtcLife fromINDEX = new IOVUpdbmtcLife( 1l );
				fromSubJect.put( ClassUtils.getINDEX( new String[]{ fromUpffx.getCOMPETE(),"_NUM" } ), String.valueOf( fromSubJSQL.size() ) );
				for( java.util.Iterator itera = fromSubJSQL.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					if( fromEntry.getValue() == null ){ continue; }
					String _para_name = ClassUtils.getINDEX( new String[]{ fromUpffx.getCOMPETE(), "_NAME_", String.valueOf( fromINDEX.getINDEX() ) } );
					String _para_value = ClassUtils.getINDEX( new String[]{ fromUpffx.getCOMPETE(), "_VALUE_", String.valueOf( fromINDEX.getINDEX() ) } );
					fromSubJect.put( _para_name, fromEntry.getKey().toString() );
					fromSubJect.put( _para_value, fromEntry.getValue() );
					fromINDEX.setINDEX( fromINDEX.getINDEX() + 1 );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromUpffx
		 * @param fromSubJSQL
		 * @param fromSubJect
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		private void _jj_array( IProgramTemplate.IUpdffgsmOffer fromUpffx, java.util.List fromSubJSQL, java.util.Map fromSubJect, IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVUpdbmtcLife fromINDEX = new IOVUpdbmtcLife( 1l );
				fromSubJect.put( ClassUtils.getINDEX( new String[]{ fromUpffx.getCOMPETE(),"_NUM" } ), String.valueOf( fromSubJSQL.size() ) );
				for( java.util.Iterator itera = fromSubJSQL.iterator(); itera.hasNext(); ){
					Object _subject = itera.next();
					if( _subject == null ){ continue; }
					String _para_name = ClassUtils.getINDEX( new String[]{ fromUpffx.getCOMPETE(), "_NAME_", String.valueOf( fromINDEX.getINDEX() ) } );
					String _para_value = ClassUtils.getINDEX( new String[]{ fromUpffx.getCOMPETE(), "_VALUE_", String.valueOf( fromINDEX.getINDEX() ) } );
					fromSubJect.put( _para_name, fromUpffx.getCOMPETE() );
					fromSubJect.put( _para_value, _subject );
					fromINDEX.setINDEX( fromINDEX.getINDEX() + 1 );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromUpffx
		 * @param fromOffer
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.List _jj_subject(ISystemTemplate.IUpfgsmxOffer fromUpffx, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception{
			java.util.List fromSubJect = null;
			try
			{
				String fromPARA = ClassUtils.getINDEX( new String[]{ fromUpffx.getCOMPETE(), "_NUM" } );
				if( fromOffer.get( fromPARA ) != null ){
					int _para_num = Integer.parseInt( (String)fromOffer.get( fromPARA ) );
					for( int _index = 0; _para_num > 0 && _index < _para_num; _index++ ){
						String _para_name = (String)fromOffer.get( ClassUtils.getINDEX( new String[]{ fromUpffx.getCOMPETE(), "_NAME_", String.valueOf( _index + 1 ) } ) );
						String _para_value = (String)fromOffer.get( ClassUtils.getINDEX( new String[]{ fromUpffx.getCOMPETE(), "_VALUE_", String.valueOf( _index + 1 ) } ) );
						if( _para_name == null || _para_value == null ){ continue; }
						if( fromSubJect == null ){ fromSubJect = new java.util.ArrayList(); }
						fromSubJect.add( new java.util.HashMap() );
						((java.util.Map)fromSubJect.get( fromSubJect.size() - 1 ) ).put( _para_name, _para_value );
					}
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
	}
}
