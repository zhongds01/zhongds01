package com.ai.sacenter.comptel.dbcp.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.UpdcpFactory;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.comptel.dbcp.IMappingSystemImpl;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.EncryptUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年10月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IMappingJDOImpl extends IMappingSystemImpl {
	public IMappingJDOImpl() {
		super();
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 直接取值遍历规则</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingDirectImpl extends IMappingSystemImpl {
		public IMappingDirectImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				if( StringUtils.isBlank( fromUpfgsm.getCOMPLEX() ) == false ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromUpfgsm.getCOMPLEX() );
					IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromUpfgsm, 
							fromUser, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				
			}
			return fromUpdcpm != null?new IOVUpdcpOffer[]{ fromUpdcpm }:null;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				Object fromUpffmx = UpfgsmUtils.IUpfsm._jj_direct(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromUser.getNATURE(), 
						fromUpfgsm.getCOMPLEX(), 
						aContext);
				if( fromUpffmx != null ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromUpffmx.toString() );
					IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromUpfgsm, 
							fromUser, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpdffsm(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_direct(fromUpfgsm, 
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
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_direct(fromUpfgsm, 
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
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 服务变量遍历规范</p>
	 * <p>Copyright: Copyright (c) 2017年1月23日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingContextImpl extends IMappingSystemImpl{
		public IMappingContextImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				Object fromUpffmx = UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromUser.getNATURE(), 
						aCOMPLEX, 
						aContext);
				if( fromUpffmx != null ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, 
							ClassUtils.IClass.isPrimitive( fromUpffmx )?fromUpffmx.toString():null );
					IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromUpfgsm, 
							fromUser, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						aCOMPLEX, 
						aContext);
			}
			finally{
				
			}
			return fromUpffmx;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						aCOMPLEX, 
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
	 * <p>Description: 变量依赖遍历规范</p>
	 * <p>Copyright: Copyright (c) 2017年1月23日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingDependImpl extends IMappingSystemImpl{
		public IMappingDependImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_depend(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						aCOMPLEX, 
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
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_depend(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						aCOMPLEX, 
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
	 * <p>Description: 批量属性遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJXDOImpl extends IMappingSystemImpl{
		public IMappingJXDOImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			java.util.Map fromUpfgsmx = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				fromUpfgsmx = UpfgsmUtils.IUpfsm._jj_complex(fromUpfgsm, fromUpfgsm.getCOMPETE(), 
						fromUser.getNATURE(), 
						aCOMPLEX, 
						aContext);
				if( fromUpfgsmx != null && fromUpfgsmx.size() > 0 ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, null );
					ClassUtils.IMerge.merge( fromUpfgsmx, fromUpdcpm.getCOMPLEX() );
				}
			}
			finally{
				if( fromUpfgsmx != null ){ fromUpfgsmx.clear(); fromUpfgsmx = null; }
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			java.util.Map fromUpdcpm = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				fromUpdcpm = UpfgsmUtils.IUpfsm._jj_complex(fromUpfgsm, fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						aCOMPLEX, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			java.util.Map fromUpdcpm = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				fromUpdcpm = UpfgsmUtils.IUpfsm._jj_complex(fromUpfgsm, fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						aCOMPLEX, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm;
		}

	}
	
	/**
	 * IUpfwmNullImpl
	 * @author admin
	 *
	 */
	public static class IMappingNullImpl extends IMappingSystemImpl{
		public IMappingNullImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpdffsm(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_null(fromUpfgsm, 
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
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_null(fromUpfgsm, 
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
	 * <p>Description: 系统时间遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingSysdateImpl extends IMappingSystemImpl{
		public IMappingSysdateImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				if( aCOMPLEX == null || aCOMPLEX.length < 2 ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				String fromUpffmx = (String)UpfgsmUtils.IUpfsm._jj_sysdate(fromUpfgsm, 
						aCOMPLEX[0], 
						fromUser.getNATURE(), 
						aCOMPLEX != null && aCOMPLEX.length > 1?aCOMPLEX[1]:null, 
						aContext);
				if( fromUpffmx != null ){
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
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_sysdate(fromUpfgsm, 
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
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_sysdate(fromUpfgsm, 
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
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingSpliteImpl extends IMappingSystemImpl{
		public IMappingSpliteImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				if( aCOMPLEX == null || aCOMPLEX.length < 2 ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				Object fromUpffmx = UpfgsmUtils.IUpfsm._jj_splite(fromUpfgsm, 
						aCOMPLEX[0], 
						fromUser.getNATURE(), 
						aCOMPLEX[1], 
						aCOMPLEX != null && aCOMPLEX.length > 2?aCOMPLEX[2]:null,
						aContext);
				if( fromUpffmx != null ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromUpffmx.toString() );
					IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromUpfgsm, 
							fromUser, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				
			}
			return fromUpdcpm != null?new IOVUpdcpOffer[]{ fromUpdcpm }:null;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				if( aCOMPLEX == null || aCOMPLEX.length < 2 ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				Object fromUpffmx = UpfgsmUtils.IUpfsm._jj_splite(fromUpfgsm, 
						aCOMPLEX[0], 
						fromUser.getNATURE(), 
						aCOMPLEX[1], 
						aCOMPLEX != null && aCOMPLEX.length > 2?aCOMPLEX[2]:null,
						aContext);
				if( fromUpffmx != null ){
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
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				if( aCOMPLEX == null || aCOMPLEX.length < 2 ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_splite(fromUpfgsm, 
						aCOMPLEX[0], 
						fromOffer, 
						aCOMPLEX[1],
						aCOMPLEX != null && aCOMPLEX.length > 2?aCOMPLEX[2]:null,
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
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				if( aCOMPLEX == null || aCOMPLEX.length < 1 ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_splite(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						aCOMPLEX[0],
						aCOMPLEX != null && aCOMPLEX.length > 1?aCOMPLEX[1]:null,
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
	 * <p>Description: 表达式分析遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingXPathImpl extends IMappingSystemImpl{
		public IMappingXPathImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				Object fromUpffmx = IUpdcpFactory.getIUpfwmSV().finishSFUpfvnChain( fromUpfgsm.getCOMPLEX(), 
						fromUser.getNATURE(), 
						aContext );
				if( fromUpffmx != null ){
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
			java.util.Map fromUpdcpm = new java.util.HashMap();
			try
			{
				Object fromUpffmx = IUpdcpFactory.getIUpfwmSV().finishSFUpfvnChain( fromUpfgsm.getCOMPLEX() , 
						fromOffer, 
						aContext );
				if( fromUpffmx != null ){
					UpfgsmUtils.IUpfvm.wrap( fromUpfgsm.getMAPPING(), 
							fromUpffmx, 
							fromOffer, 
							fromUpdcpm, 
							aContext );
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			java.util.Map fromUpdcpm = new java.util.HashMap();
			try
			{
				Object fromUpffmx = IUpdcpFactory.getIUpfwmSV().finishSFUpfvnChain( fromUpfgsm.getCOMPLEX() , 
						fromOffer, 
						aContext );
				if( fromUpffmx != null ){
					UpfgsmUtils.IUpfvm.wrap( fromUpfgsm.getMAPPING(), 
							fromUpffmx, 
							fromOffer, 
							fromUpdcpm, 
							aContext );
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: JEVAL规则遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月17日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJevalImpl extends IMappingSystemImpl{
		public IMappingJevalImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				String fromUpffmx = UpdcpUtils.IUpfvn.evaluate(aCOMPLEX, fromUser.getNATURE(), aContext);
				if( fromUpffmx != null && StringUtils.isBlank( fromUpffmx ) == false ){
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
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				fromUpffmx = UpdcpUtils.IUpfvn.evaluate(aCOMPLEX, fromOffer, aContext);
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
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				fromUpffmx = UpdcpUtils.IUpfvn.evaluate(aCOMPLEX, 
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
	 * <p>Description: 判断属性存在遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingExistImpl extends IMappingSystemImpl{
		public IMappingExistImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				if( aCOMPLEX == null || aCOMPLEX.length < 1 ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				if( UpfgsmUtils.IUpfsm._jj_exist( aCOMPLEX[0], fromUser.getNATURE(), aContext ) ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, aCOMPLEX != null && 
							aCOMPLEX.length > 1?aCOMPLEX[1]:IUpdcConst.IState.C );
					IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromUpfgsm, 
							fromUser, 
							fromUpdcpm, 
							aContext);
				}
			}
			finally{
				
			}
			return fromUpdcpm != null?new IOVUpdcpOffer[]{ fromUpdcpm }:null;
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
				if( UpfgsmUtils.IUpfsm._jj_exist( aCOMPLEX, fromUser.getNATURE(), aContext ) ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, null );
					IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromUpfgsm, 
							fromUser, 
							fromUpdcpm, 
							aContext);
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
			java.util.Map fromUpdcpm = null;
			try
			{
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				if( aCOMPLEX == null || aCOMPLEX.length < 1 ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				if( aCOMPLEX != null && aCOMPLEX.length < 2 ){
					aCOMPLEX = new String[]{ aCOMPLEX[0], fromUpfgsm.getCOMPETE() };
				}
				if( UpfgsmUtils.IUpfsm._jj_exist( aCOMPLEX[1], fromOffer, aContext ) ){
					IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( aCOMPLEX[0], 
							fromOffer, 
							fromUpdcpm = new java.util.HashMap(), 
							aContext );
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			IOVUpfgsmCatalog fromUpdcpm = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				if( UpfgsmUtils.IUpfsm._jj_exist( aCOMPLEX, fromOffer, aContext ) ){
					fromUpdcpm = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmOffer(null, 
							fromUpfgsm, 
							fromOffer, 
							aContext);
				}
			}
			finally{
				
			}
			return fromUpdcpm != null?fromUpdcpm.getMAPPINGS():null;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: IFELSE规则遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月17日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingIfElseImpl extends IMappingSystemImpl{
		public IMappingIfElseImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
		    java.util.HashMap fromUpdcpm = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				aCOMPLEX = UpdcpUtils.IUpfvn.evaluate( aCOMPLEX, fromOffer, aContext );
				if( StringUtils.isBlank( aCOMPLEX ) == false ){
					IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( aCOMPLEX, 
							fromOffer, 
							fromUpdcpm = new java.util.HashMap(), 
							aContext);
				}
			}
			finally{
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			IOVUpfgsmCatalog fromUpdcpm = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				boolean fromUpffmx = UpfgsmUtils.IUpfsm._jj_IfElse(fromUpfgsm,
						fromOffer, 
						aCOMPLEX, 
						aContext);
				if( fromUpffmx == true ) {
					fromUpdcpm = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmc( fromUpfgsm, 
							fromOffer, 
							aContext );
				}
			}
			finally{
			}
			return fromUpdcpm != null?fromUpdcpm.getMAPPINGS():null;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 构造POJO遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingIDOImpl extends IMappingSystemImpl{
		public IMappingIDOImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
			try
			{
				IOVUpfgsmCatalog fromUpdcpm = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmOffer(null,
						fromUpfgsm, 
						fromOffer, 
						aContext);
				fromUpffmx = fromUpfgsm.getNULLABLE()?null:ReflectUtils.IReflect.invokeConstructor( 
						Class.forName(fromUpfgsm.getCATEGORY() ), new Object[]{} );;
				if (fromUpdcpm != null && fromUpdcpm.getMAPPINGS().size() > 0) {
					fromUpffmx = fromUpffmx != null ? fromUpffmx:ReflectUtils.IReflect.invokeConstructor( 
							Class.forName( fromUpfgsm.getCATEGORY() ), new Object[]{} );
					ClassUtils.IClass.transfer( fromUpdcpm.getMAPPINGS(), fromUpffmx );
				}
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
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingIDLImpl extends IMappingSystemImpl{
		public IMappingIDLImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromLIST = null;
			UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
			try
			{
				IOVUpfgsmCatalog fromUpdcpm = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmOffer(null, 
						fromUpfgsm, 
						fromOffer, 
						aContext );
				fromLIST = ReflectUtils.IReflect.invokeConstructor( Class.forName(fromUpfgsm.getCATEGORY() ), new Object[]{} );
				if (fromUpdcpm != null && fromUpdcpm.getMAPPINGS().size() > 0) {
					if (ClassUtils.isAssignable( fromLIST.getClass(),java.util.List.class ) == false) {
						ExceptionFactory.throwRuntime("IOS0011023", new String[]{ fromUpfgsm.getCOMPETE(), 
								java.util.List.class.getName() } );
					}
					IPlatformTemplate.IUpffgsmOffer fromUpfgsmx[] = null;
					fromUpfgsmx = UpfgsmUtils.ICustom.getICSTKUpfgsmc();
					for (int index = 0; index < fromUpfgsmx.length; index++) {
						Object fromPOJO = fromUpdcpm.getMAPPINGS().get( fromUpfgsmx[index].getMAPPING() );
						if( fromPOJO == null && fromUpfgsmx[index].getNULLABLE() )
							continue;
						else {
							if( fromPOJO == null ){
								ExceptionFactory.throwRuntime("IOS0011024", new String[]{ fromUpfgsm.getCOMPETE() } );
							}
							((java.util.List) fromLIST).add( fromPOJO );
						}
					}
				}
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getRocket().rollbackTransaction();
				throw exception;
			}
			finally{
				
			}
			return fromLIST;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 位字符遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJBTFImpl extends IMappingSystemImpl{
		public IMappingJBTFImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			String fromJBTF = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" });
				}
				fromJBTF = IUpdcpFactory.getIUpfvmSV().finishSFUpdbtfChain(fromUpfgsm, 
						fromOffer, 
						aContext);
			}
			finally{
				
			}
			return fromJBTF != null?fromJBTF:null;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			String fromJBTF = null;
			try
			{
				fromJBTF = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( fromJBTF ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				fromJBTF = IUpdcpFactory.getIUpfvmSV().finishSFUpdbtfChain(fromUpfgsm, 
						fromJBTF, 
						fromOffer, 
						aContext);
			}
			finally{
				
			}
			return fromJBTF;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 枚举转换遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJDTXImpl extends IMappingSystemImpl{
		public IMappingJDTXImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				ISystemTemplate.IEnumWrapper fromUpffmx = null;
				if( StringUtils.isBlank( fromUpfgsm.getCOMPLEX() ) ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				fromUpffmx = IUpdcpFactory.getIUpdcpSV().finishSFUpdbtxChain(fromUpfgsm, 
						fromUser, 
						aContext);
				if( fromUpffmx != null ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromUpffmx.getTARGET() );
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
			String fromUpdcpm = null;
			try
			{
				ISystemTemplate.IEnumWrapper fromUpffmx = null;
				fromUpffmx = IUpdcpFactory.getIUpfvmSV().finishSFUpdbtxChain(fromUpfgsm, 
						fromOffer, 
						aContext);
				if( fromUpffmx != null ) fromUpdcpm = fromUpffmx.getTARGET();
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			String fromUpdcpm = null;
			try
			{
				ISystemTemplate.IEnumWrapper fromUpffmx = null;
				fromUpffmx = IUpdcpFactory.getIUpfvmSV().finishSFUpdbtxChain(fromUpfgsm, 
						fromOffer, 
						aContext);
				if( fromUpffmx != null ) fromUpdcpm = fromUpffmx.getTARGET();
			}
			finally{
				
			}
			return fromUpdcpm;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 判断成功遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJRLImpl extends IMappingSystemImpl{
		public IMappingJRLImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			java.util.Map fromUpdcpm = new java.util.HashMap();
			try
			{
				Object fromUpffmx = UpfgsmUtils.IUpfsm._jj_context( fromUpfgsm, 
						fromOffer, 
						fromUpfgsm.getCOMPETE(), 
						aContext);
				Boolean fromSUCCEED = fromUpffmx != null && StringUtils.isBlank( fromUpfgsm.getCOMPLEX() ) == false? 
						Boolean.FALSE : Boolean.TRUE;
				if (fromSUCCEED != null && fromSUCCEED.equals( Boolean.FALSE ) ) {
					fromSUCCEED = UpfgsmUtils.IUpfsm._jj_IfElse(fromUpfgsm, fromOffer,
							fromUpfgsm.getCOMPLEX(), aContext) ? Boolean.FALSE
							: Boolean.TRUE;
				}
				ClassUtils.IMerge.merge(new Object[][]{{ IUpdcConst.IUpfwm.PLWK_FAILURE, fromSUCCEED } }, 
						fromUpdcpm,
						false);
			}
			finally{
				
			}
			return fromUpdcpm;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 开通类型遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJKIImpl extends IMappingSystemImpl{
		public IMappingJKIImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				IPlatformTemplate.IUpffmOperate fromUpfom = null;
				fromUpfom = UpdcUtils.ISubFlow.getOPERATE(aContext);
				if( fromUpfom == null ){
					ExceptionFactory.throwRuntime("IOS0011025", new String[] { IUpdcConst.IUpdbm.IUpdbf.OPERATE });
				}
				fromUpffmx = fromUpfom.getPS_TYPE();
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
				IPlatformTemplate.IUpffmOperate fromUpfom = null;
				fromUpfom = UpdcUtils.ISubFlow.getOPERATE(aContext);
				if( fromUpfom == null ){
					ExceptionFactory.throwRuntime("IOS0011025", new String[] { IUpdcConst.IUpdbm.IUpdbf.OPERATE });
				}
				fromUpffmx = fromUpfom.getPS_TYPE();
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 优先级遍历规范</p>
	 * <p>Copyright: Copyright (c) 2017年1月25日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingJPIImpl extends IMappingSystemImpl{
		public IMappingJPIImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				IOVOrderPentium fromOrder = UpdcUtils.ISubFlow.getORDER( aContext );
				if( fromOrder == null ){
					ExceptionFactory.throwRuntime("IOS0011025", new String[] { IUpdcConst.IUpdbm.IUpdbf.ORDER });
				}
				fromUpffmx = new Long( fromOrder.getPRIORITY() );
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
				IOVOrderPentium fromPentium = null;
				fromPentium = UpdcUtils.ISubFlow.getORDER( aContext );
				if( fromPentium == null ){
					ExceptionFactory.throwRuntime("IOS0011025", new String[] { IUpdcConst.IUpdbm.IUpdbf.ORDER });
				}
				fromUpffmx = new Long( fromPentium.getPRIORITY() );
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 分表路由遍历规范</p>
	 * <p>Copyright: Copyright (c) 2017年1月25日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingJPTImpl extends IMappingSystemImpl{
		public IMappingJPTImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				fromUpffmx = CenterUtils.ICustom.getRegionId();
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
				fromUpffmx = CenterUtils.ICustom.getRegionId();
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 字符串分割遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingJXOImpl extends IMappingSystemImpl{
		public IMappingJXOImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			StringBuilder fromPARAM = new StringBuilder();
			java.util.Map fromUpdbm = new java.util.HashMap();
			UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
			try
			{
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL(fromUpfgsm.getCOMPLEX());
				if( aCOMPLEX != null && aCOMPLEX.length <= 0 ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[] {
							fromUpfgsm.getCOMPETE(), "COMPLEX" });
				}
				aCOMPLEX = new String[]{ aCOMPLEX[0], (aCOMPLEX.length > 1?aCOMPLEX[1]:";") };
				IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer( aCOMPLEX[0], 
						fromOffer, 
						fromUpdbm, 
						aContext );
				UpdcpUtils.ICustom.wrap( fromOffer, fromUpdbm );
				fromPARAM.append( JdomUtils.ICustom.wrap( fromUpdbm , aCOMPLEX[1] ) );
				if( StringUtils.isBlank( fromPARAM.toString() ) == false &&
						StringUtils.endsWith( fromPARAM.toString() , aCOMPLEX[1] ) == false ){
					fromPARAM.append( aCOMPLEX[1] );
				}
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getRocket().rollbackTransaction();
				throw exception;
			}
			finally{
				if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null;} 
			}
			return fromPARAM.toString();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			StringBuilder fromPARAM = new StringBuilder();
			UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				aCOMPLEX = StringUtils.isBlank( aCOMPLEX )?";" : aCOMPLEX;
				IOVUpfgsmCatalog fromUpdcpm = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmOffer(null, 
						fromUpfgsm, 
						fromOffer, 
						aContext);
				UpdcpUtils.ICustom.wrap( fromOffer, fromUpdcpm.getMAPPINGS() );
				fromPARAM.append( JdomUtils.ICustom.wrap( fromUpdcpm.getMAPPINGS(), aCOMPLEX ) );
				if( StringUtils.isBlank( fromPARAM.toString() ) == false && 
						StringUtils.endsWith( fromPARAM.toString() , aCOMPLEX ) == false ){
					fromPARAM.append( aCOMPLEX );
				}
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				UpfsvcManager.getRocket().rollbackTransaction();
				throw exception;
			}
			finally{
				
			}
			return fromPARAM.toString();
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 循环结构遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingForLImpl extends IMappingSystemImpl{
		public IMappingForLImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			java.util.List fromUpdcpm = null;
			try
			{
				String aJEXP[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				aJEXP = new String[]{aJEXP[0],aJEXP != null && aJEXP.length > 1?aJEXP[1]:fromUpfgsm.getCOMPETE()};
				fromUpdcpm = IUpdcpFactory.getIUpfvmSV().finishSFUpdbpfChain(fromUpfgsm.getCOMPETE(),
						aJEXP[1], 
						aJEXP[0], 
						fromOffer, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			java.util.List fromUpdcpm = null;
			try
			{
				String aJEXP = fromUpfgsm.getCOMPLEX();
				aJEXP = StringUtils.isBlank( aJEXP )?fromUpfgsm.getCOMPETE():aJEXP;
				fromUpdcpm = IUpdcpFactory.getIUpfvmSV().finishSFUpdforChain(fromUpfgsm, 
						aJEXP, 
						fromOffer, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 统一序列编号遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingSIDImpl extends IMappingSystemImpl{
		public IMappingSIDImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			java.math.BigDecimal fromUpffmx = null;
			try
			{
				fromUpffmx = UpdcpFactory.getIUpdcpDAO().getSEQUENCE(fromUpfgsm.getCOMPLEX());
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
				fromUpffmx = UpdcpFactory.getIUpdcpDAO().getSEQUENCE(fromUpfgsm.getCOMPLEX());
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 操作流水号[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2016年9月6日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingSQLIDImpl extends IMappingSystemImpl{
		public IMappingSQLIDImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				IOVTaskPentium fromTASK = UpdcUtils.ISubFlow.getTASK( aContext );
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				fromUpffmx = MathUtils.IMath.sequence(fromTASK.getREGION_ID(), 
						fromTASK.getTASK_ID(), 
						aCOMPLEX != null?Integer.parseInt( aCOMPLEX ):0 );
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
				IOVTaskPentium fromTASK = UpdcUtils.ISubFlow.getTASK( aContext );
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				fromUpffmx = MathUtils.IMath.sequence(fromTASK.getREGION_ID(), 
						fromTASK.getTASK_ID(), 
						aCOMPLEX != null?Integer.parseInt( aCOMPLEX ):0 );
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: IP转换16进制遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月19日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingIPXImpl extends IMappingSystemImpl{
		public IMappingIPXImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			String fromIPHEX = null;
			try
			{
				String aCOMPLEX[] = new String[] { fromUpfgsm.getCOMPETE() };
				if (StringUtils.isBlank(fromUpfgsm.getCOMPLEX()) == false){
					aCOMPLEX = UpfgsmUtils.IUpfsm.getISTKJexpL(fromUpfgsm.getCOMPLEX());
				}
				String fromADDR = (String) UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, fromOffer, (String) aCOMPLEX[0], aContext);
				if (aCOMPLEX != null && aCOMPLEX.length > 1 && fromADDR != null){
					fromADDR = (String) UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, fromOffer, (String) aCOMPLEX[1], aContext);
				}
				if (StringUtils.isBlank(fromADDR) == false){ fromIPHEX = MathUtils.IMath.ip2hex( fromADDR );}
			}
			finally{
				
			}
			return fromIPHEX;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			String fromIPHEX = null;
			try
			{
				String aCOMPLEX[] = new String[] { fromUpfgsm.getCOMPETE() };
				if (StringUtils.isBlank(fromUpfgsm.getCOMPLEX()) == false)
					aCOMPLEX = UpfgsmUtils.IUpfsm.getISTKJexpL(fromUpfgsm.getCOMPLEX());
				String fromADDR = (String) UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm,
						fromOffer, (String) aCOMPLEX[0], aContext);
				if (aCOMPLEX != null && aCOMPLEX.length > 1 && fromADDR != null)
					fromADDR = (String) UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm,
							fromOffer, (String) aCOMPLEX[1], aContext);
				if (StringUtils.isBlank(fromADDR) == false)
					fromIPHEX = MathUtils.IMath.ip2hex( fromADDR );
			}
			finally{
				
			}
			return fromIPHEX;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年1月25日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingPSWDImpl extends IMappingSystemImpl{
		
		public IMappingPSWDImpl() {
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{	
				String  fromUpffmx = null;
				String aCOMPLEX[] = StringUtils.split( fromUpfgsm.getCOMPLEX(), "," );
				if( aCOMPLEX != null && aCOMPLEX.length == 2 && StringUtils.isNumeric( aCOMPLEX[1] ) ){
					fromUpffmx = EncryptUtils.IIdentity.getRandomBuffer( aCOMPLEX[0], 
							Integer.parseInt( aCOMPLEX[1] ) );
				}
				fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, fromUpffmx );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpdffsm(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{	
				String aCOMPLEX[] = StringUtils.split( fromUpfgsm.getCOMPLEX(), "," );
				if( aCOMPLEX != null && aCOMPLEX.length == 2 && StringUtils.isNumeric( aCOMPLEX[1] ) ){
					fromUpffmx = EncryptUtils.IIdentity.getRandomBuffer( aCOMPLEX[0], 
							Integer.parseInt( aCOMPLEX[1] ) );
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: RC2密码解密映射规范</p>
	 * <p>Copyright: Copyright (c) 2017年1月25日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingDecryptImpl extends IMappingSystemImpl{
		
		public IMappingDecryptImpl() {
			super();
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
				Object fromUpffmx = UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromUser.getNATURE(), 
						aCOMPLEX, 
						aContext);
				if( fromUpffmx != null && ClassUtils.IClass.isPrimitive( fromUpffmx ) ){
					fromUpdcpm = UpdcpUtils.ICustom.wrap( fromUpfgsm, EncryptUtils.RC2.decrypt( fromUpffmx.toString() ) );
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpdffsm(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
		 */
		public Object finishSFUpfgsmc(ISystemTemplate.IUpfgsmxOffer fromUpfgsm, java.util.Map fromOffer, IUpdcContext aContext) throws SFException, Exception {
			Object fromUpffmx = null;
			try
			{
				String aCOMPLEX = fromUpfgsm.getCOMPLEX();
				if( StringUtils.isBlank( aCOMPLEX ) ){ aCOMPLEX = fromUpfgsm.getCOMPETE(); }
				fromUpffmx = UpfgsmUtils.IUpfsm._jj_context(fromUpfgsm, 
						fromUpfgsm.getCOMPETE(), 
						fromOffer, 
						aCOMPLEX, 
						aContext);
				if( fromUpffmx != null ){
					fromUpffmx = EncryptUtils.RC2.decrypt( fromUpffmx.toString() );
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
	}
}
