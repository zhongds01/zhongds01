package com.ai.sacenter.valuebean;

import com.ai.sacenter.util.UUID;
import com.ai.sacenter.util.XmlUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016��11��28��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpdbpmOffice implements java.io.Serializable{
	private static final long serialVersionUID = -5818253726648135786L;
	/*Ψһ����*/
	private UUID _id = null;
	/*���𷽹���*/
	private Object  _objective = null;
	/*����ԭʼ����*/
	private IUpdbpmOfferHome _subflow = new IUpdbpmOfferHome();
	/*���𷽾�������*/
	private IUpdcpmOfferHome _program = new IUpdcpmOfferHome();
	public IOVUpdbpmOffice( Object objective) {
		super();
		_objective = objective;
		_id        = UUID.getUUID();
	}
	
	/**
	 * @return Ψһ����
	 */
	public UUID getID() {
		return _id;
	}

	/**
	 * @return ���𷽹���
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return ����ԭʼ����
	 */
	public IUpdbpmOfferHome getSUBFLOW() {
		return _subflow;
	}
	
	/**
	 * @return ���𷽾�������
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
		/*�û����*/
		private long    _user_id        ;
		/*�û�����*/
		private String  _bill_id        ;
		/*�μƷѺ�*/
		private String  _sub_bill_id    ;
		/*�������*/
		private String  _headnum        ;
		/*��������*/
		private String  _category       ;
		/*�û����ڵ��б���*/
		private String  _user_region_id ;
		/*�������ڵ��б���*/
		private String  _order_region_id;
		/*��Ԫ����*/
		private String  _region_code    ;
		/*���б���*/
		private String  _region_id      ;
		/*��������*/
		private java.util.Map _subflow = new java.util.HashMap();
		/*����������*/
		private ISystemTemplate.IUpfgkmOfficeX  _component  = null;
		public IUpdbpmOfferHome(){
			super();
		}
		
		/**
		 * @return �û����
		 */
		public long getUSER_ID() {
			return _user_id;
		}
		
		/**
		 * @param user_id �û����
		 */
		public void setUSER_ID(long user_id) {
			_user_id = user_id;
		}
		
		/**
		 * @return �û�����
		 */
		public String getBILL_ID() {
			return _bill_id;
		}
		
		/**
		 * @param bILL_ID �û�����
		 */
		public void setBILL_ID(String bILL_ID) {
			_bill_id = bILL_ID;
		}
		
		/**
		 * @return �μƷѺ�
		 */
		public String getSUB_BILL_ID() {
			return _sub_bill_id;
		}

		/**
		 * @param sUB_BILL_ID �μƷѺ�
		 */
		public void setSUB_BILL_ID(String sUB_BILL_ID) {
			_sub_bill_id = sUB_BILL_ID;
		}

		/**
		 * @return �������
		 */
		public String getHEADNUM() {
			return _headnum;
		}
		
		/**
		 * @param hEADNUM �������
		 */
		public void setHEADNUM(String hEADNUM) {
			_headnum = hEADNUM;
		}
		
		/**
		 * @return ���б���
		 */
		public String getREGION_ID() {
			return _region_id;
		}
		
		/**
		 * @param region_id ���б���
		 */
		public void setREGION_ID(String region_id) {
			_region_id = region_id;
		}
		
		/**
		 * @return ��������
		 */
		public String getCATEGORY() {
			return _category;
		}
		
		/**
		 * @param cATEGORY ��������
		 */
		public void setCATEGORY(String cATEGORY) {
			_category = cATEGORY;
		}
		
		/**
		 * @return �û����ڵ��б���
		 */
		public String getUSER_REGION_ID() {
			return _user_region_id;
		}
		
		/**
		 * @param uSER_REGION_ID �û����ڵ��б���
		 */
		public void setUSER_REGION_ID(String uSER_REGION_ID) {
			_user_region_id = uSER_REGION_ID;
		}
		
		/**
		 * @return �������ڵ��б���
		 */
		public String getORDER_REGION_ID() {
			return _order_region_id;
		}
		
		/**
		 * @param oRDER_REGION_ID �������ڵ��б���
		 */
		public void setORDER_REGION_ID(String oRDER_REGION_ID) {
			_order_region_id = oRDER_REGION_ID;
		}
		
		/**
		 * @return ��Ԫ����
		 */
		public String getREGION_CODE() {
			return _region_code;
		}
		
		/**
		 * @param region_code ��Ԫ����
		 */
		public void setREGION_CODE(String region_code) {
			_region_code = region_code;
		}
		
		/**
		 * @return ��������
		 */
		public java.util.Map getSUBFLOW() {
			return _subflow;
		}

		/**
		 * @param subflow ��������
		 */
		public void setSUBFLOW(java.util.Map subflow) {
			_subflow = subflow;
		}
		
		/**
		 * @return ����������
		 */
		public ISystemTemplate.IUpfgkmOfficeX getCOMPONENT() {
			return _component;
		}
		
		/**
		 * @param component ����������
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
