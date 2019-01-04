package com.ai.sacenter.comptel.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.comptel.dbcp.IMappingSystemImpl;
import com.ai.sacenter.core.bo.ISAOffer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务用户变量遍历规范[服务能力规范]</p>
 * <p>Copyright: Copyright (c) 2015年10月14日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IMappingUserImpl extends IMappingSystemImpl {
	public IMappingUserImpl() {
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
			fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpUserX(fromUpfgsm, 
					fromUser, 
					aContext);
		}
		finally{
			
		}
		return fromUpdcpm != null?new IOVUpdcpOffer[]{ fromUpdcpm }:null;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.IUpdcContext)
	 */
	public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
		IOVUpdcpOffer fromUpdcpm = null;
		try
		{
			String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
			if( aCOMPLEX == null || aCOMPLEX.length < 1 ){
				ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
			}
			fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpUserX(fromUpfgsm, 
					fromUser, 
					aContext);
		}
		finally{
			
		}
		return fromUpdcpm;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务产品能力遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingOfferImpl extends IMappingSystemImpl{
		public IMappingOfferImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer[] fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpOffer(fromUpfgsm, 
						fromUser, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer, com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.comptel.bo.IOVUpdcpOffer, com.ai.sacenter.IUpdcContext)
		 */
		public void finishSFUpfgsmc(IProfessionalTemplate.IProductOffer fromUpdbcpm, IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVUpdcpOffer fromUpdcpm, IUpdcContext aContext) throws SFException, Exception {
			try
			{
				HQSQLTable _table = UpdcpmUtils.getCOMPOSITE();
				HQSQLTable.HQSQLColumn _column = _table.getProperty( ISAOffer.S_Comptel );
				if( fromUpdcpm.getCOMPTEL() == null || fromUpdcpm.getCOMPTEL().length() == 0 ){
					if( _column.isASTNoNull() ){
						ExceptionFactory.throwIllegal("IOS0011095", new String[]{ fromUpfgsm.getID(), fromUpfgsm.getCOMPETE() } );
					}
				}
				else if( fromUpdcpm.getCOMPTEL().length() > _column.getMaxLength() ){
					ExceptionFactory.throwIllegal("IOS0011095", new String[]{ fromUpfgsm.getID(), fromUpfgsm.getCOMPETE() } );
				}
				String fromPARAM[] = SystemUtils.ICustom.substringAsL( fromUpdcpm.getCOMPLEX(), ";" );
				if( fromPARAM != null && fromPARAM.length > 5 ){
					ExceptionFactory.throwIllegal("IOS0011095", new String[]{ fromUpfgsm.getID(), fromUpfgsm.getCOMPETE() } );
				}
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpLifite(fromUpfgsm, 
						fromUser, 
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
	 * <p>Description: 服务产品变量遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月22日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingOfferXImpl extends IMappingSystemImpl{
		public IMappingOfferXImpl(){
			super();
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 服务批量属性遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2016年7月12日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingBatchXImpl extends IMappingSystemImpl{
		public IMappingBatchXImpl(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpBatchX(fromUpfgsm, 
						fromUser, 
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
	 * <p>Description: 服务类能力遍历规范[服务能力规范]</p>
	 * <p>Copyright: Copyright (c) 2015年10月22日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingComptelImpl extends IMappingSystemImpl{
		public IMappingComptelImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpComptel(fromUpfgsm, 
						fromUser, 
						aContext);
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
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpComptel(fromUpfgsm, 
						fromUser, 
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
	 * <p>Description: 服务变化遍历规范</p>
	 * <p>Copyright: Copyright (c) 2015年10月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IMappingChangeImpl extends IMappingSystemImpl{
		public IMappingChangeImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpChange(fromUpfgsm, 
						fromUser, 
						aContext);
				if( StringUtils.isBlank( fromUpdcpm.getCOMPTEL() ) ){ fromUpdcpm = null; }
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
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpChange(fromUpfgsm, 
						fromUser, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年5月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingGroupImpl extends IMappingSystemImpl{
		public IMappingGroupImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpLifite(fromUpfgsm, 
						fromUser, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm != null?new IOVUpdcpOffer[]{ fromUpdcpm }:null;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception{
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpLifite(fromUpfgsm, 
						fromUser, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年5月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingMultleImpl extends IMappingSystemImpl{
		public IMappingMultleImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm[] = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpMultle(fromUpfgsm, 
						fromUser, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm != null && fromUpdcpm.length > 0?fromUpdcpm:null;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception{
			IOVUpdcpOffer[] fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpMultle(fromUpfgsm, 
						fromUser, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm != null && fromUpdcpm.length > 0?fromUpdcpm[ fromUpdcpm.length - 1]:null;
		}
	}
	/**
	 * 服务功能优先级
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年8月16日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMappingMutexImpl extends IMappingSystemImpl{
		public IMappingMutexImpl(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer[] finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception {
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpPriority(fromUpfgsm, 
						fromUser, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm != null?new IOVUpdcpOffer[]{ fromUpdcpm }:null;
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.dbcp.IMappingSystemImpl#finishSFUpfgsmc(com.ai.sacenter.valuebean.IProfessionalTemplate.IUpdbfgsmxOffer, com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser, com.ai.sacenter.common.IUpdcContext)
		 */
		public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, IOVOrderUser fromUser, IUpdcContext aContext) throws SFException, Exception{
			IOVUpdcpOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcpFactory.getIUpdcpSV().finishSFUpdcpPriority(fromUpfgsm, 
						fromUser, 
						aContext);
			}
			finally{
				
			}
			return fromUpdcpm;
		}
	}
}
