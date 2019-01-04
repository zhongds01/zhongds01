package com.ai.sacenter.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.util.ClassUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ���з����Ŷ���</p>
 * <p>Copyright: Copyright (c) 2016��11��23��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmCityHome implements java.io.Serializable{
	private static final long serialVersionUID = 7394434840444682101L;
	/*��Ԫ����*/
	private String PLATFORM ;
	/*����ʱ��*/
	private java.sql.Timestamp CREATE_DATE = null;
	/*���б���*/
	private String REGION_ID;
	/*�����б�*/
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
	 * @return ��Ԫ����
	 */
	public String getPLATFORM() {
		return PLATFORM;
	}
	
	/**
	 * @param pLATFORM ��Ԫ����
	 */
	public void setPLATFORM(String pLATFORM) {
		PLATFORM = pLATFORM;
	}
	
	/**
	 * @return ����ʱ��
	 */
	public java.sql.Timestamp getCREATE_DATE() {
		return CREATE_DATE;
	}
	
	/**
	 * @param cREATE_DATE ����ʱ��
	 */
	public void setCREATE_DATE(java.sql.Timestamp cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	
	/**
	 * @return ���б���
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}
	
	/**
	 * @param rEGION_ID ���б���
	 */
	public void setREGION_ID(String rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	
	/**
	 * @return �����б�
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
	 * �ϲ���ͨ����[ȫ����������]
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
	 * �ϲ���ͨ����[����������ÿ�ͨ����]
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
	 * �ϲ���ͨ����[��ӿ�ͨ����]
	 * @param complete
	 */
	public void mergeAsComposite( java.util.List complete ){
		for( java.util.Iterator itera = complete.iterator(); itera.hasNext(); ){
			Object _objective = itera.next();
			COMPLETE.add( _objective );
		}
	}
}
