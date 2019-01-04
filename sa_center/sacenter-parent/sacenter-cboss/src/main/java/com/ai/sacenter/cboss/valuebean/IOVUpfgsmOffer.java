package com.ai.sacenter.cboss.valuebean;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.cboss.IUpfgsmConst;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.IUpdfmxLittle;

/**
 * <p>Title: sacenter-cboss</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018Äê4ÔÂ17ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfgsmOffer extends IUpdfmxLittle implements java.lang.Comparable,java.io.Serializable{
	private static final long serialVersionUID = -1935422400205636003L;
	protected long   SO_NBR	      ;
	protected String CATEGORY	  ;
	protected long   USER_ID	  ;
	protected java.sql.Timestamp CREATE_DATE;
	protected String REGION_ID    ;
	protected long   STOP_TYPE    ;
	protected long   SUB_PLAN_NO  ;
	protected java.sql.Timestamp ORDER_DATE ;
	public IOVUpfgsmOffer(){
		super();
	}
	
	public IOVUpfgsmOffer( DataStructInterface instance) throws Exception {
		super( instance );
		if( instance instanceof DataContainer ){
			DataContainer _instance = (DataContainer)instance;
			SO_NBR	    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.SO_NBR	  );
			CATEGORY    = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.CATEGORY    );
			USER_ID	    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.USER_ID	  );
			CREATE_DATE = _instance.getAsDateTime( IUpfgsmConst.IUpfwmCol.CREATE_DATE );
			REGION_ID   = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.REGION_ID   );
			STOP_TYPE   = _instance.getAsInt     ( IUpfgsmConst.IUpfwmCol.STOP_TYPE   );
			SUB_PLAN_NO = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.SUB_PLAN_NO );
			ORDER_DATE  = _instance.getAsDateTime( IUpfgsmConst.IUpfwmCol.ORDER_DATE  );
		}
		else if( instance instanceof HQSQLEntityBean ){
			HQSQLEntityBean _instance = (HQSQLEntityBean)instance;
			SO_NBR	    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.SO_NBR	  );
			CATEGORY    = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.CATEGORY    );
			USER_ID	    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.USER_ID	  );
			CREATE_DATE = _instance.getAsDateTime( IUpfgsmConst.IUpfwmCol.CREATE_DATE );
			REGION_ID   = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.REGION_ID   );
			STOP_TYPE   = _instance.getAsInt     ( IUpfgsmConst.IUpfwmCol.STOP_TYPE   );
			SUB_PLAN_NO = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.SUB_PLAN_NO );
			ORDER_DATE  = _instance.getAsDateTime( IUpfgsmConst.IUpfwmCol.ORDER_DATE  );
		}
		else{
			throw new java.lang.UnsupportedOperationException( instance.getClass().getName() );
		}
	}
	
	public IOVUpfgsmOffer( IOVUpfgsmOffer provision ) throws Exception{
		super( provision );
		SO_NBR	    = provision.getSO_NBR     ();
		CATEGORY    = provision.getCATEGORY   ();
		USER_ID	    = provision.getUSER_ID    ();
		CREATE_DATE = provision.getCREATE_DATE();
		REGION_ID   = provision.getREGION_ID  ();
		STOP_TYPE   = provision.getSTOP_TYPE  ();
		SUB_PLAN_NO = provision.getSUB_PLAN_NO();
		ORDER_DATE  = provision.getORDER_DATE ();
	}
	
	/**
	 * @return the sO_NBR
	 */
	public long getSO_NBR() {
		return SO_NBR;
	}
	
	/**
	 * 
	 * @param sO_NBR
	 * @throws Exception
	 */
	public void setSO_NBR(long sO_NBR) throws Exception{
		SO_NBR = sO_NBR;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.SO_NBR, new Long( sO_NBR ) ); }
	}
	
	/**
	 * @return the cATEGORY
	 */
	public String getCATEGORY() {
		return CATEGORY;
	}
	
	/**
	 * 
	 * @param cATEGORY
	 * @throws Exception
	 */
	public void setCATEGORY(String cATEGORY) throws Exception{
		CATEGORY = cATEGORY;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.CATEGORY, cATEGORY ); }
	}
	
	/**
	 * @return the uSER_ID
	 */
	public long getUSER_ID() {
		return USER_ID;
	}
	
	/**
	 * 
	 * @param uSER_ID
	 * @throws Exception
	 */
	public void setUSER_ID(long uSER_ID) throws Exception{
		USER_ID = uSER_ID;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.USER_ID, new Long( uSER_ID ) ); }
	}
	
	/**
	 * @return the cREATE_DATE
	 */
	public java.sql.Timestamp getCREATE_DATE() {
		return CREATE_DATE;
	}
	
	/**
	 * 
	 * @param cREATE_DATE
	 * @throws Exception
	 */
	public void setCREATE_DATE(java.sql.Timestamp cREATE_DATE) throws Exception{
		CREATE_DATE = cREATE_DATE;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.CREATE_DATE, cREATE_DATE ); }
	}

	/**
	 * @return the rEGION_ID
	 */
	public String getREGION_ID() {
		return REGION_ID;
	}

	/**
	 * 
	 * @param rEGION_ID
	 * @throws Exception
	 */
	public void setREGION_ID(String rEGION_ID) throws Exception{
		REGION_ID = rEGION_ID;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.REGION_ID, rEGION_ID ); }
	}

	/**
	 * @return the sTOP_TYPE
	 */
	public long getSTOP_TYPE() {
		return STOP_TYPE;
	}

	/**
	 * @param sTOP_TYPE the sTOP_TYPE to set
	 */
	public void setSTOP_TYPE(long sTOP_TYPE) throws Exception{
		STOP_TYPE = sTOP_TYPE;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.STOP_TYPE, new Integer( (int)sTOP_TYPE ) ); }
	}
	
	/**
	 * @return the sUB_PLAN_NO
	 */
	public long getSUB_PLAN_NO() {
		return SUB_PLAN_NO;
	}

	/**
	 * 
	 * @param sUB_PLAN_NO
	 * @throws Exception
	 */
	public void setSUB_PLAN_NO(long sUB_PLAN_NO) throws Exception{
		SUB_PLAN_NO = sUB_PLAN_NO;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.SUB_PLAN_NO, new Long( sUB_PLAN_NO ) ); }
	}

	/**
	 * @return the oRDER_DATE
	 */
	public java.sql.Timestamp getORDER_DATE() {
		return ORDER_DATE;
	}

	/**
	 * 
	 * @param oRDER_DATE
	 * @throws Exception
	 */
	public void setORDER_DATE(java.sql.Timestamp oRDER_DATE) throws Exception{
		ORDER_DATE = oRDER_DATE;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.ORDER_DATE, oRDER_DATE ); }
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		boolean _equals = objective != null && objective instanceof IOVUpfgsmOffer?true:false;
		if( _equals == true ){
			_equals = SO_NBR == ((IOVUpfgsmOffer)objective).SO_NBR;
		}
		return _equals;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long _compare = objective != null && objective instanceof IOVUpfgsmOffer?0:1;
		if( _compare == 0 ){ _compare = SO_NBR - ((IOVUpfgsmOffer)objective).SO_NBR; }
		return _compare == 0?0:(_compare > 0?1:-1);
	}
	
}
