package com.ai.sacenter.util;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ��Ԫ�仯�켣</p>
 * <p>Copyright: Copyright (c) 2016��8��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class WeakLateTrail implements java.io.Serializable{
	private static final long serialVersionUID = -1286002688750173476L;
	/*����*/
	private WeakTrail _CREATE = null;
	/*�˶�*/
	private WeakTrail _CANCEL = null;
	/*�仯*/
	private WeakTrail _CHANGE = null;
	/*����*/
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
	 * <p>Copyright: Copyright (c) 2017��2��3��</p>
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
