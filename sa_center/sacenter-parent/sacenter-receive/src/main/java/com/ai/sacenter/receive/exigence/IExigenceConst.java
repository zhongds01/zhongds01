package com.ai.sacenter.receive.exigence;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年4月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IExigenceConst {
	public interface IUpdbm{
		/*异步定单[开通中心]DAO*/
		public static final Class IRocketDAO = com.ai.sacenter.receive.exigence.dao.interfaces.IRocketDAO.class;
		/*异步定单[远端中心]DAO*/
		public static final Class IRemoteDAO = com.ai.sacenter.receive.exigence.dao.remote.interfaces.IRemoteDAO.class;
		public interface IUpdbf{
			/*开通订单项*/
			public static final String EXIGENCE     = "EXIGENCE";
			/*用户编号[开通定单]*/
			public static final String USER_ID      = "CMXUSERID";
			/*用户号码[开通定单]*/
			public static final String BILL_ID      = "CMXBILLID";
			/*发起方编码[开通定单]*/
			public static final String ORIGINATOR   = "CMXORIGOR";
		}
		public interface IUpdbc{
			/*行政区域路由*/
			public static final String DISTRICT_ID   = "DISTRICT_ID";
		}
		public interface IEnum{
			/*开通默认发起方编码*/
			public static final String PROGRAM_ORIGINATOR = "1";
		}
	}
}
