package com.ai.sacenter.comptel;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ����������ӳ��淶</p>
 * <p>Copyright: Copyright (c) 2015��10��13��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpSystem {
	/**
	 * ����������Ʒ��ӳ��淶
	 * @param fromUpfgsm ӳ��淶
	 * @param fromUser �û�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer[] finishSFUpfgsmc( IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, 
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��������������ӳ�����淶
	 * @param fromUpdbcpm ����������
	 * @param fromUpfgsm ����ӳ��淶
	 * @param fromUpdcpm ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgsmc( IProfessionalTemplate.IProductOffer fromUpdbcpm,
			IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm,
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ��������������ӳ�����淶
	 * @param fromUpdbcpm ����������
	 * @param fromUpfgsm ����ӳ��淶
	 * @param fromUpdcpm ��������
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgsmc( IProfessionalTemplate.IProductOffer fromUpdbcpm,
			IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm,
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �����������Լ�ӳ��淶
	 * @param fromUpfgsm ӳ��淶
	 * @param fromUser �û�����
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpfgsmc( IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, 
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
}
