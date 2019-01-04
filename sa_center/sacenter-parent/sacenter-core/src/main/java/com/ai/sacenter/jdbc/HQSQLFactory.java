package com.ai.sacenter.jdbc;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.dialect.MySQL5DialectImpl;
import com.ai.sacenter.jdbc.dialect.OracleDialectImpl;
import com.ai.sacenter.jdbc.dialect.SybaseDailectImpl;
import com.ai.sacenter.jdbc.interfaces.IDataStoreSRV;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.subtable.ISubTableWrapper;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-10-3</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class HQSQLFactory {
	private static final java.util.Map _runtime_composite = new java.util.concurrent.ConcurrentHashMap();
	public HQSQLFactory(){
		super();
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IDataStoreSRV getIDataStoreSV() throws SFException,Exception{
		return (IDataStoreSRV)UpfsvcFactory.getService( IDataStoreSRV.class );
	}
	/**
	 * 
	 * @param fromJAVA
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static ISubTableWrapper getIDataStoreSV( String fromJAVA ) throws SFException,Exception{
		return (ISubTableWrapper) IUpdcFactory.getIUpdcsSV(fromJAVA,
				IUpdcConst.IEnum.IInvoke.SingletonT,
				ISubTableWrapper.class.getName(), 
				fromJAVA);
	}
	/**
	 * 获取基于JDBC_APP模式仓库存储访问类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static OracleDialectImpl getOracle() throws SFException,Exception{
		OracleDialectImpl fromORACLE = null;
		try
		{
			fromORACLE = (OracleDialectImpl)getDialect( HQSQLConst.Category.ORACLE );
		}
		finally{
			
		}
		return fromORACLE;
	}
	/**
	 * 获取基于JDBC_HQSQL模式仓库存储访问类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static MySQL5DialectImpl getMySQL5() throws SFException,Exception{
		MySQL5DialectImpl fromMYSQL5 = null;
		try
		{
			fromMYSQL5 = (MySQL5DialectImpl)getDialect( HQSQLConst.Category.MYSQL5 );
		}
		finally{
			
		}
		return fromMYSQL5;
	}
	/**
	 * 获取基于JDBC_HQSQL模式仓库存储访问类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static SybaseDailectImpl getSyBase() throws SFException,Exception{
		SybaseDailectImpl fromSYBASE = null;
		try
		{
			fromSYBASE = (SybaseDailectImpl)getDialect( HQSQLConst.Category.SYBASE );
		}
		finally{
			
		}
		return fromSYBASE;
	}
	
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IHQSQLDialect getDialect( ) throws SFException{
		return getDialect( HQSQLConst.Category.ORACLE );
	}
	
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IHQSQLDialect getDialect( String aCOMPOSITE ) throws SFException{
		IHQSQLDialect fromDialect = null;
		try
		{
			String fromINDEX = ClassUtils.getINDEX(new String[]{"_$_HQSQLDialect", "_$_", aCOMPOSITE} );
			if( ( fromDialect = (IHQSQLDialect)_runtime_composite.get( fromINDEX ) ) == null ){
				synchronized ( _runtime_composite ){
					IConfigDefine.IGlobalDefine.IControlDefine aConfigure = null;
					if( ( fromDialect = (IHQSQLDialect)_runtime_composite.get( fromINDEX ) ) == null ){
						aConfigure = IConfigDefine.getINSTANCE().getControl();
						String fromCLASS = (String)aConfigure.getDIALECT().get( aCOMPOSITE );
						if( StringUtils.isBlank( fromCLASS ) ){
							if( StringUtils.equals( aCOMPOSITE, HQSQLConst.Category.ORACLE ) )
								fromCLASS = com.ai.sacenter.jdbc.dialect.OracleDialectImpl.class.getName();
							else if( StringUtils.equals( aCOMPOSITE, HQSQLConst.Category.SYBASE ) )
								fromCLASS = com.ai.sacenter.jdbc.dialect.SybaseDailectImpl.class.getName();
							else if( StringUtils.equals( aCOMPOSITE, HQSQLConst.Category.MYSQL5 ) )
								fromCLASS = com.ai.sacenter.jdbc.dialect.MySQL5DialectImpl.class.getName();
						}
						if( StringUtils.isBlank( fromCLASS ) ) ExceptionFactory.throwOracle("IOS0014015", new String[]{aCOMPOSITE});
						fromDialect = (IHQSQLDialect)Class.forName( fromCLASS ).newInstance();
						_runtime_composite.put( fromINDEX , fromDialect );
					}
				}
			}
		}
		catch( java.lang.Exception aEXCEPTION ){
			ExceptionFactory.throwOracle("IOS0014021", new String[]{aCOMPOSITE , 
					aEXCEPTION.getMessage()}, 
					aEXCEPTION );
		}
		finally{
			
		}
		return fromDialect;
	}	
	
}
