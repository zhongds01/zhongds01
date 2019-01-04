package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.valuebean.IUpfgsmTemplate;
import com.ai.sacenter.valuebean.IUpfgsmTemplate.IUpfgsmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �����ԪMISCӳ��</p>
 * <p>Copyright: Copyright (c) 2015-5-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpfgsmSRV {
	/**
	 * ������Ԫ������ѯ��Ԫ������չ�淶
	 * @param fromUpfwm ��Ԫ����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgsmTemplate.IUpfgsmOffer getSFUpfgsmMisc( IOVUpfwmOffer fromUpfwm, 
				IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������Ԫ������չ�淶������Ԫ���Կ�ͨ��
	 * @param fromUpfwm ��Ԫ����
	 * @param fromUpfgsm ��Ԫ���Թ淶
	 * @param fromUpfgsmx ��Ԫ������չ�淶
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFUpfgsmMisc(IOVUpfwmOffer fromUpfwm,
				IUpfgsmOffer fromUpfgsm,
				IUpfgsmTemplate.IUpfgsmxOffer fromUpfgsmx,
				IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������Ԫ���������Ԫ������չת��
	 * @param fromUpfwm ��Ԫ����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap finishSFUpfgsmMisc( IOVUpfwmOffer fromUpfwm,
				IUpdcContext aContext ) throws SFException,Exception;
}
