package com.ai.sacenter.provision.mstp;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

/**
 * <p>Title: ucmframe</p>
 * <p>Description:  ��··������</p>
 * <p>Copyright: Copyright (c) 2015-1-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmDefine implements java.io.Serializable{
	private static final long serialVersionUID = -5633358829295014094L;
	/*��··�ɱ���*/
	private String ID_;
	/*��Ԫ������Ϣ*/
	private IUpffmNetWork PLATFORM_;
	/*��··��*/
	private java.util.List NETWORK_ = new java.util.ArrayList();
	/*��Ԫ·����չ����*/
	private java.util.Map STUB_   = new java.util.HashMap();
	/*ȫ��·������*/
	private java.util.Map GLOBAL_ = new java.util.HashMap();
	/*XML����*/
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
	 * @return ��··�ɱ���
	 */
	public String getID_() {
		return ID_;
	}
	/**
	 * @return ��··��
	 */
	public java.util.List getNETWORK_() {
		return NETWORK_;
	}
	/**
	 * @return ��··�ɹ淶
	 */
	public IUpffmNetWork getPLATFORM_() {
		return PLATFORM_;
	}
	/**
	 * @return ��չ����
	 */
	public java.util.Map getSTUB_() {
		return STUB_;
	}
	/**
	 * @return ȫ��·������
	 */
	public java.util.Map getGLOBAL_() {
		return GLOBAL_;
	}
	/**
	 * @return ��·����
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
	 * <p>Description: ��Ԫ·������</p>
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
		 * @return ����˵�ַ
		 */
		public String getURL() {
			return URL;
		}
		
		/**
		 * @return �Ƿ�����
		 */
		public boolean getUSE() {
			return USE == null || USE.equalsIgnoreCase("true");
		}
		/**
		 * @return ��··��
		 */
		public org.dom4j.Element getROOT_() {
			return ROOT_;
		}
	}
}
