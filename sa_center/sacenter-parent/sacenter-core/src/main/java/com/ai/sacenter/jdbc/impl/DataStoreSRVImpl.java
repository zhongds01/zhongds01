package com.ai.sacenter.jdbc.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLDelegate;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.jdbc.NoSQLDelegate;
import com.ai.sacenter.jdbc.interfaces.IDataStoreSRV;
import com.ai.sacenter.util.ClassUtils;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-4-10</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class DataStoreSRVImpl extends UpdcEclipseImpl implements IDataStoreSRV {
	private final static Log log = LogFactory.getLog( DataStoreSRVImpl.class );
	public DataStoreSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.interfaces.IDataStoreSRV#getSysdate()
	 */
	public java.sql.Timestamp getSysdate() throws SFException, Exception {
		java.sql.Timestamp fromSysdate = null;
		try
		{
			fromSysdate = HQSQLFactory.getOracle().getSysdate();
		}
		finally{
			
		}
		return fromSysdate;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.jdbc.interfaces.IDataStoreSRV#finish(java.lang.String, java.util.List)
	 */
	public void finish(String fromDAO, java.util.List fromUpdbm) throws SFException, Exception {
		try
		{
			class SFUpdfmxTfImpl{
				public SFUpdfmxTfImpl(){
					super();
				}
				
				/**
				 * 
				 * @param _objective
				 * @param fromMBean
				 * @throws SFException
				 * @throws Exception
				 */
				public void transferWithDailect( Object _objective, NoSQLDelegate fromMBean ) throws SFException,Exception{
					try
					{
						if( ClassUtils.IClass.isMap( _objective )/*基于JDBC_SYBASE模式*/){
							HQSQLFactory.getSyBase().transfer( _objective, fromMBean );
						}
						else if( ClassUtils.IClass.isContainer( _objective )/*基于JDBC_ORACLE模式*/ ){
							HQSQLFactory.getOracle().transfer( _objective, fromMBean );
						}
						else if( ClassUtils.IClass.isMYSQL5( _objective )/*JDBC_MYSQL模式*/){
							HQSQLFactory.getMySQL5().transfer( _objective, fromMBean );
						}
						else if( ClassUtils.IClass.isLittle( _objective ) /*JDBC_LITTLE模式*/){
							IUpdfmxLittle fromLittle = (IUpdfmxLittle)_objective;
							transferWithDailect( fromLittle.getINSTANCE(), fromMBean );
							for( java.util.Iterator itera = fromLittle.getLittle().getLITTLE().iterator(); itera.hasNext(); ){
								IUpdfmxLittle ____little = (IUpdfmxLittle)itera.next();
								transferWithDailect( ____little, fromMBean );
							}
						}
						else if( _objective != null ){
							ExceptionFactory.throwOracle("IOS0014011", new String[]{_objective.getClass().getName()});
						}
					}
					finally{
						
					}
				}
				
			}
			SFUpdfmxTfImpl fromUpdfmxImpl = new SFUpdfmxTfImpl();
			NoSQLDelegate fromMBean = new NoSQLDelegate( fromUpdbm, fromDAO );
			try
			{
				NoSQLDelegate.IUpdfmxOffer fromUpdfmx = fromMBean.getSUBFLOW();
				for( java.util.Iterator itera = fromUpdbm.iterator(); itera.hasNext(); ){
					Object _objective = itera.next();
					fromUpdfmxImpl.transferWithDailect( _objective, fromMBean );
				}
				for( java.util.Iterator itera = fromUpdfmx.getSUBFLOW().entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					HQSQLTable fromTABLE = (HQSQLTable)fromEntry.getKey();
					HQSQLDelegate fromDelegate = (HQSQLDelegate)fromEntry.getValue();
					HQSQLFactory.getDialect( fromTABLE.getTYPE() ).commit( fromMBean, fromDelegate);
				}
				fromUpdfmx.setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				if( fromUpdfmx.getSUMING() > 0 && log.isDebugEnabled() ) log.debug("batch Execute finish[REGION_ID:" + "NULL" + ",REGION:NULL" + 
						"[Routing Information by the itself JVM settings]], Data Table [" + fromUpdfmx.getSUMING() 
						+"] ,Time-consuming ["+(fromUpdfmx.getCOMPLETE().getTime() - 
								fromUpdfmx.getCREATE().getTime() )+"]ms");
			}
			finally{
				if( fromMBean != null ){ fromMBean = null; }
				if( fromUpdfmxImpl != null ){ fromUpdfmxImpl = null; }
			}
			
		}
		finally{
			
		}
	}
}
