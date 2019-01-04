package com.ai.sacenter.util;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.valuebean.IOVUpdfmxDestiny;

public class WeakPersistence implements java.io.Serializable {
	private static final long serialVersionUID = 8826906092845988515L;
	/* ������� */
	private UUID ID = null;
	/* �첽�����ɻ������� */
	private java.util.HashMap<Class<?>, java.util.List<DataStructInterface>> _tables = new java.util.HashMap<Class<?>, java.util.List<DataStructInterface>>();
	/* �첽���ڴ��������� */
	private WeakHashMap  _indexs = new WeakHashMap();
	public WeakPersistence() {
		super();
		ID = UUID.getUUID();
	}

	/**
	 * @return �������
	 */
	public UUID getID() {
		return ID;
	}

	/**
	 * ���ص�ǰ�������첽�����ɻ����嵥
	 * @return
	 */
	public IOVUpdfmxDestiny getBottle() {
		IOVUpdfmxDestiny fromUpdfmx = new IOVUpdfmxDestiny( this );
		IOVUpdfmxDestiny fromBottle = new IOVUpdfmxDestiny( this );
		try 
		{
			for( java.util.Iterator<java.util.Map.Entry<Class<?>, java.util.List<DataStructInterface>>> itera = _tables.entrySet().iterator(); itera.hasNext(); ) {
				java.util.Map.Entry<Class<?>, java.util.List<DataStructInterface>> fromEntry = (java.util.Map.Entry<Class<?>, java.util.List<DataStructInterface>>)itera.next();
				Class<?> __composite = (java.lang.Class<?>)fromEntry.getKey();
				java.util.List<DataStructInterface> __bottle = (java.util.List<DataStructInterface>)fromEntry.getValue();
				for( java.util.Iterator<DataStructInterface> iterap = __bottle.iterator(); iterap.hasNext(); ) {
					DataStructInterface fromEntity = (DataStructInterface)iterap.next();
					if( OracleUtils.ICustom.isCommit( fromEntity ) == false ){ continue; }
					fromBottle.getBottle( __composite, fromEntity ).getBottle().add( fromEntity );
				}
			}
			if( fromBottle != null && fromBottle.getDestiny().size() > 0 ){
				for( java.util.Iterator<IOVUpdfmxDestiny.IUpdfmxOffer> itera = fromBottle.getDestiny().values().iterator(); itera.hasNext(); ) {
					IOVUpdfmxDestiny.IUpdfmxBottle __bottle = (IOVUpdfmxDestiny.IUpdfmxBottle)itera.next();
					IOVUpdfmxDestiny.IUpdfmxDestiny __destiny = fromUpdfmx.getDestiny( __bottle.getDestiny() );
					ClassUtils.IMerge.merge( __bottle.getBottle(), __destiny.getBottle() );
				}
			}
		}
		catch( java.lang.Exception exception ){
			ExceptionFactory.throwOracle("IOS0014000", new String[]{ exception.getMessage() }, exception);
		}
		finally{
			if( fromBottle != null ){ fromBottle = null; }
		}
		return fromUpdfmx;
	}
	
	/**
	 * ���ݵ�ǰ���ݲֿ����ѯ��ǰ�������첽�����嵥
	 * @param _composite ���ݲֿ���
	 * @param _query ָ������ʵ��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public DataStructInterface[] getBottle(Class<?> _composite, DataStructInterface _query) throws SFException,Exception{
		DataStructInterface[] fromArray = null;
		IOVUpdfmxDestiny fromUpdfmx = new IOVUpdfmxDestiny( this );
		try 
		{
			IOVUpdfmxDestiny.IUpdfmxBottle fromBottle = fromUpdfmx.getBottle( _composite, _query );
			java.util.List<DataStructInterface> __bottle = (java.util.List<DataStructInterface>)_tables.get( _composite );
			if( __bottle != null && __bottle.isEmpty() == false ){
				for( java.util.Iterator<DataStructInterface> itera = __bottle.iterator(); itera.hasNext(); ) {
					DataStructInterface fromEntity = (DataStructInterface)itera.next();
					if( OracleUtils.ICustom.equals( fromEntity, _query ) ) {
						fromBottle.getBottle().add( fromEntity );
					}
				}
				if( fromBottle != null && fromBottle.getBottle().size() > 0) {
					fromArray = (DataStructInterface[])ClassUtils.IClass.arrayCopy(fromBottle.getBottle(), _query.getClass());
				}
			}
		} 
		finally{
			if( fromUpdfmx != null ) { fromUpdfmx = null; }
		}
		return fromArray;
	}
	
	/**
	 * @return ���ص�ǰ�����첽��ȫ���嵥
	 */
	public java.util.HashMap<Class<?>, java.util.List<DataStructInterface>> getSubSQL() {
		return _tables;
	}
	
