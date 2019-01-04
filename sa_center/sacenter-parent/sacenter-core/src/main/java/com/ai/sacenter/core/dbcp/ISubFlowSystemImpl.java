package com.ai.sacenter.core.dbcp;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.IUpdcFactory;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.core.valuebean.IOVUpdffwmOffer;
import com.ai.sacenter.valuebean.IOVUpdcpmOffer;
import com.ai.sacenter.valuebean.IOVUpdspmLife;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ���񼤻��������</p>
 * <p>Copyright: Copyright (c) 2014-8-20</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class ISubFlowSystemImpl extends IUpdcpmCapitalImpl {

	public ISubFlowSystemImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: �쳣�ɵ������</p>
	 * <p>Copyright: Copyright (c) 2014-12-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbmClaimCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmClaimCreateImpl(){
			super();
		}
		/**
		 * ���ݷ��񶨵���������쳣�ɵ������������
		 * @param fromOrder  ���񶩵�
		 * @param fromTASK   ���񶩵�����
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
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdffwmOffer fromUpddgma = null;
			try
			{
				fromUpddgma = IUpdcFactory.getITaskSV().finishSFTaskClaim(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
			return fromUpddgma;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: ���񼤻��쳣�������</p>
	 * <p>Copyright: Copyright (c) 2014-8-20</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbmSubFlowCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmSubFlowCreateImpl(){
			super();
		}
		/**
		 * �����쳣�����������{ת��������[��̨�����Զ�����]}
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ��������
		 * @param fromUpdfwm ����ָ�
		 * @param fromUpdcpm ����������
		 * @param fromASK  �쳣��������
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskQueue( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskQueue(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * �����쳣�����������{�Զ��ع�[�����Զ��ع�����]}
		 * @param fromOrder ���񶨵�
		 * @param fromTASK  ��������
		 * @param fromUpdfwm ����ָ�
		 * @param fromUpdcpm ����������
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskRollBack( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskRollBack(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * �����쳣�����������{ת���쳣[���񶨵��쳣����]}
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ��������
		 * @param fromUpdfwm ����ָ�
		 * @param fromUpdcpm ����������
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskException( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskException(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * �����쳣�����������{ת�쳣����[���񶨵��쳣����]}
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ��������
		 * @param fromUpdfwm ����ָ�
		 * @param fromUpdcpm ����������
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskIgnore( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskIgnore(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * �����쳣�����������{��������[�������������鵵]}
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ��������
		 * @param fromUpdfwm ����ָ�
		 * @param fromUpdcpm ����������
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskComplete( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskComplete(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * �����쳣�����������{�˹����[���񶨵��쳣����]}
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ��������
		 * @param fromUpdfwm ����ָ�
		 * @param fromUpdcpm ����������
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskHuman( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK ,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION ,
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskHuman(fromOrder, 
						fromTASK,
						fromUpdfwm, 
						fromUpdcpm,
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
		/**
		 * �����쳣�����������{�쳣ת��ʷ����[�����쳣����]}
		 * @param fromOrder ���񶨵�
		 * @param fromTASK  ��������
		 * @param fromUpdfwm ����ָ�
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
				IUpdcContext aContext ) throws SFException, Exception{
			try
			{
				IUpdcFactory.getITaskSV().finishSFTaskHistory(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: ����ͨ�쳣�ݴ���������</p>
	 * <p>Copyright: Copyright (c) 2016��8��30��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbmCompensaCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmCompensaCreateImpl(){
			super();
		}
		/**
		 * ���쳣�����������{������Ԫ���쳣��������}
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
		public Object finishSFTaskBlank( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			return null;
		}
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
		public Object finishSFTaskDefault( IOVOrderPentium fromOrder,
				IOVTaskPentium fromTASK,
				IOVUpdspmLife fromUpdfwm,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext ) throws SFException,Exception{
			Object fromEnable = null;
			try
			{
				fromEnable = IUpdcFactory.getITaskSV().finishSFTaskCompensa(fromOrder, 
						fromTASK, 
						fromUpdfwm, 
						fromUpdcpm, 
						aEXCEPTION, 
						aContext);
			}
			finally{
				
			}
			return fromEnable;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: ���񼤻��쳣�ع������</p>
	 * <p>Copyright: Copyright (c) 2014-12-22</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbmRollBackCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmRollBackCreateImpl(){
			super();
		}
		/**
		 * ���ݷ��񶨵�������ɿ��쳣�ع������
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @param fromUpdcpm ����ӳ�����
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVTaskPentium[] finishSFTaskBlank(IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext) throws SFException, Exception{
			IOVTaskPentium fromBWK[] = null;
			try
			{
				
			}
			finally{
				
			}
			return fromBWK;
		}
		/**
		 * ���ݷ��񶨵���������쳣�ع������
		 * @param fromOrder ���񶨵�
		 * @param fromTASK ���񶨵�����
		 * @param fromUpdcpm ����ӳ�����
		 * @param aEXCEPTION �쳣����
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVTaskPentium[] finishSFTaskRollBack(IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK,
				IOVUpdcpmOffer fromUpdcpm,
				SFException aEXCEPTION,
				IUpdcContext aContext) throws SFException, Exception{
			IOVTaskPentium fromBWK[] = null;
			try
			{
				fromBWK = IUpdcFactory.getIUpdbpmSV().finishSFUpdbmException(fromOrder, 
						fromTASK, 
						fromUpdcpm,
						aEXCEPTION,
						aContext);
			}
			finally{
				
			}
			return fromBWK;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: ������м��������</p>
	 * <p>Copyright: Copyright (c) 2014-12-30</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbmQueueCreateImpl extends ISubFlowSystemImpl{
		public IUpdbmQueueCreateImpl(){
			super();
		}
		/**
		 * ���ݷ�����й�����ɷ��������ز�����Ԫ���
		 * @param fromQueue ������й���
		 * @param fromUpdcpm ����������
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFTaskActive(IOVQueuePentium fromQueue, 
				IOVUpdcpmOffer fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IUpdcFactory.getIUpdcmqSV().finishSFTaskActive(fromQueue, 
						fromUpdcpm, 
						aContext);
			}
			finally{
				
			}
		}
	}
}
