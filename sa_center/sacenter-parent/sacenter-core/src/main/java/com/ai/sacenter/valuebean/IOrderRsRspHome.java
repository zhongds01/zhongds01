package com.ai.sacenter.valuebean;

import com.ai.sacenter.common.ISystemResultHome;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 基于服务定单反馈</p>
 * <p>Copyright: Copyright (c) 2017年6月19日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOrderRsRspHome implements java.io.Serializable{
	private static final long serialVersionUID = -3897569205779714892L;
	/*反馈代码*/
	private String  _rspCode  ;
	/*发起方*/
	private String  _rspHome  ;
	/*反馈描述*/
	private String  _rspDesc  ;
	/*开通反馈明细*/
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
	 * @return 反馈代码
	 */
	public String getRspCode() {
		return _rspCode;
	}
	
	/**
	 * @param rspCode 反馈代码
	 */
	public void setRspCode(String rspCode) {
		_rspCode = rspCode;
	}
	
	/**
	 * @return 发起方
	 */
	public String getRspHome() {
		return _rspHome;
	}

	/**
	 * @param rspHome 发起方
	 */
	public void setRspHome(String rspHome) {
		_rspHome = rspHome;
	}

	/**
	 * @return 反馈描述
	 */
	public String getRspDesc() {
		return _rspDesc;
	}
	
	/**
	 * @param rspDesc 反馈描述
	 */
	public void setRspDesc(String rspDesc) {
		_rspDesc = rspDesc;
	}
	
	/**
	 * @return 开通反馈明细
	 */
	public java.util.ArrayList getRspResult() {
		return _rspResult;
	}
	
	/**
	 * 开通反馈末明细
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
	 * 开通汇总反馈(唯一性)
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
	 * 添加开通反馈报文
	 * @param result 开通反馈明细
	 */
	public void mergeAsGroup( IOVUpfwmResponse result ){
		if( _rspResult == null ){ _rspResult = new java.util.ArrayList(); }
		_rspResult.add( new ISystemResultHome( result ) );
	}
	
	/**
	 * 添加开通反馈报文
	 * @param result 开通反馈明细
	 */
	public void mergeAsGroup( ISystemResultHome result ){
		if( _rspResult == null ){ _rspResult = new java.util.ArrayList(); }
		_rspResult.add( new ISystemResultHome( result ) );
	}
	
	/**
	 * 合并开通反馈报文
	 * @param fromRsRspHome 开通反馈明细
	 */
	public void mergeAsResult( IOVUpfwmResponse result ){
		ISystemResultHome _result = null;
		if( _rspResult == null ){ _rspResult = new java.util.ArrayList(); }
		if( _rspResult.size() <= 0 ){ _result = new ISystemResultHome( _rspCode, _rspDesc ); }
		else{ _result = (ISystemResultHome)_rspResult.get( _rspResult.size() - 1 ); }
		_result.mergeAsResult( result.getRspBody() );
	}

	/**
	 * 合并开通反馈报文
	 * @param fromRsRspHome 开通反馈明细
	 */
	public void mergeAsResult( ISystemResultHome result ){
		ISystemResultHome _result = null;
		if( _rspResult == null ){ _rspResult = new java.util.ArrayList(); }
		if( _rspResult.size() <= 0 ){ _result = new ISystemResultHome( _rspCode, _rspDesc ); }
		else{ _result = (ISystemResultHome)_rspResult.get( _rspResult.size() - 1 ); }
		_result.mergeAsResult( result.getRspBody() );
	}
	
}
