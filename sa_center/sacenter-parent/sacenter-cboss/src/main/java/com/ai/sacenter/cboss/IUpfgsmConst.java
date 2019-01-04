package com.ai.sacenter.cboss;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-12-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgsmConst {
	/*CenterBossDAO��*/
	public static final Class<?> IUpfgsmDAO = com.ai.sacenter.cboss.dao.interfaces.IUpfgsmDAO.class;;
	public interface IUpfwmCol{
		/*�������*/
		public static final String SO_NBR         = "SO_NBR"        ;
		/*�������*/
		public static final String ORDER_ID       = "ORDER_ID"      ;
		/*�������*/
		public static final String OFFER_ID       = "OFFER_ID"      ;
		/*������*/
		public static final String TASK_ID        = "TASK_ID"       ;
		/*��������*/
		public static final String CATEGORY       = "CATEGORY"      ;
		/*�û����*/			              		        
		public static final String USER_ID        = "USER_ID"       ;
		/*�û�����*/			              		        
		public static final String BILL_ID        = "BILL_ID"       ;
		/*�μƷѺ�*/
		public static final String SUB_BILL_ID    = "SUB_BILL_ID"   ;
		/*����ʱ��*/
		public static final String CREATE_DATE    = "CREATE_DATE"   ;
		/*���б��*/
		public static final String REGION_ID      = "REGION_ID"     ;
		/*ͣ��״̬*/
		public static final String USER_STS       = "USER_STS"      ;
		/*ͣ������*/
		public static final String STOP_TYPE      = "STOP_TYPE"     ;
		/*����״̬*/
		public static final String ORDER_STS      = "STS"           ;
		/*�������*/
		public static final String SUB_PLAN_NO    = "SUB_PLAN_NO"   ;
		/*ԤԼʱ��*/
		public static final String ORDER_DATE     = "ORDER_DATE"    ;
		/*��չ���Ա��*/			      		        
		public static final String PROPERTY_ID    = "PROPERTY_ID"   ;
		/*��չ�������*/			      		        
		public static final String PROPERTY_SEQ   = "SEQ"           ;
		/*��չ����ֵ*/
		public static final String PROPERTY_VALUE = "PROPERTY_VALUE";
		/*���б���*/						        
		public static final String REGION_CODE    = "REGION_CODE"   ;
		/*��������*/				      
		public static final String RESULT         = "RESULT"        ;
		/*��������*/						        
		public static final String RESULT_DESC    = "RESULT_DESC"   ;
		/*�������*/
		public static final String COMPLETE_DATE  = "PROCESS_DATE"  ;
	}
	public interface IUpfrsp{
		/*�ɹ�����*/
		public static final String SUCCEED = "0000";
	}
	public interface ICustom{
		/*������Դ*/
		public static final String VGPCMSRC = "VGCPMSRC";
		/*�������*/
		public static final String VGPCMSGT = "VGPCMSGT";
		/*�������*/
		public static final String VGPCNUMB = "VGPCNUMB";
	}
	public interface IState{
		/*��ʼ״̬*/
		public static final int  CREATE = 1;
	}
	public interface IOriginate{
		/*�û���������*/
		public static final int USER    = 0;
		/*�û���������*/
		public static final int OSSTATE = 1;
	}
	public interface ISubscribe{
		/*�û�״̬*/
		public static final String STATUS = "STATUS";
		/*������ϵ*/
		public static final String ORDER  = "ORDER" ;
	}
	public interface ICallBack{
		/*����Ҫ��ִ*/
		public static final int NO    = 0;
		/*��Ҫ��ִ*/
		public static final int YES   = 1;
	}
	public interface IChannel{
		/*CBOSS����*/
		public static final String CBOSS = "99";
		public interface ISource{
			/*��ѯCBOSS������Դ(0-BOSS,1-ƽ̨)BOSS����*/
			public static final int  BOSS     = 0;
			/*��ѯCBOSS������Դ(0-BOSS,1-ƽ̨)ƽ̨����*/
			public static final int  PLATFORM = 1;
		}
	}
}
