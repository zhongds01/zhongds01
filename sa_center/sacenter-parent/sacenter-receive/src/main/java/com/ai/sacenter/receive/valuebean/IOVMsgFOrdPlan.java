package com.ai.sacenter.receive.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ���������߻�</p>
 * <p>Copyright: Copyright (c) 2018��3��13��</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class IOVMsgFOrdPlan extends IOVMsgFPlan implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = 6583762850888257781L;
	public IOVMsgFOrdPlan() {
		super();
	}

	public IOVMsgFOrdPlan(IOVMsgFPlan fromPlot) {
		super(fromPlot);
	}

	public IOVMsgFOrdPlan(IOVMsgFOrdPlan fromPlan ) {
		super( fromPlan );
	}
	
	public IOVMsgFOrdPlan(IOVMsgFUser fromUser, org.dom4j.Element element) {
		super(fromUser, element);
	}

}
