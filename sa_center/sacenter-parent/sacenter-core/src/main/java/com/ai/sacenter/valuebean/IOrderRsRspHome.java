package com.ai.sacenter.valuebean;

import com.ai.sacenter.common.ISystemResultHome;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ���ڷ��񶨵�����</p>
 * <p>Copyright: Copyright (c) 2017��6��19��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOrderRsRspHome implements java.io.Serializable{
	private static final long serialVersionUID = -3897569205779714892L;
	/*��������*/
	private String  _rspCode  ;
	/*����*/
	private String  _rspHome  ;
	/*��������*/
	private String  _rspDesc  ;
	/*��ͨ������ϸ*/
	private java.util.ArrayList _rspResult = null;
	public IOrderRsRspHome(){
		super();
	}
	
	public IOrderRsRspHome( String rspCode, String rspHome, String rspDesc ){
		super();
		_rspCode = rspCode;
		_rspHome = rspHome;
		_rspDesc = rspDesc;
	}
	
	public IOrderRsRspHome( IOrderRsRspHome result ){
		super();
		_rspCode = result._rspCode;
		_rspHome = result._rspHome;
		_rspDesc = result._rspDesc;
		if( result._rspResult != null ){
			for( java.util.Iterator itera = result._rspResult.iterator(); itera.hasNext(); ){
				ISystemResultHome _result = (ISystemResultHome)itera.next();
				if( _result == null ) continue;
				if( _rspResult == null ){ _rspResult = new java.util.ArrayList(); }
				_rspResult.add( new ISystemResultHome( _result ) ); 
			}
		}
	}
	
	/**
	 * @return ��������
	 */
	public String getRspCode() {
		return _rspCode;
	}
	
	/**
	 * @param rspCode ��������
	 */
	public void setRspCode(String rspCode) {
		_rspCode = rspCode;
	}
	
	/**
	 * @return ����
	 */
	public String getRspHome() {
		return _rspHome;
	}

	/**
	 * @param rspHome ����
	 */
	public void setRspHome(String rspHome) {
		_rspHome = rspHome;
	}

	/**
	 * @return ��������
	 */
	public String getRspDesc() {
		return _rspDesc;
	}
	
	/**
	 * @param rspDesc ��������
	 */
	public void setRspDesc(String rspDesc) {
		_rspDesc = rspDesc;
	}
	
	/**
	 * @return ��ͨ������ϸ
	 */
	public java.util.ArrayList getRspResult() {
		return _rspResult;
	}
	
	/**
	 * ��ͨ����ĩ��ϸ
	 * @return
	 */
	public ISystemResultHome getRspTail(){
		ISystemResultHome result = null;
		if( _rspResult != null && _rspResult.size() > 0 ){
			for( int index = _rspResult.size() - 1; index >= 0; index-- ){
				result = (ISystemResultHome)_rspResult.get( index );
				if( result != null ){ break; }
			}
		}
		return result;
	}
	
	/**
	 * ��ͨ���ܷ���(Ψһ��)
	 * @return 
	 */
	public ISystemResultHome getRspBody(){
		ISystemResultHome _respond = null;
		if( _rspResult != null && _rspResult.size() == 1 ){
			ISystemResultHome _result = getRspTail();
			_respond = new ISystemResultHome( _result );
		}
		else if( _rspResult != null && _rspResult.size() > 1 ){
			for( java.util.Iterator itera = _rspResult.iterator(); itera.hasNext(); ){
				ISystemResultHome _result = (ISystemResultHome)itera.next();
				if( _result == null || _result.isRspBlank() ) continue;
				if( _respond == null ){ _respond = new ISystemResultHome( _rspCode, _rspDesc );}
				_respond.mergeAsResult( _result.getRspBody() );
			}
		}
		return _respond;
	}
	
	/**
	 * ��ӿ�ͨ��������
	 * @param result ��ͨ������ϸ
	 */
	public void mergeAsGroup( IOVUpfwmResponse result ){
		if( _rspResult == null ){ _rspResult = new java.util.ArrayList(); }
		_rspResult.add( new ISystemResultHome( result ) );
	}
	
	/**
	 * ��ӿ�ͨ��������
	 * @param result ��ͨ������ϸ
	 */
	public void mergeAsGroup( ISystemResultHome result ){
		if( _rspResult == null ){ _rspResult = new java.util.ArrayList(); }
		_rspResult.add( new ISystemResultHome( result ) );
	}
	
	/**
	 * �ϲ���ͨ��������
	 * @param fromRsRspHome ��ͨ������ϸ
	 */
	public void mergeAsResult( IOVUpfwmResponse result ){
		ISystemResultHome _result = null;
		if( _rspResult == null ){ _rspResult = new java.util.ArrayList(); }
		if( _rspResult.size() <= 0 ){ _result = new ISystemResultHome( _rspCode, _rspDesc ); }
		else{ _result = (ISystemResultHome)_rspResult.get( _rspResult.size() - 1 ); }
		_result.mergeAsResult( result.getRspBody() );
	}

	/**
	 * �ϲ���ͨ��������
	 * @param fromRsRspHome ��ͨ������ϸ
	 */
	public void mergeAsResult( ISystemResultHome result ){
		ISystemResultHome _result = null;
		if( _rspResult == null ){ _rspResult = new java.util.ArrayList(); }
		if( _rspResult.size() <= 0 ){ _result = new ISystemResultHome( _rspCode, _rspDesc ); }
		else{ _result = (ISystemResultHome)_rspResult.get( _rspResult.size() - 1 ); }
		_result.mergeAsResult( result.getRspBody() );
	}
	
}
