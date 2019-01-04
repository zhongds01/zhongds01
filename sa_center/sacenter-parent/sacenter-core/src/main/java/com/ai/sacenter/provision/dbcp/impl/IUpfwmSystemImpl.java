package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.dbcp.IUpdcpmCapitalImpl;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ������Ԫ�������</p>
 * <p>Copyright: Copyright (c) 2014-7-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmSystemImpl extends IUpdcpmCapitalImpl {

	public IUpfwmSystemImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016��1��25��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpfwmOfferCreateImpl extends IUpfwmSystemImpl{
		public IUpfwmOfferCreateImpl(){
			super();
		}
		/**
		 * ������Ԫ���������Ԫ��ӳ�������
		 * @param fromUpfwm ��Ԫ����
		 * @param fromUpdfwm ����ָ�
		 * @param fromUpdcpm ����ӳ�����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public java.util.HashMap finishSFUpfwmOffer(IOVUpfwmOffer fromUpfwm, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			java.util.HashMap fromUpffx = null;
			try
			{
				fromUpffx = IUpfwmFactory.getIUpfwmSV().finishSFUpfwmOffer(fromUpfwm, 
						fromUpdfwm, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				
			}
			return fromUpffx;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: ��Ԫ�����쳣�������</p>
	 * <p>Copyright: Copyright (c) 2014-8-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmSubFlowCreateImpl extends IUpfwmSystemImpl{
		public IUpfwmSubFlowCreateImpl(){
			super();
		}
		/**
		 * �ղ���[��Ԫ���쳣�������]
		 * @param fromUpfwm ��Ԫ����
		 * @param fromUpdfwm ��Ԫָ��
		 * @param fromUpdcpm �쳣�������
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfwmException( IOVUpfwmOffer fromUpfwm, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
			    IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IUpfwmFactory.getIUpfwmSV().finishSFUpfwmException(fromUpfwm, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * ת�������в���[��̨�����Զ�����]
		 * @param fromUpfwm ��Ԫ����
		 * @param fromUpdfwm ��Ԫָ��
		 * @param fromUpdcpm �쳣�������
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfwmRetry( IOVUpfwmOffer fromUpfwm, 
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
			    IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IUpfwmFactory.getIUpfwmSV().finishSFUpfwmQueue(fromUpfwm, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
	}
}
