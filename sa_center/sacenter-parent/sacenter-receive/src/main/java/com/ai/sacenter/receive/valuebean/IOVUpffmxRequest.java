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
 * <p>Description: 开通定单组(开通工单请求和开通到期工单)</p>
 * <p>Copyright: Copyright (c) 2016年3月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpffmxRequest implements java.io.Serializable{
	private static final long serialVersionUID = 4858009927711530520L;
	/*发起方工单*/
	private Object _objective = null;
	/*开通工单*/
	private IOVUpffmxConsult   _platform = new IOVUpffmxConsult();
	/*开通事务*/
	private IUpffxOptimizeHome _optimize = new IUpffxOptimizeHome();
	/*批量工单*/
	private IUpffxCentrexHome _centrex   = new IUpffxCentrexHome();
	/*到期工单*/
	private IUpffxExpireHome  _expire    = new IUpffxExpireHome();
	public IOVUpffmxRequest(Object oBJECTIVE) {
		super();
		_objective = oBJECTIVE;
	}
	
	/**
	 * 发起方工单
	 * @return 
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return 开通事务
	 */
	public IUpffxOptimizeHome getUSER() {
		return _optimize;
	}

	/**
	 * @return 开通工单
	 */
	public IOVUpffmxConsult getPLATFORM() {
		return _platform;
	}
	
	/**
	 * @param pLATFORM 开通工单
	 */
	public void setPLATFORM(IOVUpffmxConsult pLATFORM) {
		_platform = pLATFORM;
	}
	
	/**
	 * @return 批量工单
	 */
	public IUpffxCentrexHome getCENTREX() {
		return _centrex;
	}
	
	/**
	 * @return 到期工单
	 */
	public IUpffxExpireHome getEXPIRE() {
		return _expire;
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 开通定单</p>
	 * <p>Copyright: Copyright (c) 2018年4月11日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static interface IUpffxDequeHome{
		/**
		 * 提交开通工单到批量缓存中
		 * @param _user
		 */
		public void submitSFUpfxUser( IUpffmxUserHome _user ) throws SFException,Exception;
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: 开通定单事务</p>
	 * <p>Copyright: Copyright (c) 2018年4月11日</p>
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
	 * <p>Description: 成员定单事务</p>
	 * <p>Copyright: Copyright (c) 2018年4月11日</p>
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
	 * <p>Description: 批量定单事务</p>
	 * <p>Copyright: Copyright (c) 2017年6月15日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffxCentrexHome implements IUpffxDequeHome{
		/*批量工单*/
		private CarbonList<IOVUpffmxConsult> _order = new CarbonList<IOVUpffmxConsult>();
		public IUpffxCentrexHome(){
			super();
		}
		
		/**
		 * @return 批量工单
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
	 * <p>Description: 到期工单事务</p>
	 * <p>Copyright: Copyright (c) 2016年3月17日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffxExpireHome implements IUpffxDequeHome{
		/*到期用户单*/
		private CarbonList<IOVUpffmxConsult>  _expire = new CarbonList<IOVUpffmxConsult>();
		/*到期缓存单*/
		private java.util.Map<String, Object> _custom = new java.util.HashMap<String, Object>();
		public IUpffxExpireHome(){
			super();
		}
		
		/**
		 * @return 到期用户单
		 */
		public CarbonList<IOVUpffmxConsult> getEXPIRE() {
			return _expire;
		}
		
		/**
		 * @return 到期缓存单
		 */
		public java.util.Map<String, Object> getCUSTOM() {
			return _custom;
		}

		/**
		 * 根据用户编号获取到期用户标志
		 * @param aUSER_ID 用户编号
		 * @return
		 */
		public IOVUpffmxConsult getSFUpffxUser( long aUSER_ID ){
			String fromINDEX = CustomUtils.ICatalog._expire_user_id( aUSER_ID );
			return (IOVUpffmxConsult)_custom.get( fromINDEX );
		}
		
		/**
		 * 提交到期用户标志
		 * @param request 开通工单
		 * @param competence 开通能力
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
		 * 提交到期用户标志
		 * @param request 开通工单
		 * @param competence 开通能力
		 * @param user 开通用户
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
				if( isEXPIRE( fromOrdUser.getUSER_ID() ) == false /*网元下周期工单覆盖为最新用户下周期*/){
					IOVOrderOfferX fromOfferX = UpdbfsUtils.ICustom.ICustomX._jj_expire( IUpdbfsConst.IState.E );
					fromOrdUser.getNATURE().put( fromOfferX.getCOMPETE(), fromOfferX );
				}
				_expire.add( _network  );
			}
			finally{
				
			}
		}
		
		/**
		 * 该用户是否已存在到期工单标志
		 * @return
		 */
		public boolean isEXPIRE( long aUSER_ID ){
			boolean _expireUser = false;
			try
			{
				String fromINDEX = CustomUtils.ICatalog._expire_user_id( aUSER_ID );
				_expireUser = _custom.get( fromINDEX ) != null?true:false;
				if( _expireUser == false /*不存在到期工单标志则检查是否存在到期工单*/){
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
	 * <p>Copyright: Copyright (c) 2017年3月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffxOptimizeHome implements java.io.Serializable{
		private static final long serialVersionUID = -4856970567368108087L;
		/*开通定单用户事务*/
    	private ArrayDeque _primitive  = new ArrayDeque();
    	/*开通用户事务缓存(手工清除)*/
		private java.util.Map<Object, Object> _custom = new java.util.HashMap<Object, Object>();
		public IUpffxOptimizeHome(){
			super();
		}
		
		/**
		 * 根据开通工单请求启动开通主用户事务
		 * @param _request 当前开通工单
		 * @param _competence 开通能力
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
		 * 根据开通工单请求和成员用户启动开通成员用户事务
		 * @param _request 当前开通工单
		 * @param _subject 开通成员用户 
		 * @param _competence 开通能力
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
		 * 根据开通工单请求启动开通到期工单事务
		 * @param _request 当前开通工单
		 * @param _expire 到期工单集
		 * @param _competence 开通能力
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
		 * 根据开通工单请求启动开通批量工单事务
		 * @param _request 当前开通工单
		 * @param _centrex 批量工单集
		 * @param _competence 开通能力
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
		 * 当前开通用户
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
		 * 提交当前开通用户事务,如开通用户事务中父级开通用户事务则恢复父级开通用户事务
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
		 * 回滚当前开通用户事务,如开通用户事务中父级开通用户事务则恢复父级开通用户事务
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
		 * @return 开通用户事务缓存
		 */
		public java.util.Map<Object,Object> getCustom() {
			return _custom;
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年3月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmxUserHome implements java.io.Serializable{
		private static final long serialVersionUID = -3311904759374598843L;
		/*事务编号*/
    	private UUID ID = null;
    	/*发起方*/
    	private IUpffxDequeHome  _optimize   = null;
		/*开通工单*/
		private IOVOrderRequest  _platform   = null;
		/*开通用户*/
		private IOVOrderUser     _user       = null;
		/*开通能力*/
		private IUpfgkmOfferHome _competence = null;
		/*服务产品依赖*/
 		private IOVUpffmxDepend  _dependent  = new IOVUpffmxDepend();
 		/*开通产品清单*/
 		private java.util.HashMap<Long,IOVMsgFCentrex>  _singleton = new java.util.HashMap<Long,IOVMsgFCentrex>();
 		/*开通其他*/
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
		 * @return 定单事务编号
		 */
		public UUID getID() {
			return ID;
		}

		/**
		 * @return 开通用户
		 */
		public IOVOrderUser getUSER() {
			return _user;
		}
		
		/**
		 * @param ord_user 开通用户
		 */
		public void setUSER(IOVOrderUser ord_user) {
			_user = ord_user;
		}
		
		/**
		 * @return 开通工单
		 */
		public IOVOrderRequest getPLATFORM() {
			return _platform;
		}
		
		/**
		 * @param platform 开通工单
		 */
		public void setPLATFORM(IOVOrderRequest platform) {
			_platform = platform;
		}

		/**
		 * @return 服务产品依赖
		 */
		public IOVUpffmxDepend getDEPENDENT() {
			return _dependent;
		}
		
		/**
		 * @return 服务产品订购清单
		 */
		public java.util.Map<Long,IOVMsgFCentrex> getSINGLETON() {
			return _singleton;
		}
		
		/**
		 * @return 开通其他
		 */
		public java.util.HashMap<String, Object> getCUSTOM() {
			return _custom;
		}

		/**
		 * 根据当前服务订购获取已处理服务订购关系
		 * @param fromMsgFCentrex 服务订购
		 * @return 为NULL则未处理过服务订购,否则待处理服务订购
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
		 * 把当前服务订购提交到服务产品订购清单中
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
		 * 把当前服务订购提交到服务产品订购清单中
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
		 * 是否为普通工单发起
		 * @return
		 */
		public boolean isSUBFLOW(){
			return _optimize != null && _optimize instanceof IUpffxSubFlowHome;
		}
		
		/**
		 * 是否为成员工单发起
		 * @return
		 */
		public boolean isSUBJECT(){
			return _optimize != null && _optimize instanceof IUpffxSubJectHome;
		}
		
		/**
		 * 是否到期产品发起
		 * @return
		 */
		public boolean isEXPIRE(){
			return _optimize != null && _optimize instanceof IUpffxExpireHome;
		}
		
		/**
		 * 是否批量工单发起
		 * @return
		 */
		public boolean isCENTREX(){
			return _optimize != null && _optimize instanceof IUpffxCentrexHome;
		}
		
		/**
		 * 释放当前产品订购依赖关系
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
