package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��Ԫ�����û�</p>
 * <p>Copyright: Copyright (c) 2017��3��8��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpffmxExpire implements java.io.Serializable{
	private static final long serialVersionUID = -958988087800693736L;
	/*���𷽹���*/
	private Object _objective = null;
	/*��ͨ���ڽ����*/
	private IUpfgkmOfferHome   _competence = null;
	/*�û�����*/
	private CarbonList<IOVMsgFOffer> _order   = new CarbonList<IOVMsgFOffer>();
	/*��Ԫ�����û�*/
	private java.util.HashMap<String,IUpffmxUser> _user = new java.util.HashMap<String,IUpffmxUser>();
	public IOVUpffmxExpire( Object objective ) {
		super();
		_objective = objective;
	}
	
	/**
	 * ���𷽹���
	 * @return 
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return �û�����
	 */
	public CarbonList<IOVMsgFOffer> getORDER() {
		return _order;
	}

	/**
	 * @return ��ͨ���ڽ����
	 */
	public IUpfgkmOfferHome getCOMPETENCE() {
		return _competence;
	}

	/**
	 * @param competence ��ͨ���ڽ����
	 */
	public void setCOMPETENCE(IUpfgkmOfferHome competence) {
		_competence = competence;
	}

	/**
	 * @return ��Ԫ�����û��嵥
	 */
	public java.util.HashMap<String,IUpffmxUser> getUSER() {
		return _user;
	}
	
	/**
	 * �����û���Ż�ȡ��Ԫ�����û��嵥
	 * @param aUSER_ID �û����
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
	 * �����û���ź͵���ʱ���ȡ�����û�
	 * @param aUSER_ID ��ͨ�û�
	 * @param fromExpire ����ʱ��
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
	 * <p>Copyright: Copyright (c) 2017��3��8��</p>
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
		 * @return �û����
		 */
		public long getUSER_ID() {
			return _user_id;
		}
		
		/**
		 * @param user_id �û����
		 */
		public void setUSER_ID(long user_id) {
			_user_id = user_id;
		}
		
		/**
		 * @return ����ʱ��
		 */
		public java.sql.Timestamp getORDER_DATE() {
			return _order_date;
		}
		
		/**
		 * @param order_date ����ʱ��
		 */
		public void setORDER_DATE(java.sql.Timestamp order_date) {
			_order_date = order_date;
		}
		
		/**
		 * @return ��ͨ���ڽ����
		 */
		public IUpfgkmOfferHome getCOMPETENCE() {
			return _competence;
		}

		/**
		 * @param competence ��ͨ���ڽ����
		 */
		public void setCOMPETENCE(IUpfgkmOfferHome competence) {
			_competence = competence;
		}
		
		/**
		 * @return �����û�
		 */
		public IOVMsgFUser getUSER() {
			return _user;
		}
		
		/**
		 * @param user �����û�
		 */
		public void setUSER(IOVMsgFUser user) {
			_user = user;
		}
	}
}
