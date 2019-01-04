package com.ai.sacenter.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.ai.sacenter.i18n.ExceptionFactory;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-3-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */

public class StringUtils extends org.apache.commons.lang.StringUtils {
	public final static Logger log=Logger.getLogger(StringUtils.class);
	public static final String LEFT  = "left";
	public static final String RIGHT = "right";
	public StringUtils() {
    	super();
    }
	
	/**
	 * 判断字符串中是否包含指定字符串
	 * @param lpBuffer 字符串
	 * @param containsbuff 包含字符串
	 * @return
	 */
	public static boolean contains( String lpBuffer , String containsbuff ){
		if( StringUtils.isEmpty( lpBuffer ) ){ return false; }
		return lpBuffer.indexOf( containsbuff ) >= 0;
	}
	
	/***
     * 判断字符串中是否包含指定字符串(忽虑空格)
     * @param lpBuffer 字符串
     * @param containsbuff 包含字符串
     * @return
     */
    public static boolean containsIgnoreBlank(String lpBuffer,String containsbuff){
	    lpBuffer = StringUtils.remove(lpBuffer,' ');
	    containsbuff = StringUtils.remove(containsbuff,' ');
	    return contains(lpBuffer, containsbuff);
    }
	
    /***
     * 判断字符串中是否包含指定字符串(忽虑字符大小写)
     * @param lpBuffer 字符串
     * @param containsbuff 包含字符串
     * @return
     */
    public static boolean containsIgnoreCase(String lpBuffer,String containsbuff){
    	if( StringUtils.isEmpty( lpBuffer ) ){ return false; }
    	return contains( lpBuffer.toUpperCase(), containsbuff.toUpperCase() );
    }
	
    /***
     * 判断字符串是否在指定字符串中存在
     * @param lpBuffer 字符串
     * @param containsbuff 指定字符串列表
     * @return
     */
    public static boolean contains( String lpBuffer, String containsbuff[] ){
    	 boolean aEnable = false;
    	 for(int index = 0 ; index < containsbuff.length ; index++){ 
		  	  aEnable |= StringUtils.equals( lpBuffer, containsbuff[index] )?true:false;
		  	  if( aEnable == true ){ break; }
    	 }
		 return aEnable; 
    }
    
    /**
     * 判断字符串是否在指定字符串中存在(忽虑字符大小写)
     * @param lpBuffer
     * @param containsbuff
     * @return
     */
    public static boolean containsIgnoreCase( String lpBuffer , String containsbuff[] ){
	    boolean aEnable = false;
	    for(int index = 0 ; index < containsbuff.length ; index++){ 
	    	aEnable |= StringUtils.equalsIgnoreCase( lpBuffer , containsbuff[index] )?true:false; 
	  	    if( aEnable == true ){ break; }
	    }
	    return aEnable; 
    }
    
    /**
	  * 判断开通串中是否只含有某具体串参数
	  * @param lpBuffer 字符串表达式[格式为A=1;C=1;B=1]
	  * @param distKeys 包含键值[A,B,C等]
	  * @return
	  */
	 public static boolean containsFixed(String lpBuffer, String[] distKeys ){
		 boolean fromFixed = false;
		 java.util.Map fromFixL = null;
		 try
		 {
			 fromFixL = StringUtils.wildcardGroup( lpBuffer, ";" );
			 ClassUtils.IMerge.purge( fromFixL, distKeys );
			 fromFixed = fromFixL == null || fromFixL.size() == 0?true:false;
		 }
		 finally{
			 if( fromFixL != null ){ fromFixL.clear(); fromFixL = null; }
		 }
		 return fromFixed;
	 }
    
	/**
     * 字符串按指定长度构造字符串,不足填空格
     * @param lpBuffer 字符串
     * @param lpLen 指定长度
     * @param lpAlign 补充类型(left左对齐right右对齐)
     * @return
     */
    public static String filling( String lpBuffer, int lpLen, String lpAlign){
    	return filling(lpBuffer, lpLen, lpAlign, ' ');
    }
    
