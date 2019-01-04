package com.ai.sacenter.util;

import com.ai.appframe2.bo.DataContainer;
import com.ai.common.util.EncryptUtil;
import com.ai.sacenter.jdbc.HQSQLEntityBean;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: 加密解密算法</p>
 * <p>Copyright: Copyright (c) 2014-3-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class EncryptUtils {
	private static java.net.InetSocketAddress HOST = null;
    static{
    	try
    	{
    		HOST = new java.net.InetSocketAddress( java.net.InetAddress.getLocalHost() , 0 );
    	}
    	catch( java.lang.Exception tt){
    		HOST = new java.net.InetSocketAddress( "127.0.0.0", 0 );
    	}
    }
    
	public EncryptUtils() {
		super();
	}
	
	/***
	 * 加密
	 * @param str
	 * @return
	 */
	public static String encrypt(String str)
	{
	    int i;
	    int tmpch;
	    StringBuilder enStrBuff = new StringBuilder();
	    for(i = 0;i <str.length();i++)
	    {
	       tmpch = (int)str.charAt(i);
	       tmpch = tmpch^0x01;
	       tmpch = tmpch^0x0a;
           enStrBuff.append(Integer.toHexString(tmpch));
	    }
        return enStrBuff.toString().toUpperCase();
	}
	
    /***
     * 解密
     * @param str
     * @return
     */
	public static String decrypt(String str)
	{
        int tmpch;
	    String deStr = str.toLowerCase();
	    StringBuilder deStrBuff = new StringBuilder();
	    for (int i=0;i<deStr.length();i+=2)
	    {
	       String subStr  = deStr.substring(i,i+2);
	       tmpch = Integer.parseInt(subStr,16);
	       tmpch = tmpch^0x01;
	       tmpch = tmpch^0x0a;
	       deStrBuff.append((char)tmpch);
	    }
	    return deStrBuff.toString();
	}
	
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * 
		 * @param _loggerfile
		 * @param _context
		 */
		public static void userlog( String _loggerfile, Object _context ){
			java.io.PrintWriter _userlogger = null;
			try
			{
				if( StringUtils.isBlank( _loggerfile ) ){ _loggerfile = "temp"; }
				if( StringUtils.contains( _loggerfile , "/" ) == false && System.getProperties().containsKey( "ucmframe.userlog.path" )){
					_loggerfile = System.getProperty("ucmframe.userlog.path") + _loggerfile;
				}
				if( FileUtils.IFile.isExistDirectory( StringUtils.left( _loggerfile ,StringUtils.lastIndexOf( _loggerfile ,"/" ))) ){
					_loggerfile = ClassUtils.getINDEX( new String[]{ _loggerfile, ".log.", TimeUtils.format( new java.util.Date(), "MMddyy" ) } );
					String _prefix = ClassUtils.getINDEX( new String[]{ TimeUtils.format( new java.util.Date(), "HHmmss" ), ".",
							HOST.getAddress().getHostAddress(), ".", String.valueOf( HOST.getPort() ), ".1.0:" } );
					_userlogger = new java.io.PrintWriter(new java.io.FileOutputStream( _loggerfile ,true ) );
					if( _context instanceof java.lang.Object[] ){
						for( int index = 0; index < ((Object[])_context).length; index++ ){
							IFile._userlog( _userlogger, _prefix, ((Object[])_context)[index] );
						}
					}
					else{
						IFile._userlog( _userlogger, _prefix, _context );
					}
					_userlogger.flush();_userlogger.close();
					_userlogger = null;
				}
			}
			catch( java.lang.Exception exception ){
				
			}
			finally{
				if( _userlogger != null ) { _userlogger.close() ; _userlogger = null;}
			}
		}
		
		private static class IFile{
			private IFile(){
				super();
			}
		    
			/**
			 * 
			 * @param _userlogger
			 * @param _prefix
			 * @param _context
			 */
			private static void _userlog( java.io.PrintWriter _userlogger , String _prefix , Object _context ){
				if( _context == null ){
					_userlogger.println( _prefix + " NULL" );
				}
				else if( _context instanceof Exception ){
					java.lang.Exception exception = (java.lang.Exception)_context;
					if( StringUtils.isBlank( exception.getMessage() ) == false ){
						_userlogger.println( _prefix + " " + exception.getMessage() );
					}
					exception.printStackTrace( _userlogger );
				}
				else if( _context instanceof java.lang.Class ){
					java.lang.Class _class = (java.lang.Class)_context;
					_userlogger.println( _prefix + " " + _class.toString() );
				}
				else if( ClassUtils.IClass.isPrimitive( _context ) ){
					_userlogger.println( _prefix + " " + _context );
				}
				else if( _context instanceof java.util.Map ){
					java.util.Map _map = (java.util.Map)_context;
					for(java.util.Iterator itera = _map.entrySet().iterator(); itera.hasNext() ; ){
						java.util.Map.Entry _entry = (java.util.Map.Entry)itera.next();
						IFile._userlog( _userlogger, _prefix + " " + _entry.getKey(), _entry.getValue() );
					}
				}
				else if( _context instanceof java.util.List ){
					java.util.List _list = (java.util.List)_context;
					for(java.util.Iterator itera = _list.iterator(); itera.hasNext() ; ){
						Object _objective = itera.next();
						IFile._userlog( _userlogger, _prefix , _objective );
					}
				}
				else if( _context instanceof java.util.Set ){
					java.util.Set _set = (java.util.Set)_context;
					for(java.util.Iterator itera = _set.iterator(); itera.hasNext() ; ){
						Object _objective = itera.next();
						IFile._userlog( _userlogger, _prefix , _objective );
					}
				}
				else if( _context instanceof DataContainer ){
					DataContainer _data = (DataContainer)_context;
					for(java.util.Iterator itera = _data.getProperties().entrySet().iterator(); itera.hasNext() ; ){
						java.util.Map.Entry _entry = (java.util.Map.Entry)itera.next();
						IFile._userlog( _userlogger, _prefix + " " + _entry.getKey(), _entry.getValue() );
					}
				}
				else if( _context instanceof HQSQLEntityBean ){
					HQSQLEntityBean _data = (HQSQLEntityBean)_context;
					for(java.util.Iterator itera = _data.getProperties().entrySet().iterator(); itera.hasNext() ; ){
						java.util.Map.Entry _entry = (java.util.Map.Entry)itera.next();
						IFile._userlog( _userlogger, _prefix + " " + _entry.getKey(), _entry.getValue() );
					}
				}
				else{
					IBeanWrapper _wrapper = new IBeanWrapper( _context );
					java.beans.PropertyDescriptor _descriptors[] = _wrapper.getPropertyDescriptors();
					for(int index = 0 ; _descriptors != null && index < _descriptors.length ; index++ ){
						try
						{
							IFile._userlog( _userlogger, _prefix + " " +  _descriptors[index].getName(), 
									_wrapper.getPropertyValue( _descriptors[index].getName() ) );
						}
						catch( java.lang.Exception exception ){
							IFile._userlog( _userlogger, _prefix, exception );
						}
					}
				}
			}
		}
	}

	public static class RC2{
		public RC2(){
			super();
		}
		
		/**
		 * RC2加密
		 * @param encrypt
		 * @return
		 * @throws Exception
		 */
	    public static String encrypt( String encrypt ) throws Exception{
	    	return EncryptUtil.encrypt( encrypt );
	    }
		
	    /**
		 * RC2解密
		 * @param decrypt
		 * @return
		 * @throws Exception
		 */
	    public static String decrypt( String decrypt )  throws Exception{
	    	return EncryptUtil.decrypt( decrypt );
	    }
	}

	public static class MD5{
		public MD5(){
			super();
		}
		
		/**
	     * 
	     * @param aRawByte
	     * @return
	     */
	    public static byte[] md5( byte[] aRawByte ){
	    	java.security.MessageDigest messageDigest = null;
			try {
				messageDigest = java.security.MessageDigest.getInstance( "MD5" );
				messageDigest.update( aRawByte );
				return messageDigest.digest();
			}
	        catch( Exception tt ){
	            throw new RuntimeException( tt.getMessage(), tt );
	        }
	        finally{
				if( messageDigest != null){messageDigest.reset();messageDigest=null;}
			}	        
	    }
	}

	public static class IDEA{
		public IDEA(){
			super();
		}
		
		/**
		 * 
		 * @param bytekey
		 * @param inputBytes
		 * @param flag
		 * @return
		 */
		private static byte[] encrypt(byte[] bytekey, byte[] inputBytes, boolean flag) {
	        byte[] encryptCode = new byte[8];
	        // 分解子密钥
	        int[] key = get_subkey(flag, bytekey);
	        // 进行加密操作
	        encrypt(key, inputBytes, encryptCode);
	        // 返回加密数据
	        return encryptCode;
	    }
		
		/**
		 * 
		 * @param inBytes
		 * @param startPos
		 * @return
		 */
	    private static int bytesToInt(byte[] inBytes, int startPos) {
	        return ((inBytes[startPos] << 8) & 0xff00) +
	        (inBytes[startPos + 1] & 0xff);
	    }
        
	    /**
         * 
         * @param inputInt
         * @param outBytes
         * @param startPos
         */
	    private static void intToBytes(int inputInt, byte[] outBytes, int startPos) {
	        outBytes[startPos] = (byte) (inputInt >>> 8);
	        outBytes[startPos + 1] = (byte) inputInt;
	    }
        
	    /**
         * 
         * @param x
         * @param y
         * @return
         */
	    private static int x_multiply_y(int x, int y) {
	        if (x == 0) {
	            x = 0x10001 - y;
	        } else if (y == 0) {
	            x = 0x10001 - x;
	        } else {
	            int tmp = x * y;
	            y = tmp & 0xffff;
	            x = tmp >>> 16;
	            x = (y - x) + ((y < x) ? 1 : 0);
	        }

	        return x & 0xffff;
	    }
        
	    /**
         * 
         * @param key
         * @param inbytes
         * @param outbytes
         */
	    private static void encrypt(int[] key, byte[] inbytes, byte[] outbytes) {
	        int k = 0;
	        int a = bytesToInt(inbytes, 0);
	        int b = bytesToInt(inbytes, 2);
	        int c = bytesToInt(inbytes, 4);
	        int d = bytesToInt(inbytes, 6);

	        for (int i = 0; i < 8; i++) {
	            a = x_multiply_y(a, key[k++]);
	            b += key[k++];
	            b &= 0xffff;
	            c += key[k++];
	            c &= 0xffff;
	            d = x_multiply_y(d, key[k++]);

	            int tmp1 = b;
	            int tmp2 = c;
	            c ^= a;
	            b ^= d;
	            c = x_multiply_y(c, key[k++]);
	            b += c;
	            b &= 0xffff;
	            b = x_multiply_y(b, key[k++]);
	            c += b;
	            c &= 0xffff;
	            a ^= b;
	            d ^= c;
	            b ^= tmp2;
	            c ^= tmp1;
	        }
	        intToBytes(x_multiply_y(a, key[k++]), outbytes, 0);
	        intToBytes(c + key[k++], outbytes, 2);
	        intToBytes(b + key[k++], outbytes, 4);
	        intToBytes(x_multiply_y(d, key[k]), outbytes, 6);
	    }
	    
        /**
         * 
         * @param byteKey
         * @return
         */
	    private static int[] encrypt_subkey(byte[] byteKey) {
	        int[] key = new int[52];

	        if (byteKey.length < 16) {
	            byte[] tmpkey = new byte[16];
	            System.arraycopy(byteKey, 0, tmpkey,
	                tmpkey.length - byteKey.length, byteKey.length);
	            byteKey = tmpkey;
	        }

	        for (int i = 0; i < 8; i++) {
	            key[i] = bytesToInt(byteKey, i * 2);
	        }

	        for (int j = 8; j < 52; j++) {
	            if ((j & 0x7) < 6) {
	                key[j] = (((key[j - 7] & 0x7f) << 9) | (key[j - 6] >> 7)) &
	                    0xffff;
	            } else if ((j & 0x7) == 6) {
	                key[j] = (((key[j - 7] & 0x7f) << 9) | (key[j - 14] >> 7)) &
	                    0xffff;
	            } else {
	                key[j] = (((key[j - 15] & 0x7f) << 9) | (key[j - 14] >> 7)) &
	                    0xffff;
	            }
	        }

	        return key;
	    }
	    
        /**
         * 
         * @param a
         * @return
         */
	    private static int fun_a(int a) {
	        if (a < 2) {
	            return a;
	        }

	        int b = 1;
	        int c = 0x10001 / a;

	        for (int i = 0x10001 % a; i != 1;) {
	            int d = a / i;
	            a %= i;
	            b = (b + (c * d)) & 0xffff;

	            if (a == 1) {
	                return b;
	            }

	            d = i / a;
	            i %= a;
	            c = (c + (b * d)) & 0xffff;
	        }

	        return (1 - c) & 0xffff;
	    }
	    
        /**
         * 
         * @param b
         * @return
         */
	    private static int fun_b(int b) {
	        return (0 - b) & 0xffff;
	    }
        
	    /**
         * 
         * @param key
         * @return
         */
	    private static int[] uncrypt_subkey(int[] key) {
	        int dec = 52;
	        int asc = 0;
	        int[] unkey = new int[52];
	        int aa = fun_a(key[asc++]);
	        int bb = fun_b(key[asc++]);
	        int cc = fun_b(key[asc++]);
	        int dd = fun_a(key[asc++]);
	        unkey[--dec] = dd;
	        unkey[--dec] = cc;
	        unkey[--dec] = bb;
	        unkey[--dec] = aa;

	        for (int k1 = 1; k1 < 8; k1++) {
	            aa = key[asc++];
	            bb = key[asc++];
	            unkey[--dec] = bb;
	            unkey[--dec] = aa;
	            aa = fun_a(key[asc++]);
	            bb = fun_b(key[asc++]);
	            cc = fun_b(key[asc++]);
	            dd = fun_a(key[asc++]);
	            unkey[--dec] = dd;
	            unkey[--dec] = bb;
	            unkey[--dec] = cc;
	            unkey[--dec] = aa;
	        }

	        aa = key[asc++];
	        bb = key[asc++];
	        unkey[--dec] = bb;
	        unkey[--dec] = aa;
	        aa = fun_a(key[asc++]);
	        bb = fun_b(key[asc++]);
	        cc = fun_b(key[asc++]);
	        dd = fun_a(key[asc]);
	        unkey[--dec] = dd;
	        unkey[--dec] = cc;
	        unkey[--dec] = bb;
	        unkey[--dec] = aa;

	        return unkey;
	    }
	    
        /**
         * 
         * @param flag
         * @param bytekey
         * @return
         */
	    private static int[] get_subkey(boolean flag, byte[] bytekey) {
	        if (flag) {
	            return encrypt_subkey(bytekey);
	        } else {
	            return uncrypt_subkey(encrypt_subkey(bytekey));
	        }
	    }
	    
	    /**
	     * IDEA加密
	     * @param idea_data
	     * @param idea_key
	     * @return
	     */
	    public static byte[] encrypt( byte[] idea_data , byte[] idea_key ){
	    	byte retdata[] = null;
	    	try
	    	{
	    		if( idea_key ==  null || idea_key.length != 16 ) throw new IllegalArgumentException(" idea encrypt key length must 16");
		    	if( idea_data ==  null || idea_data.length%8 != 0 ) throw new IllegalArgumentException(" idea encrypt data length must be a multiple of 8");
		    	retdata = new byte[idea_data.length];
			    for (int i = 0; i < idea_data.length/8; i++) {
			    	byte[] tmpkey = new byte[16];
			        byte[] tmpdata = new byte[8];
			        System.arraycopy(idea_key, 0, tmpkey, 0, 16);
			        System.arraycopy(idea_data, i * 8, tmpdata, 0, 8);
			        byte[] tmpresult = encrypt(tmpkey, tmpdata, true);
			        System.arraycopy(tmpresult, 0, retdata, i * 8, 8);
			    }
	    	}
	    	finally{
	    		
	    	}
	    	return retdata;
	    }
	    
	    /**
	     * IDEA解密
	     * @param idea_data
	     * @param idea_key
	     * @return
	     */
	    public static byte[] decrypt( byte[] idea_data , byte[] idea_key ){
	    	byte retdata[] = null;
	    	try
	    	{
	    		if( idea_key ==  null || idea_key.length != 16 ) throw new IllegalArgumentException(" idea encrypt key length must 16");
		    	if( idea_data ==  null || idea_data.length%8 != 0 ) throw new IllegalArgumentException(" idea encrypt data length must be a multiple of 8");
		    	retdata = new byte[idea_data.length];
			    for (int i = 0; i < idea_data.length/8; i++) {
			    	byte[] tmpkey = new byte[16];
			        byte[] tmpdata = new byte[8];
			        System.arraycopy(idea_key, 0, tmpkey, 0, 16);
			        System.arraycopy(idea_data, i * 8, tmpdata, 0, 8);
			        byte[] tmpresult = encrypt(tmpkey, tmpdata, false);
			        System.arraycopy(tmpresult, 0, retdata, i * 8, 8);
			    }
	    	}
	    	finally{
	    		
	    	}
	    	return retdata;
	    }
	}
	
	public static class AES{
		public AES(){
			super();
		}
		
		/**
		 * 加密
		 * @param content
		 * @param aKeys
		 * @return
		 * @throws Exception
		 */
		public static byte[] encrypt(byte[] content, byte[] aKeys) throws Exception{
			javax.crypto.KeyGenerator kgen = javax.crypto.KeyGenerator.getInstance("AES");   
            kgen.init(128, new java.security.SecureRandom(aKeys) );   
            javax.crypto.SecretKey secretKey = kgen.generateKey();   
            byte[] enCodeFormat = secretKey.getEncoded();   
            javax.crypto.spec.SecretKeySpec key = new javax.crypto.spec.SecretKeySpec(enCodeFormat, "AES");   
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");// 创建密码器   
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);// 初始化   
            return cipher.doFinal(content); 
		}
		
		/**
		 * 解密
		 * @param content
		 * @param aKeys
		 * @return
		 * @throws Exception
		 */
		public static byte[] decrypt( byte[] content, byte[] aKeys ) throws Exception{
			javax.crypto.KeyGenerator kgen = javax.crypto.KeyGenerator.getInstance("AES");   
            kgen.init(128, new java.security.SecureRandom( aKeys ));   
            javax.crypto.SecretKey secretKey = kgen.generateKey();   
            byte[] enCodeFormat = secretKey.getEncoded();   
            javax.crypto.spec.SecretKeySpec key = new javax.crypto.spec.SecretKeySpec(enCodeFormat, "AES");               
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");// 创建密码器   
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);// 初始化   
            return cipher.doFinal(content); 
		}
	}
	
	public static class DES{
		public DES(){
			super();
		}
		
		/**
		 * 加密
		 * @param _password_ 待加密
		 * @param _securekey_ 密匙
		 * @return
		 * @throws Exception
		 */
		public static byte[] encrypt(byte[] _password_, String _securekey_) throws Exception{
			java.security.SecureRandom random = new java.security.SecureRandom();
			javax.crypto.spec.DESKeySpec desKey = new javax.crypto.spec.DESKeySpec( _securekey_.getBytes() );
			javax.crypto.SecretKeyFactory keyFactory = javax.crypto.SecretKeyFactory.getInstance("DES");
			javax.crypto.SecretKey securekey = keyFactory.generateSecret(desKey);
			javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES");
	        cipher.init( javax.crypto.Cipher.ENCRYPT_MODE, securekey, random );
	        return cipher.doFinal( _password_ );
		}
		
		/**
		 * 解密
		 * @param _password_
		 * @param _securekey_ 密匙
		 * @return
		 * @throws Exception
		 */
		public static byte[] decrypt(byte[] _password_, String _securekey_) throws Exception{
			java.security.SecureRandom random = new java.security.SecureRandom();
			javax.crypto.spec.DESKeySpec desKey = new javax.crypto.spec.DESKeySpec( _securekey_.getBytes() );
			javax.crypto.SecretKeyFactory keyFactory = javax.crypto.SecretKeyFactory.getInstance("DES");
			javax.crypto.SecretKey securekey = keyFactory.generateSecret( desKey );
			javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES");
	        cipher.init( javax.crypto.Cipher.DECRYPT_MODE, securekey, random );
	        return cipher.doFinal( _password_ );
		}
	}
	
	public static class IIdentity{
		public IIdentity(){
			super();
		}
		
		public static String getRandomBuffer(String expr, int count){
			StringBuilder sb = new StringBuilder();
			int boundary = 0;
			if("d".equals(expr)) boundary = 10;
			if("alpha".equals(expr)) boundary=26;
			if("ALPHA".equals(expr)) boundary=260;
			if("Alpha".equals(expr)) boundary=54;
			if(boundary == 0){
				return "";
			}
			if(boundary > 0){
				java.util.Random rdm = new java.util.Random();
				for (int i = 0; i < count; i++) {
					int rmdnum = Math.abs(rdm.nextInt());
					switch (boundary) {
					case 10:
						sb.append(rmdnum % boundary +"");
						break;
					case 26:
						sb.append((char)(rmdnum % boundary + 'a') + "");
						break;
					case 260:
						sb.append((char)(rmdnum % (boundary/10) + 'A') + "");
						break;
					default:
						int j = rmdnum % (boundary);
						if(j >=25){
							sb.append((char)(j + 'A') + "");
						}else{
							sb.append((char)(j + 'a') + "");
						}
						break;
					}
				}
			}
			return sb.toString();
		}
	}
}
