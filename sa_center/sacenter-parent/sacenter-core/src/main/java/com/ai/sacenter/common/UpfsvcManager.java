package com.ai.sacenter.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.center.SFCenterOffer;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jeval.JevalSTKEngine;
import com.ai.sacenter.util.ArrayDeque;
import com.ai.sacenter.util.ArrayUQCList;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JVMUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.valuebean.IOVUpdfmxDestiny;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IOVUpdfmxUnique;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpfsvcManager {
	private static final Log log = LogFactory.getLog( UpfsvcManager.class );
	private final static ThreadLocal _mbean_factory = new ThreadLocal();
	static{
    	try{
    		UpfsvcFactory.initial();
    	}
    	finally{
    		
    	}
    }
	
	public UpfsvcManager() {
		super();
	}
	
	/**
	 * 获取全局事务[数据库级事务和内存级事务]
	 * @return
	 */
	public static IUpfsvcMBean getMBean(){
		IUpfsvcMBean _transparent = null;
		try
		{
			_transparent = (UpfsvcMBeanImpl)_mbean_factory.get();
			if( _transparent == null ){
				_transparent = new UpfsvcMBeanImpl();
				_transparent.setQuality( SystemUtils.ICustom._wrap( _transparent ) );
				_mbean_factory.set( _transparent );
				if (log.isDebugEnabled()) log.debug("ucmframe create thread name:" + SystemUtils.getCLUSTER() + " mbean [" + _transparent + "]");
			}
		}
		catch( java.lang.Exception exception ){
			String fromWEBLOGIC[] = JVMUtils.getWEBLOGIC();
			ExceptionFactory.throwRuntime("IOS0012017", new String[]{ fromWEBLOGIC[0], 
					fromWEBLOGIC[1], exception.getMessage() }, exception);
		}
		finally{
			
		}
		return _transparent;
	}
	
	/**
	 * 获取全局事务[数据库级事务和内存级事务](如线程上无，则返回空)
	 * @return
	 */
	public static IUpfsvcMBean getBlankMBean(){
		UpfsvcMBeanImpl _transparent = null;
		try 
		{
			_transparent = (UpfsvcMBeanImpl)_mbean_factory.get();
		} 
		finally {

		}
		return _transparent;
	}
	
	/**
	 * 获取当前数据库级事务,如全局事务中不存在数据库级事务则抛异常
	 * @return
	 */
	public static IUpfsvcOracle getSession(){
		IUpfsvcOracle _transaction = null;
		try 
		{
			IUpfsvcMBean _transparent = (UpfsvcMBeanImpl)_mbean_factory.get();
			if( _transparent == null ) {
				ExceptionFactory.throwRuntime("IOS0010000", new String[] { SystemUtils.getCLUSTER() });
			}
			_transaction = _transparent.getTransaction();
		}
		finally{
			
		}
		return _transaction;
	}

	/**
	 * 获取当前数据库级事务,如全局事务中不存在数据库级事务则返回NULL
	 * @return
	 */
	public static IUpfsvcOracle getBlankSession() {
		IUpfsvcOracle _transaction = null;
		try
		{
			UpfsvcMBeanImpl _transparent = (UpfsvcMBeanImpl)_mbean_factory.get();
			if( _transparent != null ){
				if( _transparent._primitive.size() > 0 ){
					_transaction = (IUpfsvcOracle)_transparent._primitive.peek();
				}
			}
		}
		finally{
			
		}
		return _transaction;
	}
	
	/**
	 * 服务过程事务[用户资料缓存和服务过程事务]
	 * @return
	 */
	public static IUpfsvcRocket getRocket(){
		IUpfsvcRocket _vantage = null;
		try
		{
			IUpfsvcMBean _transparent = UpfsvcManager.getMBean();
			_vantage = _transparent.getRocket();
		}
		finally{
			
		}
		return _vantage;
	}
	
	/**
	 * 如不存在事务提交则释放当前全局事务
	 * 
	 */
	public static void finishMBean() {
		try 
		{
			UpfsvcMBeanImpl _transparent = (UpfsvcMBeanImpl)_mbean_factory.get();
			if( _transparent != null && _transparent.getUnCommitted() == null ){
				_transparent.finishMBean();
				if( log.isDebugEnabled() ) log.debug("ucmframe release thread name:" + SystemUtils.getCLUSTER() + " mbean [" + _transparent + "]");
				_transparent = null;
				_mbean_factory.set(null);
			}
		} 
		finally {

		}
	}
	
	/**
	 * 强制释放当前线程上所有全局事务[数据库级事务和内存级事务]
	 */
	public static void forceMBean(){
		try 
		{
			UpfsvcMBeanImpl _transparent = (UpfsvcMBeanImpl)_mbean_factory.get();
			if( _transparent != null ) {
				_transparent.finishMBean();
				if( log.isDebugEnabled() ) log.debug("ucmframe release thread name:" + SystemUtils.getCLUSTER() + " mbean [" + _transparent + "]");
				_transparent = null;
			}
			_mbean_factory.set(null);
		} 
		finally {

		}
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 全局事务类</p>
	 * <p>Copyright: Copyright (c) 2015-1-8</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public interface IUpfsvcMBean{
		/**
		 * 
		 * @return 获取全局属性缓存
		 */
		public java.util.Map getGraphics();

		/**
		 * 
		 * @return 获取当前线程线程单例清单
		 */
		public java.util.Map getSingleton();

		/**
		 * 
		 * @return 获取计算表达式引擎
		 */
		public JevalSTKEngine getJEVAL();

		/**
		 * @return 全局应答属性
		 */
		public MBeanRsRspHome getRespond();

		/**
		 * 
		 * @return 临时属性集合
		 */
		public java.util.Map getDelegation();

		/**
		 * 
		 * @return 服务交易质量
		 */
		public MBeanDelegate getQuality();

		/**
		 * 
		 * @param fromMBean 服务交易质量
		 */
		public void setQuality(MBeanDelegate fromMBean);
		
		/**
		 * 服务过程缓存
		 * @return
		 */
		public IUpfsvcRocket getRocket();

		/**
		 * 启动新会话事务[新内存级事务和新数据库级事务][如存在会话事务则挂起当前会话事务]
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction() throws SFException,Exception;

		/**
		 * 启动新会话事务[新内存级事务和继承数据库级事务][如存在内存级事务则挂起当前内存级事务]
		 * @throws SFException
		 * @throws Exception
		 */
		public void carryTransaction() throws SFException,Exception;
		
		/**
		 * 获取当前会话事务[如不存在会话事务则抛异常]
		 * @return
		 */
		public IUpfsvcOracle getTransaction();

		/**
		 * 是否存在未提交会话事务[内存级事务、数据库级事务和过程级事务]
		 * @return 为NULL则不存在未提交会话事务
		 */
		public UpfsvcVantage.UserTransaction[] getUnCommitted();
		
		/**
		 * 提交当前会话事务[如存在父级会话事务则恢复父级会话事]
		 * @throws SFException
		 * @throws Exception
		 */
		public void commitTransaction() throws SFException,Exception;

		/**
		 * 回滚当前会话事务[如存在父级会话事务则恢复父级会话事]
		 * @throws SFException
		 * @throws Exception
		 */
		public void rollbackTransaction() throws SFException,Exception;

		/**
		 * 释放当前隔离性事务
		 * 
		 */
		public void finishMBean();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 全局隔离性事务[与线程变量并存]</p>
	 * <p>Copyright: Copyright (c) 2015-1-9</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class UpfsvcMBeanImpl implements IUpfsvcMBean,java.io.Serializable{
		private static final long serialVersionUID = -8174912867494762926L;
		/*全局隔离性事务编码*/
		private UUID _id = null;
		/*全局属性缓存(手工清除,与会话并存)*/
		private java.util.Map     _graphics = new java.util.HashMap();
		/*线程单例清单*/
		private java.util.Map     _singleton = new java.util.HashMap();
		/*正值表达式分析器*/
		private JevalSTKEngine    _jeval   = new JevalSTKEngine();
		/*全局反馈信息*/
		private MBeanRsRspHome    _respond   = new MBeanRsRspHome();
		/*临时线程集合*/
    	private java.util.Map     _delegation = new java.util.HashMap();
    	/*服务交易质量控制*/
    	private MBeanDelegate     _quality   = null;
    	/*服务过程缓存*/
    	private UpfsvcRocketImpl  _rocket    = new UpfsvcRocketImpl();
    	/*会话层隔离性事务*/
    	private ArrayDeque        _primitive = new ArrayDeque();
		public UpfsvcMBeanImpl(){
			super();
			_id = UUID.getUUID();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#getGraphics()
		 */
		public java.util.Map getGraphics() {
			return _graphics;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#getSingleton()
		 */
		public java.util.Map getSingleton() {
			return _singleton;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#getJEVAL()
		 */
		public JevalSTKEngine getJEVAL() {
			return _jeval;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#getRespond()
		 */
		public MBeanRsRspHome getRespond() {
			return _respond;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#getDelegation()
		 */
		public java.util.Map getDelegation() {
			return _delegation;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#getQuality()
		 */
		public MBeanDelegate getQuality(){
			try
			{
				if( _quality.getORDER_ID() <= 0 ){
					SFCenterOffer _centeroffer = SFCenterFactory.getCenterBlank();
					if( _centeroffer != null ){
						_quality.setREGION_ID( _centeroffer.getREGION_ID           () );
						_quality.setORDER_ID ( UpdcFactory.getIUpdcSV().getORDER_ID() );
					}
				}
			}
			catch( java.lang.Exception exception ){
				if( log.isErrorEnabled() ) log.error( exception.getMessage(), exception );
				SFException aEXCEPTION = ExceptionFactory.getException( exception );
				throw aEXCEPTION;
			}
			finally{
				
			}
			return _quality;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#setQuality(com.ai.sacenter.common.MBeanDelegate)
		 */
		public void setQuality(MBeanDelegate fromMBean) {
			_quality = fromMBean;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#getRocket()
		 */
		public IUpfsvcRocket getRocket() {
			if( _rocket == null ){ _rocket = new UpfsvcRocketImpl(); }
			return _rocket;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#beginTransaction()
		 */
		public void beginTransaction() throws SFException, Exception {
			try 
			{
				UpfsvcOracleImpl _transaction = new UpfsvcOracleImpl();
				if( log.isDebugEnabled() ){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] create rocket [" + _transaction + "]");
				}
				try
				{
					_transaction._transaction.beginTransaction();
					_transaction._transparent.getCustom().beginAsTransaction( _rocket._custom );
				}
				catch( java.lang.Exception exception ){
					_transaction._transaction.rollbackTransaction();
					throw exception;
				}
				try{
					_primitive.push( _transaction );
				}
				catch( java.lang.Exception exception ){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] create rocket [" + _transaction + "] exception");
					_transaction._transaction.rollbackTransaction();
					throw exception;
				}
			} 
			finally {

			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#carryTransaction()
		 */
		public void carryTransaction() throws SFException, Exception {
			try 
			{
				UpfsvcOracleImpl _transaction = new UpfsvcOracleImpl();
				if( log.isDebugEnabled() ){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] create rocket [" + _transaction + "]");
				}
				try{
					if( _transaction._transaction.isTransaction() == false ){
						_transaction._transaction.beginTransaction();
					}
					_transaction._transparent.getCustom().beginAsTransaction( _rocket._custom );
				}
				catch( java.lang.Exception exception ){
					_transaction._transaction.rollbackTransaction();
					throw exception;
				}
				try{
					_primitive.push( _transaction );
				}
				catch( java.lang.Exception exception ){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] create rocket [" + _transaction + "] exception");
					_transaction._transaction.rollbackTransaction();
					throw exception;
				}
			} 
			finally {

			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#getTransaction()
		 */
		public IUpfsvcOracle getTransaction() {
			IUpfsvcOracle _transaction = null;
			try 
			{
				if( _primitive.size() > 0 ){
					_transaction = (UpfsvcOracleImpl)_primitive.peek();
				}
				if( _transaction == null ) {
					ExceptionFactory.throwRuntime("IOS0010000", new String[] { SystemUtils.getCLUSTER() });
				}
			} 
			finally {

			}
			return _transaction;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#getUnCommitted()
		 */
		public UpfsvcVantage.UserTransaction[] getUnCommitted() {
			UpfsvcVantage.UserTransaction _commited[] = null;
			try
			{
				if( _primitive.size() > 0 || _rocket._rocket.size() > 0 ){
					int fromINDEX = 0;
					_commited = new UpfsvcVantage.UserTransaction[ _primitive.size() + _rocket._rocket.size() ];
					for(java.util.Iterator itera = _primitive.descendingIterator(); itera.hasNext();fromINDEX++ ){
						_commited[ fromINDEX ] = (UpfsvcVantage.UserTransaction)itera.next();
					}
					for(java.util.Iterator itera = _rocket._rocket.descendingIterator(); itera.hasNext();fromINDEX++ ){
						_commited[ fromINDEX ] = (UpfsvcVantage.UserTransaction)itera.next();
					}
				}
			}
			finally{
				
			}
			return _commited;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#commitTransaction()
		 */
		public void commitTransaction() throws SFException, Exception {
			IUpdcContext aContext = ClassUtils.getIContextImpl();
			try 
			{
				UpfsvcOracleImpl _transaction = (UpfsvcOracleImpl)_primitive.peek();
				UpfsvcVantage.SybaseTransaction __transaction = _transaction._transparent;
				IUpdcFactory.getIUpdwfSV().finishSFOrder( aContext );
				_transaction._transaction.commitTransaction();
				_rocket._custom.commitAsTransaction( __transaction.getCustom() );
				_primitive.pop();
				_transaction.finishRocket();
				if( log.isDebugEnabled() ){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] commit rocket [" + _transaction + "]");
				}
				_transaction = null;
			}
			finally {
				if( aContext != null ){ aContext.clear(); aContext = null; }
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#rollbackTransaction()
		 */
		public void rollbackTransaction() throws SFException,Exception{
			try
			{
				UpfsvcOracleImpl _transaction = (UpfsvcOracleImpl)_primitive.pop();
				_rocket._custom.rollbackAsTransaction( _transaction._transparent.getCustom() );
				_transaction._transaction.rollbackTransaction();
				_transaction.finishRocket();
				if (log.isDebugEnabled()){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] rollback rocket [" + _transaction + "]");
				}
				_transaction = null;
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcMBean#finishMBean()
		 */
		public void finishMBean() {
			try 
			{
				for ( ; _primitive.size() > 0; ) {
					UpfsvcOracleImpl _transaction = (UpfsvcOracleImpl)_primitive.pop();
					_transaction.finishRocket();
					if( log.isDebugEnabled() ){
						log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean[" + this + "] uncommitted rocket[" + _transaction + "]");
					}
					_transaction = null;
				}
				SystemUtils.ISystem.freeEnviron();
				_rocket.finishRocket(); _rocket = null;
				_graphics.clear()  ; _graphics   = null;
				_singleton.clear() ; _singleton  = null;
				_jeval = null      ; _respond    = null;
				_delegation.clear(); _delegation = null;
			} 
			finally {

			}
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return _id.toString();
		}
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 内存事务类</p>
	 * <p>Copyright: Copyright (c) 2015-1-9</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public interface IUpfsvcOracle{
		/**
		 * @return 服务级缓存
		 */
		public java.util.Map getMotion();
		
		/**
		 * 启动新内存级事务并且挂起父级内存级事务
		 * @return
		 */
		public void beginTransaction();

		/**
		 * 获取当前内存级事务
		 * @return
		 */
		public UpfsvcVantage.SybaseTransaction getTransaction();
		
		/**
		 * 根据组件类获取当前归属网元索引区
		 * @param _component_ 组件类
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVUpdfmxUnique getIUpfxUnique( String _component_ ) throws SFException,Exception;
		
		/**
		 * 获取当前内存事务类中用户资料缓存
		 * @return
		 */
		public UpfsvcVantage.IUpdfmxCustom getIUpfxCustom();
		
		/**
		 * 根据用户编码获取当前内存事务类中用户资料缓存
		 * @param _custom_id_ 用户编码
		 * @return
		 */
		public IUpdfmxDirectory getIUpfxCustom( String _custom_id_ );
		
		/**
		 * 根据用户覆盖当前内存事务类中用户资料组[如用户主资料不存在则当前内存事务类中增加用户资料组,否则覆盖当前内存事务类中当前用户子资料列表中]
		 * @param _custom_id_ 用户编码
		 * @param _custom_ 用户缓存
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxEntry _custom_ );
		
		/**
		 * 根据用户组全量覆盖当前内存事务类中用户资料组
		 * @param _custom_id_ 用户编码
		 * @param _directory_ 用户缓存
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxDirectory _directory_ );
		
		/**
		 * 获取当前数据库事务类到期用户列表
		 * @return
		 */
		public IUpdfmxDirectory getIUpfxExpire();

		/**
		 * 根据用户编码获取当前内存事务类中到期用户缓存
		 * @param _custom_id_ 用户编码
		 * @return
		 */
		public IUpdfmxExpire getIUpfxExpire( String _custom_id_ );
		
		/**
		 * 根据用户编码覆盖当前内存事务类中到期用户缓存
		 * @param _custom_id 用户编码
		 * @param _expire_ 到期用户
		 */
		public void submitIUpfxExpire( String _custom_id, IUpdfmxExpire _expire_ );
		
		/**
		 * 取得当前内存级事务中网元调度变量集
		 * @return
		 */
		public java.util.Map getComposite();
		
		/**
		 * 根据服务任务类查询当前服务全部任务
		 * @param fromTYPE 服务任务类
		 * @return
		 */
		public Object[] getIUpdbpmLifite(Class fromTYPE);
		
		/**
		 * 把当前服务任务单提交当前内存级事务中服务全部缓存
		 * @param fromTASK 服务任务单
		 */
		public void submitIUpdbpmLifite(Object fromTASK);
		
		/**
		 * 根据服务任务类查询当前服务变化任务缓存
		 * @param fromTYPE 服务任务类
		 * @return
		 */
		public Object[] getIUpdfmxLifite(Class fromTYPE);
		
		/**
		 * 把当前服务任务单提交当前内存级事务中服务变化缓存
		 * @param fromTASK 服务任务单
		 */
		public void submitIUpdfmxLifite(Object fromTASK);
		
		/**
		 * 查询网元表模式工单列表
		 * @return
		 */
		public IOVUpdfmxDestiny getBottle();

		/**
		 * 查询当前事务异步表索引缓存区
		 * @return
		 */
		public java.util.Map getIndexs();

		/**
		 * 根据当前索引对象查询所有事务异步表索引
		 * @param fromCREATE 索引对象
		 * @return
		 */
		public java.util.Map getIndexs(Object fromCREATE);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则不备份失败表及历史表]
		 * @param fromUpfwm 异步工单
		 */
		public void submitISQLLite(Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则备份历史表]
		 * @param fromUpfwm 异步表工单
		 */
		public void submitISQLHistory(Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则备份失败表]
		 * @param fromUpfwm 异步表工单
		 */
		public void submitISQLLifite(Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则不备份失败表及历史表]
		 * @param fromComposite 数据仓库类
		 * @param fromUpfwm 网元工单
		 */
		public void submitISQLLite(Class fromComposite, Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则备份历史表]
		 * @param fromComposite 数据仓库类
		 * @param fromUpfwm 异步表工单
		 */
		public void submitISQLHistory(Class fromComposite, Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则备份失败表]
		 * @param fromComposite 数据仓库类
		 * @param fromUpfwm 异步表工单
		 */
		public void submitISQLLifite(Class fromComposite, Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则不备份失败及历史表]
		 * @param fromCREATE 索引对象
		 * @param fromUpfwm 网元工单
		 */
		public void submitISQLLite(Object fromCREATE, Object fromUpfwm);

		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则备份历史表]
		 * @param fromCREATE 索引对象
		 * @param fromUpfwm 网元工单
		 */
		public void submitISQLHistory(Object fromCREATE, Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则备份失败表]
		 * @param fromCREATE 索引对象
		 * @param fromUpfwm 网元工单
		 */
		public void submitISQLLifite(Object fromCREATE, Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则不备份失败表及历史表]
		 * @param fromCREATE 索引对象
		 * @param fromComposite 数据仓库类
		 * @param fromUpfwm 网元工单
		 */
		public void submitISQLLite(Object fromCREATE, Class fromComposite, Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则备份历史表]
		 * @param fromCREATE 索引对象
		 * @param fromComposite 数据仓库类
		 * @param fromUpfwm 网元工单
		 */
		public void submitISQLHistory(Object fromCREATE, Class fromComposite, Object fromUpfwm);
		
		/**
		 * 把当前异步表工单提交到当前内存级事务中[异步表为删除则备份失败表]
		 * @param fromCREATE 索引对象
		 * @param fromComposite 数据仓库类
		 * @param fromUpfwm 网元工单
		 */
		public void submitISQLLifite(Object fromCREATE, Class fromComposite, Object fromUpfwm);
		
		/**
		 * 根据创建索引对象回滚当前异步表缓存
		 * @param fromCREATE 索引对象
		 */
		public void rollbackISQLLite(Object fromCREATE);
		
		/**
		 * 提交当前内存级事务到父级中并且恢复父级内存级事务
		 * 
		 */
		public void commitTransaction();

		/**
		 * 回滚当前内存级事务并且恢复父级内存级事务
		 * 
		 */
		public void rollbackTransaction();
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-10-17</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class UpfsvcOracleImpl extends UpfsvcVantage.UserTransaction implements IUpfsvcOracle,java.io.Serializable{
		private static final long serialVersionUID = -2352722551726169962L;
		/*内存级事务*/
    	private UpfsvcVantage.SybaseTransaction _transparent = new UpfsvcVantage.SybaseTransaction();
    	/*数据库级事务*/
    	private UpfsvcVantage.OracleTransaction _transaction = new UpfsvcVantage.OracleTransaction();
    	/*局部事务堆栈*/
    	private ArrayDeque        _primitive = new ArrayDeque();
    	/*服务订购缓存*/
		private java.util.Map     _subscribe   = new java.util.HashMap();
		public UpfsvcOracleImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#beginTransaction()
		 */
		public void beginTransaction() {
			try
			{
				UpfsvcVantage.SybaseTransaction transparent = _transparent;
				UpfsvcVantage.SybaseTransaction __transparent = new UpfsvcVantage.SybaseTransaction();
				if( _primitive.size() > 0 ){ transparent = ((UpfsvcVantage.SybaseTransaction)_primitive.peek()); }
				__transparent.beginAsTransaction( transparent );
				if( log.isDebugEnabled() ) log.debug( "ucmframe begin transaction [thread name:" + SystemUtils.getCLUSTER() +" rocket [" + this + "]["+ __transparent +"]");
				_primitive.push( __transparent );
			}
			finally{
				
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getTransaction()
		 */
		public UpfsvcVantage.SybaseTransaction getTransaction() {
			UpfsvcVantage.SybaseTransaction transaction = null;
			try
			{
				transaction = _transparent;
				if( _primitive.size() > 0 ){ transaction = (UpfsvcVantage.SybaseTransaction)_primitive.peek(); }
				if( transaction == null ){
					ExceptionFactory.throwRuntime("IOS0010000", new String[]{ SystemUtils.getCLUSTER()} );
				}
			}
			finally{
				
			}
			return transaction;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getIUpfxUnique(java.lang.String)
		 */
		public IOVUpdfmxUnique getIUpfxUnique(String _component_) throws SFException, Exception {
			IOVUpdfmxUnique __unique__ = null;
			try
			{
				IPlatformTemplate.IUpffmOffer __platform__ = null;
				__platform__ = CenterUtils.ICustom.getSFCenterNetWork( _component_ );
				StringBuffer __component__ = new StringBuffer( IUpdcConst.IUpdcp.IUpdbm.PROGRAM_UNIQUE );
				__component__.append( "_$_" ).append( __platform__.getID() );
				__unique__ = (IOVUpdfmxUnique)_motion.get( __component__.toString() );
				if( __unique__ == null ){
					__unique__ = new IOVUpdfmxUnique( _component_, __platform__ );
					_motion.put( __component__.toString(), __unique__  );
				}
			}
			finally{
				
			}
			return __unique__;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getIUpfxCustom()
		 */
		public UpfsvcVantage.IUpdfmxCustom getIUpfxCustom() {
			UpfsvcVantage.IUpdfmxCustom _custom_factory = null;
			try
			{
				UpfsvcVantage.SybaseTransaction __transaction__ = getTransaction();
				_custom_factory = __transaction__.getCustom();
			}
			finally{
				
			}
			return _custom_factory;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getIUpfxCustom(java.lang.String)
		 */
		public IUpdfmxDirectory getIUpfxCustom(String _custom_id_) {
			IUpdfmxDirectory _custom_factory = null;
			try
			{
				UpfsvcVantage.IUpdfmxCustom __custom_factory[] = null;
				UpfsvcVantage.SybaseTransaction transaction = getTransaction();
				if( ( _custom_factory = (IUpdfmxDirectory)transaction.getCustom().getIUpfxCustom( _custom_id_ ) ) == null ){
					for( java.util.Iterator itera = _primitive.descendingIterator(); itera.hasNext(); ){
						UpfsvcVantage.SybaseTransaction __transaction = (UpfsvcVantage.SybaseTransaction)itera.next();
						_custom_factory = (IUpdfmxDirectory)__transaction.getCustom().getIUpfxCustom( _custom_id_ );
						if( _custom_factory != null ){ break; }
					}
					if( _custom_factory == null ){
						UpfsvcMBeanImpl __mbean_factory = (UpfsvcMBeanImpl)_mbean_factory.get();
						__custom_factory = new UpfsvcVantage.IUpdfmxCustom[]{ _transparent.getCustom(), __mbean_factory._rocket._custom };
						for( int index = 0; __custom_factory != null && index < __custom_factory.length; index++ ){
							if( __custom_factory[index] == null ){ continue; }
							_custom_factory = __custom_factory[index].getIUpfxCustom( _custom_id_ );
							if( _custom_factory != null ){ break; }
						}
					}
					if( _custom_factory != null ){ _custom_factory = (IUpdfmxDirectory)ClassUtils.IClass.atomDesign( _custom_factory ); }
				}
			}
			finally{
				
			}
			return _custom_factory;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitIUpfxCustom(java.lang.String, com.ai.sacenter.common.IUpdfmxEntry)
		 */
		public void submitIUpfxCustom(String _custom_id_, IUpdfmxEntry _custom_) {
			try
			{
				UpfsvcVantage.SybaseTransaction transaction = getTransaction();
				transaction.getCustom().submitIUpfxCustom( _custom_id_, _custom_ );
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitIUpfxCustom(java.lang.String, com.ai.sacenter.common.IUpdfmxDirectory)
		 */
		public void submitIUpfxCustom(String _custom_id_, IUpdfmxDirectory _directory_) {
			try
			{
				UpfsvcVantage.SybaseTransaction transaction = getTransaction();
				transaction.getCustom().submitIUpfxCustom( _custom_id_, _directory_ );
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getIUpfxExpire()
		 */
		public IUpdfmxDirectory getIUpfxExpire() {
			IUpdfmxDirectory _expire_factory = null;
			try
			{
				UpfsvcVantage.IUpdfmxCustom _custom_factory = _transparent.getCustom();
				if( _custom_factory != null && _custom_factory.getExpire().size() > 0 ){
					_expire_factory = new IUpdfmxDirectory( _id.toString() );
					for( java.util.Iterator<IUpdfmxExpire> itera = _custom_factory.getExpire().values().iterator(); itera.hasNext(); ){
						IUpdfmxExpire _expire_ = (IUpdfmxExpire)itera.next();
						if( _expire_factory.getBottle() == null ){ _expire_factory.setBottle( _expire_ ); }
						ClassUtils.IMerge.merge( new Object[]{ _expire_ }, _expire_factory.getDirectory() );
					}
				}
			}
			finally{
				
			}
			return _expire_factory;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getIUpfxExpire(java.lang.String)
		 */
		public IUpdfmxExpire getIUpfxExpire(String _custom_id_) {
			IUpdfmxExpire _expire_factory = null;
			try
			{
				UpfsvcVantage.SybaseTransaction transaction = getTransaction();
				if( ( _expire_factory = (IUpdfmxExpire)transaction.getCustom().getIUpfxExpire( _custom_id_ ) ) == null ){
					for( java.util.Iterator itera = _primitive.descendingIterator(); itera.hasNext(); ){
						UpfsvcVantage.SybaseTransaction __transaction = (UpfsvcVantage.SybaseTransaction)itera.next();
						_expire_factory = (IUpdfmxExpire)__transaction.getCustom().getIUpfxExpire( _custom_id_ );
						if( _expire_factory != null ){ break; }
					}
					if( _expire_factory == null ){ _expire_factory = _transparent.getCustom().getIUpfxExpire( _custom_id_ ); }
					if( _expire_factory != null ){ _expire_factory = (IUpdfmxExpire)ClassUtils.IClass.atomDesign( _expire_factory ); }
				}
			}
			finally{
				
			}
			return _expire_factory;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitIUpfxExpire(java.lang.String, com.ai.sacenter.common.IUpdfmxExpire)
		 */
		public void submitIUpfxExpire(String _custom_id, IUpdfmxExpire _expire_) {
			try
			{
				UpfsvcVantage.SybaseTransaction transaction = getTransaction();
				transaction.getCustom().submitIUpfxExpire( _custom_id, _expire_ );
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getComposite()
		 */
		public java.util.Map getComposite() {
			java.util.Map composite = null;
			try
			{
				UpfsvcVantage.SybaseTransaction transaction = getTransaction();
				composite = transaction.getComposite();
			}
			finally{
				
			}
			return composite;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getIUpdbpmLifite(java.lang.Class)
		 */
		public Object[] getIUpdbpmLifite(Class fromTYPE) {
			java.util.List _objective = new ArrayUQCList();
			try
			{
				ClassUtils.IMerge.merge( _transparent.getTransversion(), _objective );
				for( java.util.Iterator itera = _primitive.iterator() ; itera.hasNext() ; ){
					UpfsvcVantage.SybaseTransaction aTransaction = (UpfsvcVantage.SybaseTransaction)itera.next();
					ClassUtils.IMerge.merge( aTransaction.getTransversion(), _objective );
				}
			}
			catch( java.lang.Exception tt){
				throw new java.lang.RuntimeException( tt );
			}
			finally{
				
			}
			return ClassUtils.IClass.arrayDesign( _objective, fromTYPE );
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitIUpdbpmLifite(java.lang.Object)
		 */
		public void submitIUpdbpmLifite(Object fromTASK) {
			java.util.Collection aCollection = null;
			try
			{
				UpfsvcVantage.SybaseTransaction transaction = getTransaction();
				aCollection = ClassUtils.IClass.getAsArray( fromTASK );
				for( java.util.Iterator itera = aCollection.iterator(); itera.hasNext(); ){
					Object _compatible = ClassUtils.IClass.atomDesign( itera.next() );
					if( _compatible == null ){ continue; }
					int fromINDEX = transaction.getTransversion().indexOf( _compatible );
					if( fromINDEX >= 0 ){ transaction.getTransversion().set( fromINDEX, _compatible ); }
					else{ transaction.getTransversion().add( _compatible ); }
				}
			}
			finally{
				if( aCollection != null ){ aCollection.clear(); aCollection = null; }
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getIUpdfmxLifite(java.lang.Class)
		 */
		public Object[] getIUpdfmxLifite(Class fromTYPE) {
			java.util.List _objective = new ArrayUQCList();
			try
			{
				ClassUtils.IMerge.merge( _transparent.getProduction(), _objective );
				for( java.util.Iterator itera = _primitive.iterator() ; itera.hasNext() ; ){
					UpfsvcVantage.SybaseTransaction aTransaction = (UpfsvcVantage.SybaseTransaction)itera.next();
					ClassUtils.IMerge.merge( aTransaction.getProduction(), _objective );
				}
			}
			finally{
				
			}
			return ClassUtils.IClass.arrayDesign( _objective, fromTYPE );
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitIUpdfmxLifite(java.lang.Object)
		 */
		public void submitIUpdfmxLifite(Object fromTASK) {
			java.util.Collection aCollection = null;
			try
			{
				UpfsvcVantage.SybaseTransaction transaction = getTransaction();
				aCollection = ClassUtils.IClass.getAsArray( fromTASK );
				for( java.util.Iterator itera = aCollection.iterator(); itera.hasNext(); ){
					Object _compatible = ClassUtils.IClass.atomDesign( itera.next() );
					if( _compatible == null ){ continue; }
					int fromINDEX = transaction.getProduction().indexOf( _compatible );
					if( fromINDEX >= 0 ){ transaction.getProduction().set( fromINDEX, _compatible ); }
					else{ transaction.getProduction().add( _compatible ); }
				}
			}
			finally{
				if( aCollection != null ){ aCollection.clear(); aCollection = null; }
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getBottle()
		 */
		public IOVUpdfmxDestiny getBottle() {
			return _transparent.getAsynchronous().getBottle();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getIndexs()
		 */
		public java.util.Map getIndexs() {
			java.util.Map fromINDEX = null;
			try
			{
				fromINDEX = _transparent.getAsynchronous().getIndexs();
				if( _primitive.size() > 0 ){
					UpfsvcVantage.SybaseTransaction aTransaction = (UpfsvcVantage.SybaseTransaction)_primitive.peek();
					fromINDEX = aTransaction.getAsynchronous().getIndexs();
				}
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#getIndexs(java.lang.Object)
		 */
		public java.util.Map getIndexs(Object fromCREATE) {
			java.util.Map fromINDEX = new java.util.HashMap();
			try
			{
				for( java.util.Iterator itera = _primitive.descendingIterator(); itera.hasNext(); ){
					UpfsvcVantage.SybaseTransaction transaction = (UpfsvcVantage.SybaseTransaction)itera.next();
					java.util.Map fromUpfwm = transaction.getAsynchronous().getIndexs( fromCREATE );
					if( fromUpfwm != null ) ClassUtils.IMerge.atomIn( fromUpfwm, fromINDEX );
				}
				java.util.Map fromUpfwm = _transparent.getAsynchronous().getIndexs( fromCREATE );
				if( fromUpfwm != null ) ClassUtils.IMerge.atomIn( fromUpfwm, fromINDEX );
			}
			finally{
				
			}
			return fromINDEX;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLLite(java.lang.Object)
		 */
		public void submitISQLLite(Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.CREATE );
				submitHQSQLite( null, IUpdcConst.IUpdbm.IUpdcDAO, fromUpfwm, fromUpdfmx );
			} 
			finally {
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLHistory(java.lang.Object)
		 */
		public void submitISQLHistory(Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.HISTORY );
				submitHQSQLite( null, IUpdcConst.IUpdbm.IUpdcDAO, fromUpfwm, fromUpdfmx );
			} 
			finally {
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLLifite(java.lang.Object)
		 */
		public void submitISQLLifite(Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.FAILURE );
				submitHQSQLite( null, IUpdcConst.IUpdbm.IUpdcDAO, fromUpfwm, fromUpdfmx );
			} 
			finally {
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLLite(java.lang.Class, java.lang.Object)
		 */
		public void submitISQLLite(Class fromComposite, Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.CREATE );
				submitHQSQLite( null, fromComposite, fromUpfwm, fromUpdfmx );
			} 
			finally {
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLHistory(java.lang.Class, java.lang.Object)
		 */
		public void submitISQLHistory(Class fromComposite, Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.HISTORY );
				submitHQSQLite( null, fromComposite, fromUpfwm, fromUpdfmx );
			} 
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLLifite(java.lang.Class, java.lang.Object)
		 */
		public void submitISQLLifite(Class fromComposite, Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.FAILURE );
				submitHQSQLite( null, fromComposite, fromUpfwm, fromUpdfmx );
			} 
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLLite(java.lang.Object, java.lang.Object)
		 */
		public void submitISQLLite(Object fromCREATE, Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.CREATE );
				submitHQSQLite( fromCREATE, IUpdcConst.IUpdbm.IUpdcDAO, fromUpfwm, fromUpdfmx );
			} 
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLHistory(java.lang.Object, java.lang.Object)
		 */
		public void submitISQLHistory(Object fromCREATE, Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.HISTORY );
				submitHQSQLite( fromCREATE, IUpdcConst.IUpdbm.IUpdcDAO, fromUpfwm, fromUpdfmx );
			} 
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLLifite(java.lang.Object, java.lang.Object)
		 */
		public void submitISQLLifite(Object fromCREATE, Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.FAILURE );
				submitHQSQLite( fromCREATE, IUpdcConst.IUpdbm.IUpdcDAO, fromUpfwm, fromUpdfmx );
			} 
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLLite(java.lang.Object, java.lang.Class, java.lang.Object)
		 */
		public void submitISQLLite(Object fromCREATE, Class fromComposite, Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.CREATE );
				submitHQSQLite( fromCREATE, fromComposite, fromUpfwm, fromUpdfmx );
			} 
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLHistory(java.lang.Object, java.lang.Class, java.lang.Object)
		 */
		public void submitISQLHistory(Object fromCREATE, Class fromComposite, Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.HISTORY );
				submitHQSQLite( fromCREATE, fromComposite, fromUpfwm, fromUpdfmx );
			} 
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#submitISQLLifite(java.lang.Object, java.lang.Class, java.lang.Object)
		 */
		public void submitISQLLifite(Object fromCREATE, Class fromComposite, Object fromUpfwm) {
			IOVUpdfmxOffer fromUpdfmx = null;
			try 
			{
				fromUpdfmx = new IOVUpdfmxOffer(this, IOVUpdfmxOffer.History.FAILURE );
				submitHQSQLite( fromCREATE, fromComposite, fromUpfwm, fromUpdfmx );
			} 
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx = null; }
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#rollbackISQLLite(java.lang.Object)
		 */
		public void rollbackISQLLite(Object fromCREATE) {
			try
			{
				for( java.util.Iterator itera = _primitive.descendingIterator(); itera.hasNext(); ){
					UpfsvcVantage.SybaseTransaction transaction = (UpfsvcVantage.SybaseTransaction)itera.next();
					transaction.getAsynchronous().rollback(fromCREATE);
				}
				_transparent.getAsynchronous().rollback( fromCREATE );
			}
			finally{
			
			}
		}
		
		/**
		 * 根据当前数据记录提交到当前会话层事务持久化中
		 * @param fromCREATE 异步单索引
		 * @param fromComposite 数据仓库
		 * @param fromUpfwm 异步表工单
		 * @param fromUpdfmx 数据存储区
		 */
		private void submitHQSQLite(Object fromCREATE, Class fromComposite, Object fromUpfwm, IOVUpdfmxOffer fromUpdfmx){
			IOVUpdfmxOffer _objective = null;
			try 
			{
				UpfsvcVantage.SybaseTransaction transaction = getTransaction();
				_objective = OracleUtils.ISystem.transfer( fromUpfwm, fromUpdfmx );
				for( java.util.Iterator itera = _objective.getORDER().getORDER().iterator(); itera.hasNext(); ){
					Object fromEntity = itera.next();
					if( fromCREATE == null ){
						transaction.getAsynchronous().commit(fromComposite, fromEntity);
					}
					else{
						transaction.getAsynchronous().commit(fromCREATE, fromComposite, fromEntity);
					}
				}
			} 
			catch (java.lang.Exception aEXCEPTION) {
				ExceptionFactory.throwOracle("IOS0014000", new String[] { aEXCEPTION
						.getMessage() }, aEXCEPTION);
			} 
			finally {
				if( _objective != null ){ _objective = null; }
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#commitTransaction()
		 */
		public void commitTransaction() {
			try
			{
				UpfsvcVantage.SybaseTransaction transparent = _transparent;
				UpfsvcVantage.SybaseTransaction __transparent = (UpfsvcVantage.SybaseTransaction)_primitive.pop();
				if( _primitive.size() > 0 ){ transparent = ((UpfsvcVantage.SybaseTransaction)_primitive.peek()); }
				transparent.commitAsTransaction( __transparent );
				if( log.isDebugEnabled() ) log.debug( "ucmframe commit transaction [thread name:" + SystemUtils.getCLUSTER() +" rocket [" + this + "]["+ __transparent +"]");
	            __transparent.finishRocket();
	            __transparent = null;
			}
			finally{
				
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcOracle#rollbackTransaction()
		 */
		public void rollbackTransaction() {
			try
			{
				UpfsvcVantage.SybaseTransaction transparent = _transparent;
				UpfsvcVantage.SybaseTransaction __transparent = (UpfsvcVantage.SybaseTransaction)_primitive.pop();
				if( _primitive.size() > 0 ){ transparent = ((UpfsvcVantage.SybaseTransaction)_primitive.peek()); }
				transparent.rollbackAsTransaction( __transparent );
				if( log.isDebugEnabled() ) log.debug( "ucmframe rollback transaction [thread name:" + SystemUtils.getCLUSTER() +" rocket [" + this + "]["+ __transparent +"]");
				__transparent.finishRocket();
				__transparent = null;
			}
			finally{
				
			}
		}
		
		/**
		 * 释放当前线程事务缓存区
		 * 
		 */
		public void finishRocket() {
			try 
			{
				for (; _primitive.size() > 0;) {
					UpfsvcVantage.SybaseTransaction transaction = (UpfsvcVantage.SybaseTransaction)_primitive.pop();
					transaction.finishRocket();
					if( log.isErrorEnabled() ){
						log.error("ucmframe thread name:" + Thread.currentThread().getName() + " rocket[" + toString() + "] uncommitted transactions[" + transaction + "]");
					}
					transaction = null;
				}
				_transparent.finishRocket();
				_primitive.clear();
				_subscribe.clear();
			} 
			finally {

			}
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#finalize()
		 */
		protected void finalize() throws Throwable {
			_primitive = null;
			_transparent = null;
			_subscribe = null;
			super.finalize();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return _id.toString();
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 服务缓存基类</p>
	 * <p>Copyright: Copyright (c) 2018年3月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public interface IUpfsvcRocket{
		/**
		 * @return 服务缓存
		 */
		public java.util.Map getMotion();
		
		/**
		 * @return 用户资料缓存
		 */
		public UpfsvcVantage.IUpdfmxCustom getIUpfxCustom();
		
		/**
		 * 根据用户编码获取当前服务缓存类中用户资料缓存
		 * @param _custom_id_ 用户编码
		 * @return
		 */
		public IUpdfmxDirectory getIUpfxCustom( String _custom_id_ );
		
		/**
		 * 根据用户覆盖当前服务缓存类中用户资料组[如用户主资料不存在则当前服务缓存类中增加用户资料组,否则覆盖当前服务缓存类中当前用户子资料列表中]
		 * @param _custom_id_ 用户编码
		 * @param _custom_ 用户缓存
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxEntry _custom_ );
		
		/**
		 * 根据用户组全量覆盖当前服务缓存类中用户资料组
		 * @param _custom_id_ 用户编码
		 * @param _directory_ 用户缓存
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxDirectory _directory_ );
		
		/**
		 * 启动开通过程事务,如存在缓存事务则挂起线程级缓存事务
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction() throws SFException, Exception;
		
		/**
		 * 启动开通过程事务[正值表达式缓存],如存在缓存事务则挂起线程级缓存事务
		 * @param _objective 发起方
		 * @param _offer 开通属性
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction( Object _objective,
				java.util.Map _offer,
				IUpdcContext aContext ) throws SFException, Exception;
		
		/**
		 * 获取开通过程事务,如线程事务中不存在缓存事务则抛异常
		 * @return
		 */
		public UpfsvcVantage.IUpdfmxDeque getTransaction();
		
		/**
		 * 获取开通过程事务,如线程事务中不存在缓存事务则抛异常
		 * @return
		 */
		public UpfsvcVantage.IUpdfmxDeque getDeque();
		
		/**
		 * 获取开通过程事务,如线程事务中不存在缓存事务则返回NULL
		 * @return
		 */
		public UpfsvcVantage.IUpdfmxDeque getBlankDeque();
		
		/**
		 * 获取当前过程事务级服务缓存[继承性]
		 * @return
		 */
		public java.util.Map getIUpfxMotion();
		
		/**
		 * 根据发起方编码获取当前过程事务服务缓存[继承性]中发起方实体
		 * @param element 发起方编码
		 * @return
		 */
		public Object getIUpfxMotion( Object element );
		
		/**
		 * 提交服务缓存到当前过程事务中服务缓存[继承性]中
		 * @param element 发起方编码
		 * @param entry 发起方实体
		 */
		public void submitIUpfmxMotion( Object element, Object entry );
		
		/**
		 * 获取当前过程事务单元变化元素
		 * @return
		 */
		public java.util.List getIUpfxChange( );
		
		/**
		 * 按照制定类获取当前过程事务单元变化元素
		 * @param _class 制定类
		 * @return
		 */
		public Object[] getIUpfxChange( Class _class );
		
		/**
		 * 获取当前过程事务中全量实体
		 * @return
		 */
		public java.util.List getIUpfxEntry();
		
		/**
		 * 按照制定类获取当前过程事务全量实体
		 * @param _class 制定类
		 * @return
		 */
		public Object getIUpfxEntry( Class _class );
		
		/**
		 * 单元元素增加到当前过程事务映射元素集合中
		 * @param element 单元元素
		 * @param change 是否加入变化
		 */
		public void submitIUpfxEntry( Object element, boolean change );
		
		/**
		 * 获取当前过程事务中业务属性
		 * @return
		 */
		public java.util.Map getIUpfxDeque( );
		
		/**
		 * 提交业务属性到当前过程事务中业务属性集合中
		 * @param deque 业务属性
		 */
		public void submitIUpfxDeque( java.util.Map deque );
		
		/**
		 * 提交开通过程事务,如当前缓存事务中父级缓存事务则恢复父级缓存事务
		 * @throws SFException
		 * @throws Exception
		 */
		public void commitTransaction() throws SFException, Exception;
		
		/**
		 * 回滚开通过程事务,如当前缓存事务中父级缓存事务则恢复父级缓存事务
		 */
		public void rollbackTransaction() throws SFException,Exception;
		
		/**
		 * 释放当前内存缓存 
		 */
		public void finishRocket();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2018年3月20日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class UpfsvcRocketImpl extends UpfsvcVantage.UserTransaction implements IUpfsvcRocket,java.io.Serializable{
		private static final long serialVersionUID = -1731221183178498023L;
		/*过程事务堆栈*/
		private ArrayDeque _rocket = new ArrayDeque();
		/*用户资料缓存*/
		private UpfsvcVantage.IUpdfmxCustom  _custom = new UpfsvcVantage.IUpdfmxCustom();
		public UpfsvcRocketImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getIUpfxCustom()
		 */
		public UpfsvcVantage.IUpdfmxCustom getIUpfxCustom() {
			return _custom;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getIUpfxCustom(java.lang.String)
		 */
		public IUpdfmxDirectory getIUpfxCustom(String _custom_id_) {
			return (IUpdfmxDirectory)_custom.getIUpfxCustom( _custom_id_ );
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#submitIUpfxCustom(java.lang.String, com.ai.sacenter.common.IUpdfmxEntry)
		 */
		public void submitIUpfxCustom(String _custom_id_, IUpdfmxEntry _custom_) {
			_custom.submitIUpfxCustom( _custom_id_, _custom_ );
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#submitIUpfxCustom(java.lang.String, com.ai.sacenter.common.IUpdfmxDirectory)
		 */
		public void submitIUpfxCustom(String _custom_id_, IUpdfmxDirectory _directory_) {
			_custom.submitIUpfxCustom( _custom_id_, _directory_ );
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#beginTransaction()
		 */
		public void beginTransaction() throws SFException, Exception {
			try
			{
				UpfsvcVantage.IUpdfmxDeque _parent = null;
				UpfsvcVantage.IUpdfmxDeque _deque = new UpfsvcVantage.IUpdfmxDeque();
				if( _rocket != null && _rocket.size() > 0 ){
					_parent = (UpfsvcVantage.IUpdfmxDeque)_rocket.peek();
				}
				_deque.beginAsDeque( _parent );
				if( log.isDebugEnabled() ){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] create deque [" + _deque + "]");
				}
				_rocket.push( _deque );
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#beginTransaction(java.lang.Object, java.util.Map, com.ai.sacenter.IUpdcContext)
		 */
		public void beginTransaction(Object _objective, java.util.Map _offer, IUpdcContext aContext) throws SFException, Exception {
			try
			{
				UpfsvcVantage.IUpdfmxDeque _parent = null;
				UpfsvcVantage.IUpdfmxDeque _deque = new UpfsvcVantage.IUpdfmxDeque();
				if( _rocket != null && _rocket.size() > 0 ){
					_parent = (UpfsvcVantage.IUpdfmxDeque)_rocket.peek();
				}
				_deque.beginAsDeque( _parent, _offer, aContext );
				if( log.isDebugEnabled() ){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] create deque [" + _deque + "]");
				}
				_rocket.push( _deque );
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getTransaction()
		 */
		public UpfsvcVantage.IUpdfmxDeque getTransaction() {
			UpfsvcVantage.IUpdfmxDeque  _deque = null;
			try
			{
				if( _rocket != null && _rocket.size() > 0 ){
					_deque = (UpfsvcVantage.IUpdfmxDeque)_rocket.peek();
				}
				if( _deque == null ) {
					ExceptionFactory.throwRuntime("IOS0010000", new String[] { SystemUtils.getCLUSTER() });
				}
			}
			finally{
				
			}
			return _deque;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getDeque()
		 */
		public UpfsvcVantage.IUpdfmxDeque getDeque() {
			UpfsvcVantage.IUpdfmxDeque  _deque = null;
			try
			{
				if( _rocket != null && _rocket.size() > 0 ){
					_deque = (UpfsvcVantage.IUpdfmxDeque)_rocket.peek();
				}
				if( _deque == null ) {
					ExceptionFactory.throwRuntime("IOS0010000", new String[] { SystemUtils.getCLUSTER() });
				}
			}
			finally{
				
			}
			return _deque;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getBlankDeque()
		 */
		public UpfsvcVantage.IUpdfmxDeque getBlankDeque() {
			UpfsvcVantage.IUpdfmxDeque  _deque = null;
			try
			{
				if( _rocket != null && _rocket.size() > 0 ){
					_deque = (UpfsvcVantage.IUpdfmxDeque)_rocket.peek();
				}
			}
			finally{
				
			}
			return _deque;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getIUpfxMotion()
		 */
		public java.util.Map getIUpfxMotion() {
			java.util.Map _subflow = null;
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				_subflow = _deque.getMotion();
			}
			finally{
				
			}
			return _subflow;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getIUpfxMotion(java.lang.Object)
		 */
		public Object getIUpfxMotion(Object element) {
			Object _entry = null;
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				_entry = _deque.getMotion().get( element );
			}
			finally{
				
			}
			return _entry;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#submitIUpfmxMotion(java.lang.Object, java.lang.Object)
		 */
		public void submitIUpfmxMotion(Object element, Object entry) {
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				_deque.getMotion().put( element, entry );
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getIUpfxChange()
		 */
		public java.util.List getIUpfxChange() {
			java.util.List _change = null;
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				_change = _deque.getChange();
			}
			finally{
				
			}
			return _change;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getIUpfxChange(java.lang.Class)
		 */
		public Object[] getIUpfxChange(Class _class) {
			Object _array[] = null;
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				_array = ClassUtils.IClass.arrayDesign( _deque.getChange(), _class );
			}
			finally{
				
			}
			return _array;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getIUpfxEntry()
		 */
		public java.util.List getIUpfxEntry() {
			java.util.List _entry = null;
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				_entry = _deque.getEntity();
			}
			finally{
				
			}
			return _entry;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getIUpfxEntry(java.lang.Class)
		 */
		public Object getIUpfxEntry(Class _class) {
			Object _array[] = null;
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				_array = ClassUtils.IClass.arrayDesign( _deque.getEntity(), _class );
			}
			finally{
				
			}
			return _array;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#submitIUpfxEntry(java.lang.Object, boolean)
		 */
		public void submitIUpfxEntry(Object element, boolean change) {
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				_deque.getEntity().add( element );
				if( change == true ){ _deque.getChange().add( element ); }
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#getIUpfxDeque()
		 */
		public java.util.Map getIUpfxDeque() {
			java.util.Map _subflow = null;
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				_subflow = _deque.getSubFlow();
			}
			finally{
				
			}
			return _subflow;
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#submitIUpfxDeque(java.util.Map)
		 */
		public void submitIUpfxDeque(java.util.Map deque) {
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = getTransaction();
				ClassUtils.IMerge.merge( deque, _deque.getSubFlow(), true );
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#commitTransaction()
		 */
		public void commitTransaction() throws SFException, Exception {
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = null;
				_deque = (UpfsvcVantage.IUpdfmxDeque)_rocket.peek();
				_deque.commitAsDeque();
				_rocket.pop();
				if( log.isDebugEnabled() ){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] commit deque [" + _deque + "]");
				}
				_deque.finishDeque();
				_deque = null;
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#rollbackTransaction()
		 */
		public void rollbackTransaction() throws SFException, Exception {
			try
			{
				UpfsvcVantage.IUpdfmxDeque _deque = null;
				_deque = (UpfsvcVantage.IUpdfmxDeque)_rocket.pop();
				_deque.rollbackAsDeque();
				_deque.finishDeque();
				if( log.isDebugEnabled() ){
					log.debug("ucmframe thread name:" + SystemUtils.getCLUSTER() + " mbean [" + this + "] rollback deque [" + _deque + "]");
				}
				_deque = null;
			}
			finally{
				
			}
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.common.UpfsvcManager.IUpfsvcRocket#finishRocket()
		 */
		public void finishRocket() {
			try
			{
				for( ; _rocket.size() > 0; ) {
					UpfsvcVantage.IUpdfmxDeque _deque = (UpfsvcVantage.IUpdfmxDeque)_rocket.pop();
					_deque.finishDeque();
					if( log.isErrorEnabled() ){
						log.error("ucmframe thread name:" + Thread.currentThread().getName() + " rocket[" + toString() + "] uncommitted deque[" + _deque + "]");
					}
					_deque = null;
				}
				if( _custom != null ){ _custom.finishCustom(); _custom = null; }
			}
			finally{
				
			}
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return _id.toString();
		}
	}
	
}
