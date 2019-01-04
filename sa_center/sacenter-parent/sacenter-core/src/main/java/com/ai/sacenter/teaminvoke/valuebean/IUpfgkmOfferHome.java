package com.ai.sacenter.teaminvoke.valuebean;

import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��ͨ����������</p>
 * <p>Copyright: Copyright (c) 2015��10��30��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgkmOfferHome implements java.io.Serializable{
	private static final long serialVersionUID = -3994329268546904251L;
	/*���𷽹���*/
	private Object OBJECTIVE = null;
	/*��������*/
	private IBusinesOfferHome CATALOG = new IBusinesOfferHome();
	public IUpfgkmOfferHome( Object oBJECTIVE) {
		super();
		OBJECTIVE = oBJECTIVE;
	}
	/**
	 * @return ���𷽹���
	 */
	public Object getOBJECTIVE() {
		return OBJECTIVE;
	}
	
	/**
	 * @return ��������
	 */
	public IBusinesOfferHome getCATALOG() {
		return CATALOG;
	}

	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015��11��1��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IBusinesOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = -880997407388148347L;
		/*��ͨ�����*/
		private IProfessionalTemplate.IBusinesOffer    _busines ;
		/*��ͨ�����ʲ�*/
		private ISystemTemplate.IImplCapital          _component;
		/*��ͨ������Ԫ*/
		private IPlatformTemplate.IUpffmOffer         _platform ;
		/*��ͨ������չ��*/
		private IProfessionalTemplate.IBusinesCombine  _program ;
		/*��ͨ������*/
		private IProfessionalTemplate.ICompetenceBusines _competence;
		public IBusinesOfferHome(){
			super();
		}
		
		/**
		 * @return ��ͨ�����
		 */
		public IProfessionalTemplate.IBusinesOffer getBUSINES() {
			return _busines;
		}
		
		/**
		 * 
		 * @param bUSINES ��ͨ�����
		 * @throws Exception
		 */
		public void setBUSINES(IProfessionalTemplate.IBusinesOffer bUSINES) throws Exception{
			_busines   = bUSINES;
			_component = SystemUtils.ISystem.getSFUpfgkmCapital( bUSINES.getIMPLCLASS() ); 
			_platform  = UpdcUtils.ISubFlow.getPLATFORM( _component );
		}
		
		/**
		 * @return ��ͨ�����ʲ�
		 */
		public ISystemTemplate.IImplCapital getCOMPONENT() {
			return _component;
		}

		/**
		 * @param component ��ͨ�����ʲ�
		 */
		public void setCOMPONENT(ISystemTemplate.IImplCapital component) {
			_component = component;
		}

		/**
		 * @return ��ͨ������Ԫ
		 */
		public IPlatformTemplate.IUpffmOffer getPLATFORM() {
			return _platform;
		}

		/**
		 * @param platform ��ͨ������Ԫ
		 */
		public void setPLATFORM(IPlatformTemplate.IUpffmOffer platform) {
			_platform = platform;
		}

		/**
		 * @return ��ͨ������չ��
		 */
		public IProfessionalTemplate.IBusinesCombine getPROGRAM() {
			return _program;
		}
		
		/**
		 * ���ݿ�ͨ��չ�����ѯ��ͨ������չ�淶
		 * @param fromCOMPETE ��ͨ������չ����
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
		 * @param bUSINESX ��ͨ������չ��
		 */
		public void setPROGRAM(IProfessionalTemplate.IBusinesCombine bUSINESX) {
			_program = bUSINESX;
		}
		
		/**
		 * @return ��ͨ������
		 */
		public IProfessionalTemplate.ICompetenceBusines getCOMPETENCE() {
			return _competence;
		}
		
		/**
		 * @param cOMPETENCE ��ͨ������
		 */
		public void setCOMPETENCE(IProfessionalTemplate.ICompetenceBusines cOMPETENCE) {
			_competence = cOMPETENCE;
		}
	}
}
