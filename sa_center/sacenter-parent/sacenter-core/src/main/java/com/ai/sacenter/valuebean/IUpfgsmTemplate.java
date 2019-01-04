package com.ai.sacenter.valuebean;

import com.ai.sacenter.base.platform.bo.ISAMisc;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��CBOSS�Խ����ù淶</p>
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
	 * <p>Description: CBOSS������ת��</p>
	 * <p>Copyright: Copyright (c) 2014-12-25</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgsmOffer implements java.io.Serializable{
		private static final long serialVersionUID = -8276288194216436892L;
		/*��Ԫ����*/
		private String ID;
		/*��Ԫ����*/
		private String NAME;
		/*ӳ���嵥*/
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
		 * @return ��Ԫ����
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * @param id ��Ԫ����
		 */
		public void setID(String id) {
			ID = id;
		}
		
		/**
		 * @return ��Ԫ����
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @param name ��Ԫ����
		 */
		public void setNAME(String name) {
			NAME = name;
		}
		
		/**
		 * @return ӳ���嵥
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
	 * <p>Description: CBOSS�����嵥</p>
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
