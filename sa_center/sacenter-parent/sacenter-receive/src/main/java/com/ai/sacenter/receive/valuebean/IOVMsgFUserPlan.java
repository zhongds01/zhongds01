package com.ai.sacenter.receive.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: �û������߻�</p>
 * <p>Copyright: Copyright (c) 2017��4��25��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFUserPlan extends IOVMsgFPlan implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = 3456604342858556656L;
	public IOVMsgFUserPlan() {
		super();
	}
	
	public IOVMsgFUserPlan( IOVMsgFPlan fromPlot ){
		super( fromPlot );
	}
	
	public IOVMsgFUserPlan(IOVMsgFUserPlan fromPlan ) {
		super( fromPlan );
	}
	
	public IOVMsgFUserPlan(IOVMsgFUser fromUser, org.dom4j.Element element ){
		super( fromUser, element );
	}

}
