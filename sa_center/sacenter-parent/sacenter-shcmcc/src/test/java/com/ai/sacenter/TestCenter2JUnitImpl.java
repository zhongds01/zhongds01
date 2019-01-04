package com.ai.sacenter;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.aif.csf.common.exception.CsfException;
import com.ai.appframe2.bo.dialect.DialectFactory;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.complex.cache.ICache;
import com.ai.appframe2.complex.datasource.LogicConnection;
import com.ai.appframe2.complex.datasource.interfaces.IConnectionDataSource;
import com.ai.sacenter.base.basic.bo.SADiction;
import com.ai.sacenter.base.competence.bo.SAMappingX;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.cache.SFCacheCluster;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.cboss.valuebean.IOVUpfgsmRadius;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.common.IUpdfmxDirectory;
import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.common.UpfsvcVantage;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.bo.ISAOffer;
import com.ai.sacenter.core.bo.SAOffer;
import com.ai.sacenter.core.bo.SAOfferHis;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.i18n.SFESCsfException;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jeval.JevalSTKEngine;
import com.ai.sacenter.jeval.PhantomEvaluator;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.module.model.ICacheConfigure;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.mstp.IUpfwmPool;
import com.ai.sacenter.provision.mstp.IUpfwmPoolFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmNotify;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.IUpdbfsFactory;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOfferX;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrderOffer;
import com.ai.sacenter.receive.exigence.ExigenceFactory;
import com.ai.sacenter.receive.exigence.IExigenceConst;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.bo.IISPCRocket;
import com.ai.sacenter.receive.exigence.bo.IISPCRocketX;
import com.ai.sacenter.receive.exigence.bo.ISPCRocket;
import com.ai.sacenter.receive.exigence.bo.ISPCRocketFail;
import com.ai.sacenter.receive.exigence.bo.ISPCRocketHis;
import com.ai.sacenter.receive.exigence.bo.ISPCRocketX;
import com.ai.sacenter.receive.exigence.bo.ISPCRocketXFail;
import com.ai.sacenter.receive.exigence.bo.ISPCRocketXHis;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFOrderBase;
import com.ai.sacenter.receive.expire.bo.ISAExpire;
import com.ai.sacenter.receive.expire.bo.SAExpire;
import com.ai.sacenter.receive.expire.bo.SAExpireSp;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketOffer;
import com.ai.sacenter.receive.order.IOrderConst;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.bo.IISARocket;
import com.ai.sacenter.receive.order.bo.ISARocketHis;
import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFRsRspMessage;
import com.ai.sacenter.receive.teaminvoke.valuebean.RocketFTextMessage;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.receive.util.ExigenceUtils;
import com.ai.sacenter.receive.util.ExpireUtils;
import com.ai.sacenter.receive.util.OrderUtils;
import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.receive.util.CustomUtils.ICustom;
import com.ai.sacenter.receive.valuebean.IOVMsgFCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFPlan;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserOffer;
import com.ai.sacenter.receive.valuebean.IOVUpffmxConsult;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.subtable.SFSubTableFactory;
import com.ai.sacenter.target.UpdbsFactory;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOfferX;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.tykt.IUpfgkmConst;
import com.ai.sacenter.tykt.UpfgkmFactory;
import com.ai.sacenter.tykt.bo.ISAEquipment;
import com.ai.sacenter.tykt.dao.remote.impl.IUpfgkmRemoteTfImpl;
import com.ai.sacenter.util.ArrayDeque;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.EncryptUtils;
import com.ai.sacenter.util.FileUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.JSONUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.OfferUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StackDeque;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.util.UpfwmUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.util.ReflectUtils.XPathNode;
import com.ai.sacenter.util.ReflectUtils.ICustom.IICustom;
import com.asiainfo.appframe.ext.exeframe.tf.TfFrameWork;
import com.asiainfo.sacenter.shcmcc.SHRocketConst;
import com.asiainfo.sacenter.shcmcc.teaminvoke.out.impl.SHUpdcCSVImpl;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxUnique;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxDestiny;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年1月12日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class TestCenter2JUnitImpl extends junit.framework.TestCase{
	private final static Log log = LogFactory.getLog( TestCenter2JUnitImpl.class );
	public TestCenter2JUnitImpl() {
		super();
		System.setProperty( "appframe.server.name", "SA-PROCESS_CSF");
		System.setProperty( "ucmframe.userlog.path", "F:/project/log/");
		System.setProperty( "oracle.jdbc.V8Compatible", "true" );
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketOffer() throws Exception{
		try
		{
			java.util.Map fromUpffmx = new java.util.HashMap();
			String fromXML = "RESULT=PROVNO=13|PROVNAME=河南|SERVAREA=13037001|SERVNAME=商丘|&PROVNO=13|PROVNAME=河南|SERVAREA=13037101|SERVNAME=郑州|;ContactorInfo=ContactorInfo0=|2|测试客户|02579099899|ContactorInfo1=5|测试|13851640256|;MAPINGINFO=USERTYPE=1|CRBT=2;SPID=9898;BIZCODE=98099000";
			UpfwmUtils.ICustom.wrap( fromXML, fromUpffmx );
			if( log.isDebugEnabled() ) log.debug( fromUpffmx );
		}
		finally{
			
		}
	}
	
	public void testRocketUpffsm() throws Exception{
		try
		{
			class IRocketUpfsmImpl{
				public IRocketUpfsmImpl(){
					super();
				}
				
				/**
				 * 
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUpdfmxOffer _jj_module() throws SFException,Exception{
					IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( this );
					try
					{
						org.dom4j.Element fromRoot = XmlUtils.parseFileXml("com/ai/sacenter/shcmcc/ucmframe-om-frame.module");
						for( java.util.Iterator itera = fromRoot.selectNodes("module").iterator(); itera.hasNext(); ){
							org.dom4j.Element aModule = (org.dom4j.Element)itera.next();
							String aUSE = aModule.attributeValue( "use", "TRUE" );
							if( aUSE.equalsIgnoreCase( "TRUE" ) == false ) continue;
							fromUpdfmx.getORDER().getORDER().add( new IModuleDefine( aModule ) );
						}
					}
					finally{
						
					}
					return fromUpdfmx;
				}
				
				
				public void _jj_module( IModuleDefine module ) throws SFException,Exception{
					try
					{
						
					}
					finally{
						
					}
				}
				
				class IModuleDefine{
					private String FILE = null;
					private String USE = null;
					private String NAME = null;
					private java.util.List<IModuleIDefine> MODULE = new java.util.ArrayList<IModuleIDefine>();
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
					public java.util.List<IModuleIDefine> getMODULE() {
						return MODULE;
					}
					
				}
			    class IModuleIDefine{
					private String ID = null;
					private String FILE = null;
					private String USE = null;
					private String NAME = null;
					public IModuleIDefine(org.dom4j.Element aElement) throws Exception{
						super();
						org.dom4j.Element aXML = XmlUtils.parseFileXml( aElement.attributeValue("file") );
						ID = aXML.attributeValue("id");
						FILE = aElement.attributeValue("file");
						NAME = aElement.attributeValue("name");
						USE = aElement.attributeValue("use","true");
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
				}
			}
			IRocketUpfsmImpl fromUpffsmImpl = new IRocketUpfsmImpl();
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				IOVUpdfmxOffer fromUpdfmx = fromUpffsmImpl._jj_module();
				for( java.util.Iterator<Object> itera = fromUpdfmx.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IRocketUpfsmImpl.IModuleDefine module = (IRocketUpfsmImpl.IModuleDefine)itera.next();
					if( StringUtils.equalsIgnoreCase( module.getUSE(), "FALSE" ) ) continue;
					if( log.isDebugEnabled() ) log.debug( module + "\t" + module.getFILE() );
					for( java.util.Iterator<IRocketUpfsmImpl.IModuleIDefine> iterap = module.getMODULE().iterator(); iterap.hasNext(); ){
						IRocketUpfsmImpl.IModuleIDefine  _module = iterap.next();
						if( StringUtils.equalsIgnoreCase( _module.getUSE(), "FALSE" ) ) continue;
						if( log.isDebugEnabled() ) log.debug( _module + "\t" + _module.getFILE() );
						IUpdcpFactory.getIUpfsmSV().deployUpffsmOracle( _module.getFILE() );
					}
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
			}
			finally{
				UpfsvcManager.finishMBean();
			}
		}
		finally{
			
		}
	}
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketPhantomImpl() throws Exception{
		try
		{
			java.io.InputStream fromInput = ClassUtils.IClass.getClassLoaderResource("com/ai/sacenter/receive/test_hlrsale.lsxl");
			//IOVMsgFRequest fromRequest = ICustom.getAsNature( "com/ai/sacenter/receive/sacenter-gsm-newsale.xml" );
			//IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromRequest.getUSER_ID() );
			IOVOrderPentium fromORDER = new IOVOrderPentium();
			fromORDER.setBILL_ID("13851640256");
			fromORDER.setSUB_BILL_ID("460007844153147");
			fromORDER.setCREATE_DATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			fromORDER.setORDER_DATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			java.util.HashMap _variables = new java.util.HashMap();
			_variables.put("BILL_ID", "13851640256");
			_variables.put("OPRTIME", "20991231235959" );
			_variables.put("ORDER", fromORDER );
			//_variables.put("GROUP", fromMsgFUser );
			String fromDeque[] = FileUtils.IFile.readLine( fromInput );
			for( int index = 0; fromDeque != null && index < fromDeque.length; index++ ){
				if( StringUtils.isBlank( fromDeque[index] ) ) continue;
				PhantomEvaluator _phantom = new PhantomEvaluator( fromDeque[index], _variables );
				//if( log.isDebugEnabled() ) log.debug( XmlUtils.IXml._format( _phantom.asXml() ) );
				if( log.isDebugEnabled() ) ICustom.userlog( "", _phantom );
			}
			/*java.lang.reflect.Method fromMethod = ReflectUtils.IReflect.getMethod(ISystemKernelImpl.class, 
					"getMULTLE", new Class[]{String.class,String.class});
			if( log.isDebugEnabled() ) log.debug( fromMethod );
			if( log.isDebugEnabled() ) log.debug( fromMethod.getDeclaringClass() );*/
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketCenterImpl() throws Exception{
		SFCenterFactory.pushCenterInfo("200");
		try
		{
			if( log.isDebugEnabled() ) log.debug("AAA0:" + SFCenterFactory.getCenterInfo() );
			SFCenterFactory.pushCenterInfo();
			try
			{
				if( log.isDebugEnabled() ) log.debug("AAA1:" + SFCenterFactory.getCenterInfo() );
				
				java.util.Map<String, String> fromUpffmx = new java.util.HashMap<String, String>();
				fromUpffmx.put("BILL_ID", "15026864778");
				SFCenterFactory.pushCenterInfo( IUpfgkmRemoteTfImpl.IUpfgkmNotifyTfImpl.class, fromUpffmx);
				try
				{
					if( log.isDebugEnabled() ) log.debug("AAA2:" + SFCenterFactory.getCenterInfo() );
				}
				finally{
					SFCenterFactory.popCenterInfo();
				}
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
			if( log.isDebugEnabled() ) log.debug("AAA0:" + SFCenterFactory.getCenterInfo() );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketJevalImpl() throws Exception{
		try
		{
			IUpdcContext aContext = ClassUtils.getIContextImpl();
			java.util.HashMap<String, String> fromPARAM = new java.util.HashMap<String, String>();
			JevalSTKEngine fromENGINE = new JevalSTKEngine();
			
			IOVOrderPentium fromORDER = new IOVOrderPentium();
			fromORDER.setBILL_ID    ("13851640256"    );
			fromORDER.setSUB_BILL_ID("460007844153147");
			fromORDER.setCREATE_DATE( new java.sql.Timestamp( System.currentTimeMillis() ) );
			fromORDER.setCOMPOSITE  ( "EXPIRE"        );
			aContext.put("ORDER", fromORDER );
			
			fromPARAM.put("BILL_ID", "13851640256");
			fromPARAM.put("OPRTIME", "20991231235959" );
			fromPARAM.put("PRDCODE", "0");
			fromPARAM.put("STBINFO", "0A0009AAA");
			fromPARAM.put("SMPJK", "E");
			fromPARAM.put("SMPJKDZ", "1385164");
			fromPARAM.put("STOP_TYPE", "1");
			fromPARAM.put("MBELL", "C");
			fromPARAM.put("STOPUSER", "E");
			fromPARAM.put("BAOCUSER", "D");
			fromPARAM.put( "VMICMOSS", "0" );
			
			/*首次停机*/
			String fromXML = fromENGINE.evaluate( "( #{STOPUSER} == 'C' && #{BAOCUSER} == 'NULL' ) || ( #{BAOCUSER} == 'C' && #{STOPUSER} == 'NULL' ) || ( #{STOPUSER} == 'C' && #{BAOCUSER} == 'C' )", fromPARAM, aContext );
			if( log.isDebugEnabled() ) log.debug( "首次停机[PBOSSV2] = " + fromXML );
			/*最终复机*/
			fromXML = fromENGINE.evaluate( "( #{STOPUSER} == 'E' && #{BAOCUSER} == 'NULL' ) || ( #{BAOCUSER} == 'E' && #{STOPUSER} == 'NULL' ) || ( #{STOPUSER} == 'E' && #{BAOCUSER} == 'E' )", fromPARAM, aContext );
			if( log.isDebugEnabled() ) log.debug( "最终复机[PBOSSV2] = " + fromXML );
			/*最终复机*/
			fromXML = fromENGINE.evaluate( "#{VMICMOSS} == '0' && ( #{STOPUSER} == 'E' || #{BAOCUSER} == 'E' )", fromPARAM, aContext );
			if( log.isDebugEnabled() ) log.debug( "最终复机[PBOSSV2] = " + fromXML );
			
			/*java.io.InputStream fromInput = ClassUtils.IClass.getClassLoaderResource("com/ai/sacenter/receive/test_jevalsale.lsxl");
			String fromDeque[] = FileUtils.IFile.readLine( fromInput );
			for( int index = 0; fromDeque != null && index < fromDeque.length; index++ ){
				if( StringUtils.isBlank( fromDeque[index] ) ) continue;
				String fromXML = fromENGINE.evaluate( fromDeque[index], fromPARAM, aContext );
				if( log.isDebugEnabled() ) log.debug( fromDeque[index] + "\t\t" + fromXML );
			}*/
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketTimestamp() throws Exception{
		try
		{
			java.sql.Timestamp fromDate = TimeUtils.getTime("20170913000001");
			java.sql.Timestamp time = TimeUtils.getNextYearStartDate( fromDate );
			if( log.isDebugEnabled() ) log.debug("NextYearStartDate: " + fromDate + "\t" + time );
			
			time = TimeUtils.getYestDayStartDate( fromDate );
			if( log.isDebugEnabled() ) log.debug( "YestDayStartDate: " + fromDate + "\t" + time );
			
			time = TimeUtils.getNextMonthStartDate( fromDate );
			if( log.isDebugEnabled() ) log.debug("NextMonthStartDate: " +  fromDate + "\t" + time );
			
			time = TimeUtils.getNextDayStartDate( fromDate );
			if( log.isDebugEnabled() ) log.debug("NextDayStartDate: " +  fromDate + "\t" + time );
			String fromMaxL = StringUtils.trimRight("13213213213", 2000 );
			if( log.isDebugEnabled() ) log.debug("NextDayStartDate: " +  fromMaxL );
			
			time = TimeUtils.getAsExpire( 2018010100l );
			if( log.isDebugEnabled() ) log.debug("getExpire: " +  time );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketTarget() throws Exception{
		try
		{
			IOVUpdbsComplete fromNotify = new IOVUpdbsComplete();
			java.util.Map fromPARAM = new java.util.HashMap();
			fromNotify.getORDER().getSUBFLOW().put( IExigenceConst.IUpdbm.IUpdbf.USER_ID   , "40061647890"  );
			fromNotify.getORDER().getSUBFLOW().put( IExigenceConst.IUpdbm.IUpdbf.BILL_ID   , "918817922342" );
			fromNotify.getORDER().getSUBFLOW().put( IExigenceConst.IUpdbm.IUpdbf.ORIGINATOR, "2" );
			fromNotify.mergeAsComplex( fromNotify.getORDER().getSUBFLOW() );
			if( log.isDebugEnabled() ) log.debug( fromNotify.getINSTANCE() + "\t" + fromNotify.getORDER().getSUBFLOW() );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testOrderOffer() throws Exception{
		try
		{
			IUpdcContext aContext = ClassUtils.getIContextImpl();
			IProfessionalTemplate.IProductOffer fromSubject = null;
			IOVMsgFExigence fromRocket = ICustom.getAsRocket("com/ai/sacenter/receive/sacenter-gsm_hedjsale.xml");
			IUpfgkmOfferHome fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRocket );
			IOVMsgFRequest fromNature = ICustom.getAsNature(fromRocket, fromUpdcpm);
			IOVOrderRequest fromRequest = ICustom.getAsRocket( fromRocket, fromUpdcpm );
			
			if( log.isDebugEnabled() ) log.debug( fromRequest + "\t" + fromRequest.getUSER() );
			IOVOrderOffer fromOrdOffer[] = fromRequest.getUSER().getCOMPETE( 270000015001l );
			IOVOrderOffer fromGroup = OfferUtils.ICustom.wrap( fromOrdOffer );
			if( log.isDebugEnabled() ) log.debug( fromGroup );
			
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketMapping() throws Exception{
		try
		{
			ISystemTemplate.IUpfgsmxOffer fromUpffxm = null;
			IUpdcContext aContext = ClassUtils.getIContextImpl();
			java.util.Map<String, String> fromPARAM = new java.util.HashMap<String, String>();
			fromPARAM.put( IExigenceConst.IUpdbm.IUpdbf.USER_ID   , "40061647890"  );
			fromPARAM.put( IExigenceConst.IUpdbm.IUpdbf.BILL_ID   , "918817922342" );
			fromPARAM.put( IExigenceConst.IUpdbm.IUpdbf.ORIGINATOR, "2" );
			fromPARAM.put("DZWLANBIZCODE", "00001");
			fromUpffxm = IUpdcfgFactory.getIUpdcpmSV().getSFUpffxmOffer("CSGSM_DZWLAN_NORMAL_MAPPING", "BIZCODE") ;
		    Object fromXML = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromUpffxm, fromPARAM, aContext);
		    if( log.isDebugEnabled() ) log.debug( fromXML );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketUpdfmx() throws Exception{
		try
		{
			if( log.isDebugEnabled() ) log.debug( IOVUpdfmxOffer.History.CREATE );
			for( int index = 0; index < IOVUpdfmxOffer.History.values().length; index++ ){
				if( log.isDebugEnabled() ) log.debug( IOVUpdfmxOffer.History.values()[index] );
			}
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( this, IOVUpdfmxOffer.History.FAILURE );
			if( log.isDebugEnabled() ) log.debug( fromUpdfmx.getORDER().getCREATOR() );
			
			switch( fromUpdfmx.getORDER().getCREATOR() ){
			   case CREATE:{
				       if( log.isDebugEnabled() ) log.debug( fromUpdfmx.getORDER().isCREATE() + "\t" + IOVUpdfmxOffer.History.CREATE );
			        }
			        break;
			   case DELETE:{
			       if( log.isDebugEnabled() ) log.debug( fromUpdfmx.getORDER().isDELETE() + "\t" + IOVUpdfmxOffer.History.DELETE );
		        }
		        break;
			   case HISTORY:{
			       if( log.isDebugEnabled() ) log.debug( fromUpdfmx.getORDER().isHISTORY() + "\t" + IOVUpdfmxOffer.History.HISTORY );
		        }
		        break;
			   case FAILURE:{
			       if( log.isDebugEnabled() ) log.debug( fromUpdfmx.getORDER().isFAILURE() + "\t" + IOVUpdfmxOffer.History.FAILURE );
		        }
		        break;
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketLatenImpl() throws Exception{
		try
		{
			IOVUpdfmxDestiny.HQSQLBottle _bottle = new IOVUpdfmxDestiny.HQSQLBottle();
			ISAEquipment __bottle = new ISAEquipment();
			__bottle.setPsId( 602101807261204l );
			__bottle.setComposite("NORMAL");
			__bottle.setRegionCode("202");
			__bottle.setOldPsParam( "45=1;B=1;c=1;39=1;W=1;G=1;K=1;O=1;" );
			__bottle.setPsParam("45=1;12=1;56=1;B=1;c=1;OCY=1;39=1;G=1;SOURCEID=1;K=1;REGIONID=211;O=1;OSSTATUS=00100000000000000000;sim=1;W=1;");
			__bottle.setStsToOld();
			__bottle.setPsStatus( 9 );
			_bottle.add( __bottle );
			
			__bottle = new ISAEquipment();
			__bottle.setPsId( 602101807261203l );
			__bottle.setComposite("NORMAL");
			__bottle.setRegionCode("202");
			__bottle.setOldPsParam( "45=1;B=1;c=1;39=1;W=1;G=1;K=1;O=1;" );
			__bottle.setPsParam("45=1;12=1;56=1;B=1;c=1;OCY=1;39=1;G=1;SOURCEID=1;K=1;REGIONID=211;O=1;OSSTATUS=00100000000000000000;sim=1;W=1;");
			__bottle.setPsStatus( 9 );
			__bottle.setStsToOld();
			__bottle.delete();
			_bottle.add( __bottle );
			
			__bottle = new ISAEquipment();
			__bottle.setPsId( 602101807261203l );
			__bottle.setRegionCode("202");
			__bottle.setComposite("NORMAL");
			__bottle.setStsToOld();
			__bottle.setPsServiceType("EPS_HSS");
			__bottle.setPsNetCode("EPS_HSS");
			_bottle.add( __bottle );
			
			if( log.isDebugEnabled() ) log.debug("-------------------------------------------");
			for( java.util.Iterator itera = _bottle.iterator(); itera.hasNext(); ){
				DataStructInterface fromEntity = (DataStructInterface)itera.next();
				String fromXML = ICustom.getAsXml( fromEntity );
				if( log.isDebugEnabled() ) log.debug( fromXML );
			}
			
			__bottle = new ISAEquipment();
			__bottle.setPsId( 602101807261203l );
			__bottle.setRegionCode("202");
			__bottle.setComposite("NORMAL");
			__bottle.setStsToOld();
			
			if( log.isDebugEnabled() ) log.debug("-------------------------------------------");
			ISAEquipment ___bottle = (ISAEquipment)_bottle.get( __bottle );
			if( log.isDebugEnabled() ) log.debug( ___bottle != null?ICustom.getAsXml( ___bottle ):"NULL");
			
			if( log.isDebugEnabled() ) log.debug("-------------------------------------------");
			java.util.ArrayList<DataStructInterface> _delete = new java.util.ArrayList<DataStructInterface>();
			_delete.add( __bottle );
			_bottle.removeAll( _delete );
			//_bottle.remove( __bottle );
			for( java.util.Iterator itera = _bottle.iterator(); itera.hasNext(); ){
				DataStructInterface fromEntity = (DataStructInterface)itera.next();
				String fromXML = ICustom.getAsXml( fromEntity );
				if( log.isDebugEnabled() ) log.debug( fromXML );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketCompete() throws Exception{
		try
		{
			Object fromUpffmx = UpfgsmUtils.IUpfsm.IIUpfsm._jj_splite("C", "C");
			if( log.isDebugEnabled() ) log.debug( fromUpffmx != null?fromUpffmx.toString():"NULL" );
			fromUpffmx = UpfgsmUtils.IUpfsm.IIUpfsm._jj_splite("E", "C");
			if( log.isDebugEnabled() ) log.debug( fromUpffmx != null?fromUpffmx.toString():"NULL" );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketMessage() throws Exception{
		try
		{
			SFCenterFactory.pushCenterInfo( IConfigDefine.getINSTANCE().getControl().getREGION_ID() );
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/test_jevalsale.lsxl");
			RocketFTextMessage fromRocket = new RocketFTextMessage(fromXML);
			if( log.isDebugEnabled() ) log.debug( fromRocket );
			java.util.Map fromJEVAL = new java.util.HashMap();
			XmlUtils.XPath( fromRocket.getText(), fromJEVAL );
			fromXML = XmlUtils.createGeneralXml("CustOrder", "UTF-8", fromJEVAL );
			if( log.isDebugEnabled() ) log.debug( fromXML );
			
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketException() throws Exception{
		try
		{
			UpfsvcManager.getMBean().beginTransaction();
			IOVMsgFExigence fromExigence = ICustom.getAsRocket( "com/ai/sacenter/receive/sacenter-gsm_hedjsale.xml" );
			SFCenterFactory.pushCenterInfo( fromExigence.getORDER().getROCKET().getREGION_ID() );
			try
			{
				IUpdcContext aContext = ClassUtils.getIContextImpl();
				/*IOVOrderPentium fromOrder = ICustom.getAsOrder( fromRocket );
				IOVTaskPentium fromTASK = ICustom.getAsTask( fromOrder );
				fromOrder.setBILL_ID("51951919");
				aContext.put( IUpdcConst.IUpdbm.IUpdbf.ORDER, fromOrder );
				aContext.put( IUpdcConst.IUpdbm.IUpdbf.TASK, fromTASK );
				fromTASK.setPLWK_CODING("IOS0012005");
				fromTASK.setDONE_RESULT("<InterBOSS><PLWK_CODING>10012</PLWK_CODING><PLWK_DESCRIBE>用户账号已占用</PLWK_DESCRIBE></InterBOSS>");
				SFException aEXCEPTION = UpdcUtils.ICustom.transferAsRespond(fromOrder, fromTASK, aContext);
				if( log.isDebugEnabled() ) log.debug( XmlUtils.IXml._format( aEXCEPTION.getAsXML() ) );
				
				IOVOfferPentium fromOfferHome = fromTASK.getORDER().getOFFER();
				JdomUtils.ICustom.wrap("JTDHMAINUSER=10061647900;JTDHMAINNO=13671508989;JTDHMAINIMSI=460027178435852", fromOfferHome.getORDER().getOFFER() );
				IOVUpdbpmOffice fromOfficeX = IUpfwmFactory.getIUpdcpmSV().getSFUpfwmOffice(fromOrder, 
						fromTASK, 
						aContext);
				if( log.isDebugEnabled() ) log.debug( XmlUtils.IXml._format( fromOfficeX.toString() ) );
				
				IOVUpdbpmOffer _subflow = new IOVUpdbpmOffer( fromOrder );
				ISystemTemplate.IUpdbpmOffer fromUpdbpm = fromTASK.getORDER().getSUBFLOW();
				UpdbpmUtils.ICustom._wrap( fromOrder, fromOfferHome, aContext );
				fromOfficeX = IUpdcFactory.getIUpdbpmSV().getSFUpdbpmOffice(fromOrder, fromUpdbpm, _subflow, aContext);
				if( log.isDebugEnabled() ) log.debug( XmlUtils.IXml._format( fromOfficeX.toString() ) );
				
				aContext.put( IUpdcConst.IUpdbm.IUpdbf.SEGMENT, fromOfficeX );
				String fromXML = UpfsvcManager.getMBean().getJEVAL().evaluate("#{SEGMENT.SUBFLOW.BILL_ID}", fromOfferHome.getORDER().getOFFER(), aContext );
				if( log.isDebugEnabled() ) log.debug( fromXML );*/
				
				/*测试验证配置[开通定单项异常]*/
				String aFILES[] = new String[]{"com/ai/sacenter/receive/sacenter-rabbit-sync.xml", 
						"com/ai/sacenter/receive/sacenter-rabbit-jtcl.xml",
						"com/ai/sacenter/receive/sacenter-rabbit-didchg.xml",
						"com/ai/sacenter/receive/sacenter-rabbit-didexp.xml"};
				/*IOS0011085 转失败 IOS0012002 转重做 IOS0000000 转历史*/
				/*com/ai/sacenter/receive/sacenter-rabbit-didchg.xml  RBGSM_ROCKET_ORDER_PROGRAM*/
				/*com/ai/sacenter/receive/sacenter-rabbit-jtcl.xml  CMKTC_ROCKET_COMPLETE_PROGRAM*/
				/*com/ai/sacenter/receive/sacenter-rabbit-sync.xml */
				CsfException _exception = new CsfException("csf1215", "服务<CUSTOM>已熔断");
				SFException aEXCEPTION = ExceptionFactory.getServiceCsf(_exception, "ShangHai_PBOSS");
				IOVMocketExigence fromRocket = ICustom.getAsExigence( "com/ai/sacenter/receive/sacenter-rabbit-didchg.xml" );
				IOVUpdcpmOffer fromUpdcpm = IExigenceFactory.getIUpdcpmSV().getSFUpfgkmComplete(fromRocket, aEXCEPTION, aContext);
				if( log.isDebugEnabled() ) log.debug( fromUpdcpm );
				
				fromRocket = ICustom.getAsExigence( "com/ai/sacenter/receive/sacenter-rabbit-jtcl.xml" );
				fromUpdcpm = IExigenceFactory.getIUpdcpmSV().getSFUpfgkmComplete(fromRocket, aEXCEPTION, aContext);
				if( log.isDebugEnabled() ) log.debug( fromUpdcpm );
				
				fromRocket = ICustom.getAsExigence( "com/ai/sacenter/receive/sacenter-rabbit-sync.xml" );
				fromUpdcpm = IExigenceFactory.getIUpdcpmSV().getSFUpfgkmComplete(fromRocket, aEXCEPTION, aContext);
				if( log.isDebugEnabled() ) log.debug( fromUpdcpm );
				
				/*for( int index = 0; index < aFILES.length; index++ ){
					IOVMocketExigence _rocket = ICustom.getAsExigence( aFILES[index] );
					fromUpdcpm = IExigenceFactory.getIUpdcpmSV().getSFUpfgkmComplete(_rocket, aEXCEPTION, aContext);
					if( log.isDebugEnabled() ) log.debug( fromUpdcpm.getPROGRAM().toString() );
				}*/
				
				
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketExplainImpl() throws Exception{
		try
		{
			UpfsvcManager.getMBean().beginTransaction();
			//IOVMsgFExigence fromExigence = ICustom.getAsRocket( "com/ai/sacenter/receive/sacenter-gsm_hedjsale.xml" );
			//SFCenterFactory.pushCenterInfo( fromExigence.getORDER().getROCKET().getREGION_ID() );
			try
			{
				//IUpdcContext aContext = ClassUtils.getIContextImpl();
				/*测试验证配置[开通定单项异常]*/
				/*IOS0011085 转失败 IOS0012002 转重做 IOS0000000 转历史*/
				/*com/ai/sacenter/receive/sacenter-rabbit-didchg.xml  RBGSM_ROCKET_ORDER_PROGRAM*/
				/*com/ai/sacenter/receive/sacenter-rabbit-jtcl.xml  CMKTC_ROCKET_COMPLETE_PROGRAM*/
				/*com/ai/sacenter/receive/sacenter-rabbit-sync.xml */
				
				String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-gsm_hedjsale.xml");
				RocketFMessage fromRocket = new RocketFTextMessage( fromXML );
				IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
				//IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			UpfsvcManager.forceMBean();
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketTransaction() throws Exception{
		try
		{
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				UpfsvcManager.getMBean().beginTransaction();
				try
				{
					java.sql.Timestamp _create = new java.sql.Timestamp( System.currentTimeMillis() );
					if( TimeUtils.yyyy( _create ) == 2018 ){
						throw new java.lang.Exception();
					}
					UpfsvcManager.getMBean().commitTransaction();
				}
				catch( java.lang.Exception exception ){
					log.error( exception.getMessage(), exception );
					UpfsvcManager.getMBean().rollbackTransaction();
				}
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
			}
			finally{
				
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketDiction() throws Exception{
		try
		{
			MBeanDelegate fromUpdbfmx = new MBeanDelegate();
			if( log.isDebugEnabled() ) log.debug( fromUpdbfmx );
			String __string__ = JSONUtils.fromBean( fromUpdbfmx );
			if( log.isDebugEnabled() ) log.debug("AAA:" + JSONUtils.IJson.isJSONString( __string__ ) );
			
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketVantage() throws Exception{
		try
		{
			SFCenterFactory.pushCenterInfo( SHRocketConst.ICustom.REGION_ID );
			UpfsvcVantage.IUpdfmxCustom _custom = UpfsvcManager.getRocket().getIUpfxCustom();
			if( log.isDebugEnabled() ) log.debug( _custom );
			_custom = UpfsvcManager.getRocket().getIUpfxCustom();
			if( log.isDebugEnabled() ) log.debug( _custom );
			UpfsvcManager.getRocket().beginTransaction();
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = UpfsvcManager.getRocket().getDeque();
				if( log.isDebugEnabled() ) log.debug("AAA1:" + _deque );
				UpfsvcManager.getRocket().getDeque().getMotion().put("CLIP", "C");
				UpfsvcManager.getRocket().getDeque().getSubFlow().put("MBELL", "C");
				if( log.isDebugEnabled() ) log.debug( UpfsvcManager.getRocket().getDeque().getMotion() );
				if( log.isDebugEnabled() ) log.debug( UpfsvcManager.getRocket().getDeque().getSubFlow() );
				UpfsvcManager.getRocket().beginTransaction( null, new java.util.HashMap(), ClassUtils.getIContextImpl() );
				try
				{
					_deque = UpfsvcManager.getRocket().getTransaction();
					if( log.isDebugEnabled() ) log.debug("AAA2:" + _deque );
					if( log.isDebugEnabled() ) log.debug( UpfsvcManager.getRocket().getDeque().getMotion() );
					if( log.isDebugEnabled() ) log.debug( UpfsvcManager.getRocket().getDeque().getSubFlow() );
					String fromXML = UpfsvcManager.getRocket().getDeque().getJEVAL().evaluate("#{MBELL} == 'C'");
					if( log.isDebugEnabled() ) log.debug("AAA2:" + fromXML );
					if( log.isDebugEnabled() ) log.debug( UpfsvcManager.getRocket().getDeque().getMotion() );
					if( log.isDebugEnabled() ) log.debug( UpfsvcManager.getRocket().getDeque().getSubFlow() );
					UpfsvcManager.getRocket().commitTransaction();
				}
				catch( java.lang.Exception exception ){
					log.error( exception.getMessage(), exception );
					UpfsvcManager.getRocket().rollbackTransaction();
				}
				UpfsvcManager.getRocket().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getRocket().rollbackTransaction();
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			UpfsvcManager.finishMBean();
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketScript() throws Exception{
		try
		{
			java.util.Map _bundle = new java.util.HashMap();
			_bundle.put( "REGION_ID", "200");
			_bundle.put( "USER_ID"  , new Long( System.currentTimeMillis() ) );
			_bundle.put( "PARAM", new java.util.HashMap() );
			((java.util.Map)_bundle.get( "PARAM" ) ).put("MBELL", "C");
			((java.util.Map)_bundle.get( "PARAM" ) ).put("VOLTE", "C");
			((java.util.Map)_bundle.get( "PARAM" ) ).put("AsName", Boolean.TRUE );
			if( log.isDebugEnabled() ) log.debug( JSONUtils.fromBean( _bundle ) );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testJtclCeaseImpl() throws Exception{
		try
		{
			SFCenterFactory.pushCenterInfo("200");
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-jtcl-ceasesale.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketAddRGsmImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket-addrgsm.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketAddRDidImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket-addrdid.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketDelRDidImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket-delrdid.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketZxddtgImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket_zxddtg.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketSpjktcgImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket_spjktcg.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketChgMGsmImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket-chgmgsm.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketChgJtRhtxImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket-chgrjtyw.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketQYAPAddrgsmImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-qyapn-addrgsm.xml");
			RocketFMessage fromRocket = new RocketFTextMessage( fromXML );
			RocketFRsRspMessage fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsRsp );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketRGsmAddImpl() throws Exception{
		try
		{
			SFCenterFactory.pushCenterInfo("200");
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-gsm-newsale.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			RocketFRsRspMessage fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsRsp );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketRsjyhAGrpImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket-addrgrp.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testMocketReceiveImpl() throws Exception{
		try
		{
			class SFMocketTfImpl{
				public SFMocketTfImpl(){
					super();
				}
				
				/**
				 * 
				 * @throws Exception
				 */
				public void testMocketTfImpl() throws Exception{
					try
					{
						String fromXML[] = new String[]{/*"com/ai/sacenter/receive/sacenter-rabbit-sync.xml", 
								"com/ai/sacenter/receive/sacenter-rabbit-jtcl.xml",
								"com/ai/sacenter/receive/sacenter-rabbit-didchg.xml",
								"com/ai/sacenter/receive/sacenter-rabbit-didexp.xml",*/
								"com/ai/sacenter/receive/sacenter-rabbit-yunmas.xml",
								/*"com/ai/sacenter/receive/sacenter-rabbit-centrex.xml",*/
								"com/ai/sacenter/receive/sacenter-rabbit-addmjtcl.xml"
								};
						for( int index = 0; fromXML != null && index < fromXML.length; index++ ){
							RocketFMessage fromRocket = new RocketFTextMessage( ICustom.getAsXml( fromXML[index] ) );
							IUpdbfsFactory.getIUpdcSV().rabbitReceiveAsyn( fromRocket );
						}
					}
					finally{
						
					}
				}
			}
			SFMocketTfImpl fromBocketImpl = new SFMocketTfImpl();
			try
			{
				for( int index = 0; index < 5; index++ ){
					fromBocketImpl.testMocketTfImpl();
					Thread.sleep( 1000 );
				}
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
			}
			finally{
				if( fromBocketImpl != null ){ fromBocketImpl = null; }
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testMocketEchoImpl() throws Exception{
		try
		{
			/*
			 * sacenter-rabbit-didchg.xml   172000010170/192110004278/RBGSM_ROCKET_ORDER_PROGRAM
             * sacenter-rabbit-didexp.xml   172000010010/192310004278/CMKTC_ROCKET_COMPLETE_PROGRAM
             * sacenter-rabbit-jtcl.xml     172000010027/192000010262/
             * sacenter-rabbit-sync.xml     171000000001/191000000001/
             * sacenter-rabbit-centrex.xml  172000010061/192000010601/RBGSM_ROCKET_ORDER_PROGRAM
             * sacenter-rabbit-explain.xml  171000000001/191000000001/191000000004
             * sacenter-rabbit-delrgsm.xml  172000010170/192110029531
             * sacenter-rabbit-expire.xml   172000010170/191001002001
             * sacenter-rabbit-addmjtcl.xml 172000010027/192100000225
             * sacenter-rabbit-osstatus.xml 171000000001/191000000188
             * sacenter-rabbit-yunmas.xml   172000010371/390000214476
			 */
			IUpfgkmCityHome fromCityHome = ICustom.getRabbitAsRemote( "com/ai/sacenter/receive/sacenter-rabbit-jtcl.xml" );
			SFCenterFactory.pushCenterInfo( fromCityHome.getREGION_ID() );
			try
			{
				MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
				fromMBean.setREPOSITORY( IExigenceConst.IUpdbm.IRemoteDAO );
				fromMBean.setREGION_ID ( fromCityHome.getREGION_ID     () );
				for( java.util.Iterator<IOVMocketExigence> itera = fromCityHome.getCOMPLETE().iterator(); itera.hasNext(); ){
					IOVMocketExigence __mocket__ = (IOVMocketExigence)itera.next();
					__mocket__.getINSTANCE().setStsToOld();
					//__mocket__.setSTATE( IUpdbfsConst.IState.H );
					for( java.util.Iterator<IOVMocketOffer> iterap = __mocket__.getORDER().getORDER().iterator(); itera.hasNext();){
						IOVMocketOffer __mocketx__ = (IOVMocketOffer)iterap.next();
						__mocketx__.getINSTANCE().setStsToOld();
					}
				}
				ExigenceFactory.getIUpdcSV().rocketReceiveAsyn(fromMBean, 
						fromCityHome, 
						new java.util.HashMap() );
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testMocketSyncImpl() throws Exception{
		try
		{
			TfFrameWork.main(new String[]{ "KTCENTER_ROCKET_SYNC_ALL", "1", "0" });
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testMocketCustomImpl() throws Exception{
		try
		{
			/*
			 * sacenter-rabbit-didchg.xml   172000010170/192110004278/RBGSM_ROCKET_ORDER_PROGRAM
             * sacenter-rabbit-didexp.xml   172000010010/192310004278/CMKTC_ROCKET_COMPLETE_PROGRAM
             * sacenter-rabbit-jtcl.xml     172000010027/192000010262/
             * sacenter-rabbit-sync.xml     171000000001/191000000001/
             * sacenter-rabbit-centrex.xml  172000010061/192000010601/RBGSM_ROCKET_ORDER_PROGRAM
             * sacenter-rabbit-explain.xml  171000000001/191000000001/191000000004
             * sacenter-rabbit-delrgsm.xml  172000010170/192110029531
             * sacenter-rabbit-expire.xml   172000010170/191001002001
             * sacenter-rabbit-addmjtcl.xml 172000010027/192100000225
             * sacenter-rabbit-osstatus.xml 171000000001/191000000188
             * sacenter-rabbit-yunmas.xml   172000010371/390000214476
			 */
			IOVMocketExigence __rocket__ = ICustom.getMocketAsRemote( "com/ai/sacenter/receive/sacenter-rabbit-addmjtcl.xml" );
			SFCenterFactory.pushCenterInfo( __rocket__.getREGION_ID() );
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				if( log.isDebugEnabled() ) log.debug( __rocket__.getORDER().getCOMPLETE() );
				LogicConnection __connection__ = (LogicConnection)OracleUtils.getTransaction( "cmkt11" );
				if( log.isDebugEnabled() ) log.debug( __connection__ );
				if( log.isDebugEnabled() ) log.debug( __connection__.getPhysicalConnection() );
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
			}
			finally{
				SFCenterFactory.popCenterInfo();
			}
			
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testOrderReceiveImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-order-addrgsm.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage( fromXML );
			RocketFRsRspMessage fromRsBody = IUpdbfsFactory.getIUpdcSV().orderReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsBody );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testOrderReceiveAsynImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-order-addrgsm.xml");
			RocketFMessage fromRocket = new RocketFTextMessage( fromXML );
			//((RocketFMapMessage)fromRocket).getMapMessage().put("XmlBusi", fromXML );
			IUpdbfsFactory.getIUpdcSV().orderReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketReceiveImpl() throws Exception{
		try
		{
			/**
			 * 物理网测试案例
			 *     用户停机 com/ai/sacenter/receive/sacenter-rocket-osstatus.xml  
			 * 手机测试案例  
			 *     其他测试 com/ai/sacenter/receive/sacenter-rocket-expire.xml
			 *     用户新装 com/ai/sacenter/receive/sacenter-gsm-newsale.xml
			 *     GPRS暂停 com/ai/sacenter/receive/sacenter-rocket-grpsst.xml
			 *     用户停机 com/ai/sacenter/receive/sacenter-gsm_osschange.xml
			 *             com/ai/sacenter/receive/sacenter-rocket-osstatus.xml
			 *     到期产品 com/ai/sacenter/receive/sacenter-rocket-custom.xml
			 *     扣费提醒 com/ai/sacenter/receive/sacenter-rocket-charge.xml
			 *     单元测试 com/ai/sacenter/receive/sacenter-rocket-junittest.xml
			 * 家庭短号案例
			 *     家庭组网 com/ai/sacenter/receive/sacenter-rocket-jtdhzw.xml
			 * 集团彩铃案例  
			 *     成员添加 com/ai/sacenter/receive/sacenter-rocket-addmjtcl.xml
			 *     集团销户 com/ai/sacenter/receive/sacenter-jtcl-ceasesale.xml
			 * 融合通信案例 
			 *     手机添加 com/ai/sacenter/receive/sacenter-rocket-addrgsm.xml
			 *     DID添加  com/ai/sacenter/receive/sacenter-rocket-addrdid.xml
			 *     DID删除  com/ai/sacenter/receive/sacenter-rocket-delrdid.xml
			 *     DID补充  com/ai/sacenter/receive/sacenter-rocket-rdidbyw.xml
			 *     功能变更 com/ai/sacenter/receive/sacenter-rocket-chgrjtyw.xml
			 *     短号变更 com/ai/sacenter/receive/sacenter-rocket-chgmgsm.xml
			 * 异常测试案例
			 *     DID异常  com/ai/sacenter/receive/sacenter-rocket-addrdip.xml
			 */
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket-addrdip.xml");
			RocketFMessage fromRocket = new RocketFTextMessage( fromXML );
			if( log.isDebugEnabled() ) log.debug( fromRocket );
			RocketFRsRspMessage fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsRsp );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketReceiveAsynImpl() throws Exception{
		try
		{
			/**
			 * 物理网测试案例
			 *     用户停机 com/ai/sacenter/receive/sacenter-rocket-osstatus.xml  
			 * 手机测试案例  
			 *     其他测试 com/ai/sacenter/receive/sacenter-rocket-expire.xml
			 *     用户新装 com/ai/sacenter/receive/sacenter-gsm-newsale.xml
			 *     GPRS暂停 com/ai/sacenter/receive/sacenter-rocket-grpsst.xml
			 *     用户停机 com/ai/sacenter/receive/sacenter-gsm_osschange.xml
			 *             com/ai/sacenter/receive/sacenter-rocket-osstatus.xml
			 *     到期产品 com/ai/sacenter/receive/sacenter-rocket-custom.xml
			 *     扣费提醒 com/ai/sacenter/receive/sacenter-rocket-charge.xml
			 *     单元测试 com/ai/sacenter/receive/sacenter-rocket-junittest.xml
			 * 家庭短号案例
			 *     家庭组网 com/ai/sacenter/receive/sacenter-rocket-jtdhzw.xml
			 * 集团彩铃案例  
			 *     成员添加 com/ai/sacenter/receive/sacenter-rocket-addmjtcl.xml
			 *     集团销户 com/ai/sacenter/receive/sacenter-jtcl-ceasesale.xml
			 * 融合通信案例 
			 *     手机添加 com/ai/sacenter/receive/sacenter-rocket-addrgsm.xml
			 *     DID添加  com/ai/sacenter/receive/sacenter-rocket-addrdid.xml
			 *     DID删除  com/ai/sacenter/receive/sacenter-rocket-delrdid.xml
			 *     DID补充  com/ai/sacenter/receive/sacenter-rocket-rdidbyw.xml
			 *     功能变更 com/ai/sacenter/receive/sacenter-rocket-chgrjtyw.xml
			 *     短号变更 com/ai/sacenter/receive/sacenter-rocket-chgmgsm.xml
			 * 固网宽带案例
			 *     宽带测试 com/ai/sacenter/receive/sacenter-centerx-req.xml
			 * SIP专线直拨
			 *     测试案例 com/ai/sacenter/receive/sacenter-rocket-sipdidhm.xml
			 * 异常测试案例
			 *     DID异常  com/ai/sacenter/receive/sacenter-rocket-addrdip.xml
			 */
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-rocket-addrgsm.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage( fromXML );
			IUpdbfsFactory.getIUpdcSV().rocketReceiveAsyn( fromRocket );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketOsStatusImpl() throws Exception{
		try
		{
			/**
			 * com/ai/sacenter/receive/sacenter-rocket-expire.xml
			 * com/ai/sacenter/receive/sacenter-gsm-newsale.xml
			 * com/ai/sacenter/receive/sacenter-rocket-osstatus.xml
			 */
			IOVMsgFRequest fromRequest = ICustom.getAsNature( "com/ai/sacenter/receive/sacenter-gsm-newsale.xml" );
			IUpfgkmOfferHome fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRequest );
			IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromRequest.getUSER_ID() );
			IOVMsgFOffer fromOrdOffer[] = fromMsgFUser.getOrdOffer( 380000180405l );
			IOVUser fromUser = CustomUtils.ICustom._wrap( fromMsgFUser, new IOVUser() );
			CarbonList<IOVUserCentrex> _order = new CarbonList<IOVUserCentrex>();
			for( int index = 0; index < fromOrdOffer.length; index++ ){
				IOVUserOrder fromOffer = CustomUtils.ICustom._wrap(fromOrdOffer[index], new IOVUserOrder() );
				IOVUserCentrex fromCabinet = _order.get( fromOffer );
				if( log.isDebugEnabled() ) log.debug( fromCabinet );
				if( fromCabinet == null ){ _order.add( fromCabinet = new IOVUserCentrex( fromOffer ) ); }
				fromCabinet.getCENTREX().add( fromOffer );
			}
			for( int index = 0; index < fromOrdOffer.length; index++ ){
				IOVUserOrder fromOffer = CustomUtils.ICustom._wrap(fromOrdOffer[index], new IOVUserOrder() );
				IOVUserCentrex fromCabinet = _order.get( fromOffer );
				if( log.isDebugEnabled() ) log.debug( fromCabinet );
				if( fromCabinet == null ){ _order.add( fromCabinet = new IOVUserCentrex() ); }
				fromCabinet.getCENTREX().add( fromOffer );
			}
			/*fromMsgFUser.setOS_STATUS( "0000000000000000000000000000000000000000000000000000000000000000" );
			fromMsgFUser.setPRE_OS_STATUS("0000010000000000000000000000000000000000000000000000000000000000");
			IOVOrderUser fromOrdUser = UpdbfsUtils.ICustom._subject(fromRequest, fromMsgFUser, fromUpdcpm);
			fromOrdUser.getNATURE().clear();
			IOrderFactory.getIOrdMixSV().finishSFOsStatusTrail(fromRequest, 
					fromMsgFUser, 
					fromOrdUser);
			if( log.isDebugEnabled() ) log.debug( fromOrdUser );*/
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketCustomImpl() throws Exception{
		try
		{
			class SFUpffxUserImpl{
				public SFUpffxUserImpl(){
					super();
				}
				
				/**
				 * 
				 * @throws Exception
				 */
				public void testUpffxRocket( IOVMsgFRequest fromRequest ) throws Exception{
					try
					{
						String _xml = "<InterBOSS><BizRsp><RspCode>0000</RspCode><RspDesc>成功</RspDesc><RspBody><CLIP>1</CLIP></RspBody></BizRsp></InterBOSS>";
						org.dom4j.Element _root = XmlUtils.parseXml( _xml );
						java.util.Map<Object, Object> _bundle = null;
						_bundle = RocketUtils.IMetaX._jj_map( _root, "BizRsp", true );
						if( log.isDebugEnabled() ) log.debug( _bundle );
						java.util.List<org.dom4j.Element> _list = RocketUtils.IMetaX._jj_list(_root, "BizRsp");
						if( log.isDebugEnabled() ) log.debug( _list );
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @param fromUpdcpm
				 * @throws Exception
				 */
				public void testUpffxCentrex( IOVMsgFExigence fromRequest, IUpfgkmOfferHome fromUpdcpm ) throws Exception{
					try
					{
						IOVUpffmxRequest fromUpffmx = new IOVUpffmxRequest( fromRequest );
						IOVMsgFExigence.IMsgFOfferXHome fromOrderHome = fromRequest.getORDER();
						UpdbfsUtils.ICustom._wrap(fromOrderHome.getROCKET(), fromUpffmx, fromUpdcpm);
						if( log.isDebugEnabled() ) log.debug("PLATFORM:" + fromUpffmx.getPLATFORM().getPLATFORM() );
						for( java.util.Iterator<IOVMsgFOrderBase> itera = fromOrderHome.getORDER().iterator(); itera.hasNext(); ){
							IOVRocketExigence fromOrder = itera.next();
							IOVOrderRequest request = UpdbfsUtils.ICustom._wrap(fromOrder, fromUpdcpm);
							fromUpffmx.getUSER().beginTransaction( request, fromUpffmx.getCENTREX(), fromUpdcpm);
							try
							{
								if( log.isDebugEnabled() ) log.debug("CENTREX:" + fromUpffmx.getUSER().getUSER().getPLATFORM() );
								fromUpffmx.getUSER().commitTransaction();
							}
							catch( java.lang.Exception exception ){
								fromUpffmx.getUSER().rollbackTransaction();
								throw exception;
							}
							finally{
								
							}
						}
						if( log.isDebugEnabled() ) log.debug("CENTREX:" + fromUpffmx.getCENTREX() );
						for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getCENTREX().getORDER().iterator(); itera.hasNext(); ){
							IOVUpffmxConsult consult = itera.next();
							if( log.isDebugEnabled() ) log.debug("CENTREX:" + consult.getPLATFORM() );
						}
					}
					finally{
						
					}
				}
				
				public void testUpffxCache( IOVMsgFRequest fromRequest ) throws Exception{
					try
					{
						ISystemTemplate.ICenterRoute fromRoute = CenterUtils.ICustom.getCenterByRegionId("201");
						if( log.isDebugEnabled() ) log.debug( fromRoute );
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @throws Exception
				 */
				public void testUpffxCustomImpl( ) throws Exception{
					try
					{
						String fromXML[] = new String[]{"com/ai/sacenter/receive/sacenter-rocket-junittest.xml",
								"com/ai/sacenter/receive/sacenter-rocket-junittstd.xml",
								"com/ai/sacenter/receive/sacenter-rocket-junittstt.xml",
								"com/ai/sacenter/receive/sacenter-rocket-expire.xml",
								"com/ai/sacenter/receive/sacenter-rocket-addmjtcl.xml"};
						for( int index = 0; fromXML != null && index < fromXML.length; index++ ){
							IOVMsgFRequest fromRequest = ICustom.getAsNature( fromXML[index] );
							IOrderFactory.getICustomSV().finishSFCentrexUser( fromRequest );
						}
						
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @throws Exception
				 */
				public void testUpffxOracle( String _owner ) throws Exception{
					try
					{
						IUpffxOracle fromUpffx = new IUpffxOracle();
						String table[] = new String[]{/*"SA_EXPIRE", "SA_EXPIRE_FAIL", "SA_EXPIRE_H", "SA_EXPIRE_SP", "SA_EXPIRE_SP_H",
								"ISA_DSMP_ORDER", "ISA_DSMP_ORDER_H", "ISA_DSMP_STATUS", "ISA_DSMP_STATUS_H",
								"SA_TARGET", "SA_TARGET_FAIL", "SA_TARGET_H", "SA_ORDER", "SA_ORDER_FAIL", "SA_ORDER_H",*/
								/*"SA_OFFER", "SA_OFFER_FAIL", "SA_OFFER_H", "SA_TASK", "SA_TASK_FAIL", "SA_TASK_H",
								"SA_QUEUE", "SA_QUEUE_FAIL", "SA_QUEUE_H", "SA_SUGGEST", "SA_SUGGEST_FAIL", "SA_SUGGEST_H",
								"SA_WORKORDER", "SA_WORKORDER_FAIL", "SA_WORKORDER_H", "ISA_NOTIFY", "ISA_NOTIFY_FAIL", "ISA_NOTIFY_H",
								"ISA_PROVISION", "ISA_PROVISION_BUFF", "ISA_PROVISION_FAIL", "ISA_PROVISION_H", "ISA_PROVISION_RESET",
								"ISA_UATMIX_H", "ISA_EQUIPMENT", "ISA_RADIUS_INDEX", "ISA_RADIUS_H", "ISA_MCAS_INDEX", "ISA_MCAS_H",
								"ISA_BRAND_CHG", "ISA_BRAND_CHG_H", "ISA_MISC_STATUS", "ISA_MISC_STATUS_H",
								"ISA_ROCKET", "ISA_ROCKET_FAIL", "ISA_ROCKET_H", "ISA_ROCKETX", "ISA_ROCKETX_FAIL", "ISA_ROCKETX_H",*/"{ISA_EQUIPMENT}" };
						for( int index = 0; index < table.length; index++ ){
							HQSQLTable _table = HQSQLUtils.getSYBASETable( "cmkt11", table[index] );
							HQSQLTable _oracle = HQSQLUtils.getOracleTable(_owner, table[index] );
							for( java.util.Iterator itera = _table.getProperties().values().iterator(); itera.hasNext(); ){
								HQSQLTable.HQSQLColumn column = (HQSQLTable.HQSQLColumn)itera.next();
								HQSQLTable.HQSQLColumn _column = _oracle != null?_oracle.getProperty( column.getName() ):null;
								fromUpffx.getTable( _table.getMapingEnty(), column.getName() ).add( column );
								if( _column != null ){ fromUpffx.getTable( _table.getMapingEnty(), column.getName() ).add( _column ); }
								/*if( _column == null ){
									fromUpffx.getTable( _table.getTable() ).add( column );
								}
								else if( column.isASTDate() && _column.isASTDate() ){
									
								}
								else if( column.getSize() != _column.getSize() ){
									fromUpffx.getTable( _table.getTable() ).add( column );
									fromUpffx.getTable( _table.getTable() ).add( _column );
								}*/
							}
						}
						String _xml = XmlUtils.createGeneralXml( "ucmframe", fromUpffx._table );
						EncryptUtils.ICustom.userlog("ucmframe", _xml );
					}
					finally{
						
					}
				}
				
				public void testUpffxCustom() throws Exception{
					try
					{
						Object _object = ClassUtils.IClass.transfer(new java.lang.Boolean(true), java.lang.Boolean.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						_object = ClassUtils.IClass.transfer("N", java.lang.Boolean.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						_object = ClassUtils.IClass.transfer( new java.lang.Long( 1000l ), java.lang.Boolean.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						_object = ClassUtils.IClass.transfer( "A", java.lang.Character.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						
						_object = ClassUtils.IClass.transfer( new java.util.Date(), java.sql.Date.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						_object = ClassUtils.IClass.transfer( new java.util.Date(), java.sql.Time.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						_object = ClassUtils.IClass.transfer( new java.util.Date(), java.sql.Timestamp.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						
						Object _map = new java.util.HashMap();
						((java.util.HashMap)_map).put("CLIP", "C");
						((java.util.HashMap)_map).put("MBELL", "C");
						_object = ClassUtils.IClass.transfer( _map, java.util.Map.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						
						_object = ClassUtils.IClass.transfer( _map, java.util.HashMap.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						
						_object = ClassUtils.IClass.transfer( _map, java.util.TreeMap.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						
						_object = net.sf.json.JSONObject.fromObject( _map );
						_object = ClassUtils.IClass.transfer( _object, java.util.Map.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						
						java.lang.Byte[] _byte = new java.lang.Byte[]{1};
						_object = ClassUtils.IClass.transfer( _byte, java.lang.Byte.class );
						if( log.isDebugEnabled() ) log.debug( _object == null?"NULL":(_object.getClass() + "\t" + _object ) );
						
						HQSQLTable.HQSQLColumn _column = new HQSQLTable.HQSQLColumn();
						_column.setJavaType( java.lang.Byte[].class );
						if( log.isDebugEnabled() ) log.debug( "AAA:" + _column.isASTDigital() );
					}
					finally{
						
					}
				}
				
				public void testUpffxMySQL() throws Exception{
					try
					{
						ObjectType fromTYPE = ISAEquipment.S_TYPE;
						if( log.isDebugEnabled() ) log.debug( fromTYPE );
						if( log.isDebugEnabled() ) log.debug( "owner:" + fromTYPE.getDataSource() );
						if( log.isDebugEnabled() ) log.debug( "name:" + fromTYPE.getName() );
						if( log.isDebugEnabled() ) log.debug( "entity:" + fromTYPE.getMapingEnty() );
						if( log.isDebugEnabled() ) log.debug( "bottle:" + fromTYPE.getFullName() );
						
						HQSQLTable _table = HQSQLUtils.getSYBASETable( "cmkt11", fromTYPE.getMapingEnty() );
						if( log.isDebugEnabled() ) log.debug( "owner:" + _table.getDataSource() );
						if( log.isDebugEnabled() ) log.debug( "name:" + _table.getName() );
						if( log.isDebugEnabled() ) log.debug( "entity:" + _table.getMapingEnty() );
						if( log.isDebugEnabled() ) log.debug( "bottle:" + _table.getFullName() );
						
					}
					finally{
						
					}
				}
				
				public void testUpffxData( ) throws SFException,Exception{
					try
					{
						/*Object _region_id = new SAExpire();
						((DataContainer)_region_id).set("BILL_ID", "13818359940");
						((DataContainer)_region_id).set("REGION_ID", "203");
						((DataContainer)_region_id).set("USER_ID", new Long( System.currentTimeMillis() ) );*/
						Object _region_id = new HQSQLEntityBean();
						((DataStructInterface)_region_id).set( ISAExpire.S_BillId  , "18217179890");
						((DataStructInterface)_region_id).set( ISAExpire.S_RegionId, "208" );
						((DataStructInterface)_region_id).set( ISAExpire.S_UserId  , new Long( System.currentTimeMillis() ) );
						String aTransactionName = OracleUtils.getTransactionName( ICustom.IRemoteDAO, _region_id );
						if( log.isDebugEnabled() ) log.debug( "SUBFLOW[REGION_ID = " + JSONUtils.fromBean( _region_id ) + "] = " + aTransactionName );
					}
					finally{
						
					}
				}
				
				public void testUpffxJson() throws SFException,Exception{
					try
					{
						java.util.List _productorders = new java.util.ArrayList();
						
						java.util.Map _productorderinfo = new java.util.HashMap();
						_productorderinfo.put("ProductOrderNumber", "0001611022355707040");
						_productorderinfo.put("ProductID", "9000916550");
						_productorderinfo.put("ProductSpecNumber", "5000202");
						_productorderinfo.put("ServiceLevelID", "1");
						java.util.List _productordercharge = new java.util.ArrayList();
						_productorderinfo.put("ProductOrderCharge", _productordercharge );
						_productordercharge.add( new java.util.HashMap() );
						((java.util.Map)_productordercharge.get( _productordercharge.size() - 1 ) ).put("ProductOrderChargeCode", "1063");
						((java.util.Map)_productordercharge.get( _productordercharge.size() - 1 ) ).put("ProductOrderChargeValue", "3");
						_productordercharge.add( new java.util.HashMap() );
						((java.util.Map)_productordercharge.get( _productordercharge.size() - 1 ) ).put("ProductOrderChargeCode", "08");
						((java.util.Map)_productordercharge.get( _productordercharge.size() - 1 ) ).put("ProductOrderChargeValue", "38");
						_productorders.add( _productorderinfo );
						
						_productorderinfo = new java.util.HashMap();
						_productorderinfo.put("ProductOrderNumber", "0001611022355707037");
						_productorderinfo.put("ProductID", "9000916547");
						_productorderinfo.put("ProductSpecNumber", "5000202");
						_productorderinfo.put("ServiceLevelID", "1");
						_productordercharge = new java.util.ArrayList();
						_productorderinfo.put("ProductOrderCharge", _productordercharge );
						_productordercharge.add( new java.util.HashMap() );
						((java.util.Map)_productordercharge.get( _productordercharge.size() - 1 ) ).put("ProductOrderChargeCode", "1063");
						((java.util.Map)_productordercharge.get( _productordercharge.size() - 1 ) ).put("ProductOrderChargeValue", "3");
						_productordercharge.add( new java.util.HashMap() );
						((java.util.Map)_productordercharge.get( _productordercharge.size() - 1 ) ).put("ProductOrderChargeCode", "08");
						((java.util.Map)_productordercharge.get( _productordercharge.size() - 1 ) ).put("ProductOrderChargeValue", "35");
						_productorders.add( _productorderinfo );
						
						if( log.isDebugEnabled() ) log.debug( "SUBFLOW[REGION_ID = NULL] = " + JSONUtils.fromBean( _productorders ) );
					}
					finally{
						
					}
				
				}
				
				public IUpffxOracle getUpffxOracle(){
					return new IUpffxOracle();
				}
				
				class IUpffxOracle{
					java.util.HashMap _table = new java.util.HashMap();
					public IUpffxOracle(){
						super();
					}
					
					/**
					 * 
					 * @param table
					 * @return
					 */
					public java.util.List getTable( String table ){
						CarbonList tables = null;
						if( _table.get( table ) == null ){
							_table.put( table, new java.util.HashMap() );
							((java.util.Map)_table.get( table )).put( "column", tables = new CarbonList() );
						}
						else{
							tables = (CarbonList)((java.util.Map)_table.get( table )).get( "column" ); 
						}
						return tables;
					}
					
					/**
					 * 
					 * @param table
					 * @return
					 */
					public java.util.List getTable( String table, String column ){
						CarbonList tables = null;
						java.util.HashMap _tables = (java.util.HashMap)_table.get( table );
						if( _tables == null ){
							_table.put( table, _tables = new java.util.HashMap() );
							java.util.HashMap ___tables = new java.util.HashMap();
							___tables.put("column", tables = new CarbonList() );
							_tables.put( new Column( column ), ___tables );
						}
						else{
							Column _column = new Column( column );
							java.util.HashMap ___tables = (java.util.HashMap)_tables.get( _column );
							if( ___tables != null ){
								tables = (CarbonList)___tables.get("column");
							}
							else{
								___tables = new java.util.HashMap();
								___tables.put("column", tables = new CarbonList() );
								_tables.put( _column, ___tables ); 
							}
						}
						return tables;
					}
				}
				
			}
			SFUpffxUserImpl fromUpffxImpl = new SFUpffxUserImpl();
			SFCenterFactory.pushCenterInfo("200");
			UpfsvcManager.getMBean().beginTransaction();
			try
			{
				fromUpffxImpl.testUpffxCustomImpl();
				/*java.sql.Connection _connection_ = ServiceManager.getSession().getConnection("cmkt11");
				if( log.isDebugEnabled() ) log.debug( ((IConnectionDataSource)_connection_).getDataSource() );
				IUpdcContext aContext = ClassUtils.getIContextImpl();
				IOVMsgFRequest fromRequest = ICustom.getAsNature( "com/ai/sacenter/receive/sacenter-rocket-addrdid.xml" );
				IOVMsgFUser fromMsgFGroup = fromRequest.getUSER( fromRequest.getUSER_ID() );
				IOVMsgFUser fromMsgFUser = fromRequest.getMEMBER()[0];
				IOVOrderUser fromGroup = ICustom.getAsOrdUser( fromRequest, fromMsgFGroup );
				IOVOrderUser fromOrdUser = ICustom.getAsOrdUser( fromRequest, fromMsgFUser );
				aContext.put( IUpdcConst.IUpdbm.IUpdbf.GROUP, fromGroup   );
				aContext.put( IUpdcConst.IUpdbm.IUpdbf.USER , fromOrdUser );
				String __lsxl__ [] = new String[]{"USER.BILL_ID",
						"USER.NATURE.200000000000006.ATTR_VALUE",
						"USER.CUSTOM.CUST_CODE","USER.CUSTOM.NATURE.bindingKDTinst.ATTR_VALUE",
						"USER.PRODUCTION[COMPETE=270000080240].FEATURE[COMPETE=260000000054].ATTR_VALUE",
						
						"GROUP.BILL_ID",
						"GROUP.NATURE.200000000000006.ATTR_VALUE",
						"GROUP.CUSTOM.CUST_CODE",
						"GROUP.CUSTOM.NATURE.PARTY_ID.ATTR_VALUE",
						"GROUP.PRODUCTION[COMPETE=270000090590].FEATURE[COMPETE=390020005911].ATTR_VALUE"};
				for(int index = 0; __lsxl__ != null && index < __lsxl__.length; index++ ){
					Object __MAPPING__ = UpfgsmUtils.IUpfsm._jj_context("", 
							__lsxl__[index], 
							fromOrdUser.getNATURE(), 
							__lsxl__[index], 
							aContext);
					if( log.isDebugEnabled() ) log.debug( __lsxl__[index] + "\t" + __MAPPING__ );
				}*/
				/*IOVMsgFRequest fromRequest = ICustom.getAsNature( "com/ai/sacenter/receive/sacenter-rocket-charge.xml" );
				IOVMsgFUser fromMsgFGroup = fromRequest.getUSER( fromRequest.getUSER_ID() );
				IOVMsgFCentrex fromMsgFCentrex = fromMsgFGroup.getOFFER( 30005428208669l );
				if( log.isDebugEnabled() ) log.debug( fromMsgFCentrex );*/
				
				/*IISARocket __rocket__ = new ISARocketHis();
				__rocket__.setOrderId( System.currentTimeMillis() );
				__rocket__.setCreateDate( new java.sql.Timestamp( System.currentTimeMillis() ) );
				__rocket__.setCompleteDate( __rocket__.getCreateDate() );
				__rocket__.setRegionId( "209" );
				String _owner_name_ = OracleUtils.getTransactionName( IUpdbfsConst.IUpdbm.IOrderDAO, __rocket__ );
				if( log.isDebugEnabled() ) log.debug( _owner_name_ );*/
				
				/*SFUpffxUserImpl.IUpffxOracle fromUpffx = fromUpffxImpl.getUpffxOracle();
				
				IISPCRocket __mocket__ = new ISPCRocketFail();
				__mocket__.setOrderId( System.currentTimeMillis() );
				__mocket__.setCreateDate( new java.sql.Timestamp( System.currentTimeMillis() ) );
				__mocket__.setCompleteDate( __mocket__.getCreateDate() );
				__mocket__.setRegionId( "210" );
				HQSQLTable __table__ = HQSQLUtils.getOracleTable( IExigenceConst.IUpdbm.IRemoteDAO, __mocket__ );
				if( log.isDebugEnabled() ) log.debug( __table__ );
				fromUpffx.getTable( __table__.getMapingEnty() ).addAll( __table__.getProperties().values() );
				
				IISPCRocketX __mocketx__ = new ISPCRocketXFail();
				__mocketx__.setOfferId( System.currentTimeMillis() );
				__mocketx__.setOrderId( __mocket__.getOrderId());
				__mocketx__.setCreateDate( __mocket__.getCreateDate() );
				__mocketx__.setCompleteDate( __mocket__.getCompleteDate() );
				__mocketx__.setRegionId( __mocket__.getRegionId() );
				__table__ = HQSQLUtils.getOracleTable( IExigenceConst.IUpdbm.IRemoteDAO, __mocketx__ );
				if( log.isDebugEnabled() ) log.debug( __table__ );
				fromUpffx.getTable( __table__.getMapingEnty() ).addAll( __table__.getProperties().values() );*/
				
				/*IISPCRocket __rocket__ = new ISPCRocket();
				__rocket__.setOrderId( System.currentTimeMillis() );
				__rocket__.setCreateDate( new java.sql.Timestamp( System.currentTimeMillis() ) );
				__rocket__.setCompleteDate( __rocket__.getCreateDate() );
				__rocket__.setRegionId( "219" );
				HQSQLTable __table__ = HQSQLUtils.getOracleTable( IExigenceConst.IUpdbm.IRemoteDAO, __rocket__ );
				if( log.isDebugEnabled() ) log.debug( __table__ );*/
				
				IUpdcContext aContext = ClassUtils.getIContextImpl();
				SFException aEXCEPTION = ExceptionFactory.getException("IOS0000006", new String[]{"172100200100005","ShangHai_BBOSS"} );
				IOVMocketExigence fromRocket = ICustom.getAsExigence( "com/ai/sacenter/receive/sacenter-rabbit-centrex.xml" );
				IOVUpdcpmOffer fromUpdcpm = IExigenceFactory.getIUpdcpmSV().getSFUpfgkmComplete( fromRocket, aEXCEPTION, aContext );
				IPlatformTemplate.IUpffmsOffer fromUpffms = fromUpdcpm.getPROGRAM().getRESPOND();
				if( log.isDebugEnabled() ) log.debug( fromUpdcpm );
				
				IOVUpdbsComplete __complete__ = new IOVUpdbsComplete();
				if( log.isDebugEnabled() ) log.debug( __complete__.getORDER().getCOMPLETE() );
				
				__complete__.setCOMPLETE( "CMKTC_ROCKET_COMPLETE_PROGRAM" );
				if( log.isDebugEnabled() ) log.debug( __complete__.getORDER().getCOMPLETE() );
				
				/*MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				if( log.isDebugEnabled() ) log.debug( fromMBean );
				String ___table___[][] = new String[][]{
					    {"{I_USER_RADIUS_INDEX}","com.ai.sacenter.cboss.dao.remote.impl.IUpfgsmRemoteTfImpl$IUpfgsmNotifyTfImpl"},
						{"{I_USER_RADIUS}"      ,"com.ai.sacenter.cboss.dao.remote.impl.IUpfgsmRemoteTfImpl$IUpfgsmNotifyXTfImpl"},
						{"I_USER_MCAS_INDEX"    ,"com.ai.sacenter.cboss.dao.remote.impl.IUpfgsmRemoteTfImpl$IUpfgsmNotifyTfImpl"},
						{"I_USER_MCAS"          ,"com.ai.sacenter.cboss.dao.remote.impl.IUpfgsmRemoteTfImpl$IUpfgsmNotifyXTfImpl"},
						{"I_BRAND_CHG"          ,"com.ai.sacenter.cboss.dao.remote.impl.IUpfgsmRemoteTfImpl$IUpfgsmNotifyTfImpl"},
						{"I_ALL_USER_STS"       ,"com.ai.sacenter.cboss.dao.remote.impl.IUpfgsmRemoteTfImpl$IUpfgsmNotifyTfImpl"}};
				IOVUpfgsmRadius fromUpdbfmx = new IOVUpfgsmRadius();
				fromUpdbfmx.setSO_NBR   ( fromMBean.getORDER_ID () );
				fromUpdbfmx.setREGION_ID( fromMBean.getREGION_ID() );
				fromUpdbfmx.setCOMPOSITE( "0750000000002"          );
				for( int __index__ = 0; __index__ < ___table___.length; __index__++ ){
					Class<?> __composite__ = Class.forName( ___table___[__index__][1] );
					HQSQLTable __table__ = HQSQLUtils.getOracleTable(__composite__, ___table___[__index__][0], fromUpdbfmx.getINSTANCE() );
					if( log.isDebugEnabled() ) log.debug( __table__ );
				}*/
				
				UpfsvcManager.getMBean().commitTransaction();
			}
			catch( java.lang.Exception exception ){
				log.error( exception.getMessage(), exception );
				UpfsvcManager.getMBean().rollbackTransaction();
			}
			finally{
				if( fromUpffxImpl != null ){ fromUpffxImpl = null; }
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketVasChgImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-gsm-prodchange.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			RocketFRsRspMessage fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsRsp );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketYJSHChgImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-gsm-yjshmqsale.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			RocketFRsRspMessage fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsRsp );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketChangeImpl() throws Exception{
		try
		{
			SFCenterFactory.pushCenterInfo("200");
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-gsm-prodchange.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			RocketFRsRspMessage fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsRsp );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testCentrexReqImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-centerx-req.xml");
			RocketFTextMessage fromRocket = new RocketFTextMessage();
			fromRocket.setText( fromXML );
			RocketFRsRspMessage fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsRsp );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testCentrexRspImpl() throws Exception{
		try
		{
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-centrex-rsp.xml");
			RocketFMessage fromRocket = new RocketFTextMessage( fromXML );
			RocketFRsRspMessage fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketCompleteAsyn( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsRsp );
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketCsfImpl() throws Exception{
		try
		{
			//SFCenterFactory.pushCenterInfo("200");
			String fromXML = ICustom.getAsXml("com/ai/sacenter/receive/sacenter-gpon-qrylogin.xml");
			RocketFMessage fromRocket = new RocketFTextMessage( fromXML );
			RocketFRsRspMessage fromRsRsp = IUpdbfsFactory.getIUpdcSV().rocketReceive( fromRocket );
			if( log.isDebugEnabled() ) log.debug( fromRsRsp );
			//SHUpdcCSVImpl fromImpl = new SHUpdcCSVImpl();
			//fromImpl.alterRadiusSpeed(null, "13851640009", "24M");
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testUpfgkmSyncImpl() throws Exception{
		try
		{
			TfFrameWork.main(new String[]{"KTCENTER_TYKT_SYNC_ALL","1","0"});
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testUpfgkmReplyImpl() throws Exception{
		try
		{
			TfFrameWork.main(new String[]{"KTCENTER_TYKT_REPLY_205","1","0"});
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testUpfgkmEchoImpl() throws Exception{
		try
		{
			class SFUpfgkmEchoImpl{
				public SFUpfgkmEchoImpl(){
					super();
				}
				
				/**
				 * 
				 * @param _order_id
				 * @param _bill_id
				 * @return
				 * @throws Exception
				 */
				public IUpfgkmCityHome getUpfgkmEhcoHome( long _order_id, String _bill_id ) throws Exception{
					IUpfgkmCityHome fromCityHome = null;
					try
					{
						IOVUpfwmCouple fromRocket = new IOVUpfwmCouple();
						fromRocket.setPS_ID       ( _order_id                  );
						fromRocket.setBILL_ID     ( _bill_id                   );
						fromRocket.setCREATE_DATE ( new java.sql.Timestamp( System.currentTimeMillis() ) );
						SFCenterOffer fromRoute = CenterUtils.ISystem._custom( fromRocket );
						fromRocket.setREGION_ID   ( fromRoute.getREGION_ID()   );
						fromRocket.setPS_STATUS   ( -1 );
						fromRocket.setFAIL_REASON ( "号码已占用"                     );
						fromRocket.setEND_DATE    ( fromRocket.getCREATE_DATE());
						fromRocket.setRET_DATE    ( fromRocket.getCREATE_DATE());
						fromCityHome = new IUpfgkmCityHome( fromRocket.getREGION_ID() );
						fromCityHome.getCOMPLETE().add( fromRocket );
					}
					finally{
						
					}
					return fromCityHome;
				}
			}
			SFUpfgkmEchoImpl fromEchoImpl = new SFUpfgkmEchoImpl();
			try
			{
				IUpfgkmCityHome fromCityHome = null;
				MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
				fromMBean.setREPOSITORY( IUpfgkmConst.IUpfgkmDAO     );
				fromCityHome = fromEchoImpl.getUpfgkmEhcoHome(606082700064186l, "15802172560");
				fromMBean.setREGION_ID ( fromCityHome.getREGION_ID() );
				SFCenterFactory.pushCenterInfo( fromCityHome.getREGION_ID() );
				try
				{
					UpfgkmFactory.getIUpfgkmSV().finishSFUpfgkmComplete(fromMBean, 
							fromCityHome, 
							new java.util.HashMap() );
				}
				finally{
					SFCenterFactory.popCenterInfo();
				}
			}
			finally{
				if( fromEchoImpl != null ){ fromEchoImpl = null; }
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testUpfgsmSyncImpl() throws Exception{
		try
		{
			TfFrameWork.main(new String[]{"KTCENTER_CBOSS_SYNC_ALL","1","0"});
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketSyncImpl() throws Exception{
		try
		{
			TfFrameWork.main(new String[]{"KTCENTER_ROCKET_SYNC_200","1","0"});
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketExpireImpl() throws Exception{
		try
		{
			TfFrameWork.main(new String[]{"KTCENTER_EXPIRE_SYNC_ALL","1","0"});
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketEchoImpl() throws Exception{
		try
		{
			class SFUpfgkmEchoImpl{
				public SFUpfgkmEchoImpl(){
					super();
				}
				
				/**
				 * 
				 * @param _order_id
				 * @param fromUpdfmx
				 * @return
				 * @throws Exception
				 */
				public IUpfgkmCityHome getASKOrder( long _order_id, IUpfgkmCityHome fromUpdfmx ) throws Exception{
					try
					{
						IOVUpdbsComplete __rocket__ = UpdbsFactory.getIUpdbsDAO().getASKOrder( _order_id );
						if( __rocket__ != null ){ fromUpdfmx.getCOMPLETE().add( __rocket__ ); }
					}
					finally{
						
					}
					return fromUpdfmx;
				}
			}
			SFUpfgkmEchoImpl fromEchoImpl = new SFUpfgkmEchoImpl();
			try
			{
				IUpfgkmCityHome fromUpdfmx = new IUpfgkmCityHome( "200" );
				MBeanDelegate fromMBean = SystemUtils.ICustom._wrap( this );
				fromMBean.setREPOSITORY( IUpdcConst.IUpdbm.IUpdbsDAO     );
				SFCenterFactory.pushCenterInfo( fromUpdfmx.getREGION_ID() );
				UpfsvcManager.getMBean().beginTransaction();
				try
				{
					fromUpdfmx = fromEchoImpl.getASKOrder(600082800006003l, fromUpdfmx );
					for( java.util.Iterator<IOVUpdbsComplete> itera = fromUpdfmx.getCOMPLETE().iterator(); itera.hasNext(); ){
						IOVUpdbsComplete __rocket__ = (IOVUpdbsComplete)itera.next();
						if( log.isDebugEnabled() ) log.debug( __rocket__.getORDER().getCOMPLETE() );
						__rocket__.setSTATE( IUpdcConst.IState.H );
					}
					UpdbsFactory.getIUpdbsSV().finishSFUpdbsComplete(fromMBean, 
							fromUpdfmx, 
							new java.util.HashMap() );
					UpfsvcManager.getMBean().commitTransaction();
				}
				catch( java.lang.Exception exception ){
					log.error( exception.getMessage(), exception );
					UpfsvcManager.getMBean().rollbackTransaction();
				}
				finally{
					SFCenterFactory.popCenterInfo();
				}
			}
			finally{
				if( fromEchoImpl != null ){ fromEchoImpl = null; }
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testRocketReplyImpl() throws Exception{
		try
		{
			TfFrameWork.main(new String[]{"KTCENTER_TARGET_REPLY_ALL","1","0"});
			//TfFrameWork.main(new String[]{"KTCENTER_TARGET_REPLY_202","1","0"});
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testQueueSyncImpl() throws Exception{
		try
		{
			TfFrameWork.main(new String[]{"KTCENTER_QUEUE_SYNC_200","1","0"});
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void testSuggestSyncImpl() throws Exception{
		try
		{
			TfFrameWork.main(new String[]{"KTCENTER_SUGGEST_SYNC_200","1","0"});
		}
		finally{
			
		}
	}
	
	public void testRocketCSVImpl() throws Exception{
		
	}
	
	public static class ICustom{
		public final static Class<?> IExpireDAO  = com.ai.sacenter.receive.expire.dao.interfaces.IExpireDAO.class;
		public final static Class<?> IRemoteDAO  = com.ai.sacenter.tykt.dao.remote.impl.IUpfgkmRemoteTfImpl.IUpfgkmNotifyTfImpl.class;
		public ICustom(){
			super();
		}
		
		/**
		 * 
		 * @param _pref
		 * @param _table
		 * @param _column
		 * @param _object
		 */
		public static void userlog( String _pref, PhantomEvaluator _phantom ) throws SFException,Exception{
			EncryptUtils.ICustom.userlog("ucmframe", _pref + ( XmlUtils.IXml._format( _phantom.getOperator().asXml() ) ) );
			//EncryptUtils.ICustom.userlog("ucmframe", _pref + ( XmlUtils.IXml._format( _phantom.asXml() ) ) );
		}
		
		/**
		 * 
		 * @param __custom_id__
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _custom_user_directory_log_( String __custom_id__ ) throws SFException,Exception{
			try
			{
				if( log.isDebugEnabled() ) log.debug( "---------------------------------------------------------------" );
				IUpdfmxDirectory __user_directory__ = UpfsvcManager.getRocket().getIUpfxCustom( __custom_id__ );
				if( log.isDebugEnabled() ) log.debug("CUSTOM: " + UpfsvcManager.getRocket().getIUpfxCustom().getCustom() );
				if( log.isDebugEnabled() ) log.debug("CUSTOM: " + (__user_directory__ != null?__user_directory__.getBottle():"NULL") );
				if( UpfsvcManager.getBlankSession() != null ){
					__user_directory__ = UpfsvcManager.getSession().getIUpfxCustom( __custom_id__ );
					if( log.isDebugEnabled() ) log.debug("ROCKET: " + UpfsvcManager.getSession().getIUpfxCustom().getCustom() );
					if( log.isDebugEnabled() ) log.debug("ROCKET: " + (__user_directory__ != null?__user_directory__.getBottle():"NULL") );
				}
			}
			finally{
				
			}
		}
		
		public static String getAsXml( DataStructInterface fromEntity ) throws Exception{
			String fromXML = null;
			try
			{
				org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
				org.dom4j.Element _root = document.addElement( "InterBOSS" );
				org.dom4j.Element _tables = _root.addElement( "_table_" );
				_tables.addAttribute( "_id_", SFSubTableFactory.createTableName( fromEntity ) );
				if( fromEntity.isNew() ){ _tables.addAttribute( "_mode_", "INSERT" ); }
				else if( fromEntity.isModified() ){ _tables.addAttribute( "_mode_", "MODIFY" ); }
				else if( fromEntity.isDeleted() ){ _tables.addAttribute( "_mode_", "DELETE" ); }
				java.util.Map<String, Object> _properties = fromEntity.getNewProperties();
				if( _properties != null && _properties.size() > 0 ){
					org.dom4j.Element _bottle = _tables.addElement( "_ps_param_" );
					for( java.util.Iterator<java.util.Map.Entry<String, Object>> itera = _properties.entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry<String, Object> fromEntry = itera.next();
						String _field = (String)fromEntry.getKey().toString().toUpperCase();
						_bottle.addElement( _field ).setText( fromEntry.getValue() != null?fromEntry.getValue().toString():"NULL");
					}
				}
				_properties = fromEntity.getOldProperties();
				if( _properties != null && _properties.size() > 0 ){
					org.dom4j.Element _bottle = _tables.addElement( "_old_ps_param_" );
					for( java.util.Iterator<java.util.Map.Entry<String, Object>> itera = _properties.entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry<String, Object> fromEntry = itera.next();
						String _field = (String)fromEntry.getKey().toString().toUpperCase();
						_bottle.addElement( _field ).setText( fromEntry.getValue() != null?fromEntry.getValue().toString():"NULL");
					}
				}
				
				fromXML = XmlUtils.IXml._format( document.asXML() );
			}
			finally{
				
			}
			return fromXML;
		}
		
		/**
		 * 
		 * @param fromFile
		 * @throws Exception
		 */
		public static String getAsXml( String fromFile ) throws Exception{
			String fromXML = null;
			try
			{
				java.io.InputStream fromStream = ClassUtils.IClass.getClassLoaderResource(fromFile);
				byte[] fromBYTE = FileUtils.IFile.readFile( fromStream );
				fromXML = new String( fromBYTE, "utf-8");
			}
			finally{
				
			}
			return fromXML;
		}
		
		/**
		 * 
		 * @param fromFile
		 * @return
		 * @throws Exception
		 */
		public static IOVMocketExigence getMocketAsRemote( String fromFile ) throws Exception{
			IOVMocketExigence fromRocket = null;
			try
			{
				fromRocket = ICustom.getAsExigence( fromFile );
				SFCenterFactory.pushCenterInfo( fromRocket.getREGION_ID() );
				UpfsvcManager.getMBean().beginTransaction();
				try
				{
					UpfsvcManager.getMBean().beginTransaction();
					SFCenterFactory.pushCenterInfo( IExigenceConst.IUpdbm.IUpdbc.DISTRICT_ID, fromRocket.getORDER_REGION_ID() );
					try
					{
						fromRocket.setORDER_ID( ExigenceFactory.getIRemoteDAO().getORDER_ID( ) );
						fromRocket.setPRIORITY( IUpdbfsConst.IUpdbm.ICustom.PRIORITY           );
						fromRocket.setSTATE   ( IUpdbfsConst.IState.C                          );
						for( java.util.Iterator itera = fromRocket.getORDER().getORDER().iterator(); itera.hasNext(); ){
							IOVMocketOffer fromOsOffer = (IOVMocketOffer)itera.next();
							fromOsOffer.setOFFER_ID ( ExigenceFactory.getIRemoteDAO().getORDER_ID() );
							fromOsOffer.setORDER_ID ( fromRocket.getORDER_ID                     () );
							fromOsOffer.setREGION_ID( fromRocket.getORDER_REGION_ID              () );
							fromOsOffer.setSTATE    ( IUpdbfsConst.IState.C                         );
						}
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						UpfsvcManager.getMBean().rollbackTransaction();
						throw exception;
					}
					finally{
						
					}
					UpfsvcManager.getMBean().commitTransaction();
				}
				catch( java.lang.Exception exception ){
					UpfsvcManager.getMBean().rollbackTransaction();
					throw exception;
				}
				finally{
					
				}
			}
			finally{
				
			}
			return fromRocket;
		}
		
		/**
		 * 
		 * @param fromFile
		 * @return
		 * @throws Exception
		 */
		public static IUpfgkmCityHome getRabbitAsRemote( String fromFile ) throws Exception{
			IUpfgkmCityHome fromUpdfmx = null;
			try
			{
				class SFRabbitRemoteImpl{
					public SFRabbitRemoteImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param fromRocket
					 * @return
					 * @throws Exception
					 */
					public IUpfgkmCityHome getSFRocketLimite( MBeanDelegate fromMBean, IOVMocketExigence fromRocket ) throws Exception{
						IUpfgkmCityHome fromUpdfmx = new IUpfgkmCityHome( fromRocket.getREGION_ID() );
						UpfsvcManager.getMBean().beginTransaction();
						SFCenterFactory.pushCenterInfo( IExigenceConst.IUpdbm.IUpdbc.DISTRICT_ID, fromRocket.getORDER_REGION_ID() );
						try
						{
							fromRocket.setORDER_ID( ExigenceFactory.getIRemoteDAO().getORDER_ID( ) );
							fromRocket.setPRIORITY( IUpdbfsConst.IUpdbm.ICustom.PRIORITY           );
							fromRocket.setSTATE   ( IUpdbfsConst.IState.C                          );
							for( java.util.Iterator itera = fromRocket.getORDER().getORDER().iterator(); itera.hasNext(); ){
								IOVMocketOffer fromOsOffer = (IOVMocketOffer)itera.next();
								fromOsOffer.setOFFER_ID ( ExigenceFactory.getIRemoteDAO().getORDER_ID() );
								fromOsOffer.setORDER_ID ( fromRocket.getORDER_ID                     () );
								fromOsOffer.setREGION_ID( fromRocket.getORDER_REGION_ID              () );
								fromOsOffer.setSTATE    ( IUpdbfsConst.IState.C                         );
								UpfsvcManager.getSession().submitISQLLite( IExigenceConst.IUpdbm.IRemoteDAO, fromOsOffer.getINSTANCE() );
							}
							fromUpdfmx.getCOMPLETE().add( fromRocket );
							UpfsvcManager.getSession().submitISQLLite( IExigenceConst.IUpdbm.IRemoteDAO, fromRocket.getINSTANCE() );
							UpfsvcManager.getMBean().commitTransaction();
						}
						catch( java.lang.Exception exception ){
							UpfsvcManager.getMBean().rollbackTransaction();
							throw exception;
						}
						finally{
							
						}
						return fromUpdfmx;
					}
				}
				SFRabbitRemoteImpl fromRemoteImpl = new SFRabbitRemoteImpl();
				try
				{
					IOVMocketExigence fromRocket = ICustom.getAsExigence(fromFile);
					SFCenterFactory.pushCenterInfo( fromRocket.getREGION_ID() );
					UpfsvcManager.getMBean().beginTransaction();
					try
					{
						MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
						fromUpdfmx = fromRemoteImpl.getSFRocketLimite(fromMBean, fromRocket);
						UpfsvcManager.getMBean().commitTransaction();
					}
					catch( java.lang.Exception exception ){
						UpfsvcManager.getMBean().rollbackTransaction();
						throw exception;
					}
					finally{
						
					}
				}
				finally{
					if( fromRemoteImpl != null ){ fromRemoteImpl = null; }
				}
			}
			finally{
				
			}
			return fromUpdfmx;
		}
		
		/**
		 * 
		 * @param fromFile
		 * @return
		 * @throws Exception
		 */
		public static IOVMocketExigence getAsExigence( String fromFile ) throws Exception{
			IOVMocketExigence fromRocket = null;
			try
			{
				String fromXML = ICustom.getAsXml( fromFile );
				RocketFTextMessage _rocket = new RocketFTextMessage( fromXML );
				fromRocket = ExigenceUtils.IRocket._jj_mocket( _rocket );
			}
			finally{
				
			}
			return fromRocket;
		}
		
		/**
		 * 
		 * @param fromFile
		 * @return
		 * @throws Exception
		 */
		public static IOVMsgFExigence getAsRocket( String fromFile ) throws Exception{
			IOVMsgFExigence fromRocket = null;
			try
			{
				String fromXML = ICustom.getAsXml( fromFile );
				RocketFTextMessage _rocket = new RocketFTextMessage( fromXML );
				fromRocket = ExigenceUtils.IRocket._jj_rocket( _rocket );
			}
			finally{
				
			}
			return fromRocket;
		}
		
		/**
		 * 
		 * @param fromFile
		 * @return
		 * @throws Exception
		 */
		public static IOVMsgFRequest getAsNature( String fromFile ) throws Exception{
			IOVMsgFRequest fromRequest = null;
			try
			{
				IOVMsgFExigence fromRocket = ICustom.getAsRocket( fromFile );
				IUpfgkmOfferHome fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRocket );
				fromRequest = OrderUtils.ICustom._wrap( fromRocket.getORDER().getLITTLE(), fromUpdcpm );
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @param fromRocket
		 * @param fromUpdcpm
		 * @return
		 * @throws Exception
		 */
		public static IOVMsgFRequest getAsNature( IOVMsgFExigence fromRocket, IUpfgkmOfferHome fromUpdcpm ) throws Exception{
			IOVMsgFRequest fromNature = null;
			try
			{
				fromNature = OrderUtils.ICustom._wrap( fromRocket.getORDER().getLITTLE(), fromUpdcpm );
			}
			finally{
				
			}
			return fromNature;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromUpdcpm
		 * @return
		 * @throws Exception
		 */
		public static IOVOrderRequest getAsRocket( IOVMsgFExigence fromRocket, IUpfgkmOfferHome fromUpdcpm ) throws Exception{
			IOVOrderRequest fromRequest = null;
			try
			{
				fromRequest = UpdbfsUtils.ICustom._wrap(fromRocket.getORDER().getLITTLE(), fromUpdcpm);
			}
			finally{
				
			}
			return fromRequest;
		}
		
		/**
		 * 
		 * @return
		 * @throws Exception
		 */
		public static IOVOrderPentium getAsOrder( IOVMsgFExigence fromRocket ) throws Exception{
			IOVOrderPentium _order = new IOVOrderPentium();
			try
			{
				IProfessionalTemplate.ICompetenceOffer aCOMPETENCE = null;
				IUpdcContext aContext = ClassUtils.getIContextImpl();
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				IUpfgkmOfferHome fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRocket );
				IOVMsgFRequest fromNature = ICustom.getAsNature(fromRocket, fromUpdcpm);
				IOVOrderRequest fromRequest = ICustom.getAsRocket( fromRocket, fromUpdcpm );
				aCOMPETENCE = UpdcpmUtils.getCOMPETENCE( fromUpdcpm.getCATALOG().getBUSINES().getCOMPETENCE() );
				UpdcUtils.wrap(fromMBean, _order, fromRequest, fromRequest.getUSER(), aCOMPETENCE, aContext);
				_order.setCREATE_DATE( fromMBean.getCREATE                  () );
			}
			finally{
				
			}
			return _order;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @return
		 * @throws Exception
		 */
		public static IOVTaskPentium getAsTask( IOVOrderPentium fromOrder ) throws Exception{
			IOVTaskPentium _task = new IOVTaskPentium();
			try
			{
				ISystemTemplate.IUpdbpmOffer fromUpdbpm = null;
				fromUpdbpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdbpmCatalog("172099840000104");
				_task = new IOVTaskPentium( fromOrder, fromUpdbpm );
				IOVOfferPentium _offer = new IOVOfferPentium();
				JdomUtils.ICustom.wrap("DWLSIM=C;GPRSJK=D;IMSPBXQY=C;IMSPBXGRPID=2108022814;NR=D;PSML=C;ZSQX=C;IMSPBXDHSI=C;CYPT=C;SJNSRFC=C;IMSPBXCYDH=8228;", _offer.getORDER().getOFFER());
				JdomUtils.ICustom.wrap("CFM=D;QJCL=C;SJGPSFC=X;IMSPBX=C;IMSPBXDHDX=C;SJOTHFC=C;SJBSFC=X;DDD=D;YYFW=D;SJQY=C;TDLTE=C;GPRS=D;CLIP=D;CYZJ=C;SMS=D", _offer.getORDER().getOFFER());
				_task.getORDER().setOFFER( _offer );
			}
			finally{
				
			}
			return _task;
		}
		
		/**
		 * 
		 * @param fromRequest
		 * @param fromMsgFUser
		 * @return
		 * @throws Exception
		 */
		public static IOVOrderUser getAsOrdUser( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser ) throws Exception{
			IOVOrderUser fromOrdUser = null;
			try
			{
				IProfessionalTemplate.IProductComptel fromComptel = null;
				IUpfgkmOfferHome fromUpdcpm = IOrderFactory.getIOrdMixSV().getSFMsgFBusines( fromRequest );
				fromOrdUser = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFUser, fromUpdcpm );
				for( java.util.Iterator<IOVMsgFOrdCentrex> itera = fromMsgFUser.getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOrdCentrex fromMsgFCentrex = (IOVMsgFOrdCentrex)itera.next();
					if( fromMsgFCentrex.getINS_PROD_ID() == 30005159419420l ){
						if( log.isDebugEnabled() ) log.debug( fromMsgFCentrex );
					}
					for( java.util.Iterator<IOVMsgFOffer> iterap = fromMsgFCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
						IOVMsgFOrdOffer fromMsgFOffer = (IOVMsgFOrdOffer)iterap.next();
						fromComptel = IOrderFactory.getIProductSV().getSFProductNature(fromRequest, fromMsgFOffer, fromUpdcpm);
						IOVOrderOffer fromOrdOffer = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFUser, fromMsgFOffer, fromComptel, fromUpdcpm);
						UpdbfsUtils.ISystem._groupAsCompete( null, fromOrdUser, fromOrdOffer);
					}
				}
				
				for( java.util.Iterator<IOVMsgFUserCentrex> itera = fromMsgFUser.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUserCentrex fromMsgFCentrex = (IOVMsgFUserCentrex)itera.next();
					if( fromMsgFUser.getORDER().get( fromMsgFCentrex ) == null ){
						for( java.util.Iterator<IOVMsgFOffer> iterap = fromMsgFCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
							IOVMsgFUserOffer fromMsgFOffer = (IOVMsgFUserOffer)iterap.next();
							fromComptel = IOrderFactory.getIProductSV().getSFProductNature(fromRequest, fromMsgFOffer, fromUpdcpm);
							IOVOrderOffer fromOrdOffer = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFUser, fromMsgFOffer, fromComptel, fromUpdcpm);
							UpdbfsUtils.ISystem._groupAsCompete( null, fromOrdUser, fromOrdOffer);
						}
					}
				}
			}
			finally{
				
			}
			return fromOrdUser;
		}
		/**
		 * 
		 * @param fromPath
		 * @return
		 * @throws Exception
		 */
		public static java.util.Queue _get_xpath( String fromPath ) throws Exception{
			java.util.Queue fromDeque = new ArrayDeque();
			StackDeque fromPeriod = new StackDeque();
			try
			{
				class QueueXPNode{
					private StringBuilder _id = new StringBuilder();
					private StringBuilder _node = new StringBuilder();
					private StringBuilder _param = new StringBuilder();
					public QueueXPNode(){
						super();
					}
					/**
					 * 
					 * @return
					 */
					public String getID(){
						return StringUtils.isBlank( _id.toString() )?null:_id.toString();
					}
					/**
					 * 
					 * @return
					 */
					public XPathNode getNODE(){
						XPathNode fromNode = null;
						try
						{
							fromNode = new XPathNode( _id.toString(), _node.toString() );
							if( _param.length() > 0 ){
								java.util.StringTokenizer _tokenizer = new java.util.StringTokenizer( _param.toString(), "&" );
							    while( _tokenizer.hasMoreTokens() ){
						            String token = _tokenizer.nextToken();
						            int _indexOf = token.indexOf( "!=" );
						            if( _indexOf >= 0 ){
						            	String name = ( _indexOf > -1 ) ? token.substring( 0, _indexOf ) : token;
							            String value = ( _indexOf > -1 ) ? token.substring( _indexOf + 2 ) : "";
							            fromNode.getParam().add( new XPathNodeUnequal( name.trim(), value.trim() ) );
						            }
						            else if( ( _indexOf = token.indexOf( "=" ) ) >= 0 ){
						            	String name = ( _indexOf > -1 ) ? token.substring( 0, _indexOf ) : token;
							            String value = ( _indexOf > -1 ) ? token.substring( _indexOf + 1 ) : "";
							            fromNode.getParam().add( new XPathNodeEqual( name.trim(), value.trim() ) );
						            }
						        }
							}
						}
						finally{
							
						}
						return fromNode;
					}
				}
				int fromINDEX = 0;
				QueueXPNode fromQueue = new QueueXPNode();
				fromPath = IICustom._jj_xpath( fromPath );
				while( fromINDEX < fromPath.length() ){
					if( fromPath.charAt( fromINDEX ) == '/' ){
						if( fromQueue.getID() != null ){ fromDeque.add( fromQueue.getNODE() ); }
						fromQueue = new QueueXPNode();
					}
					else if( fromPath.charAt( fromINDEX ) == '[' ){
						fromQueue._node.append( fromPath.charAt( fromINDEX ) );
						fromINDEX += 1;
						fromPeriod.push( fromQueue );
						while( fromINDEX < fromPath.length() ){
							fromQueue._node.append( fromPath.charAt( fromINDEX ) );
							if( fromPath.charAt( fromINDEX ) == '[' ){
								throw new IllegalArgumentException( "arguments are required."  );
							}
							if( fromPath.charAt( fromINDEX ) == ']' ){
								fromPeriod.pop();
								break;
							}
							fromQueue._param.append( fromPath.charAt( fromINDEX ) );
							fromINDEX += 1;
						}
						if( fromPeriod.size() > 0 ){
							throw new IllegalArgumentException( "arguments are required."  );
						}
					}
					else{
						fromQueue._id.append( fromPath.charAt( fromINDEX ) );
						fromQueue._node.append( fromPath.charAt( fromINDEX ) );
					}
					fromINDEX += 1;
				}
				if( fromPeriod.size() > 0 ){
					throw new IllegalArgumentException( "arguments are required."  );
				}
				if( fromQueue != null && fromQueue.getID() != null ){ fromDeque.add( fromQueue.getNODE() ); }
			}
			finally{
				if( fromPeriod != null ){ fromPeriod.clear(); fromPeriod = null; }
			}
			return fromDeque;
		}
	}
	
	public static class XPathNode {
		private String id;
		private String node;
		private java.util.ArrayList<XPathEqual> param = new java.util.ArrayList<XPathEqual>();
		public XPathNode( ){
			super();
		}
		
		public XPathNode( String _id, String _node ){
			super();
			id   = _id  ;
			node = _node;
		}
		
		/**
		 * @return the id
		 */
		public String getId() {
			return id != null && StringUtils.isBlank( id ) == false?id:null;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the node
		 */
		public String getNode() {
			return node;
		}

		/**
		 * @param node the node to set
		 */
		public void setNode(String node) {
			this.node = node;
		}

		/**
		 * @return the param
		 */
		public java.util.ArrayList<XPathEqual> getParam() {
			return param;
		}
		
		/**
		 * 节点为通配符
		 * @return
		 */
		public boolean isPattern(){
			return id != null && StringUtils.isBlank( id ) == false && 
					StringUtils.equals( id, "*" );
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean isEmpty(){
			return id != null && StringUtils.isBlank( id );
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			String __xml__ = null;
			try
			{
				org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
				org.dom4j.Element _root_ = document.addElement( "InterBOSS" );
				org.dom4j.Element _node_ = _root_.addElement("__xpath__");
				_node_.addElement( "_id_" ).setText  ( id   );
				org.dom4j.Element __node__ = _node_.addElement( "_phantom_" );
				for( java.util.Iterator<XPathEqual> itera = param.iterator(); itera.hasNext(); ){
					XPathEqual _xpathequal_ = (XPathEqual)itera.next();
					_xpathequal_._jj_document( __node__.addElement( "_param_" ) );
				}
				__xml__ = document.asXML();
			}
			catch( java.lang.Exception exception ){
				__xml__ = super.toString();
			}
			finally{
				
			}
			return __xml__;
		}
	}
	
	public static class XPathEqual{
		public XPathEqual(){
			super();
		}
		
		/**
		 * 
		 * @param __node__
		 * @param __left__
		 * @return
		 * @throws Exception
		 */
		public boolean _jj_equal( final XPathNode __node__, final Object __left__ ) throws Exception{
			return false;
		}
		
		/**
		 * 
		 * @param _element
		 */
		public void _jj_document( org.dom4j.Element _element ){
			
		}
	}
	
	public static class XPathNodeEqual extends XPathEqual{
		protected String _left;
		protected String _right;
		private XPathNodeEqual(){
			super();
		}
		
		private XPathNodeEqual( String left, String right ){
			super();
			_left  = left ;
			_right = right;
		}
		
		/**
		 * @return the left
		 */
		public String getLeft() {
			return _left;
		}
		
		/**
		 * @param left the left to set
		 */
		public void setLeft(String left) {
			_left = left;
		}
		
		/**
		 * @return the right
		 */
		public String getRight() {
			return _right;
		}
		
		/**
		 * @param right the right to set
		 */
		public void setRight(String right) {
			_right = right;
		}

		/**
		 * 
		 * @param __node__
		 * @param __left__
		 * @return
		 * @throws Exception
		 */
		public boolean _jj_equal( final XPathNode __node__, final Object __left__ ) throws Exception{
			if( __left__ == null ){ 
				return _right != null && _right.equals( "NULL" ); 
			}
			else if( _right != null && _right.equals( "NULL" ) ){
				return false; 
			}
			else if( _right.equals( "*" ) ){ 
				return true; 
			}
			else{
				return __left__.equals( _right );
			}
		}
		
		/**
		 * 
		 * @param _element
		 */
		public void _jj_document( org.dom4j.Element _element ){
			_element.addAttribute( "_pattern_", "=" ).addAttribute( _left, _right );
		}
		
	}
	
	public static class XPathNodeUnequal extends XPathNodeEqual{
		private XPathNodeUnequal(){
			super();
		}
		
		private XPathNodeUnequal( String left, String right ){
			super( left, right );
		}
		
		/**
		 * 
		 * @param __node__
		 * @param __left__
		 * @return
		 * @throws Exception
		 */
		public boolean _jj_equal( final XPathNode __node__, final Object __left__ ) throws Exception{
			if( __left__ == null ){ 
				return _right != null && _right.equals( "NULL" ) == false; 
			}
			else if( _right != null && _right.equals( "NULL" ) ){
				return true; 
			}
			else{
				return __left__.equals( _right ) == false;
			}
		}
		
		/**
		 * 
		 * @param _element
		 */
		public void _jj_document( org.dom4j.Element _element ){
			_element.addAttribute( "_pattern_", "!=" ).addAttribute( _left, _right );
		}
	}
	public static class Column implements java.io.Serializable{
		private static final long serialVersionUID = -6667466636585707412L;
		private String _field;
		public Column(){
			super();
		}
		
		public Column( Column column ){
			super();
			_field = column._field;
		}
		
		public Column( String name){
			super();
			_field = name;
		}
		
		/**
		 * @return the _field
		 */
		public String getField() {
			return _field;
		}

		/**
		 * @param _field the _field to set
		 */
		public void setField(String _field) {
			this._field = _field;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object obj) {
			if( obj == null ){
				return false;
			}
			else if( obj instanceof java.lang.String ){
				java.lang.String _string = (java.lang.String)obj;
				return _field.equals( _string );
			}
			else if( obj instanceof Column ){
				Column _column = (Column)obj;
				return _field.equals( _column._field );
			}
			return super.equals(obj);
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			StringBuilder _xml = new StringBuilder( super.toString() );
			_xml.append("[field=").append(_field ).append("]");
			return _xml.toString();
		}
		
	}
	
	public static class TestReflectImpl extends UpdcEclipseImpl{
		public TestReflectImpl(){
			super();
		}
		
		/**
		 * 
		 * @throws SFException
		 * @throws Exception
		 */
		public void testReflect01Impl() throws SFException,Exception{
			if( log.isDebugEnabled() ) log.debug( "TestReflectImpl:testReflect01Impl()" );
		}
		
		/**
		 * 
		 * @throws SFException
		 * @throws Exception
		 */
		public void testReflect01Impl( IUpdfmxEntry __user__ ) throws SFException,Exception{
			if( log.isDebugEnabled() ) log.debug( "TestReflectImpl:testReflect01Impl(IUpdfmxEntry)" );
		}
		
		/**
		 * 
		 * @throws SFException
		 * @throws Exception
		 */
		public void testReflect01Impl( IOVUser __user__ ) throws SFException,Exception{
			if( log.isDebugEnabled() ) log.debug( "TestReflectImpl:testReflect01Impl(IOVUser)" );
		}
	}
	
	public static class MethodReference{
		private StringBuilder _methodName = new StringBuilder();
		private java.util.List _parameters = new java.util.ArrayList();
		public MethodReference( ){
			super();
		}
		
		/**
		 * 
		 * @return
		 */
		public String getAsXML(){
			String fromXML = null;
			try
			{
				org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
				org.dom4j.Element fromRoot = document.addElement( "function" );
				fromRoot.addElement("method").setText( _methodName.toString() );
				org.dom4j.Element fromParam = fromRoot.addElement( "param" );
				for( int index = 0; index < _parameters.size(); index++ ){
					ParamReference _param = (ParamReference)_parameters.get( index );
					fromParam.addElement( "param_" + index ).setText( _param._parameter.toString() );
				}
				fromXML = XmlUtils.IXml._format( document, "UTF-8" );
			}
			catch( java.lang.Exception exception ){
				fromXML = super.toString();
			}
			finally{
				
			}
			return fromXML;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return getAsXML();
		}

		public static class ParamReference{
			private StringBuilder _parameter = new StringBuilder();
			public ParamReference(){
				super();
			}
		}
	}
}
