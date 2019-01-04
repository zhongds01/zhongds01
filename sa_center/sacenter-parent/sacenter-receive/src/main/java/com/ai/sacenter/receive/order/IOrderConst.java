package com.ai.sacenter.receive.order;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通定单常量</p>
 * <p>Copyright: Copyright (c) 2016年8月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOrderConst {
	public interface IUser{
		public interface IUserCol{
			/*停复机变化前*/
			public final static String PRE_OS_STATUS = "PRE_OS_STATUS";
			/*停复机变化后*/
			public final static String OS_STATUS     = "OS_STATUS";
		}
	}
	public interface IOffer{
		
	}
	public interface IUpfwm{
		/*网元编码*/
		public final static String PLATFORM   = "PLATFORM";
		/*指令编码*/
		public final static String DIRECTIVE  = "DIRECTIVE";
	}
}
