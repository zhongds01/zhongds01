package com.ai.sacenter.receive.custom;

public class ICustomConst {
	public interface ICustType{
		/*客户类型：个人客户*/
		public static final String INDIVIDUAL = "1";
		/*客户类型：家庭客户*/
		public static final String FAMILY = "2";
		/*客户类型：集团客户*/
		public static final String GROUP = "3";
        /*客户类型：VPMN客户*/
		public static final String VPMN = "4";
		/*个人大客户*/
		public static final int INDIV_VIP = 11;
	}
	public interface ICustom{
		/*用户编号*/
		public static final String USER_ID   = "USER_ID";
		/*客户编号*/
		public static final String CUSTOM_ID = "CUSTOM_ID";
		/*策划编号*/
		public static final String OFFER_ID  = "OFFER_ID";
	}
	public interface IOffer{
		/*是否主策划[主策划]*/
		public static final int IS_MAIN_OFFER  = 1;
		/*策划是否主策划[非主策划]*/
		public static final int NOT_MAIN_OFFER = 0;
		/*是否主用户[主用户]*/
		public static final int IS_GRP_MAIN_USER  = 1;
		/*是否主用户[非主用户]*/
		public static final int NOT_GRP_MAIN_USER = 0;
	}
}
