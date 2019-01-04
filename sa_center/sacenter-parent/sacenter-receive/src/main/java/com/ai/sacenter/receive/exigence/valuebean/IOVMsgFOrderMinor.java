package com.ai.sacenter.receive.exigence.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通次要定单项</p>
 * <p>Copyright: Copyright (c) 2018年3月1日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class IOVMsgFOrderMinor extends IOVMsgFOrderBase {
	private static final long serialVersionUID = -2796825553365678500L;
	public IOVMsgFOrderMinor() throws Exception {
		super();
	}

	public IOVMsgFOrderMinor(org.dom4j.Element fromCustOrder, org.dom4j.Element fromOrderItem) throws Exception {
		super(fromCustOrder, fromOrderItem);
	}

	public IOVMsgFOrderMinor(IOVMsgFOrderBase fromSRC) throws Exception {
		super(fromSRC);
	}

	public IOVMsgFOrderMinor(IOVMsgFOrderMinor fromSRC) throws Exception {
		super(fromSRC);
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.valuebean.IOVRocketExigence#isCOMPETENCE()
	 */
	public boolean isCOMPETENCE() throws Exception {
		return false;
	}
}
