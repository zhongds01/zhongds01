package com.ai.sacenter.valuebean;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.base.competence.bo.ISACompensation;
import com.ai.sacenter.base.competence.bo.ISAComponent;
import com.ai.sacenter.base.competence.bo.ISAComponentRel;
import com.ai.sacenter.base.competence.bo.ISADistribute;
import com.ai.sacenter.base.competence.bo.ISAException;
import com.ai.sacenter.base.competence.bo.ISAMappingX;
import com.ai.sacenter.base.competence.bo.ISAProgram;
import com.ai.sacenter.base.competence.bo.ISAProgramRel;
import com.ai.sacenter.base.competence.bo.ISARollBack;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 解决方案模板</p>
 * <p>Copyright: Copyright (c) 2014-3-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IProgramTemplate implements java.io.Serializable{
	private static final long serialVersionUID = -5504677663554563299L;
	public IProgramTemplate() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务组件属性</p>
	 * <p>Copyright: Copyright (c) 2012-3-30</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdffgsmOffer extends ISystemTemplate.IUpfgsmxOffer implements java.io.Serializable{
		private static final long serialVersionUID = 9005087094781486430L;
		protected String CODE         ;
		protected String COMPONENT    ;    
		public IUpdffgsmOffer(){
			super();
		}
		public IUpdffgsmOffer(ISAMappingX aMAPPING){
			super();
			ID            = String.valueOf(aMAPPING.getId());  
			CODE          = aMAPPING.getCode       ();
			NAME          = aMAPPING.getName       ();    
			COMPONENT     = aMAPPING.getComponent  ();    
			CATEGORY      = aMAPPING.getPlatform   ();  
			SORT_BY       = aMAPPING.getSortBy     ();
			COMPETE       = aMAPPING.getCompete    ();    
			MAPPING       = aMAPPING.getMapping    ();    
			IMPLCLASS     = aMAPPING.getImplclass  ();    
			COMPLEX       = aMAPPING.getComplex    ();    
			CONTROL       = aMAPPING.getControl    ();
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
		 * @return the cOMPONENT
		 */
		public String getCOMPONENT() {
			return COMPONENT;
		}
		/**
		 * @param component the cOMPONENT to set
		 */
		public void setCOMPONENT(String component) {
			COMPONENT = component;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 框架解决方案</p>
	 * <p>Copyright: Copyright (c) 2014-3-27</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdpgmOffer implements java.io.Serializable{
		private static final long serialVersionUID = 1990075684482656572L;
		private String ID       ;                         
		private String NAME     ;                         
		private String CATEGORY ;
		private String GRAPHICS ;                         
		private String CONTROL  ;
		private java.util.Map  PROGRAM = new java.util.HashMap();
		public IUpdpgmOffer(ISAProgram aProgram){
			super();
			ID       = aProgram.getId      ();
			NAME     = aProgram.getName    ();
			CATEGORY = aProgram.getCategory();
			GRAPHICS = aProgram.getComplex ();
			CONTROL  = aProgram.getControl ();
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
		 * @return the gRAPHICS
		 */
		public String getGRAPHICS() {
			return GRAPHICS;
		}

		/**
		 * @param graphics the gRAPHICS to set
		 */
		public void setGRAPHICS(String graphics) {
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
		 * @return 解决方案组件
		 */
		public java.util.Map getPROGRAM() {
			return PROGRAM;
		}
		/**
		 * 解决方案补偿组件
		 * @return
		 */
		public IUpdpgmCatalog getCOMPENSA(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_COMPENSA );
		}
		/**
		 * 解决方案一级映射组件
		 * @return
		 */
		public IUpdpgmCatalog getMAPPING(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_MAPPING );
		}
		/**
		 * 解决方案二级映射组件
		 * @return
		 */
		public IUpdpgmCatalog getCOMPOSITE(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_COMPOSITE );
		}
		/**
		 * 解决方案派单组件
		 * @return
		 */
		public IUpdpgmCatalog getDISTRIBUTE(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_DISTRIBUTE );
		}
		/**
		 * 解决方案异常回单类组件
		 * @return
		 */
		public IUpdpgmCatalog getSUBFLOW(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_SUBFLOW );
		}
		/**
		 * 解决方案网元工单级异常类组件
		 * @return
		 */
		public IUpdpgmCatalog getPLATFORM(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_PLATFORM );
		}
		/**
		 * 解决方案服务工单级异常回滚类组件
		 * @return
		 */
		public IUpdpgmCatalog getROLLBACK(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_ROLLBACK );
		}
		/**
		 * 解决方案回单原因类组件
		 * @return
		 */
		public IUpdpgmCatalog getEXCEPTION(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_EXCEPTION );
		}
		/**
		 * 解决方案变量组件
		 * @return
		 */
		public IUpdpgmCatalog getCOMPLEX(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_COMPLEX );
		}
		/**
		 * 解决方案服务归档类组件
		 * @return
		 */
		public IUpdpgmCatalog getCOMPLETE(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_COMPLETE );
		}
		/**
		 * 解决方案队列类组件
		 * @return
		 */
		public IUpdpgmCatalog getQUEUE(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_QUEUE );
		}
		/**
		 * 解决方案定单项类组件
		 * @return
		 */
		public IUpdpgmCatalog getROCKET(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_ROCKET );
		}
		/**
		 * 解决方案通知类组件
		 * @return
		 */
		public IUpdpgmCatalog getSUGGEST(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_SUGGEST );
		}
		/**
		 * 解决方案到期类组件
		 * @return
		 */
		public IUpdpgmCatalog getEXPIRE(){
			return (IUpdpgmCatalog)PROGRAM.get( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_EXPIRE );
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: 解决方案关联</p>
		 * <p>Copyright: Copyright (c) 2014-3-27</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 3.0
		 */
		public static class IUpdpgmCatalog implements java.io.Serializable{
			private static final long serialVersionUID = 8673176702418716129L;
			private long   ID           ;                                                                                                                                                                             
			private String NAME         ;  
			private String PROGRAM      ;
			private String CATEGORY     ;
			private String COMPONENT    ;
			private String COMPLEX      ;                                                                                                                                                                             
			private String CONTROL      ;
			private IUpdfcmpOffer MODULE = null;
			public IUpdpgmCatalog(ISAProgramRel aPROGRAM, IUpdfcmpOffer aCOMPONENT){
				super();
				ID            = aPROGRAM.getId         ();                                                                                                                                                                             
				NAME          = aPROGRAM.getName       ();  
				PROGRAM       = aPROGRAM.getProgram    ();
				CATEGORY      = aPROGRAM.getCategory   ();
				COMPONENT     = aPROGRAM.getComponent  ();
				MODULE        = aCOMPONENT               ;
				COMPLEX       = aPROGRAM.getComplex    ();                                                                                                                                                                             
				CONTROL       = aPROGRAM.getControl    ();
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
			 * @return the cOMPONENT
			 */
			public String getCOMPONENT() {
				return COMPONENT;
			}
			/**
			 * @param component the cOMPONENT to set
			 */
			public void setCOMPONENT(String component) {
				COMPONENT = component;
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
			 * @return the mODULE
			 */
			public IUpdfcmpOffer getMODULE() {
				return MODULE;
			}
			/**
			 * @param module the mODULE to set
			 */
			public void setMODULE(IUpdfcmpOffer module) {
				MODULE = module;
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
			 * @return the pROGRAM
			 */
			public String getPROGRAM() {
				return PROGRAM;
			}
			/**
			 * @param program the pROGRAM to set
			 */
			public void setPROGRAM(String program) {
				PROGRAM = program;
			}
			
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 框架解决方案组件</p>
	 * <p>Copyright: Copyright (c) 2014-3-27</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdfcmpOffer implements java.io.Serializable{
		private static final long serialVersionUID = -6534062468796134245L;
		protected String ID       ;                                                                                                                             
		protected String NAME     ;                                                                                                                             
		protected String CATEGORY ;
		protected String DESCRIBE ;
		protected String IMPLCLASS;
		protected String COMPLEX  ;                                                                                                                             
		protected String CONTROL  ;
		/*二级组件流程*/
		protected java.util.List CATALOG = new java.util.ArrayList();
		/*异常回滚流程*/
		protected java.util.Map  WORKFLOW = new java.util.HashMap();
		public IUpdfcmpOffer( ISAComponent aComponent ){
			super();
			ID        = aComponent.getId         ();                                                                                                                             
			NAME      = aComponent.getName       ();                                                                                                                             
			CATEGORY  = aComponent.getCategory   ();
			DESCRIBE  = aComponent.getDescription();
			IMPLCLASS = aComponent.getImplclass  ();
			COMPLEX   = aComponent.getComplex    ();                                                                                                                             
			CONTROL   = aComponent.getControl    ();       
		}
		
		/**
		 * @return 组件类型
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}
		
		/**
		 * @param category 组件类型
		 */
		public void setCATEGORY(String category) {
			CATEGORY = category;
		}
		
		/**
		 * @return 组件属性
		 */
		public String getCOMPLEX() {
			return COMPLEX;
		}
		
		/**
		 * @param complex 组件属性
		 */
		public void setCOMPLEX(String complex) {
			COMPLEX = complex;
		}
		
		/**
		 * @return 组件变量
		 */
		public String getCONTROL() {
			return CONTROL;
		}
		
		/**
		 * @param control 组件变量
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}
		
		/**
		 * @return 组件描述
		 */
		public String getDESCRIBE() {
			return DESCRIBE;
		}
		
		/**
		 * @param describe 组件描述
		 */
		public void setDESCRIBE(String describe) {
			DESCRIBE = describe;
		}
		
		/**
		 * @return 组件编码
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * @param id 组件编码
		 */
		public void setID(String id) {
			ID = id;
		}
		
		/**
		 * @return 组件名称
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param name 组件名称
		 */
		public void setNAME(String name) {
			NAME = name;
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
		 * @return 二级组件目录
		 */
		public java.util.List getCATALOG() {
			return CATALOG;
		}
		
		/**
		 * 
		 * @param fromUpdcmpt
		 */
		public void subscribe( DataStructInterface fromUpdcmpt ){
			
		}
		
		/**
		 * 
		 * @param fromUpdcmpt
		 */
		public void submitWorkFlow( ISARollBack fromUpdcmpt ){
		   	try
		   	{
		   		IUpdfbpmOffer.IUpdfcmpRollBack fromUpdbm = new IUpdfbpmOffer.IUpdfcmpRollBack( fromUpdcmpt );
		   		if( WORKFLOW.get( fromUpdbm.getCATALOG() ) == null ){
		   			WORKFLOW.put( fromUpdbm.getCATALOG(), new java.util.ArrayList() );
				}
				((java.util.List)WORKFLOW.get( fromUpdbm.getCATALOG() ) ).add( fromUpdbm );
		   	}
		   	finally{
		   		
		   	}
		}
		
		/**
		 * @return 异常回滚规范
		 */
		public java.util.Map getWORKFLOW() {
			return WORKFLOW;
		}
		
		/**
		 * @return 网元定单级回滚规范
		 */
		public java.util.List getPLATFORM() {
			java.util.List fromUpdbm = null;
			try
			{
				fromUpdbm = (java.util.List)WORKFLOW.get( IUpdcConst.IUpdbm.IUpdbf.PLATFORM );
				if( fromUpdbm == null ) fromUpdbm = new java.util.ArrayList();
			}
			finally{
				
			}
			return fromUpdbm;
		}
		
		/**
		 * @return 服务流程级回滚规范
		 */
		public java.util.List getSUBFLOW() {
			java.util.List fromUpdbm = null;
			try
			{
				fromUpdbm = (java.util.List)WORKFLOW.get( IUpdcConst.IUpdbm.IUpdbf.SUBFLOW );
				if( fromUpdbm == null ) fromUpdbm = new java.util.ArrayList();
			}
			finally{
				
			}
			return fromUpdbm;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			String fromXML = null;
			try
			{
				org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
				org.dom4j.Element fromRoot = document.addElement( "InterBOSS" );
				org.dom4j.Element fromRootInfo = fromRoot.addElement( "COMPONENT" );
				fromRootInfo.addElement("ID"       ).setText( ID       );
				fromRootInfo.addElement("NAME"     ).setText( NAME     );
				fromRootInfo.addElement("CATEGORY" ).setText( CATEGORY );
				org.dom4j.Element fromExtInfo = fromRootInfo.addElement( "FUTURE" );
				fromExtInfo.addElement("IMPLCLASS").setText( IMPLCLASS  );
				if( CATALOG != null && CATALOG.size() > 0 ){
					for( java.util.Iterator itera = CATALOG.iterator(); itera.hasNext(); ){
						IUpdfcmpCatalog fromCatalog = (IUpdfcmpCatalog)itera.next();
						org.dom4j.Element fromCatInfo = fromExtInfo.addElement( "FUTURE" );
						fromCatInfo.addElement("ID"       ).setText( String.valueOf( fromCatalog.ID )  );
						fromCatInfo.addElement("NAME"     ).setText( fromCatalog.NAME                  );
						fromCatInfo.addElement("COMPONENT").setText( fromCatalog.SUBFIGURE             );
						fromCatInfo.addElement("COMPLEX"  ).setText( fromCatalog.COMPLEX != null?
								fromCatalog.COMPLEX:""  );
					}
				}
				fromXML = XmlUtils.IXml._format( document.asXML() );
			}
			catch( java.lang.Exception exception ){
				fromXML = super.toString();
			}
			finally{
				
			}
			return fromXML;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活组件关联</p>
	 * <p>Copyright: Copyright (c) 2014-11-11</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdfcmpCatalog implements java.io.Serializable{
		private static final long serialVersionUID = -2190147199885389425L;
		private long   ID           ;
		private String NAME         ;
		private String COMPONENT    ;
		private String CATEGORY     ;
		private String SUBFIGURE    ;
		private String COMPLEX      ;
		public IUpdfcmpCatalog(ISAComponentRel aComponent){
			super();
			ID            = aComponent.getId          ();
			NAME          = aComponent.getName        ();
			COMPONENT     = aComponent.getComponent   ();
			CATEGORY      = aComponent.getCategory    ();
			SUBFIGURE     = aComponent.getSubfigure   ();
			COMPLEX       = aComponent.getComplex     ();
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
		 * @return the cOMPONENT
		 */
		public String getCOMPONENT() {
			return COMPONENT;
		}
		/**
		 * @param component the cOMPONENT to set
		 */
		public void setCOMPONENT(String component) {
			COMPONENT = component;
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
		 * @return the sUBFIGURE
		 */
		public String getSUBFIGURE() {
			return SUBFIGURE;
		}
		/**
		 * @param subfigure the sUBFIGURE to set
		 */
		public void setSUBFIGURE(String subfigure) {
			SUBFIGURE = subfigure;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活补偿组件</p>
	 * <p>Copyright: Copyright (c) 2014-3-28</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdfmptOffer extends IUpdfcmpOffer implements java.io.Serializable{
		private static final long serialVersionUID = -3316532109095120096L;
		private java.util.List COMPENSA = new java.util.ArrayList();
		public IUpdfmptOffer(ISAComponent aComponent ){
			super( aComponent );
		}
		/**
		 * @return the cOMPENSA
		 */
		public java.util.List getCOMPENSA() {
			return COMPENSA;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.valuebean.IProgramTemplate.IUpdfcmpOffer#subscribe(com.ai.appframe2.common.DataStructInterface)
		 */
		public void subscribe(DataStructInterface fromUpdcmpt) {
			try
			{
				ISACompensation aCompensation = (ISACompensation)fromUpdcmpt;
				IUpdfcmpCompensation fromCOMPENSA = new IUpdfcmpCompensation( aCompensation );
				COMPENSA.add( fromCOMPENSA );
			}
			finally{
				
			}
		}

		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: 服务激活补偿组件</p>
		 * <p>Copyright: Copyright (c) 2014-3-28</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 3.0
		 */
		public static class IUpdfcmpCompensation implements java.io.Serializable{
			private static final long serialVersionUID = 7401280996650210996L;
			private long   ID           ;               
			private String NAME         ;               
			private String CATEGORY     ;
			private String PLATFORM     ;
			private String COMPLEX      ;               
			public IUpdfcmpCompensation( ISACompensation aCompensation ){
				super();
				ID        = aCompensation.getId         ();               
				NAME      = aCompensation.getName       ();               
				CATEGORY  = aCompensation.getCategory   ();
				PLATFORM  = aCompensation.getPlatform   ();
				COMPLEX   = aCompensation.getComplex    ();               
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
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活属性组件</p>
	 * <p>Copyright: Copyright (c) 2014-3-28</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdffsmOffer extends IUpdfcmpOffer implements java.io.Serializable{
		private static final long serialVersionUID = -4372342099315672455L;
		private java.util.List COMPETENCE = new java.util.ArrayList();
		public IUpdffsmOffer(ISAComponent aComponent ){
			super( aComponent );
		}	
		/**
		 * @return the cOMPETENCE
		 */
		public java.util.List getCOMPETENCE() {
			return COMPETENCE;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活派单组件</p>
	 * <p>Copyright: Copyright (c) 2014-3-28</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdffwmOffer extends IUpdfcmpOffer implements java.io.Serializable{
		private static final long serialVersionUID = 9091093870981117070L;
		private java.util.Map DISTRIBUTE = new java.util.HashMap();
		public IUpdffwmOffer(ISAComponent aComponent){
			super( aComponent );
		}
		/**
		 * @return the dISTRIBUTE
		 */
		public java.util.Map getDISTRIBUTE() {
			return DISTRIBUTE;
		}
		/**
		 * 根据网元编号和工单类型查询派单规范
		 * @param aPLATFORM
		 * @param aCATEGORY
		 * @return
		 */
		public java.util.List getDISTRIBUTE( String aPLATFORM , String aCATEGORY ){
			java.util.List fromClaim = null;
			try
			{
				String fromUpfms[] = new String[]{aCATEGORY, "*"};
				for( int index = 0; index < fromUpfms.length; index++ ){
					String aINDEX = ClassUtils.getINDEX( new String[]{aPLATFORM , 
							"_$_" , 
							fromUpfms[index] } );
					fromClaim = (java.util.List)DISTRIBUTE.get( aINDEX );
					if( fromClaim != null ) break;
				}
				
			}
			finally{
				
			}
			return fromClaim;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.valuebean.IProgramTemplate.IUpdfcmpOffer#subscribe(com.ai.appframe2.common.DataStructInterface)
		 */
		public void subscribe(DataStructInterface fromUpdcmpt) {
			try
			{
				ISADistribute aDistribute = (ISADistribute)fromUpdcmpt;
				IUpdfcmpDistribute fromHUMAN = new IUpdfcmpDistribute( aDistribute );
				String aINDEX = ClassUtils.getINDEX( new String[]{fromHUMAN.getPLATFORM_() , 
						"_$_" , 
						fromHUMAN.getCATEGORY() } );
				if( DISTRIBUTE.containsKey( aINDEX ) == false ) DISTRIBUTE.put( aINDEX , new java.util.ArrayList() );
				((java.util.List)DISTRIBUTE.get( aINDEX ) ).add( fromHUMAN );
			}
			finally{
				
			}
		}

		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: 服务激活派单规则</p>
		 * <p>Copyright: Copyright (c) 2014-3-28</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 3.0
		 */
		public static class IUpdfcmpDistribute implements java.io.Serializable{
			private static final long serialVersionUID = 690207521174458863L;
			private long   ID           ;                       
			private String NAME         ;                       
			private String CATEGORY     ;
			private String PLATFORM_    ;                       
			private String COMPLEX      ;                       
			private String DISTRIBUTE   ;
			private String COMPOSITE    ;                       
			private String CONTROL      ;                       
			private java.sql.Timestamp EFFECTIVE    ;                       
			private java.sql.Timestamp EXPIRE       ;                       
			public IUpdfcmpDistribute( ISADistribute aDistribute ){
				super();
				ID            = aDistribute.getId         ();                       
				NAME          = aDistribute.getName       ();                       
				CATEGORY      = aDistribute.getCategory   ();
				PLATFORM_     = aDistribute.getPlatform   ();                       
				COMPLEX       = aDistribute.getComplex    ();                       
				DISTRIBUTE    = aDistribute.getDistribute ();
				COMPOSITE     = aDistribute.getComposite  ();                       
				CONTROL       = aDistribute.getControl    ();                       
				EFFECTIVE     = aDistribute.getEffective  ();                       
				EXPIRE        = aDistribute.getExpire     ();                       
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
			 * @return the dISTRIBUTE
			 */
			public String getDISTRIBUTE() {
				return DISTRIBUTE;
			}
			/**
			 * @param distribute the dISTRIBUTE to set
			 */
			public void setDISTRIBUTE(String distribute) {
				DISTRIBUTE = distribute;
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
			
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活异常原因类组件</p>
	 * <p>Copyright: Copyright (c) 2014-3-31</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdfcauOffer extends IUpdfcmpOffer implements java.io.Serializable{
		private static final long serialVersionUID = 6825367778780150091L;
		private java.util.ArrayList EXCEPTION = new java.util.ArrayList();
		public IUpdfcauOffer( ISAComponent aComponent ){
			super( aComponent );
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.valuebean.IProgramTemplate.IUpdfcmpOffer#subscribe(com.ai.appframe2.common.DataStructInterface)
		 */
		public void subscribe(DataStructInterface fromUpdcmpt) {
			try
			{
				IUpdfcmpCausation aEXCEPTION = new IUpdfcmpCausation( 
						(ISAException)fromUpdcmpt );
				EXCEPTION.add( aEXCEPTION );
			}
			finally{
				
			}
		}
		/**
		 * @return the eXCEPTION
		 */
		public java.util.ArrayList getEXCEPTION() {
			return EXCEPTION;
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2014-12-2</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 3.0
		 */
		public static class IUpdfcmpCausation  implements java.io.Serializable{
			private static final long serialVersionUID = -2813335390455034232L;
			private String ID          ;
			private String NAME        ;
			private String PLATFORM    ;
			private String DESCRIPTION ;
			private String COMPLEX     ;
			private String CONTROL     ;
			public IUpdfcmpCausation( ISAException aEXCEPTION ){
				super();
				ID          = aEXCEPTION.getRespond    ();        
				NAME        = aEXCEPTION.getName       ();        
				PLATFORM    = aEXCEPTION.getPlatform   ();        
				DESCRIPTION = aEXCEPTION.getDescription();        
				COMPLEX     = aEXCEPTION.getComplex    ();        
				CONTROL     = aEXCEPTION.getControl    ();        
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
			 * @return the dESCRIPTION
			 */
			public String getDESCRIPTION() {
				return DESCRIPTION;
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
			 * @return the pLATFORM
			 */
			public String getPLATFORM() {
				return PLATFORM;
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活异常回滚组件</p>
	 * <p>Copyright: Copyright (c) 2015-5-2</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdfbpmOffer extends IUpdfcmpOffer implements java.io.Serializable{
		private static final long serialVersionUID = -8786665543925512317L;
		public IUpdfbpmOffer(ISAComponent aComponent){
			super( aComponent );
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2015-5-21</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 3.0
		 */
		public static class IUpdfcmpRollBack implements java.io.Serializable{
			private static final long serialVersionUID = 5486875125757105390L;
			private long   ID         ;
			private String NAME       ;
			private String COMPONENT  ;
			private String CATALOG    ;
			private String DESCRIPTION;
			private String PLATFORM   ;
			private String SUBFLOW    ;
			private String COMPLEX    ;
			private String CONTROL    ;			   
			public IUpdfcmpRollBack(ISARollBack aRollBack){
				super();
				ID          = aRollBack.getId         ();
				NAME        = aRollBack.getName       ();
				COMPONENT   = aRollBack.getComponent  ();
				CATALOG     = aRollBack.getCatalog    ();
				DESCRIPTION = aRollBack.getDescription();
				PLATFORM    = aRollBack.getPlatform   ();
				SUBFLOW     = aRollBack.getSubflow    ();
				COMPLEX     = aRollBack.getComplex    ();
				CONTROL     = aRollBack.getControl    ();
			}
			/**
			 * @return the cATALOG
			 */
			public String getCATALOG() {
				return CATALOG;
			}
			/**
			 * @param catalog the cATALOG to set
			 */
			public void setCATALOG(String catalog) {
				CATALOG = catalog;
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
			 * @return the cOMPONENT
			 */
			public String getCOMPONENT() {
				return COMPONENT;
			}
			/**
			 * @param component the cOMPONENT to set
			 */
			public void setCOMPONENT(String component) {
				COMPONENT = component;
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
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 服务激活通用组件</p>
	 * <p>Copyright: Copyright (c) 2015-5-20</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdfcwmOffer extends IUpdfcmpOffer implements java.io.Serializable{
		private static final long serialVersionUID = -1287432107123774223L;
		public IUpdfcwmOffer(ISAComponent aComponent){
			super(aComponent);
		}
	}
}