	/**
	 * ���ݵ�ǰ���ݲֿ����ѯ��ǰ�������첽��ȫ���嵥
	 * @param _composite  ���ݲֿ���
	 * @param _query ָ������ʵ��
	 * @return
	 */
	public DataStructInterface[] getSubSQL(Class<?> _composite, DataStructInterface _query) {
		DataStructInterface[] fromArray = null;
		java.util.List<DataStructInterface> _transaction = new java.util.ArrayList<DataStructInterface>();
		try 
		{
			java.util.List<DataStructInterface> __bottle = (java.util.List<DataStructInterface>)_tables.get( _composite );
			if( __bottle != null && __bottle.isEmpty() == false ) {
				for (java.util.Iterator<DataStructInterface> itera = __bottle.iterator(); itera.hasNext();) {
					DataStructInterface fromEntity = (DataStructInterface) itera.next();
					if( OracleUtils.ICustom.equals( fromEntity, _query) ){ _transaction.add(fromEntity); }
				}
				if( _transaction != null && _transaction.size() > 0 ){
					fromArray = (DataStructInterface[]) ClassUtils.IClass.arrayCopy(_transaction, _query.getClass());
				}
			}
		} 
		finally{
			if( _transaction != null ) { _transaction.clear(); _transaction = null; }
		}
		return fromArray;
	}

	/**
	 * @return �첽���ڴ���������
	 */
	public WeakHashMap getIndexs() {
		return _indexs;
	}

	/**
	 * ���ݵ�ǰ���������ѯ��ǰ�첽��������
	 * @param aINDEX ��������
	 * @return
	 */
	public java.util.Map<Class<?>, java.util.List<DataStructInterface>> getIndexs(Object fromCREATE) {
		return (java.util.Map<Class<?>, java.util.List<DataStructInterface>>)_indexs.get(fromCREATE);
	}

	/**
	 * ��������Ψһ�԰�aOBJECT�ϲ���ǰ��������
	 * @param _composite ���ݲֿ���
	 * @param aOBJECT ����ʵ��
	 * @param fromUpfwm ����ʵ���б�
	 */
	private void transfer(Class<?> _composite, Object aOBJECT, java.util.List<DataStructInterface> fromUpfwm) {
		try 
		{
			Object fromArray[] = new Object[] { aOBJECT };
			if( ClassUtils.IClass.isArray( aOBJECT ) ){ fromArray = (Object[]) aOBJECT; }
			for( int index = 0; fromArray != null && index < fromArray.length; index++ ) {
				if( fromArray[index] == null ) continue;
				if( isBottle( fromArray[index] ) == false ){
					ExceptionFactory.throwOracle("IOS0014011", new String[]{ fromArray[index].getClass().getName() });
				}
				DataStructInterface fromEntity = (DataStructInterface)fromArray[index];
				fromUpfwm.add(fromEntity);
			}
		} 
		finally{

		}
	}

	/**
	 * ��ǰ�첽�����ύ���첽������
	 * @param _bottle �첽����
	 */
	public void commit(Object _bottle) {
		try 
		{
			commit(IUpdcConst.IUpdbm.IUpdcDAO, _bottle);
		} 
		finally{

		}
	}

