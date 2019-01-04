package com.ai.sacenter.valuebean;

import com.ai.sacenter.util.UUID;
import com.ai.sacenter.util.XmlUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年11月28日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpdbpmOffice implements java.io.Serializable{
	private static final long serialVersionUID = -5818253726648135786L;
	/*唯一编码*/
	private UUID _id = null;
	/*发起方工单*/
	private Object  _objective = null;
	/*发起方原始属性*/
	private IUpdbpmOfferHome _subflow = new IUpdbpmOfferHome();
	/*发起方局向属性*/
	private IUpdcpmOfferHome _program = new IUpdcpmOfferHome();
	public IOVUpdbpmOffice( Object objective) {
		super();
		_objective = objective;
		_id        = UUID.getUUID();
	}
	
	/**
	 * @return 唯一编码
	 */
	public UUID getID() {
		return _id;
	}

	/**
	 * @return 发起方工单
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return 发起方原始属性
	 */
	public IUpdbpmOfferHome getSUBFLOW() {
		return _subflow;
	}
	
	/**
	 * @return 发起方局向属性
	 */
	public IUpdcpmOfferHome getPROGRAM() {
		return _program;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String fromXML = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "InterBOSS" );
			_root.addElement( "ID" ).setText( _id.toString() );
			XmlUtils.IXml._createIXml( _root, null, _subflow );
			org.dom4j.Element _element = _root.addElement( "PROGRAM" );
			if( _program != null ){
				XmlUtils.IXml._createIXml( _element, null, _program );
			}
			fromXML = document.asXML();
		}
		catch( java.lang.Exception exception ){
			exception.printStackTrace();
			fromXML = super.toString();
		}
		finally{
			
		}
		return fromXML;
	}

	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-5-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbpmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 2619033863860603199L;
		/*用户编号*/
		private long    _user_id        ;
		/*用户号码*/
		private String  _bill_id        ;
		/*次计费号*/
		private String  _sub_bill_id    ;
		/*局向编码*/
		private String  _headnum        ;
		/*局向类型*/
		private String  _category       ;
		/*用户所在地市编码*/
		private String  _user_region_id ;
		/*订单所在地市编码*/
		private String  _order_region_id;
		/*网元地市*/
		private String  _region_code    ;
		/*地市编码*/
		private String  _region_id      ;
		/*其它属性*/
		private java.util.Map _subflow = new java.util.HashMap();
		/*号码局向组件*/
		private ISystemTemplate.IUpfgkmOfficeX  _component  = null;
		public IUpdbpmOfferHome(){
			super();
		}
		
		/**
		 * @return 用户编号
		 */
		public long getUSER_ID() {
			return _user_id;
		}
		
		/**
		 * @param user_id 用户编号
		 */
		public void setUSER_ID(long user_id) {
			_user_id = user_id;
		}
		
		/**
		 * @return 用户号码
		 */
		public String getBILL_ID() {
			return _bill_id;
		}
		
		/**
		 * @param bILL_ID 用户号码
		 */
		public void setBILL_ID(String bILL_ID) {
			_bill_id = bILL_ID;
		}
		
		/**
		 * @return 次计费号
		 */
		public String getSUB_BILL_ID() {
			return _sub_bill_id;
		}

		/**
		 * @param sUB_BILL_ID 次计费号
		 */
		public void setSUB_BILL_ID(String sUB_BILL_ID) {
			_sub_bill_id = sUB_BILL_ID;
		}

		/**
		 * @return 局向编码
		 */
		public String getHEADNUM() {
			return _headnum;
		}
		
		/**
		 * @param hEADNUM 局向编码
		 */
		public void setHEADNUM(String hEADNUM) {
			_headnum = hEADNUM;
		}
		
		/**
		 * @return 地市编码
		 */
		public String getREGION_ID() {
			return _region_id;
		}
		
		/**
		 * @param region_id 地市编码
		 */
		public void setREGION_ID(String region_id) {
			_region_id = region_id;
		}
		
		/**
		 * @return 局向类型
		 */
		public String getCATEGORY() {
			return _category;
		}
		
		/**
		 * @param cATEGORY 局向类型
		 */
		public void setCATEGORY(String cATEGORY) {
			_category = cATEGORY;
		}
		
		/**
		 * @return 用户所在地市编码
		 */
		public String getUSER_REGION_ID() {
			return _user_region_id;
		}
		
		/**
		 * @param uSER_REGION_ID 用户所在地市编码
		 */
		public void setUSER_REGION_ID(String uSER_REGION_ID) {
			_user_region_id = uSER_REGION_ID;
		}
		
		/**
		 * @return 订单所在地市编码
		 */
		public String getORDER_REGION_ID() {
			return _order_region_id;
		}
		
		/**
		 * @param oRDER_REGION_ID 订单所在地市编码
		 */
		public void setORDER_REGION_ID(String oRDER_REGION_ID) {
			_order_region_id = oRDER_REGION_ID;
		}
		
		/**
		 * @return 网元地市
		 */
		public String getREGION_CODE() {
			return _region_code;
		}
		
		/**
		 * @param region_code 网元地市
		 */
		public void setREGION_CODE(String region_code) {
			_region_code = region_code;
		}
		
		/**
		 * @return 其它属性
		 */
		public java.util.Map getSUBFLOW() {
			return _subflow;
		}

		/**
		 * @param subflow 其它属性
		 */
		public void setSUBFLOW(java.util.Map subflow) {
			_subflow = subflow;
		}
		
		/**
		 * @return 号码局向组件
		 */
		public ISystemTemplate.IUpfgkmOfficeX getCOMPONENT() {
			return _component;
		}
		
		/**
		 * @param component 号码局向组件
		 */
		public void setCOMPONENT(ISystemTemplate.IUpfgkmOfficeX component) {
			_component   = component;
			_region_code = component.getREGION_ID();
		}
	}
	
	public static class IUpdcpmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 8901428806875577150L;
		public IUpdcpmOfferHome(){
			super();
		}
	}
}
