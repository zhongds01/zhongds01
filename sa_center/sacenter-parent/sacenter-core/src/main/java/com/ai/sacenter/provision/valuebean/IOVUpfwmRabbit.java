package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-cboss</p>
 * <p>Description: 网元工单索引</p>
 * <p>Copyright: Copyright (c) 2017年2月20日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpfwmRabbit implements java.io.Serializable{
	private static final long serialVersionUID = -3818634613604041578L;
	/*发起方*/
	private Object  _objective = null;
	/*通知索引*/
	private java.util.HashMap _index = new java.util.HashMap();
	public IOVUpfwmRabbit(Object objective) {
		super();
		_objective = objective;
	}
	
	/**
	 * @return 发起方
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return 通知索引
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
	 * <p>Copyright: Copyright (c) 2017年2月21日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmNotify implements java.io.Serializable{
		private static final long serialVersionUID = -7456064512899425964L;
		/*用户编号*/
		private long   _user_id ;
		/*工单类型*/
		private String _category ;
		/*到期时间*/
		private java.sql.Timestamp _create_date;
		/*地市编码*/
		private String _region_id;
		/*网元编码*/
		private String _platform ;
		/*用户停机*/
		private String _status   ;
		/*上发工单*/
		private java.util.ArrayList _subflow = new java.util.ArrayList();
		public IUpfwmNotify(){
			super();
			_status = IUpfwmConst.IUpfwm.IUpffs.NORMAL;
		}
		
		/**
		 * @return 用户编号
		 */
		public long getUSER_ID() {
			return _user_id;
		}
		
		/**
		 * @param _user_id 用户编号
		 */
		public void setUSER_ID(long user_id) {
			_user_id = user_id;
		}
		
		/**
		 * @return 工单类型
		 */
		public String getCATEGORY() {
			return _category;
		}
		
		/**
		 * @param category 工单类型
		 */
		public void setCATEGORY(String category) {
			_category = category;
		}
		
		/**
		 * @return 到期时间
		 */
		public java.sql.Timestamp getCREATE_DATE() {
			return _create_date;
		}
		
		/**
		 * @param create_date 到期时间
		 */
		public void setCREATE_DATE(java.sql.Timestamp create_date) {
			_create_date = create_date;
		}
		
		/**
		 * @return 地市编码
		 */
		public String getREGION_ID() {
			return _region_id;
		}
		
		/**
		 * @param region_id 地市编码
		 */
		public void setREGION_ID(String region_id) {
			_region_id = region_id;
		}
		
		/**
		 * @return 网元编码
		 */
		public String getPLATFORM() {
			return _platform;
		}
		
		/**
		 * @param platform 网元编码
		 */
		public void setPLATFORM(String platform) {
			_platform = platform;
		}

		/**
		 * @return 用户停机
		 */
		public String getSTATUS() {
			return _status;
		}

		/**
		 * @param status 用户停机
		 */
		public void setSTATUS(String status) {
			_status = status;
		}

		/**
		 * 
		 * @param status 停机类型
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
		 * 获取当前索引
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
		 * 是否到期类型
		 * @return
		 */
		public boolean isEXPIRE(){
			return StringUtils.equals( _category, IUpdcConst.IUpdbm.IUpdbf.EXPIRE );
		}
		
		/**
		 * 是否用户停机
		 * @return
		 */
		public boolean isOSUSER(){
			return  StringUtils.equals( _status, IUpfwmConst.IUpfwm.IUpffs.NORMAL ) == false;
		}
		
		/**
		 * 是否为停机暂停上发
		 * @return
		 */
		public boolean isSUSPEND(){
			return StringUtils.equals( _category, IUpdcConst.IUpdbm.IUpdbf.EXPIRE ) && 
					StringUtils.equals( _status, IUpfwmConst.IUpfwm.IUpffs.NORMAL ) == false;
		}
	}
}
