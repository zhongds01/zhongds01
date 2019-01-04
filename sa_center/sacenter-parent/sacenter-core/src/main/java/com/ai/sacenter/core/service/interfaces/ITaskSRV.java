package com.ai.sacenter.core.service.interfaces;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVUpdffwmOffer;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.valuebean.IUpfgkmUserHome;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ������ͨ������ȷ���</p>
 * <p>Copyright: Copyright (c) 2011-10-14</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ITaskSRV {
	/**
	 * ����������������
	 * @param fromOrder ���񶨵�
	 * @param fromOffer �����Ʒ����
	 * @param fromUpdbm �������̹淶
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium finishSFTaskCreate( IOVOrderPentium fromOrder,
			IOVOfferPentium fromOffer,
		    ISystemTemplate.IUpdbpmOffer fromUpdbm,
		    IUpdcContext aContext) throws SFException,Exception;
	/**
	 * �������̶�����ѯ��ǰ���̶������������嵥
	 * @param fromOrder ���񶨵�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getSFTaskOffer( IOVOrderPentium fromOrder ) throws SFException, Exception;
	/**
	 * �������̶��������ѯ��ǰ���̶������������嵥
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getSFTaskOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium  fromTASK,
	        IUpdcContext aContext) throws SFException, Exception;
	/**
	 * �������̶��������ѯ��ǰ���̶������������嵥
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param fromUpdfwm ����ָ�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap getSFTaskOffer(IOVOrderPentium fromOrder,
			IOVTaskPentium  fromTASK,
			IOVUpdspmLife fromUpdfwm,
	        IUpdcContext aContext) throws SFException, Exception;
	/**
	 * ���ݿ�ͨ�����ȡ��ǰ��ͨ�����Ӧ��ͨ�û�
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgkmUserHome getSFUpfgkmUser( IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ������ͨ���������Ԫָ�������
	 * @param fromBWO ���񶨵�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List getSFUpdfwm(IOVOrderPentium fromOrder,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �������������Ԫָ�������
	 * @param fromBWO ���񶨵�
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.List getSFUpdfwm(IOVOrderPentium fromOrder[] ,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���ƽִ̨�н�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromASK �������
	 * @param aEXCEPTION �����쳣
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskRespond( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromNetWork,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ��Ԫָ��������̵�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromNetWork ��Ԫ����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskChain(IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromNetWork,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ��Ԫָ��������̵�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param aEXCEPTION  �����쳣
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskChain( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException,Exception;
	/**
	 * ������ɷ�������
	 * @param fromOrder ��ͨ����
	 * @param fromTASK ��ͨ����
	 * @param fromUpdfwm �߼�ָ�
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ������ԪӦ�������ع���������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromASK ��ԪӦ��
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpfwmResponse fromASK,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݷ����쳣��ɷ����������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK  ��������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݷ����쳣��ɷ����������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK  ��������
	 * @param fromUpdfwm �߼�ָ�
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTask(IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݷ����쳣����˹���������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݷ����쳣����쳣�ص�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ��������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * �����쳣����������ɷ��񶨵��쳣����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param aEXCEPTION �쳣����
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			SFException aEXCEPTION ,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ��ɷ��񶨵�����������ͨ����Ϳ�ͨ��Ʒ����
	 * @param fromOrder ���񶨵�
	 * @param fromDepend ���񶨵�ȫ����
	 * @param fromTASK ���񶨵�����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVTaskPentium[] finishSFTaskDepend( IOVOrderPentium fromOrder,
			IOVTaskPentium[] fromDepend , 
			IOVTaskPentium fromTASK , 
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * ���񶨵��������������鵵
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK , 
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * ���ݷ���Ⱥ�鵥��ɷ����Ա������
	 * @param fromGroup ����Ⱥ�鵥
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskGroup(IOVOrderPentium fromGroup, 
            IUpdcContext aContext) throws SFException, Exception;
	/**
	 * �����쳣�����������{������Ԫ���쳣��������}
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromASK �쳣����
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskNetWork( IOVOrderPentium fromOrder,
	    IOVTaskPentium fromTASK,
		IOVUpdspmLife fromUpdfwm,
		IOVUpfwmResponse fromASK,
		SFException aEXCEPTION,
		IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �����쳣�����������{������Ԫ���쳣��������}
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ��Ԫ�������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @return ��ΪNULL���Ѳ��������쳣
	 * @throws SFException
	 * @throws Exception
	 */
	public Object finishSFTaskCompensa( IOVOrderPentium fromOrder,
	    IOVTaskPentium fromTASK,
		IOVUpdspmLife fromUpdfwm,
		IOVUpdcpmOffer fromUpdcpm,
		SFException aEXCEPTION,
		IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * �����쳣����������ɷ�������ת���쳣����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskException( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * �����쳣����������ɷ��������쳣������������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskIgnore( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * �����쳣������������쳣��������������������
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskComplete( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * �����쳣����������ɷ�����������ɵ�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskHuman( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * �����쳣������������쳣ת�������в���
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskQueue( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * �����쳣������������쳣�ع�����
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskRollBack( IOVOrderPentium fromOrder,
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * �����쳣�����������{�쳣ת��ʷ����[�����쳣����]}
	 * @param fromOrder ���񶨵�
	 * @param fromTASK ���񶨵�����
	 * @param fromUpdfwm ����ָ�
	 * @param fromUpdcpm ����������
	 * @param aEXCEPTION �쳣����
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFTaskHistory( IOVOrderPentium fromOrder , 
			IOVTaskPentium fromTASK ,
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION ,
			IUpdcContext aContext ) throws SFException, Exception;
	/**
	 * �����쳣�ɵ�������Ĭ���ɵ������������
	 * @param fromOrder  ���񶩵�
	 * @param fromTASK  ���񶩵�����
	 * @param fromUpdfwm  ���񼤻�ָ��
	 * @param fromUpdcpm �쳣�ɵ����
	 * @param aEXCEPTION �����쳣��
	 * @param aContext
	 * @return 
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdffwmOffer finishSFTaskClaim(IOVOrderPentium fromOrder, 
			IOVTaskPentium fromTASK, 
			IOVUpdspmLife fromUpdfwm,
			IOVUpdcpmOffer fromUpdcpm,
			SFException aEXCEPTION,
			IUpdcContext aContext) throws SFException, Exception;
}
