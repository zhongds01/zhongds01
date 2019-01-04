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
	/*统一开通DAO类*/
	public static final Class IUpfgkmDAO = com.ai.sacenter.tykt.dao.interfaces.IUpfgkmDAO.class;
	public interface IUpfwmCol{
		/*工单编号*/
		public static final String PS_ID_COL = "PS_ID";
		/*用户号码*/
		public static final String BILL_ID_COL = "BILL_ID";
		/*工单创建时间*/
		public static final String CREATE_DATE_COL = "CREATE_DATE";
		/*用户所在地市*/
		public static final String REGION_ID_COL = "REGION_ID";
		/*开通串*/
		public static final String PS_PARAM_COL = "PS_PARAM";
		/*查询开通串*/
		public static final String TARGET_PARAM_COL = "TARGET_PARAM";
		/*网元开始时间*/
		public static final String START_DATE_COL = "START_DATE";
		/*网元结束时间*/
		public static final String END_DATE_COL = "END_DATE";
		/*反馈时间*/
		public static final String RET_DATE_COL = "RET_DATE";
		/*工单状态*/
		public static final String PS_STATUS_COL = "PS_STATUS";
		/*应答代码*/
		public static final String FAIL_CODE_COL = "FAIL_CODE";
		/*应答描述*/
		public static final String FAIL_REASON_COL = "FAIL_REASON";
		/*异常描述*/
		public static final String FAIL_LOG_COL = "FAIL_LOG";
		/*工单转移时间*/
		public static final String HAND_DATE_COL = "HAND_DATE";
	}
	public interface IUpfwm{
		/*创建(初始化)*/
		public static final int CREATE    = 0;
		/*人工报竣*/
		public static final int COMPLETE  = 6;
		/*正常报竣*/
		public static final int SUCCEED   = 9;
		public static class IChannel{
			/*开通中心发起*/
			public static final int  CENTER  =  8;
		}
		public static class ICustom{
			/*普通停机*/
			public final static String STOP_USER  = "OSS_STOP_USER";
			/*VOTEL停机*/
			public final static String V_STOPUSER = "OSS_V_STOPUSER";
			/*普通单停*/
			public final static String BAOC 	  = "OSS_BAOC";
			/*VOTEL单停*/
			public final static String V_BAOC 	  = "OSS_V_BAOC";
		}
	}
}
