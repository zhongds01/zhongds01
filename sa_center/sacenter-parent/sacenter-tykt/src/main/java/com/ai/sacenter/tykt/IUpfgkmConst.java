package com.ai.sacenter.tykt;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-12-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgkmConst {
	/*ͳһ��ͨDAO��*/
	public static final Class IUpfgkmDAO = com.ai.sacenter.tykt.dao.interfaces.IUpfgkmDAO.class;
	public interface IUpfwmCol{
		/*�������*/
		public static final String PS_ID_COL = "PS_ID";
		/*�û�����*/
		public static final String BILL_ID_COL = "BILL_ID";
		/*��������ʱ��*/
		public static final String CREATE_DATE_COL = "CREATE_DATE";
		/*�û����ڵ���*/
		public static final String REGION_ID_COL = "REGION_ID";
		/*��ͨ��*/
		public static final String PS_PARAM_COL = "PS_PARAM";
		/*��ѯ��ͨ��*/
		public static final String TARGET_PARAM_COL = "TARGET_PARAM";
		/*��Ԫ��ʼʱ��*/
		public static final String START_DATE_COL = "START_DATE";
		/*��Ԫ����ʱ��*/
		public static final String END_DATE_COL = "END_DATE";
		/*����ʱ��*/
		public static final String RET_DATE_COL = "RET_DATE";
		/*����״̬*/
		public static final String PS_STATUS_COL = "PS_STATUS";
		/*Ӧ�����*/
		public static final String FAIL_CODE_COL = "FAIL_CODE";
		/*Ӧ������*/
		public static final String FAIL_REASON_COL = "FAIL_REASON";
		/*�쳣����*/
		public static final String FAIL_LOG_COL = "FAIL_LOG";
		/*����ת��ʱ��*/
		public static final String HAND_DATE_COL = "HAND_DATE";
	}
	public interface IUpfwm{
		/*����(��ʼ��)*/
		public static final int CREATE    = 0;
		/*�˹�����*/
		public static final int COMPLETE  = 6;
		/*��������*/
		public static final int SUCCEED   = 9;
		public static class IChannel{
			/*��ͨ���ķ���*/
			public static final int  CENTER  =  8;
		}
		public static class ICustom{
			/*��ͨͣ��*/
			public final static String STOP_USER  = "OSS_STOP_USER";
			/*VOTELͣ��*/
			public final static String V_STOPUSER = "OSS_V_STOPUSER";
			/*��ͨ��ͣ*/
			public final static String BAOC 	  = "OSS_BAOC";
			/*VOTEL��ͣ*/
			public final static String V_BAOC 	  = "OSS_V_BAOC";
		}
	}
}
