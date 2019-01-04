package com.ai.sacenter.comptel.service.impl;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.IUpfvmsSTKLocal;
import com.ai.sacenter.common.IUpfwmsSTKLocal;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.common.UpfsvcVantage;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.comptel.IUpfgsmSystem;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.util.UpdcpmUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProgramTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IUpdcpmGroup;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-12-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmSRVImpl extends UpdcEclipseImpl implements IUpfwmSRV {
	public UpfwmSRVImpl(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#getSFUpdbmChain(java.lang.Object, java.util.Map, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.Map getSFUpdbmChain(Object fromUpfwm, 
			java.util.Map fromOffer, 
			java.util.Map fromUpfgsm, 
			IUpdcContext aContext) throws SFException, Exception {
		java.util.Map fromChain = new java.util.HashMap();
		try
		{
			UpfsvcVantage.IUpdfmxDeque fromUpdbpmHome = UpfsvcManager.getRocket().getBlankDeque();
			if( fromUpdbpmHome != null && fromUpfgsm != null && fromUpfgsm.size() > 0 ){
				IPlatformTemplate.IUpffgsmOffer fromUpfgsmc[] = UpfgsmUtils.ICustom.getICSTKUpfgsmc();
				if( fromUpfgsmc != null && fromUpfgsmc.length > 0 ){
					java.util.List fromUpfgsmL = new java.util.ArrayList();
					java.util.List fromUpfgsmcL  = new java.util.ArrayList();
					for( int index = 0 ; fromUpfgsmc != null && index < fromUpfgsmc.length ; index++ ){
						fromUpfgsmL.add( fromUpfgsmc[index] );
						if( fromUpfgsm.containsKey( fromUpfgsmc[index].getMAPPING() ) == false ) continue;
						fromUpfgsmcL.add( fromUpfgsmc[index].getMAPPING() );
					}
					if( fromUpfgsmL != null && fromUpfgsmL.size() > 0 )   fromChain.put( "IUpffgsmL", fromUpfgsmL );
					if( fromUpfgsmcL != null && fromUpfgsmcL.size() > 0 ) fromChain.put( "IUpffgsmcL", fromUpfgsmcL );
				}
			}
			if( fromUpfgsm != null ){
				ClassUtils.IMerge.merge( fromUpfgsm, fromChain );
				fromChain.put( "IUpffgsmxL", fromUpfgsm );
			}
			ClassUtils.IMerge.merge( fromOffer , fromChain, false );
		}
		finally{
			
		}
		return fromChain;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpdbmChain(java.lang.String, java.util.Map, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.Map finishSFUpdbmChain(String fromJEXP, 
			java.util.Map fromOffer, 
			java.util.Map fromUpfgsm, 
			IUpdcContext aContext) throws SFException, Exception {
		IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
		try
		{
			if( fromUpfgsm == null ) fromUpfgsm = new java.util.HashMap();
			fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.MAPPING, fromUpfgsm );
			String aCOMPLEX[][] = UpfgsmUtils.IUpfvm.getISTKJexpL( fromJEXP );
			for( int index = 0 ; aCOMPLEX != null && index < aCOMPLEX.length; index++ ){
				Object aOBJECT = finishSFUpfvnChain( aCOMPLEX[index][1] , 
						fromOffer, 
						aContext );
				if( aOBJECT == null ) continue;
				UpfgsmUtils.IUpfvm.wrap( aCOMPLEX[index][0], 
						aOBJECT, 
						fromOffer, 
						fromUpfgsm, 
						aContext );
			}
		}
		finally{
			if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
		}
		return fromUpfgsm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpfvnChain(java.lang.String, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFUpfvnChain(String fromCOMPLEX, 
			java.util.Map fromOffer,
			IUpdcContext aContext) throws SFException, Exception {
		Object aOBJECT = null;
		try
		{
			class IUpfwmOfferImpl{
				public IUpfwmOfferImpl(){
					super();
				}
				/**
				 * 常量引用,格式为#[常量]
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_conston(String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					return StringUtils.substringBetwn( aJEXP , "#[" , "]" );
				}
				/**
				 * 拆分引用,格式为${{变量,拆分表达式[样例为C=1&E=1&*=3或C=1;E=1;*=3]<,默认值>}}
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_splite( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					String aOBJECT = null;
					try
					{
						String fromArray[] = StringUtils.wildcardArray( StringUtils.substringBetwn( aJEXP , "${{" , "}}" ), ",");
						fromArray[1] = StringUtils.replace( fromArray[1] , "&" , ";");
						aOBJECT = (String)UpfgsmUtils.IUpfsm._jj_splite( aJEXP , 
								fromArray[0],
								fromOffer, 
								fromArray[1],
								null,
								aContext);
						if( aOBJECT == null && fromArray.length > 2 && StringUtils.isBlank( fromArray[2] ) == false ) aOBJECT = fromArray[2];
						if( aOBJECT != null && StringUtils.startWith( aOBJECT.toString(), "$" ) ){
							aOBJECT = (String)UpfgsmUtils.IUpfsm.IIUpfsm._jj_variable( aJEXP, 
									aJEXP, 
									fromOffer, 
									aOBJECT.toString() , 
									aContext );
						}
					}
					finally{
						
					}
					return aOBJECT;
				}
				/**
				 * 变量引用,格式为${变量列表[样例为BILL_ID&IInstanceL.BILL_ID]<,默认值>}
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_variable( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					Object aOBJECT = null;
					try
					{
						String aCOMPLEX = StringUtils.substringBetwn( aJEXP , "${" , "}" );
						aOBJECT = UpfgsmUtils.IUpfsm._jj_context(aJEXP, 
								aJEXP, 
								fromOffer, 
								aCOMPLEX, 
								aContext);
					}
					finally{
						
					}
					return aOBJECT;
				}
				/**
				 * 正值表达式引用,格式为#{JEVAL表达式[样例为#{CVPMN_PHONENO}+'|'+#{IInstanceL.BILL_ID}]}
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_jeval( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					Object aOBJECT = null;
					try
					{
						String arguments = StringUtils.substringBetwn( aJEXP , "#{" , "}" );
						aOBJECT = UpdcpUtils.IUpfvn.evaluate( arguments, 
								fromOffer, 
								aContext) ;
					}
					finally{
						
					}
					return aOBJECT;
				}
				/**
				 * 模板引用,格式为$REF[#REF[模板编码]<,表达式规范[样例为USERTYPE=#[0]&MBELL=#[1]或NULL=$XPF[属性模板编码]或$XPF[属性模板编码]>]
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_refref( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					Object aOBJECT = null;
					try
					{
						String fromMODULE[] = StringUtils.wildcardArray( StringUtils.substringBetwn( aJEXP , "$REF[" , "]" ) , "," );
						fromMODULE = new String[]{ fromMODULE[0],(fromMODULE == null || fromMODULE.length <= 1 || 
								StringUtils.isBlank( fromMODULE[1] )?null:fromMODULE[1])};
						aOBJECT = IUpdcpFactory.getIUpfvmSV().finishSFUpdbrfChain("NULL", 
								fromMODULE[1], 
								fromMODULE[0], 
								fromOffer, 
								aContext);
					}
					finally{
						
					}
					return aOBJECT;
				}
				/**
				 * 属性模板引用,格式为$XPF[属性模板编码]或$XPF[属性模板编码.属性编码]
				 * 样例为$XPF[PBKDM_VPMNV2_NEWSALE]或$XPF[PBKDM_VPMNV2_NEWSALE.CVPMN_NOTABLE]
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_refxpf( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					Object aOBJECT = null;
					try
					{
						String aCOMPLEX = StringUtils.substringBetwn( aJEXP , "$XPF[" , "]" );
						aOBJECT = IUpdcpFactory.getIUpfvmSV().finishSFXPathChain(aCOMPLEX, 
								fromOffer, 
								aContext);
					}
					finally{
						
					}
					return aOBJECT;
				}
				/**
				 * 批量引用,格式为$BPF[属性模板或$BPF[批量属性头],循环属性编码,$REF[模板编码]]或$BPF[属性模板或$BPF[批量属性头],循环属性编码]
				 * @param aJEXP 
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_refbpf( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					Object aOBJECT = null;
					try
					{
						String fromMODULE = aJEXP;
						aOBJECT = IUpdcpFactory.getIUpfvmSV().finishSFUpdbpfChain("NULL", 
								"NULL", 
								fromMODULE, 
								fromOffer, 
								aContext);
					}
					finally{
						
					}
					return aOBJECT;
				}
				/**
				 * 批量属性引用,格式为$BMF[属性1=属性11,属性2=属性21....]
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_refbmf( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					Object aOBJECT = null;
					try
					{
						String fromMODULE = aJEXP;
						aOBJECT = IUpdcpFactory.getIUpfvmSV().finishSFUpdbpfChain( "NULL", 
								"NULL", 
								fromMODULE, 
								fromOffer, 
								aContext);
					}
					finally{
						
					}
					return aOBJECT;
				}
				/**
				 * 位字符引用,格式为$BTF[属性模板编码.属性编码],样例为$BTF[PBKDM_PVPMNV2_NEWSALE.PVPMN_FLAGS]
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public String _jj_refbtf( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					String aOBJECT = null;
					try
					{
						IProgramTemplate.IUpdffgsmOffer fromUpffxm = null;
						String arguments[] = StringUtils.wildcardArray( StringUtils.substringBetwn( aJEXP , "$BTF[" , "]" ) , "." );
						if( arguments == null || arguments.length <= 1 || StringUtils.isBlank( arguments[0] ) || StringUtils.isBlank( arguments[1] ) )
							ExceptionFactory.throwJeval("IOS0011021", new String[]{"$BTF[TEMPLATE.IPXPID]","TEMPLATE.IPXPID"} );
						fromUpffxm = IUpdcfgFactory.getIUpdcpmSV().getSFUpffxmOffer(arguments[0], arguments[1]);
						aOBJECT = IUpdcpFactory.getIUpfvmSV().finishSFUpdbtfChain(fromUpffxm, 
								fromOffer, 
								aContext);
					}
					finally{
						
					}
					return aOBJECT != null?aOBJECT.toString():null;
				}
				/**
				 * 函数引用,格式为$FUN.方法名(参数清单)
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_reffun( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					Object _objective = null;
					try
					{
						_objective = IUpdcpFactory.getIUpfvmSV().finishSFUpdfunChain("NULL", 
								aJEXP, 
								fromOffer, 
								aContext);
					}
					finally{
						
					}
					return _objective;
				}
				
				/**
				 * 其他引用
				 * @param aJEXP
				 * @param fromOffer
				 * @param aContext
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public Object _jj_other( String aJEXP , 
						java.util.Map fromOffer , 
						IUpdcContext aContext ) throws SFException,Exception{
					Object aOBJECT = null;
					try
					{
						//%PARAM%订单开通串;%LDPWM%调用订购属性;%LDPAP%上下文对象;
						if( StringUtils.equals( aJEXP , "%PARAM%")/*开通串*/ ){
							IOVTaskPentium fromTASK = UpdcUtils.ISubFlow.getTASK( aContext );
							IOVUpfwmOffer fromUpfwm = UpdcUtils.ISubFlow.getPROVISION( aContext );
							aOBJECT = fromUpfwm != null?fromUpfwm.getORDER().getOFFER():
								(fromTASK != null?fromTASK.getORDER().getOFFER().getORDER().getOFFER():null);
						}
						else if( StringUtils.equals( aJEXP , "%LDPWM%")/*函数订购属性*/ ){
							aOBJECT = fromOffer;
						}
						else if( StringUtils.equals( aJEXP , "%LDPAP%")/*函数上下文对象*/ ){
							aOBJECT = aContext;
						}
						else if( StringUtils.startWith( aJEXP , "$" ) ){
							aJEXP = StringUtils.substring( aJEXP , 1 , aJEXP.length() );
							aOBJECT = UpfgsmUtils.IUpfsm._jj_context(aJEXP,
									fromOffer, 
									aJEXP, 
									aContext);
						}
						else{
							aOBJECT = UpfgsmUtils.IUpfsm._jj_context( aJEXP, 
									fromOffer, 
									aJEXP, 
									aContext);
						}
					}
					finally{
						
					}
					return aOBJECT;
				}
			}
			IUpfwmOfferImpl fromUpdbmImpl = new IUpfwmOfferImpl();
			try
			{
				if( StringUtils.startWith( fromCOMPLEX, "#[" )/*常量模板*/ )
					aOBJECT = fromUpdbmImpl._jj_conston( fromCOMPLEX, fromOffer, aContext );
				else if( StringUtils.startWith( fromCOMPLEX, "$REF[" ) )
					aOBJECT = fromUpdbmImpl._jj_refref( fromCOMPLEX, fromOffer, aContext );
				else if( StringUtils.startWith( fromCOMPLEX, "$XPF[" ) /*引用属性模板*/)
					aOBJECT = fromUpdbmImpl._jj_refxpf( fromCOMPLEX, fromOffer, aContext );
				else if( StringUtils.startWith( fromCOMPLEX, "$BTF[" ) /*位字符模板*/)
					aOBJECT = fromUpdbmImpl._jj_refbtf( fromCOMPLEX, fromOffer, aContext );
				else if( StringUtils.startWith( fromCOMPLEX, "$BPF[") /*批量模板*/)
					aOBJECT = fromUpdbmImpl._jj_refbpf( fromCOMPLEX, fromOffer, aContext );
				else if( StringUtils.startWith( fromCOMPLEX, "$BMF[") /*批量属性*/)
					aOBJECT = fromUpdbmImpl._jj_refbmf( fromCOMPLEX, fromOffer, aContext );
				else if( StringUtils.startWith( fromCOMPLEX, "$FUN") /*采用VTL方法模版*/)
					aOBJECT = fromUpdbmImpl._jj_reffun( fromCOMPLEX, fromOffer, aContext );
				else if( StringUtils.startWith( fromCOMPLEX, "${{" )/*DATAIDD=${{IProduct.STATE,1=C&2=E}}*/ )
					aOBJECT = fromUpdbmImpl._jj_splite( fromCOMPLEX, fromOffer, aContext );
				else if( StringUtils.startWith( fromCOMPLEX, "${" ) /*DATAIDD=${IProduct.STATE}或者DATAIDD=${IProduct.STATE,0}*/)
					aOBJECT = fromUpdbmImpl._jj_variable( fromCOMPLEX , fromOffer, aContext);
				else if( StringUtils.startWith( fromCOMPLEX, "#{" ) /*DATAIDD=#{#[IProduct.STATE]}*/)
					aOBJECT = fromUpdbmImpl._jj_jeval( fromCOMPLEX , fromOffer, aContext );
				else if( StringUtils.isBlank( fromCOMPLEX ) == false /*DATADDD=DTIDD*/ )
					aOBJECT = fromUpdbmImpl._jj_other( fromCOMPLEX , fromOffer, aContext );
			}
			finally{
				if( fromUpdbmImpl != null ){ fromUpdbmImpl = null; }
			}
		}
		finally{
			
		}
		return aOBJECT;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpdbmOffer(com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmxOffer, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public Object finishSFUpdbmOffer(ISystemTemplate.IUpfgsmxOffer fromUpffxm, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		Object fromUpffmx = null;
		try
		{
			String aCOMPLEX = fromUpffxm.getCOMPLEX();
			if( StringUtils.isBlank( aCOMPLEX ) ) aCOMPLEX = fromUpffxm.getCOMPETE();
			if( StringUtils.isBlank( fromUpffxm.getIMPLCLASS() )/*按照默认映射规则*/ ){
				fromUpffmx = finishSFUpfvnChain( aCOMPLEX, 
						fromOffer, 
						aContext );
			}
			else/*按照映射组件映射*/{
				IUpfgsmSystem fromUpfgsmImpl = UpdcpmUtils.ISystem.getIUpffxmSV( fromUpffxm.getIMPLCLASS() );
				fromUpffmx = fromUpfgsmImpl.finishSFUpfgsmc(fromUpffxm, 
						fromOffer, 
						aContext);
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
			ExceptionFactory.throwIllegal("IOS0011084", new String[]{ fromUpffxm.getID(), 
					fromUpffxm.getCOMPETE(), exception.getMessage() });
		}
		finally{
			
		}
		return fromUpffmx;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpdbmOffer(com.ai.sacenter.valuebean.IProgramTemplate.IUpdffsmOffer, java.util.Map, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.Map finishSFUpdbmOffer(IProgramTemplate.IUpdffsmOffer fromUpffwm, 
			java.util.Map fromOffer, 
			java.util.Map fromUpfgsm, 
			IUpdcContext aContext) throws SFException, Exception {
		IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
		try
		{
			fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.MAPPING, fromUpfgsm );
			IProgramTemplate.IUpdffgsmOffer fromUpffxm = null;
			for( java.util.Iterator itera = fromUpffwm.getCOMPETENCE().iterator(); itera.hasNext(); ){
				fromUpffxm = (IProgramTemplate.IUpdffgsmOffer)itera.next();
				Object aOBJECT = finishSFUpdbmOffer( fromUpffxm, fromOffer, fromLDAP );
				UpfgsmUtils.IUpfvm.wrap( fromUpffxm.getMAPPING(), 
						aOBJECT , 
						fromOffer, 
						fromUpfgsm, 
						fromLDAP );
			}
		}
		finally{
			if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null; }
		}
		return fromUpfgsm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpdbmOffer(java.lang.String, java.util.Map, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public java.util.Map finishSFUpdbmOffer(String fromMODULE,
			java.util.Map fromOffer, 
			java.util.Map fromUpfwm, 
			IUpdcContext aContext) throws SFException, Exception {
		IUpdcpmGroup fromGroup = null;
		try
		{
			IProgramTemplate.IUpdffsmOffer fromUpffwm = null;
			fromGroup = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcmptCatalog(fromMODULE, fromOffer, aContext);
			for( java.util.Iterator itera = fromGroup.getPROGRAM().getGROUP().iterator(); itera.hasNext(); ){
				fromUpffwm = (IProgramTemplate.IUpdffsmOffer)itera.next();
				finishSFUpdbmOffer(fromUpffwm, 
						fromOffer, 
						fromUpfwm, 
						aContext);
			}
		}
		finally{
			if( fromGroup != null ){ fromGroup = null; }
		}
		return fromUpfwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpdbmChain(java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public String finishSFUpdbmChain(String fromID, 
			String fromFILE, 
			String fromPROTOCOL, 
			java.util.Map fromOffer, 
			java.util.Map fromUpfgsm, 
			IUpdcContext aContext) throws SFException, Exception {
		String fromPLMX = fromPROTOCOL;
		java.util.Map fromChain = null;
		try
		{
			fromChain = getSFUpdbmChain(null, fromOffer, fromUpfgsm,  aContext);
			if( StringUtils.equals( fromFILE, IUpdcConst.IUpfwm.IUpdpfm.VM )/*采用VM语言*/){
				fromPLMX = IUpfvmsSTKLocal.getINSTANCE().evaluate(fromID,
						fromPROTOCOL, 
						fromChain, 
						fromOffer, 
						aContext);
			}
			else if( StringUtils.equals( fromFILE, IUpdcConst.IUpfwm.IUpdpfm.WM )/*采用WM语言*/){
				fromPLMX = IUpfwmsSTKLocal.getINSTANCE().evaluate(fromID, 
						fromPROTOCOL, 
						fromChain, 
						fromOffer, 
						aContext);
			}
			else/*其他采用WM语言*/{
				fromPLMX = IUpfwmsSTKLocal.getINSTANCE().evaluate(fromID, 
						fromPROTOCOL, 
						fromChain, 
						fromOffer, 
						aContext);
			}
		}
		finally{
			if( fromChain != null ){ fromChain.clear(); fromChain = null;}
		}
		return fromPLMX;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpdbmChain(java.lang.String, java.lang.String, java.util.Map, java.util.Map, com.ai.sacenter.common.IUpdcContext)
	 */
	public String finishSFUpdbmChain(String fromID, 
			String fromMODULE, 
			java.util.Map fromOffer, 
			java.util.Map fromUpfgsm, 
			IUpdcContext aContext) throws SFException, Exception {
		String fromPLMMX = fromMODULE;
		java.util.Map fromChain = null;
		try
		{
			IPlatformTemplate.IUpffmProtocol fromPLMM = null;
			if( StringUtils.startWith( fromMODULE , "$REF[" ) ){
				fromMODULE = StringUtils.substringBetwn( fromMODULE, "$REF[", "]" );
			}
			fromPLMM = IUpdcfgFactory.getIUpffmSV().getSFUpffmProtocol( fromMODULE );
			fromPLMMX = finishSFUpdbmChain(fromPLMM.getID(), 
					fromPLMM.getFILE_TYPE(), 
					fromPLMM.getPLMMX(), 
					fromOffer, 
					fromUpfgsm, 
					aContext);
		}
		finally{
			if( fromChain != null ){ fromChain.clear(); fromChain = null;}
		}
		return fromPLMMX;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpdbmChain(java.lang.String, java.util.Map, com.ai.sacenter.IUpdcContext)
	 */
	public String finishSFUpdbmChain(String fromMODULE, 
			java.util.Map fromOffer, 
			IUpdcContext aContext) throws SFException, Exception {
		String fromPLMMX = fromMODULE;
		try
		{
			fromPLMMX = finishSFUpdbmChain(fromMODULE, 
					fromMODULE, 
					fromOffer, 
					null, 
					aContext);
		}
		finally{
		
		}
		return fromPLMMX;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpdbmChain(com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer[], java.util.Map, java.util.Map, java.lang.String, com.ai.sacenter.common.IUpdcContext)
	 */
	public String finishSFUpdbmChain(IPlatformTemplate.IUpffgsmOffer fromUpfgsm, 
			IPlatformTemplate.IUpffgsmOffer[] fromUpfgsmc, 
			java.util.Map fromOffer, 
			java.util.Map fromUpfsm, 
			String fromPROTOCOL, 
			IUpdcContext aContext) throws SFException, Exception {
		String fromPLMMX = null;
		try
		{
			String fromID = fromUpfgsm != null?fromUpfgsm.getCOMPETE():fromPROTOCOL;
			fromPLMMX = finishSFUpdbmChain(fromID, 
					fromPROTOCOL, 
					fromOffer, 
					fromUpfsm, 
					aContext);
			fromPLMMX = StringUtils.isBlank( fromPLMMX ) == false?fromPLMMX:null;
		}
		finally{
			
		}
		return fromPLMMX;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV#finishSFUpdbmChain(java.lang.String, com.ai.sacenter.valuebean.IPlatformTemplate.IUpffgsmOffer, java.util.Map, java.lang.String, com.ai.sacenter.common.IUpdcContext)
	 */
	public String finishSFUpdbmChain(String fromMODULE, 
			IPlatformTemplate.IUpffgsmOffer fromUpfgsm, 
			java.util.Map fromOffer, 
			String fromPROTOCOL, 
			IUpdcContext aContext) throws SFException, Exception {
		String fromPLMMX = null;
		UpfsvcManager.getRocket().beginTransaction(fromUpfgsm, fromOffer, aContext);
		try
		{
			IOVUpfgsmCatalog fromUpfsm = null;
			IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
			try
			{
				fromUpfsm = IUpdcpFactory.getIUpfsmSV().finishSFUpfgsmOffer( fromMODULE, 
						fromUpfgsm, 
						fromOffer, 
						fromLDAP );
				IPlatformTemplate.IUpffgsmOffer fromUpfgsmc[] = null;
				fromUpfgsmc = UpfgsmUtils.ICustom.getICSTKUpfgsmc();
				fromPLMMX = finishSFUpdbmChain(fromUpfgsm, 
						fromUpfgsmc, 
						fromOffer, 
						fromUpfsm.getMAPPINGS(), 
						fromPROTOCOL, 
						fromLDAP);
			}
			finally{
				if( fromLDAP != null ){ fromLDAP.clear(); fromLDAP = null;}
				if( fromUpfsm != null ){ fromUpfsm.getMAPPINGS().clear(); fromUpfsm = null;}
			}
			UpfsvcManager.getRocket().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			UpfsvcManager.getRocket().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromPLMMX;
	}

}
