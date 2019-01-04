package com.ai.sacenter.common;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 开通反馈明细</p>
 * <p>Copyright: Copyright (c) 2017年6月19日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ISystemResultHome implements java.io.Serializable{
	private static final long serialVersionUID = 138934063800714507L;
	/*反馈代码*/
	private String  _rspCode  ;
	/*反馈描述*/
	private String  _rspDesc  ;
	/*反馈域*/
	private String  _rspHome  ;
	/*反馈报文*/
	private Object  _rspResult;
	/*反馈结果*/
	private java.util.HashMap _result = new java.util.HashMap();
	public ISystemResultHome(){
		super();
	}
	
	public ISystemResultHome( String rspCode, String rspDesc ){
		super();
		_rspCode = rspCode;
		_rspDesc = rspDesc;
		_rspHome = IUpdcConst.IUpfwm.IUpfm.ucmframe;
	}
	
	public ISystemResultHome( String rspCode, String rspHome, String rspDesc ){
		super();
		_rspCode = rspCode;
		_rspHome = rspHome;
		_rspDesc = rspDesc;
	}
	
	public ISystemResultHome( String rspCode, String rspHome, String rspDesc, java.util.Map rspResult ){
		super();
		_rspCode = rspCode;
		_rspHome = rspHome;
		_rspDesc = rspDesc;
		if( rspResult != null ){
			_result.putAll( rspResult );
		}
	}

	public ISystemResultHome(ISystemResultHome result){
		super();
		_rspCode   = result._rspCode  ;
		_rspHome   = result._rspHome  ;
		_rspDesc   = result._rspDesc  ;
		_rspResult = result._rspResult;
		if( result._result != null ){
			_result.putAll( result._result );
		}
	}
	
	public ISystemResultHome( IOVUpfwmResponse result ){
		super();
		_rspCode   = result.getRspCode  ();
		_rspHome   = result.getRspHome  ();
		_rspDesc   = result.getRspDesc  ();
		_rspResult = result.getRspResult();
		if( result.getRspBody() != null ){
			_result.putAll( result.getRspBody() );
		}
	}
	
	/**
	 * @return 原始代码
	 */
	public String getRspCode() {
		return _rspCode;
	}
	
	/**
	 * @param rspCode 原始代码
	 */
	public void setRspCode(String rspCode) {
		_rspCode = rspCode;
		if( rspCode != null ) _result.put( IUpfgkmConst.RETN, rspCode );
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
		if( rspDesc != null ) _result.put( IUpfgkmConst.DESC, rspDesc );
	}
	
	/**
	 * @return 反馈网元
	 */
	public String getRspHome() {
		return _rspHome;
	}
	
	/**
	 * @param rspHome 反馈描述
	 */
	public void setRspHome(String rspHome) {
		_rspDesc = rspHome;
		if( rspHome != null ) _result.put( IUpfgkmConst.HOME, rspHome );
	}
	
	/**
	 * @return 反馈报文
	 */
	public Object getRspResult() {
		return _rspResult;
	}

	/**
	 * @param _rspResult 反馈报文
	 */
	public void setRspResult(Object rspResult) {
		_rspResult = rspResult;
	}

	/**
	 * 开通结果中RESULT节点
	 * @return
	 */
	public java.util.List getAsResult(){
		return (java.util.List)_result.get( IUpfgkmConst.RESULT );
	}
	
	/**
	 * @return 开通反馈明细
	 */
	public java.util.Map getRspBody() {
		return _result;
	}
	
	/**
	 * 
	 * @param _objective
	 */
	private void _mergeAsResult( Object _objective ){
		if( _result.get( IUpfgkmConst.RESULT ) == null ){ 
			_result.put( IUpfgkmConst.RESULT, new java.util.ArrayList() ); 
		}
		((java.util.List)_result.get( IUpfgkmConst.RESULT ) ).add( _objective );
	}
	
	/**
	 * 合并到开通结果中[RESULT节点合并其它参数转存当前开通结果,否则全量合并]
	 * @param result 开通结果
	 */
	public void mergeAsResult( java.util.Map result ){
		if( result != null && result.size() > 0 ){
			for( java.util.Iterator itera = result.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
				if( StringUtils.equals( (String)fromEntry.getKey(), IUpfgkmConst.RETN ) ){
					setRspCode( (String)fromEntry.getValue() );
				}
				else if( StringUtils.equals( (String)fromEntry.getKey(), IUpfgkmConst.DESC ) ){
					setRspDesc( (String)fromEntry.getValue() );
				}
				else if( StringUtils.equals( (String)fromEntry.getKey(), IUpfgkmConst.HOME ) ){
					setRspHome( (String)fromEntry.getValue() );
				}
				else if( StringUtils.equals( (String)fromEntry.getKey(), IUpfgkmConst.RESULT ) ){
					mergeAsGroup( fromEntry.getValue() );
				}
				else if( fromEntry.getValue() != null ){
					_result.put( fromEntry.getKey(), fromEntry.getValue() );
				}
			}
		}
	}
	
	/**
	 * 合并到开通结果RESULT节点中
	 * @param result
	 */
	public void mergeAsGroup( Object result ){
		if( result != null && result instanceof Object[] ){
			Object _array[] = (Object[])result;
			for( int index = 0; _array != null && index < _array.length; index++ ){
				if( _array[index] == null ) continue;
				_mergeAsResult( _array[index] );
			}
		}
		else if( result != null && result instanceof java.util.List ){
			java.util.List _list = (java.util.List)result;
			for( java.util.Iterator itera = _list.iterator(); itera.hasNext(); ){
				Object _objective = itera.next();
				if( _objective == null ) continue;
				_mergeAsResult( _objective );
			}
		}
		else if( result != null ){
			_mergeAsResult( result );
		}
	}
	
	/**
	 * 是否反馈为空
	 * @return
	 */
	public boolean isRspBlank(){
		return _result == null || _result.isEmpty();
	}
	
	private interface IUpfgkmConst{
		/*原始代码*/
		public static final String RETN   = "RETN"    ;
		/*原始描叙*/
		public static final String DESC   = "DESC"    ;
		/*网元编码*/
		public static final String HOME   = "NETWORK" ;
		/*原始结果*/
		public static final String RESULT  = "RESULT" ;
	}
}
