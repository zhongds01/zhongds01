package com.ai.sacenter.common;

import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.module.model.UpdcLifeCycle;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * @author Administrator
 * 即开即通环境变量初始化
 */
public class IJEnvicLInitImpl extends UpdcLifeCycle {
    public IJEnvicLInitImpl() {
		super();
	}

    /*
     * (non-Javadoc)
     * @see com.ai.sacenter.module.model.UpdcLifeCycle#initalize(com.ai.sacenter.module.IConfigDefine.IModuleDefine.IModuleIDefine.IInitalizeDefine)
     */
	public void initalize(IConfigDefine.IModuleDefine.IModuleIDefine.IInitalizeDefine aInitalize) throws Exception {
		java.util.Map aUpdsmLife = new java.util.HashMap();
		try
		{
			if( aInitalize.getCONFIG() != null ){
				JdomUtils._getISTKJdomL( aInitalize.getCONFIG().asXML() , aUpdsmLife );
				 ClassUtils.IMerge.merge( aUpdsmLife , IConfigDefine.getINSTANCE().getConfigItem().getGRAPHICS() );
				 for( java.util.Iterator itera = aUpdsmLife.entrySet().iterator() ;  itera.hasNext() ;){
				 	 java.util.Map.Entry e = (java.util.Map.Entry)itera.next();
					 if( e.getValue() != null && e.getValue() instanceof java.lang.String && 
						StringUtils.isBlank( e.getValue().toString() ) == false ){
						 System.setProperty( e.getKey().toString() , e.getValue().toString() );
					 }
				 }
			}
		}
		finally{
			if( aUpdsmLife != null ){ aUpdsmLife.clear(); aUpdsmLife = null; }
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-10-27</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IJExprcLInitImpl extends UpdcLifeCycle{
		public IJExprcLInitImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.model.UpdcLifeCycle#initalize(com.ai.sacenter.module.IConfigDefine.IModuleDefine.IModuleIDefine.IInitalizeDefine)
		 */
		public void initalize(IConfigDefine.IModuleDefine.IModuleIDefine.IInitalizeDefine aInitalize) throws Exception {
			if( aInitalize.getCONFIG() == null ) return;
			JdomUtils._getISTKJdomL( aInitalize.getCONFIG().asXML() , IConfigDefine.getINSTANCE().getConfigItem().getCOMPLEX() );
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2012-4-20</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ICenterLInitImpl extends UpdcLifeCycle{
		public ICenterLInitImpl(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.module.model.UpdcLifeCycle#initalize(com.ai.sacenter.module.IConfigDefine.IModuleDefine.IModuleIDefine.IInitalizeDefine)
		 */
		public void initalize(IConfigDefine.IModuleDefine.IModuleIDefine.IInitalizeDefine aInitalize) throws Exception {
			if( aInitalize.getCONFIG() == null ) return;
			IConfigDefine.getINSTANCE().getCenter()._submitJEnvic( aInitalize.getCONFIG() );
		}
	}
}