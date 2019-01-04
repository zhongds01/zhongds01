package com.ai.sacenter.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 服务定单群</p>
 * <p>Copyright: Copyright (c) 2017年7月25日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVOrderGroup implements java.io.Serializable{
	private static final long serialVersionUID = 1276785722170408647L;
	private String GROUP_ID    ;
	private String GROUP_TYPE  ;
	private long   GROUP_AMOUNT;
	private long   GROUP_BY    ;
	public IOVOrderGroup() {
		super();
	}
	
	public IOVOrderGroup(IOVOrderGroup group ) {
		super();
		GROUP_ID     = group.GROUP_ID    ;
		GROUP_TYPE   = group.GROUP_TYPE  ;
		GROUP_AMOUNT = group.GROUP_AMOUNT;
		GROUP_BY     = group.GROUP_BY    ;
	}
	
	/**
	 * @return 用户组编号
	 */
	public String getGROUP_ID() {
		return GROUP_ID;
	}

	/**
	 * @param gROUP_ID 用户组编号
	 */
	public void setGROUP_ID(String gROUP_ID) {
		GROUP_ID = gROUP_ID;
	}

	/**
	 * @return 用户组类型
	 */
	public String getGROUP_TYPE() {
		return GROUP_TYPE;
	}

	/**
	 * @param gROUP_TYPE 用户组类型
	 */
	public void setGROUP_TYPE(String gROUP_TYPE) {
		GROUP_TYPE = gROUP_TYPE;
	}

	/**
	 * @return 用户组数量
	 */
	public long getGROUP_AMOUNT() {
		return GROUP_AMOUNT;
	}

	/**
	 * @param gROUP_AMOUNT 用户组数量
	 */
	public void setGROUP_AMOUNT(long gROUP_AMOUNT) {
		GROUP_AMOUNT = gROUP_AMOUNT;
	}

	/**
	 * @return 用户组定单序号
	 */
	public long getGROUP_BY() {
		return GROUP_BY;
	}

	/**
	 * @param gROUP_BY 用户组定单序号
	 */
	public void setGROUP_BY(long gROUP_BY) {
		GROUP_BY = gROUP_BY;
	}
	
}
