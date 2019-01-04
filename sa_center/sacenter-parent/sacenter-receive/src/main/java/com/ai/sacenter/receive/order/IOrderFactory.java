package com.ai.sacenter.receive.order;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.order.service.interfaces.ICustomSRV;
import com.ai.sacenter.receive.order.service.interfaces.IExpireSRV;
import com.ai.sacenter.receive.order.service.interfaces.IUrgencySRV;
import com.ai.sacenter.receive.order.service.interfaces.IOrdLdapSRV;
import com.ai.sacenter.receive.order.service.interfaces.IOrdMixSRV;
import com.ai.sacenter.receive.order.service.interfaces.IOrdOfferSRV;
import com.ai.sacenter.receive.order.service.interfaces.IOrderSRV;
import com.ai.sacenter.receive.order.service.interfaces.IProductSRV;

public class IOrderFactory {
	public IOrderFactory(){
		super();
	}
	/**
     * 开通定单[内部服务]
     * @return
     * @throws Exception
     */
	public static IOrderSRV getIOrderSV() throws Exception{
		return (IOrderSRV)UpfsvcFactory.getService(IOrderSRV.class);
	}
	/**
	 * 客户中心[内部服务]
	 * @return
	 * @throws Exception
	 */
	public static ICustomSRV getICustomSV() throws Exception{
		return (ICustomSRV)UpfsvcFactory.getService(ICustomSRV.class);
	}
	/**
	 * 用户到期工单[内部服务]
	 * @return
	 * @throws Exception
	 */
	public static IExpireSRV getIExpireSV() throws Exception{
		return (IExpireSRV)UpfsvcFactory.getService(IExpireSRV.class);
	}
	/**
	 * 产品中心[内部服务]
	 * @return
	 * @throws Exception
	 */
	public static IProductSRV getIProductSV() throws Exception{
		return (IProductSRV)UpfsvcFactory.getService(IProductSRV.class);
	}
	/**
	 * 开通能力[内部服务]
	 * @return
	 * @throws Exception
	 */
	public static IOrdLdapSRV getIOrdLdapSV() throws Exception{
		return (IOrdLdapSRV)UpfsvcFactory.getService(IOrdLdapSRV.class);
	}
	/**
	 * 开通订购产品[内部服务]
	 * @return
	 * @throws Exception
	 */
	public static IOrdOfferSRV getIOrdOfferSV() throws Exception{
		return (IOrdOfferSRV)UpfsvcFactory.getService(IOrdOfferSRV.class);
	}
	/**
	 * 开通其它[内部服务]
	 * @return
	 * @throws Exception
	 */
	public static IOrdMixSRV getIOrdMixSV() throws Exception{
		return (IOrdMixSRV)UpfsvcFactory.getService(IOrdMixSRV.class);
	}
	/**
	 * 开通修复[内部服务]
	 * @return
	 * @throws Exception
	 */
	public static IUrgencySRV getIUrgencySV() throws Exception{
		return (IUrgencySRV)UpfsvcFactory.getService(IUrgencySRV.class);
	}
	/**
	 * 根据开通接入层获取开通接入能力
	 * @param fromCapital 开通接入层
	 * @return
	 * @throws Exception
	 */
	public static IBusinesCapital getIUpdcpmSV(String fromCapital)throws Exception{
		return (IBusinesCapital)UpfsvcFactory.getService( fromCapital , 
				IUpdcConst.IEnum.IInvoke.Singleton, 
				IBusinesCapital.class.getName(), 
				fromCapital );
	}
}
