package com.ai.sacenter.receive.exigence;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��4��26��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExigenceConst {
	public interface IUpdbm{
		/*�첽����[��ͨ����]DAO*/
		public static final Class IRocketDAO = com.ai.sacenter.receive.exigence.dao.interfaces.IRocketDAO.class;
		/*�첽����[Զ������]DAO*/
		public static final Class IRemoteDAO = com.ai.sacenter.receive.exigence.dao.remote.interfaces.IRemoteDAO.class;
		public interface IUpdbf{
			/*��ͨ������*/
			public static final String EXIGENCE     = "EXIGENCE";
			/*�û����[��ͨ����]*/
			public static final String USER_ID      = "CMXUSERID";
			/*�û�����[��ͨ����]*/
			public static final String BILL_ID      = "CMXBILLID";
			/*���𷽱���[��ͨ����]*/
			public static final String ORIGINATOR   = "CMXORIGOR";
		}
		public interface IUpdbc{
			/*��������·��*/
			public static final String DISTRICT_ID   = "DISTRICT_ID";
		}
		public interface IEnum{
			/*��ͨĬ�Ϸ��𷽱���*/
			public static final String PROGRAM_ORIGINATOR = "1";
		}
	}
}
