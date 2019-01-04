package com.ai.sacenter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.jeval.PhantomEvaluator;
import com.ai.sacenter.util.ReflectUtils;
import com.ai.sacenter.util.StackDeque;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: 本地类调用器</p>
 * <p>Copyright: Copyright (c) 2017年9月2日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdfvnSTKLocal {
	private final static Log log = LogFactory.getLog( IUpdfvnSTKLocal.class );
	private static IUpdfvnSTKLocal INSTANCE = null;
	public IUpdfvnSTKLocal(){
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public static IUpdfvnSTKLocal getINSTANCE(){
		if( INSTANCE == null ){
			synchronized ( IUpdfvnSTKLocal.class ) {
				if( INSTANCE == null ){
					try{
						INSTANCE = new IUpdfvnSTKLocal();
					}
					catch( java.lang.Exception tt){
						throw new java.lang.RuntimeException( tt.getMessage() , tt );
					}
				}
			}
		}
		return IUpdfvnSTKLocal.INSTANCE;
	}
	
	/**
	 * 
	 * @param expression 正值表达式
	 * @param _variables
	 * @return
	 * @throws Exception
	 */
	public Object evaluate ( String expression, java.util.HashMap _variables ) throws Exception{
		Object _objective = null;
		PhantomEvaluator _phantom = null;
		try
		{
			if( StringUtils.isBlank( expression ) == false ){
				_phantom = new PhantomEvaluator( _variables );
				_objective = _phantom.evaluate( expression );
				if( log.isDebugEnabled() ) log.debug( _objective );
			}
		}
		finally{
			if( _phantom != null ){ _phantom = null; }
		}
		return _objective;
	}
}
