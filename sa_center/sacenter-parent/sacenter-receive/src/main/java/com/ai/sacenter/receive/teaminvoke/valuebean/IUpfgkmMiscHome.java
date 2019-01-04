package com.ai.sacenter.receive.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ��Ʒ������</p>
 * <p>Copyright: Copyright (c) 2017��3��15��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmMiscHome implements java.io.Serializable{
	private static final long serialVersionUID = 8714671529640039086L;
	/*��Ʒ���*/
	private long   PRODUCT_ID ;
	/*��Ʒ������*/
	private java.util.ArrayList<IUpfgkmOfferHome> _offer = new java.util.ArrayList<IUpfgkmOfferHome>();
	public IUpfgkmMiscHome( long pRODUCT_ID ) {
		super();
		PRODUCT_ID = pRODUCT_ID;
	}
	
	/**
	 * @return ��Ʒ���
	 */
	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	/**
	 * @param pRODUCT_ID ��Ʒ���
	 */
	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	/**
	 * @return ��Ʒ������
	 */
	public java.util.ArrayList<IUpfgkmOfferHome> getOFFER() {
		return _offer;
	}
    
	/**
	 * ��Ʒ������
	 * @return
	 */
	public IUpfgkmOfferHome getOFFER( int fromINDEX ){
		return (IUpfgkmOfferHome)_offer.get( fromINDEX );
	}
	
	/**
	 * @param offer ��Ʒ������
	 */
	public void setOFFER(java.util.ArrayList<IUpfgkmOfferHome> offer) {
		_offer = offer;
	}

	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017��3��15��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 8835245569150801848L;
		/*��Ʒ���*/
		private long   PRODUCT_ID;
		/*�̲�Ʒ���*/
		private String SPROM_ID;
		/*�ʷѱ��*/
		private String PRICE_ID;
		/*�������*/
		private String PLAN_ID;
		/*ҵ������*/
		private String SERVTYPE   ;
		/*��ҵ����*/
		private String SPID       ;
		/*ҵ�����*/
		private String BIZCODE    ;
		/*�Ʒ�����*/
		private String BILLFLG    ;
		/*�Ƿ��Ʒ����[P��Ʒ����L�ǲ�Ʒģʽ����]*/
		private String PRODFLG    ;
		/*�Ƿ񱾵�[L����G����]*/
		private String PLATFLG    ;
		/*���ݼƷ�[G��L��]*/
		private String GLOBAL     ;
		public IUpfgkmOfferHome(){
			super();
		}
		
		/**
		 * @return ��Ʒ���
		 */
		public long getPRODUCT_ID() {
			return PRODUCT_ID;
		}

		/**
		 * @param pRODUCT_ID ��Ʒ���
		 */
		public void setPRODUCT_ID(long pRODUCT_ID) {
			PRODUCT_ID = pRODUCT_ID;
		}

		/**
		 * @return �̲�Ʒ���
		 */
		public String getSPROM_ID() {
			return SPROM_ID;
		}

		/**
		 * @param sPROM_ID �̲�Ʒ���
		 */
		public void setSPROM_ID(String sPROM_ID) {
			SPROM_ID = sPROM_ID;
		}

		/**
		 * @return �ʷѱ��
		 */
		public String getPRICE_ID() {
			return PRICE_ID;
		}

		/**
		 * @param pRICE_ID �ʷѱ��
		 */
		public void setPRICE_ID(String pRICE_ID) {
			PRICE_ID = pRICE_ID;
		}

		/**
		 * @return �������
		 */
		public String getPLAN_ID() {
			return PLAN_ID;
		}

		/**
		 * @param pLAN_ID �������
		 */
		public void setPLAN_ID(String pLAN_ID) {
			PLAN_ID = pLAN_ID;
		}

		/**
		 * @return ҵ������
		 */
		public String getSERVTYPE() {
			return SERVTYPE;
		}
		
		/**
		 * @param sERVTYPE ҵ������
		 */
		public void setSERVTYPE(String sERVTYPE) {
			SERVTYPE = sERVTYPE;
		}
		
		/**
		 * @return ��ҵ����
		 */
		public String getSPID() {
			return SPID;
		}
		
		/**
		 * @param sPID ��ҵ����
		 */
		public void setSPID(String sPID) {
			SPID = sPID;
		}
		
		/**
		 * @return ҵ�����
		 */
		public String getBIZCODE() {
			return BIZCODE;
		}
		
		/**
		 * @param bIZCODE ҵ�����
		 */
		public void setBIZCODE(String bIZCODE) {
			BIZCODE = bIZCODE;
		}
		
		/**
		 * @return �Ʒ�����
		 */
		public String getBILLFLG() {
			return BILLFLG;
		}
		
		/**
		 * @param bILLFLG �Ʒ�����
		 */
		public void setBILLFLG(String bILLFLG) {
			BILLFLG = bILLFLG;
		}
		
		/**
		 * @return �Ƿ��Ʒ����
		 */
		public String getPRODFLG() {
			return PRODFLG;
		}

		/**
		 * @param pRODFLG �Ƿ��Ʒ����
		 */
		public void setPRODFLG(String pRODFLG) {
			PRODFLG = pRODFLG;
		}

		/**
		 * @return �Ƿ񱾵�[L����G����]
		 */
		public String getPLATFLG() {
			return PLATFLG;
		}

		/**
		 * @param pLATFLG �Ƿ񱾵�[L����G����]
		 */
		public void setPLATFLG(String pLATFLG) {
			PLATFLG = pLATFLG;
		}

		/**
		 * @return ���ݼƷ�
		 */
		public String getGLOBAL() {
			return GLOBAL;
		}
		
		/**
		 * @param gLOBAL ���ݼƷ�
		 */
		public void setGLOBAL(String gLOBAL) {
			GLOBAL = gLOBAL;
		}
	}
}
