package com.ai.sacenter.common;

import com.ai.appframe2.common.ServiceManager;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.jeval.JevalSTKEngine;
import com.ai.sacenter.util.ArrayUQCList;
import com.ai.sacenter.util.AssertUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.util.WeakPersistence;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ��������</p>
 * <p>Copyright: Copyright (c) 2018��3��20��</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class UpfsvcVantage implements java.io.Serializable{
	private static final long serialVersionUID = 4386320138003210139L;
	public UpfsvcVantage() {
		super();
	}
	
	/**
	 * <p>Title: sacenter-core</p>
	 * <p>Description: ������̻���</p>
	 * <p>Copyright: Copyright (c) 2018��3��20��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0 
	 */
	public static class IUpdfmxMotion implements java.io.Serializable{
		private static final long serialVersionUID = 5196360046768111416L;
		/*������*/
		protected UUID _id = null;
		/*���񻺴�[�̳���]*/
		protected java.util.Map _motion = new java.util.HashMap();
		public IUpdfmxMotion() {
			super();
			_id = UUID.getUUID();
		}

		/**
		 * @return ������
		 */
		public UUID getID() {
			return _id;
		}
		
		/**
		 * @return ���񻺴�
		 */
		public java.util.Map getMotion() {
			return _motion;
		}
		
		/**
		 * ���ݻ�������ȡ��Ӧ����ʵ��
		 * @param _custom_id_ �������
		 * @return
		 */
		public Object getIUpfxMotion( Object _custom_id_ ){
			return _motion.get( _custom_id_ );
		}
		
		/**
		 * ���ݻ�������ύ����ʵ��
		 * @param _custom_id_ �������
		 * @param _motion_ ����ʵ��
		 */
		public void submitIUpfxMotion( Object _custom_id_, Object _motion_ ){
			_motion.put( _custom_id_, _motion_ );
		}
		
		/**
		 * �ͷŵ�ǰ�ڴ�
		 */
		public void finishCustom(){
			_motion.clear(); _motion = null;
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: ��������</p>
	 * <p>Copyright: Copyright (c) 2018��3��20��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class UserTransaction extends IUpdfmxMotion{
		private static final long serialVersionUID = 8128564943410651425L;
		public UserTransaction(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return _id.toString();
		}
		
		/**
		 * �ͷŵ�ǰ�ڴ�
		 */
		public void finishCustom(){
			super.finishCustom();
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: ���ݿ⼶��������</p>
	 * <p>Copyright: Copyright (c) 2017��12��14��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class OracleTransaction extends UserTransaction implements java.io.Serializable{
		private static final long serialVersionUID = -4966234433779062178L;
		/*��������*/
		private UserTransaction    _parented  = null;
		/*��ǰ����*/
		private UserTransaction    _currently = null;
		/*�������ӳ�*/
		private java.util.HashMap  _subflow   = new java.util.HashMap();
		public OracleTransaction(){
			super();
		}
		
		/**
		 * @return �������ӳ�
		 */
		public java.util.HashMap getSubFlow() {
			return _subflow;
		}
		
		/**
		 * �Ƿ��Ѵ������ݿ⼶����
		 * @return
		 */
		public boolean isTransaction(){
			return ServiceManager.getSession().isStartTransaction();
		}
		
		/**
		 * ���������ݿ⼶�����ҹ���ǰ���ݿ�����
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction() throws SFException,Exception{
			try
			{
				if( isTransaction() ){
					ServiceManager.getSession().suspend();
					_parented = new UserTransaction();
				}
				ServiceManager.getSession().startTransaction();
				_currently = new UserTransaction();
			}
			catch( java.lang.Exception exception ){
				if( _parented != null ){
					ServiceManager.getSession().resume();
					_parented = null;
				}
				_currently = null;
				throw exception;
			}
		}

		/**
		 * �ύ��ǰ���ݿ������һָ��������ݿ�����
		 * @throws SFException
		 * @throws Exception
		 */
		public void commitTransaction() throws SFException,Exception{
			try
			{
				if( _currently != null ){
					ServiceManager.getSession().commitTransaction();
					_currently = null;
				}
				if( _parented != null ){
					ServiceManager.getSession().resume();
					_parented = null;
				}
			}
			finally{
				
			}
		}

		/**
		 * �ع���ǰ���ݿ������һָ��������ݿ�����
		 * @throws SFException
		 * @throws Exception
		 */
		public void rollbackTransaction() throws SFException,Exception{
			try
			{
				if( _currently != null ){
					ServiceManager.getSession().rollbackTransaction();
					_currently = null;
				}
				if( _parented != null ){
					ServiceManager.getSession().resume();
					_parented = null;
				}
			}
			finally{
				
			}
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: �Խ�����������</p>
	 * <p>Copyright: Copyright (c) 2018��3��20��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class SybaseTransaction extends UserTransaction implements java.io.Serializable{
		private static final long serialVersionUID = 201246241780584238L;
		/*����仯����*/
		private java.util.List    _production   = new ArrayUQCList();
		/*����ȫ������*/
		private java.util.List    _transversion = new ArrayUQCList();
		/*�첽����*/
		private WeakPersistence   _asynchronous = new WeakPersistence();
		/*�����໺��*/
		private java.util.HashMap _composite    = new java.util.HashMap();
		/*�û����ϻ���*/
		private IUpdfmxCustom     _custom       = new IUpdfmxCustom();
		public SybaseTransaction(){
			super();
		}
    	
		/**
		 * @return ����仯����
		 */
		public java.util.List getProduction() {
			return _production;
		}

		/**
		 * @return ����ȫ������
		 */
		public java.util.List getTransversion() {
			return _transversion;
		}

		/**
		 * @return �첽����
		 */
		public WeakPersistence getAsynchronous() {
			return _asynchronous;
		}
		
		/**
		 * @return �����໺��
		 */
		public java.util.HashMap getComposite() {
			return _composite;
		}

		/**
		 * @return �û����ϻ���
		 */
		public IUpdfmxCustom getCustom() {
			return _custom;
		}

		/**
		 * ���ݸ�����������������[�̳и����������û�����]
		 * @param transaction ��������
		 */
		public void beginAsTransaction(UserTransaction transaction) {
			try
			{
				_custom.beginAsTransaction( transaction );
			}
			finally{
				
			}
		}

		/**
		 * �����¼������ύ�ϼ�������
		 * @param transaction �¼�����
		 */
		public void commitAsTransaction(UserTransaction transaction) {
			try
			{
				_custom.commitAsTransaction( transaction                               );
				SybaseTransaction _transaction = (SybaseTransaction)transaction;
				_asynchronous.commit       ( _transaction._asynchronous                );
				ClassUtils.IMerge.merge    ( _transaction._production  , _production   );
	            ClassUtils.IMerge.merge    ( _transaction._transversion, _transversion );
			}
			finally{
				
			}
		}
		
		/**
		 * �����¼�����ع��ϼ�������
		 * @param transaction �¼�����
		 */
		public void rollbackAsTransaction(UserTransaction transaction) {
			try
			{
				_custom.rollbackAsTransaction( transaction  );
			}
			finally{
				
			}
		}

		/**
		 * �ͷŵ�ǰ���񻺴��ڴ�
		 */
		public void finishRocket(){
			try
			{
				if( _custom != null ) { _custom.finishCustom(); _custom = null; }
				if( _production != null ){ _production.clear(); }
				if( _asynchronous != null ) { _asynchronous.rollback(); }
			}
			finally{
				
			}
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return super.toString();
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: �û�������</p>
	 * <p>Copyright: Copyright (c) 2018��3��20��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IUpdfmxCustom extends UserTransaction implements java.io.Serializable{
		private static final long serialVersionUID = 8081553227549539744L;
		/*�û�����*/
		private java.util.Map<String, IUpdfmxDirectory> _custom = new java.util.HashMap<String, IUpdfmxDirectory>();
		/*�����û�*/
		private java.util.Map<String, IUpdfmxExpire> _expire = new java.util.HashMap<String, IUpdfmxExpire>();
		public IUpdfmxCustom(){
			super();
		}
		
		/**
		 * �û����� 
		 * @return
		 */
		public java.util.Map<String, IUpdfmxDirectory> getCustom(){
			return _custom;
		}
		
		/**
		 * @return �����û�
		 */
		public java.util.Map<String, IUpdfmxExpire> getExpire() {
			return _expire;
		}
		
		/**
		 * �����û������ȡ�û����ϻ���
		 * @param _custom_id_ �û�����
		 * @return
		 */
		public IUpdfmxDirectory getIUpfxCustom( String _custom_id_ ){
			AssertUtils.notNull( _custom_id_ );
			return (IUpdfmxDirectory)_custom.get( _custom_id_ );
		}
		
		/**
		 * �����û��鸲���û�������[���û���������ͬ�򸲸ǵ�ǰ�û�������,���򸲸ǵ�ǰ�û��������б���]
		 * @param _directory_ �û�������
		 */ 
		public void submitIUpfxCustom( IUpdfmxDirectory _directory_ ){
			AssertUtils.notNull( _directory_ );
			AssertUtils.notNull( _directory_.getGroup() );
			IUpdfmxDirectory __directory__ = (IUpdfmxDirectory)_custom.get( _directory_.getGroup() );
			if( __directory__ == null ){
				_custom.put( _directory_.getGroup(), _directory_ );
			}
			else if( __directory__.getBottle() == null ){
				__directory__.setBottle( _directory_.getBottle() );
				__directory__.getDirectory().clear();
				for( java.util.Iterator<IUpdfmxEntry> itera = _directory_.getDirectory().iterator(); itera.hasNext(); ){
					IUpdfmxEntry __entry__ = (IUpdfmxEntry)itera.next();
					if( __entry__ == null ){ continue; }
					__directory__.getDirectory().add( __entry__ );
				}
			}
			else{
				__directory__.setBottle( _directory_.getBottle() );
				for( java.util.Iterator<IUpdfmxEntry> itera = _directory_.getDirectory().iterator(); itera.hasNext(); ){
					IUpdfmxEntry __entry__ = (IUpdfmxEntry)itera.next();
					if( __entry__ == null ){ continue; }
					int __indexOf__ = __directory__.getDirectory().indexOf( __entry__ );
					if( __indexOf__ < 0 ){ __directory__.getDirectory().add( __entry__ ); }
					else{ __directory__.getDirectory().set( __indexOf__, __entry__ ); }
				}
			}
		}
		
		/**
		 * �����û���ȫ�������û�������
		 * @param _custom_id_ �û�����
		 * @param _directory_ �û�������
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxDirectory _directory_ ){
			AssertUtils.notNull( _custom_id_ );
			if( _directory_ == null ){
				_custom.put( _custom_id_, new IUpdfmxDirectory( _custom_id_ ) );
			}
			else{
				AssertUtils.isTrue( _custom_id_.equals( _directory_.getGroup() ) );
				_custom.put( _custom_id_, _directory_ );
			}
		}
		
		/**
		 * �����û������û�������[���û������ϲ������������û�������,���򸲸ǵ�ǰ�û��������б���]
		 * @param _custom_id_ �û�����
		 * @param _entry_ �û�����
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxEntry _entry_ ){
			IUpdfmxDirectory __directory__ = (IUpdfmxDirectory)_custom.get( _custom_id_ );
			if( __directory__ == null ){
				__directory__ = new IUpdfmxDirectory( _custom_id_, _entry_ );
				_custom.put( __directory__.getGroup(), __directory__ );
			}
			else{
				int __indexOf__ = __directory__.getDirectory().indexOf( _entry_ );
				if( __indexOf__ < 0 ){ __directory__.getDirectory().add( _entry_ ); }
				else{ __directory__.getDirectory().set( __indexOf__, _entry_ ); }
			}
		}
		
		/**
		 * �����û������ȡ�����û�����
		 * @param _custom_id_ �û�����
		 * @return
		 */
		public IUpdfmxExpire getIUpfxExpire( String _custom_id_ ){
			AssertUtils.notNull( _custom_id_ );
			return (IUpdfmxExpire)_expire.get( _custom_id_ );
		}
		
		/**
		 * �����û���ȫ�������û�������
		 * @param _custom_id_ �û�����
		 * @param _expire_ �����û���
		 */
		public void submitIUpfxExpire( String _custom_id_, IUpdfmxExpire _expire_ ){
			AssertUtils.notNull( _custom_id_ );
			IUpdfmxExpire __expire__ = (IUpdfmxExpire)_expire.get( _custom_id_ );
			if( _expire_ == null && __expire__ != null ){
				_expire.remove( _custom_id_ );
			}
			else if( _expire_ != null && __expire__ == null ){
				_expire.put( _custom_id_, _expire_ );
			}
			else if( _expire_ != null && _expire_.equals( __expire__ ) ){
				for( java.util.Iterator<IUpdfmxEntry> itera = __expire__.getSUBJECT().iterator(); itera.hasNext(); ){
					IUpdfmxExpire ___expire___ = (IUpdfmxExpire)itera.next();
					_expire_.getSUBJECT().add( (IUpdfmxExpire)ClassUtils.IClass.atomDesign( ___expire___ ) );
				}
				_expire.put( _custom_id_, _expire_ );
			}
			else if( _expire_ != null ){
				if( __expire__.getSUBJECT().get( _expire_ ) == null ){ __expire__.getSUBJECT().add( _expire_ ); }
				for( java.util.Iterator<IUpdfmxEntry> itera = _expire_.getSUBJECT().iterator(); itera.hasNext(); ){
					IUpdfmxExpire ___expire___ = (IUpdfmxExpire)itera.next();
					int __indexOf__ = __expire__.getSUBJECT().indexOf( ___expire___ );
					if( __indexOf__ < 0 ){ 
						__expire__.getSUBJECT().add( (IUpdfmxExpire)ClassUtils.IClass.atomDesign( ___expire___ ) );
					}
					else{
						__expire__.getSUBJECT().set( __indexOf__, (IUpdfmxExpire)ClassUtils.IClass.atomDesign( ___expire___ ) );
					}
				}
			}
		}
		
		/**
		 * ���ݸ�����������������[�̳и����������û�����]
		 * @param transaction ��������
		 */
		public void beginAsTransaction(UserTransaction transaction) {
			try
			{
				if( transaction instanceof IUpdfmxCustom ){
					
				}
				else if( transaction instanceof SybaseTransaction ){
					
				}
			}
			finally{
				
			}
		}

		/**
		 * �����¼������ύ�ϼ�������
		 * @param transaction �¼�����
		 */
		public void commitAsTransaction(UserTransaction transaction) {
			try
			{
				if( transaction != null && ( transaction instanceof IUpdfmxCustom ) ){
					IUpdfmxCustom _custom_ = (IUpdfmxCustom)transaction;
					ClassUtils.IMerge.atomDesign( _custom_._custom,  _custom );
				}
				else if( transaction != null && ( transaction instanceof SybaseTransaction ) ){
					IUpdfmxCustom _custom_ = ((SybaseTransaction)transaction)._custom;
					ClassUtils.IMerge.atomDesign( _custom_._custom,  _custom );
					ClassUtils.IMerge.atomDesign( _custom_._expire,  _expire );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * �����¼�����ع��ϼ�������
		 * @param transaction �¼�����
		 */
		public void rollbackAsTransaction(UserTransaction transaction) {
			try
			{
				
			}
			finally{
				
			}
		}
		
		/**
		 * �ͷŵ�ǰ�ڴ�
		 */
		public void finishCustom(){
			super.finishCustom();
			_custom.clear(); _custom = null;
			_expire.clear(); _expire = null;
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: ���������</p>
	 * <p>Copyright: Copyright (c) 2018��3��20��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IUpdfmxDeque extends UserTransaction implements java.io.Serializable{
		private static final long serialVersionUID = -7287493960837958668L;
		/*���������*/
		private JevalSTKEngine _jeval = null;
		/*������̻���*/
		private java.util.HashMap   _deque   = new java.util.HashMap();
		/*ҵ�񼶻���[�̳���]*/
		private java.util.HashMap   _subflow = new java.util.HashMap();
		/*ӳ��仯Ԫ��*/
		private java.util.ArrayList _change  = new java.util.ArrayList();
		/*ӳ��ȫ��Ԫ��*/
		private java.util.ArrayList _entity  = new java.util.ArrayList();
		/*��������*/
		private IUpdfmxDeque      _parent = null;
		public IUpdfmxDeque(){
			super();
		}
		
		/**
		 * @return ���������
		 */
		public JevalSTKEngine getJEVAL() {
			return _jeval;
		}

		/**
		 * @param jeval ���������
		 */
		public void setJEVAL(JevalSTKEngine jeval) {
			_jeval = jeval;
		}
		
		/**
		 * @return ������̻���
		 */
		public java.util.HashMap getDeque() {
			return _deque;
		}

		/**
		 * @return ҵ�񼶻���
		 */
		public java.util.HashMap getSubFlow() {
			return _subflow;
		}
		
		/**
		 * @return ӳ��仯Ԫ��
		 */
		public java.util.List getChange() {
			return _change;
		}

		/**
		 * @return ӳ��ȫ��Ԫ��
		 */
		public java.util.List getEntity() {
			return _entity;
		}
		
		/**
		 * @return ��������
		 */
		public IUpdfmxDeque getParent() {
			return _parent;
		}

		/**
		 * @param parent ��������
		 */
		public void setParent(IUpdfmxDeque parent) {
			_parent = parent;
		}
		
		/**
		 * ����������
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginAsDeque( IUpdfmxDeque parent ) throws SFException,Exception{
			try
			{
				_parent = parent;
				if( _parent != null ){
					_motion.putAll ( _parent._motion  );
					_subflow.putAll( _parent._subflow );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * ����������
		 * @param parent ��������
		 * @param offer ��ͨ����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginAsDeque( IUpdfmxDeque parent, java.util.Map offer, IUpdcContext aContext ) throws SFException,Exception{
			java.util.Map _offer = new java.util.HashMap();
			try
			{
				beginAsDeque( parent );
				_jeval = new JevalSTKEngine();
				ClassUtils.IMerge.merge( _subflow, _offer, true );
				ClassUtils.IMerge.merge( offer, _offer, true );
				_jeval.submitVariables( _offer, aContext );
			}
			finally{
				if( _offer != null ){ _offer.clear(); _offer = null; }
			}
		}
		
		/**
		 * �ύ���񵽸�������
		 * @throws SFException
		 * @throws Exception
		 */
		public void commitAsDeque( ) throws SFException,Exception{
			try
			{
				
			}
			finally{
				
			}
		}
		
		/**
		 * �ع����񵽸�������
		 * @throws SFException
		 * @throws Exception
		 */
		public void rollbackAsDeque() throws SFException,Exception{
			try
			{
				
			}
			finally{
				
			}
		}
		
		/**
		 * �ͷŵ�ǰ�ڴ�
		 */
		public void finishDeque(){
			super.finishCustom();
		}
	}
}
