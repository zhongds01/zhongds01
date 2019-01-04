package com.ai.sacenter.provision.mstp.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.mstp.IUpfwmClient;
import com.ai.sacenter.provision.mstp.IUpfwmDefine;
import com.ai.sacenter.provision.mstp.IUpfwmMonitor;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmNetWork;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-1-27</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpfwmDefault implements IUpfwmClient,java.io.Serializable{
	private static final long serialVersionUID = -3866560377748071743L;
	private   UUID ID = null;
	protected IUpffmNetWork PLATFORM_;
	protected IUpfwmDefine NETWORK_;
	protected java.util.Map STUB_ = new java.util.HashMap();
	protected java.util.List MONITOR_ = new java.util.ArrayList();
	public UpfwmDefault( IUpffmNetWork fromUpfm , IUpfwmDefine fromNetWork) throws Exception{
		super();
		ID = UUID.getUUID();
		PLATFORM_ = fromUpfm;
		NETWORK_ = fromNetWork;
	}
	/**
	 * @return 客户端编码
	 */
	public UUID getID() {
		return ID;
	}
	/**
	 * @return 网路路由
	 */
	public IUpfwmDefine getNETWORK_() {
		return NETWORK_;
	}
	/**
	 * @return 网元配置
	 */
	public IUpffmNetWork getPLATFORM_() {
		return PLATFORM_;
	}
	/**
	 * @return 扩展属性
	 */
	public java.util.Map getSTUB_() {
		return STUB_;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmClient#isClientReady()
	 */
	public boolean isClientReady() {
		return false;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmClient#login(com.ai.sacenter.provision.mstp.IUpfwmMonitor)
	 */
	public void login(IUpfwmMonitor fromMonitor) throws SFException, Exception {
		try {
			if (MONITOR_.contains(fromMonitor) == false) {
				MONITOR_.add(fromMonitor);
			}
		} finally {

		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ai.sacenter.provision.mstp.IUpfwmClient#hbhbt()
	 */
	public void hbhbt() throws SFException, Exception {
		try {
			for (java.util.Iterator itera = MONITOR_.iterator(); itera
					.hasNext();) {
				IUpfwmMonitor fromMonitor = (IUpfwmMonitor) itera.next();
				fromMonitor.finishSFUpfwmHbhbt( this );
			}
		} finally {

		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.provision.mstp.IUpfwmClient#logout()
	 */
	public void logout() throws SFException, Exception {
		try {
			MONITOR_.clear();
		} finally {

		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 网元路由配置</p>
	 * <p>Copyright: Copyright (c) 2015-1-28</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmCauDefine extends IUpfwmDefine.IUpfwmCauDefine
			implements java.io.Serializable {
		private static final long serialVersionUID = 6684011458038767826L;
		public IUpfwmCauDefine( org.dom4j.Element aElement ) throws Exception{
			super( aElement );
		}
	}
}
