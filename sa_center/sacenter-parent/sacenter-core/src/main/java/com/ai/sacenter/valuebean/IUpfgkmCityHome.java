package com.ai.sacenter.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.util.ClassUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 地市分组存放对象</p>
 * <p>Copyright: Copyright (c) 2016年11月23日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmCityHome implements java.io.Serializable{
	private static final long serialVersionUID = 7394434840444682101L;
	/*网元编码*/
	private String PLATFORM ;
	/*创建时间*/
	private java.sql.Timestamp CREATE_DATE = null;
	/*地市编码*/
	private String REGION_ID;
	/*工单列表*/
	private java.util.List COMPLETE = new java.util.ArrayList(); 
	public IUpfgkmCityHome() {
		super();
	}
	public IUpfgkmCityHome( String regionId ){
		super();
		PLATFORM    = IUpdcConst.IUpfwm.IUpfm.ucmframe;
		CREATE_DATE = new java.sql.Timestamp( System.currentTimeMillis() ); 
		REGION_ID   = regionId;
	}
	
	public IUpfgkmCityHome( String platform, String regionId ){
		super();
		PLATFORM  = platform;
		CREATE_DATE = new java.sql.Timestamp( System.currentTimeMillis() ); 
		REGION_ID = regionId;
	}
	
	public IUpfgkmCityHome( String platform, java.sql.Timestamp createDate, String regionId ){
		super();
		PLATFORM    = platform;
		CREATE_DATE = createDate; 
		REGION_ID   = regionId;
	}
	
	/**
	 * @return 网元编码
	 */
	public String getPLATFORM() {
		return PLATFORM;
	}
	
	/**
	 * @param pLATFORM 网元编码
	 */
	public void setPLATFORM(String pLATFORM) {
		PLATFORM = pLATFORM;
	}
	
	/**
	 * @return 创建时间
	 */
	public java.sql.Timestamp getCREATE_DATE() {
		return CREATE_DATE;
	}
	
	/**
	 * @param cREATE_DATE 创建时间
	 */
	public void setCREATE_DATE(java.sql.Timestamp cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	
	/**
	 * @return 地市编码
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}
	
	/**
	 * @param rEGION_ID 地市编码
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	
	/**
	 * @return 工单列表
	 */
	public java.util.List getCOMPLETE() {
		return COMPLETE;
	}
	
	/**
	 * 
	 * @param aCOMPOSITE
	 * @return
	 */
	public Object[] getCOMPLETE( Class aCOMPOSITE ){
		return ClassUtils.IClass.arrayDesign( COMPLETE, aCOMPOSITE );
	}
	
	/**
	 * 合并开通单项[全部清除后添加]
	 * @param _complete
	 */
	public void mergeAsLimite( java.util.List complete ){
		COMPLETE.clear();
		for( java.util.Iterator itera = complete.iterator(); itera.hasNext(); ){
			Object _objective = itera.next();
			COMPLETE.add( _objective );
		}
	}
	
	/**
	 * 合并开通单项[如存在则重置开通单项]
	 * @param _complete
	 */
	public void mergeAsUnique( java.util.List complete ){
		for( java.util.Iterator itera = complete.iterator(); itera.hasNext(); ){
			Object _objective = itera.next();
			int indexOf = COMPLETE.indexOf( _objective );
			if( indexOf >= 0 ){ COMPLETE.set( indexOf, _objective ); }
			else{ COMPLETE.add( _objective ); }
		}
	}
	
	/**
	 * 合并开通单项[添加开通单项]
	 * @param complete
	 */
	public void mergeAsComposite( java.util.List complete ){
		for( java.util.Iterator itera = complete.iterator(); itera.hasNext(); ){
			Object _objective = itera.next();
			COMPLETE.add( _objective );
		}
	}
}
