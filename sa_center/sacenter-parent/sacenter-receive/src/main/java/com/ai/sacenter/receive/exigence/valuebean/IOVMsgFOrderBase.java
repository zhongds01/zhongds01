package com.ai.sacenter.receive.exigence.valuebean;

import com.ai.sacenter.receive.order.valuebean.IOVRocketExigence;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通异步定单项</p>
 * <p>Copyright: Copyright (c) 2017年5月5日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFOrderBase extends IOVRocketExigence implements java.io.Serializable{
	private static final long serialVersionUID = -959955380067858228L;
	public IOVMsgFOrderBase() throws Exception{
		super();
	}
	
	public IOVMsgFOrderBase( org.dom4j.Element fromCustOrder, org.dom4j.Element fromOrderItem ) throws Exception{
		super( fromCustOrder, fromOrderItem );
	}
	
	public IOVMsgFOrderBase( IOVMsgFOrderBase fromSRC ) throws Exception{
		super( fromSRC );
	}
}
