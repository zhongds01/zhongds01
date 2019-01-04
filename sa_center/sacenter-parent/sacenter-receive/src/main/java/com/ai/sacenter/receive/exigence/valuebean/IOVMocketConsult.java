package com.ai.sacenter.receive.exigence.valuebean;

import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通定单分解组</p>
 * <p>Copyright: Copyright (c) 2018年2月26日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0 
 */
public class IOVMocketConsult implements java.io.Serializable{
	private static final long serialVersionUID = 3764429813016525455L;
	/*开通定单*/
	private IOVMsgFExigence _objective;
	/*开通分解组*/
	private IUpdfmxOfferHome _subflow = new IUpdfmxOfferHome();
	public IOVMocketConsult( IOVMsgFExigence objective ) {
		super();
		_objective = objective;
	}
	
	public IOVMocketConsult( IOVMocketConsult objective ) {
		super();
		_objective = objective._objective;
		ClassUtils.IMerge.merge( objective._subflow._group  , _subflow._group   );
		ClassUtils.IMerge.merge( objective._subflow._subflow, _subflow._subflow );
	}
	
	/**
	 * @return 开通定单
	 */
	public IOVMsgFExigence getOBJECTIVE() {
		return _objective;
	}

	
	/**
	 * @return 开通分解组
	 */
	public IUpdfmxOfferHome getSUBFLOW() {
		return _subflow;
	}


	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2018年2月26日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IUpdfmxOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 8952665455220121418L;
		/*开通分解组*/
		private java.util.HashMap<String,IOVMocketCompose> _group = new java.util.HashMap<String,IOVMocketCompose>();
		/*开通其他组*/
		private CarbonList<Object> _subflow   = new CarbonList<Object>();
		public IUpdfmxOfferHome(){
			super();
		}
		
		/**
		 * @return 开通分解组
		 */
		public java.util.HashMap<String,IOVMocketCompose> getGROUP() {
			return _group;
		}
		
		/**
		 * @return 开通其他组
		 */
		public java.util.ArrayList<Object> getSUBFLOW() {
			return _subflow;
		}
	
	}
}
