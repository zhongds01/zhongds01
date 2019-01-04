package com.ai.sacenter.common;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.util.UUID;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015Äê10ÔÂ30ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdcContextImpl extends java.util.HashMap implements IUpdcContext {
	private static final long serialVersionUID = -1948059863357806678L;
	private UUID ID = null;
	public IUpdcContextImpl() {
		super();
		ID = UUID.getUUID();
	}
	 
    public IUpdcContextImpl(java.util.Map map) {
        super( map );
        ID = UUID.getUUID();
    }
	
    /**
	 * @return the uUID
	 */
	public UUID getUUID() {
		return ID;
	}
	
	/**
	 * 
	 */
	public java.util.Map getMap( String fromKey) {
		return (java.util.Map)super.get( fromKey );
	}
}
