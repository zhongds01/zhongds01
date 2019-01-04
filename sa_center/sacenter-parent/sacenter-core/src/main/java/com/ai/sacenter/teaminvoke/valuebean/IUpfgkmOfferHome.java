package com.ai.sacenter.teaminvoke.valuebean;

import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 开通接入能力层</p>
 * <p>Copyright: Copyright (c) 2015年10月30日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgkmOfferHome implements java.io.Serializable{
	private static final long serialVersionUID = -3994329268546904251L;
	/*发起方工单*/
	private Object OBJECTIVE = null;
	/*服务接入层*/
	private IBusinesOfferHome CATALOG = new IBusinesOfferHome();
	public IUpfgkmOfferHome( Object oBJECTIVE) {
		super();
		OBJECTIVE = oBJECTIVE;
	}
	/**
	 * @return 发起方工单
	 */
	public Object getOBJECTIVE() {
		return OBJECTIVE;
	}
	
	/**
	 * @return 服务接入层
	 */
	public IBusinesOfferHome getCATALOG() {
		return CATALOG;
	}

	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年11月1日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IBusinesOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -880997407388148347L;
		/*开通接入层*/
		private IProfessionalTemplate.IBusinesOffer    _busines ;
		/*开通接入资产*/
		private ISystemTemplate.IImplCapital          _component;
		/*开通接入网元*/
		private IPlatformTemplate.IUpffmOffer         _platform ;
		/*开通接入扩展层*/
		private IProfessionalTemplate.IBusinesCombine  _program ;
		/*开通能力层*/
		private IProfessionalTemplate.ICompetenceBusines _competence;
		public IBusinesOfferHome(){
			super();
		}
		
		/**
		 * @return 开通接入层
		 */
		public IProfessionalTemplate.IBusinesOffer getBUSINES() {
			return _busines;
		}
		
		/**
		 * 
		 * @param bUSINES 开通接入层
		 * @throws Exception
		 */
		public void setBUSINES(IProfessionalTemplate.IBusinesOffer bUSINES) throws Exception{
			_busines   = bUSINES;
			_component = SystemUtils.ISystem.getSFUpfgkmCapital( bUSINES.getIMPLCLASS() ); 
			_platform  = UpdcUtils.ISubFlow.getPLATFORM( _component );
		}
		
		/**
		 * @return 开通接入资产
		 */
		public ISystemTemplate.IImplCapital getCOMPONENT() {
			return _component;
		}

		/**
		 * @param component 开通接入资产
		 */
		public void setCOMPONENT(ISystemTemplate.IImplCapital component) {
			_component = component;
		}

		/**
		 * @return 开通接入网元
		 */
		public IPlatformTemplate.IUpffmOffer getPLATFORM() {
			return _platform;
		}

		/**
		 * @param platform 开通接入网元
		 */
		public void setPLATFORM(IPlatformTemplate.IUpffmOffer platform) {
			_platform = platform;
		}

		/**
		 * @return 开通接入扩展层
		 */
		public IProfessionalTemplate.IBusinesCombine getPROGRAM() {
			return _program;
		}
		
		/**
		 * 根据开通扩展编码查询开通接入扩展规范
		 * @param fromCOMPETE 开通接入扩展编码
		 * @return
		 */
		public IProfessionalTemplate.IBusinesKernel getPROGRAM( String fromCOMPETE ){
			IProfessionalTemplate.IBusinesKernel fromKernel = null;
			try
			{
				if( _program != null ){
					fromKernel = _program.getPROGRAM( fromCOMPETE );
				}
			}
			finally{
				
			}
			return fromKernel;
		}
		
		/**
		 * @param bUSINESX 开通接入扩展层
		 */
		public void setPROGRAM(IProfessionalTemplate.IBusinesCombine bUSINESX) {
			_program = bUSINESX;
		}
		
		/**
		 * @return 开通能力层
		 */
		public IProfessionalTemplate.ICompetenceBusines getCOMPETENCE() {
			return _competence;
		}
		
		/**
		 * @param cOMPETENCE 开通能力层
		 */
		public void setCOMPETENCE(IProfessionalTemplate.ICompetenceBusines cOMPETENCE) {
			_competence = cOMPETENCE;
		}
	}
}
