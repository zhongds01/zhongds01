package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.receive.util.RocketUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 用户定单组</p>
 * <p>Copyright: Copyright (c) 2017年5月4日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFGroup implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = 2031094963210037267L;
	private String GROUP_ID    ;
	private String GROUP_TYPE  ;
	private long   GROUP_AMOUNT;
	private long   GROUP_BY    ;
	public IOVMsgFGroup() {
		super();
	}
	
	public IOVMsgFGroup(IOVMsgFGroup group ) {
		super();
		GROUP_ID     = group.GROUP_ID    ;
		GROUP_TYPE   = group.GROUP_TYPE  ;
		GROUP_AMOUNT = group.GROUP_AMOUNT;
		GROUP_BY     = group.GROUP_BY    ;
	}
	
	public IOVMsgFGroup( org.dom4j.Element _element ){
		super();
		GROUP_ID     = RocketUtils.IMetaX._jj_string ( _element, "UserGroupId"     );
		GROUP_TYPE   = RocketUtils.IMetaX._jj_string ( _element, "UserGroupType"   , true );
		GROUP_AMOUNT = RocketUtils.IMetaX._jj_long   ( _element, "UserGroupAmount" );
		GROUP_BY     = RocketUtils.IMetaX._jj_long   ( _element, "UserGroupBy"     );
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective == null || ( objective instanceof IOVMsgFGroup ) == false  ){
			return false;
		}
		IOVMsgFGroup group = (IOVMsgFGroup)objective;
		return StringUtils.equals( GROUP_ID, group.GROUP_ID ) && 
				StringUtils.equals( GROUP_TYPE, group.GROUP_TYPE );
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try 
		{
			doCompare = objective != null && objective instanceof IOVMsgFGroup ? 0 : 1;
			if (doCompare == 0) {
				IOVMsgFGroup group = (IOVMsgFGroup) objective;
				doCompare = GROUP_ID.compareTo( group.GROUP_ID );
				if( doCompare == 0 ){
					doCompare = GROUP_TYPE.compareTo( group.GROUP_TYPE );
				}
			}
		} 
		finally{

		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
	
}
