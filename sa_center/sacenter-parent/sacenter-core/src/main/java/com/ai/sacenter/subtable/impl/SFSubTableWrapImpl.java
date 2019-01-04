package com.ai.sacenter.subtable.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.subtable.ISubSQLOffer;
import com.ai.sacenter.subtable.ISubTableWrapper;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.valuebean.ISubTableTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �ֱ�ʵ�ֽӿ�</p>
 * <p>Copyright: Copyright (c) 2011-11-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class SFSubTableWrapImpl extends UpdcEclipseImpl implements ISubTableWrapper,java.io.Serializable {
	private static final long serialVersionUID = 2349020082036124733L;
	
	public SFSubTableWrapImpl() {
		super();
	}
	
	/**
	 * ������ת���淶ת�����ݿ���ֵ
	 * @param fromUpfwm ���ݼ�¼
	 * @param fromSubSQL Ŀ����ת���淶
	 * @param fromHQSQL Ŀ���ṹ�淶
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	protected Object transfer( HQSQLEntityBean fromUpfwm, ISubTableTemplate.ISubSQLTableCol fromSubTabCol, ISubSQLOffer fromSubSQL, IUpdcContext aContext) throws SFException, Exception{
		Object fromField = null;
		try
		{
			ISubSQLOffer.IUpdfmxOffer fromUpdfmx = fromSubSQL.getSubFlow();
			fromField = IUpdcpFactory.getIUpfwmSV().finishSFUpdbmOffer(fromSubTabCol, fromUpdfmx.getSubFlow(), aContext);
			HQSQLTable.HQSQLColumn fromCol = fromUpdfmx.getSubJect().getProperty( fromSubTabCol.getMAPPING() );
			if( fromCol != null ){
				if( fromField == null && fromCol.isASTNoNull() ){
					ExceptionFactory.throwOracle("IOS0014003", new String[]{fromUpdfmx.getSubJect().getDataSource() ,
							fromUpdfmx.getSubJect().getMapingEnty() , 
							fromSubTabCol.getMAPPING() });
				}
				fromField = ClassUtils.IClass.transfer( fromField, fromCol.getJavaType() );
			}
		}
		finally{
			
		}
		return fromField;
	}
	
	/**
	 * ���ݵ�ǰ��¼��Ŀ¼��ӳ��ת��ΪĿ��Դ��¼
	 * @param fromUpfwm ��ǰ�������м�¼
	 * @param fromSubSQL Ŀ���淶
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	protected java.util.HashMap transfer( HQSQLEntityBean fromUpfwm, ISubSQLOffer fromSubSQL, IUpdcContext aContext) throws SFException, Exception{
		java.util.HashMap fromUpdbm = null;
		try
		{
			java.util.List fromTableCol = fromSubSQL.getSubFlow().getSubJsql().getMAPPING();
			if( fromTableCol == null || fromTableCol.size() <= 0 ){
				fromUpdbm = new java.util.HashMap( fromUpfwm.getProperties() );
			}
			else{
				fromUpdbm = new java.util.HashMap();
				for( java.util.Iterator itera = fromTableCol.iterator(); itera.hasNext(); ){
					ISubTableTemplate.ISubSQLTableCol fromColumn = (ISubTableTemplate.ISubSQLTableCol)itera.next();
					Object fromField = transfer(fromUpfwm, fromColumn, fromSubSQL, aContext);
					if( fromField != null ) fromUpdbm.put( fromColumn.getMAPPING() , fromField );
				}
			}
		}
		finally{
			
		}
		return fromUpdbm;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.subtable.ISubTableWrapper#transform(com.ai.sacenter.jdbc.HQSQLEntityBean, com.ai.sacenter.subtable.ISubSQLOffer, com.ai.sacenter.IUpdcContext)
	 */
	public java.util.HashMap transform(HQSQLEntityBean fromBroke, ISubSQLOffer fromSubSQL, IUpdcContext aContext) throws SFException, Exception {
		java.util.HashMap fromUpdbm = null;
		try
		{
			ISubSQLOffer.IUpdfmxOffer fromUpdfmx = fromSubSQL.getSubFlow();
			java.util.HashMap fromORACLE = transfer(fromBroke, fromSubSQL, aContext);
			fromUpdbm = OracleUtils.ISystem.wrap( fromUpdfmx.getSubJect(), new java.util.HashMap[]{ fromORACLE } );
		}
		finally{
			
		}
		return fromUpdbm;
	}
}
