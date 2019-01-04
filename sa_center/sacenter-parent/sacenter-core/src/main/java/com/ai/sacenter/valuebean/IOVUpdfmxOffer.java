package com.ai.sacenter.valuebean;

import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.UUID;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ��ͨ�־û���</p>
 * <p>Copyright: Copyright (c) 2017��6��26��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpdfmxOffer implements java.io.Serializable{
	private static final long serialVersionUID = -2594067739289977937L;
	/*���ױ��*/
	private UUID   _id = null;
	/*����*/
	private Object _objective = null;
	/*��ͨ��*/
	private IUpdfmxOfferHome _order = null;
	public IOVUpdfmxOffer() {
		super();
		_id    = UUID.getUUID        ();
		_order = new IUpdfmxOfferHome();
	}
	
	public IOVUpdfmxOffer( IOVUpdfmxOffer fromUpdfmx ){
		super();
		_objective = fromUpdfmx._objective                    ;
		_id        = UUID.getUUID                           ();
		_order     = new IUpdfmxOfferHome( fromUpdfmx._order );
	}
	
	public IOVUpdfmxOffer( Object objective ){
		super();
		_objective = objective             ;
		_id        = UUID.getUUID        ();
		_order     = new IUpdfmxOfferHome();
	}
	
	public IOVUpdfmxOffer( Object objective, History creator ){
		super();
		_objective = objective                      ;
		_id        = UUID.getUUID                 ();
		_order     = new IUpdfmxOfferHome( creator );
	}
	
	public IOVUpdfmxOffer( Object objective, History creator, java.sql.Timestamp create, java.sql.Timestamp complete ){
		super();
		_objective = objective;
		_id        = UUID.getUUID();
		_order = new IUpdfmxOfferHome( creator, create, complete );
	}
	
	/**
	 * @return ���ױ��
	 */
	public UUID getID() {
		return _id;
	}

	/**
	 * @return ����
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return ��ͨ��
	 */
	public IUpdfmxOfferHome getORDER() {
		return _order;
	}

	public static class IUpdfmxOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 6966220669324210912L;
	    /*��ͨ�־û�*/
		private CarbonList _order   = new CarbonList();
		/*��ʱ�־û�*/
		private CarbonList _future  = new CarbonList();
		/*��������*/
		private java.util.HashMap _subflow = new java.util.HashMap();
		/*���ݹ淶*/
		private History  _creator  = null;
		/*����ʱ��*/
		private java.sql.Timestamp  _create   = null;
		/*�鵵ʱ��*/
		private java.sql.Timestamp  _complete = null;
		public IUpdfmxOfferHome(){
			super();
			_creator  = History.CREATE;
			_create   = new java.sql.Timestamp( System.currentTimeMillis() );
			_complete = new java.sql.Timestamp( System.currentTimeMillis() ); 
		}
		
		public IUpdfmxOfferHome( IUpdfmxOfferHome fromUpdfmx ){
			super();
			_creator  = fromUpdfmx._creator;
			_create   = fromUpdfmx._create ;
			_complete = fromUpdfmx._complete;
		}
		
		public IUpdfmxOfferHome( History creator ){
			super();
			_creator  = creator;
			_create   = new java.sql.Timestamp( System.currentTimeMillis() );
			_complete = new java.sql.Timestamp( System.currentTimeMillis() ); 
		}
		
		public IUpdfmxOfferHome( History creator, java.sql.Timestamp create, java.sql.Timestamp complete ){
			super();
			_creator  = creator  ;
			_create   = create   ;
			_complete = complete ; 
		}
		
		/**
		 * ��ͨ�־û�
		 * @return 
		 */
		public CarbonList getORDER() {
			return _order;
		}

		/**
		 * ����ָ���෵�ؿ�ͨ�־û�
		 * @param aCOMPOSITE
		 * @return
		 */
		public Object getORDER( Class aCOMPOSITE ){
		   	return ClassUtils.IClass.arrayDesign( _order, aCOMPOSITE );
		}
		
		/**
		 * @return ��ʱ�־û�
		 */
		public CarbonList getFUTURE() {
			return _future;
		}
		
		/**
		 * ����ָ���෵����ʱ�־û�
		 * @param aCOMPOSITE
		 * @return
		 */
		public Object getFUTURE( Class aCOMPOSITE ){
		   	return ClassUtils.IClass.arrayDesign( _future, aCOMPOSITE );
		}
		
		/**
		 * @return ��������
		 */
		public java.util.HashMap getSUBFLOW() {
			return _subflow;
		}

		/**
		 * ���ݷֱ������ȡ�־û��洢�ṹ[��ͨ����ͬ��]
		 * @param _composite
		 * @return
		 */
		public CarbonList getSUBFLOW( long _composite ){
			java.lang.Long __composite = new java.lang.Long( _composite );
			CarbonList _phantom = (CarbonList)_subflow.get( __composite );
			if( _phantom == null ){
				_subflow.put( __composite, _phantom = new CarbonList() );
			}
			return _phantom;
		}
		
		/**
		 * ���ݷֱ������ȡ�־û��洢�ṹ[��ͨ����ͬ��]
		 * @param _composite
		 * @return
		 */
		public CarbonList getSUBFLOW( String _composite ){
			CarbonList _phantom = (CarbonList)_subflow.get( _composite );
			if( _phantom == null ){
				_subflow.put( _composite, _phantom = new CarbonList() );
			}
			return _phantom;
		}
		
		/**
		 * @return ���ݹ淶
		 */
		public History getCREATOR() {
			return _creator;
		}
		
		/**
		 * @return ����ʱ��
		 */
		public java.sql.Timestamp getCREATE() {
			return _create;
		}

		/**
		 * @param create ����ʱ��
		 */
		public void setCREATE(java.sql.Timestamp create) {
			_create = create;
		}

		/**
		 * @return �鵵ʱ��
		 */
		public java.sql.Timestamp getCOMPLETE() {
			return _complete;
		}

		/**
		 * @param complete �鵵ʱ��
		 */
		public void setCOMPLETE(java.sql.Timestamp complete) {
			_complete = complete;
		}
		
		/**
		 * �Ƿ�Ϊ�������ޱ���ģʽ
		 * @return
		 */
		public boolean isCREATE(){
			return _creator == History.CREATE;
		}
		
		/**
		 * �Ƿ�Ϊ�������ޱ���ģʽ
		 * @return
		 */
		public boolean isUPDATE(){
			return _creator == History.UPDATE;
		}
		
		/**
		 * �Ƿ�Ϊɾ�����ޱ���ģʽ
		 * @return
		 */
		public boolean isDELETE(){
			return _creator == History.DELETE;
		}
		
		/**
		 * �Ƿ�Ϊɾ���򱸷���ʷģʽ
		 * @return
		 */
		public boolean isHISTORY(){
			return _creator == History.HISTORY;
		}
		
		/**
		 * �Ƿ�Ϊɾ���򱸷�ʧ��ģʽ
		 * @return
		 */
		public boolean isFAILURE(){
			return _creator == History.FAILURE;
		}
	}
	
	public static enum History {
		CREATE("�������ޱ���"),UPDATE("�������ޱ���"),DELETE("ɾ�����ޱ���"),HISTORY("ɾ���򱸷���ʷ"),FAILURE("ɾ���򱸷�ʧ��");
		private String _desc;
		private History( String desc){
			_desc = desc;
		}
		
		/**
		 * @return the _desc
		 */
		public String desc() {
			return _desc;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return super.toString() + "{" + super.name() + ", " +  _desc +"}";  
		}

	}
}
