package com.ai.sacenter.common;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.IUpdcpFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpfgsmUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: WM模板语言</p>
 * <p>Copyright: Copyright (c) 2014-4-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmsSTKLocal {
	private static IUpfwmsSTKLocal INSTANCE = new IUpfwmsSTKLocal();
	private IUpfwmsSTKLocal(){
		super();
	}
	/**
	 * 
	 * @return
	 */
	public static IUpfwmsSTKLocal getINSTANCE(){
		return IUpfwmsSTKLocal.INSTANCE;
	}
	/**
	 * 根据模板规范生成模板内容
	 * @param fromID 模板规范编码
	 * @param fromMODULE 模板规范内容
	 * @param aUpdgcpLife 产品能力集,以IUpdgdspL键存放对象中
	 * @param aContext
	 * @return
	 * @throws Exception
	 */
	public String evaluate(String fromID,
			String fromMODULE , 
			java.util.Map fromOffer , 
			IUpdcContext aContext ) throws Exception{
		String aOBJECT = null;
		java.util.Map fromChain = new java.util.HashMap();
		try
		{
			IUpfwm.submit( null , fromOffer, fromChain, aContext );
			aOBJECT = IUpfwm.evaluate(fromID, 
					fromMODULE, 
					fromChain, 
					aContext);
		}
		finally{
			if( fromChain != null ){ fromChain.clear(); fromChain = null;}
		}
		return aOBJECT;
	}
	/**
	 * 根据模板规范生成模板内容
	 * @param fromID 模板规范编码
	 * @param fromMODULE 模板规范内容
	 * @param fromUpfgsm 其他属性集
	 * @param aUpdgcpLife 产品能力集,以IUpdgdspL键存放对象中
	 * @param aContext
	 * @return
	 * @throws Exception
	 */
	public String evaluate(String fromID,
			String fromMODULE , 
			java.util.Map fromUpfgsm,
			java.util.Map fromOffer , 
			IUpdcContext aContext ) throws Exception{
		String aOBJECT = null;
		java.util.Map fromChain = new java.util.HashMap();
		try
		{
			IUpfwm.submit( null , fromOffer, fromChain, aContext );
			IUpfwm.submit( fromUpfgsm, fromChain );
			aOBJECT = IUpfwm.evaluate(fromID, 
					fromMODULE, 
					fromChain, 
					aContext);
		}
		finally{
			if( fromChain != null ){ fromChain.clear(); fromChain = null;}
		}
		return aOBJECT;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2014-4-14</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwm{
		public IUpfwm(){
			super();
		}
		/**
		 * 
		 * @param fromOffer
		 * @param fromChain
		 * @throws SFException
		 * @throws Exception
		 */
		public static void submit( java.util.Map fromOffer , 
				java.util.Map fromChain ) throws SFException,Exception{
			try
			{
				if( fromOffer != null && fromOffer.size() > 0 ){
					for(java.util.Iterator itera = fromOffer.entrySet().iterator() ; itera.hasNext() ; ){
						java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
						if( fromChain.containsKey( fromEntry.getKey() ) == false ){ 
							fromChain.put(fromEntry.getKey() , fromEntry.getValue());
						}
					}
				}
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param fromObject
		 * @param fromOffer
		 * @param fromChain
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static void submit( Object[][] fromObject , 
				java.util.Map fromOffer , 
				java.util.Map fromChain ,
				IUpdcContext aContext) throws SFException,Exception{
			try
			{
				for(int index = 0 ; fromObject !=  null && index < fromObject.length ; index++){ 
					fromChain.put( fromObject[index][0].toString(), fromObject[index][1]);
				}
				if( fromOffer != null && fromOffer.size() > 0 ){
					IUpfwm.submit( fromOffer, fromChain );
					fromChain.put( IUpdcConst.IUpdbm.IUpdbf.PARAM, fromOffer );
				}
				if( aContext != null ){ fromChain.put( IUpdcConst.IUpdbm.IUpdbf.LDPAP, aContext);}
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param fromID
		 * @param fromMODULE
		 * @param fromChain
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String evaluate( String fromID,
			String fromMODULE , 
			java.util.Map fromChain , 
			IUpdcContext aContext ) throws SFException,Exception{
			String fromPLMM = fromMODULE;
			try
			{
				String fromItemName[] = StringUtils.substring( fromPLMM , "^[", "^]" );
				for( int index = 0 ; fromItemName != null && index < fromItemName.length; index++ ){
					String fromItem = ClassUtils.getINDEX( new String[]{ "^[", fromItemName[index], "^]" });
					String fromCol = suddenly(fromID, fromItemName[index], fromChain, aContext);
					if( fromCol == null ){
						fromPLMM = StringUtils.replace( fromPLMM , fromItem , "" );
					}
					else{
						fromPLMM = StringUtils.replace( fromPLMM , fromItem , fromCol );
					}
				}
				fromItemName = StringUtils.substring( fromPLMM , "^<", "^>" );
				for( int index = 0 ; fromItemName != null && index < fromItemName.length; index++ ){
					String fromItem = ClassUtils.getINDEX( new String[]{ "^<", fromItemName[index], "^>" });
					String fromMAPPING = wrap( fromID, fromItem, fromChain , aContext );
					if( StringUtils.isBlank( fromMAPPING ) ){
						ExceptionFactory.throwIllegal("IOS0010012", new String[]{fromID,fromItemName[index]} );
					}
					fromPLMM = StringUtils.replace( fromPLMM , fromItem , fromMAPPING );
				}
				fromPLMM = StringUtils.isBlank( fromPLMM )?null:fromPLMM;
			}
			finally{
				
			}
			return fromPLMM;
		}
		/**
		 * 
		 * @param fromID
		 * @param fromItemName
		 * @param fromChain
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		private static String suddenly( String fromID,
				String fromItemName , 
				java.util.Map fromChain , 
				IUpdcContext aContext ) throws SFException,Exception{
			String fromPLMM = fromItemName;
			try
			{
				String fromItem[] = StringUtils.substring( fromItemName , "^<", "^>" );
				for( int index = 0 ; fromItem != null && index < fromItem.length; index++ ){
					fromItemName = ClassUtils.getINDEX( new String[]{ "^<", fromItem[index], "^>" });
					String fromOBJECT = wrap( fromID, fromItemName, fromChain , aContext );
					if( fromOBJECT == null ){ fromPLMM = null; break; }
					else{
						fromPLMM = StringUtils.replace( fromPLMM , fromItemName , fromOBJECT );
					}
				}
			}
			finally{
			
			}
			return fromPLMM;
		}
		/**
		 * 
		 * @param fromID
		 * @param fromItemName
		 * @param fromChain
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		private static String wrap(String fromID,
				String fromItemName , 
				java.util.Map fromChain , 
				IUpdcContext aContext ) throws SFException,Exception{
			Object aOBJECT = null;
			try
			{
				String aCOMPLEX[] = new String[]{StringUtils.substringBetwn( fromItemName , "^<", "^>")};
				if( UpfgsmUtils.IUpfsm.isVariable( aCOMPLEX[0] ) ){
					 aOBJECT = IUpdcpFactory.getIUpfwmSV().finishSFUpfvnChain( aCOMPLEX[0], 
							 fromChain, 
							 aContext );
				}
				else{
					aCOMPLEX = StringUtils.wildcardArray( aCOMPLEX[0] , "#" );
					aOBJECT =  UpfgsmUtils.IUpfsm._jj_context( aCOMPLEX[0], 
							fromChain, 
							aCOMPLEX[0], 
							aContext);
					if( aOBJECT == null && aCOMPLEX != null && aCOMPLEX.length > 1 ) aOBJECT = aCOMPLEX[1];
				}
				if( aOBJECT != null && ClassUtils.IClass.isPrimitive( aOBJECT.getClass() ) == false ){ 
					ExceptionFactory.throwIllegal("IOS0010011", new String[]{fromID,aCOMPLEX[0]}, null );
				}
			}
			finally{
				
			}
			return aOBJECT != null?aOBJECT.toString():null;
		}
	}
}
