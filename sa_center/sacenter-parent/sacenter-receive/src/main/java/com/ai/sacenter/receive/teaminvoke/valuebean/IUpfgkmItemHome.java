package com.ai.sacenter.receive.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ��Ʒ��Ԫ</p>
 * <p>Copyright: Copyright (c) 2017��5��2��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmItemHome implements java.io.Serializable{
 	private static final long serialVersionUID = 2435870140831487534L;
 	/*��Ʒ��Ԫ���*/
    private long PRODUCT_ITEM_ID;
    /*��Ʒ��Ԫ*/
	private IUpfgkmOfferHome _offer = null;
	public IUpfgkmItemHome( long pRODUCT_ITEM_ID ){
		super();
		PRODUCT_ITEM_ID = pRODUCT_ITEM_ID;
	}

	/**
	 * @return ��Ʒ��Ԫ���
	 */
	public long getPRODUCT_ITEM_ID() {
		return PRODUCT_ITEM_ID;
	}

	/**
	 * @return ��Ʒ��Ԫ
	 */
	public IUpfgkmOfferHome getOFFER() {
		return _offer;
	}

	/**
	 * @param offer ��Ʒ��Ԫ
	 */
	public void setOFFER(IUpfgkmOfferHome offer) {
		_offer = offer;
	}

	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017��5��2��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 6235118209233564366L;
		private long   PRODUCT_ID ;
		private String NAME       ;
		private String CATEGORY   ;
		private String COMPETE_ID ;
		private long   PRICE_ID   ;
		private long   PLAN_ID    ;
		public IUpfgkmOfferHome( long pRODUCT_ID ){
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
		 * @return ��Ʒ����
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param nAME ��Ʒ����
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		
		/**
		 * @return ��Ʒ����
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param cATEGORY ��Ʒ����
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		
		/**
		 * @return ��Ʒ����
		 */
		public String getCOMPETE_ID() {
			return COMPETE_ID;
		}
		
		/**
		 * @param cOMPETE_ID ��Ʒ����
		 */
		public void setCOMPETE_ID(String cOMPETE_ID) {
			COMPETE_ID = cOMPETE_ID;
		}
		
		/**
		 * @return �ʷѱ��
		 */
		public long getPRICE_ID() {
			return PRICE_ID;
		}

		/**
		 * @param pRICE_ID �ʷѱ��
		 */
		public void setPRICE_ID(long pRICE_ID) {
			PRICE_ID = pRICE_ID;
		}

		/**
		 * @return ��������
		 */
		public long getPLAN_ID() {
			return PLAN_ID;
		}
		
		/**
		 * @param pLAN_ID ��������
		 */
		public void setPLAN_ID(long pLAN_ID) {
			PLAN_ID = pLAN_ID;
		}
	}
}
