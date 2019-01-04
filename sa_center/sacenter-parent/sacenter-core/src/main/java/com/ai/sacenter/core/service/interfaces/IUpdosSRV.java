package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdbmtcLife;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IProgramTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ����ĵ��÷���</p>
 * <p>Copyright: Copyright (c) 2014-5-21</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdosSRV {
	/**
	 * ��ѯ���̿�����Ϣ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdbmtcLife getSFUpdbmToken() throws SFException,Exception;
	/**
	 * �����쳣�������񵥲�ѯ��ǰ���������ɵ��淶
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IProgramTemplate.IUpdffwmOffer.IUpdfcmpDistribute getSFUpdbmClaim( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION ,
			IUpdcContext aContext ) throws SFException, Exception;
}
