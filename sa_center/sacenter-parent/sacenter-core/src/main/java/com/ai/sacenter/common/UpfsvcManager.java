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
	 * ��ȡȫ������[���ݿ⼶������ڴ漶����]
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
	 * ��ȡȫ������[���ݿ⼶������ڴ漶����](���߳����ޣ��򷵻ؿ�)
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
	 * ��ȡ��ǰ���ݿ⼶����,��ȫ�������в��������ݿ⼶���������쳣
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
	 * ��ȡ��ǰ���ݿ⼶����,��ȫ�������в��������ݿ⼶�����򷵻�NULL
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
	 * �����������[�û����ϻ���ͷ����������]
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
	 * �粻���������ύ���ͷŵ�ǰȫ������
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
	 * ǿ���ͷŵ�ǰ�߳�������ȫ������[���ݿ⼶������ڴ漶����]
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
	 * <p>Description: ȫ��������</p>
	 * <p>Copyright: Copyright (c) 2015-1-8</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public interface IUpfsvcMBean{
		/**
		 * 
		 * @return ��ȡȫ�����Ի���
		 */
		public java.util.Map getGraphics();

		/**
		 * 
		 * @return ��ȡ��ǰ�߳��̵߳����嵥
		 */
		public java.util.Map getSingleton();

		/**
		 * 
		 * @return ��ȡ������ʽ����
		 */
		public JevalSTKEngine getJEVAL();

		/**
		 * @return ȫ��Ӧ������
		 */
		public MBeanRsRspHome getRespond();

		/**
		 * 
		 * @return ��ʱ���Լ���
		 */
		public java.util.Map getDelegation();

		/**
		 * 
		 * @return ����������
		 */
		public MBeanDelegate getQuality();

		/**
		 * 
		 * @param fromMBean ����������
		 */
		public void setQuality(MBeanDelegate fromMBean);
		
		/**
		 * ������̻���
		 * @return
		 */
		public IUpfsvcRocket getRocket();

		/**
		 * �����»Ự����[���ڴ漶����������ݿ⼶����][����ڻỰ���������ǰ�Ự����]
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction() throws SFException,Exception;

		/**
		 * �����»Ự����[���ڴ漶����ͼ̳����ݿ⼶����][������ڴ漶���������ǰ�ڴ漶����]
		 * @throws SFException
		 * @throws Exception
		 */
		public void carryTransaction() throws SFException,Exception;
		
		/**
		 * ��ȡ��ǰ�Ự����[�粻���ڻỰ���������쳣]
		 * @return
		 */
		public IUpfsvcOracle getTransaction();

		/**
		 * �Ƿ����δ�ύ�Ự����[�ڴ漶�������ݿ⼶����͹��̼�����]
		 * @return ΪNULL�򲻴���δ�ύ�Ự����
		 */
		public UpfsvcVantage.UserTransaction[] getUnCommitted();
		
		/**
		 * �ύ��ǰ�Ự����[����ڸ����Ự������ָ������Ự��]
		 * @throws SFException
		 * @throws Exception
		 */
		public void commitTransaction() throws SFException,Exception;

		/**
		 * �ع���ǰ�Ự����[����ڸ����Ự������ָ������Ự��]
		 * @throws SFException
		 * @throws Exception
		 */
		public void rollbackTransaction() throws SFException,Exception;

		/**
		 * �ͷŵ�ǰ����������
		 * 
		 */
		public void finishMBean();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: ȫ�ָ���������[���̱߳�������]</p>
	 * <p>Copyright: Copyright (c) 2015-1-9</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class UpfsvcMBeanImpl implements IUpfsvcMBean,java.io.Serializable{
		private static final long serialVersionUID = -8174912867494762926L;
		/*ȫ�ָ������������*/
		private UUID _id = null;
		/*ȫ�����Ի���(�ֹ����,��Ự����)*/
		private java.util.Map     _graphics = new java.util.HashMap();
		/*�̵߳����嵥*/
		private java.util.Map     _singleton = new java.util.HashMap();
		/*��ֵ���ʽ������*/
		private JevalSTKEngine    _jeval   = new JevalSTKEngine();
		/*ȫ�ַ�����Ϣ*/
		private MBeanRsRspHome    _respond   = new MBeanRsRspHome();
		/*��ʱ�̼߳���*/
    	private java.util.Map     _delegation = new java.util.HashMap();
    	/*��������������*/
    	private MBeanDelegate     _quality   = null;
    	/*������̻���*/
    	private UpfsvcRocketImpl  _rocket    = new UpfsvcRocketImpl();
    	/*�Ự�����������*/
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
	 * <p>Description: �ڴ�������</p>
	 * <p>Copyright: Copyright (c) 2015-1-9</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public interface IUpfsvcOracle{
		/**
		 * @return ���񼶻���
		 */
		public java.util.Map getMotion();
		
		/**
		 * �������ڴ漶�����ҹ��𸸼��ڴ漶����
		 * @return
		 */
		public void beginTransaction();

		/**
		 * ��ȡ��ǰ�ڴ漶����
		 * @return
		 */
		public UpfsvcVantage.SybaseTransaction getTransaction();
		
		/**
		 * ����������ȡ��ǰ������Ԫ������
		 * @param _component_ �����
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVUpdfmxUnique getIUpfxUnique( String _component_ ) throws SFException,Exception;
		
		/**
		 * ��ȡ��ǰ�ڴ����������û����ϻ���
		 * @return
		 */
		public UpfsvcVantage.IUpdfmxCustom getIUpfxCustom();
		
		/**
		 * �����û������ȡ��ǰ�ڴ����������û����ϻ���
		 * @param _custom_id_ �û�����
		 * @return
		 */
		public IUpdfmxDirectory getIUpfxCustom( String _custom_id_ );
		
		/**
		 * �����û����ǵ�ǰ�ڴ����������û�������[���û������ϲ�������ǰ�ڴ��������������û�������,���򸲸ǵ�ǰ�ڴ��������е�ǰ�û��������б���]
		 * @param _custom_id_ �û�����
		 * @param _custom_ �û�����
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxEntry _custom_ );
		
		/**
		 * �����û���ȫ�����ǵ�ǰ�ڴ����������û�������
		 * @param _custom_id_ �û�����
		 * @param _directory_ �û�����
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxDirectory _directory_ );
		
		/**
		 * ��ȡ��ǰ���ݿ������ൽ���û��б�
		 * @return
		 */
		public IUpdfmxDirectory getIUpfxExpire();

		/**
		 * �����û������ȡ��ǰ�ڴ��������е����û�����
		 * @param _custom_id_ �û�����
		 * @return
		 */
		public IUpdfmxExpire getIUpfxExpire( String _custom_id_ );
		
		/**
		 * �����û����븲�ǵ�ǰ�ڴ��������е����û�����
		 * @param _custom_id �û�����
		 * @param _expire_ �����û�
		 */
		public void submitIUpfxExpire( String _custom_id, IUpdfmxExpire _expire_ );
		
		/**
		 * ȡ�õ�ǰ�ڴ漶��������Ԫ���ȱ�����
		 * @return
		 */
		public java.util.Map getComposite();
		
		/**
		 * ���ݷ����������ѯ��ǰ����ȫ������
		 * @param fromTYPE ����������
		 * @return
		 */
		public Object[] getIUpdbpmLifite(Class fromTYPE);
		
		/**
		 * �ѵ�ǰ���������ύ��ǰ�ڴ漶�����з���ȫ������
		 * @param fromTASK ��������
		 */
		public void submitIUpdbpmLifite(Object fromTASK);
		
		/**
		 * ���ݷ����������ѯ��ǰ����仯���񻺴�
		 * @param fromTYPE ����������
		 * @return
		 */
		public Object[] getIUpdfmxLifite(Class fromTYPE);
		
		/**
		 * �ѵ�ǰ���������ύ��ǰ�ڴ漶�����з���仯����
		 * @param fromTASK ��������
		 */
		public void submitIUpdfmxLifite(Object fromTASK);
		
		/**
		 * ��ѯ��Ԫ��ģʽ�����б�
		 * @return
		 */
		public IOVUpdfmxDestiny getBottle();

		/**
		 * ��ѯ��ǰ�����첽������������
		 * @return
		 */
		public java.util.Map getIndexs();

		/**
		 * ���ݵ�ǰ���������ѯ���������첽������
		 * @param fromCREATE ��������
		 * @return
		 */
		public java.util.Map getIndexs(Object fromCREATE);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򲻱���ʧ�ܱ���ʷ��]
		 * @param fromUpfwm �첽����
		 */
		public void submitISQLLite(Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򱸷���ʷ��]
		 * @param fromUpfwm �첽����
		 */
		public void submitISQLHistory(Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򱸷�ʧ�ܱ�]
		 * @param fromUpfwm �첽����
		 */
		public void submitISQLLifite(Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򲻱���ʧ�ܱ���ʷ��]
		 * @param fromComposite ���ݲֿ���
		 * @param fromUpfwm ��Ԫ����
		 */
		public void submitISQLLite(Class fromComposite, Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򱸷���ʷ��]
		 * @param fromComposite ���ݲֿ���
		 * @param fromUpfwm �첽����
		 */
		public void submitISQLHistory(Class fromComposite, Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򱸷�ʧ�ܱ�]
		 * @param fromComposite ���ݲֿ���
		 * @param fromUpfwm �첽����
		 */
		public void submitISQLLifite(Class fromComposite, Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򲻱���ʧ�ܼ���ʷ��]
		 * @param fromCREATE ��������
		 * @param fromUpfwm ��Ԫ����
		 */
		public void submitISQLLite(Object fromCREATE, Object fromUpfwm);

		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򱸷���ʷ��]
		 * @param fromCREATE ��������
		 * @param fromUpfwm ��Ԫ����
		 */
		public void submitISQLHistory(Object fromCREATE, Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򱸷�ʧ�ܱ�]
		 * @param fromCREATE ��������
		 * @param fromUpfwm ��Ԫ����
		 */
		public void submitISQLLifite(Object fromCREATE, Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򲻱���ʧ�ܱ���ʷ��]
		 * @param fromCREATE ��������
		 * @param fromComposite ���ݲֿ���
		 * @param fromUpfwm ��Ԫ����
		 */
		public void submitISQLLite(Object fromCREATE, Class fromComposite, Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򱸷���ʷ��]
		 * @param fromCREATE ��������
		 * @param fromComposite ���ݲֿ���
		 * @param fromUpfwm ��Ԫ����
		 */
		public void submitISQLHistory(Object fromCREATE, Class fromComposite, Object fromUpfwm);
		
		/**
		 * �ѵ�ǰ�첽�����ύ����ǰ�ڴ漶������[�첽��Ϊɾ���򱸷�ʧ�ܱ�]
		 * @param fromCREATE ��������
		 * @param fromComposite ���ݲֿ���
		 * @param fromUpfwm ��Ԫ����
		 */
		public void submitISQLLifite(Object fromCREATE, Class fromComposite, Object fromUpfwm);
		
		/**
		 * ���ݴ�����������ع���ǰ�첽����
		 * @param fromCREATE ��������
		 */
		public void rollbackISQLLite(Object fromCREATE);
		
		/**
		 * �ύ��ǰ�ڴ漶���񵽸����в��һָ������ڴ漶����
		 * 
		 */
		public void commitTransaction();

		/**
		 * �ع���ǰ�ڴ漶�����һָ������ڴ漶����
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
		/*�ڴ漶����*/
    	private UpfsvcVantage.SybaseTransaction _transparent = new UpfsvcVantage.SybaseTransaction();
    	/*���ݿ⼶����*/
    	private UpfsvcVantage.OracleTransaction _transaction = new UpfsvcVantage.OracleTransaction();
    	/*�ֲ������ջ*/
    	private ArrayDeque        _primitive = new ArrayDeque();
    	/*���񶩹�����*/
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
		 * ���ݵ�ǰ���ݼ�¼�ύ����ǰ�Ự������־û���
		 * @param fromCREATE �첽������
		 * @param fromComposite ���ݲֿ�
		 * @param fromUpfwm �첽����
		 * @param fromUpdfmx ���ݴ洢��
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
		 * �ͷŵ�ǰ�߳����񻺴���
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
	 * <p>Description: ���񻺴����</p>
	 * <p>Copyright: Copyright (c) 2018��3��20��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public interface IUpfsvcRocket{
		/**
		 * @return ���񻺴�
		 */
		public java.util.Map getMotion();
		
		/**
		 * @return �û����ϻ���
		 */
		public UpfsvcVantage.IUpdfmxCustom getIUpfxCustom();
		
		/**
		 * �����û������ȡ��ǰ���񻺴������û����ϻ���
		 * @param _custom_id_ �û�����
		 * @return
		 */
		public IUpdfmxDirectory getIUpfxCustom( String _custom_id_ );
		
		/**
		 * �����û����ǵ�ǰ���񻺴������û�������[���û������ϲ�������ǰ���񻺴����������û�������,���򸲸ǵ�ǰ���񻺴����е�ǰ�û��������б���]
		 * @param _custom_id_ �û�����
		 * @param _custom_ �û�����
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxEntry _custom_ );
		
		/**
		 * �����û���ȫ�����ǵ�ǰ���񻺴������û�������
		 * @param _custom_id_ �û�����
		 * @param _directory_ �û�����
		 */
		public void submitIUpfxCustom( String _custom_id_, IUpdfmxDirectory _directory_ );
		
		/**
		 * ������ͨ��������,����ڻ�������������̼߳���������
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction() throws SFException, Exception;
		
		/**
		 * ������ͨ��������[��ֵ���ʽ����],����ڻ�������������̼߳���������
		 * @param _objective ����
		 * @param _offer ��ͨ����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction( Object _objective,
				java.util.Map _offer,
				IUpdcContext aContext ) throws SFException, Exception;
		
		/**
		 * ��ȡ��ͨ��������,���߳������в����ڻ������������쳣
		 * @return
		 */
		public UpfsvcVantage.IUpdfmxDeque getTransaction();
		
		/**
		 * ��ȡ��ͨ��������,���߳������в����ڻ������������쳣
		 * @return
		 */
		public UpfsvcVantage.IUpdfmxDeque getDeque();
		
		/**
		 * ��ȡ��ͨ��������,���߳������в����ڻ��������򷵻�NULL
		 * @return
		 */
		public UpfsvcVantage.IUpdfmxDeque getBlankDeque();
		
		/**
		 * ��ȡ��ǰ�������񼶷��񻺴�[�̳���]
		 * @return
		 */
		public java.util.Map getIUpfxMotion();
		
		/**
		 * ���ݷ��𷽱����ȡ��ǰ����������񻺴�[�̳���]�з���ʵ��
		 * @param element ���𷽱���
		 * @return
		 */
		public Object getIUpfxMotion( Object element );
		
		/**
		 * �ύ���񻺴浽��ǰ���������з��񻺴�[�̳���]��
		 * @param element ���𷽱���
		 * @param entry ����ʵ��
		 */
		public void submitIUpfmxMotion( Object element, Object entry );
		
		/**
		 * ��ȡ��ǰ��������Ԫ�仯Ԫ��
		 * @return
		 */
		public java.util.List getIUpfxChange( );
		
		/**
		 * �����ƶ����ȡ��ǰ��������Ԫ�仯Ԫ��
		 * @param _class �ƶ���
		 * @return
		 */
		public Object[] getIUpfxChange( Class _class );
		
		/**
		 * ��ȡ��ǰ����������ȫ��ʵ��
		 * @return
		 */
		public java.util.List getIUpfxEntry();
		
		/**
		 * �����ƶ����ȡ��ǰ��������ȫ��ʵ��
		 * @param _class �ƶ���
		 * @return
		 */
		public Object getIUpfxEntry( Class _class );
		
		/**
		 * ��ԪԪ�����ӵ���ǰ��������ӳ��Ԫ�ؼ�����
		 * @param element ��ԪԪ��
		 * @param change �Ƿ����仯
		 */
		public void submitIUpfxEntry( Object element, boolean change );
		
		/**
		 * ��ȡ��ǰ����������ҵ������
		 * @return
		 */
		public java.util.Map getIUpfxDeque( );
		
		/**
		 * �ύҵ�����Ե���ǰ����������ҵ�����Լ�����
		 * @param deque ҵ������
		 */
		public void submitIUpfxDeque( java.util.Map deque );
		
		/**
		 * �ύ��ͨ��������,�統ǰ���������и�������������ָ�������������
		 * @throws SFException
		 * @throws Exception
		 */
		public void commitTransaction() throws SFException, Exception;
		
		/**
		 * �ع���ͨ��������,�統ǰ���������и�������������ָ�������������
		 */
		public void rollbackTransaction() throws SFException,Exception;
		
		/**
		 * �ͷŵ�ǰ�ڴ滺�� 
		 */
		public void finishRocket();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2018��3��20��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class UpfsvcRocketImpl extends UpfsvcVantage.UserTransaction implements IUpfsvcRocket,java.io.Serializable{
		private static final long serialVersionUID = -1731221183178498023L;
		/*���������ջ*/
		private ArrayDeque _rocket = new ArrayDeque();
		/*�û����ϻ���*/
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
