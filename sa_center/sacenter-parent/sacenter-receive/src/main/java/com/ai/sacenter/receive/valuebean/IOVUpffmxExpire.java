package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 网元到期用户</p>
 * <p>Copyright: Copyright (c) 2017年3月8日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpffmxExpire implements java.io.Serializable{
	private static final long serialVersionUID = -958988087800693736L;
	/*发起方工单*/
	private Object _objective = null;
	/*开通到期接入层*/
	private IUpfgkmOfferHome   _competence = null;
	/*用户订购*/
	private CarbonList<IOVMsgFOffer> _order   = new CarbonList<IOVMsgFOffer>();
	/*网元到期用户*/
	private java.util.HashMap<String,IUpffmxUser> _user = new java.util.HashMap<String,IUpffmxUser>();
	public IOVUpffmxExpire( Object objective ) {
		super();
		_objective = objective;
	}
	
	/**
	 * 发起方工单
	 * @return 
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return 用户订购
	 */
	public CarbonList<IOVMsgFOffer> getORDER() {
		return _order;
	}

	/**
	 * @return 开通到期接入层
	 */
	public IUpfgkmOfferHome getCOMPETENCE() {
		return _competence;
	}

	/**
	 * @param competence 开通到期接入层
	 */
	public void setCOMPETENCE(IUpfgkmOfferHome competence) {
		_competence = competence;
	}

	/**
	 * @return 网元到期用户清单
	 */
	public java.util.HashMap<String,IUpffmxUser> getUSER() {
		return _user;
	}
	
	/**
	 * 根据用户编号获取网元到期用户清单
	 * @param aUSER_ID 用户编号
	 * @return
	 */
	public IUpffmxUser[] getUSER( long aUSER_ID ){
		java.util.List<IUpffmxUser> fromUpffmxHome = new java.util.ArrayList<IUpffmxUser>();
		try
		{
			for( java.util.Iterator<IUpffmxUser> itera = _user.values().iterator(); itera.hasNext(); ){
				IUpffmxUser fromUserHome = (IUpffmxUser)itera.next();
				if( fromUserHome.getUSER_ID() == aUSER_ID ){
					fromUpffmxHome.add( fromUserHome );
				}
			}
		}
		finally{
			
		}
		return (IUpffmxUser[])fromUpffmxHome.toArray( new IUpffmxUser[]{} );
	}
	
	/**
	 * 根据用户编号和到期时间获取到期用户
	 * @param aUSER_ID 开通用户
	 * @param fromExpire 到期时间
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpffmxUser getUSER( long aUSER_ID, java.sql.Timestamp fromExpire ) throws SFException,Exception{
		IUpffmxUser fromUserHome = null;
		try
		{
			fromExpire = TimeUtils.expire( fromExpire );
			String fromINDEX = CustomUtils.ICatalog._expire_user_id( aUSER_ID, fromExpire );
			fromUserHome = (IUpffmxUser)_user.get( fromINDEX );
			if( fromUserHome == null ){
				_user.put( fromINDEX, fromUserHome = new IUpffmxUser( aUSER_ID, 
						fromExpire, 
						_competence ) );
			}
		}
		finally{
			
		}
		return fromUserHome;
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年3月8日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpffmxUser implements java.io.Serializable{
		private static final long serialVersionUID = -2662773863756285202L;
		private long _user_id ;
		private java.sql.Timestamp _order_date;
		private IUpfgkmOfferHome   _competence = null;
		private IOVMsgFUser _user ;
		public IUpffmxUser( long aUSER_ID, java.sql.Timestamp aORDER_DATE){
			super();
			_user_id    = aUSER_ID;
			_order_date = aORDER_DATE;
		}
		
		public IUpffmxUser( long aUSER_ID, java.sql.Timestamp aORDER_DATE, IUpfgkmOfferHome aCOMPETENCE ){
			super();
			_user_id    = aUSER_ID   ;
			_order_date = aORDER_DATE;
			_competence = aCOMPETENCE;
		}
		
		/**
		 * @return 用户编号
		 */
		public long getUSER_ID() {
			return _user_id;
		}
		
		/**
		 * @param user_id 用户编号
		 */
		public void setUSER_ID(long user_id) {
			_user_id = user_id;
		}
		
		/**
		 * @return 到期时间
		 */
		public java.sql.Timestamp getORDER_DATE() {
			return _order_date;
		}
		
		/**
		 * @param order_date 到期时间
		 */
		public void setORDER_DATE(java.sql.Timestamp order_date) {
			_order_date = order_date;
		}
		
		/**
		 * @return 开通到期接入层
		 */
		public IUpfgkmOfferHome getCOMPETENCE() {
			return _competence;
		}

		/**
		 * @param competence 开通到期接入层
		 */
		public void setCOMPETENCE(IUpfgkmOfferHome competence) {
			_competence = competence;
		}
		
		/**
		 * @return 到期用户
		 */
		public IOVMsgFUser getUSER() {
			return _user;
		}
		
		/**
		 * @param user 到期用户
		 */
		public void setUSER(IOVMsgFUser user) {
			_user = user;
		}
	}
}
