package com.ai.sacenter.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.HQSQLUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017Äê12ÔÂ13ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class HQSQLOffer implements java.io.Serializable{
	protected final static Log log = LogFactory.getLog( HQSQLOffer.class );
	private static final long serialVersionUID = 6087092022261311202L;
	public HQSQLOffer() {
		super();
	}
	
	/**
	 * 
	 * @param _type
	 * @param _field
	 * @param _objective
	 * @throws SFException
	 */
	public void validate( ObjectType _type, String _field, Object _objective ) throws SFException{
		try
		{
			HQSQLTable _table = HQSQLUtils.getCheckSum( _type );
			if( _table != null ){
				HQSQLTable.HQSQLColumn __column__  = _table.getProperty( _field );
				HQSQLFactory.getDialect().validate( _table, __column__, _objective );
			}
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwOracleInside("IOS0014000", 
					new String[]{exception.getMessage()}, 
					exception );
		}
		finally{
			
		}
	}
}
