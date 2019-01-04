package com.ai.sacenter.util;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 单元变化轨迹</p>
 * <p>Copyright: Copyright (c) 2016年8月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class WeakLateTrail implements java.io.Serializable{
	private static final long serialVersionUID = -1286002688750173476L;
	/*订购*/
	private WeakTrail _CREATE = null;
	/*退订*/
	private WeakTrail _CANCEL = null;
	/*变化*/
	private WeakTrail _CHANGE = null;
	/*其他*/
	private WeakTrail _OTHER = null;
	public WeakLateTrail() {
		super();
	}
	
	/**
	 * @return the _CREATE
	 */
	public WeakTrail getCREATE() {
		return _CREATE;
	}
	
	/**
	 * @param _CREATE
	 */
	public void setCREATE(WeakTrail _cREATE) {
		_CREATE = _cREATE;
	}
	
	/**
	 * @return the _CANCEL
	 */
	public WeakTrail getCANCEL() {
		return _CANCEL;
	}
	
	/**
	 * @param _CANCEL
	 */
	public void setCANCEL(WeakTrail _cANCEL) {
		_CANCEL = _cANCEL;
	}
	
	/**
	 * @return the _CHANGE
	 */
	public WeakTrail getCHANGE() {
		return _CHANGE;
	}

	/**
	 * @param _CHANGE the _CHANGE to set
	 */
	public void setCHANGE(WeakTrail cHANGE) {
		_CHANGE = cHANGE;
	}

	/**
	 * @return the _OTHER
	 */
	public WeakTrail getOTHER() {
		return _OTHER;
	}
	
	/**
	 * @param _OTHER
	 */
	public void setOTHER(WeakTrail _oTHER) {
		_OTHER = _oTHER;
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年2月3日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class WeakTrail implements java.io.Serializable{
		private static final long serialVersionUID = -5230026246745506618L;
		public WeakTrail(){
			super();
		}
	}
}
