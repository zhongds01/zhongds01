package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate.IBusinesKernel;
import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductCatalog;
import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductGroup;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016��9��1��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpffmxDepend implements java.io.Serializable{
	private static final long serialVersionUID = 300818351883226708L;
	/*�����Ʒ������*/
	private java.util.Map<String,IOVOfferGroupHome> _dependent  = new java.util.HashMap<String,IOVOfferGroupHome>();
	/*�û�������Ʒ�嵥*/
	private java.util.Map<String,IProductCatalog>   _production = new java.util.HashMap<String,IProductCatalog>();
	/*�û������Ʒ�嵥*/
	private CarbonList<IOVMsgFOffer> _instance = new CarbonList<IOVMsgFOffer>();
	public IOVUpffmxDepend(){
		super();
	}
	
	/**
	 * ���ӷ����Ʒ������
	 * @param fromBusinesX ����ҵ����չ�淶
	 * @param fromGroup �����Ʒ������
	 */
	public void addGROUP(IBusinesKernel fromBusinesX, IProductGroup fromGroup ){
		try
		{
			if( _dependent.get( fromGroup.getGROUP() ) == null ){
				IOVOfferGroupHome fromGroupHome = new IOVOfferGroupHome( fromGroup, fromBusinesX );
				_dependent.put( fromGroup.getGROUP(), fromGroupHome );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * 
	 * @return �����Ʒ������
	 */
	public java.util.Map<String,IOVOfferGroupHome> getGROUP(){
		return _dependent;
	}
	
	/**
	 * ��ȡ�����Ʒ������
	 * @param fromGroup �����Ʒ���������
	 * @return
	 */
	public IOVOfferGroupHome getGROUP( String fromGroup ){
		return (IOVOfferGroupHome)_dependent.get( fromGroup );
	}
	
	/**
	 * 
	 * @param fromOffer
	 * @return
	 */
	public IProductCatalog[] getGROUP( IOVMsgFOffer fromOffer ){
		IProfessionalTemplate.IProductCatalog fromCatalog[] = null;
		java.util.List<IProductCatalog> fromCombine = new java.util.ArrayList<IProductCatalog>();
		try
		{
			if( _dependent != null && _dependent.size() > 0 ){
				for( java.util.Iterator<IOVOfferGroupHome> itera = _dependent.values().iterator(); itera.hasNext(); ){
					IOVOfferGroupHome _grouphome = (IOVOfferGroupHome)itera.next();
					String aCOMPETE = String.valueOf( fromOffer.getPRODUCT_ID() );
					java.util.List<IProductCatalog> _subflow = _grouphome.getGroup().getCOMBINE( aCOMPETE );
					if( _subflow == null || _subflow.size() <= 0 ){
						aCOMPETE = String.valueOf( fromOffer.getSERVICE_ID() );
						_subflow = _grouphome.getGroup().getCOMBINE( aCOMPETE );
					}
					if( _subflow != null && _subflow.size() > 0 ){
						ClassUtils.IMerge.merge( _subflow, fromCombine );
					}
    			}
				fromCatalog = (IProductCatalog[])fromCombine.toArray( new IProductCatalog[]{} );
			}
		}
		finally{
			if( fromCombine != null ){ fromCombine.clear(); fromCombine = null; }
		}
		return fromCatalog;
	}
	
	/**
	 * @return �û�������Ʒ�嵥
	 */
	public java.util.Map<String,IProductCatalog> getPRODUCTION() {
		return _production;
	}
	
	/**
	 * ����������(��Ҫ���ָ�������)
	 * @param fromOffer ��ͨ���񶩹�
	 * @param fromCatalog ��ͨ����������ϵ
	 */
	public void submitIOddOffer( IOVMsgFOffer fromOffer, IProductCatalog fromCatalog ){
		try
		{
			if( _production.get( fromCatalog.getEXTEND_ATTR_A() ) == null ){
				_production.put( fromCatalog.getEXTEND_ATTR_A(), fromCatalog );
			}
		}
		finally{
			
		}
	}
	
	/**
	 * ����������(��Ҫ���ָ�������)
	 * @param fromOffer ��ͨ���񶩹�
	 * @param fromCatalog ��ͨ����������ϵ
	 */
	public void submitIGrpOffer( IOVMsgFOffer fromOffer, IProductCatalog fromCatalog ){
		try
		{
			IOVOfferGroupHome fromGroup = null;
			IProfessionalTemplate.IProductCombine fromCombine = null;
			fromGroup = getGROUP( fromCatalog.getPRODUCT_ID() );
			if( fromGroup != null && fromGroup.getGroup().getSUBFLOW() != null ){
				fromCombine = fromGroup.getGroup().getGROUP( fromCatalog.getCATEGORY() );
			}
			if( fromCombine != null && fromCombine.getCATALOG().size() > 0 ){
				for( java.util.Iterator<IProductCatalog> itera = fromCombine.getCATALOG().iterator(); itera.hasNext(); ){
					fromCatalog = (IProductCatalog)itera.next();
					if( _production.get( fromCatalog.getEXTEND_ATTR_A() ) == null ){
						_production.put( fromCatalog.getEXTEND_ATTR_A(), fromCatalog );
					}
				}
			}
		}
		finally{
			
		}
	}
	
	/**
	 * ����������Ʒ��ϵ
	 * @param fromOffer ��ͨ���������Ʒ
	 * @return
	 */
	public IProfessionalTemplate.IProductCatalog getProduction( IOVMsgFOffer fromOffer ){
		IProfessionalTemplate.IProductCatalog fromCatalog = null;
		try
		{
			String fromCOMPETE = String.valueOf( fromOffer.getPRODUCT_ID() );
			fromCatalog = (IProductCatalog)_production.get( fromCOMPETE );
			if( fromCatalog == null ){
				fromCOMPETE = String.valueOf( fromOffer.getSERVICE_ID() );
				fromCatalog = (IProductCatalog)_production.get( fromCOMPETE );
			}
		}
		finally{
			
		}
		return fromCatalog;
	}
	
	/**
	 * @return �û������Ʒ�嵥
	 */
	public CarbonList<IOVMsgFOffer> getINSTANCE() {
		return _instance;
	}
	
	public static class IOVOfferGroupHome implements java.io.Serializable{
		private static final long serialVersionUID = 5679060282893301437L;
		private IProductGroup   _group;
		private IBusinesKernel  _businesX;
		public IOVOfferGroupHome(IProductGroup group, IBusinesKernel businesX){
			super();
			_group = group;
			_businesX = businesX;
		}
		
		/**
		 * @return �����Ʒ������
		 */
		public IProductGroup getGroup() {
			return _group;
		}
		
		/**
		 * @param _group �����Ʒ������
		 */
		public void setGroup(IProductGroup group) {
			_group = group;
		}
		
		/**
		 * @return ����ҵ����չ�淶
		 */
		public IBusinesKernel getBusinesX() {
			return _businesX;
		}
		
		/**
		 * @param _businesX ����ҵ����չ�淶
		 */
		public void setBusinesX(IBusinesKernel businesX) {
			_businesX = businesX;
		}
	}
}
