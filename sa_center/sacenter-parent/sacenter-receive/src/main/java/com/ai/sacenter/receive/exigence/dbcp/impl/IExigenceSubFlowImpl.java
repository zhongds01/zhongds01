package com.ai.sacenter.receive.exigence.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.core.dbcp.IUpdcpmCapitalImpl;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.dbcp.IExigenceCapital;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketExigence;
import com.ai.sacenter.receive.order.dbcp.impl.IBusinesSubFlowImpl;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ���񶨵��첽�鵵</p>
 * <p>Copyright: Copyright (c) 2017��6��15��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IExigenceSubFlowImpl extends IBusinesSubFlowImpl implements IExigenceCapital{
	public IExigenceSubFlowImpl(){
		super();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ��ͨ�������쳣�鵵���</p>
	 * <p>Copyright: Copyright (c) 2018��1��31��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IRocketSubFlowImpl extends IUpdcpmCapitalImpl{
		public IRocketSubFlowImpl(){
			super();
		}
		
		/**
		 * <p>Library: IUpdfvmDefaultImpl</p>
		 * <p>Description: ��ǰ��ͨ������ʧ�ܹ鵵[��ͨ�������쳣���]</p>
		 * @param fromMBean ȫ������
		 * @param fromRocket ��ͨ������
		 * @param fromUpdcpm �쳣�鵵���
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfgkmDefaultImpl(MBeanDelegate fromMBean,
				IOVMocketExigence fromRocket,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmException(fromMBean, 
						fromRocket, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
	
		/**
		 * <p>Library: IUpdfvmHistoryImpl</p>
		 * <p>Description: ��ǰ��ͨ��������ʷ�鵵[��ͨ�������쳣���]</p>
		 * @param fromMBean ȫ������
		 * @param fromRocket ��ͨ������
		 * @param fromUpdcpm �쳣�鵵���
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfgkmHistoryImpl(MBeanDelegate fromMBean,
				IOVMocketExigence fromRocket,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmHistory(fromMBean, 
						fromRocket, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		
		/**
		 * <p>Library: IUpdfvmQueueImpl</p>
		 * <p>Description: ��ǰ��ͨ�����������鵵[��ͨ�������쳣���]</p>
		 * @param fromMBean ȫ������
		 * @param fromRocket ��ͨ������
		 * @param fromUpdcpm �쳣�鵵���
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpfgkmQueueImpl(MBeanDelegate fromMBean,
				IOVMocketExigence fromRocket,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				IExigenceFactory.getIUpdfmxSV().finishSFUpfgkmConnection(fromMBean, 
						fromRocket, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
	}
}
