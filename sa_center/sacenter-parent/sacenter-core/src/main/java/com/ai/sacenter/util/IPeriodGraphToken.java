package com.ai.sacenter.util;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: �����������</p>
 * <p>Copyright: Copyright (c) 2015-2-9</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IPeriodGraphToken implements java.io.Serializable{
	private static final long serialVersionUID = -2126808197899293184L;
	/*����*/
	private String  token = IToken.NONE;
	/*��ʱ*/
	private long    timeCoSum = 0;
	/*�ֲ����׻���*/
	private java.util.Map _deque = new java.util.HashMap();
	/*ȫ�ֱ�������*/
	private java.util.Map _graphics = new java.util.HashMap();
	public IPeriodGraphToken(){
		super();
	}
	
	/**
	 * @return �ֲ�����
	 */
	public java.util.Map getDeque() {
		return _deque;
	}
	
	/**
	 * @return ȫ�ֱ���
	 */
	public java.util.Map getGraphics() {
		return _graphics;
	}
	
	/**
	 * @return ����
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
	 * �Ƿ�Ϊ��ʼ״̬
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
		/*��ʼ*/
		public final static String NONE = "NONE";
		/*����*/
		public final static String ACTIVE = "ACTIVE";
		/*������*/
		public final static String RUNING = "RUNING";
		/*������*/
		public final static String QUEUEING = "QUEUEING";
		/*�ع���*/
		public final static String ROLLBING = "ROLLBING";
		/*��;��*/
		public final static String WAITING = "WAITING";
		/*���(�����쳣)*/
		public final static String FINISH = "FINISH";
	}
}
