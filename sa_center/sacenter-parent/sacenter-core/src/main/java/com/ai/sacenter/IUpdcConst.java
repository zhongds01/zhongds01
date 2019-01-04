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
		/*开通优先级*/
	    public static final String PRIORITY   = "PRIORITY";
	    /*开通来源类型*/
	    public static final String CHANNEL    = "CHANNEL";
	    /*发起方类型*/
	    public static final String ORIGINATOR = "ORIGINATOR";
	    /*开通流程日期*/
	    public static final String ACTIVATE   = "ACTIVATE";
	    /*全局事务控制*/
	    public static final String GLOBAL     = "GLOBAL";
	    /*开通名单控制*/
	    public static final String CONTROL    = "CONTROL";
	    /*并行割接控制*/
	    public static final String PARALLEL   = "PARALLEL";
	}
	
	public interface IUpdbm{
		/*数据访问DAO*/
		public static final Class IUpdcDAO   = com.ai.sacenter.core.dao.interfaces.IUpdcDAO.class;
		/*异步访问DAO*/
		public static final Class IUpdfmxDAO = com.ai.sacenter.core.dao.interfaces.IUpdfmxDAO.class;
		/*开通反馈DAO*/
		public static final Class IUpdbsDAO  = com.ai.sacenter.target.dao.interfaces.IUpdbsDAO.class;
		/*服务阶段DAO*/
		public static final Class IUpfgxmDAO = com.ai.sacenter.suggest.dao.interfaces.IUpfgxmDAO.class;
		public interface IUpdbf{
    		/*默认路由*/
    		public static final String NORMAL      = "NORMAL";
    		/*缓存路由*/
    		public static final String BUFFER      = "BUFFER";
    		/*批量路由*/
    		public static final String MULTLE      = "MULTLE";
    		/*下周期发起*/
    		public static final String EXPIRE      = "EXPIRE";
    		/*网元优先级*/
    		public static final String PRIORITY    = "PRIORITY";
    		/*优先级时限*/
    		public static final String LIMITESS    = "LIMITESS";
    		/*系统工号*/
    		public static final String SYSTEM      = "SYSTEM";
    		/*应答路由*/
    		public static final String REPLY       = "REPLY";
    		/*功能变更*/
    		public static final String CHANGE      = "CHANGE";
    		/*逻辑号码*/
    		public static final String MSISDN      = "MSISDN";
    		/*服务其它属性*/
    		public final static String PRIMITIVE   = "PRIMITIVE";
    		/*服务其它属性*/
    		public final static String OPTIMIZE    = "OPTIMIZE";
    		/*服务其它属性*/
    		public final static String COMPLEX     = "COMPLEX";
    		/*服务用户*/
    		public final static String USER        = "USER";
    		/*群组用户*/
    		public static final String GROUP       = "GROUP";
    		/*群组成员*/
    		public static final String MEMBER      = "MEMBER";
    		/*固网服务*/
    		public static final String CENTREX     = "CENTREX";
    		/*服务产品*/
    		public final static String PRODUCTION  = "PRODUCTION";
    		/*服务产品规范*/
    		public final static String PROTECTION  = "PROTECTION";
    		/*服务产品属性*/
    		public final static String FEATURE     = "FEATURE";
    		/*服务报文*/
    		public final static String ROCKET      = "ROCKET";
    		/*反馈定单*/
    		public final static String TARGET      = "TARGET";
    		/*阶段定单*/
    		public final static String SUGGEST     = "SUGGEST";
    		/*服务定单*/
    		public final static String ORDER       = "ORDER";
    		/*服务任务*/
    		public final static String TASK        = "TASK";
    		/*解决方案*/
    		public final static String PROGRAM     = "PROGRAM";
    		/*规格目录*/
    		public final static String CATALOG     = "CATALOG";
    		/*映射结果*/
    		public final static String MAPPING     = "MAPPING";
    		/*服务反馈单*/
    		public final static String OBJECTIVE   = "OBJECTIVE";
    		/*网元工单*/
    		public final static String PROVISION   = "PROVISION";
    		/*产品能力*/
    		public final static String COMPETENCE  = "COMPETENCE";
    		/*调度接口类*/
    		public static final String REFERENCE   = "REFERENCE";
    		/*号码路由*/
    		public final static String NUMBER      = "NUMBER";
    		/*号段局向*/
			public static final String OFFICE      = "OFFICE";
			/*逻辑号码*/
			public static final String SEGMENT     = "SEGMENT";
    		/*网元基础*/
    		public final static String PLATFORM    = "PLATFORM";
    		/*网元指令*/
    		public final static String DIRECTIVE   = "DIRECTIVE";
    		/*网元子指令*/
    		public final static String CHILDREN    = "CHILDREN";
    		/*网元操作*/
    		public final static String OPERATE     = "OPERATE";
    		/*网元工单接口表*/
    		public static final String PERSISTENT  = "PERSISTENT";
    		/*网元工单接口表DAO类*/
    		public static final String REPOSITORY  = "REPOSITORY";
    		/*网元数据分析器*/
    		public static final String PROTOCOL    = "PROTOCOL";
    		/*异步工单表前缀*/
    		public static final String COMPOSITE   = "COMPOSITE";
    		/*框架交易日志*/
    	    public final static String REQOTING    = "REQOTING";
    	    /*网元DEBUG状态*/
    	    public final static String DEBUGING    = "DEBUGING";
    	    /*网元通道集*/
    	    public final static String CHANNEL     = "CHANNEL";
    	    /*流程定购属性*/
    		public final static String PARAM       = "PARAM";
    		/*上下文类*/
    		public final static String LDPAP       = "LDPAP";
    	    /*流程级反馈*/
    		public final static String SUBFLOW     = "SUBFLOW";
    		/*自定义*/
    		public final static String CUSTOM      = "CUSTOM";
    		/*异常工单*/
    		public final static String EXCEPTION   = "EXCEPTION";
			/*落地任务*/
			public static final String HUMAN       = "HUMAN";
			/*用户主计费号*/
			public static final String BILL_ID     = "BILL_ID";
			/*用户次计费号*/
			public static final String SUB_BILL_ID = "SUB_BILL_ID";
			/*停机类型*/
			public static final String STOP_TYPE   = "VMICMOST";
    	}
		public interface IUpdmc{
			/*用户号码*/
		    public static final String BILL_ID     = "BILL_ID";
			/*地区编号*/
		    public static final String REGION_ID   = "REGION_ID";
		    /*地区区号*/
		    public static final String REGION_CODE = "REGION_CODE";
		    /*地市编码*/
		    public static final String DISTRICT_ID = "DISTRICT_ID";
		    /*自定义路由*/
			public static final String CUSTOM_ID   = "CUSTOM_ID";
		    /*中心标志*/
		    public static final String CENTER_FLAG = "{CENTER}";
		    /*路由类型**/
	    	public static final String PROVISION   = "PROVISION";
		}
		public interface IUpdbpm{
			/*用户号码*/
			public static final String BILL_ID     = "SYS_BILL_ID";
			/*次计费号*/
			public static final String SUB_BILL_ID = "SYS_SUB_BILL_ID";
			/*局向编码*/
		    public static final String OFFICE      = "SYS_OFFICE";
		    /*局向类型*/
		    public static final String CATEGORY    = "SYS_CATEGORY";
		}
	}
	/*激活能力类型*/
	public interface IUpdcp{
		/*产品规格类开通*/
		public final static String CATALOG     = "CATALOG";
		/*产品操作类开通*/
		public final static String BUSINES     = "BUSINESS";
		/*产品渠道类类*/
		public final static String CHANNEL     = "CHANNEL";
		/*产品品牌类开通*/
		public final static String TRADEMARK   = "TRADEMARK";
		/*服务类开通*/
		public final static String SERVICE     = "SERVICE";
		/*产品类开通*/
		public final static String PRICE       = "PRICE";
		/*多次订购类开通*/
		public final static String MULTLE      = "MULTLE";
		/*属性类开通*/
		public final static String ATTRIBUE    = "ATTRIBUE";
		/*其它类开通*/
		public final static String VIRTUAL     = "VIRTUAL";
		
		public interface IUpdbm{
			/*普通类开通*/
			public final static String PROGRAM_BUSINES    = "PROGRAM_BUSINES";
			/*立即类开通*/
			public final static String PROGRAM_COMPTEL    = "PROGRAM_COMPTEL";
			/*群组类开通*/
			public final static String PROGRAM_GROUP      = "PROGRAM_GROUP";
			/*虚群类开通*/
			public final static String PROGRAM_CENTREX    = "PROGRAM_CENTREX";
			/*成员类开通*/
			public final static String PROGRAM_MEMBER     = "PROGRAM_MEMBER";
			/*到期类组件*/
			public final static String PROGRAM_EXPIRE     = "PROGRAM_EXPIRE";
			/*共享类组件*/
			public final static String PROGRAM_SHARE      = "PROGRAM_SHARE";
			/*容错类组件*/
			public final static String PROGRAM_COMPENSA   = "PROGRAM_COMPENSA";
			/*回滚类组件*/
			public final static String PROGRAM_ROLLBACK   = "PROGRAM_ROLLBACK";
			/*一级属性类组件*/
			public final static String PROGRAM_MAPPING    = "PROGRAM_MAPPING";
			/*二级属性类组件*/
			public final static String PROGRAM_COMPOSITE  = "PROGRAM_COMPOSITE";
			/*变量类组件*/
			public final static String PROGRAM_COMPLEX    = "PROGRAM_COMPLEX";
			/*派单类组件*/
			public final static String PROGRAM_DISTRIBUTE = "PROGRAM_DISTRIBUTE";
			/*异常回单类组件*/
			public final static String PROGRAM_SUBFLOW    = "PROGRAM_SUBFLOW";
			/*网元定单异常归档类组件*/
			public final static String PROGRAM_MONITOR    = "PROGRAM_MONITOR";
			/*网元调度异常类组件*/
			public final static String PROGRAM_PROVISION  = "PROGRAM_PROVISION";
			/*网元异常类组件*/
			public final static String PROGRAM_PLATFORM   = "PROGRAM_PLATFORM";
			/*异常原因类组件*/
			public final static String PROGRAM_EXCEPTION  = "PROGRAM_EXCEPTION";
			/*归档类组件*/
			public final static String PROGRAM_COMPLETE   = "PROGRAM_COMPLETE";
			/*队列类组件*/
			public final static String PROGRAM_QUEUE      = "PROGRAM_QUEUE";
			/*阶段类组件*/
			public final static String PROGRAM_SUGGEST    = "PROGRAM_SUGGEST";
			/*服务定单异常组件*/	
			public final static String PROGRAM_ROCKET     = "PROGRAM_ROCKET";
			/*服务索引归属组件*/
			public final static String PROGRAM_UNIQUE     = "PROGRAM_UNIQUE";
		}
	}
	/*开通反馈*/
	public interface IUpdfx{
		/*成功[统一反馈代码]*/
		public static final String SUCCEED   = "IOS0000000";
		/*未知错误[统一反馈代码]*/
		public static final String UNKNOWN   = "IOS0000001";
		/*系统错误[统一反馈代码]*/
		public static final String SYSTEM    = "IOS0000002";
		/*人工跳单[网元异常界面]*/
		public static final String COMPLETE  = "IOS0000003";
		/*退单回滚[网元异常界面]*/
		public static final String CANCEL    = "IOS0000004";
		/*网元异常[网元异常界面]*/
		public static final String NETWORK   = "IOS0000005";
		/*无效配置项*/
		public static final String INVALID  =  "IOS0000006";
		/*特定错误*/
		public static final String DESIGNING = "IOS0010017";
		/*堵塞类异常*/
		public static final String BLOCKING  = "IOS0012001";
		/*连接类异常*/
		public static final String CONNECT   = "IOS0012002";
		/*并发类异常*/
		public static final String IDLEING   = "IOS0012003";
		/*超时类异常*/
		public static final String TIMEOUT   = "IOS0012004";
		/*逻辑类异常*/
		public static final String REMOTE    = "IOS0012005";
		/*文件类异常*/
		public static final String FILEING   = "IOS0012006";
		/*失败类异常*/
		public static final String FAULTING  = "IOS0012015";
		/*正值表达式异常*/
		public static final String JEVALING  = "IOS0011033";
		/*数据库类异常*/
		public static final String ORACLE    = "IOS0014000";
		/*归属域类型*/
		public interface IDomain{
			/*内部资源*/
			public static final String INSIDE   = "INSIDE";
			/*未知错误*/
			public static final String EXTEND   = "EXTEND";
		}
		/*对外编码*/
		public interface IQuality{
			/*成功*/
			public static final String SUCCEED   = "UBOCB00000000";
			/*未知错误*/
			public static final String UNKNOWN   = "UBOCB00000001";
			/*系统错误*/
			public static final String SYSTEM    = "UBOCB00000002";
			/*配置类错误*/
			public static final String DESIGNING = "UBOCB00000003";
			/*连接类异常*/
			public static final String CONNECT   = "UBOCB00000004";
			/*并发类异常*/
			public static final String IDLEING   = "UBOCB00000005";
			/*超时类异常*/
			public static final String TIMEOUT   = "UBOCB00000006";
			/*网元类异常*/
			public static final String REMOTE    = "UBOCB00000007";
			/*数据库类异常*/
			public static final String ORACLE    = "UBOCB00000008";
		}
	}
	/*网元类型*/
	public interface IUpfwm{
		/*是否逻辑异常*/
    	public final static String PLWK_FAILURE  = "PLWK_FAILURE";
    	/*反馈代码*/
    	public final static String PLWK_CODING   = "PLWK_CODING";
    	/*反馈描述*/
    	public final static String PLWK_DESCRIBE = "PLWK_DESCRIBE";
    	/*原始反馈描述*/
    	public final static String PLWK_BOTTOM   = "PLWK_BOTTOM";
    	/*反馈结果报文*/
    	public final static String PLWK_DISPING  = "PLWK_DISPING";
    	/*原始请求报文*/
    	public final static String PLWK_ORIGING  = "PLWK_ORIGING";
    	/*原始反馈报文*/
    	public final static String PLWK_HOMEING  = "PLWK_HOMEING";
    	/*网元反馈报文*/
    	public final static String PLWK_NETWORK  = "PLWK_NETWORK";
    	/*应答代码策略*/
    	public final static String PLWK_ETOMING  = "PLWK_ETOMING";
    	/*异常信息*/
    	public final static String PLWK_EXCEPTION = "PLWK_EXCEPTION";
    	public interface IUpfm{
    		/*框架网元*/
    		public static final String ucmframe = "ucmframe";
    	}
    	public interface IUpdpfm{
    		/*VM模板*/
    		public final static String VM = "VM";
    		/*WM模板*/
    		public final static String WM = "WM";
    		public interface IUpfmx{
        		/*文件模板*/
        		public final static String FILE = "FILE";
        		/*字符串模板*/
        		public final static String CHAR = "CHAR";
        	}
    	}
    	/*指令类型*/
        public interface IUpdfm{
        	/*网元登录流程*/
        	public final static String LOGIN  = "LOGIN";
        	/*网元注销流程*/
        	public final static String LOGOUT = "LOGOUT";
        	/*网元心跳流程*/
        	public final static String HBHBT  = "HBHBT";
        }
        /*名单类型*/
    	public interface IUpfms{
    		/*白名单类型*/
    		public final static String WHITELST = "WHITELST";
    		/*黑名单类型*/
    		public final static String BLACKLST = "BLACKLST";
    	}
    }
	/*环境枚举*/
	public interface IEnum{
		/*流程开通属性最大字节数*/
    	public static final String BYTE      = "SYSTEM.BYTE";
    	/*调度任务处理量*/
    	public static final String ROWNUM    = "SYSTEM.ROWNUM";
    	/*流程来源*/
    	public static final String CHANNEL   = "SYSTEM.CHANNEL";
    	/*名单控制*/
    	public static final String MSDNLST   = "SYSTEM.MSDNLIST";
    	/*默认优先级*/
    	public static final String PRIORITY  = "JPI0000";
    	/*默认工号*/
	    public static final String STAFF     = "999999";
	    /*默认组织*/
	    public static final String ORGANIZE  = "999999";
	    /*系统岗位*/
		public static final String STATION   = "SYSTEM";
		/*系统渠道*/
	    public static final String SYSTEM    = "SYSTEM";
		/*系统特殊字符键*/
    	public interface ISschk{
    		public static final String NULL    = "NULL";
    		public static final String ISC$    = "$";
    		public static final String UnKnown = "*";
    	}
    	public interface IYesNo{
    		public static final String Yes = "Y";
    		public static final String No  = "N";
    	}
    	/*服务类型*/
        public interface IInvoke{
        	/*简单*/
        	public final static String Pojo = "Pojo";
        	/*单例*/
			public final static String Singleton = "Singleton";
			/*线程单例*/
			public final static String SingletonT = "SingletonT";
			/*外部服务交易索引拦截器*/
			public final static String Primitive = "Primitive";
			/*内部服务交易索引拦截器*/
			public final static String Optimize  = "Optimize";
			/*自定义拦截器*/
			public final static String Interceptor = "Interceptor";
			/*HTTP*/
			public final static String WebService = "webservice";
			/*EJB*/
			public final static String Ejb = "Ejb";
		}
    }
	/*缓存类型*/
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
			public final static String I_SYSTEM                      = "I_SYSTEM";/*系统级缓存*/
			public final static String I_SYSTEM_STATIC               = "I_SYSTEM_STATIC";/*枚举清单*/
			public final static String I_SYSTEM_CATEGORY             = "I_SYSTEM_CATEGORY";/*枚举清单*/
			public final static String I_SYSTEM_DICTION              = "I_SYSTEM_DICTION";/*字典清单*/
			public final static String I_SYSTEM_PARALLEL             = "I_SYSTEM_PARALLEL";/*割接策略*/
			public final static String I_SYSTEM_DISTRICT             = "I_SYSTEM_DISTRICT";/*区域清单*/
			public final static String I_SYSTEM_LIBRARY              = "I_SYSTEM_LIBRARY";/*接口库清单*/
			public final static String I_MULTLE_RESOURCE             = "I_MULTLE_RESOURCE";/*开通国际编码资源清单*/
			public final static String I_CENTER                      = "I_CENTER";/*服务中心清单*/
			public final static String I_CENTER_CATALOG              = "I_CENTER_CATALOG";/*服务中心映射清单*/
			public final static String I_CENTER_MAPPING              = "I_CENTER_MAPPING";/*服务中心路由映射清单*/
			public final static String I_CENTER_WRAPPER              = "I_CENTER_WRAPPER";/*服务中心路由转换清单*/
			public final static String I_CENTER_ROUTING              = "I_CENTER_ROUTING";/*服务中心路由清单*/
			public final static String I_SUBTABLE                    = "I_SUBTABLE";/*外围接口映射*/
			public final static String I_SUBTABLE_PERSISTENT         = "I_SUBTABLE_PERSISTENT";/*分表持久化清单*/
			public final static String I_SUBTABLE_NETWORK            = "I_SUBTABLE_NETWORK";/*网元分表规范*/
			public final static String I_SUBTABLE_BASIC              = "I_SUBTABLE_BASIC";/*分表规则按TABLE清单*/
			public final static String I_SUBTABLE_LOCATION           = "I_SUBTABLE_LOCATION";/*分表规则按LOCATION清单*/
			public final static String I_SUBTABLE_ROUTING            = "I_SUBTABLE_ROUTING";/*分表路由规则清单*/ 
			public final static String I_SUBTABLE_IDGENERATOR        = "I_SUBTABLE_IDGENERATOR";/*分表编号转换清单*/
			public final static String I_SUBTABLE_REGIONNUMBER       = "I_SUBTABLE_REGIONNUMBER";/*分表编号转换清单*/
			public final static String I_OFFICE                      = "I_OFFICE";/*号码配置清单*/
			public final static String I_OFFICE_SECTION              = "I_OFFICE_SECTION";/*号段局向清单*/
			public final static String I_OFFICE_PHONE                = "I_OFFICE_PHONE";/*网元名单清单*/
			public final static String I_PRIORITY_BUSINESS           = "I_PRIORITY_BUSINESS";/*业务优先级路由清单*/
			public final static String I_PRIORITY_LIMITE             = "I_PRIORITY_LIMITE";/*网元优先级时限路由清单*/
			public final static String I_PLATFORM                    = "I_PLATFORM";/*网元清单*/
			public final static String I_PLATFORM_NETWORK            = "I_PLATFORM_NETWORK";/*网元网路清单*/
			public final static String I_PLATFORM_BASIC              = "I_PLATFORM_BASIC";/*网元基本清单*/
			public final static String I_PLATFORM_PARENT             = "I_PLATFORM_PARENT";/*平台上级清单*/
			public final static String I_PLATFORM_CHILD              = "I_PLATFORM_CHILD";/*平台下级清单*/
			public final static String I_PLATFORM_DEBUG              = "I_PLATFORM_DEBUG";/*网元测试清单*/
			public final static String I_PLATFORM_OPERATE            = "I_PLATFORM_OPERATE";/*网元操作清单*/
			public final static String I_PLATFORM_DIRECTIVE          = "I_PLATFORM_DIRECTIVE";/*网元指令清单*/
			public final static String I_PLATFORM_SUBFLOW            = "I_PLATFORM_SUBFLOW";/*网元二级流程清单*/
			public final static String I_PLATFORM_FEATURE            = "I_PLATFORM_FEATURE";/*网元属性清单*/
			public final static String I_PLATFORM_PROTOCOL           = "I_PLATFORM_PROTOCOL";/*网元模板清单*/
			public final static String I_PLATFORM_MAPPING            = "I_PLATFORM_MAPPING";/*网元映射清单*/
			public final static String I_PLATFORM_MISC               = "I_PLATFORM_MISC";/*网元属性扩展清单*/
			public final static String I_PROGRAM                     = "I_PROGRAM";/*框架解决方案*/
			public final static String I_PROGRAM_RESPOND             = "I_PROGRAM_RESPOND";/*框架反馈清单*/
			public final static String I_PROGRAM_RESPOND_BASIC       = "I_PROGRAM_RESPOND_BASIC";/*框架反馈清单*/
			public final static String I_PROGRAM_RESPOND_RELATE      = "I_PROGRAM_RESPOND_RELATE";/*框架反馈归类清单*/
			public final static String I_PROGRAM_PROGRAM             = "I_PROGRAM_PROGRAM";/*框架解决方案*/
			public final static String I_PROGRAM_COMPONENT           = "I_PROGRAM_COMPONENT";/*方案组件清单*/
			public final static String I_PROGRAM_COMPONENT_MAPPING   = "I_PROGRAM_COMPONENT_MAPPING";/*方案属性组件清单*/
			public final static String I_COMPETENCE_BUSINES          = "I_COMPETENCE_BUSINES";/*服务能力接入清单*/
			public final static String I_COMPETENCE_BUSINES_KERNEL   = "I_COMPETENCE_BUSINES_KERNEL";/*服务能力接入扩展清单*/
			public final static String I_COMPETENCE_BUSINES_COMPETE  = "I_COMPETENCE_BUSINES_COMPETE";/*服务能力接入产品扩展清单*/
			public final static String I_COMPETENCE_TEMPLATE         = "I_COMPETENCE_TEMPLATE";/*服务能力模块*/
			public final static String I_COMPETENCE_WORKFLOW         = "I_COMPETENCE_WORKFLOW";/*服务流程清单*/
			public final static String I_COMPETENCE_BPELFLOW         = "I_COMPETENCE_BPELFLOW";/*服务流程任务清单*/
			public final static String I_COMPETENCE_PRODUCT          = "I_COMPETENCE_PRODUCT";/*服务产品单元*/
			public final static String I_COMPETENCE_PRODUCT_BASIC    = "I_COMPETENCE_PRODUCT_BASIC";/*服务产品单元[产品编号]*/
			public final static String I_COMPETENCE_PRODUCT_COMPTEL  = "I_COMPETENCE_PRODUCT_COMPTEL";/*服务产品单元[产品编码]*/
			public final static String I_COMPETENCE_PRODUCT_SUBJECT  = "I_COMPETENCE_PRODUCT_SUBJECT";/*服务产品扩展属性[产品编号]*/
			public final static String I_COMPETENCE_PRODUCT_COMBINE  = "I_COMPETENCE_PRODUCT_COMBINE";/*服务产品单元[产品关联]*/
			public final static String I_COMPETENCE_PRODUCT_GROUP    = "I_COMPETENCE_PRODUCT_GROUP";/*服务产品单元[产品关联组]*/
			public final static String I_COMPETENCE_PRODUCT_KERNEL   = "I_COMPETENCE_PRODUCT_KERNEL";/*服务能力组[服务变量]*/
		}
	}
	/*服务状态*/
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
