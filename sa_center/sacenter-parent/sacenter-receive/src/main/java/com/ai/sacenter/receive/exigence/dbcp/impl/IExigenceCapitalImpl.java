package com.ai.sacenter.receive.exigence.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.exigence.IExigenceFactory;
import com.ai.sacenter.receive.exigence.dbcp.IExigenceCapital;
import com.ai.sacenter.receive.exigence.valuebean.IOVMsgFExigence;
import com.ai.sacenter.receive.exigence.valuebean.IOVMocketConsult;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ�����ʲ�</p>
 * <p>Copyright: Copyright (c) 2018��2��27��</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class IExigenceCapitalImpl extends UpdcEclipseImpl implements IBusinesCapital,IExigenceCapital {
	public IExigenceCapitalImpl() {
		super();
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ��ͨ������ֽ��ʲ�</p>
	 * <p>Copyright: Copyright (c) 2018��2��27��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IRocketExplainImpl extends IExigenceCapitalImpl{
		public IRocketExplainImpl(){
			super();
		}
		
		/**
		 * <p>Library: IUpdfmsxDefaultImpl</p>
		 * <p>Description: ��ͨ�������û��ֽ�[��ͨ�����ֽ����]</p>
		 * @param fromRocket ȫ������
		 * @param fromUpdfmx ��ͨ�����ֽ���
		 * @param fromUpdcpm �����������
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMocketConsult finishSFUpdfmxDefault(IOVMsgFExigence fromRocket,
				IOVMocketConsult fromUpdfmx,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVMocketConsult fromConsult = null;
			try
			{
				fromConsult = IExigenceFactory.getIUpdfmxSV().finishSFUpdfmxDefault(fromRocket, 
						fromUpdfmx, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				
			}
			return fromConsult;
		}
	}
}
