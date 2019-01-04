package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

/**
 * <p>Title: ucmframe</p>
 * <p>Description:  网路路由配置</p>
 * <p>Copyright: Copyright (c) 2015-1-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmDefine implements java.io.Serializable{
	private static final long serialVersionUID = -5633358829295014094L;
	/*网路路由编码*/
	private String ID_;
	/*网元基本信息*/
	private IUpffmNetWork PLATFORM_;
	/*网路路由*/
	private java.util.List NETWORK_ = new java.util.ArrayList();
	/*网元路由扩展属性*/
	private java.util.Map STUB_   = new java.util.HashMap();
	/*全局路由属性*/
	private java.util.Map GLOBAL_ = new java.util.HashMap();
	/*XML内容*/
	private org.dom4j.Element ROOT_ = null;
	public IUpfwmDefine( IUpfwsxDefine fromUpfwsx ,
			IUpffmNetWork fromUpffm,
			org.dom4j.Element aElement ) throws Exception{
		super();
		ROOT_ = aElement;
		PLATFORM_ = fromUpffm;
		ID_ = ROOT_.attributeValue( "id" , IUpdcConst.IEnum.ISschk.NULL );
		JdomUtils.IJdom.getIJDX$StubL( ROOT_ , STUB_ );
		ClassUtils.IMerge.merge( STUB_, GLOBAL_ );
		ClassUtils.IMerge.atomIn( fromUpfwsx.getSTUB_() , GLOBAL_ );
	}
	/**
	 * @return 网路路由编码
	 */
	public String getID_() {
		return ID_;
	}
	/**
	 * @return 网路路由
	 */
	public java.util.List getNETWORK_() {
		return NETWORK_;
	}
	/**
	 * @return 网路路由规范
	 */
	public IUpffmNetWork getPLATFORM_() {
		return PLATFORM_;
	}
	/**
	 * @return 扩展属性
	 */
	public java.util.Map getSTUB_() {
		return STUB_;
	}
	/**
	 * @return 全局路由属性
	 */
	public java.util.Map getGLOBAL_() {
		return GLOBAL_;
	}
	/**
	 * @return 网路配置
	 */
	public org.dom4j.Element getROOT_() {
		return ROOT_;
	}
	/**
	 * 
	 * @return
	 */
	public String getURL_( ){
		String fromURL_ = null;
		try
		{
			fromURL_ = PLATFORM_.getID();
			for( java.util.Iterator itera = NETWORK_.iterator(); itera.hasNext(); ){
				IUpfwmCauDefine fromNetWork = (IUpfwmCauDefine)itera.next();
				if( StringUtils.isBlank( fromNetWork.URL ) == false ){
					fromURL_ = fromNetWork.URL;
					break;
				}
			}
		}
		finally{
			
		}
		return fromURL_;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元路由配置</p>
	 * <p>Copyright: Copyright (c) 2011-10-25</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmCauDefine implements java.io.Serializable{
		private static final long serialVersionUID = 8507120690237138875L;
		private String URL;
		private String USE;
		private org.dom4j.Element ROOT_;
		public IUpfwmCauDefine( org.dom4j.Element aElement ) throws Exception{
			super();
			URL = aElement.attributeValue( "url" );
			USE = aElement.attributeValue("use", "TRUE").toUpperCase();
			ROOT_ = aElement;
		}
		/**
		 * @return 服务端地址
		 */
		public String getURL() {
			return URL;
		}
		
		/**
		 * @return 是否启用
		 */
		public boolean getUSE() {
			return USE == null || USE.equalsIgnoreCase("true");
		}
		/**
		 * @return 网路路由
		 */
		public org.dom4j.Element getROOT_() {
			return ROOT_;
		}
	}
}
