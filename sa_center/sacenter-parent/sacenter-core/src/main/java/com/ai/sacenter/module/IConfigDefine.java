package com.ai.sacenter.module;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpfvmsSTKLocal;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.model.ICacheConfigure;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-3-20</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class IConfigDefine implements java.io.Serializable {
	private final static Log log = LogFactory.getLog(IConfigDefine.class);
	private static final long serialVersionUID = 1091202566782758669L;
	private static IConfigDefine INSTANCE = null;
	private org.dom4j.Element _configure = null;
	private IGlobalDefine _runtime_globaldefine = null;
	private ICacheConfigure _runtime_cacheconfigure = null;
	private java.util.List _runtime_moduledefine = java.util.Collections.synchronizedList(new java.util.ArrayList());
	private static java.util.Map _runtime_servicedefine = new java.util.concurrent.ConcurrentHashMap();
	private IConfigDefine() {
		try 
		{
			String aConfigXml = JdomUtils.IConfigure.getIConfigRoot();
			org.dom4j.Element fromRoot = XmlUtils.parseFileXml( aConfigXml );
			initialize( fromRoot );
		}
		catch ( java.lang.Exception ex) {
		   throw new RuntimeException(ex);
		}
	}
	
	/***
	 * 
	 * @return
	 */
	public static IConfigDefine getINSTANCE(){
		if( INSTANCE == null ){
			synchronized(IConfigDefine.class){
				if(INSTANCE == null) INSTANCE = new IConfigDefine();
		    }
		}
		return INSTANCE;
	}
	
	/**
	 * @return the _configure
	 */
	public org.dom4j.Element getConfigure() {
		return _configure;
	}
	
	/***
	 * 
	 * @return
	 */
	public IGlobalDefine getConfigItem(){
		return _runtime_globaldefine;
	}
	
	/**
	 * 
	 * @return
	 */
	public ICacheConfigure getConfigCache(){
		return _runtime_cacheconfigure;
	}
	
	/**
	 * 网元路由配置
	 * @return
	 */
	public IGlobalDefine.ICenterDefine getCenter(){
		return _runtime_globaldefine.getCENTER();
	}
	
	/**
	 * 流程控制配置
	 * @return
	 */
	public IGlobalDefine.ISubFlowDefine getSubFlow(){
		return _runtime_globaldefine.getSUBFLOW();
	}
	
	/**
	 * 调度控制配置
	 * @return
	 */
	public IGlobalDefine.IControlDefine getControl(){
		return _runtime_globaldefine.getCONTROL();
	}
	
	/***
	 * 
	 * @return
	 */
	public IModuleDefine.IModuleIDefine[] getModule(){
		java.util.List aIModuleISKEL = new java.util.ArrayList();
		for(java.util.Iterator itera = _runtime_moduledefine.iterator() ; itera.hasNext() ; ){
			IConfigDefine.IModuleDefine aModule = (IConfigDefine.IModuleDefine)itera.next();
			if( aModule.getUSE().equalsIgnoreCase("true") == false ) continue;
			ClassUtils.IMerge.merge( aModule.getMODULE() , aIModuleISKEL );
		}
		return (IModuleDefine.IModuleIDefine[])aIModuleISKEL.toArray( new IModuleDefine.IModuleIDefine[]{} );
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public IModuleDefine.IModuleIDefine.IInitalizeDefine[] getInitalize( ) throws Exception{
		java.util.List aINITALIZE = new java.util.ArrayList();
		try
		{
			IModuleDefine.IModuleIDefine aModule[] = getModule();
			for(int index = 0 ; index < aModule.length ; index++){
				for( java.util.Iterator itera = aModule[index].getINITALIZE().iterator() ; itera.hasNext() ; ){
					IModuleDefine.IModuleIDefine.IInitalizeDefine aInitalize = (IModuleDefine.IModuleIDefine.IInitalizeDefine)itera.next();
					if( aInitalize.getUSE().equalsIgnoreCase("true") == false ) continue;
					aINITALIZE.add( aInitalize );
				}
			}
		}
		finally{
			
		}
		
		return (IModuleDefine.IModuleIDefine.IInitalizeDefine[])aINITALIZE.toArray( new IModuleDefine.IModuleIDefine.IInitalizeDefine[]{});
	}
	
	/***
	 * 
	 * @param fromRoot
	 * @throws SFException
	 * @throws Exception
	 */
	private void initialize( org.dom4j.Element fromRoot ) throws SFException,Exception{
		try
		{
			_configure = fromRoot;
			_runtime_globaldefine = new IConfigDefine.IGlobalDefine( (org.dom4j.Element)fromRoot.selectSingleNode("configitem[@name='SYSTEM']") );
			
			org.dom4j.Element _configitem = (org.dom4j.Element)fromRoot.selectSingleNode("configitem[@name='CACHE']");
			if( _configitem != null ){ 
				_runtime_cacheconfigure = new ICacheConfigure( _configitem ); 
			}
			else{
				_runtime_cacheconfigure = new ICacheConfigure();
			}
			
			for( java.util.Iterator itera = fromRoot.selectNodes("module").iterator(); itera.hasNext(); ){
				org.dom4j.Element aModule = (org.dom4j.Element)itera.next();
				String aUSE = aModule.attributeValue( "use", "TRUE" );
				if( aUSE.equalsIgnoreCase( "TRUE" ) == false ) continue;
				_runtime_moduledefine.add( new IConfigDefine.IModuleDefine( aModule ) );
			}
			for(java.util.Iterator itera = _runtime_moduledefine.iterator() ; itera.hasNext() ; ){
				IConfigDefine.IModuleDefine aModule = (IConfigDefine.IModuleDefine)itera.next();
				if( aModule.getUSE().equalsIgnoreCase("true") == false ) continue;
				for( java.util.Iterator iterap = aModule.getMODULE().iterator(); iterap.hasNext(); ){
					IConfigDefine.IModuleDefine.IModuleIDefine aModuleDefine = (IConfigDefine.IModuleDefine.IModuleIDefine)iterap.next();
					addIModule( aModuleDefine );
					if( log.isDebugEnabled() ) log.debug("load configuration file[" + aModuleDefine.getFILE() + "]successfully");
				}
			}
			if( log.isDebugEnabled() ) log.debug("initalize configuration[com/ai/ucmframe/AIUpdcRoot.xml]successfully");
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @param aServiceId
	 * @return
	 */
	public IConfigDefine.IServiceDefine getServiceDefine( String aServiceId ) {
		IConfigDefine.IServiceDefine aServiceDefine = null;
		try
		{
			if( _runtime_servicedefine.containsKey( aServiceId ) == false ) ExceptionFactory.throwRuntime("IOS0011003", new String[]{aServiceId});
			aServiceDefine = (IConfigDefine.IServiceDefine)_runtime_servicedefine.get( aServiceId );
		}
		finally{
			
		}
		return aServiceDefine;
	}
	
	/**
	 * 
	 * @param aID
	 * @param aTYPE
	 * @param aIInterface
	 * @param aIImpl
	 * @return
	 */
	public IServiceDefine getServiceDefine( String aID,
			String aTYPE ,
			String aIInterface,
			String aIImpl ){
		IServiceDefine aServiceDefine = null;
		try
		{
			aServiceDefine = (IServiceDefine)_runtime_servicedefine.get( aID );
			if( aServiceDefine == null ){
				aServiceDefine = Configure._creVmSRVCDefine( this, 
						aID, 
						aTYPE, 
						aIInterface, 
						aIImpl);
			}
		}
		catch( java.lang.Exception aThrowable){
			ExceptionFactory.throwRuntime( aThrowable );
		}
		return aServiceDefine;
	}
	
	/**
	 * 
	 * @param aIInterface
	 * @return
	 */
	public IServiceDefine getServiceDefine( Class aIInterface ){
		IServiceDefine aServiceDefine = null;
		try
		{
			aServiceDefine = (IServiceDefine)_runtime_servicedefine.get( aIInterface.getName() );
			if( aServiceDefine == null ){
				String aIImplClass = ClassUtils.IClass.getSVImpl( aIInterface ).getName();
				aServiceDefine = Configure._creVmSRVCDefine( this , 
						aIInterface.getName(), 
						IUpdcConst.IEnum.IInvoke.Singleton, 
						aIInterface.getName(), 
						aIImplClass );
			}
		}
		catch( java.lang.Exception aThrowable){
			ExceptionFactory.throwRuntime( aThrowable );
		}
		return aServiceDefine;
	}
	
	/**
	 * 
	 * @param aModuleId
	 * @param aUIProxyId
	 * @return
	 * @throws Exception
	 */
	public IConfigDefine.IModuleDefine.IModuleIDefine.IDeputizeDefine getDeputize( String aModuleId , String aUIProxyId ){
		IConfigDefine.IModuleDefine.IModuleIDefine.IDeputizeDefine aDeputizeDefine = null;
		try
		{
			String aINDEX = ClassUtils.getINDEX( new String[]{aModuleId , "$" , aUIProxyId.toUpperCase()} );
			aDeputizeDefine = (IConfigDefine.IModuleDefine.IModuleIDefine.IDeputizeDefine)_runtime_globaldefine._reference.get( aINDEX );
		}
		finally{
			
		}
		return aDeputizeDefine;
	}
	
	/***
	 * 
	 * @param aModule
	 * @throws SFException
	 * @throws Exception
	 */
	private void addIModule( IConfigDefine.IModuleDefine.IModuleIDefine aModule ) throws SFException,Exception{
		if( aModule.getUSE().equalsIgnoreCase("true") == false ) return;
		org.dom4j.Element aElement = XmlUtils.parseFileXml( aModule.getFILE() );
		String aModuleId = aElement.attributeValue("id");
		addISERVICE( aModuleId , aElement );
	}
	
	/***
	 * 
	 * @param aModuleId
	 * @param aElement
	 * @throws Exception
	 */
	private void addISERVICE( String aModuleId , org.dom4j.Element aElement ) throws Exception{
		java.util.List aServiceDefines = aElement.elements("service");
		for( java.util.Iterator itera = aServiceDefines.iterator(); itera.hasNext(); ){
			org.dom4j.Element temp = (org.dom4j.Element)itera.next();
			IConfigDefine.IServiceDefine aServiceDefine = new IConfigDefine.IServiceDefine( aModuleId , temp );
			if( aServiceDefine.getUSE().equalsIgnoreCase("true") == false ) continue;
			if( _runtime_servicedefine.containsKey( aServiceDefine.getID() ) == false )
				_runtime_servicedefine.put( aServiceDefine.getID() , aServiceDefine );
		}
	}
	
	/***
	 * 
	 *
	 */
	public class IGlobalDefine{
		private org.dom4j.Element _configure = null;
		private boolean _debug = false;
		private boolean _filesystem = true;
		private String  _kernel = null;
		private IControlDefine _control = null;
		private ISubFlowDefine _subflow = null;
		private ICenterDefine  _center = null;
		private java.util.Map  _velocity = new java.util.HashMap();
		private java.util.Map  _complex = new java.util.HashMap();
		/*环境变量*/
		private java.util.Map  _graphics = new java.util.HashMap();
		/*代理类*/
		private java.util.Map  _reference = new java.util.HashMap();
		/*创建虚拟接口框架模板*/
	    private java.util.Map  _module = java.util.Collections.synchronizedMap( new java.util.HashMap() );
        public IGlobalDefine(  org.dom4j.Element fromRoot ) throws Exception{
        	super();
        	_configure = fromRoot;
        	JdomUtils.IJdom.getIJDX$ItemL( (org.dom4j.Element)fromRoot.selectSingleNode("item[@name='VELOCITY']"), _velocity );
        	JdomUtils.IJdom.getIJDX$ItemL( (org.dom4j.Element)fromRoot.selectSingleNode("item[@name='JEVAL']")   , _complex );
        	
        	_debug      = JdomUtils.IConfigure.getAsBoolean( fromRoot, "DEBUG", false );
        	_kernel     = JdomUtils.IConfigure.getAsString( fromRoot ,"KERNELSYSTEM", com.ai.sacenter.common.ISystemKernelImpl.class.getName());
        	_filesystem = JdomUtils.IConfigure.getAsBoolean( fromRoot, "FILESYSTEM", false )	;
			
			org.dom4j.Element fromLimite = (org.dom4j.Element)fromRoot.selectSingleNode("item[@name='CONTRO']");
			_control = new IControlDefine( fromLimite );
			_subflow = new ISubFlowDefine( (org.dom4j.Element)fromLimite.selectSingleNode("item[@name='SUBFLOW']") );
			
			fromLimite = (org.dom4j.Element)fromRoot.selectSingleNode("item[@name='CENTER']");
			_center = fromLimite == null?new ICenterDefine():new ICenterDefine( fromLimite );
		}
        
		/**
		 * @return the _configure
		 */
		public org.dom4j.Element getConfigure() {
			return _configure;
		}

		/**
		 * @return the KERNEL
		 */
		public String getKERNEL() {
			return _kernel;
		}
		
		/**
		 * @return the VELOCITY
		 */
		public java.util.Map getVELOCITY() {
			return _velocity;
		}
		
		/**
		 * @return the DEBUG
		 */
		public boolean getDEBUG() {
			return _debug;
		}
		
		/**
		 * @return the FILESYSTEM
		 */
		public boolean getFILESYSTEM() {
			return _filesystem;
		}
		
		/**
		 * @return the CONTROL
		 */
		public IControlDefine getCONTROL() {
			return _control;
		}
		
		/**
		 * 
		 * @return
		 */
		public ISubFlowDefine getSUBFLOW(){
			return _subflow;
		}
		
		/**
		 * @return the cENTER
		 */
		public ICenterDefine getCENTER() {
			return _center;
		}
		
		/**
		 * @return the cOMPLEX
		 */
		public java.util.Map getCOMPLEX() {
			return _complex;
		}
		
		/**
		 * @return the gRAPHICS
		 */
		public java.util.Map getGRAPHICS() {
			return _graphics;
		}
		
		/**
		 * 
		 * @param aPATH
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public Object getGRAPHICS( String aPATH ) throws SFException,Exception{
			return ReflectUtils.xPath( aPATH , _graphics );
		}
		
		/**
         * 控制类定义
         * <p>Company: AI(NanJing)</p>
         * @author maohuiyun
         * @version 2.0 
         *
         */
        public class IControlDefine implements java.io.Serializable{
        	private static final long serialVersionUID = 8715768945789895039L;
        	private boolean _human       = false;
        	private long    _redo_times  = 5;
        	private long    _interval    = 300;
        	private boolean _rsgmsystem  = false;
        	private String  _region_id   = null;
        	private String  _program_  = null;
        	private java.util.Map _dialect = new java.util.HashMap();
        	public IControlDefine( org.dom4j.Element aElement ){
        		super();
        		_redo_times  = JdomUtils.IConfigure.getAsLong   ( aElement, "REDO_TIMES" , 5     );
        		_interval    = JdomUtils.IConfigure.getAsLong   ( aElement, "INTERVAL"   , 300   );
        		_human       = JdomUtils.IConfigure.getAsBoolean( aElement, "HUMAN"      , false );
        		_rsgmsystem  = JdomUtils.IConfigure.getAsBoolean( aElement, "RSGMSYSTEM" , false );
        		_region_id   = JdomUtils.IConfigure.getAsString ( aElement, "REGION_ID"  , null  );
        		_program_    = JdomUtils.IConfigure.getAsString ( aElement, "PROGRAM"    , "CMKTC_ROCKET_COMPLETE_PROGRAM" );
        		aElement = (org.dom4j.Element)aElement.selectSingleNode("item[@name='DIALECT']");
        		if( aElement != null ){
        			for( java.util.Iterator itera = aElement.elements("item").iterator(); itera.hasNext(); ){
        				org.dom4j.Element temp = (org.dom4j.Element)itera.next();
        				_dialect.put( temp.attributeValue("name"), temp.getTextTrim() );
        			}
        		}
        	}
        	
			/**
			 * @return 是否网元异常落地
			 */
			public boolean getHUMAN() {
				return _human;
			}
			
			/**
			 * @return 重做次数
			 */
			public long getREDO_TIMES() {
				return _redo_times;
			}
			
			/**
			 * @return 时间间隔
			 */
			public long getINTERVAL() {
				return _interval;
			}

			/**
			 * @return 号段局向
			 */
			public boolean getRSGMSYSTEM() {
				return _rsgmsystem;
			}
			
			/**
			 * @return 地市编码
			 */
			public String getREGION_ID() {
				return _region_id;
			}
			
			/**
			 * @return 服务组件
			 */
			public String getPROGRAM() {
				return _program_;
			}

			/**
			 * @return 数据方言
			 */
			public java.util.Map getDIALECT() {
				return _dialect;
			}
			
        }
        /**
         * 回滚流程控制类规则
         * <p>Title: ucmframe</p>
         * <p>Description: </p>
         * <p>Copyright: Copyright (c) 2011-11-4</p>
         * <p>Company: AI(NanJing)</p>
         * @author maohuiyun
         * @version 2.0 
         *
         */
        public class ISubFlowDefine implements java.io.Serializable{
        	private static final long serialVersionUID = -1688021459206866350L;
        	private boolean _rollback = false;
        	private boolean _rbwfqfom = false;
        	public ISubFlowDefine( org.dom4j.Element aElement ){
        		super();
        		_rollback = JdomUtils.IConfigure.getAsBoolean( aElement, "ROLLBACK", false );
        		_rbwfqfom = JdomUtils.IConfigure.getAsBoolean( aElement, "RBWFQFOM", false );
        	}
        	
			/**
			 * @return the rBWFQFOM
			 */
			public boolean getRBWFQFOM() {
				return _rbwfqfom;
			}
			
			/**
			 * @return the rOLLBACK
			 */
			public boolean getROLLBACK() {
				return _rollback;
			}
		}
        /**
         * 
         * <p>Title: ucmframe</p>
         * <p>Description: </p>
         * <p>Copyright: Copyright (c) 2012-4-20</p>
         * <p>Company: AI(NanJing)</p>
         * @author maohuiyun
         * @version 2.0 
         *
         */
        public class ICenterDefine implements java.io.Serializable{
        	private static final long serialVersionUID = 1435083412801441345L;
        	/*中心类转换类*/
        	private java.util.Map _func = new java.util.HashMap();
        	public ICenterDefine(){
        		super();
        	}
			public ICenterDefine( org.dom4j.Element aElement) throws Exception {
        		super();
        		_submitJEnvic( aElement );
        	}
			/**
			 * 
			 * @param aElement
			 * @throws Exception
			 */
			public void _submitJEnvic( org.dom4j.Element aElement) throws Exception{
				for( java.util.Iterator itera = aElement.elements( "item" ).iterator() ; itera.hasNext() ; ){
        			org.dom4j.Element temp = (org.dom4j.Element)itera.next();
        			String aUSE = temp.attributeValue( "use", "TRUE" );
        			if( aUSE.equalsIgnoreCase( "TRUE" ) == false ) continue;
        			_func.put( temp.attributeValue("name"), temp.attributeValue("value") );
        		}
        	}
			/**
			 * @return the FUNC
			 */
			public java.util.Map getFUNC() {
				return _func;
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-4-23</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public class IModuleDefine{
		private String FILE = null;
		private String USE = null;
		private String NAME = null;
		private java.util.List MODULE = new java.util.ArrayList();
		public IModuleDefine(org.dom4j.Element aElement) throws Exception{
			FILE = aElement.attributeValue("file");
			NAME = aElement.attributeValue("name");
			USE = aElement.attributeValue("use","true");
			java.util.List aModules = XmlUtils.parseFileXml( getFILE() ).selectNodes("module");
			for( java.util.Iterator itera = aModules.iterator() ; itera.hasNext() ; ){
				org.dom4j.Element aModule = (org.dom4j.Element)itera.next();
				String aUSE = aModule.attributeValue( "use", "TRUE" );
				if( aUSE.equalsIgnoreCase( "TRUE" ) == false ) continue;
				MODULE.add( new IModuleIDefine( aModule ) );
			}
		}
		/**
		 * 
		 *
		 */
		public IModuleDefine(){
			super();
		}
		/**
		 * @return the fILE
		 */
		public String getFILE() {
			return FILE;
		}
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		/**
		 * @return the uSE
		 */
		public String getUSE() {
			return USE;
		}
		/**
		 * @return the MODULE
		 */
		public java.util.List getMODULE() {
			return MODULE;
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2013-4-23</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public class IModuleIDefine{
			private String ID = null;
			private String FILE = null;
			private String USE = null;
			private String NAME = null;
			private java.util.List INITALIZE = new java.util.ArrayList();
			public IModuleIDefine(org.dom4j.Element aElement) throws Exception{
				super();
				org.dom4j.Element aXML = XmlUtils.parseFileXml( aElement.attributeValue("file") );
				ID = aXML.attributeValue("id");
				FILE = aElement.attributeValue("file");
				NAME = aElement.attributeValue("name");
				USE = aElement.attributeValue("use","true");
				//初始化环境接口
				for( java.util.Iterator itera = aXML.elements("initalize").iterator(); itera.hasNext(); ){
					IInitalizeDefine aInitalize = new IInitalizeDefine( (org.dom4j.Element)itera.next() );
					if( StringUtils.equalsIgnoreCase( aInitalize.getUSE() , "true") == false ) continue;
					aInitalize.MODULE = ID;
					INITALIZE.add( aInitalize );
				}
				//初始化代理类
				for( java.util.Iterator itera = aXML.elements("proxy").iterator(); itera.hasNext(); ){
					org.dom4j.Element temp = (org.dom4j.Element)itera.next();
					String aID = temp.attributeValue("id");
					for( java.util.Iterator iterap = temp.elements("proxy").iterator(); iterap.hasNext(); ){
						org.dom4j.Element tmp = (org.dom4j.Element)iterap.next();
						String aUSE = tmp.attributeValue( "use", "true" );
						if( aUSE.equalsIgnoreCase("true") == false ) continue;
						IDeputizeDefine aDeputize = new IDeputizeDefine( tmp );
						_runtime_globaldefine._reference.put( (aID +"$"+aDeputize.getNAME()).toUpperCase() , aDeputize );
					}
				}
				//服务构造模板
				for( java.util.Iterator itera = aXML.elements("vm-gen-ui").iterator() ; itera.hasNext() ; ){
					org.dom4j.Element temp = (org.dom4j.Element)itera.next();
					String aIGenUIProxyId = temp.attributeValue("id");
					for( java.util.Iterator iterap = temp.elements("template").iterator(); iterap.hasNext(); ){
						org.dom4j.Element tmp = (org.dom4j.Element)iterap.next();
						String aUSE = tmp.attributeValue( "use", "true" );
						if( aUSE.equalsIgnoreCase("true") == false ) continue;
						IDeputVmfsDefine aDeputVmfsDefine = new IDeputVmfsDefine( tmp );
						_runtime_globaldefine._module.put( (aIGenUIProxyId +"$"+aDeputVmfsDefine.getNAME()).toUpperCase() , aDeputVmfsDefine );
					}
				}
			}
			/**
			 * 
			 * @throws Exception
			 */
			public IModuleIDefine( ) throws Exception{
				super();
			}
			/**
			 * @return the iD
			 */
			public String getID() {
				return ID;
			}
			/**
			 * @return Returns the fILE.
			 */
			public String getFILE() {
				return FILE;
			}
			/**
			 * @return Returns the uSE.
			 */
			public String getUSE() {
				return USE;
			}
			/**
			 * @return the nAME
			 */
			public String getNAME() {
				return NAME;
			}
			
			/**
			 * @return the INITALIZE
			 */
			public java.util.List getINITALIZE() {
				return INITALIZE;
			}

			/***
			 * 
			 * @author Administrator
			 * <initalize>
			 * </initalize>
			 */
			public class IInitalizeDefine{
				private String  MODULE;
				private String  CLASS;
				private org.dom4j.Element CONFIG;
				private String  USE;
				public IInitalizeDefine( org.dom4j.Element aElement ) throws SFException,Exception{
					CLASS = aElement.attributeValue("name");
					CONFIG = (org.dom4j.Element)aElement.selectSingleNode("configitem");
					USE = aElement.attributeValue("use","true");
				}
				/**
				 * @return the cLASS
				 */
				public String getCLASS() {
					return CLASS;
				}

				/**
				 * @return the cONFIG
				 */
				public org.dom4j.Element getCONFIG() {
					return CONFIG;
				}

				/**
				 * @return the mODULE
				 */
				public String getMODULE() {
					return MODULE;
				}

				/**
				 * @return the uSE
				 */
				public String getUSE() {
					return USE;
				}

				/* (non-Javadoc)
				 * @see java.lang.Object#toString()
				 */
				public String toString() {
					StringBuilder aIRetnSKEL = new StringBuilder();
					aIRetnSKEL.append(super.toString()).append("{")
					          .append("MODULE = ").append( MODULE )
					          .append(", CLASS_NAME = ").append( CLASS )
					          .append(", CONFIG_ITEM = ").append( CONFIG != null?CONFIG.asXML():"NULL" )
					          .append("}");
					return aIRetnSKEL.toString();
				}
			}
			/**
			 * 
			 * <p>Title: ucmframe</p>
			 * <p>Description: </p>
			 * <p>Copyright: Copyright (c) 2013-4-23</p>
			 * <p>Company: AI(NanJing)</p>
			 * @author maohuiyun
			 * @version 2.0 
			 *
			 */
			public class IDeputizeDefine{
				private String NAME;
				private String PROXY;
				private String IMPL;
				private String USE;
				public IDeputizeDefine( org.dom4j.Element aElement ) throws Exception{
					NAME = aElement.attributeValue("name");
					PROXY = aElement.attributeValue("proxy-class");
					IMPL = aElement.attributeValue("impl-define");
					USE = aElement.attributeValue("use", "true");
				}
				/**
				 * @return the iMPL
				 */
				public String getIMPL() {
					return IMPL;
				}
				/**
				 * @return the nAME
				 */
				public String getNAME() {
					return NAME;
				}
				/**
				 * @return the pROXY
				 */
				public String getPROXY() {
					return PROXY;
				}
				/**
				 * @return the uSE
				 */
				public String getUSE() {
					return USE;
				}
				
			}
			/**
			 * 
			 * <p>Title: ucmframe</p>
			 * <p>Description: </p>
			 * <p>Copyright: Copyright (c) 2013-4-23</p>
			 * <p>Company: AI(NanJing)</p>
			 * @author maohuiyun
			 * @version 2.0 
			 *
			 */
			public class IDeputVmfsDefine{
				private String NAME;
				private String TEMPLATE;
				private String USE;
				public IDeputVmfsDefine( org.dom4j.Element aElement ) throws Exception{
					super();
					NAME = aElement.attributeValue("name");
					TEMPLATE = aElement.attributeValue("template");
					USE = aElement.attributeValue("use", "true");
				}
				/**
				 * @return the nAME
				 */
				public String getNAME() {
					return NAME;
				}
				/**
				 * @return the tEMPLATE
				 */
				public String getTEMPLATE() {
					return TEMPLATE;
				}
				/**
				 * @param template the tEMPLATE to set
				 */
				public void setTEMPLATE(String template) {
					TEMPLATE = template;
				}
				/**
				 * @return the uSE
				 */
				public String getUSE() {
					return USE;
				}
			}
		}
	}
	/**
	 * 服务定义
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-4-23</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public class IServiceDefine{
		private String ID ;
		private String NAME;
		private String INTERFACE;
		private String USE = null;
		private IImplDefine IMPL_DEFINE ;
		public IServiceDefine( String aModuleId , org.dom4j.Element aElement ) throws Exception{
			ID = StringUtils.isBlank(aModuleId)?aElement.attributeValue("id"):
				(aModuleId+ "." + aElement.attributeValue("id"));
			NAME = aElement.attributeValue("name");
			INTERFACE = aElement.attributeValue("interface");
			USE = aElement.attributeValue("use","true");
			org.dom4j.Element aImpldefine = (org.dom4j.Element)aElement.selectSingleNode("impl-define");
			String aINVOKE = aImpldefine.attributeValue("invoke");
			if( aINVOKE.equalsIgnoreCase( IUpdcConst.IEnum.IInvoke.Ejb ) )
				IMPL_DEFINE = new IServiceDefine.IImplEjbDefine( aImpldefine );
			else if( aINVOKE.equalsIgnoreCase( IUpdcConst.IEnum.IInvoke.Interceptor ) )
				IMPL_DEFINE = new IServiceDefine.IImplInvokeDefine( aImpldefine );
			else if( aINVOKE.equalsIgnoreCase( IUpdcConst.IEnum.IInvoke.WebService ) )
				IMPL_DEFINE = new IImplWsDefine( aImpldefine );
			else if( aINVOKE.equalsIgnoreCase( IUpdcConst.IEnum.IInvoke.Primitive ) )
				IMPL_DEFINE = new IServiceDefine.IImplDefine( aImpldefine );
			else
			    IMPL_DEFINE = new IServiceDefine.IImplDefine( aImpldefine );
		}
		/**
		 * @return Returns the iD.
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @return Returns the iNTERFACE.
		 */
		public String getINTERFACE() {
			return INTERFACE;
		}
		/**
		 * @return Returns the nAME.
		 */
		public String getNAME() {
			return NAME;
		}
		/**
		 * @return Returns the uSE.
		 */
		public String getUSE() {
			return USE;
		}
		/**
		 * @return Returns the iMPL_DEFINE.
		 */
		public IImplDefine getIMPL_DEFINE() {
			return IMPL_DEFINE;
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2013-4-23</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public class IImplDefine{
			private String INVOKE;
			private String IMPL_CLASS;
			private String CONTEXT;
			private java.util.Map STUB = new java.util.HashMap();
			public IImplDefine( org.dom4j.Element aImpldefine ) throws Exception{
				INVOKE = aImpldefine.attributeValue("invoke");
				IMPL_CLASS = aImpldefine.attributeValue("impl-class");
				CONTEXT = aImpldefine.attributeValue("context");
				JdomUtils.IJdom.getIJDX$StubL( aImpldefine , STUB );
			}
			
			/**
			 * @return Returns the iMPL_CLASS.
			 */
			public String getIMPL_CLASS() {
				return IMPL_CLASS;
			}

			/**
			 * @return Returns the INVOKE.
			 */
			public String getINVOKE() {
				return INVOKE;
			}
			
			/**
			 * @return the cONTEXT
			 */
			public String getCONTEXT() {
				return CONTEXT;
			}
			
			/**
			 * @return the STUB
			 */
			public java.util.Map getSTUB() {
				return STUB;
			}
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2013-4-23</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public class IImplInvokeDefine extends IImplDefine{
			private String INTERCEPTOR_CLASS;
			public IImplInvokeDefine( org.dom4j.Element aImpldefine ) throws Exception{
				super( aImpldefine );
				INTERCEPTOR_CLASS = aImpldefine.attributeValue("interceptor");
			}
			/**
			 * @return the iNTERCEPTOR_CLASS
			 */
			public String getINTERCEPTOR_CLASS() {
				return INTERCEPTOR_CLASS;
			}
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2013-4-23</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public class IImplWsDefine extends IImplDefine{
			private String URL;
			public IImplWsDefine( org.dom4j.Element aImpldefine ) throws Exception{
				super( aImpldefine );
				URL = aImpldefine.attributeValue("url");
			}

			/**
			 * @return the uRL
			 */
			public String getURL() {
				return URL;
			}
		}
		/**
		 * 
		 * <p>Title: ucmframe</p>
		 * <p>Description: </p>
		 * <p>Copyright: Copyright (c) 2013-4-23</p>
		 * <p>Company: AI(NanJing)</p>
		 * @author maohuiyun
		 * @version 2.0 
		 *
		 */
		public class IImplEjbDefine extends IImplDefine{
			private String JNDI;
			private String HOME_INTERFACE;
			public IImplEjbDefine( org.dom4j.Element aImpldefine ) throws Exception{
				super( aImpldefine );
				JNDI = aImpldefine.attributeValue("jndi");
				HOME_INTERFACE = aImpldefine.attributeValue("home-interface");
			}
			/**
			 * @return the hOME_INTERFACE
			 */
			public String getHOME_INTERFACE() {
				return HOME_INTERFACE;
			}
			/**
			 * @return the jNDI
			 */
			public String getJNDI() {
				return JNDI;
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2012-7-6</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class Configure{
		public Configure(){
			super();
		}
		
		/**
		 * 
		 * @param aINSTANCE
		 * @param aTYPE
		 * @param aIInterface
		 * @param aIImpl
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IServiceDefine _creVmSRVCDefine( final IConfigDefine aINSTANCE , 
				String aID,
				String aTYPE ,
				String aIInterface,
				String aIImpl ) throws SFException,Exception{
			IServiceDefine aServiceDefine = null;
			java.util.Map fromUpffmx = new java.util.HashMap();
			try
			{
				aServiceDefine = (IServiceDefine)_runtime_servicedefine.get( aID );
				if( aServiceDefine == null ){
					IConfigDefine.IModuleDefine.IModuleIDefine.IDeputVmfsDefine aDeputVmfsDefine = null;
					synchronized( aINSTANCE ){
						if( ( aServiceDefine = (IServiceDefine)_runtime_servicedefine.get( aID ) ) == null ){
							ClassUtils.IMerge.merge( new Object[][]{{"ID",aID},{"TYPE",aTYPE},{"INTERFACE" ,aIInterface},{"IMPL_CLASS",aIImpl}}, fromUpffmx , true );
							String aINDEX  = ("SERVICEFRAME$"+aTYPE).toUpperCase();
							aDeputVmfsDefine = (IConfigDefine.IModuleDefine.IModuleIDefine.IDeputVmfsDefine)aINSTANCE._runtime_globaldefine._module.get( aINDEX );
							if( aDeputVmfsDefine == null ) ExceptionFactory.throwRuntime("IOS0011002", new String[]{aINDEX} );
							String aXML = IUpfvmsSTKLocal.getINSTANCE().evaluate(aDeputVmfsDefine.getTEMPLATE() , 
									fromUpffmx );
							if( log.isDebugEnabled() ) log.debug( aXML );
							aINSTANCE.addISERVICE( "" , XmlUtils.parseXml( aXML ) );
							aServiceDefine = (IServiceDefine)_runtime_servicedefine.get( aID );
						}
					}
				}
			}
			finally{
				if( fromUpffmx != null ) { fromUpffmx.clear(); fromUpffmx = null;}
			}
			return aServiceDefine;
		}
		
	}
}
