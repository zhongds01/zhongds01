package com.ai.sacenter.cache.redis;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.base.platform.bo.ISAMisc;
import com.ai.sacenter.cache.SFCacheFactory;
import com.ai.sacenter.module.IConfigDefine;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.UpfgsmUtils;
import com.ai.sacenter.valuebean.IUpfgsmTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 即开即通映射模板缓存</p>
 * <tables><table>I_OPEN_MAPPING</table></tables>
 * <tables><table>I_OPEN_MAPPING_REL</table></tables>
 * <p>Copyright: Copyright (c) 2011-10-12</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IIMappingCacheImpl extends ISystemCacheImpl {

	public IIMappingCacheImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.cache.redis.ISystemCacheImpl#getCache()
	 */
	public java.util.HashMap getCache() throws Exception {
		java.util.HashMap fromUpfgsm = new java.util.HashMap();
		SFCacheFactory.getDeque().beginTransaction( this );
		try
		{
			_wrapWithMapping( fromUpfgsm );
			_wrapWithMisc( fromUpfgsm );
			SFCacheFactory.getDeque().commitTransaction();
		}
		catch( java.lang.Exception exception ){
			SFCacheFactory.getDeque().rollbackTransaction();
			throw exception;
		}
		finally{
			
		}
		return fromUpfgsm;
	}
	
	/**
	 * 
	 * @param fromUpfgsm
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithMapping( java.util.HashMap fromUpfgsm ) throws SFException,Exception{
		try
		{
			if( IConfigDefine.getINSTANCE().getConfigItem().getFILESYSTEM() /*基于文件映射*/){
				IConfigDefine.IModuleDefine.IModuleIDefine fromModule[] = IConfigDefine.getINSTANCE().getModule();
    			for( int index = 0 ; fromModule != null && index < fromModule.length; index++ ){
    				UpfgsmUtils.deployUpfsmFile( fromModule[index].getFILE() , fromUpfgsm );
    			}
			}
			else{
				java.util.HashMap _mappingdefine = BasicFactory.getIUpffmSV().getIUpffsmOffer();
				UpfgsmUtils.deployUpfsmOracle( _mappingdefine, fromUpfgsm );
			}
		}
		finally{
		
		}
	}
	
	/**
	 * 
	 * @param fromMisc
	 * @throws SFException
	 * @throws Exception
	 */
	protected void _wrapWithMisc( java.util.HashMap fromMisc ) throws SFException,Exception{
		try
		{
			java.util.List _miscdefine = BasicFactory.getIUpffmSV().getIUpffmMisc();
			for( java.util.Iterator itera = _miscdefine.iterator(); itera.hasNext(); ){
				ISAMisc _miscmapping = (ISAMisc)itera.next();
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_PLATFORM_MISC, new String[]{_miscmapping.getPlatform()} );
				IUpfgsmTemplate.IUpfgsmOffer fromUpfgsm = (IUpfgsmTemplate.IUpfgsmOffer)fromMisc.get( fromINDEX );
				if( fromUpfgsm == null ){ 
					fromMisc.put( fromINDEX, fromUpfgsm = new IUpfgsmTemplate.IUpfgsmOffer( _miscmapping ));
				}
				fromUpfgsm.mergeAsMisc( _miscmapping );
			}
		}
		finally{
			
		}
	}
}
