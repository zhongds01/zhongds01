package com.ai.sacenter.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.base.competence.bo.ISABusines;
import com.ai.sacenter.base.competence.bo.ISABusinesRel;
import com.ai.sacenter.base.competence.bo.ISABusinesX;
import com.ai.sacenter.base.competence.bo.ISACompetence;
import com.ai.sacenter.base.competence.bo.ISACompetenceRel;
import com.ai.sacenter.base.competence.bo.ISAComptel;
import com.ai.sacenter.base.competence.bo.ISAComptelRel;
import com.ai.sacenter.base.competence.bo.ISAComptelX;
import com.ai.sacenter.base.competence.bo.ISAProduct;
import com.ai.sacenter.base.competence.bo.ISAProductRel;
import com.ai.sacenter.base.competence.bo.ISAProductX;
import com.ai.sacenter.base.competence.bo.ISASubFlow;
import com.ai.sacenter.base.competence.bo.ISAWorkFlow;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务激活开放能力</p>
 * <p>Copyright: Copyright (c) 2015-5-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IProfessionalTemplate implements java.io.Serializable{
	private static final long serialVersionUID = 6017002538535806932L;
	public IProfessionalTemplate() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月9日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IProductOffer implements java.io.Serializable{
		private static final long serialVersionUID = 8484686652742677252L;
		private String ID ;
		private String COMPETE    ;
		private String NAME       ;
		private String CATEGORY   ;
		private String DESCRIPTION;
		private String CONTROL    ;
		private String PROVIDER   ;
		private java.sql.Timestamp EFFECTIVE  ;
		private java.sql.Timestamp EXPIRE     ;
		private IProductComptel COMPTEL = null;
		private java.util.List SUBFLOW = new java.util.ArrayList();
		public IProductOffer( ISAProduct aProduct ){
			super();
		    ID          = String.valueOf(aProduct.getProductId());
		    COMPETE     = aProduct.getCode       ();
			NAME        = aProduct.getName       ();
			CATEGORY    = aProduct.getCategory   ();
			DESCRIPTION = aProduct.getDescription();
			CONTROL     = aProduct.getControl    ();
			PROVIDER    = aProduct.getProvider   ();
			EFFECTIVE   = aProduct.getEffective  ();
			EXPIRE      = aProduct.getExpire     ();
		}
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}
		/**
		 * @return the cOMPETE
		 */
		public String getCOMPETE() {
			return COMPETE;
		}
		/**
		 * @param cOMPETE the cOMPETE to set
		 */
		public void setCOMPETE(String cOMPETE) {
			COMPETE = cOMPETE;
		}
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		/**
		 * @param nAME the nAME to set
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		/**
		 * @param dESCRIPTION the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		/**
		 * @param cONTROL the cONTROL to set
		 */
		public void setCONTROL(String cONTROL) {
			CONTROL = cONTROL;
		}
		/**
		 * @return the pROVIDER
		 */
		public String getPROVIDER() {
			return PROVIDER;
		}
		/**
		 * @param pROVIDER the pROVIDER to set
		 */
		public void setPROVIDER(String pROVIDER) {
			PROVIDER = pROVIDER;
		}
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
		/**
		 * @return the cOMPTEL
		 */
		public IProductComptel getCOMPTEL() {
			return COMPTEL;
		}
		/**
		 * @param cOMPTEL the cOMPTEL to set
		 */
		public void setCOMPTEL(IProductComptel cOMPTEL) {
			COMPTEL = cOMPTEL;
		}
		/**
		 * @return the sUBFLOW
		 */
		public java.util.List getSUBFLOW() {
			return SUBFLOW;
		}
		/**
		 * 是否产品规格类
		 * @return
		 */
		public boolean isCATALOG(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.CATALOG );
		}
		/**
		 * 是否产品操作类
		 * @return
		 */
		public boolean isBUSINESS(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.BUSINES );
		}
		/**
		 * 是否服务功能
		 * @return
		 */
		public boolean isSERVICE(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.SERVICE );
		}
		/**
		 * 是否产品类开通
		 * @return
		 */
		public boolean isPRICE(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.PRICE );
		}
		/**
		 * 是否虚拟服务
		 * @return
		 */
		public boolean isVIRTUAL(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.VIRTUAL );
		}
		/**
		 * 是否为服务属性
		 * @return
		 */
		public boolean isATTRIBUE(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.ATTRIBUE );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月9日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IProductComptel implements java.io.Serializable{
		private static final long serialVersionUID = -4239545073621965393L;
		private String  PRODUCT_ID;
		private String  CATEGORY  ;
		private int     COMPOSITE ;
		private String  COMPTEL   ;
		private String  COMPLEX   ;
		private String  EXTEND_ATTR_A;
		private String  EXTEND_ATTR_B;
		private String  EXTEND_ATTR_C;
		private String  EXTEND_ATTR_D;
		private String  EXTEND_ATTR_E;
		private String  EXTEND_ATTR_F;
		private String  EXTEND_ATTR_G;
		private String  EXTEND_ATTR_H;
		private String  EXTEND_ATTR_I;
		private String  EXTEND_ATTR_J;
		private String  EXTEND_ATTR_K;
		private String  EXTEND_ATTR_L;
		private String  EXTEND_ATTR_M;
		private String  EXTEND_ATTR_N;
		private String  EXTEND_ATTR_O;
		private java.sql.Timestamp  EFFECTIVE ;
		private java.sql.Timestamp  EXPIRE    ;
		private IProductCombineX COMBINE      ;
		private IProductComptelX COMPTELX = null;
		public IProductComptel(ISAProductX aProduct){
			super();
			PRODUCT_ID    = String.valueOf(aProduct.getProductId());
			CATEGORY      = aProduct.getCategory    ();
			COMPOSITE     = aProduct.getComposite   ();
			COMPTEL       = aProduct.getComptel     ();
			COMPLEX       = aProduct.getComplex     ();
			EXTEND_ATTR_A = aProduct.getExtendAttrA ();
			EXTEND_ATTR_B = aProduct.getExtendAttrB ();
			EXTEND_ATTR_C = aProduct.getExtendAttrC ();
			EXTEND_ATTR_D = aProduct.getExtendAttrD ();
			EXTEND_ATTR_E = aProduct.getExtendAttrE ();
			EXTEND_ATTR_F = aProduct.getExtendAttrF ();
			EXTEND_ATTR_G = aProduct.getExtendAttrG ();
			EXTEND_ATTR_H = aProduct.getExtendAttrH ();
			EXTEND_ATTR_I = aProduct.getExtendAttrI ();
			EXTEND_ATTR_J = aProduct.getExtendAttrJ ();
			EXTEND_ATTR_K = aProduct.getExtendAttrK ();
			EXTEND_ATTR_L = aProduct.getExtendAttrL ();
			EXTEND_ATTR_M = aProduct.getExtendAttrM ();
			EXTEND_ATTR_N = aProduct.getExtendAttrN ();
			EXTEND_ATTR_O = aProduct.getExtendAttrO ();
			EFFECTIVE     = aProduct.getEffective   ();
			EXPIRE        = aProduct.getExpire      ();
			COMBINE       = new IProductCombineX(this);
			COMPTELX      = new IProductComptelX(this);
		}
		
		/**
		 * @return the pRODUCT_ID
		 */
		public String getPRODUCT_ID() {
			return PRODUCT_ID;
		}
		
		/**
		 * @param pRODUCT_ID the pRODUCT_ID to set
		 */
		public void setPRODUCT_ID(String pRODUCT_ID) {
			PRODUCT_ID = pRODUCT_ID;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		
		/**
		 * @return the cOMPOSITE
		 */
		public int getCOMPOSITE() {
			return COMPOSITE;
		}
		
		/**
		 * @param cOMPOSITE the cOMPOSITE to set
		 */
		public void setCOMPOSITE(int cOMPOSITE) {
			COMPOSITE = cOMPOSITE;
		}
		
		/**
		 * @return the cOMPTEL
		 */
		public String getCOMPTEL() {
			return COMPTEL;
		}
		
		/**
		 * @param cOMPTEL the cOMPTEL to set
		 */
		public void setCOMPTEL(String cOMPTEL) {
			COMPTEL = cOMPTEL;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		
		/**
		 * @return the eXTEND_ATTR_A
		 */
		public String getEXTEND_ATTR_A() {
			return EXTEND_ATTR_A;
		}
		
		/**
		 * @param eXTEND_ATTR_A the eXTEND_ATTR_A to set
		 */
		public void setEXTEND_ATTR_A(String eXTEND_ATTR_A) {
			EXTEND_ATTR_A = eXTEND_ATTR_A;
		}
		
		/**
		 * @return the eXTEND_ATTR_B
		 */
		public String getEXTEND_ATTR_B() {
			return EXTEND_ATTR_B;
		}
		
		/**
		 * @param eXTEND_ATTR_B the eXTEND_ATTR_B to set
		 */
		public void setEXTEND_ATTR_B(String eXTEND_ATTR_B) {
			EXTEND_ATTR_B = eXTEND_ATTR_B;
		}
		
		/**
		 * @return the eXTEND_ATTR_C
		 */
		public String getEXTEND_ATTR_C() {
			return EXTEND_ATTR_C;
		}
		
		/**
		 * @param eXTEND_ATTR_C the eXTEND_ATTR_C to set
		 */
		public void setEXTEND_ATTR_C(String eXTEND_ATTR_C) {
			EXTEND_ATTR_C = eXTEND_ATTR_C;
		}
		
		/**
		 * @return the eXTEND_ATTR_D
		 */
		public String getEXTEND_ATTR_D() {
			return EXTEND_ATTR_D;
		}
		
		/**
		 * @param eXTEND_ATTR_D the eXTEND_ATTR_D to set
		 */
		public void setEXTEND_ATTR_D(String eXTEND_ATTR_D) {
			EXTEND_ATTR_D = eXTEND_ATTR_D;
		}
		
		/**
		 * @return the eXTEND_ATTR_E
		 */
		public String getEXTEND_ATTR_E() {
			return EXTEND_ATTR_E;
		}
		
		/**
		 * @param eXTEND_ATTR_E the eXTEND_ATTR_E to set
		 */
		public void setEXTEND_ATTR_E(String eXTEND_ATTR_E) {
			EXTEND_ATTR_E = eXTEND_ATTR_E;
		}
		
		/**
		 * @return the eXTEND_ATTR_F
		 */
		public String getEXTEND_ATTR_F() {
			return EXTEND_ATTR_F;
		}
		
		/**
		 * @param eXTEND_ATTR_F the eXTEND_ATTR_F to set
		 */
		public void setEXTEND_ATTR_F(String eXTEND_ATTR_F) {
			EXTEND_ATTR_F = eXTEND_ATTR_F;
		}
		
		/**
		 * @return the eXTEND_ATTR_G
		 */
		public String getEXTEND_ATTR_G() {
			return EXTEND_ATTR_G;
		}
		
		/**
		 * @param eXTEND_ATTR_G the eXTEND_ATTR_G to set
		 */
		public void setEXTEND_ATTR_G(String eXTEND_ATTR_G) {
			EXTEND_ATTR_G = eXTEND_ATTR_G;
		}
		
		/**
		 * @return the eXTEND_ATTR_H
		 */
		public String getEXTEND_ATTR_H() {
			return EXTEND_ATTR_H;
		}
		
		/**
		 * @param eXTEND_ATTR_H the eXTEND_ATTR_H to set
		 */
		public void setEXTEND_ATTR_H(String eXTEND_ATTR_H) {
			EXTEND_ATTR_H = eXTEND_ATTR_H;
		}
		
		/**
		 * @return the eXTEND_ATTR_I
		 */
		public String getEXTEND_ATTR_I() {
			return EXTEND_ATTR_I;
		}
		
		/**
		 * @param eXTEND_ATTR_I the eXTEND_ATTR_I to set
		 */
		public void setEXTEND_ATTR_I(String eXTEND_ATTR_I) {
			EXTEND_ATTR_I = eXTEND_ATTR_I;
		}
		
		/**
		 * @return the eXTEND_ATTR_J
		 */
		public String getEXTEND_ATTR_J() {
			return EXTEND_ATTR_J;
		}
		
		/**
		 * @param eXTEND_ATTR_J the eXTEND_ATTR_J to set
		 */
		public void setEXTEND_ATTR_J(String eXTEND_ATTR_J) {
			EXTEND_ATTR_J = eXTEND_ATTR_J;
		}
		
		/**
		 * @return the eXTEND_ATTR_K
		 */
		public String getEXTEND_ATTR_K() {
			return EXTEND_ATTR_K;
		}
		
		/**
		 * @param eXTEND_ATTR_K the eXTEND_ATTR_K to set
		 */
		public void setEXTEND_ATTR_K(String eXTEND_ATTR_K) {
			EXTEND_ATTR_K = eXTEND_ATTR_K;
		}
		
		/**
		 * @return the eXTEND_ATTR_L
		 */
		public String getEXTEND_ATTR_L() {
			return EXTEND_ATTR_L;
		}
		
		/**
		 * @param eXTEND_ATTR_L the eXTEND_ATTR_L to set
		 */
		public void setEXTEND_ATTR_L(String eXTEND_ATTR_L) {
			EXTEND_ATTR_L = eXTEND_ATTR_L;
		}
		
		/**
		 * @return the eXTEND_ATTR_M
		 */
		public String getEXTEND_ATTR_M() {
			return EXTEND_ATTR_M;
		}
		
		/**
		 * @param eXTEND_ATTR_M the eXTEND_ATTR_M to set
		 */
		public void setEXTEND_ATTR_M(String eXTEND_ATTR_M) {
			EXTEND_ATTR_M = eXTEND_ATTR_M;
		}
		
		/**
		 * @return the eXTEND_ATTR_N
		 */
		public String getEXTEND_ATTR_N() {
			return EXTEND_ATTR_N;
		}
		
		/**
		 * @param eXTEND_ATTR_N the eXTEND_ATTR_N to set
		 */
		public void setEXTEND_ATTR_N(String eXTEND_ATTR_N) {
			EXTEND_ATTR_N = eXTEND_ATTR_N;
		}
		
		/**
		 * @return the eXTEND_ATTR_O
		 */
		public String getEXTEND_ATTR_O() {
			return EXTEND_ATTR_O;
		}
		
		/**
		 * @param eXTEND_ATTR_O the eXTEND_ATTR_O to set
		 */
		public void setEXTEND_ATTR_O(String eXTEND_ATTR_O) {
			EXTEND_ATTR_O = eXTEND_ATTR_O;
		}
		
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
		
		/**
		 * @return 服务级别
		 */
		public IProductCombineX getCOMBINE() {
			return COMBINE;
		}

		/**
		 * @return 服务类型
		 */
		public IProductComptelX getCOMPTELX() {
			return COMPTELX;
		}
		
		/**
		 * 单服务类开通
		 * @return
		 */
		public boolean isCOMPETE(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.SERVICE );
		}
		
		/**
		 * 是否单产品类开通
		 * @return
		 */
		public boolean isPRICE(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.PRICE );
		}
		
		/**
		 * 是否单产品类开通
		 * @return
		 */
		public boolean isMULTLE(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.MULTLE );
		}
		
		/**
		 * 是否虚拟服务
		 * @return
		 */
		public boolean isVIRTUAL(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.VIRTUAL );
		}
		
		/**
		 * 是否为服务属性
		 * @return
		 */
		public boolean isATTRIBUE(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.ATTRIBUE );
		}
		
		/**
		 * 
		 * <p>Title: sacenter-core</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2017年9月13日</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 3.0
		 */
		public static class IProductCombineX implements java.io.Serializable{
			private static final long serialVersionUID = 2532312000857020069L;
			private IProductComptel COMPTEL = null;
			public IProductCombineX( IProductComptel aComptel ){
				super();
				COMPTEL = aComptel;
			}
			
			/**
			 * 是否为主体服务
			 * @return
			 */
			public boolean isMASS(){
				return COMPTEL.COMPOSITE == IComptel.IGrade.MSS;
			}
			
			/**
			 * 是否为基本服务
			 * @return
			 */
			public boolean isBASIC(){
				return COMPTEL.COMPOSITE == IComptel.IGrade.BSS;
			}
			
			/**
			 * 是否为增值服务
			 * @return
			 */
			public boolean isVASS(){
				return COMPTEL.COMPOSITE == IComptel.IGrade.VAS;
			}
			
			/**
			 * 是否为其它产品
			 * @return
			 */
			public boolean isOTSS(){
				return COMPTEL.COMPOSITE == IComptel.IGrade.OSS;
			}
			
			/**
			 * 是否为扩展服务
			 * @return
			 */
			public boolean isEXTEND(){
				return COMPTEL.COMPOSITE == IComptel.IGrade.XSS;
			}
		}
		/**
		 * 
		 * <p>Title: sacenter-core</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2017年2月5日</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public static class IProductComptelX implements java.io.Serializable{
			private static final long serialVersionUID = -7872584866309778388L;
			IProductComptel COMPTEL = null;
			public IProductComptelX(IProductComptel aComptel){
				super();
				COMPTEL = aComptel;
			}
			
			/**
			 * 是否为服务类开通
			 * @return
			 */
			public boolean isFUNC(){
				return StringUtils.contains( COMPTEL.COMPTEL, new String[]{ IComptel.BSS, IComptel.VAS } );
			}
			
			/**
			 * 是否基本服务
			 * @return
			 */
			public boolean isBASIC(){
				return StringUtils.equals( COMPTEL.COMPTEL, IComptel.BSS );
			}
			
			/**
			 * 是否增值服务
			 * @return
			 */
			public boolean isVAS(){
				return StringUtils.equals( COMPTEL.COMPTEL, IComptel.VAS );
			}
			
			/**
			 * 是否附加属性
			 * @return
			 */
			public boolean isPLAIN(){
				return StringUtils.contains( COMPTEL.COMPTEL, new String[]{ IComptel.BSX, IComptel.MSX } );
			}
			
			/**
			 * 是否为批量属性
			 * @return
			 */
			public boolean isMULTLE(){
				return StringUtils.equals( COMPTEL.COMPTEL, IComptel.MSX );
			}
		}
		public static class IComptel{
			/*基本功能*/
			public static final String BSS  = "B";
			/*增值服务*/
			public static final String VAS  = "C";
			/*附加属性*/
			public static final String BSX  = "X";
			/*批量属性*/
			public static final String MSX  = "M";
			public static class IGrade{
				/*主体服务*/
				public static final int  MSS  = 1;
				/*承载服务*/
				public static final int  BSS  = 2;
				/*增值服务*/
				public static final int  VAS  = 3;
				/*其它服务*/
				public static final int  OSS  = 4;
				/*扩展服务*/
				public static final int  XSS  = 5;
			}
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016年9月1日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IProductGroup implements java.io.Serializable{
		private static final long serialVersionUID = -3631454168724705178L;
		private String GROUP ;
		private java.util.Map SUBFLOW = new java.util.HashMap();
		public IProductGroup( ISAProductRel aProduct ){
			super();
			GROUP = aProduct.getProductId();
		}
		/**
		 * @return the _groupId
		 */
		public String getGROUP() {
			return GROUP;
		}
		/**
		 * @param _groupId the _groupId to set
		 */
		public void setGROUP(String _groupId) {
			GROUP = _groupId;
		}
		/**
		 * @return the sUBFLOW
		 */
		public java.util.Map getSUBFLOW() {
			return SUBFLOW;
		}
		/**
		 * 
		 * @param fromCatalog
		 */
		public void addGROUP( IProductCatalog fromCatalog ){
			try
			{
				IProductCombine fromCombine = getGROUP( fromCatalog );
				fromCombine.addCOMBINE( fromCatalog );
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param fromComposite
		 * @return
		 */
		public IProductCombine getGROUP( String fromComposite ){
			return (IProductCombine)SUBFLOW.get( fromComposite );
		}
		/**
		 * 
		 * @param aProductCombine
		 * @return
		 */
		public IProductCombine getGROUP( IProfessionalTemplate.IProductCatalog fromCatalog ){
			IProductCombine fromCombine = null;
			try
			{
				fromCombine = (IProductCombine)SUBFLOW.get( fromCatalog.getCATEGORY() );
				if( fromCombine == null ){
					fromCombine = new IProductCombine( fromCatalog );
					SUBFLOW.put( fromCombine.getCATEGORY(), fromCombine );
				}
			}
			finally{
				
			}
			return fromCombine;
		}
		/**
		 * 
		 * @param aCOMPETE
		 * @return
		 */
		public java.util.List getCOMBINE( String aCOMPETE ){
			java.util.List fromSUBFLOW = null;
			try
			{
				for( java.util.Iterator itera = SUBFLOW.values().iterator(); itera.hasNext(); ){
					IProductCombine fromGroup = (IProductCombine)itera.next();
					java.util.List fromCombine = fromGroup.getCOMBINE( aCOMPETE );
					if( fromCombine != null ){ 
						if( fromSUBFLOW == null ) fromSUBFLOW = new java.util.ArrayList();
						ClassUtils.IMerge.merge( fromCombine, fromSUBFLOW );
					}
				}
			}
			finally{
				
			}
			return fromSUBFLOW;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月9日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IProductCombine implements java.io.Serializable{
		private static final long serialVersionUID = -3406556484594055185L;
		private String PRODUCT_ID;
		private String CATEGORY  ;
		private java.util.List CATALOG = new java.util.ArrayList(); 
		private java.util.Map  COMBINE = new java.util.HashMap();
		public IProductCombine( ){
			super();
		}
		public IProductCombine( IProductCatalog fromCatalog ){
			super();
			PRODUCT_ID = fromCatalog.getPRODUCT_ID();
			CATEGORY   = fromCatalog.getCATEGORY();
		}
		/**
		 * @return the pRODUCT_ID
		 */
		public String getPRODUCT_ID() {
			return PRODUCT_ID;
		}
		/**
		 * @param pRODUCT_ID the pRODUCT_ID to set
		 */
		public void setPRODUCT_ID(String pRODUCT_ID) {
			PRODUCT_ID = pRODUCT_ID;
		}
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		/**
		 * @return the cATALOG
		 */
		public java.util.List getCATALOG() {
			return CATALOG;
		}
		/**
		 * @return the cOMBINE
		 */
		public java.util.Map getCOMBINE() {
			return COMBINE;
		}
		/**
		 * 
		 * @param aCOMPETE
		 * @return
		 */
		public java.util.List getCOMBINE( String aCOMPETE ){
			return (java.util.List)COMBINE.get( aCOMPETE );
		}
		/**
		 * 
		 * @param aCatalog
		 */
		public void addCOMBINE( IProductCatalog aCatalog ){
			try
			{
				CATALOG.add( aCatalog );
				java.util.List fromCombine = (java.util.List)COMBINE.get( 
						aCatalog.getCOMPETE_ID() );
				if( fromCombine == null ){
					COMBINE.put( aCatalog.getCOMPETE_ID(), 
							fromCombine = new java.util.ArrayList() );
				}
				fromCombine.add( aCatalog );
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月9日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IProductCatalog implements java.io.Serializable{
		private static final long serialVersionUID = 6026382447331117907L;
		private String PRODUCT_ID    ;
		private String COMPETE_ID    ;
		private String CATEGORY      ;
		private String EXTEND_ATTR_A ;
		private String EXTEND_ATTR_B ;
		private String EXTEND_ATTR_C ;
		private String EXTEND_ATTR_D ;
		private String EXTEND_ATTR_E ;
		private String EXTEND_ATTR_F ;
		private String EXTEND_ATTR_G ;
		private String EXTEND_ATTR_H ;
		private String EXTEND_ATTR_I ;
		private String EXTEND_ATTR_J ;
		private String EXTEND_ATTR_K ;
		private String EXTEND_ATTR_L ;
		private String EXTEND_ATTR_M ;
		private String EXTEND_ATTR_N ;
		private String EXTEND_ATTR_O ;
		private java.sql.Timestamp EFFECTIVE ;
		private java.sql.Timestamp EXPIRE    ;
		public IProductCatalog( ISAProductRel aProduct ){
			super();
			PRODUCT_ID         = String.valueOf(aProduct.getProductId());
			COMPETE_ID         = String.valueOf(aProduct.getRelatProductId());
			CATEGORY           = aProduct.getProdRelatKindId();
			EXTEND_ATTR_A      = aProduct.getExtendAttrA    ();
			EXTEND_ATTR_B      = aProduct.getExtendAttrB    ();
			EXTEND_ATTR_C      = aProduct.getExtendAttrC    ();
			EXTEND_ATTR_D      = aProduct.getExtendAttrD    ();
			EXTEND_ATTR_E      = aProduct.getExtendAttrE    ();
			EXTEND_ATTR_F      = aProduct.getExtendAttrF    ();
			EXTEND_ATTR_G      = aProduct.getExtendAttrG    ();
			EXTEND_ATTR_H      = aProduct.getExtendAttrH    ();
			EXTEND_ATTR_I      = aProduct.getExtendAttrI    ();
			EXTEND_ATTR_J      = aProduct.getExtendAttrJ    ();
			EXTEND_ATTR_K      = aProduct.getExtendAttrK    ();
			EXTEND_ATTR_L      = aProduct.getExtendAttrL    ();
			EXTEND_ATTR_M      = aProduct.getExtendAttrM    ();
			EXTEND_ATTR_N      = aProduct.getExtendAttrN    ();
			EXTEND_ATTR_O      = aProduct.getExtendAttrO    ();
			EFFECTIVE          = aProduct.getEffective      ();
			EXPIRE             = aProduct.getExpire         ();
		}
		/**
		 * @return the pRODUCT_ID
		 */
		public String getPRODUCT_ID() {
			return PRODUCT_ID;
		}
		/**
		 * @param pRODUCT_ID the pRODUCT_ID to set
		 */
		public void setPRODUCT_ID(String pRODUCT_ID) {
			PRODUCT_ID = pRODUCT_ID;
		}
		/**
		 * @return the cOMPETE_ID
		 */
		public String getCOMPETE_ID() {
			return COMPETE_ID;
		}
		/**
		 * @param cOMPETE_ID the cOMPETE_ID to set
		 */
		public void setCOMPETE_ID(String cOMPETE_ID) {
			COMPETE_ID = cOMPETE_ID;
		}
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		/**
		 * @return the eXTEND_ATTR_A
		 */
		public String getEXTEND_ATTR_A() {
			return EXTEND_ATTR_A;
		}
		/**
		 * @param eXTEND_ATTR_A the eXTEND_ATTR_A to set
		 */
		public void setEXTEND_ATTR_A(String eXTEND_ATTR_A) {
			EXTEND_ATTR_A = eXTEND_ATTR_A;
		}
		/**
		 * @return the eXTEND_ATTR_B
		 */
		public String getEXTEND_ATTR_B() {
			return EXTEND_ATTR_B;
		}
		/**
		 * @param eXTEND_ATTR_B the eXTEND_ATTR_B to set
		 */
		public void setEXTEND_ATTR_B(String eXTEND_ATTR_B) {
			EXTEND_ATTR_B = eXTEND_ATTR_B;
		}
		/**
		 * @return the eXTEND_ATTR_C
		 */
		public String getEXTEND_ATTR_C() {
			return EXTEND_ATTR_C;
		}
		/**
		 * @param eXTEND_ATTR_C the eXTEND_ATTR_C to set
		 */
		public void setEXTEND_ATTR_C(String eXTEND_ATTR_C) {
			EXTEND_ATTR_C = eXTEND_ATTR_C;
		}
		/**
		 * @return the eXTEND_ATTR_D
		 */
		public String getEXTEND_ATTR_D() {
			return EXTEND_ATTR_D;
		}
		/**
		 * @param eXTEND_ATTR_D the eXTEND_ATTR_D to set
		 */
		public void setEXTEND_ATTR_D(String eXTEND_ATTR_D) {
			EXTEND_ATTR_D = eXTEND_ATTR_D;
		}
		/**
		 * @return the eXTEND_ATTR_E
		 */
		public String getEXTEND_ATTR_E() {
			return EXTEND_ATTR_E;
		}
		/**
		 * @param eXTEND_ATTR_E the eXTEND_ATTR_E to set
		 */
		public void setEXTEND_ATTR_E(String eXTEND_ATTR_E) {
			EXTEND_ATTR_E = eXTEND_ATTR_E;
		}
		/**
		 * @return the eXTEND_ATTR_F
		 */
		public String getEXTEND_ATTR_F() {
			return EXTEND_ATTR_F;
		}
		/**
		 * @param eXTEND_ATTR_F the eXTEND_ATTR_F to set
		 */
		public void setEXTEND_ATTR_F(String eXTEND_ATTR_F) {
			EXTEND_ATTR_F = eXTEND_ATTR_F;
		}
		/**
		 * @return the eXTEND_ATTR_G
		 */
		public String getEXTEND_ATTR_G() {
			return EXTEND_ATTR_G;
		}
		/**
		 * @param eXTEND_ATTR_G the eXTEND_ATTR_G to set
		 */
		public void setEXTEND_ATTR_G(String eXTEND_ATTR_G) {
			EXTEND_ATTR_G = eXTEND_ATTR_G;
		}
		/**
		 * @return the eXTEND_ATTR_H
		 */
		public String getEXTEND_ATTR_H() {
			return EXTEND_ATTR_H;
		}
		/**
		 * @param eXTEND_ATTR_H the eXTEND_ATTR_H to set
		 */
		public void setEXTEND_ATTR_H(String eXTEND_ATTR_H) {
			EXTEND_ATTR_H = eXTEND_ATTR_H;
		}
		/**
		 * @return the eXTEND_ATTR_I
		 */
		public String getEXTEND_ATTR_I() {
			return EXTEND_ATTR_I;
		}
		/**
		 * @param eXTEND_ATTR_I the eXTEND_ATTR_I to set
		 */
		public void setEXTEND_ATTR_I(String eXTEND_ATTR_I) {
			EXTEND_ATTR_I = eXTEND_ATTR_I;
		}
		/**
		 * @return the eXTEND_ATTR_J
		 */
		public String getEXTEND_ATTR_J() {
			return EXTEND_ATTR_J;
		}
		/**
		 * @param eXTEND_ATTR_J the eXTEND_ATTR_J to set
		 */
		public void setEXTEND_ATTR_J(String eXTEND_ATTR_J) {
			EXTEND_ATTR_J = eXTEND_ATTR_J;
		}
		/**
		 * @return the eXTEND_ATTR_K
		 */
		public String getEXTEND_ATTR_K() {
			return EXTEND_ATTR_K;
		}
		/**
		 * @param eXTEND_ATTR_K the eXTEND_ATTR_K to set
		 */
		public void setEXTEND_ATTR_K(String eXTEND_ATTR_K) {
			EXTEND_ATTR_K = eXTEND_ATTR_K;
		}
		/**
		 * @return the eXTEND_ATTR_L
		 */
		public String getEXTEND_ATTR_L() {
			return EXTEND_ATTR_L;
		}
		/**
		 * @param eXTEND_ATTR_L the eXTEND_ATTR_L to set
		 */
		public void setEXTEND_ATTR_L(String eXTEND_ATTR_L) {
			EXTEND_ATTR_L = eXTEND_ATTR_L;
		}
		/**
		 * @return the eXTEND_ATTR_M
		 */
		public String getEXTEND_ATTR_M() {
			return EXTEND_ATTR_M;
		}
		/**
		 * @param eXTEND_ATTR_M the eXTEND_ATTR_M to set
		 */
		public void setEXTEND_ATTR_M(String eXTEND_ATTR_M) {
			EXTEND_ATTR_M = eXTEND_ATTR_M;
		}
		/**
		 * @return the eXTEND_ATTR_N
		 */
		public String getEXTEND_ATTR_N() {
			return EXTEND_ATTR_N;
		}
		/**
		 * @param eXTEND_ATTR_N the eXTEND_ATTR_N to set
		 */
		public void setEXTEND_ATTR_N(String eXTEND_ATTR_N) {
			EXTEND_ATTR_N = eXTEND_ATTR_N;
		}
		/**
		 * @return the eXTEND_ATTR_O
		 */
		public String getEXTEND_ATTR_O() {
			return EXTEND_ATTR_O;
		}
		/**
		 * @param eXTEND_ATTR_O the eXTEND_ATTR_O to set
		 */
		public void setEXTEND_ATTR_O(String eXTEND_ATTR_O) {
			EXTEND_ATTR_O = eXTEND_ATTR_O;
		}
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 基于产品操作接入能力共享</p>
	 * <p>Copyright: Copyright (c) 2015年10月10日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbfgsmOffer extends IUpfgsmOffer implements java.io.Serializable{
		private static final long serialVersionUID = -1060930709912538841L;
		private String   SUBFLOW  ;
		private IProductOffer  COMPETE_  = null;
		private IComptelOffer  CATALOG_  = null;
		public IUpdbfgsmOffer( IComptelOffer fromCATALOG, IProductOffer fromCOMPETE ){
			super();
			ID        = fromCATALOG.getID                       ();  
			NAME      = fromCATALOG.getDESCRIPTION              ();                                                                                                                                                    
			COMPETE   = String.valueOf( fromCATALOG.getCOMPETE() );
			CATEGORY  = IUpdcConst.IUpdcp.SERVICE                 ;
			SORT_BY   = fromCATALOG.getSORT_BY                  ();  
			SUBFLOW   = fromCATALOG.getSUBFLOW                  ();
			MAPPING   = String.valueOf( fromCATALOG.getCOMPETE() );	
			IMPLCLASS = fromCATALOG.getIMPLCLASS                ();                                                                                                                                                    
			COMPLEX   = fromCATALOG.getCOMPLEX                  ();                                                                                                                                                    
			CHECKING  = fromCATALOG.getCHECKING                 ();                                                                                                                                                    
			COMPETE_  = fromCOMPETE                               ;
			CATALOG_  = fromCATALOG                               ;
			if( fromCATALOG.getEXTEND() != null ){
				COMPETE = fromCATALOG.getEXTEND                 ();
			}
		}
		
		/**
		 * @return the sUBFLOW
		 */
		public String getSUBFLOW() {
			return SUBFLOW;
		}
		
		/**
		 * @param sUBFLOW the sUBFLOW to set
		 */
		public void setSUBFLOW(String sUBFLOW) {
			SUBFLOW = sUBFLOW;
		}
		
		/**
		 * @return the cOMPETE_
		 */
		public IProductOffer getCOMPETE_() {
			return COMPETE_;
		}
		
		/**
		 * @return the cATALOG_
		 */
		public IComptelOffer getCATALOG_() {
			return CATALOG_;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月10日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IComptelOffer implements java.io.Serializable{
		private static final long serialVersionUID = 115797553178677458L;
		private String ID         ;
		private long   BUSINES    ;
		private long   COMPETE    ;
		private String DESCRIPTION;
		private String EXTEND     ;
		private long   SORT_BY    ;
		private String SUBFLOW    ;
		private String IMPLCLASS  ;
		private String COMPLEX    ;
		private String CHECKING   ;
		private java.sql.Timestamp EFFECTIVE  ;
		private java.sql.Timestamp EXPIRE     ;
		public IComptelOffer( ISAComptel aCompetence ){
			super();
			ID          = String.valueOf(aCompetence.getId());
			BUSINES     = aCompetence.getBusiness   ();
			COMPETE     = aCompetence.getCompeteId  ();
			DESCRIPTION = aCompetence.getDescription();
			EXTEND      = aCompetence.getExtendId   ();
			SORT_BY     = aCompetence.getSortBy     ();
			SUBFLOW     = aCompetence.getSubflow    ();
			IMPLCLASS   = aCompetence.getImplclass  ();
			COMPLEX     = aCompetence.getComplex    ();
			CHECKING    = aCompetence.getChecking   ();
			EFFECTIVE   = aCompetence.getEffective  ();
			EXPIRE      = aCompetence.getExpire     ();
		}
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}
		/**
		 * @return the bUSINES
		 */
		public long getBUSINES() {
			return BUSINES;
		}
		/**
		 * @param bUSINES the bUSINES to set
		 */
		public void setBUSINES(long bUSINES) {
			BUSINES = bUSINES;
		}
		/**
		 * @return the cOMPETE
		 */
		public long getCOMPETE() {
			return COMPETE;
		}
		/**
		 * @param cOMPETE the cOMPETE to set
		 */
		public void setCOMPETE(long cOMPETE) {
			COMPETE = cOMPETE;
		}
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		/**
		 * @param dESCRIPTION the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
		/**
		 * @return the eXTEND
		 */
		public String getEXTEND() {
			return EXTEND;
		}
		/**
		 * @param eXTEND the eXTEND to set
		 */
		public void setEXTEND(String eXTEND) {
			EXTEND = eXTEND;
		}
		/**
		 * @return the sORT_BY
		 */
		public long getSORT_BY() {
			return SORT_BY;
		}
		/**
		 * @param sORT_BY the sORT_BY to set
		 */
		public void setSORT_BY(long sORT_BY) {
			SORT_BY = sORT_BY;
		}
		/**
		 * @return the sUBFLOW
		 */
		public String getSUBFLOW() {
			return SUBFLOW;
		}
		/**
		 * @param sUBFLOW the sUBFLOW to set
		 */
		public void setSUBFLOW(String sUBFLOW) {
			SUBFLOW = sUBFLOW;
		}
		/**
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}
		/**
		 * @param iMPLCLASS the iMPLCLASS to set
		 */
		public void setIMPLCLASS(String iMPLCLASS) {
			IMPLCLASS = iMPLCLASS;
		}
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		/**
		 * @return the cHECKING
		 */
		public String getCHECKING() {
			return CHECKING;
		}
		/**
		 * @param cHECKING the cHECKING to set
		 */
		public void setCHECKING(String cHECKING) {
			CHECKING = cHECKING;
		}
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月10日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbfgsmxOffer extends IUpfgsmOffer implements java.io.Serializable{
		private static final long serialVersionUID = 8583080820576231740L;
		private IProductOffer    COMPETE_ = null;
		private IProductOffer    MAPPING_ = null;
		private IComptelCatalog  CATALOG_ = null;
		public IUpdbfgsmxOffer( IComptelCatalog aCATALOG, 
				IProductOffer aCOMPETE, 
				IProductOffer aMAPPING ){
			super();
			ID        = aCATALOG.getID         ();  
			NAME      = aCATALOG.getDESCRIPTION(); 
			COMPETE   = aCOMPETE.getCOMPETE    ();
			CATEGORY  = aCOMPETE.getCATEGORY   ();
			SORT_BY   = aCATALOG.getSORT_BY    (); 
			MAPPING   = aCATALOG.getEXTEND     ();
			if( MAPPING == null && aMAPPING != null ){
				MAPPING = aMAPPING.getCOMPETE  ();
			}
			else if( aMAPPING != null && aMAPPING.isVIRTUAL() == false ){
				MAPPING = aMAPPING.getCOMPETE  ();
			}
			IMPLCLASS = aCATALOG.getIMPLCLASS  ();                                                                                                                                                    
			COMPLEX   = aCATALOG.getCOMPLEX    ();                                                                                                                                                    
			CHECKING  = aCATALOG.getCHECKING   ();                                                                                                                                                        
			COMPETE_  = aCOMPETE;
			MAPPING_  = aMAPPING;
			CATALOG_  = aCATALOG;
		}
		
		/**
		 * @return the cOMPETE_
		 */
		public IProductOffer getCOMPETE_() {
			return COMPETE_;
		}
		
		/**
		 * @return the mAPPING_
		 */
		public IProductOffer getMAPPING_() {
			return MAPPING_;
		}
		
		/**
		 * @return the cATALOG_
		 */
		public IComptelCatalog getCATALOG_() {
			return CATALOG_;
		}
		
		/**
		 * 是否服务产品能力
		 * @return
		 */
		public boolean isCOMPETE(){
			return MAPPING_ != null ;
		}
		
		/**
		 * 是否属性映射能力
		 * @return
		 */
		public boolean isMAPPING(){
			return ( MAPPING_ == null || MAPPING_.isVIRTUAL() ) && 
					StringUtils.isBlank( MAPPING ) == false;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IComptelKernel implements java.io.Serializable{
		private static final long serialVersionUID = 2896094161101010850L;
		private String ID       ;
		private String NAME     ;
		private String CATEGORY ;
		private String COMPLEX  ;
		private String PROVIDER ;
		private java.sql.Timestamp EFFECTIVE;
		private java.sql.Timestamp EXPIRE   ;
		public IComptelKernel(ISAComptelX aCompetence){
			super();
			ID        = aCompetence.getId       ();
			NAME      = aCompetence.getName     ();
			CATEGORY  = aCompetence.getCategory ();
			COMPLEX   = aCompetence.getComplex  ();
			PROVIDER  = aCompetence.getProvider ();
			EFFECTIVE = aCompetence.getEffective();
			EXPIRE    = aCompetence.getExpire   ();
		}
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		/**
		 * @param nAME the nAME to set
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		/**
		 * @return the pROVIDER
		 */
		public String getPROVIDER() {
			return PROVIDER;
		}
		/**
		 * @param pROVIDER the pROVIDER to set
		 */
		public void setPROVIDER(String pROVIDER) {
			PROVIDER = pROVIDER;
		}
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月10日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IComptelCatalog implements java.io.Serializable{
		private static final long serialVersionUID = 2846199483501296012L;
		private String ID         ;
		private long   COMPETE    ;
		private long   PRODUCT    ;
		private String DESCRIPTION;
		private String EXTEND     ;
		private long   SORT_BY    ;
		private String IMPLCLASS  ;
		private String COMPLEX    ;
		private String CHECKING   ;
		private java.sql.Timestamp EFFECTIVE  ;
		private java.sql.Timestamp EXPIRE     ;
		public IComptelCatalog( ISAComptelRel aCompetence ){
			super();
			ID          = String.valueOf(aCompetence.getId());
			COMPETE     = aCompetence.getCompeteId  ();
			PRODUCT     = aCompetence.getProductId  ();
			DESCRIPTION = aCompetence.getDescription();
			EXTEND      = aCompetence.getExtendId   ();
			SORT_BY     = aCompetence.getSortBy     ();
			IMPLCLASS   = aCompetence.getImplclass  ();
			COMPLEX     = aCompetence.getComplex    ();
			CHECKING    = aCompetence.getChecking   ();
			EFFECTIVE   = aCompetence.getEffective  ();
			EXPIRE      = aCompetence.getExpire     ();
		}
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}
		/**
		 * @return the cOMPETE
		 */
		public long getCOMPETE() {
			return COMPETE;
		}
		/**
		 * @param cOMPETE the cOMPETE to set
		 */
		public void setCOMPETE(long cOMPETE) {
			COMPETE = cOMPETE;
		}
		/**
		 * @return the pRODUCT
		 */
		public long getPRODUCT() {
			return PRODUCT;
		}
		/**
		 * @param pRODUCT the pRODUCT to set
		 */
		public void setPRODUCT(long pRODUCT) {
			PRODUCT = pRODUCT;
		}
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		/**
		 * @param dESCRIPTION the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
		/**
		 * @return the eXTEND
		 */
		public String getEXTEND() {
			return EXTEND;
		}
		/**
		 * @param eXTEND the eXTEND to set
		 */
		public void setEXTEND(String eXTEND) {
			EXTEND = eXTEND;
		}
		/**
		 * @return the sORT_BY
		 */
		public long getSORT_BY() {
			return SORT_BY;
		}
		/**
		 * @param sORT_BY the sORT_BY to set
		 */
		public void setSORT_BY(long sORT_BY) {
			SORT_BY = sORT_BY;
		}
		/**
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}
		/**
		 * @param iMPLCLASS the iMPLCLASS to set
		 */
		public void setIMPLCLASS(String iMPLCLASS) {
			IMPLCLASS = iMPLCLASS;
		}
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		/**
		 * @return the cHECKING
		 */
		public String getCHECKING() {
			return CHECKING;
		}
		/**
		 * @param cHECKING the cHECKING to set
		 */
		public void setCHECKING(String cHECKING) {
			CHECKING = cHECKING;
		}
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
	}
	/**
	 * 
	 * @author:HC
	 * @date:2016年1月6日
	 * @description:
	 */
	public static class ICompetenceOffer implements java.io.Serializable{
		private static final long serialVersionUID = -7832818462436232868L;
		protected String ID           ;                  
		protected String NAME         ;                  
		protected String CATEGORY     ;
		protected long   CATALOG      ;    
		protected long   BUSINESS     ;
		protected String COMPLEX      ;
		protected String IMPLCLASS    ;
		protected String COMPLETE     ;          
		protected String CONTROL      ;
		public ICompetenceOffer( ISACompetence aTEMPLATE ){
			super();
			ID            = aTEMPLATE.getId         ();                  
			NAME          = aTEMPLATE.getName       ();                  
			CATEGORY      = aTEMPLATE.getCategory   ();
			CATALOG       = aTEMPLATE.getCatalog    ();   
			BUSINESS      = aTEMPLATE.getBusiness   ();
			COMPLEX       = aTEMPLATE.getComplex    ();
			IMPLCLASS     = aTEMPLATE.getImplclass  ();
			COMPLETE      = aTEMPLATE.getComplete   ();     
			CONTROL       = aTEMPLATE.getControl    ();
		}
		
		public ICompetenceOffer( ISACompetenceRel aCatalog ){
			super();
			ID          = aCatalog.getCode       ();
			NAME        = aCatalog.getName       ();
			CATEGORY    = aCatalog.getCategory   ();
			CATALOG     = aCatalog.getCatalog    ();
			BUSINESS    = aCatalog.getBusiness   ();
			IMPLCLASS   = aCatalog.getImplclass  ();
			COMPLEX     = aCatalog.getComplex    ();
			CONTROL     = aCatalog.getControl    ();
		}
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		/**
		 * @param nAME the nAME to set
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		/**
		 * @return the cATALOG
		 */
		public long getCATALOG() {
			return CATALOG;
		}
		/**
		 * @param cATALOG the cATALOG to set
		 */
		public void setCATALOG(long cATALOG) {
			CATALOG = cATALOG;
		}
		/**
		 * @return the bUSINESS
		 */
		public long getBUSINESS() {
			return BUSINESS;
		}
		/**
		 * @param bUSINESS the bUSINESS to set
		 */
		public void setBUSINESS(long bUSINESS) {
			BUSINESS = bUSINESS;
		}
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		/**
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}
		/**
		 * @param iMPLCLASS the iMPLCLASS to set
		 */
		public void setIMPLCLASS(String iMPLCLASS) {
			IMPLCLASS = iMPLCLASS;
		}
		/**
		 * @return the cOMPLETE
		 */
		public String getCOMPLETE() {
			return COMPLETE;
		}
		/**
		 * @param cOMPLETE the cOMPLETE to set
		 */
		public void setCOMPLETE(String cOMPLETE) {
			COMPLETE = cOMPLETE;
		}
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		/**
		 * @param cONTROL the cONTROL to set
		 */
		public void setCONTROL(String cONTROL) {
			CONTROL = cONTROL;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务能力接入模板</p>
	 * <p>Copyright: Copyright (c) 2013-5-21</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICompetenceBusines extends ICompetenceOffer implements java.io.Serializable{
		private static final long serialVersionUID = -8905627678025345320L;
		private java.sql.Timestamp EFFECTIVE    ;                  
		private java.sql.Timestamp EXPIRE       ;
		private java.util.Map SUBFLOW  = new java.util.HashMap();
		public ICompetenceBusines(ISACompetence aTEMPLATE) throws Exception{
			super( aTEMPLATE );
			EFFECTIVE     = aTEMPLATE.getEffective  ();                  
			EXPIRE        = aTEMPLATE.getExpire     ();                  
		}
		
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}

		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}

		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}

		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}

		/**
		 * @return the sUBFLOW
		 */
		public java.util.Map getSUBFLOW() {
			return SUBFLOW;
		}
		
		/**
		 * 
		 * @param aCatalog
		 */
		public void mergeAsGroup( ISACompetenceRel aCatalog ){
			try
			{
				ICompetenceCatalog fromCatalog = new ICompetenceCatalog( aCatalog );
				String fromINDEX = ClassUtils.getINDEX( new String[]{fromCatalog.getCATEGORY(), 
						"_$_", String.valueOf( fromCatalog.getCATALOG_ID() ) } );
				SUBFLOW.put( fromINDEX, fromCatalog );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromINDEX 模板索引
		 * @return
		 */
		public ICompetenceCatalog getSUBFLOW( String fromINDEX ){
			return (ICompetenceCatalog)SUBFLOW.get( fromINDEX );
		}
		
		/**
		 * 根据能力类型获取对应开通能力
		 * @param fromMODULE 能力类型
		 * @param fromCATALOG 产品规格
		 * @return
		 */
		public ICompetenceCatalog getSUBFLOW( String fromMODULE, String fromCATALOG ){
			ICompetenceCatalog fromUpdcpm = null;
			try
			{
				String fromINDEX = ClassUtils.getINDEX( new String[]{fromMODULE, "_$_", 
						fromCATALOG } );
				fromUpdcpm = (ICompetenceCatalog)SUBFLOW.get( fromINDEX );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据能力类型获取对应开通能力
		 * @param fromCATALOG 产品规格
		 * @return
		 */
		public ICompetenceOffer getBUSINES( String fromCATALOG ){
			ICompetenceOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = getSUBFLOW( getCATEGORY(), fromCATALOG );
				if( fromUpdcpm == null ) fromUpdcpm = this;
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 是否为正常定单
		 * @return
		 */
		public boolean isNORMAL(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.IUpdbm.PROGRAM_BUSINES ) ;
		}
		
		/**
		 * 是否群组定单
		 * @return
		 */
		public boolean isGROUP(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.IUpdbm.PROGRAM_GROUP ) ;
		}
		
		/**
		 * 是否成员组定单
		 * @return
		 */
		public boolean isCENTREX(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.IUpdbm.PROGRAM_CENTREX ) ;
		}
		
		/**
		 * 是否成员定单
		 * @return
		 */
		public boolean isMEMBER(){
			return StringUtils.equals( CATEGORY, IUpdcConst.IUpdcp.IUpdbm.PROGRAM_MEMBER ) ;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务能力二级接入模板</p>
	 * <p>Copyright: Copyright (c) 2015年10月9日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICompetenceCatalog extends ICompetenceOffer implements java.io.Serializable {
		private static final long serialVersionUID = 7380688783065633566L;
		private String COMPETENCE;
		private String CATALOG_ID;
		private java.sql.Timestamp EFFECTIVE;
		private java.sql.Timestamp EXPIRE;
		public ICompetenceCatalog(ISACompetenceRel aCatalog) {
			super( aCatalog );
			COMPETENCE  = aCatalog.getCompetence ();
			CATALOG_ID  = aCatalog.getCatalogId  ();
			EFFECTIVE   = aCatalog.getEffective  ();
			EXPIRE      = aCatalog.getExpire     ();
		}
		/**
		 * @return the cOMPETENCE
		 */
		public String getCOMPETENCE() {
			return COMPETENCE;
		}
		/**
		 * @param cOMPETENCE the cOMPETENCE to set
		 */
		public void setCOMPETENCE(String cOMPETENCE) {
			COMPETENCE = cOMPETENCE;
		}
		/**
		 * @return the cATALOG_ID
		 */
		public String getCATALOG_ID() {
			return CATALOG_ID;
		}
		/**
		 * @param cATALOG_ID the cATALOG_ID to set
		 */
		public void setCATALOG_ID(String cATALOG_ID) {
			CATALOG_ID = cATALOG_ID;
		}
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 即开即通流程集</p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbpmOffer implements java.io.Serializable{
		private static final long serialVersionUID = 805034619074815667L;
		private String ID           ;                
		private String NAME         ;                
		private String CATEGORY     ;
		private String COMPLEX      ;
		private java.util.List SUBFLOW = new java.util.ArrayList();
		public IUpdbpmOffer( ISAWorkFlow aWorkflow ){
			super();
			ID            = aWorkflow.getId         ();                
			NAME          = aWorkflow.getName       ();                
			CATEGORY      = aWorkflow.getCategory   ();
			COMPLEX       = aWorkflow.getComplex    ();
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}

		/**
		 * @param category the cATEGORY to set
		 */
		public void setCATEGORY(String category) {
			CATEGORY = category;
		}

		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}

		/**
		 * @param complex the cOMPLEX to set
		 */
		public void setCOMPLEX(String complex) {
			COMPLEX = complex;
		}

		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}

		/**
		 * @param id the iD to set
		 */
		public void setID(String id) {
			ID = id;
		}

		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}

		/**
		 * @param name the nAME to set
		 */
		public void setNAME(String name) {
			NAME = name;
		}

		/**
		 * 
		 * @return
		 */
		public java.util.List getSUBFLOW(){
			return SUBFLOW;
		}
		/**
		 * 
		 * @param fromUpdbm
		 */
		public void subscribe( IUpdbpelOffer fromUpdbm ){
			try
			{
				SUBFLOW.add( fromUpdbm );
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活流程规范</p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbpelOffer extends ISystemTemplate.IUpdbpmOffer implements java.io.Serializable{
		private static final long serialVersionUID = -4380859435062702021L;
		public IUpdbpelOffer( ISASubFlow aWORKFLW ) throws Exception{
			super();
			ID        = String.valueOf(aWORKFLW.getId());                
			NAME      = aWORKFLW.getName       ();  
			SUBFLOW   = aWORKFLW.getSubflow    ();
			CATEGORY  = aWORKFLW.getCategory   ();   
			PLATFORM  = aWORKFLW.getPlatform   ();                
			DIRECTIVE = aWORKFLW.getDirective  ();                
			PROGRAM   = aWORKFLW.getProgram    ();   
			COMPLETE  = aWORKFLW.getComplete   ();
			PRIORITY  = aWORKFLW.getPriority   ();   
			SORT_BY   = aWORKFLW.getSortBy     ();                
			CONTROL   = aWORKFLW.getControl    ();   
			JEVAL     = aWORKFLW.getJeval      ();                
			IMPLCLASS = aWORKFLW.getImplclass  ();                
			COMPOSITE = aWORKFLW.getComposite  ();   
			COMPLEX   = aWORKFLW.getComplex    ();
			JdomUtils.ICustom.wrap( COMPOSITE, GRAPHICS );
			JdomUtils._getISTKJdomL( CONTROL , GRAPHICS );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 开通接入层</p>
	 * <p>Copyright: Copyright (c) 2011-10-12</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IBusinesOffer implements java.io.Serializable{
		private static final long serialVersionUID = -164813989414319104L;
		private long   ID         ;
		private String CATALOG    ;
		private String BUSINES    ;
		private String ORIGINATE  ;
		private String NAME       ;
		private String CATEGORY   ;
		private String DESCRIPTION;
		private String IMPLCLASS  ;
		private String PROGRAM    ;
		private long   PRIORITY   ;
		private String PROTOCOL   ;
		private String PROVIDER   ;
		private String COMPETENCE ;
		private String COMPLETE   ;
		private String COMPOSITE  ;
		private String COMPLEX    ;
		private String GROUP      ;
		private String MEMBER     ;
		private String CONTROL    ;
		private java.sql.Timestamp EFFECTIVE  ;
		private java.sql.Timestamp EXPIRE     ;
        private java.util.Map GRAPHICS = new java.util.HashMap();
		public IBusinesOffer(ISABusines aBusines){
			super();
			ID          = aBusines.getId         ();
			CATALOG     = aBusines.getCatalog    ();
			BUSINES     = aBusines.getBusiness   ();
			ORIGINATE   = aBusines.getOriginate  ();
			NAME        = aBusines.getName       ();
			CATEGORY    = aBusines.getCategory   ();
			DESCRIPTION = aBusines.getDescription();
			IMPLCLASS   = aBusines.getImplclass  ();
			PROVIDER    = aBusines.getProtocol   ();
			PROGRAM     = aBusines.getProgram    ();
			PRIORITY    = aBusines.getPriority   ();
			PROTOCOL    = aBusines.getProtocol   ();
			COMPETENCE  = aBusines.getCompetence ();
			COMPLETE    = aBusines.getComplete   ();
			COMPOSITE   = aBusines.getComposite  ();
			COMPLEX     = aBusines.getComplex    ();
			GROUP       = aBusines.getGroupRole  ();
			MEMBER      = aBusines.getMemberRole ();
			CONTROL     = aBusines.getControl    ();
			EFFECTIVE   = aBusines.getEffective  ();
			EXPIRE      = aBusines.getExpire     ();
			JdomUtils._getISTKJdomL( CONTROL, GRAPHICS );
		}
		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}
		/**
		 * @param iD the iD to set
		 */
		public void setID(long iD) {
			ID = iD;
		}
		/**
		 * @return the cATALOG
		 */
		public String getCATALOG() {
			return CATALOG;
		}
		/**
		 * @param cATALOG the cATALOG to set
		 */
		public void setCATALOG(String cATALOG) {
			CATALOG = cATALOG;
		}
		/**
		 * @return the bUSINES
		 */
		public String getBUSINES() {
			return BUSINES;
		}
		/**
		 * @param bUSINES the bUSINES to set
		 */
		public void setBUSINES(String bUSINES) {
			BUSINES = bUSINES;
		}
		
		/**
		 * @return the oRIGINATE
		 */
		public String getORIGINATE() {
			return ORIGINATE;
		}
		/**
		 * @param oRIGINATE the oRIGINATE to set
		 */
		public void setORIGINATE(String oRIGINATE) {
			ORIGINATE = oRIGINATE;
		}
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		/**
		 * @param nAME the nAME to set
		 */
		public void setNAME(String nAME) {
			NAME = nAME;
		}
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		/**
		 * @param cATEGORY the cATEGORY to set
		 */
		public void setCATEGORY(String cATEGORY) {
			CATEGORY = cATEGORY;
		}
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		/**
		 * @param dESCRIPTION the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
		/**
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}
		/**
		 * @param iMPLCLASS the iMPLCLASS to set
		 */
		public void setIMPLCLASS(String iMPLCLASS) {
			IMPLCLASS = iMPLCLASS;
		}
		/**
		 * @return the pROGRAM
		 */
		public String getPROGRAM() {
			return PROGRAM;
		}
		/**
		 * @param pROGRAM the pROGRAM to set
		 */
		public void setPROGRAM(String pROGRAM) {
			PROGRAM = pROGRAM;
		}
		/**
		 * @return the pRIORITY
		 */
		public long getPRIORITY() {
			return PRIORITY;
		}
		/**
		 * @param pRIORITY the pRIORITY to set
		 */
		public void setPRIORITY(long pRIORITY) {
			PRIORITY = pRIORITY;
		}
		/**
		 * @return the pROTOCOL
		 */
		public String getPROTOCOL() {
			return PROTOCOL;
		}
		/**
		 * @param pROTOCOL the pROTOCOL to set
		 */
		public void setPROTOCOL(String pROTOCOL) {
			PROTOCOL = pROTOCOL;
		}
		/**
		 * @return the pROVIDER
		 */
		public String getPROVIDER() {
			return PROVIDER;
		}
		/**
		 * @param pROVIDER the pROVIDER to set
		 */
		public void setPROVIDER(String pROVIDER) {
			PROVIDER = pROVIDER;
		}
		/**
		 * @return the cOMPETENCE
		 */
		public String getCOMPETENCE() {
			return COMPETENCE;
		}
		/**
		 * @param cOMPETENCE the cOMPETENCE to set
		 */
		public void setCOMPETENCE(String cOMPETENCE) {
			COMPETENCE = cOMPETENCE;
		}
		/**
		 * @return the cOMPLETE
		 */
		public String getCOMPLETE() {
			return COMPLETE;
		}
		/**
		 * @param cOMPLETE the cOMPLETE to set
		 */
		public void setCOMPLETE(String cOMPLETE) {
			COMPLETE = cOMPLETE;
		}
		/**
		 * @return the cOMPOSITE
		 */
		public String getCOMPOSITE() {
			return COMPOSITE;
		}
		/**
		 * @param cOMPOSITE the cOMPOSITE to set
		 */
		public void setCOMPOSITE(String cOMPOSITE) {
			COMPOSITE = cOMPOSITE;
		}
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		/**
		 * @param cOMPLEX the cOMPLEX to set
		 */
		public void setCOMPLEX(String cOMPLEX) {
			COMPLEX = cOMPLEX;
		}
		/**
		 * @return the gROUP
		 */
		public String getGROUP() {
			return GROUP;
		}
		/**
		 * @param gROUP the gROUP to set
		 */
		public void setGROUP(String gROUP) {
			GROUP = gROUP;
		}
		/**
		 * @return the mEMBER
		 */
		public String getMEMBER() {
			return MEMBER;
		}
		/**
		 * @param mEMBER the mEMBER to set
		 */
		public void setMEMBER(String mEMBER) {
			MEMBER = mEMBER;
		}
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		/**
		 * @param cONTROL the cONTROL to set
		 */
		public void setCONTROL(String cONTROL) {
			CONTROL = cONTROL;
		}
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		/**
		 * @param eFFECTIVE the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		/**
		 * @param eXPIRE the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
		/**
		 * @return the gRAPHICS
		 */
		public java.util.Map getGRAPHICS() {
			return GRAPHICS;
		}
		/**
		 * 是否开通明细归档
		 * @return
		 */
		public boolean isCOMPLETE(){
			return StringUtils.equals( COMPLETE, IUpdcConst.IEnum.IYesNo.Yes );
		}
		/**
		 * 是否支持下周期变更
		 * @return
		 */
		public boolean isEXPIRE(){
			return StringUtils.equals( COMPOSITE, IUpdcConst.IUpdbm.IUpdbf.EXPIRE );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 开通接入层扩展属性</p>
	 * <p>Copyright: Copyright (c) 2015年9月29日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IBusinesCombine  implements java.io.Serializable{
		private static final long serialVersionUID = -9058275896661230054L;
		private String ID ;
		private java.util.Map PROGRAM = new java.util.HashMap();
		public IBusinesCombine( String aID ){
			super();
			ID = aID ;
		}
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @return the pROGRAM
		 */
		public java.util.Map getPROGRAM() {
			return PROGRAM;
		}
		/**
		 * 
		 * @param fromCOMPETE
		 * @return
		 */
		public IBusinesKernel getPROGRAM( String fromCOMPETE ){
			IBusinesKernel fromKernel = null;
			try
			{
				fromKernel = (IBusinesKernel)PROGRAM.get( fromCOMPETE );
			}
			finally{
				
			}
			return fromKernel;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年9月30日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IBusinesKernel implements java.io.Serializable{
		private static final long serialVersionUID = 8264385744539885675L;
		private String ID         ;
		private String NAME       ;
		private String PROGRAM    ;
		private String DESCRIPTION;
		private String IMPLCLASS  ;
		private String COMPLEX    ;
		private String CONTROL    ;
		private java.sql.Timestamp EFFECTIVE  ;
		private java.sql.Timestamp EXPIRE     ;
		public IBusinesKernel( ISABusinesX fromBusinesX ){
			super();
			ID          = fromBusinesX.getCode       ();
			NAME        = fromBusinesX.getName       ();
			PROGRAM     = fromBusinesX.getProgram    ();
			DESCRIPTION = fromBusinesX.getDescription();
			IMPLCLASS   = fromBusinesX.getImplclass  ();
			COMPLEX     = fromBusinesX.getComplex    ();
			CONTROL     = fromBusinesX.getControl    ();
			EFFECTIVE   = fromBusinesX.getEffective  ();
			EXPIRE      = fromBusinesX.getExpire     ();
		}
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		/**
		 * @return the pROGRAM
		 */
		public String getPROGRAM() {
			return PROGRAM;
		}
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		/**
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 开通接入层产品关联</p>
	 * <p>Copyright: Copyright (c) 2015年9月29日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IBusinesCatalog  implements java.io.Serializable{
		private static final long serialVersionUID = -9058275896661230054L;
		private String CATALOG    ;
		private String BUSINES    ;
		private String PRODUCT    ;
		private String NAME       ;
		private String CATEGORY   ;
		private String DESCRIPTION;
		private String IMPLCLASS  ;
		private String COMPLEX    ;
		private String CONTROL    ;
		private java.sql.Timestamp EFFECTIVE  ;
		private java.sql.Timestamp EXPIRE     ;
		private java.util.Map SUBFLOW = new java.util.HashMap();
		public IBusinesCatalog( ISABusinesRel aBusinesRel){
			super();
			CATALOG     = aBusinesRel.getCatalog    ();
			BUSINES     = aBusinesRel.getBusiness   ();
			PRODUCT     = aBusinesRel.getProduct    ();
			NAME        = aBusinesRel.getName       ();
			CATEGORY    = aBusinesRel.getCategory   ();
			DESCRIPTION = aBusinesRel.getDescription();
			IMPLCLASS   = aBusinesRel.getImplclass  ();
			COMPLEX     = aBusinesRel.getComplex    ();
			CONTROL     = aBusinesRel.getControl    ();
			EFFECTIVE   = aBusinesRel.getEffective  ();
			EXPIRE      = aBusinesRel.getExpire     ();
			JdomUtils._getISTKJdomL( CONTROL, SUBFLOW );
			JdomUtils.ICustom.wrap ( COMPLEX, SUBFLOW );
		}
		
		/**
		 * @return the cATALOG
		 */
		public String getCATALOG() {
			return CATALOG;
		}
		
		/**
		 * @return the bUSINES
		 */
		public String getBUSINES() {
			return BUSINES;
		}
		
		/**
		 * @return the pRODUCT
		 */
		public String getPRODUCT() {
			return PRODUCT;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		
		/**
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}

		/**
		 * @return the sUBFLOW
		 */
		public java.util.Map getSUBFLOW() {
			return SUBFLOW;
		}
		
		/**
		 * 
		 * @param aCOMPETE
		 * @return
		 */
		public String getSUBFLOW( String aCOMPETE ){
			return (String)SUBFLOW.get( aCOMPETE );
		}
	}
}
