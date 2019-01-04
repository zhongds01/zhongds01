package com.ai.sacenter.receive.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通产品局数据</p>
 * <p>Copyright: Copyright (c) 2017年3月15日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmMiscHome implements java.io.Serializable{
	private static final long serialVersionUID = 8714671529640039086L;
	/*产品编号*/
	private long   PRODUCT_ID ;
	/*产品局数据*/
	private java.util.ArrayList<IUpfgkmOfferHome> _offer = new java.util.ArrayList<IUpfgkmOfferHome>();
	public IUpfgkmMiscHome( long pRODUCT_ID ) {
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
	 * @return 产品局数据
	 */
	public java.util.ArrayList<IUpfgkmOfferHome> getOFFER() {
		return _offer;
	}
    
	/**
	 * 产品局数据
	 * @return
	 */
	public IUpfgkmOfferHome getOFFER( int fromINDEX ){
		return (IUpfgkmOfferHome)_offer.get( fromINDEX );
	}
	
	/**
	 * @param offer 产品局数据
	 */
	public void setOFFER(java.util.ArrayList<IUpfgkmOfferHome> offer) {
		_offer = offer;
	}

	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年3月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfgkmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 8835245569150801848L;
		/*产品编号*/
		private long   PRODUCT_ID;
		/*短产品编号*/
		private String SPROM_ID;
		/*资费编号*/
		private String PRICE_ID;
		/*其他编号*/
		private String PLAN_ID;
		/*业务类型*/
		private String SERVTYPE   ;
		/*企业代码*/
		private String SPID       ;
		/*业务代码*/
		private String BIZCODE    ;
		/*计费类型*/
		private String BILLFLG    ;
		/*是否产品受理[P产品受理L非产品模式受理]*/
		private String PRODFLG    ;
		/*是否本地[L本地G集团]*/
		private String PLATFLG    ;
		/*内容计费[G是L否]*/
		private String GLOBAL     ;
		public IUpfgkmOfferHome(){
			super();
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
		 * @return 短产品编号
		 */
		public String getSPROM_ID() {
			return SPROM_ID;
		}

		/**
		 * @param sPROM_ID 短产品编号
		 */
		public void setSPROM_ID(String sPROM_ID) {
			SPROM_ID = sPROM_ID;
		}

		/**
		 * @return 资费编号
		 */
		public String getPRICE_ID() {
			return PRICE_ID;
		}

		/**
		 * @param pRICE_ID 资费编号
		 */
		public void setPRICE_ID(String pRICE_ID) {
			PRICE_ID = pRICE_ID;
		}

		/**
		 * @return 其他编号
		 */
		public String getPLAN_ID() {
			return PLAN_ID;
		}

		/**
		 * @param pLAN_ID 其他编号
		 */
		public void setPLAN_ID(String pLAN_ID) {
			PLAN_ID = pLAN_ID;
		}

		/**
		 * @return 业务类型
		 */
		public String getSERVTYPE() {
			return SERVTYPE;
		}
		
		/**
		 * @param sERVTYPE 业务类型
		 */
		public void setSERVTYPE(String sERVTYPE) {
			SERVTYPE = sERVTYPE;
		}
		
		/**
		 * @return 企业代码
		 */
		public String getSPID() {
			return SPID;
		}
		
		/**
		 * @param sPID 企业代码
		 */
		public void setSPID(String sPID) {
			SPID = sPID;
		}
		
		/**
		 * @return 业务代码
		 */
		public String getBIZCODE() {
			return BIZCODE;
		}
		
		/**
		 * @param bIZCODE 业务代码
		 */
		public void setBIZCODE(String bIZCODE) {
			BIZCODE = bIZCODE;
		}
		
		/**
		 * @return 计费类型
		 */
		public String getBILLFLG() {
			return BILLFLG;
		}
		
		/**
		 * @param bILLFLG 计费类型
		 */
		public void setBILLFLG(String bILLFLG) {
			BILLFLG = bILLFLG;
		}
		
		/**
		 * @return 是否产品受理
		 */
		public String getPRODFLG() {
			return PRODFLG;
		}

		/**
		 * @param pRODFLG 是否产品受理
		 */
		public void setPRODFLG(String pRODFLG) {
			PRODFLG = pRODFLG;
		}

		/**
		 * @return 是否本地[L本地G集团]
		 */
		public String getPLATFLG() {
			return PLATFLG;
		}

		/**
		 * @param pLATFLG 是否本地[L本地G集团]
		 */
		public void setPLATFLG(String pLATFLG) {
			PLATFLG = pLATFLG;
		}

		/**
		 * @return 内容计费
		 */
		public String getGLOBAL() {
			return GLOBAL;
		}
		
		/**
		 * @param gLOBAL 内容计费
		 */
		public void setGLOBAL(String gLOBAL) {
			GLOBAL = gLOBAL;
		}
	}
}
