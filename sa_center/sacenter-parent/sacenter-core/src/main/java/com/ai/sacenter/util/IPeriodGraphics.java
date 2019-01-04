package com.ai.sacenter.util;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-2-9</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IPeriodGraphics implements java.io.Serializable{
	private static final long serialVersionUID = -8691268546377887293L;
	private String id;
	private String name;
	private String type;
	private java.util.Map graphics = new java.util.HashMap();
	public IPeriodGraphics(){
		super();
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the graphics
	 */
	public java.util.Map getGraphics() {
		return graphics;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean doEquals = obj instanceof IPeriodGraphics;
		if( doEquals == true ) doEquals = StringUtils.equals( id , ((IPeriodGraphics)obj).id );
		return doEquals;
	}
}
