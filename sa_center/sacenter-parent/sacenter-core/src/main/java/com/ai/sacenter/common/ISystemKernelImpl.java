package com.ai.sacenter.common;

import java.net.InetAddress;

import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 内核调度服务接口</p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ISystemKernelImpl extends UpdcEclipseImpl {
	public ISystemKernelImpl() {
		super();
	}
	/**
	 * 
	 * @param aObject
	 * @return
	 */
	public Object quote( Object aObject ){
		if( aObject == null || aObject instanceof java.lang.String == false )
			return aObject;
		else{
			String str = (String)aObject;
			StringBuilder aIRetnL = new StringBuilder();
			for( int index = 0 ; index < str.length() ; index++ ){
				char ch = str.charAt( index );
				switch( ch ){
				case '&':
					aIRetnL.append("&amp;");
					break;
				case '"':
					aIRetnL.append("&quot;");
					break;
				case '\'':
					aIRetnL.append("&apos;");
					break;
				case '<':
					aIRetnL.append("&lt;");
					break;
				case '>':
					aIRetnL.append("&gt;");
					break;
				default:
					aIRetnL.append(ch);
				}
			}
			return aIRetnL.toString();
		}
	}

    /**
     *
     * @param time
     * @param aformat
     * @return
     * @throws Exception
     */
	public String format( Object time , String aformat ) throws Exception{
		String aTime = null;
		try
		{
			aTime = TimeUtils.format( TimeUtils.getTime( time ), aformat );
		}
		finally{
			
		}
		return aTime;
	}
	
	/**
	 * 
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public String getSYSDATE( String format ) throws Exception{
		String fromSysdate = null;
		try
		{
			fromSysdate = TimeUtils.format( TimeUtils.getSysdate() , format);
		}
		finally{
			
		}
		return fromSysdate;
	}
	
	/**
	 * 
	 * @param aOPRTIME
	 * @param aFORMAT
	 * @return
	 * @throws Exception
	 */
	public String getSYSDATE( Object aOPRTIME , String aFORMAT ) throws Exception{
		String aSYSDATE = null;
		try
		{
			java.sql.Timestamp fromSysdate = TimeUtils.getTime( aOPRTIME );
			aSYSDATE = TimeUtils.format( fromSysdate, aFORMAT );
		}
		finally{
			
		}
		return aSYSDATE;
	}
	
	/**
	 * 获取当前时间,格式为YYYYMMDD
	 * @return
	 */
	public String getDAY(){
		String fromDAY = "";
		try
		{
			fromDAY = TimeUtils.yyyymmdd( TimeUtils.getSysdate() );
		}
		finally{
			
		}
		return fromDAY;
	}
	
	/**
	 * 获取当前日期后一天
	 * @return 获取当前日期后一天 yyyyMMdd
	 */
	public String getNEXTDAY(){
		String fromNextDay = "";
		try
		{
			fromNextDay = TimeUtils.yyyymmdd( TimeUtils.addDay( 
					TimeUtils.getSysdate(), 1 ) );
		}
		finally{
			
		}
		return fromNextDay;
	}
	
	/**
	 * 
	 * @param aBILL_ID
	 * @param aREGION_CODE
	 * @return
	 * @throws Exception
	 */
	public String getMSISDN( String aBILL_ID, String aREGION_CODE ) throws Exception{
		StringBuilder fromMsisdn = new StringBuilder();
		try
		{
			fromMsisdn.append( aBILL_ID );
			if( StringUtils.startWith( aREGION_CODE, "0" ) ){
				aREGION_CODE = StringUtils.substring( aREGION_CODE, 1 );
			}
			if( StringUtils.startWith( aBILL_ID, aREGION_CODE ) ){
				fromMsisdn.insert( 0, "0" );
			}
		}
		finally{
		
		}
		return fromMsisdn.toString();
	}
	
	/**
	 * 
	 * @param aBILL_ID
	 * @param aREGION_CODE
	 * @return
	 * @throws Exception
	 */
	public String getMSPSTN( String aBILL_ID, String aREGION_CODE ) throws Exception{
		StringBuilder fromREGION = new StringBuilder();
		try
		{
			fromREGION.append( aREGION_CODE );
			if( StringUtils.startWith( aBILL_ID, aREGION_CODE ) ){
				aBILL_ID = StringUtils.substring( aBILL_ID, aREGION_CODE.length() );
			}
			else{
				if( StringUtils.startWith( fromREGION.toString(), "0") == false ){
					fromREGION.insert( 0, "0" );
				}
				if( StringUtils.startWith( aBILL_ID, fromREGION.toString() ) ){
					aBILL_ID = StringUtils.substring( aBILL_ID, 
							fromREGION.toString().length() );
				}
			}
		}
		finally{
			if( fromREGION != null ){ fromREGION = null; }
		}
		return aBILL_ID;
	}
	
	/**
	 * 
	 * @param aZONENAME
	 * @param aOffset
	 * @param aCount
	 * @return
	 * @throws Exception
	 */
	public String getZONENAME( String aZONENAME, String aOffset , String aCount ) throws Exception{
		StringBuilder fromNAME = new StringBuilder();
		try
		{
			if( StringUtils.isBlank( aOffset ) == false ){ 
				aZONENAME = StringUtils.substring( aZONENAME, 
						Integer.parseInt( aOffset ), 
						Integer.parseInt( aCount ) );
			}
			for(int index = aZONENAME.length() - 1 ; index >= 0 ; index--){ 
				fromNAME.append( aZONENAME.charAt( index ) ).append(".");
			}
		}
		finally{
			
		}
		return fromNAME.toString();
	}
	
	/**
	 * 获取本地IP地址
	 * @return
	 */
	public String getHOST(){
		String fromOsHost = null;
		try
		{
			fromOsHost = InetAddress.getLocalHost().getHostAddress();
		}
		catch( java.lang.Exception aException ){
			fromOsHost = "127.0.0.1";
		}
		finally{
			
		}
		return fromOsHost;
	}
	
	/**
	 * 获取下月初时间
	 * @param _create_date
	 * @return
	 */
	public String getNEXTMONTH( Object _create_date ){
		String nextMonth = null;
		try
		{
			java.sql.Timestamp fromCREATE = TimeUtils.getTime( _create_date );
			nextMonth = TimeUtils.yyyymmddhhmmss( fromCREATE );
			if( TimeUtils.getActualMinday( fromCREATE ) != TimeUtils.getDay( fromCREATE ) ){
				java.sql.Timestamp _next_month = TimeUtils.getNextMonthStartDate( fromCREATE );
				nextMonth = TimeUtils.yyyymmddhhmmss( _next_month );
			}
		}
		finally{
			
		}
		return nextMonth;
	}
	
	/**
	 * 获取月末时间
	 * @param _create_date
	 * @return
	 */
	public String getYESTDAY( Object _create_date ){
		String yeatDay = null;
		try
		{
			java.sql.Timestamp fromCREATE = TimeUtils.getTime( _create_date );
			yeatDay = TimeUtils.yyyymmddhhmmss( fromCREATE );
			if( TimeUtils.getActualMaxday( fromCREATE ) != TimeUtils.getDay( fromCREATE ) ){
				java.sql.Timestamp _yester_day = TimeUtils.getYestDayStartDate( fromCREATE );
				yeatDay = TimeUtils.yyyymmddhhmmss( _yester_day );
			}
		}
		finally{
			
		}
		return yeatDay;
	}
}
