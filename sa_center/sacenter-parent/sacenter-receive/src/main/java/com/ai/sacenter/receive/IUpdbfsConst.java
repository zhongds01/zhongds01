package com.ai.sacenter.receive;

public class IUpdbfsConst {
	public interface IUpdbm{
		/*��ͨ����DAO*/
		public Class<?> IOrderDAO   = com.ai.sacenter.receive.order.dao.interfaces.IOrderDAO.class;
		/*��ͨ�޸�DAO*/
		public Class<?> IUrgencyDAO = com.ai.sacenter.receive.order.dao.interfaces.IUrgencyDAO.class;
		/*��ͨ����DAO*/
		public Class<?> IExpireDAO  = com.ai.sacenter.receive.expire.dao.interfaces.IExpireDAO.class;
		public interface ICache{
			/*��ͨ����ģ��*/
			public final static String PROGRAM_RECEIVE    = "PROGRAM_RECEIVE";
			/*���ڹ���ģ��*/
			public final static String PROGRAM_EXPIRE     = "PROGRAM_EXPIRE";
			/*��������ģ��*/
			public final static String PROGRAM_DEPEND     = "PROGRAM_DEPEND";
			/*ͬ�����ģ��*/
			public final static String PROGRAM_GROUP      = "PROGRAM_GROUP";
			/*�û��Լ��䶩���嵥*/
			public final static String PROGRAM_CUSTOM     = "PROGRAM_CUSTOM";
			/*��ͨ������Ʒģ��*/
			public final static String PROGRAM_PRODUCTION = "PROGRAM_PRODUCTION";
			/*ȫ��ģ��*/
			public final static String PROGRAM_GLOBAL     = "PROGRAM_GLOBAL";
			/*����ģ��*/
			public final static String PROGRAM_ORDER      = "PROGRAM_ORDER";
			/*�û�ģ��*/
			public final static String PROGRAM_USER       = "PROGRAM_USER";
			/*�����ײ���*/
			public final static String PROGRAM_OFFER      = "PROGRAM_OFFER";
			/*��ͨ�����ֽ�*/
			public final static String PROGRAM_COMPOSE    = "PROGRAM_COMPOSE";
			/*��ͨ�޸�������*/
			public final static String PROGRAM_URGENCY    = "PROGRAM_URGENCY";
			/*��ͨ��������*/
			public final static String PROGRAM_PLATFORM   = "PROGRAM_PLATFORM";
			/*��ͨ�����鵵*/
			public final static String PROGRAM_COMPLETE   = "PROGRAM_COMPLETE";
			/*ͣ����λģ��*/
			public final static String PROGRAM_OSSTATUS   = "PROGRAM_OSSTATUS";
		}
		public interface ICustom{
			/*Ĭ�����ȼ�*/
			public static final int    PRIORITY   = 10;
			/*Ĭ����������*/
			public static final String CHANNEL    = "8";
			 /*Ĭ�Ϸ���*/
		    public static final String ORIGINATOR = "9";
			/*Ĭ�Ϲ���*/
		    public static final String STAFF      = "999999";
		    /*ϵͳ��λ*/
			public static final String ORGANIZE   = "999999";
			/*Ĭ���û�����*/
			public static final String BILL_ID    = "13999999999";
		}
		public interface ICatalog{
			/*�Ƿ���ͨ���Ĺ��*/
			public final static String RECEIVE   = "999990010100";
			/*Ĭ�ϲ�Ʒ���*/
			public static final String CATALOG   = "999990010199";
		}
		public interface IBusines{
			/*��������������*/
			public final static String EXPIRE    = "999900020101";
			/*�Ƿ���ͨ���Ĳ���*/
			public final static String RECEIVE   = "999990010200";
			/*Ĭ�ϲ�������*/
			public static final String BUSINES  = "999990010900";
		}
		public interface IBatches{
			/*����ҵ��*/
			public static final String YES  = "1";
			/*����ҵ��*/
			public static final String NO   = "0";
		}
		public interface IRole{
			/*��Ա��ɫ*/
			public final static String MEMBER    = "0";
			/*Ⱥ���ɫ*/
			public final static String GROUP     = "1";
			/*��ͨ��ɫ*/
			public final static String NORMAL    = "2";
		}
		public interface IProdType{
			/*��ͨ��ɫ*/
			public final static String NORMAL    = "0";
			/*��Ա��ɫ*/
			public final static String MEMBER    = "1";
			/*Ⱥ���ɫ*/
			public final static String GROUP     = "2";
		}
		public interface IUser{
			/*��ͨ����[����ģ��]*/
			public final static String ORDER       = "ORDER";
			/*��ͨ����[����ģ��]*/
			public final static String INSTANCE    = "INSTANCE";
			/*�����ڱ�־*/
			public static final String CYCLE       = "CYCLE";
			/*���й���*/
			public static final String MIDDLE      = "MIDDLE";
			/*����ʱ��[��ͨ����]*/
			public final static String OPRTIME     = "OPRTIME";
			/*������Դ[��ͨ����]*/
			public final static String OPRSRC	   = "OPRSRC";
			/*��Ʒ���*/
			public static final String VMICMPID    = "VMICMPID";
			/*ҵ�����*/
			public static final String VMICMBSI    = "VMICMBSI";
			/*�����߻�����*/
			public static final String VMICPIID    = "VMICPIID";
			/*֧����ʽ*/
			public static final String VMICPTID    = "VMICPTID";
			/*���б���*/
			public static final String VMILOCTY    = "VMILOCTY";
			/*�û�Ʒ��*/
			public static final String VMICMTDK    = "VMICMTDK";
			/*�û���Ʒ��*/
			public static final String VMICOTDK    = "VMICOTDK";
			/*�û�״̬*/
			public static final String VMICMOSI    = "VMICMOSI";
			/*�����û�ͣ��״̬[�û�ͣ����]*/
			public static final String VMICMOSS    = "VMICMOSS";
			/*�û�����ͣ��λ[�û�ͣ����]*/
			public static final String VMICMOTS    = "VMICMOTS";
			/*�û�ͣ����λ������[�û�ͣ����]*/
			public static final String VMICMOST    = "VMICMOST";
			/*�û�ͣ����λ�仯ֵ[�û�ͣ����]*/
			public static final String VMICMOTB    = "VMICMOTB";
			/*ͣ��[�û�ͣ����]*/
			public final static String STOPUSER    = "STOPUSER";
			/*��ͣ[�û�ͣ����]*/
			public final static String BAOCUSER    = "BAOCUSER";
			/*�����û�*/
			public final static String EXPIREUSER  = "EXPIREUSER";
			/*�û���IMSI[�û�����]*/
	    	public final static String NEWIMSI     = "NEWIMSI";
	    	/*���û�����[�û�����]*/
	    	public final static String NEWMSDN     = "NEWMSDN";
	    	/*���ű��*/
			public static final String GROUP_ID    = "GROUP_ID";
			/*��������*/
			public static final String GROUP_TYPE  = "GROUP_TYPE";
			public interface IOsState{
				/*����*/
				public final static String NORMAL  = "0";
				/*����ͣ��*/
				public final static String MGRSTP  = "1";
				/*Ӫҵͣ��*/
				public final static String ISOSTP  = "2";
				/*����ͣ��*/
				public final static String AMSSTP  = "3";
				/*Ӫҵ��ʧ*/
				public final static String LOSTSTP = "4";
				/*Ӫҵ���*/
				public final static String FINDSTP = "5";
			}
		}
		public interface IOriginate{
			/*��ͨ��������*/
			public final static String PROGRAM_RECEIVE  = "RECEIVE";
			/*��ͨ���ڷ���*/
			public final static String PROGRAM_EXPIRE   = "EXPIRE";
			/*��ͨ�鵵����*/
			public final static String PROGRAM_COMPLETE = "COMPLETE";
			/*��ͨ�޸�����*/
			public final static String PROGRAM_URGENCY  = "URGENCY";
			/*��ͨ��������*/
			public final static String PROGRAM_OTHER    = "OTHER";
		}
		public interface IProduct{
			/*ͬ���ײ�ģ��*/
			public final static String PROGRAM_GROUP_PLAN     = "PROGRAM_GROUP_PLAN";
			/*����������ģ��*/
			public final static String PROGRAM_PVPMN_COMPETE  = "PROGRAM_PVPMN_COMPETE";
			/*ͬ�����ģ��*/
			public final static String PROGRAM_GROUP_COMPETE  = "PROGRAM_GROUP_COMPETE";
			/*ͬ���Ʒģ��*/
			public final static String PROGRAM_GROUP_PRICE    = "PROGRAM_GROUP_PRICE";
			/*��Ա����[��Ҫ��Գ�Ա����Ⱥ������]*/
			public final static String PROGRAM_DEPEND_MEMBER  = "PROGRAM_DEPEND_MEMBER";
			/*����������(��Ҫ���ָ�������)*/
			public final static String PROGRAM_DEPEND_GROUP   = "PROGRAM_DEPEND_GROUP";
			/*������������(��Ҫ��Է�����������)*/
			public final static String PROGRAM_DEPEND_FUTURE  = "PROGRAM_DEPEND_FUTURE";
			/*����������(��Ҫ���ָ�������)*/
			public final static String PROGRAM_DEPEND_COMPETE = "PROGRAM_DEPEND_COMPETE";
			/*���ڲ�Ʒ��(��������ϵͳ)*/
			public final static String PROGRAM_EXPIRE_GROUP   = "PROGRAM_EXPIRE_GROUP";
		}
	}
	
