package com.ai.sacenter.comptel;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpfsvcFactory;
import com.ai.sacenter.comptel.bo.IOVUpdcpCatalog;
import com.ai.sacenter.comptel.bo.IOVUpfgsmCatalog;
import com.ai.sacenter.comptel.service.interfaces.IUpdcpSRV;
import com.ai.sacenter.comptel.service.interfaces.IUpfgsmSRV;
import com.ai.sacenter.comptel.service.interfaces.IUpfsmSRV;
import com.ai.sacenter.comptel.service.interfaces.IUpfvmSRV;
import com.ai.sacenter.comptel.service.interfaces.IUpfvnSRV;
import com.ai.sacenter.comptel.service.interfaces.IUpfwmSRV;
import com.ai.sacenter.comptel.valuebean.IOVUpdcpCatalogImpl;
import com.ai.sacenter.comptel.valuebean.IOVUpfgsmCatalogImpl;
import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ������������ӿ�</p>
 * <p>Copyright: Copyright (c) 2015��10��12��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdcpFactory {
	public IUpdcpFactory() {
		super();
	}
	
	/**
	 * ��������������
	 * @return
	 */
	public static IOVUpdcpCatalog getIUpdbcpmImpl(){
		return new IOVUpdcpCatalogImpl();
	}
	
	/**
	 * ��������������
	 * @param fromMODULE
	 * @param fromBUSINES
	 * @return
	 */
	public static IOVUpdcpCatalog getIUpdcpmImpl( String fromMODULE, 
			IProductOffer fromBUSINES ){
		return new IOVUpdcpCatalogImpl( fromMODULE, fromBUSINES );
	}
	
	/**
	 * ����ӳ��������
	 * @return
	 */
	public static IOVUpfgsmCatalog getIUpfgsmImpl(){
		return new IOVUpfgsmCatalogImpl();
	}
	
	/**
	 * ����ӳ��������
	 * @param fromMODULE
	 * @return
	 */
	public static IOVUpfgsmCatalog getIUpfgsmImpl(String fromMODULE, Object fromOBJECTIVE){
		return new IOVUpfgsmCatalogImpl( fromMODULE, fromOBJECTIVE );
	}
	
	/**
	 * ������������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpSRV getIUpdcpSV() throws SFException,Exception{
		return (IUpdcpSRV)UpfsvcFactory.getService( IUpdcpSRV.class );
	}
	
	/**
	 * ����WMЭ�����ӿ�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfwmSRV getIUpfwmSV() throws SFException,Exception{
		return (IUpfwmSRV)UpfsvcFactory.getService( IUpfwmSRV.class );
	}
	
	/**
	 * ����VMЭ�����ӿ�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfvmSRV getIUpfvmSV() throws SFException,Exception{
		return (IUpfvmSRV)UpfsvcFactory.getService( IUpfvmSRV.class );
	}
	/**
	 * 
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfvnSRV getIUpfvnSV() throws SFException,Exception{
		return (IUpfvnSRV)UpfsvcFactory.getService( IUpfvnSRV.class );
	}
	
	/**
	 * ������Ԫ������ӳ��淶
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfsmSRV getIUpfsmSV() throws SFException,Exception{
		return (IUpfsmSRV)UpfsvcFactory.getService( IUpfsmSRV.class );
	}
	
	/**
	 * ��ԪMISC����ӳ��淶
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfgsmSRV getIUpfgsmSV() throws SFException,Exception{
		return (IUpfgsmSRV)UpfsvcFactory.getService( IUpfgsmSRV.class );
	}
	
	/**
	 * ����������ӳ��淶
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpSystem getIUpdcpSV( String fromJAVA ) throws SFException,Exception{
		return (IUpdcpSystem)UpfsvcFactory.getService( fromJAVA , 
				IUpdcConst.IEnum.IInvoke.Singleton, 
				IUpdcpSystem.class.getName(), 
				fromJAVA );
	}
	
	/**
	 * ���񼤻ӳ��淶
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfgsmSystem getIUpffxmSV( String fromJAVA ) throws SFException,Exception{
		return (IUpfgsmSystem)UpfsvcFactory.getService( fromJAVA , 
				IUpdcConst.IEnum.IInvoke.Singleton, 
				IUpfgsmSystem.class.getName(), 
				fromJAVA );
	}
	
	/**
	 * ��Ԫ��ӳ��淶
	 * @param fromJAVA
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfgsmSystem getIUpfgsmSV( String fromJAVA ) throws SFException,Exception{
		return (IUpfgsmSystem)UpfsvcFactory.getService( fromJAVA , 
				IUpdcConst.IEnum.IInvoke.Singleton, 
				IUpfgsmSystem.class.getName(), 
				fromJAVA );
	}
}
