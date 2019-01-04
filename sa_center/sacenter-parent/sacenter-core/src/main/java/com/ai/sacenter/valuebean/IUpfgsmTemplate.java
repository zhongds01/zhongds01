package com.ai.sacenter.valuebean;

import com.ai.sacenter.base.platform.bo.ISAMisc;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 与CBOSS对接配置规范</p>
 * <p>Copyright: Copyright (c) 2014-12-25</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgsmTemplate {

	public IUpfgsmTemplate() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: CBOSS测属性转换</p>
	 * <p>Copyright: Copyright (c) 2014-12-25</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgsmOffer implements java.io.Serializable{
		private static final long serialVersionUID = -8276288194216436892L;
		/*网元编码*/
		private String ID;
		/*网元描述*/
		private String NAME;
		/*映射清单*/
		private java.util.ArrayList COMPETENCE = new java.util.ArrayList();
		public IUpfgsmOffer(){
			super();
		}
		
		public IUpfgsmOffer( ISAMisc _miscdefine ){
			super();
			ID   = _miscdefine.getPlatform();
			NAME = _miscdefine.getProvider(); 
		}
		
		/**
		 * @return 网元编码
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * @param id 网元编码
		 */
		public void setID(String id) {
			ID = id;
		}
		
		/**
		 * @return 网元描述
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param name 网元描述
		 */
		public void setNAME(String name) {
			NAME = name;
		}
		
		/**
		 * @return 映射清单
		 */
		public java.util.ArrayList getCOMPETENCE() {
			return COMPETENCE;
		}
		
		/**
		 * 
		 * @param _mapping
		 * @return
		 */
		public IUpfgsmxOffer getMAPPING( String _mapping ){
			IUpfgsmxOffer __catalog = null;
			try
			{
				for( java.util.Iterator itera = COMPETENCE.iterator(); itera.hasNext(); ){
					IUpfgsmxOffer _miscdefine = (IUpfgsmxOffer)itera.next();
					if( _miscdefine.getMAPPING().equals( _mapping ) ){
						__catalog = _miscdefine;
						break;
					}
				}
			}
			finally{
				
			}
			return __catalog;
		}
		
		/**
		 * 
		 * @param _miscdefine
		 */
		public void mergeAsMisc( ISAMisc _miscdefine ){
			try
			{
				COMPETENCE.add( new IUpfgsmxOffer( _miscdefine ) );
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: CBOSS属性清单</p>
	 * <p>Copyright: Copyright (c) 2014-12-25</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgsmxOffer extends ISystemTemplate.IUpfgsmxOffer implements java.io.Serializable{
		private static final long serialVersionUID = -7274355813909838203L;
		private String PLATFORM     ;
		private String PROVIDER     ;
		public IUpfgsmxOffer( ISAMisc fromMisc ){
			super();
			ID            = String.valueOf( fromMisc.getId() );
			NAME          = fromMisc.getName                ();
			PLATFORM      = fromMisc.getPlatform            ();
			COMPETE       = fromMisc.getCompete             ();
			SORT_BY       = fromMisc.getSortBy              ();
			MAPPING       = fromMisc.getMapping             ();
			COMPLEX       = fromMisc.getComplex             ();
			PROVIDER      = fromMisc.getProvider            ();
		}
		
		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}
		
		/**
		 * @param platform the pLATFORM to set
		 */
		public void setPLATFORM(String platform) {
			PLATFORM = platform;
		}
		
		/**
		 * @return the pROVIDER
		 */
		public String getPROVIDER() {
			return PROVIDER;
		}
		
		/**
		 * @param provider the pROVIDER to set
		 */
		public void setPROVIDER(String provider) {
			PROVIDER = provider;
		}
	}
}
