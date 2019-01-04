package com.ai.sacenter.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.platform.bo.ISAPhone;
import com.ai.sacenter.base.platform.bo.ISAPlatform;
import com.ai.sacenter.base.platform.bo.ISARespond;
import com.ai.sacenter.base.platform.bo.ISARespondRel;
import com.ai.sacenter.base.platform.bo.SAProtocol;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.module.IConfigDefine.IGlobalDefine.IControlDefine;
import com.ai.sacenter.base.platform.bo.ISAClient;
import com.ai.sacenter.base.platform.bo.ISADebuging;
import com.ai.sacenter.base.platform.bo.ISADirective;
import com.ai.sacenter.base.platform.bo.ISADirectiveS;
import com.ai.sacenter.base.platform.bo.ISAFeature;
import com.ai.sacenter.base.platform.bo.ISAOperate;
import com.ai.sacenter.base.platform.bo.SAMapping;
import com.ai.sacenter.base.platform.bo.SAMappingRel;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.FileUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IPlatformTemplate implements java.io.Serializable {
	private static final long serialVersionUID = -3711047149699807633L;
	public IPlatformTemplate() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元基本信息</p>
	 * <p>Copyright: Copyright (c) 2011-10-12</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmOffer implements java.io.Serializable{
		private static final long serialVersionUID = 783831171855855762L;
		private String ID             ;
		private String CODE           ;
		private String NAME           ;
		private String CATEGORY       ;
		private String DESCRIPTION    ;
		private String PARENT_        ;
		private String PROTOCOL       ;
		private String CONTROL        ;
		private String NETWORK        ;
		private IUpffmNetWork DIGITAL = null;
		private LittleEndian  ENDIAN = null;
		private java.util.Map GRAPHICS = new java.util.HashMap();
		public IUpffmOffer(){
			super();
		}
		
		public IUpffmOffer( ISAPlatform aPlatform ){
			super();
			ID             = aPlatform.getId             ();
			CODE           = aPlatform.getCode           ();
			NAME           = aPlatform.getName           ();
			CATEGORY       = aPlatform.getCategory       ();
			DESCRIPTION    = aPlatform.getDescription    ();
			PARENT_        = aPlatform.getParentPlatform ();
			PROTOCOL       = aPlatform.getProtocol       ();
			CONTROL        = aPlatform.getControl        ();
			NETWORK        = aPlatform.getNetwork        ();
			JdomUtils._getISTKJdomL( CONTROL , GRAPHICS );
			ENDIAN         = new LittleEndian( this );
		}
		
		public IUpffmOffer( ISAPlatform aPlatform, IUpffmNetWork aClient, java.util.Map fromGraph ){
			super();
			ID             = aPlatform.getId             ();
			CODE           = aPlatform.getCode           ();
			NAME           = aPlatform.getName           ();
			CATEGORY       = aPlatform.getCategory       ();
			DESCRIPTION    = aPlatform.getDescription    ();
			PARENT_        = aPlatform.getParentPlatform ();
			PROTOCOL       = aPlatform.getProtocol       ();
			CONTROL        = aPlatform.getControl        ();
			NETWORK        = aPlatform.getNetwork        ();
			JdomUtils._getISTKJdomL( CONTROL , GRAPHICS );
			if( fromGraph != null ) GRAPHICS.putAll( fromGraph );
			ENDIAN         = new LittleEndian( this );
			DIGITAL        = aClient;
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
		 * @return the cODE
		 */
		public String getCODE() {
			return CODE;
		}
		
		/**
		 * @param code the cODE to set
		 */
		public void setCODE(String code) {
			CODE = code;
		}
		
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		
		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		
		/**
		 * @param description the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String description) {
			DESCRIPTION = description;
		}
		
		/**
		 * @return the dIGITAL
		 */
		public IUpffmNetWork getDIGITAL() {
			return DIGITAL;
		}
		
		/**
		 * @param digital the dIGITAL to set
		 */
		public void setDIGITAL(IUpffmNetWork digital) {
			DIGITAL = digital;
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
		 * @return the nETWORK
		 */
		public String getNETWORK() {
			return NETWORK;
		}
		
		/**
		 * @param network the nETWORK to set
		 */
		public void setNETWORK(String network) {
			NETWORK = network;
		}
		
		/**
		 * @return the pARENT_
		 */
		public String getPARENT_() {
			return PARENT_;
		}
		
		/**
		 * @param parent_ the pARENT_ to set
		 */
		public void setPARENT_(String parent_) {
			PARENT_ = parent_;
		}
		
		/**
		 * @return the pROTOCOL
		 */
		public String getPROTOCOL() {
			return PROTOCOL;
		}
		
		/**
		 * @param protocol the pROTOCOL to set
		 */
		public void setPROTOCOL(String protocol) {
			PROTOCOL = protocol;
		}
		
		/**
		 * @param endian the eNDIAN to set
		 */
		public void setENDIAN(LittleEndian endian) {
			ENDIAN = endian;
		}
		
		/**
		 * @param graphics the gRAPHICS to set
		 */
		public void setGRAPHICS(java.util.Map graphics) {
			GRAPHICS = graphics;
		}
		
		/**
		 * @return the eNDIAN
		 */
		public LittleEndian getENDIAN() {
			return ENDIAN;
		}
		
		/**
		 * @return the gRAPHICS
		 */
		public java.util.Map getGRAPHICS() {
			return GRAPHICS;
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean isTable(){
			return StringUtils.equalsIgnoreCase( PROTOCOL , "TABLE" );
		}
		
		/**
		 * 是否开通规范组
		 * @return
		 */
		public boolean isSUBFLOW(){
			return StringUtils.equals( ID, IUpdcConst.IUpfwm.IUpfm.ucmframe );
		}
		
		/**
		 * 是否外部规范组
		 * @return
		 */
		public boolean isEXTEND(){
			return StringUtils.equals( ID, IUpdcConst.IUpfwm.IUpfm.ucmframe ) == false;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			String __xml__ = null;
			try
			{
				org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
				org.dom4j.Element _root = document.addElement( "InterBOSS" );
				org.dom4j.Element _platform = _root.addElement( "PLATFORM" );
				_platform.addElement( "_id_"       ).setText( ID                         );
				_platform.addElement( "_code_"     ).setText( CODE != null?CODE:""       );
				_platform.addElement( "_name_"     ).setText( NAME != null?NAME:""       );
				_platform.addElement( "_parent_"   ).setText( PARENT_ != null?PARENT_:"" );
				if( DIGITAL != null ){
					org.dom4j.Element _network = _platform.addElement( "NETWORK" );
					_network.addElement( "_id_"         ).setText( DIGITAL.ID        );
					_network.addElement( "_name_"       ).setText( DIGITAL.ID        );
					_network.addElement( "_network_"    ).setText( DIGITAL.NETWORK   );
					_network.addElement( "_implclass_"  ).setText( DIGITAL.IMPLCLASS );
				}
				if( ENDIAN != null ){
					org.dom4j.Element _subflow = _platform.addElement( "SUBFLOW" );
					_subflow.addElement( "_persistent_" ).setText( ENDIAN.PERSISTENT != null?ENDIAN.PERSISTENT:"" );
					_subflow.addElement( "_repository_" ).setText( ENDIAN.REPOSITORY != null?ENDIAN.REPOSITORY:"" );
					_subflow.addElement( "_composite_"  ).setText( ENDIAN.COMPOSITE != null?ENDIAN.COMPOSITE:""   );
					_subflow.addElement( "_provision_"  ).setText( ENDIAN.PROVISION != null?ENDIAN.PROVISION:""   );
					_subflow.addElement( "_reqoting_"   ).setText( ENDIAN.REQOTING != null?ENDIAN.REQOTING:""     );
					_subflow.addElement( "_debuging_"   ).setText( ENDIAN.DEBUGING != null?ENDIAN.DEBUGING:""     );
				}
				__xml__ = XmlUtils.IXml._format( document.asXML() );
			}
			catch( java.lang.Exception exception ){
				__xml__ = super.toString();
			}
			return __xml__;
		}

		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: 网元分析器</p>
		 * <p>Copyright: Copyright (c) 2014-8-27</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 3.0
		 */
		public static class LittleEndian implements java.io.Serializable{
			private static final long serialVersionUID = 2639659444481222565L;
			/*网元工单容器*/
			private String PERSISTENT;
			/*网元工单存储*/
			private String REPOSITORY;
			/*异步工单表前缀*/
			private String COMPOSITE;
			/*到期批开*/
			private String PROVISION;
			/*交易日志开关*/
			private String REQOTING;
			/*报文交易开关*/
			private String DEBUGING;
			public LittleEndian( final IUpffmOffer fromUpfm ){
				super();
				PERSISTENT = (String)fromUpfm.GRAPHICS.get( IUpdcConst.IUpdbm.IUpdbf.PERSISTENT );
				REPOSITORY = (String)fromUpfm.GRAPHICS.get( IUpdcConst.IUpdbm.IUpdbf.REPOSITORY );
				COMPOSITE  = (String)fromUpfm.GRAPHICS.get( IUpdcConst.IUpdbm.IUpdbf.COMPOSITE  );
				PROVISION  = (String)fromUpfm.GRAPHICS.get( IUpdcConst.IUpdbm.IUpdbf.PROVISION  );
				REQOTING   = (String)fromUpfm.GRAPHICS.get( IUpdcConst.IUpdbm.IUpdbf.REQOTING   );
				DEBUGING   = (String)fromUpfm.GRAPHICS.get( IUpdcConst.IUpdbm.IUpdbf.DEBUGING   );
			}
			
			/**
			 * @return 异步工单表前缀
			 */
			public String getCOMPOSITE() {
				return COMPOSITE;
			}
			
			/**
			 * @return 报文交易开关
			 */
			public boolean getDEBUGING() {
				return StringUtils.equalsIgnoreCase( DEBUGING, Boolean.TRUE.toString() );
			}
			
			/**
			 * @return 网元工单容器
			 */
			public String getPERSISTENT() {
				return PERSISTENT;
			}
			
			/**
			 * @return 网元工单存储
			 */
			public String getREPOSITORY() {
				return REPOSITORY;
			}
			
			/**
			 * @return 到期批开
			 */
			public String getPROVISION() {
				return PROVISION;
			}
			
			/**
			 * @return 交易日志开关
			 */
			public boolean getREQOTING() {
				return StringUtils.equalsIgnoreCase( REQOTING, Boolean.TRUE.toString() );
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-4-28</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffmNetWork  implements java.io.Serializable{
		private static final long serialVersionUID = 7083975674814L;
		private String ID           ;
		private String NAME         ;
		private String CATEGORY     ;
		private String DESCRIPTION  ;
		private String NETWORK      ;
		private String IMPLCLASS    ;
		private String COMPLEX      ;
		public IUpffmNetWork(ISAClient aClient) throws Exception{
			super();
			ID            = aClient.getId         ();
			NAME          = aClient.getName       ();
			CATEGORY      = aClient.getCategory   ();
			DESCRIPTION   = aClient.getDescription();
			NETWORK       = aClient.getNetwork    ();
			IMPLCLASS     = aClient.getImplclass  ();
			COMPLEX       = aClient.getComplex    ();
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
		 * @return the nETWORK
		 */
		public String getNETWORK() {
			return NETWORK;
		}
		/**
		 * @param nETWORK the nETWORK to set
		 */
		public void setNETWORK(String nETWORK) {
			NETWORK = nETWORK;
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
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 即开即通映射集</p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffsmOffer implements java.io.Serializable{
		private static final long serialVersionUID = -1533359352466103524L;
		private String ID	       ;
		private String NAME        ;
		private String MODULE      ;
		private java.util.List COMPETENCE = new java.util.ArrayList();
		public IUpffsmOffer( SAMapping fromModule ){
			super();
			ID     = fromModule.getCode  ();
			MODULE = fromModule.getModule();
			NAME   = fromModule.getName  ();
		}
		public IUpffsmOffer( org.dom4j.Element aElement ) throws Exception{
			super();
			ID     = ClassUtils.getINDEX( new String[]{ aElement.getParent().attributeValue("id"),".",aElement.attributeValue("id") });
			NAME   = aElement.attributeValue( "desc", "*" );
			MODULE = aElement.getParent().attributeValue("id");
			for( java.util.Iterator itera = aElement.elements("mapping").iterator(); itera.hasNext(); ){
				org.dom4j.Element temp = (org.dom4j.Element)itera.next();
				String aUSE = temp.attributeValue("use", "true");
				if( aUSE.equalsIgnoreCase("false") ) continue;
				COMPETENCE.add( new IUpffgsmOffer( temp ) );
			}
		}
		
		/**
		 * @return the cOMPETENCE
		 */
		public java.util.List getCOMPETENCE() {
			return COMPETENCE;
		}
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @return the mODULE
		 */
		public String getMODULE() {
			return MODULE;
		}
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		/**
		 * 
		 * @param fromCatalog
		 * @param fromUpfgsmc
		 */
		public void baleUcm2Upfsm( SAMappingRel fromCatalog , java.util.HashMap fromUpfgsmc ){
			COMPETENCE.add( new IUpffgsmOffer( fromCatalog , fromUpfgsmc ) );
		}
		/**
		 * 
		 * @param fromUpfsm
		 */
		public void baleUcm2Upfsm( IUpffsmOffer fromUpfsm ){
			for( java.util.Iterator itera = fromUpfsm.COMPETENCE.iterator(); itera.hasNext(); ){
				IUpffgsmOffer fromUpfgsm = (IUpffgsmOffer)itera.next();
				COMPETENCE.add( fromUpfgsm );
			}
		}
		/**
		 * 
		 * @param aElement
		 * @throws Exception
		 */
		public void baleUcm2Jdom( org.dom4j.Element aElement ) throws Exception{
			aElement.addAttribute("id", StringUtils.wildcardArray( ID, "." )[1]);
			aElement.addAttribute("desc", StringUtils.substringBefore(NAME, "[") );
			for( java.util.Iterator itera = COMPETENCE.iterator(); itera.hasNext(); ){
				IUpffgsmOffer fromUpfgsm = (IUpffgsmOffer)itera.next();
				fromUpfgsm.baleUcm2Jdom( aElement.addElement("mapping") );
			}
		}
		/**
		 * 
		 * @param fromMODULE
		 * @param fromCATALOG
		 * @throws Exception
		 */
		public void baleUcm2Jdbm( java.util.List fromMODULE , 
				java.util.List fromCATALOG ) throws Exception{
			try
			{
				java.util.HashMap fromModel = new java.util.HashMap();
				fromModel.put( SAMapping.S_Id , BasicFactory.getIUpffmDAO().getSEQUENCE(
						SAMapping.S_TYPE.getMapingEnty() )  );
				fromModel.put( SAMapping.S_Code, ID );
				fromModel.put( SAMapping.S_Name , NAME );
				fromModel.put( SAMapping.S_Category, "IUcm2UpfsmL" );
				fromModel.put( SAMapping.S_Module, MODULE );
				fromModel.put( SAMapping.S_Creater, IUpdcConst.IEnum.STAFF );
				fromModel.put( SAMapping.S_CreateDate, new java.sql.Timestamp( System.currentTimeMillis() ) );
				fromModel.put( SAMapping.S_State, "U" );
				fromMODULE.add( fromModel );
				for( int index = 0 ; COMPETENCE != null && index < COMPETENCE.size(); index++ ){
					IUpffgsmOffer fromUpfgsm = (IUpffgsmOffer)COMPETENCE.get( index );
					fromUpfgsm.baleUcm2Jdbm( this, -1 , index + 1, fromMODULE, fromCATALOG );
				}
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffgsmOffer extends ISystemTemplate.IUpfgsmOffer implements java.io.Serializable{
		private static final long serialVersionUID = -1785171049981685993L;
		private boolean NULLABLE     ;
		private boolean IGNOREABLE   ;
		private int     LENGTH       ;        
		private java.util.Map  GRAPHICS = new java.util.HashMap();
		public IUpffgsmOffer( SAMappingRel aMappingDefine ,java.util.HashMap aUpfgsmcDefine ){
			super();
			baleUcm2Upfsm( aMappingDefine , aUpfgsmcDefine );
		}
		public IUpffgsmOffer( org.dom4j.Element aElement ) throws Exception{
			super();
			baleUcm2Upfsm( aElement );
		}
		/**
		 * 
		 * @param aIMappingL
		 * @param aIMappingSubL
		 */
		private void baleUcm2Upfsm( SAMappingRel aMappingDefine , java.util.HashMap aUpfgsmcDefine ){
			ID	        = String.valueOf(aMappingDefine.getId());
			COMPETE     = aMappingDefine.getCompete    ();
			NAME        = aMappingDefine.getName       ();
			MAPPING	    = aMappingDefine.getMapping	   ();
			IMPLCLASS   = aMappingDefine.getImplclass  ();
			COMPLEX	    = aMappingDefine.getComplex() == null?aMappingDefine.getComplex():
				(StringUtils.equals( aMappingDefine.getComplex() , "NULL")?"":aMappingDefine.getComplex() );
			NULLABLE	= StringUtils.equalsIgnoreCase(aMappingDefine.getNullable(),"N")?false:true;
			IGNOREABLE  = StringUtils.equalsIgnoreCase(aMappingDefine.getIgnoreable(),"Y")?true:false;
			CATEGORY	= aMappingDefine.getCategory   ();
			SORT_BY     = aMappingDefine.getSortBy     ();
			LENGTH	    = aMappingDefine.getLength	   ();
			JdomUtils._getISTKJdomL( aMappingDefine.getControl() , GRAPHICS );
			java.util.List aUpdgmLife = (java.util.List)aUpfgsmcDefine.get( String.valueOf( aMappingDefine.getId() ) );
			if( aUpdgmLife != null && aUpdgmLife.size() > 0 ){
				for( java.util.Iterator itera = aUpdgmLife.iterator() ; itera.hasNext() ; ){
					SAMappingRel aUpfgsmDefine = (SAMappingRel)itera.next();
					COMPETENCE.add( new IUpffgsmOffer( aUpfgsmDefine , aUpfgsmcDefine ) );
				}
			}
		}
		/**
		 * 
		 * @param element
		 * @throws Exception
		 */
		private void baleUcm2Upfsm(  org.dom4j.Element element ) throws Exception{
			ID         = String.valueOf(0l);
			COMPETE    = element.attributeValue("name"     );
			NAME       = element.attributeValue("desc"     );
			if( StringUtils.isBlank( NAME ) ){ NAME   = "*"; }
			MAPPING    = element.attributeValue("mapping"  );
			IMPLCLASS  = element.attributeValue("method"   );
			CATEGORY   = element.attributeValue("type"     );
			LENGTH     = Integer.parseInt(element.attributeValue("length", "0"));
			NULLABLE   = Boolean.parseBoolean( element.attributeValue( "nullable" , "true" ) );
			IGNOREABLE = Boolean.parseBoolean(element.attributeValue("ignoreable", "false") );
			COMPLEX    = element.attributeValue("expr"     );
			for( java.util.Iterator itera = element.elements("mapping").iterator(); itera.hasNext(); ){
				org.dom4j.Element temp = (org.dom4j.Element)itera.next();
				String aUSE = temp.attributeValue("use", "true");
				if( aUSE.equalsIgnoreCase("false") ) continue;
				COMPETENCE.add( new IUpffgsmOffer( temp ) );
			}
		}
		/**
		 * 
		 * @param aElement
		 * @throws Exception
		 */
		private void baleUcm2Jdom( org.dom4j.Element aElement ) throws Exception{
			aElement.addAttribute("name", COMPETE );
			aElement.addAttribute("mapping", MAPPING );
			aElement.addAttribute("method", IMPLCLASS );
			if( StringUtils.isBlank( COMPLEX ) == false  ) aElement.addAttribute("expr", StringUtils.equals(COMPLEX, "NULL")?"":COMPLEX );
			if( StringUtils.isBlank( CATEGORY ) == false ) aElement.addAttribute("type", CATEGORY );
			if( LENGTH > 0 ) aElement.addAttribute("length", String.valueOf( LENGTH ) );
			if( NULLABLE == false ) aElement.addAttribute("nullable", "false" );
			if( IGNOREABLE == true ) aElement.addAttribute("ignoreable", "true" );
			aElement.addAttribute("desc", NAME );
			for( java.util.Iterator itera = COMPETENCE.iterator(); itera.hasNext(); ){
				IUpffgsmOffer fromUpfgsmc = (IUpffgsmOffer)itera.next();
				fromUpfgsmc.baleUcm2Jdom( aElement.addElement("mapping") );
			}
		}
		/**
		 * 
		 * @param fromUpffsm
		 * @param fromPARENT
		 * @param fromSORT
		 * @param fromMODULE
		 * @param fromCATALOG
		 * @throws Exception
		 */
		public void baleUcm2Jdbm(IUpffsmOffer fromUpffsm,
				long fromPARENT,
				long fromSORT,
				java.util.List fromMODULE , 
				java.util.List fromCATALOG ) throws Exception{
			try
			{
				java.util.HashMap fromModel = new java.util.HashMap();
				java.math.BigDecimal fromDecimal = BasicFactory.getIUpffmDAO().getSEQUENCE( 
						SAMapping.S_TYPE.getMapingEnty() );
				fromModel.put( SAMappingRel.S_Id , fromDecimal  );
				fromModel.put( SAMappingRel.S_Compete, COMPETE );
				fromModel.put( SAMappingRel.S_Name, NAME );
				fromModel.put( SAMappingRel.S_Template, fromUpffsm.getID() );
				fromModel.put( SAMappingRel.S_Module, fromUpffsm.getMODULE() );
				fromModel.put( SAMappingRel.S_Mapping, MAPPING );
				fromModel.put( SAMappingRel.S_Implclass, IMPLCLASS );
				fromModel.put( SAMappingRel.S_ParentId, new Long( fromPARENT ) );
				fromModel.put( SAMappingRel.S_SortBy, new Long( fromSORT ) );
				fromModel.put( SAMappingRel.S_Complex, COMPLEX == null ?COMPLEX:(StringUtils.isBlank(COMPLEX)?"NULL":COMPLEX) );
				fromModel.put( SAMappingRel.S_Nullable, NULLABLE?IUpdcConst.IEnum.IYesNo.Yes: IUpdcConst.IEnum.IYesNo.No );
				fromModel.put( SAMappingRel.S_Ignoreable, IGNOREABLE?IUpdcConst.IEnum.IYesNo.Yes: IUpdcConst.IEnum.IYesNo.No );
				fromModel.put( SAMappingRel.S_Category, CATEGORY );
				fromModel.put( SAMappingRel.S_Length, new Long(LENGTH) );
				fromModel.put( SAMappingRel.S_Creater, IUpdcConst.IEnum.STAFF );
				fromModel.put( SAMappingRel.S_CreateDate, new java.sql.Timestamp( System.currentTimeMillis() ) );
				fromModel.put( SAMappingRel.S_State, "U" );
				fromCATALOG.add( fromModel );
				for( int index = 0 ; COMPETENCE != null && index < COMPETENCE.size(); index++ ){
					IUpffgsmOffer fromUpfgsmc = (IUpffgsmOffer)COMPETENCE.get( index );
					fromUpfgsmc.baleUcm2Jdbm( fromUpffsm, fromDecimal.longValue(), index + 1 , fromMODULE, fromCATALOG );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * @return the iGNOREABLE
		 */
		public boolean getIGNOREABLE() {
			return IGNOREABLE;
		}
		/**
		 * @param ignoreable the iGNOREABLE to set
		 */
		public void setIGNOREABLE(boolean ignoreable) {
			IGNOREABLE = ignoreable;
		}
		/**
		 * @return the lENGTH
		 */
		public int getLENGTH() {
			return LENGTH;
		}
		/**
		 * @param length the lENGTH to set
		 */
		public void setLENGTH(int length) {
			LENGTH = length;
		}
		/**
		 * @return the nULLABLE
		 */
		public boolean getNULLABLE() {
			return NULLABLE;
		}
		/**
		 * @param nullable the nULLABLE to set
		 */
		public void setNULLABLE(boolean nullable) {
			NULLABLE = nullable;
		}
		/**
		 * @param graphics the gRAPHICS to set
		 */
		public void setGRAPHICS(java.util.Map graphics) {
			GRAPHICS = graphics;
		}
		/**
		 * @return the gRAPHICS
		 */
		public java.util.Map getGRAPHICS() {
			return GRAPHICS;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元模拟反馈</p>
	 * <p>Copyright: Copyright (c) 2014-3-24</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffmDebuging implements java.io.Serializable{
		private static final long serialVersionUID = -3529357042579923515L;
		private long   ID           ;
		private String NAME         ;
		private String DIRECTIVE    ;
		private String PLATFORM     ;
		private String COMPLEX      ;
		private String CONTROL      ;
		private java.sql.Timestamp EFFECTIVE    ;
		private java.sql.Timestamp EXPIRE       ;
		public IUpffmDebuging( ISADebuging aDebugging ){
			super();
			ID            = aDebugging.getId           ();
			NAME          = aDebugging.getName         ();
			DIRECTIVE     = aDebugging.getDirective    ();
			PLATFORM      = aDebugging.getPlatform     ();
			COMPLEX       = aDebugging.getComplex      ();
			CONTROL       = aDebugging.getControl      ();
			EFFECTIVE     = aDebugging.getEffective    ();
			EXPIRE        = aDebugging.getExpire       ();
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
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}

		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}

		/**
		 * @return the dIRECTIVE
		 */
		public String getDIRECTIVE() {
			return DIRECTIVE;
		}

		/**
		 * @param directive the dIRECTIVE to set
		 */
		public void setDIRECTIVE(String directive) {
			DIRECTIVE = directive;
		}

		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}

		/**
		 * @param effective the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp effective) {
			EFFECTIVE = effective;
		}

		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}

		/**
		 * @param expire the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp expire) {
			EXPIRE = expire;
		}

		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}

		/**
		 * @param id the iD to set
		 */
		public void setID(long id) {
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
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}

		/**
		 * @param platform the pLATFORM to set
		 */
		public void setPLATFORM(String platform) {
			PLATFORM = platform;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元属性定义</p>
	 * <p>Copyright: Copyright (c) 2013-5-31</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffxOffer implements java.io.Serializable{
		private static final long serialVersionUID = 7268879583803773601L;
		private String ID           ;
		private String NAME         ;
		private String PLATFORM     ;
		private long   CATEGORY     ;
		private String PROVIDER     ;
		public IUpffxOffer(ISAFeature aFEATURE){
			super();
			ID            = aFEATURE.getCode         ();
			NAME          = aFEATURE.getName         ();
			PLATFORM      = aFEATURE.getPlatform     ();
			CATEGORY      = aFEATURE.getCategory     ();
			PROVIDER      = aFEATURE.getProvider     ();
		}
		
		/**
		 * @return the cATEGORY
		 */
		public long getCATEGORY() {
			return CATEGORY;
		}

		/**
		 * @param category the cATEGORY to set
		 */
		public void setCATEGORY(long category) {
			CATEGORY = category;
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
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}

		/**
		 * @param platform the pLATFORM to set
		 */
		public void setPLATFORM(String platform) {
			PLATFORM = platform;
		}

		/**
		 * @return the pROVIDER
		 */
		public String getPROVIDER() {
			return PROVIDER;
		}

		/**
		 * @param provider the pROVIDER to set
		 */
		public void setPROVIDER(String provider) {
			PROVIDER = provider;
		}

		/**
		 * 是否功能属性
		 * @return
		 */
		public boolean isFUNCTION(){
			return CATEGORY == 1l; 
		}
		
		/**
		 * 是否普通属性
		 * @return
		 */
		public boolean isPLAIN(){
			return CATEGORY == 2l; 
		} 
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元操作</p>
	 * <p>Copyright: Copyright (c) 2011-10-12</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmOperate implements java.io.Serializable{
		private static final long serialVersionUID = 6554240117188692845L;
		private String ID           ;           
		private String CODE         ;           
		private String NAME         ;           
		private String CATEGORY     ;           
		private String DESCRIPTION  ;           
		private String PLATFORM_    ;           
		private String PS_TYPE      ;           
		private String PRIORITY     ;           
		private String PS_SERVICE   ;           
		private long   REDO_TIMES   ;       
		private String COMPOSITE    ;           
		private String MONITOR      ;    
		private String SYNCFLG      ;
		private String RSLTFLG      ;
		private String PLOSFLG      ;
		private String REQUEST      ;           
		private String RESPONSE     ;           
		private String COMPLEX      ;
		private String CONTROL      ;
		private java.util.Map GRAPHICS = new java.util.HashMap();
		public IUpffmOperate(){
			super();
		}
		public IUpffmOperate(ISAOperate aOperate ){
			ID            = aOperate.getId           ();           
			CODE          = aOperate.getCode         ();           
			NAME          = aOperate.getName         ();           
			CATEGORY      = aOperate.getCategory     ();           
			DESCRIPTION   = aOperate.getDescription  ();           
			PLATFORM_     = aOperate.getPlatform     ();           
			PS_TYPE       = aOperate.getPsType       ();           
			PRIORITY      = aOperate.getPriority     ();           
			PS_SERVICE    = aOperate.getPsService    ();           
			REDO_TIMES    = aOperate.getRedoTimes    (); 
			COMPOSITE     = aOperate.getComposite    ();           
			MONITOR       = aOperate.getMonitor      ();          
			SYNCFLG       = aOperate.getSyncflg      ();
			RSLTFLG       = aOperate.getRsltflg      ();
			PLOSFLG       = aOperate.getPlosflg      ();
			REQUEST       = aOperate.getRequest      ();           
			RESPONSE      = aOperate.getResponse     ();           
			COMPLEX       = aOperate.getComplex      ();
			CONTROL       = aOperate.getControl      ();
			JdomUtils._getISTKJdomL( CONTROL , GRAPHICS );
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
		 * @return the cODE
		 */
		public String getCODE() {
			return CODE;
		}
		/**
		 * @param code the cODE to set
		 */
		public void setCODE(String code) {
			CODE = code;
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
		 * @return the cOMPOSITE
		 */
		public String getCOMPOSITE() {
			return COMPOSITE;
		}
		/**
		 * @param composite the cOMPOSITE to set
		 */
		public void setCOMPOSITE(String composite) {
			COMPOSITE = composite;
		}
		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		/**
		 * @param description the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String description) {
			DESCRIPTION = description;
		}
		/**
		 * @return the gRAPHICS
		 */
		public java.util.Map getGRAPHICS() {
			return GRAPHICS;
		}
		/**
		 * @param graphics the gRAPHICS to set
		 */
		public void setGRAPHICS(java.util.Map graphics) {
			GRAPHICS = graphics;
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
		 * @return the mONITOR
		 */
		public String getMONITOR() {
			return MONITOR;
		}
		/**
		 * @param monitor the mONITOR to set
		 */
		public void setMONITOR(String monitor) {
			MONITOR = monitor;
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
		 * @return the pLATFORM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}
		/**
		 * @param platform_ the pLATFORM_ to set
		 */
		public void setPLATFORM_(String platform_) {
			PLATFORM_ = platform_;
		}
		/**
		 * @return the pLOSFLG
		 */
		public String getPLOSFLG() {
			return PLOSFLG;
		}
		/**
		 * @param plosflg the pLOSFLG to set
		 */
		public void setPLOSFLG(String plosflg) {
			PLOSFLG = plosflg;
		}
		/**
		 * @return the pRIORITY
		 */
		public String getPRIORITY() {
			return PRIORITY;
		}
		/**
		 * @param priority the pRIORITY to set
		 */
		public void setPRIORITY(String priority) {
			PRIORITY = priority;
		}
		/**
		 * @return the pS_SERVICE
		 */
		public String getPS_SERVICE() {
			return PS_SERVICE;
		}
		/**
		 * @param ps_service the pS_SERVICE to set
		 */
		public void setPS_SERVICE(String ps_service) {
			PS_SERVICE = ps_service;
		}
		/**
		 * @return the pS_TYPE
		 */
		public String getPS_TYPE() {
			return PS_TYPE;
		}
		/**
		 * @param ps_type the pS_TYPE to set
		 */
		public void setPS_TYPE(String ps_type) {
			PS_TYPE = ps_type;
		}
		/**
		 * @return the rEDO_TIMES
		 */
		public long getREDO_TIMES() {
			return REDO_TIMES;
		}
		/**
		 * @param redo_times the rEDO_TIMES to set
		 */
		public void setREDO_TIMES(long redo_times) {
			REDO_TIMES = redo_times;
		}
		/**
		 * @return the rEQUEST
		 */
		public String getREQUEST() {
			return REQUEST;
		}
		/**
		 * @param request the rEQUEST to set
		 */
		public void setREQUEST(String request) {
			REQUEST = request;
		}
		/**
		 * @return the rESPONSE
		 */
		public String getRESPONSE() {
			return RESPONSE;
		}
		/**
		 * @param response the rESPONSE to set
		 */
		public void setRESPONSE(String response) {
			RESPONSE = response;
		}
		/**
		 * @return the rSLTFLG
		 */
		public String getRSLTFLG() {
			return RSLTFLG;
		}
		/**
		 * @param rsltflg the rSLTFLG to set
		 */
		public void setRSLTFLG(String rsltflg) {
			RSLTFLG = rsltflg;
		}
		/**
		 * @return the sYNCFLG
		 */
		public String getSYNCFLG() {
			return SYNCFLG;
		}
		/**
		 * @param syncflg the sYNCFLG to set
		 */
		public void setSYNCFLG(String syncflg) {
			SYNCFLG = syncflg;
		}
		/**
		 * 是否网元异常转监控策略
		 * @return
		 */
		public boolean isMONITOR(){
			return StringUtils.equals( MONITOR , IUpdcConst.IEnum.IYesNo.Yes );
		}
		/**
		 * 是否网元异常转历史策略
		 * @return
		 */
		public boolean isHISTORY(){
			return StringUtils.isBlank(MONITOR)
					|| StringUtils.equals(MONITOR, IUpdcConst.IEnum.IYesNo.Yes) == false;
		}
		/**
         * 是否为同步指令
         * @return
         */
        public boolean isSYNCFLG(){
             return StringUtils.equals( SYNCFLG , IUpdcConst.IEnum.IYesNo.Yes );
        }
		/**
		 * 判断是否网元反馈
		 * @return
		 */
		public boolean isREPLY(){
			return StringUtils.equals( RSLTFLG , IUpdcConst.IEnum.IYesNo.Yes );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元主指令</p>
	 * <p>Copyright: Copyright (c) 2011-10-12</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmDirective implements java.io.Serializable{
		private static final long serialVersionUID = -5652039573780683961L;
		private String ID           ;                                                                                                                                                                                                                                                                                                                                                                                         
		private String NAME         ;                                                                                                                                                                                                                                                                                                                                                                                         
		private String PLATFORM_    ;                                                                                                                                                                                                                                                                                                                                                                                         
		private String DESCRIPTION  ;                                                                                                                                                                                                                                                                                                                                                                                         
		private String OPERATE_     ;                                                                                                                                                                                                                                                                                                                                                                                         
		private String CATEGORY     ;
		private String DIRECTIVE    ;                                                                                                                                                                                                                                                                                                                                                                                         
		private String SUBFLOW      ;
		private String COMPLEX      ;                                                                                                                                                                                                                                                                                                                                                                                         
		private String CONTROL      ;
		private String IMPLCLASS    ;                                                                                                                                                                                                                                                                                                                                                                                         
		private java.util.List WRKFLW = new java.util.ArrayList();//子指令集列表
		private java.util.Map GRAPHICS = new java.util.HashMap();
		public IUpffmDirective(){
			super();
		}
		public IUpffmDirective( ISADirective aDirective ) throws Exception{
			super();
			ID            = aDirective.getId         ();                                                                                                                                                                                                                                                                                                                                                                                         
			NAME          = aDirective.getName       ();                                                                                                                                                                                                                                                                                                                                                                                         
			PLATFORM_     = aDirective.getPlatform   ();                                                                                                                                                                                                                                                                                                                                                                                         
			DESCRIPTION   = aDirective.getDescription();                                                                                                                                                                                                                                                                                                                                                                                         
			OPERATE_      = aDirective.getOperate    ();                                                                                                                                                                                                                                                                                                                                                                                         
			CATEGORY      = aDirective.getCategory   ();
			DIRECTIVE     = aDirective.getDirective  ();                                                                                                                                                                                                                                                                                                                                                                                         
			SUBFLOW       = aDirective.getSubflow    ();
			COMPLEX       = aDirective.getComplex    ();                                                                                                                                                                                                                                                                                                                                                                                         
			CONTROL       = aDirective.getControl    ();
			IMPLCLASS     = aDirective.getImplclass  ();                                                                                                                                                                                                                                                                                                                                                                                         
			if( StringUtils.isBlank( SUBFLOW ) == false ){
				String[] aSUBFLOW = FileUtils.IFile.readLine( SUBFLOW );
				for(int index = 0 ; aSUBFLOW != null && index < aSUBFLOW.length ; index++){
					if( StringUtils.isBlank( aSUBFLOW[index] ) ) continue;
					WRKFLW.add( aSUBFLOW[index] );
				}
			}
			JdomUtils._getISTKJdomL( CONTROL , GRAPHICS );
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
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		/**
		 * @param description the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String description) {
			DESCRIPTION = description;
		}
		/**
		 * @return the dIRECTIVE
		 */
		public String getDIRECTIVE() {
			return DIRECTIVE;
		}
		/**
		 * @param directive the dIRECTIVE to set
		 */
		public void setDIRECTIVE(String directive) {
			DIRECTIVE = directive;
		}
		/**
		 * @return the gRAPHICS
		 */
		public java.util.Map getGRAPHICS() {
			return GRAPHICS;
		}
		/**
		 * @param graphics the gRAPHICS to set
		 */
		public void setGRAPHICS(java.util.Map graphics) {
			GRAPHICS = graphics;
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
		 * @return the iMPLCLASS
		 */
		public String getIMPLCLASS() {
			return IMPLCLASS;
		}
		/**
		 * @param implclass the iMPLCLASS to set
		 */
		public void setIMPLCLASS(String implclass) {
			IMPLCLASS = implclass;
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
		 * @return the oPERATE_
		 */
		public String getOPERATE_() {
			return OPERATE_;
		}
		/**
		 * @param operate_ the oPERATE_ to set
		 */
		public void setOPERATE_(String operate_) {
			OPERATE_ = operate_;
		}
		/**
		 * @return the pLATFORM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}
		/**
		 * @param platform_ the pLATFORM_ to set
		 */
		public void setPLATFORM_(String platform_) {
			PLATFORM_ = platform_;
		}
		/**
		 * @return the sUBFLOW
		 */
		public String getSUBFLOW() {
			return SUBFLOW;
		}
		/**
		 * @param subflow the sUBFLOW to set
		 */
		public void setSUBFLOW(String subflow) {
			SUBFLOW = subflow;
		}
		/**
		 * @return the wRKFLW
		 */
		public java.util.List getWRKFLW() {
			return WRKFLW;
		}
		/**
		 * @param wrkflw the wRKFLW to set
		 */
		public void setWRKFLW(java.util.List wrkflw) {
			WRKFLW = wrkflw;
		}
		/**
		 * 
		 * @return
		 */
		public String getINDEX(){
			return ClassUtils.getINDEX(  IUpdcConst.ICache.ICachePref.I_PLATFORM_DIRECTIVE, 
					new String[]{ PLATFORM_ , ID } );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元二级流程</p>
	 * <p>Copyright: Copyright (c) 2015年10月8日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffbpmOffer implements java.io.Serializable{
		private static final long serialVersionUID = 4537054052288136346L;
		private String ID    ;
		private String NAME  ;
		private java.util.List SUBFLOW = new java.util.ArrayList();
		public IUpffbpmOffer( String fromSUBFLOW, String fromNAME ){
			super();
			ID   = fromSUBFLOW;
			NAME = fromNAME;
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
		 * @return the sUBFLOW
		 */
		public java.util.List getSUBFLOW() {
			return SUBFLOW;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元二级指令</p>
	 * <p>Copyright: Copyright (c) 2011-10-12</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmSubFlow extends ISystemTemplate.IUpdbpmOffer implements java.io.Serializable{
		private static final long serialVersionUID = -4809618179146395924L;
		public IUpffmSubFlow(){
			super();
		}
		public IUpffmSubFlow( ISADirectiveS aDirectiveS ){
			super();
			ID            = String.valueOf(aDirectiveS.getId());                        
			NAME          = aDirectiveS.getName       ();                        
			SUBFLOW       = aDirectiveS.getSubflow    ();
			CATEGORY      = aDirectiveS.getCategory   ();
			PLATFORM      = aDirectiveS.getPlatform   ();                        
			DIRECTIVE     = aDirectiveS.getDirective  ();                        
			PROGRAM       = aDirectiveS.getProgram    (); 
			COMPLETE      = aDirectiveS.getComplete   ();
			JEVAL         = aDirectiveS.getJeval      ();
			IMPLCLASS     = null; 
			COMPLEX       = aDirectiveS.getComplex    ();                        
			CONTROL       = aDirectiveS.getControl    ();
			JdomUtils._getISTKJdomL( CONTROL , GRAPHICS );
		}
		/**
		 * 二级指令是否存在解决方案
		 * @return
		 */
		public boolean isPROGRAM(){
			return PROGRAM != null && StringUtils.isBlank( PROGRAM ) == false;
		}
		/**
		 * 是否采用二级流程网元
		 * @return
		 */
		public boolean isUpfdfm(){
			return StringUtils.equals( CATEGORY , IUpdcConst.IUpdbm.IUpdbf.NORMAL );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元模板</p>
	 * <p>Copyright: Copyright (c) 2013-5-3</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmProtocol implements java.io.Serializable{
		private static final long serialVersionUID = -7480207342191262090L;
		private String ID            ;
		private String NAME          ;
		private String PLATFORM_     ;
		private String DESCRIPTION   ;
		private String FILE_TYPE     ;
		private String PLMX_TYPE     ;
		private String FILES         ;
		private String PLMMX         ;
		private String PLMMX_01      ;
		private String PLMMX_02      ;
		private String PLMMX_03      ;
		private String PLMMX_04      ;
		private String PLMMX_05      ;
		private String PLMMX_06      ;
		private String PLMMX_07      ;
		private String PLMMX_08      ;
		private String PLMMX_09      ;
		private String PLMMX_10      ;
		private String PLMMX_11      ;
		private String PLMMX_12      ;
		private String PLMMX_13      ;
		private String PLMMX_14      ;
		private String PLMMX_15      ;
		public IUpffmProtocol(SAProtocol aTEMPLATE) throws Exception{
			super();
			ID            = aTEMPLATE.getId           ();
			NAME          = aTEMPLATE.getName         ();
			PLATFORM_     = aTEMPLATE.getPlatform     ();
			setDESCRIPTION(aTEMPLATE.getDescription  ());
			FILE_TYPE     = aTEMPLATE.getFileType     ();
			PLMX_TYPE     = aTEMPLATE.getPlmxType     ();
			FILES         = aTEMPLATE.getFiles        ();
			if( isFile() == true ) readFromFile( aTEMPLATE , this );
			else readFromChar( aTEMPLATE, this );
		}
		
		/**
		 * @return the fILE_TYPE
		 */
		public String getFILE_TYPE() {
			return FILE_TYPE;
		}

		/**
		 * @return the fILES
		 */
		public String getFILES() {
			return FILES;
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
		 * @return the pLATFORM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}

		/**
		 * @return the pLMMX
		 */
		public String getPLMMX() {
			return PLMMX;
		}

		/**
		 * @return the pLMMX_01
		 */
		public String getPLMMX_01() {
			return PLMMX_01;
		}

		/**
		 * @return the pLMMX_02
		 */
		public String getPLMMX_02() {
			return PLMMX_02;
		}

		/**
		 * @return the pLMMX_03
		 */
		public String getPLMMX_03() {
			return PLMMX_03;
		}

		/**
		 * @return the pLMMX_04
		 */
		public String getPLMMX_04() {
			return PLMMX_04;
		}

		/**
		 * @return the pLMMX_05
		 */
		public String getPLMMX_05() {
			return PLMMX_05;
		}

		/**
		 * @return the pLMMX_06
		 */
		public String getPLMMX_06() {
			return PLMMX_06;
		}

		/**
		 * @return the pLMMX_07
		 */
		public String getPLMMX_07() {
			return PLMMX_07;
		}

		/**
		 * @return the pLMMX_08
		 */
		public String getPLMMX_08() {
			return PLMMX_08;
		}

		/**
		 * @return the pLMMX_09
		 */
		public String getPLMMX_09() {
			return PLMMX_09;
		}

		/**
		 * @return the pLMMX_10
		 */
		public String getPLMMX_10() {
			return PLMMX_10;
		}

		/**
		 * @return the pLMMX_11
		 */
		public String getPLMMX_11() {
			return PLMMX_11;
		}

		/**
		 * @return the pLMMX_12
		 */
		public String getPLMMX_12() {
			return PLMMX_12;
		}

		/**
		 * @return the pLMMX_13
		 */
		public String getPLMMX_13() {
			return PLMMX_13;
		}

		/**
		 * @return the pLMMX_14
		 */
		public String getPLMMX_14() {
			return PLMMX_14;
		}

		/**
		 * @return the pLMMX_15
		 */
		public String getPLMMX_15() {
			return PLMMX_15;
		}

		/**
		 * @return the pLMX_TYPE
		 */
		public String getPLMX_TYPE() {
			return PLMX_TYPE;
		}

		/**
		 * 模板内容来源于文件模式
		 * @return
		 */
		public boolean isFile(){
			return StringUtils.equals( PLMX_TYPE, IUpdcConst.IUpfwm.IUpdpfm.IUpfmx.FILE ) && 
			        StringUtils.isBlank( FILES ) == false;
		}
		/**
		 * 判断模板是否为VM模板
		 * @return
		 */
		public boolean isVmfs( ){
			return StringUtils.equals( FILE_TYPE, IUpdcConst.IUpfwm.IUpdpfm.VM );
		}
		/**
		 * 判断模板是否为WM模板
		 * @return
		 */
		public boolean isWmfs(){
			return StringUtils.equals( FILE_TYPE, IUpdcConst.IUpfwm.IUpdpfm.WM );
		}
		/**
		 * 
		 * @param aTEMPLATE
		 * @param aUpdvmfsDefine
		 * @throws Exception
		 */
		private void readFromFile( SAProtocol aTEMPLATE , IUpffmProtocol aUpdvmfsDefine ) throws Exception{
			java.io.InputStream aInputStream = ClassUtils.IClass.getClassLoaderResource( aTEMPLATE.getFiles() );
			try
			{
				if( aInputStream == null ) ExceptionFactory.throwRuntime("IOS0010016", new String[]{aTEMPLATE.getFiles()} );
				byte aByte[] = FileUtils.IFile.readFile( aInputStream );
				aUpdvmfsDefine.PLMMX = new String( aByte , 0 , aByte.length );
				String[] lstPLMMX = SystemUtils.ICustom.substringAsL( aUpdvmfsDefine.PLMMX );
				for( int index = 0 ; lstPLMMX != null && index < lstPLMMX.length; index++ ){
					String aPropertyName = ClassUtils.getINDEX( new String[]{"PLMMX_",(index < 9 ?"0":""),String.valueOf( index+ 1 ) } );
					if( aTEMPLATE.hasPropertyName( aPropertyName ) == false ) continue;
					aTEMPLATE.set( aPropertyName, lstPLMMX[index] );
				}
				_wrap( aTEMPLATE, aUpdvmfsDefine );
				aTEMPLATE.setStsToOld();
			}
			finally{
				if( aInputStream != null ){ aInputStream.close(); aInputStream = null;}
			}
		}
		/**
		 * 
		 * @param aTEMPLATE
		 * @param aUpdvmfsDefine
		 * @throws Exception
		 */
		private void readFromChar( SAProtocol aTEMPLATE , IUpffmProtocol aUpdvmfsDefine ) throws Exception{
			try
			{
				_wrap( aTEMPLATE, aUpdvmfsDefine );
				StringBuilder aUpfvmsLife = new StringBuilder();
				for( int index = 0 ; index < aTEMPLATE.getPropertyNames().length; index++ ){
					String aPropertyName = ClassUtils.getINDEX( new String[]{"PLMMX_",(index < 9 ?"0":""),String.valueOf( index+ 1 ) } );
					if( aTEMPLATE.hasPropertyName( aPropertyName ) == false ) continue;
					if( StringUtils.isBlank( aTEMPLATE.getAsString( aPropertyName ) ) ) continue;
					aUpfvmsLife.append( aTEMPLATE.getAsString( aPropertyName ) );
				}
				PLMMX = aUpfvmsLife.toString();
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param aTEMPLATE
		 * @param aUpdvmfsDefine
		 * @throws Exception
		 */
		private void _wrap( SAProtocol aTEMPLATE , IUpffmProtocol aUpdvmfsDefine ) throws Exception{
			try
			{
				aUpdvmfsDefine.PLMMX_01      = aTEMPLATE.getPlmmx01      ();
				aUpdvmfsDefine.PLMMX_02      = aTEMPLATE.getPlmmx02      ();
				aUpdvmfsDefine.PLMMX_03      = aTEMPLATE.getPlmmx03      ();
				aUpdvmfsDefine.PLMMX_04      = aTEMPLATE.getPlmmx04      ();
				aUpdvmfsDefine.PLMMX_05      = aTEMPLATE.getPlmmx05      ();
				aUpdvmfsDefine.PLMMX_06      = aTEMPLATE.getPlmmx06      ();
				aUpdvmfsDefine.PLMMX_07      = aTEMPLATE.getPlmmx07      ();
				aUpdvmfsDefine.PLMMX_08      = aTEMPLATE.getPlmmx08      ();
				aUpdvmfsDefine.PLMMX_09      = aTEMPLATE.getPlmmx09      ();
				aUpdvmfsDefine.PLMMX_10      = aTEMPLATE.getPlmmx10      ();
				aUpdvmfsDefine.PLMMX_11      = aTEMPLATE.getPlmmx11      ();
				aUpdvmfsDefine.PLMMX_12      = aTEMPLATE.getPlmmx12      ();
				aUpdvmfsDefine.PLMMX_13      = aTEMPLATE.getPlmmx13      ();
				aUpdvmfsDefine.PLMMX_14      = aTEMPLATE.getPlmmx14      ();
				aUpdvmfsDefine.PLMMX_15      = aTEMPLATE.getPlmmx15      ();
			}
			finally{
				
			}
		}

		public String getDESCRIPTION() {
			return DESCRIPTION;
		}

		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
	}
	
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网路名单</p>
	 * <p>Copyright: Copyright (c) 2013-4-26</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmPhone implements java.io.Serializable{
		private static final long serialVersionUID = -5808043580936346512L;
		private String ID           ;            
		private String DESCRIPTION  ;            
		private String PLATFORM     ;            
		private String CATEGORY     ;
		private String COMPLEX      ;            
		private String CONTROL      ;            
		public IUpffmPhone(ISAPhone aPhone){
			super();
			ID            = aPhone.getMsisdn      () ;            
			DESCRIPTION   = aPhone.getDescription () ;            
			PLATFORM      = aPhone.getPlatform    () ;            
			CATEGORY      = aPhone.getCategory    () ;
			COMPLEX       = aPhone.getComplex     () ;            
			CONTROL       = aPhone.getControl     () ;            
		}
		
		public IUpffmPhone(String aMSISDN, String aPLATFORM, String aCATEGORY) {
			super();
			ID       = aMSISDN;
			PLATFORM = aPLATFORM;
			CATEGORY = aCATEGORY;
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
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}

		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}

		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}

		/**
		 * @param description the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String description) {
			DESCRIPTION = description;
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
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}

		/**
		 * @param platform the pLATFORM to set
		 */
		public void setPLATFORM(String platform) {
			PLATFORM = platform;
		}

		/**
		 * 名单控制为白名单控制
		 * @return
		 */
		public boolean isWHITELST(){
			return StringUtils.equals( CATEGORY, 
					IUpdcConst.IUpfwm.IUpfms.WHITELST );
		}
		/**
		 * 名单控制为黑名单控制
		 * @return
		 */
		public boolean isBLACKLST(){
			return StringUtils.equals( CATEGORY, 
					IUpdcConst.IUpfwm.IUpfms.BLACKLST );
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 开通反馈组</p>
	 * <p>Copyright: Copyright (c) 2017年5月26日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmsGroup implements java.io.Serializable{
		private static final long serialVersionUID = 2954434090240769418L;
		private String        _platform;
		private java.util.Map _respond = new java.util.HashMap();
		private java.util.Map _catalog = new java.util.HashMap();
		public IUpffmsGroup( String _platform_ ){
			super();
			_platform = _platform_;
		}
		
		public IUpffmsGroup( ISARespond aRespond ){
			super();
			_platform = aRespond.getPlatform();
		}
		
		public IUpffmsGroup( ISARespondRel aCatalog ){
			super();
			_platform = aCatalog.getPlatform();
		}
		
		/**
		 * 网元编码
		 * @return 
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
		 * @return 网元代码规范
		 */
		public java.util.Map getRESPOND() {
			return _respond;
		}
		
		/**
		 * 
		 * @param aRespond
		 */
		public void mergeAsGroup( ISARespond aRespond ){
			StringBuilder fromINDEX = new StringBuilder();
			try
			{
				IUpffmsOffer fromOffer = new IUpffmsOffer( aRespond );
				fromINDEX.append( fromOffer.getCATEGORY() ).append("_$_")
				         .append( fromOffer.getID() );
				_respond.put( fromINDEX.toString(), fromOffer );
			}
			finally{
				if( fromINDEX != null ){ fromINDEX = null; }
			}
		}
		
		/**
		 * 根据反馈代码和反馈类型获取反馈代码规范
		 * @param _id 反馈代码
		 * @param _category 反馈类型
		 * @return
		 */
		public IUpffmsOffer getRESPOND( String _id, String _category ){
			IUpffmsOffer fromOffer = null;
			try
			{
				String fromNAME[][] = new String[][]{{_category, _id }, {"*"      , _id }, {_category, "*" }, 
					{"*"      , "*" }};
                for( int index = 0; index < fromNAME.length; index++ ){
                	String fromINDEX = ClassUtils.getINDEX( new String[]{ fromNAME[index][0], "_$_",
                			fromNAME[index][1] } );
                	fromOffer = (IUpffmsOffer)_respond.get( fromINDEX );
                	if( fromOffer != null ){ break; }
                }
			}
			finally{
				
			}
			return fromOffer;
		}
		
		/**
		 * @return 网元代码转换器
		 */
		public java.util.Map getCATALOG() {
			return _catalog;
		}
		
		/**
		 * 
		 * @param aRespond
		 */
		public void mergeAsGroup( ISARespondRel aRespond ){
			StringBuilder fromINDEX = new StringBuilder();
			try
			{
				IUpffmsCatalog fromCatalog = new IUpffmsCatalog( aRespond );
				fromINDEX.append( fromCatalog.getCATEGORY() ).append("_$_")
		                 .append( fromCatalog.getID() );
				_catalog.put( fromINDEX.toString(), fromCatalog );
			}
			finally{
				if( fromINDEX != null ){ fromINDEX = null; }
			}
		}
		
		/**
		 * 根据反馈代码和反馈类型获取网元代码转换器
		 * @param _id 反馈代码
		 * @param _category 反馈类型
		 * @return
		 */
		public IUpffmsCatalog getCATALOG( String _id, String _category ){
			IUpffmsCatalog fromCatalog = null;
			try
			{
				String fromNAME[][] = new String[][]{{_category, _id != null?_id:"NULL" }, 
					{"*"      , _id != null?_id:"NULL" }, {_category, "*" }, {"*"      , "*" }};
                for( int index = 0; index < fromNAME.length; index++ ){
                	String fromINDEX = ClassUtils.getINDEX( new String[]{ fromNAME[index][0], "_$_",
                			fromNAME[index][1] } );
                	fromCatalog = (IUpffmsCatalog)_catalog.get( fromINDEX );
                	if( fromCatalog != null ){ break; }
                }
			}
			finally{
				
			}
			return fromCatalog;
		}
		
		/**
		 * 是否开通规范组
		 * @return
		 */
		public boolean isSUBFLOW(){
			return StringUtils.equals( _platform, IUpdcConst.IUpfwm.IUpfm.ucmframe );
		}
		
		/**
		 * 是否外部规范组
		 * @return
		 */
		public boolean isEXTEND(){
			return StringUtils.equals( _platform, IUpdcConst.IUpfwm.IUpfm.ucmframe ) == false;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 开通反馈规范</p>
	 * <p>Copyright: Copyright (c) 2014-3-27</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffmsOffer implements java.io.Serializable{
		private static final long serialVersionUID = 3611971461302744464L;
		private String ID            ;      
		private String NAME          ;      
		private String CATEGORY      ;      
		private String PLATFORM      ;      
		private int    SUCCEED       ;
		private String BUSINESS      ;
		private String NETWORK       ;
		private String COMPLEX       ;      
		private long   RETRY_TIMES   ;
		private long   RETRY_INTERVAL;
		private String CONTROL       ;      
		private java.sql.Timestamp EFFECTIVE    ;      
		private java.sql.Timestamp EXPIRE       ;     
		private java.util.Map GRAPHICS = new java.util.HashMap();
		public IUpffmsOffer(ISARespond aRespond){
			super();
			IControlDefine _control_ = IConfigDefine.getINSTANCE().getControl();
			ID             = aRespond.getCode        ();      
			NAME           = aRespond.getName        ();      
			CATEGORY       = aRespond.getCategory    ();      
			PLATFORM       = aRespond.getPlatform    ();      
			SUCCEED        = aRespond.getSucceed     ();
			BUSINESS       = aRespond.getBusiness    ();
			NETWORK        = aRespond.getNetwork     ();
			COMPLEX        = aRespond.getComplex     (); 
			RETRY_TIMES    = _control_.getREDO_TIMES ();
			RETRY_INTERVAL = _control_.getINTERVAL   ();
			CONTROL        = aRespond.getControl     ();      
			EFFECTIVE      = aRespond.getEffective   ();      
			EXPIRE         = aRespond.getExpire      ();  
			JdomUtils.ICustom.wrap( COMPLEX, GRAPHICS );
			if( GRAPHICS.get( "RETRY_TIMES") != null ){
				RETRY_TIMES = Long.parseLong( GRAPHICS.get( "RETRY_TIMES" ).toString() );
			}
			if( GRAPHICS.get( "RETRY_INTERVAL") != null ){
				RETRY_INTERVAL = Long.parseLong( GRAPHICS.get( "RETRY_INTERVAL" ).toString() );
			}
		}
		
		public IUpffmsOffer(IPlatformTemplate.IUpffmOffer fromUpfm, SFException aEXCEPTION ){
			super();
			IControlDefine _control_ = IConfigDefine.getINSTANCE().getControl();
			ID             = aEXCEPTION.getFaultCode      ();
			NAME           = aEXCEPTION.getMessage        ();
			CATEGORY       = IUpdcConst.IEnum.ISschk.UnKnown;
			PLATFORM       = fromUpfm.getID               ();
			SUCCEED        = 0                              ;
			RETRY_TIMES    = _control_.getREDO_TIMES      ();
			RETRY_INTERVAL =_control_.getINTERVAL         ();
		}
		
		public IUpffmsOffer( SFException aEXCEPTION ){
			super();
			IControlDefine _control_ = IConfigDefine.getINSTANCE().getControl();
			ID             = aEXCEPTION.getFaultCode      ();
			NAME           = aEXCEPTION.getMessage        ();
			CATEGORY       = IUpdcConst.IEnum.ISschk.UnKnown;
			PLATFORM       = aEXCEPTION.getOriginator     ();
			SUCCEED        = 0                              ;
			RETRY_TIMES    = _control_.getREDO_TIMES      ();
			RETRY_INTERVAL =_control_.getINTERVAL         ();
		}
		
		public IUpffmsOffer( String _code, String _name ){
			super();
			IControlDefine _control_ = IConfigDefine.getINSTANCE().getControl();
			ID             = _code                           ;
			NAME           = _name                           ;
			CATEGORY       = IUpdcConst.IEnum.ISschk.UnKnown ;
			PLATFORM       = IUpdcConst.IUpfwm.IUpfm.ucmframe;
			SUCCEED        = 0                               ;
			RETRY_TIMES    = _control_.getREDO_TIMES       ();
			RETRY_INTERVAL =_control_.getINTERVAL          ();
		}
		
		public IUpffmsOffer( String _code, String _name, String _platform ){
			super();
			IControlDefine _control_ = IConfigDefine.getINSTANCE().getControl();
			ID             = _code                           ;
			NAME           = _name                           ;
			CATEGORY       = IUpdcConst.IEnum.ISschk.UnKnown ;
			PLATFORM       = _platform                       ;
			SUCCEED        = 0                               ;
			RETRY_TIMES    = _control_.getREDO_TIMES       ();
			RETRY_INTERVAL =_control_.getINTERVAL          ();
		}
		
		/**
		 * @return the bUSINESS
		 */
		public String getBUSINESS() {
			return BUSINESS;
		}
		
		/**
		 * @param business the bUSINESS to set
		 */
		public void setBUSINESS(String business) {
			BUSINESS = business;
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
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		
		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}
		
		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		
		/**
		 * @param effective the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp effective) {
			EFFECTIVE = effective;
		}
		
		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		
		/**
		 * @param expire the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp expire) {
			EXPIRE = expire;
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
		 * @return the nETWORK
		 */
		public String getNETWORK() {
			return NETWORK;
		}
		
		/**
		 * @param network the nETWORK to set
		 */
		public void setNETWORK(String network) {
			NETWORK = network;
		}
		
		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}
		
		/**
		 * @param platform the pLATFORM to set
		 */
		public void setPLATFORM(String platform_) {
			PLATFORM = platform_;
		}
		
		/**
		 * @return the sUCCEED
		 */
		public int getSUCCEED() {
			return SUCCEED;
		}
		
		/**
		 * @param succeed the sUCCEED to set
		 */
		public void setSUCCEED(int succeed) {
			SUCCEED = succeed;
		}
		
		/**
		 * @return the rETRY_TIMES
		 */
		public long getRETRY_TIMES() {
			return RETRY_TIMES;
		}

		/**
		 * @param rETRY_TIMES the rETRY_TIMES to set
		 */
		public void setRETRY_TIMES(long rETRY_TIMES) {
			RETRY_TIMES = rETRY_TIMES;
		}

		/**
		 * @return the rETRY_INTERVAL
		 */
		public long getRETRY_INTERVAL() {
			return RETRY_INTERVAL;
		}

		/**
		 * @param rETRY_INTERVAL the rETRY_INTERVAL to set
		 */
		public void setRETRY_INTERVAL(long rETRY_INTERVAL) {
			RETRY_INTERVAL = rETRY_INTERVAL;
		}
		
		/**
		 * @return the gRAPHICS
		 */
		public java.util.Map getGRAPHICS() {
			return GRAPHICS;
		}
		
		/**
		 * 是否反馈代码为统配
		 * @return
		 */
		public boolean isUNKNOWN(){
			return StringUtils.equals( ID, IUpdcConst.IEnum.ISschk.UnKnown );
		}
		
		/**
		 * 是否为成功反馈
		 * @return
		 */
		public boolean isSUCCEED(){
			return SUCCEED == 1;
		}
		
		/**
		 * 是否失败反馈
		 * @return
		 */
		public boolean isFAILURE(){
			return SUCCEED == 0;
		}
		
		/**
		 * 是否开通规范组
		 * @return
		 */
		public boolean isSUBFLOW(){
			return StringUtils.equals( PLATFORM, IUpdcConst.IUpfwm.IUpfm.ucmframe );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 开通反馈转换规范</p>
	 * <p>Copyright: Copyright (c) 2014-3-27</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffmsCatalog implements java.io.Serializable{
		private static final long serialVersionUID = -4810067338442717182L;
		private String ID           ;   
		private String NAME         ;   
		private String CATEGORY     ;   
		private String PLATFORM     ;   
		private String COMPOSITE    ;
		private String NETWORK      ;
		private String COMPLEX      ;   
		private String CONTROL      ;   
		private java.sql.Timestamp EFFECTIVE    ;   
		private java.sql.Timestamp EXPIRE       ;   
		public IUpffmsCatalog(ISARespondRel aRespond){
			super();
			ID            = aRespond.getCode       ();   
			NAME          = aRespond.getName       ();   
			CATEGORY      = aRespond.getCategory   ();   
			PLATFORM      = aRespond.getPlatform   ();   
			COMPOSITE     = aRespond.getComposite  ();   
			NETWORK       = aRespond.getNetwork    ();
			COMPLEX       = aRespond.getComplex    ();   
			CONTROL       = aRespond.getControl    ();   
			EFFECTIVE     = aRespond.getEffective  ();   
			EXPIRE        = aRespond.getExpire     ();   
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
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}

		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}

		/**
		 * @return the eFFECTIVE
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}

		/**
		 * @param effective the eFFECTIVE to set
		 */
		public void setEFFECTIVE(java.sql.Timestamp effective) {
			EFFECTIVE = effective;
		}

		/**
		 * @return the eXPIRE
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}

		/**
		 * @param expire the eXPIRE to set
		 */
		public void setEXPIRE(java.sql.Timestamp expire) {
			EXPIRE = expire;
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
		 * @return the nETWORK
		 */
		public String getNETWORK() {
			return NETWORK;
		}

		/**
		 * @param network the nETWORK to set
		 */
		public void setNETWORK_(String network_) {
			NETWORK = network_;
		}

		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}

		/**
		 * @param platform the pLATFORM to set
		 */
		public void setPLATFORM(String platform) {
			PLATFORM = platform;
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
	}
}
