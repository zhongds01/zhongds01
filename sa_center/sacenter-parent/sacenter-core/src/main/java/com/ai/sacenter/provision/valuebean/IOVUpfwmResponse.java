package com.ai.sacenter.provision.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ�ⷴ����</p>
 * <p>Copyright: Copyright (c) 2015��10��26��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfwmResponse implements java.io.Serializable{
	private static final long serialVersionUID = -8322501744490421449L;
	/*���𷽹���*/
	private Object  _objective = null;
	/*�Ƿ�ɹ�*/
	private Boolean _failure = null;
	/*��������*/
	private String  _rspCode;
	/*��������*/
	private String  _rspDesc;
	/*ԭʼ������Ԫ*/
	private String  _rspHome;
	/*ԭʼ����*/
	private Object  _rspResult;
	/*�˻�����*/
	private String  _rspBottom;
	/*����������*/
	private java.util.Map  _rspBody;
	/*��Ԫ��Ӧ��*/
	private IUpfwmOfferHome _order = new IUpfwmOfferHome();
	public IOVUpfwmResponse( Object objective ) {
		super();
		_objective = objective;
	}

	/**
	 * @return ���𷽹���
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return �Ƿ�ɹ�
	 */
	public Boolean getFAILURE() {
		return _failure;
	}
	
	/**
	 * @param fAILURE �Ƿ�ɹ�
	 */
	public void setFAILURE(Boolean fAILURE) {
		_failure = fAILURE;
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
	 * @return ������Ԫ
	 */
	public String getRspHome() {
		return _rspHome;
	}
	
	/**
	 * @param rspHome ������Ԫ
	 */
	public void setRspHome(String rspHome) {
		_rspHome = rspHome;
	}
	
	/**
	 * @return ԭʼ����
	 */
	public Object getRspResult() {
		return _rspResult;
	}
	
	/**
	 * @param original ԭʼ����
	 */
	public void setRspResult(Object RspResult) {
		_rspResult = RspResult;
	}
	
	/**
	 * @return ��Χ�˻�����
	 */
	public String getRspBottom() {
		return _rspBottom;
	}
	
	/**
	 * @param rspBottom ��Χ�˻�����
	 */
	public void setRspBottom(String rspBottom) {
		_rspBottom = rspBottom;
	}
	
	/**
	 * @return ����������
	 */
	public java.util.Map getRspBody() {
		return _rspBody;
	}
	
	/**
	 * @param rspBody ����������
	 */
	public void setRspBody(java.util.Map rspBody) {
		_rspBody = rspBody;
	}
	
	/**
	 * �Ƿ����ɹ�
	 * @return
	 */
	public boolean isSUCCEED(){
		return  _failure == null || ( _failure != null && _failure.equals( Boolean.FALSE ));
	}
	
	/**
	 * �Ƿ���ʧ��
	 * @return
	 */
	public boolean isFAILURE(){
		return _failure != null && _failure.equals( Boolean.TRUE );
	}
	
	/**
	 * �Ƿ�������ΪNULL
	 * @return
	 */
	public boolean isRsRspNull(){
		return StringUtils.isBlank( _rspCode ) ;
	}
	
	/**
	 * ��XML���ݷ�ʽ���� 
	 * @return
	 */
	public String getAsXml(){
		String _xml = null;
		java.util.HashMap fromXML = new java.util.HashMap();
		try
		{
			fromXML.put( IUpdcConst.IUpfwm.PLWK_FAILURE, 
					_failure != null?_failure.toString():
						Boolean.FALSE.toString                 ()   );
			fromXML.put( IUpdcConst.IUpfwm.PLWK_CODING  , _rspCode  );
			fromXML.put( IUpdcConst.IUpfwm.PLWK_ORIGING , _rspHome  );
			fromXML.put( IUpdcConst.IUpfwm.PLWK_DESCRIBE, _rspDesc  );
			_xml = XmlUtils.createNoformatXml( "InterBOSS", fromXML );
		}
		finally{
			if( fromXML != null ){ fromXML.clear(); fromXML = null; }
		}
		return _xml;
	}
	
	/**
	 * @return ������
	 */
	public IUpfwmOfferHome getORDER() {
		return _order;
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015��10��27��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfwmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -2328547117659485257L;
		/*������Ϣ*/
		private java.util.Map _subflow = new java.util.HashMap();
		public IUpfwmOfferHome(){
			super();
		}
		
		/**
		 * @return ������Ϣ
		 */
		public java.util.Map getSUBFLOW() {
			return _subflow;
		}
	}
}
