package com.ai.sacenter.util;

import com.ai.sacenter.i18n.ExceptionFactory;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: 文件处理器</p>
 * <p>Copyright: Copyright (c) 2014-3-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */

public class FileUtils extends org.apache.commons.io.FileUtils{
	public FileUtils() {
		super();
	}
	/**
	 * 
	 * <p>Title: openframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-1-26</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IFile{
		public IFile(){
			super();
		}
		/***
		 * 创建文件系统目录
		 * @param aRootPath
		 * @param aSubPath
		 * @throws Exception
		 */
	    public static void mkdir( String aRootPath , 
	    		String aSubPath ) throws Exception{
	    	try
	    	{
	    		String aPaths[] = StringUtils.split( aSubPath , "." );
		    	for(int index = 0 ;index < aPaths.length ; index++){
		    		String aPath = aRootPath + "/" + aPaths[index];
		    		java.io.File aFILE = new java.io.File( aPath );
		    		if( aFILE.exists() == false ) aFILE.mkdir();
		    	}
	    	}
	    	finally{
	    		
	    	}
	    }
	    /***
	     * 根据文件名匹配查询当前以及其子目录下匹配文件
	     * @param aPROJECT_HOME
	     * @param pattern
	     * @return
	     * @throws Exception
	     */
	    public static java.io.File[] listSubFiles( String aPROJECT_HOME , String pattern ) throws Exception{
	    	java.util.List aOBJECT = new java.util.ArrayList();
	    	try
	    	{
	    		IIFile.listSubFiles( new java.io.File( aPROJECT_HOME ) , 
	    				pattern , 
	    				aOBJECT ) ;
	    	}
	    	finally{
	    		
	    	}
	    	return (java.io.File[])aOBJECT.toArray( new java.io.File[]{} );
	    }
	    /***
	     * 根据文件名匹配删除当前以及其子目录下匹配文件
	     * @param aPROJECT_HOME
	     * @param pattern
	     * @throws java.io.Exception
	     */
	    public static void deleteSubFile( String aPROJECT_HOME , 
	    		String pattern ) throws Exception{
	    	try
	    	{
	    		java.io.File aFILE[] = IFile.listSubFiles( aPROJECT_HOME , pattern );
		    	for(int index = 0; index < aFILE.length ; index++){
		    		aFILE[index].deleteOnExit();
		    		aFILE[index] = null;
		    	}
	    	}
	    	finally{
	    		
	    	}
	    }
	    /***
	     * 
	     * @param aFileName
	     * @param aContext
	     * @throws Exception
	     */
	    public static void writeFile( String aFileName , String aContext ) throws Exception{
	    	try
	    	{
	    		java.io.File aFILE = new java.io.File( aFileName );
	    		java.io.FileOutputStream fos = new java.io.FileOutputStream( aFILE );
	    		java.io.PrintStream ps = new java.io.PrintStream(fos, true, "UTF-8");
				ps.print(aContext);
				ps.flush(); ps.close(); ps = null;
				fos.close(); fos = null;
	    	}
	    	finally{
	    		
	    	}
	    }
	    /**
	     * 
	     * @param aPriFileName
	     * @param aFileName
	     * @param aEncoding
	     * @throws Exception
	     */
	    public static void writeFile( String aPriFileName , 
	    		String aFileName , 
	    		String aEncoding ) throws Exception{
	    	try
	    	{
	    		String aOBJECT[] = IFile.readLine( new java.io.FileInputStream(aPriFileName ) ) ;
	    		java.io.FileOutputStream fos = new java.io.FileOutputStream( aFileName );
	    		java.io.PrintStream ps = new java.io.PrintStream(fos, true, "UTF-8");
	    		int index = 0 ;
	    		while( index < aOBJECT.length ){
	    			ps.println( new String(aOBJECT[index].getBytes("GBK") , aEncoding) ); 
	    			index++;
	    		}
	    		ps.flush(); 
	    		ps.close(); ps = null;
	    		fos.close(); fos = null;
	    	}
	    	finally{
	    		
	    	}
	    }
	    /**
	     * 根据CLASSPATH环境下文件读取文件内容
	     * @param aFileName
	     * @return
	     * @throws Exception
	     */
	    public static byte[] readFile( String aFileName ) throws Exception{
	    	byte[] aBYTE = null;
	    	try
	    	{
	    		java.io.InputStream aInputStream = null;
	    		java.io.File aFile = new java.io.File( aFileName );
    			if( aFile != null && aFile.isFile() && aFile.exists() ){
    				aInputStream = new java.io.FileInputStream( aFile );
    			}
    			else{
    				aInputStream = ClassUtils.IClass.getClassLoaderResource( aFileName );
    			}
	    		if( aInputStream == null ) ExceptionFactory.throwIOException("IOS0010026", new String[]{aFileName});
	    		aBYTE = IFile.readFile( aInputStream );
	    	}
	    	finally{
	    		
	    	}
	    	return aBYTE;
	    }
	    /***
	     * 根据文件输入流读取文件内容
	     * @param in
	     * @return
	     * @throws Exception
	     */
	    public static byte[] readFile( java.io.InputStream in ) throws Exception{
	    	byte[] aBYTE = null;
	    	try
	    	{
	    		aBYTE = new byte[ in.available() ];
	    		if( aBYTE != null && aBYTE.length > 0 ){
		    		byte[] buffer = new byte[4098];
		    		int aINDEX = 0 ;
		    		int bytesRead = in.read( buffer );
		    		while( bytesRead != -1 ){
		    			System.arraycopy( buffer, 0 , aBYTE, aINDEX, bytesRead );
		    			aINDEX += bytesRead;
		 		    	bytesRead = in.read( buffer );
		    		}
		    	}
	    	}
	    	finally{
	    		
	    	}
	    	return aBYTE;
	    }
	    /***
	     * 
	     * @param aDirectory
	     * @return
	     */
	    public static boolean isExistDirectory( String aDirectory ){
	    	java.io.File aFile = new java.io.File( aDirectory );
	    	return aFile.isDirectory() && aFile.exists();
	    }
	    /**
	     * 
	     * @param aFileName
	     * @return
	     */
	    public static boolean isExistFile( String aFileName ){
	    	boolean m_bFile = false;
	    	try
	    	{
	    		java.io.File aFile = new java.io.File( aFileName );
		    	m_bFile = aFile.isFile() && aFile.exists();
		    	if( m_bFile == false/*不为文件路径,可能为类路径*/ ){
		    		m_bFile = Thread.currentThread().getContextClassLoader().getResourceAsStream( aFileName ) != null ?true:false;
		    	}
	    	}
	    	finally{
	    		
	    	}
	    	return m_bFile;
	    }
	    /***
	     * 
	     * @param aFileName
	     * @param aContext
	     * @throws Exception
	     */
	    public static void writeLine( String aFileName , String aContext ) throws Exception{
	    	try
	    	{
	    		java.io.File aFILE = new java.io.File( aFileName );
	    		java.io.FileOutputStream fos = new java.io.FileOutputStream( aFILE, true );
	    		java.io.PrintStream ps = new java.io.PrintStream(fos, true, "UTF-8");
				ps.println(aContext);
				ps.flush(); ps.close(); ps = null;
				fos.close(); fos = null;
	    	}
	    	finally{
	    		
	    	}
	    }
	    /**
	     * 
	     * @param aStream
	     * @return
	     * @throws Exception
	     */
	    public static String[] readLine( String aStream ) throws Exception{
	    	String aOBJECT[] = null;
	    	java.io.LineNumberReader reader = null;
			try
			{
				reader = new java.io.LineNumberReader( new java.io.StringReader( aStream ) );	  
				aOBJECT = IIFile.readLine( reader );
			}
			finally{
				try{ if( reader != null ){ reader.close();reader= null;}}
				catch( java.lang.Exception t){}
			}
	    	return aOBJECT;
	    }
	    /**
	     * 
	     * @param aStream
	     * @return
	     * @throws Exception
	     */
	    public static String[] readLine( java.io.InputStream aStream ) throws Exception{
	    	java.io.LineNumberReader reader = null;
			try {
				reader = new java.io.LineNumberReader(new java.io.InputStreamReader(aStream));	  
				return IIFile.readLine( reader );
			}
			finally{
				try{ if( reader != null ){ reader.close();reader= null;}}
				catch( java.lang.Exception t){}
			}
	    }
	}
    /**
     * 
     * <p>Title: openframe</p>
     * <p>Description: </p>
     * <p>Copyright: Copyright (c) 2011-1-26</p>
     * <p>Company: AI(NanJing)</p>
     * @author maohuiyun
     * @version 2.0 
     *
     */
    private static class IIFile{
    	/***
         * 
         * @param aPROJECT
         * @param pattern
         * @param aFILES
         * @throws Exception
         */
        private static void listSubFiles( java.io.File aPROJECT , 
        		String pattern , 
        		java.util.List aFILES ) throws Exception{
        	try
        	{
        		if( aPROJECT.exists() == false ) return;
            	java.io.File aISubFile[] = aPROJECT.listFiles();
            	if( aISubFile != null && aISubFile.length > 0 ){
            		for(int index = 0 ; index < aISubFile.length ; index++){
            			if( aISubFile[index].isFile() && StringUtils.wildcardMatch( aISubFile[index].getName() , pattern ) ) 
            				aFILES.add( aISubFile[index] );
            			else if( aISubFile[index].isDirectory() ){
            				listSubFiles( aISubFile[index] , 
            						pattern , 
            						aFILES );
            			}
            		}
            	}
        	}
        	finally{
        		
        	}
        }
        /**
         * 
         * @param aReader
         * @return
         * @throws Exception
         */
        public static String[] readLine( java.io.LineNumberReader aReader ) throws Exception{
        	java.util.List aOBJECT = new java.util.ArrayList();
        	try
        	{
        		String line;
    			while((line = aReader.readLine()) != null){
    				aOBJECT.add(line);
    			}
        	}
        	finally{
        		
        	}
        	return (String[])aOBJECT.toArray(new String[]{});
        }
    }
}
