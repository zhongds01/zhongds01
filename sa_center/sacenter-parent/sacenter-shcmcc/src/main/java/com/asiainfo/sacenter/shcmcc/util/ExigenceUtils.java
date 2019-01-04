package com.asiainfo.sacenter.shcmcc.util;

import com.ai.common.util.EncryptUtil;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.provision.IUpfwmConst;
import com.ai.sacenter.provision.UpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;

/**
 * 
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年3月30日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ExigenceUtils {
	public ExigenceUtils(){
		super();
	}
	
	public static class ICustom{
		public ICustom(){
			super();
		}

		/**
		 * 构造报文
		 * @param aUSER_ID
		 * @param aBILL_ID
		 * @return
		 * @throws Exception
		 */
		public static IOVUpfwmOffer _jj_provision( long aUSER_ID,
											  String aBILL_ID,
											  String aREGION_ID,
											  String aPLATFORM,
											  String aDIRECTIVE) throws Exception{
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				fromUpfwm = new IOVUpfwmOffer();
				IPlatformTemplate.IUpffmOperate fromUpfom = null;
				IPlatformTemplate.IUpffmDirective fromUpdfwm = null;
				IPlatformTemplate.IUpffmOffer fromUpffm = null;
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromUpfwm.setPS_ID      ( UpfwmFactory.getIUpfwmDAO().getPS_ID ()  );
				fromUpfwm.setDONE_CODE  ( String.valueOf( fromMBean.getORDER_ID() ) );
				fromUpfwm.setCUST_ORDER ( String.valueOf( fromMBean.getORDER_ID() ) );
				fromUpfwm.setORDER_ID   ( UpdcFactory.getIUpdcDAO().getORDER_ID () );
				fromUpfwm.setTASK_ID    ( fromUpfwm.getORDER_ID()                   );

				fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( aPLATFORM );
				fromUpdfwm = IUpdcfgFactory.getIUpffmSV().getSFUpffmLogical(aDIRECTIVE, fromUpffm);
				fromUpfom = IUpdcfgFactory.getIUpffmSV().getSFUpffmOperate(fromUpdfwm.getOPERATE_(), fromUpffm);
				fromUpfwm.setCATEGORY   ( fromUpfom.getCATEGORY()                  );

				fromUpfwm.setUSER_ID    ( aUSER_ID                                 );
				fromUpfwm.setREGION_ID  ( aREGION_ID                               );
				fromUpfwm.setPRIORITY   ( IUpdbfsConst.IUpdbm.ICustom.PRIORITY     );
				fromUpfwm.setCREATE_DATE( fromMBean.getCREATE()                    );
				fromUpfwm.setBILL_ID    ( aBILL_ID                                 );
				fromUpfwm.setPLATFORM   ( aPLATFORM                                );
				fromUpfwm.setDIRECTIVE  ( aDIRECTIVE                               );
				fromUpfwm.setSTART_DATE ( fromMBean.getCREATE()                    );
				fromUpfwm.setPS_STATUS  ( IUpfwmConst.IUpdos.CREATE                );
				fromUpfwm.setRETRY_TIMES( fromUpfom.getREDO_TIMES               () );
				fromUpfwm.setSUB_PLAN_NO( fromMBean.getORDER_ID()                  );
				fromUpfwm.setCOMPOSITE  ( fromUpfom.getCOMPOSITE                () );
				fromUpfwm.setORDER_DATE ( fromMBean.getCREATE                   () );
			}
			finally{

			}
			return fromUpfwm;
		}
	}

	public static class RC2{
		public RC2(){
			super();
		}
	    /**
	     * 用户账号密码解密
	     * @param fromPSWD
	     * @return
	     * @throws Exception
	     */
	    public static String _password( String fromPSWD ) throws Exception{
	    	StringBuilder fromUpffmx = null;
	    	try
	    	{
	    		if( StringUtils.isBlank( fromPSWD ) || fromPSWD.length() < 48 ){
	    			fromUpffmx = fromPSWD != null?new StringBuilder(fromPSWD):null;
	    		}
	    		else if( fromPSWD.length() == 48 ){
	    			fromUpffmx = new StringBuilder( EncryptUtil.decrypt( fromPSWD ) );
	    		}
	    		else{
	    			fromUpffmx = new StringBuilder( );
	    			fromUpffmx.append( EncryptUtil.decrypt( fromPSWD.substring( 0, 48 ) ) )
	    			          .append( fromPSWD.substring( 48, fromPSWD.length() ) );
	    		}
	    	}
	    	finally{
	    		
	    	}
	    	return fromUpffmx != null?fromUpffmx.toString():null;
	    }
	}
}
