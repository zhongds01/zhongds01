package com.ai.sacenter.core.valuebean;

import com.ai.sacenter.valuebean.IProgramTemplate.IUpdffwmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 落地派单对象</p>
 * <p>Copyright: Copyright (c) 2014-4-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdffwmOffer implements java.io.Serializable{
	private static final long serialVersionUID = 2577767670254832600L;
	private Object INDEX ;//索引编码
	private String TYPE  ;//派单类型
	private String OBJECT;//派单对象
	private String JAVA  ;//全路径类
	private IUpdffwmOffer.IUpdfcmpDistribute CONFIGURE;//派单规则
	private java.util.HashMap COMPLEX = new java.util.HashMap();
	public IOVUpdffwmOffer(String aTYPE , String aOBJECT, String aJAVA ){
		super();
		TYPE = aTYPE;
		OBJECT = aOBJECT;
		JAVA = aJAVA;
	}
	
	/**
	 * @return the cONFIGURE
	 */
	public IUpdffwmOffer.IUpdfcmpDistribute getCONFIGURE() {
		return CONFIGURE;
	}

	/**
	 * @param configure the cONFIGURE to set
	 */
	public void setCONFIGURE(IUpdffwmOffer.IUpdfcmpDistribute configure) {
		CONFIGURE = configure;
	}

	/**
	 * @return the iNDEX
	 */
	public Object getINDEX() {
		return INDEX;
	}
	/**
	 * @param index the iNDEX to set
	 */
	public void setINDEX(Object index) {
		INDEX = index;
	}
	/**
	 * @return the jAVA
	 */
	public String getJAVA() {
		return JAVA;
	}
	/**
	 * @param java the jAVA to set
	 */
	public void setJAVA(String java) {
		JAVA = java;
	}
	/**
	 * @return the oBJECT
	 */
	public String getOBJECT() {
		return OBJECT;
	}
	/**
	 * @param object the oBJECT to set
	 */
	public void setOBJECT(String object) {
		OBJECT = object;
	}
	/**
	 * @return the tYPE
	 */
	public String getTYPE() {
		return TYPE;
	}
	/**
	 * @param type the tYPE to set
	 */
	public void setTYPE(String type) {
		TYPE = type;
	}
	/**
	 * @return the cOMPLEX
	 */
	public java.util.HashMap getCOMPLEX() {
		return COMPLEX;
	}
}
