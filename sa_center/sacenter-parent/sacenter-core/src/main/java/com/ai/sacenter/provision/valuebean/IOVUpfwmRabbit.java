package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-cboss</p>
 * <p>Description: ��Ԫ��������</p>
 * <p>Copyright: Copyright (c) 2017��2��20��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpfwmRabbit implements java.io.Serializable{
	private static final long serialVersionUID = -3818634613604041578L;
	/*����*/
	private Object  _objective = null;
	/*֪ͨ����*/
	private java.util.HashMap _index = new java.util.HashMap();
	public IOVUpfwmRabbit(Object objective) {
		super();
		_objective = objective;
	}
	
	/**
	 * @return ����
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return ֪ͨ����
	 */
	public java.util.HashMap getINDEX() {
		return _index;
	}
	
	/**
	 * 
	 * @param fromINDEX
	 * @return
	 */
	public IUpfwmNotify getINDEX( String fromINDEX ){
		return (IUpfwmNotify)_index.get( fromINDEX );
	}
	/**
	 * 
	 * <p>Title: sacenter-cboss</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017��2��21��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmNotify implements java.io.Serializable{
		private static final long serialVersionUID = -7456064512899425964L;
		/*�û����*/
		private long   _user_id ;
		/*��������*/
		private String _category ;
		/*����ʱ��*/
		private java.sql.Timestamp _create_date;
		/*���б���*/
		private String _region_id;
		/*��Ԫ����*/
		private String _platform ;
		/*�û�ͣ��*/
		private String _status   ;
		/*�Ϸ�����*/
		private java.util.ArrayList _subflow = new java.util.ArrayList();
		public IUpfwmNotify(){
			super();
			_status = IUpfwmConst.IUpfwm.IUpffs.NORMAL;
		}
		
		/**
		 * @return �û����
		 */
		public long getUSER_ID() {
			return _user_id;
		}
		
		/**
		 * @param _user_id �û����
		 */
		public void setUSER_ID(long user_id) {
			_user_id = user_id;
		}
		
		/**
		 * @return ��������
		 */
		public String getCATEGORY() {
			return _category;
		}
		
		/**
		 * @param category ��������
		 */
		public void setCATEGORY(String category) {
			_category = category;
		}
		
		/**
		 * @return ����ʱ��
		 */
		public java.sql.Timestamp getCREATE_DATE() {
			return _create_date;
		}
		
		/**
		 * @param create_date ����ʱ��
		 */
		public void setCREATE_DATE(java.sql.Timestamp create_date) {
			_create_date = create_date;
		}
		
		/**
		 * @return ���б���
		 */
		public String getREGION_ID() {
			return _region_id;
		}
		
		/**
		 * @param region_id ���б���
		 */
		public void setREGION_ID(String region_id) {
			_region_id = region_id;
		}
		
		/**
		 * @return ��Ԫ����
		 */
		public String getPLATFORM() {
			return _platform;
		}
		
		/**
		 * @param platform ��Ԫ����
		 */
		public void setPLATFORM(String platform) {
			_platform = platform;
		}

		/**
		 * @return �û�ͣ��
		 */
		public String getSTATUS() {
			return _status;
		}

		/**
		 * @param status �û�ͣ��
		 */
		public void setSTATUS(String status) {
			_status = status;
		}

		/**
		 * 
		 * @param status ͣ������
		 */
		public void setSTATUS( long status ){
			_status = String.valueOf( status );
			if( _status.length() < 2 ){
				_status = StringUtils.filling( _status, 2, StringUtils.RIGHT, '0');
			}
		}
		
		/**
		 * @return the _platform
		 */
		public java.util.ArrayList getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * ��ȡ��ǰ����
		 * @return
		 */
		public String getINDEX(){
			StringBuilder fromINDEX = new StringBuilder();
			try
			{
				fromINDEX.append( _user_id > 0?String.valueOf(_user_id):"*")
				         .append("_$_")
				         .append( _category != null?_category:"*" )
				         .append("_$")
				         .append( _platform != null?_platform:"*" )
				         .append("_$_")
				         .append( _create_date != null?TimeUtils.getAsExpire( _create_date ):"*" )
				         .append("_$_")
				         .append( _region_id );
			}
			finally{
				
			}
			return fromINDEX.toString();
		}
		
		/**
		 * �Ƿ�������
		 * @return
		 */
		public boolean isEXPIRE(){
			return StringUtils.equals( _category, IUpdcConst.IUpdbm.IUpdbf.EXPIRE );
		}
		
		/**
		 * �Ƿ��û�ͣ��
		 * @return
		 */
		public boolean isOSUSER(){
			return  StringUtils.equals( _status, IUpfwmConst.IUpfwm.IUpffs.NORMAL ) == false;
		}
		
		/**
		 * �Ƿ�Ϊͣ����ͣ�Ϸ�
		 * @return
		 */
		public boolean isSUSPEND(){
			return StringUtils.equals( _category, IUpdcConst.IUpdbm.IUpdbf.EXPIRE ) && 
					StringUtils.equals( _status, IUpfwmConst.IUpfwm.IUpffs.NORMAL ) == false;
		}
	}
}
