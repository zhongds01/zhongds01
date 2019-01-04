package com.ai.sacenter.util;

import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: 日期处理类</p>
 * <p>Copyright: Copyright (c) 2014-3-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class TimeUtils {
	
	public TimeUtils() {
		super();
	}
	
	/**
	 * 
	 * @param format
	 * @return
	 */
	public static String format( String format ){
		return format( getSysdate(), format ); 
	}
	
	/**
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String format( java.util.Date time , String format){
		java.text.DateFormat DateFormat = new java.text.SimpleDateFormat( format );
		return DateFormat.format( time );
	}
	
	/**
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static java.sql.Timestamp format( String str , String format ){
		try
	    {
			java.text.DateFormat DateFormat = new java.text.SimpleDateFormat( format );
	        return new java.sql.Timestamp( DateFormat.parse( str ).getTime() );
	    }
	    catch( java.lang.Exception e){
	    	throw new java.lang.RuntimeException(e);
	    }
	}
	
	/**
	 * 
	 * @return
	 */
	public static java.sql.Timestamp getSysdate(){
		java.sql.Timestamp __sysdate = null;
		try
		{
			MBeanDelegate fromMBean = null;
			if( UpfsvcManager.getBlankMBean() != null ){
				fromMBean = UpfsvcManager.getMBean().getQuality();
			}
			if( fromMBean != null && fromMBean.getCREATE() != null ){
				__sysdate = fromMBean.getCREATE();
			}
			else{
				__sysdate = BasicFactory.getIBaseSV().getSysdate();
			}
		}
		catch( java.lang.Exception aEXCEPTION ){
			__sysdate = new java.sql.Timestamp( System.currentTimeMillis() );
		}
		finally{
			
		}
		return __sysdate;
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static java.sql.Timestamp getTime( Object time ){
		java.sql.Timestamp _time = null;
		if( time == null ){
			_time = new java.sql.Timestamp( System.currentTimeMillis() );
		}
		else if( time instanceof java.sql.Timestamp ){
			 _time = (java.sql.Timestamp)time;
		}
		else if( time instanceof java.util.Date ){
			_time = new java.sql.Timestamp( ((java.util.Date)time).getTime() );
		}
		else if( time instanceof java.lang.String ){
			String string = (String)time;
			if( string.equals( "NULL" ) || string.equals( "'NULL'" ) ){
				_time = new java.sql.Timestamp( System.currentTimeMillis() );
			}
			else{
				_time = TimeUtils.getTimestamp( string );
			}
		}
		else if( time instanceof java.lang.Number){
			java.lang.Number _number = (java.lang.Number)time;
			_time = new java.sql.Timestamp( _number.longValue() );
		}
		else{
			_time = new java.sql.Timestamp( System.currentTimeMillis() );
		}
		return _time;
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static java.sql.Timestamp getTimestamp( String time ){
		java.sql.Timestamp fromTimestamp = null;
		if( StringUtils.wildcardMatch( (String)time , "????-??-??" ) )
			fromTimestamp = format( (String)time, "yyyy-MM-dd" );
		else if( StringUtils.wildcardMatch( (String)time , "????/??/??" ) )
			fromTimestamp = format( (String)time, "yyyy/MM/dd" );
		else if( StringUtils.wildcardMatch( (String)time , "????-??-?? ??:??:??" ) ||
				StringUtils.wildcardMatch( (String)time , "????-??-?? ??:??:??.*" ))
	        fromTimestamp = format( (String)time , "yyyy-MM-dd HH:mm:ss" );
		else if( StringUtils.wildcardMatch( (String)time , "????/??/?? ??:??:??" ) )
			fromTimestamp = format( (String)time , "yyyy/MM/dd HH:mm:ss" );
		else if( ((String)time).length() == "yyyyMMdd".length() )
			fromTimestamp = format( (String)time , "yyyyMMdd" );
		else	  
			fromTimestamp = format( (String)time , "yyyyMMddHHmmss" );
		return fromTimestamp;
	}
	
	/**
	 * 当前时间增加年
	 * @param time
	 * @param aYears
	 * @return
	 */
	public static java.sql.Timestamp addYear( java.sql.Timestamp time , int aYears ){
	  java.util.GregorianCalendar cal = getCalendar( time );
	  cal.add(java.util.GregorianCalendar.YEAR, aYears );
	  return new java.sql.Timestamp( cal.getTimeInMillis() );
	}
    
	/**
	 * 获取当前时间年份
	 * @param time
	 * @return
	 */
	public static int getYear( java.sql.Timestamp time ){
		java.util.Calendar calendar = getCalendar(time);
		return calendar.get( java.util.Calendar.YEAR );
	}
	
	/**
	 * 当前时间增加月份
	 * @param time
	 * @param aMonth
	 * @return
	 */
	public static java.sql.Timestamp addMonth( java.sql.Timestamp time , int aMonth ){
		java.util.GregorianCalendar cal = getCalendar( time );
	    cal.add(java.util.GregorianCalendar.MONTH, aMonth );
	    return new java.sql.Timestamp( cal.getTimeInMillis() );
	}
	
	/**
	 * 获取当前月份
	 * @param time
	 * @return
	 */
	public static int getMonth( java.sql.Timestamp time ){
		java.util.Calendar calendar = getCalendar(time);
		return calendar.get( java.util.Calendar.MONTH ) + 1;
	}
	
	/**
	 * 当前时间增加天数
	 * @param time
	 * @param aDays
	 * @return
	 */
	public static java.sql.Timestamp addDay( java.sql.Timestamp time , int aDays ){
		java.util.GregorianCalendar cal = getCalendar( time );
	    cal.add(java.util.GregorianCalendar.DAY_OF_MONTH, aDays );
	    return new java.sql.Timestamp( cal.getTimeInMillis() );
	}
	
	/**
	 * 获取当前月份天数
	 * @param time
	 * @return
	 */
	public static int getDay( java.sql.Timestamp time ){
		java.util.GregorianCalendar cal = getCalendar( time );
		return cal.get( java.util.GregorianCalendar.DAY_OF_MONTH );
	}
	
	/**
	 * 获取当前年天数
	 * @param time
	 * @return
	 */
	public static int getDayOfYear( java.sql.Timestamp time ){
		java.util.GregorianCalendar cal = getCalendar( time );
		return cal.get( java.util.GregorianCalendar.DAY_OF_YEAR );
	}
	
	/**
	 * 当前时间增加小时数
	 * @param time
	 * @param aHours
	 * @return
	 */
	public static java.sql.Timestamp addHour( java.sql.Timestamp time , int aHours ){
		java.util.GregorianCalendar cal = getCalendar( time );
	    cal.add(java.util.GregorianCalendar.HOUR, aHours );
	    return new java.sql.Timestamp( cal.getTimeInMillis() );
	}
	
	/**
	 * 获取当前时间小时
	 * @param time
	 * @return
	 */
	public static int getHour( java.sql.Timestamp time ){
		java.util.GregorianCalendar cal = getCalendar( time );
		return cal.get( java.util.GregorianCalendar.HOUR_OF_DAY );
	}
	
	/**
	 * 当前时间增加分钟数
	 * @param time
	 * @param aMinutes
	 * @return
	 */
	public static java.sql.Timestamp addMinute( java.sql.Timestamp time , int aMinutes ){
		java.util.GregorianCalendar cal = getCalendar( time );
	    cal.add( java.util.GregorianCalendar.MINUTE, aMinutes );
	    return new java.sql.Timestamp( cal.getTime().getTime() );
	}
	
	/**
	 * 获取当前时间分钟数
	 * @param time
	 * @return
	 */
	public static int getMinute( java.sql.Timestamp time ){
		java.util.GregorianCalendar cal = getCalendar( time );
		return cal.get( java.util.GregorianCalendar.MINUTE );
	}
	
	/**
	 * 当前时间增加秒数
	 * @param time
	 * @param aSeconds
	 * @return
	 */
	public static java.sql.Timestamp addSecond( java.sql.Timestamp time , int aSeconds ){
		java.util.GregorianCalendar cal = getCalendar( time );
	    cal.add( java.util.GregorianCalendar.SECOND, aSeconds );
	    return new java.sql.Timestamp( cal.getTime().getTime() );
	}
	
	/**
	 * 获取当前时间分钟数
	 * @param time
	 * @return
	 */
	public static int getSecond( java.sql.Timestamp time ){
		java.util.GregorianCalendar cal = getCalendar( time );
		return cal.get( java.util.GregorianCalendar.SECOND );
	}
	
	/**
	 * 当前时间增加毫秒数
	 * @param time
	 * @param aMillisecond
	 * @return
	 */
	public static java.sql.Timestamp addMilliSecond( java.sql.Timestamp time , int aMillisecond ){
		java.util.GregorianCalendar cal = getCalendar( time );
	    cal.add( java.util.GregorianCalendar.MILLISECOND, aMillisecond );
	    return new java.sql.Timestamp( cal.getTime().getTime() );
	}
	
	/**
	 * 获取当前时间毫秒数
	 * @param time
	 * @return
	 */
	public static int getMilliSecond( java.sql.Timestamp time ){
		java.util.GregorianCalendar cal = getCalendar( time );
		return cal.get( java.util.GregorianCalendar.MILLISECOND );
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long diffYear( java.sql.Timestamp time1 , java.sql.Timestamp time2 ){
		java.util.GregorianCalendar aCalendar1 = getCalendar( time1 );
		java.util.GregorianCalendar aCalendar2 = getCalendar( time2 );
		return aCalendar1.get( java.util.GregorianCalendar.YEAR ) - aCalendar2.get( java.util.GregorianCalendar.YEAR );
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long diffMonth( java.sql.Timestamp time1 , java.sql.Timestamp time2 ){
		java.util.GregorianCalendar aCalendar1 = getCalendar( time1 );
		java.util.GregorianCalendar aCalendar2 = getCalendar( time2 );
		return (aCalendar1.get( java.util.GregorianCalendar.YEAR ) - aCalendar2.get( java.util.GregorianCalendar.YEAR )) * 12 + 
		             (aCalendar1.get( java.util.GregorianCalendar.MONTH ) - aCalendar2.get( java.util.GregorianCalendar.MONTH ));
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long diffDay( java.sql.Timestamp time1 , java.sql.Timestamp time2 ){
		return (time1.getTime() - time2.getTime() )/24/60/60/1000;
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long diffHour( java.sql.Timestamp time1 , java.sql.Timestamp time2 ){
		return (time1.getTime() - time2.getTime() )/60/60/1000;
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long diffMinute( java.sql.Timestamp time1 , java.sql.Timestamp time2 ){
		return (time1.getTime() - time2.getTime())/60/1000;
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long milliSecond( java.sql.Timestamp time1 , java.sql.Timestamp time2 ){
		return time1.getTime() - time2.getTime();
	}
	
	/**
	 * 
	 * @param aIBookingTime
	 * @return
	 */
	public static java.sql.Timestamp getDelay1Month( java.sql.Timestamp aIBookingTime ){
		java.sql.Timestamp aBOOKING = addMonth( aIBookingTime , 1 );
		String temp = yyyymm( aBOOKING )+"01005959";
		return format( temp , "yyyyMMddHHmmss");
	}
	
	/**
	 * 加20分钟精确到小时维度
	 * @param aExpire
	 * @return
	 */
	public static java.sql.Timestamp expire( java.sql.Timestamp aExpire ){
		StringBuilder fromExpire = new StringBuilder();
		try
		{
			aExpire = TimeUtils.addMinute( aExpire , 20 );
			fromExpire.append( format( aExpire , "yyyyMMddHH") )
			          .append("0001");
			aExpire = format( fromExpire.toString(), "yyyyMMddHHmmss");
		}
		finally{
			
		}
		return aExpire;
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static String yyyymm(java.sql.Timestamp time){
		return format( time , "yyyyMM" );
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static String yyyymm(java.util.Date time){
		return format( time , "yyyyMM" );
	}
	
	/**
	 * 日期转换为yyyyMMddHHmmss
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public static String yyyymmddhhmmss( java.sql.Timestamp time){
		return format( time , "yyyyMMddHHmmss");
	}
	
	/**
	 * 
	 * @param aTime
	 * @return
	 */
	public static java.sql.Timestamp yyyymmddhhmmss( String aTime ){
		java.sql.Timestamp rtn = null;
		if( aTime != null ) rtn = format( aTime , "yyyy-MM-dd HH:mm:ss");
		return rtn;
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public static String yymmddhhmm( java.sql.Timestamp time ){
		return format( time , "yyMMddHHmm" );
	}
	
	/**
	 * 日期转换为yyyyMMddHH
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public static String yyyymmddhh( java.sql.Timestamp time ){
	  	return format( time , "yyyyMMddHH"); 
	}
	
	/**
	 * 日期转换为yyyyMMdd
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public static String yyyymmdd( java.sql.Timestamp time ){
	  	return format( time , "yyyyMMdd"); 
	}
	
	/**
	 * 日期转换为yyyyMMdd
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public static String yyyymmdd( java.util.Date time ){
		return format( time , "yyyyMMdd"); 
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static long yyyy( java.sql.Timestamp time ){
	  	return Long.parseLong( format( time , "yyyy") );
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static String yyyy( java.util.Date time ){
	  	return format( time , "yyyy");
	}
	
	/**
	 * 判断年月日是否相等
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 * @throws Exception
	 */
	public static boolean equalYYYYMMDD(java.sql.Timestamp time1,
			java.sql.Timestamp time2) {
		return yyyymmdd(time1).equals(yyyymmdd(time2));
	}
	
	/**
	 * 判断时间是否相等
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 * @throws Exception
	 */
	public static boolean equal(java.sql.Timestamp time1,
			java.sql.Timestamp time2) {
		return yyyymmddhhmmss(time1).equals(yyyymmddhhmmss(time2));
	}

	/**
	 * 判断是否time1大于time2
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 * @throws Exception
	 */
	public static boolean greater(java.sql.Timestamp time1,
			java.sql.Timestamp time2) {
		return time1.compareTo(time2) > 0 ? true : false;
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 * @throws Exception
	 */
	public static boolean greaterEqual(java.sql.Timestamp time1,
			java.sql.Timestamp time2) {
		return time1.compareTo(time2) >= 0 ? true : false;
	}
	
	/**
	 * 判断时间(年月日)time1大于time2
	 * @param time1
	 * @param time2
	 * @return
	 * @throws Exception
	 */
	public static boolean greaterYYYYMMDD(java.sql.Timestamp time1,
			java.sql.Timestamp time2) {
		return yyyymmdd(time1).compareTo(yyyymmdd(time2)) > 0 ? true : false;
	}

	/**
	 * 判断时间(年月日小时)time1大于time2
	 * @param time1
	 * @param time2
	 * @return
	 * @throws Exception
	 */
	public static boolean greaterYYYYMMDDHH(java.sql.Timestamp time1,
			java.sql.Timestamp time2) {
		return yyyymmddhh(time1).compareTo(yyyymmddhh(time2)) > 0 ? true : false;
	}
	
	/**
	 * 判断时间无穷大 规则time在年上减去aSysdate在年大于5年则认为无穷大
	 * @param time
	 * @param aSysdate
	 * @return
	 * @throws Exception
	 */
	public static boolean infiniteYYYY(java.sql.Timestamp time,
			java.sql.Timestamp aSysdate) {
		return yyyy(time) - yyyy(aSysdate) > 10 ? true : false;
	}
	
	/**
	 * 判断时间(年月日)time1小于等于time2
	 * @param time1
	 * @param time2
	 * @return
	 * @throws Exception
	 */
	public static boolean lessEqualYYYYMMDD(java.sql.Timestamp time1,
			java.sql.Timestamp time2) {
		return greaterYYYYMMDD(time1, time2) ? false : true;
	}
	
	/**
	 * 
	 * @param aValidDate
	 * @param aIOpenSVDate
	 * @param aExpiredate
	 * @return
	 */
	public static boolean middle(java.sql.Timestamp aValidDate,
			java.sql.Timestamp aIOpenSVDate, java.sql.Timestamp aExpiredate) {
		return aValidDate.compareTo(aIOpenSVDate) < 0
				&& aExpiredate.compareTo(aIOpenSVDate) > 0 ? true : false;
	}
	
	/**
	 * 
	 * @param aValidDate
	 * @param aIOpenSVDate
	 * @param aExpiredate
	 * @return
	 */
	public static boolean middle(String aValidDate, String aIOpenSVDate,
			String aExpiredate) {
		return aValidDate.compareTo(aIOpenSVDate) <= 0
				&& aExpiredate.compareTo(aIOpenSVDate) >= 0 ? true : false;
	}
	
	/**
	 * 获取到期时间
	 * @param aExpire
	 * @return
	 */
	public static String getAsExpire( java.sql.Timestamp aExpire ){
		return format( aExpire , "yyyyMMddHH");
	}
	
	/**
	 * 根据到期时间转换为到期时间
	 * @param aEXPIRE 到期时间
	 * @return
	 */
	public static java.sql.Timestamp getAsExpire( long aEXPIRE ){
		java.sql.Timestamp _expire = null;
		try
		{
			_expire = addSecond( format( String.valueOf(aEXPIRE), 
					                     "yyyyMMddHH" ), 
					1 );
		}
		finally{
			
		}
		return _expire;
	}
	
	/**
	 * 获取当前年内秒数
	 * @return
	 */
	public static long getAsTime(){
		long aSeconds = 0;
		try
		{
			aSeconds = TimeUtils.getAsTime( new java.sql.Timestamp( 
					System.currentTimeMillis() ) );
		}
		finally{
			
		}
		return aSeconds;
	}
	
	/**
	 * 获取当前年内秒数
	 * @param time
	 * @return
	 */
	public static long getAsTime( java.sql.Timestamp time ){
		long aSeconds = 0;
		try
		{
			java.util.Calendar calendar = getCalendar( time );
			aSeconds = ( calendar.get( java.util.Calendar.DAY_OF_YEAR ) - 1 ) * 24 *3600 +
					calendar.get( java.util.Calendar.HOUR ) * 3600 + 
					calendar.get( java.util.Calendar.MINUTE ) * 60 +
					calendar.get( java.util.Calendar.SECOND );
		}
		finally{
			
		}
		return aSeconds;
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static boolean isActualMiddle(java.sql.Timestamp time) {
		java.util.Calendar calendar = getCalendar(time);
		int aDAY = calendar.get(java.util.Calendar.DAY_OF_MONTH);
		return aDAY == calendar
				.getActualMaximum(java.util.Calendar.DAY_OF_MONTH)
				|| aDAY == calendar
						.getActualMinimum(java.util.Calendar.DAY_OF_MONTH)
								? false
								: true;
	}
	
	/**
	 * 当前时间月最大天数
	 * @param time
	 * @return
	 */
	public static int getActualMaxday(java.sql.Timestamp time) {
		java.util.Calendar calendar = getCalendar(time);
		return calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 当前时间月最小天数
	 * @param time
	 * @return
	 */
	public static int getActualMinday(java.sql.Timestamp time) {
		java.util.Calendar calendar = getCalendar(time);
		return calendar.getActualMinimum(java.util.Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 当前月最大毫秒数
	 * @param time
	 * @return
	 */
	public static java.sql.Timestamp getActualMaxtime(java.sql.Timestamp time) {
		java.util.Calendar calendar = getCalendar(time);
		calendar.set(java.util.GregorianCalendar.DAY_OF_MONTH,
				calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH));
		calendar.set(java.util.GregorianCalendar.HOUR_OF_DAY,
				calendar.getActualMaximum(java.util.Calendar.HOUR_OF_DAY));
		calendar.set(java.util.GregorianCalendar.SECOND,
				calendar.getActualMaximum(java.util.Calendar.SECOND));
		calendar.set(java.util.GregorianCalendar.MINUTE,
				calendar.getActualMaximum(java.util.Calendar.MINUTE));
		calendar.set(java.util.GregorianCalendar.MILLISECOND, 0);
		return new java.sql.Timestamp(calendar.getTimeInMillis());
	}
	
	/**
	 * 计算小时数
	 * @param aDayHour,格式为DDHH或-DDHH
	 * @return
	 * @throws Exception
	 */
	public static int getActualHours(String aDayHour) throws Exception {
		int aHours = 0;
		try 
		{
			if ((aDayHour.length() == 4 || aDayHour.length() == 5) == false)
				throw new IllegalArgumentException(aDayHour);
			if (aDayHour.length() == 4)
				aDayHour = "+" + aDayHour;
			String temp[] = new String[]{StringUtils.substring(aDayHour, 0, 1),
					StringUtils.substring(aDayHour, 1, 3),
					StringUtils.substring(aDayHour, 3, 5)};
			aHours = (Integer.parseInt(temp[1]) * 24
					+ Integer.parseInt(temp[2]))
					* (temp[0].equals("+") ? 1 : -1);
		} 
		finally {

		}
		return aHours;
	}
	
	/**
	 * 
	 *
	 */
	public static java.sql.Timestamp getMaxExpire() {
		return java.sql.Timestamp.valueOf("2099-12-31 23:59:59");
	}
	
	/**
	 * 
	 * @return
	 */
	public static java.sql.Timestamp getEffective() {
		java.sql.Timestamp _effective = null;
		try 
		{
			java.sql.Timestamp __sysdate = TimeUtils.getSysdate();
			_effective = TimeUtils.addSecond( __sysdate, -20 );
		} 
		finally{

		}
		return _effective;
	}
	
	/**
	 * 
	 * @return
	 */
	public static java.sql.Timestamp getExpire() {
		java.sql.Timestamp _effective = null;
		try 
		{
			java.sql.Timestamp __sysdate = TimeUtils.getSysdate();
			_effective = TimeUtils.addSecond( __sysdate, -20 );
		} 
		finally{

		}
		return _effective;
	}
	
	/**
	 * 当前时间下年初时间
	 * @param time
	 * @return
	 */
	public static java.sql.Timestamp getNextYearStartDate( java.sql.Timestamp time ) {
		java.util.GregorianCalendar aCalendar = getCalendar(time);
		aCalendar.add( java.util.GregorianCalendar.YEAR        , 1 );
		aCalendar.set( java.util.GregorianCalendar.MONTH       , 0 );
		aCalendar.set( java.util.GregorianCalendar.DAY_OF_MONTH, 1 );
		aCalendar.set( java.util.GregorianCalendar.HOUR_OF_DAY , 0 );
		aCalendar.set( java.util.GregorianCalendar.MINUTE      , 0 );
		aCalendar.set( java.util.GregorianCalendar.SECOND      , 1 );
		aCalendar.set( java.util.GregorianCalendar.MILLISECOND , 0 );
		return new java.sql.Timestamp( aCalendar.getTimeInMillis() );
	}
	
	/**
	 * 当前时间前天开始时间
	 * @param time
	 * @return
	 */
	public static java.sql.Timestamp getYestDayStartDate( java.sql.Timestamp time ) {
		java.util.GregorianCalendar aCalendar = getCalendar( time );
		aCalendar.add( java.util.GregorianCalendar.DAY_OF_MONTH, -1 );
		aCalendar.set( java.util.GregorianCalendar.HOUR_OF_DAY , 0  );
		aCalendar.set( java.util.GregorianCalendar.MINUTE      , 0  );
		aCalendar.set( java.util.GregorianCalendar.SECOND      , 1  );
		aCalendar.set( java.util.GregorianCalendar.MILLISECOND , 0  );
		return new java.sql.Timestamp( aCalendar.getTimeInMillis()  );
	}
	
	/**
	 * 当前时间下月初时间
	 * @param time
	 * @return
	 */
	public static java.sql.Timestamp getNextMonthStartDate( java.sql.Timestamp time ) {
		java.util.GregorianCalendar aCalendar = getCalendar(time);
		aCalendar.add( java.util.GregorianCalendar.MONTH       , 1 );
		aCalendar.set( java.util.GregorianCalendar.DAY_OF_MONTH, 1 );
		aCalendar.set( java.util.GregorianCalendar.HOUR_OF_DAY , 0 );
		aCalendar.set( java.util.GregorianCalendar.MINUTE      , 0 );
		aCalendar.set( java.util.GregorianCalendar.SECOND      , 1 );
		aCalendar.set( java.util.GregorianCalendar.MILLISECOND , 0 );
		return new java.sql.Timestamp( aCalendar.getTimeInMillis() );
	}
	
	/**
	 * 当前时间下天初时间
	 * @param time
	 * @return
	 */
	public static java.sql.Timestamp getNextDayStartDate( java.sql.Timestamp time ) {
		java.util.GregorianCalendar aCalendar = getCalendar( time );
		aCalendar.add( java.util.GregorianCalendar.DAY_OF_MONTH, 1 );
		aCalendar.set( java.util.GregorianCalendar.HOUR_OF_DAY , 0 );
		aCalendar.set( java.util.GregorianCalendar.MINUTE      , 0 );
		aCalendar.set( java.util.GregorianCalendar.SECOND      , 1 );
		aCalendar.set( java.util.GregorianCalendar.MILLISECOND , 0 );
		return new java.sql.Timestamp( aCalendar.getTimeInMillis() );
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static java.util.GregorianCalendar getCalendar(java.util.Date time) {
		java.util.GregorianCalendar aCalendar = new java.util.GregorianCalendar();
		aCalendar.setTimeInMillis(time.getTime());
		return aCalendar;
	}
	
}
