package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.util.UUID;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ������</p>
 * <p>Copyright: Copyright (c) 2014-7-5</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfgmtxLife implements java.io.Serializable{
	private static final long serialVersionUID = 1759467704508832058L;
	/*������*/
	private UUID _id = null;
	/*����*/
	private Object _objective = null;
	/*��������*/
	private IUpfgmtxLifeHome _subflow = new IUpfgmtxLifeHome();
	public IOVUpfgmtxLife(Object objective){
		super();
		_id        = UUID.getUUID();
		_objective = objective;
	}
	
	/**
	 * @return ���ױ��
	 */
	public UUID getID() {
		return _id;
	}
	
	/**
	 * @return ����
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return ��������
	 */
	public IUpfgmtxLifeHome getSUBFLOW() {
		return _subflow;
	}


	public static class IUpfgmtxLifeHome implements java.io.Serializable{
		private static final long serialVersionUID = 3631751503989879190L;
		/*�������*/
		private String _order_id;
		/*�������*/
		private String _done_code;
		/*�û����*/
		private long   _user_id;
		/*�û�����*/
		private String _bill_id;
		/*����ʱ��*/
		private java.sql.Timestamp  _create_date;
		/*���б���*/
		private String _region_id;
		/*��Ԫ����*/
		private String _platform;
		/*��������*/
		private Object _objective;
		/*��·��*/
		private Object _implclass;
		/*��������*/
		private String _channel;
		/*��������*/
		private Object _index;
		/*��Ϣ��*/
		private java.util.HashMap _body = new java.util.HashMap();
		public IUpfgmtxLifeHome(){
			super();
		}
		
		/**
		 * @return �������
		 */
		public String getORDER_ID() {
			return _order_id;
		}

		/**
		 * @param oRDER_ID �������
		 */
		public void setORDER_ID(String oRDER_ID) {
			_order_id = oRDER_ID;
		}

		/**
		 * @return �������
		 */
		public String getDONE_CODE() {
			return _done_code;
		}

		/**
		 * @param dONE_CODE �������
		 */
		public void setDONE_CODE(String dONE_CODE) {
			_done_code = dONE_CODE;
		}

		/**
		 * @return �û����
		 */
		public long getUSER_ID() {
			return _user_id;
		}

		/**
		 * @param uSER_ID �û����
		 */
		public void setUSER_ID(long uSER_ID) {
			_user_id = uSER_ID;
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
		 * @return ����ʱ��
		 */
		public java.sql.Timestamp getCREATE_DATE() {
			return _create_date;
		}

		/**
		 * @param cREATE_DATE ����ʱ��
		 */
		public void setCREATE_DATE(java.sql.Timestamp cREATE_DATE) {
			_create_date = cREATE_DATE;
		}

		/**
		 * @return ���б���
		 */
		public String getREGION_ID() {
			return _region_id;
		}

		/**
		 * @param rEGION_ID ���б���
		 */
		public void setREGION_ID(String rEGION_ID) {
			_region_id = rEGION_ID;
		}
		
		/**
		 * @return ��Ԫ����
		 */
		public String getPLATFORM() {
			return _platform;
		}

		/**
		 * @param pLATFORM ��Ԫ����
		 */
		public void setPLATFORM(String pLATFORM) {
			_platform = pLATFORM;
		}
		
		/**
		 * @return ��������
		 */
		public Object getOBJECTIVE() {
			return _objective;
		}

		/**
		 * @param oBJECTIVE ��������
		 */
		public void setOBJECTIVE(Object oBJECTIVE) {
			_objective = oBJECTIVE;
		}

		/**
		 * @return ָ���ʲ�
		 */
		public Object getIMPLCLASS() {
			return _implclass;
		}

		/**
		 * @param iMPLCLASS ָ���ʲ�
		 */
		public void setIMPLCLASS(Object iMPLCLASS) {
			_implclass = iMPLCLASS;
		}

		/**
		 * @return ��������
		 */
		public String getCHANNEL() {
			return _channel;
		}

		/**
		 * @param cHANNEL ��������
		 */
		public void setCHANNEL(String cHANNEL) {
			_channel = cHANNEL;
		}
		
		/**
		 * @return ��������
		 */
		public Object getINDEX() {
			return _index;
		}

		/**
		 * @param iNDEX ��������
		 */
		public void setINDEX(Object iNDEX) {
			_index = iNDEX;
		}
		
		/**
		 * @return ������Ϣ
		 */
		public java.util.HashMap getBODY() {
			return _body;
		}

	}
}
