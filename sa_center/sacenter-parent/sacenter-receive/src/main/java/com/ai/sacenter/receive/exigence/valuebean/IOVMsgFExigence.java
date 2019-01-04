package com.ai.sacenter.receive.exigence.valuebean;

import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ�첽����</p>
 * <p>Copyright: Copyright (c) 2017��5��4��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFExigence implements java.io.Serializable{
	private static final long serialVersionUID = -3008190749182471878L;
	private long   ROCKET_ID    ;
	private String CUST_ORDER   ;
	private String CHANNEL      ;
	private String ORG_ID       ;
	private String STAFF_ID     ;
	private IMsgFOfferXHome _order = null;
	public IOVMsgFExigence() {
		super();
		_order = new IMsgFOfferXHome( this );
	}

	public IOVMsgFExigence( String _rocket ) throws Exception{
		super();
		org.dom4j.Element _root = XmlUtils.parseXml( _rocket );
		org.dom4j.Element _custorder = RocketUtils.IMetaX._jj_element( _root, "CustOrderInfo" );
		CUST_ORDER = RocketUtils.IMetaX._jj_string( _custorder, "OrderId"          );
		CHANNEL    = RocketUtils.IMetaX._jj_string( _custorder, "AccessChanelType" );
		ORG_ID     = RocketUtils.IMetaX._jj_string( _custorder, "SalesOrganizeId"  );
		STAFF_ID   = RocketUtils.IMetaX._jj_string( _custorder, "SalesPersonId"    );
		_order     = new IMsgFOfferXHome( this );
		for( java.util.Iterator<org.dom4j.Element> itera = _root.elements( "OrderItem" ).iterator(); itera.hasNext(); ){
			org.dom4j.Element _orderitem = (org.dom4j.Element)itera.next();
			IOVMsgFOrderBase fromOrder = ExigenceUtils.IRocket.IRocketX._wrapWithConsult(_custorder,
					_orderitem, 
					this );
			_order.getORDER().add( fromOrder );
		}
	}
	
	public IOVMsgFExigence(IOVMocketExigence _mocket ) throws Exception{
		super();
		org.dom4j.Element _root = XmlUtils.parseXml( _mocket.getORDER().getBODY() );
		org.dom4j.Element _custorder = RocketUtils.IMetaX._jj_element( _root, "CustOrderInfo" );
		CUST_ORDER = RocketUtils.IMetaX._jj_string( _custorder, "OrderId"          );
		CHANNEL    = RocketUtils.IMetaX._jj_string( _custorder, "AccessChanelType" );
		ORG_ID     = RocketUtils.IMetaX._jj_string( _custorder, "SalesOrganizeId"  );
		STAFF_ID   = RocketUtils.IMetaX._jj_string( _custorder, "SalesPersonId"    );
		_order     = new IMsgFOfferXHome( _mocket, this );
		for( java.util.Iterator<org.dom4j.Element> itera = _root.elements( "OrderItem" ).iterator(); itera.hasNext(); ){
			org.dom4j.Element _orderitem = (org.dom4j.Element)itera.next();
			IOVMsgFOrderBase fromOrder = ExigenceUtils.IRocket.IRocketX._wrapWithConsult(_custorder,
					_orderitem, 
					this );
			_order.getORDER().add( fromOrder );
		}
	}
	
	public IOVMsgFExigence( org.dom4j.Element fromCustOrder ) throws Exception{
		super();
		CUST_ORDER = RocketUtils.IMetaX._jj_string( fromCustOrder, "OrderId"          );
		CHANNEL    = RocketUtils.IMetaX._jj_string( fromCustOrder, "AccessChanelType" );
		ORG_ID     = RocketUtils.IMetaX._jj_string( fromCustOrder, "SalesOrganizeId"  );
		STAFF_ID   = RocketUtils.IMetaX._jj_string( fromCustOrder, "SalesPersonId"    );
		_order     = new IMsgFOfferXHome( this );
	}
	
	public IOVMsgFExigence( org.dom4j.Element fromRoot, org.dom4j.Element fromCustOrder ) throws Exception{
		super();
		CUST_ORDER = RocketUtils.IMetaX._jj_string( fromCustOrder, "OrderId"          );
		CHANNEL    = RocketUtils.IMetaX._jj_string( fromCustOrder, "AccessChanelType" );
		ORG_ID     = RocketUtils.IMetaX._jj_string( fromCustOrder, "SalesOrganizeId"  );
		STAFF_ID   = RocketUtils.IMetaX._jj_string( fromCustOrder, "SalesPersonId"    );
		_order     = new IMsgFOfferXHome( this );
		for( java.util.Iterator<org.dom4j.Element> itera = fromRoot.elements( "OrderItem" ).iterator(); itera.hasNext(); ){
			org.dom4j.Element fromOrderItem = (org.dom4j.Element)itera.next();
			IOVMsgFOrderBase fromOrder = ExigenceUtils.IRocket.IRocketX._wrapWithConsult(fromCustOrder,
					fromOrderItem, 
					this );
			_order.getORDER().add( fromOrder );
		}
	}
	
	public IOVMsgFExigence( IOVMsgFExigence fromRocket ) throws Exception{
		super();
		ROCKET_ID  = fromRocket.ROCKET_ID  ;
		CUST_ORDER = fromRocket.CUST_ORDER ;
		CHANNEL    = fromRocket.CHANNEL    ;
		ORG_ID     = fromRocket.ORG_ID     ;
		STAFF_ID   = fromRocket.STAFF_ID   ;
		_order     = new IMsgFOfferXHome( fromRocket._order._mocket, this );
	}
	
	/**
	 * @return �������
	 */
	public long getROCKET_ID() {
		return ROCKET_ID;
	}

	/**
	 * @param rOCKET_ID �������
	 */
	public void setROCKET_ID(long rOCKET_ID) {
		ROCKET_ID = rOCKET_ID;
	}

	/**
	 * @return �ͻ��������
	 */
	public String getCUST_ORDER() {
		return CUST_ORDER;
	}

	/**
	 * @param cUST_ORDER �ͻ��������
	 */
	public void setCUST_ORDER(String cUST_ORDER) {
		CUST_ORDER = cUST_ORDER;
	}

	/**
	 * @return ��������
	 */
	public String getCHANNEL() {
		return CHANNEL;
	}

	/**
	 * @param cHANNEL ��������
	 */
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}

	/**
	 * @return ������֯���
	 */
	public String getORG_ID() {
		return ORG_ID;
	}

	/**
	 * @param oRG_ID ������֯���
	 */
	public void setORG_ID(String oRG_ID) {
		ORG_ID = oRG_ID;
	}

	/**
	 * @return ����Ա������
	 */
	public String getSTAFF_ID() {
		return STAFF_ID;
	}

	/**
	 * @param sTAFF_ID ����Ա������
	 */
	public void setSTAFF_ID(String sTAFF_ID) {
		STAFF_ID = sTAFF_ID;
	}

	/**
	 * @return ��ͨ������
	 */
	public IMsgFOfferXHome getORDER() {
		return _order;
	}

	/**
	 * 
	 * @return
	 */
	public String getAsXml() throws Exception{
		String _xml = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "CustOrder" );
			org.dom4j.Element _custorder = _root.addElement( "CustOrderInfo" );
			_custorder.addElement( "OrderId"          ).setText( CUST_ORDER );
			_custorder.addElement( "AccessChanelType" ).setText( CHANNEL    );
			_custorder.addElement( "SalesPersonId"    ).setText( STAFF_ID   );
			_custorder.addElement( "SalesOrganizeId"  ).setText( ORG_ID     );
			
			for( java.util.Iterator<IOVMsgFOrderBase> itera = _order._order.iterator(); itera.hasNext(); ){
				IOVMsgFOrderBase fromOrder = (IOVMsgFOrderBase)itera.next();
				org.dom4j.Element _orderitem = _root.addElement( "OrderItem" );
				_orderitem.addElement( "OrderItemId"    ).setText( fromOrder.getORDER_ITEM_ID                        () );
				_orderitem.addElement( "OriginatorCode" ).setText( fromOrder.getORIGINATOR                           () );
				_orderitem.addElement( "ItemCode"       ).setText( fromOrder.getCATALOG                             ()  );
				_orderitem.addElement( "BusinessCode"   ).setText( fromOrder.getBUSINESS                             () );
				_orderitem.addElement( "OwnerId"        ).setText( String.valueOf( fromOrder.getUSER_ID            () ) );
				_orderitem.addElement( "ServiceNumber"  ).setText( fromOrder.getBILL_ID                              () );
				_orderitem.addElement( "BeId"           ).setText( fromOrder.getORDER_REGION_ID                      () );
				_orderitem.addElement( "SendTime"       ).setText( TimeUtils.yyyymmddhhmmss( fromOrder.getDONE_DATE() ) );
				_orderitem.addElement( "ProdInfo"       ).addCDATA( fromOrder.getORDER().getBODY() );
			}
			_xml = document.asXML();
		}
		finally{
			
		}
		return _xml;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String _xml = null;
		try
		{
			_xml = getAsXml();
		}
		catch( java.lang.Exception exception ){
			_xml = super.toString();
		}
		finally{
			
		}
		return _xml;
	}

	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017��5��5��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMsgFOfferXHome implements java.io.Serializable{
		private static final long serialVersionUID = -6049614786979727559L;
		/*��ͨ������*/
		private CarbonList<IOVMsgFOrderBase> _order = new CarbonList<IOVMsgFOrderBase>();
		/*��ͨ�첽��*/
		private IOVMsgFExigence     _exigence = null;
		/*��ͨ����*/
		private IOVMsgFOrderBase    _rocket   = null;
		/*��ͨ�첽��*/
		private IOVMocketExigence   _mocket   = null;
		public IMsgFOfferXHome(IOVMsgFExigence rocket ){
			super();
			_exigence = rocket ;
		}
		
		public IMsgFOfferXHome(IOVMocketExigence mocket, IOVMsgFExigence rocket ){
			super();
			_exigence = rocket;
			_mocket   = mocket;
		}
		
		/**
		 * @return ��ͨ������
		 */
		public CarbonList<IOVMsgFOrderBase> getORDER() {
			return _order;
		}
		
		/**
		 * ��ͨ��λ������
		 * @return
		 * @throws Exception
		 */
		public IOVMsgFOrderBase getLITTLE() throws Exception{
			IOVMsgFOrderBase fromLittle = null;
			if( _order != null && _order.size() == 1 /*��ͨ��������*/){
				fromLittle = (IOVMsgFOrderBase)_order.get( _order.size() - 1 ); 
			}
			else if( _order != null && _order.size() > 0 /*��ͨ�ඨ����*/){
				fromLittle = (IOVMsgFOrderBase)_order.get( 0 );
				for( java.util.Iterator<IOVMsgFOrderBase> itera = _order.iterator(); itera.hasNext(); ){
					IOVMsgFOrderBase fromOrder = (IOVMsgFOrderBase)itera.next();
					if( fromOrder.isCOMPETENCE() /*��ͨ��������*/){
						fromLittle = fromOrder;
						break;
					}
				}
			}
			return fromLittle;
		}
		
		/**
		 * 
		 * @return ��ͨ������ϸ
		 * @throws Exception
		 */
		public IOVMsgFOrderBase getROCKET() throws Exception {
			if( _rocket == null ){
				IOVMsgFOrderBase _little = getLITTLE();
				if( _little != null && _exigence == null ){
					_rocket = new IOVMsgFOrderMain( _little );
				}
				else if( _little != null && _exigence != null ){
					_rocket = new IOVMsgFOrderMain( _little );
					_rocket.getORDER().getORDER().clear();
					OrderUtils.IRocket.IRocketX._wrapWithRocket( _exigence.getAsXml(), _rocket );
				}
			}
			return _rocket;
		}
		
		/**
		 * @return rocket ��ͨ������ϸ
		 */
		public void setROCKET( IOVMsgFOrderBase rocket) {
			_rocket = rocket;
		}

		/**
		 * @return ��ͨ�첽��
		 */
		public IOVMocketExigence getMOCKET() {
			return _mocket;
		}

		/**
		 * @param mocket ��ͨ�첽��
		 */
		public void setMOCKET(IOVMocketExigence mocket) {
			_mocket = mocket;
		}
	}
}
