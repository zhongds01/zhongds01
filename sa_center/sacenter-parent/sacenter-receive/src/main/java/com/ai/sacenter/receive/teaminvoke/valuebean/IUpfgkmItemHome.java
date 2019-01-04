package com.ai.sacenter.receive.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通产品单元</p>
 * <p>Copyright: Copyright (c) 2017年5月2日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmItemHome implements java.io.Serializable{
 	private static final long serialVersionUID = 2435870140831487534L;
 	/*产品单元编号*/
    private long PRODUCT_ITEM_ID;
    /*产品单元*/
	private IUpfgkmOfferHome _offer = null;
	public IUpfgkmItemHome( long pRODUCT_ITEM_ID ){
		super();
		PRODUCT_ITEM_ID = pRODUCT_ITEM_ID;
	}

	/**
	 * @return 产品单元编号
	 */
	public long getPRODUCT_ITEM_ID() {
		return PRODUCT_ITEM_ID;
	}

	/**
	 * @return 产品单元
	 */
	public IUpfgkmOfferHome getOFFER() {
		return _offer;
	}

	/**
	 * @param offer 产品单元
	 */
	public void setOFFER(IUpfgkmOfferHome offer) {
		_offer = offer;
	}

	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年5月2日</p>
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
		 * @return 产品编号
		 */
		public long getPRODUCT_ID() {
			return PRODUCT_ID;
		}
		
		/**
		 * @param pRODUCT_ID 产品编号
		 */
		public void setPRODUCT_ID(long pRODUCT_ID) {
			PRODUCT_ID = pRODUCT_ID;
		}
		
		/**
		 * @return 产品名称
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param nAME 产品名称
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		
		/**
		 * @return 产品类型
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param cATEGORY 产品类型
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		
		/**
		 * @return 产品编码
		 */
		public String getCOMPETE_ID() {
			return COMPETE_ID;
		}
		
		/**
		 * @param cOMPETE_ID 产品编码
		 */
		public void setCOMPETE_ID(String cOMPETE_ID) {
			COMPETE_ID = cOMPETE_ID;
		}
		
		/**
		 * @return 资费编号
		 */
		public long getPRICE_ID() {
			return PRICE_ID;
		}

		/**
		 * @param pRICE_ID 资费编号
		 */
		public void setPRICE_ID(long pRICE_ID) {
			PRICE_ID = pRICE_ID;
		}

		/**
		 * @return 其他编码
		 */
		public long getPLAN_ID() {
			return PLAN_ID;
		}
		
		/**
		 * @param pLAN_ID 其他编码
		 */
		public void setPLAN_ID(long pLAN_ID) {
			PLAN_ID = pLAN_ID;
		}
	}
}
