package com.ai.sacenter.provision;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.core.IUpdcpmCapital;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.dbcp.IUpffmxCapital;
import com.ai.sacenter.provision.dbcp.IUpfwmCapital;
import com.ai.sacenter.provision.dbcp.IUpfwmProtocol;
import com.ai.sacenter.provision.service.interfaces.IUpdcpmSRV;
import com.ai.sacenter.provision.service.interfaces.IUpdfmxSRV;
import com.ai.sacenter.provision.service.interfaces.IUpffmSRV;
import com.ai.sacenter.provision.service.interfaces.IUpffmxSRV;
import com.ai.sacenter.provision.service.interfaces.IUpfwmSRV;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.provision.service.interfaces.IUpdfwmSRV;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元工单内部服务</p>
 * <p>Copyright: Copyright (c) 2014-4-21</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmFactory {

	public IUpfwmFactory() {
		super();
	}
	/**
	 * 获取网元能力服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpmSRV getIUpdcpmSV() throws SFException,Exception{
		return (IUpdcpmSRV)UpfsvcFactory.getService( IUpdcpmSRV.class );
	}
	/**
	 * 根据接口类获取网元能力服务
	 * @param fromIMPLCLASS 接口类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpmCapital getIUpdcpmSV( String fromIMPLCLASS )  throws SFException,Exception{
		return (IUpdcpmCapital)UpfsvcFactory.getService( fromIMPLCLASS, 
				IUpdcConst.IEnum.IInvoke.SingletonT, 
				IUpdcpmCapital.class.getName(), 
				fromIMPLCLASS );
	}
	/**
	 * 获取网元工单服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfwmSRV getIUpfwmSV() throws SFException,Exception{
		return (IUpfwmSRV)UpfsvcFactory.getService( IUpfwmSRV.class );
	}
	/**
	 * 获取网元逻辑指令服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdfwmSRV getIUpdfwmSV() throws SFException,Exception{
		return (IUpdfwmSRV)UpfsvcFactory.getService( IUpdfwmSRV.class );
	}
	/**
	 * 根据接口类获取网元插件资产
	 * @param fromJAVA 接口类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfwmCapital getIUpdfwmSV( String fromJAVA ) throws SFException,Exception{
		return (IUpfwmCapital)UpfsvcFactory.getService( fromJAVA , 
				IUpdcConst.IEnum.IInvoke.Singleton, 
				IUpfwmCapital.class.getName(), 
				fromJAVA );
	}
	/**
	 * 获取网元定单服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpffmSRV getIUpffmSV() throws SFException,Exception{
		return (IUpffmSRV)UpfsvcFactory.getService( IUpffmSRV.class );
	}
	/**
	 * 获取网元到期服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdfmxSRV getIUpdfmxSV() throws SFException,Exception{
		return (IUpdfmxSRV)UpfsvcFactory.getService( IUpdfmxSRV.class );
	}
	/**
	 * 获取网元到期插件资产
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpffmxSRV getIUpffmxSV() throws SFException,Exception{
		return (IUpffmxSRV)UpfsvcFactory.getService( IUpffmxSRV.class );
	}
	/**
	 * 根据网元编码获取网元到期插件资产
	 * @param aPLATFORM 网元编码
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpffmxCapital getIUpffmxSV( String aPLATFORM ) throws SFException,Exception{
		IUpffmxCapital fromUpffmxImpl = null;
		try
		{
			IPlatformTemplate.IUpffmOffer fromUpffm[] = null;
			IPlatformTemplate.IUpffmOffer.LittleEndian fromUpffmx = null;
			fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmParent( aPLATFORM );
			for( int index = fromUpffm.length - 1 ; fromUpffm != null && index >= 0 ; index-- ){
				if( StringUtils.isBlank( fromUpffm[index].getENDIAN().getPROVISION() ) == false ){
					fromUpffmx = fromUpffm[index].getENDIAN();
					break;
				}
			}
			if( fromUpffmx == null ) ExceptionFactory.throwIllegal( "IOS0011085", new String[]{ aPLATFORM } );
			fromUpffmxImpl = (IUpffmxCapital)UpfsvcFactory.getService( fromUpffmx.getPROVISION(), 
					IUpdcConst.IEnum.IInvoke.SingletonT, 
					IUpffmxCapital.class.getName(), 
					fromUpffmx.getPROVISION() );
		}
		finally{
			
		}
		return fromUpffmxImpl;
	}
	/**
	 * 根据接口类获取网元协议资产
	 * @param fromJAVA 接口类
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfwmProtocol getIUpdcpSV( String fromJAVA ) throws SFException,Exception{
		return (IUpfwmProtocol)UpfsvcFactory.getService( fromJAVA , 
				IUpdcConst.IEnum.IInvoke.SingletonT, 
				IUpfwmProtocol.class.getName(), 
				fromJAVA );
	}
}
