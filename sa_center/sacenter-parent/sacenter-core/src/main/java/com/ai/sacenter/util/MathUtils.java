package com.ai.sacenter.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import sun.misc.DoubleConsts;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 数学工具</p>
 * <p>Copyright: Copyright (c) 2015年10月21日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class MathUtils {
	public MathUtils() {
		super();
	}
		
	/**
	 * 是否整数字符串(包含正整数以及负整数,不包含小数)
	 * @param aDecimal
	 * @return
	 */
	public static boolean isNumeric( String aDecimal ){
		if( aDecimal == null ){
			return false;
		}
		else if( aDecimal.length() <= 0 ){
			return false;
		}
		else if( aDecimal.charAt( 0 ) == '-' /*负数*/){
			aDecimal = aDecimal.substring( 1 );
			return StringUtils.isNumeric( aDecimal );
		}
		else/*正整数*/{
			return StringUtils.isNumeric( aDecimal );
		}
	}
	
	/**
	 * 是否数字符串(包含小数和负数)
	 * @param aDecimal
	 * @return
	 */
	public static boolean isDecimal( String aDecimal ){
		return StringUtils.isDigital( aDecimal );
	}
	
	/**
	 * 是否无穷大
	 * @param _double
	 * @return
	 */
	public static boolean isFinite( double _double ){
		return Math.abs( _double ) <= DoubleConsts.MAX_VALUE;
	}
	
	/**
	 * 整数字符串转换整数
	 * @param fromDecimal 整数字符串
	 * @return
	 */
	public static long decimal( String fromDecimal ){
		try
		{
			return Long.parseLong( fromDecimal );
		}
		catch( java.lang.NumberFormatException exception ){
			throw exception;
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年6月7日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMath{
		public IMath(){
			super();
		}

		/**
		 * 
		 * @param aMedian
		 * @return
		 */
		public static int random(int aMedian) {
			int aRandom = 0;
			java.util.Random fromRandom = new java.util.Random();
			try{
				aRandom = fromRandom.nextInt(aMedian);
			} 
			finally {
				if( fromRandom != null ) { fromRandom = null; }
			}
			return aRandom;
		}

		/**
		 * 
		 * @param nMedian
		 * @param nDigit
		 * @return
		 */
		public static String random(int nMedian, int nDigit) {
			StringBuilder aOBJECT = new StringBuilder();
			java.util.Random fromRandom = new java.util.Random();
			try {
				for (int index = 0; index < nDigit; index++) {
					aOBJECT.append( fromRandom.nextInt( nMedian ) );
				}
			} 
			finally{
				if (fromRandom != null) { fromRandom = null; }
			}
			return aOBJECT.toString();
		}

		/**
		 * 
		 * @param asourcedata
		 * @param aOffset
		 * @param length
		 * @return
		 */
		public static byte[] toByteArray(byte[] asourcedata, int aOffset, int length) {
			byte[] data = new byte[length];
			System.arraycopy(asourcedata, aOffset, data, 0, length);
			return data;
		}

		/**
		 * 
		 * @param aValue
		 * @return
		 */
		public static byte[] toByteArray(int aValue) {
			byte[] data = new byte[4];
			data[3] = (byte) (aValue >> 0 & 0xFF);
			data[2] = (byte) (aValue >> 8 & 0xFF);
			data[1] = (byte) (aValue >> 16 & 0xFF);
			data[0] = (byte) (aValue >> 24 & 0xFF);
			return data;
		}

		/**
		 * 
		 * @param aValue
		 * @return
		 */
		public static byte[] toByteArray(short aValue) {
			byte[] data = new byte[2];
			data[1] = (byte) (aValue >> 0 & 0xFF);
			data[0] = (byte) (aValue >> 8 & 0xFF);
			return data;
		}

		/**
		 * 
		 * @param aValue
		 * @return
		 */
		public static byte[] toByteArray(long aValue) {
			byte[] data = new byte[8];
			data[7] = (byte) (int) (aValue >> 0 & 0xFF);
			data[6] = (byte) (int) (aValue >> 8 & 0xFF);
			data[5] = (byte) (int) (aValue >> 16 & 0xFF);
			data[4] = (byte) (int) (aValue >> 24 & 0xFF);
			data[3] = (byte) (int) (aValue >> 32 & 0xFF);
			data[2] = (byte) (int) (aValue >> 40 & 0xFF);
			data[1] = (byte) (int) (aValue >> 48 & 0xFF);
			data[0] = (byte) (int) (aValue >> 56 & 0xFF);
			return data;
		}

		/**
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static byte[] toByteArray(Object aOBJECT) {
			byte bytes[] = null;
			try{
				if( aOBJECT == null )
					return null;
				if( aOBJECT instanceof java.lang.String ){
					bytes = ((String)aOBJECT).getBytes();
				} 
				else if( aOBJECT instanceof byte[] ){
					bytes = (byte[])aOBJECT;
				} 
				else if( aOBJECT instanceof java.lang.Integer ){
					bytes = IMath.toByteArray(((Integer)aOBJECT).intValue());
				} 
				else if( aOBJECT instanceof java.lang.Short ){
					bytes = IMath.toByteArray(((Short)aOBJECT).shortValue());
				} 
				else if( aOBJECT instanceof java.lang.Long ){
					bytes = IMath.toByteArray(((Long)aOBJECT).longValue());
				}
				else{
					bytes = IMath.object2byte( aOBJECT );
				}
			} 
			finally {

			}
			return bytes;
		}

		/**
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static String toString(Object aOBJECT) {
			String string = null;
			java.math.BigDecimal _decimal = null;
			try
			{
				if( aOBJECT == null ){
					string = null;
				} 
				else if( aOBJECT instanceof byte[] ){
					string = new String((byte[])aOBJECT);
				} 
				else if( aOBJECT instanceof Double ){
					_decimal = new java.math.BigDecimal( ((Double)aOBJECT).toString() );
					string  = _decimal.toPlainString();
				}
				else{
					string = (String) aOBJECT;
				}
			} 
			finally{
				if( _decimal != null ){ _decimal = null; }
			}
			return string;
		}

		/**
		 * 
		 * @param aData
		 * @param aOffset
		 * @return
		 */
		public static short toShort(byte[] aData, int aOffset) {
			return (short) (((aData[(aOffset + 0)] & 0xFF) << 8) + ((aData[(aOffset + 1)] & 0xFF) << 0));
		}

		/**
		 * 
		 * @param aData
		 * @param aOffset
		 * @return
		 */
		public static int toInt(byte[] aData, int aOffset) {
			return (((aData[(aOffset + 0)] & 0xFF) << 24)
					+ ((aData[(aOffset + 1)] & 0xFF) << 16)
					+ ((aData[(aOffset + 2)] & 0xFF) << 8) + ((aData[(aOffset + 3)] & 0xFF) << 0));
		}

		/**
		 * 
		 * @param aData
		 * @param aOffset
		 * @return
		 */
		public static long toLong(byte[] aData, int aOffset) {
			long low = ((aData[(aOffset + 0)] & 0xFF) << 24)
					+ ((aData[(aOffset + 1)] & 0xFF) << 16)
					+ ((aData[(aOffset + 2)] & 0xFF) << 8)
					+ ((aData[(aOffset + 3)] & 0xFF) << 0);
			long high = ((aData[(aOffset + 4)] & 0xFF) << 24)
					+ ((aData[(aOffset + 5)] & 0xFF) << 16)
					+ ((aData[(aOffset + 6)] & 0xFF) << 8)
					+ ((aData[(aOffset + 7)] & 0xFF) << 0);
			return (high + (low << 32));
		}

		/**
		 * 
		 * @param aData
		 * @param aOffset
		 * @param aLen
		 * @return
		 */
		public static String toString(byte[] aData, int aOffset, int aLen) {
			return new String(aData, aOffset, aLen);
		}

		/**
		 * 
		 * @param value
		 * @return
		 */
		public static String int2hex(int value) {
			return int2hex( value, 4);
		}

		/**
		 * 
		 * @param value
		 * @param length
		 * @return
		 */
		public static String int2hex(int value, int length) {
			String temStr = Integer.toHexString(value);
			StringBuilder temBuffer = new StringBuilder();
			while (temStr.length() < length) {
				temBuffer.append("0");
				temBuffer.append(temStr);
				temStr = temBuffer.toString();
				temBuffer.delete(0, temBuffer.toString().length());
			}
			return temStr.toUpperCase();
		}

		/**
		 * 
		 * @param value
		 * @param length
		 * @return
		 */
		public static String int2string( int value, int length ){
			String temStr = String.valueOf( value );
			StringBuilder temBuffer = new StringBuilder();
			while (temStr.length() < length) {
				temBuffer.append("0");
				temBuffer.append(temStr);
				temStr = temBuffer.toString();
				temBuffer.delete(0, temBuffer.toString().length());
			}
			return temStr.toUpperCase();
		}
		
		/**
		 * 
		 * @param value
		 * @return
		 */
		public static String long2hex(long value) {
			String temStr = Long.toHexString(value);
			StringBuilder temBuffer = new StringBuilder();
			while (temStr.length() < 8) {
				temBuffer.append("0");
				temBuffer.append(temStr);
				temStr = temBuffer.toString();
				temBuffer.delete(0, temBuffer.toString().length());
			}
			return temStr.toUpperCase();
		}

		/**
		 * 
		 * @param aHexString
		 * @return
		 */
		public static int hex2Int(String aHexString) {
			StringBuilder str = new StringBuilder("0x");
			str.append(aHexString);
			return Integer.decode(str.toString()).intValue();
		}

		/**
		 * 
		 * @param aHexString
		 * @return
		 */
		public static long hex2Long(String aHexString) {
			StringBuilder str = new StringBuilder("0x");
			str.append(aHexString);
			return Long.decode(str.toString()).intValue();
		}

		/**
		 * 
		 * @param aByte
		 * @return
		 */
		public static String byte2hex(byte[] aByte) {
			StringBuilder fromHEX = new StringBuilder();
			for (int index = 0; aByte != null && index < aByte.length; index++) {
				String stmp = Integer.toHexString(aByte[index] & 0xFF);
				if (stmp.length() == 1)
					fromHEX.append("0").append(stmp);
				else
					fromHEX.append(stmp);
			}
			return fromHEX.toString().toUpperCase();
		}

		/**
		 * 
		 * @param aByte
		 * @return
		 */
		public static String byte2binary(byte[] aByte) {
			StringBuilder aBinary = new StringBuilder();
			for (int index = 0; index < aByte.length; index++) {
				StringBuilder stmp = new StringBuilder(Integer.toBinaryString(aByte[index] & 0xFF));
				while (stmp.length() < 8) {
					stmp.insert(0, '0');
				}
				aBinary.append(stmp);
			}
			return aBinary.toString().toUpperCase();
		}

		/**
		 * 
		 * @param aHex
		 * @return
		 */
		public static byte[] hex2byte(String aHex) {
			byte aByte[] = new byte[aHex.length() / 2];
			byte aHexByte[] = aHex.getBytes();
			for (int index = 0; index < aByte.length; index++) {
				byte _b0 = Byte.decode( "0x" + new String(new byte[] { aHexByte[2 * index] })).byteValue();
				_b0 = (byte) (_b0 << 4);
				byte _b1 = Byte.decode( "0x" + new String( new byte[] { aHexByte[2 * index + 1] })).byteValue();
				aByte[index] = (byte) (_b0 | _b1);
			}
			return aByte;
		}

		/**
		 * 
		 * @param _stringip__
		 * @return
		 */
		public static String ip2hex(String _stringip__) {
			StringBuilder __hex__ = new StringBuilder();
			String __string__[] = StringUtils.wildcardArray( _stringip__, "." );
			for (int index = 0; index < __string__.length; index++) {
				__hex__.append( int2hex( Integer.parseInt( __string__[index]), 2 ) );
			}
			return __hex__.toString();
		}
		
		/**
		 * 
		 * @param _stringip_
		 * @return
		 */
		public static String ip2dec( String _stringip_ ){
			StringBuilder __hex__ = new StringBuilder();
			String __string__[] = StringUtils.wildcardArray( _stringip_, "." );
			for (int index = 0; index < __string__.length; index++) {
				__hex__.append( int2string( Integer.parseInt( __string__[index]), 3 ) );
			}
			return __hex__.toString();
		}
		
		/**
		 * 
		 * @param aOBJECT
		 * @return
		 */
		public static byte[] object2byte( Object aOBJECT ) {
			byte bytes[] = null;
			ByteArrayOutputStream byteOutput = null;
			ObjectOutputStream objectOutput = null; 
			try
			{
				byteOutput = new  ByteArrayOutputStream(); 
				objectOutput = new ObjectOutputStream( byteOutput );
				objectOutput.writeObject( aOBJECT );
				bytes = byteOutput.toByteArray();
			}
			catch( java.lang.Exception exception ){
				throw new java.lang.RuntimeException( exception.getMessage(), exception );
			}
			finally{
				try{
					if( objectOutput != null ){ objectOutput.close(); objectOutput = null;}
					if( byteOutput != null ){ byteOutput.close(); byteOutput = null;}
				}
				catch( java.lang.Exception exception ){}
			}
			return bytes;
		}

		/**
		 * 
		 * @param bytes
		 * @return
		 */
		public static Object byte2object( byte bytes[] ) {
			Object object = null;
			ByteArrayInputStream byteInput =  null;  
			ObjectInputStream ObjectInput = null; 
			try
			{
				byteInput = new ByteArrayInputStream( bytes );
				ObjectInput = new  ObjectInputStream( byteInput );
				object = ObjectInput.readObject();
			}
			catch( java.lang.Exception exception ){
				throw new java.lang.RuntimeException( exception.getMessage(), exception );
			}
			finally{
				try{
					if( ObjectInput != null ){ ObjectInput.close(); ObjectInput = null;}
					if( byteInput != null ){ byteInput.close(); byteInput = null;}
				}
				catch( java.lang.Exception exception ){}
			}
			return object;
		}
		
		/**
		 * 
		 * @param aMultiple
		 * @return
		 */
		public static long decimal( int aMultiple ){
			long fromDecimal = 1;
			while( aMultiple > 0 ){
				fromDecimal *= 10;
				aMultiple -= 1;
			}
			return fromDecimal;
		}
		
		/**
		 * 
		 * @param aPrefix
		 * @param aSequence
		 * @param aFixL
		 * @return
		 */
		public static String sequence(String aPrefix,  long aSequence, int aFixL){
			StringBuilder fromAsL = new StringBuilder();
			if( aFixL <= 0 ){
				fromAsL.append( aSequence );
			}
			else if( aFixL <= 8 ){
				aSequence = aSequence % IMath.decimal( aFixL );
				fromAsL.append( StringUtils.filling( String.valueOf( aSequence ), 
						aFixL, 
						StringUtils.RIGHT, 
						'0' ) );
			}
			else if( aFixL <= 15 ){
				if( aPrefix != null ) fromAsL.append( aPrefix );
				aSequence = aSequence % IMath.decimal( aFixL - fromAsL.length() );
				fromAsL.append( StringUtils.filling( String.valueOf( aSequence ), 
						aFixL - fromAsL.length(), 
						StringUtils.RIGHT, 
						'0' ) );
			}
			else{
				if( aPrefix != null ) fromAsL.append( aPrefix );
				java.sql.Timestamp fromCREATE = new java.sql.Timestamp( System.currentTimeMillis() );
				fromAsL.append( TimeUtils.format( fromCREATE, "MMdd" ) );
				aSequence = aSequence % IMath.decimal( aFixL - fromAsL.length() );
				fromAsL.append( StringUtils.filling( String.valueOf( aSequence ), 
				    		   aFixL - fromAsL.length(), 
				    		   StringUtils.RIGHT, 
						       '0' ) );
			}
			return fromAsL.toString();
		}
	}
}
