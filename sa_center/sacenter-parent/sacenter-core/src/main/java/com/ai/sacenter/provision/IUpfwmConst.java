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
		/*网元工单DAO*/
		public static final Class IUpfwmDAO  = com.ai.sacenter.provision.dao.interfaces.IUpfwmDAO.class;
		/*网元批次DAO*/
		public static final Class IUpfpmDAO  = com.ai.sacenter.provision.dao.interfaces.IUpfpmDAO.class;
		/*到期单DAO*/
		public static final Class IUpffmxDAO = com.ai.sacenter.provision.dao.interfaces.IUpffmxDAO.class;
		/*异步访问DAO*/
		public static final Class IUpdfmxDAO = com.ai.sacenter.provision.dao.interfaces.IUpdfmxDAO.class;
		public interface IUpdmon{
			/*初始(根据网元指令成功标志)*/
			public static final int CREATE  = 0;
			/*失败(与网元指令执行是否成功都反馈成功)*/
			public static final int FAILURE = 1;
		}
		public interface IUpdrbm{
			/*默认(真实反馈网元指令情况)*/
			public static final int CREATE   = 0;
			/*可忽略失败(如网元指令异常则作为成功处理)*/
			public static final int IGNORE   = 1;
			/*失败不回退(如网元指令异常则作为失败处理)*/
			public static final int FAILURE  = 2;
			/*失败回退(如网元指令异常则作为回退处理)*/
			public static final int ROLLBACK = 3;
		}
		public interface IUpdrdo{
			/*可忽略*/
			public static final int CREATE = 0;
			/*转重做*/
			public static final int RETRY  = 1;
		}
		public interface IUpffs{
			/*正常*/
			public final static String NORMAL     = "00";
			/*单停*/
			public final static String BAOCUSER   = "01";
			/*停机*/
			public final static String STOPUSER   = "02";
			/*预销户*/
			public final static String PRECEASE   = "03";
			/*销户*/
			public final static String RECYCLE    = "04";
			/*过户*/
			public final static String TRSFUSR    = "05";
			/*改号*/
			public final static String MODIMSN    = "06";
			/*未知*/
			public final static String UNKNOWN    = "99";
		}
	}
	public interface IUpdos{
		/*创建初始*/
		public static final int CREATE    = 0;
		/*网元异常*/
		public static final int FAILURE   = 1;
		/*内部异常*/
		public static final int EXCEPTION = 2;
		/*下发异步网元成功*/
		public static final int ISSUED    = 5;
		/*人工报竣*/
		public static final int HUMAN     = 6;
		/*正常报竣*/
		public static final int SUCCEED   = 9;
		/*已撤销*/
		public static final int CANCEL    = 10;
		/*暂停*/
		public static final int SUSPEND   = 11;
		/*恢复*/
		public static final int RESUME    = 0;
		/*运行*/
		public static final int RUNNING   = 20;
		/*转重做*/
		public static final int RETRY     = 21;
	}
	public interface IUpdfs{
		/*订购*/
		public final static String C = "C";
		/*依赖*/
		public final static String D = "D";
		/*变更*/
		public final static String X = "X";
		/*退订*/
		public final static String E = "E";
		/*恢复*/
		public final static String F = "F";
		/*暂停*/
		public final static String T = "T";
		/*保持*/
		public final static String U = "U";
	}
}
