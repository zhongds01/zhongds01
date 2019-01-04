package com.ai.sacenter.receive.exigence.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通主定单项</p>
 * <p>Copyright: Copyright (c) 2018年3月1日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class IOVMsgFOrderMain extends IOVMsgFOrderBase {
	private static final long serialVersionUID = -1353214598189417626L;
	public IOVMsgFOrderMain() throws Exception {
		super();
	}

	public IOVMsgFOrderMain(org.dom4j.Element fromCustOrder, org.dom4j.Element fromOrderItem) throws Exception {
		super(fromCustOrder, fromOrderItem);
	}

	public IOVMsgFOrderMain(IOVMsgFOrderBase fromSRC) throws Exception {
		super(fromSRC);
	}

	public IOVMsgFOrderMain(IOVMsgFOrderMain fromSRC) throws Exception {
		super(fromSRC);
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.valuebean.IOVRocketExigence#isCOMPETENCE()
	 */
	public boolean isCOMPETENCE() throws Exception {
		return true;
	}

}
