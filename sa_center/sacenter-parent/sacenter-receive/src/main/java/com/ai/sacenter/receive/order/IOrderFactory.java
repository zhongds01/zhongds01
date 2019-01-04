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
     * ��ͨ����[�ڲ�����]
     * @return
     * @throws Exception
     */
	public static IOrderSRV getIOrderSV() throws Exception{
		return (IOrderSRV)UpfsvcFactory.getService(IOrderSRV.class);
	}
	/**
	 * �ͻ�����[�ڲ�����]
	 * @return
	 * @throws Exception
	 */
	public static ICustomSRV getICustomSV() throws Exception{
		return (ICustomSRV)UpfsvcFactory.getService(ICustomSRV.class);
	}
	/**
	 * �û����ڹ���[�ڲ�����]
	 * @return
	 * @throws Exception
	 */
	public static IExpireSRV getIExpireSV() throws Exception{
		return (IExpireSRV)UpfsvcFactory.getService(IExpireSRV.class);
	}
	/**
	 * ��Ʒ����[�ڲ�����]
	 * @return
	 * @throws Exception
	 */
	public static IProductSRV getIProductSV() throws Exception{
		return (IProductSRV)UpfsvcFactory.getService(IProductSRV.class);
	}
	/**
	 * ��ͨ����[�ڲ�����]
	 * @return
	 * @throws Exception
	 */
	public static IOrdLdapSRV getIOrdLdapSV() throws Exception{
		return (IOrdLdapSRV)UpfsvcFactory.getService(IOrdLdapSRV.class);
	}
	/**
	 * ��ͨ������Ʒ[�ڲ�����]
	 * @return
	 * @throws Exception
	 */
	public static IOrdOfferSRV getIOrdOfferSV() throws Exception{
		return (IOrdOfferSRV)UpfsvcFactory.getService(IOrdOfferSRV.class);
	}
	/**
	 * ��ͨ����[�ڲ�����]
	 * @return
	 * @throws Exception
	 */
	public static IOrdMixSRV getIOrdMixSV() throws Exception{
		return (IOrdMixSRV)UpfsvcFactory.getService(IOrdMixSRV.class);
	}
	/**
	 * ��ͨ�޸�[�ڲ�����]
	 * @return
	 * @throws Exception
	 */
	public static IUrgencySRV getIUrgencySV() throws Exception{
		return (IUrgencySRV)UpfsvcFactory.getService(IUrgencySRV.class);
	}
	/**
	 * ���ݿ�ͨ������ȡ��ͨ��������
	 * @param fromCapital ��ͨ�����
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
