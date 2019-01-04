package com.ai.sacenter.util;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务调度令牌</p>
 * <p>Copyright: Copyright (c) 2015-2-9</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IPeriodGraphToken implements java.io.Serializable{
	private static final long serialVersionUID = -2126808197899293184L;
	/*令牌*/
	private String  token = IToken.NONE;
	/*耗时*/
	private long    timeCoSum = 0;
	/*局部交易缓存*/
	private java.util.Map _deque = new java.util.HashMap();
	/*全局变量缓存*/
	private java.util.Map _graphics = new java.util.HashMap();
	public IPeriodGraphToken(){
		super();
	}
	
	/**
	 * @return 局部交易
	 */
	public java.util.Map getDeque() {
		return _deque;
	}
	
	/**
	 * @return 全局变量
	 */
	public java.util.Map getGraphics() {
		return _graphics;
	}
	
	/**
	 * @return 令牌
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * @param aToken the token to set
	 */
	public void setToken(String aToken) {
		token = aToken;
	}
	
	/**
	 * @return the timeCoSum
	 */
	public long getTimeCoSum() {
		return timeCoSum;
	}
	
	/**
	 * @param aTimeCoSumL the timeCoSum to set
	 */
	public void setTimeCoSum(long aTimeCoSumL) {
		timeCoSum = aTimeCoSumL;
	}
	
	/**
	 * 
	 * @param token
	 */
	public void _wrap( IPeriodGraphToken _token ){
		token     = _token.token            ;
		timeCoSum = _token.timeCoSum        ;
		_deque.putAll( _token._deque )      ;
		_graphics.putAll( _token._graphics );
	}
	
	/**
	 * 是否为初始状态
	 * @return
	 */
	public boolean isTokenNone(){
		return StringUtils.equals( token , IToken.NONE );
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2011-11-3</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IToken{
		/*初始*/
		public final static String NONE = "NONE";
		/*激活*/
		public final static String ACTIVE = "ACTIVE";
		/*运行中*/
		public final static String RUNING = "RUNING";
		/*队列中*/
		public final static String QUEUEING = "QUEUEING";
		/*回滚中*/
		public final static String ROLLBING = "ROLLBING";
		/*在途中*/
		public final static String WAITING = "WAITING";
		/*完成(包含异常)*/
		public final static String FINISH = "FINISH";
	}
}