    /**
     * 整数按指定长度构造字符串,以指定字符填充
     * @param lpBuffer 字符串
     * @param lpLen 指定长度
     * @param lpAlign 补充类型(left左对齐right右对齐)
     * @param lpFill 填充字符
     * @return
     */
    public static String filling(String lpBuffer, int lpLen, String lpAlign, char lpFill){
    	StringBuilder fromAsL = new StringBuilder( lpBuffer );
    	while( fromAsL.length() < lpLen ){
    		if( equalsIgnoreCase( lpAlign , StringUtils.LEFT ) ){
    			fromAsL.append( lpFill );
    		}
    		else{
    			fromAsL.insert( 0, lpFill );
    		}
    	}
    	return fromAsL.toString();
    }
    
    /**
     * 从字符串中删除掉指定字符
     * @param lpBuffer 字符串
     * @param lpDelete 待删除字符
     * @return
     */
    public static String remove(String lpBuffer, char lpDelete){
    	StringBuilder fromAsL = new StringBuilder( lpBuffer );
    	int fromPos = 0;
    	while( fromPos < fromAsL.length() ){
    		if( fromAsL.charAt( fromPos ) != lpDelete ){
    			fromPos += 1;
    		}
    		else{
    			fromAsL.deleteCharAt( fromPos );
    		}
    	}
    	return fromAsL.toString();
    }
    
    /**
     * 从字符串中删除掉指定字符串
     * @param lpBuffer 字符串
     * @param lpDelete 待删除字符串
     * @return
     */
    public static String remove(String lpBuffer,String lpDelete){
    	return StringUtils.replace(lpBuffer, lpDelete, "");
    }
    
