package com.ai.sacenter.receive.custom;

public class ICustomConst {
	public interface ICustType{
		/*�ͻ����ͣ����˿ͻ�*/
		public static final String INDIVIDUAL = "1";
		/*�ͻ����ͣ���ͥ�ͻ�*/
		public static final String FAMILY = "2";
		/*�ͻ����ͣ����ſͻ�*/
		public static final String GROUP = "3";
        /*�ͻ����ͣ�VPMN�ͻ�*/
		public static final String VPMN = "4";
		/*���˴�ͻ�*/
		public static final int INDIV_VIP = 11;
	}
	public interface ICustom{
		/*�û����*/
		public static final String USER_ID   = "USER_ID";
		/*�ͻ����*/
		public static final String CUSTOM_ID = "CUSTOM_ID";
		/*�߻����*/
		public static final String OFFER_ID  = "OFFER_ID";
	}
	public interface IOffer{
		/*�Ƿ����߻�[���߻�]*/
		public static final int IS_MAIN_OFFER  = 1;
		/*�߻��Ƿ����߻�[�����߻�]*/
		public static final int NOT_MAIN_OFFER = 0;
		/*�Ƿ����û�[���û�]*/
		public static final int IS_GRP_MAIN_USER  = 1;
		/*�Ƿ����û�[�����û�]*/
		public static final int NOT_GRP_MAIN_USER = 0;
	}
}
