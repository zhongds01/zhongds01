package com.ai.sacenter.receive.exigence.valuebean;

import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFBsException;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.exigence.IExigenceConst;
import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFRsRspHome;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于开通定单项反馈</p>
 * <p>Copyright: Copyright (c) 2017年5月8日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMocketRespone implements java.io.Serializable{
	private static final long serialVersionUID = -1165793115228254069L;
	private long   ROCKET_ID    ;
	private String CUST_ORDER   ;
	private String CHANNEL      ;
	private String ORG_ID       ;
	private String STAFF_ID     ;
	private IRocketOfferHome _order = null;
	public IOVMocketRespone() {
		super();
		_order = new IRocketOfferHome( this );
	}
	
	public IOVMocketRespone( String _rocket ) throws Exception{
		super();
		org.dom4j.Element _root = XmlUtils.parseXml( _rocket );
		org.dom4j.Element _custorder = RocketUtils.IMetaX._jj_element( _root, "CustOrderInfo" );
		CUST_ORDER   = RocketUtils.IMetaX._jj_string( _custorder, "OrderId"          );
		CHANNEL      = RocketUtils.IMetaX._jj_string( _custorder, "AccessChanelType" );
		ORG_ID       = RocketUtils.IMetaX._jj_string( _custorder, "SalesOrganizeId"  );
		STAFF_ID     = RocketUtils.IMetaX._jj_string( _custorder, "SalesPersonId"    );
		_order       = new IRocketOfferHome( this );
		for( java.util.Iterator<org.dom4j.Element> itera = _root.elements( "OrderItem" ).iterator(); itera.hasNext(); ){
			org.dom4j.Element _orderitem = (org.dom4j.Element)itera.next();
			IRocketRsRspHome fromOrder = new IRocketRsRspHome( this, _orderitem );
			if( _order._rocket == null ){
				_order._rocket = fromOrder.getROCKET( _order._mocket );
				OrderUtils.IRocket.IRocketX._wrapWithRocket( _rocket, _order._rocket );
			}
			_order._order.add( fromOrder );
		}
	}
	
	public IOVMocketRespone( org.dom4j.Element fromCustOrder ) throws Exception{
		super();
		CUST_ORDER = RocketUtils.IMetaX._jj_string( fromCustOrder, "OrderId"          );
		CHANNEL    = RocketUtils.IMetaX._jj_string( fromCustOrder, "AccessChanelType" );
		ORG_ID     = RocketUtils.IMetaX._jj_string( fromCustOrder, "SalesOrganizeId"  );
		STAFF_ID   = RocketUtils.IMetaX._jj_string( fromCustOrder, "SalesPersonId"    );
		_order     = new IRocketOfferHome( this );
	}
	
	public IOVMocketRespone( org.dom4j.Element fromRoot, org.dom4j.Element fromCustOrder ) throws Exception{
		super();
		CUST_ORDER   = RocketUtils.IMetaX._jj_string( fromCustOrder, "OrderId"          );
		CHANNEL      = RocketUtils.IMetaX._jj_string( fromCustOrder, "AccessChanelType" );
		ORG_ID       = RocketUtils.IMetaX._jj_string( fromCustOrder, "SalesOrganizeId"  );
		STAFF_ID     = RocketUtils.IMetaX._jj_string( fromCustOrder, "SalesPersonId"    );
		_order       = new IRocketOfferHome( this );
		for( java.util.Iterator<org.dom4j.Element> itera = fromRoot.elements( "OrderItem" ).iterator(); itera.hasNext(); ){
			org.dom4j.Element fromOrderItem = (org.dom4j.Element)itera.next();
			_order._order.add( new IRocketRsRspHome( this, fromOrderItem ) );
		}
	}
	
	public IOVMocketRespone( IOVMsgFExigence fromExigence ){
		super();
		ROCKET_ID  = fromExigence.getROCKET_ID ();
		CUST_ORDER = fromExigence.getCUST_ORDER();
		CHANNEL    = fromExigence.getCHANNEL   ();
		ORG_ID     = fromExigence.getORG_ID    ();
		STAFF_ID   = fromExigence.getSTAFF_ID  ();
		_order     = new IRocketOfferHome( this );
	}
	
	
	/**
	 * @return 定单编号
	 */
	public long getROCKET_ID() {
		return ROCKET_ID;
	}

	/**
	 * @param rOCKET_ID 定单编号
	 */
	public void setROCKET_ID(long rOCKET_ID) {
		ROCKET_ID = rOCKET_ID;
	}

	/**
	 * @return 客户订单编号
	 */
	public String getCUST_ORDER() {
		return CUST_ORDER;
	}
	
	/**
	 * @param 客户订单编号
	 */
	public void setCUST_ORDER(String cUST_ORDER) {
		CUST_ORDER = cUST_ORDER;
	}
	
	/**
	 * @return 渠道类型
	 */
	public String getCHANNEL() {
		return CHANNEL;
	}
	
	/**
	 * @param cHANNEL 渠道类型
	 */
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}
	
	/**
	 * @return 受理组织编号
	 */
	public String getORG_ID() {
		return ORG_ID;
	}
	
	/**
	 * @param oRG_ID 受理组织编号
	 */
	public void setORG_ID(String oRG_ID) {
		ORG_ID = oRG_ID;
	}
	
	/**
	 * @return 受理员工工号
	 */
	public String getSTAFF_ID() {
		return STAFF_ID;
	}
	
	/**
	 * @param sTAFF_ID 受理员工工号
	 */
	public void setSTAFF_ID(String sTAFF_ID) {
		STAFF_ID = sTAFF_ID;
	}
	
	/**
	 * @return 开通订单项
	 */
	public IRocketOfferHome getORDER() {
		return _order;
	}
	
	/**
	 * 
	 * @param _custorder
	 * @throws Exception
	 */
	private void custOrderInfoToXml( org.dom4j.Element _custorder ) throws Exception{
		try
		{
			_custorder.addElement( "OrderId"          ).setText( CUST_ORDER );
			_custorder.addElement( "AccessChanelType" ).setText( CHANNEL    );
			_custorder.addElement( "SalesPersonId"    ).setText( STAFF_ID   );
			_custorder.addElement( "SalesOrganizeId"  ).setText( ORG_ID     );
		}
		finally{
			
		}
	}
	
	/**
	 * 开通反馈转换开通外部应答
	 * @return
	 * @throws Exception
	 */
	public String getAsXml() throws Exception{
		String _xml = null;
		try
		{
			SFBsException fromExtend = null;
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "CustOrder" );
			custOrderInfoToXml ( _root.addElement( "CustOrderInfo"  ) );
			for( java.util.Iterator<IRocketRsRspHome> itera = _order._order.iterator(); itera.hasNext(); ){
				IRocketRsRspHome _rsRsp = (IRocketRsRspHome)itera.next();
				fromExtend = ExceptionFactory.getExtend( _rsRsp.getRESULT().getRspCode(), 
						_rsRsp.getRESULT().getRspDesc() );
				_rsRsp.orderItemInfoToXml( _root.addElement( "OrderItem" ), fromExtend );
			}
			_xml = document.asXML();
		}
		catch( java.lang.Exception exception ){
			_xml = super.toString();
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
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "CustOrder" );
			custOrderInfoToXml( _root.addElement( "CustOrderInfo"  ) );
			for( java.util.Iterator<IRocketRsRspHome> itera = _order._order.iterator(); itera.hasNext(); ){
				IRocketRsRspHome _rsRsp = (IRocketRsRspHome)itera.next();
				org.dom4j.Element _orderitem = _root.addElement( "OrderItem" );
				_rsRsp.orderItemInfoToXml( _orderitem, null );
			}
			_xml = document.asXML();
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
	 * <p>Copyright: Copyright (c) 2017年6月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IRocketOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 3192938567660810841L;
		/*开通异步应答*/
		private IOVMocketRespone    _mocket = null;
		/*开通报文明细*/
		private IOVMsgFOrderBase    _rocket = null;
		/*开通定单项*/
		private CarbonList<IRocketRsRspHome> _order = new CarbonList<IRocketRsRspHome>();
		public IRocketOfferHome( IOVMocketRespone mocket ){
			super();
			_mocket = mocket;
		}
		
		/**
		 * 开通定单
		 * @return
		 * @throws Exception
		 */
		public IOVMsgFOrderBase getROCKET() throws Exception{
			if( _rocket == null && _order != null && _order.size() > 0 ){
				IRocketRsRspHome fromLittle = (IRocketRsRspHome)_order.get( 0 );
				_rocket = fromLittle.getROCKET( _mocket );
				String _body = ExigenceUtils.IRocket._jj_network( _mocket );
				OrderUtils.IRocket.IRocketX._wrapWithRocket( _body, _rocket );
			}
			return _rocket;
		}

		/**
		 * @param rocket 开通报文明细
		 */
		public void setROCKET(IOVMsgFOrderBase rocket) {
			_rocket = rocket;
		}

		/**
		 * @return 开通订单项
		 */
		public CarbonList<IRocketRsRspHome> getORDER() {
			return _order;
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年5月8日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IRocketRsRspHome implements java.io.Serializable{
		private static final long serialVersionUID = 6722513879706219333L;
		private String ORDER_ID     ;
		private String CATALOG      ;
		private String BUSINESS     ;
		private String ORIGINATOR   ;
		private long   USER_ID      ;
		private String BILL_ID      ;
		private String ORDER_REGION_ID    ;
		private String REGION_ID    ;
		private java.sql.Timestamp DONE_DATE    ;
		private IOVMsgFRsRspHome RESULT = null;
		public IRocketRsRspHome(){
			super();
			RESULT = new IOVMsgFRsRspHome();
		}
		
		public IRocketRsRspHome( IOVMocketRespone fromMocket, org.dom4j.Element fromOrderItem ){
			super();
			ORDER_ID        = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "OrderItemId"     , false );
			CATALOG         = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "ItemCode"        , false );
			BUSINESS        = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "BusinessCode"    , false );
			ORIGINATOR      = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "OriginatorCode"  , false );
			USER_ID         = RocketUtils.IMetaX._jj_long     ( fromOrderItem, "OwnerId"         , false );
			BILL_ID         = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "ServiceNumber"   , false );
			ORDER_REGION_ID = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "BeId"            , false );
			DONE_DATE       = RocketUtils.IMetaX._jj_timestamp( fromOrderItem, "SendTime"        , false );
			String fromBody = RocketUtils.IMetaX._jj_string   ( fromOrderItem, "OrderItemRsp"    , false );
			RESULT          = new IOVMsgFRsRspHome( XmlUtils.parseXml( fromBody ) );
			SFCenterOffer fromCenter = CenterUtils.ISystem._custom( this );
			REGION_ID       = fromCenter.getREGION_ID();
		}
		
		public IRocketRsRspHome( IOVMocketExigence fromOsRocket ){
			super();
			ORDER_ID         = fromOsRocket.getCUST_ORDER     ();
			CATALOG          = fromOsRocket.getCATALOG_ID     ();
			BUSINESS         = fromOsRocket.getBUSINESS_ID    ();
			ORIGINATOR       = fromOsRocket.getORIGINATOR     (); 
			USER_ID          = fromOsRocket.getUSER_ID        ();
			BILL_ID          = fromOsRocket.getBILL_ID        ();
			ORDER_REGION_ID  = fromOsRocket.getORDER_REGION_ID();
			REGION_ID        = fromOsRocket.getREGION_ID      ();
			DONE_DATE        = fromOsRocket.getDONE_DATE      ();
			RESULT           = new IOVMsgFRsRspHome();
		}
		
		public IRocketRsRspHome( IOVMsgFOrderBase fromOsRocket ){
			super();
			ORDER_ID         = fromOsRocket.getORDER_ITEM_ID  ();
			CATALOG          = fromOsRocket.getCATALOG        ();
			BUSINESS         = fromOsRocket.getBUSINESS       ();
			ORIGINATOR       = fromOsRocket.getORIGINATOR     (); 
			USER_ID          = fromOsRocket.getUSER_ID        ();
			BILL_ID          = fromOsRocket.getBILL_ID        ();
			ORDER_REGION_ID  = fromOsRocket.getORDER_REGION_ID();
			REGION_ID        = fromOsRocket.getREGION_ID      ();
			DONE_DATE        = fromOsRocket.getDONE_DATE      ();
			RESULT           = new IOVMsgFRsRspHome();
		}
		
		public IRocketRsRspHome( IOVUpdbsComplete fromOrder ){
			super();
			IOVUpdbsComplete.IUpdbsOfferHome fromOfferHome = fromOrder.getORDER();
			ORDER_ID        = fromOrder.getDONE_CODE                      ();
			CATALOG         = fromOrder.getCATALOG                        ();
			BUSINESS        = fromOrder.getBUSINESS                       ();
			ORIGINATOR      = (String)fromOfferHome.getSUBFLOW().get( IExigenceConst.IUpdbm.IUpdbf.ORIGINATOR );
			if( ORIGINATOR == null ){
				ORIGINATOR  = IExigenceConst.IUpdbm.IEnum.PROGRAM_ORIGINATOR;
			}
			USER_ID         = fromOrder.getUSER_ID                        ();
			String fromUSER_ID = (String)fromOfferHome.getSUBFLOW().get( IExigenceConst.IUpdbm.IUpdbf.USER_ID );
			if( fromUSER_ID != null ){
				USER_ID     = Long.parseLong( fromUSER_ID                  );
			}
			BILL_ID         = (String)fromOfferHome.getSUBFLOW().get( IExigenceConst.IUpdbm.IUpdbf.BILL_ID );
			if( BILL_ID == null ){
				BILL_ID     = fromOrder.getBILL_ID                        ();
			}
			ORDER_REGION_ID = fromOrder.getORDER_REGION_ID                ();
			REGION_ID       = fromOrder.getREGION_ID                      ();
			DONE_DATE       = fromOrder.getCOMPLETE_DATE                  ();
			RESULT          = new IOVMsgFRsRspHome                        ();
		}
		
		/**
		 * @return 开通定单项编号
		 */
		public String getORDER_ID() {
			return ORDER_ID;
		}
		
		/**
		 * @param oRDER_ID 开通定单项编号
		 */
		public void setORDER_ID(String oRDER_ID) {
			ORDER_ID = oRDER_ID;
		}
		
		/**
		 * @return 产品编码
		 */
		public String getCATALOG() {
			return CATALOG;
		}
		
		/**
		 * @param cATALOG 产品编码
		 */
		public void setCATALOG(String cATALOG) {
			CATALOG = cATALOG;
		}
		
		/**
		 * @return 业务编码
		 */
		public String getBUSINESS() {
			return BUSINESS;
		}
		
		/**
		 * @param bUSINESS 业务编码
		 */
		public void setBUSINESS(String bUSINESS) {
			BUSINESS = bUSINESS;
		}
		
		/**
		 * @return 发起方编码
		 */
		public String getORIGINATOR() {
			return ORIGINATOR;
		}
		
		/**
		 * @param 发起方编码
		 */
		public void setORIGINATOR(String oRIGINATE) {
			ORIGINATOR = oRIGINATE;
		}
		
		/**
		 * @return 用户编号
		 */
		public long getUSER_ID() {
			return USER_ID;
		}
		
		/**
		 * @param uSER_ID 用户编号
		 */
		public void setUSER_ID(long uSER_ID) {
			USER_ID = uSER_ID;
		}
		
		/**
		 * @return 用户号码
		 */
		public String getBILL_ID() {
			return BILL_ID;
		}
		
		/**
		 * @param bILL_ID 用户号码
		 */
		public void setBILL_ID(String bILL_ID) {
			BILL_ID = bILL_ID;
		}
		
		/**
		 * @return 订单地市编码
		 */
		public String getORDER_REGION_ID() {
			return ORDER_REGION_ID;
		}
		
		/**
		 * @param oRDER_REGION_ID 订单地市编码
		 */
		public void setORDER_REGION_ID(String oRDER_REGION_ID) {
			ORDER_REGION_ID = oRDER_REGION_ID;
		}
		
		/**
		 * @return 地市编码
		 */
		public String getREGION_ID() {
			return REGION_ID;
		}

		/**
		 * @param rEGION_ID 地市编码
		 */
		public void setREGION_ID(String rEGION_ID) {
			REGION_ID = rEGION_ID;
		}

		/**
		 * @return 派发时间
		 */
		public java.sql.Timestamp getDONE_DATE() {
			return DONE_DATE;
		}
		
		/**
		 * @param dONE_DATE 派发时间
		 */
		public void setDONE_DATE(java.sql.Timestamp dONE_DATE) {
			DONE_DATE = dONE_DATE;
		}
		
		/**
		 * @return 反馈结果
		 */
		public IOVMsgFRsRspHome getRESULT() {
			return RESULT;
		}
		
		/**
		 * @param rESULT 反馈结果
		 */
		public void setRESULT(IOVMsgFRsRspHome rESULT) {
			RESULT = rESULT;
		}

		/**
		 * 
		 * @param _mocket
		 * @return
		 * @throws Exception
		 */
		private IOVMsgFOrderBase getROCKET( IOVMocketRespone _mocket ) throws Exception{
			IOVMsgFOrderBase _rocket = null;
			try
			{
				_rocket = new IOVMsgFOrderMain();
				_rocket.setROCKET_ID      ( _mocket.getROCKET_ID                               () );
				_rocket.setCUST_ORDER     ( _mocket.getCUST_ORDER                              () );
				_rocket.setORDER_ITEM_ID  ( ORDER_ID                                              );
				_rocket.setCATALOG        ( CATALOG                                               );
				_rocket.setBUSINESS       ( BUSINESS                                              );
				_rocket.setBATCHES        ( IUpdbfsConst.IUpdbm.IBatches.NO                       );
				_rocket.setORIGINATOR     ( ORIGINATOR                                            );
				_rocket.setCHANNEL        ( _mocket.CHANNEL                                       );
				_rocket.setUSER_ID        ( USER_ID                                               );
				_rocket.setBILL_ID        ( BILL_ID                                               );
				_rocket.setCREATE_DATE    ( new java.sql.Timestamp( System.currentTimeMillis () ) );
				_rocket.setREGION_ID      ( REGION_ID                                             );
				_rocket.setSTATE          ( IUpdbfsConst.IState.C                                 );
				_rocket.setORDER_REGION_ID( ORDER_REGION_ID                                       );
				_rocket.setDONE_DATE      ( DONE_DATE                                             );
				_rocket.setPRIORITY       ( IUpdbfsConst.IUpdbm.ICustom.PRIORITY                  );
				_rocket.setCOMPOSITE      ( IUpdbfsConst.IUpdbm.IOriginate.PROGRAM_COMPLETE       );
				_rocket.setORG_ID         ( _mocket.getORG_ID                                  () );
				_rocket.setSTAFF_ID       ( _mocket.getSTAFF_ID                                () );
				_rocket.setPLWK_CREATE    ( new java.sql.Timestamp( System.currentTimeMillis () ) );
			}
			finally{
				
			}
			return _rocket;
		}
		
		/**
		 * 
		 * @param _orderitem
		 * @param fromExtend
		 * @throws Exception
		 */
		private void orderItemInfoToXml( org.dom4j.Element _orderitem, SFBsException fromExtend ) throws Exception{
			try
			{
				_orderitem.addElement( "OrderItemId"    ).setText( ORDER_ID                              );
				_orderitem.addElement( "OriginatorCode" ).setText( ORIGINATOR                            );
				_orderitem.addElement( "ItemCode"       ).setText( CATALOG                               );
				_orderitem.addElement( "BusinessCode"   ).setText( BUSINESS                              );
				_orderitem.addElement( "OwnerId"        ).setText( String.valueOf( USER_ID             ) );
				_orderitem.addElement( "ServiceNumber"  ).setText( BILL_ID                               );
				_orderitem.addElement( "BeId"           ).setText( ORDER_REGION_ID                       );
				_orderitem.addElement( "SendTime"       ).setText( TimeUtils.yyyymmddhhmmss( DONE_DATE ) );
				
				if( RESULT != null ){
					org.dom4j.Document _busidoc = org.dom4j.DocumentHelper.createDocument();
					org.dom4j.Element _bizrsp = _busidoc.addElement( "UserOrderRsp" );
					if( fromExtend != null ){
						_bizrsp.addElement( "RspCode" ).setText( fromExtend.getFaultCode() );
						_bizrsp.addElement( "RspDesc" ).setText( fromExtend.getMessage  () );
					}
					else{
						_bizrsp.addElement( "RspCode" ).setText( RESULT.getRspCode() );
						_bizrsp.addElement( "RspDesc" ).setText( RESULT.getRspDesc() );
					}
					if( RESULT.getRspResult() != null ){
						OrderUtils.IRocket.IIRsRsp._gvp_wrap_complex("RspResult", 
								RESULT.getRspResult(), 
								_bizrsp);
					}
					if( RESULT.getRspBody() != null && RESULT.getRspBody().size() > 0 ){
						OrderUtils.IRocket.IIRsRsp._gvp_wrap_complex("RspBody", 
								RESULT.getRspBody(), 
								_bizrsp);
					}
					_orderitem.addElement( "OrderItemRsp" ).addCDATA( _busidoc.asXML());
				}
			}
			finally{
				
			}
		}
		
	}
}
