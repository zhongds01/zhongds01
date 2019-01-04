package com.ai.sacenter.cboss.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cboss.IUpfgsmConst;
import com.ai.sacenter.cboss.IUpfgsmFactory;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.provision.dbcp.impl.IHttpProtocolImpl;
import com.ai.sacenter.provision.dbcp.impl.IUpfbpmCapitalImpl;
import com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.HttpServletWrapper;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

public class IUpfgsmCapitalImpl extends IUpfwmCapitalImpl{

	public IUpfgsmCapitalImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-cboss</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author jitao
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmJWPIfoImpl extends IUpfwmCapitalImpl{
		
		public IUpfgsmJWPIfoImpl() {
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfgsmFactory.getIUpfgsmSV().finishSFUpfgkmOffer(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-cboss</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author jitao
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmJWJFfoImpl extends IUpfwmCapitalImpl{
		
		public IUpfgsmJWJFfoImpl() {
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfgsmFactory.getIUpfgsmSV().finishSFUpfgxmOffer(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-cboss</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author jitao
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmAllSTSImpl extends IUpfwmCapitalImpl{
	
		public IUpfgsmAllSTSImpl() {
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfgsmFactory.getIUpfgsmSV().finishSFUpfgsmStatus(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-cboss</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月8日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author jitao
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmTDKIfoImpl extends IUpfwmCapitalImpl{
		public IUpfgsmTDKIfoImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfgsmFactory.getIUpfgsmSV().finishSFUpfgsmBrand(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}	
	}
	/**
	 * 
	 * <p>Title: sacenter-cboss</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月8日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author jitao
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmPSPIfoImpl extends IUpfwmCapitalImpl{
		public IUpfgsmPSPIfoImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfgsmFactory.getIUpfgsmSV().finishSFUpfgkmPassive(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}	
	}
	/**
	 * 
	 * <p>Title: sacenter-cboss</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月8日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author jitao
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmPSJFfoImpl extends IUpfwmCapitalImpl{
		public IUpfgsmPSJFfoImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.provision.dbcp.impl.IUpfwmCapitalImpl#finishSFUpdfwm(com.ai.sacenter.core.valuebean.IOVOrderPentium, com.ai.sacenter.core.valuebean.IOVTaskPentium, com.ai.sacenter.valuebean.IOVUpdspmLife, com.ai.sacenter.IUpdcContext)
		 */
		public IOVUpfwmResponse finishSFUpdfwm(IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
				IUpdcContext aContext) throws SFException, Exception {
			IOVUpfwmResponse fromASK = null;
			try
			{
				fromASK = IUpfgsmFactory.getIUpfgsmSV().finishSUpfgxmPassive(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						aContext);
			}
			finally{
				
			}
			return fromASK;
		}	
	}
	/**
	 * 
	 * <p>Title: sacenter-cboss</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年3月8日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author jitao
	 * @version 2.0 
	 *
	 */
	public static class IUpfgsmTPPIfoImpl extends IUpfbpmCapitalImpl{
		public IUpfgsmTPPIfoImpl(){
			super();
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: 与COSS测透传报文分析器</p>
		 * <p>Copyright: Copyright (c) 2013-3-22</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public static class IUpfgsmProtocolImpl extends IHttpProtocolImpl.HttpMapProtocolImpl{
			public IUpfgsmProtocolImpl(){
				super();
			}
			
			
			/* (non-Javadoc)
			 * @see com.ai.ucmframe.provision.dbcp.impl.IUpfwmProtocolImpl#finishASKUpfwm(com.ai.ucmframe.provision.valuebean.IOVUpfwmOffer, com.ai.ucmframe.valuebean.IOVUpdspmLife, java.lang.Object, com.ai.ucmframe.common.IUpdcContext)
			 */
			public IOVUpfwmResponse finishASKUpfwm(IOVUpfwmOffer fromUpfwm,
					IOVUpdspmLife fromUpdfwm, 
					Object fromRsBody,
					IUpdcContext aContext) throws SFException, Exception {
				IOVUpfwmResponse fromUpdcpm = null;
				HttpServletWrapper fromHttp = null;
				try
				{
					fromUpdcpm = new IOVUpfwmResponse( fromUpfwm );
					String fromRsRsp = MathUtils.IMath.toString( fromRsBody );
					fromHttp = new HttpServletWrapper( fromRsRsp );	
					fromUpdcpm.setFAILURE  ( Boolean.FALSE );
					fromUpdcpm.setRspResult( fromRsRsp     );
					fromUpdcpm.setRspBottom( fromRsRsp     );
					if( StringUtils.isBlank( fromHttp.getPARAM() ) == false && 
							fromHttp.getQUERY().size() > 0 ){
						String fromCODING = fromHttp.getAsString( "RspCode" );
						String fromDESCRIBE = fromHttp.getAsString( "RspDesc" );
						fromUpdcpm.setFAILURE( StringUtils.equals(fromCODING, 
								IUpfgsmConst.IUpfrsp.SUCCEED)?Boolean.FALSE:Boolean.TRUE );
						fromUpdcpm.setRspCode ( fromCODING   );
						fromUpdcpm.setRspDesc ( fromDESCRIBE );
					}
				}
				finally{
					if( fromHttp != null ){ fromHttp = null; }
				}
				return fromUpdcpm;
			}
		}
	}
}
