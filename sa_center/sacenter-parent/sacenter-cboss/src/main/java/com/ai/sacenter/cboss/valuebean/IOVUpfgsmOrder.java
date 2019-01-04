package com.ai.sacenter.cboss.valuebean;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.cboss.IUpfgsmConst;
import com.ai.sacenter.jdbc.HQSQLEntityBean;

public class IOVUpfgsmOrder extends IOVUpfgsmOffer{
	private static final long serialVersionUID = 8010988187933607903L;
	protected long   ORDER_ID	  ;
	protected long   OFFER_ID	  ;
	protected long   TASK_ID	  ;
	protected String BILL_ID	  ;
	protected String SUB_BILL_ID  ;
	protected String USER_STS	  ;
	protected long   STS	      ;
	public IOVUpfgsmOrder() {
		super();
	}
	
	public IOVUpfgsmOrder( DataStructInterface instance) throws Exception{
		super( instance );
		if( instance instanceof DataContainer ){
			DataContainer _instance = (DataContainer)instance;
			ORDER_ID    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.ORDER_ID    );
			OFFER_ID    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.OFFER_ID    );
			TASK_ID	    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.TASK_ID	  );
			BILL_ID	    = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.BILL_ID	  );
			SUB_BILL_ID = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.SUB_BILL_ID );
			USER_STS    = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.USER_STS    );
			STS         = _instance.getAsInt     ( IUpfgsmConst.IUpfwmCol.ORDER_STS   );
		}
		else if( instance instanceof HQSQLEntityBean ){
			HQSQLEntityBean _instance = (HQSQLEntityBean)instance;
			ORDER_ID    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.ORDER_ID    );
			OFFER_ID    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.OFFER_ID    );
			TASK_ID	    = _instance.getAsLong    ( IUpfgsmConst.IUpfwmCol.TASK_ID	  );
			BILL_ID	    = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.BILL_ID	  );
			SUB_BILL_ID = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.SUB_BILL_ID );
			USER_STS    = _instance.getAsString  ( IUpfgsmConst.IUpfwmCol.USER_STS    );
			STS         = _instance.getAsInt     ( IUpfgsmConst.IUpfwmCol.ORDER_STS   );
		}
		else{
			throw new java.lang.UnsupportedOperationException( instance.getClass().getName() );
		}
	}
	
	public IOVUpfgsmOrder( IOVUpfgsmOrder provision ) throws Exception{
		super( provision );
		ORDER_ID    = provision.getORDER_ID   ();
		OFFER_ID    = provision.getOFFER_ID   ();
		TASK_ID	    = provision.getTASK_ID    ();
		BILL_ID	    = provision.getBILL_ID    (); 
		SUB_BILL_ID = provision.getSUB_BILL_ID();
		USER_STS    = provision.getUSER_STS   ();
		STS	        = provision.getSTS	      ();
	}
	
	/**
	 * @return the oRDER_ID
	 */
	public long getORDER_ID() {
		return ORDER_ID;
	}
	
	/**
	 * 
	 * @param oRDER_ID
	 * @throws Exception
	 */
	public void setORDER_ID(long oRDER_ID) throws Exception{
		ORDER_ID = oRDER_ID;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.ORDER_ID, new Long( oRDER_ID ) ); }
	}
	
	/**
	 * @return the oFFER_ID
	 */
	public long getOFFER_ID() {
		return OFFER_ID;
	}
	
	/**
	 * 
	 * @param oFFER_ID
	 * @throws Exception
	 */
	public void setOFFER_ID(long oFFER_ID) throws Exception{
		OFFER_ID = oFFER_ID;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.OFFER_ID, new Long( oFFER_ID ) ); }
	}
	
	/**
	 * @return the tASK_ID
	 */
	public long getTASK_ID() {
		return TASK_ID;
	}
	
	/**
	 * 
	 * @param tASK_ID
	 * @throws Exception
	 */
	public void setTASK_ID(long tASK_ID) throws Exception{
		TASK_ID = tASK_ID;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.TASK_ID, new Long( tASK_ID ) ); }
	}
	
	/**
	 * @return the bILL_ID
	 */
	public String getBILL_ID() {
		return BILL_ID;
	}
	
	/**
	 * 
	 * @param bILL_ID
	 * @throws Exception
	 */
	public void setBILL_ID(String bILL_ID) throws Exception{
		BILL_ID = bILL_ID;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.BILL_ID, bILL_ID ); }
	}
	
	/**
	 * @return the sUB_BILL_ID
	 */
	public String getSUB_BILL_ID() {
		return SUB_BILL_ID;
	}
	
	/**
	 * 
	 * @param sUB_BILL_ID
	 * @throws Exception
	 */
	public void setSUB_BILL_ID(String sUB_BILL_ID) throws Exception{
		SUB_BILL_ID = sUB_BILL_ID;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.SUB_BILL_ID, sUB_BILL_ID ); }
	}
	
	
	/**
	 * @return the uSER_STS
	 */
	public String getUSER_STS() {
		return USER_STS;
	}

	/**
	 * 
	 * @param uSER_STS
	 * @throws Exception
	 */
	public void setUSER_STS(String uSER_STS) throws Exception{
		USER_STS = uSER_STS;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.USER_STS, uSER_STS ); }
	}

	/**
	 * @return the sTS
	 */
	public long getSTS() {
		return STS;
	}

	/**
	 * 
	 * @param sTS
	 * @throws Exception
	 */
	public void setSTS(long sTS) throws Exception{
		STS = sTS;
		if( _instance != null ){ _instance.set( IUpfgsmConst.IUpfwmCol.ORDER_STS, new Integer( (int)sTS )  ); }
	}
}