    /**
     * 替换字符串中指定位置的字符
     * @param lpBuffer 字符串
     * @param lpPos 被替换位置
     * @param lpReplace 替换字符
     * @return
     */
    public static String replace(String lpBuffer, int lpPos, char lpReplace){
    	StringBuilder fromAsL = new StringBuilder( lpBuffer );
    	if( lpBuffer == null || fromAsL.length() <= lpPos ){
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	fromAsL.setCharAt( lpPos, lpReplace );
    	return fromAsL.toString();
    }
    
    /***
     * 格式如下A=1&B=2&C=12
     * @param aManifest
     * @param fromPARAM
     * @return
     */
    public static void manifest( String aManifest , java.util.Map fromPARAM ){
	    StringTokenizer tok = new StringTokenizer( aManifest , "&" );
	    while( tok.hasMoreTokens() ){
            String token = tok.nextToken();
            int eq = token.indexOf( "=" );
            String name = (eq > -1) ? token.substring( 0, eq ) : token;
            String value = (eq > -1) ? token.substring( eq + 1 ) : "";
            fromPARAM.put(name.trim(), value);
        }
    }
    
    /**
     * 
     * @param fromMap
     * @param pattern
     * @return
     */
    public static String[] wildcardMatch(java.util.Map fromMap, String pattern) {
		java.util.List fromList = new java.util.ArrayList();
		for (java.util.Iterator itera = fromMap.entrySet().iterator(); itera.hasNext();) {
			java.util.Map.Entry fromEntry = (java.util.Map.Entry) itera.next();
			if( fromEntry.getKey() != null && ClassUtils.IClass.isString( fromEntry.getKey() ) &&
					StringUtils.wildcardMatch( (String)fromEntry.getKey(), pattern ) ){
				fromList.add( fromEntry.getKey() );
			}
		}
		return (String[]) fromList.toArray(new String[] {});
	}
    
    /**
     * 判断字符串符合字符串匹配规则
     * @param lpBuffer 字符串
     * @param lpPattern 匹配字符串
     * @return
     */
    public static final boolean wildcardMatch( String lpBuffer , String lpPattern[] ){
    	for( int fromINDEX = 0; fromINDEX < lpPattern.length; fromINDEX++ ){
    		if( wildcardMatch( lpBuffer, lpPattern[fromINDEX] ) ){
    			return true;
    	    }
        }
    	return false;
    }
    
    /**
     * 判断字符串符合字符串匹配规则
     * @param lpBuffer
     * @param pattern
     * @return
     */
    public static final boolean wildcardMatch(String lpBuffer , String pattern){
   	    int patternLength = pattern.length();
        int strLength = lpBuffer.length();
        int strIndex = 0;
        char ch;
        for (int patternIndex = 0; patternIndex < patternLength; patternIndex++){
       	 ch = pattern.charAt(patternIndex);
            if (ch == '*') {
           	 while(strIndex < strLength){
             		if (wildcardMatch( lpBuffer.substring(strIndex), 
             				pattern.substring(patternIndex + 1)))
                         return true;
                     strIndex++;
                }
            } 
            else if (ch == '?') {
                strIndex++;
                if (strIndex > strLength)
                    return false;
            } else {
                if ((strIndex >= strLength || (ch != lpBuffer.charAt(strIndex))))
                    return false;
                strIndex++;
            }
        }
        return (strIndex == strLength);
     }
    
     /**
	  * 从字符串中抹掉指定字符
	  * @param lpBuffer 字符串
	  * @param lpDelete 指定字符
	  * @return
	  */
	 public static final String wildcardErase( String lpBuffer , String lpDelete ){
		  String fromAsL = new String( lpBuffer );
		  if( StringUtils.isBlank( lpDelete ) == false ){
			  for( int index = 0; index < lpDelete.length(); index++ ){
				  char fromChar = lpDelete.charAt( index );
				  if( StringUtils.indexOf( fromAsL, fromChar ) >= 0 ){
					  fromAsL = StringUtils.replace( fromAsL, 
							  String.valueOf( fromChar ), 
							  "");
				  }
			  }
		  }
		  return fromAsL;
	 }
	 
	 /**
	  * 将字符串转换为字符数组
	  * @param lpBuffer 字符串
	  * @return
	  */
	 public static final String[] wildcardArray( String lpBuffer ){
		  String fromArray[] = new String[ (lpBuffer = (lpBuffer == null?
				  "":lpBuffer)).length()];
		  for( int index = 0; index < lpBuffer.length(); index++ ){
			  fromArray[index] = String.valueOf( lpBuffer.charAt( index ) );
		  }
		  return fromArray;
	 }
	 
	 /**
	  * 根据分隔符提取字符串(不忽律空字符)
	  * @param lpBuffer 字符串
	  * @param lpSeparator 分隔符
	  * @return
	  */
	 public static String[] wildcardArray( String lpBuffer , String lpSeparator ){
		  java.util.List fromList = new java.util.ArrayList();
		  int fromStart = 0,fromEnd = -lpSeparator.length();
		  while( lpBuffer != null && fromEnd < lpBuffer.length()){
			  fromStart = fromEnd + lpSeparator.length();
		      fromEnd = StringUtils.indexOf(lpBuffer, lpSeparator, fromStart);
		      if( fromEnd < 0 ) fromEnd = lpBuffer.length();
		      fromList.add( StringUtils.substring(lpBuffer, fromStart, fromEnd) );
		  }
		  return (String[])fromList.toArray(new String[]{});
	 }
	 
	 /**
	  * 比较2数据个数组fromALL和fromDELETE，返回fromDELETE中不存在的数组
	  * @param fromALL
	  * @param fromDELETE
	  * @return
	  */
	 public static String[] wildcardDiff( String[] fromALL,String[] fromDELETE ){
		 java.util.ArrayList fromDiff = new java.util.ArrayList();
		 fromDiff.addAll( Arrays.asList( fromALL ) );
		 fromDiff.removeAll( Arrays.asList( fromDELETE ) );
		 return (String[])fromDiff.toArray( new String[]{} );
	 }
	 /**
	  * 
	  * @param lpBuffer
	  * @param lpSeparator
	  * @return
	  */
	 public static String[] wildcardTail( String lpBuffer ,  String lpSeparator ){
		  java.util.List fromTail = new java.util.ArrayList();
		  int index = StringUtils.indexOf( lpBuffer , lpSeparator );
		  if( index < 0 ){ 
			  fromTail.add( lpBuffer ); 
		  }
		  else{
			  fromTail.add( StringUtils.substring( lpBuffer, 0, index) );
			  fromTail.add( StringUtils.substring( lpBuffer, 
					  index + lpSeparator.length(), 
					  lpBuffer.length() ) );
		  }
		  return (String[])fromTail.toArray(new String[]{});
	 }	
	 /**
	  * 按照分隔符拆分表达式[格式为A=1;B=1;C=1]转换为数组结构
	  * @param lpBuffer 字符串
	  * @param lpSeparator 分隔符
	  * @return
	  */
	 public static String[][] wildcardSplite( String lpBuffer,  String lpSeparator ){
		  java.util.List fromSplite =  new java.util.ArrayList();
		  if( StringUtils.isBlank( lpBuffer ) == false ){
			  String fromTail[] = wildcardArray( lpBuffer , lpSeparator );
			  for(int index = 0 ; index < fromTail.length ; index++){
				  String fromApp[] = wildcardTail( fromTail[index], "=" );
				  if( fromApp != null && fromApp.length > 0 ){
					  fromSplite.add( new String[]{ fromApp[0], fromApp.length>1?fromApp[1]:""} );
				  }
			  }
		  }
		  return (String[][])fromSplite.toArray( new String[][]{} );
	 }
	 /**
	  * 按照分隔符拆分表达式[格式为A=1;B=1;C=1]转换为Map结构
	  * @param lpBuffer 字符串
	  * @param lpSeparator 分隔符
	  * @return
	  */
	 public static java.util.Map wildcardGroup(String lpBuffer, String lpSeparator){
		 java.util.Map fromGroup = new java.util.HashMap();
		 String fromArray[][] = StringUtils.wildcardSplite( lpBuffer, lpSeparator );
		 if( fromArray != null && fromArray.length > 0 ){
			 for( int index = 0; index < fromArray.length; index++ ){
				 if( fromArray[index] != null && fromArray[index].length > 0 ){
					 fromGroup.put( fromArray[index][0],  fromArray[index].length > 1?
							 fromArray[index][1]:null );
				 }
			 }
		 }
		 return fromGroup;
	 }
	 
	 /**
	  * 字符串从左到右连接[忽虑空格和空字符]
	  * @param lpBuffer
	  * @return
	  */
	 public static String trimLeft( String lpBuffer[] ){
		 StringBuilder fromLeft = null;
		 try
		 {
			 for( int index = 0; lpBuffer != null && index < lpBuffer.length; index++ ){
				 if( lpBuffer[index] != null ){
					 if( fromLeft == null ) fromLeft = new StringBuilder();
					 fromLeft.append( lpBuffer[index] );
				 }
			 }
		 }
		 finally{
			 
		 }
		 return fromLeft != null?fromLeft.toString():null;
	 }
	 
	 /**
	  * 字符串从右到左连接[忽虑空格和空字符]
	  * @param lpBuffer
	  * @return
	  */
	 public static String trimRight( String lpBuffer[] ){
		 StringBuilder fromLeft = null;
		 try
		 {
			 if( lpBuffer != null && lpBuffer.length > 0 ){
				 for( int index = lpBuffer.length - 1; index >= 0; index-- ){
					 if( lpBuffer[index] != null ){
						 if( fromLeft == null ) fromLeft = new StringBuilder();
						 fromLeft.append( lpBuffer[index] );
					 }
				 }
			 }
		 }
		 finally{
			 
		 }
		 return fromLeft != null?fromLeft.toString():null;
	 }
	 
	 /***
	  * 从左修剪最大字节长度字符,如不足最大字节长度则原样返回
	  * @param lpBuffer 字符串
	  * @param lpMaxLen 最大字节长度
	  * @return
	  */
	 public static final String trimLeft( String lpBuffer, int lpMaxLen ){
		  StringBuilder fromLeft = new StringBuilder();
		  int fromINDEX = 0,fromLen = 0;
		  if( lpBuffer == null || lpBuffer.getBytes().length < lpMaxLen ){
			  return lpBuffer;
		  }
		  while( fromINDEX < lpBuffer.length() ){
			  String fromApp = String.valueOf( lpBuffer.charAt( fromINDEX ) );
			  fromLen = fromLeft.toString().getBytes().length +
	   				fromApp.getBytes().length;
			  if( fromLen > lpMaxLen ){ break;}
			  fromLeft.append( fromApp );
			  fromINDEX += 1;
		  }
		  return fromLeft.toString();
	 }
	 /***
	  * 从左修剪最大字节长度字符，如不足最大字节长度则右边填充指定字符
	  * @param lpBuffer 字符串
	  * @param lpMaxLen 最大字节长度 
	  * @param lpFill 填充字符
	  * @return
	  */
	 public static final String trimLeft( String lpBuffer , int lpMaxLen , char lpFill ){
		  if( lpBuffer == null ){ return lpBuffer; }
		  else if( lpBuffer.getBytes().length > lpMaxLen ){
			  lpBuffer = trimLeft(lpBuffer, lpMaxLen);
		  }
		  StringBuilder  fromMaxL = new StringBuilder( lpBuffer );
		  while( fromMaxL.toString().getBytes().length < lpMaxLen ){
			  fromMaxL.append( lpFill );
		  }
		  return fromMaxL.toString();
	 }
	 /***
	  * 根据分隔符提取左边字符串(不忽律空字符)
	  * @param lpBuffer 字符串
	  * @param lpSeparator
	  * @return
	  */
	 public static final String trimLeft( String lpBuffer , String lpSeparator ){
		  if( lpBuffer == null || lpBuffer.length() <=0 ){
			  return lpBuffer;
		  }
		  String fromArray[] = wildcardArray(lpBuffer, lpSeparator);
		  return fromArray != null && fromArray.length > 0?fromArray[0]:null;
	 }
	 
	 /**
	  * 从右修剪最大字节长度字符,如不足最大字节长度则原样返回
	  * @param lpBuffer
	  * @param lpMaxLen
	  * @return
	  */
	 public static final String trimRight( String lpBuffer , int lpMaxLen ){
		 String fromMaxL = lpBuffer;
		 if( fromMaxL.getBytes().length > lpMaxLen ){
			 fromMaxL = StringUtils.substring( fromMaxL , 0, lpMaxLen );
	 	 }
		 return fromMaxL;
	 }
	 /**
	  * 
	  * @param aEXCEPTION
	  * @param lpMaxByte
	  * @return
	  */
	 public static final String trimRight( java.lang.Exception aEXCEPTION , int lpMaxByte ) {
	 	String fromMaxL = null;
	 	try
	 	{
	 		Throwable aPRIMITIVE = ExceptionFactory.getPrimitive( aEXCEPTION );
	 		StringWriter aWrite = new StringWriter();
	 		PrintWriter Out = new PrintWriter( aWrite );
	 		aPRIMITIVE.printStackTrace( Out );
	 		Out.flush();Out.close();Out  = null;
	 		fromMaxL = aWrite.toString();
	 		aWrite.close();aWrite = null;
	 		if( fromMaxL.getBytes().length > lpMaxByte ){
	 			fromMaxL = StringUtils.substring( fromMaxL , 0, lpMaxByte );
	 		}
	 	}
	 	catch( java.lang.Exception aException){
	 		
	 	}
	 	return fromMaxL;
	 }
	 
	 /***
	  * 从右修剪最大字节长度字符，如不足最大字节长度则左边填充指定字符
	  * @param lpBuffer 字符串
	  * @param lpMaxLen 最大字节长度 
	  * @param lpFill 填充字符
	  * @return
	  */
	 public static final String trimRight( String lpBuffer , int lpMaxLen , char lpFill ){
		 if( lpBuffer == null ){ return lpBuffer; }
		 else if( lpBuffer.getBytes().length > lpMaxLen ){
			 lpBuffer = trimRight(lpBuffer, lpMaxLen);
		 }
		 StringBuilder  fromMaxL = new StringBuilder( lpBuffer );
		 while( fromMaxL.toString().getBytes().length < lpMaxLen ){
			 fromMaxL.insert(0, lpFill );
		 }
		 return fromMaxL.toString();
	 }
	 
	 /***
	  * 获取按特定字符最右字符串
	  * @param lpBuffer 字符串
	  * @param lpSeparator 分隔符
	  * @return
	  */
	 public static final String trimRight( String lpBuffer , String lpSeparator ){
		 if( lpBuffer == null || lpBuffer.length() <=0 ){
			 return lpBuffer;
		 }
		 String fromArray[] = wildcardArray(lpBuffer, lpSeparator);
		 return fromArray != null && fromArray.length > 0?fromArray[ fromArray.length - 1]:null;
	 }
	 /**
	  * 
	  * @param lpBytes
	  * @param aOffset
	  * @param aLen
	  * @return
	  */
	 public static final String trim( byte[] lpBytes, int aOffset, int aLen ){
		 String fromTrim = null;
		 try
		 {
			 fromTrim = new String(lpBytes, aOffset, aLen);
			 if( fromTrim != null ) fromTrim = StringUtils.trim( fromTrim );
		 }
		 finally{
			 
		 }
		 return fromTrim;
	 }
	 /**
	  * 判断字符串为null
	  * @param lpBuffer
	  * @return
	  */
	 public static boolean isNULL( String lpBuffer ){
		 return lpBuffer == null || equalsIgnoreCase( lpBuffer, "null" );
	 }
	 /**
	  * 是否数字字符串
	  * @param lpBuffer
	  * @return
	  */
	 public static boolean isDigital( String lpBuffer ){
		 if( StringUtils.isBlank( lpBuffer ) ) return false;
	     int aDianHaoC = 0;
	     for(int index = 0 ; index < lpBuffer.length() ; index++ ){
	     	switch( lpBuffer.charAt( index ) ){
	     	case '0':
	     	case '1':
	     	case '2':
	     	case '3':
	     	case '4':
	     	case '5':
	     	case '6':
	     	case '7':
	     	case '8':
	     	case '9':
	     		;
	     		break;
	     	case '-':
	     		{if( index != 0 ) return false;}
	     		break;
	     	case '.':
	     	    {aDianHaoC++;if( aDianHaoC > 1) return false;}
	     	    break;
	     	default:
	     		return false;
	     	}
	     }
	     return true;
	 }
	 /**
	  * 判断字符串在尾部是否以指定字符串
	  * @param lpBuffer 
	  * @param lpEndWith
	  * @return
	  */
	 public static boolean endsWith(String lpBuffer,String lpEndWith){
		 if( lpBuffer == null || lpEndWith == null ) return false;
		 if( lpBuffer.length() < lpEndWith.length() ) return  false;
		 for( int index = 0 ; index < lpEndWith.length(); index++ ){
		  	if( lpBuffer.charAt( lpBuffer.length() - index - 1 ) != 
		  		 lpEndWith.charAt( lpEndWith.length() - 1 - index ) ){
		  		return false;
		      }
		 }
		 return true;
	 }
	 /**
	  * 判断字符串在尾部是否以指定字符串(忽虑字符大小写)
	  * @param lpBuffer
	  * @param lpEndWith
	  * @return
	  */
	 public static boolean endsIgnoreCaseWith(String lpBuffer,String lpEndWith){
		 if( lpBuffer == null || lpEndWith == null ) return false;
		 if( lpBuffer.length() < lpEndWith.length() ) return  false;
		 return endsWith( lpBuffer.toUpperCase(),
		  		lpEndWith.toUpperCase() );	
	 }
	 /***
	  * 判断字符串在开头是否以指定字符串
	  * @param lpBuffer
	  * @param lpStartWith
	  * @return
	  */
	 public static boolean startWith(String lpBuffer,String lpStartWith){
	 	if( lpBuffer == null || lpStartWith == null ) return false;
	 	if( lpBuffer.length() < lpStartWith.length() ) return false;
	 	for( int Index = 0; Index < lpStartWith.length(); Index++){
	 		if( lpBuffer.charAt(Index) != lpStartWith.charAt(Index) ){
		  		return false;
		  	}
		 }
		 return true;
	 }
	 /**
	  * 
	  * @param lpBuffer
	  * @param lpStartWith
	  * @return
	  */
	 public static boolean startWith( String lpBuffer,String lpStartWith[] ){
		 for( int index = 0; lpStartWith != null && index < lpStartWith.length; index++ ){
			 if( startWith( lpBuffer, lpStartWith[index] ) ){
				 return true;
			 }
		 }
		 return false; 
	 }
	 /***
	  * 判断字符串在开头是否以指定字符串(忽虑字符大小写)
	  * @param lpBuffer
	  * @param lpStartWith
	  * @return
	  */
	 public static boolean startIgnoreCaseWith(String lpBuffer,String lpStartWith){
		 if( lpBuffer == null || lpStartWith == null ) return false;
		 if( lpBuffer.length() < lpStartWith.length() ) return false;
		 return startWith( lpBuffer.toUpperCase(), lpStartWith.toUpperCase() );
	 }
	 /**
	  * 
	  * @param lpBuffer
	  * @param lpOpen
	  * @param lpClose
	  * @return
	  */
	 public static String[] substring( String lpBuffer , char lpOpen , char lpClose ){
		 java.util.List fromBuffer = new java.util.ArrayList();
	 	 StackDeque fromMaxL = new StackDeque();
	 	 try
	 	 {
	 		StringBuilder fromAsL = new StringBuilder();
	 	    for(int index = 0 ; index < lpBuffer.length() ; index++){
	 		    if( lpBuffer.charAt( index ) == lpOpen ){
	 		    	if( fromMaxL.size() > 0 ) fromAsL.append( lpBuffer.charAt( index ) );
	 		    	fromMaxL.push( String.valueOf( lpOpen ) );
	 	    		index += 1 ;
	 	    	}
	 	    	if( fromMaxL.size() > 0 && lpBuffer.charAt( index ) != lpClose  ) 
	 	    		fromAsL.append( lpBuffer.charAt( index ) );
	 	    	else if( lpBuffer.charAt( index ) == lpClose ){
	 	    		if( fromMaxL.size() <= 0 ) throw new IllegalArgumentException( "arguments are required."  );
	 	    		fromMaxL.pop();
	 	    		if( fromMaxL.size() > 0 ) 
	 	    			fromAsL.append( lpBuffer.charAt( index ) );
	 	    		else {
	 	    			fromBuffer.add( fromAsL.toString() );
	 	    			fromAsL = new StringBuilder();
	 	    		}
	 	    	}
	 	   	}
	 	    if( fromMaxL.size() > 0 ) throw new IllegalArgumentException( "arguments are required."  );
	 	 }
	 	 finally{
	 	    if( fromMaxL != null ){ fromMaxL.clear(); fromMaxL = null;} 
	 	 }
	 	 return (String[])fromBuffer.toArray(new String[]{});
	 }
	 /**
	  * 
	  * @param lpBuffer
	  * @param lpOpenMatch
	  * @param lpCloseMatch
	  * @return
	  */
	 public static String[] substring( String lpBuffer , String lpOpenMatch, String lpCloseMatch ){
	 	 java.util.List fromList = new java.util.ArrayList();
	 	 int fromStart = 0 , fromEnd = - lpOpenMatch.length();
	 	 while( fromEnd < lpBuffer.length() ){
	 		 fromStart = StringUtils.indexOf( lpBuffer , lpOpenMatch , fromEnd ) ;
	 		  if( fromStart < 0 ) break;
	 		  fromStart += lpOpenMatch.length();
	 		  fromEnd = StringUtils.indexOf( lpBuffer , lpCloseMatch , fromStart );
	 		  if( fromEnd < 0 ) break;
	 		  fromList.add( StringUtils.substring( lpBuffer , fromStart , fromEnd ) );
	 		  fromEnd += lpCloseMatch.length();
	 	 }
	 	 return (String[])fromList.toArray(new String[]{});
	 }
	 /**
	  * 按长度分割字符串
	  * @param lpBuffer
	  * @param aMaxByte
	  * @return
	  */
	 public static String[] substringAsL( String lpBuffer , int aMaxBytes ){
		 java.util.List fromAsL = new java.util.ArrayList();
			try
			{
				if( lpBuffer == null || aMaxBytes <= 0 ){ return new String[0];}
				byte[] fromBytes = lpBuffer.getBytes();
				for( int fromINDEX = 0,fromLen = 0; fromINDEX < fromBytes.length; ){
					if( fromINDEX + aMaxBytes >= fromBytes.length ){
						String fromString = new String(fromBytes, fromINDEX, 
								fromBytes.length - fromINDEX );
						fromAsL.add( fromString );
						break;
					}
					else{
						String fromSubStr = new String(fromBytes, fromINDEX,  aMaxBytes );
						if( fromSubStr.charAt( fromSubStr.length() - 1 ) != 
								lpBuffer.charAt( fromSubStr.length() + fromLen - 1 ) ){
							String fromSubA = new String(fromBytes, fromINDEX, 
									fromSubStr.getBytes().length - 1 );
							fromAsL.add( fromSubA );
							fromLen += fromSubA.length();
							fromINDEX = fromINDEX + fromSubA.getBytes().length;
						}
						else{
							fromAsL.add( fromSubStr );
							fromLen += fromSubStr.length();
							fromINDEX = fromINDEX + fromSubStr.getBytes().length;
						}
					}
				}
			}
			finally{
				
			}
			return (String[])fromAsL.toArray( new String[]{} );
	 }
	 /**
	  * 
	  * @param lpBuffer
	  * @param lpOpen
	  * @param lpClose
	  * @return
	  */
	 public static String substringBetwn( String lpBuffer, String lpOpen, String lpClose ){
	 	String rtn = StringUtils.substringAfter( lpBuffer, lpOpen);
	 	if( rtn != null ) rtn = StringUtils.substringBeforeLast( rtn , lpClose );
	 	return rtn;
	 }
}
