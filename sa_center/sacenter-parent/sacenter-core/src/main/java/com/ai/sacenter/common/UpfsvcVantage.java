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
 * <p>Description: 服务级事务</p>
 * <p>Copyright: Copyright (c) 2018年3月20日</p>
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
	 * <p>Description: 服务过程基类</p>
	 * <p>Copyright: Copyright (c) 2018年3月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0 
	 */
	public static class IUpdfmxMotion implements java.io.Serializable{
		private static final long serialVersionUID = 5196360046768111416L;
		/*事务编号*/
		protected UUID _id = null;
		/*服务缓存[继承性]*/
		protected java.util.Map _motion = new java.util.HashMap();
		public IUpdfmxMotion() {
			super();
			_id = UUID.getUUID();
		}

		/**
		 * @return 事务编号
		 */
		public UUID getID() {
			return _id;
		}
		
		/**
		 * @return 服务缓存
		 */
		public java.util.Map getMotion() {
			return _motion;
		}
		
		/**
		 * 根据缓存编码获取对应缓存实体
		 * @param _custom_id_ 缓存编码
		 * @return
		 */
		public Object getIUpfxMotion( Object _custom_id_ ){
			return _motion.get( _custom_id_ );
		}
		
		/**
		 * 根据缓存编码提交缓存实体
		 * @param _custom_id_ 缓存编码
		 * @param _motion_ 缓存实体
		 */
		public void submitIUpfxMotion( Object _custom_id_, Object _motion_ ){
			_motion.put( _custom_id_, _motion_ );
		}
		
		/**
		 * 释放当前内存
		 */
		public void finishCustom(){
			_motion.clear(); _motion = null;
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 服务事务</p>
	 * <p>Copyright: Copyright (c) 2018年3月20日</p>
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
		 * 释放当前内存
		 */
		public void finishCustom(){
			super.finishCustom();
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 数据库级服务事务</p>
	 * <p>Copyright: Copyright (c) 2017年12月14日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class OracleTransaction extends UserTransaction implements java.io.Serializable{
		private static final long serialVersionUID = -4966234433779062178L;
		/*父级事务*/
		private UserTransaction    _parented  = null;
		/*当前事务*/
		private UserTransaction    _currently = null;
		/*数据连接池*/
		private java.util.HashMap  _subflow   = new java.util.HashMap();
		public OracleTransaction(){
			super();
		}
		
		/**
		 * @return 数据连接池
		 */
		public java.util.HashMap getSubFlow() {
			return _subflow;
		}
		
		/**
		 * 是否已存在数据库级事务
		 * @return
		 */
		public boolean isTransaction(){
			return ServiceManager.getSession().isStartTransaction();
		}
		
		/**
		 * 启动新数据库级事务并且挂起当前数据库事务
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
		 * 提交当前数据库事务并且恢复父级数据库事务
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
		 * 回滚当前数据库事务并且恢复父级数据库事务
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
	 * <p>Description: 自建级服务事务</p>
	 * <p>Copyright: Copyright (c) 2018年3月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class SybaseTransaction extends UserTransaction implements java.io.Serializable{
		private static final long serialVersionUID = 201246241780584238L;
		/*服务变化缓存*/
		private java.util.List    _production   = new ArrayUQCList();
		/*服务全部缓存*/
		private java.util.List    _transversion = new ArrayUQCList();
		/*异步表缓存*/
		private WeakPersistence   _asynchronous = new WeakPersistence();
		/*过程类缓存*/
		private java.util.HashMap _composite    = new java.util.HashMap();
		/*用户资料缓存*/
		private IUpdfmxCustom     _custom       = new IUpdfmxCustom();
		public SybaseTransaction(){
			super();
		}
    	
		/**
		 * @return 服务变化缓存
		 */
		public java.util.List getProduction() {
			return _production;
		}

		/**
		 * @return 服务全量缓存
		 */
		public java.util.List getTransversion() {
			return _transversion;
		}

		/**
		 * @return 异步表缓存
		 */
		public WeakPersistence getAsynchronous() {
			return _asynchronous;
		}
		
		/**
		 * @return 过程类缓存
		 */
		public java.util.HashMap getComposite() {
			return _composite;
		}

		/**
		 * @return 用户资料缓存
		 */
		public IUpdfmxCustom getCustom() {
			return _custom;
		}

		/**
		 * 根据父级事务启动新事务[继承父级事务中用户资料]
		 * @param transaction 父级事务
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
		 * 根据下级事务提交上级新事务
		 * @param transaction 下级事务
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
		 * 根据下级事务回滚上级新事务
		 * @param transaction 下级事务
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
		 * 释放当前事务缓存内存
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
	 * <p>Description: 用户级缓存</p>
	 * <p>Copyright: Copyright (c) 2018年3月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IUpdfmxCustom extends UserTransaction implements java.io.Serializable{
		private static final long serialVersionUID = 8081553227549539744L;
		/*用户资料*/
		private java.util.Map<String, IUpdfmxDirectory> _custom = new java.util.HashMap<String, IUpdfmxDirectory>();
		/*到期用户*/
		private java.util.Map<String, IUpdfmxExpire> _expire = new java.util.HashMap<String, IUpdfmxExpire>();
		public IUpdfmxCustom(){
			super();
		}
		
		/**
		 * 用户资料 
		 * @return
		 */
		public java.util.Map<String, IUpdfmxDirectory> getCustom(){
			return _custom;
		}
		
		/**
		 * @return 到期用户
		 */
		public java.util.Map<String, IUpdfmxExpire> getExpire() {
			return _expire;
		}
		
		/**
		 * 根据用户编码获取用户资料缓存
		 * @param _custom_id_ 用户编码
		 * @return
		 */
		public IUpdfmxDirectory getIUpfxCustom( String _custom_id_ ){
			AssertUtils.notNull( _custom_id_ );
			return (IUpdfmxDirectory)_custom.get( _custom_id_ );
		}
		
		/**
		 * 根据用户组覆盖用户资料组[如用户主资料相同则覆盖当前用户主资料,否则覆盖当前用户子资料列表中]
		 * @param _directory_ 用户资料组
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
		 * 根据用户组全量覆盖用户资料组
		 * @param _custom_id_ 用户编码
		 * @param _directory_ 用户资料组
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
		 * 根据用户覆盖用户资料组[如用户主资料不存在则增加用户资料组,否则覆盖当前用户子资料列表中]
		 * @param _custom_id_ 用户编码
		 * @param _entry_ 用户资料
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
		 * 根据用户编码获取到期用户缓存
		 * @param _custom_id_ 用户编码
		 * @return
		 */
		public IUpdfmxExpire getIUpfxExpire( String _custom_id_ ){
			AssertUtils.notNull( _custom_id_ );
			return (IUpdfmxExpire)_expire.get( _custom_id_ );
		}
		
		/**
		 * 根据用户组全量覆盖用户资料组
		 * @param _custom_id_ 用户编码
		 * @param _expire_ 到期用户组
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
		 * 根据父级事务启动新事务[继承父级事务中用户资料]
		 * @param transaction 父级事务
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
		 * 根据下级事务提交上级新事务
		 * @param transaction 下级事务
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
		 * 根据下级事务回滚上级新事务
		 * @param transaction 下级事务
		 */
		public void rollbackAsTransaction(UserTransaction transaction) {
			try
			{
				
			}
			finally{
				
			}
		}
		
		/**
		 * 释放当前内存
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
	 * <p>Description: 服务过程类</p>
	 * <p>Copyright: Copyright (c) 2018年3月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IUpdfmxDeque extends UserTransaction implements java.io.Serializable{
		private static final long serialVersionUID = -7287493960837958668L;
		/*运算计算器*/
		private JevalSTKEngine _jeval = null;
		/*服务过程缓存*/
		private java.util.HashMap   _deque   = new java.util.HashMap();
		/*业务级缓存[继承性]*/
		private java.util.HashMap   _subflow = new java.util.HashMap();
		/*映射变化元素*/
		private java.util.ArrayList _change  = new java.util.ArrayList();
		/*映射全量元素*/
		private java.util.ArrayList _entity  = new java.util.ArrayList();
		/*父级事务*/
		private IUpdfmxDeque      _parent = null;
		public IUpdfmxDeque(){
			super();
		}
		
		/**
		 * @return 运算计算器
		 */
		public JevalSTKEngine getJEVAL() {
			return _jeval;
		}

		/**
		 * @param jeval 运算计算器
		 */
		public void setJEVAL(JevalSTKEngine jeval) {
			_jeval = jeval;
		}
		
		/**
		 * @return 服务过程缓存
		 */
		public java.util.HashMap getDeque() {
			return _deque;
		}

		/**
		 * @return 业务级缓存
		 */
		public java.util.HashMap getSubFlow() {
			return _subflow;
		}
		
		/**
		 * @return 映射变化元素
		 */
		public java.util.List getChange() {
			return _change;
		}

		/**
		 * @return 映射全量元素
		 */
		public java.util.List getEntity() {
			return _entity;
		}
		
		/**
		 * @return 父级事务
		 */
		public IUpdfmxDeque getParent() {
			return _parent;
		}

		/**
		 * @param parent 父级事务
		 */
		public void setParent(IUpdfmxDeque parent) {
			_parent = parent;
		}
		
		/**
		 * 启动新事务
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
		 * 启动新事务
		 * @param parent 父级事务
		 * @param offer 开通属性
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
		 * 提交事务到父级事务
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
		 * 回滚事务到父级事务
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
		 * 释放当前内存
		 */
		public void finishDeque(){
			super.finishCustom();
		}
	}
}
