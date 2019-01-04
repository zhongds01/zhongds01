package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOfferX;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.ArrayDeque;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.UUID;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ������(��ͨ��������Ϳ�ͨ���ڹ���)</p>
 * <p>Copyright: Copyright (c) 2016��3��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpffmxRequest implements java.io.Serializable{
	private static final long serialVersionUID = 4858009927711530520L;
	/*���𷽹���*/
	private Object _objective = null;
	/*��ͨ����*/
	private IOVUpffmxConsult   _platform = new IOVUpffmxConsult();
	/*��ͨ����*/
	private IUpffxOptimizeHome _optimize = new IUpffxOptimizeHome();
	/*��������*/
	private IUpffxCentrexHome _centrex   = new IUpffxCentrexHome();
	/*���ڹ���*/
	private IUpffxExpireHome  _expire    = new IUpffxExpireHome();
	public IOVUpffmxRequest(Object oBJECTIVE) {
		super();
		_objective = oBJECTIVE;
	}
	
	/**
	 * ���𷽹���
	 * @return 
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return ��ͨ����
	 */
	public IUpffxOptimizeHome getUSER() {
		return _optimize;
	}

	/**
	 * @return ��ͨ����
	 */
	public IOVUpffmxConsult getPLATFORM() {
		return _platform;
	}
	
	/**
	 * @param pLATFORM ��ͨ����
	 */
	public void setPLATFORM(IOVUpffmxConsult pLATFORM) {
		_platform = pLATFORM;
	}
	
	/**
	 * @return ��������
	 */
	public IUpffxCentrexHome getCENTREX() {
		return _centrex;
	}
	
	/**
	 * @return ���ڹ���
	 */
	public IUpffxExpireHome getEXPIRE() {
		return _expire;
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ��ͨ����</p>
	 * <p>Copyright: Copyright (c) 2018��4��11��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static interface IUpffxDequeHome{
		/**
		 * �ύ��ͨ����������������
		 * @param _user
		 */
		public void submitSFUpfxUser( IUpffmxUserHome _user ) throws SFException,Exception;
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ��ͨ��������</p>
	 * <p>Copyright: Copyright (c) 2018��4��11��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffxSubFlowHome implements IUpffxDequeHome{
		public IUpffxSubFlowHome(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.receive.valuebean.IOVUpffmxRequest.IUpffxDequeHome#submitSFUpfxUser(com.ai.sacenter.receive.valuebean.IOVUpffmxRequest.IUpffmxUserHome)
		 */
		public void submitSFUpfxUser(IUpffmxUserHome _user) throws SFException, Exception {
			
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ��Ա��������</p>
	 * <p>Copyright: Copyright (c) 2018��4��11��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpffxSubJectHome implements IUpffxDequeHome{
		public IUpffxSubJectHome(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.receive.valuebean.IOVUpffmxRequest.IUpffxDequeHome#submitSFUpfxUser(com.ai.sacenter.receive.valuebean.IOVUpffmxRequest.IUpffmxUserHome)
		 */
		public void submitSFUpfxUser(IUpffmxUserHome _user) throws SFException, Exception {
			try
			{
				_user.getPLATFORM().getORDER().add( _user.getUSER() );
			}
			finally{
				
			}
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ������������</p>
	 * <p>Copyright: Copyright (c) 2017��6��15��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffxCentrexHome implements IUpffxDequeHome{
		/*��������*/
		private CarbonList<IOVUpffmxConsult> _order = new CarbonList<IOVUpffmxConsult>();
		public IUpffxCentrexHome(){
			super();
		}
		
		/**
		 * @return ��������
		 */
		public CarbonList<IOVUpffmxConsult> getORDER() {
			return _order;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.receive.valuebean.IOVUpffmxRequest.IUpffxDequeHome#submitSFUpfxUser(com.ai.sacenter.receive.valuebean.IOVUpffmxRequest.IUpffmxUserHome)
		 */
		public void submitSFUpfxUser(IUpffmxUserHome _user) throws SFException, Exception {
			try
			{
				_order.add( new IOVUpffmxConsult( _user._platform, _user._competence ) );
			}
			finally{
				
			}
		}
		
	}

	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ���ڹ�������</p>
	 * <p>Copyright: Copyright (c) 2016��3��17��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffxExpireHome implements IUpffxDequeHome{
		/*�����û���*/
		private CarbonList<IOVUpffmxConsult>  _expire = new CarbonList<IOVUpffmxConsult>();
		/*���ڻ��浥*/
		private java.util.Map<String, Object> _custom = new java.util.HashMap<String, Object>();
		public IUpffxExpireHome(){
			super();
		}
		
		/**
		 * @return �����û���
		 */
		public CarbonList<IOVUpffmxConsult> getEXPIRE() {
			return _expire;
		}
		
		/**
		 * @return ���ڻ��浥
		 */
		public java.util.Map<String, Object> getCUSTOM() {
			return _custom;
		}

		/**
		 * �����û���Ż�ȡ�����û���־
		 * @param aUSER_ID �û����
		 * @return
		 */
		public IOVUpffmxConsult getSFUpffxUser( long aUSER_ID ){
			String fromINDEX = CustomUtils.ICatalog._expire_user_id( aUSER_ID );
			return (IOVUpffmxConsult)_custom.get( fromINDEX );
		}
		
		/**
		 * �ύ�����û���־
		 * @param request ��ͨ����
		 * @param competence ��ͨ����
		 * @throws Exception
		 */
		public void submitSFUpffxUser( IOVOrderRequest request, IUpfgkmOfferHome competence ) throws Exception{
			try
			{
				String fromINDEX = CustomUtils.ICatalog._expire_user_id( request.getUSER_ID() );
				if( _custom.get( fromINDEX ) == null ){
					_custom.put( fromINDEX, new IOVUpffmxConsult( request, competence ) );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * �ύ�����û���־
		 * @param request ��ͨ����
		 * @param competence ��ͨ����
		 * @param user ��ͨ�û�
		 * @throws Exception
		 */
		public void submitSFUpffxUser( IOVOrderRequest request, IOVOrderUser user, IUpfgkmOfferHome competence ) throws Exception{
			try
			{
				String fromINDEX = CustomUtils.ICatalog._expire_user_id( user.getUSER_ID() );
				if( _custom.get( fromINDEX ) == null ){
					IOVOrderRequest _request = new IOVOrderRequest( request, user );
					_custom.put( fromINDEX, new IOVUpffmxConsult( _request, competence ) );
				}
			}
			finally{
				
			}
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.receive.valuebean.IOVUpffmxRequest.IUpffxDequeHome#submitSFUpfxUser(com.ai.sacenter.receive.valuebean.IOVUpffmxRequest.IUpffmxUserHome)
		 */
		public void submitSFUpfxUser(IUpffmxUserHome _user) throws SFException, Exception {
			try
			{
				IOVOrderUser fromOrdUser = _user.getPLATFORM().getUSER();
				IOVUpffmxConsult _network = new IOVUpffmxConsult( _user._platform, _user._competence );
				if( isEXPIRE( fromOrdUser.getUSER_ID() ) == false /*��Ԫ�����ڹ�������Ϊ�����û�������*/){
					IOVOrderOfferX fromOfferX = UpdbfsUtils.ICustom.ICustomX._jj_expire( IUpdbfsConst.IState.E );
					fromOrdUser.getNATURE().put( fromOfferX.getCOMPETE(), fromOfferX );
				}
				_expire.add( _network  );
			}
			finally{
				
			}
		}
		
		/**
		 * ���û��Ƿ��Ѵ��ڵ��ڹ�����־
		 * @return
		 */
		public boolean isEXPIRE( long aUSER_ID ){
			boolean _expireUser = false;
			try
			{
				String fromINDEX = CustomUtils.ICatalog._expire_user_id( aUSER_ID );
				_expireUser = _custom.get( fromINDEX ) != null?true:false;
				if( _expireUser == false /*�����ڵ��ڹ�����־�����Ƿ���ڵ��ڹ���*/){
					java.util.List<IOVUpffmxConsult> expire = new java.util.ArrayList<IOVUpffmxConsult>();
					for( java.util.Iterator<IOVUpffmxConsult> itera = _expire.iterator(); itera.hasNext(); ){
						IOVUpffmxConsult _network = (IOVUpffmxConsult)itera.next();
						if( _network.getUSER_ID() == aUSER_ID ){ expire.add( _network ); }
					}
					_expireUser = expire != null && expire.size() > 0?true:false;
				}
			}
			finally{
				
			}
			return _expireUser;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017��3��7��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffxOptimizeHome implements java.io.Serializable{
		private static final long serialVersionUID = -4856970567368108087L;
		/*��ͨ�����û�����*/
    	private ArrayDeque _primitive  = new ArrayDeque();
    	/*��ͨ�û����񻺴�(�ֹ����)*/
		private java.util.Map<Object, Object> _custom = new java.util.HashMap<Object, Object>();
		public IUpffxOptimizeHome(){
			super();
		}
		
		/**
		 * ���ݿ�ͨ��������������ͨ���û�����
		 * @param _request ��ǰ��ͨ����
		 * @param _competence ��ͨ����
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction(IOVOrderRequest _request, IUpfgkmOfferHome _competence) throws SFException,Exception{
			try
			{
				IUpffmxUserHome fromUserHome = null;
				IUpffxDequeHome _orderhome = (IUpffxDequeHome)ClassUtils.getSingleton( IUpffxSubFlowHome.class.getName() );
				fromUserHome = new IUpffmxUserHome( _orderhome, _request, _request.getUSER(), _competence );
				UpdbfsUtils.ISystem._jj_dependent( _competence, fromUserHome.getDEPENDENT() );
				_primitive.push( fromUserHome );
			}
			finally{
				
			}
		}
		
		/**
		 * ���ݿ�ͨ��������ͳ�Ա�û�������ͨ��Ա�û�����
		 * @param _request ��ǰ��ͨ����
		 * @param _subject ��ͨ��Ա�û� 
		 * @param _competence ��ͨ����
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction(IOVOrderRequest _request, IOVOrderUser _subject,  IUpfgkmOfferHome _competence) throws SFException,Exception{
			try
			{
				IUpffmxUserHome fromUserHome = null;
				IUpffxDequeHome _orderhome = (IUpffxDequeHome)ClassUtils.getSingleton( IUpffxSubJectHome.class.getName() );
				fromUserHome = new IUpffmxUserHome( _orderhome, _request, _subject, _competence );
				UpdbfsUtils.ISystem._jj_dependent( _competence, fromUserHome.getDEPENDENT() );
				_primitive.push( fromUserHome );
			}
			finally{
				
			}
		}

		/**
		 * ���ݿ�ͨ��������������ͨ���ڹ�������
		 * @param _request ��ǰ��ͨ����
		 * @param _expire ���ڹ�����
		 * @param _competence ��ͨ����
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction(IOVOrderRequest _request, IUpffxExpireHome _expire, IUpfgkmOfferHome _competence) throws SFException,Exception{
			try
			{
				IUpffmxUserHome fromUserHome = null;
				fromUserHome = new IUpffmxUserHome( _expire, _request, _request.getUSER(), _competence );
				UpdbfsUtils.ISystem._jj_dependent( _competence, fromUserHome.getDEPENDENT() );
				_primitive.push( fromUserHome );
			}
			finally{
				
			}
		}
		
		/**
		 * ���ݿ�ͨ��������������ͨ������������
		 * @param _request ��ǰ��ͨ����
		 * @param _centrex ����������
		 * @param _competence ��ͨ����
		 * @throws SFException
		 * @throws Exception
		 */
		public void beginTransaction(IOVOrderRequest _request, IUpffxCentrexHome _centrex, IUpfgkmOfferHome _competence) throws SFException,Exception{
			try
			{
				IUpffmxUserHome fromUserHome = null;
				fromUserHome = new IUpffmxUserHome( _centrex, _request, _request.getUSER(), _competence );
				UpdbfsUtils.ISystem._jj_dependent( _competence, fromUserHome.getDEPENDENT() );
				_primitive.push( fromUserHome );
			}
			finally{
				
			}
		}
		
		/**
		 * ��ǰ��ͨ�û�
		 * @return
		 */
		public IUpffmxUserHome getUSER(){
			IUpffmxUserHome fromUserHome = null;
			try 
			{
				if (_primitive.size() > 0) fromUserHome = (IUpffmxUserHome) _primitive.peek();
				if (fromUserHome == null) {
					ExceptionFactory.throwRuntime("IOS0010000", new String[] { Thread.currentThread().getName() });
				}
			} 
			finally{

			}
			return fromUserHome;
		}
		
		/**
		 * �ύ��ǰ��ͨ�û�����,�翪ͨ�û������и�����ͨ�û�������ָ�������ͨ�û�����
		 */
		public void commitTransaction(){
			try
			{
				IUpffmxUserHome fromUserHome = (IUpffmxUserHome)_primitive.pop();
				if( fromUserHome._optimize != null ){ fromUserHome._optimize.submitSFUpfxUser( fromUserHome ); }
				fromUserHome.finishSingleton();
				fromUserHome = null;
			}
			catch( java.lang.Exception exception ){
				ExceptionFactory.throwRuntime( exception );
			}
			finally{
				
			}
		}
		
		/**
		 * �ع���ǰ��ͨ�û�����,�翪ͨ�û������и�����ͨ�û�������ָ�������ͨ�û�����
		 */
		public void rollbackTransaction(){
			try
			{
				IUpffmxUserHome fromUserHome = (IUpffmxUserHome) _primitive.pop();
				fromUserHome.finishSingleton();
				fromUserHome = null;
			}
			finally{
				
			}
		}
		
		/**
		 * @return ��ͨ�û����񻺴�
		 */
		public java.util.Map<Object,Object> getCustom() {
			return _custom;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017��3��7��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmxUserHome implements java.io.Serializable{
		private static final long serialVersionUID = -3311904759374598843L;
		/*������*/
    	private UUID ID = null;
    	/*����*/
    	private IUpffxDequeHome  _optimize   = null;
		/*��ͨ����*/
		private IOVOrderRequest  _platform   = null;
		/*��ͨ�û�*/
		private IOVOrderUser     _user       = null;
		/*��ͨ����*/
		private IUpfgkmOfferHome _competence = null;
		/*�����Ʒ����*/
 		private IOVUpffmxDepend  _dependent  = new IOVUpffmxDepend();
 		/*��ͨ��Ʒ�嵥*/
 		private java.util.HashMap<Long,IOVMsgFCentrex>  _singleton = new java.util.HashMap<Long,IOVMsgFCentrex>();
 		/*��ͨ����*/
 		private java.util.HashMap<String, Object> _custom = new java.util.HashMap<String, Object>();
 		public IUpffmxUserHome(){
			super();
			ID        = UUID.getUUID();
			_optimize = null          ;
		}
		
		public IUpffmxUserHome(IOVOrderRequest request, IOVOrderUser orduser, IUpfgkmOfferHome competence){
			super();
			ID          = UUID.getUUID();
			_optimize   = null          ;
			_platform   = request       ;
			_user       = orduser       ;
			_competence = competence    ;
		}
		
		public IUpffmxUserHome(IUpffxDequeHome objective, IOVOrderRequest request, IOVOrderUser orduser, IUpfgkmOfferHome competence ){
			super();
			ID          = UUID.getUUID();
			_optimize   = objective     ;
			_platform   = request       ;
			_user       = orduser       ;
			_competence = competence    ;
		}
		
		/**
		 * @return ����������
		 */
		public UUID getID() {
			return ID;
		}

		/**
		 * @return ��ͨ�û�
		 */
		public IOVOrderUser getUSER() {
			return _user;
		}
		
		/**
		 * @param ord_user ��ͨ�û�
		 */
		public void setUSER(IOVOrderUser ord_user) {
			_user = ord_user;
		}
		
		/**
		 * @return ��ͨ����
		 */
		public IOVOrderRequest getPLATFORM() {
			return _platform;
		}
		
		/**
		 * @param platform ��ͨ����
		 */
		public void setPLATFORM(IOVOrderRequest platform) {
			_platform = platform;
		}

		/**
		 * @return �����Ʒ����
		 */
		public IOVUpffmxDepend getDEPENDENT() {
			return _dependent;
		}
		
		/**
		 * @return �����Ʒ�����嵥
		 */
		public java.util.Map<Long,IOVMsgFCentrex> getSINGLETON() {
			return _singleton;
		}
		
		/**
		 * @return ��ͨ����
		 */
		public java.util.HashMap<String, Object> getCUSTOM() {
			return _custom;
		}

		/**
		 * ���ݵ�ǰ���񶩹���ȡ�Ѵ�����񶩹���ϵ
		 * @param fromMsgFCentrex ���񶩹�
		 * @return ΪNULL��δ��������񶩹�,�����������񶩹�
		 */
		public IOVMsgFCentrex getSFUpffxUsed( IOVMsgFCentrex fromMsgFCentrex ){
			IOVMsgFCentrex fromUsed = null;
			try
			{
				if( fromMsgFCentrex != null && fromMsgFCentrex.getINS_PROD_ID() > 0 ){
					Long fromInstId = new Long( fromMsgFCentrex.getINS_PROD_ID() );
					fromUsed = (IOVMsgFCentrex)_singleton.get( fromInstId );
				}
			}
			finally{
				
			}
			return fromUsed;
		}
		
		/**
		 * �ѵ�ǰ���񶩹��ύ�������Ʒ�����嵥��
		 * @param fromMsgFCentrex
		 */
		public void submitSFUpffxUsed( IOVMsgFCentrex fromMsgFCentrex ){
			try
			{
				if( fromMsgFCentrex != null && fromMsgFCentrex.getINS_PROD_ID() > 0 ){
					java.lang.Long fromInstId = new Long( fromMsgFCentrex.getINS_PROD_ID() );
					_singleton.put( fromInstId, fromMsgFCentrex );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * �ѵ�ǰ���񶩹��ύ�������Ʒ�����嵥��
		 * @param fromMsgFCentrex
		 */
		public void submitSFUpffxUsed( IOVMsgFCentrex[] fromMsgFCentrex ){
			try
			{
				for( int index = 0; fromMsgFCentrex != null && index < fromMsgFCentrex.length; index++ ){
					if( fromMsgFCentrex[index].getINS_PROD_ID() <= 0 ) continue;
					submitSFUpffxUsed( fromMsgFCentrex[index] );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * �Ƿ�Ϊ��ͨ��������
		 * @return
		 */
		public boolean isSUBFLOW(){
			return _optimize != null && _optimize instanceof IUpffxSubFlowHome;
		}
		
		/**
		 * �Ƿ�Ϊ��Ա��������
		 * @return
		 */
		public boolean isSUBJECT(){
			return _optimize != null && _optimize instanceof IUpffxSubJectHome;
		}
		
		/**
		 * �Ƿ��ڲ�Ʒ����
		 * @return
		 */
		public boolean isEXPIRE(){
			return _optimize != null && _optimize instanceof IUpffxExpireHome;
		}
		
		/**
		 * �Ƿ�������������
		 * @return
		 */
		public boolean isCENTREX(){
			return _optimize != null && _optimize instanceof IUpffxCentrexHome;
		}
		
		/**
		 * �ͷŵ�ǰ��Ʒ����������ϵ
		 */
		public void finishSingleton(){
			try
			{
				if( _singleton != null ){ _singleton.clear(); }
				if( _dependent != null ){ _dependent.getINSTANCE().clear(); }
				if( _custom != null ){ _custom.clear(); }
			}
			finally{
				
			}
		}
	}
}
