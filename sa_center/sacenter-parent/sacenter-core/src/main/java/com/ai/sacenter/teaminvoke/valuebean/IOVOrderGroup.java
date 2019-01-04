package com.ai.sacenter.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ���񶨵�Ⱥ</p>
 * <p>Copyright: Copyright (c) 2017��7��25��</p>
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
	 * @return �û�����
	 */
	public String getGROUP_ID() {
		return GROUP_ID;
	}

	/**
	 * @param gROUP_ID �û�����
	 */
	public void setGROUP_ID(String gROUP_ID) {
		GROUP_ID = gROUP_ID;
	}

	/**
	 * @return �û�������
	 */
	public String getGROUP_TYPE() {
		return GROUP_TYPE;
	}

	/**
	 * @param gROUP_TYPE �û�������
	 */
	public void setGROUP_TYPE(String gROUP_TYPE) {
		GROUP_TYPE = gROUP_TYPE;
	}

	/**
	 * @return �û�������
	 */
	public long getGROUP_AMOUNT() {
		return GROUP_AMOUNT;
	}

	/**
	 * @param gROUP_AMOUNT �û�������
	 */
	public void setGROUP_AMOUNT(long gROUP_AMOUNT) {
		GROUP_AMOUNT = gROUP_AMOUNT;
	}

	/**
	 * @return �û��鶨�����
	 */
	public long getGROUP_BY() {
		return GROUP_BY;
	}

	/**
	 * @param gROUP_BY �û��鶨�����
	 */
	public void setGROUP_BY(long gROUP_BY) {
		GROUP_BY = gROUP_BY;
	}
	
}
