package com.ai.sacenter.receive;

public class IUpdbfsConst {
	public interface IUpdbm{
		/*开通定单DAO*/
		public Class<?> IOrderDAO   = com.ai.sacenter.receive.order.dao.interfaces.IOrderDAO.class;
		/*开通修复DAO*/
		public Class<?> IUrgencyDAO = com.ai.sacenter.receive.order.dao.interfaces.IUrgencyDAO.class;
		/*开通到期DAO*/
		public Class<?> IExpireDAO  = com.ai.sacenter.receive.expire.dao.interfaces.IExpireDAO.class;
		public interface ICache{
			/*开通定单模型*/
			public final static String PROGRAM_RECEIVE    = "PROGRAM_RECEIVE";
			/*到期工单模型*/
			public final static String PROGRAM_EXPIRE     = "PROGRAM_EXPIRE";
			/*服务依赖模型*/
			public final static String PROGRAM_DEPEND     = "PROGRAM_DEPEND";
			/*同组服务模型*/
			public final static String PROGRAM_GROUP      = "PROGRAM_GROUP";
			/*用户以及其订购清单*/
			public final static String PROGRAM_CUSTOM     = "PROGRAM_CUSTOM";
			/*开通定单产品模型*/
			public final static String PROGRAM_PRODUCTION = "PROGRAM_PRODUCTION";
			/*全局模型*/
			public final static String PROGRAM_GLOBAL     = "PROGRAM_GLOBAL";
			/*订单模型*/
			public final static String PROGRAM_ORDER      = "PROGRAM_ORDER";
			/*用户模型*/
			public final static String PROGRAM_USER       = "PROGRAM_USER";
			/*基本套餐组*/
			public final static String PROGRAM_OFFER      = "PROGRAM_OFFER";
			/*开通定单分解*/
			public final static String PROGRAM_COMPOSE    = "PROGRAM_COMPOSE";
			/*开通修复单发起*/
			public final static String PROGRAM_URGENCY    = "PROGRAM_URGENCY";
			/*开通定单发起*/
			public final static String PROGRAM_PLATFORM   = "PROGRAM_PLATFORM";
			/*开通定单归档*/
			public final static String PROGRAM_COMPLETE   = "PROGRAM_COMPLETE";
			/*停复机位模型*/
			public final static String PROGRAM_OSSTATUS   = "PROGRAM_OSSTATUS";
		}
		public interface ICustom{
			/*默认优先级*/
			public static final int    PRIORITY   = 10;
			/*默认渠道类型*/
			public static final String CHANNEL    = "8";
			 /*默认发起方*/
		    public static final String ORIGINATOR = "9";
			/*默认工号*/
		    public static final String STAFF      = "999999";
		    /*系统岗位*/
			public static final String ORGANIZE   = "999999";
			/*默认用户号码*/
			public static final String BILL_ID    = "13999999999";
		}
		public interface ICatalog{
			/*非法开通报文规格*/
			public final static String RECEIVE   = "999990010100";
			/*默认产品规格*/
			public static final String CATALOG   = "999990010199";
		}
		public interface IBusines{
			/*下周期批开操作*/
			public final static String EXPIRE    = "999900020101";
			/*非法开通报文操作*/
			public final static String RECEIVE   = "999990010200";
			/*默认操作编码*/
			public static final String BUSINES  = "999990010900";
		}
		public interface IBatches{
			/*批量业务*/
			public static final String YES  = "1";
			/*单个业务*/
			public static final String NO   = "0";
		}
		public interface IRole{
			/*成员角色*/
			public final static String MEMBER    = "0";
			/*群组角色*/
			public final static String GROUP     = "1";
			/*普通角色*/
			public final static String NORMAL    = "2";
		}
		public interface IProdType{
			/*普通角色*/
			public final static String NORMAL    = "0";
			/*成员角色*/
			public final static String MEMBER    = "1";
			/*群组角色*/
			public final static String GROUP     = "2";
		}
		public interface IUser{
			/*开通定单[订单模型]*/
			public final static String ORDER       = "ORDER";
			/*开通定单[订购模型]*/
			public final static String INSTANCE    = "INSTANCE";
			/*下周期标志*/
			public static final String CYCLE       = "CYCLE";
			/*月中工单*/
			public static final String MIDDLE      = "MIDDLE";
			/*受理时间[开通定单]*/
			public final static String OPRTIME     = "OPRTIME";
			/*受理来源[开通定单]*/
			public final static String OPRSRC	   = "OPRSRC";
			/*产品规格*/
			public static final String VMICMPID    = "VMICMPID";
			/*业务编码*/
			public static final String VMICMBSI    = "VMICMBSI";
			/*基本策划编码*/
			public static final String VMICPIID    = "VMICPIID";
			/*支付方式*/
			public static final String VMICPTID    = "VMICPTID";
			/*县市编码*/
			public static final String VMILOCTY    = "VMILOCTY";
			/*用户品牌*/
			public static final String VMICMTDK    = "VMICMTDK";
			/*用户老品牌*/
			public static final String VMICOTDK    = "VMICOTDK";
			/*用户状态*/
			public static final String VMICMOSI    = "VMICMOSI";
			/*最终用户停机状态[用户停复机]*/
			public static final String VMICMOSS    = "VMICMOSS";
			/*用户最终停机位[用户停复机]*/
			public static final String VMICMOTS    = "VMICMOTS";
			/*用户停开机位数类型[用户停复机]*/
			public static final String VMICMOST    = "VMICMOST";
			/*用户停开机位变化值[用户停复机]*/
			public static final String VMICMOTB    = "VMICMOTB";
			/*停机[用户停复机]*/
			public final static String STOPUSER    = "STOPUSER";
			/*单停[用户停复机]*/
			public final static String BAOCUSER    = "BAOCUSER";
			/*到期用户*/
			public final static String EXPIREUSER  = "EXPIREUSER";
			/*用户新IMSI[用户换卡]*/
	    	public final static String NEWIMSI     = "NEWIMSI";
	    	/*新用户号码[用户换卡]*/
	    	public final static String NEWMSDN     = "NEWMSDN";
	    	/*集团编号*/
			public static final String GROUP_ID    = "GROUP_ID";
			/*集团类型*/
			public static final String GROUP_TYPE  = "GROUP_TYPE";
			public interface IOsState{
				/*正常*/
				public final static String NORMAL  = "0";
				/*管理停机*/
				public final static String MGRSTP  = "1";
				/*营业停机*/
				public final static String ISOSTP  = "2";
				/*帐务停机*/
				public final static String AMSSTP  = "3";
				/*营业挂失*/
				public final static String LOSTSTP = "4";
				/*营业解挂*/
				public final static String FINDSTP = "5";
			}
		}
		public interface IOriginate{
			/*开通定单发起*/
			public final static String PROGRAM_RECEIVE  = "RECEIVE";
			/*开通到期发起*/
			public final static String PROGRAM_EXPIRE   = "EXPIRE";
			/*开通归档发起*/
			public final static String PROGRAM_COMPLETE = "COMPLETE";
			/*开通修复发起*/
			public final static String PROGRAM_URGENCY  = "URGENCY";
			/*开通其他发起*/
			public final static String PROGRAM_OTHER    = "OTHER";
		}
		public interface IProduct{
			/*同组套餐模型*/
			public final static String PROGRAM_GROUP_PLAN     = "PROGRAM_GROUP_PLAN";
			/*商务虚拟网模型*/
			public final static String PROGRAM_PVPMN_COMPETE  = "PROGRAM_PVPMN_COMPETE";
			/*同组服务模型*/
			public final static String PROGRAM_GROUP_COMPETE  = "PROGRAM_GROUP_COMPETE";
			/*同组产品模型*/
			public final static String PROGRAM_GROUP_PRICE    = "PROGRAM_GROUP_PRICE";
			/*成员依赖[主要针对成员依赖群组依赖]*/
			public final static String PROGRAM_DEPEND_MEMBER  = "PROGRAM_DEPEND_MEMBER";
			/*服务依赖组(主要针对指令功能依赖)*/
			public final static String PROGRAM_DEPEND_GROUP   = "PROGRAM_DEPEND_GROUP";
			/*服务属性依赖(主要针对服务属性依赖)*/
			public final static String PROGRAM_DEPEND_FUTURE  = "PROGRAM_DEPEND_FUTURE";
			/*单服务依赖(主要针对指令功能依赖)*/
			public final static String PROGRAM_DEPEND_COMPETE = "PROGRAM_DEPEND_COMPETE";
			/*到期产品组(归属到期系统)*/
			public final static String PROGRAM_EXPIRE_GROUP   = "PROGRAM_EXPIRE_GROUP";
		}
	}
	
