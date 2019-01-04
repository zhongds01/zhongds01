package com.ai.sacenter.receive.order.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.core.IUpdcpmCapital;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.valuebean.IOVUpffmxConsult;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.teaminvoke.UpdcFactory;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ����������ʲ�</p>
 * <p>Copyright: Copyright (c) 2018��7��3��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ICustomExpireImpl extends UpdcEclipseImpl implements IUpdcpmCapital {

	public ICustomExpireImpl() {
		super();
	}
	
	/**
	 * ��ͨ���ڶ���[�����ڿ�ͨ][��ͨ�û��������]
	 * IUpdfffxDefaultImpl
	 * @param fromUpdfmx ���ڶ���
	 * @param fromUpdcpm ��ͨ����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIUpdfxDefaultImpl( IUpdfmxExpire fromUpdfmx, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext ) throws SFException,Exception{
		IOVOrderResponse fromASK = null;
		try
		{
			
		}
		finally{
			
		}
		return fromASK;
	}
	
	/**
	 * ��ͨ���ڶ���[�����ڿ�ͨ][��ͨ�û��������]
	 * IUpdfffxExpireImpl
	 * @param fromUpdfmx ���ڶ���
	 * @param fromUpdcpm ��ͨ����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVOrderResponse finishIUpdfxExpireImpl( IUpdfmxExpire fromUpdfmx, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext ) throws SFException,Exception{
		IOVOrderResponse fromASK = null;
		IOVUpffmxRequest fromUpffmx = null;
		try
		{
			String  fromXML = XmlUtils.createNoformatXml("InterBOSS", aContext );
			fromUpffmx = IOrderFactory.getIOrdLdapSV().getSFMsgFExpire(fromUpdfmx, fromUpdcpm, aContext);
			IOVUpffmxConsult __PLATFORM__ = fromUpffmx.getPLATFORM();
			if( __PLATFORM__.getPLATFORM() != null && __PLATFORM__.getCOMPETENCE() != null ){
				fromASK = UpdcFactory.getIUpdcSV().applySFOrder(__PLATFORM__.getPLATFORM(), 
						__PLATFORM__.getCOMPETENCE(), 
						fromXML );
			}
			for( java.util.Iterator<IOVUpffmxConsult> itera = fromUpffmx.getEXPIRE().getEXPIRE().iterator(); itera.hasNext(); ){
				IOVUpffmxConsult ___PLATFORM___ = (IOVUpffmxConsult)itera.next();
				UpdcFactory.getIUpdcSV().applySFOrder(___PLATFORM___.getPLATFORM(), 
						___PLATFORM___.getCOMPETENCE(), 
						fromXML );
			}
		}
		finally{
			if( fromUpffmx != null ){ fromUpffmx = null; }
		}
		return fromASK;
	}
	
}
