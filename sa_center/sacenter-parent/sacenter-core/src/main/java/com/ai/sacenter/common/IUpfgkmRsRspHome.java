package com.ai.sacenter.common;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 框架反馈类</p>
 * <p>Copyright: Copyright (c) 2014-4-23</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgkmRsRspHome implements java.io.Serializable{
	private static final long serialVersionUID = -7738112928384104263L;
	/*发起方*/
	private Object _objective = null;
	public IUpfgkmRsRspHome( Object objective ) {
		super();
		_objective = objective;
	}
	
	/**
	 * @return 发起方
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
}
