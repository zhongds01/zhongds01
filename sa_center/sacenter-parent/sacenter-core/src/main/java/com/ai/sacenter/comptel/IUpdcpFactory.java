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
 * <p>Description: 服务能力服务接口</p>
 * <p>Copyright: Copyright (c) 2015年10月12日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdcpFactory {
	public IUpdcpFactory() {
		super();
	}
	
	/**
	 * 构造服务能力结果
	 * @return
	 */
	public static IOVUpdcpCatalog getIUpdbcpmImpl(){
		return new IOVUpdcpCatalogImpl();
	}
	
	/**
	 * 构造服务能力结果
	 * @param fromMODULE
	 * @param fromBUSINES
	 * @return
	 */
	public static IOVUpdcpCatalog getIUpdcpmImpl( String fromMODULE, 
			IProductOffer fromBUSINES ){
		return new IOVUpdcpCatalogImpl( fromMODULE, fromBUSINES );
	}
	
	/**
	 * 构造映射结果对象
	 * @return
	 */
	public static IOVUpfgsmCatalog getIUpfgsmImpl(){
		return new IOVUpfgsmCatalogImpl();
	}
	
	/**
	 * 构造映射结果对象
	 * @param fromMODULE
	 * @return
	 */
	public static IOVUpfgsmCatalog getIUpfgsmImpl(String fromMODULE, Object fromOBJECTIVE){
		return new IOVUpfgsmCatalogImpl( fromMODULE, fromOBJECTIVE );
	}
	
	/**
	 * 服务能力服务
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpdcpSRV getIUpdcpSV() throws SFException,Exception{
		return (IUpdcpSRV)UpfsvcFactory.getService( IUpdcpSRV.class );
	}
	
	/**
	 * 基于WM协议服务接口
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfwmSRV getIUpfwmSV() throws SFException,Exception{
		return (IUpfwmSRV)UpfsvcFactory.getService( IUpfwmSRV.class );
	}
	
	/**
	 * 基于VM协议服务接口
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
	 * 服务网元级属性映射规范
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfsmSRV getIUpfsmSV() throws SFException,Exception{
		return (IUpfsmSRV)UpfsvcFactory.getService( IUpfsmSRV.class );
	}
	
	/**
	 * 网元MISC属性映射规范
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IUpfgsmSRV getIUpfgsmSV() throws SFException,Exception{
		return (IUpfgsmSRV)UpfsvcFactory.getService( IUpfgsmSRV.class );
	}
	
	/**
	 * 服务能力级映射规范
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
	 * 服务激活级映射规范
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
	 * 网元级映射规范
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
