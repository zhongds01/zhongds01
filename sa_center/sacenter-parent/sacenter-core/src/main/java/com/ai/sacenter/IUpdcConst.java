package com.ai.sacenter;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-12-2</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpdcConst {
	public interface ISystem{
		/*��ͨ���ȼ�*/
	    public static final String PRIORITY   = "PRIORITY";
	    /*��ͨ��Դ����*/
	    public static final String CHANNEL    = "CHANNEL";
	    /*��������*/
	    public static final String ORIGINATOR = "ORIGINATOR";
	    /*��ͨ��������*/
	    public static final String ACTIVATE   = "ACTIVATE";
	    /*ȫ���������*/
	    public static final String GLOBAL     = "GLOBAL";
	    /*��ͨ��������*/
	    public static final String CONTROL    = "CONTROL";
	    /*���и�ӿ���*/
	    public static final String PARALLEL   = "PARALLEL";
	}
	
	public interface IUpdbm{
		/*���ݷ���DAO*/
		public static final Class IUpdcDAO   = com.ai.sacenter.core.dao.interfaces.IUpdcDAO.class;
		/*�첽����DAO*/
		public static final Class IUpdfmxDAO = com.ai.sacenter.core.dao.interfaces.IUpdfmxDAO.class;
		/*��ͨ����DAO*/
		public static final Class IUpdbsDAO  = com.ai.sacenter.target.dao.interfaces.IUpdbsDAO.class;
		/*����׶�DAO*/
		public static final Class IUpfgxmDAO = com.ai.sacenter.suggest.dao.interfaces.IUpfgxmDAO.class;
		public interface IUpdbf{
    		/*Ĭ��·��*/
    		public static final String NORMAL      = "NORMAL";
    		/*����·��*/
    		public static final String BUFFER      = "BUFFER";
    		/*����·��*/
    		public static final String MULTLE      = "MULTLE";
    		/*�����ڷ���*/
    		public static final String EXPIRE      = "EXPIRE";
    		/*��Ԫ���ȼ�*/
    		public static final String PRIORITY    = "PRIORITY";
    		/*���ȼ�ʱ��*/
    		public static final String LIMITESS    = "LIMITESS";
    		/*ϵͳ����*/
    		public static final String SYSTEM      = "SYSTEM";
    		/*Ӧ��·��*/
    		public static final String REPLY       = "REPLY";
    		/*���ܱ��*/
    		public static final String CHANGE      = "CHANGE";
    		/*�߼�����*/
    		public static final String MSISDN      = "MSISDN";
    		/*������������*/
    		public final static String PRIMITIVE   = "PRIMITIVE";
    		/*������������*/
    		public final static String OPTIMIZE    = "OPTIMIZE";
    		/*������������*/
    		public final static String COMPLEX     = "COMPLEX";
    		/*�����û�*/
    		public final static String USER        = "USER";
    		/*Ⱥ���û�*/
    		public static final String GROUP       = "GROUP";
    		/*Ⱥ���Ա*/
    		public static final String MEMBER      = "MEMBER";
    		/*��������*/
    		public static final String CENTREX     = "CENTREX";
    		/*�����Ʒ*/
    		public final static String PRODUCTION  = "PRODUCTION";
    		/*�����Ʒ�淶*/
    		public final static String PROTECTION  = "PROTECTION";
    		/*�����Ʒ����*/
    		public final static String FEATURE     = "FEATURE";
    		/*������*/
    		public final static String ROCKET      = "ROCKET";
    		/*��������*/
    		public final static String TARGET      = "TARGET";
    		/*�׶ζ���*/
    		public final static String SUGGEST     = "SUGGEST";
    		/*���񶨵�*/
    		public final static String ORDER       = "ORDER";
    		/*��������*/
    		public final static String TASK        = "TASK";
    		/*�������*/
    		public final static String PROGRAM     = "PROGRAM";
    		/*���Ŀ¼*/
    		public final static String CATALOG     = "CATALOG";
    		/*ӳ����*/
    		public final static String MAPPING     = "MAPPING";
    		/*��������*/
    		public final static String OBJECTIVE   = "OBJECTIVE";
    		/*��Ԫ����*/
    		public final static String PROVISION   = "PROVISION";
    		/*��Ʒ����*/
    		public final static String COMPETENCE  = "COMPETENCE";
    		/*���Ƚӿ���*/
    		public static final String REFERENCE   = "REFERENCE";
    		/*����·��*/
    		public final static String NUMBER      = "NUMBER";
    		/*�Ŷξ���*/
			public static final String OFFICE      = "OFFICE";
			/*�߼�����*/
			public static final String SEGMENT     = "SEGMENT";
    		/*��Ԫ����*/
    		public final static String PLATFORM    = "PLATFORM";
    		/*��Ԫָ��*/
    		public final static String DIRECTIVE   = "DIRECTIVE";
    		/*��Ԫ��ָ��*/
    		public final static String CHILDREN    = "CHILDREN";
    		/*��Ԫ����*/
    		public final static String OPERATE     = "OPERATE";
    		/*��Ԫ�����ӿڱ�*/
    		public static final String PERSISTENT  = "PERSISTENT";
    		/*��Ԫ�����ӿڱ�DAO��*/
    		public static final String REPOSITORY  = "REPOSITORY";
    		/*��Ԫ���ݷ�����*/
    		public static final String PROTOCOL    = "PROTOCOL";
    		/*�첽������ǰ׺*/
    		public static final String COMPOSITE   = "COMPOSITE";
    		/*��ܽ�����־*/
    	    public final static String REQOTING    = "REQOTING";
    	    /*��ԪDEBUG״̬*/
    	    public final static String DEBUGING    = "DEBUGING";
    	    /*��Ԫͨ����*/
    	    public final static String CHANNEL     = "CHANNEL";
    	    /*���̶�������*/
    		public final static String PARAM       = "PARAM";
    		/*��������*/
    		public final static String LDPAP       = "LDPAP";
    	    /*���̼�����*/
    		public final static String SUBFLOW     = "SUBFLOW";
    		/*�Զ���*/
    		public final static String CUSTOM      = "CUSTOM";
    		/*�쳣����*/
    		public final static String EXCEPTION   = "EXCEPTION";
			/*�������*/
			public static final String HUMAN       = "HUMAN";
			/*�û����ƷѺ�*/
			public static final String BILL_ID     = "BILL_ID";
			/*�û��μƷѺ�*/
			public static final String SUB_BILL_ID = "SUB_BILL_ID";
			/*ͣ������*/
			public static final String STOP_TYPE   = "VMICMOST";
    	}
		public interface IUpdmc{
			/*�û�����*/
		    public static final String BILL_ID     = "BILL_ID";
			/*�������*/
		    public static final String REGION_ID   = "REGION_ID";
		    /*��������*/
		    public static final String REGION_CODE = "REGION_CODE";
		    /*���б���*/
		    public static final String DISTRICT_ID = "DISTRICT_ID";
		    /*�Զ���·��*/
			public static final String CUSTOM_ID   = "CUSTOM_ID";
		    /*���ı�־*/
		    public static final String CENTER_FLAG = "{CENTER}";
		    /*·������**/
	    	public static final String PROVISION   = "PROVISION";
		}
		public interface IUpdbpm{
			/*�û�����*/
			public static final String BILL_ID     = "SYS_BILL_ID";
			/*�μƷѺ�*/
			public static final String SUB_BILL_ID = "SYS_SUB_BILL_ID";
			/*�������*/
		    public static final String OFFICE      = "SYS_OFFICE";
		    /*��������*/
		    public static final String CATEGORY    = "SYS_CATEGORY";
		}
	}
	/*������������*/
	public interface IUpdcp{
		/*��Ʒ����࿪ͨ*/
		public final static String CATALOG     = "CATALOG";
		/*��Ʒ�����࿪ͨ*/
		public final static String BUSINES     = "BUSINESS";
		/*��Ʒ��������*/
		public final static String CHANNEL     = "CHANNEL";
		/*��ƷƷ���࿪ͨ*/
		public final static String TRADEMARK   = "TRADEMARK";
		/*�����࿪ͨ*/
		public final static String SERVICE     = "SERVICE";
		/*��Ʒ�࿪ͨ*/
		public final static String PRICE       = "PRICE";
		/*��ζ����࿪ͨ*/
		public final static String MULTLE      = "MULTLE";
		/*�����࿪ͨ*/
		public final static String ATTRIBUE    = "ATTRIBUE";
		/*�����࿪ͨ*/
		public final static String VIRTUAL     = "VIRTUAL";
		
		public interface IUpdbm{
			/*��ͨ�࿪ͨ*/
			public final static String PROGRAM_BUSINES    = "PROGRAM_BUSINES";
			/*�����࿪ͨ*/
			public final static String PROGRAM_COMPTEL    = "PROGRAM_COMPTEL";
			/*Ⱥ���࿪ͨ*/
			public final static String PROGRAM_GROUP      = "PROGRAM_GROUP";
			/*��Ⱥ�࿪ͨ*/
			public final static String PROGRAM_CENTREX    = "PROGRAM_CENTREX";
			/*��Ա�࿪ͨ*/
			public final static String PROGRAM_MEMBER     = "PROGRAM_MEMBER";
			/*���������*/
			public final static String PROGRAM_EXPIRE     = "PROGRAM_EXPIRE";
			/*���������*/
			public final static String PROGRAM_SHARE      = "PROGRAM_SHARE";
			/*�ݴ������*/
			public final static String PROGRAM_COMPENSA   = "PROGRAM_COMPENSA";
			/*�ع������*/
			public final static String PROGRAM_ROLLBACK   = "PROGRAM_ROLLBACK";
			/*һ�����������*/
			public final static String PROGRAM_MAPPING    = "PROGRAM_MAPPING";
			/*�������������*/
			public final static String PROGRAM_COMPOSITE  = "PROGRAM_COMPOSITE";
			/*���������*/
			public final static String PROGRAM_COMPLEX    = "PROGRAM_COMPLEX";
			/*�ɵ������*/
			public final static String PROGRAM_DISTRIBUTE = "PROGRAM_DISTRIBUTE";
			/*�쳣�ص������*/
			public final static String PROGRAM_SUBFLOW    = "PROGRAM_SUBFLOW";
			/*��Ԫ�����쳣�鵵�����*/
			public final static String PROGRAM_MONITOR    = "PROGRAM_MONITOR";
			/*��Ԫ�����쳣�����*/
			public final static String PROGRAM_PROVISION  = "PROGRAM_PROVISION";
			/*��Ԫ�쳣�����*/
			public final static String PROGRAM_PLATFORM   = "PROGRAM_PLATFORM";
			/*�쳣ԭ�������*/
			public final static String PROGRAM_EXCEPTION  = "PROGRAM_EXCEPTION";
			/*�鵵�����*/
			public final static String PROGRAM_COMPLETE   = "PROGRAM_COMPLETE";
			/*���������*/
			public final static String PROGRAM_QUEUE      = "PROGRAM_QUEUE";
			/*�׶������*/
			public final static String PROGRAM_SUGGEST    = "PROGRAM_SUGGEST";
			/*���񶨵��쳣���*/	
			public final static String PROGRAM_ROCKET     = "PROGRAM_ROCKET";
			/*���������������*/
			public final static String PROGRAM_UNIQUE     = "PROGRAM_UNIQUE";
		}
	}
	/*��ͨ����*/
	public interface IUpdfx{
		/*�ɹ�[ͳһ��������]*/
		public static final String SUCCEED   = "IOS0000000";
		/*δ֪����[ͳһ��������]*/
		public static final String UNKNOWN   = "IOS0000001";
		/*ϵͳ����[ͳһ��������]*/
		public static final String SYSTEM    = "IOS0000002";
		/*�˹�����[��Ԫ�쳣����]*/
		public static final String COMPLETE  = "IOS0000003";
		/*�˵��ع�[��Ԫ�쳣����]*/
		public static final String CANCEL    = "IOS0000004";
		/*��Ԫ�쳣[��Ԫ�쳣����]*/
		public static final String NETWORK   = "IOS0000005";
		/*��Ч������*/
		public static final String INVALID  =  "IOS0000006";
		/*�ض�����*/
		public static final String DESIGNING = "IOS0010017";
		/*�������쳣*/
		public static final String BLOCKING  = "IOS0012001";
		/*�������쳣*/
		public static final String CONNECT   = "IOS0012002";
		/*�������쳣*/
		public static final String IDLEING   = "IOS0012003";
		/*��ʱ���쳣*/
		public static final String TIMEOUT   = "IOS0012004";
		/*�߼����쳣*/
		public static final String REMOTE    = "IOS0012005";
		/*�ļ����쳣*/
		public static final String FILEING   = "IOS0012006";
		/*ʧ�����쳣*/
		public static final String FAULTING  = "IOS0012015";
		/*��ֵ���ʽ�쳣*/
		public static final String JEVALING  = "IOS0011033";
		/*���ݿ����쳣*/
		public static final String ORACLE    = "IOS0014000";
		/*����������*/
		public interface IDomain{
			/*�ڲ���Դ*/
			public static final String INSIDE   = "INSIDE";
			/*δ֪����*/
			public static final String EXTEND   = "EXTEND";
		}
		/*�������*/
		public interface IQuality{
			/*�ɹ�*/
			public static final String SUCCEED   = "UBOCB00000000";
			/*δ֪����*/
			public static final String UNKNOWN   = "UBOCB00000001";
			/*ϵͳ����*/
			public static final String SYSTEM    = "UBOCB00000002";
			/*���������*/
			public static final String DESIGNING = "UBOCB00000003";
			/*�������쳣*/
			public static final String CONNECT   = "UBOCB00000004";
			/*�������쳣*/
			public static final String IDLEING   = "UBOCB00000005";
			/*��ʱ���쳣*/
			public static final String TIMEOUT   = "UBOCB00000006";
			/*��Ԫ���쳣*/
			public static final String REMOTE    = "UBOCB00000007";
			/*���ݿ����쳣*/
			public static final String ORACLE    = "UBOCB00000008";
		}
	}
	/*��Ԫ����*/
	public interface IUpfwm{
		/*�Ƿ��߼��쳣*/
    	public final static String PLWK_FAILURE  = "PLWK_FAILURE";
    	/*��������*/
    	public final static String PLWK_CODING   = "PLWK_CODING";
    	/*��������*/
    	public final static String PLWK_DESCRIBE = "PLWK_DESCRIBE";
    	/*ԭʼ��������*/
    	public final static String PLWK_BOTTOM   = "PLWK_BOTTOM";
    	/*�����������*/
    	public final static String PLWK_DISPING  = "PLWK_DISPING";
    	/*ԭʼ������*/
    	public final static String PLWK_ORIGING  = "PLWK_ORIGING";
    	/*ԭʼ��������*/
    	public final static String PLWK_HOMEING  = "PLWK_HOMEING";
    	/*��Ԫ��������*/
    	public final static String PLWK_NETWORK  = "PLWK_NETWORK";
    	/*Ӧ��������*/
    	public final static String PLWK_ETOMING  = "PLWK_ETOMING";
    	/*�쳣��Ϣ*/
    	public final static String PLWK_EXCEPTION = "PLWK_EXCEPTION";
    	public interface IUpfm{
    		/*�����Ԫ*/
    		public static final String ucmframe = "ucmframe";
    	}
    	public interface IUpdpfm{
    		/*VMģ��*/
    		public final static String VM = "VM";
    		/*WMģ��*/
    		public final static String WM = "WM";
    		public interface IUpfmx{
        		/*�ļ�ģ��*/
        		public final static String FILE = "FILE";
        		/*�ַ���ģ��*/
        		public final static String CHAR = "CHAR";
        	}
    	}
    	/*ָ������*/
        public interface IUpdfm{
        	/*��Ԫ��¼����*/
        	public final static String LOGIN  = "LOGIN";
        	/*��Ԫע������*/
        	public final static String LOGOUT = "LOGOUT";
        	/*��Ԫ��������*/
        	public final static String HBHBT  = "HBHBT";
        }
        /*��������*/
    	public interface IUpfms{
    		/*����������*/
    		public final static String WHITELST = "WHITELST";
    		/*����������*/
    		public final static String BLACKLST = "BLACKLST";
    	}
    }
	/*����ö��*/
	public interface IEnum{
		/*���̿�ͨ��������ֽ���*/
    	public static final String BYTE      = "SYSTEM.BYTE";
    	/*������������*/
    	public static final String ROWNUM    = "SYSTEM.ROWNUM";
    	/*������Դ*/
    	public static final String CHANNEL   = "SYSTEM.CHANNEL";
    	/*��������*/
    	public static final String MSDNLST   = "SYSTEM.MSDNLIST";
    	/*Ĭ�����ȼ�*/
    	public static final String PRIORITY  = "JPI0000";
    	/*Ĭ�Ϲ���*/
	    public static final String STAFF     = "999999";
	    /*Ĭ����֯*/
	    public static final String ORGANIZE  = "999999";
	    /*ϵͳ��λ*/
		public static final String STATION   = "SYSTEM";
		/*ϵͳ����*/
	    public static final String SYSTEM    = "SYSTEM";
		/*ϵͳ�����ַ���*/
    	public interface ISschk{
    		public static final String NULL    = "NULL";
    		public static final String ISC$    = "$";
    		public static final String UnKnown = "*";
    	}
    	public interface IYesNo{
    		public static final String Yes = "Y";
    		public static final String No  = "N";
    	}
    	/*��������*/
        public interface IInvoke{
        	/*��*/
        	public final static String Pojo = "Pojo";
        	/*����*/
			public final static String Singleton = "Singleton";
			/*�̵߳���*/
			public final static String SingletonT = "SingletonT";
			/*�ⲿ����������������*/
			public final static String Primitive = "Primitive";
			/*�ڲ�����������������*/
			public final static String Optimize  = "Optimize";
			/*�Զ���������*/
			public final static String Interceptor = "Interceptor";
			/*HTTP*/
			public final static String WebService = "webservice";
			/*EJB*/
			public final static String Ejb = "Ejb";
		}
    }
	/*��������*/
	public interface ICache{
		public final static Class IIUpfmsgtI     = com.ai.sacenter.cache.redis.IIOfficeCacheImpl.class;
		public final static Class IIUpdpbfgI     = com.ai.sacenter.cache.redis.IIBasicCacheImpl.class;
		public final static Class IIMultlesI     = com.ai.sacenter.cache.redis.IIMultlesCacheImpl.class;
		public final static Class IIUpdfgrpI     = com.ai.sacenter.cache.redis.IIRespondCacheImpl.class;
		public final static Class IIUpdfbmcI     = com.ai.sacenter.cache.redis.IIBusinesCacheImpl.class;
		public final static Class IIUpdfbpmI     = com.ai.sacenter.cache.redis.IISubFlowCacheImpl.class;
		public final static Class IIUpdprgmI     = com.ai.sacenter.cache.redis.IIComponentCacheImpl.class;
		public final static Class IIUpfvmfsI     = com.ai.sacenter.cache.redis.IIProtocolCacheImpl.class;
		public final static Class IIUpdcpgmI     = com.ai.sacenter.cache.redis.IICompetenceCacheImpl.class;
		public final static Class IIUpfgmccI     = com.ai.sacenter.cache.redis.IIPlatformCacheImpl.class;
		public final static Class IIUpfgsmcI     = com.ai.sacenter.cache.redis.IIMappingCacheImpl.class;
		public interface ICachePref{
			public final static String I_SYSTEM                      = "I_SYSTEM";/*ϵͳ������*/
			public final static String I_SYSTEM_STATIC               = "I_SYSTEM_STATIC";/*ö���嵥*/
			public final static String I_SYSTEM_CATEGORY             = "I_SYSTEM_CATEGORY";/*ö���嵥*/
			public final static String I_SYSTEM_DICTION              = "I_SYSTEM_DICTION";/*�ֵ��嵥*/
			public final static String I_SYSTEM_PARALLEL             = "I_SYSTEM_PARALLEL";/*��Ӳ���*/
			public final static String I_SYSTEM_DISTRICT             = "I_SYSTEM_DISTRICT";/*�����嵥*/
			public final static String I_SYSTEM_LIBRARY              = "I_SYSTEM_LIBRARY";/*�ӿڿ��嵥*/
			public final static String I_MULTLE_RESOURCE             = "I_MULTLE_RESOURCE";/*��ͨ���ʱ�����Դ�嵥*/
			public final static String I_CENTER                      = "I_CENTER";/*���������嵥*/
			public final static String I_CENTER_CATALOG              = "I_CENTER_CATALOG";/*��������ӳ���嵥*/
			public final static String I_CENTER_MAPPING              = "I_CENTER_MAPPING";/*��������·��ӳ���嵥*/
			public final static String I_CENTER_WRAPPER              = "I_CENTER_WRAPPER";/*��������·��ת���嵥*/
			public final static String I_CENTER_ROUTING              = "I_CENTER_ROUTING";/*��������·���嵥*/
			public final static String I_SUBTABLE                    = "I_SUBTABLE";/*��Χ�ӿ�ӳ��*/
			public final static String I_SUBTABLE_PERSISTENT         = "I_SUBTABLE_PERSISTENT";/*�ֱ�־û��嵥*/
			public final static String I_SUBTABLE_NETWORK            = "I_SUBTABLE_NETWORK";/*��Ԫ�ֱ�淶*/
			public final static String I_SUBTABLE_BASIC              = "I_SUBTABLE_BASIC";/*�ֱ����TABLE�嵥*/
			public final static String I_SUBTABLE_LOCATION           = "I_SUBTABLE_LOCATION";/*�ֱ����LOCATION�嵥*/
			public final static String I_SUBTABLE_ROUTING            = "I_SUBTABLE_ROUTING";/*�ֱ�·�ɹ����嵥*/ 
			public final static String I_SUBTABLE_IDGENERATOR        = "I_SUBTABLE_IDGENERATOR";/*�ֱ���ת���嵥*/
			public final static String I_SUBTABLE_REGIONNUMBER       = "I_SUBTABLE_REGIONNUMBER";/*�ֱ���ת���嵥*/
			public final static String I_OFFICE                      = "I_OFFICE";/*���������嵥*/
			public final static String I_OFFICE_SECTION              = "I_OFFICE_SECTION";/*�Ŷξ����嵥*/
			public final static String I_OFFICE_PHONE                = "I_OFFICE_PHONE";/*��Ԫ�����嵥*/
			public final static String I_PRIORITY_BUSINESS           = "I_PRIORITY_BUSINESS";/*ҵ�����ȼ�·���嵥*/
			public final static String I_PRIORITY_LIMITE             = "I_PRIORITY_LIMITE";/*��Ԫ���ȼ�ʱ��·���嵥*/
			public final static String I_PLATFORM                    = "I_PLATFORM";/*��Ԫ�嵥*/
			public final static String I_PLATFORM_NETWORK            = "I_PLATFORM_NETWORK";/*��Ԫ��·�嵥*/
			public final static String I_PLATFORM_BASIC              = "I_PLATFORM_BASIC";/*��Ԫ�����嵥*/
			public final static String I_PLATFORM_PARENT             = "I_PLATFORM_PARENT";/*ƽ̨�ϼ��嵥*/
			public final static String I_PLATFORM_CHILD              = "I_PLATFORM_CHILD";/*ƽ̨�¼��嵥*/
			public final static String I_PLATFORM_DEBUG              = "I_PLATFORM_DEBUG";/*��Ԫ�����嵥*/
			public final static String I_PLATFORM_OPERATE            = "I_PLATFORM_OPERATE";/*��Ԫ�����嵥*/
			public final static String I_PLATFORM_DIRECTIVE          = "I_PLATFORM_DIRECTIVE";/*��Ԫָ���嵥*/
			public final static String I_PLATFORM_SUBFLOW            = "I_PLATFORM_SUBFLOW";/*��Ԫ���������嵥*/
			public final static String I_PLATFORM_FEATURE            = "I_PLATFORM_FEATURE";/*��Ԫ�����嵥*/
			public final static String I_PLATFORM_PROTOCOL           = "I_PLATFORM_PROTOCOL";/*��Ԫģ���嵥*/
			public final static String I_PLATFORM_MAPPING            = "I_PLATFORM_MAPPING";/*��Ԫӳ���嵥*/
			public final static String I_PLATFORM_MISC               = "I_PLATFORM_MISC";/*��Ԫ������չ�嵥*/
			public final static String I_PROGRAM                     = "I_PROGRAM";/*��ܽ������*/
			public final static String I_PROGRAM_RESPOND             = "I_PROGRAM_RESPOND";/*��ܷ����嵥*/
			public final static String I_PROGRAM_RESPOND_BASIC       = "I_PROGRAM_RESPOND_BASIC";/*��ܷ����嵥*/
			public final static String I_PROGRAM_RESPOND_RELATE      = "I_PROGRAM_RESPOND_RELATE";/*��ܷ��������嵥*/
			public final static String I_PROGRAM_PROGRAM             = "I_PROGRAM_PROGRAM";/*��ܽ������*/
			public final static String I_PROGRAM_COMPONENT           = "I_PROGRAM_COMPONENT";/*��������嵥*/
			public final static String I_PROGRAM_COMPONENT_MAPPING   = "I_PROGRAM_COMPONENT_MAPPING";/*������������嵥*/
			public final static String I_COMPETENCE_BUSINES          = "I_COMPETENCE_BUSINES";/*�������������嵥*/
			public final static String I_COMPETENCE_BUSINES_KERNEL   = "I_COMPETENCE_BUSINES_KERNEL";/*��������������չ�嵥*/
			public final static String I_COMPETENCE_BUSINES_COMPETE  = "I_COMPETENCE_BUSINES_COMPETE";/*�������������Ʒ��չ�嵥*/
			public final static String I_COMPETENCE_TEMPLATE         = "I_COMPETENCE_TEMPLATE";/*��������ģ��*/
			public final static String I_COMPETENCE_WORKFLOW         = "I_COMPETENCE_WORKFLOW";/*���������嵥*/
			public final static String I_COMPETENCE_BPELFLOW         = "I_COMPETENCE_BPELFLOW";/*�������������嵥*/
			public final static String I_COMPETENCE_PRODUCT          = "I_COMPETENCE_PRODUCT";/*�����Ʒ��Ԫ*/
			public final static String I_COMPETENCE_PRODUCT_BASIC    = "I_COMPETENCE_PRODUCT_BASIC";/*�����Ʒ��Ԫ[��Ʒ���]*/
			public final static String I_COMPETENCE_PRODUCT_COMPTEL  = "I_COMPETENCE_PRODUCT_COMPTEL";/*�����Ʒ��Ԫ[��Ʒ����]*/
			public final static String I_COMPETENCE_PRODUCT_SUBJECT  = "I_COMPETENCE_PRODUCT_SUBJECT";/*�����Ʒ��չ����[��Ʒ���]*/
			public final static String I_COMPETENCE_PRODUCT_COMBINE  = "I_COMPETENCE_PRODUCT_COMBINE";/*�����Ʒ��Ԫ[��Ʒ����]*/
			public final static String I_COMPETENCE_PRODUCT_GROUP    = "I_COMPETENCE_PRODUCT_GROUP";/*�����Ʒ��Ԫ[��Ʒ������]*/
			public final static String I_COMPETENCE_PRODUCT_KERNEL   = "I_COMPETENCE_PRODUCT_KERNEL";/*����������[�������]*/
		}
	}
	/*����״̬*/
	public interface IState{
		public final static String C  = "C" ;
		public final static String B  = "B" ;
		public final static String K  = "K" ;
		public final static String D  = "D" ;
		public final static String R  = "R" ;
		public final static String X  = "X" ;
		public final static String O  = "O" ;
		public final static String Q  = "Q" ;
		public final static String W  = "W" ;
		public final static String E  = "E" ;
		public final static String U  = "U" ;
		public final static String F  = "F" ;
		public final static String H  = "H" ;
		public final static String T  = "T" ;
		public final static String P  = "P" ;
		public final static String S  = "S" ;
		public final static String EC = "EC";
		public final static String CE = "CE";
	}
}
