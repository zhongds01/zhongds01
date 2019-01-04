package com.ai.sacenter.comptel.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.bo.IOVUpdcpCatalog;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �����Ʒ��������</p>
 * <p>Copyright: Copyright (c) 2014-4-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpSRV {
	/**
	 * ���ݷ����Ʒ�淶��ɶ�Ӧ�����������Թ淶
	 * @param fromUpfgsm �������Թ淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpfgsmc(IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ����Ʒ�淶��ɶ�Ӧ�����������Թ淶
	 * @param fromUpfgsm ���������淶
	 * @param fromCOMPETE �������Լ�
	 * @param fromUser ���񶨵��û�
	 * @param fromUpdcpm ���񶩹���
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpfgsmc(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			java.util.List fromCOMPETE,
			IOVOrderUser fromUser,
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��������淶��ɶ�Ӧ���������·��������淶
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param fromUpdcpm ���񶩹���
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpOffer( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݵ�ǰ���񼤻�������ɾ�̬��������[����̬�����淶]�淶
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IEnumWrapper finishSFUpdbtxChain( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݵ�ǰ���񼤻�������ɷ�������[����仯�����淶]�淶
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpChange( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��������淶��ɵ�ǰ�û������Ʒ���������淶[���������淶]
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer[] finishSFUpdcpOffer( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��������淶��ɵ�ǰ�û����������������淶[���������淶]
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpComptel( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��������淶��ɵ�ǰ�û�������������淶[���������淶]
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpLifite(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��������淶��ɵ�ǰ�û���������ϱ����淶[���������淶]
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer[] finishSFUpdcpMultle(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��������淶��ɵ�ǰ�û���������ϱ����淶[���������淶]
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpPriority(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	
	/**
	 * ���ݷ��������淶��ɵ�ǰ�û������������Ա����淶[���������淶]
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpBatchX( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ��������淶��ɵ�ǰ�û������û����������淶[���������淶]
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser ���񶨵��û�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpdcpUserX( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ݷ�������ģ����ɷ������������淶
	 * @param fromUpfgsm �����Ʒ�淶
	 * @param fromUser  �����û�
	 * @param fromUpdcpm ��������ģ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpCatalog finishSFUpdcpModule( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݷ�������ģ����ɷ������������淶
	 * @param fromUser  �����û�
	 * @param fromUpdcpm ��������ģ��
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpCatalog finishSFUpdcpOffer( IOVOrderUser fromUser,
			IProfessionalTemplate.IProductOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݷ�������ģ����ɷ������������淶
	 * @param fromUser �����û�
	 * @param fromGroup Ⱥ���û�
	 * @param fromUpdcpm ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpCatalog finishSFUpdcpOffer(IOVOrderUser fromUser,
			IOVOrderUser fromGroup,
			IProfessionalTemplate.ICompetenceOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ��ɷ��񶨵���Ӧ�����Ʒ���������淶
	 * @param fromRequest ��ͨ����
	 * @param fromOrder ���񶨵�
	 * @param fromUser  �����û�
	 * @param fromGroup Ⱥ���û�
	 * @param fromUpdcwm ��������ģ�� 
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpdcpOffer(IOVOrderRequest fromRequest,
			IOVOrderPentium fromOrder,
			IOVOrderUser fromUser,
			IOVOrderUser fromGroup,
			IProfessionalTemplate.ICompetenceOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException, Exception;
}
