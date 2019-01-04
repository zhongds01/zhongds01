package com.ai.sacenter.util;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.complex.datasource.DataSourceTemplate;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterCatalog;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLConst;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.jdbc.IUpdfmxLittle;
import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.subtable.SFSubTableFactory;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ���ݿ⹤��</p>
 * <p>Copyright: Copyright (c) 2014-5-9</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class OracleUtils {
	public OracleUtils() {
		super();
	}
	/**
	 * ��ȡ��ǰ���ݿ����Ӷ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static java.sql.Connection getTransaction() throws SFException,Exception{
		java.sql.Connection aTransaction = null;
		String aTransactionName = null;
		try
		{
			aTransactionName = OracleUtils.getTransactionName();
			aTransaction = OracleUtils.getTransaction( aTransactionName );
		}
		catch( java.lang.Exception aEXCEPTION ){
			ExceptionFactory.throwOracleConnect("IOS0014014", new String[]{aTransactionName,
					aEXCEPTION.getMessage()} );
		}
		finally{
			
		}
		return aTransaction;
	}

	/**
	 * ���ݵ�ǰ����Դ��ȡ���ݿ����Ӷ���
	 * @param schema ����Դ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static java.sql.Connection getTransaction( String schema ) throws SFException,Exception{
		java.sql.Connection aTransaction = null;
		try
		{
			if( StringUtils.isBlank( schema ) ) schema = getTransactionName();
			aTransaction = ServiceManager.getSession().getConnection( schema );
		}
		catch( java.lang.Exception aEXCEPTION ){
			ExceptionFactory.throwOracleConnect("IOS0014014", new String[]{schema,
					aEXCEPTION.getMessage()} );
		}
		finally{
			
		}
		return aTransaction;
	}
	
	/**
	 * ���ݵ�ǰ����Դ��ȡ���ݿ����Ӷ���
	 * @param fromTYPE
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static java.sql.Connection getTransaction(ObjectType fromTYPE, java.util.Map fromPARAM  ) throws SFException,Exception{
		java.sql.Connection aTransaction = null;
		String schema = null;
		try
		{
			schema = OracleUtils.getTransactionName( fromTYPE, fromPARAM );
			aTransaction = ServiceManager.getSession().getConnection( schema );
		}
		catch( java.lang.Exception aEXCEPTION ){
			ExceptionFactory.throwOracleConnect("IOS0014014", new String[]{schema,
					aEXCEPTION.getMessage()} );
		}
		finally{
			
		}
		return aTransaction;
	}
	
	/**
	 * ���ݵ�ǰ����Դ��ȡ���ݿ����Ӷ���
	 * @param fromTYPE
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static java.sql.Connection getTransaction(HQSQLTable fromTYPE, java.util.Map fromPARAM  ) throws SFException,Exception{
		java.sql.Connection aTransaction = null;
		String schema = null;
		try
		{
			schema = OracleUtils.getTransactionName( fromPARAM );
			aTransaction = ServiceManager.getSession().getConnection( schema );
		}
		catch( java.lang.Exception aEXCEPTION ){
			ExceptionFactory.throwOracleConnect("IOS0014014", new String[]{schema,
					aEXCEPTION.getMessage()} );
		}
		finally{
			
		}
		return aTransaction;
	}
	
	/**
	 * ��ȡ��ǰĬ��ϵͳ������Դ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String getTransactionName() throws SFException, Exception {
		String aTransactionName = null;
		try
		{
			SFCenterOffer _centeroffer = SFCenterFactory.getCenterBlank();
			String _region_id = _centeroffer != null?_centeroffer.getREGION_ID():null;
			aTransactionName = OracleUtils.getTransactionName( _region_id );
		}
		finally{
			
		}
		return aTransactionName;
	}
	/**
	 * ���ݵ��б����ȡ��ǰϵͳ������Դ
	 * @param _region_id ���б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String getTransactionName( String _region_id ) throws SFException, Exception {
		String aTransactionName = null;
		try
		{
			aTransactionName = ServiceManager.getSession().getCurrentTransactionName();
			SFCenterCatalog _catalog   = SFCenterFactory.getCenterBlank() != null?SFCenterFactory.getCatalog():null;
			ISystemTemplate.ICenterCatalog __catalog = _catalog != null?_catalog.getSUBFLOW().getCatalog():null;
			if( __catalog != null && _catalog.getSUBFLOW().isCUSTOM() /*�Զ�������Դ*/){
				aTransactionName = StringUtils.isBlank( __catalog.getCOMPOSITE() ) == false?__catalog.getCOMPOSITE():aTransactionName;
				if( StringUtils.contains( aTransactionName, IUpdcConst.IUpdbm.IUpdmc.CENTER_FLAG ) ){
					aTransactionName = StringUtils.replace( aTransactionName, 
							IUpdcConst.IUpdbm.IUpdmc.CENTER_FLAG, 
							SFCenterFactory.getCenterInfo().getCENTER_ID() );
				}
			}
			else if( __catalog != null )/*ϵͳ����Դ*/{
				aTransactionName = StringUtils.isBlank( __catalog.getCOMPOSITE() ) == false?__catalog.getCOMPOSITE():aTransactionName;
				if( StringUtils.contains( aTransactionName, IUpdcConst.IUpdbm.IUpdmc.CENTER_FLAG ) ){
					ISystemTemplate.ICenterRoute fromRoute = CenterUtils.ICustom.getCenterByRegionId( _region_id );
					aTransactionName = StringUtils.replace( aTransactionName, 
							DataSourceTemplate.CENTER_FLAG, 
							fromRoute.getCENTER() );
				}
			}
		}
		finally{
			
		}
		return aTransactionName;
	}
	
	/**
	 * ���ݿ������·�ɹ淶¼��ȡ��ǰ��ܼ�����Դ
	 * @param fromPARAM �������·�ɹ淶
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String getTransactionName( java.util.Map fromPARAM ) throws SFException,Exception{
		String aTransactionName = null;
		try
		{
			Object _region_id = fromPARAM.get( IUpdcConst.IUpdbm.IUpdmc.REGION_ID );
			if( _region_id == null ){
				_region_id = fromPARAM.get( IUpdcConst.IUpdbm.IUpdmc.REGION_CODE );
			}
			if( _region_id == null || StringUtils.isBlank( _region_id.toString() ) ){
				_region_id = CenterUtils.ICustom.getRegionId();
			}
			aTransactionName = OracleUtils.getTransactionName( _region_id != null?_region_id.toString():null );
		}
		finally{
			
		}
		return aTransactionName;
	}
	
	/**
	 * ���ݵ�ǰ���ݼ�¼��ȡ��ǰϵͳ������Դ
	 * @param fromTYPE BO��������
	 * @param fromPARAM ��ѯ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String getTransactionName( ObjectType fromTYPE, java.util.Map fromPARAM  ) throws SFException,Exception{
		String aTransactionName = null;
		try
		{
			aTransactionName = OracleUtils.getTransactionName( fromPARAM );
		}
		finally{
			
		}
		return aTransactionName;
	}
	
	/**
	 * ���ݵ�ǰ���ݼ�¼��ȡ��ǰϵͳ������Դ
	 * @param fromTYPE BO��������
	 * @param fromPARAM ��ѯ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String getTransactionName( HQSQLTable fromTYPE, java.util.Map fromPARAM  ) throws SFException,Exception{
		String aTransactionName = null;
		try
		{
			aTransactionName = OracleUtils.getTransactionName( fromPARAM );
		}
		finally{
			
		}
		return aTransactionName;
	}
	
	/**
	 * ������·����ȡ��ǰϵͳ������Դ
	 * @param _implclass ��·��
	 * @param _region_route ·�ɶ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static String getTransactionName( Class _implclass, Object _region_route ) throws SFException,Exception{
		String aTransactionName = null;
		try
		{ 
			IPlatformTemplate.IUpffmOffer fromNetWork = CenterUtils.ICustom.getSFCenterNetWork( _implclass.getName() );
			ISystemTemplate.ICenterCatalog __catalog = CenterUtils.ICustom.getSFCenterComposite( _implclass.getName() );
			ISystemTemplate.ICenterWrapper fromWrapper = CenterUtils.getSFCenterWrapper( _implclass.getName(), fromNetWork );
			if( fromWrapper != null ){
				SFCenterCatalog _catalog = new SFCenterCatalog( fromWrapper, _region_route );
				SFCenterOffer fromCenter = CenterUtils.ISystem._wrap( _catalog.getCenter(), _catalog );
				aTransactionName = StringUtils.contains( __catalog.getCOMPOSITE(), DataSourceTemplate.CENTER_FLAG )?
						StringUtils.replace( __catalog.getCOMPOSITE(), DataSourceTemplate.CENTER_FLAG, fromCenter.getCENTER_ID() ):
							__catalog.getCOMPOSITE();
			}
			else{
				Object _region_id = _region_route;
				if( ClassUtils.IClass.isPrimitive( _region_id ) == false ){
					_region_id = ReflectUtils.xPath( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, _region_route );
					if( _region_id == null ){ ReflectUtils.xPath( IUpdcConst.IUpdbm.IUpdmc.REGION_CODE, _region_route ); }
					if( _region_id == null ){ _region_id = CenterUtils.ICustom.getRegionId(); }
				}
				ISystemTemplate.ICenterRoute fromRoute = CenterUtils.ICustom.getCenterByRegionId( _region_id.toString() );
				aTransactionName = StringUtils.contains( __catalog.getCOMPOSITE(), DataSourceTemplate.CENTER_FLAG )?
						StringUtils.replace( __catalog.getCOMPOSITE(), DataSourceTemplate.CENTER_FLAG, fromRoute.getCENTER() ):
							__catalog.getCOMPOSITE();
			}
		}
		finally{
			
		}
		return aTransactionName;
	}
	
	/**
	 * �жϱ��Ƿ������û�����
	 * @param schema
	 * @param table
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static boolean isExistTable( String schema , String table ) throws SFException,Exception{
		boolean aOBJECT = false;
		java.sql.Connection aTransaction = null;
		try
		{
			aTransaction = OracleUtils.getTransaction( schema );
			aOBJECT = ICustom.isExistTable( aTransaction, table );
		}
		finally{
			if( aTransaction != null ) { aTransaction.close();}
		}
		return aOBJECT;
	}
	/**
	 * ��ѯ��ṹ����
	 * @param _owner ���ݿ�Դ����
	 * @param _table_name ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static HQSQLTable getITableDefine( String _owner, String _table_name ) throws SFException,Exception{
		HQSQLTable _table = null;
		java.sql.Connection aTransaction = null;
		try
		{
			aTransaction = OracleUtils.getTransaction( _owner );
			if( ICustom.isExistTable( aTransaction, _table_name ) ){
				_table = new HQSQLTable( _owner, _table_name  );
				ICustom.getTableColumn ( aTransaction, _table );
				ICustom.getTablePrimary( aTransaction, _table );
			}
		}
		finally{
			if( aTransaction != null ) { aTransaction.close();}
		}
		return _table;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: ���ݼǻ������</p>
	 * <p>Copyright: Copyright (c) 2014-5-9</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * ���ݱ�������ṹ�����ݼ�
		 * @param fromTable ����
		 * @param fromUpfwm ���ݼ�¼
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.HashMap wrap( String fromTable, java.util.Map fromUpfwm[] ) throws SFException,Exception{
			java.util.HashMap fromUpfgkmHome = new java.util.HashMap();
			try
			{
				for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length ; index++ ){
					if( fromUpfgkmHome.containsKey( fromTable ) == false ) fromUpfgkmHome.put( fromTable , new java.util.ArrayList() );
					((java.util.List)fromUpfgkmHome.get( fromTable )).add( fromUpfwm[index] );
				}
			}
			finally{
				
			}
			return fromUpfgkmHome;
		}
		
		/**
		 * ���ݱ�������ṹ�����ݼ�[�������Ʒ���]
		 * @param fromMYSQL ����
		 * @param fromUpfwm ���ݼ�¼
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.HashMap wrap( HQSQLTable fromMYSQL, java.util.Map fromUpfwm[] ) throws SFException,Exception{
			java.util.HashMap fromUpfgkmHome = new java.util.HashMap();
			try
			{
				for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length ; index++ ){
					String fromTABLE = SFSubTableFactory.createTableName( fromMYSQL.getMapingEnty(), fromUpfwm[index] );
					if( fromUpfgkmHome.containsKey( fromTABLE ) == false ){
						fromUpfgkmHome.put( fromTABLE, new java.util.ArrayList() );
					}
					((java.util.List)fromUpfgkmHome.get( fromTABLE )).add( fromUpfwm[index] );
				}
			}
			finally{
				
			}
			return fromUpfgkmHome;
		}
		
		/**
		 * ���ݱ�������ṹ�����ݼ�[�������Ʒ���]
		 * @param fromMYSQL ����
		 * @param fromUpfwm ���ݼ�¼
		 * @param fromORACLE ����鼯
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.HashMap wrap( String fromMYSQL, java.util.Map fromUpfwm[], java.util.HashMap fromORACLE ) throws SFException,Exception{
			try
			{
				for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length ; index++ ){
					String fromTABLE = SFSubTableFactory.createTableName( fromMYSQL, fromUpfwm[index] );
					if( fromORACLE.containsKey( fromTABLE ) == false ){
						fromORACLE.put( fromTABLE, new java.util.ArrayList() );
					}
					((java.util.List)fromORACLE.get( fromTABLE )).add( fromUpfwm[index] );
				}
			}
			finally{
				
			}
			return fromORACLE;
		}
		
		/**
		 * ���ݵ�ǰ���ݼ�¼���ص���ǰ�Ự������־û���
		 * @param fromUpfwm �첽����[BO�������BO����]
		 * @param fromUpdfmx ���ݴ洢������
		 * @return
		 */
		public static IOVUpdfmxOffer transfer( Object fromUpfwm, IOVUpdfmxOffer fromUpdfmx){
			IOVUpdfmxOffer fromOffer = null;
			try
			{
				class SFUpdfmxTfImpl{
					public SFUpdfmxTfImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromEntity
					 * @param fromUpdfmx
					 * @throws SFException
					 * @throws Exception
					 */
					public void transferSYBASE( java.util.Map fromEntity, IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
						try
						{
							fromUpdfmx.getORDER().getORDER().add( fromEntity );
						}
						finally{
							
						}
					}
					
					/**
					 * �����ݼ�¼fromEntity�ϲ���ǰ��������
					 * @param fromEntity
					 * @param fromUpdfmx ���ݴ洢������
					 * @throws SFException
					 * @throws Exception
					 */
					public void transferORACLE( DataStructInterface fromEntity, IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
						try
						{
							ISystemTemplate.IUpfgkmComposite fromHistory = null;
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							if( fromEntity != null && fromEntity.isDeleted() /*ɾ����������*/){
								if( fromUpdfmxHome.isHISTORY() && HQSQLUtils.IIfElse.isHISTROY( fromEntity ) == false /*������ʷ��*/){
									fromHistory = HQSQLUtils.ISystem.getSFUpfgkmHistory( fromEntity.getObjectType().getMapingEnty() );
								}
								else if( fromUpdfmxHome.isFAILURE() && HQSQLUtils.IIfElse.isFAILURE( fromEntity ) /*����ʧ�ܱ�[ɾ���ٲ���]*/){
									fromHistory = HQSQLUtils.ISystem.getSFUpfgkmComposite( fromEntity.getObjectType().getMapingEnty() );
								}
								else if( fromUpdfmxHome.isFAILURE() /*����ʧ�ܱ�[ת�Ƶ�ʧ��]*/){
									fromHistory = HQSQLUtils.ISystem.getSFUpfgkmFail( fromEntity.getObjectType().getMapingEnty() );
								}
								if( fromHistory != null && StringUtils.isBlank( fromHistory.getPERSISTENT() ) == false ){
									DataContainer _history = ClassUtils.IClass.getASTBOEntity( fromHistory.getPERSISTENT() );
									OracleUtils.ICustom.transfer( fromEntity, _history );
									if( _history.hasPropertyName("COMPLETE_DATE") && _history.get( "COMPLETE_DATE" ) == null ){
										_history.set("COMPLETE_DATE", fromUpdfmxHome.getCOMPLETE() );
									}
									fromUpdfmx.getORDER().getORDER().add( _history );
								}
							}
							fromUpdfmx.getORDER().getORDER().add( fromEntity );
						}
						finally{
							
						}
					}
					
					/**
					 * 
					 * @param fromEntity
					 * @param fromUpdfmx
					 * @throws SFException
					 * @throws Exception
					 */
					public void _transferMYSQL( HQSQLEntityBean fromEntity, IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
						try
						{
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							ISystemTemplate.IUpfgkmComposite fromHistory = null;
							if( fromEntity != null && fromEntity.isDeleted() /*ɾ����������*/){
								if( fromUpdfmxHome.isHISTORY() && HQSQLUtils.IIfElse.isHISTROY( fromEntity ) == false /*������ʷ��*/){
									fromHistory = HQSQLUtils.ISystem.getSFUpfgkmHistory( fromEntity.getObjectType().getMapingEnty() );
								}
								else if( fromUpdfmxHome.isFAILURE() && HQSQLUtils.IIfElse.isFAILURE( fromEntity ) /*����ʧ�ܱ�[ɾ���ٲ���]*/){
									fromHistory = HQSQLUtils.ISystem.getSFUpfgkmComposite( fromEntity.getObjectType().getMapingEnty() );
								}
								else if( fromUpdfmxHome.isFAILURE() /*����ʧ�ܱ�[ת�Ƶ�ʧ��]*/){
									fromHistory = HQSQLUtils.ISystem.getSFUpfgkmFail( fromEntity.getObjectType().getMapingEnty() );
								}
								if( fromHistory != null && StringUtils.isBlank( fromHistory.getPERSISTENT() ) == false ){
									HQSQLEntityBean __history = HQSQLUtils.ICustom.getASTBOEntity( fromHistory.getPERSISTENT() );
									HQSQLUtils.ICustom.transfer( fromEntity, __history );
									if( __history.hasPropertyName("COMPLETE_DATE") && __history.get( "COMPLETE_DATE" ) == null ){
										__history.set("COMPLETE_DATE", fromUpdfmxHome.getCOMPLETE() );
									}
									fromUpdfmx.getORDER().getORDER().add( __history );
								}
							}
							fromUpdfmx.getORDER().getORDER().add( fromEntity );
						}
						finally{
							
						}
					}
					
					/**
					 * 
					 * @param fromEntity
					 * @param fromUpdfmx
					 * @throws SFException
					 * @throws Exception
					 */
					public void transferMYSQL( HQSQLEntityBean fromEntity, IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
						try
						{
							if( ICustom.isCommit( fromEntity ) ){ _transferMYSQL( fromEntity, fromUpdfmx ); }
							for( java.util.Iterator iterap = fromEntity.getLittle().getLittle().iterator(); iterap.hasNext(); ){
								HQSQLEntityBean ____little = (HQSQLEntityBean)iterap.next();
								transferMYSQL( ____little, fromUpdfmx );
							}
						}
						finally{
							
						}
					}
					
					/**
					 * 
					 * @param fromLittle
					 * @param fromUpdfmx
					 * @throws SFException
					 * @throws Exception
					 */
					public void transferLittle( IUpdfmxLittle fromLittle, IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
						try
						{
							DataStructInterface fromEntity = fromLittle.getINSTANCE();
							if( fromEntity != null && ICustom.isCommit( fromEntity ) ){
								if( ClassUtils.IClass.isContainer( fromEntity ) ){
									DataContainer ____little = (DataContainer)fromEntity;
									transferORACLE( ____little, fromUpdfmx );
								}
								else if( ClassUtils.IClass.isMYSQL5( fromEntity ) ){
									HQSQLEntityBean ____little = (HQSQLEntityBean)fromEntity;
									transferMYSQL( ____little, fromUpdfmx );
								}
								else{
									ExceptionFactory.throwOracle("IOS0014011", new String[]{fromEntity.getClass().getName()});
								}
							}
							for( java.util.Iterator itera = fromLittle.getLittle().getLITTLE().iterator(); itera.hasNext(); ){
								IUpdfmxLittle ____little = (IUpdfmxLittle)itera.next();
								transferLittle( ____little, fromUpdfmx );
							}
						}
						finally{
							
						}
					}
					
					/**
					 * 
					 * @param fromEntity
					 * @param fromUpdfmx
					 * @throws SFException
					 * @throws Exception
					 */
					public void transferOther( Object fromEntity, IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
						try
						{
							IOVUpdfmxOffer.IUpdfmxOfferHome fromUpdfmxHome = fromUpdfmx.getORDER();
							int fromINDEX = fromUpdfmxHome.getORDER().indexOf( fromEntity );
							if( fromINDEX < 0 ){ 
								fromUpdfmxHome.getORDER().add( fromEntity );
							}
							else{
								fromUpdfmxHome.getORDER().set( fromINDEX, fromEntity );
							}
						}
						finally{
							
						}
					}
				}
				SFUpdfmxTfImpl fromUpdfmxImpl = new SFUpdfmxTfImpl();
				try
				{
					fromOffer = new IOVUpdfmxOffer( fromUpdfmx );
					Object fromArray[] = new Object[] { fromUpfwm };
					if( fromUpfwm instanceof java.util.List ) { fromArray = ((java.util.List) fromUpfwm).toArray();} 
					else if( ClassUtils.IClass.isArray(fromUpfwm) ) { fromArray = (Object[]) fromUpfwm; }
					for( int index = 0; fromUpfwm != null && index < fromArray.length; index++ ) {
						if( fromArray[index] == null ) continue;
						if( ClassUtils.IClass.isMap( fromArray[index] ) ){
							fromUpdfmxImpl.transferSYBASE( (java.util.Map)fromArray[index], fromOffer );
						}
						else if( ClassUtils.IClass.isContainer( fromArray[index] ) ){
							DataStructInterface fromEntity = (DataStructInterface) fromArray[index];
							if( ICustom.isCommit( fromEntity ) == false ){ continue; }
							fromUpdfmxImpl.transferORACLE( fromEntity, fromOffer );
						}
						else if( ClassUtils.IClass.isMYSQL5( fromArray[index] ) ){
							HQSQLEntityBean fromEntity = (HQSQLEntityBean)fromArray[index];
							fromUpdfmxImpl.transferMYSQL( fromEntity, fromOffer );
						}
						else if( ClassUtils.IClass.isLittle( fromArray[index] ) ){
							IUpdfmxLittle fromEntity = (IUpdfmxLittle)fromArray[index];
							fromUpdfmxImpl.transferLittle( fromEntity, fromOffer );
						}
						else{
							fromUpdfmxImpl.transferOther( fromArray[index], fromOffer );
						}
					}
					ClassUtils.IMerge.merge( fromOffer.getORDER().getORDER(), fromUpdfmx.getORDER().getORDER() );
				}
				finally{
					if( fromUpdfmxImpl != null ){ fromUpdfmxImpl = null; }
				}
				
			} 
			catch (java.lang.Exception aEXCEPTION) {
				ExceptionFactory.throwOracle("IOS0014000", new String[] { aEXCEPTION
						.getMessage() }, aEXCEPTION);
			} 
			finally {
				
			}
			return fromOffer;
		}
		
		/**
		 * �ѵ�ǰ���񻺴������ύʵ�����ݿ���
		 * @param aUpdbkmLife
		 * @throws SFException
		 * @throws Exception
		 */
		public static void submitDBLite(java.util.Map aUpdbkmLife ) throws SFException,Exception{
			try
			{
				for( java.util.Iterator itera = aUpdbkmLife.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					Class aUpdcDAOLife = (Class)aEntry.getKey();
					if( ClassUtils.isAssignable( aUpdcDAOLife , IUpdbmDAOLife.class ) ){
						UpdcFactory.getIUpdcDAO( (Class)aEntry.getKey() ).finish( (java.util.List)aEntry.getValue() );
					}
				}
			}
			finally{
				
			}
		}
		/**
		 * ����APP��ܿ������캯��
		 * @param fromSRC
		 * @param fromDest
		 * @throws Exception
		 */
		public static DataStructInterface transfer( DataStructInterface fromSRC ) throws Exception{
			DataStructInterface fromDest = null;
			try
			{
				if( fromSRC != null && fromSRC instanceof DataContainer ){
					Class _descriptor = Class.forName( fromSRC.getObjectType().getFullName() );
					fromDest = DataContainerFactory.createDataContainerInstance( _descriptor, fromSRC.getObjectType() );
					DataContainerFactory.transfer( fromSRC, fromDest );
				}
				else if( fromSRC != null && fromSRC instanceof HQSQLEntityBean ){
					HQSQLEntityBean compatible = (HQSQLEntityBean)fromSRC;
					fromDest = (DataStructInterface)ReflectUtils.IReflect.invokeConstructor( fromSRC.getClass(), new Object[]{ fromSRC.getObjectType() } );
					HQSQLUtils.ICustom.transfer( (DataStructInterface)compatible, (HQSQLEntityBean)fromDest );
					for( java.util.Iterator itera = compatible.getLittle().getLittle().iterator(); itera.hasNext(); ){
						HQSQLEntityBean __bottle = (HQSQLEntityBean)itera.next();
						HQSQLEntityBean _compatible = (HQSQLEntityBean)transfer( __bottle );
						((HQSQLEntityBean)fromDest).getLittle().getLittle().add( _compatible );
					}
				}
			}
			finally{
				
			}
			return fromDest;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2014-5-9</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * �������ݼ�¼���ձ����ϲ������ݱ�����
		 * @param aUpdbfLife ���ݼ�[����KEY=�������������������Žṹ]
		 * @param aUpdbcLife ��������(��DataContainerΪ���ݼ�¼)����
		 * @param aUpdbmLife ��������(��HashMapΪ���ݼ�)����
		 * @throws Exception
		 */
		public static void transfer( java.util.Map aUpdbfLife, java.util.List aUpdbcLife, java.util.Map aUpdbmLife ) throws Exception{
			try
			{
				for( java.util.Iterator itera = aUpdbfLife.entrySet().iterator(); itera.hasNext() ; ){
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					String fromTable = (String)aEntry.getKey();
					java.util.List fromList = (java.util.List)aEntry.getKey();
					if( aUpdbmLife.containsKey( fromTable ) == false ) aUpdbmLife.put( fromTable, new java.util.ArrayList() );
					ClassUtils.IMerge.merge( fromList, (java.util.List)aUpdbmLife.get( fromTable ) );
				}
			}
			finally{
				
			}
		}
		/**
		 * ��������Ψһ�԰�aOBJECT�ϲ���ǰ��������
		 * @param aOBJECT
		 * @param fromUpdfmx
		 */
		public static void transfer(Object aOBJECT, java.util.List fromUpdfmx ){
			try
			{
				if( ClassUtils.IClass.isContainer( aOBJECT ) ){
					if( ClassUtils.IClass.isArray( aOBJECT ) == false ) fromUpdfmx.add( aOBJECT );
					else{
						Object aARRAY[] =  (Object[])aOBJECT;
						for( int index = 0 ; index < aARRAY.length ; index++ ) fromUpdfmx.add( aARRAY[index] );
					}
				}
				else if( ClassUtils.IClass.isMYSQL5( aOBJECT ) ){
					if( ClassUtils.IClass.isArray( aOBJECT ) == false ) fromUpdfmx.add( aOBJECT );
					else{
						Object aARRAY[] =  (Object[])aOBJECT;
						for( int index = 0 ; index < aARRAY.length ; index++ ) fromUpdfmx.add( aARRAY[index] );
					}
				}
				else{
					Object aARRAY[] = new Object[]{aOBJECT};
					if( ClassUtils.IClass.isArray( aOBJECT ) ) aARRAY =  (Object[])aOBJECT;
					for( int index = 0 ; index < aARRAY.length ; index++ ){
						int aINDEX = fromUpdfmx.indexOf( aARRAY[index] );
						if( aINDEX < 0 ) fromUpdfmx.add( aARRAY[index] );
						else fromUpdfmx.set( aINDEX , aARRAY[index] );
					}
				}
			}
			finally{
				
			}
		}
			
		/**
		 * ��fromObjectת��ΪtoObject
		 * @param fromObject ԭBO����
		 * @param toObject  Ŀ��BO����
		 * @throws Exception
		 */
		public static void transfer( DataStructInterface fromObject, DataStructInterface toObject ) throws Exception{
			try
			{
				java.util.Map fromMap = fromObject.getProperties();
				java.util.Map fromField = toObject.getObjectType().getProperties();
				for(java.util.Iterator itera = fromMap.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					if( fromField.containsKey( (String)aEntry.getKey() ) ){
						toObject.set( aEntry.getKey().toString() , aEntry.getValue() );
					}
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromObject
		 * @param toMap
		 * @throws Exception
		 */
		public static void transfer( DataStructInterface fromObject, java.util.Map toMap ) throws Exception{
			try
			{
				for(java.util.Iterator itera = fromObject.getProperties().entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					toMap.put( aEntry.getKey().toString() , aEntry.getValue() );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromObject
		 * @param toObject
		 * @throws Exception
		 */
		public static void transfer( Object fromObject[][], DataStructInterface toObject[] ) throws Exception{
			try
			{
				for(int index = 0 ; index < toObject.length ; index++){
					for( int aINDEX = 0 ; aINDEX < fromObject.length ; aINDEX++ ){
						if( ((DataContainer)toObject[index]).hasPropertyName( (String)fromObject[aINDEX][0] ) ){
							toObject[index].set( (String)fromObject[aINDEX][0], fromObject[aINDEX][1] );
						}
					}
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromMap
		 * @param toObject
		 * @throws Exception
		 */
		public static void transfer( java.util.Map fromMap, DataStructInterface toObject ) throws Exception{
			try
			{
				for( java.util.Iterator itera = fromMap.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					String fromKEY = ((String)aEntry.getKey()).toUpperCase();
					Object fromOBJECT = aEntry.getValue();
					if( ((DataContainer)toObject).hasPropertyName( fromKEY ) == false ) continue;
					if( fromMap.get( fromKEY ) != null ) toObject.set( fromKEY , fromOBJECT );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromMap
		 * @param toObject
		 * @throws Exception
		 */
		public static void transfer( java.util.Map fromMap, DataStructInterface toObject[] ) throws Exception{
			try
			{
				for(int index = 0 ; toObject != null && index < toObject.length ; index++){
					ICustom.transfer( fromMap , toObject[index] );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * ȡ��ԭ��,����ڷֱ������ȡԭ��
		 * @param aTableName
		 * @return
		 */
		public static String getTableName( String aTableName ){
			String fromTable = aTableName;
			try
			{
				String fromObject[] = StringUtils.substring( fromTable, "{", "}" );
				if( fromObject != null && fromObject.length > 0 ) fromTable = fromObject[0];
			}
			finally{
				
			}
			return fromTable;
		}
		
		/**
		 * �Ƿ������ύ���ݿ�
		 * @param fromHQSQL
		 * @return
		 */
		public static boolean isCommit( DataStructInterface fromHQSQL ){
			return fromHQSQL.isDeleted() || fromHQSQL.isNew() || fromHQSQL.isModified();
		}
		
		/**
		 * �Ƿ�����·��
		 * @param aTransactionName
		 * @return
		 */
		public static boolean isCENTER( String aTransactionName ){
			return StringUtils.isBlank( aTransactionName ) == false && 
			       StringUtils.contains( aTransactionName , IUpdcConst.IUpdbm.IUpdmc.CENTER_FLAG );
		}
		
		/**
		 * �Ƿ�������ͬһ���ݼ�¼
		 * @param _table_left
		 * @param _table_right
		 * @return
		 */
		public static boolean equals(DataStructInterface _table_left, DataStructInterface _table_right){
			try 
			{
				String _table_name_left = SFSubTableFactory.createTableName( _table_left );
				String _table_name_right = SFSubTableFactory.createTableName( _table_right );
				if( _table_name_left.equals( _table_name_right ) ){
					com.ai.appframe2.common.Property _property = null;
					java.util.Map fromPrimary = _table_left.getObjectType().getKeyProperties();
					if( fromPrimary != null && fromPrimary.size() > 0 ){
						for( java.util.Iterator itera = fromPrimary.values().iterator(); itera.hasNext(); ){
							_property = (com.ai.appframe2.common.Property)itera.next();
							if( IICustom.equals(_property.getName(), _table_left, _table_right ) == false ){
								return false;
							}
						}
						return true;
					}
				}
			} 
			catch (java.lang.Exception aEXCEPTION) {
				ExceptionFactory.throwRuntime(aEXCEPTION);
			}
			return false;
		}
		
		/**
		 * �жϱ��Ƿ������û���
		 * @param aTransaction
		 * @param table
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean isExistTable( java.sql.Connection aTransaction , String table ) throws SFException,Exception{
			boolean aOBJECT = false;
			java.sql.ResultSet aResultset = null;
			try
			{
				table = ICustom.getTableName( table );
				aResultset = aTransaction.getMetaData().getTables( null , 
						aTransaction.getMetaData().getUserName(), 
						table.toUpperCase() , 
						null );
				aOBJECT = aResultset.next();
			}
			finally{
				if( aResultset != null ) {aResultset.close(); aResultset = null;}
			}
			return aOBJECT;
		}
		
		/**
		 * ��ѯ����ͨ�ֶ���Ϣ
		 * @param aTransaction
		 * @param fromHQSQL
		 * @throws SFException
		 * @throws Exception
		 */
		public static void getTableColumn( java.sql.Connection aTransaction , HQSQLTable fromHQSQL ) throws SFException,Exception{
			java.sql.ResultSet _resultset = null;
		  	try
			{
		  		String table = ICustom.getTableName( fromHQSQL.getMapingEnty() );
		  		_resultset = aTransaction.getMetaData().getColumns( null, 
		  				aTransaction.getMetaData().getUserName(), 
		  				table, 
		  				null );
		  		while( _resultset.next() ){
		  			HQSQLTable.HQSQLColumn _column = new HQSQLTable.HQSQLColumn( _resultset );
		  			fromHQSQL.getProperties().put( _column.getName(), _column  );
		  		}
			}
			finally{
				if( _resultset != null ) {_resultset.close(); _resultset = null; }
			}
		}
		
		/**
		 * 
		 * @param aTransaction
		 * @param fromHQSQL
		 * @throws SFException
		 * @throws Exception
		 */
		public static void getTablePrimary(  java.sql.Connection aTransaction, HQSQLTable fromHQSQL ) throws SFException,Exception{
			java.sql.ResultSet _resultset = null;
		  	try
			{
		  		String table = ICustom.getTableName( fromHQSQL.getMapingEnty() );
		  		HQSQLTable.HQSQLColumn fromCol = null;
		  		_resultset = aTransaction.getMetaData().getPrimaryKeys( null , aTransaction.getMetaData().getUserName(), 
		  				table.toUpperCase() );
		  		while( _resultset.next() ){
		  			String aColumnName = _resultset.getString( "COLUMN_NAME" ).toUpperCase();
		  			fromCol = fromHQSQL.getProperty( aColumnName );
		  			if( fromCol == null ){
		  				ExceptionFactory.throwIllegal("IOS0014002", new String[]{fromHQSQL.getDataSource(), 
		  						fromHQSQL.getMapingEnty(), aColumnName } );
		  			}
		  			fromCol.setType( HQSQLConst.Category.Column.PRIMARY          );
		  			fromHQSQL.getKeyProperties().put( fromCol.getName(), fromCol );
		  		}
			}
			finally{
				if( _resultset != null ) {_resultset.close();_resultset=null;}
			}
		}
		
		public static class IICustom{
			public IICustom(){
				super();
			}
			
			/**
			 * 
			 * @param fromKEY
			 * @param elementA
			 * @param elementB
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static boolean equals(String fromKEY, DataStructInterface elementA, DataStructInterface elementB) throws SFException,Exception{
				boolean fromEqual = false;
				try
				{
					Object fromColA = null,fromColB = null;
					if( elementA.isModified() ) fromColA = elementA.getOldObj( fromKEY );
					else fromColA = elementA.get( fromKEY );
					if( elementB.isModified() ) fromColB = elementB.getOldObj( fromKEY );
					else fromColB = elementB.get( fromKEY );
					if (fromColA == null || fromColB == null) {
						ExceptionFactory.throwOracle("IOS0014003", new String[] {
								"NULL", elementA.getObjectType().getMapingEnty(), fromKEY });
					}
					fromEqual = fromColA.equals( fromColB );
				}
				finally{
					
				}
				return fromEqual;
			}
		}
	}
}
