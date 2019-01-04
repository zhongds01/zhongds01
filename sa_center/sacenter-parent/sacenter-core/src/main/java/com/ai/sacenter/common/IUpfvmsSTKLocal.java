package com.ai.sacenter.common;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.FileUtils;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StackDeque;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: VM模板语言</p>
 * <p>Copyright: Copyright (c) 2014-4-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class IUpfvmsSTKLocal {
	private final static java.util.Map _runtime_protocol = new java.util.concurrent.ConcurrentHashMap();
	private static IUpfvmsSTKLocal INSTANCE = null;
    public IUpfvmsSTKLocal() {
		super();
	}
	/**
	 * 
	 * @return
	 */
	public static IUpfvmsSTKLocal getINSTANCE(){
		if( INSTANCE == null ){
			synchronized ( IUpfvmsSTKLocal.class ) {
				if( INSTANCE == null ){
					try{
						INSTANCE = new IUpfvmsSTKLocal();
						INSTANCE.finishIEnviron( new java.util.HashMap() );
					}
					catch( java.lang.Exception tt){
						throw new java.lang.RuntimeException( tt.getMessage() , tt );
					}
				}
			}
		}
		return IUpfvmsSTKLocal.INSTANCE;
	}
	/**
	 * 
	 * @param aJEnvic
	 * @throws Exception
	 */
	public void finishIEnviron( java.util.Map aJEnvic ) throws Exception{
		for( java.util.Iterator itera = aJEnvic.entrySet().iterator() ;  itera.hasNext() ; ){
			java.util.Map.Entry e = (java.util.Map.Entry)itera.next();
			IUpfvm._environ( e.getKey().toString() , e.getValue() );	
		}
		Velocity.init();
	}
	/**
	 * 根据VM模板调用VM引用,返回内容中包含$则抛异常
	 * @param fromID 模板编号
	 * @param fromMODULE  VM模板
	 * @param fromUpfgsm  其他属性集
	 * @param fromOffer 产品能力集,以IUpdgdspL键存放对象中
	 * @param aContext
	 * @return
	 * @throws Exception
	 */
	public String evaluate(String fromID,
			String fromMODULE , 
			java.util.Map fromUpfgsm , 
			java.util.Map fromOffer,
			IUpdcContext aContext ) throws Exception{
		String aOBJECT = null;
		java.util.Map fromChain = new java.util.HashMap();
		try
		{
			IUpfvm.submit( fromUpfgsm, fromChain );
			IUpfvm.submit( fromOffer, fromChain );
			IUpfvm.submit( aContext , fromChain );
			fromChain.put( IUpdcConst.IUpdbm.IUpdbf.PARAM, fromOffer );
			fromChain.put( IUpdcConst.IUpdbm.IUpdbf.LDPAP, aContext );
			aOBJECT = evaluate( fromID, fromMODULE, fromChain );
		}
		finally{
			if( fromChain != null ){ fromChain.clear(); fromChain = null;}
		}
		return aOBJECT;
	}
	/**
	 * 根据VM模板调用VM引用,返回内容中包含$则抛异常
	 * @param fromID 模板编号
	 * @param fromMODULE 模板文件或模板内容
	 * @param fromChain 模板属性集
	 * @return
	 * @throws Exception
	 */
	public String evaluate(String fromID,
			String fromMODULE , 
			java.util.Map fromChain ) throws Exception{
		String aOBJECT = null;
		try
		{
			if( StringUtils.startWith( fromMODULE, "$REF[" ) ){
				ExceptionFactory.throwIllegal("IOS0010013", new String[]{fromID != null?
						fromID:"NULL",fromMODULE} );
			}
			aOBJECT = evaluate( fromMODULE, fromChain );
			if( StringUtils.contains( aOBJECT , IUpdcConst.IEnum.ISschk.ISC$ ) ){
				ExceptionFactory.throwRuntime("IOS0010014", new String[]{fromID != null?
						fromID:"NULL",aOBJECT});
			}
			aOBJECT = StringUtils.isBlank( aOBJECT )?null:aOBJECT;
		}
		finally{
		
		}
		return aOBJECT;
	}
	/**
	 * 根据VM模板调用VM引用[返回内容中$则直接返回]
	 * @param fromMODULE 模板文件或模板内容
	 * @param fromChain 模板属性集
	 * @return
	 * @throws Exception
	 */
	public String evaluate(String fromMODULE , 
			java.util.Map fromChain ) throws Exception{
		String aOBJECT = null;
		VelocityContext aContext = null;
		try
		{
			aContext = new VelocityContext();
			IUpfvm.submit( fromChain , aContext );
			aOBJECT = IUpfvm.evaluate( fromMODULE, 
					IConfigDefine.getINSTANCE().getConfigItem().getKERNEL(), 
					aContext );
		}
		finally{
			if( aContext != null ) { aContext = null; }
		}
		return aOBJECT;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-5-28</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	private static class IUpfvm{
		private IUpfvm(){
			super();
		}
		/**
		 * 
		 * @param aTEMPLATE
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		private static String _wrap( String aTEMPLATE ) throws SFException, Exception{
			String fromPLMM = aTEMPLATE;
			try
			{
				if( StringUtils.endsIgnoreCaseWith( aTEMPLATE , ".vm" ) || 
						StringUtils.endsIgnoreCaseWith( aTEMPLATE, ".wm" ) ){
					if( (fromPLMM = (String)_runtime_protocol.get( aTEMPLATE ) ) == null ){
						synchronized ( _runtime_protocol ){
							if( (fromPLMM = (String)_runtime_protocol.get( aTEMPLATE ) ) == null ){
								java.io.InputStream aInputStream = ClassUtils.IClass.getClassLoaderResource( aTEMPLATE );
								try
								{
									if( aInputStream == null ) ExceptionFactory.throwRuntime("IOS0010016", new String[]{aTEMPLATE} );
									byte aByte[] = FileUtils.IFile.readFile( aInputStream );
									_runtime_protocol.put( aTEMPLATE , fromPLMM = new String( aByte , 0 , aByte.length ) );
								}
								finally{
									if( aInputStream != null ){ aInputStream.close(); aInputStream = null;}
								}
							}
						}
					}
				}
			}
			finally{
				
			}
			return fromPLMM;
		}
		/**
		 * 
		 * @param aKEY
		 * @param aVALUE
		 */
		private static void _environ( String aKEY , Object aVALUE ){
			if( aVALUE == null ) return;
			if( aVALUE instanceof java.lang.String ) Velocity.setProperty( aKEY , aVALUE );
			else if( aVALUE instanceof java.util.List ){
				for( java.util.Iterator itera = ((java.util.List)aVALUE).iterator() ; itera.hasNext() ;  )
					_environ( aKEY , itera.next() );
			}
			else if( aVALUE instanceof java.util.Map ){
				for( java.util.Iterator itera = ((java.util.Map)aVALUE).entrySet().iterator(); itera.hasNext() ;  ){
					java.util.Map.Entry e = (java.util.Map.Entry)itera.next();
					_environ( e.getKey().toString() , e.getValue() );
				}
			}
		}
		/**
		 * 
		 * @param aTEMPLATE
		 * @param aUpdgkernImpl
		 * @param aContext
		 * @return
		 * @throws Exception
		 */
		public static String evaluate( String aTEMPLATE , 
				String aUpdgkernImpl, 
				VelocityContext aContext ) throws Exception{
			String aRESULT = "";
			java.io.Writer aWriter = null;
			try
			{
				aTEMPLATE = _wrap( aTEMPLATE );
				aWriter = new java.io.StringWriter();
				aTEMPLATE = macro( aTEMPLATE , aUpdgkernImpl , aContext );
			    Velocity.evaluate( aContext, aWriter, "ucmframe$VelociEngine", aTEMPLATE);
				aRESULT = aWriter.toString();
			}
			catch(Exception e){
				throw e;
			}
			finally{
				try{if( aWriter != null ){ aWriter.close(); aWriter = null;}
				}catch( java.lang.Exception t){}
			}
			return aRESULT;
		}
		/**
		 * 
		 * @param aTEMPLATE
		 * @return
		 */
		private static boolean _isExistMacro( String aTEMPLATE ){
			return StringUtils.contains(aTEMPLATE, "[" ) && StringUtils.contains(aTEMPLATE, "]" );
		}
		/**
		 * 
		 * @param aTEMPLATE
		 * @param aMACRO_
		 * @return
		 * @throws Exception
		 */
		private static String _macro( String aTEMPLATE , String aMACRO_ ) throws Exception{
			StackDeque fromDeque = new StackDeque();
		    try
			{
		    	int aMACRO_0 = StringUtils.indexOf( aTEMPLATE , aMACRO_ ) , aMACRO_1 = 0 ;
		    	if( aMACRO_0 < 0 ) return aTEMPLATE;
		    	aMACRO_0 = aMACRO_0 + aMACRO_.length() - 1;
				for( aMACRO_1 = aMACRO_0 ; aMACRO_1 < aTEMPLATE.length(); aMACRO_1++ ){
					if( aTEMPLATE.charAt( aMACRO_1 ) == '[' ){
						fromDeque.push( String.valueOf( '[' ) );
	    				aMACRO_1 += 1 ;
	    			}
	    			else if( aTEMPLATE.charAt( aMACRO_1 ) == ']' ){
	    				if( fromDeque.size() <= 0 ) throw new java.lang.RuntimeException( "arguments are required."  );
	    				fromDeque.pop();
	    				if( fromDeque.size() <= 0 ) break;
	    			}
				}
				if( fromDeque.size() > 0 ) throw new java.lang.RuntimeException( "arguments are required."  );
				StringBuilder temp = new StringBuilder( aTEMPLATE );
				temp.setCharAt( aMACRO_0 , '(' );temp.setCharAt( aMACRO_1 , ')' );
				aTEMPLATE = temp.toString();
			}
			finally{
				if( fromDeque != null ){ fromDeque.clear(); fromDeque = null;} 
			}
			return _macro( aTEMPLATE , aMACRO_ );
		}
		/**
		 * 
		 * @param aTEMPLATE
		 * @param aUpdgkernLife
		 * @param aContext
		 * @return
		 * @throws Exception
		 */
		private static String macro( String aTEMPLATE , 
				String fromKERNEL, 
				VelocityContext aContext ) throws Exception{
			try
			{
				submit( new Object[][]{{"FUN", Class.forName( fromKERNEL ).newInstance() } }, aContext );
				if( _isExistMacro( aTEMPLATE ) ){
					ISystemTemplate.ISystemNative fromNative = ReflectUtils.getNative( Class.forName( fromKERNEL ) );
					for( java.util.Iterator itera = fromNative.getMethods().iterator() ; itera.hasNext() ; ){
						java.lang.reflect.Method aMethod = (java.lang.reflect.Method)itera.next();
						String aMACRO_ = ClassUtils.getINDEX( new String[]{"$FUN.", aMethod.getName(), "[" } );
						if( StringUtils.contains( aTEMPLATE , aMACRO_ ) == false ) continue;
			            aTEMPLATE = _macro( aTEMPLATE, aMACRO_ );	
			            if( _isExistMacro( aTEMPLATE ) == false ) break;
					}
				}
			}
			finally{
				
			}
			return aTEMPLATE;
		}
		/**
		 * 
		 * @param aUpdgcpLife
		 * @param aContext
		 */
		private static void submit( Object aUpdgcpLife[][] , VelocityContext aContext ){
			for( int index = 0 ; index < aUpdgcpLife.length; index++ ){
				if( aContext.containsKey( aUpdgcpLife[index][0] ) ) continue; 
				aContext.put( (String)aUpdgcpLife[index][0] , aUpdgcpLife[index][1] );
			}
		}
		/**
		 * 
		 * @param aUpdgcpLife
		 * @param aContext
		 */
		private static void submit( java.util.Map aUpdgcpLife, 
				VelocityContext aContext ){
			if( aUpdgcpLife != null ){
				for(java.util.Iterator itera = aUpdgcpLife.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					if( aContext.containsKey( aEntry.getKey().toString() ) ) continue; 
					aContext.put( aEntry.getKey().toString() , aEntry.getValue());
				}
			}
		}
		/**
		 * 
		 * @param aUpdgspLife
		 * @param aUpdvmLife
		 */
		public static void submit(java.util.Map aUpdgspLife , 
				java.util.Map aUpdvmLife ){
			try
			{
				if( aUpdgspLife != null && aUpdgspLife.size() > 0 ){
					for(java.util.Iterator itera = aUpdgspLife.entrySet().iterator() ; itera.hasNext() ; ){
						java.util.Map.Entry e = (java.util.Map.Entry)itera.next();
						if( aUpdvmLife.containsKey( e.getKey() ) == false ) 
							aUpdvmLife.put(e.getKey() , e.getValue());
					}
				}
			}
			finally{
				
			}
		}
	}
}
