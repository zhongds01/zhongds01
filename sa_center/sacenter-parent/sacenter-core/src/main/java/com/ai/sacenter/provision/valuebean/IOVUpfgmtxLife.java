package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.util.UUID;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元事务交易</p>
 * <p>Copyright: Copyright (c) 2014-7-5</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfgmtxLife implements java.io.Serializable{
	private static final long serialVersionUID = 1759467704508832058L;
	/*事务编号*/
	private UUID _id = null;
	/*发起方*/
	private Object _objective = null;
	/*交易事务*/
	private IUpfgmtxLifeHome _subflow = new IUpfgmtxLifeHome();
	public IOVUpfgmtxLife(Object objective){
		super();
		_id        = UUID.getUUID();
		_objective = objective;
	}
	
	/**
	 * @return 交易编号
	 */
	public UUID getID() {
		return _id;
	}
	
	/**
	 * @return 发起方
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return 交易事务
	 */
	public IUpfgmtxLifeHome getSUBFLOW() {
		return _subflow;
	}


	public static class IUpfgmtxLifeHome implements java.io.Serializable{
		private static final long serialVersionUID = 3631751503989879190L;
		/*定单编号*/
		private String _order_id;
		/*操作编号*/
		private String _done_code;
		/*用户编号*/
		private long   _user_id;
		/*用户号码*/
		private String _bill_id;
		/*创建时间*/
		private java.sql.Timestamp  _create_date;
		/*地市编码*/
		private String _region_id;
		/*网元编码*/
		private String _platform;
		/*操作对象*/
		private Object _objective;
		/*类路径*/
		private Object _implclass;
		/*渠道编码*/
		private String _channel;
		/*索引编码*/
		private Object _index;
		/*消息体*/
		private java.util.HashMap _body = new java.util.HashMap();
		public IUpfgmtxLifeHome(){
			super();
		}
		
		/**
		 * @return 定单编号
		 */
		public String getORDER_ID() {
			return _order_id;
		}

		/**
		 * @param oRDER_ID 定单编号
		 */
		public void setORDER_ID(String oRDER_ID) {
			_order_id = oRDER_ID;
		}

		/**
		 * @return 操作编号
		 */
		public String getDONE_CODE() {
			return _done_code;
		}

		/**
		 * @param dONE_CODE 操作编号
		 */
		public void setDONE_CODE(String dONE_CODE) {
			_done_code = dONE_CODE;
		}

		/**
		 * @return 用户编号
		 */
		public long getUSER_ID() {
			return _user_id;
		}

		/**
		 * @param uSER_ID 用户编号
		 */
		public void setUSER_ID(long uSER_ID) {
			_user_id = uSER_ID;
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
		 * @return 创建时间
		 */
		public java.sql.Timestamp getCREATE_DATE() {
			return _create_date;
		}

		/**
		 * @param cREATE_DATE 创建时间
		 */
		public void setCREATE_DATE(java.sql.Timestamp cREATE_DATE) {
			_create_date = cREATE_DATE;
		}

		/**
		 * @return 地市编码
		 */
		public String getREGION_ID() {
			return _region_id;
		}

		/**
		 * @param rEGION_ID 地市编码
		 */
		public void setREGION_ID(String rEGION_ID) {
			_region_id = rEGION_ID;
		}
		
		/**
		 * @return 网元编码
		 */
		public String getPLATFORM() {
			return _platform;
		}

		/**
		 * @param pLATFORM 网元编码
		 */
		public void setPLATFORM(String pLATFORM) {
			_platform = pLATFORM;
		}
		
		/**
		 * @return 操作对象
		 */
		public Object getOBJECTIVE() {
			return _objective;
		}

		/**
		 * @param oBJECTIVE 操作对象
		 */
		public void setOBJECTIVE(Object oBJECTIVE) {
			_objective = oBJECTIVE;
		}

		/**
		 * @return 指令资产
		 */
		public Object getIMPLCLASS() {
			return _implclass;
		}

		/**
		 * @param iMPLCLASS 指令资产
		 */
		public void setIMPLCLASS(Object iMPLCLASS) {
			_implclass = iMPLCLASS;
		}

		/**
		 * @return 渠道编码
		 */
		public String getCHANNEL() {
			return _channel;
		}

		/**
		 * @param cHANNEL 渠道编码
		 */
		public void setCHANNEL(String cHANNEL) {
			_channel = cHANNEL;
		}
		
		/**
		 * @return 交易索引
		 */
		public Object getINDEX() {
			return _index;
		}

		/**
		 * @param iNDEX 交易索引
		 */
		public void setINDEX(Object iNDEX) {
			_index = iNDEX;
		}
		
		/**
		 * @return 交易消息
		 */
		public java.util.HashMap getBODY() {
			return _body;
		}

	}
}
