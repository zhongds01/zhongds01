package com.ai.sacenter.provision.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.dbcp.IUpdcpmCapitalImpl;
import com.ai.sacenter.provision.IUpfwmFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ������Ԫ�������</p>
 * <p>Copyright: Copyright (c) 2015-1-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpdffmSystemImpl extends IUpdcpmCapitalImpl {

	public IUpdffmSystemImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: ��Ԫ�����鵵���</p>
	 * <p>Copyright: Copyright (c) 2014-7-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdffmCompleteImpl extends IUpdffmSystemImpl{
		public IUpdffmCompleteImpl(){
			super();
		}

		/**
		 * [��Ԫ����������ת��ʷ[���񶨵����̵���]]
		 * @param fromOrder ��Ԫ����
		 * @param fromUpdcpm ���������
		 * @param aContext
		 * @throws Exception
		 */
		public void finishSFUpfwmDefault( IOVUpfwmOrder fromOrder , 
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmHistory(fromOrder, 
						fromUpdcpm,
						aContext);
			}
			finally{
				
			}
		}
		
		/**
		 * [��Ԫ���������������񶨵�[���񶨵����̵���]]
		 * @param fromOrder ��Ԫ����
		 * @param fromUpdcpm ����鵵���
		 * @param aContext
		 * @throws IOpenException
		 * @throws Exception
		 */
		public void finishSFTaskComplete( IOVUpfwmOrder fromOrder , 
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IUpfwmFactory.getIUpffmSV().finishSFTaskComplete(fromOrder, 
						fromUpdcpm,
						aContext);
			}
			finally{
				
			}
		}

		/**
		 * ������Ԫ����ҵ�񼶲������[ת����[���񶨵��쳣����,תʧ�ܵ��˹�����]]
		 * @param fromOrder ��������
		 * @param fromUpdcpm ����������
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfwmException( IOVUpfwmOrder fromOrder,
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IUpfwmFactory.getIUpffmSV().finishSFUpfwmException(fromOrder, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				
			}
		}
	}
}
