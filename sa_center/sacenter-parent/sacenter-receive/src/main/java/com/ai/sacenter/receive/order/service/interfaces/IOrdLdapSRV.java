package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxExpire;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: �뿪ͨ���������Խ�</p>
 * <p>Copyright: Copyright (c) 2016��3��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IOrdLdapSRV {
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFExpire( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFEffective( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	
	/**
	 * 
	 * @param fromUpdfmx
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFExpire( IUpdfmxExpire fromUpdfmx, 
			IOVUpdcpmOffer fromUpdcpm, 
			IUpdcContext aContext ) throws SFException, Exception;
	
	/**
	 * �����û��������ɿ�ͨ������������ϵ(�û�������������ϵ)
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ�����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFNature(IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm, 
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * �����û������������û�������ͨ������������ϵ[���Ա�����ڿ�ͨ]
	 * @param fromRequest ��ͨ����
	 * @param fromUpdcpm ��ͨ�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMsgFGroup( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMemberNature( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMemberEffective( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFMemberExpire( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFGroupEffective( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
	/**
	 * 
	 * @param fromRequest
	 * @param fromUpdcpm
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpffmxRequest getSFGroupExpire( IOVMsgFRequest fromRequest,
			IUpfgkmOfferHome fromUpdcpm,
			IUpdcContext aContext) throws SFException, Exception;
}
