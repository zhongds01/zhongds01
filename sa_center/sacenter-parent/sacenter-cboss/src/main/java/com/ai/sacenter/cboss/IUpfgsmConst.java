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
	/*CenterBossDAO类*/
	public static final Class<?> IUpfgsmDAO = com.ai.sacenter.cboss.dao.interfaces.IUpfgsmDAO.class;;
	public interface IUpfwmCol{
		/*工单编号*/
		public static final String SO_NBR         = "SO_NBR"        ;
		/*定单编号*/
		public static final String ORDER_ID       = "ORDER_ID"      ;
		/*订购编号*/
		public static final String OFFER_ID       = "OFFER_ID"      ;
		/*任务编号*/
		public static final String TASK_ID        = "TASK_ID"       ;
		/*工单类型*/
		public static final String CATEGORY       = "CATEGORY"      ;
		/*用户编号*/			              		        
		public static final String USER_ID        = "USER_ID"       ;
		/*用户号码*/			              		        
		public static final String BILL_ID        = "BILL_ID"       ;
		/*次计费号*/
		public static final String SUB_BILL_ID    = "SUB_BILL_ID"   ;
		/*创建时间*/
		public static final String CREATE_DATE    = "CREATE_DATE"   ;
		/*地市编号*/
		public static final String REGION_ID      = "REGION_ID"     ;
		/*停机状态*/
		public static final String USER_STS       = "USER_STS"      ;
		/*停机类型*/
		public static final String STOP_TYPE      = "STOP_TYPE"     ;
		/*工单状态*/
		public static final String ORDER_STS      = "STS"           ;
		/*索引编号*/
		public static final String SUB_PLAN_NO    = "SUB_PLAN_NO"   ;
		/*预约时间*/
		public static final String ORDER_DATE     = "ORDER_DATE"    ;
		/*扩展属性编号*/			      		        
		public static final String PROPERTY_ID    = "PROPERTY_ID"   ;
		/*扩展属性序号*/			      		        
		public static final String PROPERTY_SEQ   = "SEQ"           ;
		/*扩展属性值*/
		public static final String PROPERTY_VALUE = "PROPERTY_VALUE";
		/*地市编码*/						        
		public static final String REGION_CODE    = "REGION_CODE"   ;
		/*反馈代码*/				      
		public static final String RESULT         = "RESULT"        ;
		/*反馈描述*/						        
		public static final String RESULT_DESC    = "RESULT_DESC"   ;
		/*完成日期*/
		public static final String COMPLETE_DATE  = "PROCESS_DATE"  ;
	}
	public interface IUpfrsp{
		/*成功编码*/
		public static final String SUCCEED = "0000";
	}
	public interface ICustom{
		/*受理来源*/
		public static final String VGPCMSRC = "VGCPMSRC";
		/*批量编号*/
		public static final String VGPCMSGT = "VGPCMSGT";
		/*单条编号*/
		public static final String VGPCNUMB = "VGPCNUMB";
	}
	public interface IState{
		/*初始状态*/
		public static final int  CREATE = 1;
	}
	public interface IOriginate{
		/*用户主动发起*/
		public static final int USER    = 0;
		/*用户被动发起*/
		public static final int OSSTATE = 1;
	}
	public interface ISubscribe{
		/*用户状态*/
		public static final String STATUS = "STATUS";
		/*订购关系*/
		public static final String ORDER  = "ORDER" ;
	}
	public interface ICallBack{
		/*不需要回执*/
		public static final int NO    = 0;
		/*需要回执*/
		public static final int YES   = 1;
	}
	public interface IChannel{
		/*CBOSS发起*/
		public static final String CBOSS = "99";
		public interface ISource{
			/*查询CBOSS受理来源(0-BOSS,1-平台)BOSS发起*/
			public static final int  BOSS     = 0;
			/*查询CBOSS受理来源(0-BOSS,1-平台)平台发起*/
			public static final int  PLATFORM = 1;
		}
	}
}
