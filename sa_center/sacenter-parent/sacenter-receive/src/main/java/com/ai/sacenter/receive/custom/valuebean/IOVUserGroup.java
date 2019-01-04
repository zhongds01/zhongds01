package com.ai.sacenter.receive.custom.valuebean;

import com.ai.sacenter.common.IUpdfmxEntry;
import com.ai.sacenter.receive.custom.ICustomConst;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 用户群</p>
 * <p>Copyright: Copyright (c) 2018年6月1日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUserGroup extends IUpdfmxEntry implements java.io.Serializable{
	private static final long serialVersionUID = -5341537280309205801L;
	private IUserGroupHome _group;
	public IOVUserGroup() {
		super();
		_group = new IUserGroupHome();
	}

	public IOVUserGroup( IOVUserGroup usergroup ) {
		super( usergroup );
		_group = new IUserGroupHome( _group );
	}
	
	/**
	 * 
	 * @return
	 */
	public IUserGroupHome getGROUP(){
		return _group;
	}
	
	public static class IUserGroupHome extends IUpdfmxEntry implements java.io.Serializable{
		private static final long serialVersionUID = 1665201137299533796L;
		private CarbonList<IUserGroup> _centrex = new CarbonList<IUserGroup>();
		public IUserGroupHome(){
			super();
		}
		
		public IUserGroupHome(IUserGroupHome usergrouphome ){
			super( usergrouphome );
			for( java.util.Iterator<IUserGroup> itera = _centrex.iterator(); itera.hasNext(); ){
				IUserGroup _usergroup = (IUserGroup)itera.next();
				_centrex.add( new IUserGroup( _usergroup ) );
			}
		}
		
		/**
		 * 用户群关系列表
		 * @return
		 */
		public CarbonList<IUserGroup> getCENTREX(){
			return _centrex;
		}
	}
	
	public static class IUserGroup extends IUpdfmxEntry implements java.io.Serializable{
		private static final long serialVersionUID = -7251734223550840978L;
		private long   OFFER_ID	     ;
		private long   GROUP_ID      ;
		private long   USER_ID	     ;
		private String ROLE_ID	     ;
		private String GROUP_USER    ;
		private String USER_REGION_ID;
		private String GROUP_REGON_ID;
		private String REGION_ID     ;
		private java.sql.Timestamp EFFECTIVE;
		private java.sql.Timestamp EXPIRE	;
		public IUserGroup(){
			super();
			OFFER_ID   = 0                                                     ;
			EFFECTIVE  = TimeUtils.getEffective()                              ;
			EXPIRE     = TimeUtils.getMaxExpire()                              ;
			GROUP_USER = String.valueOf( ICustomConst.IOffer.IS_GRP_MAIN_USER );
		}
		
		public IUserGroup( IUserGroup usergroup ){
			super( usergroup );
			OFFER_ID       = usergroup.getOFFER_ID      ();
			GROUP_ID       = usergroup.getGROUP_ID      ();
			USER_ID	       = usergroup.getUSER_ID	    ();
			ROLE_ID	       = usergroup.getROLE_ID	    ();
			GROUP_USER     = usergroup.getGROUP_USER    ();
			USER_REGION_ID = usergroup.getUSER_REGION_ID();
			GROUP_REGON_ID = usergroup.getGROUP_REGON_ID();
			REGION_ID      = usergroup.getREGION_ID     ();
			EFFECTIVE      = usergroup.getEFFECTIVE     ();
			EXPIRE	       = usergroup.getEXPIRE	    ();
		}
		
		/**
		 * @return 群组订购编号
		 */
		public long getOFFER_ID() {
			return OFFER_ID;
		}
		
		/**
		 * @param oFFER_ID 群组订购编号
		 */
		public void setOFFER_ID(long oFFER_ID) {
			OFFER_ID = oFFER_ID;
		}
		
		/**
		 * @return 群组用户编号
		 */
		public long getGROUP_ID() {
			return GROUP_ID;
		}
		
		/**
		 * @param gROUP_ID 群组用户编号
		 */
		public void setGROUP_ID(long gROUP_ID) {
			GROUP_ID = gROUP_ID;
		}
		
		/**
		 * @return 群组成员编号
		 */
		public long getUSER_ID() {
			return USER_ID;
		}
		
		/**
		 * @param uSER_ID 群组成员编号
		 */
		public void setUSER_ID(long uSER_ID) {
			USER_ID = uSER_ID;
		}
		
		/**
		 * @return 群组成员角色
		 */
		public String getROLE_ID() {
			return ROLE_ID;
		}
		
		/**
		 * @param rOLE_ID 群组成员角色
		 */
		public void setROLE_ID(String rOLE_ID) {
			ROLE_ID = rOLE_ID;
		}
		
		/**
		 * @return 群主用户标志
		 */
		public String getGROUP_USER() {
			return GROUP_USER;
		}
		
		/**
		 * @param gROUP_USER 群主用户标志
		 */
		public void setGROUP_USER(String gROUP_USER) {
			GROUP_USER = gROUP_USER;
		}
		
		/**
		 * @return 群组成员所在地市
		 */
		public String getUSER_REGION_ID() {
			return USER_REGION_ID;
		}
		
		/**
		 * @param uSER_REGION_ID 群组成员所在地市
		 */
		public void setUSER_REGION_ID(String uSER_REGION_ID) {
			USER_REGION_ID = uSER_REGION_ID;
		}
		
		/**
		 * @return 群组所在地市编码
		 */
		public String getGROUP_REGON_ID() {
			return GROUP_REGON_ID;
		}
		
		/**
		 * @param gROUP_REGON_ID 群组所在地市编码
		 */
		public void setGROUP_REGON_ID(String gROUP_REGON_ID) {
			GROUP_REGON_ID = gROUP_REGON_ID;
		}
		
		/**
		 * @return 群组地市编码
		 */
		public String getREGION_ID() {
			return REGION_ID;
		}
		
		/**
		 * @param rEGION_ID 群组地市编码
		 */
		public void setREGION_ID(String rEGION_ID) {
			REGION_ID = rEGION_ID;
		}
		
		/**
		 * @return 生效时间
		 */
		public java.sql.Timestamp getEFFECTIVE() {
			return EFFECTIVE;
		}
		
		/**
		 * @param eFFECTIVE 生效时间
		 */
		public void setEFFECTIVE(java.sql.Timestamp eFFECTIVE) {
			EFFECTIVE = eFFECTIVE;
		}
		
		/**
		 * @return 失效时间
		 */
		public java.sql.Timestamp getEXPIRE() {
			return EXPIRE;
		}
		
		/**
		 * @param eXPIRE 失效时间
		 */
		public void setEXPIRE(java.sql.Timestamp eXPIRE) {
			EXPIRE = eXPIRE;
		}
		
	}
}
