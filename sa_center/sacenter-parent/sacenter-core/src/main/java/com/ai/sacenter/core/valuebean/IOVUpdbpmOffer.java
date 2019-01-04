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
	/*发起方工单*/
	private Object     _objective = null;
	/*服务激活构件*/
	private IUpdbmHome _subflow = new IUpdbmHome();
	public IOVUpdbpmOffer(Object objective) {
		super();
		_objective = objective;
	}
	
	/**
	 * @return 发起方工单
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return 服务激活构件
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
		/*服务订购集*/
		private IOVOfferPentium   _offer      = null;
		/*服务能力集*/
		private java.util.HashMap _subflow    = new java.util.HashMap();
		/*服务扩展集*/
		private java.util.HashMap _extend    = new java.util.HashMap();
		/*服务激活属性*/
		private java.util.HashMap _graphics = new java.util.HashMap();
		public IUpdbmHome(){
			super();
		}
		
		/**
		 * @return 服务订购集
		 */
		public IOVOfferPentium getOFFER() {
			return _offer;
		}

		/**
		 * @param _offer 服务订购
		 */
		public void setOffer(IOVOfferPentium offer) {
			_offer = offer;
		}
		
		/**
		 * @param _offer 服务订购集[设置当前服务订购和其服务能力属性合并到当前服务能力中]
		 */
		public void mergeAsOffer(IOVOfferPentium offer) {
			_offer = offer;
			IOVOfferPentium.IOfferMBeanHome fromOfferHome = _offer.getORDER();
			ClassUtils.IMerge.merge( fromOfferHome.getOFFER(), _subflow );
		}

		/**
		 * @return 服务能力集
		 */
		public java.util.HashMap getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * @return 服务扩展集
		 */
		public java.util.HashMap getEXTEND() {
			return _extend;
		}

		/**
		 * @return 服务激活属性
		 */
		public java.util.HashMap getGraphics() {
			return _graphics;
		}
		
		/**
		 * 服务激活属性
		 * @param fromINDEX 内存索引编码
		 * @return
		 */
		public java.util.HashMap getGraphics( String fromINDEX ){
			return (java.util.HashMap)_graphics.get( fromINDEX );
		}
		
	}
	
}