	public interface IEnum{
		public interface IYesNo{
    		public static final String Yes = "Y";
    		public static final String No  = "N";
    	}
		public interface IEffective{
			/*全部,包括已失效,下周期和本周期*/          
			public static final int VALID_TYPE_HIS      = 0;
			/*立即生效*/
			public static final int VALID_TYPE_NOW      = 1;
			/*未生效*/                                  
			public static final int VALID_TYPE_NEXT     = 2;
			/*次日生效*/
			public static final int VALID_TYPE_NEXT_DAY = 3;
			/*已失效*/
			public static final int VALID_TYPE_EXPIRED  = 4;
			/*所有。含本周期、下周期生效*/              
			public static final int VALID_TYPE_ALL      = -1;
		}
	}
	public interface IState{
		public final static String C   = "C";
		public final static String E   = "E";
		public final static String EC  = "EC";
		public final static String CE  = "CE";
		public final static String D   = "D";
		public final static String T   = "T";// 暂停
		public final static String F   = "F";// 恢复
		public final static String U   = "U";
		public final static String X   = "X";
		public final static String H   = "H";
		public interface IOrder{
			public final static String S01 = "1";
			public final static String S02 = "2";
			public final static String S03 = "3";
			public final static String S04 = "4";
			public final static String S05 = "5";// 暂停
			public final static String S06 = "6";// 恢复
		}
	}
}
