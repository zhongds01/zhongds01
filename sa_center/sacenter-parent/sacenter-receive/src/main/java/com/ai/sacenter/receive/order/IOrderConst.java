package com.ai.sacenter.receive.order;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͨ��������</p>
 * <p>Copyright: Copyright (c) 2016��8��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOrderConst {
	public interface IUser{
		public interface IUserCol{
			/*ͣ�����仯ǰ*/
			public final static String PRE_OS_STATUS = "PRE_OS_STATUS";
			/*ͣ�����仯��*/
			public final static String OS_STATUS     = "OS_STATUS";
		}
	}
	public interface IOffer{
		
	}
	public interface IUpfwm{
		/*��Ԫ����*/
		public final static String PLATFORM   = "PLATFORM";
		/*ָ�����*/
		public final static String DIRECTIVE  = "DIRECTIVE";
	}
}
