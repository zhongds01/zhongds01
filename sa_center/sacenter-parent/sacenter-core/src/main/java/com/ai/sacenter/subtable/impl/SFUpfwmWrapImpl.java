package com.ai.sacenter.subtable.impl;

import com.ai.appframe2.complex.tab.id.IIdGeneratorWrapper;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.provision.bo.IISANotifyIndex;
import com.ai.sacenter.provision.bo.ISAProvision;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.subtable.ISubSQLOffer;
import com.ai.sacenter.subtable.ISubTableWrapper;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISubTableTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元工单分表机制</p>
 * <p>Copyright: Copyright (c) 2013-7-25</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFUpfwmWrapImpl extends SFSubTableWrapImpl {
	private static final long serialVersionUID = 2990671471052715750L;
	public SFUpfwmWrapImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元工单类型分表机制</p>
	 * <p>Copyright: Copyright (c) 2013-7-25</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICompositeWrapperImpl extends SFTableSplitWrapImpl{
		private static final long serialVersionUID = 7689084947920603306L;
		public ICompositeWrapperImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, 
				String fromCol, 
				Object fromComposite) throws Exception {
			String fromCustom = "";
			try
			{
				ISubTableTemplate.ISubSQLTableCau fromCatalog = null;
				String fromUpffmx[] = new String[]{(String)fromComposite, "*"  };
				for( int index = 0; fromUpffmx != null && index < fromUpffmx.length; index++ ){
					fromCatalog = UpfwmUtils.ISystem.getSubTableCau(fromTable, fromCol, fromUpffmx[index] );
					if( fromCatalog != null ) { break; }
				}
				fromCustom = fromCatalog != null?(StringUtils.isBlank( fromCatalog.getSUFFIX_A() )?"":fromCatalog.getSUFFIX_A()):null;
				if( fromCustom == null ){
					ExceptionFactory.throwIllegal( "IOS0014012", new String[]{fromTable, fromCol, (String)fromComposite } );
				}
			}
			finally{
				
			}
			return fromCustom;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元根目录分表机制[分表规则转换规范]</p>
	 * <p>Copyright: Copyright (c) 2014-9-27</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICatalogWrapperImpl extends SFTableSplitWrapImpl{
		private static final long serialVersionUID = -5831088683945537706L;
		public ICatalogWrapperImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, String fromCol, Object fromObj) throws Exception {
			String fromCustom = "";
			try
			{
				ISubTableTemplate.ISubSQLTableCau fromCAU = null;
				IPlatformTemplate.IUpffmOffer fromUpfm[] = null;
				fromUpfm = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( fromObj.toString() );
				fromCAU = UpfwmUtils.ISystem.getSubTableCau(fromTable, fromCol, fromUpfm[ fromUpfm.length - 1 ].getID() );
				if( fromCAU == null ){
					ExceptionFactory.throwIllegal( "IOS0014012", new String[]{fromTable, fromCol, fromUpfm[ fromUpfm.length - 1 ].getID()});
				}
				fromCustom = fromCAU.getSUFFIX_A();
			}
			finally{
				
			}
			return fromCustom;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元目录分表机制</p>
	 * <p>Copyright: Copyright (c) 2014-9-27</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IPlatformWrapperImpl extends SFTableSplitWrapImpl{
		private static final long serialVersionUID = -8884917189604785520L;
		public IPlatformWrapperImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, String fromCol, Object fromObj) throws Exception {
			String fromCatalog = "";
			try
			{
				ISubTableTemplate.ISubSQLTableCau fromCAU = null;
				fromCAU = UpfwmUtils.ISystem.getSubTableCau(fromTable, fromCol, (String)fromObj );
				if( fromCAU == null ){
					ExceptionFactory.throwIllegal( "IOS0014012", new String[]{fromTable, fromCol, (String)fromObj});
				}
				fromCatalog = fromCAU.getSUFFIX_A();
			}
			finally{
				
			}
			return fromCatalog;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 网元上发索引分表规范</p>
	 * <p>Copyright: Copyright (c) 2017年2月22日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class INotifyWrapperImpl extends SFTableSplitWrapImpl{
		private static final long serialVersionUID = -1957200660456438600L;
		public INotifyWrapperImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, String fromColumn, Object fromObject) throws Exception {
			String fromCustom = null;
			try
			{
				ISubTableTemplate.ISubSQLTableCau fromCatalog = null;
				java.util.Map fromPARAM = (java.util.Map)fromObject;
				String aPLATFORM = (String)fromPARAM.get( IISANotifyIndex.S_Platform );
				String aCATEGORY = (String)fromPARAM.get( IISANotifyIndex.S_Category );
				String fromUpffmx[][] = new String[][]{{aPLATFORM, aCATEGORY},{aPLATFORM, "*"  }};
				for(int index = 0; fromUpffmx != null && index < fromUpffmx.length; index++ ){
					String fromINDEX = ClassUtils.getINDEX( new String[]{fromUpffmx[index][0],
							"_", fromUpffmx[index][1]} );
					fromCatalog = UpfwmUtils.ISystem.getSubTableCau(fromTable, fromColumn, fromINDEX );
					if( fromCatalog != null ) { break; }
				}
				if( fromCatalog != null ) fromCustom = fromCatalog.getSUFFIX_A();
			}
			finally{
				
			}
			return fromCustom;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#magnetic(java.lang.String, java.lang.String, java.util.Map)
		 */
		public Object magnetic(String fromTable, String fromCol, java.util.Map fromPARAM) throws Exception {
			java.util.Map fromUpffmx = new java.util.HashMap();
			try
			{
				ClassUtils.IMerge.merge( new Object[][]{{IISANotifyIndex.S_Platform, 
					fromPARAM.get( IISANotifyIndex.S_Platform )},
					{IISANotifyIndex.S_Category, 
						fromPARAM.get( IISANotifyIndex.S_Category )}}, 
						fromUpffmx, true );
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元工单号统一编码化</p>
	 * <p>Copyright: Copyright (c) 2014-7-20</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmIdWrapperImpl extends SFSubTableWrapImpl implements IIdGeneratorWrapper{
		private static final long serialVersionUID = 4932186206828523431L;
		public IUpfwmIdWrapperImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.appframe2.complex.tab.id.IIdGeneratorWrapper#wrapper(long)
		 */
		public long wrapper(long aORDER_ID) {
			long fromOrder = 0;
			try
			{
				ISubTableTemplate.IdGenerator fromIIdGen = null;
				SFCenterOffer _centeroffer = SFCenterFactory.getCenterInfo();
				String fromTABLE = ISAProvision.S_TYPE.getMapingEnty();
				fromIIdGen = IUpdcfgFactory.getIBasicSV().getSFIdGenerator(fromTABLE, 
						_centeroffer.getCHANNEL_ID(), 
						_centeroffer.getREGION_ID() );
				if( fromIIdGen == null || StringUtils.isBlank( fromIIdGen.getREGION_NUMBER() ) ){
					ExceptionFactory.throwIllegal("IOS0011031", new String[]{fromTABLE,
							ClassUtils.getINDEX( new String[]{"SEQUENCE","/","REGION_NUMBER"}) } );
				}
				fromOrder = Long.parseLong( fromIIdGen.getREGION_NUMBER() ) * 
						10000000000L + aORDER_ID;
			}
			catch( java.lang.Exception aEXCEPTION ){
				ExceptionFactory.throwRuntime( aEXCEPTION );
			}
			finally{
				
			}
			return fromOrder;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元工单转移配置规范</p>
	 * <p>Copyright: Copyright (c) 2014-7-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmWrapperTfImpl extends SFSubTableWrapImpl implements ISubTableWrapper{
		private static final long serialVersionUID = -2045578044492678336L;
		public IUpfwmWrapperTfImpl(){
			super();
		}
		/**
		 * 网元工单转移预处理
		 * @param fromUpfwm
		 * @param fromSubSQL
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		protected void before( IOVUpfwmOffer fromUpfwm, ISubSQLOffer fromSubSQL, IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IPlatformTemplate.IUpffmOffer fromUpfm = null;
				IPlatformTemplate.IUpffmDirective fromUpdfm = null;
				IPlatformTemplate.IUpffmOperate fromUpfom = null;
				fromUpfm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( fromUpfwm.getPLATFORM() );
				fromUpdfm = IUpdcfgFactory.getIUpffmSV().getSFUpffmLogical( fromUpfwm.getDIRECTIVE() , fromUpfm );
				fromUpfom = IUpdcfgFactory.getIUpffmSV().getSFUpffmOperate( fromUpdfm.getOPERATE_() , fromUpfm );
				aContext.put( IUpdcConst.IUpdbm.IUpdbf.PROVISION , fromUpfwm );
				aContext.put( IUpdcConst.IUpdbm.IUpdbf.COMPETENCE, fromUpfwm.getORDER().getOFFER() );
				aContext.put( IUpdcConst.IUpdbm.IUpdbf.PLATFORM  , fromUpfm  );
				aContext.put( IUpdcConst.IUpdbm.IUpdbf.OPERATE   , fromUpfom );
			}
			finally{
				
			}
		}
		
		/**
		 * 网元工单转移后处理
		 * @param fromUpfwm
		 * @param fromSubTabRel
		 * @param fromHQSQL
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		protected void finall( IOVUpfwmOffer fromUpfwm, ISubSQLOffer fromSubSQL, IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				aContext.clear();
			}
			finally{
				
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFSubTableWrapImpl#transform(com.ai.sacenter.jdbc.HQSQLEntityBean, com.ai.sacenter.subtable.ISubSQLOffer, com.ai.sacenter.IUpdcContext)
		 */
		public java.util.HashMap transform(HQSQLEntityBean fromBroke, ISubSQLOffer fromSubSQL, IUpdcContext aContext) throws SFException, Exception {
			java.util.HashMap fromUpdbm = null;
			IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
			try
			{
				IOVUpfwmOffer fromUpfwm = new IOVUpfwmOffer( fromBroke.getProperties() );
				try
				{
					before(fromUpfwm, fromSubSQL, fromLDAP);
					ISubSQLOffer.IUpdfmxOffer fromUpdfmx = fromSubSQL.getSubFlow();
					java.util.HashMap fromORACLE = transfer(fromBroke, fromSubSQL, aContext);
					fromUpdbm = OracleUtils.ISystem.wrap( fromUpdfmx.getSubJect(), new java.util.HashMap[]{ fromORACLE } );
				}
				finally{
					finall(fromUpfwm, fromSubSQL, fromLDAP);
					if( fromUpfwm != null ){ fromUpfwm = null; }
				}
			}
			finally{
				if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
			}
			return fromUpdbm;
		}
		
	}
}