	public interface IEnum{
		public interface IYesNo{
    		public static final String Yes = "Y";
    		public static final String No  = "N";
    	}
		public interface IEffective{
			/*ȫ��,������ʧЧ,�����ںͱ�����*/          
			public static final int VALID_TYPE_HIS      = 0;
			/*������Ч*/
			public static final int VALID_TYPE_NOW      = 1;
			/*δ��Ч*/                                  
			public static final int VALID_TYPE_NEXT     = 2;
			/*������Ч*/
			public static final int VALID_TYPE_NEXT_DAY = 3;
			/*��ʧЧ*/
			public static final int VALID_TYPE_EXPIRED  = 4;
			/*���С��������ڡ���������Ч*/              
			public static final int VALID_TYPE_ALL      = -1;
		}
	}
	public interface IState{
		public final static String C   = "C";
		public final static String E   = "E";
		public final static String EC  = "EC";
		public final static String CE  = "CE";
		public final static String D   = "D";
		public final static String T   = "T";// ��ͣ
		public final static String F   = "F";// �ָ�
		public final static String U   = "U";
		public final static String X   = "X";
		public final static String H   = "H";
		public interface IOrder{
			public final static String S01 = "1";
			public final static String S02 = "2";
			public final static String S03 = "3";
			public final static String S04 = "4";
			public final static String S05 = "5";// ��ͣ
			public final static String S06 = "6";// �ָ�
		}
	}
}
