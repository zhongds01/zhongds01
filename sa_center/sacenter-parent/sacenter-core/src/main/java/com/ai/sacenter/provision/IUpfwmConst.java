package com.ai.sacenter.provision;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-7-9</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfwmConst {
	public interface IUpfwm{
		/*��Ԫ����DAO*/
		public static final Class IUpfwmDAO  = com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO.class;
		/*��Ԫ����DAO*/
		public static final Class IUpfpmDAO  = com.ai.sacenter.provision.dao.interfaces.IUpfpmDAO.class;
		/*���ڵ�DAO*/
		public static final Class IUpffmxDAO = com.ai.sacenter.provision.dao.interfaces.IUpffmxDAO.class;
		/*�첽����DAO*/
		public static final Class IUpdfmxDAO = com.ai.sacenter.provision.dao.interfaces.IUpdfmxDAO.class;
		public interface IUpdmon{
			/*��ʼ(������Ԫָ��ɹ���־)*/
			public static final int CREATE  = 0;
			/*ʧ��(����Ԫָ��ִ���Ƿ�ɹ��������ɹ�)*/
			public static final int FAILURE = 1;
		}
		public interface IUpdrbm{
			/*Ĭ��(��ʵ������Ԫָ�����)*/
			public static final int CREATE   = 0;
			/*�ɺ���ʧ��(����Ԫָ���쳣����Ϊ�ɹ�����)*/
			public static final int IGNORE   = 1;
			/*ʧ�ܲ�����(����Ԫָ���쳣����Ϊʧ�ܴ���)*/
			public static final int FAILURE  = 2;
			/*ʧ�ܻ���(����Ԫָ���쳣����Ϊ���˴���)*/
			public static final int ROLLBACK = 3;
		}
		public interface IUpdrdo{
			/*�ɺ���*/
			public static final int CREATE = 0;
			/*ת����*/
			public static final int RETRY  = 1;
		}
		public interface IUpffs{
			/*����*/
			public final static String NORMAL     = "00";
			/*��ͣ*/
			public final static String BAOCUSER   = "01";
			/*ͣ��*/
			public final static String STOPUSER   = "02";
			/*Ԥ����*/
			public final static String PRECEASE   = "03";
			/*����*/
			public final static String RECYCLE    = "04";
			/*����*/
			public final static String TRSFUSR    = "05";
			/*�ĺ�*/
			public final static String MODIMSN    = "06";
			/*δ֪*/
			public final static String UNKNOWN    = "99";
		}
	}
	public interface IUpdos{
		/*������ʼ*/
		public static final int CREATE    = 0;
		/*��Ԫ�쳣*/
		public static final int FAILURE   = 1;
		/*�ڲ��쳣*/
		public static final int EXCEPTION = 2;
		/*�·��첽��Ԫ�ɹ�*/
		public static final int ISSUED    = 5;
		/*�˹�����*/
		public static final int HUMAN     = 6;
		/*��������*/
		public static final int SUCCEED   = 9;
		/*�ѳ���*/
		public static final int CANCEL    = 10;
		/*��ͣ*/
		public static final int SUSPEND   = 11;
		/*�ָ�*/
		public static final int RESUME    = 0;
		/*����*/
		public static final int RUNNING   = 20;
		/*ת����*/
		public static final int RETRY     = 21;
	}
	public interface IUpdfs{
		/*����*/
		public final static String C = "C";
		/*����*/
		public final static String D = "D";
		/*���*/
		public final static String X = "X";
		/*�˶�*/
		public final static String E = "E";
		/*�ָ�*/
		public final static String F = "F";
		/*��ͣ*/
		public final static String T = "T";
		/*����*/
		public final static String U = "U";
	}
}
