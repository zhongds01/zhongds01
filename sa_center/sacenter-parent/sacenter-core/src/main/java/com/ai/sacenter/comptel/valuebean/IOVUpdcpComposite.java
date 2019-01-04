package com.ai.sacenter.comptel.valuebean;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年8月27日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class IOVUpdcpComposite implements java.io.Serializable{
	private static final long serialVersionUID = 6114695943677896043L;
	public IOVUpdcpComposite(){
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 服务产品批量集</p>
	 * <p>Copyright: Copyright (c) 2017年8月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IOVUpdcpMultle implements java.io.Serializable{
		private static final long serialVersionUID = 8424823670444482234L;
		private java.util.HashMap _multle = new java.util.HashMap();
		public IOVUpdcpMultle(){
			super();
		}
		
		public IOVUpdcpMultle( ISystemTemplate.IUpfgsmOffer fromUpfgsm ) throws Exception{
			super();
			IUpffmxOffer __catalog__ = null;
			IProfessionalTemplate.IProductOffer fromUpffx = UpdcpUtils.ICustom._wrap( fromUpfgsm );
			if( fromUpfgsm.isUpdcpm() /*服务产品影射级*/){
				__catalog__ = new IUpffmxCatalog( fromUpffx.getCOMPETE(), fromUpffx );
				_multle.put( fromUpffx.getCOMPETE(), __catalog__ );
			}
			else/*产品属性级映射单元*/{
				__catalog__ = new IUpffmxMultle( fromUpffx.getCOMPETE(), fromUpffx );
				_multle.put( fromUpffx.getCOMPETE(), __catalog__ );
				_readfrommultle( fromUpffx, fromUpfgsm, _multle );
			}
		}
		
		/**
		 * 
		 * @param fromGroup
		 * @param fromUpfgsm
		 * @param fromMultle
		 * @throws Exception
		 */
		private void _readfrommultle( IProfessionalTemplate.IProductOffer fromGroup, 
				ISystemTemplate.IUpfgsmOffer fromUpfgsm, 
				java.util.HashMap fromMultle ) throws Exception{
			try
			{
				for( java.util.Iterator itera = fromGroup.getSUBFLOW().iterator(); itera.hasNext(); ){
					IProfessionalTemplate.IUpdbfgsmxOffer fromUpffgmx = (IProfessionalTemplate.IUpdbfgsmxOffer)itera.next();
					IProfessionalTemplate.IProductOffer fromUpffx = fromUpffgmx.getMAPPING_();
					IProfessionalTemplate.IProductComptel fromUpffmx = fromUpffx != null?fromUpffx.getCOMPTEL():null;
					if( fromUpffmx != null && fromUpffmx.getCOMPTELX().isMULTLE() ){
						fromMultle.put( fromUpffgmx.getMAPPING(), new IUpffmxMultle( fromUpffgmx.getMAPPING(), fromUpffx ) );
						_readfrommultle( fromUpffx, fromUpfgsm, fromMultle );
					}
					else{
						fromMultle.put( fromUpffgmx.getMAPPING(), new IUpffmxBasic( fromUpffgmx.getMAPPING(), fromUpffx ) );
						_readfrommultle( fromUpffx, fromUpfgsm, fromMultle );
					}
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 获取服务产品批量集
		 * @return
		 */
		public java.util.HashMap getMultle(){
			return _multle;
		}
		
		/**
		 * 根据当前服务属性编码获取当前批量服务属性,如不存在则创建基本服务属性
		 * @param _compete 服务属性编码
		 * @return
		 */
		public IUpffmxOffer getMultle( Object _compete ){
			IUpffmxOffer multle = (IUpffmxOffer)_multle.get( _compete );
			if( multle == null ){ _multle.put( _compete, multle = new IUpffmxBasic( _compete.toString() ) ); }
			return multle;
		}
		
		/**
		 * 根据当前服务属性编码获取当前批量服务属性
		 * @param fromUpffx 服务属性编码
		 * @return
		 */
		public IUpffmxOffer getMultle( IProfessionalTemplate.IProductOffer fromUpffx ){
			return (IUpffmxOffer)_multle.get( fromUpffx.getCOMPETE() );
		}
		
		/**
		 * 
		 * @param fromUpfgsm
		 * @param fromUser
		 * @param fromUpdcpm
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void submitAsMultle(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
				IOVOrderUser fromUser,
				IOVUpdcpOffer fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			IProfessionalTemplate.IProductOffer fromUpffx = UpdcpUtils.ICustom._wrap( fromUpfgsm );
			IOVUpdcpComposite.IUpffmxOffer __multle__ = getMultle( fromUpffx.getCOMPETE() );
			if( fromUpfgsm.isUpdcpm() ){
				IOVUpdcpComposite.IUpffmxCatalog __catalog__ = (IOVUpdcpComposite.IUpffmxCatalog)__multle__;
				__catalog__._catalog.add( fromUpdcpm );
			}
			else{
				if( __multle__ != null ){ __multle__.submitAsLate( fromUpdcpm.getCOMPTEL() ); }
				for( java.util.Iterator itera = _multle.values().iterator(); itera.hasNext(); ){
					IOVUpdcpComposite.IUpffmxOffer multle = (IOVUpdcpComposite.IUpffmxOffer)itera.next();
					if( StringUtils.equals( __multle__.getCOMPETE(), multle.getCOMPETE() ) ) continue;
					multle.submitAsLate( fromUpdcpm.getCOMPLEX().remove( multle.getCOMPETE() ) );
				}
				for( java.util.Iterator itera = fromUpdcpm.getCOMPLEX().entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					if( fromEntry.getValue() == null ) continue;
					getMultle( fromEntry.getKey() ).submitAsLate( fromEntry.getValue().toString() );
				}
			}
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 开通服务属性基类</p>
	 * <p>Copyright: Copyright (c) 2017年8月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffmxOffer implements java.io.Serializable{
		private static final long serialVersionUID = -6069021213360422966L;
		private String _compete = null;
		private IProfessionalTemplate.IProductOffer _provider;
		public IUpffmxOffer( String compete ){
			super();
			_compete  = compete;
			_provider = null;
		}
		
		public IUpffmxOffer( String compete, IProfessionalTemplate.IProductOffer provider ){
			super();
			_compete  = compete;
			_provider = provider;
		}
		
		/**
		 * @return 开通服务编码
		 */
		public String getCOMPETE() {
			return _compete;
		}
		
		/**
		 * @return 服务产品提供者
		 */
		public IProfessionalTemplate.IProductOffer getPROVIDER() {
			return _provider;
		}

		/**
		 * 是否有效属性
		 * @return
		 */
		public boolean isCOMPLEX(){
			return false;
		}
		
		/**
		 * 是否为该服务能力
		 * @param nature 
		 * @return
		 */
		public boolean isCOMPLEX( IProfessionalTemplate.IProductOffer _nature ){
			return _provider != null && _nature != null && 
					StringUtils.equals( _provider.getID(), _nature.getID() );
		}
		
		/**
		 * 设置开通属性
		 * @param multle 开通属性值
		 */
		public void submitAsLate( Object multle ){
			
		}
		
		/**
		 * 返回当前开通功能
		 * @return
		 */
		public String getAsStatus(){
			return null;
		}
		
		/**
		 * 返回当前开通属性
		 * @return
		 */
		public String getAsLate(){
			return null;
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 开通服务属性基本类</p>
	 * <p>Copyright: Copyright (c) 2017年8月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffmxBasic extends IUpffmxOffer{
		private static final long serialVersionUID = 8696327397551269662L;
		private Object _multle = null;
		public IUpffmxBasic( String compete ){
			super( compete );
		}
		
		public IUpffmxBasic( String compete, IProfessionalTemplate.IProductOffer provider ){
			super( compete, provider );
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite.IUpffmxOffer#isCOMPLEX()
		 */
		public boolean isCOMPLEX() {
			return _multle != null?true:false;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite.IUpffmxOffer##submitAsLate(java.lang.Object)
		 */
		public void submitAsLate(Object multle) {
			super.submitAsLate( multle );
			if( multle != null ) { _multle = multle; }
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite.IUpffmxOffer##getAsStatus()
		 */
		public String getAsStatus() {
			return _multle != null?_multle.toString():null;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite.IUpffmxOffer##getAsLate()
		 */
		public String getAsLate() {
			return _multle != null?_multle.toString():null;
		}
		
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 开通批量属性类</p>
	 * <p>Copyright: Copyright (c) 2017年8月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffmxMultle extends IUpffmxOffer{
		private static final long serialVersionUID = 4543287409749994575L;
		private java.util.List _multle = new java.util.ArrayList();
		public IUpffmxMultle( String compete, IProfessionalTemplate.IProductOffer provider ){
			super( compete, provider );
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite.IUpffmxOffer##isCOMPLEX()
		 */
		public boolean isCOMPLEX() {
			for( java.util.Iterator itera = _multle.iterator(); itera.hasNext(); ){
				Object _objective = itera.next();
				if( _objective != null ){ return true; }
			}
			return false;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite.IUpffmxOffer##submitAsLate(java.lang.Object)
		 */
		public void submitAsLate(Object multle) {
			super.submitAsLate( multle );
			_multle.add( multle );
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite.IUpffmxOffer##getAsStatus()
		 */
		public String getAsStatus() {
			StringBuilder multle = new StringBuilder();
			try
			{
				for( java.util.Iterator itera = _multle.iterator(); itera.hasNext(); ){
					String _objective = (String)itera.next();
					if( _objective == null || multle.indexOf( _objective ) >= 0 ) continue;
					multle.append( _objective );
				}
			}
			finally{
				
			}
			return multle.toString();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite.IUpffmxOffer#getAsLate()
		 */
		public String getAsLate() {
			StringBuilder multle = new StringBuilder();
			for( int index = 0; _multle != null && index < _multle.size(); index++ ){
				Object _objective = (Object)_multle.get( index );
				if( index > 0 ){ multle.append( "/" ); }
				multle.append( _objective != null?_objective.toString():"" );
			}
			return multle.toString();
		}

	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2018年8月21日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffmxCatalog extends IUpffmxOffer{
		private static final long serialVersionUID = -7695992433829184658L;
		private java.util.List _catalog = new java.util.ArrayList();
		public IUpffmxCatalog( String compete, IProfessionalTemplate.IProductOffer provider ){
			super( compete, provider );
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.comptel.valuebean.IOVUpdcpComposite.IUpffmxOffer##isCOMPLEX()
		 */
		public boolean isCOMPLEX() {
			return _catalog != null && _catalog.size() > 0;
		}

		/**
		 * @return the _catalog
		 */
		public java.util.List getCatalog() {
			return _catalog;
		}
		
	}
}