	/**
	 * ���첽�����ύ���첽��־û���
	 * @param _composite ���ݲֿ���
	 * @param _bottle �첽����
	 */
	public void commit(Class<?> _composite, Object _bottle) {
		try 
		{
			java.util.List<DataStructInterface> _transaction = (java.util.List<DataStructInterface>)_tables.get( _composite );
			if( _transaction == null ){
				_tables.put( _composite, _transaction = new java.util.ArrayList<DataStructInterface>());
			}
			transfer( _composite, _bottle, _transaction );
		}
		finally {

		}
	}

	/**
	 * ��ǰ�첽�����ύ���첽�����в���������
	 * @param _create ��������
	 * @param _composite ���ݲֿ���
	 * @param _bottle �첽����
	 */
	public void commit(Object _create, Class<?> _composite, Object _bottle) {
		try 
		{
			commit( _composite, _bottle );
			java.util.Map<Class<?>, java.util.List<DataStructInterface>> fromBottom = null;
			fromBottom = (java.util.Map<Class<?>, java.util.List<DataStructInterface>>)_indexs.get(_create);
			if( fromBottom == null ) {
				_indexs.put(_create, fromBottom = new java.util.HashMap<Class<?>, java.util.List<DataStructInterface>>());
			}
			java.util.List<DataStructInterface> _transaction =(java.util.List<DataStructInterface>)fromBottom.get(_composite); 
			if( _transaction == null) {
				fromBottom.put(_composite, _transaction = new java.util.ArrayList<DataStructInterface>());
			}
			transfer( _composite, _bottle, _transaction );
		} 
		finally {

		}
	}
	
	/**
	 * ��ָ���첽��־û��ϲ�����ǰ�첽�־û�������
	 * @param fromUpfwm ָ���첽��־û�
	 */
	public void commit( WeakPersistence fromUpfwm ){
		try
		{
			ClassUtils.IMerge.atomIn( fromUpfwm._tables , _tables  );
			ClassUtils.IMerge.atomIn( fromUpfwm._indexs , _indexs  ); 
		}
		finally{
			
		}
	}
	/**
	 * ���ݴ�����������ع���ǰ�첽�����ɻ���
	 * @param _create  ��������
	 */
	public java.util.List<DataStructInterface> rollback(Object _create) {
		java.util.List<DataStructInterface> fromDELETE = new java.util.ArrayList<DataStructInterface>();
		try 
		{
			java.util.Map<Class<?>, java.util.List<DataStructInterface>> fromINDEX = null;
			fromINDEX = (java.util.Map<Class<?>, java.util.List<DataStructInterface>>)_indexs.get( _create );
			if( fromINDEX != null && fromINDEX.size() >= 0 ) {
				for( java.util.Iterator<java.util.Map.Entry<Class<?>, java.util.List<DataStructInterface>>> itera = fromINDEX.entrySet().iterator(); itera.hasNext();) {
					java.util.Map.Entry<Class<?>, java.util.List<DataStructInterface>> fromEntry = (java.util.Map.Entry<Class<?>, java.util.List<DataStructInterface>>)itera.next();
					Class<?> _composite = (Class<?>) fromEntry.getKey();
					if( _tables.containsKey( _composite ) == false ){ continue; }
					java.util.List<DataStructInterface> _memory = (java.util.List<DataStructInterface>)fromEntry.getValue();
					java.util.List<DataStructInterface> _transaction = (java.util.List<DataStructInterface>)_tables.get( _composite );
					ClassUtils.IMerge.purge( _memory, _transaction );
					ClassUtils.IMerge.merge( _memory, fromDELETE   );
					if( _transaction.size() <= 0 ){ _tables.remove( _composite ); }
					_memory.clear();
				}
				_indexs.remove( _create );
			}
		} 
		finally {

		}
		return fromDELETE;
	}
	
	/**
	 * �ͷ��첽�����л���
	 *
	 */
	public void rollback(){
		_tables.clear();
		_indexs.clear();
	}
	
	/**
	 * 
	 * @param aOBJECT
	 * @return
	 */
	public boolean isBottle(Object fromSubJSQL) {
		return fromSubJSQL != null && (fromSubJSQL instanceof DataContainer || fromSubJSQL instanceof DataContainer[] ||
				fromSubJSQL instanceof HQSQLEntityBean || fromSubJSQL instanceof HQSQLEntityBean[] );
	}

}
