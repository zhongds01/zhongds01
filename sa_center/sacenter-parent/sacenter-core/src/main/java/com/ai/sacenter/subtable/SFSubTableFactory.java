package com.ai.sacenter.subtable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.complex.self.po.TableSplit;
import com.ai.appframe2.complex.self.po.TableSplitMapping;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �ֱ�淶����,����Appframe�ֱ����</p>
 * <p>Copyright: Copyright (c) 2014-9-5</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SFSubTableFactory {
	private final static Log log = LogFactory.getLog( SFSubTableFactory.class );
	static{
		try{
			UpfsvcFactory.initial();
		}
		finally{
			
		}
	}
	public SFSubTableFactory() {
		super();
	}
	
	/**
	 * ���ݷֱ�淶����Ŀ���
	 * @param aTableName ����
	 * @param fromPARAM ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String createTableName( String aTableName, java.util.Map fromPARAM ) throws SFException,Exception{
		String _table_name = aTableName;
		ISubTableOffer fromSubTable = null;
		try
		{
			String fromName[] = StringUtils.substring( aTableName, "{", "}");
			if( fromName != null && fromName.length > 0 ){
				if( fromName != null && fromName.length != 1 ) ExceptionFactory.throwIllegal("IOS0014008", new String[]{aTableName});
				fromSubTable = wrap( fromName, fromPARAM );
				_table_name = wrap( fromSubTable.getTable( fromName[0] ) );
			}
		}
		catch(java.lang.Exception aEXCEPTION ){
			if( log.isErrorEnabled() ) log.error( aEXCEPTION.getMessage(), aEXCEPTION );
			ExceptionFactory.throwIllegal("IOS0014023", 
					new String[]{aTableName, aEXCEPTION.getMessage()});
		}
		finally{
			if( fromSubTable != null ){ fromSubTable = null; }
		}
		return _table_name;
	}
	
	/**
	 * ���ݷֱ�淶ת��Ŀ�����
	 * @param fromPARAM ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String createTableName( DataStructInterface fromPARAM ) throws SFException,Exception{
		String _table_name = null;
		try
		{
			_table_name = createTableName( fromPARAM.getObjectType().getMapingEnty(), fromPARAM.getProperties() );
		}
		finally{
			
		}
		return _table_name;
	}
	
	/**
	 * ���ݷֱ�淶ת��Ŀ�����
	 * @param aTableName ����,�ɰ����ֱ��־
	 * @param fromPARAM ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String createTableName( String aTableName, DataStructInterface fromPARAM ) throws SFException,Exception{
		String _table_name = aTableName;
		try
		{
			_table_name = createTableName( aTableName, fromPARAM.getProperties() );
		}
		finally{
			
		}
		return _table_name;
	}
	
	/**
	 * ���ݷֱ�淶ת��Ŀ�����
	 * @param aTableName ����,�ɰ����ֱ��־
	 * @param fromPARAM ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String createTableName( String aTableName, HQSQLEntityBean fromPARAM ) throws SFException,Exception{
		String _table_name = aTableName;
		try
		{
			_table_name = createTableName( aTableName, fromPARAM.getProperties() );
		}
		finally{
			
		}
		return _table_name;
	}
	
	/**
	 * ���ݷֱ�淶ת��Ŀ�����
	 * @param fromPARAM ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String createTableName( HQSQLEntityBean fromPARAM ) throws SFException,Exception{
		String _table_name = null;
		try
		{
			HQSQLTable _subjsql = fromPARAM.getObjectType();
			_table_name = createTableName( _subjsql.getMapingEnty(), fromPARAM.getProperties() );
		}
		finally{
			
		}
		return _table_name;
	}
	
	/**
	 * ���ݷֱ�淶ת����ֵ����
	 * ������ʷֻ�洢3����,I_OPEN_PERSISTENT��MEMORIZEΪ4,�������ǰ��ʷ�������ڵ��ڷ�ֵ������ǰ��ʷ��洢
	 * @param aTableName ����[�ɰ����ֱ��־]
	 * @param fromPARAM ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String createThreShold( String aTableName, java.util.Map fromPARAM ) throws SFException,Exception{
		String _table_name = aTableName;
		ISubTableOffer fromSubTable = null;
		try
		{
			String fromName[] = StringUtils.substring( aTableName, "{", "}");
			if( fromName != null && fromName.length > 0 ){
				java.util.HashMap fromClique = null;
				try
				{
					ISubTableOffer.ISubTableOfferHome fromTableHome = null;
					if( fromName != null && fromName.length != 1 ) ExceptionFactory.throwIllegal("IOS0014008", new String[]{aTableName});
					String fromTABLE = fromName != null && fromName.length > 0?fromName[0]:null;
					fromClique = HQSQLUtils.ISystem.getSFUpfgkmThreShold( fromTABLE, fromPARAM );
					fromSubTable = wrap( new String[]{fromTABLE}, fromClique );
					fromTableHome = fromSubTable.getTable( fromTABLE );
					_table_name = wrap( fromTableHome );
				}
				finally{
					if( fromClique != null ){ fromClique.clear(); fromClique = null; }
				}
			}
		}
		catch(java.lang.Exception aEXCEPTION ){
			if( log.isErrorEnabled() ) log.error( aEXCEPTION.getMessage(), aEXCEPTION );
			ExceptionFactory.throwIllegal("IOS0014023", 
					new String[]{aTableName, aEXCEPTION.getMessage()});
		}
		finally{
			if( fromSubTable != null ){ fromSubTable = null; }
		}
		return _table_name;
	}
	
	/**
	 * ���ݷֱ�淶ת����ֵ����
	 * ������ʷֻ�洢3����,I_OPEN_PERSISTENT��MEMORIZEΪ4,�������ǰ��ʷ�������ڵ��ڷ�ֵ������ǰ��ʷ��洢
	 * @param aTableName ����[�ɰ����ֱ��־]
	 * @param fromPARAM ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String createThreShold(  String aTableName, DataContainerInterface fromPARAM ) throws SFException,Exception{
		String _table_name = aTableName;
		try
		{
			_table_name = createThreShold( aTableName , fromPARAM.getProperties() );
		}
		finally{
			
		}
		return _table_name;
	}
	
	/**
	 * ���ݷֱ�淶ת��Ŀ��ű�
	 * @param aTableSQL Դ��SQL
	 * @param fromPARAM ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String createTableSQL( String aTableSQL, java.util.Map fromPARAM ) throws SFException,Exception{
		String fromSQL = aTableSQL;
		ISubTableOffer fromSubTable = null;
		try
		{
			String fromName[] = StringUtils.substring( aTableSQL, "{", "}");
			if( fromName != null && fromName.length > 0 ){
				fromSubTable = wrap( fromName, fromPARAM );
				if( fromSubTable != null && fromSubTable.getTable().size() > 0 ){
					ISubTableOffer.ISubTableOfferHome fromTableHome = null;
					for( java.util.Iterator itera = fromSubTable.getTable().values().iterator(); itera.hasNext(); ){
						fromTableHome = (ISubTableOffer.ISubTableOfferHome)itera.next();
						String aTableName = wrap( fromTableHome );
						String aCOMPLEX = ClassUtils.getINDEX(new String[]{"{",fromTableHome.getTableName(),"}"});
						fromSQL = StringUtils.replace( fromSQL, aCOMPLEX, aTableName );
					}
				}
			}
		}
		finally{
			if( fromSubTable != null ){ fromSubTable = null; }
		}
		return fromSQL;
	}
	
	/**
	 * ���ݷֱ�淶�Ƿ����㷧ֵ����
	 * @param aTableName ����[�ɰ����ֱ��־]
	 * @param fromPARAM ���ݼ�¼
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public static boolean isThreShold( String aTableName, java.util.Map fromPARAM ) throws SFException,Exception{
		boolean fromThreshold = false;
		try
		{
			ISystemTemplate.IUpfgkmComposite fromThreShold = null;
			fromThreShold = HQSQLUtils.ISystem.getSFUpfgkmComposite( aTableName );
			if( fromThreShold != null && fromThreShold.isThreShold() ){
				String fromTABLE = createTableName( aTableName, fromPARAM );
				String fromThreld = createThreShold( aTableName, fromPARAM );
				fromThreshold = fromTABLE.toUpperCase().compareTo( 
			    		fromThreld.toUpperCase() ) >= 0?false:true;
			}
		}
		finally{
			
		}
		return fromThreshold;
	}
	
	/**
	 * ���ݷֱ�淶�Ƿ����㷧ֵ����
	 * @param fromPARAM ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static boolean isThreShold( DataContainerInterface fromPARAM ) throws SFException,Exception{
		boolean fromBool = true;
		try
		{
			ObjectType fromTYPE = fromPARAM.getObjectType();
			fromBool = isThreShold( fromTYPE.getMapingEnty() , fromPARAM.getProperties() );
		}
		finally{
			
		}
		return fromBool;
	}
	
	/**
	 * ���ݷֱ���������ݼ�¼ת��Ϊ�ֱ����ת������
	 * @param aTableName ����,�������ֱ��־
	 * @param fromPARAM  ���ݼ�¼
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	private static ISubTableOffer wrap(String aTableName[], java.util.Map fromPARAM ) throws SFException,Exception{
		ISubTableOffer fromSubTable = new ISubTableOffer();
		try
		{
			if( fromPARAM == null ) fromPARAM = new java.util.HashMap();
			for( int index = 0 ; aTableName != null && index < aTableName.length; index++ ){
				TableSplit fromTableSplit = HQSQLUtils.ISystem.getSFUpfgkmSplit( aTableName[index] );
				TableSplitMapping fromMapping[] = HQSQLUtils.ISystem.getSFUpfgkmMapping( fromTableSplit.getTableName() );
				for( int aINDEX = 0; fromMapping != null && aINDEX < fromMapping.length; aINDEX++ ){
					Object fromCol = HQSQLUtils.ISystem.wrap(fromTableSplit, 
							fromMapping[aINDEX], 
							fromPARAM);
					fromSubTable.add( fromTableSplit, 
							fromMapping[aINDEX].getColumnName() , 
							fromCol.toString() );
				}
			}
		}
		finally{
			
		}
		return fromSubTable;
	}
	
	/**
	 * ���ݷֱ����ת������ת��ΪĿ�����
	 * @param fromTableCross �ֱ�淶����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	private static String wrap( ISubTableOffer.ISubTableOfferHome fromTableCross ) throws SFException,Exception{
		String aTableName = null;
		try
		{
			TableSplit aTableSplit = fromTableCross.getSubTable();
			aTableName = aTableSplit.getTableNameExpr();
			String tableNameArray[] = StringUtils.substring(aTableSplit.getTableNameExpr(), "T[", "]");
			if( tableNameArray != null && tableNameArray.length > 0 ){
				String aCOMPLEX = ClassUtils.getINDEX( new String[]{"T[",tableNameArray[0],"]"});
				aTableName = StringUtils.replace( aTableName , 
						aCOMPLEX, 
						aTableSplit.getTableName() );
			}
			tableNameArray = StringUtils.substring(fromTableCross.getSubTable().getTableNameExpr(), "C[", "]");
			for( int index = 0 ; tableNameArray != null && index < tableNameArray.length; index++ ){
				String fromColumn = fromTableCross.getValueByCol( tableNameArray[index] );
				if( fromColumn == null ) ExceptionFactory.throwIllegal("IOS0014009", new String[]{aTableSplit.getTableName(),tableNameArray[index]} );
				String aCOMPLEX = ClassUtils.getINDEX( new String[]{"C[",tableNameArray[index],"]"});
				aTableName = StringUtils.replace( aTableName, 
						aCOMPLEX, 
						fromColumn );
			}
		}
		finally{
			
		}
		return aTableName;
	}
}
