package com.ai.sacenter.common;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ��ͨ������ϸ</p>
 * <p>Copyright: Copyright (c) 2017��6��19��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ISystemResultHome implements java.io.Serializable{
	private static final long serialVersionUID = 138934063800714507L;
	/*��������*/
	private String  _rspCode  ;
	/*��������*/
	private String  _rspDesc  ;
	/*������*/
	private String  _rspHome  ;
	/*��������*/
	private Object  _rspResult;
	/*�������*/
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
	 * @return ԭʼ����
	 */
	public String getRspCode() {
		return _rspCode;
	}
	
	/**
	 * @param rspCode ԭʼ����
	 */
	public void setRspCode(String rspCode) {
		_rspCode = rspCode;
		if( rspCode != null ) _result.put( IUpfgkmConst.RETN, rspCode );
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
		if( rspDesc != null ) _result.put( IUpfgkmConst.DESC, rspDesc );
	}
	
	/**
	 * @return ������Ԫ
	 */
	public String getRspHome() {
		return _rspHome;
	}
	
	/**
	 * @param rspHome ��������
	 */
	public void setRspHome(String rspHome) {
		_rspDesc = rspHome;
		if( rspHome != null ) _result.put( IUpfgkmConst.HOME, rspHome );
	}
	
	/**
	 * @return ��������
	 */
	public Object getRspResult() {
		return _rspResult;
	}

	/**
	 * @param _rspResult ��������
	 */
	public void setRspResult(Object rspResult) {
		_rspResult = rspResult;
	}

	/**
	 * ��ͨ�����RESULT�ڵ�
	 * @return
	 */
	public java.util.List getAsResult(){
		return (java.util.List)_result.get( IUpfgkmConst.RESULT );
	}
	
	/**
	 * @return ��ͨ������ϸ
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
	 * �ϲ�����ͨ�����[RESULT�ڵ�ϲ���������ת�浱ǰ��ͨ���,����ȫ���ϲ�]
	 * @param result ��ͨ���
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
	 * �ϲ�����ͨ���RESULT�ڵ���
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
	 * �Ƿ���Ϊ��
	 * @return
	 */
	public boolean isRspBlank(){
		return _result == null || _result.isEmpty();
	}
	
	private interface IUpfgkmConst{
		/*ԭʼ����*/
		public static final String RETN   = "RETN"    ;
		/*ԭʼ����*/
		public static final String DESC   = "DESC"    ;
		/*��Ԫ����*/
		public static final String HOME   = "NETWORK" ;
		/*ԭʼ���*/
		public static final String RESULT  = "RESULT" ;
	}
}
