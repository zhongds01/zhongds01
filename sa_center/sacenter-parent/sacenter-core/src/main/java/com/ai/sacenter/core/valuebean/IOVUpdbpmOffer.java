package com.ai.sacenter.core.valuebean;

import com.ai.sacenter.util.ClassUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015-5-6</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdbpmOffer implements java.io.Serializable{
	private static final long serialVersionUID = 958467591444275893L;
	/*���𷽹���*/
	private Object     _objective = null;
	/*���񼤻��*/
	private IUpdbmHome _subflow = new IUpdbmHome();
	public IOVUpdbpmOffer(Object objective) {
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
	 * @return ���񼤻��
	 */
	public IUpdbmHome getSUBFLOW() {
		return _subflow;
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-5-21</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdbmHome implements java.io.Serializable{
		private static final long serialVersionUID = 5587294629293510103L;
		/*���񶩹���*/
		private IOVOfferPentium   _offer      = null;
		/*����������*/
		private java.util.HashMap _subflow    = new java.util.HashMap();
		/*������չ��*/
		private java.util.HashMap _extend    = new java.util.HashMap();
		/*���񼤻�����*/
		private java.util.HashMap _graphics = new java.util.HashMap();
		public IUpdbmHome(){
			super();
		}
		
		/**
		 * @return ���񶩹���
		 */
		public IOVOfferPentium getOFFER() {
			return _offer;
		}

		/**
		 * @param _offer ���񶩹�
		 */
		public void setOffer(IOVOfferPentium offer) {
			_offer = offer;
		}
		
		/**
		 * @param _offer ���񶩹���[���õ�ǰ���񶩹���������������Ժϲ�����ǰ����������]
		 */
		public void mergeAsOffer(IOVOfferPentium offer) {
			_offer = offer;
			IOVOfferPentium.IOfferMBeanHome fromOfferHome = _offer.getORDER();
			ClassUtils.IMerge.merge( fromOfferHome.getOFFER(), _subflow );
		}

		/**
		 * @return ����������
		 */
		public java.util.HashMap getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * @return ������չ��
		 */
		public java.util.HashMap getEXTEND() {
			return _extend;
		}

		/**
		 * @return ���񼤻�����
		 */
		public java.util.HashMap getGraphics() {
			return _graphics;
		}
		
		/**
		 * ���񼤻�����
		 * @param fromINDEX �ڴ���������
		 * @return
		 */
		public java.util.HashMap getGraphics( String fromINDEX ){
			return (java.util.HashMap)_graphics.get( fromINDEX );
		}
		
	}
	
}
